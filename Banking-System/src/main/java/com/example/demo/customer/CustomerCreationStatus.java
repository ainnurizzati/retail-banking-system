package com.example.demo.customer;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class CustomerCreationStatus {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;

    @Enumerated(EnumType.STRING)
    @Column(name="message")
    private Message message;

    @OneToOne(mappedBy = "customerCreationStatus")
    @JoinColumn(name = "customer_id", referencedColumnName = "customerId")
    private Customer customer;

	public CustomerCreationStatus() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CustomerCreationStatus(int id, Message message, Customer customer) {
		super();
		Id = id;
		this.message = message;
		this.customer = customer;
	}

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public Message getMessage() {
		return message;
	}

	public void setMessage(Message message) {
		this.message = message;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	
}