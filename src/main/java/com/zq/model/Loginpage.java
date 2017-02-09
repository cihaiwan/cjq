package com.zq.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.jsoup.Connection.Response;


public class Loginpage extends BaseModel{
	private String url;
	private String failureurl;
	private String successmsg;

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getFailureurl() {
		return failureurl;
	}

	public void setFailureurl(String failureurl) {
		this.failureurl = failureurl;
	}

	public String getSuccessmsg() {
		return successmsg;
	}

	public void setSuccessmsg(String successmsg) {
		this.successmsg = successmsg.replaceAll("'","\"");
	}

	
	public boolean checkValid(Response response){
		if(StringUtils.isEmpty(successmsg)){
			String path=response.url().getPath();
			System.out.println(path);
			if(url.matches(".*"+path+".*")){
					return false;
			}else{
				return true;
			}
		}else{
			if(response.body().trim().matches("(?s).*"+successmsg+".*")){
				return true;
			}
		}
		return false;
		
	}
}
