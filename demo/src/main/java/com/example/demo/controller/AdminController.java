package com.example.demo.controller;


import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.LoanApplicantModel;
import com.example.demo.service.LoanApplicantAdminService;

@RestController
@CrossOrigin(allowedHeaders = "*",origins = "*")
@RequestMapping("/admin/")
public class AdminController {
	
	
	private LoanApplicantAdminService adminservice=new LoanApplicantAdminService();
	
	//for loan details admin rest API
	@GetMapping("/getAllLoans")
	public List<LoanApplicantModel> approveLoan()
	{
		System.out.println("inside all approved loan");
		return (List<LoanApplicantModel>) adminservice.approvedLoan();
	}
	//for edit LOAN
	@PutMapping("/editLoan/{id}") 
	public ResponseEntity<LoanApplicantModel> editLoan(@PathVariable int id,@RequestBody LoanApplicantModel repaymentUser)
	{
		return adminservice.editLoan(id, repaymentUser);	
	}
	//for getting findById
	@GetMapping("/deleteLoan/{id}")
	public ResponseEntity<LoanApplicantModel> getById(@PathVariable int id)
	{
		LoanApplicantModel admin= adminservice.getById(id);
		return ResponseEntity.ok(admin);
	}
	
	//for delete loan rest API
	@DeleteMapping("/deleteLoan/{id}")
	public ResponseEntity<Map<String,Boolean>> deleteLoan(@PathVariable int id)
	{
		LoanApplicantModel admin= adminservice.getById(id);
		adminservice.deleteloan(admin);
		Map<String,Boolean>response=new HashMap<>();
		response.put("deleted",Boolean.TRUE);
		return ResponseEntity.ok(response);	
	}
	//for approving the status
	@PutMapping("/editStatusA/{id}")
	public ResponseEntity<LoanApplicantModel> editstatusA(@PathVariable int id,@RequestBody LoanApplicantModel userObj)
	{
		return adminservice.editstatusA(id, userObj);
	}
	//for rejecting the status
	@PutMapping("/editStatusR/{id}")
	public ResponseEntity<LoanApplicantModel> editstatusR(@PathVariable int id,@RequestBody LoanApplicantModel userObj)
	{
		return adminservice.editstatusR(id, userObj);
	}
	//for editing Repayment Schedule
	@PutMapping("/editRepaymentSchedule/{id}") 
	public ResponseEntity<LoanApplicantModel> editRepaymentSchedule(@PathVariable int id,@RequestBody LoanApplicantModel repaymentUser)
	{
		deleteRepaymentSchedule(id,repaymentUser);
		return adminservice.editRepaymentSchedule(id, repaymentUser);	
	}
	@GetMapping("/generateSchedule/{id}")
	public int calculateEmi(@PathVariable int id)
	{
		LoanApplicantModel admin= adminservice.getById(id);
	   return  adminservice.calculateEmi(admin);
	}
	//for delete the repayment Schedule
	@PutMapping("/deleteRepaymentSchedule/{id}")
	public ResponseEntity<LoanApplicantModel> deleteRepaymentSchedule(@PathVariable int id,@RequestBody LoanApplicantModel repaymentuser)
	{
		return adminservice.deleteRepaymentSchedule(id, repaymentuser);	
	}
}


