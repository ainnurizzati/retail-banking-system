package com.example.demo.account;

import java.sql.Date;

public class DateRange {

	private Date fromDate;
	private Date toDate;
	
	public DateRange() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DateRange(Date fromDate, Date toDate) {
		super();
		this.fromDate = fromDate;
		this.toDate = toDate;
	}

	public Date getFromDate() {
		return fromDate;
	}

	public void setFromDate(Date fromDate) {
		this.fromDate = fromDate;
	}

	public Date getToDate() {
		return toDate;
	}

	public void setToDate(Date toDate) {
		this.toDate = toDate;
	}
	
	
}
