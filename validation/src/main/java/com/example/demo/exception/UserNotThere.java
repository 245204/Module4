package com.example.demo.exception;

public class UserNotThere extends RuntimeException {
	public UserNotThere(String message) {
		super(message);
	}

}
