package com.nhom13.model;

import com.nhom13.model.pk.CartPK;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Cart.class)
public abstract class Cart_ {

	public static volatile SingularAttribute<Cart, Long> quantity;
	public static volatile SingularAttribute<Cart, Book> book;
	public static volatile SingularAttribute<Cart, CartPK> id;
	public static volatile SingularAttribute<Cart, User> user;

	public static final String QUANTITY = "quantity";
	public static final String BOOK = "book";
	public static final String ID = "id";
	public static final String USER = "user";

}

