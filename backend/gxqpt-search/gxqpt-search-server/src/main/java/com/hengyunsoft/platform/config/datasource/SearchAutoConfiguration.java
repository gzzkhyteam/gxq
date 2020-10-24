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
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.interceptor.TransactionInterceptor;

import javax.sql.DataSource;

/**
 * 一体化平台 中心数据库配置
 *
 * @author tyh
 * @createTime 2017-11-18 0:34
 */
@Configuration
@MapperScan(
        basePackages = {
                "com.hengyunsoft.platform.search.repository.core",
        },
        annotationClass=Repository.class,
        sqlSessionFactoryRef = "sqlSessionFactory_search")
@EnableConfigurationProperties({SearchAutoConfiguration.CenterDataSourceProperties.class})
public class SearchAutoConfiguration extends BaseDbConfiguration {
    private static final String AOP_POINTCUT_EXPRESSION = "execution (* com.hengyunsoft.platform.*.impl..*.*(..))";

    private final CenterDataSourceProperties dataSourceProperties;

    public SearchAutoConfiguration(CenterDataSourceProperties dataSourceProperties) {
        this.dataSourceProperties = dataSourceProperties;
    }

    @Bean(name = "dataSource_search", initMethod = "init", destroyMethod = "close")
    public DataSource searchDataSource() {
        return DataSourceFactory.createDataSource(this.dataSourceProperties);
    }

    @Bean(name = "tx_search")
    public DataSourceTransactionManager searchTransactionManager() {
        return new DataSourceTransactionManager(searchDataSource());
    }

    @Bean(name = "sqlSessionFactory_search")
    public SqlSessionFactory sqlSessionFactory(@Qualifier("dataSource_search") DataSource searchDataSource) throws Exception {
        System.out.println("----------------SqlSessionFactory");
        return DataSourceFactory.createSqlSessionFactoryBean(searchDataSource, new String[]{
                "classpath:mapper_search/**/*.xml",
        }) .getObject();
    }

    @Bean
    public TransactionInterceptor txAdvice(@Qualifier("tx_search") PlatformTransactionManager transactionManager) {
        return super.txAdvice(transactionManager);
    }

    @Bean
    public Advisor txAdviceAdvisor(@Qualifier("tx_search") PlatformTransactionManager transactionManager) {
        AspectJExpressionPointcut pointcut = new AspectJExpressionPointcut();
        pointcut.setExpression(AOP_POINTCUT_EXPRESSION);
        return new DefaultPointcutAdvisor(pointcut, txAdvice(transactionManager));
    }

    @ConfigurationProperties(
            prefix = "gxqpt.mysql.search"
    )
    static class CenterDataSourceProperties extends DataSourceProperties {

    }
}
