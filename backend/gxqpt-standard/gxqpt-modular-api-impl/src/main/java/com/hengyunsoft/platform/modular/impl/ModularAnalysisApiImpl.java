package com.hengyunsoft.platform.modular.impl;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.hengyunsoft.base.Result;
import com.hengyunsoft.commons.utils.context.DozerUtils;
import com.hengyunsoft.platform.modular.dto.HotSupportDTO;
import com.hengyunsoft.platform.modular.dto.HotSupportListDTO;
import com.hengyunsoft.platform.modular.dto.ModularAnalysisCategoryTopDTO;
import com.hengyunsoft.platform.modular.dto.ModularDiscardedNumDTO;
import com.hengyunsoft.platform.modular.dto.ModularDownloadNumDTO;
import com.hengyunsoft.platform.modular.dto.ModularDownloadTopDTO;
import com.hengyunsoft.platform.modular.dto.ModularHandleAnalysisDTO;
import com.hengyunsoft.platform.modular.dto.ModularNewestDTO;
import com.hengyunsoft.platform.modular.dto.ModularNumDTO;
import com.hengyunsoft.platform.modular.dto.ModularRepertoriesTopDTO;
import com.hengyunsoft.platform.modular.entity.modular.domain.ModularAnalysisCategoryTopDO;
import com.hengyunsoft.platform.modular.entity.modular.domain.ModularDO;
import com.hengyunsoft.platform.modular.entity.modular.domain.ModularHotDO;
import com.hengyunsoft.platform.modular.entity.modular.dos.HotSupportListDO;
import com.hengyunsoft.platform.modular.entity.modular.dos.ModularDiscardedNumDO;
import com.hengyunsoft.platform.modular.entity.modular.dos.ModularDownloadNumDO;
import com.hengyunsoft.platform.modular.entity.modular.dos.ModularNewestDO;
import com.hengyunsoft.platform.modular.entity.modular.dos.ModularNumDO;
import com.hengyunsoft.platform.modular.entity.modular.po.Modular;
import com.hengyunsoft.platform.modular.repository.service.ModularLogService;
import com.hengyunsoft.platform.modular.repository.service.ModularService;
import com.hengyunsoft.platform.modular.utils.AiUtil;
import com.hengyunsoft.platform.modular.utils.DateUtil;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author wangs
 * @createTime 2018-4-03
 */
@RestController
@Slf4j
@Api(value = "API - ModularAnalysisApiImpl", description = "模块使用分析")
public class ModularAnalysisApiImpl /*implements ModularAnalysisApi*/ {

    @Autowired
    private DozerUtils dozerUtils;
    @Autowired
    private ModularService modularService;
    @Autowired
    private ModularLogService modularLogService;

    /**
     * 下载量最多的CategoryTop10
     */
	@RequestMapping(value = "/analysis/category/down/top10", method = RequestMethod.POST)
    public Result<List<ModularAnalysisCategoryTopDTO>> findCategoryDownTop10() {
        List<ModularAnalysisCategoryTopDO> list = modularLogService.findCategoryDownTop10();
        List<ModularAnalysisCategoryTopDTO> lists = dozerUtils.mapList(list, ModularAnalysisCategoryTopDTO.class);
        return Result.success(lists);
    }

    /**
     * 使用量最多的模块Top10
     */
	@RequestMapping(value = "/analysis/modular/down/top10", method = RequestMethod.POST)
    @ApiOperation(value="模块活跃度榜top10",notes = "模块活跃度榜top10")
    public Result<List<ModularDownloadTopDTO>> findModularDownTop10() {
        List<ModularDO> list = modularLogService.findModularDownTop10();
        List<ModularDownloadTopDTO> lists = dozerUtils.mapList(list, ModularDownloadTopDTO.class);
        return Result.success(lists);
    }

    /**
     * 模块数量最多的库排行
     *
     * @return
     */
	@RequestMapping(value = "/analysis/repository/top10", method = RequestMethod.POST)
    public Result<List<ModularRepertoriesTopDTO>> findRepositoryTop10() {
        List<Modular> list = modularService.findRepositoryTop10();
        List<ModularRepertoriesTopDTO> lists = dozerUtils.mapList(list, ModularRepertoriesTopDTO.class);
        return Result.success(lists);
    }
    /*========================================模块使用top10======================================*/

    /**
     * 活跃提供商榜
     */
	@RequestMapping(value = "/analysis/supplier/top10", method = RequestMethod.POST)
    @ApiOperation(value="活跃提供商榜top10",notes = "活跃提供商榜top10")
    public Result<List<HotSupportDTO>> findSupplierTop10() throws ParseException {
        List<ModularHotDO> list = modularService.findSupplierTop10();
        List<HotSupportDTO> lists = dozerUtils.mapList(list, HotSupportDTO.class);
        return Result.success(lists);
    }


    /**
     * 模块活跃度榜
     */
	@RequestMapping(value = "/analysis/modular/updateFrequency/top10", method = RequestMethod.POST)
    @ApiOperation(value="模块热度榜top10",notes = "模块热度榜top10")
    public Result<List<HotSupportDTO>> findModularUpdateFrequencyTop10() throws ParseException {
        List<ModularHotDO> list = modularService.findModularUpdateFrequencyTop10();
        List<HotSupportDTO> lists = dozerUtils.mapList(list, HotSupportDTO.class);
        return Result.success(lists);
    }

    /**
     * 新模块榜
     */
	@RequestMapping(value = "/analysis/modular/lastUpload/top10", method = RequestMethod.POST)
    public Result<List<HotSupportDTO>> findModularLastUploadTop10() throws ParseException {
        List<ModularHotDO> list = modularService.findModularLastUploadTop10();
        List<HotSupportDTO> lists = dozerUtils.mapList(list, HotSupportDTO.class);
        return Result.success(lists);
    }
      
    
    
    /**
     * 模块各操作统计
     */
	@RequestMapping(value = "/home/handle/count", method = RequestMethod.GET)
	@ApiOperation(value="模块各操作统计",notes = "模块各操作统计")
	public Result<ModularHandleAnalysisDTO> getModularHandle() {
		try {
			ModularHandleAnalysisDTO modular = new ModularHandleAnalysisDTO();
			//获取本月1号00:00:00的时间
			Date date = DateUtil.getThisMonthTime();
			//模块总数
			Integer modularNum = modularService.getModularNum();
			modular.setModularNum(modularNum);
			//本月新增模块数
			Integer monthModularNum = modularService.getMonthModularNum(date);
			modular.setMonthAddNum(monthModularNum);
			//废弃模块总数
			Integer modularDiscarded = modularService.getModularDiscardedNum();
			modular.setOverdueNum(modularDiscarded);
			//本月废弃模块数
			Integer monthModularDiscarded = modularService.getMonthModularDiscardedNum(date);
			modular.setMonthOverdueNum(monthModularDiscarded);
			//模块使用量
			Integer modularUsed = modularLogService.getModularUsedNum();	
			modular.setModularUsedNum(modularUsed);
			//本月模块使用量
			Integer monthModularUsed = modularLogService.getMonthModularUsedNum(date);
			modular.setMonthUsedNum(monthModularUsed);
			//模块使用率
			Integer modularUsedRate = modularLogService.getModularUsedRate();
			if(modularUsedRate!=null&&modularUsedRate<modularNum&&modularNum!=null&&modularNum!=0){
				Double rate = (double) (modularUsedRate*100/modularNum);
				modular.setModularUsageRate(rate);
			}else if(modularUsedRate>=modularNum){
				modular.setModularUsageRate(100.00);
			}
			//本月模块使用率
			Integer monthModularUsedRate = modularLogService.getMonthModularUsedRate(date);
			if(monthModularUsedRate!=null&&monthModularUsedRate<modularNum&&modularNum!=null&&modularNum!=0){
				Double rate = (double) (monthModularUsedRate*100/modularNum);
				modular.setMonthUsageRate(rate);
			}else if(monthModularUsedRate>=modularNum){
				modular.setMonthUsageRate(100.00);
			}
			return Result.success(modular);
		} catch (Exception e) {
			log.error("获取模块各操作统计出错："+e);
			return Result.fail("获取模块各操作统计出错");
		}
	}
	
    /**
     * 模块数量分析
     */
	@RequestMapping(value = "/home/num/analysis", method = RequestMethod.GET)
	@ApiOperation(value="模块数量分析",notes = "模块数量分析")
	public Result<List<ModularNumDTO>> getModularNum() {
		try {
			//获取本月1号00:00:00的时间
			Date date = DateUtil.getThisMonthTime();
	        List<ModularNumDO> list = modularService.getModularNumAnalysis(date);
			//模块总数
			Integer modularNum = modularService.getModularNum();
	        if(modularNum==null||modularNum==0){
	        	return Result.success(null);
	        }
	        //添加每月历史数量	    
	        Integer num = 0;
			//倒序
            Collections.sort(list, new Comparator<ModularNumDO>() {
    			@Override
    			public int compare(ModularNumDO o1, ModularNumDO o2) {
    				if(!o1.getYear().equals(o2.getYear())){
    					return -o1.getYear().compareTo(o2.getYear());
    				}
    				if(!o1.getMonth().equals(o2.getMonth())){
    					return -o1.getMonth().compareTo(o2.getMonth());
    				}
    				return 0;
    			}
    		});
	        for(ModularNumDO modularNumDO:list){
	        	Integer add = modularNumDO.getMonthAddNum();
	        	if(num==0){
	        		num = modularNum - add;
	        	}else{
	        		num = num - add;
	        	}	        	
	        	modularNumDO.setModularNum(num);
	        }

	        if(list!=null&&list.size()>0){
				List<String> dates = new ArrayList<String>();
				for(ModularNumDO modularNumDO:list){
					String month_ = modularNumDO.getYear()+"-"+DateUtil.getMonthAddZero(modularNumDO.getMonth());
					dates.add(month_);
					modularNumDO.setMonth(DateUtil.getMonthAddZero(modularNumDO.getMonth()));
				}
				List<String> months = DateUtil.getMonthBetween();
				for(String month:months){
					if(!dates.contains(month)){
						ModularNumDO modularNumDO = new ModularNumDO();
						modularNumDO.setYear(month.substring(0, 4));
						modularNumDO.setMonth(month.substring(5));
						modularNumDO.setModularNum(AiUtil.getNum(month, list, dates));
						modularNumDO.setMonthAddNum(0);
						list.add(modularNumDO);
					}
				}

				//排序
	            Collections.sort(list, new Comparator<ModularNumDO>() {
	    			@Override
	    			public int compare(ModularNumDO o1, ModularNumDO o2) {
	    				if(!o1.getYear().equals(o2.getYear())){
	    					return o1.getYear().compareTo(o2.getYear());
	    				}
	    				if(!o1.getMonth().equals(o2.getMonth())){
	    					return o1.getMonth().compareTo(o2.getMonth());
	    				}
	    				return 0;
	    			}
	    		});
			}else{
				List<String> months = DateUtil.getMonthBetween();
				for(String month:months){
					ModularNumDO modularNumDO = new ModularNumDO();
					modularNumDO.setYear(month.substring(0, 4));
					modularNumDO.setMonth(month.substring(5));
					modularNumDO.setModularNum(0);
					modularNumDO.setMonthAddNum(0);
					list.add(modularNumDO);
				}
			}
	        List<ModularNumDTO> result = dozerUtils.mapList(list, ModularNumDTO.class);
	        return Result.success(result);
		} catch (Exception e) {
			log.error("获取模块数量分析数据出错："+e);
			return Result.fail("获取模块数量分析数据出错");
		}
	}
	
    /**
     * 废弃模块数(一年以上没有更新的模块)
     */
	@RequestMapping(value = "/home/discarded/num", method = RequestMethod.GET)
	@ApiOperation(value="废弃模块数",notes = "废弃模块数")
	public Result<List<ModularDiscardedNumDTO>> getModularDiscardedNum() {
		try {
	        List<ModularDiscardedNumDO> list = modularService.getModularDiscardedAnalysis();
	        if(list!=null&&list.size()>0){
				List<String> dates = new ArrayList<String>();
				for(ModularDiscardedNumDO modularDiscardedNumDO:list){
					String month_ = modularDiscardedNumDO.getYear()+"-"+DateUtil.getMonthAddZero(modularDiscardedNumDO.getMonth());
					dates.add(month_);
					modularDiscardedNumDO.setMonth(DateUtil.getMonthAddZero(modularDiscardedNumDO.getMonth()));
				}
				List<String> months = DateUtil.getMonthBetween();
				for(String month:months){
					if(!dates.contains(month)){
						ModularDiscardedNumDO modularDiscardedNumDO = new ModularDiscardedNumDO();
						modularDiscardedNumDO.setYear(month.substring(0, 4));
						modularDiscardedNumDO.setMonth(month.substring(5));
						modularDiscardedNumDO.setModularNum(0);
						list.add(modularDiscardedNumDO);
					}
				}

				//排序
	            Collections.sort(list, new Comparator<ModularDiscardedNumDO>() {
	    			@Override
	    			public int compare(ModularDiscardedNumDO o1, ModularDiscardedNumDO o2) {
	    				if(!o1.getYear().equals(o2.getYear())){
	    					return o1.getYear().compareTo(o2.getYear());
	    				}
	    				if(!o1.getMonth().equals(o2.getMonth())){
	    					return o1.getMonth().compareTo(o2.getMonth());
	    				}
	    				return 0;
	    			}
	    		});
			}else{
				List<String> months = DateUtil.getMonthBetween();
				for(String month:months){
					ModularDiscardedNumDO modularDiscardedNumDO = new ModularDiscardedNumDO();
					modularDiscardedNumDO.setYear(month.substring(0, 4));
					modularDiscardedNumDO.setMonth(month.substring(5));
					modularDiscardedNumDO.setModularNum(0);
					list.add(modularDiscardedNumDO);
				}
			}
	        List<ModularDiscardedNumDTO> result = dozerUtils.mapList(list, ModularDiscardedNumDTO.class);
	        return Result.success(result);
		} catch (Exception e) {
			log.error("获取废弃模块数出错："+e);
			return Result.fail("获取废弃模块数出错");
		}
	}
	
    /**
     * 新模块榜(最近半年)
     */
	@RequestMapping(value = "/home/newest/ranking", method = RequestMethod.GET)
	@ApiOperation(value="新模块榜",notes = "新模块榜")
	public Result<List<ModularNewestDTO>> getModularNewestRanking() {
		try {
	        List<ModularNewestDO> list = modularService.getModularNewestRanking();
	        List<ModularNewestDTO> result = dozerUtils.mapList(list, ModularNewestDTO.class);
	        return Result.success(result);
		} catch (Exception e) {
			log.error("获取新模块榜出错："+e);
			return Result.fail("获取新模块榜出错");
		}
	}
	
    /**
     * 模块下载top20
     */
	@RequestMapping(value = "/home/download/num", method = RequestMethod.GET)
	@ApiOperation(value="模块下载top20",notes = "模块下载top20")
	public Result<List<ModularDownloadNumDTO>> getModularDownloadTop20() {
		try {
			//获取模块下载总量
			Integer modularUsed = modularLogService.getModularUsedNum();
			if(modularUsed==null||modularUsed==0){
				return Result.success(null);
			}
	        List<ModularDownloadNumDO> list = modularLogService.getModularDownloadTop20();
	        if(list!=null){
	        	//添加占比
				DecimalFormat df = new DecimalFormat("#.##");
		        for(ModularDownloadNumDO modularDownloadNumDO:list){
		        	if(modularDownloadNumDO==null){
		        		continue;
		        	}
		        	Integer count = modularDownloadNumDO.getCount();
		        	if(count!=null){
						Double proportion = (double)(count*100/modularUsed);
						modularDownloadNumDO.setRatio(df.format(proportion));
					}else{
						modularDownloadNumDO.setRatio("0.00");
					}
		        }
	        }
	        List<ModularDownloadNumDTO> result = dozerUtils.mapList(list, ModularDownloadNumDTO.class);
	        return Result.success(result);
		} catch (Exception e) {
			log.error("获取模块下载top20出错："+e);
			return Result.fail("获取模块下载top20出错");
		}
	}
    /**
     * 活跃提供商列表
     */
	@RequestMapping(value = "/used/supplier/top10", method = RequestMethod.GET)
	@ApiOperation(value="活跃提供商列表",notes = "活跃提供商列表")
	public Result<List<HotSupportListDTO>> getSupplierListTop10() {
		try {
	        List<HotSupportListDO> list = modularService.getSupplierListTop10();
	        List<HotSupportListDTO> result = dozerUtils.mapList(list, HotSupportListDTO.class);
	        return Result.success(result);
		} catch (Exception e) {
			log.error("获取活跃提供商列表出错："+e);
			return Result.fail("获取活跃提供商列表出错");
		}
	}

}
