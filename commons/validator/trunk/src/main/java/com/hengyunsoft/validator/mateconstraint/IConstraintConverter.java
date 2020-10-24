package com.hengyunsoft.validator.mateconstraint;

import java.lang.annotation.Annotation;

import com.hengyunsoft.validator.ConstraintInfo;
/**
 *   
 *   子类请实现成线程安全的
 */
public interface IConstraintConverter {

	public boolean suport(Class<? extends Annotation> clazz);
	
	public ConstraintInfo converter(Annotation ano) throws Exception;
}
