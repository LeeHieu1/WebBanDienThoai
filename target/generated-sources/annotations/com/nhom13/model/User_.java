package com.nhom13.model;

import com.nhom13.utility.datatype.ERole;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(User.class)
public abstract class User_ {

	public static volatile SingularAttribute<User, String> password;
	public static volatile ListAttribute<User, Book> books;
	public static volatile SingularAttribute<User, String> phone;
	public static volatile SingularAttribute<User, ERole> roles;
	public static volatile SingularAttribute<User, String> name;
	public static volatile ListAttribute<User, Order> orders;
	public static volatile SingularAttribute<User, Long> id;
	public static volatile SingularAttribute<User, String> email;
	public static volatile SingularAttribute<User, Boolean> enabled;
	public static volatile SingularAttribute<User, String> username;
	public static volatile SingularAttribute<User, String> verificationCode;
	public static volatile SingularAttribute<User, Boolean> status;

	public static final String PASSWORD = "password";
	public static final String BOOKS = "books";
	public static final String PHONE = "phone";
	public static final String ROLES = "roles";
	public static final String NAME = "name";
	public static final String ORDERS = "orders";
	public static final String ID = "id";
	public static final String EMAIL = "email";
	public static final String ENABLED = "enabled";
	public static final String USERNAME = "username";
	public static final String VERIFICATION_CODE = "verificationCode";
	public static final String STATUS = "status";

}

