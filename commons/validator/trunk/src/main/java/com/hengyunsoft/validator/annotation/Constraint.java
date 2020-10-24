package com.hengyunsoft.validator.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.groups.Default;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({})
public @interface Constraint {

	Class<?> value();
	Class<?>[] groups() default {Default.class};
}
