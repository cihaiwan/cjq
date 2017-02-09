package com.zq.model;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.PropertyUtils;
import org.dom4j.Attribute;
import org.dom4j.Element;


public class Listpage extends BaseModel {
	
	private String matches="";
	private String ref;
	private Object refObj;
	private String index="1";
	private String pagesize="1";
	private String prefixurl="";
	
	
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
	public String getIndex() {
		return index;
	}
	public void setIndex(String index) {
		this.index = index;
	}
	public String getPagesize() {
		return pagesize;
	}
	public void setPagesize(String pagesize) {
		this.pagesize = pagesize;
	}
	
	public int getIndexInt(){
		return Integer.parseInt(index);
	}
	public int getPagesizeInt(int all){
		int i=Integer.parseInt(pagesize);
		if(i>1){
			return (all+i-1)/i;
		}else{
			return all;
		}
	}
	 
	public int getPageIndex(int index,int all){
		int i=Integer.parseInt(pagesize);
		if(i>1){
			return Integer.parseInt(pagesize)*index;
		}else{
			return index;
		}
	}
	public String getPrefixurl() {
		return prefixurl;
	}
	public void setPrefixurl(String prefixurl) {
		this.prefixurl = prefixurl;
	}
	
	
}
