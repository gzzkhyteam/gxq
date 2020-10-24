package com.hengyunsoft.platform.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequestMapping("/msgs")
public class MsgsController {

    //渠道管理页面
    @RequestMapping("/channelList")
    public String channelList(ModelMap model) {
        return "channel/list";
    }
    //渠道管理页面
    @RequestMapping("/channelCreate")
    public String channelCreate(ModelMap model) {
        return "channel/create";
    }
    //渠道管理页面
    @RequestMapping("/channelEdit")
    public String channelEdit(String id, ModelMap model) {
        model.addAttribute("id", id);
        return "channel/edit";
    }
    //渠道管理页面
    @RequestMapping("/channelView")
    public String channelView(String id, ModelMap model) {
        model.addAttribute("id", id);
        return "channel/detail";
    }

    //渠道类别管理页面
    @RequestMapping("/channelTypeList")
    public String channelTypeList(ModelMap model) {
        return "channeltype/list";
    }


    //渠道组管理页面
    @RequestMapping("/channelGroupList")
    public String channelGroupList(ModelMap model) {
        return "channelgroup/list";
    }
    //渠道组管理页面
    @RequestMapping("/channelGroupCreate")
    public String channelGroupCreate(ModelMap model) {
        return "channelgroup/create";
    }
    //渠道组管理页面
    @RequestMapping("/channelGroupEdit")
    public String channelGroupEdit(String id, ModelMap model) {
        model.addAttribute("id", id);
        return "channelgroup/edit";
    }
    //渠道组管理页面
    @RequestMapping("/channelGroupView")
    public String channelGroupView(String id, ModelMap model) {
        model.addAttribute("id", id);
        return "channelgroup/detail";
    }


    //新增消息页面
    @RequestMapping("/createMessage")
    public String createMessage(ModelMap model) {
        return "msgsmessage/create";
    }
    //渠道管理页面-定时发送
    @RequestMapping("/setTimeSave")
    public String setTimeSave(ModelMap model) {
        return "msgsmessage/setTimeSave";
    }
    //草稿箱页面
    @RequestMapping("/drafts")
    public String drafts(ModelMap model) {
        return "msgsmessage/drafts";
    }
    //草稿箱列表修改
    @RequestMapping("/draftsEdit")
    public String draftsEdit(String id, int type , ModelMap model) {
        model.addAttribute("id", id);
        model.addAttribute("type", type);
        return "msgsmessage/drafts_edit";
    }//文档管理文件上传
    @RequestMapping("/uploadFile")
    public String uploadFile(String folderId, String dataType, ModelMap model) {
        model.addAttribute("folderId", folderId);
        model.addAttribute("dataType", dataType);
        return "msgsmessage/uploadFile";
    }
       //发布成功
    @RequestMapping("/publishSucess")
    public String publishSucess(ModelMap model) {
        return "msgsmessage/publish_sucess";
    }
    //发布成功
    @RequestMapping("/messageView")
    public String messageView(String id, ModelMap model) {
        model.addAttribute("id", id);
        return "msgsmessage/news_about";
    }

    //统计分析
    @RequestMapping("/analysis")
    public String analysis(ModelMap model) {
        return "analysis/list";
    }
    //文件预览
    @RequestMapping("/swf")
    public String swf(Long id,ModelMap model) {
        model.addAttribute("id", id);
        return "file_manage/flexpaper";
    }

    //发布商列表
    @RequestMapping("/publisherList")
    public String publisherList(ModelMap model) {
        return "publisher/list";
    }

    //发布商详情
    @RequestMapping("/publisherView")
    public String publisherView(ModelMap model) {
        return "publisher/view";
    }

    //发布商管理
    @RequestMapping("/publisherManage")
    public String publisherManage(String id,ModelMap model) {
        model.addAttribute("id",id);
        return "channel/publisherManage";
    }
}
