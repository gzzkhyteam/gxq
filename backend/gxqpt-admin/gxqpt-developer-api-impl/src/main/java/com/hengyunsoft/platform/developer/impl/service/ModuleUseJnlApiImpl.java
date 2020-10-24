package com.hengyunsoft.platform.developer.impl.service;

import com.hengyunsoft.base.Result;
import com.hengyunsoft.commons.exception.core.DeveloperExceptionCode;
import com.hengyunsoft.commons.utils.context.DozerUtils;
import com.hengyunsoft.platform.admin.entity.org.gxqpt.domain.FastEntryRankDO;
import com.hengyunsoft.platform.developer.api.service.api.ModuleUseJnlApi;
import com.hengyunsoft.platform.developer.api.service.dto.module.*;
import com.hengyunsoft.platform.developer.entity.core.domain.ModuleUseRankDO;
import com.hengyunsoft.platform.developer.entity.core.po.ModuleUseInfo;
import com.hengyunsoft.platform.developer.entity.core.po.domain.ModuleUseDayDataDO;
import com.hengyunsoft.platform.developer.entity.core.po.domain.ModuleUseSumTotalNumDO;
import com.hengyunsoft.platform.developer.repository.service.service.ModuleUseJnlService;
import com.hengyunsoft.security.auth.client.annotation.IgnoreAppToken;
import com.hengyunsoft.utils.BizAssert;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

/**
 * com.hengyunsoft.platform.developer.api.service.api
 * 版权：中科恒运软件科技股份有限公司贵阳分公司
 * 描述：开发者调用日志记录Api
 * 修改人：sunxiaoya
 * 修改时间：2018/4/17
 * 修改内容：
 */
@Data
@Api(value = "API-ModuleUseJnlApiImpl.java", description = "开发者调用日志记录")
@RestController
@RequestMapping("moduleUse")
@Slf4j
public class ModuleUseJnlApiImpl implements ModuleUseJnlApi {

    @Autowired
    ModuleUseJnlService moduleUseJnlService;

    @Autowired
    DozerUtils dozerUtils;

    /**
     * 描述：开发者调用日志记录Api
     * 参数：[ModuleUseJnlSaveDTO：开发者调用日志记录]
     * 返回值：ModuleUseJnlSaveDTO
     * 修改人：sunxiaoya
     * 修改时间：2018/4/17
     * 修改内容：
     */
    @Override
    @ApiOperation(value = "开发者调用日志记录", notes = "开发者调用日志记录")
    @ApiResponses({
            @ApiResponse(code = 77500, message = "功能统计appId不能为空"),
            @ApiResponse(code = 77501, message = "功能统计moduleId不能为空"),
    })
    @IgnoreAppToken
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public Result<Boolean> save(@RequestBody ModuleUseJnlSaveDTO dto) {

        //1、验证
        BizAssert.assertNotEmpty(DeveloperExceptionCode.FUNCTION_STATISTICS_APP_ID_NULL, dto.getAppId());
        BizAssert.assertNotEmpty(DeveloperExceptionCode.FUNCTION_STATISTICS_MODULE_ID_NULL, dto.getModuleId());

        //2、转换并保存
        moduleUseJnlService.saveLog(dozerUtils.map(dto, ModuleUseInfo.class));

        //4、返回
        return Result.success(true);
    }


    /**
     * 描述：查询开发者调用日志Api
     * 参数：[combineId：查询开发者调用日志]
     * 返回值：List<ModuleUseJnlMsgDTO>
     * 修改人：sunxiaoya
     * 修改时间：2018/4/19
     * 修改内容：
     */
    @Override
    @ApiOperation(value = "查询开发者调用日志", notes = "查询开发者调用日志")
    @ApiResponses({
            @ApiResponse(code = 77502, message = "功能统计开始时间不能为空"),
            @ApiResponse(code = 77503, message = "功能统计结束时间不能为空"),
            @ApiResponse(code = 77504, message = "功能统计时间刻度不能为空"),
    })
    @RequestMapping(value = "/getJnl", method = RequestMethod.POST)
    public Result<List<ModuleUseJnlMsgDTO>> getJnl(@RequestBody ModuleUseJnlDTO dto) {

        //1.获取数据
        String appId = dto.getAppId();
        String moduleId = dto.getModuleId();
        String startTime = dto.getStartTime();
        String endTime = dto.getEndTime();
        String timeScale = dto.getTimeScale();

        //2、验证
        BizAssert.assertNotEmpty(DeveloperExceptionCode.FUNCTION_STATISTICS_START_TIME_NULL, startTime);
        BizAssert.assertNotEmpty(DeveloperExceptionCode.FUNCTION_STATISTICS_END_TIME_NULL, endTime);
        BizAssert.assertNotEmpty(DeveloperExceptionCode.FUNCTION_STATISTICS_TIME_SCALE_NULL, timeScale);

        //3、查询并返回
        return Result.success(dozerUtils.mapList(moduleUseJnlService.getJnl(appId,moduleId,startTime,endTime,timeScale), ModuleUseJnlMsgDTO.class));
    }

    /**
     * 获取模块调用总量
     * @return
     */
    @Override
    @ApiOperation(value = "获取模块调用总量(用于大屏)", notes = "获取模块调用总量(用于大屏)")
    @ApiResponses({

    })
    @RequestMapping(value = "/getSumTotalNum", method = RequestMethod.GET)
    public Result<ModuleUseTotalDTO> getSumTotalNum() {
        ModuleUseSumTotalNumDO sumTotalNum = moduleUseJnlService.getSumTotalNum();
        ModuleUseTotalDTO map = dozerUtils.map(sumTotalNum, ModuleUseTotalDTO.class);
        Result<ModuleUseTotalDTO> result = Result.success(map, "获取模块调用总量成功");
        return  result;
    }

    /**
     * 获取全天模块调用总量
     * @return
     */
    @Override
    @ApiOperation(value = "获取全天模块调用总量(用于大屏)", notes = "获取全天模块调用总量(用于大屏)")
    @ApiResponses({

    })
    @RequestMapping(value = "/findDayData", method = RequestMethod.GET)
    public Result<List<ModuleUseDayDataDTO>> findDayData() {
        List<ModuleUseDayDataDO> dayData = moduleUseJnlService.findDayData();
        List<ModuleUseDayDataDTO> map = dozerUtils.mapList(dayData, ModuleUseDayDataDTO.class);
        Result<List<ModuleUseDayDataDTO>> result = Result.success(map, "数据获取成功");
        return  result;
    }

    /**
     * 获取接口调用排行榜
     * @param
     * @return
     */
    @Override
    @ApiOperation(value = "获取接口调用排行榜", notes = "获取接口调用排行榜")
    @RequestMapping(value = "/getModuleUseRank", method = RequestMethod.GET)
    public Result<List<ModuleUseRankDTO>> getModuleUseRank(){

        //查询并返回
        return Result.success(dozerUtils.mapList(moduleUseJnlService.getModuleUseRank(), ModuleUseRankDTO.class));
    }
}