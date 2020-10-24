package com.hengyunsoft.platform.hardware.constant;

public enum  ScriptEnum {
    IP("config_ip"),
    SERVERID("config_serverId");

    private String msg;

    ScriptEnum(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }
}
