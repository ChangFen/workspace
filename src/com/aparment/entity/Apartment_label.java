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
@Table(name="apartment_label")
public class Apartment_label {
	private String lbid ;	//标签id
	private String label ;	//标签信息
	private Aparment aparment;	//小区
	
	
	public Apartment_label() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Apartment_label(String lbid, String label) {
		super();
		this.lbid = lbid;
		this.label = label;
	}
	@Id
	@GeneratedValue(generator = "_uuid")    
	@GenericGenerator(name = "_uuid", strategy = "guid") 
	public String getLbid() {
		return lbid;
	}
	public void setLbid(String lbid) {
		this.lbid = lbid;
	}
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	@ManyToOne(cascade={CascadeType.REFRESH},fetch=FetchType.LAZY)
	@JoinColumn(name="aid")
	public Aparment getAparment() {
		return aparment;
	}
	public void setAparment(Aparment aparment) {
		this.aparment = aparment;
	}
}
