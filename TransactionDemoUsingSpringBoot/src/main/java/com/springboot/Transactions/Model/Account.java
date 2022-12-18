package com.springboot.Transactions.Model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity(name = "Account")
@Table(name = "Account")
public class Account {
	@Id
	//@GeneratedValue(strategy = GenerationType.AUTO)
	@NotNull
	long accountId;
	@NotEmpty(message = "Please Enter a valid accountName")
	@Size(min=2,message= "Name should have at least 2 digits")
	String accountName;
	long amount;
	
	public Account() {
		
	}

	public Account(long accountId, String accountName, long amount) {
		super();
		this.accountId = accountId;
		this.accountName = accountName;
		this.amount = amount;
	}

	public long getAccountId() {
		return accountId;
	}

	public void setAccountId(long accountId) {
		this.accountId = accountId;
	}

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public long getAmount() {
		return amount;
	}

	public void setAmount(long amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "Account [accountId=" + accountId + ", accountName=" + accountName + ", amount=" + amount + "]";
	}
	
	
	
}
