package com.springboot.rest.model;

public class PaymentDetails {
	int amount;

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "PaymentDetails [amount=" + amount + "]";
	}
	
	
}
