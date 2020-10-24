package com.hengyunsoft.platform.security.api.backups.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
@ApiModel(value = "ShareResponseBackupsLogTime", description = "备份监控数据带日期查询返回信息")
public class ShareResponseBackupsLogTimeDTO implements Serializable {

    /**
     * 开始日期
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "开始日期")
    private Date startTime;

    /**
     * 数据
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "数据")
    private List<ShareResponseBackupsLogDTO> logList;

}
