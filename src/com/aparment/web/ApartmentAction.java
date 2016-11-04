package com.aparment.web;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

import com.aparment.entity.Aparment;
import com.aparment.service.ApartmentService;
@Controller
public class ApartmentAction {
	@Resource
	private ApartmentService apartmentService ;
	private List list = new ArrayList() ;
	private String[] aids ;
	private Aparment apartment ;
	private boolean bl ;
	public String add(){
		if(apartmentService.add(apartment)){
			return "index" ;
		}
		return "add" ;
	}
	public String delete(){
		bl = apartmentService.deleteAll(aids) ;
		return "success" ;
	}
	
	public String findAll(){
		list = apartmentService.findAll() ;
		return "success" ;
	}
	
	public Aparment getApartment() {
		return apartment;
	}
	public void setApartment(Aparment apartment) {
		this.apartment = apartment;
	}
	public List getList() {
		return list;
	}
	public void setList(List list) {
		this.list = list;
	}
	public String[] getAids() {
		return aids;
	}
	public void setAids(String[] aids) {
		this.aids = aids;
	}
	public boolean isBl() {
		return bl;
	}
	public void setBl(boolean bl) {
		this.bl = bl;
	}
	
	
}
