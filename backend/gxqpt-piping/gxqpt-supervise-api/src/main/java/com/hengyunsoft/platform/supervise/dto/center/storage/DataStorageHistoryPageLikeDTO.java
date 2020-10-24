package com.hengyunsoft.platform.supervise.dto.center.storage;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@Data
@ApiModel(value = "DataStorageHistoryPageLike", description = "数据存储历史记录模糊查询入参实体")
public class DataStorageHistoryPageLikeDTO {
    /**
     * 配置id
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "配置id")
    private Long storageId;

    /**
     * 开始时间
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "开始时间")
    private Date startTime;

    /**
     * 结束时间
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "结束时间")
    private Date endTime;
}
