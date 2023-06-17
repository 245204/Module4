package com.example.demo.exception;

import org.springframework.http.HttpStatus;

public class ErrorMessagee {
 HttpStatus status;
 String message;
 public ErrorMessagee() {
	// TODO Auto-generated constructor stub
}
public HttpStatus getStatus() {
	return status;
}
public void setStatus(HttpStatus status) {
	this.status = status;
}
public String getMessage() {
	return message;
}
public void setMessage(String message) {
	this.message = message;
}
public ErrorMessagee(HttpStatus status, String message) {
	super();
	this.status = status;
	this.message = message;
}

}
