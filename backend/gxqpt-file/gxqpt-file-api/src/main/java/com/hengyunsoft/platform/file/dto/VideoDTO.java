package com.hengyunsoft.platform.file.dto;

import com.hengyunsoft.platform.file.dto.image.BaseFileDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
@ApiModel(value = "Video", description = "视频")
public class VideoDTO extends BaseFileDTO implements Serializable {

    /**
     * 视频截图路径url
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "视频截图路径url")
    private String screenshot;
}
