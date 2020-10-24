package com.hengyunsoft.platform.developer.api.service.dto.module.serviceresource;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * com.hengyunsoft.platform.admin.api.authority.dto.resource
 * 版权：中科恒运软件科技股份有限公司贵阳分公司
 * 描述：服务资源文档管理dto
 * 修改人：sunxiaoya
 * 修改时间：2018/4/4
 * 修改内容：
 */
@Data
@ApiModel(value = "ServiceResourceDoc", description = "服务资源文档管理")
public class ServiceResourceDocDTO {

    @ApiModelProperty(value = "id")
    private Long id;

    @ApiModelProperty(value = "模块id")
    private Long moduleId;

    @ApiModelProperty(value = "解析swagger生成json格式字符串")
    private String jsonContent;

    @ApiModelProperty(value = "解析swagger生成json格式字符串")
    private String jsonMsg;

    @ApiModelProperty(value = "发布状态： 已发表、未发布")
    private Boolean status;

}
