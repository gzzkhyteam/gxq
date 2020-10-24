package com.hengyunsoft.platform.exchange.api.set.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * com.hengyunsoft.platform.exchange.api.set.dto
 * 版权：中科恒运软件科技股份有限公司贵阳分公司
 * 描述：删除文件参数
 * 修改人：gbl
 * 修改时间：2018/5/10
 * 修改内容：
 */
@Data
@ApiModel(value = "DeleteFileParam", description = "删除文件参数")
public class DeleteFileParamDTO {
    @ApiModelProperty(value = "数据id")
    private Long setId;
    @ApiModelProperty(value = "文件编号列表")
    private List<Long> fileIds;

}
