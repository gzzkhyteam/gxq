package com.hengyunsoft.platform.exchange.api.overview.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class DirOrgDTO {
    @ApiModelProperty(value = "业务名称")
    private String dirName;
    @ApiModelProperty(value = "单位id")
    private String unitId;
    @ApiModelProperty(value = "数据集量")
    private String dataCount;
    @ApiModelProperty(value = "业务类型")
    private String busCode;
    @ApiModelProperty(value = "关键字")
    private String searchKey;
    @ApiModelProperty(value = "排序方式：1，更新时间，2，访问量，3，数据量")
    private Integer indexNo;
    @ApiModelProperty(value = "业务key")
    private String busKey;

}
