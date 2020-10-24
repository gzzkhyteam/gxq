package com.hengyunsoft.platform.modular.entity.modular.dos;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
@Data
@ApiModel(value = "ModularDownloadNumDO", description = "模块下载量")
public class ModularDownloadNumDO {
   @ApiModelProperty(value = "模块名称")
   private String name;
   @ApiModelProperty(value = "下载次数")
   private Integer count;
   @ApiModelProperty(value = "占比")
   private String ratio;
}
