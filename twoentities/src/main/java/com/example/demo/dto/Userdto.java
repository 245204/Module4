package com.example.demo.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;


public class Userdto {
	@NotNull(message="user name empty")
	private String name;
	@Max(10)
	@Min(1)
	private int age;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	
	public Userdto(@NotNull(message = "user name empty") String name, @Max(10) @Min(1) int age) {
		super();
		this.name = name;
		this.age = age;
	}
	public Userdto() {
		
	}

}
