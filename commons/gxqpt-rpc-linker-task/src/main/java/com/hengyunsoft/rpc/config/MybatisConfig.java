package com.hengyunsoft.rpc.config;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Repository;
import com.alibaba.druid.pool.DruidDataSource;
import com.hengyunsoft.sync.util.DataSourceFactory;

@Configuration
@MapperScan(basePackages= {"com.hengyunsoft"},
			annotationClass=Repository.class,
			sqlSessionFactoryRef = "sqlSessionFactory"
		)
public class MybatisConfig {

//    private static final int TX_METHOD_TIMEOUT = 60;
//    private static final String AOP_POINTCUT_EXPRESSION = "execution (* com.hengyunsoft.platform.*.impl..*.*(..)) " +
//            " execution (*  or execution (* com.hengyunsoft.platform.*.open..*.*(..)) ";
	
	@Bean(initMethod = "init", destroyMethod = "close")
	public DataSource dataSource(DataSourceProperties properties) {
		
		DruidDataSource dataSource = DataSourceFactory.createDataSource(properties);
		dataSource.setDefaultReadOnly(true);
		dataSource.setDefaultAutoCommit(false);
		return dataSource;
	}
	
	@Bean("sqlSessionFactory")
	public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception {
		
		String[] resourceLocationPatterns = {"classpath:mapper/base/*.xml"};
		return DataSourceFactory.createSqlSessionFactoryBean(dataSource, resourceLocationPatterns ).getObject();
	}
	
//    @Bean(name = "tx_admin")
//    public DataSourceTransactionManager rdsTransactionManager(DataSource dataSource) {
//    	
//        return new DataSourceTransactionManager(dataSource);
//    }
    
//    @Bean
//    public TransactionInterceptor txAdvice(@Qualifier("tx_admin") PlatformTransactionManager transactionManager) {
//        NameMatchTransactionAttributeSource source = new NameMatchTransactionAttributeSource();
//        /*只读事务，不做更新操作*/
//        RuleBasedTransactionAttribute readOnlyTx = new RuleBasedTransactionAttribute();
//        readOnlyTx.setReadOnly(true);
//        readOnlyTx.setPropagationBehavior(TransactionDefinition.PROPAGATION_NOT_SUPPORTED);
//        Map<String, TransactionAttribute> txMap = new HashMap<>(11);
//        txMap.put("*", readOnlyTx);
//        source.setNameMap(txMap);
//        TransactionInterceptor txAdvice = new TransactionInterceptor(transactionManager, source);
//        return txAdvice;
//    }

//    @Bean
//    public Advisor txAdviceAdvisor(@Qualifier("tx_admin") PlatformTransactionManager transactionManager) {
//        AspectJExpressionPointcut pointcut = new AspectJExpressionPointcut();
//        pointcut.setExpression(AOP_POINTCUT_EXPRESSION);
//        return new DefaultPointcutAdvisor(pointcut, txAdvice(transactionManager));
//    }
}
