package com.example.demo.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class LoanApplicantModel {
	private String applicantName;
	private String applicantPhone;
	private String applicantPan;
	private String applicantAddress;
	private Integer emi=0;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer applicantLoanId;
	
	private String applicantSalary;
	private String applicantEmail;
	private String applicantAadhar;
	private String loanAmountRequired;
	private String loanRepaymentMonths;
	private String status;
	
	public LoanApplicantModel()
	{	
	}
	
	public LoanApplicantModel(Integer applicantLoanId, String applicantName, String applicantPhone, String applicantPan,
			String applicantAddress, String applicantSalary, String applicantEmail, String applicantAadhar, String status,String loanAmountRequired,String loanRepaymentMonths,Integer emi) {
		super();
		this.applicantLoanId = applicantLoanId;
		this.applicantName = applicantName;
		this.applicantPhone = applicantPhone;
		this.applicantPan = applicantPan;
		this.applicantAddress = applicantAddress;
		this.applicantSalary = applicantSalary;
		this.applicantEmail = applicantEmail;
		this.applicantAadhar = applicantAadhar;
		this.status=status;
		this.loanAmountRequired=loanAmountRequired;
		this.loanRepaymentMonths=loanRepaymentMonths;
		this.emi=emi;
	}

	public Integer getEmi() {
		return emi;
	}

	public void setEmi(Integer emi) {
		this.emi = emi;
	}
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Integer getApplicantLoanId() {
		return applicantLoanId;
	}
	public void setApplicantLoanId(Integer applicantLoanId) {
		this.applicantLoanId = applicantLoanId;
	}
	public String getApplicantName() {
		return applicantName;
	}
	public void setApplicantName(String applicantName) {
		this.applicantName = applicantName;
	}
	public String getApplicantPhone() {
		return applicantPhone;
	}
	public void setApplicantPhone(String applicantPhone) {
		this.applicantPhone = applicantPhone;
	}
	public String getApplicantPan() {
		return applicantPan;
	}
	public void setApplicantPan(String applicantPan) {
		this.applicantPan = applicantPan;
	}
	public String getApplicantAddress() {
		return applicantAddress;
	}
	public void setApplicantAddress(String applicantAddress) {
		this.applicantAddress = applicantAddress;
	}
	public String getApplicantSalary() {
		return applicantSalary;
	}
	public void setApplicantSalary(String applicantSalary) {
		this.applicantSalary = applicantSalary;
	}
	public String getApplicantEmail() {
		return applicantEmail;
	}
	public void setApplicantEmail(String applicantEmail) {
		this.applicantEmail = applicantEmail;
	}
	public String getApplicantAadhar() {
		return applicantAadhar;
	}
	public String getLoanAmountRequired() {
		return loanAmountRequired;
	}

	public void setLoanAmountRequired(String loanAmountRequired) {
		this.loanAmountRequired = loanAmountRequired;
	}

	public String getLoanRepaymentMonths() {
		return loanRepaymentMonths;
	}

	public void setLoanRepaymentMonths(String loanRepaymentMonths) {
		this.loanRepaymentMonths = loanRepaymentMonths;
	}

	public void setApplicantAadhar(String applicantAadhar) {
		this.applicantAadhar = applicantAadhar;
	}


}
