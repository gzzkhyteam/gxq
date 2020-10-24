package com.hengyunsoft.platform.exchange.entity.directory.po.domain;

import com.hengyunsoft.base.entity.BaseEntity;
import com.hengyunsoft.platform.exchange.entity.directory.po.ShareDataDirectory;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class ShareDataDirectoryDictDO extends BaseEntity<Long> implements Serializable {
    /**
     * 主键
     *
     * @mbggenerated
     */
    private Long id;

    /**
     * 申请编号
     *
     * @mbggenerated
     */
    private String applyCode;

    /**
     * 目录名称
     *
     * @mbggenerated
     */
    private String dirName;

    /**
     * 目录编码
     *
     * @mbggenerated
     */
    private String dirCode;

    /**
     * 单位简称
     *
     * @mbggenerated
     */
    private String unitAbbr;

    /**
     * 父id
     *
     * @mbggenerated
     */
    private String parentId;

    /**
     * 单位id
     *
     * @mbggenerated
     */
    private String unitId;

    /**
     * 目录描述
     *
     * @mbggenerated
     */
    private String desc;

    /**
     * 目录标识:1,单位；2，数据目录
     *
     * @mbggenerated
     */
    private Integer dirType;

    /**
     * 数据量
     *
     * @mbggenerated
     */
    private Integer dataCount;

    /**
     * 查看次数
     *
     * @mbggenerated
     */
    private Integer seeCount;

    /**
     * 下载次数
     *
     * @mbggenerated
     */
    private Integer downCount;

    /**
     * 操作类型(最近一次)：1,新增；2，修改；3，删除；4，禁用
     *
     * @mbggenerated
     */
    private Integer optType;

    /**
     * 审批状态:1,未发布；2，审批中；3，驳回；4，已发布；
     *
     * @mbggenerated
     */
    private Integer status;

    /**
     * 是否元目录:1,否；2，是
     *
     * @mbggenerated
     */
    private Integer isBottom;

    /**
     * 领域分类
     *
     * @mbggenerated
     */
    private String domain;



    /**
     * 专题分类
     *
     * @mbggenerated
     */
    private String specialType;


    /**
     * 主题大类
     *
     * @mbggenerated
     */
    private String themeOne;

    /**
     * 主题中类
     *
     * @mbggenerated
     */
    private String themeTwo;

    /**
     * 主题小类
     *
     * @mbggenerated
     */
    private String themeThree;

    /**
     * 行业大类
     *
     * @mbggenerated
     */
    private String industryOne;

    /**
     * 行业中类
     *
     * @mbggenerated
     */
    private String industryTwo;

    /**
     * 行业小类
     *
     * @mbggenerated
     */
    private String industryThree;

    /**
     * 服务大类
     *
     * @mbggenerated
     */
    private String serviceOne;

    /**
     * 服务中类
     *
     * @mbggenerated
     */
    private String serviceTwo;

    /**
     * 服务小类
     *
     * @mbggenerated
     */
    private String serviceThree;


    /**
     * 主题大类_name
     *
     * @mbggenerated
     */
    private String themeOneName;

    /**
     * 主题中类_name
     *
     * @mbggenerated
     */
    private String themeTwoName;

    /**
     * 主题小类_name
     *
     * @mbggenerated
     */
    private String themeThreeName;

    /**
     * 行业大类_name
     *
     * @mbggenerated
     */
    private String industryOneName;

    /**
     * 行业中类_name
     *
     * @mbggenerated
     */
    private String industryTwoName;

    /**
     * 行业小类_name
     *
     * @mbggenerated
     */
    private String industryThreeName;

    /**
     * 服务大类_name
     *
     * @mbggenerated
     */
    private String serviceOneName;



    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    /**
     * 服务中类_name
     *
     * @mbggenerated
     */
    private String serviceTwoName;

    /**
     * 服务小类_name
     *
     * @mbggenerated
     */
    private String serviceThreeName;

    /**
     * 开放方式:1,开发；2，不开放
     *
     * @mbggenerated
     */
    private Integer openWay;

    /**
     * 共享方式:1,共享；2，有条件共享；3，不共享
     *
     * @mbggenerated
     */
    private Integer shareWay;

    /**
     * 数据类型:1,结构化数据；2，非结构化数据
     *
     * @mbggenerated
     */
    private Integer dataType;

    /**
     * 不同享、不开放、有条件共享原因
     *
     * @mbggenerated
     */
    private String reason;

    /**
     * 数据集id
     *
     * @mbggenerated
     */
    private Long setId;

    /**
     * 数据状态；1，正常；2，已删除；3，已禁用
     *
     * @mbggenerated
     */
    private Integer dataStatus;

    /**
     * 创建时间
     *
     * @mbggenerated
     */
    private Date createTime;

    /**
     * 创建人
     *
     * @mbggenerated
     */
    private Long createUser;

    /**
     * 更新时间
     *
     * @mbggenerated
     */
    private Date updateTime;

    /**
     * 更新人
     *
     * @mbggenerated
     */
    private Long updateUser;
    /**
     * 共享单位unitIds
     */
    private List<String> unitIds;


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
     * 操作类型(最近一次)：1,新增；2，修改；3，删除；4，禁用
     *
     * @mbggenerated
     */
    public Integer getOptType() {
        return optType;
    }

    /**
     * 操作类型(最近一次)：1,新增；2，修改；3，删除；4，禁用
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
    public String getSpecialType() {
        return specialType;
    }

    public void setSpecialType(String specialType) {
        this.specialType = specialType;
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
    public String getThemeOneName() {
        return themeOneName;
    }

    public void setThemeOneName(String themeOneName) {
        this.themeOneName = themeOneName;
    }

    public String getThemeTwoName() {
        return themeTwoName;
    }

    public void setThemeTwoName(String themeTwoName) {
        this.themeTwoName = themeTwoName;
    }

    public String getThemeThreeName() {
        return themeThreeName;
    }

    public void setThemeThreeName(String themeThreeName) {
        this.themeThreeName = themeThreeName;
    }

    public String getIndustryOneName() {
        return industryOneName;
    }

    public void setIndustryOneName(String industryOneName) {
        this.industryOneName = industryOneName;
    }

    public String getIndustryTwoName() {
        return industryTwoName;
    }

    public void setIndustryTwoName(String industryTwoName) {
        this.industryTwoName = industryTwoName;
    }

    public String getIndustryThreeName() {
        return industryThreeName;
    }

    public void setIndustryThreeName(String industryThreeName) {
        this.industryThreeName = industryThreeName;
    }

    public String getServiceOneName() {
        return serviceOneName;
    }

    public void setServiceOneName(String serviceOneName) {
        this.serviceOneName = serviceOneName;
    }

    public String getServiceTwoName() {
        return serviceTwoName;
    }

    public void setServiceTwoName(String serviceTwoName) {
        this.serviceTwoName = serviceTwoName;
    }

    public String getServiceThreeName() {
        return serviceThreeName;
    }

    public void setServiceThreeName(String serviceThreeName) {
        this.serviceThreeName = serviceThreeName;
    }
    /**
     * 开放方式:1,开发；2，不开放
     *
     * @mbggenerated
     */
    public Integer getOpenWay() {
        return openWay;
    }

    /**
     * 开放方式:1,开发；2，不开放
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
    public List<String> getUnitIds() {
        return unitIds;
    }

    public void setUnitIds(List<String> unitIds) {
        this.unitIds = unitIds;
    }


}



