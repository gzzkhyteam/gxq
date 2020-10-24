package com.hengyunsoft.platform.mail.entity.core.po;

import com.hengyunsoft.base.entity.BaseEntity;
import java.io.Serializable;
import java.util.Date;

public class SetParam extends BaseEntity<Long> implements Serializable {
    /**
     * 主键id
     *
     * @mbggenerated
     */
    private Long id;

    /**
     * 是否需要回执
     *
     * @mbggenerated
     */
    private Integer isReceipt;

    /**
     * 默认编码
     *
     * @mbggenerated
     */
    private String defaultCode;

    /**
     * 登陆显示页
     *
     * @mbggenerated
     */
    private String loginPage;

    /**
     * 自动清除垃圾时间间隔 （天）
     *
     * @mbggenerated
     */
    private Integer clearTrashGap;

    /**
     * 自动清除病毒时间间隔 （天）
     *
     * @mbggenerated
     */
    private Integer clearViruseGap;

    /**
     * 是否启用自动转发
     *
     * @mbggenerated
     */
    private Integer autoForward;

    /**
     * 转发到的邮箱
     *
     * @mbggenerated
     */
    private String forwardAddress;

    /**
     * 是否保存副本在本地邮箱
     *
     * @mbggenerated
     */
    private Integer saveCopyLocal;

    /**
     * 是否启用自动回复
     *
     * @mbggenerated
     */
    private Integer autoReply;

    /**
     * 回复内容
     *
     * @mbggenerated
     */
    private String replyContent;

    /**
     * 当前签名值
     *
     * @mbggenerated
     */
    private Long currSign;

    /**
     * 是否记录日志
     *
     * @mbggenerated
     */
    private Boolean isLogged;

    /**
     * 创建时间
     *
     * @mbggenerated
     */
    private Date createTime;

    /**
     * 创建人
     *
     * @mbggenerated
     */
    private String createUser;

    /**
     * 更新时间
     *
     * @mbggenerated
     */
    private Date updateTime;

    /**
     * 更新人
     *
     * @mbggenerated
     */
    private String updateUser;

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
     * 是否需要回执
     *
     * @mbggenerated
     */
    public Integer getIsReceipt() {
        return isReceipt;
    }

    /**
     * 是否需要回执
     *
     * @mbggenerated
     */
    public void setIsReceipt(Integer isReceipt) {
        this.isReceipt = isReceipt;
    }

    /**
     * 默认编码
     *
     * @mbggenerated
     */
    public String getDefaultCode() {
        return defaultCode;
    }

    /**
     * 默认编码
     *
     * @mbggenerated
     */
    public void setDefaultCode(String defaultCode) {
        this.defaultCode = defaultCode == null ? null : defaultCode.trim();
    }

    /**
     * 登陆显示页
     *
     * @mbggenerated
     */
    public String getLoginPage() {
        return loginPage;
    }

    /**
     * 登陆显示页
     *
     * @mbggenerated
     */
    public void setLoginPage(String loginPage) {
        this.loginPage = loginPage == null ? null : loginPage.trim();
    }

    /**
     * 自动清除垃圾时间间隔 （天）
     *
     * @mbggenerated
     */
    public Integer getClearTrashGap() {
        return clearTrashGap;
    }

    /**
     * 自动清除垃圾时间间隔 （天）
     *
     * @mbggenerated
     */
    public void setClearTrashGap(Integer clearTrashGap) {
        this.clearTrashGap = clearTrashGap;
    }

    /**
     * 自动清除病毒时间间隔 （天）
     *
     * @mbggenerated
     */
    public Integer getClearViruseGap() {
        return clearViruseGap;
    }

    /**
     * 自动清除病毒时间间隔 （天）
     *
     * @mbggenerated
     */
    public void setClearViruseGap(Integer clearViruseGap) {
        this.clearViruseGap = clearViruseGap;
    }

    /**
     * 是否启用自动转发
     *
     * @mbggenerated
     */
    public Integer getAutoForward() {
        return autoForward;
    }

    /**
     * 是否启用自动转发
     *
     * @mbggenerated
     */
    public void setAutoForward(Integer autoForward) {
        this.autoForward = autoForward;
    }

    /**
     * 转发到的邮箱
     *
     * @mbggenerated
     */
    public String getForwardAddress() {
        return forwardAddress;
    }

    /**
     * 转发到的邮箱
     *
     * @mbggenerated
     */
    public void setForwardAddress(String forwardAddress) {
        this.forwardAddress = forwardAddress == null ? null : forwardAddress.trim();
    }

    /**
     * 是否保存副本在本地邮箱
     *
     * @mbggenerated
     */
    public Integer getSaveCopyLocal() {
        return saveCopyLocal;
    }

    /**
     * 是否保存副本在本地邮箱
     *
     * @mbggenerated
     */
    public void setSaveCopyLocal(Integer saveCopyLocal) {
        this.saveCopyLocal = saveCopyLocal;
    }

    /**
     * 是否启用自动回复
     *
     * @mbggenerated
     */
    public Integer getAutoReply() {
        return autoReply;
    }

    /**
     * 是否启用自动回复
     *
     * @mbggenerated
     */
    public void setAutoReply(Integer autoReply) {
        this.autoReply = autoReply;
    }

    /**
     * 回复内容
     *
     * @mbggenerated
     */
    public String getReplyContent() {
        return replyContent;
    }

    /**
     * 回复内容
     *
     * @mbggenerated
     */
    public void setReplyContent(String replyContent) {
        this.replyContent = replyContent == null ? null : replyContent.trim();
    }

    /**
     * 当前签名值
     *
     * @mbggenerated
     */
    public Long getCurrSign() {
        return currSign;
    }

    /**
     * 当前签名值
     *
     * @mbggenerated
     */
    public void setCurrSign(Long currSign) {
        this.currSign = currSign;
    }

    /**
     * 是否记录日志
     *
     * @mbggenerated
     */
    public Boolean getIsLogged() {
        return isLogged;
    }

    /**
     * 是否记录日志
     *
     * @mbggenerated
     */
    public void setIsLogged(Boolean isLogged) {
        this.isLogged = isLogged;
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
     * 创建人
     *
     * @mbggenerated
     */
    public String getCreateUser() {
        return createUser;
    }

    /**
     * 创建人
     *
     * @mbggenerated
     */
    public void setCreateUser(String createUser) {
        this.createUser = createUser == null ? null : createUser.trim();
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

    /**
     * 更新人
     *
     * @mbggenerated
     */
    public String getUpdateUser() {
        return updateUser;
    }

    /**
     * 更新人
     *
     * @mbggenerated
     */
    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser == null ? null : updateUser.trim();
    }
}