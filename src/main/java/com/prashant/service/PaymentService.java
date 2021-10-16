package com.prashant.service;

import java.util.List;

import com.prashant.model.Payment;
import com.prashant.model.Product;

public interface PaymentService {
	 public List<Payment> getPayments();
	 public Payment savepayment(Payment payment);
}
