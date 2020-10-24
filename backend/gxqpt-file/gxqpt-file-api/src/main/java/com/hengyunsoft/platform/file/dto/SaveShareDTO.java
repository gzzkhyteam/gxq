package com.hengyunsoft.platform.file.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;


@Data
@ApiModel(value = "SaveShare", description = "分享保存")
public class SaveShareDTO {
    /**
     * 需要分享的文件id集合
     */
    @ApiModelProperty(value = "需要分享的文件id集合")
    private List<Long> idList;
    /**
     * 文件是否加密
     */
    @ApiModelProperty(value = "文件是否加密")
    private Boolean isPwd;
    /**
     * 是否存在有效期-  NUL:无限期; DAY:1天; WEEK:7天
     */
    @ApiModelProperty(value = "是否存在有效期-  NUL:无限期; DAY:1天; WEEK:7天", example = "NUL,DAY,WEEK")
    private String valid;
}
