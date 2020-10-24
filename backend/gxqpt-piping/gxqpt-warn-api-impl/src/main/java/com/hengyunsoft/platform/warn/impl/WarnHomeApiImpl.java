package com.hengyunsoft.platform.warn.impl;

import com.hengyunsoft.base.Result;
import com.hengyunsoft.commons.context.BaseContextHandler;
import com.hengyunsoft.commons.servicemodule.annotation.WarnSendModule;
import com.hengyunsoft.commons.utils.context.DozerUtils;
import com.hengyunsoft.platform.supervise.dto.analysis.EmpWarnTypeResDTO;
import com.hengyunsoft.platform.supervise.dto.analysis.WarnScaleCountDTO;
import com.hengyunsoft.platform.warn.api.warn.dto.WarnLevelDTO;
import com.hengyunsoft.platform.warn.entity.domain.EmpWarnTypeResDO;
import com.hengyunsoft.platform.warn.entity.domain.WarnLevelDO;
import com.hengyunsoft.platform.warn.entity.domain.WarnScaleCountDO;
import com.hengyunsoft.platform.warn.repository.service.GxqptWarnService;
import com.hengyunsoft.platform.warn.repository.service.WarnScaleStatisticalService;
import com.hengyunsoft.platform.warn.utils.DateUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * 描述：预警管理系统首页
 * @author zjr
 * @date 2018/09/07
 */
@Api(value = "预警管理系统首页", description = "预警管理系统首页")
@Slf4j
@RestController
@WarnSendModule
public class WarnHomeApiImpl {
	@Autowired
	private GxqptWarnService gxqptWarnService;
	@Autowired
	private WarnScaleStatisticalService warnScaleStatisticalService;
	@Autowired
	private DozerUtils dozerUtils;

	/**
	 * 个人预警级别情况
	 * @return
	 */
	@ApiOperation(value = "个人预警级别情况", notes = "个人预警级别情况")
	@RequestMapping(value = "/findLevelCount", method = RequestMethod.POST)
	public Result<List<WarnLevelDTO>> findLevelCount (){
		//查询
		List<WarnLevelDO> levelList = gxqptWarnService.findLevelCount(BaseContextHandler.getAdminId());
		//转换
		List<WarnLevelDTO> list = dozerUtils.mapList(levelList,WarnLevelDTO.class);
		return Result.success(list);
	}

	/**
	 * 人员预警产生、处理情况
	 *  @return
	 */
	@ApiOperation(value="单个人员预警产生、处理情况",notes = "单个人员预警产生、处理情况")
	@RequestMapping(value = "/warnHandleStatistical",method = RequestMethod.POST)
	public Result<List<WarnScaleCountDTO>> getWarnProvHandle(){
		try {
			//查询
			List<WarnScaleCountDO> penlist = warnScaleStatisticalService.getScaleByUserId(BaseContextHandler.getAdminId());
			List<String> monthList = new ArrayList<String>();
			log.info("warn/warnHandleStatistical -> getWarnProvHandle:{}",penlist.size());
				for (int i=0;i<penlist.size();i++){
					monthList.add(penlist.get(i).getMonth());
				}
				//查询近半年所包含的月份
				List<String> months = DateUtil.getMonthBetween();
				for (String month :months){
					if (!monthList.contains(month)){
						WarnScaleCountDO warnScaleCountDO = new WarnScaleCountDO();
						warnScaleCountDO.setMonth(month);
						warnScaleCountDO.setAvgConfirmTime("0.00");
						warnScaleCountDO.setAvgHandleTime("0.00");
						warnScaleCountDO.setHandled(0);
						warnScaleCountDO.setNewCome(0);
						warnScaleCountDO.setPending(0);
						penlist.add(warnScaleCountDO);
					}
				}
				//排序
				Collections.sort(penlist, new Comparator<WarnScaleCountDO>() {
					@Override
					public int compare(WarnScaleCountDO o1, WarnScaleCountDO o2) {
						if(!o1.getMonth().equals(o2.getMonth())){
							return o1.getMonth().compareTo(o2.getMonth());
						}
						return 0;
					}
				});
			//转换
			List<WarnScaleCountDTO> list = dozerUtils.mapList(penlist,WarnScaleCountDTO.class);
			return Result.success(list);
		} catch (Exception e) {
			log.error("单个人员预警产生、处理情况出错"+e);
			return Result.fail("单个人员预警产生、处理情况出错");
		}
	}

	/**
	 *  预警类型TOP10
	 *  @return
	 */
	@ApiOperation(value="预警类型TOP10",notes = "预警类型TOP10")
	@RequestMapping(value = "/findWarnType",method = RequestMethod.POST)
	public Result<List<EmpWarnTypeResDTO>> findWarnType(){
		//查询
		List<EmpWarnTypeResDO> typeList = gxqptWarnService.findWarnType(BaseContextHandler.getAdminId());
		//转换
		List<EmpWarnTypeResDTO> list = dozerUtils.mapList(typeList,EmpWarnTypeResDTO.class);
		return Result.success(list);
	}
}
