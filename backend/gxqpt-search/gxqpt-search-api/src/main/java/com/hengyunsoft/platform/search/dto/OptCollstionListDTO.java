package com.hengyunsoft.platform.search.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * com.hengyunsoft.platform.search.dto
 * 版权：中科恒运软件科技股份有限公司贵阳分公司
 * 描述：集合权限数据列表
 * 修改人：gbl
 * 修改时间：2018/4/9
 * 修改内容：
 */
@Data
@ApiModel(value = "OptCollstionList", description = "集合权限数据列表")
public class OptCollstionListDTO {

    @ApiModelProperty(value = "集合权限数据列表")
    private List<OptCollectionDTO> optCollList;
}
