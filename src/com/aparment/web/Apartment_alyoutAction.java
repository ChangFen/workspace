package com.aparment.web;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

import com.aparment.entity.Apartment_alyout;
import com.aparment.service.Apartment_alyoutService;

@Controller("alyoutAction")
public class Apartment_alyoutAction {
	@Resource
	private Apartment_alyoutService apartment_alyoutService ;
	private boolean bl ;
	private Apartment_alyout alyout ;
	
	public String add(){
		bl = apartment_alyoutService.add(alyout) ;
		return "success" ;
	}

	public boolean isBl() {
		return bl;
	}

	public void setBl(boolean bl) {
		this.bl = bl;
	}

	public Apartment_alyout getAlyout() {
		return alyout;
	}

	public void setAlyout(Apartment_alyout alyout) {
		this.alyout = alyout;
	}
	
}
