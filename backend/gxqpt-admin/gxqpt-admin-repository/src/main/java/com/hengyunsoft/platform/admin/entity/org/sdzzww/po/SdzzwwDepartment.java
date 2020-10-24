package com.hengyunsoft.platform.admin.entity.org.sdzzww.po;

import com.hengyunsoft.base.entity.BaseEntity;
import com.hengyunsoft.validator.ValidatorGroups;
import com.hengyunsoft.validator.annotation.FieldDesc;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

public class SdzzwwDepartment extends BaseEntity<String> implements Serializable {
    @Length(max=64)
    @NotNull(groups=ValidatorGroups.MustNoneNull.class)
    private String id;

    /**
     * 上级部门名称
     *
     * @mbggenerated
     */
    @FieldDesc("上级部门名称")
    @Length(max=64)
    private String parentName;

    /**
     * 上级部门id
     *
     * @mbggenerated
     */
    @FieldDesc("上级部门id")
    @Length(max=64)
    private String parentId;

    /**
     * 部门所属单位
     *
     * @mbggenerated
     */
    @FieldDesc("部门所属单位")
    @Length(max=64)
    private String orgId;

    /**
     * 部门名称
     *
     * @mbggenerated
     */
    @FieldDesc("部门名称")
    @Length(max=64)
    private String name;

    /**
     * 部门简称
     *
     * @mbggenerated
     */
    @FieldDesc("部门简称")
    @Length(max=64)
    private String shortName;

    /**
     * 部门其它名
     *
     * @mbggenerated
     */
    @FieldDesc("部门其它名")
    @Length(max=64)
    private String elseName;

    /**
     * 所属类型（继承单位）
     *
     * @mbggenerated
     */
    @FieldDesc("所属类型（继承单位）")
    @Length(max=64)
    private String forType;

    /**
     * 所属级别（继承单位）
     *
     * @mbggenerated
     */
    @FieldDesc("所属级别（继承单位）")
    @Length(max=64)
    private String forClass;

    /**
     * 所属系统如公安、税务等（继承单位）
     *
     * @mbggenerated
     */
    @FieldDesc("所属系统如公安、税务等（继承单位）")
    @Length(max=64)
    private String forindustry;

    /**
     * 部门管理员
     *
     * @mbggenerated
     */
    @FieldDesc("部门管理员")
    @Length(max=64)
    private String orgadmin;

    /**
     * 邮编
     *
     * @mbggenerated
     */
    @FieldDesc("邮编")
    @Length(max=64)
    private String zipcode;

    /**
     * 电话
     *
     * @mbggenerated
     */
    @FieldDesc("电话")
    @Length(max=64)
    private String telcode;

    /**
     * 传真
     *
     * @mbggenerated
     */
    @FieldDesc("传真")
    @Length(max=64)
    private String faxcode;

    /**
     * 状态 1正常 2待撤销 3 已撤销
     *
     * @mbggenerated
     */
    @FieldDesc("状态 1正常 2待撤销 3 已撤销")
    @Length(max=2)
    private String status;

    /**
     * 排序（值小排前）
     *
     * @mbggenerated
     */
    @FieldDesc("排序（值小排前）")
    @Range(min=Integer.MIN_VALUE,max=Integer.MAX_VALUE)
    private Integer sortvalue;

    /**
     * 部门介绍
     *
     * @mbggenerated
     */
    @FieldDesc("部门介绍")
    @Length(max=800)
    private String descrption;

    /**
     * 部门节点类型 1为实体单位 0为分类
     *
     * @mbggenerated
     */
    @FieldDesc("部门节点类型 1为实体单位 0为分类")
    @Length(max=2)
    private String fornodetype;

    /**
     * 部门职责
     *
     * @mbggenerated
     */
    @FieldDesc("部门职责")
    @Length(max=800)
    private String orgduty;

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

    /**
     * 同步人员明细记录的日志id， 供回写日志状态接口（见第五大点）调用
     *
     * @mbggenerated
     */
    @FieldDesc("同步人员明细记录的日志id， 供回写日志状态接口（见第五大点）调用")
    @Length(max=64)
    private String logid;

    /**
     * 对应的其它id， 如果未有其它对应则它与本身 id一样
     *
     * @mbggenerated
     */
    @FieldDesc("对应的其它id， 如果未有其它对应则它与本身 id一样")
    @Length(max=64)
    private String otherid;

    private static final long serialVersionUID = 1L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * 上级部门名称
     *
     * @mbggenerated
     */
    public String getParentName() {
        return parentName;
    }

    /**
     * 上级部门名称
     *
     * @mbggenerated
     */
    public void setParentName(String parentName) {
        this.parentName = parentName == null ? null : parentName.trim();
    }

    /**
     * 上级部门id
     *
     * @mbggenerated
     */
    public String getParentId() {
        return parentId;
    }

    /**
     * 上级部门id
     *
     * @mbggenerated
     */
    public void setParentId(String parentId) {
        this.parentId = parentId == null ? null : parentId.trim();
    }

    /**
     * 部门所属单位
     *
     * @mbggenerated
     */
    public String getOrgId() {
        return orgId;
    }

    /**
     * 部门所属单位
     *
     * @mbggenerated
     */
    public void setOrgId(String orgId) {
        this.orgId = orgId == null ? null : orgId.trim();
    }

    /**
     * 部门名称
     *
     * @mbggenerated
     */
    public String getName() {
        return name;
    }

    /**
     * 部门名称
     *
     * @mbggenerated
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 部门简称
     *
     * @mbggenerated
     */
    public String getShortName() {
        return shortName;
    }

    /**
     * 部门简称
     *
     * @mbggenerated
     */
    public void setShortName(String shortName) {
        this.shortName = shortName == null ? null : shortName.trim();
    }

    /**
     * 部门其它名
     *
     * @mbggenerated
     */
    public String getElseName() {
        return elseName;
    }

    /**
     * 部门其它名
     *
     * @mbggenerated
     */
    public void setElseName(String elseName) {
        this.elseName = elseName == null ? null : elseName.trim();
    }

    /**
     * 所属类型（继承单位）
     *
     * @mbggenerated
     */
    public String getForType() {
        return forType;
    }

    /**
     * 所属类型（继承单位）
     *
     * @mbggenerated
     */
    public void setForType(String forType) {
        this.forType = forType == null ? null : forType.trim();
    }

    /**
     * 所属级别（继承单位）
     *
     * @mbggenerated
     */
    public String getForClass() {
        return forClass;
    }

    /**
     * 所属级别（继承单位）
     *
     * @mbggenerated
     */
    public void setForClass(String forClass) {
        this.forClass = forClass == null ? null : forClass.trim();
    }

    /**
     * 所属系统如公安、税务等（继承单位）
     *
     * @mbggenerated
     */
    public String getForindustry() {
        return forindustry;
    }

    /**
     * 所属系统如公安、税务等（继承单位）
     *
     * @mbggenerated
     */
    public void setForindustry(String forindustry) {
        this.forindustry = forindustry == null ? null : forindustry.trim();
    }

    /**
     * 部门管理员
     *
     * @mbggenerated
     */
    public String getOrgadmin() {
        return orgadmin;
    }

    /**
     * 部门管理员
     *
     * @mbggenerated
     */
    public void setOrgadmin(String orgadmin) {
        this.orgadmin = orgadmin == null ? null : orgadmin.trim();
    }

    /**
     * 邮编
     *
     * @mbggenerated
     */
    public String getZipcode() {
        return zipcode;
    }

    /**
     * 邮编
     *
     * @mbggenerated
     */
    public void setZipcode(String zipcode) {
        this.zipcode = zipcode == null ? null : zipcode.trim();
    }

    /**
     * 电话
     *
     * @mbggenerated
     */
    public String getTelcode() {
        return telcode;
    }

    /**
     * 电话
     *
     * @mbggenerated
     */
    public void setTelcode(String telcode) {
        this.telcode = telcode == null ? null : telcode.trim();
    }

    /**
     * 传真
     *
     * @mbggenerated
     */
    public String getFaxcode() {
        return faxcode;
    }

    /**
     * 传真
     *
     * @mbggenerated
     */
    public void setFaxcode(String faxcode) {
        this.faxcode = faxcode == null ? null : faxcode.trim();
    }

    /**
     * 状态 1正常 2待撤销 3 已撤销
     *
     * @mbggenerated
     */
    public String getStatus() {
        return status;
    }

    /**
     * 状态 1正常 2待撤销 3 已撤销
     *
     * @mbggenerated
     */
    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
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
     * 部门介绍
     *
     * @mbggenerated
     */
    public String getDescrption() {
        return descrption;
    }

    /**
     * 部门介绍
     *
     * @mbggenerated
     */
    public void setDescrption(String descrption) {
        this.descrption = descrption == null ? null : descrption.trim();
    }

    /**
     * 部门节点类型 1为实体单位 0为分类
     *
     * @mbggenerated
     */
    public String getFornodetype() {
        return fornodetype;
    }

    /**
     * 部门节点类型 1为实体单位 0为分类
     *
     * @mbggenerated
     */
    public void setFornodetype(String fornodetype) {
        this.fornodetype = fornodetype == null ? null : fornodetype.trim();
    }

    /**
     * 部门职责
     *
     * @mbggenerated
     */
    public String getOrgduty() {
        return orgduty;
    }

    /**
     * 部门职责
     *
     * @mbggenerated
     */
    public void setOrgduty(String orgduty) {
        this.orgduty = orgduty == null ? null : orgduty.trim();
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

    /**
     * 同步人员明细记录的日志id， 供回写日志状态接口（见第五大点）调用
     *
     * @mbggenerated
     */
    public String getLogid() {
        return logid;
    }

    /**
     * 同步人员明细记录的日志id， 供回写日志状态接口（见第五大点）调用
     *
     * @mbggenerated
     */
    public void setLogid(String logid) {
        this.logid = logid == null ? null : logid.trim();
    }

    /**
     * 对应的其它id， 如果未有其它对应则它与本身 id一样
     *
     * @mbggenerated
     */
    public String getOtherid() {
        return otherid;
    }

    /**
     * 对应的其它id， 如果未有其它对应则它与本身 id一样
     *
     * @mbggenerated
     */
    public void setOtherid(String otherid) {
        this.otherid = otherid == null ? null : otherid.trim();
    }
}