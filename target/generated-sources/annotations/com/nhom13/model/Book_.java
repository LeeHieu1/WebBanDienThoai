package com.nhom13.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Book.class)
public abstract class Book_ extends com.nhom13.model.BaseModel_ {

	public static volatile SingularAttribute<Book, String> image;
	public static volatile ListAttribute<Book, OrderDetail> orderDetails;
	public static volatile SingularAttribute<Book, Long> price;
	public static volatile SingularAttribute<Book, String> name;
	public static volatile SingularAttribute<Book, String> authorname;
	public static volatile SingularAttribute<Book, String> description;
	public static volatile SingularAttribute<Book, Category> category;
	public static volatile SingularAttribute<Book, User> user;

	public static final String IMAGE = "image";
	public static final String ORDER_DETAILS = "orderDetails";
	public static final String PRICE = "price";
	public static final String NAME = "name";
	public static final String AUTHORNAME = "authorname";
	public static final String DESCRIPTION = "description";
	public static final String CATEGORY = "category";
	public static final String USER = "user";

}

