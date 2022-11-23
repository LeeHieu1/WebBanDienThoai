package com.nhom13.model;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(BaseModel.class)
public abstract class BaseModel_ {

	public static volatile SingularAttribute<BaseModel, Date> createdDate;
	public static volatile SingularAttribute<BaseModel, String> createdBy;
	public static volatile SingularAttribute<BaseModel, Date> modifiedDate;
	public static volatile SingularAttribute<BaseModel, String> modifiedBy;
	public static volatile SingularAttribute<BaseModel, Long> id;

	public static final String CREATED_DATE = "createdDate";
	public static final String CREATED_BY = "createdBy";
	public static final String MODIFIED_DATE = "modifiedDate";
	public static final String MODIFIED_BY = "modifiedBy";
	public static final String ID = "id";

}

