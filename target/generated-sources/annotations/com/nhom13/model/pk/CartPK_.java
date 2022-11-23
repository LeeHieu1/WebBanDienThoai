package com.nhom13.model.pk;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(CartPK.class)
public abstract class CartPK_ {

	public static volatile SingularAttribute<CartPK, Long> userId;
	public static volatile SingularAttribute<CartPK, Long> bookId;

	public static final String USER_ID = "userId";
	public static final String BOOK_ID = "bookId";

}

