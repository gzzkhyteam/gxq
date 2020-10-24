package com.hengyunsoft.platform.logs.entity.logs.po;

import com.hengyunsoft.base.entity.BaseEntity;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

public class LogCount extends BaseEntity<Long> implements Serializable {
    /**
     * 时间显示
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "横轴时间显示")
    private String time;
    /**
     * 日志类型名称
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "日志类型名称")
    private String logTypeName;
    /**
     * 数量
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "数量")
    private String number;

    @Override
    public Long getId() {
        return null;
    }

    @Override
    public void setId(Long id) {

    }

    @Override
    public Date getCreateTime() {
        return null;
    }

    @Override
    public Date getUpdateTime() {
        return null;
    }

    @Override
    public void setCreateTime(Date nowDate) {

    }

    @Override
    public void setUpdateTime(Date nowDate) {

    }

    public String getLogTypeName() {
        return logTypeName;
    }

    public void setLogTypeName(String logTypeName) {
        this.logTypeName = logTypeName;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
