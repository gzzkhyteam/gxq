package com.hengyunsoft.platform.mt.entity.appr.po;

import com.hengyunsoft.base.entity.BaseEntity;
import java.io.Serializable;
import java.util.Date;

public class ApprApply extends BaseEntity<Long> implements Serializable {
    /**
     * 主键
     *
     * @mbggenerated
     */
    private Long id;

    /**
     * 撤销业务Id
     *
     * @mbggenerated
     */
    private Long applyId;

    /**
     * 撤销原因
     *
     * @mbggenerated
     */
    private String canceReasonl;

    /**
     * 单位
     *
     * @mbggenerated
     */
    private String unitId;

    /**
     * 申请编号
     *
     * @mbggenerated
     */
    private String aprCode;

    /**
     * 审批类型(overtime:加班，leave:请假，business:出差，outside:外勤，:supply:补签)
     *
     * @mbggenerated
     */
    private String aprType;

    /**
     * 申请人Id
     *
     * @mbggenerated
     */
    private Long applyUserId;

    /**
     * 申请人姓名
     *
     * @mbggenerated
     */
    private String applyUserName;

    /**
     * 当前状态(1:审批中，2:已驳回，3:已结束，4:已撤销)
     *
     * @mbggenerated
     */
    private Integer curState;

    /**
     * 当前审批顺序
     *
     * @mbggenerated
     */
    private Integer curUserIndex;

    /**
     * 当前审批人
     *
     * @mbggenerated
     */
    private Long curAprUserId;

    /**
     * 当前审批人姓名
     *
     * @mbggenerated
     */
    private String curAprUserName;

    /**
     * 创建人
     *
     * @mbggenerated
     */
    private Long createUser;

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
    private Long updateUser;

    /**
     * 更新时间
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
     * 撤销业务Id
     *
     * @mbggenerated
     */
    public Long getApplyId() {
        return applyId;
    }

    /**
     * 撤销业务Id
     *
     * @mbggenerated
     */
    public void setApplyId(Long applyId) {
        this.applyId = applyId;
    }

    /**
     * 撤销原因
     *
     * @mbggenerated
     */
    public String getCanceReasonl() {
        return canceReasonl;
    }

    /**
     * 撤销原因
     *
     * @mbggenerated
     */
    public void setCanceReasonl(String canceReasonl) {
        this.canceReasonl = canceReasonl == null ? null : canceReasonl.trim();
    }

    /**
     * 单位
     *
     * @mbggenerated
     */
    public String getUnitId() {
        return unitId;
    }

    /**
     * 单位
     *
     * @mbggenerated
     */
    public void setUnitId(String unitId) {
        this.unitId = unitId == null ? null : unitId.trim();
    }

    /**
     * 申请编号
     *
     * @mbggenerated
     */
    public String getAprCode() {
        return aprCode;
    }

    /**
     * 申请编号
     *
     * @mbggenerated
     */
    public void setAprCode(String aprCode) {
        this.aprCode = aprCode == null ? null : aprCode.trim();
    }

    /**
     * 审批类型(overtime:加班，leave:请假，business:出差，outside:外勤，:supply:补签)
     *
     * @mbggenerated
     */
    public String getAprType() {
        return aprType;
    }

    /**
     * 审批类型(overtime:加班，leave:请假，business:出差，outside:外勤，:supply:补签)
     *
     * @mbggenerated
     */
    public void setAprType(String aprType) {
        this.aprType = aprType == null ? null : aprType.trim();
    }

    /**
     * 申请人Id
     *
     * @mbggenerated
     */
    public Long getApplyUserId() {
        return applyUserId;
    }

    /**
     * 申请人Id
     *
     * @mbggenerated
     */
    public void setApplyUserId(Long applyUserId) {
        this.applyUserId = applyUserId;
    }

    /**
     * 申请人姓名
     *
     * @mbggenerated
     */
    public String getApplyUserName() {
        return applyUserName;
    }

    /**
     * 申请人姓名
     *
     * @mbggenerated
     */
    public void setApplyUserName(String applyUserName) {
        this.applyUserName = applyUserName == null ? null : applyUserName.trim();
    }

    /**
     * 当前状态(1:审批中，2:已驳回，3:已结束，4:撤销中，5：已经撤销)
     *
     * @mbggenerated
     */
    public Integer getCurState() {
        return curState;
    }

    /**
     * 当前状态(1:审批中，2:已驳回，3:已结束，4:撤销中，5：已经撤销)
     *
     * @mbggenerated
     */
    public void setCurState(Integer curState) {
        this.curState = curState;
    }

    /**
     * 当前审批顺序
     *
     * @mbggenerated
     */
    public Integer getCurUserIndex() {
        return curUserIndex;
    }

    /**
     * 当前审批顺序
     *
     * @mbggenerated
     */
    public void setCurUserIndex(Integer curUserIndex) {
        this.curUserIndex = curUserIndex;
    }

    /**
     * 当前审批人
     *
     * @mbggenerated
     */
    public Long getCurAprUserId() {
        return curAprUserId;
    }

    /**
     * 当前审批人
     *
     * @mbggenerated
     */
    public void setCurAprUserId(Long curAprUserId) {
        this.curAprUserId = curAprUserId;
    }

    /**
     * 当前审批人姓名
     *
     * @mbggenerated
     */
    public String getCurAprUserName() {
        return curAprUserName;
    }

    /**
     * 当前审批人姓名
     *
     * @mbggenerated
     */
    public void setCurAprUserName(String curAprUserName) {
        this.curAprUserName = curAprUserName == null ? null : curAprUserName.trim();
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