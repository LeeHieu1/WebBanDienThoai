package com.nhom13.payload.request;

import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
public class PaymentRequest {

    private Long id;
    @NotBlank
    private String name;
}
