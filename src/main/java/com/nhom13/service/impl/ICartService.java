package com.nhom13.service.impl;

import com.nhom13.dto.CartDTO;
import com.nhom13.payload.request.CartRequest;
import com.nhom13.payload.response.BaseResponse;
import com.nhom13.payload.response.ListResponse;

public interface ICartService {

    public BaseResponse addToCart(CartRequest request,Long userId);

    public BaseResponse updateCart(CartRequest request,Long userId);

    public BaseResponse deleteCart(Long bookId,Long userId);

    public ListResponse<CartDTO> getCartBooks(Long userId);

}
