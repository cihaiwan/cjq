package com.zq.model;

import java.util.HashMap;
import java.util.Map;

import org.dom4j.Attribute;
import org.dom4j.Element;

public class Param implements IXmlModel{
	
	private Map<String,Object> map=new HashMap<String,Object>();
	 
	public void create(Element ee,Map<String,Object> ids){
		
		 for(Object o:ee.attributes()){
				Attribute attribute=(Attribute) o;
				if(attribute.getName().equals("ref")){
					map.put("refObj",ids.get(attribute.getValue()));
				}
				map.put( attribute.getName(),attribute.getValue());
			}
	}

	public Map<String, Object> getMap() {
		return map;
	}

	public void setMap(Map<String, Object> map) {
		this.map = map;
	}

	
	
}
