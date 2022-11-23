package com.nhom13.payload.request;

import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;

import lombok.Data;

@Data
public class OrderRequest {
    // @NotBlank
    String name;
    // @NotBlank
    // @Length(min = 10, max = 10)
    String phone;
    String address;
    Long payment;
}
