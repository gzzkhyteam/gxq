package com.hengyunsoft.platform.exchange.api.dataapi.dto.demand;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * com.hengyunsoft.platform.exchange.api.dataapi.dto
 * 版权：中科恒运软件科技股份有限公司贵阳分公司
 * 描述：需求处理详情
 * 修改人：zhaopengfei
 * 修改时间：2018/4/21
 * 修改内容：
 */
@Data
@ApiModel(value = "DemandHandleDetail", description = "需求处理详情")
public class DemandHandleDetailDTO extends DemandSaveDTO {
    @ApiModelProperty(value = "处理部门")
    private String orgName;
    @ApiModelProperty(value = "状态:1,通过；2，驳回")
    private Integer status;

    @ApiModelProperty(value = "审批意见")
    private String hdContent;

    @ApiModelProperty(value = "附件list")
    private List<DemandFileDTO> fileList;
    @ApiModelProperty(value = "apiId")
    private Long apiId;

    @ApiModelProperty(value = "API预计封装时间")
    private Date estimateTime;


}
