package com.hengyunsoft.platform.controller.taskSendFile;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * @author luchanghong
 * @create 2018-05-09 16:14
 * @desc 发文管理控制层
 **/
@Controller
@RequestMapping("/fast/{appId}/document")
public class TaskSendFileController {
    /**
     * 发文管理首页
     * @return
     */
    @RequestMapping("taskSendFile")
    public String main(@PathVariable String appId, ModelMap map) {

        map.put("appId", appId);
        return "/taskSendFile/main";
    }

    /**
     * 到新增收文界面
     * @return
     */
    @RequestMapping("addTaskSendFile")
    public String addTaskSendFile(@PathVariable String appId, ModelMap map) {

        map.put("appId", appId);
        return "/taskSendFile/add";
    }

    /**
     * 到发文处理界面
     * @return
     */
    @RequestMapping("taskSendFileUpdate")
    public String taskSendFileUpdate(@PathVariable String appId, ModelMap map) {

        map.put("appId", appId);
        return "taskSendFile/addOrUpdate";
    }

    /**
     * 收文详情
     * @param id
     * @return
     */
    @RequestMapping("getSendFileDetail")
    public String getDgetSendFileDetailetail(@PathVariable String appId, ModelMap map, String id, Model model, HttpServletRequest request) {
        map.put("appId", appId);
        model.addAttribute("taskSenFileId",request.getParameter("taskSenFileId"));
        return "taskSendFile/detail";
    }

    /**
     * 收发文设置
     * @return
     */
    @RequestMapping("szDocument")
    public String szDocument(@PathVariable String appId, ModelMap map) {

        map.put("appId", appId);
        return "taskSendFile/szDocument";
    }

    /**
     * 修改收文设置
     * @return
     */
    @RequestMapping("editRecvFileType")
    public String editRecvFileType(@PathVariable String appId, ModelMap map) {
        map.put("appId", appId);
        return "taskSendFile/editRecvFileType";
    }

    /**
     * 新增收文设置
     * @return
     */
    @RequestMapping("addRecvFileType")
    public String addRecvFileType(@PathVariable String appId, ModelMap map) {
        map.put("appId", appId);
        return "taskSendFile/addRecvFileType";
    }

    /**
     * 更改收文
     * @return
     */
    @RequestMapping("addOrUpdate")
    public String update(@PathVariable String appId, ModelMap map,HttpServletRequest request, Model model) {
        map.put("appId", appId);
        System.out.println("dasf---------------"+request.getParameter("id"));
        model.addAttribute("id",request.getParameter("taskSenFileId"));
        return "taskSendFile/update";
    }
}