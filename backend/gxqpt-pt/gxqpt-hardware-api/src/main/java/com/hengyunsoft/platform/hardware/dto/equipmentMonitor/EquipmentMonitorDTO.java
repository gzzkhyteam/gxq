package com.hengyunsoft.platform.hardware.dto.equipmentMonitor;

import java.util.Date;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author farglory
 * @create 2018-09-3 14:12
 * @desc 查询设备监控列表返回数据实体
 **/
@Data
public class EquipmentMonitorDTO {

	@ApiModelProperty(value = "主键id")
    private Long id;

	@ApiModelProperty(value = "机房编号")
    private String roomNumber;

	@ApiModelProperty(value = "管理员")
    private String roomAdmin;

	@ApiModelProperty(value = "联系电话")
    private String contactNumber;

	@ApiModelProperty(value = "主机数量")
    private Integer hostNum;

	@ApiModelProperty(value = "路由器数量")
    private Integer routerNum;

	@ApiModelProperty(value = "空调数量")
    private Integer airConNum;

	@ApiModelProperty(value = "机柜数量")
    private Integer cabinetNum;

	@ApiModelProperty(value = "是否删除")
    private Integer isDelete;

	@ApiModelProperty(value = "创建人")
    private String createUser;

	@ApiModelProperty(value = "创建时间")
    private Date createTime;

	@ApiModelProperty(value = "修改人")
    private String updateUser;

	@ApiModelProperty(value = "修改时间")
    private Date updateTime;

}