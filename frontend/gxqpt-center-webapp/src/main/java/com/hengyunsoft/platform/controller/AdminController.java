package com.hengyunsoft.platform.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hengyunsoft.platform.security.StringParamSecurityUtil;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Value("http://${gxqpt.hostname.nginx}:${gxqpt.port.nginx}")
    private String nginxUrl;

    //对内首页
    @RequestMapping("/index")
    public String doc() {
        return "admin/index";
    }

    @RequestMapping("/index2")
    public String doc2(ModelMap model) {
        return "admin/index";
    }
    //密码修改
    @RequestMapping("/repassword")
    public String repassword(Long id,ModelMap model) {
        model.addAttribute("id",id);
        return "admin/repassword";
    }
    //配置新增
    @RequestMapping("/configureCreate")
    public String configureCreate(ModelMap model) {
        return "admin/configureCreate";
    }
    //配置修改
    @RequestMapping("/configureEdit")
    public String configureEdit(String id, ModelMap model) {
        model.addAttribute("id",StringParamSecurityUtil.convert(id));
        return "admin/configureEdit";
    }
    //更多
    @RequestMapping("/pageMore")
    public String pageMore(String type, ModelMap model) {
    	type = filterMsgType(type);
        model.addAttribute("type",type);
        return "admin/pageMore";
    }
    //人员基本信息
    @RequestMapping("/personInfoPage")
    public String personInfoPage(String id,String systemCode,ModelMap model) {
        model.addAttribute("id",StringParamSecurityUtil.convert(id));
        model.addAttribute("systemCode",StringParamSecurityUtil.convert(systemCode));
        return "admin/personInfoPage";
    }
    //搜索结果页
    @RequestMapping("/search")
    public String search(ModelMap model) {

        model.addAttribute("type","");
        return "admin/search";
    }
    //home页
    @RequestMapping("/home")
    public String home(String type,ModelMap model) {
    	type = filterMsgType(type);
    	model.addAttribute("type",type);
        return "admin/home";
    }
    //全部消息页
    @RequestMapping("/allInfoPage")
    public String allInfoPage(String type, ModelMap model) {
    	type = filterMsgType(type);
        model.addAttribute("type",type);
        return "admin/allInfoPage";
    }
    //已读消息页
    @RequestMapping("/readInfoPage")
    public String readInfoPage(String type, ModelMap model) {
    	type = filterMsgType(type);
        model.addAttribute("type",type);
        return "admin/readInfoPage";
    }

	private String filterMsgType(String type) {
		if(type == null) {
			return null;
		}
		switch (type) {
		case "all": return type;
		case "noHandle": return type;
		case "needHandle": return type;
		case "message": return type;
		default:
			return null;
		}
	}
}
