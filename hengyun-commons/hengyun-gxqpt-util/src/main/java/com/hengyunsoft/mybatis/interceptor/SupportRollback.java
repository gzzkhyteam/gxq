package com.hengyunsoft.mybatis.interceptor;

import java.util.Properties;

import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Plugin;
import org.apache.ibatis.plugin.Signature;
import org.springframework.transaction.NoTransactionException;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.interceptor.TransactionInterceptor;
import org.springframework.transaction.support.DefaultTransactionStatus;

import com.hengyunsoft.exception.BizException;
import com.hengyunsoft.mybatis.annotation.IgnoreTx;

@Intercepts(
	    {
	        @Signature(type = Executor.class, method = "update", args = {MappedStatement.class,Object.class}),
	    }
)
public class SupportRollback implements Interceptor {

	private String[] ignoreBasePackages = {};
	
	public final static String IGNORE_BASE_PACKAGE_SEPARATOR = ",";
	
	/**
	 * 只读事物默认执行写操作的情况下需要报错   
	 */
	private boolean readOnlyTxRollback = true;
	/**
	 * 在没有事物的情况写默认是报错
	 */
	private boolean noTxRollback = true;
	
	private boolean enable = false;
	@Override
	public Object intercept(Invocation invocation) throws Throwable {
		
		if(!enable) {
			return invocation.proceed();
		}
		
		if(!isIgnore()) {
		
			checkTx(invocation);
		}
		return invocation.proceed();
	}

	public void checkTx(Invocation invocation) {
		TransactionStatus transactionStatus = null;
		try {
			transactionStatus = TransactionInterceptor.currentTransactionStatus();
			
		} catch (NoTransactionException e) {
			
			if(noTxRollback) {
				//在没有事物的写操作中，若配置了参数noTxRollback为true，那么将会执行报错。
				throw new BizException(-1, "未开启事物，不允许执行update操作");
			}
			return ;
		}
		
		if(transactionStatus instanceof DefaultTransactionStatus) {
			DefaultTransactionStatus def = (DefaultTransactionStatus) transactionStatus;
			
			if(def.isReadOnly() && readOnlyTxRollback) {
				//在有事物的写操作中，在事物是只读的，且配置了参数readOnlyTxRollback为true，那么将会执行报错。
				throw new BizException(-1, "只读事物，不允许执行update操作");
			}
		}
	}

	public boolean isIgnore() {
		
		StackTraceElement[] stacks = new RuntimeException().getStackTrace();
		Class<?> clazz = null;
		for (StackTraceElement stackTraceElement : stacks) {
			try {
				clazz = Class.forName(stackTraceElement.getClassName());
			} catch (ClassNotFoundException e) {
				continue ;
			}
			if(clazz.getAnnotation(IgnoreTx.class) != null) {
				return true;
			};
		}
			
		if(ignoreBasePackages.length > 0) {
			String clazzName = null;
			for (StackTraceElement stackTraceElement : stacks) {
				clazzName = stackTraceElement.getClassName();
				for (String ignoreBasePackage : ignoreBasePackages) {
					if(clazzName.indexOf(ignoreBasePackage) >= 0) {
						return true;
					}
				}
			}
		}
		return false;
	}

	@Override
	public Object plugin(Object target) {
		return Plugin.wrap(target, this);
	}

	@Override
	public void setProperties(Properties properties) {

		if(properties != null) {
			
			String readOnlyTxRollbackStr = properties.getProperty("readOnlyTxRollback");
			if(readOnlyTxRollbackStr != null) {
				readOnlyTxRollback = Boolean.parseBoolean(readOnlyTxRollbackStr);
			}
			String noTxRollbackStr = properties.getProperty("noTxRollback");
			
			if(noTxRollbackStr != null) {
				noTxRollback = Boolean.parseBoolean(noTxRollbackStr);
			}
			
			String ignoreBasePackagesStr = properties.getProperty("ignoreBasePackages");
			if(ignoreBasePackagesStr != null) {
				ignoreBasePackages = ignoreBasePackagesStr.split(IGNORE_BASE_PACKAGE_SEPARATOR);
			} 
		}
	}

}
