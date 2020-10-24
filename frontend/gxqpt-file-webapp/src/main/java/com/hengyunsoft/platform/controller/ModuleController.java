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
    public String index(
            String url,
            ModelMap model, HttpServletRequest request) {
        UserDTO accountDTO = LoginInfoUtil.getLoginUser(request);
        model.put("user", accountDTO);
        model.put("url", url);
        return "module/index";
    }
    //首页
    @RequestMapping("/home")
    public String home() {
        return "module/home";
    }

    //文件数量分析
    @RequestMapping("/numberAnalysis")
    public String numberAnalysis() {
        return "file/analysis/numberAnalysis";
    }

    //文件大小分析
    @RequestMapping("/sizeAnalysis")
    public String sizeAnalysis() {
        return "file/analysis/sizeAnalysis";
    }

    //磁盘空间分析
    @RequestMapping("/spaceAnalysis")
    public String spaceAnalysis() {
        return "file/analysis/spaceAnalysis";
    }

    //多系统文件分析
    @RequestMapping("/systemAnalysis")
    public String systemAnalysis() {
        return "file/analysis/systemAnalysis";
    }

    //文件流量分析
    @RequestMapping("/flowAnalysis")
    public String flowAnalysis() {
        return "file/analysis/flowAnalysis";
    }

    //文件类别分析
    @RequestMapping("/categoryAnalysis")
    public String categoryAnalysis() {
        return "file/analysis/categoryAnalysis";
    }

    //文件云图
    @RequestMapping("/cloudAnalysis")
    public String cloudAnalysis() {
        return "file/analysis/cloudAnalysis";
    }

    //设置
    @RequestMapping("/settings")
    public String settings() {
        return "file/settings/list";
    }

}
