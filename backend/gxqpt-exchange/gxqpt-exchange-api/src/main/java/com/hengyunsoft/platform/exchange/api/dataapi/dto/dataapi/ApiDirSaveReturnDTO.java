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
 * 描述：API目录保存返回字段
 * 修改人：zhaopengfei
 * 修改时间：2018/6/11
 * 修改内容：
 */
@Data
@ApiModel(value = "ApiDirSaveReturn", description = "API目录保存返回字段")
public class ApiDirSaveReturnDTO {
    @ApiModelProperty(value = "API Id")
    private Long apiId;
    @ApiModelProperty(value = "共享申请 Id")
    private Long applyId;
    @ApiModelProperty(value = "单位Id")
    private String unitId;

}
