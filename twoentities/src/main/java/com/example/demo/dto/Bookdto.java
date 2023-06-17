package com.example.demo.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;


public class Bookdto {
	@NotNull(message="name empty")
	private String name;
	@Max(10)
	@Min(1)
	private int qty;
	public Bookdto() {
		// TODO Auto-generated constructor stub
	}
	public Bookdto(String name, int qty) {
		super();
		
		this.name = name;
		this.qty = qty;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
	

}
