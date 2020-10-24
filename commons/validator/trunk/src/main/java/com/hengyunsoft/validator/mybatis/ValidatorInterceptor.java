package com.hengyunsoft.validator.mybatis;


import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;

import org.apache.ibatis.binding.MapperMethod.ParamMap;
import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Plugin;
import org.apache.ibatis.plugin.Signature;
import org.apache.ibatis.reflection.ParamNameResolver;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;

import com.hengyunsoft.validator.annotation.ValidGroup;

@Intercepts(
	    {
	        @Signature(type = Executor.class, method = "update", args = {MappedStatement.class, Object.class}),
	    }
)
public abstract class ValidatorInterceptor implements Interceptor{
	
	/**
	 * @see ParamNameResolver
	 */
	private static final String GENERIC_NAME_PREFIX = "param";
	@Override
	public Object intercept(Invocation invocation) throws Throwable {
		
		Object[] args = invocation.getArgs();
		
        MappedStatement ms = (MappedStatement) args[0];
        Method method= getMethod(ms.getId());

        Annotation[][] paraAnnotations = method.getParameterAnnotations();
        if(paraAnnotations == null || paraAnnotations.length == 0) {
        	return invocation.proceed();
        }
        final Class<?>[] paramTypes = method.getParameterTypes();

        /////////////////////////参数仅仅有两种类型：  mybatis没有包装的单个java类型       mybatis使用 ParamMap 包装了的类型（具体详情见代码）//////////////////////////////
		//        /**
		//         * <p>
		//         * A single non-special parameter is returned without a name.<br />
		//         * Multiple parameters are named using the naming rule.<br />
		//         * In addition to the default names, this method also adds the generic names (param1, param2,
		//         * ...).
		//         * </p>
		//         */
		//        public Object getNamedParams(Object[] args) {
		//          final int paramCount = names.size();
		//          if (args == null || paramCount == 0) {
		//            return null;
		//          } else if (!hasParamAnnotation && paramCount == 1) {
		//            return args[names.firstKey()];
		//          } else {
		//            final Map<String, Object> param = new ParamMap<Object>();
		//            int i = 0;
		//            for (Map.Entry<Integer, String> entry : names.entrySet()) {
		//              param.put(entry.getValue(), args[entry.getKey()]);
		//              // add generic param names (param1, param2, ...)
		//              final String genericParamName = GENERIC_NAME_PREFIX + String.valueOf(i + 1);
		//              // ensure not to overwrite parameter named with @Param
		//              if (!names.containsValue(genericParamName)) {
		//                param.put(genericParamName, args[entry.getKey()]);
		//              }
		//              i++;
		//            }
		//            return param;
		//          }
		//        }
        Map<String, Object> parameter = null;
        Object parameterObj = args[1];
        
        if(args[1] instanceof ParamMap) {
        	parameter = (Map)args[1];
        } 
        //mybatis包装了参数后放在map，参数的key是字符串：    "param" + 参数在参数列表中的位置。   但是参数位置计算是忽略了特殊参数的。
        //比如：   aMethod(@Param("M") int a, @Param("N") int b) -> a: param1, b:param2
        //     aMethod(int a, int b) -> a: param1,  b:param2
        //     aMethod(int a, RowBounds rb, int b) -> a: param1,  b:param2   注意看：   b的位置提前了，并不是param3
        for (int i = 0,skipspecialParametersIndex = 1; i < paraAnnotations.length; i++) {
        	
        	if (isSpecialParameter(paramTypes[i])) {
                // skip special parameters
        		//特殊类型不会加入到参数列表的   也不再我们的验证范围之内
                continue;
            }
			Annotation[] annotations = paraAnnotations[i];
			if(isEmpty(annotations)) {
				continue ;
			}
			// add generic param names (param1, param2, ...)
	        final String genericParamName = GENERIC_NAME_PREFIX + skipspecialParametersIndex;
	        skipspecialParametersIndex++;
			check(annotations,parameter == null ? parameterObj : parameter.get(genericParamName));
		}
        return invocation.proceed();
	}
	
	private Method getMethod(String id) throws ClassNotFoundException {
		
		int index = id.lastIndexOf('.');
		String interfaceFullName = id.substring(0, index);
		String methodName = id.substring(index+1);
		Class<?> clazz = Class.forName(interfaceFullName);
		Method[] methods = clazz.getMethods();
		for (Method method : methods) {
			if(method.getName().equals(methodName)) {
				return method;
			}
		}
		return null;
	}

	private void check(Annotation[] annotations, Object object) throws Exception {
		
		if(object == null) {
			return ;
		}
		
		for (Annotation annotation : annotations) {
			if(annotation instanceof ValidGroup) {
				Set<ConstraintViolation<Object>> consts = getValidator().validate(object, ((ValidGroup)annotation).value());
				if(consts.size() == 0) {
					continue ;
				}
				errorThrowsException(consts);
			}
		}
	}

	protected abstract void errorThrowsException(Set<ConstraintViolation<Object>> consts) throws Exception;

	private boolean isEmpty(Object[] obj) {
		return obj == null || obj.length == 0;
	}

	@Override
	public Object plugin(Object target) {
		
		return Plugin.wrap(target, this);
	}

	@Override
	public void setProperties(Properties properties) {
		
	}
	
	protected abstract Validator getValidator() ;
	
	private static boolean isSpecialParameter(Class<?> clazz) {
		    return RowBounds.class.isAssignableFrom(clazz) || ResultHandler.class.isAssignableFrom(clazz);
	}
}
