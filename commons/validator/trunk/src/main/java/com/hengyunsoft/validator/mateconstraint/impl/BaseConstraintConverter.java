package com.hengyunsoft.validator.mateconstraint.impl;

import java.lang.annotation.Annotation;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import com.hengyunsoft.validator.ConstraintInfo;
import com.hengyunsoft.validator.mateconstraint.IConstraintConverter;

public abstract class BaseConstraintConverter implements IConstraintConverter {


	private  List<String> methods = Collections.EMPTY_LIST;

	@Override
	public boolean suport(Class<? extends Annotation> clazz) {

		return clazz != null && getSuport().contains(clazz);
	}

	@Override
	public ConstraintInfo converter(Annotation ano) throws Exception{
		
		Class<? extends Annotation> clazz = ano.getClass();
		Map<String,Object> attr = new HashMap<>(4);
		for (String method : methods) {
			Object value = clazz.getMethod(method).invoke(ano);
			attr.put(method, value);
		}
		
		return ConstraintInfo.builder().setType(getType()).setAttrs(attr).builder();
	}

	
	protected abstract List<Class<? extends Annotation>> getSuport();







	protected List<String> getMethods() {
		return methods;
	}



	protected void setMethods(List<String> methods) {
		this.methods = methods;
	}



	protected abstract String getType();



	
}