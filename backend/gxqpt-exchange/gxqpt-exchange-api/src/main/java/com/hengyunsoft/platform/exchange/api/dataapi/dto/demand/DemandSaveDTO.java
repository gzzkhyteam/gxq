package com.hengyunsoft.platform.exchange.api.dataapi.dto.demand;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * com.hengyunsoft.platform.exchange.api.dataapi.dto
 * 版权：中科恒运软件科技股份有限公司贵阳分公司
 * 描述：需求新增dto
 * 修改人：zhaopengfei
 * 修改时间：2018/4/21
 * 修改内容：
 */
@Data
@ApiModel(value = "DemandSave", description = "需求保存Dto")
public class DemandSaveDTO {
    @ApiModelProperty(value = "单位名称")
    private String unitName;

    @ApiModelProperty(value = "单位类型")
    private String unitType;

    @ApiModelProperty(value = "联系人姓名")
    private String contName;

    @ApiModelProperty(value = "联系人电话")
    private String contTel;

    @ApiModelProperty(value = "联系人邮箱")
    private String contEmail;

    @ApiModelProperty(value = "统一社会信用代码")
    private String creditCode;

    @ApiModelProperty(value = "需求内容", required = true)
    private String content;

    @ApiModelProperty(value = "用途")
    private String purpose;

    @ApiModelProperty(value = "申请原因")
    private String applyReason;

    @ApiModelProperty(value = "处理部门id", required = true)
    private String orgId;

    @ApiModelProperty(value = "附件list")
    private List<DemandFileDTO> fileList;


}
