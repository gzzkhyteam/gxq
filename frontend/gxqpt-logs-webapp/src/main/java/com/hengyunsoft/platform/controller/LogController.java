package com.hengyunsoft.platform.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequestMapping("/logs")
public class LogController {

    //日志采集页面
    @RequestMapping("/collectList")
    public String collectList(ModelMap model) {
        return "log_collect/list";
    }

    //日志导入页面
    @RequestMapping("/collectImport")
    public String collectImport(ModelMap model) {
        return "log_collect/importFile";
    }

    //日志采集文件上传
    @RequestMapping("/uploadFile")
    public String uploadFile(String folderId, String dataType, ModelMap model) {
        model.addAttribute("folderId", folderId);
        model.addAttribute("dataType", dataType);
        return "log_collect/uploadFile";
    }

    //tomcat日志文件预览
    @RequestMapping("/collectTomcatView")
    public String collectTomcatView(String id,String documentId,String userId,String token,ModelMap model) {
        model.addAttribute("id", id);
        model.addAttribute("documentId", documentId);
        model.addAttribute("userId", userId);
        model.addAttribute("token", token);
        return "log_collect/collectTomcatView";
    }

    //nginx日志文件预览
    @RequestMapping("/collectNginxView")
    public String collectNginxView(String id,String documentId,String userId,String token,ModelMap model) {
        model.addAttribute("id", id);
        model.addAttribute("documentId", documentId);
        model.addAttribute("userId", userId);
        model.addAttribute("token", token);
        return "log_collect/collectNginxView";
    }

    //应用系统日志文件预览
    @RequestMapping("/collectAppView")
    public String collectAppView(String id,String documentId,String userId,String token,ModelMap model) {
        model.addAttribute("id", id);
        model.addAttribute("documentId", documentId);
        model.addAttribute("userId", userId);
        model.addAttribute("token", token);
        return "log_collect/collectAppView";
    }

    //apache日志文件预览
    @RequestMapping("/collectApacheView")
    public String collectApacheView(String id,String documentId,String userId,String token,ModelMap model) {
        model.addAttribute("id", id);
        model.addAttribute("documentId", documentId);
        model.addAttribute("userId", userId);
        model.addAttribute("token", token);
        return "log_collect/collectApacheView";
    }

    //未解析日志预览
    @RequestMapping("/collectNoparsedView")
    public String collectNoparsedView(String id,String documentId,String userId,String token,ModelMap model) {
        model.addAttribute("id", id);
        model.addAttribute("documentId", documentId);
        model.addAttribute("userId", userId);
        model.addAttribute("token", token);
        return "log_collect/collectNoparsedView";
    }

    //已失效日志预览
    @RequestMapping("/collectInvalidView")
    public String collectInvalidView(String id,String documentId,String userId,String token,ModelMap model) {
        model.addAttribute("id", id);
        model.addAttribute("documentId", documentId);
        model.addAttribute("userId", userId);
        model.addAttribute("token", token);
        return "log_collect/collectInvalidView";
    }

    //解析失败日志预览
    @RequestMapping("/collectFailureView")
    public String collectFailureView(String id,String documentId,String userId,String token,ModelMap model) {
        model.addAttribute("id", id);
        model.addAttribute("documentId", documentId);
        model.addAttribute("userId", userId);
        model.addAttribute("token", token);
        return "log_collect/collectFailureView";
    }

    //日志管理页面
    @RequestMapping("/manageList")
    public String manageList(ModelMap model) {
        return "log_manage/list";
    }

    //应用日志检索页面
    @RequestMapping("/applyserachList")
    public String applyserachList(ModelMap model) {
        return "applylog_search/list";
    }

    //应用日志详情
    @RequestMapping("/applogView")
    public String applogView(String id,String documentId,String userId,String token,ModelMap model) {
        model.addAttribute("id", id);
        model.addAttribute("documentId", documentId);
        model.addAttribute("userId", userId);
        model.addAttribute("token", token);
        return "applylog_search/applogView";
    }

    //Apache日志检索页面
    @RequestMapping("/apacheserachList")
    public String apacheserachList(ModelMap model) {
        return "apachelog_search/list";
    }

    //Apache日志详情
    @RequestMapping("/apacheView")
    public String apacheView(String id,String documentId,String userId,String token,ModelMap model) {
        model.addAttribute("id", id);
        model.addAttribute("documentId", documentId);
        model.addAttribute("userId", userId);
        model.addAttribute("token", token);
        return "apachelog_search/apacheView";
    }

    //Nginx日志检索页面
    @RequestMapping("/nginxserachList")
    public String nginxserachList(ModelMap model) {
        return "nginxlog_search/list";
    }

    //Nginx日志详情
    @RequestMapping("/nginxView")
    public String nginxView(String id,String documentId,String userId,String token,ModelMap model) {
        model.addAttribute("id", id);
        model.addAttribute("documentId", documentId);
        model.addAttribute("userId", userId);
        model.addAttribute("token", token);
        return "nginxlog_search/nginxView";
    }

    //Tomcat日志检索页面
    @RequestMapping("/tomcatserachList")
    public String tomcatserachList(ModelMap model) {
        return "tomcatlog_search/list";
    }

    //Tomcat日志详情
    @RequestMapping("/tomcatView")
    public String tomcatView(String id,String documentId,String userId,String token,ModelMap model) {
        model.addAttribute("id", id);
        model.addAttribute("documentId", documentId);
        model.addAttribute("userId", userId);
        model.addAttribute("token", token);
        return "tomcatlog_search/tomcatView";
    }
    //操作日志检索页面
    @RequestMapping("/actserachList")
    public String actserachList(ModelMap model) {
        return "actlog_search/list";
    }

    //日志聚合页面
    @RequestMapping("/groupList")
    public String groupList(ModelMap model) {
        return "log_group/list";
    }

    //日志告警页面
    @RequestMapping("/waringList")
    public String waringList(ModelMap model) {
        return "log_waring/list";
    }

    //日志告警回溯分析页面
    @RequestMapping("/warningAnalysisView")
    public String warningAnalysisView(String id,String logType,ModelMap model) {
        model.addAttribute("id", id);
        model.addAttribute("logType", logType);
        return "log_waring/warningAnalysisView";
    }

    //日志告警处理页面
    @RequestMapping("/deal")
    public String deal(String id,String logType,ModelMap model) {
        model.addAttribute("id", id);
        model.addAttribute("logType", logType);
        return "log_waring/deal";
    }

    //日志告警处理页面
    @RequestMapping("/batchDeal")
    public String batchDeal(String ids,ModelMap model) {
        model.addAttribute("ids", ids);
        return "log_waring/batchDeal";
    }

    //日志告警规则新增
    @RequestMapping("/create")
    public String create(ModelMap model) {
        return "logwaring_setting/create";
    }

    //日志告警规则查看
    @RequestMapping("/view")
    public String view(String id,ModelMap model) {
        model.addAttribute("id", id);
        return "logwaring_setting/view";
    }

    //日志告警规则修改
    @RequestMapping("/edit")
    public String edit(String id,ModelMap model) {
        model.addAttribute("id", id);
        return "logwaring_setting/edit";
    }
    //日志数据分析页面
    @RequestMapping("/blankList")
    public String blankList(ModelMap model) {
        return "log_blank/list";
    }

    //日志数据分析页面
    @RequestMapping("/analysisList")
    public String analysisList(ModelMap model) {
        return "log_analysis/list";
    }

    //用户登录统计页面
    @RequestMapping("/loginList")
    public String loginList(ModelMap model) {
        return "log_view/loginList";
    }

    //日志数量分析
    @RequestMapping("/logNumList")
    public String logNumList(ModelMap model) {
        return "log_view/logNumList";
    }

    //日志告警分析
    @RequestMapping("/logWarningList")
    public String logWarningList(ModelMap model) {
        return "log_view/logWarningList";
    }

    //用户访问分析
    @RequestMapping("/accessList")
    public String accessList(ModelMap model) {
        return "log_view/accessList";
    }
    //日志仪表盘页面
    @RequestMapping("/dashboardList")
    public String dashboardList(ModelMap model) {
        return "log_dashboard/list";
    }

    //告警规则设置页面
    @RequestMapping("/waringsetList")
    public String waringsetList(ModelMap model) {
        return "logwaring_setting/list";
    }

    //日志保留设置页面
    @RequestMapping("/keepsetList")
    public String keepsetList(ModelMap model) {
        return "logkeeping_setting/list";
    }
    //日志文件格式设置
    @RequestMapping("/logPatternList")
    public String logPatternList(ModelMap model) {
        return "logpattern_setting/list";
    }
    //新增日志文件格式设置
    @RequestMapping("/createPattern")
    public String createPattern(ModelMap model) {
        return "logpattern_setting/create";
    }
    //修改日志文件格式设置
    @RequestMapping("/editPattern")
    public String editPattern(String id,ModelMap model) {
        model.addAttribute("id", id);
        return "logpattern_setting/edit";
    }
}
