package com.example.demo.account;

public class AccountIdAndAmountDTO {

	private int accountId;
	private double amount;
	
	public AccountIdAndAmountDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AccountIdAndAmountDTO(int accountId, double amount) {
		super();
		this.accountId = accountId;
		this.amount = amount;
	}

	public int getAccountId() {
		return accountId;
	}

	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}
	
	
}
