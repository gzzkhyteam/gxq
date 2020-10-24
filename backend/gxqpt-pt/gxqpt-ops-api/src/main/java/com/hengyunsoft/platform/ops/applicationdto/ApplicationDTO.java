package com.hengyunsoft.platform.ops.applicationdto;


import com.hengyunsoft.platform.ops.operationfiledto.OperationFileDTO;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @author tianai
 * @createTime 2018-07-13
 */
@Data
public class ApplicationDTO implements Serializable{
    /**
     * 主键
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "ID")
    private Long id;

    /**
     * 系统id
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "系统id")
    private String systemId;

    /**
     * 系统名称
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "系统名称")
    private String systemName;

    /**
     * 发布日期
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "发布日期")
    private Date publishDate;

    /**
     * 版本名称
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "版本名称")
    private String versionName;

    /**
     * 发布版本号
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "发布版本号")
    private String versionNumber;

    /**
     * 升级内容
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "升级内容")
    private String upgradeContent;

    /**
     * 发布服务器
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "发布服务器")
    private String publishingServer;

    /**
     * 状态
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "状态")
    private Integer status;

    /**
     * 备注
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "备注")
    private String remark;

    /**
     * 创建时间
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "创建时间")
    private Date createTime;
    @ApiModelProperty(value = "附件")
    private List<OperationFileDTO> fileList;

}
