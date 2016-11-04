package com.aparment.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.aparment.dao.Apartment_labelDao;
import com.aparment.entity.Apartment_label;
@Service
public class Apartment_labelService {
	@Resource
	private Apartment_labelDao apartment_labelDao ;
	
	public boolean add(Apartment_label label){
		return apartment_labelDao.add(label) ;
	}

	public void setApartment_labelDao(Apartment_labelDao apartment_labelDao) {
		this.apartment_labelDao = apartment_labelDao;
	}
	
}
