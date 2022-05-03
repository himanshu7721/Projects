package com.example.demo.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.ResponseEntity.BodyBuilder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.model.Customer;
import com.example.demo.model.Document;
import com.example.demo.model.profile;
import com.example.demo.repository.Customer_repository;
import com.example.demo.repository.Image_repository;
import com.example.demo.repository.profile_repository;
import com.example.demo.service.ResourceNotFoundException;
@RestController
@CrossOrigin(allowedHeaders = "*",origins = "*")
@RequestMapping("/user/")
public class Customer_controller {
 
	
	@Autowired
	private Customer_repository customerRepository;
	
    @Autowired
	private Image_repository image_repository;
    
    @Autowired
	private profile_repository profilerepository;
    

	@GetMapping("/addLoan")
	public List<Customer> getAllEmployees()
	{
		return customerRepository.findAll();
    }
	@PostMapping("/addLoan")
	public Customer addloan(@RequestBody Customer customer)
	{
		return customerRepository.save(customer);
	}
	
	@GetMapping("/profile") 
	public List<profile> getAllProfile(){
		return profilerepository.findAll();
	}
	@PostMapping("/profile")
    public Profile createProfile(@RequestBody Profile profile) {
    	return profilerepository.save(profile);
    	
    }
	

	@PutMapping("/profile/{loanid}")
	public ResponseEntity<profile> updateprofile(@PathVariable Long id, @RequestBody profile profiledetails){
	
			profile profile=profilerepository.findById(id)
					.orElseThrow(() -> new ResourceNotFoundException("check the id:"+id));
			profile.setName(profiledetails.getName());
			profile.setPh_number(profile.getPh_number());
			profile.setEmail_id(profile.getEmail_id());
			profile.setAddress(profile.getAddress());
			profile.setMonthlyemi(profile.getMonthlyemi());
			
			
			profile updatedprofile =profilerepository .save(profile);
			return ResponseEntity.ok(updatedprofile);
			
	}

	@DeleteMapping("/profile/delete/{loanid}")
	public ResponseEntity<HashMap<String, Boolean>> deleteprofile(@PathVariable Long loanid){
		profile profile=profilerepository.findById(loanid)
				.orElseThrow(() -> new ResourceNotFoundException("check the id:"+loanid));
		profilerepository.delete(profile);
		HashMap<String, Boolean>response=new HashMap<>();
		response.put("deleted",Boolean.TRUE);
		return ResponseEntity.ok(response);
		
	}
	

	@PostMapping("/addDocument")
	public BodyBuilder uplaodImage(@RequestParam("imageFile") MultipartFile file) throws IOException {
            System.out.println("inside document upload");
		System.out.println("Original Image Byte Size - " + file.getBytes().length);
		Document doc = new Document(file.getOriginalFilename(), file.getContentType(),file.getBytes());
		image_repository.save(doc);
		return ResponseEntity.status(HttpStatus.OK);
	}
	
	
	
	}

