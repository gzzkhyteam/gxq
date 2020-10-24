package com.hengyunsoft.platform.admin.entity.org.gxqpt.domain;

public class GxqptOrgByExchangeReqDO {
    private String id;
    private String isenable = "1";
    private String isdelete = "0";

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIsenable() {
        return isenable;
    }

    public void setIsenable(String isenable) {
        this.isenable = isenable;
    }

    public String getIsdelete() {
        return isdelete;
    }

    public void setIsdelete(String isdelete) {
        this.isdelete = isdelete;
    }
}
