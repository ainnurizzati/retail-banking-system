package com.example.demo.account;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class AccountCreationStatus {

    @Id
    private String message;

    @OneToOne
    @JoinColumn(name = "account_id", referencedColumnName = "accountId")
    private Account account;

	public AccountCreationStatus() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AccountCreationStatus(String message, Account account) {
		super();
		this.message = message;
		this.account = account;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	
}
