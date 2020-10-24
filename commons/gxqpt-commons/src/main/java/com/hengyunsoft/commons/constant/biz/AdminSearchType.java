package com.hengyunsoft.commons.constant.biz;


public enum AdminSearchType {
    APPLICATION("应用"), //应用
    MENU("菜单"),  //菜单
    MSG("消息"), //消息
    ;

    private AdminSearchType(String describe) {
        this.describe = describe;
    }

    private String describe;

    public String getDescribe() {
        return describe;
    }
}
