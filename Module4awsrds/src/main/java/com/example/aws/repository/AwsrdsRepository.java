package com.example.aws.repository;
//we extend jparepository to get the inbuilt functions inside the jpa<the basic class,primay key type>

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.aws.entity.AwsrdsEntity;
@Repository
public interface AwsrdsRepository extends JpaRepository<AwsrdsEntity, Long> {
	

}
