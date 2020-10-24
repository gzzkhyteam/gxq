package com.hengyunsoft.platform.ops.servicedto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "TrainFileDTO", description = "培训文件对象")
public class TrainFileDTO {
    @ApiModelProperty(value = "文件id")
    private Long fileId;
    @ApiModelProperty(value = "文件名称")
    private String name;
    @ApiModelProperty(value = "文件类型")
    private String type;
    @ApiModelProperty(value = "业务id")
    private Long bussId;
    @ApiModelProperty(value = "业务类型")
    private String bussType;
    @ApiModelProperty(value = "文件大小")
    private Integer fileSize;
    @ApiModelProperty(value = "文件路径")
    private String fileUrl;   
}
