package com.example.demo.model;

public class JwtResponse {
	
	public String token;

	public JwtResponse(String token) {
		
		this.token = token;
	}

	public JwtResponse() {
		
	}

	public String getToken() {
		return this.token;
	}

	public void setToken(String token) {
		this.token = token;
	}
	

}
