package com.hengyunsoft.commons.exception.core;

import com.hengyunsoft.exception.code.BaseExceptionCode;

/**
 * 统一监管平台异常 编码 范围：  110000-114999
 */
public enum SuperviseExceptionCode implements BaseExceptionCode{

    //全责类型管理相关 start
    SUPERVISE_TYPE_ID_NULL(110000,"权责类型id不能为空"),
    SUPERVISE_DRAG_EXIST(110001,"拖动位置不正确"),
    SUPERVISE_DRAG_ID_EXIST(110002,"获取当前拖动类型不正确"),
    SUPERVISE_POWER_NAME_NULL(110003,"全责类型名称不能为空"),
    SUPERVISE_POWER_CODE_NULL(110004,"全责类型编码不能为空"),
    //全责类型管理相关 end

    //权责监管 start
    POWER_SUPERVISE_ID_NULL(110100,"权责监管id不能为空"),
    POWER_SUPERVISE_CODE_NULL(110101,"权责编码不能为空"),
    POWER_SUPERVISE_TYPE_NULL(110102,"权责类型不能为空"),
    POWER_SUPERVISE_NAME_NULL(110103,"权责名称不能为空"),
    POWER_SUPERVISE_UNIT_NULL(110104,"执行单位不能为空"),

    //权责监管 end

    //权责监管环节 start
    POWER_SUPERVISE_LINK_ID_NULL(110120,"权责监管环节ID不能为空"),
    POWER_SUPERVISE_LINK_CODE_NULL(110121,"环节编码不能为空"),
    POWER_SUPERVISE_LINK_NAME_NULL(110122,"环节名称不能为空"),
    POWER_SUPERVISE_LINK_TIME_LIMIT_NULL(110123,"时长阀值不能为空"),
    POWER_SUPERVISE_LINK_BIZ_ID_NULL(110124,"业务ID不能为空"),
    POWER_SUPERVISE_APP_ID_NULL(110125,"应用ID不能为空"),
    POWER_SUPERVISE_APP_NAME_NULL(110126,"应用名称不能为空"),

    //---------  共有部分代码   -------------
    SUPERVISE_DUTY_USER_NULL(110124,"责任人不能为空"),
    SUPERVISE_CONFIRM_USER_NULL(110125,"确认人不能为空"),
    SUPERVISE_REMIND_TYPE_NULL(110126,"提醒方式不能为空"),
    SUPERVISE_TYPE_NULL(110127,"监管方式不能为空"),
    SUPERVISE_RUN_STATUS_NULL(110128,"运行状态不能为空"),
    POWER_SUPERVISE_LINK_DESC_NULL(110129,"环节描述不能为空"),
    POWER_SUPERVISE_LINK_START_TIME_NULL(110130,"开始时间不能为空"),
    POWER_SUPERVISE_LINK_END_TIME_NULL(110131,"结束时间不能为空"),
    //权责监管环节 end

    //接口监管 start
    SERVER_SUPERVISE_ID_NULL(110140,"服务监管ID不能为空"),
    SERVER_SUPERVISE_SERVER_ID_NULL(110141,"服务监管所属服务ID不能为空"),
    //INTERFACE_SUPERVISE_URL_NULL(110142,"接口监管地址不能为空"),
    //INTERFACE_SUPERVISE_NAME_NULL(110143,"接口监管名称不能为空"),
    SERVER_SUPERVISE_WARN_LIMIT_NULL(110144,"服务监管上限阀值不能为空"),
    SERVER_SUPERVISE_LIMIT_CYCLE_NULL(110145,"服务监管阀值周期不能为空"),
    SERVER_SUPERVISE_CODE_NULL(110146,"服务监管服务编码不能为空"),

    //接口监管 end

    ;

    private int code;
    private String msg;

    SuperviseExceptionCode(int code, String msg) {
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
