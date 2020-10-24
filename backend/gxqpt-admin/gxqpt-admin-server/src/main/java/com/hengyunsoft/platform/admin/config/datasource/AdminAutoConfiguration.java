package com.hengyunsoft.platform.admin.config.datasource;


import javax.sql.DataSource;

import com.hengyunsoft.spring.autoconfigure.datasource.BaseDbConfiguration;
import com.hengyunsoft.spring.autoconfigure.datasource.DataSourceFactory;
import com.hengyunsoft.spring.autoconfigure.datasource.DataSourceProperties;

import lombok.extern.slf4j.Slf4j;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.springframework.aop.Advisor;
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

/**
 * 一体化平台 中心数据库配置
 *
 * @author tyh
 * @createTime 2017-11-18 0:34
 */
@Configuration
//@EnableCaching
@Slf4j
@MapperScan(
        basePackages = {"com.hengyunsoft.platform"},
        annotationClass = Repository.class,
        sqlSessionFactoryRef = "sqlSessionFactory_admin")
@EnableConfigurationProperties({AdminAutoConfiguration.CenterDataSourceProperties.class})
public class AdminAutoConfiguration extends BaseDbConfiguration {
    

    private final CenterDataSourceProperties dataSourceProperties;

    public AdminAutoConfiguration(CenterDataSourceProperties dataSourceProperties) {
        this.dataSourceProperties = dataSourceProperties;
    }

    @Bean(name = "dataSource_admin", initMethod = "init", destroyMethod = "close")
    @Primary
    public DataSource rdsDataSource() {
        return DataSourceFactory.createDataSource(this.dataSourceProperties);
    }

    @Bean(name = "tx_admin")
    public DataSourceTransactionManager rdsTransactionManager() {
        return new DataSourceTransactionManager(rdsDataSource());
    }

    @Bean(name = "sqlSessionFactory_admin")
    public SqlSessionFactory sqlSessionFactory(@Qualifier("dataSource_admin") DataSource rdsDataSource) throws Exception {
        System.out.println("----------------SqlSessionFactory");
        return DataSourceFactory.createSqlSessionFactoryBean(rdsDataSource, new String[]{"classpath:mapper_admin/**/*.xml", "classpath:mapper_developer/**/*.xml"})
                .getObject();
    }

    @Bean
    public TransactionInterceptor txAdvice(@Qualifier("tx_admin") PlatformTransactionManager transactionManager) {
        return super.txAdvice(transactionManager);
    }

    @Bean
    public Advisor txAdviceAdvisor(@Qualifier("tx_admin") PlatformTransactionManager transactionManager) {
    	return super.txAdviceAdvisor(transactionManager);
    }

    @ConfigurationProperties(
            prefix = "gxqpt.mysql.admin"
    )
    static class CenterDataSourceProperties extends DataSourceProperties {

    }
    
    @Override
    protected Logger getLog() {
    	return log;
    }
}
