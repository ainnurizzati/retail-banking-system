package com.example.demo.account;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.customer.CustomerRepo;
import com.example.demo.customer.CustomerService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class AccountController {

	@Autowired
	private AccountService accService;
	
	@Autowired
	private CustomerRepo custRepo;
	
	@Autowired
	private CustomerService customerService;
	
	@Autowired
	private StatementRepository statementRepo;
	
	private static final Logger logger = LoggerFactory.getLogger(AccountController.class);
	
	//create account
	@PostMapping("/createAccount/{customerId}")
	public ResponseEntity<Account> createAccount(@PathVariable int customerId, @RequestBody Account account) {
	    Account newAccount = accService.createAccount(customerId, account);
	    return new ResponseEntity<>(newAccount, HttpStatus.CREATED);
	}
	
	//get account ID and balance by AccountID
	@GetMapping("/getAccount/{accountId}")
	public ResponseEntity<AccountInfoDTO> getAccountInfos(@PathVariable int accountId) {
	    AccountInfoDTO accountSummary = accService.getAccountSummary(accountId);
	    return new ResponseEntity<>(accountSummary, HttpStatus.OK);
	}

	//get accounts by custID
	@GetMapping("/getAccounts/{customerId}")
	public ResponseEntity<List<AccountInfoDTO>> getAccountsByCustomerId(@PathVariable int customerId) {
		List<AccountInfoDTO> accounts = accService.getAccountsByCustomerId(customerId);
		if (accounts == null) {
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		List<AccountInfoDTO> accountInfoDTOS = accounts.stream().map(a -> new AccountInfoDTO(a.getAccountId(), a.getBalance())).collect(Collectors.toList());
		return new ResponseEntity<>(accountInfoDTOS, HttpStatus.OK);
		}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/getAccountStatement/{accountId}")
	  public ResponseEntity<List<Statement>> getStatementByAccountIdAndDates(@PathVariable int accountId,@RequestParam("fromDate") @DateTimeFormat(pattern="yyyy-MM-dd") LocalDate fromDate,
	                                                                           @RequestParam("toDate") @DateTimeFormat(pattern="yyyy-MM-dd") LocalDate toDate) {
	    List<Statement> statement = accService.getStatementByAccountIdAndDates(accountId, java.sql.Date.valueOf(fromDate), java.sql.Date.valueOf(toDate));
	    return new ResponseEntity<>(statement, HttpStatus.OK);
	  }


}
