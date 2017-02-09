package com.zq.base;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.reflect.MethodUtils;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import com.zq.model.IXmlModel;
import com.zq.model.Loginpage;
import com.zq.model.Mainpage;

public class InitConfig {
	
	private Loginpage loginpage;
	private List<Mainpage> mainpage=new ArrayList<Mainpage>();
	private Map<String,Object> ids=new HashMap<String, Object>();
	
	
	
	public Loginpage getLoginpage() {
		return loginpage;
	}
	public void setLoginpage(Loginpage loginpage) {
		this.loginpage = loginpage;
	}
	
	
	public List<Mainpage> getMainpage() {
		return mainpage;
	}
	public void setMainpage(Mainpage mainpage) {
		this.mainpage.add(mainpage);
	}
	
	public IXmlModel setSelf(String base,Element e,Map<String,Object> ids) throws Exception{
		String tag=base+StringUtils.capitalize(e.getName());
		IXmlModel obj=(IXmlModel) Class.forName(tag).newInstance();
		obj.create(e, ids);
		if(e.elements().size()>0){
			for(Object ee1:e.elements()){
				Element ee =(Element) ee1;
				String tag2=base+StringUtils.capitalize(ee.getName());
				IXmlModel obj2=(IXmlModel) Class.forName(tag2).newInstance();
				obj2.create(ee, ids);
				List<IXmlModel> l=(List<IXmlModel>) PropertyUtils.getProperty(obj, "list");
				l.add(obj2);
			}
		}
		return obj;
	}
	
	
	@SuppressWarnings("unchecked")
	public void init() throws Exception{
		
		String base="com.zq.model.";
		//InitConfig.class.getClassLoader().getResourceAsStream("wt/a.xml")
		SAXReader reader=new SAXReader();
		Element element=reader.read(InitConfig.class.getClassLoader().getResourceAsStream("wt/b.xml")).getRootElement();
		List<Element> list=element.selectNodes("//*[@id]");
		for(Element e:list){
			Object obj=setSelf(base,e,null);
			ids.put(e.attributeValue("id"),obj );
		}
		List<Element> list3=element.selectNodes("/config/*");
		for(Element e:list3){
			if(e.attribute("id")!=null){
				continue;
			}
			Object obj=setSelf(base,e,ids);
			
//			PropertyUtils.setProperty(this,e.getName(), obj);
			MethodUtils.invokeMethod(this, "set"+StringUtils.capitalize(e.getName()), obj);
		}
		
	}
	public Map<String, Object> getIds() {
		return ids;
	}
}
