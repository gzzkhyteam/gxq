package com.hengyunsoft.platform.exchange.api.dataapi.dto.dataapi;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * com.hengyunsoft.platform.exchange.api.dataapi.dto
 * 版权：中科恒运软件科技股份有限公司贵阳分公司
 * 描述：api续期api信息
 * 修改人：zhaopengfei
 * 修改时间：2018/5/1
 * 修改内容：
 */
@Data
@ApiModel(value = "ApiRenewalInfo", description = "api续期api信息")
public class  ApiRenewalInfoDTO{
    @ApiModelProperty(value = "API Id")
    private Long apiId;
    @ApiModelProperty(value = "API名称")
    private String apiName;
    @ApiModelProperty(value = "API编号")
    private String apiCode;
    @ApiModelProperty(value = "支持格式（1,json;2,xml）")
    private Integer dataFmat;
    @ApiModelProperty(value = "对应目录")
    private String dirName;
    @ApiModelProperty(value = "授权有效期限")
    private Date limitTime;
}
