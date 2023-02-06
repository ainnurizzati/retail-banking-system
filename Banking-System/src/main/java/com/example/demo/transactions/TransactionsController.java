package com.example.demo.transactions;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.account.AccountIdAndAmountDTO;

@RestController
public class TransactionsController {

	@Autowired
	private TransactionsService transactionsService;

		@CrossOrigin(origins = "http://localhost:4200")
		@PostMapping("/deposit")
	    public Object deposit(@RequestBody AccountIdAndAmountDTO accountIdAndAmount) {
	        return transactionsService.deposit(accountIdAndAmount.getAccountId(), accountIdAndAmount.getAmount());
	    }
		
		@CrossOrigin(origins = "http://localhost:4200")
	    @PostMapping("/withdraw")
	    public Object withdraw(@RequestBody AccountIdAndAmountDTO accountIdAndAmount) {
	        return transactionsService.withdraw(accountIdAndAmount.getAccountId(), accountIdAndAmount.getAmount());
	    }
	    
		@CrossOrigin(origins = "http://localhost:4200")
	    @PostMapping("/transfer")
	    public Object transfer(@RequestBody TransferRequestDTO transferRequest) {
	      int sourceAccountId = (int) transferRequest.getSourceAccountId();
	      int targetAccountId = transferRequest.getTargetAccountId();
	      double amount = transferRequest.getAmount();
	      return transactionsService.transfer(sourceAccountId, targetAccountId, amount);
	    }
}
