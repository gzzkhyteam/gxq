package com.hengyunsoft.commons.exception.core;

import com.hengyunsoft.exception.code.BaseExceptionCode;

/***
 *
 * 运维服务平台（gxqpt-ops项目）相关的异常代码
 *  运维服务平台 异常编码 范围：  105000-109999
 *  @author tianai
 * @createTime 2018-07-13
 */
public enum OperationExceptionCode implements BaseExceptionCode {
    //运维人员管理
    USER_ID_NULL(105000, "运维人员id不能为空"),
    CONTENT_NULL(105001, "负责内容不能为空"),
    SYETEM_NAME_NULL(105002, "运维人员id不能为空"),



    //应用升级信息管理
    SYSTEM_NAME_NULL(105010, "系统名称不能为空"),
    VERSION_NUMBER_NULL(105011, "版本号不能为空"),
    VERSION_NAME_NULL(105012, "版本名称不能为空"),
    PUBLISHING_SERVER_NULL(105013, "发布服务器地址不能为空"),
    PUBLISHING_STATUS_NULL(105014, "启用状态不能为空"),
    UPGRADE_CONTENT_NULL(105015, "升级内容不能为空"),


    //咨询管理
    CONSULT_NAME(105020, "咨询名称不能为空"),
    CONSULT_TIME(105021, "咨询时间不能为空"),
    CONSULT_INFO(105022, "咨询内容不能为空"),
    SERVICE_ATTITUDE(105023, "服务态度不能为空"),
    SERVICE_EFFICIENCY(105024, "服务效率不能为空"),
    SERVICE_QUALITY(105025, "服务质量不能为空"),
    CONSULT_ADVICE(105025, "咨询建议不能为空"),
    DEAL_RESULT(105026,"处理结果不能为空"),
    PAGE_PARAMS(105027,"分页参数不能为空"),
    CONSULT_ID(105028,"咨询ID不能为空"),

    //服务目录管理
    PID_ID_NULL(105030, "父id不能为空"),
    SORT_NULL(105031, "排序不能为空"),
    LEVEL_NULL(105032, "层级不能为空"),
    TYPE_NULL(105033, "类型不能为空"),
    LSERVICE_NAME_NULL(105034, "服务名称不能为空"),
    SERVICE_TYPE_NULL(105035, "服务类别不能为空"),
    SERVICE_OBJ_NULL(105036, "服务对象不能为空"),
    SERVICE_CLASS_NULL(105037, "服务分类不能为空"),
    SERVICE_NAME_NULL(105038, "服务名称不能为空"),

    SERVICE_ID_NULL(105039, "服务申请id不能为空"),
    SERVICE_RESULT_NULL(105040, "审批结果不能为空"),
    AUDIT_OPINION_NULL(105041, "审批意见不能为空"),
    DEAL_USER_NAME_NULL(105042, "协助人不能为空"),
    DEAL_USER_NULL(105043, "处理人不能为空"),
    SERVICE_PROCESS_NULL(105044, "服务过程不能为空"),
    DEAL_RESULT_NULL(105045, "处理结果不能为空"),
    SERVICE_ATTITUDE_NULL(105046, "服务态度不能为空"),
    SERVICE_EFFICIENCY_NULL(105047, "服务效率不能为空"),
    SERVICE_EVALUATION_NULL(105048, "服务质量不能为空"),

    //服务故障管理
    FAULT_NAME_NULL(105049, "故障名称不能为空"),
    FAULT_PC_NULL(105050, "故障主机不能为空"),
    FAULT_PROCESS_NULL(105051,"处理过程不能为空"),
    FAULT_RESULT_NULL(105052,"处理结果不能为空"),
    DEAL_OPINION_NULL(105053,"处理建议不能为空"),
    FAULT_TIME_TYPE_NULL(105054,"时间参数类型不能为空"),
    FAULT_APPID_NOT_NULL(105055,"应用appId不能为空"),
    FAULT_PARAM_OBJECT_NULL(105056,"参数对象不能为空"),

    //告警管理
    ALARM_NAME_NULL(105070,"告警名称不能为空"),
    ALARM_LEVEL_NULL(105071,"告警级别不能为空"),
    ALARM_TYPE_NULL(105072,"告警类型不能为空"),
    ALARM_TASK_TYPE_NULL(105073,"任务类型不能为空"),
    ALARM_DAY_NULL(105074,"告警天数不能为空"),

    //日志管理
    LOG_ID__NULL(105075,"id不能为空"),
    LOG_TYPE_NULL(105076,"日志类别不能为空"),
    LOG_RECORD_NULL(105077,"日志记录不能为空"),
    LOG_FAULT_LEVEL_TYPE_NULL(105078,"故障级别不能为空"),
    LOG_FAULT_CLASSIFICATION_NULL(105079,"故障分类不能为空"),
    LOG_DEAL_USER_NULL(105080,"日志管理故障处理人不能为空"),
    LOG_DEAL_TIME_NULL(105081,"日志管理故障处理时间分类不能为空"),









    ;
    private int code;
    private String msg;

    OperationExceptionCode(int code, String msg) {
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
