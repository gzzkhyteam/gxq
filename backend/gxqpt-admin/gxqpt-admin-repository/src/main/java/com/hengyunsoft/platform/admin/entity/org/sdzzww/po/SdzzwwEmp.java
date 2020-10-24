package com.hengyunsoft.platform.admin.entity.org.sdzzww.po;

import com.hengyunsoft.base.entity.BaseEntity;
import com.hengyunsoft.validator.ValidatorGroups;
import com.hengyunsoft.validator.annotation.FieldDesc;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

public class SdzzwwEmp extends BaseEntity<String> implements Serializable {
    /**
     * ID
     *
     * @mbggenerated
     */
    @FieldDesc("ID")
    @Length(max = 64)
    @NotNull(groups = ValidatorGroups.MustNoneNull.class)
    private String id;

    /**
     * 姓名
     *
     * @mbggenerated
     */
    @FieldDesc("姓名")
    @Length(max = 64)
    private String name;

    /**
     * 登录账号
     *
     * @mbggenerated
     */
    @FieldDesc("登录账号")
    @Length(max = 64)
    private String nickname;

    /**
     * md5密码
     *
     * @mbggenerated
     */
    @FieldDesc("md5密码")
    @Length(max = 64)
    private String passwordmd5;

    /**
     * SHA密码
     *
     * @mbggenerated
     */
    @FieldDesc("SHA密码")
    @Length(max = 64)
    private String passwordsha;

    /**
     * 性别
     *
     * @mbggenerated
     */
    @FieldDesc("性别")
    @Length(max = 2)
    private String sex;

    /**
     * 生日
     *
     * @mbggenerated
     */
    @FieldDesc("生日")
    @Length(max = 20)
    private String birthday;

    /**
     * 民族
     *
     * @mbggenerated
     */
    @FieldDesc("民族")
    @Length(max = 8)
    private String nation;

    /**
     * 照片
     *
     * @mbggenerated
     */
    @FieldDesc("照片")
    @Length(max = 100)
    private String photo;

    /**
     * 所属单位id
     *
     * @mbggenerated
     */
    @FieldDesc("所属单位id")
    @Length(max = 64)
    private String mainorgid;

    /**
     * 所属单位名称
     *
     * @mbggenerated
     */
    @FieldDesc("所属单位名称")
    @Length(max = 64)
    private String mainorgname;

    /**
     * 所属部门id
     *
     * @mbggenerated
     */
    @FieldDesc("所属部门id")
    @Length(max = 64)
    private String maindeptid;

    /**
     * 所属部门名称
     *
     * @mbggenerated
     */
    @FieldDesc("所属部门名称")
    @Length(max = 64)
    private String maindeptname;

    /**
     * 所属职务id
     *
     * @mbggenerated
     */
    @FieldDesc("所属职务id")
    @Length(max = 64)
    private String mainduty;

    /**
     * 所属职务名称
     *
     * @mbggenerated
     */
    @FieldDesc("所属职务名称")
    @Length(max = 64)
    private String maindutyname;

    /**
     * 所属岗位id
     *
     * @mbggenerated
     */
    @FieldDesc("所属岗位id")
    @Length(max = 64)
    private String mainpost;

    /**
     * 所属岗位名称
     *
     * @mbggenerated
     */
    @FieldDesc("所属岗位名称")
    @Length(max = 64)
    private String mainpostname;

    /**
     * 办公电话
     *
     * @mbggenerated
     */
    @FieldDesc("办公电话")
    @Length(max = 20)
    private String officetel;

    /**
     * 手机1
     *
     * @mbggenerated
     */
    @FieldDesc("手机1")
    @Length(max = 20)
    private String mainmobile;

    /**
     * 手机2
     *
     * @mbggenerated
     */
    @FieldDesc("手机2")
    @Length(max = 20)
    private String submobile;

    /**
     * 是否单位管理员
     *
     * @mbggenerated
     */
    @FieldDesc("是否单位管理员")
    @Length(max = 2)
    private String isorgadmin;

    /**
     * 删除标记
     *
     * @mbggenerated
     */
    @FieldDesc("删除标记")
    @Length(max = 2)
    private String isdelete;

    /**
     * 启用标记
     *
     * @mbggenerated
     */
    @FieldDesc("启用标记")
    @Length(max = 2)
    private String isenable;

    /**
     * 用户类型id
     *
     * @mbggenerated
     */
    @FieldDesc("用户类型id")
    @Length(max = 2)
    private String usertype;

    /**
     * 状态 1在职、 2 转职中、 3 离职、 4 退休
     *
     * @mbggenerated
     */
    @FieldDesc("状态 1在职、 2 转职中、 3 离职、 4 退休")
    @Length(max = 2)
    private String status;

    /**
     * 个人简介
     *
     * @mbggenerated
     */
    @FieldDesc("个人简介")
    @Length(max = 300)
    private String descrption;

    /**
     * 是否政协委员
     *
     * @mbggenerated
     */
    @FieldDesc("是否政协委员")
    @Length(max = 1)
    private String iscommittee;

    /**
     * 是否人大代表
     *
     * @mbggenerated
     */
    @FieldDesc("是否人大代表")
    @Length(max = 1)
    private String isdeputy;

    /**
     * 是否单位一把手
     *
     * @mbggenerated
     */
    @FieldDesc("是否单位一把手")
    @Length(max = 1)
    private String isheader;

    /**
     * 是否单位领导
     *
     * @mbggenerated
     */
    @FieldDesc("是否单位领导")
    @Length(max = 1)
    private String isleader;

    /**
     * 人员职责
     *
     * @mbggenerated
     */
    @FieldDesc("人员职责")
    @Length(max = 300)
    private String userduty;

    /**
     * 排序权重值赿小靠前
     *
     * @mbggenerated
     */
    @FieldDesc("排序权重值赿小靠前")
    @Range(min = Integer.MIN_VALUE, max = Integer.MAX_VALUE)
    private Integer sortvalue;

    /**
     * 职务级别
     *
     * @mbggenerated
     */
    @FieldDesc("职务级别")
    @Length(max = 5)
    private String dutylevel;

    /**
     * 对应的其它id， 如果未有其它对应则它与本身 id一样
     *
     * @mbggenerated
     */
    @FieldDesc("对应的其它id， 如果未有其它对应则它与本身 id一样")
    @Length(max = 64)
    private String otherid;

    /**
     * 创建人id
     *
     * @mbggenerated
     */
    @FieldDesc("创建人id")
    @Length(max = 64)
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
    @Length(max = 64)
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
    @Length(max = 64)
    private String logid;

    /**
     * 高新区平台中的用户id
     *
     * @mbggenerated
     */
    @FieldDesc("高新区平台中的用户id")
    @Range(min = Long.MIN_VALUE, max = Long.MAX_VALUE)
    private Long gxqptEmpId;

    /**
     * 最高学历
     *
     * @mbggenerated
     */
    @FieldDesc("最高学历")
    @Length(max = 64)
    private String education;

    /**
     * 统一人员编号
     *
     * @mbggenerated
     */
    @FieldDesc("统一人员编号")
    @Length(max = 255)
    private String empNo;

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
     * 姓名
     *
     * @mbggenerated
     */
    public String getName() {
        return name;
    }

    /**
     * 姓名
     *
     * @mbggenerated
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 登录账号
     *
     * @mbggenerated
     */
    public String getNickname() {
        return nickname;
    }

    /**
     * 登录账号
     *
     * @mbggenerated
     */
    public void setNickname(String nickname) {
        this.nickname = nickname == null ? null : nickname.trim();
    }

    /**
     * md5密码
     *
     * @mbggenerated
     */
    public String getPasswordmd5() {
        return passwordmd5;
    }

    /**
     * md5密码
     *
     * @mbggenerated
     */
    public void setPasswordmd5(String passwordmd5) {
        this.passwordmd5 = passwordmd5 == null ? null : passwordmd5.trim();
    }

    /**
     * SHA密码
     *
     * @mbggenerated
     */
    public String getPasswordsha() {
        return passwordsha;
    }

    /**
     * SHA密码
     *
     * @mbggenerated
     */
    public void setPasswordsha(String passwordsha) {
        this.passwordsha = passwordsha == null ? null : passwordsha.trim();
    }

    /**
     * 性别
     *
     * @mbggenerated
     */
    public String getSex() {
        return sex;
    }

    /**
     * 性别
     *
     * @mbggenerated
     */
    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }

    /**
     * 生日
     *
     * @mbggenerated
     */
    public String getBirthday() {
        return birthday;
    }

    /**
     * 生日
     *
     * @mbggenerated
     */
    public void setBirthday(String birthday) {
        this.birthday = birthday == null ? null : birthday.trim();
    }

    /**
     * 民族
     *
     * @mbggenerated
     */
    public String getNation() {
        return nation;
    }

    /**
     * 民族
     *
     * @mbggenerated
     */
    public void setNation(String nation) {
        this.nation = nation == null ? null : nation.trim();
    }

    /**
     * 照片
     *
     * @mbggenerated
     */
    public String getPhoto() {
        return photo;
    }

    /**
     * 照片
     *
     * @mbggenerated
     */
    public void setPhoto(String photo) {
        this.photo = photo == null ? null : photo.trim();
    }

    /**
     * 所属单位id
     *
     * @mbggenerated
     */
    public String getMainorgid() {
        return mainorgid;
    }

    /**
     * 所属单位id
     *
     * @mbggenerated
     */
    public void setMainorgid(String mainorgid) {
        this.mainorgid = mainorgid == null ? null : mainorgid.trim();
    }

    /**
     * 所属单位名称
     *
     * @mbggenerated
     */
    public String getMainorgname() {
        return mainorgname;
    }

    /**
     * 所属单位名称
     *
     * @mbggenerated
     */
    public void setMainorgname(String mainorgname) {
        this.mainorgname = mainorgname == null ? null : mainorgname.trim();
    }

    /**
     * 所属部门id
     *
     * @mbggenerated
     */
    public String getMaindeptid() {
        return maindeptid;
    }

    /**
     * 所属部门id
     *
     * @mbggenerated
     */
    public void setMaindeptid(String maindeptid) {
        this.maindeptid = maindeptid == null ? null : maindeptid.trim();
    }

    /**
     * 所属部门名称
     *
     * @mbggenerated
     */
    public String getMaindeptname() {
        return maindeptname;
    }

    /**
     * 所属部门名称
     *
     * @mbggenerated
     */
    public void setMaindeptname(String maindeptname) {
        this.maindeptname = maindeptname == null ? null : maindeptname.trim();
    }

    /**
     * 所属职务id
     *
     * @mbggenerated
     */
    public String getMainduty() {
        return mainduty;
    }

    /**
     * 所属职务id
     *
     * @mbggenerated
     */
    public void setMainduty(String mainduty) {
        this.mainduty = mainduty == null ? null : mainduty.trim();
    }

    /**
     * 所属职务名称
     *
     * @mbggenerated
     */
    public String getMaindutyname() {
        return maindutyname;
    }

    /**
     * 所属职务名称
     *
     * @mbggenerated
     */
    public void setMaindutyname(String maindutyname) {
        this.maindutyname = maindutyname == null ? null : maindutyname.trim();
    }

    /**
     * 所属岗位id
     *
     * @mbggenerated
     */
    public String getMainpost() {
        return mainpost;
    }

    /**
     * 所属岗位id
     *
     * @mbggenerated
     */
    public void setMainpost(String mainpost) {
        this.mainpost = mainpost == null ? null : mainpost.trim();
    }

    /**
     * 所属岗位名称
     *
     * @mbggenerated
     */
    public String getMainpostname() {
        return mainpostname;
    }

    /**
     * 所属岗位名称
     *
     * @mbggenerated
     */
    public void setMainpostname(String mainpostname) {
        this.mainpostname = mainpostname == null ? null : mainpostname.trim();
    }

    /**
     * 办公电话
     *
     * @mbggenerated
     */
    public String getOfficetel() {
        return officetel;
    }

    /**
     * 办公电话
     *
     * @mbggenerated
     */
    public void setOfficetel(String officetel) {
        this.officetel = officetel == null ? null : officetel.trim();
    }

    /**
     * 手机1
     *
     * @mbggenerated
     */
    public String getMainmobile() {
        return mainmobile;
    }

    /**
     * 手机1
     *
     * @mbggenerated
     */
    public void setMainmobile(String mainmobile) {
        this.mainmobile = mainmobile == null ? null : mainmobile.trim();
    }

    /**
     * 手机2
     *
     * @mbggenerated
     */
    public String getSubmobile() {
        return submobile;
    }

    /**
     * 手机2
     *
     * @mbggenerated
     */
    public void setSubmobile(String submobile) {
        this.submobile = submobile == null ? null : submobile.trim();
    }

    /**
     * 是否单位管理员
     *
     * @mbggenerated
     */
    public String getIsorgadmin() {
        return isorgadmin;
    }

    /**
     * 是否单位管理员
     *
     * @mbggenerated
     */
    public void setIsorgadmin(String isorgadmin) {
        this.isorgadmin = isorgadmin == null ? null : isorgadmin.trim();
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
     * 用户类型id
     *
     * @mbggenerated
     */
    public String getUsertype() {
        return usertype;
    }

    /**
     * 用户类型id
     *
     * @mbggenerated
     */
    public void setUsertype(String usertype) {
        this.usertype = usertype == null ? null : usertype.trim();
    }

    /**
     * 状态 1在职、 2 转职中、 3 离职、 4 退休
     *
     * @mbggenerated
     */
    public String getStatus() {
        return status;
    }

    /**
     * 状态 1在职、 2 转职中、 3 离职、 4 退休
     *
     * @mbggenerated
     */
    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    /**
     * 个人简介
     *
     * @mbggenerated
     */
    public String getDescrption() {
        return descrption;
    }

    /**
     * 个人简介
     *
     * @mbggenerated
     */
    public void setDescrption(String descrption) {
        this.descrption = descrption == null ? null : descrption.trim();
    }

    /**
     * 是否政协委员
     *
     * @mbggenerated
     */
    public String getIscommittee() {
        return iscommittee;
    }

    /**
     * 是否政协委员
     *
     * @mbggenerated
     */
    public void setIscommittee(String iscommittee) {
        this.iscommittee = iscommittee == null ? null : iscommittee.trim();
    }

    /**
     * 是否人大代表
     *
     * @mbggenerated
     */
    public String getIsdeputy() {
        return isdeputy;
    }

    /**
     * 是否人大代表
     *
     * @mbggenerated
     */
    public void setIsdeputy(String isdeputy) {
        this.isdeputy = isdeputy == null ? null : isdeputy.trim();
    }

    /**
     * 是否单位一把手
     *
     * @mbggenerated
     */
    public String getIsheader() {
        return isheader;
    }

    /**
     * 是否单位一把手
     *
     * @mbggenerated
     */
    public void setIsheader(String isheader) {
        this.isheader = isheader == null ? null : isheader.trim();
    }

    /**
     * 是否单位领导
     *
     * @mbggenerated
     */
    public String getIsleader() {
        return isleader;
    }

    /**
     * 是否单位领导
     *
     * @mbggenerated
     */
    public void setIsleader(String isleader) {
        this.isleader = isleader == null ? null : isleader.trim();
    }

    /**
     * 人员职责
     *
     * @mbggenerated
     */
    public String getUserduty() {
        return userduty;
    }

    /**
     * 人员职责
     *
     * @mbggenerated
     */
    public void setUserduty(String userduty) {
        this.userduty = userduty == null ? null : userduty.trim();
    }

    /**
     * 排序权重值赿小靠前
     *
     * @mbggenerated
     */
    public Integer getSortvalue() {
        return sortvalue;
    }

    /**
     * 排序权重值赿小靠前
     *
     * @mbggenerated
     */
    public void setSortvalue(Integer sortvalue) {
        this.sortvalue = sortvalue;
    }

    /**
     * 职务级别
     *
     * @mbggenerated
     */
    public String getDutylevel() {
        return dutylevel;
    }

    /**
     * 职务级别
     *
     * @mbggenerated
     */
    public void setDutylevel(String dutylevel) {
        this.dutylevel = dutylevel == null ? null : dutylevel.trim();
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
     * 高新区平台中的用户id
     *
     * @mbggenerated
     */
    public Long getGxqptEmpId() {
        return gxqptEmpId;
    }

    /**
     * 高新区平台中的用户id
     *
     * @mbggenerated
     */
    public void setGxqptEmpId(Long gxqptEmpId) {
        this.gxqptEmpId = gxqptEmpId;
    }

    /**
     * 最高学历
     *
     * @mbggenerated
     */
    public String getEducation() {
        return education;
    }

    /**
     * 最高学历
     *
     * @mbggenerated
     */
    public void setEducation(String education) {
        this.education = education == null ? null : education.trim();
    }

    /**
     * 统一人员编号
     *
     * @mbggenerated
     */
    public String getEmpNo() {
        return empNo;
    }

    /**
     * 统一人员编号
     *
     * @mbggenerated
     */
    public void setEmpNo(String empNo) {
        this.empNo = empNo == null ? null : empNo.trim();
    }
}