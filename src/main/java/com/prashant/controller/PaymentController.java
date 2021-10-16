package com.prashant.controller;

import java.net.URI;
import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.prashant.model.Payment;

import com.prashant.service.PaymentService;

@RestController
@CrossOrigin
public class PaymentController {

	@Autowired
	private PaymentService service;
	
	@GetMapping("/payments")
	@CrossOrigin(origins = "http://localhost:4200")
	public List<Payment> retrieveAllPayments(){
		return service.getPayments();
	}
	
	@PostMapping("/payments")
	@CrossOrigin(origins = "http://localhost:4200")
	public ResponseEntity<Payment> createProduct(@RequestBody Payment payment) {
		
		Payment savedPayment = service.savepayment(payment);
		
	
		URI location = ServletUriComponentsBuilder
				 .fromCurrentRequest()
				 .path("/{theId}")
				 .buildAndExpand(savedPayment.getId())
				 .toUri();
		return ResponseEntity.created(location).build();
	}
}
