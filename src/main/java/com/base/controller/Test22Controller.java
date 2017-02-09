package com.base.controller;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.base.IBaseServiceK;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@Controller
@RequestMapping("/test")
public class Test22Controller {
	private static final Logger logger=LoggerFactory.getLogger(Test22Controller.class); 
	Gson gson=new GsonBuilder().create();

	@Resource
	private IBaseServiceK k;
	@RequestMapping("/test")
	public void test() throws Exception{
		logger.debug("hello world");
//		TestUser testUser=new TestUser();
//		k.save(testUser);
//		TestUser user=k.findOne(TestUser.class,"1");
//		System.out.println(gson.toJson(user));
//		List<TestUser> users=k.findAll("from TestUser where id=?","1");
//		System.out.println(gson.toJson(users));
//		Map<String,Object> map33=new HashMap<String,Object>();
//		map33.put("name","2");
//		List<TestUser> users33=k.findAll("from TestUser where name=:name",map33);
//		System.out.println(gson.toJson(users33));
//		List<TestUser> users2=k.findPage("from TestUser where unid=?",new PageBeanK(),"1");
//		System.out.println(gson.toJson(users2));
//		Map<String,Object> map=new HashMap<String,Object>();
//		map.put("name","2");
//		List<TestUser> users3=k.findPage("from TestUser where name=:name",new PageBeanK(),map);
//		System.out.println("-------------->"+gson.toJson(users3));
//		TestUser user2=k.findSql(TestUser.class, "select * from a_test_user  where unid=?","1");
//		System.out.println("user2------->"+gson.toJson(user2));
//		List<TestUser> user21=k.findAllSql(TestUser.class, "select * from a_test_user a where a.unid=?","1");
//		System.out.println("user21------->"+gson.toJson(user21));
//		List<TestUser> user22=k.findSqlPage(TestUser.class, "select * from a_test_user a where a.unid=?",new PageBeanK(),"1");
//		System.out.println("user22------->"+gson.toJson(user22));
	}
}
