package com.hengyunsoft.platform.developer.api.screen.dto.org;/**
 * Created by Administrator on 2018/5/1.
 */

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author madb
 * @create 2018/05/01
 * @desc 每月应用展示DTO
 **/
@Data
public class OrgMonthNumDTO {
    @ApiModelProperty(value = "月份")
    private String month;
    @ApiModelProperty(value = "每月对应数量")
    private int num;
}
