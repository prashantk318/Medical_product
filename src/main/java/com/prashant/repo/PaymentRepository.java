package com.prashant.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.prashant.model.Payment;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Integer> {

}
