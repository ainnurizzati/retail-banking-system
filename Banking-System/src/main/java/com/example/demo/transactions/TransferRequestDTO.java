package com.example.demo.transactions;


public class TransferRequestDTO {

	private int sourceAccountId;
	private int targetAccountId;
	private double amount;
	
	public TransferRequestDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TransferRequestDTO(int sourceAccountId, int targetAccountId, double amount) {
		super();
		this.sourceAccountId = sourceAccountId;
		this.targetAccountId = targetAccountId;
		this.amount = amount;
	}

	public int getSourceAccountId() {
		return sourceAccountId;
	}

	public void setSourceAccountId(int sourceAccountId) {
		this.sourceAccountId = sourceAccountId;
	}

	public int getTargetAccountId() {
		return targetAccountId;
	}

	public void setTargetAccountId(int targetAccountId) {
		this.targetAccountId = targetAccountId;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}
	
	
	
}
