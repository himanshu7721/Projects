package com.example.demo.repository;


import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.profile;



public interface profile_repository extends JpaRepository<profile,Long> {
	Profile save(Profile profile);
}
