package com.hengyunsoft.commons.exception.core;

import com.hengyunsoft.exception.code.BaseExceptionCode;

/**
 * 日志服务异常代码
 * 从65000~69999, 每个子模块加500， 每个异常代码+1
 */
public enum LogsExceptionCode implements BaseExceptionCode {
    ID_NULL(65000, "ID不允许为空"),

    FILE_NULL(65001, "上传日志文件不允许为空"),
    FILE_NAME_EMPTY(65002,"文件名称不允许为空"),
    LOG_TYPE_EMPTY(65003,"文件类型不允许为空"),
    LOG_DOCUMENT_EMPTY(65004,"文档ID不允许为空"),
    LOG_DATA_CHANNEL(65005,"采集渠道不允许为空"),
    ENTITY_NULL(65006, "实体对象未获取到值"),

    WARN_RESULT_NULL(65500,"处理意见不能为空"),
    WARN_IDS_NULL(65501,"处理记录IDS不能为空"),

    LOG_STARTTIME_EMPTY(66001,"开始时间不能为空"),
    LOG_ENDTIME_EMPTY(66002,"结束时间不能为空"),

    DATE_FORMAT_ERROR(66500, "日期格式不正确，格式应为 yyyy-MM-dd HH:mm:ss"),
    CONTENT_TOO_LONG(66501,"内容超长"),
    LOG_LEVEL_VALUE(66502,"日志级别可选值为：INFO|DEBUG|WARN|ERROR|FATAL"),
    LOG_TYPE_VALUE(66503,"日类型可选值：APACHE|NGINX|TOMCAT|APP"),
    TIME_NOT_EXIST(66504,"未找到删除时间段的数据"),
    EXECUTE_FAIL(66505,"操作失败"),

    ;
    private int code;
    private String msg;

    LogsExceptionCode(int code, String msg) {
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
