package com.nhom13.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nhom13.dto.CartDTO;
import com.nhom13.payload.request.CartRequest;
import com.nhom13.security.userprincipal.UserPrincipal;
import com.nhom13.service.impl.ICartService;
@CrossOrigin
@RestController
@RequestMapping("api/user")
public class CartController {
    @Autowired
    ICartService cartService;

    @GetMapping("/cart")
    public ResponseEntity<?> getAllCarts(@AuthenticationPrincipal UserPrincipal user) {
        return ResponseEntity.ok(cartService.getCartBooks(user.getId()));
    }

    @PostMapping("/addCart")
    public ResponseEntity<?> addToCart(@AuthenticationPrincipal UserPrincipal user,
            @RequestBody @Valid CartRequest request) {
        return ResponseEntity.ok(cartService.addToCart(request, user.getId()));
    }

    @PutMapping("/updateCart")
    public ResponseEntity<?> updateCart(@AuthenticationPrincipal UserPrincipal user,
            @RequestBody @Valid CartRequest request) {
        return ResponseEntity.ok(cartService.updateCart(request, user.getId()));
    }

    @DeleteMapping("/delCart/{bookId}")
    public ResponseEntity<?> deleteCart(@AuthenticationPrincipal UserPrincipal user,
            @PathVariable("bookId") Long bookId) {
        return ResponseEntity.ok(cartService.deleteCart(bookId, user.getId()));
    }

}
