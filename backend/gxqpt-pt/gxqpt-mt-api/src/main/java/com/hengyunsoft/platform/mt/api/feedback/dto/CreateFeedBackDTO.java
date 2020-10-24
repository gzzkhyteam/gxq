package com.hengyunsoft.platform.mt.api.feedback.dto;

import com.hengyunsoft.platform.mt.api.file.dto.CreateFileDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * com.hengyunsoft.platform.mt.api.feedback.dto
 * 版权：中科恒运软件科技股份有限公司贵阳分公司
 * 描述：创建意见反馈请求参数
 * 修改人：gbl
 * 修改时间：2018/6/22
 * 修改内容：
 */
@Data
@ApiModel(value = "CreateFeedBack", description = "创建意见反馈请求参数")
public class CreateFeedBackDTO {

    @ApiModelProperty(value = "反馈标题")
    private String fbTitle;

    @ApiModelProperty(value = "应用id")
    private Long appliId;

    @ApiModelProperty(value = "反馈内容")
    private String fbContent;

    @ApiModelProperty(value = "紧急程度(1普通，2紧急，3非常紧急)")
    private Integer fbEmergency;

    @ApiModelProperty(value = "图片")
    private List<CreateFileDTO> images;
}
