package com.nhom13.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nhom13.model.PaymentMethod;

@Repository
public interface PaymentRepository extends JpaRepository<PaymentMethod, Long> {

}
