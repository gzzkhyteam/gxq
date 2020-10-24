package com.hengyunsoft.platform.ops.servicedto;

import com.hengyunsoft.platform.ops.consultdto.DealUserDTO;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;


/**
 * @author tianai
 * @createTime 2018-07-19
 */
@Data
public class ServiceMangeAlarmDTO implements Serializable{
    @ApiModelProperty(value = "申请编号")
    private String applyCode;
    @ApiModelProperty(value = "计算时长")
    private Integer  day;

}
