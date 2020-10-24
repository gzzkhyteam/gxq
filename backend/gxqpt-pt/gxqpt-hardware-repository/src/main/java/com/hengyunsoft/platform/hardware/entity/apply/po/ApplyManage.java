package com.hengyunsoft.platform.hardware.entity.apply.po;

import com.hengyunsoft.base.entity.BaseEntity;
import java.io.Serializable;
import java.util.Date;

public class ApplyManage extends BaseEntity<Long> implements Serializable {
    /**
     * 主键
     *
     * @mbggenerated
     */
    private Long id;

    /**
     * 申请单号
     *
     * @mbggenerated
     */
    private String applyNo;

    /**
     * 申请单位id
     *
     * @mbggenerated
     */
    private String applyOrgid;

    /**
     * 申请单位名称
     *
     * @mbggenerated
     */
    private String applyOrgname;

    /**
     * 申请人id
     *
     * @mbggenerated
     */
    private String applyUid;

    /**
     * 审请人姓名
     *
     * @mbggenerated
     */
    private String applyUname;

    /**
     * 申请类型(1新增2变更)
     *
     * @mbggenerated
     */
    private String applyType;

    /**
     * 申请时间
     *
     * @mbggenerated
     */
    private Date applyTime;

    /**
     * 每一个环节的特定标识（避免多个字段确认一个环节）
     *
     * @mbggenerated
     */
    private String stepCode;

    /**
     * 每一个环节的特定环节名称
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
     * 申请人邮箱
     *
     * @mbggenerated
     */
    private String applyEmail;

    /**
     * 申请原因
     *
     * @mbggenerated
     */
    private String applyReason;

    /**
     * 变更源，该表单由哪条服务器变更而来
     *
     * @mbggenerated
     */
    private Long serverKeyid;

    /**
     * 是否分配到资源（1是0否）
     *
     * @mbggenerated
     */
    private Boolean resflag;

    /**
     * 是否正常结束流程（1正常审批中2非正常结束3正常结束）
     *
     * @mbggenerated
     */
    private String endflag;

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
     * 申请单号
     *
     * @mbggenerated
     */
    public String getApplyNo() {
        return applyNo;
    }

    /**
     * 申请单号
     *
     * @mbggenerated
     */
    public void setApplyNo(String applyNo) {
        this.applyNo = applyNo == null ? null : applyNo.trim();
    }

    /**
     * 申请单位id
     *
     * @mbggenerated
     */
    public String getApplyOrgid() {
        return applyOrgid;
    }

    /**
     * 申请单位id
     *
     * @mbggenerated
     */
    public void setApplyOrgid(String applyOrgid) {
        this.applyOrgid = applyOrgid == null ? null : applyOrgid.trim();
    }

    /**
     * 申请单位名称
     *
     * @mbggenerated
     */
    public String getApplyOrgname() {
        return applyOrgname;
    }

    /**
     * 申请单位名称
     *
     * @mbggenerated
     */
    public void setApplyOrgname(String applyOrgname) {
        this.applyOrgname = applyOrgname == null ? null : applyOrgname.trim();
    }

    /**
     * 申请人id
     *
     * @mbggenerated
     */
    public String getApplyUid() {
        return applyUid;
    }

    /**
     * 申请人id
     *
     * @mbggenerated
     */
    public void setApplyUid(String applyUid) {
        this.applyUid = applyUid == null ? null : applyUid.trim();
    }

    /**
     * 审请人姓名
     *
     * @mbggenerated
     */
    public String getApplyUname() {
        return applyUname;
    }

    /**
     * 审请人姓名
     *
     * @mbggenerated
     */
    public void setApplyUname(String applyUname) {
        this.applyUname = applyUname == null ? null : applyUname.trim();
    }

    /**
     * 申请类型(1新增2变更)
     *
     * @mbggenerated
     */
    public String getApplyType() {
        return applyType;
    }

    /**
     * 申请类型(1新增2变更)
     *
     * @mbggenerated
     */
    public void setApplyType(String applyType) {
        this.applyType = applyType == null ? null : applyType.trim();
    }

    /**
     * 申请时间
     *
     * @mbggenerated
     */
    public Date getApplyTime() {
        return applyTime;
    }

    /**
     * 申请时间
     *
     * @mbggenerated
     */
    public void setApplyTime(Date applyTime) {
        this.applyTime = applyTime;
    }

    /**
     * 每一个环节的特定标识（避免多个字段确认一个环节）
     *
     * @mbggenerated
     */
    public String getStepCode() {
        return stepCode;
    }

    /**
     * 每一个环节的特定标识（避免多个字段确认一个环节）
     *
     * @mbggenerated
     */
    public void setStepCode(String stepCode) {
        this.stepCode = stepCode == null ? null : stepCode.trim();
    }

    /**
     * 每一个环节的特定环节名称
     *
     * @mbggenerated
     */
    public String getStepName() {
        return stepName;
    }

    /**
     * 每一个环节的特定环节名称
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
     * 申请人邮箱
     *
     * @mbggenerated
     */
    public String getApplyEmail() {
        return applyEmail;
    }

    /**
     * 申请人邮箱
     *
     * @mbggenerated
     */
    public void setApplyEmail(String applyEmail) {
        this.applyEmail = applyEmail == null ? null : applyEmail.trim();
    }

    /**
     * 申请原因
     *
     * @mbggenerated
     */
    public String getApplyReason() {
        return applyReason;
    }

    /**
     * 申请原因
     *
     * @mbggenerated
     */
    public void setApplyReason(String applyReason) {
        this.applyReason = applyReason == null ? null : applyReason.trim();
    }

    /**
     * 变更源，该表单由哪条服务器变更而来
     *
     * @mbggenerated
     */
    public Long getServerKeyid() {
        return serverKeyid;
    }

    /**
     * 变更源，该表单由哪条服务器变更而来
     *
     * @mbggenerated
     */
    public void setServerKeyid(Long serverKeyid) {
        this.serverKeyid = serverKeyid;
    }

    /**
     * 是否分配到资源（1是0否）
     *
     * @mbggenerated
     */
    public Boolean getResflag() {
        return resflag;
    }

    /**
     * 是否分配到资源（1是0否）
     *
     * @mbggenerated
     */
    public void setResflag(Boolean resflag) {
        this.resflag = resflag;
    }

    /**
     * 是否正常结束流程（1正常审批中2非正常结束3正常结束）
     *
     * @mbggenerated
     */
    public String getEndflag() {
        return endflag;
    }

    /**
     * 是否正常结束流程（1正常审批中2非正常结束3正常结束）
     *
     * @mbggenerated
     */
    public void setEndflag(String endflag) {
        this.endflag = endflag == null ? null : endflag.trim();
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