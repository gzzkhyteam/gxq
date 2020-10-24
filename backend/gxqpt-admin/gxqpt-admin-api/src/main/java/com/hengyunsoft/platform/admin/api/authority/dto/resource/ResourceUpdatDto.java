package com.hengyunsoft.platform.admin.api.authority.dto.resource;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * com.hengyunsoft.platform.admin.api.authority.dto.resource
 * codeBySC2
 * 版权：中科恒运软件科技股份有限公司贵阳分公司
 * 描述：
 * 修改人：zhaopengfei
 * 修改时间：2018/3/6
 * 修改内容：
 */
@Data
public class ResourceUpdatDto extends ResourceSaveDto{
    @ApiModelProperty(value = "资源Id",required = true)
    private Long id;
}
