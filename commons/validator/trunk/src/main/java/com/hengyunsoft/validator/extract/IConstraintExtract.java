package com.hengyunsoft.validator.extract;

import java.util.Collection;

import com.hengyunsoft.validator.FieldValidatorDesc;
import com.hengyunsoft.validator.annotation.Constraint;

public interface IConstraintExtract {

	public Collection<FieldValidatorDesc> extract(Constraint[] constraints) throws Exception;
	
}
