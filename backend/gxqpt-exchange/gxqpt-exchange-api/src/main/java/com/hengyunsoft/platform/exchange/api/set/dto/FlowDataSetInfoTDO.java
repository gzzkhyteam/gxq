package com.hengyunsoft.platform.exchange.api.set.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * com.hengyunsoft.platform.exchange.api.set.dto
 * 版权：中科恒运软件科技股份有限公司贵阳分公司
 * 描述：流程详情信息
 * 修改人：gbl
 * 修改时间：2018/4/27
 * 修改内容：
 */
@Data
@ApiModel(value = "FlowDataSetInfo", description = "流程详情信息")
public class FlowDataSetInfoTDO {
    @ApiModelProperty(value = "数据集id")
    private long id;
    @ApiModelProperty(value = "数据集类型")
    private Integer setType;
    @ApiModelProperty(value = "申请编号")
    private String applyCode;

    @ApiModelProperty(value = "申请人")
    private String applyUserName;

    @ApiModelProperty(value = "数据集名称")
    private String setName;

    @ApiModelProperty(value = "数据集大小(数据量)")
    private Float dataCount;

    @ApiModelProperty(value = "申请原因")
    private String reason;

    @ApiModelProperty(value = "过滤字段列表")
    private List<FieldParamDTO> paramFileds;

    @ApiModelProperty(value = "目录关联信息")
    private List<RelatedDirectoryDTO> relatedDirectory;

    //文件类数据集关联的文件
    @ApiModelProperty(value = "附件信息")
    private List<DataSetFileDTO> files;

    @ApiModelProperty(value = "表名标识")
    private String tableCode;
}
