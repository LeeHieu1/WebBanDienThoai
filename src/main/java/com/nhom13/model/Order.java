package com.nhom13.model;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
@Entity
@Table(name = "orders")
public class Order extends BaseModel {

}