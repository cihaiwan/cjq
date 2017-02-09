package com.zq.base.impl;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.jsoup.Connection.Response;
import org.jsoup.Jsoup;

import com.zq.base.IValidCode;

public class PythonValid implements IValidCode{
	
	public static void main(String[] args) throws Exception {

		new PythonValid().login();
	}
	public Map<String,String> login() throws IOException{
		Response response0=Jsoup.connect("http://zjsc.zjsczs.org/pub/login.do?sysCmd=login").execute();
		Map<String,String> cookies=response0.cookies();
		Map<String,String> map=new HashMap<String,String>();
		map.put("username","330300" );
		map.put("userpawd","000000" );
		map.put("rndCode", getValid("http://zjsc.zjsczs.org/servlet/Coder?text=topLogin_Jsp",cookies));
		Jsoup.connect("http://zjsc.zjsczs.org/pub/login.do?sysCmd=login").cookies(cookies).data(map).execute();
		return cookies;
	}
	public static synchronized String getValid(String remoteurl,Map<String,String> cookies) throws IOException{
		Response resultImageResponse = Jsoup.connect(remoteurl).cookies(cookies).ignoreContentType(true).execute();
		String url=(PythonValid.class.getClassLoader().getResource("").getFile().replaceAll("/(.*)(.*/){3}", "$1")+"/").replaceAll("%20", " ");
		String url2=url+"valid/";
		File file=new File(url2+"temp/x.jpg");
		if(!file.exists()){
			file.createNewFile();
		}
		FileOutputStream out = (new FileOutputStream(file));
		out.write(resultImageResponse.bodyAsBytes());           
		out.close();
		File file2=new File(url2+"temp/xx.txt");
		if(!file2.exists()){
			file2.createNewFile();
		}
		String url3=url2.replaceAll("\\s+","%20");
		 String path = "python "+url2.replaceAll("([^/]+)","\"$1\"" )+"pytesser4.py "+url3+"temp/x.jpg" +" "+url3+"temp/xx.txt";
		 
	        Runtime run = Runtime.getRuntime();
	        try {
	            Process process = run.exec(path);
	            process.waitFor();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        FileReader fr = new FileReader(url2+"temp/xx.txt");
		      BufferedReader bf = new BufferedReader(fr);
		      String rndCode=bf.readLine();
		      bf.close();
		      System.out.println(rndCode);
		      return rndCode;
	}
	@Override
	public String readCode(String url, Map<String, String> cookies) throws Exception {
		// TODO Auto-generated method stub
		return PythonValid.getValid(url, cookies);
	}

	
	
}
