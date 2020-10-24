package com.hengyunsoft.platform.developer.api.service.dto.module.apply;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 *
 * 版权：中科恒运软件科技股份有限公司贵阳分公司
 * 描述：我的功能混合逻辑操作dto
 * 修改人：sunxiaoya
 * 修改时间：2018/8/29
 * 修改内容：
 */
@Data
@ApiModel(value = "ServiceModuleMixHandleDTO", description = "我的功能混合逻辑操作dto")
public class ServiceModuleMixHandleDTO {

    @ApiModelProperty(value = "主键")
    private Long id;

    /**
     * 状态： 1、正常使用中   10、已过时（有新版本取代）   20、停止使用
     */
    @ApiModelProperty(value = "startUsing:开启使用 outmoded:过时 cancelOutmoded:取消过时 stopUsing:停止使用")
    private String mixHandleType;

    @ApiModelProperty(value = "推荐使用功能ID")
    private Long adviseModuleId;

    @ApiModelProperty(value = "推荐使用功能名字")
    private String adviseModuleName;
}
