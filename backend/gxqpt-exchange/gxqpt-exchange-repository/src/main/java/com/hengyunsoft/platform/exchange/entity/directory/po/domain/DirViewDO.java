package com.hengyunsoft.platform.exchange.entity.directory.po.domain;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class DirViewDO {
        @ApiModelProperty(value = "目录id")
        private Long id;
        @ApiModelProperty(value = "目录名称")
        private String name;
        @ApiModelProperty(value = "数据集id")
        private String setId;
        @ApiModelProperty(value = "数据集名称")
        private String setName;

}
