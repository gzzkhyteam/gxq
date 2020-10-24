package com.hengyunsoft.platform.security.repository.constant;

/**
 * 处理状态枚举
 * @author yxl
 * @created 2018-07-11
 */
public enum HandleStatus {
    UNHANDLE_STATUS(0),HANDLED_STATUS(1);
    private int value;
    HandleStatus(int value){
        this.value = value;
    }
    public int getValue() {
        return value;
    }
}
