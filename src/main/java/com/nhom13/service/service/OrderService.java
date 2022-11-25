package com.nhom13.service.service;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;

import com.nhom13.controller.exception.CommonRuntimeException;
import com.nhom13.dto.OrderDTO;
import com.nhom13.model.Cart;
import com.nhom13.model.Order;
import com.nhom13.model.OrderDetail;
import com.nhom13.model.PaymentMethod;
import com.nhom13.model.User;
import com.nhom13.payload.request.OrderRequest;
import com.nhom13.payload.response.BaseResponse;
import com.nhom13.payload.response.ListResponse;
import com.nhom13.repository.CartRepository;
import com.nhom13.repository.OrderDetailRepository;
import com.nhom13.repository.OrderRepository;
import com.nhom13.repository.PaymentRepository;
import com.nhom13.repository.UserRepository;
import com.nhom13.service.impl.IOrderService;

@Service
public class OrderService implements IOrderService {

    @Autowired
    OrderDetailRepository orderDetailRepo;

    @Autowired
    OrderRepository orderRepo;

    @Autowired
    CartRepository cartRepo;

    @Autowired
    UserRepository userRepo;

    @Autowired
    PaymentRepository paymentRepo;
    @Autowired
    ModelMapper modelMapper;

    @Transactional
    public BaseResponse orderBooks(OrderRequest request, Long userId) {

        User user = userRepo.getReferenceById(userId);
        PaymentMethod paymentMethod = paymentRepo.getReferenceById(request.getPayment());
        List<Cart> lstCarts = cartRepo.findByUserId(userId);
        if (lstCarts.size() == 0)
            return new BaseResponse(false, "You do not have any book in cart !");
        // Well
        Order order = new Order();
        Long total = 0L;
        List<OrderDetail> orderDetails = new ArrayList<>();

        for (Cart cart : lstCarts) {
            orderDetails.add(new OrderDetail(order, cart.getQuantity(), cart.getBook().getPrice(), cart.getBook()));
            total += cart.getBook().getPrice() * cart.getQuantity();
        }

        order.setPaymentMethod(paymentMethod);
        order.setOrderDetails(orderDetails);
        order.setAddress(request.getAddress());
        order.setPhone(request.getPhone());
        order.setName(request.getName());
        // Tự xử lý
        order.setStatus(0);
        order.setTotalPrice(total);
        order.setUser(user);

        orderRepo.save(order);

        // Delete from cart
        cartRepo.deleteAllInBatch(lstCarts);
        return new BaseResponse(true, "Create order success !");

    }

    public ListResponse<OrderDTO> getOrders(Long userId) {
        User user = userRepo.getReferenceById(userId);

        List<OrderDTO> orders = orderRepo.findByUser(user).stream()
                .map(order -> modelMapper.map(order, OrderDTO.class)).toList();
        if (orders.size() == 0)
            throw new CommonRuntimeException("You do not have any order !");
        return new ListResponse<>(orders);
    }

    public OrderDTO getOrders(Long userId, Long orderId) {

        OrderDTO order = modelMapper.map(orderRepo.findById(orderId).get(), OrderDTO.class);
        if (order.getId_user() != userId)
            throw new CommonRuntimeException("Order not found !");
        return order;
    }
}
