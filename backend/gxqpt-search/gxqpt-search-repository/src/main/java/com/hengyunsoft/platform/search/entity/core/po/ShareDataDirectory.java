package com.hengyunsoft.platform.search.entity.core.po;

import com.hengyunsoft.base.entity.BaseEntity;
import com.hengyunsoft.validator.ValidatorGroups.MustNoneNull;
import com.hengyunsoft.validator.annotation.FieldDesc;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

public class ShareDataDirectory extends BaseEntity<Long> implements Serializable {
    /**
     * 主键
     *
     * @mbggenerated
     */
    @FieldDesc("主键")
    @Range(min=Long.MIN_VALUE,max=Long.MAX_VALUE)
    @NotNull(groups=MustNoneNull.class)
    private Long id;

    /**
     * 申请编号
     *
     * @mbggenerated
     */
    @FieldDesc("申请编号")
    @Length(max=100)
    private String applyCode;

    /**
     * 目录名称
     *
     * @mbggenerated
     */
    @FieldDesc("目录名称")
    @Length(max=200)
    @NotNull(groups=MustNoneNull.class)
    private String dirName;

    /**
     * 目录编码
     *
     * @mbggenerated
     */
    @FieldDesc("目录编码")
    @Length(max=200)
    @NotNull(groups=MustNoneNull.class)
    private String dirCode;

    /**
     * 单位简称
     *
     * @mbggenerated
     */
    @FieldDesc("单位简称")
    @Length(max=200)
    private String unitAbbr;

    /**
     * 父id
     *
     * @mbggenerated
     */
    @FieldDesc("父id")
    @Length(max=64)
    @NotNull(groups=MustNoneNull.class)
    private String parentId;

    /**
     * 单位id
     *
     * @mbggenerated
     */
    @FieldDesc("单位id")
    @Length(max=64)
    @NotNull(groups=MustNoneNull.class)
    private String unitId;

    /**
     * 目录描述
     *
     * @mbggenerated
     */
    @FieldDesc("目录描述")
    @Length(max=1000)
    private String desc;

    /**
     * 目录标识:1,单位；2，数据目录
     *
     * @mbggenerated
     */
    @FieldDesc("目录标识:1,单位；2，数据目录")
    @Range(min=Integer.MIN_VALUE,max=Integer.MAX_VALUE)
    @NotNull(groups=MustNoneNull.class)
    private Integer dirType;

    /**
     * 数据量
     *
     * @mbggenerated
     */
    @FieldDesc("数据量")
    @Range(min=Integer.MIN_VALUE,max=Integer.MAX_VALUE)
    private Integer dataCount;

    /**
     * 查看次数
     *
     * @mbggenerated
     */
    @FieldDesc("查看次数")
    @Range(min=Integer.MIN_VALUE,max=Integer.MAX_VALUE)
    private Integer seeCount;

    /**
     * 下载次数
     *
     * @mbggenerated
     */
    @FieldDesc("下载次数")
    @Range(min=Integer.MIN_VALUE,max=Integer.MAX_VALUE)
    private Integer downCount;

    /**
     * 操作类型(最近一次)：1,新增；2，修改；3，删除；4，禁用,5，正常,6,启用
     *
     * @mbggenerated
     */
    @FieldDesc("操作类型(最近一次)：1,新增；2，修改；3，删除；4，禁用,5，正常,6,启用")
    @Range(min=Integer.MIN_VALUE,max=Integer.MAX_VALUE)
    private Integer optType;

    /**
     * 审批状态:1,未发布；2，审批中；3，驳回；4，已发布；
     *
     * @mbggenerated
     */
    @FieldDesc("审批状态:1,未发布；2，审批中；3，驳回；4，已发布；")
    @Range(min=Integer.MIN_VALUE,max=Integer.MAX_VALUE)
    @NotNull(groups=MustNoneNull.class)
    private Integer status;

    /**
     * 是否元目录:1,否；2，是
     *
     * @mbggenerated
     */
    @FieldDesc("是否元目录:1,否；2，是")
    @Range(min=Integer.MIN_VALUE,max=Integer.MAX_VALUE)
    @NotNull(groups=MustNoneNull.class)
    private Integer isBottom;

    /**
     * 专题分类
     *
     * @mbggenerated
     */
    @FieldDesc("专题分类")
    @Length(max=128)
    private String specialType;

    /**
     * 领域分类
     *
     * @mbggenerated
     */
    @FieldDesc("领域分类")
    @Length(max=128)
    private String domain;

    /**
     * 主题大类
     *
     * @mbggenerated
     */
    @FieldDesc("主题大类")
    @Length(max=128)
    private String themeOne;

    /**
     * 主题中类
     *
     * @mbggenerated
     */
    @FieldDesc("主题中类")
    @Length(max=128)
    private String themeTwo;

    /**
     * 主题小类
     *
     * @mbggenerated
     */
    @FieldDesc("主题小类")
    @Length(max=128)
    private String themeThree;

    /**
     * 行业大类
     *
     * @mbggenerated
     */
    @FieldDesc("行业大类")
    @Length(max=128)
    private String industryOne;

    /**
     * 行业中类
     *
     * @mbggenerated
     */
    @FieldDesc("行业中类")
    @Length(max=128)
    private String industryTwo;

    /**
     * 行业小类
     *
     * @mbggenerated
     */
    @FieldDesc("行业小类")
    @Length(max=128)
    private String industryThree;

    /**
     * 服务大类
     *
     * @mbggenerated
     */
    @FieldDesc("服务大类")
    @Length(max=128)
    private String serviceOne;

    /**
     * 服务中类
     *
     * @mbggenerated
     */
    @FieldDesc("服务中类")
    @Length(max=128)
    private String serviceTwo;

    /**
     * 服务小类
     *
     * @mbggenerated
     */
    @FieldDesc("服务小类")
    @Length(max=128)
    private String serviceThree;

    /**
     * 开放方式:1,开放；2，不开放
     *
     * @mbggenerated
     */
    @FieldDesc("开放方式:1,开放；2，不开放")
    @Range(min=Integer.MIN_VALUE,max=Integer.MAX_VALUE)
    private Integer openWay;

    /**
     * 共享方式:1,共享；2，有条件共享；3，不共享
     *
     * @mbggenerated
     */
    @FieldDesc("共享方式:1,共享；2，有条件共享；3，不共享")
    @Range(min=Integer.MIN_VALUE,max=Integer.MAX_VALUE)
    private Integer shareWay;

    /**
     * 数据类型:1,结构化数据；2，非结构化数据
     *
     * @mbggenerated
     */
    @FieldDesc("数据类型:1,结构化数据；2，非结构化数据")
    @Range(min=Integer.MIN_VALUE,max=Integer.MAX_VALUE)
    private Integer dataType;

    /**
     * 不同享、不开放、有条件共享原因
     *
     * @mbggenerated
     */
    @FieldDesc("不同享、不开放、有条件共享原因")
    @Length(max=2147483647)
    private String reason;

    /**
     * 数据集id
     *
     * @mbggenerated
     */
    @FieldDesc("数据集id")
    @Range(min=Long.MIN_VALUE,max=Long.MAX_VALUE)
    private Long setId;

    /**
     * 是否生成数据库表：1已生成
     *
     * @mbggenerated
     */
    @FieldDesc("是否生成数据库表：1已生成")
    @Range(min=Integer.MIN_VALUE,max=Integer.MAX_VALUE)
    private Integer dataSheet;

    /**
     * 数据状态；1，正常；2，已删除；3，已禁用
     *
     * @mbggenerated
     */
    @FieldDesc("数据状态；1，正常；2，已删除；3，已禁用")
    @Range(min=Integer.MIN_VALUE,max=Integer.MAX_VALUE)
    private Integer dataStatus;

    /**
     * 创建时间
     *
     * @mbggenerated
     */
    @FieldDesc("创建时间")
    private Date createTime;

    /**
     * 创建人
     *
     * @mbggenerated
     */
    @FieldDesc("创建人")
    @Range(min=Long.MIN_VALUE,max=Long.MAX_VALUE)
    private Long createUser;

    /**
     * 更新时间
     *
     * @mbggenerated
     */
    @FieldDesc("更新时间")
    private Date updateTime;

    /**
     * 更新人
     *
     * @mbggenerated
     */
    @FieldDesc("更新人")
    @Range(min=Long.MIN_VALUE,max=Long.MAX_VALUE)
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
     * 申请编号
     *
     * @mbggenerated
     */
    public String getApplyCode() {
        return applyCode;
    }

    /**
     * 申请编号
     *
     * @mbggenerated
     */
    public void setApplyCode(String applyCode) {
        this.applyCode = applyCode == null ? null : applyCode.trim();
    }

    /**
     * 目录名称
     *
     * @mbggenerated
     */
    public String getDirName() {
        return dirName;
    }

    /**
     * 目录名称
     *
     * @mbggenerated
     */
    public void setDirName(String dirName) {
        this.dirName = dirName == null ? null : dirName.trim();
    }

    /**
     * 目录编码
     *
     * @mbggenerated
     */
    public String getDirCode() {
        return dirCode;
    }

    /**
     * 目录编码
     *
     * @mbggenerated
     */
    public void setDirCode(String dirCode) {
        this.dirCode = dirCode == null ? null : dirCode.trim();
    }

    /**
     * 单位简称
     *
     * @mbggenerated
     */
    public String getUnitAbbr() {
        return unitAbbr;
    }

    /**
     * 单位简称
     *
     * @mbggenerated
     */
    public void setUnitAbbr(String unitAbbr) {
        this.unitAbbr = unitAbbr == null ? null : unitAbbr.trim();
    }

    /**
     * 父id
     *
     * @mbggenerated
     */
    public String getParentId() {
        return parentId;
    }

    /**
     * 父id
     *
     * @mbggenerated
     */
    public void setParentId(String parentId) {
        this.parentId = parentId == null ? null : parentId.trim();
    }

    /**
     * 单位id
     *
     * @mbggenerated
     */
    public String getUnitId() {
        return unitId;
    }

    /**
     * 单位id
     *
     * @mbggenerated
     */
    public void setUnitId(String unitId) {
        this.unitId = unitId == null ? null : unitId.trim();
    }

    /**
     * 目录描述
     *
     * @mbggenerated
     */
    public String getDesc() {
        return desc;
    }

    /**
     * 目录描述
     *
     * @mbggenerated
     */
    public void setDesc(String desc) {
        this.desc = desc == null ? null : desc.trim();
    }

    /**
     * 目录标识:1,单位；2，数据目录
     *
     * @mbggenerated
     */
    public Integer getDirType() {
        return dirType;
    }

    /**
     * 目录标识:1,单位；2，数据目录
     *
     * @mbggenerated
     */
    public void setDirType(Integer dirType) {
        this.dirType = dirType;
    }

    /**
     * 数据量
     *
     * @mbggenerated
     */
    public Integer getDataCount() {
        return dataCount;
    }

    /**
     * 数据量
     *
     * @mbggenerated
     */
    public void setDataCount(Integer dataCount) {
        this.dataCount = dataCount;
    }

    /**
     * 查看次数
     *
     * @mbggenerated
     */
    public Integer getSeeCount() {
        return seeCount;
    }

    /**
     * 查看次数
     *
     * @mbggenerated
     */
    public void setSeeCount(Integer seeCount) {
        this.seeCount = seeCount;
    }

    /**
     * 下载次数
     *
     * @mbggenerated
     */
    public Integer getDownCount() {
        return downCount;
    }

    /**
     * 下载次数
     *
     * @mbggenerated
     */
    public void setDownCount(Integer downCount) {
        this.downCount = downCount;
    }

    /**
     * 操作类型(最近一次)：1,新增；2，修改；3，删除；4，禁用,5，正常,6,启用
     *
     * @mbggenerated
     */
    public Integer getOptType() {
        return optType;
    }

    /**
     * 操作类型(最近一次)：1,新增；2，修改；3，删除；4，禁用,5，正常,6,启用
     *
     * @mbggenerated
     */
    public void setOptType(Integer optType) {
        this.optType = optType;
    }

    /**
     * 审批状态:1,未发布；2，审批中；3，驳回；4，已发布；
     *
     * @mbggenerated
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 审批状态:1,未发布；2，审批中；3，驳回；4，已发布；
     *
     * @mbggenerated
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * 是否元目录:1,否；2，是
     *
     * @mbggenerated
     */
    public Integer getIsBottom() {
        return isBottom;
    }

    /**
     * 是否元目录:1,否；2，是
     *
     * @mbggenerated
     */
    public void setIsBottom(Integer isBottom) {
        this.isBottom = isBottom;
    }

    /**
     * 专题分类
     *
     * @mbggenerated
     */
    public String getSpecialType() {
        return specialType;
    }

    /**
     * 专题分类
     *
     * @mbggenerated
     */
    public void setSpecialType(String specialType) {
        this.specialType = specialType == null ? null : specialType.trim();
    }

    /**
     * 领域分类
     *
     * @mbggenerated
     */
    public String getDomain() {
        return domain;
    }

    /**
     * 领域分类
     *
     * @mbggenerated
     */
    public void setDomain(String domain) {
        this.domain = domain == null ? null : domain.trim();
    }

    /**
     * 主题大类
     *
     * @mbggenerated
     */
    public String getThemeOne() {
        return themeOne;
    }

    /**
     * 主题大类
     *
     * @mbggenerated
     */
    public void setThemeOne(String themeOne) {
        this.themeOne = themeOne == null ? null : themeOne.trim();
    }

    /**
     * 主题中类
     *
     * @mbggenerated
     */
    public String getThemeTwo() {
        return themeTwo;
    }

    /**
     * 主题中类
     *
     * @mbggenerated
     */
    public void setThemeTwo(String themeTwo) {
        this.themeTwo = themeTwo == null ? null : themeTwo.trim();
    }

    /**
     * 主题小类
     *
     * @mbggenerated
     */
    public String getThemeThree() {
        return themeThree;
    }

    /**
     * 主题小类
     *
     * @mbggenerated
     */
    public void setThemeThree(String themeThree) {
        this.themeThree = themeThree == null ? null : themeThree.trim();
    }

    /**
     * 行业大类
     *
     * @mbggenerated
     */
    public String getIndustryOne() {
        return industryOne;
    }

    /**
     * 行业大类
     *
     * @mbggenerated
     */
    public void setIndustryOne(String industryOne) {
        this.industryOne = industryOne == null ? null : industryOne.trim();
    }

    /**
     * 行业中类
     *
     * @mbggenerated
     */
    public String getIndustryTwo() {
        return industryTwo;
    }

    /**
     * 行业中类
     *
     * @mbggenerated
     */
    public void setIndustryTwo(String industryTwo) {
        this.industryTwo = industryTwo == null ? null : industryTwo.trim();
    }

    /**
     * 行业小类
     *
     * @mbggenerated
     */
    public String getIndustryThree() {
        return industryThree;
    }

    /**
     * 行业小类
     *
     * @mbggenerated
     */
    public void setIndustryThree(String industryThree) {
        this.industryThree = industryThree == null ? null : industryThree.trim();
    }

    /**
     * 服务大类
     *
     * @mbggenerated
     */
    public String getServiceOne() {
        return serviceOne;
    }

    /**
     * 服务大类
     *
     * @mbggenerated
     */
    public void setServiceOne(String serviceOne) {
        this.serviceOne = serviceOne == null ? null : serviceOne.trim();
    }

    /**
     * 服务中类
     *
     * @mbggenerated
     */
    public String getServiceTwo() {
        return serviceTwo;
    }

    /**
     * 服务中类
     *
     * @mbggenerated
     */
    public void setServiceTwo(String serviceTwo) {
        this.serviceTwo = serviceTwo == null ? null : serviceTwo.trim();
    }

    /**
     * 服务小类
     *
     * @mbggenerated
     */
    public String getServiceThree() {
        return serviceThree;
    }

    /**
     * 服务小类
     *
     * @mbggenerated
     */
    public void setServiceThree(String serviceThree) {
        this.serviceThree = serviceThree == null ? null : serviceThree.trim();
    }

    /**
     * 开放方式:1,开放；2，不开放
     *
     * @mbggenerated
     */
    public Integer getOpenWay() {
        return openWay;
    }

    /**
     * 开放方式:1,开放；2，不开放
     *
     * @mbggenerated
     */
    public void setOpenWay(Integer openWay) {
        this.openWay = openWay;
    }

    /**
     * 共享方式:1,共享；2，有条件共享；3，不共享
     *
     * @mbggenerated
     */
    public Integer getShareWay() {
        return shareWay;
    }

    /**
     * 共享方式:1,共享；2，有条件共享；3，不共享
     *
     * @mbggenerated
     */
    public void setShareWay(Integer shareWay) {
        this.shareWay = shareWay;
    }

    /**
     * 数据类型:1,结构化数据；2，非结构化数据
     *
     * @mbggenerated
     */
    public Integer getDataType() {
        return dataType;
    }

    /**
     * 数据类型:1,结构化数据；2，非结构化数据
     *
     * @mbggenerated
     */
    public void setDataType(Integer dataType) {
        this.dataType = dataType;
    }

    /**
     * 不同享、不开放、有条件共享原因
     *
     * @mbggenerated
     */
    public String getReason() {
        return reason;
    }

    /**
     * 不同享、不开放、有条件共享原因
     *
     * @mbggenerated
     */
    public void setReason(String reason) {
        this.reason = reason == null ? null : reason.trim();
    }

    /**
     * 数据集id
     *
     * @mbggenerated
     */
    public Long getSetId() {
        return setId;
    }

    /**
     * 数据集id
     *
     * @mbggenerated
     */
    public void setSetId(Long setId) {
        this.setId = setId;
    }

    /**
     * 是否生成数据库表：1已生成
     *
     * @mbggenerated
     */
    public Integer getDataSheet() {
        return dataSheet;
    }

    /**
     * 是否生成数据库表：1已生成
     *
     * @mbggenerated
     */
    public void setDataSheet(Integer dataSheet) {
        this.dataSheet = dataSheet;
    }

    /**
     * 数据状态；1，正常；2，已删除；3，已禁用
     *
     * @mbggenerated
     */
    public Integer getDataStatus() {
        return dataStatus;
    }

    /**
     * 数据状态；1，正常；2，已删除；3，已禁用
     *
     * @mbggenerated
     */
    public void setDataStatus(Integer dataStatus) {
        this.dataStatus = dataStatus;
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