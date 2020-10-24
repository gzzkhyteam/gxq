package com.hengyunsoft.platform.supervise.impl.constant;

/**
 * 脚本替换枚举
 */
public enum ScriptEnum {
    IP("config_ip"),
    ID("config_id"),
    FILEURL("config_fileurl"),
    LOGURL("config_logurl"),
    DBURL("config_dburl");

    private String msg;

    ScriptEnum(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }
}
