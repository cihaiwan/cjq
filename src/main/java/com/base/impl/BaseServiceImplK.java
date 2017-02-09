package com.base.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.apache.commons.lang3.StringUtils;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.base.IBaseDaoK;
import com.base.IBaseServiceK;
import com.base.bean.PageBeanK;

@Transactional
@Service
public class BaseServiceImplK implements IBaseServiceK{
	protected JdbcTemplate jdbcTemplate;
	@Resource
	private IBaseDaoK baseDaoK;

	public <T> void save(final T t) throws Exception {
		baseDaoK.save(t);
		
	}

	public <T> void update(T t) throws Exception {
		baseDaoK.update(t);
	}

	public <T> void delete(T t) throws Exception {
		baseDaoK.delete(t);
	}

	public <T> T findOne(Class<T> clz, Serializable unid) throws Exception {
		// TODO Auto-generated method stub
		return baseDaoK.findOne(clz, unid);
	}

	public <T> T load(Class<T> clz, Serializable unid) throws Exception {
		// TODO Auto-generated method stub
		return baseDaoK.load(clz, unid);
	}

	public <T> T findOne(String hql, Object... obj) throws Exception {
		
		return baseDaoK.findOne(hql, obj);
	}

	public <T> T findOne(String hql, Map<String, Object> obj) throws Exception {
		// TODO Auto-generated method stub
		return baseDaoK.findOne(hql, obj);
	}

	public <T> List<T> findAll(String hql, Object... obj) throws Exception {
		// TODO Auto-generated method stub
		return baseDaoK.findAll(hql, obj);
	}

	public <T> List<T> findAll(String hql, Map<String, Object> obj)
			throws Exception {
		// TODO Auto-generated method stub
		return baseDaoK.findAll(hql, obj);
	}

	
	public <T> List<T> findPage(String hql, PageBeanK bean, Object... obj)
			throws Exception {
		Long count=count(hql, obj);
		bean.setAllCount(count.intValue());
		List<T> data=baseDaoK.findPage(hql, bean.getPageNo(),bean.getPageSize(),obj);
		bean.setData(data);
		return data;
	}

	public <T> List<T> findPage(String hql, PageBeanK bean,
			Map<String, Object> obj) throws Exception {
		Long count=count(hql, obj);
		bean.setAllCount(count.intValue());
		List<T> data=baseDaoK.findPage(hql, bean.getPageNo(),bean.getPageSize(),obj);
		bean.setData(data);
		return data;
	}

	public <T> T findSql(Class<T> clz, String sql, Object... obj)
			throws Exception {
		
		return baseDaoK.findSql(clz, sql, obj);
	}

	public <T> T findSql(Class<T> clz, String sql, Map<String, Object> obj)
			throws Exception {
		// TODO Auto-generated method stub
		return baseDaoK.findSql(clz, sql, obj);
	}

	public <T> List<T> findAllSql(Class<T> clz, String sql, Object... obj)
			throws Exception {
		// TODO Auto-generated method stub
		return baseDaoK.findAllSql(clz, sql, obj);
	}

	public <T> List<T> findAllSql(Class<T> clz, String sql,
			Map<String, Object> obj) throws Exception {
		// TODO Auto-generated method stub
		return baseDaoK.findAllSql(clz, sql, obj);
	}

	public <T> List<T> findSqlPage(Class<T> clz, String sql, PageBeanK bean,
			Object... obj) throws Exception {
		Number count=baseDaoK.findSqlNum("select count(*) from "+ StringUtils.substringAfter(sql , "from"), obj);
		bean.setAllCount(count.intValue());
		List<T> data=baseDaoK.findSqlPage(clz,sql, bean.getPageNo(),bean.getPageSize(),obj);
		bean.setData(data);
		return data;
	}

	public <T> List<T> findSqlPage(Class<T> clz, String sql, PageBeanK bean,
			Map<String, Object> obj) throws Exception {
		Number count=baseDaoK.findSqlNum("select count(*) from "+ StringUtils.substringAfter(sql , "from"), obj);
		bean.setAllCount(count.intValue());
		List<T> data=baseDaoK.findSqlPage(clz,sql, bean.getPageNo(),bean.getPageSize(),obj);
		bean.setData(data);
		return data;
	}

	public Long count(String hql, Object... obj) throws Exception {
		if(hql.matches("select\\s+.*count\\([^)]+\\).*from .*")){
			return findOne(hql, obj);
		}else{
			return findOne("select count(*) " +hql, obj);
		}
	}

	public Long count(String hql, Map<String, Object> obj) throws Exception {
		if(hql.matches("select\\s+.*count\\([^)]+\\).*from .*")){
			return findOne(hql, obj);
		}else{
			return findOne("select count(*) " +hql, obj);
		}
	}
	
	@Resource(name="dataSource3")
	public void setJdbcTemplate(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	public void deleteListSql(String sql,Object... obj) throws Exception {
		//(sql,obj)jdbcTemplate.execute(sql);
	}

}
