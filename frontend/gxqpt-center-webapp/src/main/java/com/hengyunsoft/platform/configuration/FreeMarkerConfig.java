package com.hengyunsoft.platform.configuration;

import java.util.Locale;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

/**
 * This is a Description
 *
 * @author tangyh
 * @date 2019/07/08
 */
@Configuration
public class FreeMarkerConfig {

    @Autowired(required = false)
    private freemarker.template.Configuration configuration;

    @PostConstruct
    public void setSharedVariable() {
        // 数据转义
        configuration.setTemplateLoader(new HtmlTemplateLoader(configuration.getTemplateLoader()));
        // 基本设置
        configuration.setDateTimeFormat("yyyy-MM-dd HH:mm:ss");
        configuration.setLocale(new Locale("zh_CN"));
    }

}
