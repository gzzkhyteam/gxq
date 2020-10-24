package com.hengyunsoft.platform.controller;

import com.hengyunsoft.platform.security.LoginInfoUtil;
import com.hengyunsoft.security.auth.dto.UserDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/module")
public class ModuleController {

    /**
     * 所有系统的首页地址统一放在module/index
     */
    @RequestMapping("/index")
    public String index(ModelMap model, HttpServletRequest request) {
        UserDTO accountDTO = LoginInfoUtil.getLoginUser(request);
        model.put("user", accountDTO);
        return "module/index";
    }

    /**
     * 首页
     */
    @RequestMapping("/home")
    public String home(HttpServletRequest request) {
        return "module/home";
    }

    /**
     * 版本发布列表
     */
    @RequestMapping("/versionList")
    public String versionList(ModelMap model) {
        return "version/list";
    }

    /**
     * 版本发布新增
     */
    @RequestMapping("/versionCreateOrEdit")
    public String versionCreate(ModelMap model) {
        return "version/createOrEdit";
    }

    /**
     * 版本查看H5
     */
    @RequestMapping("/versionMobile")
    public String versionMobile(ModelMap model) {
        return "version/mobile";
    }

    /**
     * 版本发布详情
     */
    @RequestMapping("/versionView")
    public String versionView(ModelMap model) {
        return "version/view";
    }

    /**
     * 使用帮助列表
     * @param model
     * @param request
     * @return
     */
    @RequestMapping("/helpList")
    public String helpList(ModelMap model) {
        return "help/list";
    }

    /**
     * 使用帮助-新增或编辑
     * @param model
     * @param request
     * @return
     */
    @RequestMapping("/helpAddOrEdit")
    public String helpAdd(ModelMap model) {
        return "help/addOrEdit";
    }

    /**
     * 使用帮助-手机端H5
     * @param model
     * @param request
     * @return
     */
    @RequestMapping("/helpMobile")
    public String helpMobile(ModelMap model) {
        return "help/mobile";
    }

    /**
     * 组件管理列表
     */
    @RequestMapping("/componentList")
    public String componentList(ModelMap model) {
        return "component/list";
    }

    /**
     * 组件管理新增或修改
     */
    @RequestMapping("/componentCreateOrEdit")
    public String componentCreateOrEdit(ModelMap model) {
        return "component/createOrEdit";
    }

    /**
     * 组件管理查看详情
     */
    @RequestMapping("/componentDetail")
    public String componentDetail(ModelMap model) {
        return "component/detail";
    }

    /**
     * 应用程序管理列表
     */
    @RequestMapping("/applyList")
    public String applyList(ModelMap model) {
        return "applyManage/list";
    }

    /**
     * 应用程序管理新增
     */
    @RequestMapping("/applyCreate")
    public String applyCreate(ModelMap model) {
        return "applyManage/create";
    }

    /**
     * 应用程序管理编辑
     */
    @RequestMapping("/applyEdit")
    public String applyEdit(String id,ModelMap model) {
        model.addAttribute("id",id);
        return "applyManage/edit";
    }

    /**
     * 应用程序管理详情
     */
    @RequestMapping("/applyView")
    public String applyView(String id,ModelMap model) {
        model.addAttribute("id",id);
        return "applyManage/view";
    }
    /**
     * 应用程序管理审核
     */
    @RequestMapping("/applyDeal")
    public String applyDeal(String id,ModelMap model) {
        model.addAttribute("id",id);
        return "applyManage/deal";
    }

    /**
     * 功能列表
     */
    @RequestMapping("/functionList")
    public String functionList(String id,ModelMap model) {
        model.addAttribute("id",id);
        return "functionManage/list";
    }

    /**
     * 功能新增
     */
    @RequestMapping("/functionCreate")
    public String functionCreate(String parentId,ModelMap model) {
        model.addAttribute("parentId",parentId);
        return "functionManage/create";
    }
    /**
     * 功能编辑
     */
    @RequestMapping("/functionEdit")
    public String functionEdit(String id,ModelMap model) {
        model.addAttribute("id",id);
        return "functionManage/edit";
    }
    /**
     * 功能详情
     */
    @RequestMapping("/functionView")
    public String functionView(String id,ModelMap model) {
        model.addAttribute("id",id);
        return "functionManage/view";
    }
    /**
     * 意见反馈列表
     */
    @RequestMapping("/feedbackList")
    public String feedbackList(ModelMap model) {
        return "feedbackManage/list";
    }

    /**
     * 意见反馈处理
     */
    @RequestMapping("/feedbackDeal")
    public String feedbackDeal(ModelMap model) {
        return "feedbackManage/deal";
    }

    /**
     * 意见反馈详情
     */
    @RequestMapping("/feedbackView")
    public String feedbackView(ModelMap model) {
        return "feedbackManage/view";
    }

    /**
     * 我的日志
     */
    @RequestMapping("/myworklog")
    public String myworklog(ModelMap model) {
        return "worklog/myworklog";
    }

    /**
     * 日志查询
     */
    @RequestMapping("/worklogList")
    public String worklogList(ModelMap model) {
        return "worklog/list";
    }

    /**
     * 日志查看
     */
    @RequestMapping("/leaderview")
    public String leaderview(ModelMap model) {
        return "worklog/leaderview";
    }
    /**
     * 日志填写
     */
    @RequestMapping("/createWorklog")
    public String createWorklog(ModelMap model) {
        return "worklog/create";
    }
    /**
     * 日志编辑
     */
    @RequestMapping("/editWorklog")
    public String editWorklog(String id,String logId,ModelMap model) {
        model.addAttribute("id",id);
        model.addAttribute("logId",logId);
        return "worklog/edit";
    }
    /**
     * 日志详情
     */
    @RequestMapping("/viewWorklog")
    public String viewWorklog(ModelMap model) {
        return "worklog/view";
    }

    /**
    选择人员
     */
    @RequestMapping("/setParent")
    public String setParent(String userId,String userIds,ModelMap model) {
        model.addAttribute("userId",userId);
        model.addAttribute("userIds",userIds);
        return "worklog/setParent";
    }
}
