package com.example.demo.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice

public class GlobalExceptionn extends Exception {
	
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public Map<String,String> hh(MethodArgumentNotValidException ex) {
		Map<String,String>mp=new HashMap<>();
		ex.getBindingResult().getFieldErrors().forEach(error ->{mp.put(error.getField(),error.getDefaultMessage());
	});
	return mp;
	}
	@ExceptionHandler(UserNotThere.class)
	public ResponseEntity hh(UserNotThere nn) {
		ErrorMessagee er=new ErrorMessagee(HttpStatus.NOT_FOUND,nn.getMessage());
		return new ResponseEntity(er,null);
		
	}

}
