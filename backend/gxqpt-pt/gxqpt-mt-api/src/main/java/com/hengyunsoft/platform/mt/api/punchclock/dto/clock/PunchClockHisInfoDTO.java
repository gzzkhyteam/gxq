package com.hengyunsoft.platform.mt.api.punchclock.dto.clock;

import com.hengyunsoft.platform.mt.api.file.dto.FileDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * com.hengyunsoft.platform.mt.api.punchclock.dto.clock
 * 版权：中科恒运软件科技股份有限公司贵阳分公司
 * 描述：打卡详情
 * 修改人：gbl
 * 修改时间：2018/7/9
 * 修改内容：
 */
@Data
@ApiModel(value = "PunchClockHisInfoDTO", description = "打卡详情")
public class PunchClockHisInfoDTO extends PunchClockHisDTO {
    @ApiModelProperty(value = "图片列表")
    private List<FileDTO> imageList;
}
