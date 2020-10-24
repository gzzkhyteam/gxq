package com.hengyunsoft.platform.mt.api.punchstatics.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * com.hengyunsoft.platform.mt.api.punchstatics.dto
 * 版权：中科恒运软件科技股份有限公司贵阳分公司
 * 描述：web查询我的考勤分页参数
 * 修改人：gbl
 * 修改时间：2018/7/24
 * 修改内容：
 */
@Data
@ApiModel(value = "WebQueryMyStaticsParamDTO", description = "web查询我的考勤分页参数")
public class WebQueryMyStaticsParamDTO {
    /***
     * 开始日期
     */
    @ApiModelProperty(value = "开始日期")
    private Date startAttDay;
    /***
     * 结束日期
     */
    @ApiModelProperty(value = "结束日期")
    private Date endAttDay;
}
