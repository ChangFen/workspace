package com.aparment.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="apartment_layout")
public class Apartment_alyout {
	private String lid;   //户型id
	private String layout ; //户型信息
	
	private Aparment aparment ;	//小区

	public Apartment_alyout() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Apartment_alyout(String lid, String layout) {
		super();
		this.lid = lid;
		this.layout = layout;
	}
	@Id
	@GeneratedValue(generator = "_uuid")    
	@GenericGenerator(name = "_uuid", strategy = "guid") 
	public String getLid() {
		return lid;
	}

	public void setLid(String lid) {
		this.lid = lid;
	}

	public String getLayout() {
		return layout;
	}

	public void setLayout(String layout) {
		this.layout = layout;
	}
	@ManyToOne(cascade={CascadeType.REFRESH},fetch=FetchType.LAZY)
	@JoinColumn(name="aid")
	public Aparment getAparment(){
		return aparment;
	}

	public void setAparment(Aparment aparment) {
		this.aparment = aparment;
	}
	
}
