package com.hengyunsoft.validator;

import java.util.Set;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.junit.BeforeClass;
import org.junit.Test;

import com.hengyunsoft.validator.ValidatorGroups.MustNoneNull;

import static org.junit.Assert.assertEquals;

public class CarTest {

    private static Validator validator;

    @BeforeClass
    public static void setUpValidator() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Test
    public void manufacturerIsNull() {
        Car car = new Car( null, "DD-AB-123", 4 );

        Set<ConstraintViolation<Car>> constraintViolations =
                validator.validate(car);

        assertEquals( 1, constraintViolations.size() );
        System.out.println( constraintViolations.iterator().next().getMessage() );
    }

    @Test
    public void licensePlateTooShort() {
        Car car = new Car( "Morris", "D", 4 );

        Set<ConstraintViolation<Car>> constraintViolations =
                validator.validate( car );

        assertEquals( 1, constraintViolations.size() );
        System.out.println(
                
                constraintViolations.iterator().next().getMessage()
        );
    }

    @Test
    public void seatCountTooLow() {
        Car car = new Car( "Morris", "DD-AB-123", 1 );

        Set<ConstraintViolation<Car>> constraintViolations =
                validator.validate( car );

        assertEquals( 1, constraintViolations.size() );
        System.out.println(
                
                constraintViolations.iterator().next().getMessage()
        );
    }

    @Test
    public void carIsValid() {
        Car car = new Car( "Morris", "DD-AB-123", 2 );

        Set<ConstraintViolation<Car>> constraintViolations =
                validator.validate( car );

        assertEquals( 0, constraintViolations.size() );
    }
    
    @Test
    public void carIsValid1() {
    	Car car = new Car( null, null, 2 );
    	
    	Set<ConstraintViolation<Car>> constraintViolations =
    			validator.validate( car ,MustNoneNull.class);
    	
    	ConstraintViolation<Car> errorCar = constraintViolations.iterator().next();
    	System.out.println(errorCar);
    	System.out.println(
                
    			errorCar.getMessage()
        );
    	assertEquals( 0, constraintViolations.size() );

    }
}