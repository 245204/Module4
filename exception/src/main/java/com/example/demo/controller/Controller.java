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

import com.example.demo.dto.Userdto;
import com.example.demo.entity.User;
import com.example.demo.exception.UserNotFoundException;
import com.example.demo.repository.UserRepository;

@RestController
@RequestMapping("/api3")
public class Controller {
	
	@Autowired
	UserRepository repo;
	
	@PostMapping("/create")
	public ResponseEntity<?> create(@RequestBody @Valid Userdto dto)
	{
		User dup=new User(dto.getId(),dto.getName(),dto.getAge());
		return ResponseEntity.status(HttpStatus.CREATED).body(repo.save(dup));
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity update(@PathVariable int id,@RequestBody @Valid Userdto dto) {
		
		User dup1=new User(id,dto.getName(),dto.getAge());
		return new ResponseEntity(repo.save(dup1),HttpStatus.FOUND);
	}
	@GetMapping("/all")
	public ResponseEntity<List<User>> showall(){
		return new ResponseEntity<List<User>>(repo.findAll(),HttpStatus.OK);
	}
	@GetMapping("/{id}")
	public ResponseEntity<?> get(@PathVariable int id) throws UserNotFoundException{
		Optional<User> dup=repo.findById(id);
		if(dup.isPresent()) 
		{
			return ResponseEntity.status(HttpStatus.FOUND).body(dup);
		}else {
			 throw new UserNotFoundException("nooooo");
		}
	}
	@DeleteMapping("/delete/{id}")
	public String delete(@PathVariable int id) throws UserNotFoundException {
		Optional <User> dp=repo.findById(id);
		if(dp.isPresent()) {
		repo.deleteById(id);
		return"deleted";
		}
		else {
			throw new UserNotFoundException("not there");
		}
	}

}
