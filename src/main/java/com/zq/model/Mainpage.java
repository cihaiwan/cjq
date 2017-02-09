package com.zq.model;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.PropertyUtils;
import org.dom4j.Attribute;
import org.dom4j.Element;


public class Mainpage extends BaseModel {
	
	private String url;
	private String matches;
	private String ref;
	private Object refObj;
	private int maxpage;
	private String pagereg;
	
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getMatches() {
		return matches;
	}
	public void setMatches(String matches) {
		this.matches = matches;
	}
	
	
	public String getRef() {
		return ref;
	}
	public void setRef(String ref) {
		this.ref = ref;
	}
	public Object getRefObj() {
		return refObj;
	}
	public void setRefObj(Object refObj) {
		this.refObj = refObj;
	}
	public int getMaxpage() {
		return maxpage;
	}
	public void setMaxpage(int maxpage) {
		this.maxpage = maxpage;
	}
	public String getPagereg() {
		return pagereg;
	}
	public void setPagereg(String pagereg) {
		this.pagereg = pagereg;
	}
	
}
