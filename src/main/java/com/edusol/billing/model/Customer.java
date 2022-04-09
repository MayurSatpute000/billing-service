package com.edusol.billing.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Embeddable
@Entity
@Table(name = "customers")
public class Customer {

	@Id
	@GeneratedValue
	@Column(name = "cust_id")
	private int c_id;
	@Column(name = "cust_name")
	private String c_name;
	@Column(name = "cust_city")
	private String city;

	public Customer() {
		super();
	}

	
	public int getC_id() {
		return c_id;
	}

	public Customer(int c_id, String c_name, String city) {
		super();
		this.c_id = c_id;
		this.c_name = c_name;
		this.city = city;
	}

	public void setC_id(int c_id) {
		this.c_id = c_id;
	}

	public String getC_name() {
		return c_name;
	}

	public void setC_name(String c_name) {
		this.c_name = c_name;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	
	@Override
	public String toString() {
		return "Customer [c_id=" + c_id + ", c_name=" + c_name + ", city=" + city + "]";
	}
	
	
	
}
