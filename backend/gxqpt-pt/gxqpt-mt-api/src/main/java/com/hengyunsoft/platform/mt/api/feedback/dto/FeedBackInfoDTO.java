package com.hengyunsoft.platform.mt.api.feedback.dto;

import com.hengyunsoft.platform.mt.api.file.dto.FileDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * com.hengyunsoft.platform.mt.api.feedback.dto
 * 版权：中科恒运软件科技股份有限公司贵阳分公司
 * 描述：意见反馈详情
 * 修改人：gbl
 * 修改时间：2018/6/22
 * 修改内容：
 */
@Data
@ApiModel(value = "FeedBackInfo", description = "意见反馈详情")
public class FeedBackInfoDTO extends FeedBackBaseDTO {
    @ApiModelProperty(value = "图片列表")
    private List<FileDTO> imageList;

    @ApiModelProperty(value = "消息列表")
    private List<FeedBackMsgDTO> msgList;
}
