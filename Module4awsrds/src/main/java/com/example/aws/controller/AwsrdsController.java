package com.example.aws.controller;
import java.util.List;

//in controller we write function in that we call the service object function and it does the process there
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.aws.entity.AwsrdsEntity;
import com.example.aws.services.AwsrdsServices;

@RestController   //to show its controller
@RequestMapping("/api/0") //to show that particular url in the postman..if nothing given it still works
public class AwsrdsController {
	@Autowired   //used for making a connection between different package class
	private AwsrdsServices awsrdsServices;
	
	@PostMapping("/create")  //to do certain function
	public AwsrdsEntity addproduct(@RequestBody AwsrdsEntity awsrdsEntity) {//AwsrdsEnitity is the return type as we need that particular class model as result
		//RequestBody we give AwsrdsEntity as we write in this particular way in postman so we request in that type
		return awsrdsServices.create(awsrdsEntity);//we call the object service and the function in the service class we give parameter as awsrdsEntity to get that type answ
		
	}
	@GetMapping("/retrieve")//everything is to be printed from the table so we use list
	public List<AwsrdsEntity> getemp(){
		return awsrdsServices.retrieve();
	}
	
	@DeleteMapping("/delete/{productId}")
	public String delteid(@PathVariable long productId) {
		return awsrdsServices.delete(productId);
	}
	
	@PutMapping("/update")
	public AwsrdsEntity update(@RequestBody AwsrdsEntity awsrdsEntity) {
		return awsrdsServices.updatedata(awsrdsEntity);
		
	}
	

}
