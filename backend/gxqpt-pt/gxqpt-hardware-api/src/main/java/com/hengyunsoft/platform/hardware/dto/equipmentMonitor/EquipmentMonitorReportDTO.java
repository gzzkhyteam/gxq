package com.hengyunsoft.platform.hardware.dto.equipmentMonitor;

import java.util.Date;
import java.util.List;

import com.hengyunsoft.platform.hardware.dto.apply.AttachmentDTO;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
/**
 * @author farglory
 * @create 2018-09-3 14:12
 * @desc 查询设备监控>报告列表返回数据实体
 **/
@Data
public class EquipmentMonitorReportDTO{
	
	@ApiModelProperty(value = "主键id")
    private Long id;

	@ApiModelProperty(value = "设备监控id")
    private Long hostMgId;

	@ApiModelProperty(value = "年")
    private Integer year;

	@ApiModelProperty(value = "月")
    private Integer month;

	@ApiModelProperty(value = "是否删除")
    private Integer isDelete;

	@ApiModelProperty(value = "创建人")
    private String createUser;
	
	@ApiModelProperty(value = "创建人名称")
    private String createUserName;
	
	@ApiModelProperty(value = "创建时间")
    private Date createTime;

	@ApiModelProperty(value = "修改人")
    private String updateUser;

	@ApiModelProperty(value = "修改时间")
    private Date updateTime;
	/**
     * 附件
     */
    @ApiModelProperty(value = "附件集合")
    private List<AttachmentDTO> attachment;
    
    /**
     * 文件大小
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "文件大小")
    private Integer fileSize;
    /**
     * 文件名称
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "文件名称")
    private String fileName;
    /**
     * 文件路径
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "文件路径")
    private String fileUrl;
}