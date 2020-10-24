package com.hengyunsoft.platform.exchange.entity.api.domain;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * com.hengyunsoft.platform.exchange.entity.api.domain
 * gxqpt
 * 版权：中科恒运软件科技股份有限公司贵阳分公司
 * 描述：对外提供API信息
 * 修改人：zhaopengfei
 * 修改时间：2018/7/4
 * 修改内容：
 */
@Data
public class AllUserApiDO {
    @ApiModelProperty(value = "主键Id")
    private Long id;

    @ApiModelProperty(value = "接口名称")
    private String apiName;

    @ApiModelProperty(value = "模块名称")
    private String moduleName;

    @ApiModelProperty(value = "接口地址")
    private String apiUrl;

    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    @ApiModelProperty(value = "更新时间")
    private Date updateTime;

}
