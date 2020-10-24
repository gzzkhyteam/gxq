package com.hengyunsoft.platform.warn.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hengyunsoft.base.Result;
import com.hengyunsoft.commons.context.BaseContextHandler;
import com.hengyunsoft.commons.servicemodule.annotation.WarnSendModule;
import com.hengyunsoft.commons.utils.context.DozerUtils;
import com.hengyunsoft.page.plugins.openapi.OpenApiReq;
import com.hengyunsoft.platform.admin.api.core.api.GxqptEmpApi;
import com.hengyunsoft.platform.admin.api.core.dto.emp.GxqptEmpByUserNameDTO;
import com.hengyunsoft.platform.admin.api.core.dto.emp.GxqptEmpRetDTO;
import com.hengyunsoft.platform.warn.api.warn.dto.*;
import com.hengyunsoft.platform.warn.constant.GetUserInfo;
import com.hengyunsoft.platform.warn.entity.domain.*;
import com.hengyunsoft.platform.warn.entity.po.GxqptSendee;
import com.hengyunsoft.platform.warn.repository.service.GxqptDutyService;
import com.hengyunsoft.platform.warn.repository.service.GxqptSendeeService;
import com.hengyunsoft.platform.warn.repository.service.GxqptWarnService;
import com.hengyunsoft.platform.warn.repository.service.WarnTimeSlotService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.Map.Entry;
import java.util.stream.Collectors;

import static com.google.common.primitives.Ints.asList;
import static java.util.Comparator.comparingInt;

@Api(value = "预警信息统计", description = "预警信息统计")
@Slf4j
@RestController
@WarnSendModule
public class WarnCountApiImpl {

	@Autowired
	private GxqptDutyService gxqptDutyService;
    @Autowired
    private DozerUtils dozerUtils;
	@Autowired
	private GxqptWarnService gxqptWarnService;

	@Autowired
	private WarnTimeSlotService warnTimeSlotService;

    @Autowired
	private GxqptSendeeService sendeeService;

    @Autowired
    private GxqptEmpApi gxqptEmpApi;

	/**
	 * 根据部门统计个人发布预警情况
	 */
	@ApiOperation(value="根据部门统计个人发布预警情况",notes = "根据部门统计个人发布预警情况")
	@RequestMapping(value = "/warncount/personal", method = RequestMethod.POST)
	public Result<PageInfo<WarnPersonalCountDTO>> getPersonalByDepartment(@RequestBody OpenApiReq<WarnParamDTO> openApiReq) {		
		try {			
			WarnParamDTO warnParamDTO = openApiReq.getData();
			if(warnParamDTO!=null){
				WarnParamDO warnParamDO = dozerUtils.map(warnParamDTO, WarnParamDO.class);
				PageHelper.startPage(openApiReq.getPageNo(), openApiReq.getPageSize());
				List<WarnPersonalCountDO> list = gxqptDutyService.getCountByDepartment(warnParamDO);
				List<WarnPersonalCountDTO> result = dozerUtils.mapList(list, WarnPersonalCountDTO.class);
		        return Result.success(new PageInfo<>(result));
			}else{
				return Result.fail("统计失败");
			}
		} catch (Exception e) {
			log.error("根据部门统计个人发布预警情况出错："+e);
			return Result.fail("根据部门统计个人发布预警情况出错");
		}
	}

	/**
	 * 根据单位统计部门发布预警情况
	 */
	@ApiOperation(value="根据单位统计部门发布预警情况",notes = "根据单位统计部门发布预警情况")
	@RequestMapping(value = "/warncount/department", method = RequestMethod.POST)
	public Result<PageInfo<WarnDepartmentCountDTO>> getDepartmentByCompany(@RequestBody OpenApiReq<WarnParamDTO> openApiReq) {
		try {			
			WarnParamDTO warnParamDTO = openApiReq.getData();
			if(warnParamDTO!=null){
				WarnParamDO warnParamDO = dozerUtils.map(warnParamDTO, WarnParamDO.class);
				PageHelper.startPage(openApiReq.getPageNo(), openApiReq.getPageSize());
				List<WarnDepartmentCountDO> list = gxqptDutyService.getDepartmentByCompany(warnParamDO);
				List<WarnDepartmentCountDTO> result = dozerUtils.mapList(list, WarnDepartmentCountDTO.class);
		        return Result.success(new PageInfo<>(result));
			}else{
				return Result.fail("统计失败");
			}
		} catch (Exception e) {
			log.error("根据单位统计部门发布预警情况出错："+e);
			return Result.fail("根据单位统计部门发布预警情况出错");
		}
	}

	/**
	 * 根据应用程序统计发布预警情况
	 */
	@ApiOperation(value="根据应用程序统计发布预警情况",notes = "根据应用程序统计发布预警情况")
	@RequestMapping(value = "/warncount/app", method = RequestMethod.POST)
	public Result<PageInfo<WarnAppCountDTO>> getByApp(@RequestBody OpenApiReq<WarnParamDTO> openApiReq) {
		try {			
			WarnParamDTO warnParamDTO = openApiReq.getData();
			if(warnParamDTO!=null){
				WarnParamDO warnParamDO = dozerUtils.map(warnParamDTO, WarnParamDO.class);
				PageHelper.startPage(openApiReq.getPageNo(), openApiReq.getPageSize());
				List<WarnAppCountDO> list = gxqptDutyService.getByApp(warnParamDO);
				List<WarnAppCountDTO> result = dozerUtils.mapList(list, WarnAppCountDTO.class);
		        return Result.success(new PageInfo<>(result));
			}else{
				return Result.fail("统计失败");
			}
		} catch (Exception e) {
			log.error("根据应用程序统计发布预警情况出错："+e);
			return Result.fail("根据应用程序统计发布预警情况出错");
		}
	}

	/**
	 * 单位预警状态统计
	 */
	@ApiOperation(value="单位预警状态统计",notes = "单位预警状态统计")
	@RequestMapping(value = "/warnstatus/company", method = RequestMethod.POST)
	public Result<PageInfo<WarnStatusCountDTO>> getStatusByCompany(@RequestBody OpenApiReq<WarnParamDTO> openApiReq) {
		try {			
			WarnParamDTO warnParamDTO = openApiReq.getData();
			if(warnParamDTO!=null){
				WarnParamDO warnParamDO = dozerUtils.map(warnParamDTO, WarnParamDO.class);
				PageHelper.startPage(openApiReq.getPageNo(), openApiReq.getPageSize());
				List<WarnStatusCountDO> list = gxqptWarnService.getStatusByCompany(warnParamDO);
				List<WarnStatusCountDTO> result = dozerUtils.mapList(list, WarnStatusCountDTO.class);
		        return Result.success(new PageInfo<>(result));
			}else{
				return Result.fail("统计失败");
			}
		} catch (Exception e) {
			log.error("单位预警状态统计出错："+e);
			return Result.fail("单位预警状态统计出错");
		}
	}

	/**
	 * 应用预警状态统计
	 * @param openApiReq
	 * @return
	 */
	@ApiOperation(value="应用预警状态统计",notes = "应用预警状态统计")
	@RequestMapping(value = "/warnstatus/app", method = RequestMethod.POST)
	public Result<PageInfo<WarnStatusCountDTO>> getStatusByApp(@RequestBody OpenApiReq<WarnParamDTO> openApiReq) {
		try {			
			WarnParamDTO warnParamDTO = openApiReq.getData();
			if(warnParamDTO!=null){
				WarnParamDO warnParamDO = dozerUtils.map(warnParamDTO, WarnParamDO.class);
				PageHelper.startPage(openApiReq.getPageNo(), openApiReq.getPageSize());
				List<WarnStatusCountDO> list = gxqptWarnService.getStatusByApp(warnParamDO);
				List<WarnStatusCountDTO> result = dozerUtils.mapList(list, WarnStatusCountDTO.class);
		        return Result.success(new PageInfo<>(result));
			}else{
				return Result.fail("统计失败");
			}
		} catch (Exception e) {
			log.error("应用预警状态统计出错："+e);
			return Result.fail("应用预警状态统计出错");
		}
	}

	/**
	 * 个人预警状态统计
	 */
	@ApiOperation(value="个人预警状态统计",notes = "个人预警状态统计")
	@RequestMapping(value = "/warnstatus/personal", method = RequestMethod.POST)
	public Result<PageInfo<WarnStatusCountDTO>> getStatusByPersonal(@RequestBody OpenApiReq<WarnParamDTO> openApiReq) {
		try {			
			WarnParamDTO warnParamDTO = openApiReq.getData();
			if(warnParamDTO!=null){
				WarnParamDO warnParamDO = dozerUtils.map(warnParamDTO, WarnParamDO.class);
				PageHelper.startPage(openApiReq.getPageNo(), openApiReq.getPageSize());
				List<WarnStatusCountDO> list = gxqptWarnService.getStatusByPersonal(warnParamDO);
				List<WarnStatusCountDTO> result = dozerUtils.mapList(list, WarnStatusCountDTO.class);
		        return Result.success(new PageInfo<>(result));
			}else{
				return Result.fail("统计出错");
			}
		} catch (Exception e) {
			log.error("个人预警状态统计出错："+e);
			return Result.fail("个人预警状态统计出错");
		}
	}
	/**
	 * 个人预警处理效率统计
	 */
	@ApiOperation(value="个人预警处理效率统计",notes = "个人预警处理效率统计")
	@RequestMapping(value = "/warnhandle/personal", method = RequestMethod.POST)
	public Result<PageInfo<WarnPersonalCountDTO>> getHandleByPersonal(@RequestBody OpenApiReq<WarnParamDTO> openApiReq) {
		try {			
			WarnParamDTO warnParamDTO = openApiReq.getData();
			if(warnParamDTO!=null){
				WarnParamDO warnParamDO = dozerUtils.map(warnParamDTO, WarnParamDO.class);
				PageHelper.startPage(openApiReq.getPageNo(), openApiReq.getPageSize());
				List<WarnPersonalCountDO> list = gxqptWarnService.getHandleByPersonal(warnParamDO);
				List<WarnPersonalCountDTO> result = dozerUtils.mapList(list, WarnPersonalCountDTO.class);
		        return Result.success(new PageInfo<>(result));
			}else{
				return Result.fail("统计出错");
			}
		} catch (Exception e) {
			log.error("个人预警处理效率统计出错："+e);
			return Result.fail("个人预警处理效率统计出错");
		}
	}
	/**
	 * 部门预警处理效率统计
	 */
	@ApiOperation(value="部门预警处理效率统计",notes = "部门预警处理效率统计")
	@RequestMapping(value = "/warnhandle/company", method = RequestMethod.POST)
	public Result<PageInfo<WarnDepartmentCountDTO>> getHandleByCompany(@RequestBody OpenApiReq<WarnParamDTO> openApiReq) {
		try {			
			WarnParamDTO warnParamDTO = openApiReq.getData();
			if(warnParamDTO!=null){
				WarnParamDO warnParamDO = dozerUtils.map(warnParamDTO, WarnParamDO.class);
				PageHelper.startPage(openApiReq.getPageNo(), openApiReq.getPageSize());
				List<WarnDepartmentCountDO> list = gxqptWarnService.getHandleByCompany(warnParamDO);
				List<WarnDepartmentCountDTO> result = dozerUtils.mapList(list, WarnDepartmentCountDTO.class);
		        return Result.success(new PageInfo<>(result));
			}else{
				return Result.fail("统计出错");
			}
		} catch (Exception e) {
			log.error("部门预警处理效率统计出错："+e);
			return Result.fail("部门预警处理效率统计出错");
		}
	}

	/**
	 * 应用预警处理效率统计
	 */
	@ApiOperation(value="应用预警处理效率统计",notes = "应用预警处理效率统计")
	@RequestMapping(value = "/warnhandle/app", method = RequestMethod.POST)
	public Result<PageInfo<WarnAppCountDTO>> getHandleByApp(@RequestBody OpenApiReq<WarnParamDTO> openApiReq) {
		try {
			WarnParamDTO warnParamDTO = openApiReq.getData();
			if(warnParamDTO!=null){
				WarnParamDO warnParamDO = dozerUtils.map(warnParamDTO, WarnParamDO.class);
				PageHelper.startPage(openApiReq.getPageNo(), openApiReq.getPageSize());
				List<WarnAppCountDO> list = gxqptWarnService.getHandleByApp(warnParamDO);
				List<WarnAppCountDTO> result = dozerUtils.mapList(list, WarnAppCountDTO.class);
		        return Result.success(new PageInfo<>(result));
			}else{
				return Result.fail("统计出错");
			}			
		} catch (Exception e) {
			log.error("应用预警处理效率统计出错："+e);
			return Result.fail("应用预警处理效率统计出错");
		}
	}
    /**
     * 数博会统计各状态预警数量
     * @return
     */
	@ApiOperation(value="数博会统计各状态预警数量",notes = "数博会统计各状态预警数量")
	@RequestMapping(value = "/fairwarn/status", method = RequestMethod.GET)
	public Result<List<FairWarnStatusCountDTO>> getNumberByAppId(@RequestParam(value="appid")String appid) {		 
		try {
			List<FairWarnStatusCountDO> fairWarnStatusCountDO = gxqptWarnService.getNumberByAppId(appid);
			List<FairWarnStatusCountDO> list = new ArrayList<FairWarnStatusCountDO>();
			Double handleTime = 0.00;
			Long handleCount = 0L;
			Long notHandleCount = 0L;
			for(FairWarnStatusCountDO dto:fairWarnStatusCountDO){
				if("4".equals(dto.getStatus())){
					handleTime = dto.getTime();
					handleCount = dto.getCount();
				}else{
					notHandleCount += dto.getCount();
				}
			}
			FairWarnStatusCountDO fairWarnStatusCount = new FairWarnStatusCountDO();
			fairWarnStatusCount.setStatus("已处理");
			fairWarnStatusCount.setCount(handleCount);
			Double time = 0.00;
			if((handleCount)!=0){
				time = (handleCount*handleTime)/(handleCount);
			}
			fairWarnStatusCount.setTime(time);
			list.add(fairWarnStatusCount);
			FairWarnStatusCountDO fairWarnStatusCount1 = new FairWarnStatusCountDO();
			fairWarnStatusCount1.setStatus("未处理");
			fairWarnStatusCount1.setCount(notHandleCount);
			list.add(fairWarnStatusCount1);
			List<FairWarnStatusCountDTO> result = dozerUtils.mapList(list, FairWarnStatusCountDTO.class);
			return Result.success(result);
		} catch (Exception e) {
			log.error("数博会统计各状态预警数量出错："+e);
			return Result.fail("数博会统计各状态预警数量出错");
		}				
	}
    /**
     * 数博会统计各级别预警数量
     * @return
     */
	@ApiOperation(value="数博会统计各级别预警数量",notes = "数博会统计各级别预警数量")
	@RequestMapping(value = "/fairwarn/level", method = RequestMethod.GET)
	public Result<List<FairWarnLevelCountDTO>> getLevelByAppId(@RequestParam(value="appid")String appid) {
		try {
			List<FairWarnLevelCountDO> list = gxqptWarnService.getLevelByAppId(appid);
			List<FairWarnLevelCountDTO> result = dozerUtils.mapList(list, FairWarnLevelCountDTO.class);
			return Result.success(result);
		} catch (Exception e) {
			log.error("数博会统计各级别预警数量出错："+e);
			return Result.fail("数博会统计各级别预警数量出错");
		}
	}
    /**
     * 数博会统计各类型预警数量
     * @return
     */
	@ApiOperation(value="数博会统计各类型预警数量",notes = "数博会统计各类型预警数量")
	@RequestMapping(value = "/fairwarn/type", method = RequestMethod.GET)
	public Result<FairWarnTypeReturnDTO> getTypeByAppId(@RequestParam(value="appid")String appid) {
			FairWarnTypeReturnDTO entity  = new FairWarnTypeReturnDTO();
			List<FairWarnCountDO> list =  gxqptWarnService.getTypeByAppId(appid);
			List<String> appNames = new ArrayList<String>();
		    List<String> types = new ArrayList<String>();
		    List<Integer> counts = new ArrayList<Integer>();
		    if(list == null || list.isEmpty()){
		    	return Result.success(null);
			}
		    list.forEach((li)->{
				appNames.add(li.getAppName());
				types.add(li.getType());
				counts.add(li.getCountNum());
			});
			entity.setAppNames(appNames);
			entity.setTypes(types);
			entity.setCounts(counts);
			return Result.success(entity);
	}
    /**
     * 数博会统各应用预警数量
     * @return
     */
	@ApiOperation(value="数博会统各应用预警数量",notes = "数博会统各应用预警数量")
	@RequestMapping(value = "/fairwarn/apps", method = RequestMethod.GET)
	public Result<FairWarnAppCountDTO> getAppsNumber() {
		try {
			FairWarnAppCountDO map = new FairWarnAppCountDO();
			List<WarnAppCountDO> innerList = gxqptDutyService.getInnerAppByAppId();
			List<WarnAppCountDO> outerList = gxqptDutyService.getOuterAppByAppId();
			map.setInner(innerList);
			map.setOuter(outerList);
			FairWarnAppCountDTO fairWarnAppCountDTO = dozerUtils.map(map, FairWarnAppCountDTO.class);
			return Result.success(fairWarnAppCountDTO);
		} catch (Exception e) {
			log.error("数博会统各应用预警数量出错："+e);
			return Result.fail("数博会统各应用预警数量出错");
		}
	}
    /**
     * 数博会统各月份预警数量
     * @return
     */
	@ApiOperation(value="数博会统各月份预警数量",notes = "数博会统各月份预警数量")
	@RequestMapping(value = "/fairwarn/months", method = RequestMethod.GET)
	public Result<List<FairWarnTimeSlotCountDTO>> getTimeSlotByAppId(@RequestParam(value="appid")String appid) {
		try {
			List<FairWarnTimeSlotCountDO> list = warnTimeSlotService.getTimeSlotByAppId(appid);
			List<FairWarnTimeSlotCountDTO> result = dozerUtils.mapList(list, FairWarnTimeSlotCountDTO.class);
			return Result.success(result);
		} catch (Exception e) {
			log.error("数博会统各月份预警数量出错："+e);
			return Result.fail("数博会统各月份预警数量出错");
		}
	}

    /**
     * 部门-应用-预警情况分析
     * @param type 所查询的系统   预警系统部门统计   type= warn  统一监管的部门统计 type = sup
     * @return
     */
	@ApiOperation(value="部门-应用-预警情况分析",notes = "部门-应用-预警情况分析")
	@RequestMapping(value = "/fairwarn/relationship", method = RequestMethod.GET)
	public Result<List<DepWarnAnalyse>> getRelationship(@RequestParam("type") String type) {
		try {
            Long adminId = null;
            GxqptSendee gxqptSendee = new GxqptSendee();
            if("warn".equalsIgnoreCase(type)){
                //获取当前任所在部门的 id
                adminId = BaseContextHandler.getAdminId();
                gxqptSendee.setUserId(adminId);
                gxqptSendee = sendeeSingleDeal(gxqptSendee);
                log.info("gxqptSendee.getOrgId(): {}", gxqptSendee.getOrgId());
            }
            //获取部门下应用的预警
			List<FairRelationshipDO> appList = gxqptDutyService.getRelationshipApp(gxqptSendee);
			Set<String> departmentId = new HashSet<>();
			log.info("fairwarn/relationship -> getRelationship:{}",appList.size());
			if(null!= appList && !appList.isEmpty()){
				appList.forEach(obj->{
					if(obj.getDepartmentId() != null){
						departmentId.add(obj.getDepartmentId());
					}
				});
			}

            List<DepWarnAnalyse> depWarnAnalyses = new ArrayList<>();
			if(departmentId.size() > 0){
                departmentId.forEach(obj ->{
                    log.info("departmentId: {}", obj);
                    DepWarnAnalyse depWarnAnalyse = new DepWarnAnalyse();
                    depWarnAnalyse.setDepartmentId(obj);
                    List<LevelNum> levelNums = new ArrayList<>();
                    appList.forEach(obj1->{
                        if(obj.equalsIgnoreCase(obj1.getDepartmentId())){
                            log.info("appList:{}  level:{}  count: {}",obj1.getDepartment(),obj1.getLevel(),obj1.getCount());
                            depWarnAnalyse.setDepartment(obj1.getDepartment());
                            LevelNum levelNum = new LevelNum();
                            levelNum.setLevel(obj1.getLevel());
                            levelNum.setCount(obj1.getCount());
                            levelNums.add(levelNum);
                        }
                    });
                    //对于没有的 等级返回的数量 填充 0  有四个等级 1、一般 2、较重 3、严重 4、特别严重
					int flag = 4;
					if(flag > levelNums.size()){
						List<Integer> level = asList(1,2,3,4);
						List<Integer> levels = levelNums.stream().map(LevelNum::getLevel).collect(Collectors.toList());
						//差集
						level=level.stream().filter(t-> !levels.contains(t)).collect(Collectors.toList());
						level.forEach(obj02->{
							LevelNum levelNum = new LevelNum();
							levelNum.setLevel(obj02);
							levelNum.setCount(0);
							levelNums.add(levelNum);
						});

					}
					//按level升序排列
					levelNums.sort(comparingInt(LevelNum::getLevel));
					int sum = levelNums.stream().mapToInt(LevelNum::getCount).sum();
					depWarnAnalyse.setTotalNum(sum);
					depWarnAnalyse.setLevelNums(levelNums);
					depWarnAnalyses.add(depWarnAnalyse);
                });
            }
			return Result.success(depWarnAnalyses);
		} catch (Exception e) {
			log.error("数博会部门、预警、应用关系出错："+e);
			return Result.fail("数博会部门、预警、应用关系出错");
		}
	}

	/**
	 * 获取未确认,已确认,已处理,预警处理平均时间接口
	 * @return
	 */
	@ApiOperation(value="获取未确认,已确认,已处理,预警处理平均时间接口",notes = "获取未确认,已确认,已处理,预警处理平均时间接口")
	@RequestMapping(value = "/count/getWarnMixStatusNum", method = RequestMethod.GET)
	public Result<WarnMixStatusNumDTO> getWarnMixStatusNum(@RequestParam(value = "userId") Long userId) {
		    //查询返回
			WarnMixStatusNumDO warnMixStatusNumDO = sendeeService.getWarnMixStatusNum(userId);
			WarnMixStatusNumDTO warnMixStatusNumDTO = dozerUtils.map(warnMixStatusNumDO, WarnMixStatusNumDTO.class);
			return Result.success(warnMixStatusNumDTO);
	}

	/**
	 * @method
	 * @description 获取个人部门信息
	 * @date: 2019/5/6 0006 18:52
	 * @author: mdengb
	 * @param duList
	 * @return
	 */
    private GxqptSendee sendeeSingleDeal(GxqptSendee duList){
        List<String> useIds = new ArrayList<>();
        useIds.add(duList.getUserId().toString());
        GxqptEmpByUserNameDTO dto = new GxqptEmpByUserNameDTO();
        dto.setUserIds(useIds);
        dto.setPageNo(1);
        dto.setPageSize(useIds.size());
        List<GxqptEmpRetDTO> empDate = gxqptEmpApi.findEmpByUserIds(dto).getData().getList();
        log.info("预警人员信息查询返回 empDate.toString:{}",empDate.toString());
        if(!empDate.isEmpty()){
            for(GxqptEmpRetDTO user : empDate){
                if(duList.getUserId().equals(user.getGxqptEmpId())){
                    //部门相关的信息
                    duList.setDepartmentId(user.getMaindeptid());
                    duList.setDepartmentName(user.getMaindeptname());
                    //应用相关信息
                    duList.setOrgId(user.getMainorgid());
                    duList.setOrgName(user.getMainorgname());
                    log.info("预警人员相关基础信息 saveWarnMessage -> dealDutys02 -> duty.getUserId:{} duty.getDepartmentId: {}  duty.getOrgId:{}",duList.getUserId(),duList.getDepartmentId(),duList.getOrgId());
                    break;
                }
            }
        }
        return duList;
    }

}
