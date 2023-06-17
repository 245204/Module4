package com.example.demo.controller;


import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.Repository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.Userdto;
import com.example.demo.entity.Book;
import com.example.demo.entity.User;
import com.example.demo.repository.BookRepository;
import com.example.demo.repository.UserRepository;

@RestController
@RequestMapping("/api2")
public class LibraryController {
	
	@Autowired
	BookRepository brepository;
	@Autowired
	UserRepository urepository;
	
	@GetMapping("/book/show")
	public ResponseEntity<?>show(){
		return ResponseEntity.ok().body(brepository.findAll());
		
	}
	@GetMapping("/book/{id}")
	public ResponseEntity<?> getid(@PathVariable int id)
	{
		Optional<Book> dup= brepository.findById(id);
		if(dup.isPresent())
		{
			//return new ResponseEntity(dup.get(),HttpStatus.FOUND);
			return ResponseEntity.status(HttpStatus.FOUND).body(dup.get());
			//return ResponseEntity.created().body(dup.get());
			
			//new object then angular no need
		}else {
		return null;}
		
	
	}
	
	@PostMapping("/book/create")
	public ResponseEntity create(@RequestBody Book book){
		return ResponseEntity.status(HttpStatus.CREATED).body(brepository.save(book));
		
	}
	
	@DeleteMapping("/book/delete/{id}")
	public String delete(@PathVariable int id) {
		brepository.deleteById(id);
		return "deleted";
	}
	
	@PutMapping("/book/update/{id}") 
	public ResponseEntity<?> update(@PathVariable int id,@RequestBody Book book) {
		Book bk=null;
		Optional<Book>dup=brepository.findById(id);
		//
		if(dup.isPresent()) {
			bk=dup.get();
         bk.setId(book.getId());
         bk.setName(book.getName()); 
         bk.setQty(book.getQty());
		 
			//return ResponseEntity.status(HttpStatus.FOUND).body(brepository.save(bk)); //if the question is to show a status then 
			return ResponseEntity.ok().body(brepository.save(bk));   //if they have given ok() then do like this only
			//return new ResponseEntity(brepository.save(bk),null); //this is the basic code for returning with responseenetity
		}else {
			return null;
		}
		
		
	}

	//---------------------------------dto----------------------------Op
	
	@PostMapping("/user/create/{uid}")
	public ResponseEntity createuser(@PathVariable int uid,@RequestBody @Valid Userdto dto) {
		User user=new User(uid,dto.getName(),dto.getAge());
		return  new ResponseEntity(urepository.save(user),HttpStatus.CREATED);
	}
	@GetMapping("/user/show")
	public ResponseEntity showall() {
	//return ResponseEntity.ok().body(urepository.findAll());
		//return ResponseEntity.status(HttpStatus.OK).body(urepository.findAll());
		return new ResponseEntity(urepository.findAll(),HttpStatus.FOUND);
		
	}
	@GetMapping("/user/{uid}")
	public ResponseEntity showbyid(@PathVariable int uid)
	{
		//return ResponseEntity.status(HttpStatus.OK).body(urepository.findById(id));
		return ResponseEntity.ok().body(urepository.findById(uid));
		//return new ResponseEntity(urepository.findById(id),null);
	}
	@PutMapping("/user/update/{uid}")
	public ResponseEntity update(@PathVariable int uid,@Valid @RequestBody Userdto dto ) 
	{
		
			User user = new User(uid,dto.getName(),dto.getAge());
			return new ResponseEntity(urepository.save(user),HttpStatus.ACCEPTED);
			
		
	}
	@DeleteMapping("/user/delete/{uid}")
	public String deleteuid (@PathVariable int uid) {
		urepository.deleteById(uid);
		return"deleted";
	}
}
	
	
	
	
