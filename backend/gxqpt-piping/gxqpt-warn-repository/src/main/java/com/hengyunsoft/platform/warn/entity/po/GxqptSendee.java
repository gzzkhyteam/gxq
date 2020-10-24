package com.hengyunsoft.platform.warn.entity.po;

import com.hengyunsoft.base.entity.BaseEntity;
import java.io.Serializable;
import java.util.Date;

public class GxqptSendee extends BaseEntity<Long> implements Serializable {

    /**
     * 预警状态：未确认
     */
    public static  final String STATUS1 = "1";
    /**
     * 预警状态：已确认
     */
    public static  final String STATUS2 = "2";
    /**
     * 预警状态：已处理
     */
    public static  final String STATUS3 = "3";
    /**
     * 预警接收人类型：确认人
     */
    public static  final String RECTYPE1 = "1";
    /**
     * 预警接收人类型：抄送人
     */
    public static  final String RECTYPE2 = "2";
    /**
     * 预警接收人类型：责任人
     */
    public static  final String RECTYPE3 = "3";
    /**
     * 是否由该用户处理：由该用户处理
     */
    public static  final Boolean WHOHANDLE = true;
    /**
     * 是否由该用户处理：不该由该用户处理
     */
    public static  final Boolean UNWHOHANDLE = false;

    /**
     * 主键id
     *
     * @mbggenerated
     */
    private Long id;

    /**
     * 用户id
     *
     * @mbggenerated
     */
    private Long userId;

    /**
     * 预警id
     *
     * @mbggenerated
     */
    private Long warnId;

    /**
     * 接收人姓名
     *
     * @mbggenerated
     */
    private String recName;

    /**
     * 接收人类型 1、确认人 2、抄送人 3、责任人
     *
     * @mbggenerated
     */
    private String recType;

    /**
     * 接收时间
     *
     * @mbggenerated
     */
    private Date recTime;

    /**
     * 预警状态  1、未确认 2、已确认 3、已处理
     *
     * @mbggenerated
     */
    private String status;

    /**
     * 备注
     *
     * @mbggenerated
     */
    private String remarks;

    /**
     * 处理人级别 1代表最低的级别
     *
     * @mbggenerated
     */
    private Integer handlerLeve;

    /**
     * 处理结果标识 0、不属实 1、属实
     *
     * @mbggenerated
     */
    private Boolean result;

    /**
     * 处理标识  1、由此用户处理 0、不该此用户处理
     *
     * @mbggenerated
     */
    private Boolean whoHandle;

    /**
     * 人员所属部门
     *
     * @mbggenerated
     */
    private String departmentId;

    /**
     * 人员所在部门名称
     *
     * @mbggenerated
     */
    private String departmentName;

    /**
     * 部门所属单位
     *
     * @mbggenerated
     */
    private String orgId;

    /**
     * 部门所在单位名称
     *
     * @mbggenerated
     */
    private String orgName;

    /**
     * 创建人
     *
     * @mbggenerated
     */
    private String createUser;

    /**
     * 创建时间
     *
     * @mbggenerated
     */
    private Date createTime;

    /**
     * 更新人
     *
     * @mbggenerated
     */
    private String updateUser;

    /**
     * 更新时间
     *
     * @mbggenerated
     */
    private Date updateTime;

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
     * 用户id
     *
     * @mbggenerated
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * 用户id
     *
     * @mbggenerated
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * 预警id
     *
     * @mbggenerated
     */
    public Long getWarnId() {
        return warnId;
    }

    /**
     * 预警id
     *
     * @mbggenerated
     */
    public void setWarnId(Long warnId) {
        this.warnId = warnId;
    }

    /**
     * 接收人姓名
     *
     * @mbggenerated
     */
    public String getRecName() {
        return recName;
    }

    /**
     * 接收人姓名
     *
     * @mbggenerated
     */
    public void setRecName(String recName) {
        this.recName = recName == null ? null : recName.trim();
    }

    /**
     * 接收人类型 确认人、抄送人、责任人
     *
     * @mbggenerated
     */
    public String getRecType() {
        return recType;
    }

    /**
     * 接收人类型 确认人、抄送人、责任人
     *
     * @mbggenerated
     */
    public void setRecType(String recType) {
        this.recType = recType == null ? null : recType.trim();
    }

    /**
     * 接收时间
     *
     * @mbggenerated
     */
    public Date getRecTime() {
        return recTime;
    }

    /**
     * 接收时间
     *
     * @mbggenerated
     */
    public void setRecTime(Date recTime) {
        this.recTime = recTime;
    }

    /**
     * 预警状态  未确认、已确认、已处理
     *
     * @mbggenerated
     */
    public String getStatus() {
        return status;
    }

    /**
     * 预警状态  未确认、已确认、已处理
     *
     * @mbggenerated
     */
    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    /**
     * 备注
     *
     * @mbggenerated
     */
    public String getRemarks() {
        return remarks;
    }

    /**
     * 备注
     *
     * @mbggenerated
     */
    public void setRemarks(String remarks) {
        this.remarks = remarks == null ? null : remarks.trim();
    }

    /**
     * 处理人级别 1代表最低的级别
     *
     * @mbggenerated
     */
    public Integer getHandlerLeve() {
        return handlerLeve;
    }

    /**
     * 处理人级别 1代表最低的级别
     *
     * @mbggenerated
     */
    public void setHandlerLeve(Integer handlerLeve) {
        this.handlerLeve = handlerLeve;
    }

    /**
     * 处理结果标识 0、不属实 1、属实
     *
     * @mbggenerated
     */
    public Boolean getResult() {
        return result;
    }

    /**
     * 处理结果标识 0、不属实 1、属实
     *
     * @mbggenerated
     */
    public void setResult(Boolean result) {
        this.result = result;
    }

    /**
     * 处理标识  1、由此用户处理 0、不该此用户处理
     *
     * @mbggenerated
     */
    public Boolean getWhoHandle() {
        return whoHandle;
    }

    /**
     * 处理标识  1、由此用户处理 0、不该此用户处理
     *
     * @mbggenerated
     */
    public void setWhoHandle(Boolean whoHandle) {
        this.whoHandle = whoHandle;
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

    public String getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getOrgId() {
        return orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId;
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }
}