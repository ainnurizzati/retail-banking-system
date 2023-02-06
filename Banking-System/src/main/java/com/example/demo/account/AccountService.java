package com.example.demo.account;

import java.sql.Date;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.customer.Customer;
import com.example.demo.customer.CustomerCreationStatusRepo;
import com.example.demo.customer.CustomerRepo;

import jakarta.transaction.Transactional;


@Service
public class AccountService {

	@Autowired
	private AccountRepository accRepo;
	
	@Autowired
	private AccountCreationStatusRepository accStatusRepo;
	
	@Autowired
	private CustomerRepo custRepo;
	
	@Autowired
	private StatementRepository statementRepo;
	
	@Autowired
	private CustomerCreationStatusRepo custCreationRepo;

	//create account
    public Account createAccount(int customerId, Account account) {
        Customer customer = custRepo.findById(customerId).orElse(null);
        if (customer == null) {
            throw new RuntimeException("No customer found with ID: " + customerId);
        }
        
        account.setCustomer(customer);
        
        AccountCreationStatus accountCreationStatus = new AccountCreationStatus();
	    
        accountCreationStatus.setMessage("Account created successfully.");
	    accountCreationStatus = accStatusRepo.save(accountCreationStatus);
	    account.setAccountCreationStatus(accountCreationStatus);
        return accRepo.save(account);
    }

  //get account id and balance by account Id
  	public AccountInfoDTO getAccountSummary(int accountId) {
          Account account = accRepo.findById(accountId).orElse(null);
          if (account == null) {
              throw new RuntimeException("No account found with ID: " + accountId);
          }
          return new AccountInfoDTO(account.getAccountId(), account.getTotalBalance());
      }
  	
    //get accounts
    public List<AccountInfoDTO> getAccountsByCustomerId(int customerId) {
        Customer customer = custRepo.findById(customerId).orElse(null);
        if (customer == null) {
            throw new RuntimeException("No customer found with ID: " + customerId);
        } else {
            List<Account> accounts = customer.getAccounts();
            List<AccountInfoDTO> accountInfoDTOs = new ArrayList<>();
            for (Account account : accounts) {
                accountInfoDTOs.add(new AccountInfoDTO(account.getAccountId(), account.getTotalBalance()));
            }
            return accountInfoDTOs;
        }
    }

    public List<Statement> getStatementByAccountIdAndDates(int accountId,Date fromDate,Date toDate) {
    	return statementRepo.findByAccount_AccountIdAndValueDateBetween(accountId, fromDate, toDate);
    }
    
}
