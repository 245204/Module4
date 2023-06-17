package com.example.demo.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.demo.entity.User;

@RestControllerAdvice
public class GlobalException extends Exception {
	
	@ExceptionHandler(UserNotFoundException.class)
	public ResponseEntity<?> handleserror(UserNotFoundException u){
		Error er=new Error(HttpStatus.NOT_FOUND, u.getMessage());
		return new  ResponseEntity(er,HttpStatus.NOT_FOUND);
		
}
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public Map<String,String> hh(MethodArgumentNotValidException ex){
		Map<String,String> mp=new HashMap<>();
		//ex.getBindingResult().getFieldErrors().forEach(error ->{m.put(error.getField(),error.getDefaultMessage());
		ex.getBindingResult().getFieldErrors().forEach(error->{mp.put(error.getField(),error.getDefaultMessage());
		
		});
		return mp;
		
		
	}

}
