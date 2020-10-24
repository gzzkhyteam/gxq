package com.hengyunsoft.platform.admin.entity.org.sdzzww.po;

import com.hengyunsoft.base.entity.BaseEntity;
import com.hengyunsoft.validator.ValidatorGroups;
import com.hengyunsoft.validator.annotation.FieldDesc;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

public class SdzzwwPost extends BaseEntity<String> implements Serializable {
    /**
     * ID
     *
     * @mbggenerated
     */
    @FieldDesc("ID")
    @Length(max=64)
    @NotNull(groups=ValidatorGroups.MustNoneNull.class)
    private String id;

    /**
     * 岗位名称
     *
     * @mbggenerated
     */
    @FieldDesc("岗位名称")
    @Length(max=64)
    private String name;

    /**
     * 岗位编码
     *
     * @mbggenerated
     */
    @FieldDesc("岗位编码")
    @Length(max=64)
    private String code;

    /**
     * 岗位所属单位 id
     *
     * @mbggenerated
     */
    @FieldDesc("岗位所属单位 id")
    @Length(max=64)
    private String orgid;

    /**
     * 岗位所属单位名称
     *
     * @mbggenerated
     */
    @FieldDesc("岗位所属单位名称")
    @Length(max=64)
    private String orgname;

    /**
     * 排序（值小排前）
     *
     * @mbggenerated
     */
    @FieldDesc("排序（值小排前）")
    @Range(min=Integer.MIN_VALUE,max=Integer.MAX_VALUE)
    private Integer sortvalue;

    /**
     * 删除标记
     *
     * @mbggenerated
     */
    @FieldDesc("删除标记")
    @Length(max=2)
    private String isdelete;

    /**
     * 启用标记
     *
     * @mbggenerated
     */
    @FieldDesc("启用标记")
    @Length(max=2)
    private String isenable;

    /**
     * 岗位级别
     *
     * @mbggenerated
     */
    @FieldDesc("岗位级别")
    @Length(max=255)
    private String level;

    /**
     * 岗位描述
     *
     * @mbggenerated
     */
    @FieldDesc("岗位描述")
    @Length(max=300)
    private String description;

    /**
     * 同步明细记录的日志id， 供回写日志状态接口（见第五大点）调用
     *
     * @mbggenerated
     */
    @FieldDesc("同步明细记录的日志id， 供回写日志状态接口（见第五大点）调用")
    @Length(max=64)
    private String logid;

    /**
     * 创建人id
     *
     * @mbggenerated
     */
    @FieldDesc("创建人id")
    @Length(max=64)
    private String createUser;

    /**
     * 创建时间
     *
     * @mbggenerated
     */
    @FieldDesc("创建时间")
    private Date createTime;

    /**
     * 更新人id
     *
     * @mbggenerated
     */
    @FieldDesc("更新人id")
    @Length(max=64)
    private String updateUser;

    /**
     * 更新时间
     *
     * @mbggenerated
     */
    @FieldDesc("更新时间")
    private Date updateTime;

    private static final long serialVersionUID = 1L;

    /**
     * ID
     *
     * @mbggenerated
     */
    public String getId() {
        return id;
    }

    /**
     * ID
     *
     * @mbggenerated
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * 岗位名称
     *
     * @mbggenerated
     */
    public String getName() {
        return name;
    }

    /**
     * 岗位名称
     *
     * @mbggenerated
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 岗位编码
     *
     * @mbggenerated
     */
    public String getCode() {
        return code;
    }

    /**
     * 岗位编码
     *
     * @mbggenerated
     */
    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    /**
     * 岗位所属单位 id
     *
     * @mbggenerated
     */
    public String getOrgid() {
        return orgid;
    }

    /**
     * 岗位所属单位 id
     *
     * @mbggenerated
     */
    public void setOrgid(String orgid) {
        this.orgid = orgid == null ? null : orgid.trim();
    }

    /**
     * 岗位所属单位名称
     *
     * @mbggenerated
     */
    public String getOrgname() {
        return orgname;
    }

    /**
     * 岗位所属单位名称
     *
     * @mbggenerated
     */
    public void setOrgname(String orgname) {
        this.orgname = orgname == null ? null : orgname.trim();
    }

    /**
     * 排序（值小排前）
     *
     * @mbggenerated
     */
    public Integer getSortvalue() {
        return sortvalue;
    }

    /**
     * 排序（值小排前）
     *
     * @mbggenerated
     */
    public void setSortvalue(Integer sortvalue) {
        this.sortvalue = sortvalue;
    }

    /**
     * 删除标记
     *
     * @mbggenerated
     */
    public String getIsdelete() {
        return isdelete;
    }

    /**
     * 删除标记
     *
     * @mbggenerated
     */
    public void setIsdelete(String isdelete) {
        this.isdelete = isdelete == null ? null : isdelete.trim();
    }

    /**
     * 启用标记
     *
     * @mbggenerated
     */
    public String getIsenable() {
        return isenable;
    }

    /**
     * 启用标记
     *
     * @mbggenerated
     */
    public void setIsenable(String isenable) {
        this.isenable = isenable == null ? null : isenable.trim();
    }

    /**
     * 岗位级别
     *
     * @mbggenerated
     */
    public String getLevel() {
        return level;
    }

    /**
     * 岗位级别
     *
     * @mbggenerated
     */
    public void setLevel(String level) {
        this.level = level == null ? null : level.trim();
    }

    /**
     * 岗位描述
     *
     * @mbggenerated
     */
    public String getDescription() {
        return description;
    }

    /**
     * 岗位描述
     *
     * @mbggenerated
     */
    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    /**
     * 同步明细记录的日志id， 供回写日志状态接口（见第五大点）调用
     *
     * @mbggenerated
     */
    public String getLogid() {
        return logid;
    }

    /**
     * 同步明细记录的日志id， 供回写日志状态接口（见第五大点）调用
     *
     * @mbggenerated
     */
    public void setLogid(String logid) {
        this.logid = logid == null ? null : logid.trim();
    }

    /**
     * 创建人id
     *
     * @mbggenerated
     */
    public String getCreateUser() {
        return createUser;
    }

    /**
     * 创建人id
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
     * 更新人id
     *
     * @mbggenerated
     */
    public String getUpdateUser() {
        return updateUser;
    }

    /**
     * 更新人id
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
}