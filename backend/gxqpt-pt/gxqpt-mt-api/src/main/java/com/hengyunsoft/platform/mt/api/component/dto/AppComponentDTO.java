package com.hengyunsoft.platform.mt.api.component.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * com.hengyunsoft.platform.mt.api.component.dto
 * 版权：中科恒运软件科技股份有限公司贵阳分公司
 * 描述：主键
 * 修改人：gbl
 * 修改时间：2018/8/27
 * 修改内容：
 */
@Data
@ApiModel(value = "", description = "")
public class AppComponentDTO {
    @ApiModelProperty(value = "主键ID")
    private Long id;
    /**
     * 模块名称
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "模块名称")
    private String componentName;

    /**
     * 描述说明
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "描述说明")
    private String componentDesc;
}
