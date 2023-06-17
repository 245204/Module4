package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.MultiValueMap;

import com.example.demo.entity.Product;
import com.example.demo.entity.ProductDto;
import com.example.demo.exception.UserNotFoundException;
import com.example.demo.repository.ProductRepository;

@Service
public class ProductServices {

	@Autowired
	ProductRepository repository;
	
	//post create
	public Product create(@Valid ProductDto productdto) {
		//converstion of dto to entity class
		Product prd=new Product (0,productdto.getName(),productdto.getDescription(),productdto.getQuantity());// instead of build function you can do this
		return repository.save(prd);
	}
	
	//get reterive
	public List<Product> fetchall() {
		return repository.findAll();
	}
	
	//get reterive id
	public Optional<Product> getid(Long productId)throws UserNotFoundException {
		//using optional cause there is exception
		Optional<Product> product=repository.findById(productId);
		if(product.isEmpty()) {
			throw new UserNotFoundException("productnotfound");
			
		}else {
			return repository.findById(productId);
		}
		
	}
	
	
	
	public String delete(Long productId) throws UserNotFoundException {
		Optional<?> product=repository.findById(productId);
		if(product.isEmpty()) {
			throw new UserNotFoundException("not available");
		}else {
			repository.deleteById(productId);
			return "deleted";
		}
		
	}

	public ResponseEntity<Product> update(Product product) {
		Optional<Product>product1=repository.findById(product.getProductId());
//		Product new=null;
//		if(product1.isPresent()) {
//			new=product1.get();
//			
//		}
		return null;
	}

	
}
