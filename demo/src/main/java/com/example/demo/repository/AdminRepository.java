package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.AdminModel;

public interface AdminRepository extends JpaRepository<AdminModel, Long>{

	public AdminModel findByEmailId(String email);

	public AdminModel findByUsername(String username);

}
