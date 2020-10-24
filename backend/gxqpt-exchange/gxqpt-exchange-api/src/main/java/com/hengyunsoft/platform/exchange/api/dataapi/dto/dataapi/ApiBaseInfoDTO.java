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
 * 描述：api基础信息
 * 修改人：zhaopengfei
 * 修改时间：2018/4/21
 * 修改内容：
 */
@Data
@ApiModel(value = "ApiBaseInfo", description = "API基础信息")
public class ApiBaseInfoDTO {
    @ApiModelProperty(value = "API Id", required = true)
    private Long apiId;
    @ApiModelProperty(value = "API名称", required = true)
    private String apiName;
    @ApiModelProperty(value = "目录Id")
    private Long dirId;
    @ApiModelProperty(value = "目录名称")
    private String dirName;
    @ApiModelProperty(value = "目录数据类型:1,结构化数据；2，非结构化数据")
    private Integer dataType;
    @ApiModelProperty(value = "API访问地址")
    private String apiUrl;
    @ApiModelProperty(value = "支持格式（1,json;2,xml）", required = true)
    private Integer dataFmat;
    @ApiModelProperty(value = "任务Id,用于区分是需求管理中封装的API还是自己创建，如果自己创建，则不用传值")
    private Long taskId;
    @ApiModelProperty(value = "api描述")
    private String apiDesc;
    @ApiModelProperty(value = "API封装授权时间")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private Date limitTime;
    @ApiModelProperty(value = "授权单位Id")
    private List<String> unitIdList;

}
