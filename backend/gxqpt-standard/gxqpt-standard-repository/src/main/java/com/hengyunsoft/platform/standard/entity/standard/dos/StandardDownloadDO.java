package com.hengyunsoft.platform.standard.entity.standard.dos;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "StandardDownloadDO", description = "标准下载")
public class StandardDownloadDO {

    @ApiModelProperty(value = "标准类别id")
    private Long id;
    @ApiModelProperty(value = "标准/类别名称")
    private String name;
    @ApiModelProperty(value = "标准/类别下载数量")
    private Integer count;
}
