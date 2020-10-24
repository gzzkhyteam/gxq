package com.hengyunsoft.platform.developer.entity.fast.po.document;

import com.hengyunsoft.base.entity.CommonBaseEntity;
import java.io.Serializable;
import java.util.Date;

public class FastAppDocTask extends CommonBaseEntity<Long> implements Serializable {
    private Long id;

    private String appId;

    /**
     * 当前用户类型
     *
     * @mbggenerated
     */
    private String currentUserType;

    /**
     * 下一步用户类型
     *
     * @mbggenerated
     */
    private String nextUserType;

    /**
     * 下一个处理人
     *
     * @mbggenerated
     */
    private Long nextUserId;

    /**
     * 处理状态：待办（processing） 已办（finished）
     *
     * @mbggenerated
     */
    private String handleStatus;

    /**
     * 环节状态
     *
     * @mbggenerated
     */
    private String linkStatus;

    private String name;

    /**
     * 收发文目标
     *
     * @mbggenerated
     */
    private String target;

    /**
     * 密级
     *
     * @mbggenerated
     */
    private String rank;

    /**
     * 标题
     *
     * @mbggenerated
     */
    private String title;

    /**
     * 描述
     *
     * @mbggenerated
     */
    private String desc;

    /**
     * 公文内容
     *
     * @mbggenerated
     */
    private String content;

    /**
     * 收文单位
     *
     * @mbggenerated
     */
    private String docUnit;

    /**
     * 收文文号
     *
     * @mbggenerated
     */
    private String docNum;

    /**
     * 收文时间
     *
     * @mbggenerated
     */
    private Date docTime;

    /**
     * 收文编码
     *
     * @mbggenerated
     */
    private String docCode;

    /**
     * 公文类型：send(发文) receive(收文)
     *
     * @mbggenerated
     */
    private String docType;

    /**
     * 紧急度
     *
     * @mbggenerated
     */
    private String urgencyDegree;

    /**
     * 附件地址
     *
     * @mbggenerated
     */
    private String attachmentUrl;

    /**
     * 附件名字
     *
     * @mbggenerated
     */
    private String attachmentName;

    /**
     * 创建人名字
     *
     * @mbggenerated
     */
    private String createUserName;

    private Long createUser;

    private Date createTime;

    private Long updateUser;

    private Date updateTime;

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

    /**
     * 当前用户类型
     *
     * @mbggenerated
     */
    public String getCurrentUserType() {
        return currentUserType;
    }

    /**
     * 当前用户类型
     *
     * @mbggenerated
     */
    public void setCurrentUserType(String currentUserType) {
        this.currentUserType = currentUserType == null ? null : currentUserType.trim();
    }

    /**
     * 下一步用户类型
     *
     * @mbggenerated
     */
    public String getNextUserType() {
        return nextUserType;
    }

    /**
     * 下一步用户类型
     *
     * @mbggenerated
     */
    public void setNextUserType(String nextUserType) {
        this.nextUserType = nextUserType == null ? null : nextUserType.trim();
    }

    /**
     * 下一个处理人
     *
     * @mbggenerated
     */
    public Long getNextUserId() {
        return nextUserId;
    }

    /**
     * 下一个处理人
     *
     * @mbggenerated
     */
    public void setNextUserId(Long nextUserId) {
        this.nextUserId = nextUserId;
    }

    /**
     * 处理状态：待办（processing） 已办（finished）
     *
     * @mbggenerated
     */
    public String getHandleStatus() {
        return handleStatus;
    }

    /**
     * 处理状态：待办（processing） 已办（finished）
     *
     * @mbggenerated
     */
    public void setHandleStatus(String handleStatus) {
        this.handleStatus = handleStatus == null ? null : handleStatus.trim();
    }

    /**
     * 环节状态
     *
     * @mbggenerated
     */
    public String getLinkStatus() {
        return linkStatus;
    }

    /**
     * 环节状态
     *
     * @mbggenerated
     */
    public void setLinkStatus(String linkStatus) {
        this.linkStatus = linkStatus == null ? null : linkStatus.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 收发文目标
     *
     * @mbggenerated
     */
    public String getTarget() {
        return target;
    }

    /**
     * 收发文目标
     *
     * @mbggenerated
     */
    public void setTarget(String target) {
        this.target = target == null ? null : target.trim();
    }

    /**
     * 密级
     *
     * @mbggenerated
     */
    public String getRank() {
        return rank;
    }

    /**
     * 密级
     *
     * @mbggenerated
     */
    public void setRank(String rank) {
        this.rank = rank == null ? null : rank.trim();
    }

    /**
     * 标题
     *
     * @mbggenerated
     */
    public String getTitle() {
        return title;
    }

    /**
     * 标题
     *
     * @mbggenerated
     */
    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    /**
     * 描述
     *
     * @mbggenerated
     */
    public String getDesc() {
        return desc;
    }

    /**
     * 描述
     *
     * @mbggenerated
     */
    public void setDesc(String desc) {
        this.desc = desc == null ? null : desc.trim();
    }

    /**
     * 公文内容
     *
     * @mbggenerated
     */
    public String getContent() {
        return content;
    }

    /**
     * 公文内容
     *
     * @mbggenerated
     */
    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    /**
     * 收文单位
     *
     * @mbggenerated
     */
    public String getDocUnit() {
        return docUnit;
    }

    /**
     * 收文单位
     *
     * @mbggenerated
     */
    public void setDocUnit(String docUnit) {
        this.docUnit = docUnit == null ? null : docUnit.trim();
    }

    /**
     * 收文文号
     *
     * @mbggenerated
     */
    public String getDocNum() {
        return docNum;
    }

    /**
     * 收文文号
     *
     * @mbggenerated
     */
    public void setDocNum(String docNum) {
        this.docNum = docNum == null ? null : docNum.trim();
    }

    /**
     * 收文时间
     *
     * @mbggenerated
     */
    public Date getDocTime() {
        return docTime;
    }

    /**
     * 收文时间
     *
     * @mbggenerated
     */
    public void setDocTime(Date docTime) {
        this.docTime = docTime;
    }

    /**
     * 收文编码
     *
     * @mbggenerated
     */
    public String getDocCode() {
        return docCode;
    }

    /**
     * 收文编码
     *
     * @mbggenerated
     */
    public void setDocCode(String docCode) {
        this.docCode = docCode == null ? null : docCode.trim();
    }

    /**
     * 公文类型：send(发文) receive(收文)
     *
     * @mbggenerated
     */
    public String getDocType() {
        return docType;
    }

    /**
     * 公文类型：send(发文) receive(收文)
     *
     * @mbggenerated
     */
    public void setDocType(String docType) {
        this.docType = docType == null ? null : docType.trim();
    }

    /**
     * 紧急度
     *
     * @mbggenerated
     */
    public String getUrgencyDegree() {
        return urgencyDegree;
    }

    /**
     * 紧急度
     *
     * @mbggenerated
     */
    public void setUrgencyDegree(String urgencyDegree) {
        this.urgencyDegree = urgencyDegree == null ? null : urgencyDegree.trim();
    }

    /**
     * 附件地址
     *
     * @mbggenerated
     */
    public String getAttachmentUrl() {
        return attachmentUrl;
    }

    /**
     * 附件地址
     *
     * @mbggenerated
     */
    public void setAttachmentUrl(String attachmentUrl) {
        this.attachmentUrl = attachmentUrl == null ? null : attachmentUrl.trim();
    }

    /**
     * 附件名字
     *
     * @mbggenerated
     */
    public String getAttachmentName() {
        return attachmentName;
    }

    /**
     * 附件名字
     *
     * @mbggenerated
     */
    public void setAttachmentName(String attachmentName) {
        this.attachmentName = attachmentName == null ? null : attachmentName.trim();
    }

    /**
     * 创建人名字
     *
     * @mbggenerated
     */
    public String getCreateUserName() {
        return createUserName;
    }

    /**
     * 创建人名字
     *
     * @mbggenerated
     */
    public void setCreateUserName(String createUserName) {
        this.createUserName = createUserName == null ? null : createUserName.trim();
    }

    public Long getCreateUser() {
        return createUser;
    }

    public void setCreateUser(Long createUser) {
        this.createUser = createUser;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Long getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(Long updateUser) {
        this.updateUser = updateUser;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}