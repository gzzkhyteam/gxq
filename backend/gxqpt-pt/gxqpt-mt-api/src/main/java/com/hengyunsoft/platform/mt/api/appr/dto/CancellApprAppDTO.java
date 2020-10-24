package com.hengyunsoft.platform.mt.api.appr.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * com.hengyunsoft.platform.mt.api.appr.dto
 * 版权：中科恒运软件科技股份有限公司贵阳分公司
 * 描述：撤销申请
 * 修改人：gbl
 * 修改时间：2018/7/16
 * 修改内容：
 */
@Data
@ApiModel(value = "CancellApprAppDTO", description = "撤销申请")
public class CancellApprAppDTO {
    @ApiModelProperty(value = "申请id")
    private  Long id;
    @ApiModelProperty(value = "撤销理由")
    private  String canceReasonl;
}
