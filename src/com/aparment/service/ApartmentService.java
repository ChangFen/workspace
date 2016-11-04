package com.aparment.service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.aparment.dao.ApartmentDao;
import com.aparment.dao.Apartment_alyoutDao;
import com.aparment.dao.Apartment_labelDao;
import com.aparment.entity.Aparment;

@Service
public class ApartmentService {
	@Resource
	private ApartmentDao apartmentDao ;
	@Resource
	private Apartment_alyoutDao  apartment_alyoutDao ;
	@Resource
	private Apartment_labelDao apartment_labelDao ;
	public boolean add(Aparment apartment){
		return apartmentDao.add(apartment) ;
	}
	
	public boolean deleteAll(String[] aids){
		for (int i = 0; i < aids.length; i++) {
			if(apartment_alyoutDao.deleteAll(aids[i])&&apartment_labelDao.deleteAll(aids[i])){
				Aparment aparment = apartmentDao.findByAid(aids[i]) ;
				if(!apartmentDao.delete(aparment)){
					return false ;
				}
			}else{
				return false ;
			}
		}
		return true ;
	}
	
	public List<Object[]> findAll(){
		List<Aparment> oldList = apartmentDao.find() ;
		List<Object[]> newList = new ArrayList<Object[]>() ;
		for (Aparment a : oldList) {
			Object[] objs = new Object[3] ;
			objs[0] = a ;
			objs[1] = apartment_alyoutDao.findByAid(a.getAid()) ;
			objs[2] = apartment_labelDao.findByAid(a.getAid()) ;
			newList.add(objs) ;
		}
		return newList ;
	}

	public void setApartmentDao(ApartmentDao apartmentDao) {
		this.apartmentDao = apartmentDao;
	}

	public void setApartment_alyoutDao(Apartment_alyoutDao apartment_alyoutDao) {
		this.apartment_alyoutDao = apartment_alyoutDao;
	}

	public void setApartment_labelDao(Apartment_labelDao apartment_labelDao) {
		this.apartment_labelDao = apartment_labelDao;
	}
	
}
