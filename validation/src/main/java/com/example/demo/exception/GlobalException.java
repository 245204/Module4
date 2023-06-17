package com.example.demo.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;


//this is validation exception checking
@RestControllerAdvice //exception to show
public class GlobalException extends Exception {
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public Map<String,String> abc(MethodArgumentNotValidException ex){
		Map<String,String>m=new HashMap<>();
		ex.getBindingResult().getFieldErrors().forEach(error ->{m.put(error.getField(),error.getDefaultMessage());
		});
		return m;
	}
	
	@ExceptionHandler(UserNotFoundException.class)
	public ResponseEntity<ErrorMessage> handleserror(UserNotFoundException uexception){
		ErrorMessage error= new ErrorMessage(HttpStatus.NOT_FOUND,uexception.getMessage());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
		
	}

}
