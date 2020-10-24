package com.hengyunsoft.platform.mt.api.punchstatics.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * com.hengyunsoft.platform.mt.api.punchstatics.dto
 * 版权：中科恒运软件科技股份有限公司贵阳分公司
 * 描述：考勤统计键值
 * 修改人：gbl
 * 修改时间：2019/7/2
 * 修改内容：
 */
@Data
@ApiModel(value = "StaticsKVDTO", description = "考勤统计键值")
public class StaticsKVDTO {
    @ApiModelProperty(value = "键")
    private String K;
    @ApiModelProperty(value = "值1")
    private int V1;
    @ApiModelProperty(value = "值2")
    private int V2;

    public StaticsKVDTO(String k, int v1, int v2) {
        K = k;
        V1 = v1;
        V2 = v2;
    }

    public StaticsKVDTO(String k, int v1) {
        K = k;
        V1 = v1;
    }
}
