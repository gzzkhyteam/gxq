package com.hengyunsoft.platform.config.datasource;


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
		basePackages= {"com.hengyunsoft.platform.search.repository.exchange"},
        annotationClass=Repository.class,
        sqlSessionFactoryRef = "sqlSessionFactory_exchange")
@EnableConfigurationProperties({ExchangeAutoConfiguration.CenterDataSourceProperties.class})
@Slf4j
public class ExchangeAutoConfiguration extends BaseDbConfiguration {

    private final CenterDataSourceProperties dataSourceProperties;

    public ExchangeAutoConfiguration(CenterDataSourceProperties dataSourceProperties) {
        this.dataSourceProperties = dataSourceProperties;
    }

    @Bean(name = "dataSource_exchange", initMethod = "init", destroyMethod = "close")
    public DataSource exchangeDataSource() {
        log.info("url={}, username={}, pass={}", dataSourceProperties.getUrl(), dataSourceProperties.getUsername(),
                dataSourceProperties.getPassword());
        return DataSourceFactory.createDataSource(this.dataSourceProperties);
    }

    @Bean(name = "tx_exchange")
    public DataSourceTransactionManager exchangeTransactionManager() {
        return new DataSourceTransactionManager(exchangeDataSource());
    }

    @Bean(name = "sqlSessionFactory_exchange")
    public SqlSessionFactory sqlSessionFactory(@Qualifier("dataSource_exchange") DataSource exchangeDataSource) throws Exception {
        log.info("----------------SqlSessionFactory");
        return DataSourceFactory.createSqlSessionFactoryBean(exchangeDataSource, new String[]{"classpath:mapper_exchange/**/*.xml"})
                .getObject();
    }

    @Bean
    public TransactionInterceptor txAdvice(@Qualifier("tx_exchange") PlatformTransactionManager transactionManager) {
        return super.txAdvice(transactionManager);
    }

    @Bean
    public Advisor txAdviceAdvisor(@Qualifier("tx_exchange") PlatformTransactionManager transactionManager) {

    	return super.txAdviceAdvisor(transactionManager);
    }

    @ConfigurationProperties(
            prefix = "gxqpt.mysql.exchange"
    )
    static class CenterDataSourceProperties extends DataSourceProperties {

    }

    @Override
    protected Logger getLog() {

    	return log;
    }
}
