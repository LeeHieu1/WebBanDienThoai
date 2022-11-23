package com.nhom13.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(OrderDetail.class)
public abstract class OrderDetail_ extends com.nhom13.model.BaseModel_ {

	public static volatile SingularAttribute<OrderDetail, Long> quantity;
	public static volatile SingularAttribute<OrderDetail, Long> price;
	public static volatile SingularAttribute<OrderDetail, Book> book;
	public static volatile SingularAttribute<OrderDetail, Order> order;

	public static final String QUANTITY = "quantity";
	public static final String PRICE = "price";
	public static final String BOOK = "book";
	public static final String ORDER = "order";

}

