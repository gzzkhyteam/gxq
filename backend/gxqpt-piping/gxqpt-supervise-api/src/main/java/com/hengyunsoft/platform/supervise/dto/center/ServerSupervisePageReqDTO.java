package com.hengyunsoft.platform.supervise.dto.center;

import com.hengyunsoft.validator.annotation.FieldDesc;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import java.io.Serializable;
import java.util.List;

/**
 * 服务监管分页查询请求DTO
 * @author sxy
 * @date 2018-09-12
 */
@Data
@ApiModel(value = "ServerSupervisePageReqDTO",description = "服务监管分页查询请求DTO")
public class ServerSupervisePageReqDTO implements Serializable{

    private static final long serialVersionUID = 1L;

    /**
     * 应用ID
     *
     * @mbggenerated
     */
    @FieldDesc("应用ID")
    @ApiModelProperty(value = "应用ID")
    @Length(max=64)
    private List<String> appId;

    /**
     * 运行状态 启用:true 禁用:false
     *
     * @mbggenerated
     */
    @FieldDesc("运行状态 启用:true 禁用:false")
    @ApiModelProperty(value = "运行状态 启用:true 禁用:false")
    private Boolean runStatus;

}
