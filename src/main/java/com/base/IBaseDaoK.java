package com.base;

import java.io.Serializable;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

public interface IBaseDaoK {
	
	public <T> void save(T t) throws Exception;
	public <T> void update(T t) throws Exception;
	public <T> void delete(T t) throws Exception;
	public <T> T findOne(Class<T> clz,Serializable unid)throws Exception;
	public <T> T load(Class<T> clz,Serializable unid)throws Exception;
	public <T> T findOne(String hql,Object obj)throws Exception;
	public <T> List<T> findAll(String hql,Object obj)throws Exception;
	public <T> List<T> findPage(String hql,int first,int max ,Object obj)throws Exception;
	public <T> T findSqlNo(final Class<T> clz,String sql,Object... obj)throws Exception;
	public <T> T findSql(final Class<T> clz,String sql,Object obj)throws Exception;
	public <T> List<T> findAllSql(final Class<T> clz,String sql,Object obj)throws Exception;
	public <T> List<T> findSqlPage(final Class<T> clz,String sql,int first,int max ,Object obj)throws Exception;
	public  Number findSqlNum(final String sql, final Object... obj)throws Exception; 
}
