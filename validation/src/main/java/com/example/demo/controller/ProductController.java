package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Product;
import com.example.demo.entity.ProductDto;
import com.example.demo.services.ProductServices;


@RestController
@RequestMapping("/api")
public class ProductController {
	
	@Autowired
	ProductServices service;
	
	@PostMapping("/create")
	public ResponseEntity<Product> create(@RequestBody @Valid ProductDto productdto){
		return new ResponseEntity(service.create(productdto),HttpStatus.CREATED); //to show status
		//return ResponseEntity.ok().body(repository.save());
	}
	
	@GetMapping("/reterive")
	 public ResponseEntity<List<Product>> fetchall(){ //public List<Product> fetchall(){  
		//return service.fetchall();
		return ResponseEntity.ok(service.fetchall());
	}
	
	@DeleteMapping("/delete/{productId}")
	public String delete(@PathVariable Long productId) {
		return service.delete(productId);
		
	}
	@GetMapping("/get/{productId}")
	public ResponseEntity<Optional<Product>> getid(@PathVariable Long productId){//public Product getid(@PathVariable Long productId) {
		return ResponseEntity.ok(service.getid(productId));//return service.getid(productId);
		//return ResponseEntity.ok().body(repository.getid());
	
	}
	@PutMapping("/update")
	public ResponseEntity<Product> update(@RequestBody Product product){
		return service.update(product);
	}
	

}
