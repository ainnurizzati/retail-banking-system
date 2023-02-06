package com.example.demo.transactions;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class TransactionStatus {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private boolean success;
    private String message;
    private double source_balance;
    private double destination_balance;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public double getSource_balance() {
		return source_balance;
	}

	public void setSource_balance(double source_balance) {
		this.source_balance = source_balance;
	}

	public double getDestination_balance() {
		return destination_balance;
	}

	public void setDestination_balance(double destination_balance) {
		this.destination_balance = destination_balance;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public LocalDateTime getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(LocalDateTime updatedAt) {
		this.updatedAt = updatedAt;
	}

	public TransactionStatus() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TransactionStatus(boolean success, String string, double source_balance2, double destination_balance2) {
		super();
		this.success = success;
		this.message = message;
		this.source_balance = source_balance;
		this.destination_balance = destination_balance;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}
    
    
}
