package com.app.banking;

import java.time.LocalDate;

import customException.BankingException;

import static utils.BankingValidationRules.validateAmount;
public class BankAccount {
	private int acctNo;//PK auto box to Integer and hashcode and equals method of Integer is called
	private String custName;
	private AccountType type;
	public int getAcctNo() {
		return acctNo;
	}
	public void setAcctNo(int acctNo) {
		this.acctNo = acctNo;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public void setCustName(String custName) {
		this.custName = custName;
	}

	private LocalDate creationDate;
	private double balance;
	public BankAccount(int acctNo, String custName, AccountType type, LocalDate creationDate, double balance) {
		super();
		this.acctNo = acctNo;
		this.custName = custName;
		this.type = type;
		this.creationDate = creationDate;
		this.balance = balance;
	}
	public LocalDate getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(LocalDate creationDate) {
		this.creationDate = creationDate;
	}
	public String getCustName() {
		return custName;
	}
	public AccountType getType() {
		return type;
	}
	public void setType(AccountType type) {
		this.type = type;
	}
	@Override
	public String toString() {
		return "BankAccount [acctNo=" + acctNo + ", custName=" + custName + ", type=" + type + ", creationDate="
				+ creationDate + ", balance=" + balance + "]";
	}
	
	public void deposit(double amount) {
		this.balance+=amount;
	}
	
	public void withdraw(double amount) throws BankingException {
		    validateAmount(balance-amount);
			this.balance-=amount;
		
	}
	
	public void fundTransfer(BankAccount dest,double amount) throws BankingException  {
		this.withdraw(amount);
		dest.deposit(amount);
		System.out.println("Funds Transfer From "+this.acctNo+" into "+dest.acctNo);
	}
	
}
