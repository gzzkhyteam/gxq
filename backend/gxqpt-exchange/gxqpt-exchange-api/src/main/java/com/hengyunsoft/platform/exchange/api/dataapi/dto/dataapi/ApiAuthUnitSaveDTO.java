package com.hengyunsoft.platform.exchange.api.dataapi.dto.dataapi;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

/**
 * com.hengyunsoft.platform.exchange.api.dataapi.dto
 * 版权：中科恒运软件科技股份有限公司贵阳分公司
 * 描述：API新增授权单位参数
 * 修改人：zhaopengfei
 * 修改时间：2018/4/21
 * 修改内容：
 */
@Data
@ApiModel(value = "ApiAuthUnitSave", description = "API新增授权单位参数")
public class ApiAuthUnitSaveDTO {
    @ApiModelProperty(value = "apiId ",required = true)
    private Long apiId;
    @ApiModelProperty(value = "授权期限",required = true)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private Date limitTime;
    @ApiModelProperty(value = "单位id数组")
    private List<String> unitIdList;
}
