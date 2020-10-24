package com.hengyunsoft.validator.extract;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.validation.Validator;

import org.hibernate.validator.internal.engine.ValidatorImpl;
import org.hibernate.validator.internal.metadata.BeanMetaDataManager;
import org.hibernate.validator.internal.metadata.aggregated.BeanMetaData;
import org.hibernate.validator.internal.metadata.core.MetaConstraint;
import org.hibernate.validator.internal.metadata.location.ConstraintLocation;

import com.hengyunsoft.validator.ConstraintInfo;
import com.hengyunsoft.validator.FieldValidatorDesc;
import com.hengyunsoft.validator.annotation.Constraint;
import com.hengyunsoft.validator.mateconstraint.IConstraintConverter;
import com.hengyunsoft.validator.mateconstraint.impl.NotNullConstraintConverter;
import com.hengyunsoft.validator.mateconstraint.impl.RangeConstraintConverter;

public class DefaultConstraintExtractImpl implements IConstraintExtract {

	
	private  Validator validator;
    private  BeanMetaDataManager beanMetaDataManager;
    private  List<IConstraintConverter> constraintConverters;

    public DefaultConstraintExtractImpl(Validator validator) throws Exception {
    	this.validator = validator;
    	init();
	}
    
    public  void init() throws Exception {

    	Field beanMetaDataManagerField = ValidatorImpl.class.getDeclaredField("beanMetaDataManager");
    	beanMetaDataManagerField.setAccessible(true);
    	beanMetaDataManager = (BeanMetaDataManager) beanMetaDataManagerField.get(validator);
    	constraintConverters = new ArrayList<>();
    	constraintConverters.add(new RangeConstraintConverter());
    	constraintConverters.add(new NotNullConstraintConverter());
    }
	
	
	@Override
	public Collection<FieldValidatorDesc> extract(Constraint[] constraints) throws Exception {
		
    	if(constraints == null || constraints.length == 0) {
    		return Collections.EMPTY_LIST;
    	}
    	Map<String,FieldValidatorDesc> fieldValidatorDescs = new HashMap();
		for (Constraint constraint : constraints) {
			doExtract(constraint,fieldValidatorDescs);
		}
		
		return fieldValidatorDescs.values();
	}
	
	private void doExtract(Constraint constraint, Map<String, FieldValidatorDesc> fieldValidatorDescs) throws Exception {
		
		Class<?> targetClazz = constraint.value();
		Class<?>[] groups = constraint.groups();
		
    	BeanMetaData<?> res = beanMetaDataManager.getBeanMetaData(targetClazz);
    	Set<MetaConstraint<?>> r = res.getMetaConstraints();
    	for (MetaConstraint<?> metaConstraint : r) {
    		builderFieldValidatorDesc(metaConstraint,groups,fieldValidatorDescs);
		}
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
		
		ConstraintLocation con = metaConstraint.getLocation();
		String domainName = con.getDeclaringClass().getSimpleName().toLowerCase();
		String fieldName = con.getMember().getName();
		String key = domainName+fieldName;
		FieldValidatorDesc desc = fieldValidatorDescs.get(domainName+fieldName);
		if(desc == null) {
			desc = new FieldValidatorDesc();
			desc.setDomainName(domainName);
			desc.setFieldName(fieldName);
			desc.setFieldType(getType(((Field)con.getMember()).getType()));
			desc.setConstraints(new ArrayList<ConstraintInfo>(5));
			fieldValidatorDescs.put(key, desc);
		} 
		ConstraintInfo constraint = builderConstraint(metaConstraint.getDescriptor().getAnnotation());
		desc.getConstraints().add(constraint);
	}


	private String getType(Class<?> declaringClass) {
		
		if(Double.class.isAssignableFrom(declaringClass) || Float.class.isAssignableFrom(declaringClass)) {
			return "double";
		}
		if(Number.class.isAssignableFrom(declaringClass)) {
			return "int";
		}
		if(Date.class.isAssignableFrom(declaringClass)) {
			return "date";
		}
		if(CharSequence.class.isAssignableFrom(declaringClass)) {
			return "string";
		}
		return declaringClass.getSimpleName().toLowerCase();
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
