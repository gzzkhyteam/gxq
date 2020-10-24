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
public class PersonManageSaveDTO implements Serializable{

    /**
     * id
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "id")
    private Long id;

    @ApiModelProperty(value = "电话")
    private String mainmobile;

    /**
     * 咨询内容
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "主要工作内容")
    private String  content;

    /**
     * 主要负责系统
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "主要负责系统")
    private List<ChargeSystemDTO> systemName;

}
