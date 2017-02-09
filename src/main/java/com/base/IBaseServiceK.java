package com.base;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.base.bean.PageBeanK;

public interface IBaseServiceK {
	public <T> void save(T t) throws Exception;
	public <T> void update(T t) throws Exception;
	public <T> void delete(T t) throws Exception;
	public <T> T findOne(Class<T> clz,Serializable unid)throws Exception;
	public <T> T load(Class<T> clz,Serializable unid)throws Exception;
	public <T> T findOne(String hql,Object... obj)throws Exception;
	public <T> T findOne(String hql,Map<String,Object> obj)throws Exception;
	public <T> List<T> findAll(String hql,Object... obj)throws Exception;
	public <T> List<T> findAll(String hql,Map<String,Object> obj)throws Exception;
	public <T> List<T> findPage(String hql,PageBeanK bean,Object... obj)throws Exception;
	public <T> List<T> findPage(String hql,PageBeanK bean,Map<String,Object> obj)throws Exception;
	

	public <T> T findSql(final Class<T> clz,String sql,Object... obj)throws Exception;
	public <T> T findSql(final Class<T> clz,String sql,Map<String,Object> obj)throws Exception;
	public <T> List<T> findAllSql(final Class<T> clz,String sql,Object... obj)throws Exception;
	public <T> List<T> findAllSql(final Class<T> clz,String sql,Map<String,Object> obj)throws Exception;
	public <T> List<T> findSqlPage(final Class<T> clz,String sql,PageBeanK bean,Object... obj)throws Exception;
	public <T> List<T> findSqlPage(final Class<T> clz,String sql,PageBeanK bean,Map<String,Object> obj)throws Exception;
	public Long count(String hql,Object... obj)throws Exception ;
	public Long count(String hql,Map<String,Object> obj)throws Exception ;
	
	public void deleteListSql(String sql,Object... obj) throws Exception;
	
}
