package com.hengyunsoft.platform.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequestMapping("/warn")
public class WarnController {

    //预警台账页面
    @RequestMapping("/warnList")
    public String warnList(ModelMap model) {
        return "warn_manage/list";
    }

    //预警处理台账页面
    @RequestMapping("/warnHandleList")
    public String warnHandleList(ModelMap model) {
        return "warn_handle_manage/list";
    }

    //预警处理结果台账页面
    @RequestMapping("/warnHandleResultList")
    public String warnHandleResultList(ModelMap model) {
        return "warn_handle_result_manage/list";
    }

    //预警信息详情页面
    @RequestMapping("/warnView")
    public String warnView(String id, ModelMap model) {
        model.addAttribute("id", id);
        return "warn_manage/view";
    }
    //预警确认页面
    @RequestMapping("/warnConfirm")
    public String warnConfirm(String id, String handlerLeve, Long warnId, Long userId, String title, String content, ModelMap model) {
        model.addAttribute("id", id);
        model.addAttribute("handlerLeve", handlerLeve);
        model.addAttribute("warnId", warnId);
        model.addAttribute("userId", userId);
        model.addAttribute("title", title);
        model.addAttribute("content", content);
        return "warn_manage/confirm";
    }
    //预警处理页面
    @RequestMapping("/warnHandle")
    public String warnHandle(String id, String handlerLeve, Long warnId, ModelMap model) {
        model.addAttribute("id", id);
        model.addAttribute("handlerLeve", handlerLeve);
        model.addAttribute("warnId", warnId);
        return "warn_manage/handle";
    }
    //预警台账管理页面
    @RequestMapping("/warnTypeList")
    public String warnTypeList(ModelMap model) {
        return "warntype_manage/list";
    }

    //分类维护新增页面
    @RequestMapping("/warntypeCreate")
    public String warntypeCreate(String parentid, String nodeid, ModelMap model) {
        model.addAttribute("parentId", parentid);
        model.addAttribute("nodeId", nodeid);
        return "warntype_manage/create";
    }
    //分类维护编辑页面
    @RequestMapping("/warntypeEdit")
    public String warntypeEdit(String id, ModelMap model) {
        model.addAttribute("id", id);
        return "warntype_manage/edit";
    }
    //预警数量对比分析页面
    @RequestMapping("/analyseNumber")
    public String analyseNumber(ModelMap model) {
        return "analyse_num_manage/list";
    }

    //预警处理效率分析页面
    @RequestMapping("/analyseProcess")
    public String analyseProcess(ModelMap model) {
        return "analyse_pro_manage/list";
    }

    //预警状态分析页面
    @RequestMapping("/analyseStatus")
    public String analyseStatus(ModelMap model) {
        return "analyse_sta_manage/list";
    }
}
