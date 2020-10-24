package com.hengyunsoft.platform.developer.api.fast.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * @author wt
 * @create 2018-05-04
 * @create 2018-05-04
 * @desc 应用数据字典
 **/
@Data
@ApiModel(value = "ResponseDictionaryDTO",description = "应用数据字典")
public class ResponseDictionaryDTO implements Serializable{

    /**
     * 编码
     * @mbggenerated
     */
    @ApiModelProperty(value = "编码")
    private String code;

    /**
     * 名称
     * @mbggenerated
     */
    @ApiModelProperty(value = "名称")
    private String name;

    /**
     * 数据字典对应应用
     * @mbggenerated
     */
    @ApiModelProperty(value = "数据字典对应应用")
    private List<ResponseApplicationDetailDTO> application;

}