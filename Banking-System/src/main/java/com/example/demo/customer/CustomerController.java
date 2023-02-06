package com.example.demo.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController {

	@Autowired
	private CustomerService custService;

	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping("/createCustomer")
	public void createCustomer(@RequestBody CustomerDTO customerDTO) {
	    Customer customer = new Customer();
	    customer.setName(customerDTO.getName());
	    customer.setAddress(customerDTO.getAddress());
	    customer.setDateofBirth(customerDTO.getDateofBirth());
	    customer.setNRIC(customerDTO.getNRIC());
	    custService.createCustomer(customer, Message.SUCCESSFUL);
	}


	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/customer/{customerId}")
	public ResponseEntity<CustomerDTO> getCustomerDetails(@PathVariable int customerId) {
        CustomerDTO customer = custService.getCustomerDetails(customerId);
        if (customer == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(customer, HttpStatus.OK);
    }

}
