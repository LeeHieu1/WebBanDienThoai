package com.nhom13.service.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.nhom13.controller.exception.CommonRuntimeException;
import com.nhom13.dto.CartDTO;
import com.nhom13.model.Book;
import com.nhom13.model.Cart;
import com.nhom13.model.User;
import com.nhom13.model.pk.CartPK;
import com.nhom13.payload.request.CartRequest;
import com.nhom13.payload.response.BaseResponse;
import com.nhom13.payload.response.ListResponse;
import com.nhom13.repository.BookRepository;
import com.nhom13.repository.CartRepository;
import com.nhom13.repository.UserRepository;
import com.nhom13.service.impl.ICartService;

@Service
public class CartService implements ICartService {

    @Autowired
    private CartRepository cartRepo;

    @Autowired
    private UserRepository userRepo;

    @Autowired
    BookRepository bookRepo;

    @Autowired
    ModelMapper modelMapper;

    // Add to cart
    public BaseResponse addToCart(CartRequest request, Long userId) {
        try {
            User user = userRepo.findById(userId).get();
            Book book = bookRepo.findById(request.getBookId()).get();

            CartPK pk = new CartPK(userId, request.getBookId());

            Cart cart = new Cart(pk, user, book, request.getQuantity());

            cartRepo.save(cart);

            return new BaseResponse(true, "Add to cart success !");
        } catch (Exception ex) {
            throw new CommonRuntimeException("Some thing went wrong try later !");
        }

    }

    // Update cart
    public BaseResponse updateCart(CartRequest request, Long userId) {
        CartPK pk = new CartPK(userId, request.getBookId());

        Optional<Cart> optCart = cartRepo.findById(pk);
        if (optCart.isEmpty())
            return new BaseResponse(false, "Cart not found !");

        Cart cart = optCart.get();
        if (request.getQuantity() <= 0) {
            cartRepo.delete(cart);
            return new BaseResponse(true, "Update cart success !");
        }
        cart.setQuantity(request.getQuantity());
        cartRepo.save(cart);

        return new BaseResponse(true, "Update cart success !");
    }

    // Delete from cart
    public BaseResponse deleteCart(Long bookId, Long userId) {
        CartPK pk = new CartPK(userId, bookId);

        Optional<Cart> optCart = cartRepo.findById(pk);
        if (optCart.isEmpty())
            return new BaseResponse(false, "Cart not found !");
        Cart cart = optCart.get();

        cartRepo.delete(cart);

        return new BaseResponse(true, "Delete cart success !");
    }
    // Get carts product

    public ListResponse<CartDTO> getCartBooks(Long userId) {
        List<CartDTO> lstCarts = cartRepo.findByUserId(userId).stream()
                .map((cart) -> modelMapper.map(cart, CartDTO.class))
                .toList();
        return new ListResponse<>(lstCarts);
    }
}
