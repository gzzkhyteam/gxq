package com.hengyunsoft.platform.exchange.api.set.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;
import java.util.Map;

/**
 * com.hengyunsoft.platform.exchange.api.set.dto
 * 版权：中科恒运软件科技股份有限公司贵阳分公司
 * 描述：数据仓库数据修改
 * 修改人：zhaopengfei
 * 修改时间：2018/8/31
 * 修改内容：
 */
@Data
@ApiModel(value = "WareHouseUpdate", description = "数据仓库数据修改")
public class WareHouseUpdateDTO {
    @ApiModelProperty(value = "数据集id")
    private Long setId;

    @ApiModelProperty(value = "删除数据列表")
    private List<Long> deleteIdList;

    @ApiModelProperty(value = "修改对象列表")
    private List<Map<String,Object>> updateObjList;


}
