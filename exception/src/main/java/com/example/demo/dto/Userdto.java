package com.example.demo.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;


public class Userdto {
	@NotNull
	private int id;
	@NotNull(message="empty")
	private String name;
	@Max(100)
	private int age;
	public Userdto() {
		// TODO Auto-generated constructor stub
	}
	public Userdto(@NotNull int id,@NotNull(message = "empty") String name, @Max(100) int age) {
		super();
		this.id=id;
		this.name = name;
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	
}