package com.hengyunsoft.platform.standard.entity.standard.po;

import com.hengyunsoft.base.entity.BaseEntity;
import com.hengyunsoft.validator.ValidatorGroups.MustNoneNull;
import com.hengyunsoft.validator.annotation.FieldDesc;
import java.io.Serializable;
import java.util.Date;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;

public class StandardFile extends BaseEntity<Long> implements Serializable {
    @Range(min=Long.MIN_VALUE,max=Long.MAX_VALUE)
    @NotNull(groups=MustNoneNull.class)
    private Long id;

    /**
     * 文档名称
     *
     * @mbggenerated
     */
    @FieldDesc("文档名称")
    @Length(max=255)
    private String name;

    /**
     * 文档编码
     *
     * @mbggenerated
     */
    @FieldDesc("文档编码")
    @Length(max=64)
    private String code;

    /**
     * 文件服务器文件id
     *
     * @mbggenerated
     */
    @FieldDesc("文件服务器文件id")
    @Length(max=64)
    private String documentId;

    /**
     * 文档类型
     *
     * @mbggenerated
     */
    @FieldDesc("文档类型")
    @Length(max=64)
    private String fileType;

    /**
     * 标准分类id
     *
     * @mbggenerated
     */
    @FieldDesc("标准分类id")
    @Length(max=64)
    private String classifyId;

    /**
     * 文档版本
     *
     * @mbggenerated
     */
    @FieldDesc("文档版本")
    @Length(max=64)
    private String version;

    /**
     * 文档描述
     *
     * @mbggenerated
     */
    @FieldDesc("文档描述")
    @Length(max=2048)
    private String description;

    /**
     * 是否有效
            1：有效
            0：无效
     *
     * @mbggenerated
     */
    @FieldDesc("是否有效 1：有效 0：无效")
    private Boolean isEnable;

    /**
     * 是否删除 
            1：已删除
            0：未删除
     *
     * @mbggenerated
     */
    @FieldDesc("是否删除 1：已删除 0：未删除")
    private Boolean isDelete;

    @Range(min=Long.MIN_VALUE,max=Long.MAX_VALUE)
    private Long createUser;

    private Date createTime;

    @Range(min=Long.MIN_VALUE,max=Long.MAX_VALUE)
    private Long updateUser;

    private Date updateTime;

    /**
     * 上传单位ID
     *
     * @mbggenerated
     */
    @FieldDesc("上传单位ID")
    @Length(max=64)
    private String companyId;

    /**
     * 上传单位名称
     *
     * @mbggenerated
     */
    @FieldDesc("上传单位名称")
    @Length(max=64)
    private String companyName;

    /**
     * 上传用户姓名
     *
     * @mbggenerated
     */
    @FieldDesc("上传用户姓名")
    @Length(max=64)
    private String createUserName;

    /**
     * 修改人姓名
     *
     * @mbggenerated
     */
    @FieldDesc("修改人姓名")
    @Length(max=64)
    private String updateUserName;

    /**
     * 来自哪个页面 1:安全保障体系 2移动应用接口规范体系 3:数据统一标准规范体系
     *
     * @mbggenerated
     */
    @FieldDesc("来自哪个页面 1:安全保障体系 2移动应用接口规范体系 3:数据统一标准规范体系")
    @Range(min=Integer.MIN_VALUE,max=Integer.MAX_VALUE)
    private Integer fromPage;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 文档名称
     *
     * @mbggenerated
     */
    public String getName() {
        return name;
    }

    /**
     * 文档名称
     *
     * @mbggenerated
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 文档编码
     *
     * @mbggenerated
     */
    public String getCode() {
        return code;
    }

    /**
     * 文档编码
     *
     * @mbggenerated
     */
    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    /**
     * 文件服务器文件id
     *
     * @mbggenerated
     */
    public String getDocumentId() {
        return documentId;
    }

    /**
     * 文件服务器文件id
     *
     * @mbggenerated
     */
    public void setDocumentId(String documentId) {
        this.documentId = documentId == null ? null : documentId.trim();
    }

    /**
     * 文档类型
     *
     * @mbggenerated
     */
    public String getFileType() {
        return fileType;
    }

    /**
     * 文档类型
     *
     * @mbggenerated
     */
    public void setFileType(String fileType) {
        this.fileType = fileType == null ? null : fileType.trim();
    }

    /**
     * 标准分类id
     *
     * @mbggenerated
     */
    public String getClassifyId() {
        return classifyId;
    }

    /**
     * 标准分类id
     *
     * @mbggenerated
     */
    public void setClassifyId(String classifyId) {
        this.classifyId = classifyId == null ? null : classifyId.trim();
    }

    /**
     * 文档版本
     *
     * @mbggenerated
     */
    public String getVersion() {
        return version;
    }

    /**
     * 文档版本
     *
     * @mbggenerated
     */
    public void setVersion(String version) {
        this.version = version == null ? null : version.trim();
    }

    /**
     * 文档描述
     *
     * @mbggenerated
     */
    public String getDescription() {
        return description;
    }

    /**
     * 文档描述
     *
     * @mbggenerated
     */
    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    /**
     * 是否有效
            1：有效
            0：无效
     *
     * @mbggenerated
     */
    public Boolean getIsEnable() {
        return isEnable;
    }

    /**
     * 是否有效
            1：有效
            0：无效
     *
     * @mbggenerated
     */
    public void setIsEnable(Boolean isEnable) {
        this.isEnable = isEnable;
    }

    /**
     * 是否删除 
            1：已删除
            0：未删除
     *
     * @mbggenerated
     */
    public Boolean getIsDelete() {
        return isDelete;
    }

    /**
     * 是否删除 
            1：已删除
            0：未删除
     *
     * @mbggenerated
     */
    public void setIsDelete(Boolean isDelete) {
        this.isDelete = isDelete;
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

    /**
     * 上传单位ID
     *
     * @mbggenerated
     */
    public String getCompanyId() {
        return companyId;
    }

    /**
     * 上传单位ID
     *
     * @mbggenerated
     */
    public void setCompanyId(String companyId) {
        this.companyId = companyId == null ? null : companyId.trim();
    }

    /**
     * 上传单位名称
     *
     * @mbggenerated
     */
    public String getCompanyName() {
        return companyName;
    }

    /**
     * 上传单位名称
     *
     * @mbggenerated
     */
    public void setCompanyName(String companyName) {
        this.companyName = companyName == null ? null : companyName.trim();
    }

    /**
     * 上传用户姓名
     *
     * @mbggenerated
     */
    public String getCreateUserName() {
        return createUserName;
    }

    /**
     * 上传用户姓名
     *
     * @mbggenerated
     */
    public void setCreateUserName(String createUserName) {
        this.createUserName = createUserName == null ? null : createUserName.trim();
    }

    /**
     * 修改人姓名
     *
     * @mbggenerated
     */
    public String getUpdateUserName() {
        return updateUserName;
    }

    /**
     * 修改人姓名
     *
     * @mbggenerated
     */
    public void setUpdateUserName(String updateUserName) {
        this.updateUserName = updateUserName == null ? null : updateUserName.trim();
    }

    /**
     * 来自哪个页面 1:安全保障体系 2移动应用接口规范体系 3:数据统一标准规范体系
     *
     * @mbggenerated
     */
    public Integer getFromPage() {
        return fromPage;
    }

    /**
     * 来自哪个页面 1:安全保障体系 2移动应用接口规范体系 3:数据统一标准规范体系
     *
     * @mbggenerated
     */
    public void setFromPage(Integer fromPage) {
        this.fromPage = fromPage;
    }
}