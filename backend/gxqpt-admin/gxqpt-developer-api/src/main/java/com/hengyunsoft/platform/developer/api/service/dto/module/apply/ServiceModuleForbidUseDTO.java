package com.hengyunsoft.platform.developer.api.service.dto.module.apply;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * com.hengyunsoft.platform.admin.api.authority.dto.resource
 * 版权：中科恒运软件科技股份有限公司贵阳分公司
 * 描述：我的功能申请管理dto
 * 修改人：sunxiaoya
 * 修改时间：2018/4/2
 * 修改内容：
 */
@Data
@ApiModel(value = "ServiceModuleForbid", description = "禁止模块功能")
public class ServiceModuleForbidUseDTO {

    @ApiModelProperty(value = "主键")
    private String id;

    @ApiModelProperty(value = "状态： 1、正常使用中   10、已过时（有新版本取代）   20、停止使用")
    private Short status;
}
