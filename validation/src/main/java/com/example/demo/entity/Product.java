package com.example.demo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Product {
	@Id
	@GeneratedValue
	private  long productId;
	private String name;
	private String description;
	private int quantity;
	
	public Product(long productId, String name, String description, int quantity) {
		super();
		this.productId = productId;
		this.name = name;
		this.description = description;
		this.quantity = quantity;
	}

	public long getProductId() {
		return productId;
	}

	public void setProductId(long productId) {
		this.productId = productId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	public Product() {
		// TODO Auto-generated constructor stub
	}
	

}
