package com.example.demo.customer;

import java.sql.Date;
import java.util.List;

import javax.validation.constraints.Pattern;

import com.example.demo.account.Account;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;


@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customerId")
    private int customerId;

    @Column(name="name")
    private String name;
    
    @Column(name="address")
    private String address;

    @Temporal(value=TemporalType.DATE)
    @Column(name="DOB")
    private Date dateofBirth;

    @Column(name="NRIC")
    private int NRIC;
    
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private CustomerCreationStatus customerCreationStatus;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Account> accounts;

	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Customer(int customerId, String name, String address, Date dateofBirth, int nRIC,
			CustomerCreationStatus customerCreationStatus, List<Account> accounts) {
		super();
		this.customerId = customerId;
		this.name = name;
		this.address = address;
		this.dateofBirth = dateofBirth;
		NRIC = nRIC;
		this.customerCreationStatus = customerCreationStatus;
		this.accounts = accounts;
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

	public CustomerCreationStatus getCustomerCreationStatus() {
		return customerCreationStatus;
	}

	public void setCustomerCreationStatus(CustomerCreationStatus customerCreationStatus) {
		this.customerCreationStatus = customerCreationStatus;
	}

	public List<Account> getAccounts() {
		return accounts;
	}

	public void setAccounts(List<Account> accounts) {
		this.accounts = accounts;
	}

	
}
