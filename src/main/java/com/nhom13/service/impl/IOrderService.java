package com.nhom13.service.impl;

import com.nhom13.dto.OrderDTO;
import com.nhom13.payload.request.OrderRequest;
import com.nhom13.payload.response.BaseResponse;
import com.nhom13.payload.response.DataResponse;
import com.nhom13.payload.response.ListResponse;
import com.nhom13.payload.response.OrderResponse;

public interface IOrderService {
    public BaseResponse orderBooks(OrderRequest request,Long userId);
    public ListResponse<OrderDTO> getOrders(Long userId);
    public OrderDTO getOrders(Long userId, Long orderId);

    DataResponse<OrderResponse> getAllOrders();
	DataResponse<OrderResponse> getOrderById(Long id);
	DataResponse<OrderResponse> getOrderByStatus(int status);

}
