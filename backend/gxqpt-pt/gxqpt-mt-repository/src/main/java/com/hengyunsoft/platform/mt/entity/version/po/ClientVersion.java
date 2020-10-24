package com.hengyunsoft.platform.mt.entity.version.po;

import com.hengyunsoft.base.entity.CommonBaseEntity;
import com.hengyunsoft.validator.ValidatorGroups;
import com.hengyunsoft.validator.annotation.FieldDesc;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

public class ClientVersion extends CommonBaseEntity<Long> implements Serializable {
    /**
     * 主键
     *
     * @mbggenerated
     */
    @FieldDesc("主键")
    @Range(min=Long.MIN_VALUE,max=Long.MAX_VALUE)
    @NotNull(groups=ValidatorGroups.MustNoneNull.class)
    private Long id;

    /**
     * 版本名称
     *
     * @mbggenerated
     */
    @FieldDesc("版本名称")
    @Length(max=50)
    private String verName;

    /**
     * 版本号
     *
     * @mbggenerated
     */
    @FieldDesc("版本号")
    @Range(min=Integer.MIN_VALUE,max=Integer.MAX_VALUE)
    private Integer verNumber;

    /**
     * 状态(1,未发布,2已发布)
     *
     * @mbggenerated
     */
    @FieldDesc("状态(1,未发布,2已发布)")
    @Range(min=Integer.MIN_VALUE,max=Integer.MAX_VALUE)
    private Integer state;

    /**
     * 下载二维码图片路径
     *
     * @mbggenerated
     */
    @FieldDesc("下载二维码图片路径")
    @Length(max=100)
    private String downQrCode;

    /**
     * 是否强制更新(1不强制,2强制)
     *
     * @mbggenerated
     */
    @FieldDesc("是否强制更新(1不强制,2强制)")
    @Range(min=Integer.MIN_VALUE,max=Integer.MAX_VALUE)
    private Integer pwUpdate;

    /**
     * 发布日期
     *
     * @mbggenerated
     */
    @FieldDesc("发布日期")
    private Date publishTime;

    /**
     * 文件id
     *
     * @mbggenerated
     */
    @FieldDesc("文件id")
    @Length(max=32)
    private String apkFileId;

    /**
     * 文件名称
     *
     * @mbggenerated
     */
    @FieldDesc("文件名称")
    @Length(max=255)
    private String apkFileName;

    /**
     * 文件路径
     *
     * @mbggenerated
     */
    @FieldDesc("文件路径")
    @Length(max=100)
    private String apkFilePath;

    /**
     * 文件大小
     *
     * @mbggenerated
     */
    @FieldDesc("文件大小")
    @Length(max=30)
    private String apkFileSize;

    /**
     * 升级内容
     *
     * @mbggenerated
     */
    @FieldDesc("升级内容")
    @Length(max=2147483647)
    private String updateContent;

    /**
     * 升级数量
     *
     * @mbggenerated
     */
    @FieldDesc("升级数量")
    @Range(min=Integer.MIN_VALUE,max=Integer.MAX_VALUE)
    private Integer updateNum;

    /**
     * 创建时间
     *
     * @mbggenerated
     */
    @FieldDesc("创建时间")
    private Date createTime;

    /**
     * 创建人
     *
     * @mbggenerated
     */
    @FieldDesc("创建人")
    @Range(min=Long.MIN_VALUE,max=Long.MAX_VALUE)
    private Long createUser;

    /**
     * 更新时间
     *
     * @mbggenerated
     */
    @FieldDesc("更新时间")
    private Date updateTime;

    /**
     * 更新人
     *
     * @mbggenerated
     */
    @FieldDesc("更新人")
    @Range(min=Long.MIN_VALUE,max=Long.MAX_VALUE)
    private Long updateUser;

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
     * 版本名称
     *
     * @mbggenerated
     */
    public String getVerName() {
        return verName;
    }

    /**
     * 版本名称
     *
     * @mbggenerated
     */
    public void setVerName(String verName) {
        this.verName = verName == null ? null : verName.trim();
    }

    /**
     * 版本号
     *
     * @mbggenerated
     */
    public Integer getVerNumber() {
        return verNumber;
    }

    /**
     * 版本号
     *
     * @mbggenerated
     */
    public void setVerNumber(Integer verNumber) {
        this.verNumber = verNumber;
    }

    /**
     * 状态(1,未发布,2已发布)
     *
     * @mbggenerated
     */
    public Integer getState() {
        return state;
    }

    /**
     * 状态(1,未发布,2已发布)
     *
     * @mbggenerated
     */
    public void setState(Integer state) {
        this.state = state;
    }

    /**
     * 下载二维码图片路径
     *
     * @mbggenerated
     */
    public String getDownQrCode() {
        return downQrCode;
    }

    /**
     * 下载二维码图片路径
     *
     * @mbggenerated
     */
    public void setDownQrCode(String downQrCode) {
        this.downQrCode = downQrCode == null ? null : downQrCode.trim();
    }

    /**
     * 是否强制更新(1不强制,2强制)
     *
     * @mbggenerated
     */
    public Integer getPwUpdate() {
        return pwUpdate;
    }

    /**
     * 是否强制更新(1不强制,2强制)
     *
     * @mbggenerated
     */
    public void setPwUpdate(Integer pwUpdate) {
        this.pwUpdate = pwUpdate;
    }

    /**
     * 发布日期
     *
     * @mbggenerated
     */
    public Date getPublishTime() {
        return publishTime;
    }

    /**
     * 发布日期
     *
     * @mbggenerated
     */
    public void setPublishTime(Date publishTime) {
        this.publishTime = publishTime;
    }

    /**
     * 文件id
     *
     * @mbggenerated
     */
    public String getApkFileId() {
        return apkFileId;
    }

    /**
     * 文件id
     *
     * @mbggenerated
     */
    public void setApkFileId(String apkFileId) {
        this.apkFileId = apkFileId == null ? null : apkFileId.trim();
    }

    /**
     * 文件名称
     *
     * @mbggenerated
     */
    public String getApkFileName() {
        return apkFileName;
    }

    /**
     * 文件名称
     *
     * @mbggenerated
     */
    public void setApkFileName(String apkFileName) {
        this.apkFileName = apkFileName == null ? null : apkFileName.trim();
    }

    /**
     * 文件路径
     *
     * @mbggenerated
     */
    public String getApkFilePath() {
        return apkFilePath;
    }

    /**
     * 文件路径
     *
     * @mbggenerated
     */
    public void setApkFilePath(String apkFilePath) {
        this.apkFilePath = apkFilePath == null ? null : apkFilePath.trim();
    }

    /**
     * 文件大小
     *
     * @mbggenerated
     */
    public String getApkFileSize() {
        return apkFileSize;
    }

    /**
     * 文件大小
     *
     * @mbggenerated
     */
    public void setApkFileSize(String apkFileSize) {
        this.apkFileSize = apkFileSize == null ? null : apkFileSize.trim();
    }

    /**
     * 升级内容
     *
     * @mbggenerated
     */
    public String getUpdateContent() {
        return updateContent;
    }

    /**
     * 升级内容
     *
     * @mbggenerated
     */
    public void setUpdateContent(String updateContent) {
        this.updateContent = updateContent == null ? null : updateContent.trim();
    }

    /**
     * 升级数量
     *
     * @mbggenerated
     */
    public Integer getUpdateNum() {
        return updateNum;
    }

    /**
     * 升级数量
     *
     * @mbggenerated
     */
    public void setUpdateNum(Integer updateNum) {
        this.updateNum = updateNum;
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

    @Override
    public String getAppId() {
        return null;
    }

    @Override
    public void setAppId(String appId) {

    }
}