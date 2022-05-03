package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.AdminModel;
import com.example.demo.model.LoginModel;
import com.example.demo.model.UserModel;
import com.example.demo.service.RegistrationService;

@RestController
@CrossOrigin("*")
public class AuthController {

	@Autowired
	private RegistrationService service;
	
	@PostMapping("/user/signup")
	public UserModel saveUser(@RequestBody UserModel user)
	{
		
		UserModel userObj=null;
		userObj=service.saveNewUser(user);
		return userObj;
	}
	@PostMapping("/admin/signup")
	public AdminModel saveAdmin(@RequestBody AdminModel user)
	{
		
		AdminModel userObj=null;
		userObj=service.saveNewAdmin(user);
		return userObj;
	}
	 /*
	@GetMapping()
	public boolean isUserPresent(LoginModel data)
	{
		return true;
	}
	@GetMapping()
	public boolean isAdminPresent(LoginModel data)
	{
	return true;	
	}
	*/
	
}
