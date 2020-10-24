package com.hengyunsoft.platform.mt.api.application.dto;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * com.hengyunsoft.platform.mt.api.application.dto
 * 版权：中科恒运软件科技股份有限公司贵阳分公司
 * 描述：
 * 修改人：gbl
 * 修改时间：2018/6/14
 * 修改内容：
 */
@Data
@ApiModel(value = "CreateFunctionReq", description = "创建应用请求参数")
public class CreateFunctionReqDTO {
    @ApiModelProperty(value = "功能id,编辑有id，新增无id")
    private Long id;
    @ApiModelProperty(value = "功能名称")
    private String appName;

    @ApiModelProperty(value = "功能的父id(所属应用的id),功能属于某一个应用，大于-1标识功能，-1表明该数据是应用")
    private Long parentId;

    @ApiModelProperty(value = "显示该功能的名称和提示的数量数据的接口")
    private String showUrl;

    @ApiModelProperty(value = "功能路径")
    private String appPath;

    @ApiModelProperty(value = "功能说明")
    private String appDesc;

    @ApiModelProperty(value = "是否显示(1:不显示 ,2:显示)")
    private Integer isShow;
}
