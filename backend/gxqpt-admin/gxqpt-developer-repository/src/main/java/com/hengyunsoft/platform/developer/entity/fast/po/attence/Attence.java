package com.hengyunsoft.platform.developer.entity.fast.po.attence;

import com.hengyunsoft.base.entity.CommonBaseEntity;
import java.io.Serializable;
import java.util.Date;

public class Attence extends CommonBaseEntity<Long> implements Serializable {
    /**
     * 主键
     *
     * @mbggenerated
     */
    private Long id;

    /**
     * 应用ID
     *
     * @mbggenerated
     */
    private String appId;

    /**
     * 签到
     *
     * @mbggenerated
     */
    private Date inTime;

    /**
     * 备注
     *
     * @mbggenerated
     */
    private String inRemark;

    /**
     * 签到图片Id，逗号分隔
     *
     * @mbggenerated
     */
    private String inPicture;

    /**
     * 抄送部门ID拼接字符串
     *
     * @mbggenerated
     */
    private String inDeptId;

    /**
     * 抄送人员 ID逗号分隔字符串
     *
     * @mbggenerated
     */
    private String inEmpId;

    /**
     * 经度
     *
     * @mbggenerated
     */
    private Double inLatitude;

    /**
     * 纬度
     *
     * @mbggenerated
     */
    private Double inLongitude;

    /**
     * 地址
     *
     * @mbggenerated
     */
    private String inAddress;

    /**
     * 是否自动签到（0：否，1:是）
     *
     * @mbggenerated
     */
    private Integer inAutoSign;

    /**
     * 签到用户ID
     *
     * @mbggenerated
     */
    private Long userid;

    /**
     * 0：签到，1： 签退
     *
     * @mbggenerated
     */
    private Integer inSignType;

    /**
     * 操作类型（0:内勤，1:外勤）
     *
     * @mbggenerated
     */
    private Integer inHandleType;

    /**
     * 签退时间
     *
     * @mbggenerated
     */
    private Date outTime;

    /**
     * 备注
     *
     * @mbggenerated
     */
    private String outRemark;

    /**
     * 签退图片（逗号分隔多张图片Id）
     *
     * @mbggenerated
     */
    private String outPicture;

    /**
     * 签退抄送部门（逗号分隔多个ID）
     *
     * @mbggenerated
     */
    private String outDeptId;

    /**
     * 签退抄送人员（多个人员逗号分隔）
     *
     * @mbggenerated
     */
    private String outEmpId;

    /**
     * 签退经度
     *
     * @mbggenerated
     */
    private Double outLatitude;

    /**
     * 签退纬度
     *
     * @mbggenerated
     */
    private Double outLongtude;

    /**
     * 签退地址
     *
     * @mbggenerated
     */
    private String outAddress;

    /**
     * 0：签到，1： 签退
     *
     * @mbggenerated
     */
    private Integer outSignType;

    /**
     * 操作类型（0:内勤，1:外勤）
     *
     * @mbggenerated
     */
    private Integer outHandleType;

    /**
     * 是否自动签退（0：否，1：是）
     *
     * @mbggenerated
     */
    private Integer outAutoSign;

    /**
     * 创建时间
     *
     * @mbggenerated
     */
    private Date createTime;

    /**
     * 更新时间
     *
     * @mbggenerated
     */
    private Date updateTime;

    /**
     * 创建人
     *
     * @mbggenerated
     */
    private Long createUser;

    /**
     * 更新人
     *
     * @mbggenerated
     */
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
     * 应用ID
     *
     * @mbggenerated
     */
    public String getAppId() {
        return appId;
    }

    /**
     * 应用ID
     *
     * @mbggenerated
     */
    public void setAppId(String appId) {
        this.appId = appId == null ? null : appId.trim();
    }

    /**
     * 签到
     *
     * @mbggenerated
     */
    public Date getInTime() {
        return inTime;
    }

    /**
     * 签到
     *
     * @mbggenerated
     */
    public void setInTime(Date inTime) {
        this.inTime = inTime;
    }

    /**
     * 备注
     *
     * @mbggenerated
     */
    public String getInRemark() {
        return inRemark;
    }

    /**
     * 备注
     *
     * @mbggenerated
     */
    public void setInRemark(String inRemark) {
        this.inRemark = inRemark == null ? null : inRemark.trim();
    }

    /**
     * 签到图片Id，逗号分隔
     *
     * @mbggenerated
     */
    public String getInPicture() {
        return inPicture;
    }

    /**
     * 签到图片Id，逗号分隔
     *
     * @mbggenerated
     */
    public void setInPicture(String inPicture) {
        this.inPicture = inPicture == null ? null : inPicture.trim();
    }

    /**
     * 抄送部门ID拼接字符串
     *
     * @mbggenerated
     */
    public String getInDeptId() {
        return inDeptId;
    }

    /**
     * 抄送部门ID拼接字符串
     *
     * @mbggenerated
     */
    public void setInDeptId(String inDeptId) {
        this.inDeptId = inDeptId == null ? null : inDeptId.trim();
    }

    /**
     * 抄送人员 ID逗号分隔字符串
     *
     * @mbggenerated
     */
    public String getInEmpId() {
        return inEmpId;
    }

    /**
     * 抄送人员 ID逗号分隔字符串
     *
     * @mbggenerated
     */
    public void setInEmpId(String inEmpId) {
        this.inEmpId = inEmpId == null ? null : inEmpId.trim();
    }

    /**
     * 经度
     *
     * @mbggenerated
     */
    public Double getInLatitude() {
        return inLatitude;
    }

    /**
     * 经度
     *
     * @mbggenerated
     */
    public void setInLatitude(Double inLatitude) {
        this.inLatitude = inLatitude;
    }

    /**
     * 纬度
     *
     * @mbggenerated
     */
    public Double getInLongitude() {
        return inLongitude;
    }

    /**
     * 纬度
     *
     * @mbggenerated
     */
    public void setInLongitude(Double inLongitude) {
        this.inLongitude = inLongitude;
    }

    /**
     * 地址
     *
     * @mbggenerated
     */
    public String getInAddress() {
        return inAddress;
    }

    /**
     * 地址
     *
     * @mbggenerated
     */
    public void setInAddress(String inAddress) {
        this.inAddress = inAddress == null ? null : inAddress.trim();
    }

    /**
     * 是否自动签到（0：否，1:是）
     *
     * @mbggenerated
     */
    public Integer getInAutoSign() {
        return inAutoSign;
    }

    /**
     * 是否自动签到（0：否，1:是）
     *
     * @mbggenerated
     */
    public void setInAutoSign(Integer inAutoSign) {
        this.inAutoSign = inAutoSign;
    }

    /**
     * 签到用户ID
     *
     * @mbggenerated
     */
    public Long getUserid() {
        return userid;
    }

    /**
     * 签到用户ID
     *
     * @mbggenerated
     */
    public void setUserid(Long userid) {
        this.userid = userid;
    }

    /**
     * 0：签到，1： 签退
     *
     * @mbggenerated
     */
    public Integer getInSignType() {
        return inSignType;
    }

    /**
     * 0：签到，1： 签退
     *
     * @mbggenerated
     */
    public void setInSignType(Integer inSignType) {
        this.inSignType = inSignType;
    }

    /**
     * 操作类型（0:内勤，1:外勤）
     *
     * @mbggenerated
     */
    public Integer getInHandleType() {
        return inHandleType;
    }

    /**
     * 操作类型（0:内勤，1:外勤）
     *
     * @mbggenerated
     */
    public void setInHandleType(Integer inHandleType) {
        this.inHandleType = inHandleType;
    }

    /**
     * 签退时间
     *
     * @mbggenerated
     */
    public Date getOutTime() {
        return outTime;
    }

    /**
     * 签退时间
     *
     * @mbggenerated
     */
    public void setOutTime(Date outTime) {
        this.outTime = outTime;
    }

    /**
     * 备注
     *
     * @mbggenerated
     */
    public String getOutRemark() {
        return outRemark;
    }

    /**
     * 备注
     *
     * @mbggenerated
     */
    public void setOutRemark(String outRemark) {
        this.outRemark = outRemark == null ? null : outRemark.trim();
    }

    /**
     * 签退图片（逗号分隔多张图片Id）
     *
     * @mbggenerated
     */
    public String getOutPicture() {
        return outPicture;
    }

    /**
     * 签退图片（逗号分隔多张图片Id）
     *
     * @mbggenerated
     */
    public void setOutPicture(String outPicture) {
        this.outPicture = outPicture == null ? null : outPicture.trim();
    }

    /**
     * 签退抄送部门（逗号分隔多个ID）
     *
     * @mbggenerated
     */
    public String getOutDeptId() {
        return outDeptId;
    }

    /**
     * 签退抄送部门（逗号分隔多个ID）
     *
     * @mbggenerated
     */
    public void setOutDeptId(String outDeptId) {
        this.outDeptId = outDeptId == null ? null : outDeptId.trim();
    }

    /**
     * 签退抄送人员（多个人员逗号分隔）
     *
     * @mbggenerated
     */
    public String getOutEmpId() {
        return outEmpId;
    }

    /**
     * 签退抄送人员（多个人员逗号分隔）
     *
     * @mbggenerated
     */
    public void setOutEmpId(String outEmpId) {
        this.outEmpId = outEmpId == null ? null : outEmpId.trim();
    }

    /**
     * 签退经度
     *
     * @mbggenerated
     */
    public Double getOutLatitude() {
        return outLatitude;
    }

    /**
     * 签退经度
     *
     * @mbggenerated
     */
    public void setOutLatitude(Double outLatitude) {
        this.outLatitude = outLatitude;
    }

    /**
     * 签退纬度
     *
     * @mbggenerated
     */
    public Double getOutLongtude() {
        return outLongtude;
    }

    /**
     * 签退纬度
     *
     * @mbggenerated
     */
    public void setOutLongtude(Double outLongtude) {
        this.outLongtude = outLongtude;
    }

    /**
     * 签退地址
     *
     * @mbggenerated
     */
    public String getOutAddress() {
        return outAddress;
    }

    /**
     * 签退地址
     *
     * @mbggenerated
     */
    public void setOutAddress(String outAddress) {
        this.outAddress = outAddress == null ? null : outAddress.trim();
    }

    /**
     * 0：签到，1： 签退
     *
     * @mbggenerated
     */
    public Integer getOutSignType() {
        return outSignType;
    }

    /**
     * 0：签到，1： 签退
     *
     * @mbggenerated
     */
    public void setOutSignType(Integer outSignType) {
        this.outSignType = outSignType;
    }

    /**
     * 操作类型（0:内勤，1:外勤）
     *
     * @mbggenerated
     */
    public Integer getOutHandleType() {
        return outHandleType;
    }

    /**
     * 操作类型（0:内勤，1:外勤）
     *
     * @mbggenerated
     */
    public void setOutHandleType(Integer outHandleType) {
        this.outHandleType = outHandleType;
    }

    /**
     * 是否自动签退（0：否，1：是）
     *
     * @mbggenerated
     */
    public Integer getOutAutoSign() {
        return outAutoSign;
    }

    /**
     * 是否自动签退（0：否，1：是）
     *
     * @mbggenerated
     */
    public void setOutAutoSign(Integer outAutoSign) {
        this.outAutoSign = outAutoSign;
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
}