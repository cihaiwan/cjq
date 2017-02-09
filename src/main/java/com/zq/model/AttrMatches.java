package com.zq.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;
import org.jsoup.Connection.Response;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


public class AttrMatches {
	private String e;
	private String attr;
	private String id;
	private String baseurl;
	
	
	public String getE() {
		return e;
	}
	public void setE(String e) {
		this.e = e;
	}
	public String getAttr() {
		return attr;
	}
	public void setAttr(String attr) {
		this.attr = attr;
	}
	
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getBaseurl() {
		return baseurl;
	}
	public void setBaseurl(String baseurl) {
		this.baseurl = baseurl;
	}
	public List<String> getValue(Response response) throws Exception{
		List<String> list=new ArrayList<String>();
		if(!StringUtils.isEmpty(attr)){
			Elements elements=response.parse().select(e);
			 Iterator<Element> iterator=elements.iterator();
			 while(iterator.hasNext()){
				 list.add(iterator.next().attr(attr));
			 }
		}else if(!StringUtils.isEmpty(id)){
			Pattern pattern=Pattern.compile(id);
			Matcher matcher=pattern.matcher(response.body());
			while(matcher.find()){
				list.add(baseurl.replaceAll("\\$\\{id\\}", matcher.group(1)));
			}
			
		}
		return list;
	}
	
	
	 
}
