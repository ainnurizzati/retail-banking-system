package com.example.demo.account;

public class AccountInfoDTO {

	private int accountId;
    private double balance;
    
	public AccountInfoDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public AccountInfoDTO(int accountId, double balance) {
		super();
		this.accountId = accountId;
		this.balance = balance;
	}
	public int getAccountId() {
		return accountId;
	}
	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
    
    
}
