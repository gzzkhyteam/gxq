package com.hengyunsoft.platform.supervise.impl.constant;

public enum OrgPublicEnum {
    ORG("org"),
    DPM("department"),
    EMP("emp"),
    USER("user"),
    APP("app"),;
    private String msg;

    public String getMsg() {
        return msg;
    }

    OrgPublicEnum(String msg) {
        this.msg = msg;
    }

    public static OrgPublicEnum getEnum(String msg) {
        for (OrgPublicEnum orgPublicEnum : OrgPublicEnum.values()) {
            if (msg.equals(orgPublicEnum.getMsg())) {
                return orgPublicEnum;
            }
        }
        return null;
    }
}
