package com.example.aws.services;
import java.util.List;
import java.util.Optional;

//the inbuilt functions and all other logical functions are written in service
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.aws.entity.AwsrdsEntity;
import com.example.aws.repository.AwsrdsRepository;
@Service
public class AwsrdsServices {
	@Autowired
private AwsrdsRepository awsrdsRepository;
	public AwsrdsEntity create(AwsrdsEntity awsrdsEntity) {
		
		return awsrdsRepository.save(awsrdsEntity); //.save is a inbuilt function so we call the repository object and then the function
	}
	public List<AwsrdsEntity> retrieve() {
		
		return awsrdsRepository.findAll();
	}
	public String delete(long productId) {
		awsrdsRepository.deleteById(productId);
		return "deleted ";
	}
	public AwsrdsEntity updatedata(AwsrdsEntity awsrdsEntity) {
		AwsrdsEntity old=null;
		Optional<AwsrdsEntity> aws=awsrdsRepository.findById(awsrdsEntity.getProductId());
		if(aws.isPresent()) {
			old=aws.get();
			old.setName(awsrdsEntity.getName());// why awsrdsEntity and not aws
			old.setDescription(awsrdsEntity.getDescription());
			old.setQty(awsrdsEntity.getQty());
			awsrdsRepository.save(old);
		}
		return old;
	}
}
