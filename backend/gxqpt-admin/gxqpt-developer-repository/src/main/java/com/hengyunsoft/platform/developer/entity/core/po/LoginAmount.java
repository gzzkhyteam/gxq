package com.hengyunsoft.platform.developer.entity.core.po;

import com.hengyunsoft.base.entity.BaseEntity;
import com.hengyunsoft.validator.annotation.FieldDesc;
import java.io.Serializable;
import java.util.Date;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;

public class LoginAmount extends BaseEntity<Long> implements Serializable {
    /**
     * 主键
     *
     * @mbggenerated
     */
    @FieldDesc("主键")
    @Range(min=Long.MIN_VALUE,max=Long.MAX_VALUE)
    private Long id;

    /**
     * 登录应用id
     *
     * @mbggenerated
     */
    @FieldDesc("登录应用id")
    @Length(max=64)
    private String appId;

    /**
     * 登录应用名称
     *
     * @mbggenerated
     */
    @FieldDesc("登录应用名称")
    @Length(max=64)
    private String appName;

    /**
     * 登录人
     *
     * @mbggenerated
     */
    @FieldDesc("登录人")
    @Range(min=Long.MIN_VALUE,max=Long.MAX_VALUE)
    private Long userId;

    /**
     * 登录人名称
     *
     * @mbggenerated
     */
    @FieldDesc("登录人名称")
    @Length(max=64)
    private String userName;

    /**
     * 登录时间
     *
     * @mbggenerated
     */
    @FieldDesc("登录时间")
    private Date loginTime;

    /**
     * 退出时间
     *
     * @mbggenerated
     */
    @FieldDesc("退出时间")
    private Date logoutTime;

    /**
     * 主要登录（进入我们系统需要输入密码那一次，当用户登录其中一个系统后，后续的系统将不再进行登录，除非退出。）
     *
     * @mbggenerated
     */
    @FieldDesc("主要登录（进入我们系统需要输入密码那一次，当用户登录其中一个系统后，后续的系统将不再进行登录，除非退出。）")
    private Boolean masterLoginIs;

    /**
     * 主要登录id
     *
     * @mbggenerated
     */
    @FieldDesc("主要登录id")
    @Range(min=Long.MIN_VALUE,max=Long.MAX_VALUE)
    private Long masterLoginId;

    /**
     * 登陆ip地址
     *
     * @mbggenerated
     */
    @FieldDesc("登陆ip地址")
    @Length(max=16)
    private String loginIp;

    /**
     * 登录账号
     *
     * @mbggenerated
     */
    @FieldDesc("登录账号")
    @Length(max=50)
    private String account;

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     *
     * @mbggenerated
     */
    public Long getId() {
        return id;
    }

    /**
     * 主键
     *
     * @mbggenerated
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 登录应用id
     *
     * @mbggenerated
     */
    public String getAppId() {
        return appId;
    }

    /**
     * 登录应用id
     *
     * @mbggenerated
     */
    public void setAppId(String appId) {
        this.appId = appId == null ? null : appId.trim();
    }

    /**
     * 登录应用名称
     *
     * @mbggenerated
     */
    public String getAppName() {
        return appName;
    }

    /**
     * 登录应用名称
     *
     * @mbggenerated
     */
    public void setAppName(String appName) {
        this.appName = appName == null ? null : appName.trim();
    }

    /**
     * 登录人
     *
     * @mbggenerated
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * 登录人
     *
     * @mbggenerated
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * 登录人名称
     *
     * @mbggenerated
     */
    public String getUserName() {
        return userName;
    }

    /**
     * 登录人名称
     *
     * @mbggenerated
     */
    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    /**
     * 登录时间
     *
     * @mbggenerated
     */
    public Date getLoginTime() {
        return loginTime;
    }

    /**
     * 登录时间
     *
     * @mbggenerated
     */
    public void setLoginTime(Date loginTime) {
        this.loginTime = loginTime;
    }

    /**
     * 退出时间
     *
     * @mbggenerated
     */
    public Date getLogoutTime() {
        return logoutTime;
    }

    /**
     * 退出时间
     *
     * @mbggenerated
     */
    public void setLogoutTime(Date logoutTime) {
        this.logoutTime = logoutTime;
    }

    /**
     * 主要登录（进入我们系统需要输入密码那一次，当用户登录其中一个系统后，后续的系统将不再进行登录，除非退出。）
     *
     * @mbggenerated
     */
    public Boolean getMasterLoginIs() {
        return masterLoginIs;
    }

    /**
     * 主要登录（进入我们系统需要输入密码那一次，当用户登录其中一个系统后，后续的系统将不再进行登录，除非退出。）
     *
     * @mbggenerated
     */
    public void setMasterLoginIs(Boolean masterLoginIs) {
        this.masterLoginIs = masterLoginIs;
    }

    /**
     * 主要登录id
     *
     * @mbggenerated
     */
    public Long getMasterLoginId() {
        return masterLoginId;
    }

    /**
     * 主要登录id
     *
     * @mbggenerated
     */
    public void setMasterLoginId(Long masterLoginId) {
        this.masterLoginId = masterLoginId;
    }

    /**
     * 登陆ip地址
     *
     * @mbggenerated
     */
    public String getLoginIp() {
        return loginIp;
    }

    /**
     * 登陆ip地址
     *
     * @mbggenerated
     */
    public void setLoginIp(String loginIp) {
        this.loginIp = loginIp == null ? null : loginIp.trim();
    }

    /**
     * 登录账号
     *
     * @mbggenerated
     */
    public String getAccount() {
        return account;
    }

    /**
     * 登录账号
     *
     * @mbggenerated
     */
    public void setAccount(String account) {
        this.account = account == null ? null : account.trim();
    }
}