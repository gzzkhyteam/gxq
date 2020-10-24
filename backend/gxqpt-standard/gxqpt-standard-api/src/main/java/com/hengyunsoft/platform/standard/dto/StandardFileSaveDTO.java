package com.hengyunsoft.platform.standard.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "StandardFileSave", description = "新增标准文档参数对象")
public class StandardFileSaveDTO extends StandardFileBaseDTO {
    /**
     * 上传单位ID
     *
     * @mbggenerated
     */
	@ApiModelProperty(value = "上传单位ID")
    private String companyId;

    /**
     * 上传单位名称
     *
     * @mbggenerated
     */
	@ApiModelProperty(value = "上传单位名称")
    private String companyName;
    /**
     * 来自哪个页面
     *
     * @mbggenerated
     */
	@ApiModelProperty(value = "来自哪个页面 1:安全保障体系 2移动应用接口规范体系 3:数据统一标准规范体系")
    private Integer fromPage;

}
