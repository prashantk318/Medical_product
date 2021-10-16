package com.prashant.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prashant.model.Payment;
import com.prashant.repo.PaymentRepository;
import com.prashant.service.PaymentService;

@Service
public class PaymentServiceImpl implements PaymentService {

	
	@Autowired
	private PaymentRepository repo;
	
	@Override
	public List<Payment> getPayments() {
		
		return repo.findAll();
	}

	@Override
	public Payment savepayment(Payment payment) {
		return repo.save(payment);
	}

}
