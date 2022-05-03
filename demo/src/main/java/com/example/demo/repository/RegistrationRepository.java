package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.UserModel;

public interface RegistrationRepository extends JpaRepository<UserModel, Long>{

	public UserModel findByUsername(String username);

	public UserModel findByEmailId(String email);

	
	


	
	

}
