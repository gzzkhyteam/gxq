package com.hengyunsoft.platform.hardware.dto.apply;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "AttachmentDTO", description = "附件")
public class AttachmentDTO {

    /**
     * 业务类型
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "业务类型")
    private String busType;

    /**
     * 文件名
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "文件名")
    private String fileName;

    /**
     * 文件大小
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "文件大小")
    private Integer fileSize;

    /**
     * 文件类型
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "文件类型")
    private String fileType;

    /**
     * 文件路径
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "文件路径")
    private String fileUrl;
}
