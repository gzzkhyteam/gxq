package com.hengyunsoft.platform.mail.dto;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * 删除、移动接收数据
 *
 * @auth wt
 * @date 2018/08/17
 */

@Data
@ApiModel(value = "DeleteMailList", description = "删除、移动接收数据入参")
public class DeleteMailListDTO {
    @ApiModelProperty(value = "删除、移动接收数据")
    private List<MoveMailListDTO> data;
}
