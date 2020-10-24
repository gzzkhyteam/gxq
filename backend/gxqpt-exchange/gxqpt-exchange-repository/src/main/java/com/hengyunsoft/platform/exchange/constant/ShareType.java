package com.hengyunsoft.platform.exchange.constant;

public enum ShareType {
    DIR_ORG_TYPE("ORG","部门"),
    DIR_DOMAIN_TYPE("domain","领域");
    private String val;
    private String describe;
    ShareType(String val, String describe) {
        this.val = val;
        this.describe = describe;
    }
    public String getVal() {
        return val;
    }

    public String getDescribe() {
        return describe;
    }
}
