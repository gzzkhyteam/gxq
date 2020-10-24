package com.hengyunsoft.platform.hardware.entity.apply.po;

import com.hengyunsoft.base.entity.BaseEntity;
import java.io.Serializable;
import java.util.Date;

public class ApplyRecord extends BaseEntity<Long> implements Serializable {
    /**
     * 主键
     *
     * @mbggenerated
     */
    private Long id;

    /**
     * 申请表主键
     *
     * @mbggenerated
     */
    private Long applyKeyid;

    /**
     * 审批人id
     *
     * @mbggenerated
     */
    private String applyUid;

    /**
     * 审批人名称
     *
     * @mbggenerated
     */
    private String applyUname;

    /**
     * 是否通过（1通过2不通过）
     *
     * @mbggenerated
     */
    private String passFlag;

    /**
     * 审批意见
     *
     * @mbggenerated
     */
    private String apprOpinion;

    /**
     * 环节代码
     *
     * @mbggenerated
     */
    private String stepCode;

    /**
     * 处理环节名称
     *
     * @mbggenerated
     */
    private String stepName;

    /**
     * 大环节code（SQ，GL，UY，YY）
     *
     * @mbggenerated
     */
    private String scode;

    /**
     * 大环节名称（申请方，管理员，国信优易，高新翼云）
     *
     * @mbggenerated
     */
    private String sname;

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
     * 修改人
     *
     * @mbggenerated
     */
    private String updateUser;

    /**
     * 修改时间
     *
     * @mbggenerated
     */
    private Date updateTime;

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
     * 申请表主键
     *
     * @mbggenerated
     */
    public Long getApplyKeyid() {
        return applyKeyid;
    }

    /**
     * 申请表主键
     *
     * @mbggenerated
     */
    public void setApplyKeyid(Long applyKeyid) {
        this.applyKeyid = applyKeyid;
    }

    /**
     * 审批人id
     *
     * @mbggenerated
     */
    public String getApplyUid() {
        return applyUid;
    }

    /**
     * 审批人id
     *
     * @mbggenerated
     */
    public void setApplyUid(String applyUid) {
        this.applyUid = applyUid == null ? null : applyUid.trim();
    }

    /**
     * 审批人名称
     *
     * @mbggenerated
     */
    public String getApplyUname() {
        return applyUname;
    }

    /**
     * 审批人名称
     *
     * @mbggenerated
     */
    public void setApplyUname(String applyUname) {
        this.applyUname = applyUname == null ? null : applyUname.trim();
    }

    /**
     * 是否通过（1通过2不通过）
     *
     * @mbggenerated
     */
    public String getPassFlag() {
        return passFlag;
    }

    /**
     * 是否通过（1通过2不通过）
     *
     * @mbggenerated
     */
    public void setPassFlag(String passFlag) {
        this.passFlag = passFlag == null ? null : passFlag.trim();
    }

    /**
     * 审批意见
     *
     * @mbggenerated
     */
    public String getApprOpinion() {
        return apprOpinion;
    }

    /**
     * 审批意见
     *
     * @mbggenerated
     */
    public void setApprOpinion(String apprOpinion) {
        this.apprOpinion = apprOpinion == null ? null : apprOpinion.trim();
    }

    /**
     * 环节代码
     *
     * @mbggenerated
     */
    public String getStepCode() {
        return stepCode;
    }

    /**
     * 环节代码
     *
     * @mbggenerated
     */
    public void setStepCode(String stepCode) {
        this.stepCode = stepCode == null ? null : stepCode.trim();
    }

    /**
     * 处理环节名称
     *
     * @mbggenerated
     */
    public String getStepName() {
        return stepName;
    }

    /**
     * 处理环节名称
     *
     * @mbggenerated
     */
    public void setStepName(String stepName) {
        this.stepName = stepName == null ? null : stepName.trim();
    }

    /**
     * 大环节code（SQ，GL，UY，YY）
     *
     * @mbggenerated
     */
    public String getScode() {
        return scode;
    }

    /**
     * 大环节code（SQ，GL，UY，YY）
     *
     * @mbggenerated
     */
    public void setScode(String scode) {
        this.scode = scode == null ? null : scode.trim();
    }

    /**
     * 大环节名称（申请方，管理员，国信优易，高新翼云）
     *
     * @mbggenerated
     */
    public String getSname() {
        return sname;
    }

    /**
     * 大环节名称（申请方，管理员，国信优易，高新翼云）
     *
     * @mbggenerated
     */
    public void setSname(String sname) {
        this.sname = sname == null ? null : sname.trim();
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
     * 修改人
     *
     * @mbggenerated
     */
    public String getUpdateUser() {
        return updateUser;
    }

    /**
     * 修改人
     *
     * @mbggenerated
     */
    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser == null ? null : updateUser.trim();
    }

    /**
     * 修改时间
     *
     * @mbggenerated
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * 修改时间
     *
     * @mbggenerated
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}