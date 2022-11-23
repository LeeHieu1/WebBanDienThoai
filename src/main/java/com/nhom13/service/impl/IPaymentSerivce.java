package com.nhom13.service.impl;

import com.nhom13.model.PaymentMethod;
import com.nhom13.payload.response.DataResponse;
import com.nhom13.payload.response.ListResponse;

public interface IPaymentSerivce {

    public DataResponse<PaymentMethod> update(Long Id, String name);

    public ListResponse<PaymentMethod> getAll();

    public DataResponse<PaymentMethod> create(String name);
}
