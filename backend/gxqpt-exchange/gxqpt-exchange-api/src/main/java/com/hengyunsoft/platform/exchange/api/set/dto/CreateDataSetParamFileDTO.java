package com.hengyunsoft.platform.exchange.api.set.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * com.hengyunsoft.platform.exchange.api.set.dto
 * 版权：中科恒运软件科技股份有限公司贵阳分公司
 * 描述：创建结构化文件或者非结构化文件数据集
 * 修改人：gbl
 * 修改时间：2018/4/22
 * 修改内容：
 */
@Data
@ApiModel(value = "CreateDataSetParamFile", description = "创建结构化文件或者非结构化文件数据集")
public class CreateDataSetParamFileDTO {
    @ApiModelProperty(value = "编辑类型,1新增，2编辑，3详情")
    private Integer editType;
    @ApiModelProperty(value = "数据集id")
    private Long id;
    @ApiModelProperty(value = "附件信息")
    private List<DataSetFileDTO> files;
    @ApiModelProperty(value = "管理目录id")
    protected List<Long> directoryId;
}
