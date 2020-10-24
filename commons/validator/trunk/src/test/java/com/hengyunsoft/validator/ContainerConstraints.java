package com.hengyunsoft.validator;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import javax.validation.Valid;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import javax.validation.constraints.NotNull;

import org.junit.BeforeClass;
import org.junit.Test;

public class ContainerConstraints {

    private static Validator validator;

    @BeforeClass
    public static void setUpValidator() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }
    
    @Test
    public void list() {
    	
    	List<Integer> ints = new ArrayList<>();
    	IntStream.range(0, 1000).forEach(i->ints.add(i));
    	Resource re = new Resource(null, null, null);
    	System.out.println(validator.validate(ints));
    }
}
