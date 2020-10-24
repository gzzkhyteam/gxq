package com.hengyunsoft.platform.mt.api.version.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * com.hengyunsoft.platform.mt.api.application.dto
 * 版权：中科恒运软件科技股份有限公司贵阳分公司
 * 描述：查询版本列表参数
 * 修改人：gbl
 * 修改时间：2018/5/27
 * 修改内容：
 */
@Data
@ApiModel(value = "QueryClientVersionParam", description = "查询版本列表参数")
public class QueryClientVersionParamDTO {
    @ApiModelProperty(value = "版本名称")
    private String verName;

    @ApiModelProperty(value = "版本号")
    private Integer verNumber;

    @ApiModelProperty(value = "开始发布日期")
    private Date startPublishTime;
    @ApiModelProperty(value = "开始发布日期")
    private Date endPublishTime;
}
