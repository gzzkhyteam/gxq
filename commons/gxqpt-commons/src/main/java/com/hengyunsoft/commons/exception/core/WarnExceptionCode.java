package com.hengyunsoft.commons.exception.core;

import com.hengyunsoft.exception.code.BaseExceptionCode;

/**
 *
 */
public enum WarnExceptionCode implements BaseExceptionCode{

    //预警信息管理相关 start
    WARN_ID_NULL(30000,"预警信息id为空"),
    //预警信息管理相关 end

    //预警类型管理相关 start
    WARN_TYPE_ID_NULL(31000,"预警类型信息id为空"),
    WARN_TYPE_DRAG_EXIST(31001,"拖动位置不正确"),
    WARN_TYPE_DRAG_ID_EXIST(31002,"获取当前拖动类型不正确"),
    WARN_TYPE_NAME_EMPTY(31003,"预警类型名称不能为空"),
    WARN_TYPE_CODE_EMPTY(31004,"预警类型编码不能为空"),
    //预警类型管理相关 end

    //预警平台分析相关 start
    ANALYSIS_PUBLIC_ID_NULL(31500,"组织机构公用id为空"),
    //预警平台分析相关 end

    //统一监管配置中心 start
    BIZ_APP_DUTY_USER_NULL(32000,"责任人为空"),
    BIZ_APP_CONFIRM_USER_NULL(32001,"确认人为空"),
    BIZ_APP_ONLINE_LIMIT_NULL(32002,"同时在线数为空"),
    BIZ_APP_SUPERVISE_TYPE_NULL(32003,"监管方式为空"),
    BIZ_APP_REMIND_TYPE_NULL(32004,"提醒方式为空"),
    BIZ_APP_RUN_STATUS_NULL(32005,"运行状态为空"),
    BIZ_APP_ID_NULL(32006,"配置id为空"),
    BIZ_APP_APPIDS_NULL(32007,"管理应用集合为空"),
    BIZ_APP_ID_NON_EXISTENT(32008,"配置id不存在"),
    //统一监管配置中心 end
    ;

    private int code;
    private String msg;

    WarnExceptionCode(int code, String msg) {
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
