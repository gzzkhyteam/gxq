package com.hengyunsoft.platform.admin.entity.core.po;

import com.hengyunsoft.base.entity.BaseEntity;

import java.io.Serializable;
import java.util.Date;

public class OrgBaseInfo  implements Serializable {
    /**
     * 组织Id
     */
    private Long id;

    /**
     * 组织名称
     */
    private String name;

    /**
     * 体系code
     */
    private String sysCode;



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSysCode() {
        return sysCode;
    }

    public void setSysCode(String sysCode) {
        this.sysCode = sysCode;
    }


}