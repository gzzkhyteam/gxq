package com.hengyunsoft.platform.standard.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "StandardClassifySave", description = "标准分类（添加）参数对象")
public class StandardClassifySaveDTO extends StandardClassifyBaseDTO {

}
