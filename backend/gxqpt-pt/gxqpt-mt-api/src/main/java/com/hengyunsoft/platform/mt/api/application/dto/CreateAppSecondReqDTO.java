package com.hengyunsoft.platform.mt.api.application.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * com.hengyunsoft.platform.mt.api.application.dto
 * 版权：中科恒运软件科技股份有限公司贵阳分公司
 * 描述：创建应用第二步（选择接口）请求参数
 * 修改人：gbl
 * 修改时间：2018/5/28
 * 修改内容：
 */
@Data
@ApiModel(value = "CreateAppSecondReq", description = "创建应用第二步（选择接口）请求参数")
public class CreateAppSecondReqDTO {
    @ApiModelProperty(value = " 应用id")
    private Long id;
    @ApiModelProperty(value = "选择的接口id")
    private List<Long> interfaceIds;
}
