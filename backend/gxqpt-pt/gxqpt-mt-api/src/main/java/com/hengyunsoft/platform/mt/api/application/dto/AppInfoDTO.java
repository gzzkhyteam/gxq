package com.hengyunsoft.platform.mt.api.application.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * com.hengyunsoft.platform.mt.api.application.dto
 * 版权：中科恒运软件科技股份有限公司贵阳分公司
 * 描述：app详情返回
 * 修改人：gbl
 * 修改时间：2019/7/8
 * 修改内容：
 */
@Data
@ApiModel(value = "AppInfoDTO", description = "app详情返回")
public class AppInfoDTO {
    @ApiModelProperty(value = "当前信息")
    private  ApplicationDTO current;
    @ApiModelProperty(value = "审批信息")
    private  ApplicationDTO audit;
}
