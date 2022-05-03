package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.model.AdminModel;
import com.example.demo.model.UserModel;
import com.example.demo.repository.AdminRepository;
import com.example.demo.repository.RegistrationRepository;

@Service
public class UserDetailsServiceImple implements UserDetailsService{

	@Autowired
	private RegistrationRepository regs;
	
	
	@Autowired
	private AdminRepository adminrepo;
	
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		
		UserModel user=this.regs.findByUsername(username);
		AdminModel admin=this.adminrepo.findByUsername(username);
		if(admin!=null)
		{
			return admin;
		}
		else if(user!=null)
		{
			return user;
		}
		else
		{
			System.out.println("not found");
			throw new UsernameNotFoundException("No user found!!!");
		}
		
		
		
	}
	
	

}
