package com.hengyunsoft.commons.constant;

/**
 * 删除状态
 *
 * @author tyh
 * @createTime 2017-12-13 10:08
 */
public enum DeleteStatus {
    DELETE(true, 1, "已删除"),
    UN_DELETE(false, 0, "未删除"),;

    /**  */
    private Boolean val;
    private int status;
    /**  */
    private String describe;

    DeleteStatus(Boolean val, int status,  String describe) {
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

    public static DeleteStatus parse(Boolean val) {
        if (val == null) {
            return DELETE;
        }
        for (DeleteStatus status : DeleteStatus.values()) {
            if (status.getVal().equals(val)) {
                return status;
            }
        }
        return DELETE;
    }
}
