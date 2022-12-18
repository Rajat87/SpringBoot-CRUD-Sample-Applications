package com.springboot.rest.service;

import org.springframework.stereotype.Service;

import com.springboot.rest.exception.NotEnoughMoneyException;
import com.springboot.rest.model.PaymentDetails;

@Service
public class PaymentService {

	public PaymentDetails makePayment(int payment) {
		throw new NotEnoughMoneyException();
	}
}
