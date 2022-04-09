package com.edusol.billing.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Bill_TABLE")
public class Bill {
	
	@Id
	
	@Column(name = "bill_id")
	private int bill_id;
	
	@Column(name = "c_id")
	private int c_id;
	
	@Column(name = "p_id")
	private int p_id;

	public Bill() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Bill(int bill_id, int c_id, int p_id) {
		super();
		this.bill_id = bill_id;
		this.c_id = c_id;
		this.p_id = p_id;
	}

	public int getBill_id() {
		return bill_id;
	}

	public void setBill_id(int bill_id) {
		this.bill_id = bill_id;
	}

	public int getC_id() {
		return c_id;
	}

	public void setC_id(int c_id) {
		this.c_id = c_id;
	}

	public int getP_id() {
		return p_id;
	}

	public void setP_id(int p_id) {
		this.p_id = p_id;
	}

	@Override
	public String toString() {
		return "Bill [bill_id=" + bill_id + ", c_id=" + c_id + ", p_id=" + p_id + "]";
	}
	
	
}
