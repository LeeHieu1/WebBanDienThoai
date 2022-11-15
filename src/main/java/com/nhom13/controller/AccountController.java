package com.nhom13.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.nhom13.service.impl.IAccountService;

@Controller
@RequestMapping("/api")
public class AccountController {
	@Autowired
	IAccountService accountService;
	
	@GetMapping("/admin/accounts")
	public ResponseEntity<?> getAllAccount() {
		return ResponseEntity.ok(accountService.getAllAccountUser());
	}
	
	@GetMapping("/account/{id}")
	public ResponseEntity<?> getAccountById(@PathVariable("id") Long id) {
		return ResponseEntity.ok(accountService.getAccountUserById(id));
	}
	
	@GetMapping("/admin/block/{id}")
	public ResponseEntity<?> block(@PathVariable("id") Long id){
		return ResponseEntity.ok(accountService.blockAccountUser(id));
	}

}