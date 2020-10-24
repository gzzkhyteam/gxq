package com.hengyunsoft.platform.file.dto;

import com.hengyunsoft.platform.file.dto.image.BaseFileDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
@ApiModel(value = "VideoConverter", description = "视频剪切")
public class VideoConverterDTO extends BaseFileDTO implements Serializable {

    /**
     * 视频剪切路径url
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "视频剪切路径url")
    private String screenshot;
}
