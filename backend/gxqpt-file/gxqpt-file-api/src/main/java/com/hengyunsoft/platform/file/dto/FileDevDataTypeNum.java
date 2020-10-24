package com.hengyunsoft.platform.file.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author madengbo
 * @create 2018-09-06 15:16
 * @desc 各类文件类型近期统计
 * @Version 1.0
 **/
@Data
public class FileDevDataTypeNum {

    private Integer imgNum;

    private Integer docNum;

    private Integer videoNum;

    private Integer audioNum;

    private Integer otherNum;
}
