package com.example.demo.entity;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.exception.UserNotThere;
import com.example.demo.repository.ProductRepository;

@RestController
@RequestMapping("/jj")
public class User {
	
	@Autowired
	ProductRepository repo;
	
	@PutMapping("/update")
	public ResponseEntity update(@RequestBody Product pr) {
		Optional<Product> dup=repo.findById(pr.getProductId());
		Product p=null;
		if(dup.isPresent()) {
			p=dup.get();
			p.setName(pr.getName());
			p.setDescription(pr.getDescription());
			p.setQuantity(p.getQuantity());
			return ResponseEntity.ok().body(repo.save(p));
		}else {
			return null;
		}
	}
	
	@PostMapping("/create")
	public ResponseEntity create(@RequestBody Product pr) {
		return new ResponseEntity(repo.save(repo.save(pr)),null);
	}
	@GetMapping("/get")
	public ResponseEntity get(@PathVariable long id) throws UserNotThere{
		Optional<Product>p=repo.findById(id);
		if(p.isPresent()) {
		return ResponseEntity.ok().body(repo.findById(id));
	}else{
		throw new UserNotThere("nooo");
		}
	}
	
	@GetMapping("/get")
	public ResponseEntity<List<Product>>fetchall(){
		return ResponseEntity.status(HttpStatus.FOUND).body(repo.findAll());
	}
	
	
	@PostMapping("/post")
	public ResponseEntity post(@RequestBody @Valid ProductDto dto) {
		Product pr=new Product(0,dto.getName(),dto.getDescription(),dto.getQuantity());
		return null;
	}
	@PutMapping("/update")
	public ResponseEntity update(@PathVariable Long id,@RequestBody @Valid ProductDto dtoo) {
		Product p=new Product(id,dtoo.getName(),dtoo.getDescription(),dtoo.getQuantity());
		return ResponseEntity.status(HttpStatus.FOUND).body(repo.save(p));
	}

}
