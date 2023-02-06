package com.example.demo.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

	@Autowired
	private CustomerRepo custRepo;
	
	@Autowired 
	private CustomerCreationStatusRepo custCreationRepo;
	
	// create customer
	public void createCustomer(Customer customer, Message message) {
        CustomerCreationStatus status = new CustomerCreationStatus();
        try {
            customer = custRepo.saveAndFlush(customer);
            status.setMessage(message);
            status.setCustomer(customer);
            custCreationRepo.saveAndFlush(status);
        } catch (Exception e) {
            status.setMessage(Message.FAILED);
            custCreationRepo.saveAndFlush(status);
        }
    }
	
	//find By ID
	public CustomerDTO getCustomerDetails(int customerId) {
        Customer customer = custRepo.findById(customerId).orElse(null);
        if (customer == null) {
            throw new RuntimeException("No customer found with ID: " + customerId);
        }
        return new CustomerDTO(customer.getCustomerId(), customer.getName(), customer.getAddress(), customer.getDateofBirth(), customer.getNRIC());
    }

}
