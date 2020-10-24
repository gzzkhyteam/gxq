package com.hengyunsoft.commons.exception.core;

import com.hengyunsoft.exception.code.BaseExceptionCode;
/**
 * 邮件服务异常代码
 * 从40000~44999, 每个子模块加500， 每个异常代码+1
 */
public enum MailExceptionCode implements BaseExceptionCode {


    ACCOUNT_NOT_NULL(40000, "账号不能为空"),
    ACCOUNT_EXIST(40001, "账号已经存在"),
    USER_INFO_GET_ERROR(40002, "无法获取用户信息"),

    SEARCH_KEYWORD_NOT_NULL(40500, "搜索条件不能为空"),

    MAIL_NOT_EXIST(41000, "邮件不存在"),
    FILE_LOAD_ERROR(41001, "附件读取异常"),

    PARAM_NOT_NULL(42000,"参数不能为空"),

    BWID_NOT_NULL(43000,"黑白名单id不能为空"),
    ;
    private int code;
    private String msg;

    MailExceptionCode(int code, String msg) {
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