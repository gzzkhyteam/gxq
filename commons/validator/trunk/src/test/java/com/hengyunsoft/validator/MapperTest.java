package com.hengyunsoft.validator;

import java.util.Arrays;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.groups.Default;
import javax.validation.metadata.BeanDescriptor;

import org.hibernate.validator.messageinterpolation.ResourceBundleMessageInterpolator;
import org.hibernate.validator.resourceloading.AggregateResourceBundleLocator;
import org.hibernate.validator.spi.resourceloading.ResourceBundleLocator;
import org.junit.BeforeClass;
import org.junit.Test;

import com.hengyunsoft.validator.ValidatorGroups.MustNoneNull;

public class MapperTest {

    private static Validator validator;

    @BeforeClass
    public static void setUpValidator() {
    	ResourceBundleLocator locator = new AggregateResourceBundleLocator(
                Arrays.asList(
                        "field/mapping/Resource",
                        "MyOtherMessages"
                )
        );

    	
    	validator = Validation.byDefaultProvider()
    	        .configure()
    	        .messageInterpolator(
    	                new ResourceBundleMessageInterpolator(locator)
    	        )
    	        .buildValidatorFactory()
    	        .getValidator();
    	
    	ResourceBundle resource = locator.getResourceBundle(Locale.getDefault());
    	System.out.println(resource.getString("resource.id"));
    }
    
  

	private void handlerError(Set<ConstraintViolation<Resource>> f) {
		
		if(f.size() == 0) {
			return ;
		}
		f.stream().forEach(c -> {
			System.out.println("字段：" + c.getPropertyPath() + "错误是：" + c.getMessage() + "模板是：" + c.getMessageTemplate()+c.getConstraintDescriptor());
			System.out.println(c);
		});
	}
	
   /**
     * 全部插入
     */
    @Test
    public void insert() {
    	
    	BeanDescriptor s = validator.getConstraintsForClass(Resource.class);
    	Resource resource = new Resource(null,null,null);
    	Set<ConstraintViolation<Resource>> f = validator.validate(resource, MustNoneNull.class,Default.class);
        handlerError(f);
    }
	
	/**
	 * 选择性插入    就是空的不插入
	 */
	@Test
    public void insertSelect() {
    	
    	Resource resource = new Resource(null,null,null);
    	Set<ConstraintViolation<Resource>> f = validator.validate(resource);
        handlerError(f);
    }
	
	/**
	 * 全部更新
	 */
	@Test
	public void update() {
		
		Resource resource = new Resource(null,"胖哥哥个收电费",null);
		Set<ConstraintViolation<Resource>> f = validator.validate(resource, MustNoneNull.class,Default.class);
		handlerError(f);
	}
	
	/**
	 * 选择性更新   就是空的不更新
	 */
	@Test
	public void updateSelect() {
		
		Resource resource = new Resource(null,"胖哥哥",null);
		Set<ConstraintViolation<Resource>> f = validator.validate(resource);
		handlerError(f);
	}
}
