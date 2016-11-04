package com.aparment.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.aparment.entity.Apartment_label;
@Repository
public class Apartment_labelDao extends BaseDao{
	public boolean add(Apartment_label label){
		return save(label)!=null ;
	} 
	public List findByAid(String aid){
		String hql = "select label from Apartment_label a where a.aparment.aid='"+aid+"'" ;
		return  HQLQuery(hql);
	}
	public boolean deleteAll(String aid){
		String sql = "delete apartment_label where aid='"+aid+"'" ;
		return getSession().createSQLQuery(sql).executeUpdate()>=0 ;
	}
}
