package com.hengyunsoft.platform.exchange.entity.api.domain;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * com.hengyunsoft.platform.exchange.entity.api.po
 * gxqpt
 * 版权：中科恒运软件科技股份有限公司贵阳分公司
 * 描述：查询字段DO
 * 修改人：zhaopengfei
 * 修改时间：2018/5/8
 * 修改内容：
 */
@Data
public class FiledSelectDO {

    @ApiModelProperty(value = "查询字段名")
    private String selectName;

    @ApiModelProperty(value = "别名")
    private String aliasName;

}
