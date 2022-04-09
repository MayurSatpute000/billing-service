package com.edusol.billing.model;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
@Embeddable
@Entity
@Table(name="PRODUCT_TABLE")
public class Product {
	
	@Id
	@Column(name="id")
	private int id;
	
	@Column(name="Type")
	private String type;
	
	@Column(name="name")
	private String name;
	
	@Column(name="amount")
    private Double amount;
	
	@Column(name="quantity")
    private int quantity;
	
	
    @Column(name="description")
	private String description;


	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Product(int id, String type, String name, Double amount, int quantity, String description) {
		super();
		this.id = id;
		this.type = type;
		this.name = name;
		this.amount = amount;
		this.quantity = quantity;
		this.description = description;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public Double getAmount() {
		return amount;
	}


	public void setAmount(Double amount) {
		this.amount = amount;
	}


	public int getQuantity() {
		return quantity;
	}


	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	@Override
	public String toString() {
		return "Product [id=" + id + ", type=" + type + ", name=" + name + ", amount=" + amount + ", quantity="
				+ quantity + ", description=" + description + "]";
	}

    

}
