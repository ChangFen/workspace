package com.aparment.dao;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
@Repository
public class BaseDao {
	@Resource
	private SessionFactory sessionFactory ;
	
	public Session getSession(){
		return sessionFactory.getCurrentSession() ;
	}
	
	public Object save(Object obj){
		try {
			getSession().save(obj) ;
			return obj ;
		} catch (Exception e) {
			return null ;
		}
	}
	
	public List HQLQuery(String hql){
		return getSession().createQuery(hql).list() ;
	}
	
	public boolean delete(Object obj){
		try {
			getSession().delete(obj);
			return true ;
		} catch (Exception e) {
			return false ;
		}
	}
	
	public static void main(String[] args) {
		System.out.println(new BaseDao().getSession());
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
}
