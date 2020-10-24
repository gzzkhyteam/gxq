package com.hengyunsoft.security.gete.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hengyunsoft.security.gete.utils.StringParamSecurityUtil;

@Controller
public class CustomSwaggerController {
    @RequestMapping("doc")
    public String swagger(String url, ModelMap model) {
    	url = StringParamSecurityUtil.convert(url);
    	
        model.put("url", url.replaceAll("script", "").replace('<', ' ').replace('>', ' '));
        return "swagger-ui";
    }
}
