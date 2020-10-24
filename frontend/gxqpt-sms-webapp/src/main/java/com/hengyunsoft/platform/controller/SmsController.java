package com.hengyunsoft.platform.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hengyunsoft.platform.configuration.GxqptWebappConfig;
import com.hengyunsoft.platform.security.LoginInfoUtil;
import com.hengyunsoft.security.auth.dto.UserDTO;

@Controller
@RequestMapping("/sms")
public class SmsController {
    @Autowired
   private GxqptWebappConfig gxqptWebappConfig;
    //新建发布页面
    @RequestMapping("/createShortMessage")
    public String createShortMessage(ModelMap model,HttpServletRequest request) {
        String appId=gxqptWebappConfig.getAppId();
        model.addAttribute("appId",appId);
        UserDTO accountDTO = LoginInfoUtil.getLoginUser(request);
        model.put("user", accountDTO);
        return "smssend/create";
    }

    //草稿箱
    @RequestMapping("/shortDrafts")
    public String drafts(ModelMap model) {
        String appId=gxqptWebappConfig.getAppId();
        model.addAttribute("appId",appId);
        return "smssend/draft";
    }
    //再次编辑
    //home=0来自于已发送 home=2来源于草稿箱
    @RequestMapping("/smsEditAgain")
    public String smsEditAgain(String id, ModelMap model,String home,HttpServletRequest request){
        model.addAttribute("msgId", id);
        model.addAttribute("home", home);
        UserDTO accountDTO = LoginInfoUtil.getLoginUser(request);
        model.put("user", accountDTO);
        String appId = gxqptWebappConfig.getAppId();
        model.addAttribute("appId",appId);
        return "smssend/editAgain";
    }

    //草稿箱继续编辑
    @RequestMapping("/smsdraftView")
    public String smsdraftView(String id, ModelMap model,String home,HttpServletRequest request){
        model.addAttribute("home", home);
        model.addAttribute("msgId", id);
        UserDTO accountDTO = LoginInfoUtil.getLoginUser(request);
        model.put("user", accountDTO);
        String appId=gxqptWebappConfig.getAppId();
        model.addAttribute("appId",appId);
        return "smssend/editAgain";
    }

    //已发送
    @RequestMapping("/publishShortSucess")
    public String publishSucess(ModelMap model) {
        String appId=gxqptWebappConfig.getAppId();
        model.addAttribute("appId",appId);
        return "smssend/publish_success";
    }

    //短信历史记录
    @RequestMapping("/smsHistory")
    public String smsHistory(ModelMap model) {
        return "smshistory/history";
    }

    //模板配置管理
    @RequestMapping("/smsModel")
    public String smsModel(ModelMap model) {
        String appId=gxqptWebappConfig.getAppId();
        model.addAttribute("appId",appId);
        return "smsmodel/model";
    }
    //模板新增
    @RequestMapping("/modelCreate")
    public String modelCreate(ModelMap model){
        String appId=gxqptWebappConfig.getAppId();
        model.addAttribute("appId",appId);
        return "smsmodel/model_creat";}
    //模板查看详情
    @RequestMapping("/modelView")
    public String modelView(String id, ModelMap model) {
        model.addAttribute("id", id);
        return "smsmodel/detail";
    }
  //模板编辑
    @RequestMapping("/modelEdit")
    public String modelEdit(String id, ModelMap model) {
        model.addAttribute("id", id);
        String appId=gxqptWebappConfig.getAppId();
        model.addAttribute("appId",appId);
        return "smsmodel/edit";
    }

    //服务账号管理
    @RequestMapping("/smsNum")
    public String smsNum(ModelMap model){ return "smsnum/number";}
    //服务账号新增
    @RequestMapping("/numCreate")
    public String numCreate(ModelMap model){return "smsnum/num_create";}
    //服务账号详情
    @RequestMapping("/numView")
    public String numView(String id, ModelMap model) {
        model.addAttribute("id", id);
        return "smsnum/detail";
    }

    //服务账号编辑
    @RequestMapping("/numEdit")
    public String numEdit(String id, ModelMap model) {
        model.addAttribute("id", id);
        return "smsnum/edit";
    }
    //指定应用
    @RequestMapping("/yingYong")
    public String yingYong(String name,String account,Long id, ModelMap model) {
        model.addAttribute("name", name);
        model.addAttribute("account",account);
        model.addAttribute("id",id);
        return "smsnum/yingyong";
    }
    //已发送查看详情
    @RequestMapping("/smsView")
    public String smsView(String id, ModelMap model){
        model.addAttribute("msgId", id);
        return "smssend/detail";
    }

    //发布人管理
    @RequestMapping("/publisherManage")
    public  String publisherManage(ModelMap model) { return "smsanalysis/publisherManage";}

    //发送模块管理
    @RequestMapping("/smsModuleRecord")
    public  String smsModuleRecord(ModelMap model) { return "smsrecord/smsModuleRecord";}
    
    //发送服务管理
    @RequestMapping("/smsServiceRecord")
    public  String smsServiceRecord(ModelMap model) { return "smsrecord/smsServiceRecord";}

    //发送应用管理
    @RequestMapping("/smsAppRecord")
    public  String smsAppRecord(ModelMap model) { return "smsrecord/smsAppRecord";}

    //短信量分析
    @RequestMapping("/smsUse")
    public String smsUse(ModelMap model){ return "smsanalysis/smsuse";}

    //短信时间分析
    @RequestMapping("/time")
    public  String time(ModelMap model) { return "smsanalysis/time";}

    //发送和接收图谱
    @RequestMapping("/sendAndReceive")
    public  String sendAndReceive(ModelMap model) { return "smsanalysis/sendAndReceive";}
}
