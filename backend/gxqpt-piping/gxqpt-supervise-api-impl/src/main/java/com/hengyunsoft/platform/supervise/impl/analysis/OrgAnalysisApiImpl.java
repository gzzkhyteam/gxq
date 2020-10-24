package com.hengyunsoft.platform.supervise.impl.analysis;

import com.github.pagehelper.PageInfo;
import com.hengyunsoft.base.Result;
import com.hengyunsoft.commons.exception.core.AuthorityExceptionCode;
import com.hengyunsoft.commons.utils.context.DozerUtils;
import com.hengyunsoft.platform.admin.api.core.api.GxqptDpmApi;
import com.hengyunsoft.platform.admin.api.core.api.GxqptEmpApi;
import com.hengyunsoft.platform.admin.api.core.api.GxqptOrgApi;
import com.hengyunsoft.platform.admin.api.core.dto.dpm.GxqptDpmResDTO;
import com.hengyunsoft.platform.admin.api.core.dto.emp.GxqptEmpByUserNameDTO;
import com.hengyunsoft.platform.admin.api.core.dto.emp.GxqptEmpRetDTO;
import com.hengyunsoft.platform.admin.api.core.dto.org.GxqptOrgResDTO;
import com.hengyunsoft.platform.developer.api.core.api.ApplicationApi;
import com.hengyunsoft.platform.developer.api.core.dto.application.ApplicationAllDTO;
import com.hengyunsoft.platform.supervise.dto.analysis.*;
import com.hengyunsoft.platform.supervise.impl.constant.OrgPublicEnum;
import com.hengyunsoft.platform.supervise.util.*;
import com.hengyunsoft.platform.warn.entity.domain.*;
import com.hengyunsoft.platform.warn.entity.po.GxqptWarn;
import com.hengyunsoft.platform.warn.entity.po.GxqptWarnType;
import com.hengyunsoft.platform.warn.repository.example.GxqptWarnExample;
import com.hengyunsoft.platform.warn.repository.example.GxqptWarnTypeExample;
import com.hengyunsoft.platform.warn.repository.service.GxqptDutyService;
import com.hengyunsoft.platform.warn.repository.service.GxqptWarnService;
import com.hengyunsoft.platform.warn.repository.service.GxqptWarnTypeService;
import com.hengyunsoft.platform.warn.repository.service.WarnScaleStatisticalService;
import com.hengyunsoft.utils.BizAssert;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

import static com.hengyunsoft.platform.supervise.util.OrgUtil.OrgChooseNotNull;

@Api(value = "API - OrgAnalysisApiImpl.java", description = "单位预警统计API")
@RestController
@Slf4j
@RequestMapping("organalysis")
public class OrgAnalysisApiImpl {
    @Autowired
    private GxqptDutyService dutyService;
    @Autowired
    private GxqptWarnService warnService;
    @Autowired
    private DozerUtils dozerUtils;
    @Autowired
    private GxqptWarnTypeService warnTypeService;
    @Autowired
    private WarnScaleStatisticalService warnScaleStatisticalService;
    @Autowired
    private ApplicationApi applicationApi;
    @Autowired
    private GxqptOrgApi orgApi;
    @Autowired
    private GxqptDpmApi dpmApi;
    @Autowired
    private GxqptEmpApi empApi;

    /**
     * 根据单位id集合查询各个单位未处理预警的数量
     *
     * @param surveyReqDTO
     * @return
     */
    @ApiOperation(value = "根据单位id集合查询各个单位未处理预警的数量", notes = "根据单位id集合查询各个单位未处理预警的数量")
    @RequestMapping(value = "/findSurvey", method = RequestMethod.POST)
    public Result<List<PublicSurveyResDTO>> findSurvey(@RequestBody PublicSurveyListReqDTO surveyReqDTO) {

        //2.查询条件
        Map<String, Object> map = OrgChooseNotNull(surveyReqDTO);
        List ids = (List) map.get("ids");
        if (ids == null || ids.size() < 1) {
            return Result.success(new ArrayList<>());
        }
        List<PublicSurveyResDTO> list = dozerUtils.mapList(dutyService.findSurvey(map), PublicSurveyResDTO.class);
        orgNodeTrans(list,(String) map.get(OrgUtil.PARAM_PROPERTY_NAME));
        //3.返回
        return Result.success(list);
    }

    /**
     * 根据机构id集合查询各个机构未处理预警的数量（公用）
     *
     * @param surveyReqDTO
     * @return
     */
    @ApiOperation(value = "根据机构id集合查询各个机构未处理预警的数量（公用）", notes = "根据机构id集合查询各个机构未处理预警的数量（公用）")
    @RequestMapping(value = "/findPublicSuperviseStatus", method = RequestMethod.POST)
    public Result<PublicSuperviseStatusResDTO> findPublicSuperviseStatus(@RequestBody PublicSurveyListReqDTO surveyReqDTO) {
        //1.验证
        BizAssert.assertNotNull(AuthorityExceptionCode.GXQPT_ORG_ID, surveyReqDTO);

        //2.查询条件
        Map<String, Object> map = OrgChooseNotNull(surveyReqDTO);
        List ids = (List) map.get("ids");
        if (ids == null || ids.size() < 1) {
            return Result.success(new PublicSuperviseStatusResDTO());
        }
        List<GxqptPublicSuperviseStatusDO> list = dutyService.findPublicSuperviseStatus(OrgChooseNotNull(surveyReqDTO));

        orgNodeTrans(list,(String) map.get(OrgUtil.PARAM_PROPERTY_NAME));
        //3.筛选转换
        PublicSuperviseStatusResDTO res = new PublicSuperviseStatusResDTO();
        res.setIds(list.stream().map(GxqptPublicSuperviseStatusDO::getId).collect(Collectors.toList()));
        res.setNames(list.stream().map(GxqptPublicSuperviseStatusDO::getName).collect(Collectors.toList()));
        res.setNewThisYears(list.stream().map(GxqptPublicSuperviseStatusDO::getNewThisYear).collect(Collectors.toList()));
        res.setUntreateds(list.stream().map(GxqptPublicSuperviseStatusDO::getUntreated).collect(Collectors.toList()));
        res.setProcesseds(list.stream().map(GxqptPublicSuperviseStatusDO::getProcessed).collect(Collectors.toList()));

        //3.返回
        return Result.success(res);
    }

    /**
     * 公用查询处理时长
     *
     * @param surveyReqDTO
     * @return
     */
    @ApiOperation(value = "公用查询处理时长", notes = "公用查询处理时长")
    @RequestMapping(value = "/findPublicHandle", method = RequestMethod.POST)
    public Result<PublicHandleResDTO> findPublicHandle(@RequestBody PublicSurveyListReqDTO surveyReqDTO) {
        //1.查询条件
        Map<String, Object> map = OrgChooseNotNull(surveyReqDTO);
        List ids = (List) map.get("ids");
        if (ids == null || ids.size() < 1) {
            return Result.success(new PublicHandleResDTO());
        }
        List<GxqptPublicHandleDO> list = dutyService.findPublicHandle(OrgChooseNotNull(surveyReqDTO));
        if (list.isEmpty()){
            return Result.success(new PublicHandleResDTO());
        }
        orgNodeTrans(list,(String) map.get(OrgUtil.PARAM_PROPERTY_NAME));
        //3.筛选转换
        PublicHandleResDTO res = new PublicHandleResDTO();
        res.setIds(list.stream().map(GxqptPublicHandleDO::getId).collect(Collectors.toList()));
        res.setNames(list.stream().map(GxqptPublicHandleDO::getName).collect(Collectors.toList()));
        res.setConfirmedHours(list.stream().map(GxqptPublicHandleDO::getConfirmedHours).collect(Collectors.toList()));
        res.setProcessedHours(list.stream().map(GxqptPublicHandleDO::getProcessedHours).collect(Collectors.toList()));

        //3.返回
        return Result.success(res);
    }

//    /**
//     * 公用查询预警级别
//     *
//     * @param surveyReqDTO
//     * @return
//     */
//    @ApiOperation(value = "公用查询预警级别", notes = "公用查询预警级别")
//    @RequestMapping(value = "/findPublicLevel", method = RequestMethod.POST)
//    public Result<PublicLevelResDTO> findPublicLevel(@RequestBody PublicSurveyListReqDTO surveyReqDTO) {
//        //1.查询条件
//        List ids = (List) OrgChooseNotNull(surveyReqDTO).get("ids");
//        if (ids == null || ids.size() < 1){
//            return Result.success(new PublicLevelResDTO());
//        }
//        List<GxqptPublicLevelDO> list = dutyService.findPublicLevel(OrgChooseNotNull(surveyReqDTO));
//
//        //3.筛选转换
//        PublicLevelResDTO res = new PublicLevelResDTO();
//        res.setCommonly(list.stream().mapToInt(GxqptPublicLevelDO::getCommonly).sum());
//        res.setHeavier(list.stream().mapToInt(GxqptPublicLevelDO::getHeavier).sum());
//        res.setSerious(list.stream().mapToInt(GxqptPublicLevelDO::getSerious).sum());
//        res.setVerySerious(list.stream().mapToInt(GxqptPublicLevelDO::getVerySerious).sum());
//
//        //3.返回
//        return Result.success(res);
//    }

    /**
     * 公用查询对比分析
     *
     * @param surveyReqDTO
     * @return
     */
    @ApiOperation(value = "公用查询对比分析", notes = "公用查询对比分析")
    @RequestMapping(value = "/findPublicContrast", method = RequestMethod.POST)
    public Result<PublicContrastResDTO> findPublicContrast(@RequestBody PublicSurveyReqDTO surveyReqDTO) {
        //1.查询条件
        Map<String, Object> map = OrgChooseNotNull(surveyReqDTO);
        String id = (String) map.get("id");
        if (id == null) {
            return Result.success(new PublicContrastResDTO());
        }
        List<GxqptPublicContrastDO> list = dutyService.findPublicContrast(map);

        //3.筛选转换
        PublicContrastResDTO res = new PublicContrastResDTO();

        //4.设置其他返回参数
        res.setNum(list.stream().map(GxqptPublicContrastDO::getNum).collect(Collectors.toList()));
        res.setAvg(list.stream().map(GxqptPublicContrastDO::getAvg).collect(Collectors.toList()));
        res.setTypeId(list.stream().map(GxqptPublicContrastDO::getTypeId).collect(Collectors.toList()));
        res.setTypeName(list.stream().map(GxqptPublicContrastDO::getTypeName).collect(Collectors.toList()));

        //5.返回
        return Result.success(res);
    }

    /**
     * 公用查询级别对比分析
     *
     * @param surveyReqDTO
     * @return
     */
    @ApiOperation(value = "公用查询级别对比分析", notes = "公用查询级别对比分析")
    @RequestMapping(value = "/findPublicContrastLevel", method = RequestMethod.POST)
    public Result<PublicContrastLevelResDTO> findPublicContrastLevel(@RequestBody PublicSurveyReqDTO surveyReqDTO) {
        //1.查询条件
        List<GxqptPublicContrastLevelDO> list = dutyService.findPublicContrastLevel(OrgChooseNotNull(surveyReqDTO),Arrays.asList(1,2,3,4));

        //3.筛选转换
        PublicContrastLevelResDTO res = new PublicContrastLevelResDTO();

        //4.设置其他返回参数
        res.setNum(list.stream().map(GxqptPublicContrastLevelDO::getNum).collect(Collectors.toList()));
        res.setAvg(list.stream().map(GxqptPublicContrastLevelDO::getAvg).collect(Collectors.toList()));
        res.setLevel(list.stream().map(obj -> {
            switch (obj.getLevel()) {
                case "1":
                    return "一般预警";
                case "2":
                    return "较重预警";
                case "3":
                    return "严重预警";
                case "4":
                    return "非常严重";
            }
            return obj.getLevel();
        }).collect(Collectors.toList()));

        //5.返回
        return Result.success(res);
    }

    /**
     * 获取单位预警类别列表
     *
     * @param surveyReqDTO
     * @return
     */
    @ApiOperation(value = "获取各单位预警类别列表", notes = "获取各单位预警类别列表")
    @RequestMapping(value = "/findTypeList", method = RequestMethod.POST)
    @ApiResponses({
            @ApiResponse(code = 56007, message = "单位不能为空"),
    })
    public Result<List<OrgSurveyBackResDTO>> getOrgWarnTypes(@RequestBody SurveyRecDTO surveyRecDTO) {
        //1.验证
        List<String> orgIds = surveyRecDTO.getIds();
        BizAssert.assertNotNull(AuthorityExceptionCode.GXQPT_ORG_NULL, orgIds);
        if (orgIds.size() == 0) {
            return null;
        }
        try {
            //预警id筛选start
            GxqptWarnTypeExample gxqptWarnTypeExample = new GxqptWarnTypeExample();
            gxqptWarnTypeExample.createCriteria();
            List<GxqptWarnType> gxqptWarnTypeList = warnTypeService.find(gxqptWarnTypeExample);

            GxqptWarnTypeExample gxqptWarnTypeExample1 = new GxqptWarnTypeExample();
            gxqptWarnTypeExample1.createCriteria().andTypeNameEqualTo("应用预警");
            List<GxqptWarnType> gxqptWarnType = warnTypeService.find(gxqptWarnTypeExample1);
            if (gxqptWarnType != null && gxqptWarnType.size() != 0) {
                List<GxqptWarnType> apps = Utils.selectTrees(gxqptWarnType, gxqptWarnTypeList);
                gxqptWarnTypeList.removeAll(apps);
                gxqptWarnTypeList.removeAll(gxqptWarnType);
            }
            Set<Long> ids = new HashSet<Long>();
            for (GxqptWarnType warnType : gxqptWarnTypeList) {
                if (warnType != null && warnType.getId() != null) {
                    ids.add(warnType.getId());
                }
            }
            //预警id筛选end
            //查询
            SurveyReqDTO surveyReqDTO = new SurveyReqDTO();
            String year = surveyRecDTO.getYear();
            if (!StringUtils.isEmpty(year)) {
                int yearNum = Integer.parseInt(year);
                year = year + "-01-01 00:00:00";
                Date date = DateUtil.stringToDate(year);
                surveyReqDTO.setStartTime(date);
                String endTime = (yearNum + 1) + "-01-01 00:00:00";
                Date endDate = DateUtil.stringToDate(endTime);
                surveyReqDTO.setEndTime(endDate);
            }
            surveyReqDTO.setIds(orgIds);
            surveyReqDTO.setTypeIds(ids);
            List<OrgSurveyBackResDTO> result = new ArrayList<OrgSurveyBackResDTO>();
            List<WarnTypesResDTO> list = dutyService.getOrgartmentWarnTypes(surveyReqDTO);
            for (String id : orgIds) {
                OrgSurveyBackResDTO orgWarnTypesDTO = new OrgSurveyBackResDTO();
                Map<String, Object> count = new HashMap<String, Object>();
                String name = "";
                String typeId = "";
                for (WarnTypesResDTO warnTypesResDTO : list) {
                    String orgId = warnTypesResDTO.getId();
                    if (StringUtils.isEmpty(orgId)) {
                        continue;
                    }
                    if (orgId.equals(id)) {
                        name = warnTypesResDTO.getName();
                        typeId = warnTypesResDTO.getId();
                        count.put(warnTypesResDTO.getType(), warnTypesResDTO.getCount());
                    }
                }
                if (!StringUtils.isEmpty(name) && !StringUtils.isEmpty(typeId)) {
                    orgWarnTypesDTO.setName(name);
                    orgWarnTypesDTO.setId(typeId);
                    orgWarnTypesDTO.setCount(count);
                    result.add(orgWarnTypesDTO);
                }
            }
            //同步权限管理系统单位名称
            if(result!=null&&result.size()!=0){
            	orgNodeTrans(result);
            }
            return Result.success(result);
        } catch (Exception e) {
            log.error("获取各单位预警类别列表出错" + e);
            return Result.fail("获取各单位预警类别列表出错");
        }
    }

    /**
     * 获取各单位预警级别列表
     *
     * @return
     */
    @ApiOperation(value = "获取各单位预警级别列表", notes = "获取各单位预警级别列表")
    @RequestMapping(value = "/fildLevelList", method = RequestMethod.POST)
    @ApiResponses({
            @ApiResponse(code = 56007, message = "单位不能为空"),
    })
    public Result<List<WarnLevelBackDTO>> getOrgartmentWarnLevels(@RequestBody SurveyRecDTO surveyRecDTO) {
        //1.验证
        List<String> ids = surveyRecDTO.getIds();
        BizAssert.assertNotNull(AuthorityExceptionCode.GXQPT_ORG_NULL, ids);
        if (ids.size() == 0) {
            return null;
        }
        try {
            SurveyReqDTO surveyReqDTO = new SurveyReqDTO();
            String year = surveyRecDTO.getYear();
            if (!StringUtils.isEmpty(year)) {
                int yearNum = Integer.parseInt(year);
                year = year + "-01-01 00:00:00";
                Date date = DateUtil.stringToDate(year);
                surveyReqDTO.setStartTime(date);
                String endTime = (yearNum + 1) + "-01-01 00:00:00";
                Date endDate = DateUtil.stringToDate(endTime);
                surveyReqDTO.setEndTime(endDate);
            }
            surveyReqDTO.setIds(ids);
            List<WarnLevelResDTO> list = dutyService.getOrgartmentWarnLevels(surveyReqDTO);
            List<WarnLevelBackDTO> result = new ArrayList<WarnLevelBackDTO>();
            for (String id:ids) {
                WarnLevelBackDTO warnLevelBackDTO = new WarnLevelBackDTO();
                Map<String, Object> count = new HashMap<String, Object>();
                String name = "";
                for (WarnLevelResDTO warnLevelResDTO : list) {
                    String orgId = warnLevelResDTO.getId();
                    if (StringUtils.isEmpty(orgId)) {
                        continue;
                    }
                    if (orgId.equals(id)) {
                        name = warnLevelResDTO.getName();
                        count.put(String.valueOf(warnLevelResDTO.getLevel()), warnLevelResDTO.getCount());
                    }
                }
                if (!StringUtils.isEmpty(name)) {
                    warnLevelBackDTO.setName(name);
                    warnLevelBackDTO.setCount(count);
                    warnLevelBackDTO.setId(id);
                    result.add(warnLevelBackDTO);
                }
            }
            if(result!=null&&result.size()!=0){
            	orgNodeTransLevel(result);
            }
            return Result.success(result);
        } catch (Exception e) {
            log.error("获取各单位预警级别列表出错" + e);
            return Result.fail("获取各单位预警级别列表出错");
        }
    }

    /**
     * 单个单位预警类型统计分析
     *
     * @param surveyReqDTO
     * @return
     */
    @ApiOperation(value = "单个单位预警类型统计分析", notes = "单个单位预警类型统计分析")
    @RequestMapping(value = "/warntype", method = RequestMethod.POST)
    @ApiResponses({
            @ApiResponse(code = 56008, message = "单位id不能为空"),
    })
    public Result<List<WarnTypeResDTO>> getWarnTypes(@RequestBody WarnTypeReqDTO warnTypeReqDTO) {
        //1.验证
        BizAssert.assertNotNull(AuthorityExceptionCode.GXQPT_ORG_ID, warnTypeReqDTO.getId());
        if (warnTypeReqDTO.getId() == null || "".equals(warnTypeReqDTO.getId())) {
            return null;
        }
        try {
            OrgWarnCheckDTO orgWarnCheckDTO = new OrgWarnCheckDTO();
            String year = warnTypeReqDTO.getYear();
            if (!StringUtils.isEmpty(year)) {
                DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                int yearNum = Integer.parseInt(year);
                year = year + "-01-01 00:00:00";
                Date date = format.parse(year);
                orgWarnCheckDTO.setStartTime(date);
                String endTime = (yearNum + 1) + "-01-01 00:00:00";
                Date endDate = format.parse(endTime);
                orgWarnCheckDTO.setEndTime(endDate);
            }
            orgWarnCheckDTO.setOrgId(warnTypeReqDTO.getId());
            List<WarnTypeResDTO> list = dutyService.getOrgWarnTypes(orgWarnCheckDTO);
            return Result.success(list);
        } catch (Exception e) {
            log.error("单个单位预警类型统计分析出错" + e);
            return Result.fail("单个单位预警类型统计分析出错");
        }
    }

    /**
     * 单个单位预警级别统计分析
     *
     * @param surveyReqDTO
     * @return
     */
    @ApiOperation(value = "单个单位预警级别统计分析", notes = "单个单位预警级别统计分析")
    @RequestMapping(value = "/warnlevel", method = RequestMethod.POST)
    @ApiResponses({
            @ApiResponse(code = 56008, message = "单位id不能为空"),
    })
    public Result<List<WarnLevelResDTO>> getWarnLevels(@RequestBody WarnTypeReqDTO OrgWarnTypeReqDTO) {
        //1.验证
        BizAssert.assertNotNull(AuthorityExceptionCode.GXQPT_ORG_ID, OrgWarnTypeReqDTO.getId());
        if (OrgWarnTypeReqDTO.getId() == null || "".equals(OrgWarnTypeReqDTO.getId())) {
            return null;
        }
        try {
            OrgWarnCheckDTO orgWarnCheckDTO = new OrgWarnCheckDTO();
            String year = OrgWarnTypeReqDTO.getYear();
            if (!StringUtils.isEmpty(year)) {
                int yearNum = Integer.parseInt(year);
                year = year + "-01-01 00:00:00";
                Date date = DateUtil.stringToDate(year);
                orgWarnCheckDTO.setStartTime(date);
                String endTime = (yearNum + 1) + "-01-01 00:00:00";
                Date endDate = DateUtil.stringToDate(endTime);
                orgWarnCheckDTO.setEndTime(endDate);
            }
            orgWarnCheckDTO.setOrgId(OrgWarnTypeReqDTO.getId());
            List<WarnLevelResDTO> list = dutyService.getOrgWarnLevels(orgWarnCheckDTO);
            return Result.success(list);
        } catch (Exception e) {
            log.error("单个单位预警级别统计分析出错" + e);
            return Result.fail("单个单位预警级别统计分析出错");
        }
    }

    /**
     * 人员预警产生、处理情况
     *
     * @param surveyReqDTO
     * @return
     */
    @ApiOperation(value = "单位预警产生、处理情况", notes = "单位预警产生、处理情况")
    @RequestMapping(value = "/warnHandleStatistical", method = RequestMethod.GET)
    @ApiResponses({
            @ApiResponse(code = 56008, message = "单位id不能为空"),
    })
    public Result<List<WarnScaleCountDTO>> getWarnProvHandle(@RequestParam(value = "id") String id,
                                                             @RequestParam(value = "year") String year) {
        BizAssert.assertNotNull(AuthorityExceptionCode.GXQPT_ORG_ID, id);
        if (id == null || "".equals(id)) {
            return null;
        }
        try {
            ScaleReqDTO scaleReqDTO = new ScaleReqDTO();
            if (!StringUtils.isEmpty(year)) {
                int date = Integer.valueOf(year);
                String startMonth = (date - 1) + "12";
                String endMonth = (date + 1) + "01";
                scaleReqDTO.setStartMonth(startMonth);
                scaleReqDTO.setEndMonth(endMonth);
                scaleReqDTO.setYear(year);
            }
            scaleReqDTO.setId(id);
            List<WarnScaleCountDTO> list = warnScaleStatisticalService.getScaleByOrgId(scaleReqDTO);
            return Result.success(list);
        } catch (Exception e) {
            log.error("单位预警产生、处理情况出错" + e);
            return Result.fail("单位预警产生、处理情况出错");
        }
    }

    /**
     * 关联规则挖掘
     *
     * @param surveyReqDTO
     * @return
     */
    @ApiOperation(value = "关联规则挖掘", notes = "关联规则挖掘")
    @RequestMapping(value = "/findAssociationRules", method = RequestMethod.POST)
    public Result<List<AppRulesResDTO>> findAssociationRules(@RequestBody PublicSurveyListReqDTO surveyReqDTO) {
        //获取数据集合
        List ids = (List) OrgChooseNotNull(surveyReqDTO).get("ids");
        if (ids == null || ids.size() < 1) {
            return Result.success(new ArrayList<>());
        }
        List<GxqptPublicRulesDO> list = dutyService.findAssociationRules(OrgChooseNotNull(surveyReqDTO));
        list = list.stream().filter(obj -> obj.getProcessed() != null && obj.getConfirmed() != null).collect(Collectors.toList());

        //获取一个双list集合,内层list表示(每一行数据:应用+产生类型+确认时间+处理时间)
        List<List<String>> targetList = list.stream().map(obj -> {
            List<String> mlist = Arrays.asList(obj.getTarget()
                    .split(","));
            List<String> rList = new ArrayList(mlist);
            rList.add(obj.getSource());
            rList.add(handleConfirmedTime(obj));
            rList.add(handleProcessTime(obj));
            return rList;
        }).collect(Collectors.toList());

        //获取record的矩阵集合
        List<List<String>> result = roleResultInit(list, targetList);

        //查询并返回
        List<AppRulesResDTO> res = AproriUtil.findAssociationRules(result);
        Collections.sort(res, new Comparator<AppRulesResDTO>() {
            @Override
            public int compare(AppRulesResDTO o1, AppRulesResDTO o2) {

                if (!o2.getSupportDegree().equals(o1.getSupportDegree())) {
                    return o2.getSupportDegree().compareTo(o1.getSupportDegree());
                }
                return o2.getConfidenceDegree().compareTo(o1.getConfidenceDegree());
            }
        });
        if (res.size() > 20)

        {
            return Result.success(res.subList(0, 20));
        }
        return Result.success(res);
    }

    /**
     * 关联规则挖掘(子)
     *
     * @param surveyReqDTO
     * @return
     */
    @ApiOperation(value = "关联规则挖掘(子)", notes = "关联规则挖掘(子)")
    @RequestMapping(value = "/findAssociationChildRules", method = RequestMethod.POST)
    public Result<List<AppRulesResDTO>> findAssociationChildRules(@RequestBody PublicSurveyReqDTO surveyReqDTO) {
        //获取数据集合
        List<GxqptPublicRulesDO> list = dutyService.findAssociationChildRules(OrgChooseNotNull(surveyReqDTO));
        list = list.stream().filter(obj -> obj.getProcessed() != null && obj.getConfirmed() != null).collect(Collectors.toList());

        //获取一个双list集合,内层list表示(每一行数据:应用+产生类型+确认时间+处理时间)
        List<List<String>> targetList = list.stream().map(obj -> {
            List<String> mlist = Arrays.asList(obj.getTarget()
                    .split(","));
            List<String> rList = new ArrayList(mlist);
            rList.add(handleConfirmedTime(obj));
            rList.add(handleProcessTime(obj));
            return rList;
        }).collect(Collectors.toList());

        //获取record的矩阵集合
        List<List<String>> result = roleResultInit(list, targetList);

        //查询并返回
        List<AppRulesResDTO> res = AproriUtil.findAssociationRules(result);
        Collections.sort(res, new Comparator<AppRulesResDTO>() {
            @Override
            public int compare(AppRulesResDTO o1, AppRulesResDTO o2) {

                if (!o2.getSupportDegree().equals(o1.getSupportDegree())) {
                    return o2.getSupportDegree().compareTo(o1.getSupportDegree());
                }
                return o2.getConfidenceDegree().compareTo(o1.getConfidenceDegree());
            }
        });
        if (res.size() > 20) {
            return Result.success(res.subList(0, 20));
        }
        return Result.success(res);
    }

    /**
     * 根据机构id集合查询各个机构未处理预警的数量（公用）
     *
     * @return
     */
    @ApiOperation(value = "根据机构id集合查询各个机构未处理预警的数量（公用）", notes = "根据机构id集合查询各个机构未处理预警的数量（公用）")
    @RequestMapping(value = "/findKeyword", method = RequestMethod.GET)
    public Result<List<Map<String, Object>>> findKeyword() {
        //1.查询条件
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Calendar c = Calendar.getInstance();
        c.setTime(new Date());
        c.add(Calendar.YEAR, -1);
        GxqptWarnExample example = new GxqptWarnExample();
        example.createCriteria().andWarntimeBetween(c.getTime(), new Date());

        //2.查询并获取内容
        List<GxqptWarn> list = warnService.find(example);
        List<String> strs = list.stream().map(GxqptWarn::getContent).collect(Collectors.toList());
        StringBuffer sb = new StringBuffer();
        for (String str : strs) {
            sb.append(str);
        }
        //3.返回
        return Result.success(TokenizerUtil.getSegWords(sb.toString()));
    }

    /**
     * 查询TOP10关键内容
     *
     * @return
     */
    @ApiOperation(value = "查询TOP10关键内容", notes = "查询TOP10关键内容")
    @RequestMapping(value = "/findContentTop", method = RequestMethod.POST)
    public Result<List<AppPublicTopContentDTO>> findContentTop(@RequestBody PublicSurveyListReqDTO surveyReqDTO) {

        /**
         * @modify mdengb
         *  2019-05-06  需求更改
         *  显示  应用名称   数据来源为各应用产生的预警数据
         *  按照预警严重程度累加显示预警值   一般预警 1分   较重预警2分  严重预警3分  特别严重预警4分
         *  按分类累加应用预警值  图形名称改为 【应用预警值分析】
         * */
        List<GxqptPublicTopContentDO> contentTop = warnService.findContentTenTop(surveyReqDTO);


        return Result.success(dozerUtils.mapList(contentTop, AppPublicTopContentDTO.class));
    }

    /**
     * 处理速度转义
     *
     * @param obj
     * @return
     */
    private String handleProcessTime(GxqptPublicRulesDO obj) {
        if (obj.getProcessed() > 0 && obj.getProcessed() <= 0.5) {
            return "处理速度:快";
        } else if (obj.getProcessed() > 0.5 && obj.getProcessed() <= 1) {
            return "处理速度:较快";
        } else if (obj.getProcessed() > 1 && obj.getProcessed() <= 1.5) {
            return "处理速度:一般";
        } else if (obj.getProcessed() > 1.5) {
            return "处理速度:慢";
        } else {
            return "处理速度:快";
        }
    }

    private List<List<String>> roleResultInit(List list, List<List<String>> targetList) {
        //1.去重复元素(独立性比较元素)
        List<String> merge = targetList.stream()
                .filter(item -> item != null)
                .reduce(new ArrayList<>(), (all, item) -> {
                    all.addAll(item);
                    return all;
                });
        Set targetResult = new HashSet(merge);

        //2.为头信息初始化
        List<List<String>> result = new ArrayList<>();
        result.add(new ArrayList());
        result.get(0).add("TID");
        result.get(0).addAll(targetResult);

        //3.为非头信息初始化
        for (int i = 0; i < list.size(); i++) {
            result.add(new ArrayList<>());
            result.get(i + 1).add(String.valueOf(i));
            result.get(i + 1).addAll(targetList.get(i));
        }
        return result;
    }

    /**
     * 确定速度转义
     *
     * @param obj
     * @return
     */
    private String handleConfirmedTime(GxqptPublicRulesDO obj) {
        if (obj.getConfirmed() > 0 && obj.getConfirmed() <= 0.5) {
            return "确定速度:快";
        } else if (obj.getConfirmed() > 0.5 && obj.getConfirmed() <= 1) {
            return "确定速度:较快";
        } else if (obj.getConfirmed() > 1 && obj.getConfirmed() <= 1.5) {
            return "确定速度:一般";
        } else if (obj.getConfirmed() > 1.5) {
            return "确定速度:慢";
        } else {
            return "确定速度:快";
        }
    }

    /**
     * 同步权限系统单位名称
     * @param list
     */
    private <T extends OrgSurveyBackResDTO> void orgNodeTrans(List<T> list){
    	List<String> ids = list.stream().map(OrgSurveyBackResDTO::getId).collect(Collectors.toList());
        List<GxqptOrgResDTO> orgDate = orgApi.findOrgNameByIds(ids).getData();
        orgDate.forEach(obj ->{
            if (ids.indexOf(obj.getId())!=-1){
                list.get(ids.indexOf(obj.getId())).setName(obj.getName());
            }
        });
    }
    /**
     * 同步权限系统单位名称(级别)
     * @param list
     */
    private <T extends WarnLevelBackDTO> void orgNodeTransLevel(List<T> list){
    	List<String> ids = list.stream().map(WarnLevelBackDTO::getId).collect(Collectors.toList());
        List<GxqptOrgResDTO> orgDate = orgApi.findOrgNameByIds(ids).getData();
        orgDate.forEach(obj ->{
            if (ids.indexOf(obj.getId())!=-1){
                list.get(ids.indexOf(obj.getId())).setName(obj.getName());
            }
        });
    }
    /**
     * 同步权限系统的组织机构name
     * @param list
     * @param orgPublicEnumStr
     * @param <T>
     */
    private <T extends GxqptPublicOrgNodeDTO> void orgNodeTrans(List<T> list, String orgPublicEnumStr) {
        if (list != null && list.size() > 0) {
            List<String> ids = list.stream().map(GxqptPublicOrgNodeDTO::getId).collect(Collectors.toList());
            switch (OrgPublicEnum.getEnum(orgPublicEnumStr)) {
                case ORG:
                    List<GxqptOrgResDTO> orgDate = orgApi.findOrgNameByIds(ids).getData();
                    orgDate.forEach(obj ->{
                        if (ids.indexOf(obj.getId())!=-1){
                            list.get(ids.indexOf(obj.getId())).setName(obj.getName());
                        }
                    });
                    break;
                case DPM:
                    List<GxqptDpmResDTO> dpmDate = dpmApi.findDpmNameByIds(ids).getData();
                    dpmDate.forEach(obj ->{
                        if (ids.indexOf(obj.getId())!=-1){
                            list.get(ids.indexOf(obj.getId())).setName(obj.getName());
                        }
                    });
                    break;
                case EMP:
                    GxqptEmpByUserNameDTO dto = new GxqptEmpByUserNameDTO();
                    dto.setUserIds(ids);
                    dto.setPageNo(1);
                    dto.setPageSize(ids.size());
                    PageInfo<GxqptEmpRetDTO> data = empApi.findEmpByUserIds(dto).getData();
                    if (data != null && data.getList()!=null){
                        List<GxqptEmpRetDTO> empDate = data.getList();
                        empDate.forEach(obj ->{
                            if (ids.indexOf(obj.getId())!=-1){
                                list.get(ids.indexOf(obj.getId())).setName(obj.getName());
                            }
                        });
                    }
                case APP:
                    List<ApplicationAllDTO> appDate = applicationApi.findAllList().getData();
                    appDate.forEach(obj ->{
                        if (ids.indexOf(obj.getAppId())!=-1){
                            list.get(ids.indexOf(obj.getAppId())).setName(obj.getName());
                        }
                    });
                    break;
            }
        }
    }
}
