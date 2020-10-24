package com.hengyunsoft.platform.context;

import com.hengyunsoft.platform.configuration.GlobalVariableProperties;
import com.hengyunsoft.platform.configuration.GxqptWebappConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import org.springframework.web.context.ServletContextAware;

import javax.servlet.ServletContext;
import java.util.Map;

@Component
@Lazy(false)
public class SharedRenderVariableContext implements ServletContextAware {

    @Autowired
    private GlobalVariableProperties globalVariableProperties;
    @Autowired
    private GxqptWebappConfig gxqptWebappConfig;


    /**
     * 全局变量    将会存储在web容器中且需要追加项目名称。
     *
     * @see ServletContext#setAttribute(String, Object)
     */
    private Map<String, String> argsNeedProjectName;
    /**
     * 全局变量    将会存储在web容器中且不需要追加项目名称。
     *
     * @see ServletContext#setAttribute(String, Object)
     */
    private Map<String, String> argsNotNeedProjectName;

    public void setArgsNeedProjectName(Map<String, String> argsNeedProjectName) {
        this.argsNeedProjectName = argsNeedProjectName;
    }

    public void setArgsNotNeedProjectName(Map<String, String> argsNotNeedProjectName) {
        this.argsNotNeedProjectName = argsNotNeedProjectName;
    }

    @Override
    public void setServletContext(ServletContext servletContext) {
        String projectName = servletContext.getContextPath();
        if (!"/".equals(projectName)) {
            projectName += "/";
        }
        String staticsPath = projectName + "static";
        String projectNameNotSuffix = projectName.substring(0, projectName.length() - 1);
        servletContext.setAttribute("_gate_url", globalVariableProperties.getGateUrl());
        servletContext.setAttribute("_logout_url", gxqptWebappConfig.getLogoutUrl());
        servletContext.setAttribute("_loginUrl", gxqptWebappConfig.getLoginUrl());
        servletContext.setAttribute("_app_id", gxqptWebappConfig.getAppId());
        servletContext.setAttribute("_cp", projectNameNotSuffix);
        servletContext.setAttribute("_static", staticsPath);
        servletContext.setAttribute("_css", staticsPath + "/css");
        servletContext.setAttribute("_images", staticsPath + "/images");
        servletContext.setAttribute("_js", staticsPath + "/js");
        servletContext.setAttribute("_lib", staticsPath + "/js/lib");
        //servletContext.setAttribute("_token", LoginInfoUtil.loginInfo().getToken());
        if (!CollectionUtils.isEmpty(argsNeedProjectName)) {
            for (Map.Entry<String, String> entry : argsNeedProjectName.entrySet()) {
                String val = entry.getValue();
                if (val.indexOf('/') == 0) {
                    servletContext.setAttribute(entry.getKey(), projectNameNotSuffix + val);
                } else {
                    servletContext.setAttribute(entry.getKey(), projectName + val);
                }
            }
        }
        if (!CollectionUtils.isEmpty(argsNotNeedProjectName)) {
            for (Map.Entry<String, String> entry : argsNotNeedProjectName.entrySet()) {
                servletContext.setAttribute(entry.getKey(), entry.getValue());
            }
        }
    }
}
