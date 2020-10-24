package com.hengyunsoft.platform.mt.api.feedback.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * com.hengyunsoft.platform.mt.api.feedback.dto
 * 版权：中科恒运软件科技股份有限公司贵阳分公司
 * 描述：创建意见反馈上传的图片详细
 * 修改人：gbl
 * 修改时间：2018/6/22
 * 修改内容：
 */
@Data
@ApiModel(value = "", description = "")
public class CreateFeedBackImageDTO {
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
