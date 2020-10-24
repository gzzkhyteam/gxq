package com.hengyunsoft.platform.standard.impl;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.hengyunsoft.base.Result;
import com.hengyunsoft.commons.constant.DeleteStatus;
import com.hengyunsoft.commons.utils.context.DozerUtils;
import com.hengyunsoft.platform.standard.dto.StandardAnalysisTopFileDTO;
import com.hengyunsoft.platform.standard.dto.StandardAnalysisTreeDTO;
import com.hengyunsoft.platform.standard.dto.StandardClassifyTreeDTO;
import com.hengyunsoft.platform.standard.dto.StandardDownloadDTO;
import com.hengyunsoft.platform.standard.dto.StandardHandleAnalysisDTO;
import com.hengyunsoft.platform.standard.dto.StandardMonthDTO;
import com.hengyunsoft.platform.standard.dto.StandardTypeDTO;
import com.hengyunsoft.platform.standard.dto.UploadCompanyDTO;
import com.hengyunsoft.platform.standard.entity.standard.domain.StandardFileDO;
import com.hengyunsoft.platform.standard.entity.standard.domain.StandardFileLogDO;
import com.hengyunsoft.platform.standard.entity.standard.dos.StandardDownloadDO;
import com.hengyunsoft.platform.standard.entity.standard.dos.StandardMonthDO;
import com.hengyunsoft.platform.standard.entity.standard.dos.StandardTypeDO;
import com.hengyunsoft.platform.standard.entity.standard.dos.UploadCompanyDO;
import com.hengyunsoft.platform.standard.entity.standard.po.StandardClassify;
import com.hengyunsoft.platform.standard.repository.standard.example.StandardClassifyExample;
import com.hengyunsoft.platform.standard.repository.standard.example.StandardFileExample;
import com.hengyunsoft.platform.standard.repository.standard.service.StandardClassifyService;
import com.hengyunsoft.platform.standard.repository.standard.service.StandardFileLogService;
import com.hengyunsoft.platform.standard.repository.standard.service.StandardFileService;
import com.hengyunsoft.platform.standard.utils.DateUtil;
import com.hengyunsoft.platform.standard.utils.ReturnTreeUtills;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
@RestController
@Slf4j
@Api(value = "标准分析管理", description = "提供标准分析数据")
public class StandardAnalysisApiImpl /*implements StandardAnalysisApi */{

    @Autowired
    private DozerUtils dozerUtils;
    @Autowired
    private StandardFileLogService standardFileLogService;   
    @Autowired
    private StandardFileService standardFileService;
    @Autowired
    private StandardClassifyService standardClassifyService;

    /**
     * 查看月下载TOP10文档列表
     *
     * @param yyyyMM
     * @return
     */
	@RequestMapping(value = "/analysis/month/top10", method = RequestMethod.POST)
    public Result<List<StandardAnalysisTopFileDTO>> statMonthTop10(@RequestParam(value = "yyyyMM")String yyyyMM) throws ParseException {
        List<StandardFileLogDO> lists = standardFileLogService.statDownloadTop10(getMonthFirstDay(yyyyMM),getMonthLastDay(yyyyMM));
        List<StandardAnalysisTopFileDTO> pageList = dozerUtils.mapPage(lists, StandardAnalysisTopFileDTO.class);
        return Result.success(pageList);
    }

    /**
     * 查看年下载TOP10文档列表
     *
     * @param yyyy
     * @return
     */
	@RequestMapping(value = "/analysis/year/top10", method = RequestMethod.POST)
    public Result<List<StandardAnalysisTopFileDTO>> statYearTop10(@RequestParam(value = "yyyy")String yyyy) throws ParseException {
        List<StandardFileLogDO> lists = standardFileLogService.statDownloadTop10(getYearFirstDay(yyyy),getYearLastDay(yyyy));
        List<StandardAnalysisTopFileDTO> pageList = dozerUtils.mapPage(lists, StandardAnalysisTopFileDTO.class);
        return Result.success(pageList);
    }

    /**
     * 按分类统计文档下载量
     *
     * @param yyyyMM@return
     */
	@RequestMapping(value = "/analysis/classify", method = RequestMethod.POST)
    public Result<List<StandardAnalysisTreeDTO>> statByClassify(@RequestParam(value = "yyyyMM") String yyyyMM, @RequestParam(value = "parentId") String parentId) throws ParseException {
        //提取各分类下载数量
        List<StandardFileLogDO> lists = standardFileLogService.statByClassify(getMonthFirstDay(yyyyMM),getMonthLastDay(yyyyMM),parentId);

        List<StandardAnalysisTreeDTO> pageList = dozerUtils.mapPage(lists, StandardAnalysisTreeDTO.class);
        return Result.success(pageList);
    }

    private Date getMonthFirstDay(String yyyyMM) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd HH:mm:ss");
        return sdf.parse(yyyyMM + "01 00:00:00");
    }

    private Date getMonthLastDay(String yyyyMM) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd HH:mm:ss");
        Date date = sdf.parse(yyyyMM + "01 00:00:00");
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.MONTH,1);
        return calendar.getTime();
    }

    private Date getYearFirstDay(String yyyy) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd HH:mm:ss");
        return sdf.parse(yyyy + "0101 00:00:00");
    }

    private Date getYearLastDay(String yyyy) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd HH:mm:ss");
        Date date = sdf.parse(yyyy + "0101 00:00:00");
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.YEAR,1);
        return calendar.getTime();
    }

    /**
     * 首页获取本月标准各操作数量
     * @return
     */
	@RequestMapping(value = "/home/statHandle/nums", method = RequestMethod.GET)
	public Result<StandardHandleAnalysisDTO> statHandleNums() {
		try {
			StandardHandleAnalysisDTO standard = new StandardHandleAnalysisDTO();
			//获取本月1号00:00:00的时间
			Date date = DateUtil.getThisMonthTime();
			//获取准数数量
			Integer standardNum = standardFileService.getStandardNum();
			standard.setStandardNum(standardNum);
			//获取本月新增标准数
			Integer monthStandardNum = standardFileService.getMonthStandardNum(date);
			standard.setMonthAddNum(monthStandardNum);
			//获取标准使用量
			Integer standardDownloadNum = standardFileLogService.getStandardDownloadNum();
			standard.setStandardUsedNum(standardDownloadNum);
			//获取本月标准使用量
			Integer monthStandardDownloadNum = standardFileLogService.getMonthStandardDownloadNum(date);
			standard.setMonthUsedNum(monthStandardDownloadNum);
			//获取标准失效数量
			Integer standardInvalidNum = standardFileService.getStandardInvalidNum();
			standard.setOverdueNum(standardInvalidNum);
			//获取本月标准失效数量
			Integer monthStandardInvalidNum = standardFileService.getMonthStandardInvalidNum(date);
			standard.setMonthOverdueNum(monthStandardInvalidNum);
			//获取运维标准数
			List<String> allClassifyIds = getClassifyIds(751514420097L);//运维标准id是定值751514420097---王涛确定
			StandardFileExample example = new StandardFileExample();
			StandardFileExample.Criteria criteria = example.createCriteria();
			criteria.andFClassifyIdIn(allClassifyIds)
			.andFClassIdEqualToCId()
			.andFIsEnableEqueal(true)
			.andFIsDeleteEqualTo(DeleteStatus.UN_DELETE.getVal());
			List<StandardFileDO> lists = standardFileService.pageDocument(example);
			if(lists!=null){
				Integer standardYunweiNum = lists.size();
				standard.setOperationNum(standardYunweiNum);
			}else{
				standard.setOperationNum(0);
			}			
			//获取本月新新增运维标准数
			StandardFileExample example1 = new StandardFileExample();
			StandardFileExample.Criteria criteria1 = example1.createCriteria();
			criteria1.andFClassifyIdIn(allClassifyIds)
			.andFCreateTimeGt(date)
            .andFCreateTimeLt(new Date())
			.andFClassIdEqualToCId()
			.andFIsEnableEqueal(true)
			.andFIsDeleteEqualTo(DeleteStatus.UN_DELETE.getVal());
			List<StandardFileDO> lists1 = standardFileService.pageDocument(example1);
			if(lists1!=null){
				Integer monthStandardYunweiNum = lists1.size();
				standard.setMonthOperationNum(monthStandardYunweiNum);
			}else{
				standard.setMonthOperationNum(0);
			}	
			return Result.success(standard);
		} catch (Exception e) {
			log.error("获取首页获取本月标准各操作数量出错:"+e);
			return Result.fail("获取首页获取本月标准各操作数量出错");
		}
	}
    /**
     * 标准上传单位TOP10
     * @return
     */
	@RequestMapping(value = "/home/uploadCompany/top10", method = RequestMethod.GET)
    @ApiOperation(value="标准上传单位TOP10",notes = "标准上传单位TOP10")
	public Result<List<UploadCompanyDTO>> uploadCompanyTop10() {
		try {
			List<UploadCompanyDO> list = standardFileService.getCompanyTop10();
			if(list!=null&&list.size()!=0){
				List<UploadCompanyDTO> result = dozerUtils.mapList(list, UploadCompanyDTO.class);
				return Result.success(result);
			}else{
				return Result.success(null);
			}
		} catch (Exception e) {
			log.error("获取标准上传单位TOP10出错:"+e);
			return Result.fail("获取标准上传单位TOP10出错");
		}		
	}
    /**
     * 类别标准数量TOP5（按类型分类）
     * @return
     */
	@RequestMapping(value = "/home/statType/top5", method = RequestMethod.GET)
	@ApiOperation(value="类别标准数量TOP5",notes = "类别标准数量TOP5")
	public Result<List<StandardTypeDTO>> statTypeTop5() {
		try {
			//标准总数
			Integer standardNum = standardFileService.getStandardNum();
			if(standardNum==null||standardNum==0){
				return Result.success(null);
			}
			List<StandardTypeDO> list = standardFileService.getTypeTop5();
			if(list!=null&&list.size()!=0){
				//添加占比
				DecimalFormat df = new DecimalFormat("#.##");
				for(StandardTypeDO standardTypeDO:list){
		        	if(standardTypeDO==null){
		        		continue;
		        	}
					Integer count = standardTypeDO.getCount();
					if(count!=null){
						Double proportion = (double)(count*100/standardNum);
						standardTypeDO.setProportion(df.format(proportion));
					}else{
						standardTypeDO.setProportion("0.00");
					}					
				}
				List<StandardTypeDTO> result = dozerUtils.mapList(list, StandardTypeDTO.class);
				return Result.success(result);
			}else{
				return Result.success(null);
			}
		} catch (Exception e) {
			log.error("获取类别标准数量TOP5出错:"+e);
			return Result.fail("获取类别标准数量TOP5出错");
		}
	}
    /**
     * 标准文档下载数量TOP20
     * @return
     */
	@RequestMapping(value = "/home/downLoad/top20", method = RequestMethod.GET)
	@ApiOperation(value="标准文档下载数量TOP20",notes = "标准文档下载数量TOP20")
	public Result<List<StandardDownloadDTO>> statDownloadTop20() {
		try {
			List<StandardDownloadDO> list = standardFileLogService.getDownloadTop20();
			if(list!=null&&list.size()!=0){
				List<StandardDownloadDTO> result = dozerUtils.mapList(list, StandardDownloadDTO.class);
				return Result.success(result);
			}else{
				return Result.success(null);
			}
		} catch (Exception e) {
			log.error("获取标准文档下载数量TOP20出错:"+e);
			return Result.fail("获取标准文档下载数量TOP20出错");
		}
	}
    /**
     * 标准分类分析
     * @return
     */
	@RequestMapping(value = "/home/statType/analysis", method = RequestMethod.GET)
	@ApiOperation(value="标准分类分析",notes = "标准分类分析")
	public Result<List<StandardDownloadDTO>> statTypeAnalysis() {
		try {
			List<StandardDownloadDO> list = new ArrayList<StandardDownloadDO>();
			// 获取一级目录的所有资源
			List<Map<String,Object>> mapList = standardFileLogService.getStandardClassifyFirstLevelDirectory();
			if(mapList.size() >0 ) {
				for(Map<String,Object> map :mapList) {
					Long id = Long.parseLong(map.get("id").toString());
					String name = map.get("name").toString();
					// 递归统计
					Integer count = standardFileLogService.getRecursionCount(id);
					StandardDownloadDO enDO = new StandardDownloadDO();
					enDO.setId(id);
					enDO.setName(name);
					enDO.setCount(count);
					list.add(enDO);
				}
			}
			// 降序排列
			list.sort((h1, h2) -> h2.getCount().compareTo(h1.getCount()));
			
			if(list!=null&&list.size()!=0){
				List<StandardDownloadDTO> result = dozerUtils.mapList(list, StandardDownloadDTO.class);
				return Result.success(result);
			}else{
				return Result.success(null);
			}
		} catch (Exception e) {
			log.error("获取标准分类分析出错:"+e);
			return Result.fail("获取标准分类分析出错");
		}
	}
    /**
     * XX标准文档下载数量TOP10
     * @return
     */
	@RequestMapping(value = "/chaild/download/top10", method = RequestMethod.GET)
	@ApiOperation(value="XX标准文档下载数量TOP10",notes = "XX标准文档下载数量TOP10")
	public Result<List<StandardDownloadDTO>> statDownloadTop10(Long typeId) {
		try {
			List<StandardDownloadDO> list = standardFileLogService.getDownloadTop10(typeId);
			if(list!=null&&list.size()!=0){
				List<StandardDownloadDTO> result = dozerUtils.mapList(list, StandardDownloadDTO.class);
				return Result.success(result);
			}else{
				return Result.success(null);
			}
		} catch (Exception e) {
			log.error("获取XX标准文档下载数量TOP10出错:"+e);
			return Result.fail("获取XX标准文档下载数量TOP10出错");
		}
	}
    /**
     * XX标准数量分析
     * @return
     */
	@RequestMapping(value = "/chaild/type/count", method = RequestMethod.GET)
	@ApiOperation(value="XX标准数量分析",notes = "XX标准数量分析")
	public Result<List<StandardMonthDTO>> statTypeCount(Long typeId) {
		try {
			//获取一年前时间
			Date date = DateUtil.getYearBackDate();
			List<StandardMonthDO> list = standardFileService.getTypeCount(typeId, date);
			if(list!=null&&list.size()!=0){
				List<StandardMonthDTO> result = dozerUtils.mapList(list, StandardMonthDTO.class);
				return Result.success(result);
			}else{
				return Result.success(null);
			}
		} catch (Exception e) {
			log.error("获取XX标准数量分析出错:"+e);
			return Result.fail("获取XX标准数量分析出错");
		}
	}
    /**
     * XX标准文档下载趋势
     * @return
     */
	@RequestMapping(value = "/chaild/download/trend", method = RequestMethod.GET)
	@ApiOperation(value="XX标准文档下载趋势",notes = "XX标准文档下载趋势")
	public Result<List<StandardMonthDTO>> statDownloadTrend(Long typeId) {
		try {
			//获取一年前时间
			Date date = DateUtil.getYearBackDate();
			List<StandardMonthDO> list = standardFileLogService.getDownloadTrend(typeId,date);
			if(list!=null&&list.size()!=0){
				List<StandardMonthDTO> result = dozerUtils.mapList(list, StandardMonthDTO.class);
				return Result.success(result);
			}else{
				return Result.success(null);
			}
		} catch (Exception e) {
			log.error("获取XX标准文档下载趋势出错:"+e);
			return Result.fail("获取XX标准文档下载趋势出错");
		}
	}
    /**
     * XX标准文档上传单位top10
     * @return
     */
	@RequestMapping(value = "/chaild/uploadCompany/top10", method = RequestMethod.GET)
	@ApiOperation(value="XX标准文档上传单位top10",notes = "XX标准文档上传单位top10")
	public Result<List<UploadCompanyDTO>> statUploadCompanyTop10(Long typeId) {
		try {
			List<UploadCompanyDO> list = standardFileService.getUploadCompanyTop10(typeId);
			if(list!=null&&list.size()!=0){
				List<UploadCompanyDTO> result = dozerUtils.mapList(list, UploadCompanyDTO.class);
				return Result.success(result);
			}else{
				return Result.success(null);
			}
		} catch (Exception e) {
			log.error("获取XX标准文档上传单位top10出错:"+e);
			return Result.fail("获取XX标准文档上传单位top10出错");
		}
	}
	
	/**
     * 描述：获取运维文档某一分类及子集的ids
     */
	private List<String> getClassifyIds(Long classifyId) {
        List<String> result = new ArrayList<String>();
        StandardClassifyExample standardClassifyExample = new StandardClassifyExample();
        standardClassifyExample.createCriteria().andIsEnableEqualTo(true);
        standardClassifyExample.setOrderByClause("parent_id,sort_no");
        List<StandardClassify> standardClassifyList = standardClassifyService.find(standardClassifyExample);
        List<StandardClassifyTreeDTO> resultTree = null;
        if (standardClassifyList != null) {
            List<StandardClassifyTreeDTO> treeList = dozerUtils.mapList(standardClassifyList,
                    StandardClassifyTreeDTO.class);
            resultTree = ReturnTreeUtills.useListRecordToTree(treeList,classifyId+"");
        }
        if(resultTree.size() >= 1){
            ergodicList(resultTree,result);
        }else{
            result.add(classifyId + "");
        }
        return  result;
    }
	/**
	 * 前序遍历得到所有的id
	 * @param resultTree
	 * @param result
	 * @return
	 */
    private List<String> ergodicList(List<StandardClassifyTreeDTO> resultTree,List<String> result){
        for (StandardClassifyTreeDTO dto : resultTree){
            result.add(dto.getId().toString());
            if(dto.getChildren() != null){
                List<StandardClassifyTreeDTO> children = dto.getChildren();
                ergodicList(children,result);
            }
        }
        return result;
    }
}
