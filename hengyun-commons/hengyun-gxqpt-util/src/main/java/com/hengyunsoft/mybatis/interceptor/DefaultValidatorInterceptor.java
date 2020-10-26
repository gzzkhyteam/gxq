package com.hengyunsoft.mybatis.interceptor;

import java.lang.reflect.Field;
import java.util.Iterator;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;

import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Signature;

import com.hengyunsoft.exception.CommonException;
import com.hengyunsoft.utils.SpringUtil;
import com.hengyunsoft.validator.annotation.FieldDesc;
import com.hengyunsoft.validator.mybatis.ValidatorInterceptor;
@Intercepts(
	    {
	        @Signature(type = Executor.class, method = "update", args = {MappedStatement.class, Object.class}),
	    }
)
public class DefaultValidatorInterceptor extends ValidatorInterceptor {

	@Override
	protected void errorThrowsException(Set<ConstraintViolation<Object>> consts) throws Exception {

		Iterator<ConstraintViolation<Object>> con = consts.iterator();
		StringBuilder errMsg = new StringBuilder(); 
		
		while (con.hasNext()) {
			ConstraintViolation<Object> constraintViolation = (ConstraintViolation<Object>) con.next();
			try {
				Class clazz = constraintViolation.getRootBeanClass();
				Field field = clazz.getDeclaredField(constraintViolation.getPropertyPath().toString());
				FieldDesc fieldDesc = field.getAnnotation(FieldDesc.class);
				if(fieldDesc != null) {
					errMsg.append(fieldDesc.value());
				}
			} catch (Exception e) {
				e.printStackTrace();
			} 
			errMsg.append(constraintViolation.getMessage());
			errMsg.append("; ");
		};
		throw new CommonException(-1, errMsg.toString());
	}

	@Override
	protected Validator getValidator() {
		
		return validator == null? (validator = SpringUtil.getBeansOfType(Validator.class).values().iterator().next()) : validator ;
	}
	
	private Validator validator;

}
