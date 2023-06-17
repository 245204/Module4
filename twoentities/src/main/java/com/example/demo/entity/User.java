package com.example.demo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class User {
	
	@Id
	
	private int uid;
	private String name;
	private int age;
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
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
	public void setAge(int age) {
		this.age = age;
	}
	public User(int uid, String name, int age) {
		super();
		this.uid = uid;
		this.name = name;
		this.age = age;
	}
	
	public User() {
		// TODO Auto-generated constructor stub
	}

}
