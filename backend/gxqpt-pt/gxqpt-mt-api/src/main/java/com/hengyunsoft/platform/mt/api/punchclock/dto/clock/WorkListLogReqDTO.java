package com.hengyunsoft.platform.mt.api.punchclock.dto.clock;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * com.hengyunsoft.platform.mt.api.punchclock.dto.clock
 * 版权：中科恒运软件科技股份有限公司贵阳分公司
 * 描述：app请求日志列表参数
 * 修改人：gbl
 * 修改时间：2019/7/3
 * 修改内容：
 */
@Data
@ApiModel(value = "WorkListLogReqDTO", description = "app请求日志列表参数")
public class WorkListLogReqDTO {
    @ApiModelProperty(value = "单位id" ,required = true)
    private String unitId;
    @ApiModelProperty(value = "用户id")
    private String name;
}
