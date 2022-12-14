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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nhom13.payload.request.OrderRequest;
import com.nhom13.security.userprincipal.UserPrincipal;
import com.nhom13.service.impl.IOrderService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class OrderController {

	@Autowired
	IOrderService orderService;

	@GetMapping("/user/order")
	public ResponseEntity<?> getOrders(@AuthenticationPrincipal UserPrincipal user) {
		return ResponseEntity.ok(orderService.getOrders(user.getId()));
	}

	@GetMapping("/user/order/{id}")
	public ResponseEntity<?> getOrders(@AuthenticationPrincipal UserPrincipal user, @PathVariable("id") Long orderId) {
		return ResponseEntity.ok(orderService.getOrders(user.getId(), orderId));
	}

	@PostMapping("/user/createOrder")
	public ResponseEntity<?> createOrders(@AuthenticationPrincipal UserPrincipal user,
			@RequestBody OrderRequest request) {
		return ResponseEntity.ok(orderService.orderBooks(request, user.getId()));
	}
	@GetMapping("/admin/orders")
	public ResponseEntity<?> getAllOrder() {
		return ResponseEntity.ok(orderService.getAllOrders());
	}
	
	@GetMapping("/admin/order/{id}")
	public ResponseEntity<?> getOrderById(@PathVariable("id") Long id) {
		return ResponseEntity.ok(orderService.getOrderById(id));
	}
	
	@GetMapping("/admin/order")
	public ResponseEntity<?> getOrderByStatus(@RequestParam("status") int status) {
		return ResponseEntity.ok(orderService.getOrderByStatus(status));
	}

}
