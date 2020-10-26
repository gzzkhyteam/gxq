package com.hengyunsoft.spring.autoconfigure.datasource;


import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.slf4j.Logger;
import org.springframework.aop.Advisor;
import org.springframework.aop.ClassFilter;
import org.springframework.aop.MethodMatcher;
import org.springframework.aop.Pointcut;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.interceptor.NameMatchTransactionAttributeSource;
import org.springframework.transaction.interceptor.RollbackRuleAttribute;
import org.springframework.transaction.interceptor.RuleBasedTransactionAttribute;
import org.springframework.transaction.interceptor.TransactionAttribute;
import org.springframework.transaction.interceptor.TransactionAttributeSource;
import org.springframework.transaction.interceptor.TransactionInterceptor;
import org.springframework.web.bind.annotation.RestController;

/**
 * This is a Description
 *
 * @author tangyh
 * @date 2018/10/24
 */
public abstract class BaseDbConfiguration {

    protected static final int TX_METHOD_TIMEOUT = 60;

    //需要开启事务的类注解集合。   基于类中的注解去判断是否需要在此类中启动事务。
    private static final List<Class<? extends Annotation>> AOP_POINTCUT_ANNOTATIONS = new ArrayList<>(2);
    private static final String TX_BASE_PACKAGE = "com.hengyunsoft.platform";
    
    static {
    	//事务在controller层开启。
    	AOP_POINTCUT_ANNOTATIONS.add(RestController.class);
    	AOP_POINTCUT_ANNOTATIONS.add(Controller.class);
    }
    
    protected TransactionInterceptor txAdvice(PlatformTransactionManager transactionManager) {

    	TransactionInterceptor txAdvice = new TransactionInterceptor(transactionManager, transactionAttributeSource());
        return txAdvice;
    }
    


	private TransactionAttributeSource transactionAttributeSource() {
		/*当前存在事务就使用当前事务，当前不存在事务就创建一个新的事务*/
        RuleBasedTransactionAttribute requiredTx = new RuleBasedTransactionAttribute();
        requiredTx.setRollbackRules( Collections.singletonList(new RollbackRuleAttribute(Throwable.class)));
        requiredTx.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);
        requiredTx.setTimeout(TX_METHOD_TIMEOUT);
        Map<String, TransactionAttribute> txMap = new HashMap<>(32);
        txMap.put("add*", requiredTx);
        txMap.put("save*", requiredTx);
        txMap.put("insert*", requiredTx);
        txMap.put("create*", requiredTx);
        txMap.put("update*", requiredTx);
        txMap.put("edit*", requiredTx);
        txMap.put("upload*", requiredTx);
        txMap.put("delete*", requiredTx);
        txMap.put("remove*", requiredTx);
        txMap.put("clean*", requiredTx);
        txMap.put("recycle*", requiredTx);
        txMap.put("batch*", requiredTx);
        txMap.put("disable*", requiredTx);
        txMap.put("enable*", requiredTx);
        txMap.put("handle*", requiredTx);
        txMap.put("syn*", requiredTx);
        txMap.put("reg*", requiredTx);
        txMap.put("*_TX", requiredTx);
        
        RuleBasedTransactionAttribute readOnlyTx = new RuleBasedTransactionAttribute();
        readOnlyTx.setReadOnly(true);
        readOnlyTx.setPropagationBehavior(TransactionDefinition.PROPAGATION_SUPPORTS);
        //除了上面的事物以外，都走只读事物
        txMap.put("*", readOnlyTx);
        NameMatchTransactionAttributeSource txTransactionAttributeSource = new NameMatchTransactionAttributeSource();
        txTransactionAttributeSource.setNameMap(txMap);
        return txTransactionAttributeSource;
	}
	
    private ClassFilter builderClassFilter() {
    	
    	
    	return new ClassFilter() {
    		
    		Logger log = getLog();
    		
			@Override
			public boolean matches(Class<?> clazz) {
				
				if(!clazz.getName().startsWith(TX_BASE_PACKAGE)) {
					return false;
				}
				for (Class<? extends Annotation> aop : AOP_POINTCUT_ANNOTATIONS) {
					if(clazz.getAnnotation(aop) != null) {
						if(log !=null ) {
							log.warn("允许带事务的类为：" + clazz);
						}
						return true;
					}
				}
				return false;
			}
		};
    }
    
    public Advisor txAdviceAdvisor(PlatformTransactionManager transactionManager) {
    	
        return new DefaultPointcutAdvisor(new Pointcut( ) {
			
        	private final ClassFilter filter = builderClassFilter();
        	
			@Override
			public MethodMatcher getMethodMatcher() {
				
				return MethodMatcher.TRUE;
			}
			
			@Override
			public ClassFilter getClassFilter() {
				return filter;
			}
		}, txAdvice(transactionManager));
    }
    
    protected Logger getLog() {
    	return null;
    }
}
