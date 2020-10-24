package com.hengyunsoft.platform.logs.entity.logs.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author luchanghong
 * @create 2018-09-03 18:28
 * @desc 日志应用
 **/
@ApiModel
public class LogAppNameDO {
    @ApiModelProperty(value = "应用名称")
    private String appName;
    @ApiModelProperty(value = "数量")
    private Integer count;
    @ApiModelProperty(value = "应用id")
    private String appId;

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }


}