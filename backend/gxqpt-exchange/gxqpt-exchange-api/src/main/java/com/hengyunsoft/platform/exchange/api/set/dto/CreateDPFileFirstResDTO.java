package com.hengyunsoft.platform.exchange.api.set.dto;

import com.hengyunsoft.platform.exchange.api.directory.dto.directory.DataDirectoryDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * com.hengyunsoft.platform.exchange.api.set.dto
 * 版权：中科恒运软件科技股份有限公司贵阳分公司
 * 描述：创建文件类数据集第一步返回
 * 修改人：gbl
 * 修改时间：2018/4/26
 * 修改内容：
 */
@Data
@ApiModel(value = "CreateDPFileFirstRes", description = "创建文件类数据集第一步返回")
public class CreateDPFileFirstResDTO {
    @ApiModelProperty(value = "数据集id")
    private Long id;
    @ApiModelProperty(value = "附件信息")
    private List<DataSetFileDTO> files;
    @ApiModelProperty(value = "当前关联目录")
    protected List<DataDirectoryDTO> directorys;

}
