package com.hengyunsoft.platform.controller;

import com.hengyunsoft.platform.security.LoginInfoUtil;
import com.hengyunsoft.security.auth.dto.UserDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("fastApp")
public class FastAppController {

    /**
     * 应用列表
     *
     * @return
     */
    @RequestMapping("/appList")
    public String appList(ModelMap model, HttpServletRequest request) {
        UserDTO accountDTO = LoginInfoUtil.getLoginUser(request);
        model.put("user", accountDTO);
        return "app_list/list";
    }

    /**
     * 创建应用
     *
     * @return
     */
    @RequestMapping("/create")
    public String create(ModelMap model, HttpServletRequest request) {

        return "application/create";
    }

    /**
     * 应用详情
     *
     * @return
     */
    @RequestMapping("/detail")
    public String detail(ModelMap model, HttpServletRequest request) {

        return "application/detail";
    }
}
