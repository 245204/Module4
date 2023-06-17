package com.example.demo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Book {
	
	@Id
	@GeneratedValue
	private int id;
	private String name;
	private int qty;
	public Book() {
		// TODO Auto-generated constructor stub
	}
	public Book(int id, String name, int qty) {
		super();
		this.id = id;
		this.name = name;
		this.qty = qty;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
