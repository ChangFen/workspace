package com.aparment.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.aparment.entity.Aparment;

@Repository
public class ApartmentDao extends BaseDao{
	
	public boolean add(Aparment apartment){
		return save(apartment)!=null ;
	}
	public boolean deleteByApartment(Aparment apartment){
		return delete(apartment) ;
	}
	public Aparment findByAid(String aid){
		return (Aparment)getSession().get(Aparment.class, aid) ;
	}
	public List find(){
		String hql ="from Aparment" ;
		return HQLQuery(hql) ;
	}

}
