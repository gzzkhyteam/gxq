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
import org.springframework.transaction.interceptor.TransactionInterceptor;

import javax.sql.DataSource;

/**
 * 一体化平台 中心数据库配置
 *
 * @author sxy
 * @createTime 2018-11-16
 *
 */
@Configuration
@MapperScan(
        basePackages = {
                "com.hengyunsoft.platform.search.repository.developer",
        },
        annotationClass=Repository.class,
        sqlSessionFactoryRef = "sqlSessionFactory_developer")
@EnableConfigurationProperties({DeveloperAutoConfiguration.CenterDataSourceProperties.class})
public class DeveloperAutoConfiguration extends BaseDbConfiguration {
    private static final String AOP_POINTCUT_EXPRESSION = "execution (* com.hengyunsoft.platform.*.impl..*.*(..))";

    private final CenterDataSourceProperties dataSourceProperties;

    public DeveloperAutoConfiguration(CenterDataSourceProperties dataSourceProperties) {
        this.dataSourceProperties = dataSourceProperties;
    }

    @Bean(name = "dataSource_developer", initMethod = "init", destroyMethod = "close")
    @Primary
    public DataSource developerDataSource() {
        return DataSourceFactory.createDataSource(this.dataSourceProperties);
    }

    @Bean(name = "tx_developer")
    @Primary
    public DataSourceTransactionManager developerTransactionManager() {
        return new DataSourceTransactionManager(developerDataSource());
    }

    @Bean(name = "sqlSessionFactory_developer")
    @Primary
    public SqlSessionFactory sqlSessionFactory(@Qualifier("dataSource_developer") DataSource developerDataSource) throws Exception {
        System.out.println("----------------SqlSessionFactory");
        return DataSourceFactory.createSqlSessionFactoryBean(developerDataSource, new String[]{
                "classpath:mapper_developer/**/*.xml",
        }) .getObject();
    }

    @Bean
    @Primary
    public TransactionInterceptor txAdvice(@Qualifier("tx_developer") PlatformTransactionManager transactionManager) {
        return super.txAdvice(transactionManager);
    }

    @Bean
    @Primary
    public Advisor txAdviceAdvisor(@Qualifier("tx_developer") PlatformTransactionManager transactionManager) {
        AspectJExpressionPointcut pointcut = new AspectJExpressionPointcut();
        pointcut.setExpression(AOP_POINTCUT_EXPRESSION);
        return new DefaultPointcutAdvisor(pointcut, txAdvice(transactionManager));
    }

    @ConfigurationProperties(
            prefix = "gxqpt.mysql.admin"
    )
    static class CenterDataSourceProperties extends DataSourceProperties {

    }
}
