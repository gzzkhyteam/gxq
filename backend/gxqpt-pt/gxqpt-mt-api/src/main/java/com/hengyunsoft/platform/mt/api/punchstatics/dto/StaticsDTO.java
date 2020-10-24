package com.hengyunsoft.platform.mt.api.punchstatics.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * com.hengyunsoft.platform.mt.api.punchstatics.dto
 * 版权：中科恒运软件科技股份有限公司贵阳分公司
 * 描述：h5显示一条考勤记录
 * 修改人：gbl
 * 修改时间：2018/7/26
 * 修改内容：
 */
@Data
@ApiModel(value = "StaticsDTO", description = "h5显示一条考勤记录")
public class StaticsDTO {
    /**
     * 统计日(yyyy-MM-dd)
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "统计日(yyyy-MM-dd)")
    private String attDay;
    /***
     * 值
     */
   @ApiModelProperty(value = "值")
    private double value;
    /***
     * 额外显示值
     */
    @ApiModelProperty(value = "额外显示值")
   private  String ext;
}
