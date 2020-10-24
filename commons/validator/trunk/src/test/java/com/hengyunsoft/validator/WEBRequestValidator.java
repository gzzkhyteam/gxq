package com.hengyunsoft.validator;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.Set;

import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.groups.Default;

import org.hibernate.validator.internal.engine.ValidatorImpl;
import org.hibernate.validator.internal.metadata.BeanMetaDataManager;
import org.hibernate.validator.internal.metadata.aggregated.BeanMetaData;
import org.hibernate.validator.internal.metadata.core.MetaConstraint;
import org.hibernate.validator.internal.metadata.descriptor.ConstraintDescriptorImpl;
import org.hibernate.validator.internal.metadata.location.ConstraintLocation;
import org.hibernate.validator.messageinterpolation.ResourceBundleMessageInterpolator;
import org.hibernate.validator.resourceloading.AggregateResourceBundleLocator;
import org.hibernate.validator.spi.resourceloading.ResourceBundleLocator;
import org.junit.BeforeClass;
import org.junit.Test;

import com.hengyunsoft.validator.ValidatorGroups.MustNoneNull;
import com.hengyunsoft.validator.mateconstraint.IConstraintConverter;
import com.hengyunsoft.validator.mateconstraint.impl.NotNullConstraintConverter;
import com.hengyunsoft.validator.mateconstraint.impl.RangeConstraintConverter;

public class WEBRequestValidator {

    private static Validator validator;
    private static BeanMetaDataManager beanMetaDataManager;
    private static List<IConstraintConverter> constraintConverters;

    @BeforeClass
    public static void setUpValidator() throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
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
    	Field beanMetaDataManagerField = ValidatorImpl.class.getDeclaredField("beanMetaDataManager");
    	beanMetaDataManagerField.setAccessible(true);
    	beanMetaDataManager = (BeanMetaDataManager) beanMetaDataManagerField.get(validator);
    	constraintConverters = new ArrayList<>();
    	constraintConverters.add(new RangeConstraintConverter());
    	constraintConverters.add(new NotNullConstraintConverter());
    }
    
    
    @Test
    public void validatorStandard() throws Exception {
    	
    	Class<?> clazz = Resource.class;
    	Class<?>[] groups = {Default.class,MustNoneNull.class};
    	

    	Map<String,FieldValidatorDesc> fieldValidatorDescs = new HashMap();
    	BeanMetaData<?> res = beanMetaDataManager.getBeanMetaData(clazz);
    	Set<MetaConstraint<?>> r = res.getMetaConstraints();
    	for (MetaConstraint<?> metaConstraint : r) {
    		builderFieldValidatorDesc(metaConstraint,groups,fieldValidatorDescs);
		}
    	System.out.println(fieldValidatorDescs);
    }

	private void builderFieldValidatorDesc(MetaConstraint<?> metaConstraint, Class<?>[] groups,
			Map<String, FieldValidatorDesc> fieldValidatorDescs) throws Exception {

		Set<Class<?>> groupsMeta = metaConstraint.getGroupList();
		boolean isContainsGroup = false;
		for (Class<?> group : groups) {
			if(groupsMeta.contains(group)) {
				isContainsGroup = true;
				break;
			}
		}
		if(!isContainsGroup) {
			return ;
		}
		
		ConstraintDescriptorImpl<?> obj = metaConstraint.getDescriptor();
		
		ConstraintLocation con = metaConstraint.getLocation();
		String domainName = con.getDeclaringClass().getSimpleName().toLowerCase();
		String fieldName = con.getMember().getName();
		String key = domainName+fieldName;
		FieldValidatorDesc desc = fieldValidatorDescs.get(domainName+fieldName);
		if(desc == null) {
			desc = new FieldValidatorDesc();
			desc.setDomainName(domainName);
			desc.setFieldName(fieldName);
			desc.setConstraints(new ArrayList<>(5));
			fieldValidatorDescs.put(key, desc);
		} 
		ConstraintInfo constraint = builderConstraint(metaConstraint.getDescriptor().getAnnotation());
		desc.getConstraints().add(constraint);
	}


	private ConstraintInfo builderConstraint(Annotation annotation) throws Exception {

		for (IConstraintConverter constraintConverter : constraintConverters) {
			if(constraintConverter.suport(annotation.annotationType())) {
				return constraintConverter.converter(annotation);
			}
		}
		return null;
	}
}
