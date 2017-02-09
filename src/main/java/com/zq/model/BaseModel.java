package com.zq.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.PropertyUtils;
import org.dom4j.Attribute;
import org.dom4j.Element;


public class BaseModel implements IXmlModel{
	protected List<? extends IXmlModel> list=new ArrayList<IXmlModel>();

	public List<? extends IXmlModel> getList() {
		return list;
	}

	public void setList(List<IXmlModel> list) {
		this.list = list;
	}
	
	
	@Override
	public void create(Element ee, Map<String, Object> ids) throws Exception {
		for(Object o:ee.attributes()){
			Attribute attribute=(Attribute) o;
			if(attribute.getName().equals("ref")){
				PropertyUtils.setNestedProperty(this, "refObj",ids.get(attribute.getValue()));
			}
			PropertyUtils.setNestedProperty(this, attribute.getName(),attribute.getValue());
		}
	}
	
}
