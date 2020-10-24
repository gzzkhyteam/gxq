package com.hengyunsoft.platform.mt.api.application.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * com.hengyunsoft.platform.mt.api.application.dto
 * 版权：中科恒运软件科技股份有限公司贵阳分公司
 * 描述：查询应用列表参数
 * 修改人：gbl
 * 修改时间：2018/5/27
 * 修改内容：
 */
@Data
@ApiModel(value = "QueryApplicationParam", description = "查询应用列表参数")
public class QueryApplicationParamDTO {
    @ApiModelProperty(value = "应用名称")
    private String appName;
    @ApiModelProperty(value = "开始创建时间(登记时间)")
    private Date startCreateTime;
    @ApiModelProperty(value = "结束创建时间(登记时间)")
    private Date endCreateTime;
    @ApiModelProperty(value = "是否是app端查询")
    private  Boolean fromApp;
}
