package com.hengyunsoft.platform.file.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author madengbo
 * @create 2018-09-06 16:39
 * @desc 各类文件近几个月发展状况分析
 * @Version 1.0
 **/
@Data
@ApiModel(value = "FileDataTypeDevViewDTO", description = "各类文件近几个月发展状况分析DTO")
public class FileDataTypeDevViewDTO {

    @ApiModelProperty(value = "时间年月")
    private String fYearMonth;

    @ApiModelProperty(value = "各类文件数量entity")
    private FileDevDataTypeNum fileDevDataTypeNum;
}
