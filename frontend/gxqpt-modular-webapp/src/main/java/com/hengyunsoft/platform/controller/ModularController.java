package com.hengyunsoft.platform.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequestMapping("/modular")
public class ModularController {

    //主页面
    @RequestMapping("/home")
    public String home(ModelMap model) {
        return "module/home";
    }

    //主页面
    @RequestMapping("/main")
    public String main(ModelMap model) {
        return "module/main";
    }

    //模块查询页面
    @RequestMapping("/searchList")
    public String searchList(ModelMap model) {
        return "modular_search/list";
    }
    //废弃模块页面
    @RequestMapping("/discarded")
    public String discarded(ModelMap model) {
        return "modular_search/discarded";
    }

    //模块发布页面
    @RequestMapping("/modularCreate")
    public String modularCreate(ModelMap model) {
        return "modular_manage/create";
    }

    //模块更新页面
    @RequestMapping("/modularEdit")
    public String modularEdit(String id, ModelMap model) {
        model.addAttribute("id",id);
        return "modular_manage/edit";
    }

    //标签和分类申请查询页面
    @RequestMapping("/categoryAndTagApplyList")
    public String categoryAndTagApplyList(ModelMap model) {
        return "modular_manage/applyList";
    }

    //标签和分类新增申请页面
    @RequestMapping("/categoryAndTagcreateApply")
    public String categoryAndTagcreateApply(ModelMap model) {
        return "modular_manage/createApply";
    }

    //待办事项查询页面
    @RequestMapping("/toDoApplyList")
    public String toDoApplyList(ModelMap model) {
        return "modular_manage/toDoApplyList";
    }

    //已办事项查询页面
    @RequestMapping("/doneApplyList")
    public String doneApplyList(ModelMap model) {
        return "modular_manage/doneApplyList";
    }

    //模块使用分析top10
    @RequestMapping("/useAnalyse")
    public String useAnalyse(ModelMap model) {
        return "modular_analyse/list";
    }
    //服务提供商
    @RequestMapping("/applyProviderList")
    public String applyProviderList(ModelMap model) {
        return "modular_provider/list";
    }
    //服务提供商新增
    @RequestMapping("/providerAdd")
    public String providerAdd(ModelMap model) {
        return "modular_provider/create";
    }
    //服务提供商修改
    @RequestMapping("/providerUpdate")
    public String providerUpdate(String id,ModelMap model) {
        model.addAttribute("id", id);
        return "modular_provider/edit";
    }
    //通过页面
    @RequestMapping("/passApply")
    public String passApply(String id, ModelMap model) {
        model.addAttribute("id", id);
        return "modular_manage/passApply";
    }

    //驳回页面
    @RequestMapping("/rejectApply")
    public String rejectApply(String id, ModelMap model) {
        model.addAttribute("id", id);
        return "modular_manage/rejectApply";
    }

    //模块管理页面
    @RequestMapping("/modularList")
    public String modularList(ModelMap model) {
        return "modular_manage/modularList";
    }

    //模块查询下的版本详情页面
    @RequestMapping("/searchVersionDetails")
    public String searchVersionDetails(String id,String modularName,String description,String modularId,ModelMap model) {
        model.addAttribute("id", id);
        model.addAttribute("modularName",modularName);
        model.addAttribute("description",description);
        model.addAttribute("modularId",modularId);
        return "modular_search/versionDetail";
    }
    //模块管理下的版本详情页面
    @RequestMapping("/manageVersionDetails")
    public String manageVersionDetails(String id,String modularName,String description,String modularId,ModelMap model) {
        model.addAttribute("id", id);
        model.addAttribute("modularName",modularName);
        model.addAttribute("description",description);
        model.addAttribute("modularId",modularId);
        return "modular_manage/versionDetail";
    }

    //模块详情页面跳转模块查询列表页面
    @RequestMapping("/mdJumpListSearch")
    public String mdJumpListSearch(String modularType,String modularTag,String groupId,String artifactId,String repName,ModelMap model) {
        model.addAttribute("modularType", modularType);
        model.addAttribute("modularTag",modularTag);
        model.addAttribute("groupId",groupId);
        model.addAttribute("artifactId",artifactId);
        model.addAttribute("repName",repName);
        return "modular_search/list";
    }

    //点击模块名称跳转模块详情页面
    @RequestMapping("/jumpSearchModularDetails")
    public String jumpSearchModularDetails(String id, ModelMap model) {
        model.addAttribute("id", id);
        return "modular_search/modularDetail";
    }

    //点击模块名称跳转模块详情页面
    @RequestMapping("/jumpManageModularDetails")
    public String jumpManageModularDetails(String id, ModelMap model) {
        model.addAttribute("id", id);
        return "modular_manage/modularDetail";
    }


}
