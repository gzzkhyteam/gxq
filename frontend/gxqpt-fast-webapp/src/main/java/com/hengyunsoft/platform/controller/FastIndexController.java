package com.hengyunsoft.platform.controller;

import com.hengyunsoft.platform.security.LoginInfoUtil;
import com.hengyunsoft.security.auth.dto.UserDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/fast")
public class FastIndexController {
    @RequestMapping("/{appId}")
    public String appList(@PathVariable String appId,
                          String url,
                          ModelMap model, HttpServletRequest request) {
        UserDTO accountDTO = LoginInfoUtil.getLoginUser(request);
        model.put("user", accountDTO);
        model.put("appId", appId);
        model.put("url", url);
        return "fast/index";
    }

    @RequestMapping("/blank")
    public String blank(ModelMap model, HttpServletRequest request) {
        return "fast/blank";
    }
}
