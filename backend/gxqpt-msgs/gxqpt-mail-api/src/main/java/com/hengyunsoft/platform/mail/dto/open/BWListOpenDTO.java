package com.hengyunsoft.platform.mail.dto.open;

import com.hengyunsoft.platform.mail.dto.bwlist.ValueDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author zjr
 * @date 2018/08/08
 */
@Data
@ApiModel(value = "BWListOpen", description = "新增黑名单")
public class BWListOpenDTO implements Serializable {

    /**
     * 邮箱用户名
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "邮箱用户名")
    private String userName;
    /**
     * 地址值,json格式[{"value":"xxx"},{"value":"xxx"}]
     * @mbggenerated
     */
    @ApiModelProperty(value = "地址值")
    private List<ValueDTO> value;

}
