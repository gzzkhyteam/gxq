package com.hengyunsoft.platform.admin.api.core.dto.emp;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * 描述:人员信息DTO
 * @author chb
 * @date 2018/3/6 11:19
 * @return
 */
@Data
@ApiModel(value = "GxqptEmp", description = "人员信息")
public class GxqptEmpOpenRetDTO implements Serializable {
    /**
     * 系统编码
     */
    @ApiModelProperty(value = "系统编码")
    private String systemCode;

    /**
     * ID
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "ID")
    private String id;

    /**
     * 姓名
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "姓名")
    private String name;

    /**
     * 登录账号
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "登录账号")
    private String nickname;

    /**
     * 性别
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "性别")
    private String sex;

    /**
     * 生日
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "生日")
    private String birthday;

    /**
     * 民族
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "民族")
    private String nation;

    /**
     * 照片
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "照片")
    private String photo;

    /**
     * 所属单位id
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "所属单位id")
    private String mainorgid;

    /**
     * 所属单位名称
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "所属单位名称")
    private String mainorgname;

    /**
     * 所属部门id
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "所属部门id")
    private String maindeptid;

    /**
     * 所属部门名称
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "所属部门名称")
    private String maindeptname;

    /**
     * 所属职务id
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "所属职务id")
    private String mainduty;

    /**
     * 所属职务名称
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "所属职务名称")
    private String maindutyname;

    /**
     * 所属岗位id
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "所属岗位id")
    private String mainpost;

    /**
     * 所属岗位名称
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "所属岗位名称")
    private String mainpostname;

    /**
     * 办公电话
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "办公电话")
    private String officetel;

    /**
     * 手机1
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "手机1")
    private String mainmobile;

    /**
     * 手机2
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "手机2")
    private String submobile;

    /**
     * 是否单位管理员
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "是否单位管理员")
    private String isorgadmin;


    /**
     * 启用标记
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "启用标记")
    private String isenable;

    /**
     * 用户类型id
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "用户类型id")
    private String usertype;

    /**
     * 状态 1在职、 2 转职中、 3 离职、 4 退休
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "状态 1在职、 2 转职中、 3 离职、 4 退休")
    private String status;

    /**
     * 个人简介
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "个人简介")
    private String descrption;

    /**
     * 是否政协委员
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "是否政协委员")
    private String iscommittee;

    /**
     * 是否人大代表
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "是否人大代表")
    private String isdeputy;

    /**
     * 是否单位一把手
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "是否单位一把手")
    private String isheader;

    /**
     * 是否单位领导
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "是否单位领导")
    private String isleader;

    /**
     * 人员职责
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "人员职责")
    private String userduty;

    /**
     * 排序权重值赿小靠前
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "排序权重值赿小靠前")
    private Integer sortvalue;

    /**
     * 职务级别
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "职务级别")
    private String dutylevel;

    /**
     * 对应的其它id， 如果未有其它对应则它与本身 id一样
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "对应的其它id， 如果未有其它对应则它与本身 id一样")
    private String otherid;


    /**
     * 同步人员明细记录的日志id， 供回写日志状态接口（见第五大点）调用
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "同步人员明细记录的日志id， 供回写日志状态接口（见第五大点）调用")
    private String logid;

    /**
     * 高新区平台中的用户id
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "高新区平台中的用户id")
    private Long gxqptEmpId;

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
}