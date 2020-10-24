package com.hengyunsoft.platform.mt.entity.feedback.po;

import com.hengyunsoft.base.entity.CommonBaseEntity;

import java.io.Serializable;
import java.util.Date;

public class FeedBackBase extends CommonBaseEntity<Long> implements Serializable {

    /***
     *主键id
     */
    private Long id;
    /**
     * 应用id
     *
     * @mbggenerated
     */
    private Long appliId;
    /***
     *反馈标题
     */
    private String fbTitle;
    /***
     *反馈内容
     */
    private String fbContent;
    /***
     * 紧急程度(1普通，2紧急，3非常紧急)
     */
    private Integer fbEmergency;

    /***
     *处理状态（1未处理，2已处理）
     */
    private Integer fbState;
    /***
     * 关闭人姓名
     */
    private String fbCloseName;
    /***
     *关闭时间
     */
    private Date fbCloseTime;
    /***
     * 创建人姓名
     */
    private String createUserName;
    /***
     * 创建时间
     */
    private Date createTime;
    /***
     * 总消息
     */
    private Integer msgTotal;
    /***
     * 未读消息
     */
    private Integer msgNotRead;

    public String getFbTitle() {
        return fbTitle;
    }

    public void setFbTitle(String fbTitle) {
        this.fbTitle = fbTitle;
    }

    public String getFbContent() {
        return fbContent;
    }

    public void setFbContent(String fbContent) {
        this.fbContent = fbContent;
    }

    public Integer getFbEmergency() {
        return fbEmergency;
    }

    public void setFbEmergency(Integer fbEmergency) {
        this.fbEmergency = fbEmergency;
    }

    public Integer getFbState() {
        return fbState;
    }

    public void setFbState(Integer fbState) {
        this.fbState = fbState;
    }

    public String getFbCloseName() {
        return fbCloseName;
    }

    public void setFbCloseName(String fbCloseName) {
        this.fbCloseName = fbCloseName;
    }

    public Date getFbCloseTime() {
        return fbCloseTime;
    }

    public void setFbCloseTime(Date fbCloseTime) {
        this.fbCloseTime = fbCloseTime;
    }

    public String getCreateUserName() {
        return createUserName;
    }

    public void setCreateUserName(String createUserName) {
        this.createUserName = createUserName;
    }

    @Override
    public Date getCreateTime() {
        return createTime;
    }

    @Override
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getMsgTotal() {
        return msgTotal;
    }

    public void setMsgTotal(Integer msgTotal) {
        this.msgTotal = msgTotal;
    }

    public Integer getMsgNotRead() {
        return msgNotRead;
    }

    public void setMsgNotRead(Integer msgNotRead) {
        this.msgNotRead = msgNotRead;
    }

    public Long getAppliId() {
        return appliId;
    }

    public void setAppliId(Long appliId) {
        this.appliId = appliId;
    }

    @Override
    public String getAppId() {
        return null;
    }

    @Override
    public void setAppId(String appId) {

    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }
}
