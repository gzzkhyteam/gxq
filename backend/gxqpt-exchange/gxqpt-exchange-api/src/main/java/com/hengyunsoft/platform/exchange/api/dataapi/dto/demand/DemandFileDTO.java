package com.hengyunsoft.platform.exchange.api.dataapi.dto.demand;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * com.hengyunsoft.platform.exchange.api.dataapi.dto
 * 版权：中科恒运软件科技股份有限公司贵阳分公司
 * 描述：附件Dto
 * 修改人：zhaopengfei
 * 修改时间：2018/4/21
 * 修改内容：
 */
@Data
@ApiModel(value = "DemandFile", description = "附件Dto")
public class DemandFileDTO {
    @ApiModelProperty(value = "附件名")
    private String oldName;

    @ApiModelProperty(value = "附件类型")
    private String fileType;

    @ApiModelProperty(value = "附件大小")
    private String fileSize;

    @ApiModelProperty(value = "附件路径")
    private String filePath;
}
