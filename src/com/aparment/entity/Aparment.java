package com.aparment.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.format.annotation.DateTimeFormat;
@Entity
@Table(name="apartment")
public class Aparment {
	private String aid;
	private String aprt_name;
	private String addr;
	private String price;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date pub_date;
	private String phone;
	
	public Aparment() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Aparment(String aid, String aprt_name, String addr, String price, Date pub_date, String phone) {
		super();
		this.aid = aid;
		this.aprt_name = aprt_name;
		this.addr = addr;
		this.price = price;
		this.pub_date = pub_date;
		this.phone = phone;
	}
	@Id
	@GeneratedValue(generator = "_uuid")    
	@GenericGenerator(name = "_uuid", strategy = "guid") 
	public String getAid() {
		return aid;
	}

	public void setAid(String aid) {
		this.aid = aid;
	}

	public String getAprt_name() {
		return aprt_name;
	}

	public void setAprt_name(String aprt_name) {
		this.aprt_name = aprt_name;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public Date getPub_date() {
		return pub_date;
	}

	public void setPub_date(Date pub_date) {
		this.pub_date = pub_date;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
}
