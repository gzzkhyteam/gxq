package com.hengyunsoft.platform.ops.servicedto;

import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "TrainFileUploadDTO", description = "培训文件上传请求参数")
public class TrainFileUploadDTO {
    @ApiModelProperty(value = "文件对象集合")
    private List<TrainFileDTO> files;
    @ApiModelProperty(value = "删除文件对象集合")
    private List<Long> fileIds;
}
