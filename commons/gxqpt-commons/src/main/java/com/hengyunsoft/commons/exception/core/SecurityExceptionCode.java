package com.hengyunsoft.commons.exception.core;

import com.hengyunsoft.exception.code.BaseExceptionCode;

/***
 * 安全保障平台（gxqpt-pt项目）相关的异常代码
 * 安全保障平台 范围：95000-99999
 * @author yxl
 * @create-time 2018/07/02
 */
public enum SecurityExceptionCode implements BaseExceptionCode {

    ID_IS_NULL(95000,"主键不能为空"),
    PAGE_OPENAPIREQ(95001, "分页参数,不能为空"),
    PARAM_COLLECTION_EMPTY(95002,"集合参数不能为空"),
    PARAM_OBJECT_IS_NULL(95003,"参数不能为空"),
    ACTION_FAIL(95004,"操作失败"),
    ID_NOT_EXIST(95005,"主键不存在"),
    PROCESS_ID_IS_NULL(95006,"进程ID不能为空"),
    PROCESS_ID_NOT_EXIST(95007,"进程ID不存在"),
    SERVER_IP_IS_NULL(95008,"服务器IP不能为空"),
    PROCESS_NAME_IS_NULL(95009,"进程名称不能为空"),
    HANDLER_IS_NULL(95010,"处理人不能为空"),
    APPID_IS_NULL(95011,"模块ID不能为空"),
    IMPORTANT_COLUMN_LACK(95012,"重要字段缺失"),
    DATE_FORMAT_EXCETION(95013,"日期时间格式有误"),
    ERRORCOUNTMINUTE_EXCEPTION(95014,"每5分钟错误次数不能小于0"),
    UPPER_LIMITCOUNTBYDAY_EXCEPTION(95015,"每日上限次数不能小于0");

    SecurityExceptionCode(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }
    private int code;
    private String msg;
    @Override
    public int getCode() {
        return 0;
    }

    @Override
    public String getMsg() {
        return null;
    }
}
