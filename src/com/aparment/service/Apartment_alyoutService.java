package com.aparment.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.aparment.dao.Apartment_alyoutDao;
import com.aparment.entity.Apartment_alyout;
@Service
public class Apartment_alyoutService {
	@Resource
	private Apartment_alyoutDao apartment_alyoutDao ;
	
	public boolean add(Apartment_alyout alyout){
		return apartment_alyoutDao.add(alyout) ;
	}

	public void setApartment_alyoutDao(Apartment_alyoutDao apartment_alyoutDao) {
		this.apartment_alyoutDao = apartment_alyoutDao;
	}
	
}
