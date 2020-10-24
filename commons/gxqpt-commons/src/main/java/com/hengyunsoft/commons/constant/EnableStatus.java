package com.hengyunsoft.commons.constant;

/**
 * @author tyh
 * @createTime 2017-12-13 10:08
 */
public enum EnableStatus {

    ENABLE(true, 1, "启用"),
    DISABLE(false, 0, "禁用"),;

    /**  */
    private Boolean val;
    private int status;
    /**  */
    private String describe;

    EnableStatus(Boolean val, int status, String describe) {
        this.val = val;
        this.status = status;
        this.describe = describe;
    }

    public Boolean getVal() {
        return val;
    }

    public String getDescribe() {
        return describe;
    }

    public int getStatus() {
        return status;
    }

    public static EnableStatus parse(Boolean val) {
        if (val == null) {
            return DISABLE;
        }
        for (EnableStatus status : EnableStatus.values()) {
            if (status.getVal().equals(val)) {
                return status;
            }
        }
        return DISABLE;
    }
}
