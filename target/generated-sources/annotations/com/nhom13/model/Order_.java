package com.nhom13.model;

import java.sql.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Order.class)
public abstract class Order_ extends com.nhom13.model.BaseModel_ {

	public static volatile SingularAttribute<Order, Date> date;
	public static volatile ListAttribute<Order, OrderDetail> orderDetails;
	public static volatile SingularAttribute<Order, String> address;
	public static volatile SingularAttribute<Order, Long> totalPrice;
	public static volatile SingularAttribute<Order, String> phone;
	public static volatile SingularAttribute<Order, String> name;
	public static volatile SingularAttribute<Order, PaymentMethod> paymentMethod;
	public static volatile SingularAttribute<Order, User> user;
	public static volatile SingularAttribute<Order, Integer> status;

	public static final String DATE = "date";
	public static final String ORDER_DETAILS = "orderDetails";
	public static final String ADDRESS = "address";
	public static final String TOTAL_PRICE = "totalPrice";
	public static final String PHONE = "phone";
	public static final String NAME = "name";
	public static final String PAYMENT_METHOD = "paymentMethod";
	public static final String USER = "user";
	public static final String STATUS = "status";

}

