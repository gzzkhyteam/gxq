package com.hengyunsoft.commons.exception.core;

import com.hengyunsoft.exception.code.BaseExceptionCode;

/**
 * 开发者平台（gxqpt-admin项目）相关的异常代码
 * 开发者平台异常编码 范围：75000~79999
 */
public enum DeveloperExceptionCode implements BaseExceptionCode {
    //模块申请 start
    SERVICE_MODULE_DOC(75000,"帮助文档不能为空"),
    SERVICE_MODULE_ID(75001,"帮助文档模块ID不能为空"),
    SERVICE_MODULE_DOC_ID(75002,"帮助文档ID不能为空"),
    SERVICE_MODULE_TITLE(75003,"帮助文档模块名称不能为空"),
    SERVICE_MODULE_CONTENT(75004,"帮助文档内容不能为空"),

    ASSIGN_MODULE_APPLY(75005,"模块数据不能为空"),
    ASSIGN_MODULE_APPLY_ID(75006,"ID不能为空"),
    ASSIGN_MODULE_ID(75007,"模块ID不能为空"),
    ASSIGN_MODULE_APP_ID(75008,"应用ID不能为空"),
    ASSIGN_MODULE_APPLY_DESC(75009,"申请描述不能为空"),
    ASSIGN_MODULE_APPR_DESC(75010,"审批描述不能为空"),
    ASSIGN_MODULE_APPR_STATUS(75011,"审批状态不能为空"),
    //模块申请  end

    // 我的功能申请  start
    MODULE_APPLY_NULL(76000, "我的功能申请信息不能为空"),
    MODULE_APPLY_ID_NULL(76001, "我的功能申请ID不能为空"),
    RESOURCES_MODULE_APPLY_EXIST(76002, "当前用户我的功能申请已经存在"),
    MODULE_APPLY_URL_NULL(76003, "我的功能申请API接口文档地址不能为空"),
    MODULE_APPLY_ICON_NULL(76004, "我的功能申请图标不能为空"),
    MODULE_APPLY_APP_ID_NULL(76005, "我的功能申请应用ID不能为空"),
    MODULE_APPLY_RESOURCE_ID_NULL(76006, "我的功能申请资源ID不能为空"),
    MODULE_APPLY_MODULE_NAME_NULL(76007, "我的功能申请功能名字不能为空"),
    MODULE_APPLY_MODULE_TYPE_NULL(76008, "我的功能申请功能类型不能为空"),
    MODULE_APPLY_MODULE_STATUS_NULL(76009, "我的功能申请功能状态不能为空"),
    MODULE_APPLY_PERSON_EMAIL_NULL(76010, "我的功能申请联系人邮箱不能为空"),
    MODULE_APPLY_PUBLIC_IS_NULL(76011, "我的功能申请是否公有模块不能为空"),
    MODULE_APPLY_PUBLIC_LOOK_NULL(76012, "我的功能申请是否公开模块不能为空"),
    MODULE_APPLY_DESC_NULL(76013, "我的功能申请功能描述不能为空"),
    MODULE_APPLY_SUCCESS_MODULE_ID_NULL(76014, "我的功能申请申请成功的模块id不能为空"),
    MODULE_APPLY_AUDITDESC_NULL(76015, "审批驳回的意见不能为空"),
    MODULE_APPLY_MODULE_MIX_HANDLE_TYPE_NULL(76016, "我的功能混合操作类型不能为空"),
    MODULE_APPLY_ADVISE_MODULE_ID_NULL(76017, "我的功能建议模块ID不能为空"),
    MODULE_APPLY_ADVISE_MODULE_NAME_NULL(76018, "我的功能建议模块名称不能为空"),

    // 我的功能申请  end

    // 应用/服务管理 start
    APPLICATION_APPID_NULL(76500, "应用/服务appid不能为空"),
    APPLICATION_NAME_NULL(76501, "应用/服务的名称不能为空"),
    APPLICATION_ID_NULL(76502, "应用/服务id不能为空"),
    APPLICATION_APPLY_ID_NULL(76503, "应用/服务申请id不能为空"),
    APPLICATION_APPLY_APPSTATUS_NULL(76504, "应用/服务申请状态不能为空"),
    APPLICATION_AUDITDESC_NULL(76505,"审批驳回的批注不能为空"),
    APPLICATION_CODE_NULL(76506,"应用code不能为空"),
    APPLICATION_TYPE_NULL(76507,"应用类型不能为空"),
    //应用依赖关系新增
    APPLICATION_PRODUCER_NAME_NULL(76508, "所依赖应用名称不能为空"),
    APPLICATION_PRODUCER_ID_NULL(76509, "所依赖应用id不能为空"),
    APPLICATION_RELATION_ID_NULL(76510, "依赖关系id不能为空"),
    // 应用/服务管理 end

    // 服务资源管理  start
    SERVICE_RESOURCE_MODULE_ID_NULL(76800, "服务资源模块ID不能为空"),
    SERVICE_RESOURCE_DOC_ID_NULL(76801, "服务资源文档ID不能为空"),
    // 服务资源管理  end

    //部署内容 start
    INSTALL_ID_NULL(77000,"部署内容id不能为空"),
    INSTALL_APPID_NULL(77001,"部署内容的应用id不能为空"),
    INSTALL_PATH_NULL(77002,"部署的路径不能为空"),
    INSTALL_MEM_NULL(77003,"部署所分配内存不能为空"),
    INSTALL_HARDDISK_NULL(77004,"部署所分配硬盘容量不能为空"),
    INSTALL_URL_NULL(77005,"首页访问地址不能为空"),
    INSTALL_HOST_NULL(77006,"部署主机不能为空"),
    //部署内容 end

    //功能统计 start
    FUNCTION_STATISTICS_APP_ID_NULL(77500,"功能统计appId不能为空"),
    FUNCTION_STATISTICS_MODULE_ID_NULL(77501,"功能统计moduleId不能为空"),
    FUNCTION_STATISTICS_START_TIME_NULL(77502,"功能统计开始时间不能为空"),
    FUNCTION_STATISTICS_END_TIME_NULL(77503,"功能统计结束时间不能为空"),
    FUNCTION_STATISTICS_TIME_SCALE_NULL(77504,"功能统计时间刻度不能为空"),
    //功能统计 end

    //主机管理start
    HOST_ID_NULL(78000,"主机id不能为空"),
    HOST_STATUS_NULL(78001,"主机状态不能为空"),
    HOST_USER_ID_NULL(78002,"用户id不能为空"),
    HOST_ASSIGN_ID_NULL(78003,"用户角色关联id不能为空"),
    //主机管理end

    //快速开发start
    FAST_APPLICATION_ID_NULL(78500,"我的快速应用ID不能为空"),
    FAST_APPLICATION_STATUS_NULL(78501,"我的快速应用启用状态不能为空"),
    FAST_MENU_ID_NULL(78503,"我的快速应用菜单ID不能为空"),
    FAST_MENU_APP_ID_NULL(78504,"我的快速应用菜单appID不能为空"),
    FAST_MENU_PARENT_ID_NULL(78505,"我的快速应用菜单父ID不能为空"),

    //快速开发end
    ;

    private int code;
    private String msg;

    DeveloperExceptionCode(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    @Override
    public int getCode() {
        return code;
    }

    @Override
    public String getMsg() {
        return msg;
    }
}
