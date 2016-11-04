package com.aparment.web;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

import com.aparment.entity.Apartment_label;
import com.aparment.service.Apartment_labelService;
@Controller("labelAction")
public class Apartment_labelAction {
	@Resource
	private Apartment_labelService apartment_labelService ;
	private boolean bl ;
	private Apartment_label label ;
	
	public String add(){
		bl = apartment_labelService.add(label) ;
		return "success" ;
	}

	public boolean isBl() {
		return bl;
	}

	public void setBl(boolean bl) {
		this.bl = bl;
	}

	public Apartment_label getLabel() {
		return label;
	}

	public void setLabel(Apartment_label label) {
		this.label = label;
	}

	
	
}
