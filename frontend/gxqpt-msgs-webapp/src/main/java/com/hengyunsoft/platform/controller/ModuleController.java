package com.hengyunsoft.platform.controller;

import com.hengyunsoft.platform.security.LoginInfoUtil;
import com.hengyunsoft.security.auth.dto.UserDTO;
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
        UserDTO accountDTO = LoginInfoUtil.getLoginUser(request);
        model.put("user", accountDTO);
        return "module/index";
    }

    /**
     * 系统首页
     *
     * @return
     */
    @RequestMapping("/home")
    public String home(ModelMap model, HttpServletRequest request) {
        UserDTO accountDTO = LoginInfoUtil.getLoginUser(request);
        model.put("user", accountDTO);
        return "module/home";
    }
    /**
     * 统计分析-渠道信息对比
     *
     * @return
     */
    @RequestMapping("/contrastAnalysis")
    public String contrastAnalysis(ModelMap model, HttpServletRequest request) {
        UserDTO accountDTO = LoginInfoUtil.getLoginUser(request);
        model.put("user", accountDTO);
        return "analysis/contrastAnalysis";
    }

    /**
     * 统计分析-消息发送情况分析
     *
     * @return
     */
    @RequestMapping("/sendAnalysis")
    public String sendAnalysis(ModelMap model, HttpServletRequest request) {
        UserDTO accountDTO = LoginInfoUtil.getLoginUser(request);
        model.put("user", accountDTO);
        return "analysis/sendAnalysis";
    }

    /**
     * 统计分析-发布商信息对比
     *
     * @return
     */
    @RequestMapping("/infoAnalysis")
    public String infoAnalysis(ModelMap model, HttpServletRequest request) {
        UserDTO accountDTO = LoginInfoUtil.getLoginUser(request);
        model.put("user", accountDTO);
        return "analysis/infoAnalysis";
    }


}
