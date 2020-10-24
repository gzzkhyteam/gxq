package com.hengyunsoft.platform.config.datasource;


import com.hengyunsoft.spring.autoconfigure.datasource.BaseDbConfiguration;
import com.hengyunsoft.spring.autoconfigure.datasource.DataSourceFactory;
import com.hengyunsoft.spring.autoconfigure.datasource.DataSourceProperties;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.aop.Advisor;
import org.springframework.aop.aspectj.AspectJExpressionPointcut;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.interceptor.NameMatchTransactionAttributeSource;
import org.springframework.transaction.interceptor.RollbackRuleAttribute;
import org.springframework.transaction.interceptor.RuleBasedTransactionAttribute;
import org.springframework.transaction.interceptor.TransactionAttribute;
import org.springframework.transaction.interceptor.TransactionInterceptor;

import javax.sql.DataSource;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * 一体化平台 中心数据库配置
 *
 * @author tyh
 * @createTime 2017-11-18 0:34
 */
@Configuration
//@EnableCaching
@MapperScan(
        basePackages = {
                "com.hengyunsoft.platform.mt.repository",
                "com.hengyunsoft.platform.security.repository",
                "com.hengyunsoft.platform.hardware.repository",
                "com.hengyunsoft.platform.ops.repository",
        },
        annotationClass=Repository.class,
        sqlSessionFactoryRef = "sqlSessionFactory_mt")
@EnableConfigurationProperties({DbAutoConfiguration.CenterDataSourceProperties.class})
public class DbAutoConfiguration extends BaseDbConfiguration {
    private static final String AOP_POINTCUT_EXPRESSION = "execution " +
            "(* com.hengyunsoft.platform.*.impl..*.*(..)) " +
            "or execution (* com.hengyunsoft.platform.jobs..*.*(..)) " +
            "or execution (* com.hengyunsoft.platform.queue..*.*(..)) ";

    private final CenterDataSourceProperties dataSourceProperties;

    public DbAutoConfiguration(CenterDataSourceProperties dataSourceProperties) {
        this.dataSourceProperties = dataSourceProperties;
    }

    @Bean(name = "dataSource_mt", initMethod = "init", destroyMethod = "close")
    @Primary
    public DataSource rdsDataSource() {
        return DataSourceFactory.createDataSource(this.dataSourceProperties);
    }

    @Bean(name = "tx_mt")
    public DataSourceTransactionManager rdsTransactionManager() {
        return new DataSourceTransactionManager(rdsDataSource());
    }

    @Bean(name = "sqlSessionFactory_mt")
    public SqlSessionFactory sqlSessionFactory(@Qualifier("dataSource_mt") DataSource rdsDataSource) throws Exception {
        return DataSourceFactory.createSqlSessionFactoryBean(rdsDataSource, new String[]{
                "classpath:mapper_mt/**/*.xml",
                "classpath:mapper_security/**/*.xml",
                "classpath:mapper_hardware/**/*.xml",
                "classpath:mapper_ops/**/*.xml",
        }) .getObject();
    }

    @Bean
    public TransactionInterceptor txAdvice(@Qualifier("tx_mt") PlatformTransactionManager transactionManager) {
        return super.txAdvice(transactionManager);
    }

    @Bean
    public Advisor txAdviceAdvisor(@Qualifier("tx_mt") PlatformTransactionManager transactionManager) {
        AspectJExpressionPointcut pointcut = new AspectJExpressionPointcut();
        pointcut.setExpression(AOP_POINTCUT_EXPRESSION);
        return new DefaultPointcutAdvisor(pointcut, txAdvice(transactionManager));
    }

    @ConfigurationProperties(
            prefix = "gxqpt.mysql.mt"
    )
    static class CenterDataSourceProperties extends DataSourceProperties {

    }
}
