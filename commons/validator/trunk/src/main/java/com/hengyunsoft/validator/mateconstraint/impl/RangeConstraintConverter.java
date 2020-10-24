package com.hengyunsoft.validator.mateconstraint.impl;


import java.lang.annotation.Annotation;
import java.util.Arrays;
import java.util.List;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;

import com.hengyunsoft.validator.mateconstraint.IConstraintConverter;


public class RangeConstraintConverter extends BaseConstraintConverter implements IConstraintConverter {

	private void init() {
		
		setMethods( Arrays.asList("min","max"));
	}

	public RangeConstraintConverter() {
		init();
	}

	@Override
	protected String getType() {
		return "range";
	}

	@Override
	protected List<Class<? extends Annotation>> getSuport() {
		return suportClazz;
	}
	private List<Class<? extends Annotation>> suportClazz = Arrays.asList(Length.class,Size.class,Range.class);
}
