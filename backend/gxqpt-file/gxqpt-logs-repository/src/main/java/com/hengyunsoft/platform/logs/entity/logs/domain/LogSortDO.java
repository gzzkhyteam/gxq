package com.hengyunsoft.platform.logs.entity.logs.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author luchanghong
 * @create 2018-09-04 16:11
 * @desc 日志分类数量
 **/
@ApiModel
public class LogSortDO {
    @ApiModelProperty(value = "数量")
    private Integer count;
    @ApiModelProperty(value = "类别")
    private String level;

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }
}