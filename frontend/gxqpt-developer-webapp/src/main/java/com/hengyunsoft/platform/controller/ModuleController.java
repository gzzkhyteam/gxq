package com.hengyunsoft.platform.controller;


import com.hengyunsoft.platform.annotation.UnLogin;
import com.hengyunsoft.platform.security.LoginInfoUtil;
import com.hengyunsoft.security.auth.dto.UserDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/module")
public class ModuleController {

    /**
     * 所有系统的首页地址统一放在module/index
     *
     * @param model
     * @param request
     * @return
     */
    @GetMapping("/docs")
    @UnLogin
    public String docs(String url, String tags, ModelMap model) {
        model.put("url", url);
        model.put("tags", tags);
        return "docs";
    }

    @GetMapping("/index")
    @UnLogin
    public String index(ModelMap model, HttpServletRequest request) {
        UserDTO accountDTO = LoginInfoUtil.getLoginUser(request);
        model.put("user", accountDTO);
        return "module/index";
    }
    /**
     * 顶部公共页面
     */
    @GetMapping("/header")
    @UnLogin
    public String header() {
        return "module/header";
    }

    /**
     * 底部公共页面
     */
    @GetMapping("/footer")
    @UnLogin
    public String footer() {
        return "module/footer";
    }

    /**
     * 左边菜单栏
     */
    @GetMapping("/navLeft")
    public String navLeft() {
        return "module/navLeft";
    }

    /**
     * 功能中心
     */
    @GetMapping("/functionCenter")
    @UnLogin
    public String functionCenter() {
        return "module/functionCore";
    }

    /**
     * API文档
     */
    @GetMapping("/apiDoc")
    @UnLogin
    public String apiDoc(String moduleId, ModelMap model) {
        model.put("moduleId", moduleId);
        return "module/apiDoc";
    }
    //    @GetMapping("doc")
//    public String swagger(String url, String group, ModelMap model) {
//        model.put("url", url);
//        model.put("group", group);
//        return "swagger-ui";
//    }

    /**
     * 帮助文档
     */
    @GetMapping("/helpDoc")
    @UnLogin
    public String helpDoc() {
        return "module/helpDoc";
    }


    /**
     * 申请该功能
     */
    @GetMapping("/callApply")
    public String callApply(String moduleId, String type, ModelMap model) {
        model.addAttribute("moduleId", moduleId);
        model.addAttribute("type", type);
        return "module/callApply";
    }

    /*
    * 搜索输入框
    */
    @GetMapping("/search")
    @UnLogin
    public String search() {
        return "module/search";
    }

    /*
    * 搜索结果
    */
    @GetMapping("/result")
    @UnLogin
    public String result(String key, ModelMap model) {
        model.addAttribute("key", key);
        return "module/result";
    }

    /**
     * 应用管理
     */
    @GetMapping("/appList")
    public String appList() {
        return "appService/list";
    }
    /**
     * 应用依赖管理
     */
    @GetMapping("/appDependManager")
    public String appDependManager(String appId, ModelMap model) {
        model.addAttribute("appId", appId);
    	return "appService/appDependManager";
    }

     /**
     * 新增应用
     */
    @GetMapping("/appServiceCreate")
    public String appServiceCreate(String id,String taskType,String flag,ModelMap model) {
        model.addAttribute("flag",flag);
        model.addAttribute("id",id);
        model.addAttribute("taskType",taskType);
        return "appService/create";
    }

    /**
     * 应用详情
     */
    @GetMapping("/appServiceView")
    public String appServiceView(String id, ModelMap model) {
        model.addAttribute("id", id);
        return "appService/view";
    }

    /**
     * 修改应用
     */
    @GetMapping("/appServiceEdit")
    public String appServiceEdit(String id, ModelMap model) {
        model.addAttribute("id", id);
        return "appService/edit";
    }

    /**
     * 应用的功能管理
     */
    @GetMapping("/functionInApp")
    public String functionInApp(String appId, ModelMap model) {
        model.addAttribute("appId", appId);
        return "appService/functionInApp";
    }

    /**
     * 部署管理列表
     */
    @GetMapping("/deployList")
    public String deployList(String appId, ModelMap model) {
        model.addAttribute("appId", appId);
        return "appService/deployList";
    }

    /**
     * 部署管理新增
     */
    @GetMapping("/deployCreate")
    public String deployCreate(String appId, ModelMap model) {
        model.addAttribute("appId", appId);
        return "appService/deployCreate";
    }

    /**
     * 部署管理修改
     */
    @GetMapping("/deployEdit")
    public String deployEdit(String id, ModelMap model) {
        model.addAttribute("id", id);
        return "appService/deployEdit";
    }

    /**
     * 部署管理详情
     */
    @GetMapping("/deployView")
    public String deployView(String id, ModelMap model) {
        model.addAttribute("id", id);
        return "appService/deployView";
    }

    /**
     * 维护管理员
     */
    @GetMapping("/managerList")
    public String managerList(String appId, ModelMap model) {
        model.addAttribute("appId", appId);
        return "appService/managerList";
    }

    /**
     * 我的提供列表
     */
    @GetMapping("/provideList")
    public String provideList() {
        return "provide/list";
    }
    /**
     * 我的提供列表
     */
    @GetMapping("/provideConsumerManger")
    public String provideConsumerManger(Long moudleId,Model model) {
    	model.addAttribute("moudleId", moudleId);
    	return "provide/consumerManger";
    }

    /**
     * 主机管理
     */
    @GetMapping("/hostList")
    public String hostList() {
        return "hostManage/list";
    }

    /**
     * 新增主机
     */
    @GetMapping("/hostCreate")
    public String hostCreate() {
        return "hostManage/create";
    }

    /**
     * 查看主机
     */
    @GetMapping("/hostView")
    public String hostView(String id, ModelMap model) {
        model.addAttribute("id", id);
        return "hostManage/view";
    }

    /**
     * 修改主机
     */
    @GetMapping("/hostEdit")
    public String hostEdit(String id, ModelMap model) {
        model.addAttribute("id", id);
        return "hostManage/edit";
    }

    /**
     * 查看主机应用
     */
    @GetMapping("/showHostApp")
    public String showHostApp(String id, ModelMap model) {
        model.addAttribute("id", id);
        return "hostManage/showHostApp";
    }

    /**
     * 新增主机应用
     */
    @GetMapping("/addHostApp")
    public String addHostApp(String id, ModelMap model) {
        model.addAttribute("id", id);
        return "hostManage/addHostApp";
    }

    /**
     * 编辑主机应用
     */
    @GetMapping("/editHostApp")
    public String editHostApp(String id, ModelMap model) {
        model.addAttribute("id", id);
        return "hostManage/editHostApp";
    }

    /**
     * 查看主机应用详情
     */
    @GetMapping("viewHostApp")
    public String viewHostApp(String id, ModelMap model) {
        model.addAttribute("id", id);
        return "hostManage/viewHostApp";
    }

    /**
     * 维护主机管理员
     */
    @GetMapping("manageHostAdmin")
    public String manageHostAdmin(String id, ModelMap model) {
        model.addAttribute("id", id);
        return "hostManage/adminList";
    }

    /**
     * 我的提供新增
     */
    @GetMapping("/provideCreate")
    public String provideCreate() {
        return "provide/create";
    }

    /**
     * 我的提供编辑
     */
    @GetMapping("/provideEdit")
    public String provideEdit(String id, ModelMap model) {
        model.addAttribute("id", id);
        return "provide/edit";
    }

    /**
     * 我的提供详情
     */
    @GetMapping("/provideView")
    public String provideView(String id, ModelMap model) {
        model.addAttribute("id", id);
        return "provide/view";
    }

    /**
     * 我的提供帮助文档
     */
    @GetMapping("/provideDocManage")
    public String provideDocManage(String moduleId, String moduleName, ModelMap model) {
        model.addAttribute("moduleId", moduleId);
        model.addAttribute("moduleName", moduleName);
        return "provide/docManage";
    }

    /**
     * 我的调用列表
     */
    @GetMapping("/myCallList")
    public String myCallList() {
        return "myCall/list";
    }

    /**
     * 我的调用新增
     */
    @GetMapping("/myCallCreate")
    public String myCallCreate() {
        return "myCall/create";
    }

    /**
     * 我的调用详情
     */
    @GetMapping("/myCallView")
    public String myCallView(String id, ModelMap model) {
        model.addAttribute("id", id);
        return "myCall/view";
    }

    /**
     * 应用类型维护列表
     */
    @GetMapping("/appTypeList")
    public String appTypeList() {
        return "appType/list";
    }

    /**
     * 应用类型维护新增
     */
    @GetMapping("/appTypeCreate")
    public String appTypeCreate() {
        return "appType/create";
    }

    /**
     * 应用类型维护列表
     */
    @GetMapping("/appTypeEdit")
    public String appTypeEdit(String id, ModelMap model) {
        model.addAttribute("id", id);
        return "appType/edit";
    }

    /**
     * 应用类型维护详情
     */
    @GetMapping("/appTypeView")
    public String appTypeView(String id, ModelMap model) {
        model.addAttribute("id", id);
        return "appType/view";
    }

    /**
     * 功能类型维护列表
     */
    @GetMapping("/functionTypeList")
    public String functionTypeList() {
        return "functionType/list";
    }

    /**
     * 功能类型维护新增
     */
    @GetMapping("/functionTypeCreate")
    public String functionTypeCreate() {
        return "functionType/create";
    }

    /**
     * 功能类型维护编辑
     */
    @GetMapping("/functionTypeEdit")
    public String functionTypeEdit(String id, ModelMap model) {
        model.addAttribute("id", id);
        return "functionType/edit";
    }

    /**
     * 功能类型维护详情
     */
    @GetMapping("/functionTypeView")
    public String functionTypeView(String id, ModelMap model) {
        model.addAttribute("id", id);
        return "functionType/view";
    }

    /**
     * 新增功能跟踪列表
     */
    @GetMapping("/functionTrackList")
    public String functionTrackList() {
        return "functionTrack/list";
    }

    /**
     * 新增功能跟踪编辑
     */
    @GetMapping("/functionTrackEdit")
    public String functionTrackEdit() {
        return "functionTrack/edit";
    }

    /**
     * 新增应用审批列表
     */
    @GetMapping("/appApprovalList")
    public String appApprovalList() {
        return "appApproval/list";
    }

    /**
     * 功能调用跟踪列表
     */
    @GetMapping("/functionCallTrack")
    public String functionCallTrack() {
        return "functionCallTrack/list";
    }

    /**
     * 调用链跟踪
     */
    @GetMapping("/callChainTrack")
    public String callChainTrack(String traceId, Model model) {
        model.addAttribute("traceId", traceId);
        return "functionCallTrack/callChainTrack";
    }

    /**
     * 波峰分析
     */
    @GetMapping("/peakAnalysis")
    public String peakAnalysis() {
        return "functionCallTrack/peakAnalysis";
    }

    /**
     * 我的任务
     */
    @GetMapping("/myTaskList")
    public String myTaskList() {
        return "myTask/list";
    }

    /**
     * 我的任务详情
     */
    @GetMapping("/myTaskView")
    public String myTaskView(String id, String taskType, ModelMap model) {
        model.addAttribute("id", id);
        model.addAttribute("taskType", taskType);
        return "myTask/view";
    }

    ////////////////服务提供商管理//////////////
    @GetMapping("/appProviderList")
    public String  appProviderList() {
    	
    	return "appProvider/list";
    }
    
    /**
     * 新增
     */
    @GetMapping("/appProviderCreate")
    public String appProviderCreate() {
        return "appProvider/create";
    }

    /**
     * 查看
     */
    @GetMapping("/appProviderView")
    public String appProviderView(String id, ModelMap model) {
        model.addAttribute("id", id);
        return "appProvider/view";
    }

    /**
     * 修改
     */
    @GetMapping("/appProviderEdit")
    public String appProviderEdit(String id, ModelMap model) {
        model.addAttribute("id", id);
        return "appProvider/edit";
    }
    ////////////////服务提供商管理end//////////////

}
