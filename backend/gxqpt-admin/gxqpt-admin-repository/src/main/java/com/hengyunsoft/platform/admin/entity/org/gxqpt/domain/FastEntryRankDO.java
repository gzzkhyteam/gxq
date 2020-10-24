package com.hengyunsoft.platform.admin.entity.org.gxqpt.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 *
 * 版权：中科恒运软件科技股份有限公司贵阳分公司
 * 描述：快捷入口排行do
 * 修改人：sunxiaoya
 * 修改时间：2018/09/10
 * 修改内容：
 */
@Data
@ApiModel(value = "FastEntryRankDO", description = "快捷入口排行do")
public class FastEntryRankDO {

    @ApiModelProperty(value = "应用资源名称")
    private String appResourceName;

    @ApiModelProperty(value = "应用名称")
    private String appName;

    @ApiModelProperty(value = "资源统计数量")
    private Long resourceNum;

}
