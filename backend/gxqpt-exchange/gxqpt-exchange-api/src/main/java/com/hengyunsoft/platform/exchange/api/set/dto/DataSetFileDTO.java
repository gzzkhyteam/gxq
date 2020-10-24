package com.hengyunsoft.platform.exchange.api.set.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * com.hengyunsoft.platform.exchange.api.set.dto
 * 版权：中科恒运软件科技股份有限公司贵阳分公司
 * 描述：附件信息
 * 修改人：gbl
 * 修改时间：2018/4/22
 * 修改内容：
 */
@Data
@ApiModel(value = "DataSetFile", description = "附件信息")
public class DataSetFileDTO {
    @ApiModelProperty(value = "文件编号")
    private Long busId;
    @ApiModelProperty(value = "原附件名称")
    private String oldName;

    @ApiModelProperty(value = "上传到文件服务器上传的文件名称")
    private String newName;

    @ApiModelProperty(value = "附件类型")
    private String fileType;

    @ApiModelProperty(value = "附件大小")
    private Double fileSize;

    @ApiModelProperty(value = "附件路径")
    private String filePath;

}
