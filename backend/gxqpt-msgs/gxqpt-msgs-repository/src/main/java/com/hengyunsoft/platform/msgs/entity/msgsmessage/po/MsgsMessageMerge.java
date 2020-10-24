package com.hengyunsoft.platform.msgs.entity.msgsmessage.po;

import com.hengyunsoft.base.entity.BaseEntity;
import java.io.Serializable;
import java.util.Date;
//合并消息|消息类型 |消息渠道
public class MsgsMessageMerge extends BaseEntity<Long> implements Serializable {
    /**
     * 消息
     *
     * @mbggenerated
     */
    private Long id;

    /**
     * 标题
     *
     * @mbggenerated
     */
    private String title;
    /**
     * 5渠道个渠道之合
     *
     * @mbggenerated
     */
    private String channelSum;
    /**
     * 渠道类型1
     *
     * @mbggenerated
     */
    private Long channelType1;

    /**
     * 渠道1
     *
     * @mbggenerated
     */
    private String channel1;

    /**
     * 渠道id（,分割）
     *
     * @mbggenerated
     */
    private String channel1Id;

    /**
     * 渠道类型2
     *
     * @mbggenerated
     */
    private Long channelType2;

    /**
     * 渠道2
     *
     * @mbggenerated
     */
    private String channel2;

    /**
     * 渠道id（,分割）
     *
     * @mbggenerated
     */
    private String channel2Id;

    /**
     * 渠道类型3
     *
     * @mbggenerated
     */
    private Long channelType3;

    /**
     * 渠道3
     *
     * @mbggenerated
     */
    private String channel3;

    /**
     * 渠道id（,分割）
     *
     * @mbggenerated
     */
    private String channel3Id;

    /**
     * 渠道类型4
     *
     * @mbggenerated
     */
    private Long channelType4;

    /**
     * 渠道4
     *
     * @mbggenerated
     */
    private String channel4;

    /**
     * 渠道id（,分割）
     *
     * @mbggenerated
     */
    private String channel4Id;

    /**
     * 渠道类型5
     *
     * @mbggenerated
     */
    private Long channelType5;

    /**
     * 渠道5
     *
     * @mbggenerated
     */
    private String channel5;

    /**
     * 渠道id（,分割）
     *
     * @mbggenerated
     */
    private String channel5Id;

    /**
     * 常用联系人
     *
     * @mbggenerated
     */
    private String contactPerson;

    /**
     * 消息状态0已发送1草稿箱
     *
     * @mbggenerated
     */
    private Integer msgStatus;

    /**
     * 消息文本内容
     *
     * @mbggenerated
     */
    private String msgTxt;

    /**
     * 消息类型
     *
     * @mbggenerated
     */
    private Integer msgType;

    /**
     * 多媒体id
     *
     * @mbggenerated
     */
    private String mediaId;

    /**
     * 多媒体url
     *
     * @mbggenerated
     */
    private String mediaUrl;

    /**
     * 附件id
     *
     * @mbggenerated
     */
    private String attachmentId;

    /**
     * 附件url
     *
     * @mbggenerated
     */
    private String attachmentUrl;

    /**
     * 超文本
     *
     * @mbggenerated
     */
    private String htmlEditid;
    private String succesNum;//成功个数
    private String erroNum;//失败个数
    private String fileLists;//微博文件列表
    /**
     * 定时发送时间
     *
     * @mbggenerated
     */
    private Date sendJobTime;

    private Long createUser;

    private Date createTime;

    private Long updateUser;

    private Date updateTime;

    private static final long serialVersionUID = 1L;

    public Long getChannelType1() {
        return channelType1;
    }

    public void setChannelType1(Long channelType1) {
        this.channelType1 = channelType1;
    }

    public Long getChannelType2() {
        return channelType2;
    }

    public void setChannelType2(Long channelType2) {
        this.channelType2 = channelType2;
    }

    public Long getChannelType3() {
        return channelType3;
    }

    public void setChannelType3(Long channelType3) {
        this.channelType3 = channelType3;
    }

    public Long getChannelType4() {
        return channelType4;
    }

    public void setChannelType4(Long channelType4) {
        this.channelType4 = channelType4;
    }

    public Long getChannelType5() {
        return channelType5;
    }

    public void setChannelType5(Long channelType5) {
        this.channelType5 = channelType5;
    }

    /**
     * 消息
     *
     * @mbggenerated

     */
    public Long getId() {
        return id;
    }

    /**
     * 消息
     *
     * @mbggenerated
     */
    public void setId(Long id) {
        this.id = id;
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
     * 渠道1
     *
     * @mbggenerated
     */
    public String getChannel1() {
        return channel1;
    }

    /**
     * 渠道1
     *
     * @mbggenerated
     */
    public void setChannel1(String channel1) {
        this.channel1 = channel1 == null ? null : channel1.trim();
    }

    /**
     * 渠道id（,分割）
     *
     * @mbggenerated
     */
    public String getChannel1Id() {
        return channel1Id;
    }

    /**
     * 渠道id（,分割）
     *
     * @mbggenerated
     */
    public void setChannel1Id(String channel1Id) {
        this.channel1Id = channel1Id == null ? null : channel1Id.trim();
    }


    /**
     * 渠道2
     *
     * @mbggenerated
     */
    public String getChannel2() {
        return channel2;
    }

    /**
     * 渠道2
     *
     * @mbggenerated
     */
    public void setChannel2(String channel2) {
        this.channel2 = channel2 == null ? null : channel2.trim();
    }

    /**
     * 渠道id（,分割）
     *
     * @mbggenerated
     */
    public String getChannel2Id() {
        return channel2Id;
    }

    /**
     * 渠道id（,分割）
     *
     * @mbggenerated
     */
    public void setChannel2Id(String channel2Id) {
        this.channel2Id = channel2Id == null ? null : channel2Id.trim();
    }


    /**
     * 渠道3
     *
     * @mbggenerated
     */
    public String getChannel3() {
        return channel3;
    }

    /**
     * 渠道3
     *
     * @mbggenerated
     */
    public void setChannel3(String channel3) {
        this.channel3 = channel3 == null ? null : channel3.trim();
    }

    /**
     * 渠道id（,分割）
     *
     * @mbggenerated
     */
    public String getChannel3Id() {
        return channel3Id;
    }

    /**
     * 渠道id（,分割）
     *
     * @mbggenerated
     */
    public void setChannel3Id(String channel3Id) {
        this.channel3Id = channel3Id == null ? null : channel3Id.trim();
    }

    /**
     * 渠道4
     *
     * @mbggenerated
     */
    public String getChannel4() {
        return channel4;
    }

    /**
     * 渠道4
     *
     * @mbggenerated
     */
    public void setChannel4(String channel4) {
        this.channel4 = channel4 == null ? null : channel4.trim();
    }

    /**
     * 渠道id（,分割）
     *
     * @mbggenerated
     */
    public String getChannel4Id() {
        return channel4Id;
    }

    /**
     * 渠道id（,分割）
     *
     * @mbggenerated
     */
    public void setChannel4Id(String channel4Id) {
        this.channel4Id = channel4Id == null ? null : channel4Id.trim();
    }


    /**
     * 渠道5
     *
     * @mbggenerated
     */
    public String getChannel5() {
        return channel5;
    }

    /**
     * 渠道5
     *
     * @mbggenerated
     */
    public void setChannel5(String channel5) {
        this.channel5 = channel5 == null ? null : channel5.trim();
    }

    /**
     * 渠道id（,分割）
     *
     * @mbggenerated
     */
    public String getChannel5Id() {
        return channel5Id;
    }

    /**
     * 渠道id（,分割）
     *
     * @mbggenerated
     */
    public void setChannel5Id(String channel5Id) {
        this.channel5Id = channel5Id == null ? null : channel5Id.trim();
    }

    /**
     * 常用联系人
     *
     * @mbggenerated
     */
    public String getContactPerson() {
        return contactPerson;
    }

    /**
     * 常用联系人
     *
     * @mbggenerated
     */
    public void setContactPerson(String contactPerson) {
        this.contactPerson = contactPerson == null ? null : contactPerson.trim();
    }

    /**
     * 消息状态0已发送1草稿箱
     *
     * @mbggenerated
     */
    public Integer getMsgStatus() {
        return msgStatus;
    }

    /**
     * 消息状态1已发送2草稿箱
     *
     * @mbggenerated
     */
    public void setMsgStatus(Integer msgStatus) {
        this.msgStatus = msgStatus;
    }

    /**
     * 消息文本内容
     *
     * @mbggenerated
     */
    public String getMsgTxt() {
        return msgTxt;
    }

    /**
     * 消息文本内容
     *
     * @mbggenerated
     */
    public void setMsgTxt(String msgTxt) {
        this.msgTxt = msgTxt == null ? null : msgTxt.trim();
    }

    /**
     * 消息类型
     *
     * @mbggenerated
     */
    public Integer getMsgType() {
        return msgType;
    }

    /**
     * 消息类型
     *
     * @mbggenerated
     */
    public void setMsgType(Integer msgType) {
        this.msgType = msgType;
    }

    /**
     * 多媒体id
     *
     * @mbggenerated
     */
    public String getMediaId() {
        return mediaId;
    }

    /**
     * 多媒体id
     *
     * @mbggenerated
     */
    public void setMediaId(String mediaId) {
        this.mediaId = mediaId == null ? null : mediaId.trim();
    }

    /**
     * 多媒体url
     *
     * @mbggenerated
     */
    public String getMediaUrl() {
        return mediaUrl;
    }

    /**
     * 多媒体url
     *
     * @mbggenerated
     */
    public void setMediaUrl(String mediaUrl) {
        this.mediaUrl = mediaUrl == null ? null : mediaUrl.trim();
    }

    /**
     * 附件id
     *
     * @mbggenerated
     */
    public String getAttachmentId() {
        return attachmentId;
    }

    /**
     * 附件id
     *
     * @mbggenerated
     */
    public void setAttachmentId(String attachmentId) {
        this.attachmentId = attachmentId == null ? null : attachmentId.trim();
    }

    /**
     * 附件url
     *
     * @mbggenerated
     */
    public String getAttachmentUrl() {
        return attachmentUrl;
    }

    /**
     * 附件url
     *
     * @mbggenerated
     */
    public void setAttachmentUrl(String attachmentUrl) {
        this.attachmentUrl = attachmentUrl == null ? null : attachmentUrl.trim();
    }

    public String getChannelSum() {
        return channelSum;
    }

    public void setChannelSum(String channelSum) {
        this.channelSum = channelSum;
    }

    /**
     * 超文本
     *
     * @mbggenerated
     */
    public String getHtmlEditid() {
        return htmlEditid;
    }

    /**
     * 超文本
     *
     * @mbggenerated
     */
    public void setHtmlEditid(String htmlEditid) {
        this.htmlEditid = htmlEditid == null ? null : htmlEditid.trim();
    }

    /**
     * 定时发送时间
     *
     * @mbggenerated
     */
    public Date getSendJobTime() {
        return sendJobTime;
    }

    /**
     * 定时发送时间
     *
     * @mbggenerated
     */
    public void setSendJobTime(Date sendJobTime) {
        this.sendJobTime = sendJobTime;
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

    public String getSuccesNum() {
        return succesNum;
    }

    public void setSuccesNum(String succesNum) {
        this.succesNum = succesNum;
    }

    public String getErroNum() {
        return erroNum;
    }

    public void setErroNum(String erroNum) {
        this.erroNum = erroNum;
    }

    public String getFileLists() {
        return fileLists;
    }

    public void setFileLists(String fileLists) {
        this.fileLists = fileLists;
    }
}