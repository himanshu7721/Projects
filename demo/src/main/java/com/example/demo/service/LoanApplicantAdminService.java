package com.example.demo.service;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.example.demo.model.LoanApplicantModel;
import com.example.demo.repository.LoanApplicantRepository;

@Service
public class LoanApplicantAdminService {
	
	
	private LoanApplicantRepository adminRepository;

	private LoanApplicantModel adminmodel=new LoanApplicantModel();
	
	//for loan details data
	public List<LoanApplicantModel> approvedLoan()
	{
		System.out.println("Inside findall service");
		return (List<LoanApplicantModel>)adminRepository.findAll();
	}	
	
	//for get by Id data
	public LoanApplicantModel getById(int id)
	{
		return (LoanApplicantModel) adminRepository.findById(id)
				.orElseThrow(()-> new ResourceNotFoundException("Loan does not exist with id :"+id));
	}
	
	//for deleting the loan 
	public void deleteloan(LoanApplicantModel am)
	{
		adminRepository.delete(am);
	}
	 
	//for editing status as Approved
	public ResponseEntity<LoanApplicantModel>  editstatusA(int id,LoanApplicantModel userObj)
	{
		LoanApplicantModel userobj=adminRepository.getById(id);
		userobj.setStatus("Approved");
		LoanApplicantModel user=adminRepository.save(userobj);
		return ResponseEntity.ok(user);
	}
	//for editing status as Rejected
	public ResponseEntity<LoanApplicantModel>  editstatusR(int id,LoanApplicantModel userObj)
	{
		LoanApplicantModel userobj=adminRepository.getById(id);
		userobj.setStatus("Rejected");
		LoanApplicantModel user=adminRepository.save(userobj);
		return ResponseEntity.ok(user);
	}
	//for editing the LOAN 
	public ResponseEntity<LoanApplicantModel> editLoan(int id,LoanApplicantModel repaymentUser)
	{
		LoanApplicantModel repaymentuser=adminRepository.getById(id);
		repaymentuser.setApplicantName(repaymentUser.getApplicantName());
		repaymentuser.setApplicantAadhar(repaymentUser.getApplicantAadhar());
		repaymentuser.setApplicantAddress(repaymentUser.getApplicantAddress());
		repaymentuser.setApplicantEmail(repaymentUser.getApplicantEmail());
		repaymentuser.setApplicantPan(repaymentUser.getApplicantPan());
		repaymentuser.setApplicantPhone(repaymentUser.getApplicantPhone());
		repaymentuser.setApplicantSalary(repaymentUser.getApplicantSalary());
		repaymentuser.setLoanAmountRequired(repaymentUser.getLoanAmountRequired());
		repaymentuser.setLoanRepaymentMonths(repaymentUser.getLoanRepaymentMonths());
		LoanApplicantModel user=adminRepository.save(repaymentuser);
		return ResponseEntity.ok(user);
	}
	//for editing the repayment schedule
	public ResponseEntity<LoanApplicantModel> editRepaymentSchedule(int id,LoanApplicantModel repaymentUser)
	{
		LoanApplicantModel repaymentuser=adminRepository.getById(id);
		repaymentuser.setLoanAmountRequired(repaymentUser.getLoanAmountRequired());
		repaymentuser.setLoanRepaymentMonths(repaymentUser.getLoanRepaymentMonths());
		LoanApplicantModel user=adminRepository.save(repaymentuser);
		return ResponseEntity.ok(user);
	}
	
	//for delete the repayment Schedule
	public ResponseEntity<LoanApplicantModel> deleteRepaymentSchedule(int id,LoanApplicantModel repaymentUser)
	{
		LoanApplicantModel repaymentuser=adminRepository.getById(id);
		int a=0;
		repaymentuser.setEmi(a);
		LoanApplicantModel user=adminRepository.save(repaymentuser);
		return ResponseEntity.ok(user);
	}
	
	public int getLoanID(LoanApplicantModel am)
	{
		return am.getApplicantLoanId();
	}
	
	//for calculating the EMI
	public int calculateEmi(LoanApplicantModel am)
	{
		int x=Integer.parseInt(am.getLoanAmountRequired());
		int y=Integer.parseInt(am.getLoanRepaymentMonths());
		int z=(x/y);
		am.setEmi(z);
		adminRepository.save(am);
		return z;
	}

	
	

}


