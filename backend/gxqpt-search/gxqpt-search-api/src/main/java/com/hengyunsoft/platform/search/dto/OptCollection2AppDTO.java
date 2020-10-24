package com.hengyunsoft.platform.search.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * com.hengyunsoft.platform.search.dto
 * 版权：中科恒运软件科技股份有限公司贵阳分公司
 * 描述：集合分配权限请求参数
 * 修改人：gbl
 * 修改时间：2018/4/11
 * 修改内容：
 */
@Data
@ApiModel(value = "OptCollection2App", description = "集合分配权限请求参数")
public class OptCollection2AppDTO {
    @ApiModelProperty(value = "集合id")
    private Long collectionId;
    @ApiModelProperty(value = "目标appId")
    private String appId;
    @ApiModelProperty(value = "权限类型 0没有，1读，2写，3读写")
    private Integer opt;
}
