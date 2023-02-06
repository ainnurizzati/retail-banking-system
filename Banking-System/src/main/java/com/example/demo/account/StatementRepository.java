package com.example.demo.account;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface StatementRepository extends JpaRepository<Statement, Integer>{

	 List<Statement> findByAccount_AccountIdAndValueDateBetween(int accountId, Date fromDate, Date toDate);

//	List<Statement> findByAccountIdAndDateBetween(int accountId, LocalDate fromDate, LocalDate toDate);

//	List<Statement> findByAccount_AccountIdAndValueDateBetween(int accountId, Date fromDate, Date toDate);


}
