package com.hengyunsoft.commons.constant;

/**
 * 布尔类型状态码
 * @author tyh
 */
public enum BooleanStatus {
    TRUE(true, "是"),
    FALSE(false, "否"),;
    /** 值 */
    private Boolean val;
    /** 描述 */
    private String describe;

    BooleanStatus(Boolean val, String describe) {
        this.val = val;
        this.describe = describe;
    }

    public Boolean getVal() {
        return val;
    }

    public String getDescribe() {
        return describe;
    }

    public static BooleanStatus parse(Boolean val) {
        if (val == null) {
            return FALSE;
        }
        for (BooleanStatus status : BooleanStatus.values()) {
            if (status.getVal().equals(val)) {
                return status;
            }
        }
        return FALSE;
    }
}
