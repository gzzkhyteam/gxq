package com.hengyunsoft.platform.standard.config.datasource;


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
                "com.hengyunsoft.platform.standard.repository",
                "com.hengyunsoft.platform.modular.repository",
        },
        annotationClass = Repository.class,
        sqlSessionFactoryRef = "sqlSessionFactory_standard")
@EnableConfigurationProperties({StandardAutoConfiguration.CenterDataSourceProperties.class})
public class StandardAutoConfiguration extends BaseDbConfiguration {
    private static final String AOP_POINTCUT_EXPRESSION = "execution (* com.hengyunsoft.platform.*.impl..*.*(..)) " +
            " or execution (* com.hengyunsoft.platform.*.open..*.*(..))";

    private final CenterDataSourceProperties dataSourceProperties;

    public StandardAutoConfiguration(CenterDataSourceProperties dataSourceProperties) {
        this.dataSourceProperties = dataSourceProperties;
    }

    @Bean(name = "dataSource_standard", initMethod = "init", destroyMethod = "close")
    @Primary
    public DataSource rdsDataSource() {
        return DataSourceFactory.createDataSource(this.dataSourceProperties);
    }

    @Bean(name = "tx_standard")
    public DataSourceTransactionManager rdsTransactionManager() {
        return new DataSourceTransactionManager(rdsDataSource());
    }

    @Bean(name = "sqlSessionFactory_standard")
    public SqlSessionFactory sqlSessionFactory(@Qualifier("dataSource_standard") DataSource rdsDataSource) throws Exception {
        return DataSourceFactory.createSqlSessionFactoryBean(rdsDataSource, new String[]{
                "classpath:mapper_standard/**/*.xml",
                "classpath:mapper_modular/**/*.xml",
        }).getObject();
    }

    @Bean
    public TransactionInterceptor txAdvice(@Qualifier("tx_standard") PlatformTransactionManager transactionManager) {
        return super.txAdvice(transactionManager);
    }

    @Bean
    public Advisor txAdviceAdvisor(@Qualifier("tx_standard") PlatformTransactionManager transactionManager) {
        AspectJExpressionPointcut pointcut = new AspectJExpressionPointcut();
        pointcut.setExpression(AOP_POINTCUT_EXPRESSION);
        return new DefaultPointcutAdvisor(pointcut, txAdvice(transactionManager));
    }

    @ConfigurationProperties(
            prefix = "gxqpt.mysql.standard"
    )
    static class CenterDataSourceProperties extends DataSourceProperties {

    }
}
