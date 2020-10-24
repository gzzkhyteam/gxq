package com.hengyunsoft.platform.developer.api.core.dto.install;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
@Data
@ApiModel(value = "HostInstallLikeReq", description = "模糊查询部署所需实体")
public class HostInstallLikeReqDTO implements Serializable {
    /**
     * 所属应用id
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "所属应用id")
    private String appId;
    /**
     * 主机id
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "主机id")
    private Long hostId;
    
    /**
     * 主机名称
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "主机名称")
    private String hostName;
    
    
}
