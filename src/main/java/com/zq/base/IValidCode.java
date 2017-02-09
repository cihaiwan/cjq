package com.zq.base;

import java.io.IOException;
import java.util.Map;

public interface IValidCode {

	public String readCode(String url,Map<String,String> cookies) throws Exception;
}
