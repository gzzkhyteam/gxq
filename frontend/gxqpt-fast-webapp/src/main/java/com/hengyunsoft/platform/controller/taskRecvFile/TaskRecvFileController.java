package com.hengyunsoft.platform.controller.taskRecvFile;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * @author luchanghong
 * @create 2018-05-09 10:45
 * @desc 收文管理控制层
 **/
@Controller
@RequestMapping("/fast/{appId}/document")
public class TaskRecvFileController {
    /**
     * 收文管理首页
     * @return
     */
    @RequestMapping("taskRecvFile")
    public String main(@PathVariable String appId,ModelMap map){
        map.put("appId", appId);return "/taskRecvFile/main";
    }

    /**
     * 到新增收文界面
     * @return
     */
    @RequestMapping("addTaskRecvFile")
    public  String addTaskRecvFile(@PathVariable String appId, Model model,HttpServletRequest request, ModelMap map){
        map.put("appId", appId);
        model.addAttribute("taskRecvFileId",request.getParameter("taskRecvFileId"));
        return "/taskRecvFile/add";
    }

    /**
     * 到新增收文界面
     * @return
     */
    @RequestMapping("updateTaskRecvFile")
    public  String updateTaskRecvFile(@PathVariable String appId, Model model,HttpServletRequest request, ModelMap map){
        map.put("appId", appId);
        model.addAttribute("taskRecvFileId",request.getParameter("taskRecvFileId"));
        return "/taskRecvFile/update";
    }
    /**
     * 到新增阅读性收文界面
     * @return
     */
    @RequestMapping("addReadFile")
    public String addReadFile(@PathVariable String appId, ModelMap map){
        map.put("appId", appId);return "/taskRecvFile/addOrUpdateReadFile";
    }

    /**
     * 收文详情
     * @param id
     * @return
     */
    @RequestMapping("getDetail")
    public  String getDetail(@PathVariable String appId, ModelMap map, String id, HttpServletRequest request, Model model){
        map.put("appId", appId);
        model.addAttribute("taskRecvFileId",request.getParameter("taskRecvFileId"));
        return "/taskRecvFile/taskRecvFileDetail";
    }

    /**
     * 添加拟办意见
     * @return
     */
    @RequestMapping("addTask")
    public  String addTask(@PathVariable String appId,ModelMap map, HttpServletRequest request, Model model){
        model.addAttribute("taskId",request.getParameter("taskRecvFileId"));
        return "/taskRecvFile/addTask";
    }
}