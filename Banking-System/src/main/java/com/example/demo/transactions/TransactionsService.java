package com.example.demo.transactions;

import java.sql.Date;
import java.time.Instant;
import java.time.ZoneId;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.account.Account;
import com.example.demo.account.AccountRepository;
import com.example.demo.account.Statement;
import com.example.demo.account.StatementRepository;

@Service
public class TransactionsService {

	@Autowired
	private AccountRepository accRepo;
	
	@Autowired
	private StatementRepository statementRepo;
	
	
	//create statement
    public void createStatement(int accountId, Date date, String naration, float withdrawal, float deposit, float closingBalance) throws Exception {
        try {
            Account account = accRepo.findById(accountId).orElseThrow(() -> new Exception("Account not found"));
            Statement statement = new Statement();
            statement.setAccount(account);
            statement.setDate(date);
            statement.setValueDate(date);
            statement.setNaration(naration);
            statement.setDeposit(deposit);
            statement.setWithdrawal(withdrawal);
            statement.setClosingBalance(closingBalance);
            statementRepo.save(statement);
        } catch (Exception e) {
            throw new Exception("Error creating statement: " + e.getMessage());
        }
    }

    //deposit
	 public Object deposit(int accountId, double amount) {
        try {
            Account account = accRepo.findById(accountId).orElseThrow(() -> new Exception("Account not found"));
            double source_balance = account.getTotalBalance(); 
            account.setTotalBalance(account.getTotalBalance() + amount);
            accRepo.save(account);
         
            Instant timestamp = Instant.now();
            java.util.Date date = Date.from(timestamp);
            java.sql.Date sqlDate = java.sql.Date.valueOf(date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
            createStatement(accountId, sqlDate, "Deposit", 0, (float) amount, (float) account.getTotalBalance().doubleValue());

            double destination_balance = account.getTotalBalance();
            return new TransactionStatus(true,"Deposit successful", source_balance, destination_balance);
        } catch (Exception e) {
            return new TransactionStatus(false,"Error making deposit: " + e.getMessage(), 0, 0);
        } 
    }
	 
	 //withdraw
	 public Object withdraw(int accountId, double amount) {
	        try {
	            Account account = accRepo.findById(accountId).orElseThrow(() -> new Exception("Account not found"));
	            double source_balance = account.getTotalBalance();
	            if (account.getTotalBalance() < amount) {
	                throw new Exception("Insufficient balance");
	            }
	            account.setTotalBalance(account.getTotalBalance() - amount);
	            accRepo.save(account);
	            
	            // called createStatement method to create statement for Withdraw
	            Instant timestamp = Instant.now();
	            java.util.Date date = Date.from(timestamp);
	            java.sql.Date sqlDate = java.sql.Date.valueOf(date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
	            createStatement(accountId, sqlDate, "Withdraw", (float)amount, 0, (float) account.getTotalBalance().doubleValue());
	            
	            double destination_balance = account.getTotalBalance();
	            	return new TransactionStatus(true, "Withdraw successful", source_balance, destination_balance);
	            } catch (Exception e) {
	            	return new TransactionStatus(false, "Error making withdraw: " + e.getMessage(), 0, 0);
	            }	
	    }
	 
	 //transfer
//	 public Object transfer(int sourceAccountId, int targetAccountId, double amount) {
//	        try {
//	            Account sourceAccount = accRepo.findById(sourceAccountId).orElseThrow(() -> new Exception("Source account not found"));
//	            Account targetAccount = accRepo.findById(targetAccountId).orElseThrow(() -> new Exception("Destination account not found"));
//	            // First, withdraw from source account
//	            Object withdrawResult = withdraw(sourceAccountId, amount);
//	            if (!((TransactionStatus) withdrawResult).isSuccess()) {
//	                return withdrawResult;
//	            }
//	            // Then, deposit to destination account 
//	            Object depositResult = deposit(targetAccountId, amount);
//	            if (!((TransactionStatus) depositResult).isSuccess()) {
//	                // If deposit failed, reverse the withdraw operation to keep consistency
//	                deposit(sourceAccountId, amount);
//	                return depositResult;
//	            }
//	            return new TransactionStatus(true, "Transfer successful", 
//	                                         ((TransactionStatus) withdrawResult).getSource_balance(), 
//	                                         ((TransactionStatus) depositResult).getDestination_balance());
//	        } catch (Exception e) {
//	            return new TransactionStatus(false, "Error making transfer: " + e.getMessage(), 0, 0);
//	        }
//	    }
	 
	 public Object transfer(int sourceAccountId, int targetAccountId, double amount) {
	       try {
	           Account sourceAccount = accRepo.findById(sourceAccountId).orElseThrow(() -> new Exception("Source account not found"));
	           Account targetAccount = accRepo.findById(targetAccountId).orElseThrow(() -> new Exception("Destination account not found"));
	           
	           // First, withdraw from source account
	           Object withdrawResult = withdraw(sourceAccountId, amount);
	           if (!((TransactionStatus) withdrawResult).isSuccess()) {
	               return withdrawResult;
	           }
	           // Then, deposit to destination account 
	           Object depositResult = deposit(targetAccountId, amount);
	           if (!((TransactionStatus) depositResult).isSuccess()) {
	               // If deposit failed, reverse the withdraw operation to keep consistency
	               deposit(sourceAccountId, amount);
	               return depositResult;
	           }
	           return new TransactionStatus(true, "Transfer successful", 
	                                        ((TransactionStatus) withdrawResult).getSource_balance(), 
	                                        ((TransactionStatus) depositResult).getDestination_balance());
	       } catch (Exception e) {
	           return new TransactionStatus(false, "Error making transfer: " + e.getMessage(), 0, 0);
	       }
	   }


}
