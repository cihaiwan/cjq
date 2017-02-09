package com.zq.model;

import java.util.Map;

import org.dom4j.Element;

public interface IXmlModel {

	public void create(Element ee,Map<String,Object> ids) throws Exception ;
	
}
