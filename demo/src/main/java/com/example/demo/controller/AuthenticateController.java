package com.example.demo.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.config.JwtUtils;
import com.example.demo.model.AdminModel;
import com.example.demo.model.JwtResponse;
import com.example.demo.model.LoginModel;
import com.example.demo.model.UserModel;
import com.example.demo.repository.AdminRepository;
import com.example.demo.repository.RegistrationRepository;
import com.example.demo.service.UserDetailsServiceImple;

@RestController
@CrossOrigin("*")
public class AuthenticateController {
	
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private UserDetailsServiceImple userDetailsServiceImple;
	
	@Autowired
	private JwtUtils jwtUtils; 
	
	@Autowired
	private RegistrationRepository regs;
	
	@Autowired
	private AdminRepository adminrepo;
	
	
	
	
	
	//generate token
	
	@PostMapping("/user/login")
	public ResponseEntity<?> isUserPresent(@RequestBody LoginModel jwtRequest) throws Exception
	{
		UserModel user=regs.findByEmailId(jwtRequest.getEmail());
		if(user==null)
		{
			System.out.println("not found user email");
			//return false;
		}
		try
		{
			authenticate(user.getUsername(), jwtRequest.getPassword());
		}
		catch(UsernameNotFoundException e)
		{
			e.printStackTrace();
			throw new Exception("USERR NOT FOUND");
		}
		
		
		//Authenticate
		
		UserDetails userDetails= this.userDetailsServiceImple.loadUserByUsername(user.getUsername());
		String token=this.jwtUtils.generateToken(userDetails);
		//JwtResponse jwt=new JwtResponse(token);
		//System.out.println(jwt.getToken());
		//return true;
		return ResponseEntity.ok(new JwtResponse(token));
		
	}
	
	
	//AdminSide
	@PostMapping("/admin/login")
	public ResponseEntity<?> isAdminPresent(@RequestBody LoginModel jwtRequest) throws Exception
	{
		boolean flag=true;
		
		AdminModel user=adminrepo.findByEmailId(jwtRequest.getEmail());
		if(user==null)
		{
			System.out.println("not found admin email");
			flag=false;
		}
		try
		{
			authenticate(user.getUsername(), jwtRequest.getPassword());
		}
		catch(UsernameNotFoundException e)
		{
			
			e.printStackTrace();
			flag=false;
			throw new Exception("USERR NOT FOUND");
			
			
		}
		
		
		//Authenticate
		
		UserDetails userDetails= this.userDetailsServiceImple.loadUserByUsername(user.getUsername());
		String token=this.jwtUtils.generateToken(userDetails);
		return ResponseEntity.ok(new JwtResponse(token));
		
		//jwt.setToken(token);
		/*return ResponseEntity.ok(jwt);
		System.out.println(jwt.getToken());
		jwt.setToken(token);
		if(jwt.getToken()==null)
			System.out.println("not");
		return flag;*/
		
	}
	
	
	//Get the token
	/*@GetMapping("/generate-token")
	public ResponseEntity<?> getNewToken()
	{
		JwtResponse jwt = new JwtResponse();
		jwt.setToken("sdsdsd");
		System.out.println();
		if(jwt.getToken()==null)
		System.out.println("hjhsjhs");
		return ResponseEntity.ok(jwt);	
	}*/
	
	
	
	private void authenticate(String username,String password) throws Exception
	{
		try
		{
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
			
		}
		catch(DisabledException e)
		{
			throw new Exception("USER DISABLED");
		}
		catch(BadCredentialsException e)
		{
			throw new Exception("INVALID CREDENTIALS"+e.getMessage());
		}
	}
	
	
	//Returns the details of current user
	@GetMapping("/current-user")
	public UserModel getCurrentUser(Principal principal)
	{
		return ((UserModel)this.userDetailsServiceImple.loadUserByUsername(principal.getName()));
	}
	@GetMapping("/current-admin")
	public AdminModel getCurrentAdmin(Principal principal)
	{
		return ((AdminModel)this.userDetailsServiceImple.loadUserByUsername(principal.getName()));
	}
	

}
