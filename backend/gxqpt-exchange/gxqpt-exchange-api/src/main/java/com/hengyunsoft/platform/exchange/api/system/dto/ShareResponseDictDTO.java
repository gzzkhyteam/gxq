package com.hengyunsoft.platform.exchange.api.system.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
@ApiModel(value = "ShareResponseDictDTO", description = "数据字典返回信息")
public class ShareResponseDictDTO implements Serializable {
    /**
     * 主键
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "主键")
    private Long id;

    /**
     * 名称
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "名称")
    private String dictName;

    /**
     * 编码
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "编码")
    private String dictCode;

    /**
     * 上级目录名称
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "上级目录名称")
    private String pDictName;

    /**
     * 上级目录编码
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "上级目录编码")
    private String pDictCode;

    @ApiModelProperty(value = "描述")
    private String describe;
    /**
     * 父ID
     *
     * @mbggenerated
     */
    private String pId;
    /**
     * 父ID
     *
     * @mbggenerated
     */
    private String indexNo;

    public String getpId() {
        return pId;
    }

    public void setpId(String pId) {
        this.pId = pId;
    }

    /**
     * 子目录
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "是否存在子目录")
    private Boolean isChildren;
}
