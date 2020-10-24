package com.hengyunsoft.platform.mail.entity.po;

import com.hengyunsoft.base.entity.BaseEntity;
import java.io.Serializable;
import java.util.Date;

public class BWList extends BaseEntity<Long> implements Serializable {
    /**
     * 黑名单
     */
    public static  final String BWTYPE1 = "black";
    /**
     * 白名单
     */
    public static  final String BWTYPE2 = "white";
    /**
     * 邮件
     */
    public static  final String LOTYPE1 = "email";
    /**
     * ip
     */
    public static  final String LOTYPE2 = "ip";
    /**
     * 域名
     */
    public static  final String LOTYPE3 = "field";


    /**
     * 主键id
     *
     * @mbggenerated
     */
    private Long id;

    /**
     * 名单类型 black、黑名单 white、白名单
     *
     * @mbggenerated
     */
    private String bwType;

    /**
     * 地址类型 email、邮件 ip、IP field、域名
     *
     * @mbggenerated
     */
    private String locateType;

    /**
     * 地址值  比如：邮件地址、IP地
     *
     * @mbggenerated
     */
    private String value;

    /**
     * 当前账号  登录用户的账号
     *
     * @mbggenerated
     */
    private String currentEmail;

    /**
     * 创建人
     *
     * @mbggenerated
     */
    private Long createUser;

    /**
     * 创建时间
     *
     * @mbggenerated
     */
    private Date createTime;

    /**
     * 更新人
     *
     * @mbggenerated
     */
    private Long updateUser;

    /**
     * 更新时间
     *
     * @mbggenerated
     */
    private Date updateTime;

    private static final long serialVersionUID = 1L;

    /**
     * 主键id
     *
     * @mbggenerated
     */
    public Long getId() {
        return id;
    }

    /**
     * 主键id
     *
     * @mbggenerated
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 名单类型 black、黑名单 white、白名单
     *
     * @mbggenerated
     */
    public String getBwType() {
        return bwType;
    }

    /**
     * 名单类型 black、黑名单 white、白名单
     *
     * @mbggenerated
     */
    public void setBwType(String bwType) {
        this.bwType = bwType == null ? null : bwType.trim();
    }

    /**
     * 地址类型 email、邮件 ip、IP field、域名
     *
     * @mbggenerated
     */
    public String getLocateType() {
        return locateType;
    }

    /**
     * 地址类型 email、邮件 ip、IP field、域名
     *
     * @mbggenerated
     */
    public void setLocateType(String locateType) {
        this.locateType = locateType == null ? null : locateType.trim();
    }

    /**
     * 地址值  比如：邮件地址、IP地
     *
     * @mbggenerated
     */
    public String getValue() {
        return value;
    }

    /**
     * 地址值  比如：邮件地址、IP地
     *
     * @mbggenerated
     */
    public void setValue(String value) {
        this.value = value == null ? null : value.trim();
    }

    /**
     * 当前账号  登录用户的账号
     *
     * @mbggenerated
     */
    public String getCurrentEmail() {
        return currentEmail;
    }

    /**
     * 当前账号  登录用户的账号
     *
     * @mbggenerated
     */
    public void setCurrentEmail(String currentEmail) {
        this.currentEmail = currentEmail == null ? null : currentEmail.trim();
    }

    /**
     * 创建人
     *
     * @mbggenerated
     */
    public Long getCreateUser() {
        return createUser;
    }

    /**
     * 创建人
     *
     * @mbggenerated
     */
    public void setCreateUser(Long createUser) {
        this.createUser = createUser;
    }

    /**
     * 创建时间
     *
     * @mbggenerated
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 创建时间
     *
     * @mbggenerated
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 更新人
     *
     * @mbggenerated
     */
    public Long getUpdateUser() {
        return updateUser;
    }

    /**
     * 更新人
     *
     * @mbggenerated
     */
    public void setUpdateUser(Long updateUser) {
        this.updateUser = updateUser;
    }

    /**
     * 更新时间
     *
     * @mbggenerated
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * 更新时间
     *
     * @mbggenerated
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}