package com.hengyunsoft.commons.adapter;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.StringJoiner;
import java.util.TimeZone;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import com.google.common.collect.Maps;
import com.hengyunsoft.commons.converter.String2DateConverter;
import com.hengyunsoft.commons.converter.XssStringJsonSerializer;
import com.hengyunsoft.commons.feign.DateFormatRegister;
import com.hengyunsoft.commons.filter.XssFilter;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.core.convert.converter.Converter;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;

public abstract class BaseConfig {

    /**
     * json 类型参数 序列化问题
     * Long -> string
     * date -> string
     *
     * @param builder
     * @return
     */
    @Bean
    @Primary
    @ConditionalOnMissingBean
    public ObjectMapper jacksonObjectMapper(Jackson2ObjectMapperBuilder builder) {
        ObjectMapper objectMapper = builder.createXmlMapper(false)
                .featuresToDisable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS)
                .timeZone(TimeZone.getTimeZone("Asia/Shanghai"))
                .build();
        //objectMapper.setSerializationInclusion(JsonInclude.Include.NON_EMPTY);//排除空字段  : 不能排除，否则前端不能显示null字段，不友好
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);//忽略未知字段
        SimpleDateFormat outputFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//日期格式
        objectMapper.setDateFormat(outputFormat);
        SimpleModule simpleModule = new SimpleModule();
        /**
         *  将Long,BigInteger序列化的时候,转化为String
         */
        simpleModule.addSerializer(Long.class, ToStringSerializer.instance);
        simpleModule.addSerializer(Long.TYPE, ToStringSerializer.instance);
        simpleModule.addSerializer(BigInteger.class, ToStringSerializer.instance);

        //在进出前后台的时候，设置BigDecimal和字符串之间转换
        simpleModule.addSerializer(BigDecimal.class, ToStringSerializer.instance);

        simpleModule.addSerializer(new XssStringJsonSerializer());
        objectMapper.registerModule(simpleModule);

        return objectMapper;
    }

    /**
     * date 类型参数 格式问题
     *
     * @return
     */
    @Bean
    public Converter<String, Date> addNewConvert() {
        return new String2DateConverter();
    }

    /**
     * 在feign调用方配置， 解决入参和出参是 date 类型
     *
     * @return
     */
    @Bean
    public DateFormatRegister dateFormatRegister() {
        return new DateFormatRegister();
    }

    /**
     * 配置跨站攻击过滤器
     *
     * @return
     */
    @Bean
    public FilterRegistrationBean filterRegistrationBean() {

        FilterRegistrationBean filterRegistration = new FilterRegistrationBean(new XssFilter());
        filterRegistration.addUrlPatterns("/*");
        filterRegistration.setOrder(1);

        Map<String, String> initParameters = Maps.newHashMap();
        String excludes = new StringJoiner(",")
                .add("/favicon.ico")
                .add("/doc.html")
                .add("/swagger-ui.html")
                .add("/csrf")
                .add("/webjars/*")
                .add("/v2/*")
                .add("/swagger-resources/*")
                .add("/resources/*")
                .add("/static/*")
                .add("/public/*")
                .add("/classpath:*")
                .add("/actuator/*")
                .add("/mgmt/*")
                .toString();
        initParameters.put("excludes", excludes);
        initParameters.put("isIncludeRichText", "true");
        initParameters.put("ignoreParamValue", "@gygxq.com");
        filterRegistration.setInitParameters(initParameters);

        return filterRegistration;
    }

}
