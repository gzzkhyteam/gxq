package com.hengyunsoft.platform.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequestMapping("/standard")
public class StandardController {

    //接口标准使用分析
    @RequestMapping("/typeAccess")
    public String typeAccess(ModelMap model) {
        return "type/access";
    }

    //服务标准使用分析
    @RequestMapping("/typeService")
    public String typeService(ModelMap model) {
        return "type/service";
    }

    //规范标准使用分析
    @RequestMapping("/typeNorm")
    public String typeNorm(ModelMap model) {
        return "type/norm";
    }

    //分类管理页面
    @RequestMapping("/classifyList")
    public String classifyList(ModelMap model) {
        return "classify_manage/list";
    }

    //分类管理新增页面
    @RequestMapping("/classifyCreate")
    public String classifyCreate(String parentid, String nodeid,
                                 String fromPage, ModelMap model) {
        model.addAttribute("parentId", parentid);
        model.addAttribute("nodeId", nodeid);
        model.addAttribute("fromPage", fromPage);
        return "classify_manage/create";
    }

    //分类管理编辑页面
    @RequestMapping("/classifyEdit")
    public String classifyEdit(String id, ModelMap model) {
        model.addAttribute("id", id);
        return "classify_manage/edit";
    }

    //文档管理页面
    @RequestMapping("/fileList")
    public String fileList(String title,
                           String fromPage,
                           ModelMap model) {
        model.put("title", title);
        model.put("fromPage", fromPage);
        return "file_manage/list";
    }

    //文档查询页面
    @RequestMapping("/fileSearchList")
    public String fileSearchList(ModelMap model) {
        return "file_manage/searchList";
    }

    //文档管理新增页面
    @RequestMapping("/fileCreate")
    public String fileCreate(ModelMap model) {
        return "file_manage/create";
    }

    //文档管理编辑页面
    @RequestMapping("/fileEdit")
    public String fileEdit(String id, ModelMap model) {
        model.addAttribute("id", id);
        return "file_manage/edit";
    }

    //文档简介页面
    @RequestMapping("/fileView")
    public String fileView(String id, ModelMap model) {
        model.addAttribute("id", id);
        return "file_manage/view";
    }

    //文档管理文件上传
    @RequestMapping("/uploadFile")
    public String uploadFile(String folderId, String dataType, ModelMap model) {
        model.addAttribute("folderId", folderId);
        model.addAttribute("dataType", dataType);
        return "file_manage/uploadFile";
    }

    //文件预览
    @RequestMapping("/swf")
    public String swf(Long id, ModelMap model) {
        model.addAttribute("id", id);
        return "file_manage/flexpaper";
    }

    //文档管理分类选择
    @RequestMapping("/selectClassifyType")
    public String selectClassifyType(String id, ModelMap model) {
        model.addAttribute("id", id);
        return "file_manage/selectClassifyType";
    }

    //标准管理使用分析
    @RequestMapping("/analyseList")
    public String analyseList(ModelMap model) {
        return "analyse_manage/list";
    }

    //标准分类申请列表
    @RequestMapping("/applyList")
    public String classifyApplyList(ModelMap model) {
        return "classify_apply/list";
    }

    //标准分类申请
    @RequestMapping("/applyCreate")
    public String applyCreate(ModelMap model) {
        return "classify_apply/create";
    }

    //待办事项
    @RequestMapping("/toDoList")
    public String toDoList(ModelMap model) {
        return "classify_apply/toDoList";
    }

    //已办事项
    @RequestMapping("/doneList")
    public String doneList(ModelMap model) {
        return "classify_apply/doneList";
    }

    //通过页面
    @RequestMapping("/pass")
    public String pass(String id, ModelMap model) {
        model.addAttribute("id", id);
        return "classify_apply/pass";
    }

    //驳回页面
    @RequestMapping("/reject")
    public String reject(String id, ModelMap model) {
        model.addAttribute("id", id);
        return "classify_apply/reject";
    }
}
