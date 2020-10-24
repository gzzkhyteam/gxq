package com.hengyunsoft.validator.mateconstraint.impl;

import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.validation.constraints.NotNull;

import com.hengyunsoft.validator.ConstraintInfo;
import com.hengyunsoft.validator.mateconstraint.IConstraintConverter;

public class NotNullConstraintConverter extends BaseConstraintConverter implements IConstraintConverter {

	
	@Override
	protected String getType() {
		return "notNull";
	}
	
	@Override
	protected List<Class<? extends Annotation>> getSuport() {
		
		return suportClazz;
	}
	private List<Class<? extends Annotation>> suportClazz;
	
	{
		suportClazz = new ArrayList<Class<? extends Annotation>>(1);
		suportClazz.add(NotNull.class);
	}
	
	@Override
	public ConstraintInfo converter(Annotation ano) throws Exception {
		
		return NOT_NULL_INSTANCE;
	}
	
	private ConstraintInfo NOT_NULL_INSTANCE = ConstraintInfo.builder().setType(getType()).builder();
	
	
}
