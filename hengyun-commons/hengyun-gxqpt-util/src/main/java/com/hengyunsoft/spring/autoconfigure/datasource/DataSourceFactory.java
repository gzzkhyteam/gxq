package com.hengyunsoft.spring.autoconfigure.datasource;

import com.alibaba.druid.pool.DruidDataSource;
import com.github.pagehelper.PageInterceptor;
import com.hengyunsoft.mybatis.interceptor.DefaultValidatorInterceptor;
import com.hengyunsoft.mybatis.interceptor.PerformanceInterceptor;
import com.hengyunsoft.mybatis.interceptor.QueryFlagInterceptor;
import com.hengyunsoft.mybatis.interceptor.SupportRollback;
import com.hengyunsoft.mybatis.typehandler.FullLikeTypeHandler;
import com.hengyunsoft.mybatis.typehandler.LeftLikeTypeHandler;
import com.hengyunsoft.mybatis.typehandler.RigthLikeTypeHandler;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.type.TypeHandler;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;
import java.util.Objects;
import java.util.Properties;

/**
 * Mysql工厂工具类
 *
 * @author brook
 */
public final class DataSourceFactory {

    private DataSourceFactory() {
    }

    private static String printSql;

    /**
     * 创建 DruidDataSource 实例
     */
    public static DruidDataSource createDataSource(DataSourceProperties properties) {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName(properties.getDriverClassName());
        dataSource.setUrl(properties.getUrl());
        dataSource.setUsername(properties.getUsername());
        dataSource.setPassword(properties.getPassword());
        dataSource.setInitialSize(2);
        dataSource.setMinIdle(2);
        dataSource.setMaxActive(properties.getMaxActive());
        dataSource.setMaxWait(60000);

        dataSource.setTimeBetweenEvictionRunsMillis(3600000);
        dataSource.setMinEvictableIdleTimeMillis(300000);
        // SQL查询,用来验证从连接池取出的连接
        dataSource.setValidationQuery("select current_timestamp()");
        // 指明连接是否被空闲连接回收器(如果有)进行检验，如果检测失败，则连接将被从池中去除
        dataSource.setTestWhileIdle(true);
        // 在空闲连接回收器线程运行期间休眠的时间值,以毫秒为单位，一般比minEvictableIdleTimeMillis小
        dataSource.setTimeBetweenEvictionRunsMillis(300000);
        // 在每次空闲连接回收器线程(如果有)运行时检查的连接数量，最好和maxActive一致
        dataSource.setNumTestsPerEvictionRun(properties.getMaxActive());
        dataSource.setTestOnBorrow(false);
        dataSource.setTestOnReturn(false);
        dataSource.setPoolPreparedStatements(true);
        // 连接池中连接，在时间段内一直空闲，被逐出连接池的时间(1000*60*60)，以毫秒为单位
        dataSource.setMinEvictableIdleTimeMillis(1000 * 60 * 60);
        dataSource.setMaxPoolPreparedStatementPerConnectionSize(20);
        try {
            dataSource.setFilters("config");
        } catch (Exception e) {
            e.printStackTrace();
        }
        dataSource.setConnectionProperties("config.decrypt=true");
        return dataSource;
    }


    /**
     * 根据指定的DataSource创建SqlSessionFactoryBean
     */
    public static SqlSessionFactoryBean createSqlSessionFactoryBean(DataSource rdsDataSource, String[] resourceLocationPatterns, String ignoreBasePackages) throws Exception {
        final SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(rdsDataSource);

        Properties properties = new Properties();
        properties.put("helperDialect", "mysql");
        // 启用合理化时，如果pageNum<1会查询第一页，如果pageNum>pages会查询最后一页； 禁用合理化时，如果pageNum<1或pageNum>pages会返回空数据
        properties.put("reasonable", "true");
        properties.put("pageSizeZero", "false");

//        QueryConvertInterceptor queryConvertInterceptor = new QueryConvertInterceptor();

        QueryFlagInterceptor queryFlagInterceptor = new QueryFlagInterceptor();
        PageInterceptor pi = new PageInterceptor();
        pi.setProperties(properties);

        DefaultValidatorInterceptor validatorInterceptor = new DefaultValidatorInterceptor();

        SupportRollback supportRollback = new SupportRollback();
        Properties supportRollbackProperties = new Properties();
        supportRollbackProperties.put("readOnlyTxRollback", "true");
        supportRollbackProperties.put("noTxRollback", "true");
        if (!StringUtils.isEmpty(ignoreBasePackages)) {
            supportRollbackProperties.put("ignoreBasePackages", ignoreBasePackages);
        }
        supportRollback.setProperties(supportRollbackProperties);

        Interceptor[] i = null;
        if (StringUtils.isNotEmpty(printSql) && "true".equals(printSql)) {
            i = new Interceptor[]{supportRollback, validatorInterceptor, pi, queryFlagInterceptor, new PerformanceInterceptor()};
        } else {
            i = new Interceptor[]{supportRollback, validatorInterceptor, pi, queryFlagInterceptor};
        }

        sessionFactory.setPlugins(i);

        if (!Objects.isNull(resourceLocationPatterns) && resourceLocationPatterns.length > 0) {
            Resource[] all = new Resource[]{};
            PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
            for (String locationPattern : resourceLocationPatterns) {
                all = ArrayUtils.addAll(all, resolver.getResources(locationPattern));
            }
            sessionFactory.setMapperLocations(all);
        }

        addLikeTypeHandler(sessionFactory);
        return sessionFactory;
    }

    /**
     * 将like类型处理器加入到mybatis中
     */
    private static void addLikeTypeHandler(final SqlSessionFactoryBean sessionFactory) {
        TypeHandler<?>[] typeHandlers = new TypeHandler[3];
        typeHandlers[0] = new LeftLikeTypeHandler();
        typeHandlers[1] = new RigthLikeTypeHandler();
        typeHandlers[2] = new FullLikeTypeHandler();
        sessionFactory.setTypeHandlers(typeHandlers);

        Class<?>[] typeAliases = new Class[3];
        typeAliases[0] = LeftLikeTypeHandler.class;
        typeAliases[1] = RigthLikeTypeHandler.class;
        typeAliases[2] = FullLikeTypeHandler.class;
        sessionFactory.setTypeAliases(typeAliases);
    }

    public static SqlSessionFactoryBean createSqlSessionFactoryBean(DataSource rdsDataSource, String[] resourceLocationPatterns) throws Exception {
        return createSqlSessionFactoryBean(rdsDataSource, resourceLocationPatterns, null);
    }

    public static SqlSessionFactoryBean createSqlSessionFactoryBean(DataSource rdsDataSource, String[] resourceLocationPatterns, String ignoreBasePackages, String printSql) throws Exception {
        DataSourceFactory.printSql = printSql;
        return createSqlSessionFactoryBean(rdsDataSource, resourceLocationPatterns, ignoreBasePackages);
    }

}