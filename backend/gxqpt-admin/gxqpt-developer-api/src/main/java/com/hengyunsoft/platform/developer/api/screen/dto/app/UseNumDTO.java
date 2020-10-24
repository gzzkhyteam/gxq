package com.hengyunsoft.platform.developer.api.screen.dto.app;

import io.swagger.annotations.ApiModel;
import lombok.Data;

@Data
@ApiModel(value = "UseNum",description = "累计调用计数")
public class UseNumDTO {
    private Integer serviceNum;
}
