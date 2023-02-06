package com.example.demo.customer;

import java.sql.Date;

public class CustomerDTO {

	private int customerId;
    private String name;
    private String address;
    private Date dateofBirth;
    private int NRIC;
    
	public CustomerDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CustomerDTO(int customerId, String name, String address, Date dateofBirth, int nRIC) {
		super();
		this.customerId = customerId;
		this.name = name;
		this.address = address;
		this.dateofBirth = dateofBirth;
		NRIC = nRIC;
	}
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
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
	public Date getDateofBirth() {
		return dateofBirth;
	}
	public void setDateofBirth(Date dateofBirth) {
		this.dateofBirth = dateofBirth;
	}
	public int getNRIC() {
		return NRIC;
	}
	public void setNRIC(int nRIC) {
		NRIC = nRIC;
	}
    
	
}
