package com.nhom13.service.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nhom13.controller.exception.CommonRuntimeException;
import com.nhom13.model.PaymentMethod;
import com.nhom13.payload.response.BaseResponse;
import com.nhom13.payload.response.DataResponse;
import com.nhom13.payload.response.ListResponse;
import com.nhom13.repository.PaymentRepository;
import com.nhom13.service.impl.IPaymentSerivce;

@Service
public class PaymentSerivce implements IPaymentSerivce {

    @Autowired
    PaymentRepository paymentRepo;

    public DataResponse<PaymentMethod> create(String name) {
        PaymentMethod pm = new PaymentMethod(name);

        pm = paymentRepo.save(pm);

        return new DataResponse<>(pm);
    }

    public DataResponse<PaymentMethod> update(Long Id, String name) {
        Optional<PaymentMethod> pm = paymentRepo.findById(Id);
        if (pm.isEmpty())
            throw new CommonRuntimeException("Payment method not found !");
        PaymentMethod paymentMethod = pm.get();
        paymentMethod.setName(name);
        paymentMethod = paymentRepo.save(paymentMethod);
        return new DataResponse<>(paymentMethod);
    }

    public ListResponse<PaymentMethod> getAll() {
        return new ListResponse<>(paymentRepo.findAll());
    }
}
