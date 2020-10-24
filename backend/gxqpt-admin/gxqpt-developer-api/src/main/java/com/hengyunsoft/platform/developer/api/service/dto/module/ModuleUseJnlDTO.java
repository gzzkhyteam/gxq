package com.hengyunsoft.platform.developer.api.service.dto.module;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * com.hengyunsoft.platform.developer.api.service.dto.module
 * 版权：中科恒运软件科技股份有限公司贵阳分公司
 * 描述：模块调用日志dto
 * 修改人：sunxiaoya
 * 修改时间：2018/4/19
 * 修改内容：
 */
@Data
@ApiModel(value = "ModuleUseJnl", description = "模块调用日志")
public class ModuleUseJnlDTO {

    @ApiModelProperty(value = "应用id")
    private String appId;

    @ApiModelProperty(value = "功能id")
    private String moduleId;

    /*@ApiModelProperty(value = "年")
    private String year;

    @ApiModelProperty(value = "月")
    private String month;

    @ApiModelProperty(value = "日")
    private String day;

    @ApiModelProperty(value = "时")
    private String hour;*/

    @ApiModelProperty(value = "开始时间")
    private String startTime;

    @ApiModelProperty(value = "结束时间")
    private String endTime;

    @ApiModelProperty(value = "时间刻度:year(年),month(月),day（日）,hour（时）,weekend（周）, quarter（季度）")
    private String timeScale;

}
