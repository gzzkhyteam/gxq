package com.hengyunsoft.platform.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("module")
public class ModuleController {
    /**
     * 所有系统的首页地址统一放在module/index
     *
     * @return
     */
    @RequestMapping("/index")
    public String index(ModelMap model, HttpServletRequest request) {
        return "module/index";
    }
    /*首页*/
    @RequestMapping("/home")
    public String home(ModelMap model, HttpServletRequest request) {
        return "module/home";
    }
    /*仪表盘*/
    @RequestMapping("/dashboard")
    public String dashboard(ModelMap model, HttpServletRequest request) {
        return "module/dashboard";
    }

}
