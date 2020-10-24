package com.hengyunsoft.platform.mt.entity.work.po;

import com.hengyunsoft.base.entity.BaseEntity;
import com.hengyunsoft.validator.ValidatorGroups;
import com.hengyunsoft.validator.annotation.FieldDesc;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

public class WorkLog extends BaseEntity<Long> implements Serializable {
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
     * 创建人
     *
     * @mbggenerated
     */
    @FieldDesc("创建人")
    @Range(min=Long.MIN_VALUE,max=Long.MAX_VALUE)
    private Long userId;

    /**
     * 照片/头像
     *
     * @mbggenerated
     */
    @FieldDesc("照片/头像")
    @Length(max=1000)
    private String photo;

    /**
     * 用户姓名
     *
     * @mbggenerated
     */
    @FieldDesc("用户姓名")
    @Length(max=64)
    private String userName;

    /**
     * 单位id
     *
     * @mbggenerated
     */
    @FieldDesc("单位id")
    @Length(max=64)
    private String mainOrgId;

    /**
     * 部门id或处室id
     *
     * @mbggenerated
     */
    @FieldDesc("部门id或处室id")
    @Length(max=64)
    private String mainDeptId;

    /**
     * 所属部门名称(处室)
     *
     * @mbggenerated
     */
    @FieldDesc("所属部门名称(处室)")
    @Length(max=64)
    private String mainDeptName;

    /**
     * 所属职务名称
     *
     * @mbggenerated
     */
    @FieldDesc("所属职务名称")
    @Length(max=64)
    private String mainDutyName;

    /**
     * 创建日期
     *
     * @mbggenerated
     */
    @FieldDesc("创建日期")
    private Date createDate;

    /**
     * 当前数量
     *
     * @mbggenerated
     */
    @FieldDesc("当前数量")
    @Range(min=Integer.MIN_VALUE,max=Integer.MAX_VALUE)
    private Integer nowNum;

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
     * 创建人
     *
     * @mbggenerated
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * 创建人
     *
     * @mbggenerated
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * 照片/头像
     *
     * @mbggenerated
     */
    public String getPhoto() {
        return photo;
    }

    /**
     * 照片/头像
     *
     * @mbggenerated
     */
    public void setPhoto(String photo) {
        this.photo = photo == null ? null : photo.trim();
    }

    /**
     * 用户姓名
     *
     * @mbggenerated
     */
    public String getUserName() {
        return userName;
    }

    /**
     * 用户姓名
     *
     * @mbggenerated
     */
    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    /**
     * 单位id
     *
     * @mbggenerated
     */
    public String getMainOrgId() {
        return mainOrgId;
    }

    /**
     * 单位id
     *
     * @mbggenerated
     */
    public void setMainOrgId(String mainOrgId) {
        this.mainOrgId = mainOrgId == null ? null : mainOrgId.trim();
    }

    /**
     * 部门id或处室id
     *
     * @mbggenerated
     */
    public String getMainDeptId() {
        return mainDeptId;
    }

    /**
     * 部门id或处室id
     *
     * @mbggenerated
     */
    public void setMainDeptId(String mainDeptId) {
        this.mainDeptId = mainDeptId == null ? null : mainDeptId.trim();
    }

    /**
     * 所属部门名称(处室)
     *
     * @mbggenerated
     */
    public String getMainDeptName() {
        return mainDeptName;
    }

    /**
     * 所属部门名称(处室)
     *
     * @mbggenerated
     */
    public void setMainDeptName(String mainDeptName) {
        this.mainDeptName = mainDeptName == null ? null : mainDeptName.trim();
    }

    /**
     * 所属职务名称
     *
     * @mbggenerated
     */
    public String getMainDutyName() {
        return mainDutyName;
    }

    /**
     * 所属职务名称
     *
     * @mbggenerated
     */
    public void setMainDutyName(String mainDutyName) {
        this.mainDutyName = mainDutyName == null ? null : mainDutyName.trim();
    }

    /**
     * 创建日期
     *
     * @mbggenerated
     */
    public Date getCreateDate() {
        return createDate;
    }

    /**
     * 创建日期
     *
     * @mbggenerated
     */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    /**
     * 当前数量
     *
     * @mbggenerated
     */
    public Integer getNowNum() {
        return nowNum;
    }

    /**
     * 当前数量
     *
     * @mbggenerated
     */
    public void setNowNum(Integer nowNum) {
        this.nowNum = nowNum;
    }
}