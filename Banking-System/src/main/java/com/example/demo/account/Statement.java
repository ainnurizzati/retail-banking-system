package com.example.demo.account;

import java.io.Serializable;
import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name="statement")
public class Statement{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int chq; 
	
	@Temporal(value=TemporalType.DATE)
	private Date date; 
	
	private String naration; 
	
	@Temporal(value=TemporalType.DATE)
	private Date valueDate; 
	
	private float withdrawal; 
	
	private float deposit;
	
	private float closingBalance;
	
	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "account_id", referencedColumnName = "accountId")
    private Account account;

	public Statement() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Statement(int chq, Date date, String naration, Date valueDate, float withdrawal, float deposit,
			float closingBalance, Account account) {
		super();
		this.chq = chq;
		this.date = date;
		this.naration = naration;
		this.valueDate = valueDate;
		this.withdrawal = withdrawal;
		this.deposit = deposit;
		this.closingBalance = closingBalance;
		this.account = account;
	}

	public int getChq() {
		return chq;
	}

	public void setChq(int chq) {
		this.chq = chq;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getNaration() {
		return naration;
	}

	public void setNaration(String naration) {
		this.naration = naration;
	}

	public Date getValueDate() {
		return valueDate;
	}

	public void setValueDate(Date valueDate) {
		this.valueDate = valueDate;
	}

	public float getWithdrawal() {
		return withdrawal;
	}

	public void setWithdrawal(float withdrawal) {
		this.withdrawal = withdrawal;
	}

	public float getDeposit() {
		return deposit;
	}

	public void setDeposit(float deposit) {
		this.deposit = deposit;
	}

	public float getClosingBalance() {
		return closingBalance;
	}

	public void setClosingBalance(float closingBalance) {
		this.closingBalance = closingBalance;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	
}
