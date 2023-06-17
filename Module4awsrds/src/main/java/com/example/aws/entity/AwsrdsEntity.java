package com.example.aws.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

//this is the basic product class
//the details you want in a table
@Entity
public class AwsrdsEntity {
	@Id //to show productid is primary key in database
	
	@GeneratedValue
	@Column(name="product_id")
	private long productId;
	private String name;
	private String description;
	private int qty;
	//private long productId;

	

	public String getName() {
		return name;
	}

	public long getProductId() {
		return productId;
	}

	public void setProductId(long productId) {
		this.productId = productId;
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

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

	public AwsrdsEntity() {
		// TODO Auto-generated constructor stub
	}

	public AwsrdsEntity(long productId, String name, String description, int qty) {
		super();
		this.productId = productId;
		this.name = name;
		this.description = description;
		this.qty = qty;
	}

}
