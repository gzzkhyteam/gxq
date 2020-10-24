package com.hengyunsoft.platform.ops.consultdto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * Created by kevin on 2018/7/17.
 */
@Data
@ApiModel(value = "DealUserDTO", description = "处理人")
public class DealUserDTO implements Serializable {

    @ApiModelProperty(value = "主键")
    private Long id;

    @ApiModelProperty(value = "业务id")
    private Long bussId;

    @ApiModelProperty(value = "人员id")
    private Long personId;

    @ApiModelProperty(value = "处理人姓名")
    private String personName;

    @ApiModelProperty(value = "人员类型(咨询处理人zxr，协助人xzr)")
    private String type;

}
