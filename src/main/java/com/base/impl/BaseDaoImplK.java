package com.base.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.transform.Transformers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.orm.hibernate4.HibernateCallback;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.base.IBaseDaoK;
@Repository
public class BaseDaoImplK extends HibernateDaoSupport implements IBaseDaoK{
	
	private static final Logger logger=LoggerFactory.getLogger(BaseDaoImplK.class);
	
	public <T> void save(T t) throws Exception {
		getHibernateTemplate().save(t);
	}

	public <T> void update(T t) throws Exception {
		getHibernateTemplate().update(t);
		
	}

	public <T> void delete(T t) throws Exception {
		getHibernateTemplate().delete(t);
	}
	
	
	public <T> T findOne(Class<T> clz, Serializable unid) {
		
		return getHibernateTemplate().get(clz, unid);
	}

	public <T> T load(Class<T> clz, Serializable unid) throws Exception{
		// TODO Auto-generated method stub
		return  getHibernateTemplate().load(clz, unid);
	}
	private void setParamets(Query query,Object[] obj,int index){
		for(Object o:(Object[])obj){
			if(o instanceof Object[]){
				setParamets(query,(Object[]) o, index);
			}else{
				query.setParameter(index,o);
			}
			index++;
		}
	}
	private void setParamets(Object obj,Query query){
		if(obj instanceof Map){
			query.setProperties((Map<String,Object>)obj);
		}else if(obj instanceof Object[]){
			setParamets(query, (Object[]) obj,0);
		}
	}
	
	public <T> T findOne(final String hql, final Object obj) throws Exception{
		
		return getHibernateTemplate().execute(new HibernateCallback<T>() {

			public T doInHibernate(Session arg0) throws HibernateException {
				Query query=arg0.createQuery(hql);
				setParamets(obj, query);
				return (T) query.uniqueResult();
			}
		});
	}

	public <T> List<T> findAll(final String hql,final Object obj) throws Exception{
		// TODO Auto-generated method stub
		return  getHibernateTemplate().execute(new HibernateCallback<List<T>>() {

			public List<T> doInHibernate(Session arg0) throws HibernateException {
				Query query=arg0.createQuery(hql);
				setParamets(obj, query);
				return (List<T>) query.list();
			}
		});
	}

	public <T> List<T> findPage(final String hql,final  int first,final int max,final Object obj)throws Exception{
		// TODO Auto-generated method stub
		return  getHibernateTemplate().execute(new HibernateCallback<List<T>>() {

			public List<T> doInHibernate(Session arg0) throws HibernateException {
				Query query=arg0.createQuery(hql);
				query.setFirstResult(first);
				query.setMaxResults(max);
				setParamets(obj, query);
				return (List<T>) query.list();
			}
		});
	}

	public <T> T findSql(final Class<T> clz,final String sql,final Object obj) throws Exception{
		
		return getHibernateTemplate().execute(new HibernateCallback<T>() {

			public T doInHibernate(Session arg0) throws HibernateException {
				SQLQuery query=arg0.createSQLQuery(sql);
				setParamets(obj, query);
				return (T) query.addEntity(clz).uniqueResult();
			}
		});
	}

	public <T> List<T> findAllSql(final Class<T> clz,final String sql,final Object obj) throws Exception{
		// TODO Auto-generated method stub
		return  getHibernateTemplate().execute(new HibernateCallback<List<T>>() {

			public List<T> doInHibernate(Session arg0) throws HibernateException {
				SQLQuery query=arg0.createSQLQuery(sql);
				setParamets(obj, query);
				return (List<T>) query.addEntity(clz).list();
			}
		});
	}

	public <T> List<T> findSqlPage(final Class<T> clz,final String sql, final int first,final  int max,final Object obj) throws Exception{
		// TODO Auto-generated method stub
		return  getHibernateTemplate().execute(new HibernateCallback<List<T>>() {

			public List<T> doInHibernate(Session arg0) throws HibernateException {
				SQLQuery query=arg0.createSQLQuery(sql);
				setParamets(obj, query);
				query.setFirstResult(first);
				query.setMaxResults(max);
				return (List<T>) query.addEntity(clz).list();
			}
		});
	}


	@Resource
	public void setSessionFactory2(SessionFactory sessionFactory){
		setSessionFactory(sessionFactory);
	}

	public <T> T findSqlNo(final Class<T> clz,final String sql, final Object... obj)
			throws Exception {
		return  getHibernateTemplate().execute(new HibernateCallback<T>() {

			public T doInHibernate(Session arg0) throws HibernateException {
				SQLQuery query=arg0.createSQLQuery(sql);
				setParamets(obj, query);
				query.setResultTransformer(Transformers.aliasToBean(clz));
				return  (T) query.uniqueResult();
			}
		});
	}
	public  Number findSqlNum(final String sql, final Object... obj)
			throws Exception {
		return  getHibernateTemplate().execute(new HibernateCallback<Number>() {
			
			public Number doInHibernate(Session arg0) throws HibernateException {
				SQLQuery query=arg0.createSQLQuery(sql);
				setParamets(obj, query);
				
				return  (Number) query.uniqueResult();
			}
		});
	}
	
	
}
