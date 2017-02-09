package com.zq.base;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.jsoup.Connection.Response;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.zq.base.impl.PythonValid;
import com.zq.model.AttrMatches;
import com.zq.model.BaseModel;
import com.zq.model.IXmlModel;
import com.zq.model.Listpage;
import com.zq.model.Loginpage;
import com.zq.model.Mainpage;
import com.zq.model.Param;

public  class AbsLogin {
	public static Gson gson=new GsonBuilder().create();
	protected int tryCount=5;//登入失败尝试次数
	protected InitConfig config;
	protected Map<String,String> cookies=new HashMap<String, String>();
	private IValidCode validCode=new PythonValid();
	public void login() throws Exception{
		
		Loginpage loginpage=config.getLoginpage();
		if(loginpage!=null){
			Response response0=Jsoup.connect(loginpage.getUrl()).execute();
			cookies=response0.cookies();
			cookies.put("baseurl",response0.url().getProtocol()+"://"+response0.url().getHost()+":"+(response0.url().getPort()==-1?"":response0.url().getPort()) +"/");
			List<Param> list=(List<Param>) loginpage.getList();
			Map<String,String> map=new HashMap<String, String>();
			for(Param param:list){
				Map<String,Object> m=param.getMap();
				if(m.containsKey("code")){
					try {
						String code=validCode.readCode( m.get("value").toString(), cookies);
						map.put(m.get("key").toString(), code);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}else{
					map.put(m.get("key").toString(), m.get("value").toString());
				}
			}

			Response response=Jsoup.connect(loginpage.getUrl()).cookies(cookies).data(map).execute();
			boolean bool=loginpage.checkValid(response);
			if(!bool){
				if(tryCount==1){
					return ;
				}
				tryCount--;
				Thread.sleep(5000);
				login();
			}
		}
	}
	
	
	public InitConfig getConfig() {
		return config;
	}


	public void setConfig(InitConfig config) {
		this.config = config;
	}


	public Map<String, String> getCookies() {
		return cookies;
	}


	public void setCookies(Map<String, String> cookies) {
		this.cookies = cookies;
	}
	
	
//	for(Mainpage mainpage:mainpages){
//	Response response=Jsoup.connect(mainpage.getUrl()).cookies(cookies).execute();
//	for(IXmlModel model:mainpage.getList()){
//		if(model instanceof Mainpage){
//			Mainpage mainpage2=(Mainpage) model;
//			String matches=mainpage2.getMatches().replaceAll("'", "\"");
//			if(!StringUtils.isEmpty(matches)){
//				AttrMatches am=gson.fromJson(matches, new TypeToken<AttrMatches>(){}.getType());
//				List<String> list=am.getValue(response.parse());
//				System.out.println(list.size());
//			}
//		}
//	}
//}

	public static void main(String[] args) throws Exception {
		InitConfig config=new InitConfig();
		config.init();
		AbsLogin absLogin=new AbsLogin();
		absLogin.setConfig(config);
		absLogin.login();
		Map<String,String> cookies=absLogin.getCookies();
		String baseurl=cookies.get("baseurl");
		List<Mainpage> mainpages=config.getMainpage();
		
		for(Mainpage mainpage:mainpages){
			System.out.println(baseurl+mainpage.getUrl().replaceAll("\\$\\{page\\}", "0"));
			Response response=Jsoup.connect(baseurl+mainpage.getUrl().replaceAll("\\$\\{page\\}", "0")).cookies(cookies).execute();
			String body=response.body();
			int maxpage=0;
			
			if(!StringUtils.isEmpty(mainpage.getPagereg())){
				maxpage=Integer.parseInt(body.replaceAll(mainpage.getPagereg(), "$1"));
			}
			mainpage.setMaxpage(maxpage);
			for(IXmlModel model:mainpage.getList()){
				if(model instanceof Listpage){
					List<String> list=new ArrayList<String>();
					Listpage mainpage2=(Listpage) model;
					String matches=mainpage2.getMatches().replaceAll("'", "\"");
					if(!StringUtils.isEmpty(matches)){
						AttrMatches am=gson.fromJson(matches, new TypeToken<AttrMatches>(){}.getType());
						for(int i=mainpage2.getIndexInt();i<mainpage2.getPagesizeInt(maxpage)+mainpage2.getIndexInt();i++){
							Response response2=Jsoup.connect(baseurl+mainpage.getUrl().replaceAll("\\$\\{page\\}",mainpage2.getPageIndex(i,maxpage)+"")).cookies(cookies).execute();
							Thread.sleep(3000);
							list.addAll(am.getValue(response2));
							break;
						}
					}
					String url=list.get(0);
					System.out.println(baseurl+mainpage2.getPrefixurl()+url);
					Response response2=Jsoup.connect(baseurl+mainpage2.getPrefixurl()+url).cookies(cookies).execute();
					Document document=response2.parse();
					BaseModel obj=(BaseModel) mainpage2.getRefObj();
					List<Param> list3=(List<Param>) obj.getList();
					Map<String,Object> model1=new LinkedHashMap<String, Object>();
					for(Param param:list3){
						Map<String,Object> mapp=param.getMap();
						String value="";
						if(!mapp.containsKey("type")){
							Element element=document.select("[name="+mapp.get("key")+"]").first();
							value=element.attr("value");
						}else if(mapp.get("type").equals("select")){
							Element element=document.select("[name="+mapp.get("key")+"]").select("option[selected]").first();
							value=element.attr("value");
						}else if(mapp.get("type").equals("radio")){
							Element element=document.select("[name="+mapp.get("key")+"]").select("[checked]").first();
							value=element.attr("value");
						}else if(mapp.get("type").equals("checkbox")){
							Element element=document.select("[name="+mapp.get("key")+"]").select("[checked]").first();
							value=model1.get((String) mapp.get("value"))+","+element.attr("value");
						}
						
						model1.put((String) mapp.get("value"),value);
					}
					System.out.println(gson.toJson(model1));
				}
			}
		}
	}

}
