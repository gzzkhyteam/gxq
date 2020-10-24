package com.hengyunsoft.platform.supervise.dto.center.storage;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@Data
@ApiModel(value = "DataStorageHistoryPageRes", description = "数据存储配置模糊查询返回实体")
public class DataStorageHistoryPageResDTO {
    /**
     * 主键
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "主键")
    private Long id;

    /**
     * 数据存储配置id
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "数据存储配置id")
    private Long storageId;

    /**
     * 数据库空间数量
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "数据库空间数量")
    private String dbSpaceNum;

    /**
     * 日志空间数量
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "日志空间数量")
    private String logSpaceNum;

    /**
     * 文件空间数量
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "文件空间数量")
    private String fileSpaceNum;

    /**
     * 创建时间
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "创建时间")
    private Date createTime;
}
