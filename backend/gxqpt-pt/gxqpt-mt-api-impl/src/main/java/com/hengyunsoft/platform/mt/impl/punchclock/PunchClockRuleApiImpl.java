package com.hengyunsoft.platform.mt.impl.punchclock;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hengyunsoft.base.Result;
import com.hengyunsoft.commons.context.BaseContextHandler;
import com.hengyunsoft.commons.exception.core.MtExceptionCode;
import com.hengyunsoft.commons.utils.context.DozerUtils;
import com.hengyunsoft.platform.mt.api.file.dto.FileDTO;
import com.hengyunsoft.platform.mt.api.punchclock.dto.rule.CreatePunchClockRuleDTO;
import com.hengyunsoft.platform.mt.api.punchclock.dto.rule.PunchClockRuleDTO;
import com.hengyunsoft.platform.mt.entity.file.po.File;
import com.hengyunsoft.platform.mt.entity.punchclock.po.PunchClockRule;
import com.hengyunsoft.platform.mt.entity.userconfig.po.UserConfig;
import com.hengyunsoft.platform.mt.impl.userconfig.UserConfigJobType;
import com.hengyunsoft.platform.mt.repository.file.example.FileExample;
import com.hengyunsoft.platform.mt.repository.file.service.FileService;
import com.hengyunsoft.platform.mt.repository.punchclock.service.PunchClockRuleService;
import com.hengyunsoft.platform.mt.repository.userconfig.service.UserConfigService;
import com.hengyunsoft.utils.BizAssert;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * com.hengyunsoft.platform.mt.impl.punchclock
 * 版权：中科恒运软件科技股份有限公司贵阳分公司
 * 描述：考勤规则
 * 修改人：gbl
 * 修改时间：2018/7/4
 * 修改内容：新增基础接口
 */
@Api(value = "API - PunchClockRuleApiImpl.java", description = "考勤规则")
@RestController
@RequestMapping("punchClock")
@Slf4j
public class PunchClockRuleApiImpl /*implements PunchClockRuleApi*/ {
    @Autowired
    private DozerUtils dozerUtils;
    @Autowired
    private PunchClockRuleService punchClockRuleService;
    @Autowired
    private UserConfigService userConfigService;
    @Autowired
    private FileService fileService;

    /**
     * 描述：创建规则
     * 参数：[dto]
     * 返回值：com.hengyunsoft.base.Result<java.lang.Boolean>
     * 修改人：gbl
     * 修改时间：2018/7/4
     * 修改内容：
     */
    @RequestMapping(value = "crateePunchClockRule", method = RequestMethod.POST)
    @ApiOperation(value = "创建规则", notes = "创建规则")
    @ApiResponses({
            @ApiResponse(code = 93000, message = "创建规则，不能为空"),
            @ApiResponse(code = 93001, message = "签到时间，不能为空"),
            @ApiResponse(code = 93002, message = "签退时间，不能为空"),
            @ApiResponse(code = 93003, message = "午休开始时间，不能为空"),
            @ApiResponse(code = 93004, message = "午休结束时间，不能为空"),
            @ApiResponse(code = 93005, message = " 签到距离范围(米)，不能为空"),
            @ApiResponse(code = 93006, message = "经度，不能为空"),
            @ApiResponse(code = 93007, message = "纬度，不能为空"),
            @ApiResponse(code = 93008, message = "打卡地点，不能为空"),
            @ApiResponse(code = 92501, message = "没有设置主单位"),
    })
    
    public Result<Boolean> saveCrateePunchClockRule(@RequestBody CreatePunchClockRuleDTO dto) {
        BizAssert.assertNotNull(MtExceptionCode.CRATEEPUNCHCLOCKRULE_CREATEPUNCHCLOCKRULEDTO, dto);
        BizAssert.assertNotEmpty(MtExceptionCode.CRATEEPUNCHCLOCKRULE_CREATEPUNCHCLOCKRULEDTO_INTIME, dto.getInTime());
        BizAssert.assertNotEmpty(MtExceptionCode.CRATEEPUNCHCLOCKRULE_CREATEPUNCHCLOCKRULEDTO_OUTTIME, dto.getOutTime());
        BizAssert.assertNotEmpty(MtExceptionCode.CRATEEPUNCHCLOCKRULE_CREATEPUNCHCLOCKRULEDTO_STARTTIME, dto.getStartTime());
        BizAssert.assertNotEmpty(MtExceptionCode.CRATEEPUNCHCLOCKRULE_CREATEPUNCHCLOCKRULEDTO_ENDTIME, dto.getEndTime());
        BizAssert.assertNotNull(MtExceptionCode.CRATEEPUNCHCLOCKRULE_CREATEPUNCHCLOCKRULEDTO_DISTANCERANGE, dto.getDistanceRange());
        BizAssert.assertNotEmpty(MtExceptionCode.CRATEEPUNCHCLOCKRULE_CREATEPUNCHCLOCKRULEDTO_LNG, dto.getLng());
        BizAssert.assertNotEmpty(MtExceptionCode.CRATEEPUNCHCLOCKRULE_CREATEPUNCHCLOCKRULEDTO_LAT, dto.getLat());
        BizAssert.assertNotEmpty(MtExceptionCode.CRATEEPUNCHCLOCKRULE_CREATEPUNCHCLOCKRULEDTO_LOCATION, dto.getLocation());

        Long adminId = BaseContextHandler.getAdminId();
        String unityId = getUnityId();
        if (unityId == null) {
            return Result.fail(MtExceptionCode.NOT_SET_MAIN_UNITY_ID);
        }
        PunchClockRule punchClockRule = dozerUtils.map(dto, PunchClockRule.class);
        punchClockRule.setUnitId(unityId);
        if (punchClockRule.getId() == null) {
            punchClockRule.setCreateUser(adminId);
            punchClockRuleService.saveSelective(punchClockRule);
        } else {
            punchClockRule.setUpdateUser(adminId);
            punchClockRuleService.updateByIdSelective(punchClockRule);
        }
        //图片
        if (dto.getFileList() != null && dto.getFileList().size() > 0) {
            List<File> files = dozerUtils.mapList(dto.getFileList(), File.class);
            FileExample allExample = new FileExample();
            allExample.createCriteria().andTableIdEqualTo(punchClockRule.getId());
            List<File> allFiles = fileService.find(allExample);
            Map<Long, File> allFileMap = new HashMap<>();
            for (File f : allFiles) {
                allFileMap.put(f.getFileId(), f);
            }
            for (File f : files) {
                File old = allFileMap.remove(f.getFileId());
                f.setTableId(punchClockRule.getId());
                f.setCreateUser(adminId);
                if (old == null) {
                    fileService.save(f);
                } else {
                    f.setId(old.getId());
                    fileService.updateById(f);
                }
            }
            for (File f : allFileMap.values()) {
                fileService.deleteById(f.getId());
            }
        }

        return Result.success(true);
    }

    /**
     * 描述：获取用户单位的考勤配置
     * 参数：
     * 返回值：
     * 修改人：gbl
     * 修改时间：2018/7/4
     * 修改内容：
     */
    
    @RequestMapping(value = "getMyUnityPunchClockRule", method = RequestMethod.GET)
    @ApiOperation(value = "获取用户单位的考勤配置", notes = "获取用户单位的考勤配置")
    @ApiResponses({
            @ApiResponse(code = 92501, message = "没有设置主单位"),
            @ApiResponse(code = 93021, message = "该单位没有创建考勤规则"),
    })
    public Result<PunchClockRuleDTO> getMyUnityPunchClockRule() {
        String unityId = getUnityId();
        if (unityId == null) {
            return Result.fail(MtExceptionCode.NOT_SET_MAIN_UNITY_ID);
        }
        PunchClockRule punchClockRule = punchClockRuleService.getPunchClockRuleByUnityid(unityId);
        if (punchClockRule == null) {
            return Result.fail(MtExceptionCode.UNIOTY_HAS_ATEPUNCHCLOCK_ROLE);
        }
        PunchClockRuleDTO dto = dozerUtils.map(punchClockRule, PunchClockRuleDTO.class);

        //附件
        FileExample fileExample = new FileExample();
        FileExample.Criteria fileCriteria = fileExample.createCriteria();
        fileCriteria.andTableIdEqualTo(punchClockRule.getId());
        List<File> files = fileService.find(fileExample);
        List<FileDTO> filesDto = dozerUtils.mapList(files, FileDTO.class);
        dto.setFileList(filesDto);

        return Result.success(dto);
    }

    /**
     * 得到单位id
     *
     * @return
     */
    public String getUnityId() {
        Long adminId = BaseContextHandler.getAdminId();
        UserConfig userConfig = userConfigService.getUserConfigByidAndType(adminId, UserConfigJobType.now_unity_id.jobId);
        if (userConfig == null) {
            return "-1";
        }
        return userConfig.getJobValue();
    }
}
