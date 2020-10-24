package com.hengyunsoft.platform.ops.persondto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author tianai
 * @createTime 2018-07-11
 */
@Data
public class ChargeSystemDTO implements Serializable{

    /**
     * ID
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "ID")
    private String id;

    /**
     * 业务表id
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = " 业务表id")
    private Long pId;

    /**
     * 系统id
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "系统id")
    private String systemId;

    /**
     * 系统名称
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "系统名称")
    private String systemName;

}
