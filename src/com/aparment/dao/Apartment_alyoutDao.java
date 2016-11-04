package com.aparment.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.aparment.entity.Apartment_alyout;
@Repository
public class Apartment_alyoutDao extends BaseDao{
	public boolean add(Apartment_alyout alyout){
		return save(alyout)!=null ;
	}
	
	public List findByAid(String aid){
		String hql = "select layout from Apartment_alyout a where a.aparment.aid='"+aid+"'" ;
		return HQLQuery(hql) ;
	}
	public boolean deleteAll(String aid){
		String sql = "delete apartment_layout where aid='"+aid+"'" ;
		return getSession().createSQLQuery(sql).executeUpdate()>=0 ;
	}
}
