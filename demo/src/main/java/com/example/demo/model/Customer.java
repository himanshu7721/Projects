package com.example.demo.model;



import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name="customers")

public class Customer {
  
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long loan_id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="address")
	private String address;
	
	@Column(name="email_id")
	private String emailid;
	
	@Column(name="mobile_no")
	private String mobile_no;
	
	@Column(name="adhaar_no")
	private String adhaar_no;
	
	@Column(name="pan_no")
	private String pan_no;
	
	@Column(name="salary")
	private int salary;
	
	@Column(name="loan_amount_required")
	private int loan_amount_required;
	
	@Column(name="loan_repayment_months")
	private int loan_repayment_months;
	
	@OneToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	private Document document;

	public Customer(){
		
	}
	
	public Customer(String name, String address, String emailid, String mobile_no, String adhaar_no, String pan_no,
			int salary, int loan_amount_required, int loan_repayment_months,Document document)  {
		super();
		this.name = name;
		this.address = address;
		this.emailid = emailid;
		this.mobile_no = mobile_no;
		this.adhaar_no = adhaar_no;
		this.pan_no = pan_no;
		this.salary = salary;
		this.loan_amount_required = loan_amount_required;
		this.loan_repayment_months = loan_repayment_months;
		this.setDocument(document);
		
	}
	public long getLoan_id() {
		return loan_id;
	}
	public void setLoan_id(long loan_id) {
		this.loan_id = loan_id;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getEmailid() {
		return emailid;
	}
	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}
	public String getMobile_no() {
		return mobile_no;
	}
	public void setMobile_no(String mobile_no) {
		this.mobile_no = mobile_no;
	}
	public String getAdhaar_no() {
		return adhaar_no;
	}
	public void setAdhaar_no(String adhaar_no) {
		this.adhaar_no = adhaar_no;
	}
	public String getPan_no() {
		return pan_no;
	}
	public void setPan_no(String pan_no) {
		this.pan_no = pan_no;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public int getLoan_amount_required() {
		return loan_amount_required;
	}
	public void setLoan_amount_required(int loan_amount_required) {
		this.loan_amount_required = loan_amount_required;
	}
	public int getLoan_repayment_months() {
		return loan_repayment_months;
	}
	public void setLoan_repayment_months(int loan_repayment_months) {
		this.loan_repayment_months = loan_repayment_months;
	}

	public Document getDocument() {
		return document;
	}

	public void setDocument(Document document) {
		this.document = document;
	}
	
	
}
