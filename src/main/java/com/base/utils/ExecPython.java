package com.base.utils;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;

import org.apache.commons.io.IOUtils;
import org.jsoup.Jsoup;
import org.jsoup.Connection.Response;

import com.gargoylesoftware.htmlunit.FailingHttpStatusCodeException;
import com.gargoylesoftware.htmlunit.TextPage;
import com.gargoylesoftware.htmlunit.UnexpectedPage;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlImageInput;
import com.gargoylesoftware.htmlunit.html.HtmlInput;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

public class ExecPython {
	//mvn exec:java -Dexec.mainClass="com.vineetmanohar.module.Main"
	public static void main(String[] args) throws FailingHttpStatusCodeException, MalformedURLException, IOException {
		
		System.out.println("hello world666");
		
//		HttpContext context=new BasicHttpContext();
//		CloseableHttpClient client=HttpClientBuilder.create().build();
//		HttpGet get=new HttpGet("http://zjsc.zjsczs.org/servlet/Coder?text=topLogin_Jsp");
//		CloseableHttpResponse response=client.execute(get, context);
//		 InputStream inputStream=response.getEntity().getContent();
//	      IOUtils.copy(inputStream,new FileOutputStream(new File("c://x.jpg")));
//	      String path = "python E:\\zhuomian\\scripttest\\python\\pytesser\\pytesser4.py";
//	        Runtime run = Runtime.getRuntime();
//	        try {
//	            // run.exec("cmd /k shutdown -s -t 3600");
//	            Process process = run.exec(path);
////	            InputStream in = process.getInputStream();
////	            while (in.read() != -1) {
////	                System.out.println(in.read());
////	            }
////	            in.close();
//	            process.waitFor();
//	           
//	        } catch (Exception e) {
//	            e.printStackTrace();
//	        }
//	      FileReader fr = new FileReader("c://xx.txt");
//	      BufferedReader bf = new BufferedReader(fr);
//	      String rndCode=bf.readLine();
//	      System.out.println(rndCode);
//	      bf.close();
//	      HttpPost post=new HttpPost("http://zjsc.zjsczs.org/pub/login.do?sysCmd=login&username=330300&userpawd=000000&rndCode="+rndCode);
//	      CloseableHttpResponse response2=client.execute(post,context);
//		 
//	        //http://zjsc.zjsczs.org/servlet/Coder?text=topLogin_Jsp
		
		
		
		
//		WebClient webClient=new WebClient();
//		webClient.getOptions().setJavaScriptEnabled(false);
//		HtmlPage page2= webClient.getPage("http://zjsc.zjsczs.org/pub/login.do?sysCmd=login");
//		UnexpectedPage page = webClient.getPage("http://zjsc.zjsczs.org/servlet/Coder?text=topLogin_Jsp");
//		InputStream inputStream=page.getInputStream();
//	      IOUtils.copy(inputStream,new FileOutputStream(new File("c://x.jpg")));
//	      String path = "python E:\\zhuomian\\scripttest\\python\\pytesser\\pytesser4.py";
//	        Runtime run = Runtime.getRuntime();
//	        try {
//	            // run.exec("cmd /k shutdown -s -t 3600");
//	            Process process = run.exec(path);
////	            InputStream in = process.getInputStream();
////	            while (in.read() != -1) {
////	                System.out.println(in.read());
////	            }
////	            in.close();
//	            process.waitFor();
//	           
//	        } catch (Exception e) {
//	            e.printStackTrace();
//	        }
//	        FileReader fr = new FileReader("c://xx.txt");
//		      BufferedReader bf = new BufferedReader(fr);
//		      String rndCode=bf.readLine();
//		      System.out.println(rndCode);
//		      bf.close();
//	       HtmlInput u=(HtmlInput) page2.getElementById("username");
//	       HtmlInput u2=(HtmlInput) page2.getElementById("userpawd");
//	       HtmlInput u3=(HtmlInput) page2.getElementById("rndCode");
//	       HtmlImageInput image=page2.getFirstByXPath("//*[@type='image']");
//	       u.setValueAttribute("330300");
//	       u2.setValueAttribute("000000");
//	       u3.setValueAttribute(rndCode);
//	       image.click();
//	       HtmlPage page3=webClient.getPage("http://zjsc.zjsczs.org/pub/main.jsp");
//	       HtmlPage page4=page3.getElementById("img3").click();
//	       System.out.println(page4.asXml());
	       
	       
	       
//		CloseableHttpClient client=HttpClientBuilder.create().build();
//		HttpGet get=new HttpGet("http://zjsc.zjsczs.org/servlet/Coder?text=topLogin_Jsp");
//		CloseableHttpResponse response=client.execute(get);
//		 InputStream inputStream=response.getEntity().getContent();
//	      IOUtils.copy(inputStream,new FileOutputStream(new File("c://x.jpg")));
//	      String path = "python E:\\zhuomian\\scripttest\\python\\pytesser\\pytesser4.py";
//	        Runtime run = Runtime.getRuntime();
//	        try {
//	            // run.exec("cmd /k shutdown -s -t 3600");
//	            Process process = run.exec(path);
////	            InputStream in = process.getInputStream();
////	            while (in.read() != -1) {
////	                System.out.println(in.read());
////	            }
////	            in.close();
//	            process.waitFor();
//	           
//	        } catch (Exception e) {
//	            e.printStackTrace();
//	        }
//	      FileReader fr = new FileReader("c://xx.txt");
//	      BufferedReader bf = new BufferedReader(fr);
//	      String rndCode=bf.readLine();
//	      System.out.println(rndCode);
//	      bf.close();
//	      HttpPost post=new HttpPost("http://zjsc.zjsczs.org/pub/login.do?sysCmd=login&username=330300&userpawd=000000&rndCode="+rndCode);
//	      CloseableHttpResponse response2=client.execute(post);
//	      HttpEntity entity=response2.getEntity();
//	      System.out.println(EntityUtils.toString(entity));
//	      HttpGet get2=new HttpGet("http://zjsc.zjsczs.org/pub/main.jsp");
//	      CloseableHttpResponse response3=client.execute(get2);
//	      HttpEntity entity3=response3.getEntity();
//	      System.out.println(EntityUtils.toString(entity3));
		
	}
	
	
}
