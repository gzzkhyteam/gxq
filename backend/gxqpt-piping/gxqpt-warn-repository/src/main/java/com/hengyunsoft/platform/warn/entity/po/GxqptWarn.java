package com.hengyunsoft.platform.warn.entity.po;

import com.hengyunsoft.base.entity.BaseEntity;
import com.hengyunsoft.validator.ValidatorGroups.MustNoneNull;
import com.hengyunsoft.validator.annotation.FieldDesc;
import java.io.Serializable;
import java.util.Date;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;

public class GxqptWarn extends BaseEntity<Long> implements Serializable {
    /**
     * 未确认
     */
    public static  final String STATUS1 = "1";
    /**
     * 已确认属实
     */
    public static  final String STATUS2 = "2";
    /**
     * 已确认不属实
     */
    public static  final String STATUS3 = "3";
    /**
     * 已处理
     */
    public static  final String STATUS4 = "4";
    /**
     * 主键id
     *
     * @mbggenerated
     */
    @FieldDesc("主键id")
    @Range(min=Long.MIN_VALUE,max=Long.MAX_VALUE)
    @NotNull(groups=MustNoneNull.class)
    private Long id;

    /**
     * 预警标题
     *
     * @mbggenerated
     */
    @FieldDesc("预警标题")
    @Length(max=255)
    private String title;

    /**
     * 预警类型id
     *
     * @mbggenerated
     */
    @FieldDesc("预警类型id")
    @Range(min=Long.MIN_VALUE,max=Long.MAX_VALUE)
    @NotNull(groups=MustNoneNull.class)
    private Long typeId;

    /**
     * 预警类型
     *
     * @mbggenerated
     */
    @FieldDesc("预警类型")
    @Length(max=255)
    private String type;

    /**
     * 预警内容
     *
     * @mbggenerated
     */
    @FieldDesc("预警内容")
    @Length(max=255)
    private String content;

    /**
     * 预警状态 1、未确认 2、已确认属实 3、已确认不属实 4、已处理
     *
     * @mbggenerated
     */
    @FieldDesc("预警状态 1、未确认 2、已确认属实 3、已确认不属实 4、已处理")
    @Length(max=20)
    private String status;

    /**
     * 预警级别 1、一般 2、较重 3、严重 4、特别严重
     *
     * @mbggenerated
     */
    @FieldDesc("预警级别 1、一般 2、较重 3、严重 4、特别严重")
    @Range(min=Integer.MIN_VALUE,max=Integer.MAX_VALUE)
    private Integer level;

    /**
     * 预警时间
     *
     * @mbggenerated
     */
    @FieldDesc("预警时间")
    private Date warntime;

    /**
     * 最近处理时间
     *
     * @mbggenerated
     */
    @FieldDesc("最近处理时间")
    private Date hanTime;

    /**
     * 平台是否可处理 1、可处理 0不可处理
     *
     * @mbggenerated
     */
    @FieldDesc("平台是否可处理 1、可处理 0不可处理")
    private Boolean isHandle;

    /**
     * 应用处理回调地址
     *
     * @mbggenerated
     */
    @FieldDesc("应用处理回调地址")
    @Length(max=100)
    private String callbackUrl;

    /**
     * 创建人
     *
     * @mbggenerated
     */
    @FieldDesc("创建人")
    @Length(max=20)
    private String createUser;

    /**
     * 创建时间
     *
     * @mbggenerated
     */
    @FieldDesc("创建时间")
    private Date createTime;

    /**
     * 更新人
     *
     * @mbggenerated
     */
    @FieldDesc("更新人")
    @Length(max=20)
    private String updateUser;

    /**
     * 更新时间
     *
     * @mbggenerated
     */
    @FieldDesc("更新时间")
    private Date updateTime;

    /**
     * 确认时长
     *
     * @mbggenerated
     */
    @FieldDesc("确认时长")
    @Length(max=20)
    private String confirmCostTime;

    /**
     * 处理时长
     *
     * @mbggenerated
     */
    @FieldDesc("处理时长")
    @Length(max=20)
    private String handleCostTime;

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
     * 预警标题
     *
     * @mbggenerated
     */
    public String getTitle() {
        return title;
    }

    /**
     * 预警标题
     *
     * @mbggenerated
     */
    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    /**
     * 预警类型id
     *
     * @mbggenerated
     */
    public Long getTypeId() {
        return typeId;
    }

    /**
     * 预警类型id
     *
     * @mbggenerated
     */
    public void setTypeId(Long typeId) {
        this.typeId = typeId;
    }

    /**
     * 预警类型
     *
     * @mbggenerated
     */
    public String getType() {
        return type;
    }

    /**
     * 预警类型
     *
     * @mbggenerated
     */
    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    /**
     * 预警内容
     *
     * @mbggenerated
     */
    public String getContent() {
        return content;
    }

    /**
     * 预警内容
     *
     * @mbggenerated
     */
    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    /**
     * 预警状态 1、未确认 2、已确认属实 3、已确认不属实 4、已处理
     *
     * @mbggenerated
     */
    public String getStatus() {
        return status;
    }

    /**
     * 预警状态 1、未确认 2、已确认属实 3、已确认不属实 4、已处理
     *
     * @mbggenerated
     */
    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    /**
     * 预警级别 1、一般 2、较重 3、严重 4、特别严重
     *
     * @mbggenerated
     */
    public Integer getLevel() {
        return level;
    }

    /**
     * 预警级别 1、一般 2、较重 3、严重 4、特别严重
     *
     * @mbggenerated
     */
    public void setLevel(Integer level) {
        this.level = level;
    }

    /**
     * 预警时间
     *
     * @mbggenerated
     */
    public Date getWarntime() {
        return warntime;
    }

    /**
     * 预警时间
     *
     * @mbggenerated
     */
    public void setWarntime(Date warntime) {
        this.warntime = warntime;
    }

    /**
     * 最近处理时间
     *
     * @mbggenerated
     */
    public Date getHanTime() {
        return hanTime;
    }

    /**
     * 最近处理时间
     *
     * @mbggenerated
     */
    public void setHanTime(Date hanTime) {
        this.hanTime = hanTime;
    }

    /**
     * 平台是否可处理 1、可处理 0不可处理
     *
     * @mbggenerated
     */
    public Boolean getIsHandle() {
        return isHandle;
    }

    /**
     * 平台是否可处理 1、可处理 0不可处理
     *
     * @mbggenerated
     */
    public void setIsHandle(Boolean isHandle) {
        this.isHandle = isHandle;
    }

    /**
     * 应用处理回调地址
     *
     * @mbggenerated
     */
    public String getCallbackUrl() {
        return callbackUrl;
    }

    /**
     * 应用处理回调地址
     *
     * @mbggenerated
     */
    public void setCallbackUrl(String callbackUrl) {
        this.callbackUrl = callbackUrl == null ? null : callbackUrl.trim();
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
     * 确认时长
     *
     * @mbggenerated
     */
    public String getConfirmCostTime() {
        return confirmCostTime;
    }

    /**
     * 确认时长
     *
     * @mbggenerated
     */
    public void setConfirmCostTime(String confirmCostTime) {
        this.confirmCostTime = confirmCostTime == null ? null : confirmCostTime.trim();
    }

    /**
     * 处理时长
     *
     * @mbggenerated
     */
    public String getHandleCostTime() {
        return handleCostTime;
    }

    /**
     * 处理时长
     *
     * @mbggenerated
     */
    public void setHandleCostTime(String handleCostTime) {
        this.handleCostTime = handleCostTime == null ? null : handleCostTime.trim();
    }
}