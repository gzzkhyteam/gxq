package com.hengyunsoft.platform.security.entity.backups.po;

import com.hengyunsoft.base.entity.CommonBaseEntity;
import java.io.Serializable;
import java.util.Date;

public class BackupsLog extends CommonBaseEntity<Long> implements Serializable {
    private Long id;

    private String appId;

    private Long backupsId;

    private Date createTime;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId == null ? null : appId.trim();
    }

    public Long getBackupsId() {
        return backupsId;
    }

    public void setBackupsId(Long backupsId) {
        this.backupsId = backupsId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}