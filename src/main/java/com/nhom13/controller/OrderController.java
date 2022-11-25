package com.nhom13.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nhom13.payload.request.OrderRequest;
import com.nhom13.security.userprincipal.UserPrincipal;
import com.nhom13.service.impl.IOrderService;

@CrossOrigin
@RestController
@RequestMapping("api/user")
public class OrderController {

	@Autowired
	IOrderService orderService;

	@GetMapping("/order")
	public ResponseEntity<?> getOrders(@AuthenticationPrincipal UserPrincipal user) {
		return ResponseEntity.ok(orderService.getOrders(user.getId()));
	}

	@GetMapping("{id}")
	public ResponseEntity<?> getOrders(@AuthenticationPrincipal UserPrincipal user, @PathVariable("id") Long orderId) {
		return ResponseEntity.ok(orderService.getOrders(user.getId(), orderId));
	}

	@PostMapping("/createOrder")
	public ResponseEntity<?> createOrders(@AuthenticationPrincipal UserPrincipal user,
			@RequestBody OrderRequest request) {
		return ResponseEntity.ok(orderService.orderBooks(request, user.getId()));
	}
}
