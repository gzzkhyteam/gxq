package com.hengyunsoft.platform.exchange.api.dataapi.dto.demand;

import com.hengyunsoft.platform.exchange.api.system.dto.ShareDictBaseInfoDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * com.hengyunsoft.platform.exchange.api.dataapi.dto
 * 版权：中科恒运软件科技股份有限公司贵阳分公司
 * 描述：附件Dto
 * 修改人：zhaopengfei
 * 修改时间：2018/4/21
 * 修改内容：
 */
@Data
@ApiModel(value = "DemandAddRequest", description = "新增需求页面返回DTO")
public class DemandAddRequestDTO {
    @ApiModelProperty(value = "单位名")
    private String orgName;
    @ApiModelProperty(value = "单位类型")
    private String unitType;
    @ApiModelProperty(value = "联系人")
    private String linkName;
    @ApiModelProperty(value = "联系人电话")
    private String linkPhone;
}
