package com.hengyunsoft.platform.developer.entity.core.po;

import com.hengyunsoft.base.entity.BaseEntity;
import com.hengyunsoft.validator.ValidatorGroups.MustNoneNull;
import com.hengyunsoft.validator.annotation.FieldDesc;
import java.io.Serializable;
import java.util.Date;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;

public class ModuleUseInfo extends BaseEntity<Long> implements Serializable {
    /**
     * 年月日时+应用+模块ID
     *
     * @mbggenerated
     */
    @FieldDesc("年月日时+应用+模块ID")
    @Length(max=200)
    @NotNull(groups=MustNoneNull.class)
    private String combineId;

    @Range(min=Long.MIN_VALUE,max=Long.MAX_VALUE)
    private Long id;

    /**
     * 功能id
     *
     * @mbggenerated
     */
    @FieldDesc("功能id")
    @Length(max=100)
    private String moduleId;

    /**
     * 应用id
     *
     * @mbggenerated
     */
    @FieldDesc("应用id")
    @Length(max=100)
    private String appId;

    /**
     * 年
     *
     * @mbggenerated
     */
    @FieldDesc("年")
    @Length(max=20)
    private String useYear;

    /**
     * 年+月
     *
     * @mbggenerated
     */
    @FieldDesc("年+月")
    @Length(max=20)
    private String useMonth;

    /**
     * 年+月+日
     *
     * @mbggenerated
     */
    @FieldDesc("年+月+日")
    @Length(max=20)
    private String useDay;

    /**
     * 年+月+日+时
     *
     * @mbggenerated
     */
    @FieldDesc("年+月+日+时")
    @Length(max=20)
    private String useHour;

    /**
     * 年+周
     *
     * @mbggenerated
     */
    @FieldDesc("年+周")
    @Length(max=20)
    private String useWeekend;

    /**
     * 年+季度
     *
     * @mbggenerated
     */
    @FieldDesc("年+季度")
    @Length(max=20)
    private String useQuarter;

    /**
     * 调用总数
     *
     * @mbggenerated
     */
    @FieldDesc("调用总数")
    @Range(min=Integer.MIN_VALUE,max=Integer.MAX_VALUE)
    private Integer totalNum;

    /**
     * 调用失败数
     *
     * @mbggenerated
     */
    @FieldDesc("调用失败数")
    @Range(min=Integer.MIN_VALUE,max=Integer.MAX_VALUE)
    private Integer errorNum;

    private Integer newTotalNum;

    private Integer newErrorNum;
    
    /**
     * 更新时间
     *
     * @mbggenerated
     */
    @FieldDesc("更新时间")
    private Date updateTime;

    private static final long serialVersionUID = 1L;

    /**
     * 年月日时+应用+模块ID
     *
     * @mbggenerated
     */
    public String getCombineId() {
        return combineId;
    }

    /**
     * 年月日时+应用+模块ID
     *
     * @mbggenerated
     */
    public void setCombineId(String combineId) {
        this.combineId = combineId == null ? null : combineId.trim();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 功能id
     *
     * @mbggenerated
     */
    public String getModuleId() {
        return moduleId;
    }

    /**
     * 功能id
     *
     * @mbggenerated
     */
    public void setModuleId(String moduleId) {
        this.moduleId = moduleId == null ? null : moduleId.trim();
    }

    /**
     * 应用id
     *
     * @mbggenerated
     */
    public String getAppId() {
        return appId;
    }

    /**
     * 应用id
     *
     * @mbggenerated
     */
    public void setAppId(String appId) {
        this.appId = appId == null ? null : appId.trim();
    }

    /**
     * 年
     *
     * @mbggenerated
     */
    public String getUseYear() {
        return useYear;
    }

    /**
     * 年
     *
     * @mbggenerated
     */
    public void setUseYear(String useYear) {
        this.useYear = useYear == null ? null : useYear.trim();
    }

    /**
     * 年+月
     *
     * @mbggenerated
     */
    public String getUseMonth() {
        return useMonth;
    }

    /**
     * 年+月
     *
     * @mbggenerated
     */
    public void setUseMonth(String useMonth) {
        this.useMonth = useMonth == null ? null : useMonth.trim();
    }

    /**
     * 年+月+日
     *
     * @mbggenerated
     */
    public String getUseDay() {
        return useDay;
    }

    /**
     * 年+月+日
     *
     * @mbggenerated
     */
    public void setUseDay(String useDay) {
        this.useDay = useDay == null ? null : useDay.trim();
    }

    /**
     * 年+月+日+时
     *
     * @mbggenerated
     */
    public String getUseHour() {
        return useHour;
    }

    /**
     * 年+月+日+时
     *
     * @mbggenerated
     */
    public void setUseHour(String useHour) {
        this.useHour = useHour == null ? null : useHour.trim();
    }

    /**
     * 年+周
     *
     * @mbggenerated
     */
    public String getUseWeekend() {
        return useWeekend;
    }

    /**
     * 年+周
     *
     * @mbggenerated
     */
    public void setUseWeekend(String useWeekend) {
        this.useWeekend = useWeekend == null ? null : useWeekend.trim();
    }

    /**
     * 年+季度
     *
     * @mbggenerated
     */
    public String getUseQuarter() {
        return useQuarter;
    }

    /**
     * 年+季度
     *
     * @mbggenerated
     */
    public void setUseQuarter(String useQuarter) {
        this.useQuarter = useQuarter == null ? null : useQuarter.trim();
    }

    /**
     * 调用总数
     *
     * @mbggenerated
     */
    public Integer getTotalNum() {
        return totalNum;
    }

    /**
     * 调用总数
     *
     * @mbggenerated
     */
    public void setTotalNum(Integer totalNum) {
        this.totalNum = totalNum;
    }

    /**
     * 调用失败数
     *
     * @mbggenerated
     */
    public Integer getErrorNum() {
        return errorNum;
    }

    /**
     * 调用失败数
     *
     * @mbggenerated
     */
    public void setErrorNum(Integer errorNum) {
        this.errorNum = errorNum;
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

	public Integer getNewTotalNum() {
		return newTotalNum;
	}

	public void setNewTotalNum(Integer newTotalNum) {
		this.newTotalNum = newTotalNum;
	}

	public Integer getNewErrorNum() {
		return newErrorNum;
		
	}

	public void setNewErrorNum(Integer newErrorNum) {
		this.newErrorNum = newErrorNum;
	}
    
}