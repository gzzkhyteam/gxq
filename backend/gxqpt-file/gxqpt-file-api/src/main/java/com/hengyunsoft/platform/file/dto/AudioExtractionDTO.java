package com.hengyunsoft.platform.file.dto;

import com.hengyunsoft.platform.file.dto.image.BaseFileDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
@ApiModel(value = "AudioExtraction", description = "音频抽取")
public class AudioExtractionDTO extends BaseFileDTO implements Serializable {

    /**
     * 音频抽取路径url
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "音频抽取路径url")
    private String screenshot;
}
