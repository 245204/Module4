package com.example.demo.entity;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class ProductDto {
	//no need of primarykey
	
	@NotNull(message="cannot be empty")
	private String name;
	@NotNull(message="cannot be empty")
	private String description;
	@Min(1)
	@Max(10)
	private int quantity;
	
	
	
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
	public void setQuantityy(int quantity) {
		this.quantity = quantity;
	}
	public ProductDto(@NotNull(message = "cannot be empty") String name,
			@NotNull(message = "cannot be empty") String description, @Min(1) @Max(10) int qty) {
		super();
		this.name = name;
		this.description = description;
		this.quantity = qty;
	}
	
	 public ProductDto() {
		// TODO Auto-generated constructor stub
	}

}
