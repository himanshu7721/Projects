package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.AdminModel;
import com.example.demo.model.UserModel;
import com.example.demo.repository.AdminRepository;
import com.example.demo.repository.RegistrationRepository;

@Service
public class RegistrationService {
	
	
	@Autowired
	private RegistrationRepository repo;
	@Autowired
	private AdminRepository adminrepo;
	public UserModel saveNewUser(UserModel data)
	{
		return repo.save(data);
	}
	public AdminModel saveNewAdmin(AdminModel data)
	{
		return adminrepo.save(data);
	}
	
	
	
}
