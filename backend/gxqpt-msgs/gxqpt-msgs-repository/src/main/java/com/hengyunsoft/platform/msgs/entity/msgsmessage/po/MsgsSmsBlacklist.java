package com.hengyunsoft.platform.msgs.entity.msgsmessage.po;

import com.hengyunsoft.base.entity.BaseEntity;
import java.io.Serializable;
import java.util.Date;

public class MsgsSmsBlacklist extends BaseEntity<Long> implements Serializable {
    /**
     * 主键id
     *
     * @mbggenerated
     */
    private Long id;

    /**
     * 应用程序id
     *
     * @mbggenerated
     */
    private String appId;

    /**
     * 登录账号
     *
     * @mbggenerated
     */
    private String nickname;

    /**
     * 用户姓名
     *
     * @mbggenerated
     */
    private String name;

    /**
     * 用户id
     *
     * @mbggenerated
     */
    private Long gxqptEmpId;

    /**
     * 所在部门名称
     *
     * @mbggenerated
     */
    private String maindeptname;

    /**
     * 创建人ID
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
     * 应用程序id
     *
     * @mbggenerated
     */
    public String getAppId() {
        return appId;
    }

    /**
     * 应用程序id
     *
     * @mbggenerated
     */
    public void setAppId(String appId) {
        this.appId = appId == null ? null : appId.trim();
    }

    /**
     * 登录账号
     *
     * @mbggenerated
     */
    public String getNickname() {
        return nickname;
    }

    /**
     * 登录账号
     *
     * @mbggenerated
     */
    public void setNickname(String nickname) {
        this.nickname = nickname == null ? null : nickname.trim();
    }

    /**
     * 用户姓名
     *
     * @mbggenerated
     */
    public String getName() {
        return name;
    }

    /**
     * 用户姓名
     *
     * @mbggenerated
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 用户id
     *
     * @mbggenerated
     */
    public Long getGxqptEmpId() {
        return gxqptEmpId;
    }

    /**
     * 用户id
     *
     * @mbggenerated
     */
    public void setGxqptEmpId(Long gxqptEmpId) {
        this.gxqptEmpId = gxqptEmpId;
    }

    /**
     * 所在部门名称
     *
     * @mbggenerated
     */
    public String getMaindeptname() {
        return maindeptname;
    }

    /**
     * 所在部门名称
     *
     * @mbggenerated
     */
    public void setMaindeptname(String maindeptname) {
        this.maindeptname = maindeptname == null ? null : maindeptname.trim();
    }

    /**
     * 创建人ID
     *
     * @mbggenerated
     */
    public Long getCreateUser() {
        return createUser;
    }

    /**
     * 创建人ID
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
}