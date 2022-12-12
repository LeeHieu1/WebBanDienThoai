package com.nhom13.service.service;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nhom13.controller.exception.CommonRuntimeException;
import com.nhom13.dto.OrderDTO;
import com.nhom13.model.Cart;
import com.nhom13.model.Order;
import com.nhom13.model.OrderDetail;
import com.nhom13.model.PaymentMethod;
import com.nhom13.model.User;
import com.nhom13.payload.request.OrderRequest;
import com.nhom13.payload.response.BaseResponse;
import com.nhom13.payload.response.BookResponse;
import com.nhom13.payload.response.DataResponse;
import com.nhom13.payload.response.ListResponse;
import com.nhom13.payload.response.OrderResponse;
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

    @Override
	public DataResponse<OrderResponse> getAllOrders() {
		DataResponse<OrderResponse> response = new DataResponse<>();
		List<Order> orders = orderRepo.findAll();
		if(orders != null) {
			List<OrderResponse> listOrder = new ArrayList<>();
			for(Order order : orders) {
				OrderResponse orderResponse = new OrderResponse();
				orderResponse.setAddress(order.getAddress());
				orderResponse.setName(order.getName());
				orderResponse.setPhone(order.getPhone());
				orderResponse.setUsername(order.getUser().getUsername());
				orderResponse.setDate(order.getDate());
				if(order.getStatus() == 0) {
					orderResponse.setStatus("Chưa thanh toán");
				}else if(order.getStatus() == 1){
					orderResponse.setStatus("Đã thanh toán");
				}else {
					orderResponse.setStatus("Chưa xác nhận");
				}
				orderResponse.setTotal_price(order.getTotalPrice());
				orderResponse.setId(order.getId());
				
				List<OrderDetail> orDetails = order.getOrderDetails();
				List<BookResponse> listBook = new ArrayList<>();
				for(OrderDetail orderDetail: orDetails) {
					BookResponse book = modelMapper.map(orderDetail.getBook(), BookResponse.class);
					listBook.add(book);
				}
				orderResponse.setBooks(listBook);
				listOrder.add(orderResponse);
			}
			response.setSuccess(true);
			response.setMessage("Success");
			response.setDatas(listOrder);
			
		}else {
			response.setSuccess(false);
			response.setMessage("Order is empty");
		}
		return response;
	}

	@Override
	public DataResponse<OrderResponse> getOrderById(Long id) {
		DataResponse<OrderResponse> response = new DataResponse<>();
		Order order = orderRepo.getById(id);
		if(order != null) {
			OrderResponse orderResponse = new OrderResponse();
			orderResponse.setAddress(order.getAddress());
			orderResponse.setName(order.getName());
			orderResponse.setPhone(order.getPhone());
			orderResponse.setUsername(order.getUser().getUsername());
			orderResponse.setDate(order.getDate());
			if(order.getStatus() == 0) {
				orderResponse.setStatus("Chưa thanh toán");
			}else {
				orderResponse.setStatus("Đã thanh toán");
			}
			orderResponse.setTotal_price(order.getTotalPrice());
			orderResponse.setId(order.getId());
			List<OrderDetail> orDetails = order.getOrderDetails();
			List<BookResponse> listBook = new ArrayList<>();
			for(OrderDetail orderDetail: orDetails) {
				BookResponse book = modelMapper.map(orderDetail.getBook(), BookResponse.class);
				book.setQuantity(orderDetail.getQuantity());
				listBook.add(book);
			}
			
			orderResponse.setBooks(listBook);
			response.setSuccess(true);
			response.setMessage("Success");
			response.setData(orderResponse);
		}
		return response;
	}

	@Override
	public DataResponse<OrderResponse> getOrderByStatus(int status) {
		DataResponse<OrderResponse> response = new DataResponse<>();
		List<Order> orders = orderRepo.getOrdersByStatus(status);
		if(orders.size()!=0) {
			List<OrderResponse> listOrder = new ArrayList<>();
			for(Order order : orders) {
				OrderResponse orderResponse = new OrderResponse();
				orderResponse.setAddress(order.getAddress());
				orderResponse.setName(order.getName());
				orderResponse.setPhone(order.getPhone());
				orderResponse.setUsername(order.getUser().getUsername());
				orderResponse.setDate(order.getDate());
				if(order.getStatus() == 0) {
					orderResponse.setStatus("Chưa thanh toán");
				}else if(order.getStatus() == 1){
					orderResponse.setStatus("Đã thanh toán");
				}else {
					orderResponse.setStatus("Chưa xác nhận");
				}
				orderResponse.setTotal_price(order.getTotalPrice());
				orderResponse.setId(order.getId());
				
				List<OrderDetail> orDetails = order.getOrderDetails();
				List<BookResponse> listBook = new ArrayList<>();
				for(OrderDetail orderDetail: orDetails) {
					BookResponse book = modelMapper.map(orderDetail.getBook(), BookResponse.class);
					listBook.add(book);
				}
				orderResponse.setBooks(listBook);
				listOrder.add(orderResponse);
			}
			response.setSuccess(true);
			response.setMessage("Success");
			response.setDatas(listOrder);
			
		}else {
			response.setSuccess(false);
			response.setMessage("Order is empty");
		}
		return response;
	}

}
