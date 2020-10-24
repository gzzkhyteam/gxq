package com.hengyunsoft.platform.exchange.api.directory.dto.directory;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author tianai
 * @createTime 2018-04-22
 */
@Data
public class DataDirectoryChangeSaveDTO extends BaseShareDataChangeDTO implements Serializable {
    /**
     * 目录名称/单位名称
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "目录名称/单位名称")
    private String dirName;

    /**
     * 父id
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "父id")
    private Long parentId;
    /**
     * 单位简称
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "单位简称")
    private String unitAbbr;
    /**
     * 目录标识:1,单位；2，数据目录
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "目录标识/单位标识")
    private Integer dirType;

    /**
     * 目录/单位描述
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "  目录/单位描述")
    private String desc;
    /**
     * 是否元目录:1,否；2，是
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "是否元目录")
    private Integer isBottom;

}
