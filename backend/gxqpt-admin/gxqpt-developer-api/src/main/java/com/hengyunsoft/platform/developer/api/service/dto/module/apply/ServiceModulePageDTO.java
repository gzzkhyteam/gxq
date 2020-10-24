package com.hengyunsoft.platform.developer.api.service.dto.module.apply;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * com.hengyunsoft.platform.admin.api.authority.dto.resource
 * 版权：中科恒运软件科技股份有限公司贵阳分公司
 * 描述：我的功能分页列表管理dto
 * 修改人：sunxiaoya
 * 修改时间：2018/4/4
 * 修改内容：
 */
@Data
@ApiModel(value = "ServiceModulePage", description = "我的功能分页列表")
public class ServiceModulePageDTO {

    @ApiModelProperty(value = "用户ID")
    private Long userId;
}
