package com.example.demo.account;

public class AccountDTO {

	 private int accountId;
	 private AccountType type;
	 private Double totalBalance;
	 private Double individualBalance;
	public AccountDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public AccountDTO(int accountId, AccountType type, Double totalBalance, Double individualBalance) {
		super();
		this.accountId = accountId;
		this.type = type;
		this.totalBalance = totalBalance;
		this.individualBalance = individualBalance;
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
	 
	 
}
