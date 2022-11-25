package com.nhom13.dto;

import java.sql.Date;
import java.util.List;

import com.nhom13.model.PaymentMethod;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor

public class OrderDTO extends BaseDTO {
	protected Long id_user;
	protected String name;
	protected String phone;
	protected String address;
	protected Long totalPrice;
	protected Date date;
	protected String paymentMethod;
	protected Integer status;
	protected List<OrderDetailDTO> orderDetails;

}
