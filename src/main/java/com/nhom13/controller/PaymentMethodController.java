package com.nhom13.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nhom13.payload.request.PaymentRequest;
import com.nhom13.service.impl.IPaymentSerivce;

@RestController
@RequestMapping("api")
public class PaymentMethodController {

    @Autowired
    IPaymentSerivce paymentSerivce;

    @GetMapping("/payment-method")
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok(paymentSerivce.getAll());
    }

    @PostMapping("admin/payment-method")
    public ResponseEntity<?> create(@RequestBody PaymentRequest request) {
        return ResponseEntity.ok(paymentSerivce.create(request.getName()));
    }

    @PutMapping("admin/payment-method")
    public ResponseEntity<?> update(@RequestBody PaymentRequest request) {
        return ResponseEntity.ok(paymentSerivce.update(request.getId(), request.getName()));
    }
}
