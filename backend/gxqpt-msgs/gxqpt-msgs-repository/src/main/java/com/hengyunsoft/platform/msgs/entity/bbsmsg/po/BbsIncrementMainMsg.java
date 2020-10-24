package com.hengyunsoft.platform.msgs.entity.bbsmsg.po;

import com.hengyunsoft.base.entity.BaseEntity;
import java.io.Serializable;
import java.util.Date;

public class BbsIncrementMainMsg extends BaseEntity<Long> implements Serializable {
    private Long id;

    /**
     * 业务id
     *
     * @mbggenerated
     */
    private String bizId;

    /**
     * 业务类型
     *
     * @mbggenerated
     */
    private String bizType;

    /**
     * 客户端对此消息的唯一标示,   若客户端对此消息进行了存储，这里推荐是那里的存储id
     *
     * @mbggenerated
     */
    private String clientFlag;

    /**
     * 简要类型，粗粒度的类型
     *
     * @mbggenerated
     */
    private String briefTpye;

    /**
     * 详细类型
     *
     * @mbggenerated
     */
    private String detailedType;

    /**
     * 详细类型描述
     *
     * @mbggenerated
     */
    private String detailedTypeDesc;

    /**
     * 标题
     *
     * @mbggenerated
     */
    private String title;

    /**
     * 内容
     *
     * @mbggenerated
     */
    private String content;

    /**
     * 作者名称
     *
     * @mbggenerated
     */
    private String senderName;

    /**
     * 处理地址
     *
     * @mbggenerated
     */
    private String handlerUrl;

    /**
     * 处理参数
     *
     * @mbggenerated
     */
    private String handlerParams;

    /**
     * 是否单人处理
     *
     * @mbggenerated
     */
    private Boolean singleHandleIs;

    /**
     * 是否需要操作
     *
     * @mbggenerated
     */
    private Boolean handlerNeedIs;

    /**
     * 应用id
     *
     * @mbggenerated
     */
    private String appId;

    /**
     * 应用名称
     *
     * @mbggenerated
     */
    private String appName;

    private Date createTime;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 业务id
     *
     * @mbggenerated
     */
    public String getBizId() {
        return bizId;
    }

    /**
     * 业务id
     *
     * @mbggenerated
     */
    public void setBizId(String bizId) {
        this.bizId = bizId == null ? null : bizId.trim();
    }

    /**
     * 业务类型
     *
     * @mbggenerated
     */
    public String getBizType() {
        return bizType;
    }

    /**
     * 业务类型
     *
     * @mbggenerated
     */
    public void setBizType(String bizType) {
        this.bizType = bizType == null ? null : bizType.trim();
    }

    /**
     * 客户端对此消息的唯一标示,   若客户端对此消息进行了存储，这里推荐是那里的存储id
     *
     * @mbggenerated
     */
    public String getClientFlag() {
        return clientFlag;
    }

    /**
     * 客户端对此消息的唯一标示,   若客户端对此消息进行了存储，这里推荐是那里的存储id
     *
     * @mbggenerated
     */
    public void setClientFlag(String clientFlag) {
        this.clientFlag = clientFlag == null ? null : clientFlag.trim();
    }

    /**
     * 简要类型，粗粒度的类型
     *
     * @mbggenerated
     */
    public String getBriefTpye() {
        return briefTpye;
    }

    /**
     * 简要类型，粗粒度的类型
     *
     * @mbggenerated
     */
    public void setBriefTpye(String briefTpye) {
        this.briefTpye = briefTpye == null ? null : briefTpye.trim();
    }

    /**
     * 详细类型
     *
     * @mbggenerated
     */
    public String getDetailedType() {
        return detailedType;
    }

    /**
     * 详细类型
     *
     * @mbggenerated
     */
    public void setDetailedType(String detailedType) {
        this.detailedType = detailedType == null ? null : detailedType.trim();
    }

    /**
     * 详细类型描述
     *
     * @mbggenerated
     */
    public String getDetailedTypeDesc() {
        return detailedTypeDesc;
    }

    /**
     * 详细类型描述
     *
     * @mbggenerated
     */
    public void setDetailedTypeDesc(String detailedTypeDesc) {
        this.detailedTypeDesc = detailedTypeDesc == null ? null : detailedTypeDesc.trim();
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
     * 内容
     *
     * @mbggenerated
     */
    public String getContent() {
        return content;
    }

    /**
     * 内容
     *
     * @mbggenerated
     */
    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    /**
     * 作者名称
     *
     * @mbggenerated
     */
    public String getSenderName() {
        return senderName;
    }

    /**
     * 作者名称
     *
     * @mbggenerated
     */
    public void setSenderName(String senderName) {
        this.senderName = senderName == null ? null : senderName.trim();
    }

    /**
     * 处理地址
     *
     * @mbggenerated
     */
    public String getHandlerUrl() {
        return handlerUrl;
    }

    /**
     * 处理地址
     *
     * @mbggenerated
     */
    public void setHandlerUrl(String handlerUrl) {
        this.handlerUrl = handlerUrl == null ? null : handlerUrl.trim();
    }

    /**
     * 处理参数
     *
     * @mbggenerated
     */
    public String getHandlerParams() {
        return handlerParams;
    }

    /**
     * 处理参数
     *
     * @mbggenerated
     */
    public void setHandlerParams(String handlerParams) {
        this.handlerParams = handlerParams == null ? null : handlerParams.trim();
    }

    /**
     * 是否单人处理
     *
     * @mbggenerated
     */
    public Boolean getSingleHandleIs() {
        return singleHandleIs;
    }

    /**
     * 是否单人处理
     *
     * @mbggenerated
     */
    public void setSingleHandleIs(Boolean singleHandleIs) {
        this.singleHandleIs = singleHandleIs;
    }

    /**
     * 是否需要操作
     *
     * @mbggenerated
     */
    public Boolean getHandlerNeedIs() {
        return handlerNeedIs;
    }

    /**
     * 是否需要操作
     *
     * @mbggenerated
     */
    public void setHandlerNeedIs(Boolean handlerNeedIs) {
        this.handlerNeedIs = handlerNeedIs;
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
     * 应用名称
     *
     * @mbggenerated
     */
    public String getAppName() {
        return appName;
    }

    /**
     * 应用名称
     *
     * @mbggenerated
     */
    public void setAppName(String appName) {
        this.appName = appName == null ? null : appName.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}