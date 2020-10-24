package com.hengyunsoft.platform.file.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author madengbo
 * @create 2018-09-06 15:05
 * @desc 文件发展状况
 * @Version 1.0
 **/
@Data
@ApiModel(value = "FileDevViewDTO", description = "近6月文件发展数量DTO")
public class FileDevViewDTO {

    @ApiModelProperty(value = "时间年月")
    private String fYearMonth;

    @ApiModelProperty(value = "文件数量")
    private Integer num;
}
