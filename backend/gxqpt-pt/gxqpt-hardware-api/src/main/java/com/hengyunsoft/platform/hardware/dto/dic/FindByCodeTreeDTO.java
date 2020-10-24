package com.hengyunsoft.platform.hardware.dto.dic;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@ApiModel(value = "FindByCodeTreeDTO",description = "字典返回树")
public class FindByCodeTreeDTO {
    @ApiModelProperty(value = "id")
    private Long id;
    @ApiModelProperty(value = "父id")
    private String parentId;
    @ApiModelProperty(value = "编码code")
    private String code;
    @ApiModelProperty(value = "字典类型名")
    private String name;

    @ApiModelProperty(value = "字典dtos")
    private List<FindByCodeDTO> dtos = new ArrayList<>();
}
