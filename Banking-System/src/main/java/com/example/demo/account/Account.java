package com.example.demo.account;

import java.util.List;

import com.example.demo.customer.Customer;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
public class Account{

	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 @Column(name="accountId")
	 private int accountId;

	 @Enumerated(EnumType.STRING)
	 private AccountType type;

	 private Double totalBalance;

	 private Double individualBalance;
	 
	 @OneToOne(mappedBy = "account", cascade = CascadeType.ALL)
	 private AccountCreationStatus accountCreationStatus;
	 
	 @OneToMany(mappedBy = "account", cascade = CascadeType.ALL)
	 private List<Statement> statements;
	 
	 @ManyToOne(fetch = FetchType.LAZY)
	 @JoinColumn(name = "customer_id", referencedColumnName = "customerId")
	 private Customer customer;

	public Account() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Account(int accountId, AccountType type, Double totalBalance, Double individualBalance,
			AccountCreationStatus accountCreationStatus, List<Statement> statements, Customer customer) {
		super();
		this.accountId = accountId;
		this.type = type;
		this.totalBalance = totalBalance;
		this.individualBalance = individualBalance;
		this.accountCreationStatus = accountCreationStatus;
		this.statements = statements;
		this.customer = customer;
	}

	public int getAccountId() {
		return accountId;
	}

	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}

	public AccountType getType() {
		return type;
	}

	public void setType(AccountType type) {
		this.type = type;
	}

	public Double getTotalBalance() {
		return totalBalance;
	}

	public void setTotalBalance(Double totalBalance) {
		this.totalBalance = totalBalance;
	}

	public Double getIndividualBalance() {
		return individualBalance;
	}

	public void setIndividualBalance(Double individualBalance) {
		this.individualBalance = individualBalance;
	}

	public AccountCreationStatus getAccountCreationStatus() {
		return accountCreationStatus;
	}

	public void setAccountCreationStatus(AccountCreationStatus accountCreationStatus) {
		this.accountCreationStatus = accountCreationStatus;
	}

	public List<Statement> getStatements() {
		return statements;
	}

	public void setStatements(List<Statement> statements) {
		this.statements = statements;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	 
	 
}
