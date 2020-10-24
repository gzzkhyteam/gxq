package com.hengyunsoft.platform.hardware.dto.manage;

import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.util.List;

@Data
@ApiModel(value = "ServerManageCheckIPDTO", description = "服务器管理ip判断")
public class ServerManageCheckIPDTO {
    List<ServerManageDetailDTO> dtos;
}
