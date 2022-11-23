package com.nhom13.service.impl;

import com.nhom13.dto.OrderDTO;
import com.nhom13.payload.request.OrderRequest;
import com.nhom13.payload.response.BaseResponse;
import com.nhom13.payload.response.ListResponse;

public interface IOrderService {
    public BaseResponse orderBooks(OrderRequest request,Long userId);

    public ListResponse<OrderDTO> getOrders(Long userId);

}
