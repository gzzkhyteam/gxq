package com.hengyunsoft.platform.file.entity.file.po;

import com.hengyunsoft.base.entity.CommonBaseEntity;
import java.io.Serializable;
import java.util.Date;

public class FileUserNum extends CommonBaseEntity<Long> implements Serializable {
    private Long id;

    /**
     * 应用id
     *
     * @mbggenerated
     */
    private String appId;

    /**
     * 文件类型 云盘数据:pan  接口数据:api
     *
     * @mbggenerated
     */
    private String type;

    /**
     * 数据类型 image/video/audio/doc/other/DIR
     *
     * @mbggenerated
     */
    private String dataType;

    /**
     * 数量
     *
     * @mbggenerated
     */
    private String num;

    /**
     * 年月
     *
     * @mbggenerated
     */
    private String fyearMonth;

    private Date createTime;

    private Long createUser;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 应用id
     *
     * @mbggenerated
     */
    public String getAppId() {
        return appId;
    }

    /**
     * 应用id
     *
     * @mbggenerated
     */
    public void setAppId(String appId) {
        this.appId = appId == null ? null : appId.trim();
    }

    /**
     * 文件类型 云盘数据:pan  接口数据:api
     *
     * @mbggenerated
     */
    public String getType() {
        return type;
    }

    /**
     * 文件类型 云盘数据:pan  接口数据:api
     *
     * @mbggenerated
     */
    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    /**
     * 数据类型 image/video/audio/doc/other/DIR
     *
     * @mbggenerated
     */
    public String getDataType() {
        return dataType;
    }

    /**
     * 数据类型 image/video/audio/doc/other/DIR
     *
     * @mbggenerated
     */
    public void setDataType(String dataType) {
        this.dataType = dataType == null ? null : dataType.trim();
    }

    /**
     * 数量
     *
     * @mbggenerated
     */
    public String getNum() {
        return num;
    }

    /**
     * 数量
     *
     * @mbggenerated
     */
    public void setNum(String num) {
        this.num = num == null ? null : num.trim();
    }

    /**
     * 年月
     *
     * @mbggenerated
     */
    public String getFyearMonth() {
        return fyearMonth;
    }

    /**
     * 年月
     *
     * @mbggenerated
     */
    public void setFyearMonth(String fyearMonth) {
        this.fyearMonth = fyearMonth == null ? null : fyearMonth.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Long getCreateUser() {
        return createUser;
    }

    public void setCreateUser(Long createUser) {
        this.createUser = createUser;
    }
}