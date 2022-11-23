package com.nhom13.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Category.class)
public abstract class Category_ extends com.nhom13.model.BaseModel_ {

	public static volatile ListAttribute<Category, Book> books;
	public static volatile SingularAttribute<Category, String> name;

	public static final String BOOKS = "books";
	public static final String NAME = "name";

}

