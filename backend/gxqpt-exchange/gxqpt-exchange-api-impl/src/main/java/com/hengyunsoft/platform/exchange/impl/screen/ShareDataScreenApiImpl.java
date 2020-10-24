package com.hengyunsoft.platform.exchange.impl.screen;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hengyunsoft.base.Result;
import com.hengyunsoft.commons.utils.DateUtils;
import com.hengyunsoft.commons.utils.context.DozerUtils;
import com.hengyunsoft.page.plugins.openapi.OpenApiReq;
import com.hengyunsoft.platform.exchange.api.dataapi.dto.dataapi.ApiQueryConditionDTO;
import com.hengyunsoft.platform.exchange.api.screen.dto.DataTrendDTO;
import com.hengyunsoft.platform.exchange.api.screen.dto.DirDataCount;
import com.hengyunsoft.platform.exchange.api.screen.dto.OrgApiViewDTO;
import com.hengyunsoft.platform.exchange.api.screen.dto.OrgDataDTO;
import com.hengyunsoft.platform.exchange.api.screen.dto.RelationshipDTO;
import com.hengyunsoft.platform.exchange.api.screen.dto.ScreenApiRealDTO;
import com.hengyunsoft.platform.exchange.api.screen.dto.ScreenDataCountDTO;
import com.hengyunsoft.platform.exchange.api.screen.dto.ScreenDataViewDTO;
import com.hengyunsoft.platform.exchange.constant.ExchangeConstants;
import com.hengyunsoft.platform.exchange.entity.api.domain.ApiCallDO;
import com.hengyunsoft.platform.exchange.entity.api.domain.ApiDirCallDO;
import com.hengyunsoft.platform.exchange.entity.api.po.ShareDataApi;
import com.hengyunsoft.platform.exchange.entity.directory.po.ShareDataDirectoryWare;
import com.hengyunsoft.platform.exchange.entity.directory.po.domain.DirViewDO;
import com.hengyunsoft.platform.exchange.entity.directory.po.domain.ShareDataDirecoryUnitNumDO;
import com.hengyunsoft.platform.exchange.entity.screen.po.ApiTopDO;
import com.hengyunsoft.platform.exchange.entity.screen.po.OrgApiViewDO;
import com.hengyunsoft.platform.exchange.entity.set.po.ShareDataSet;
import com.hengyunsoft.platform.exchange.entity.system.domain.JoinOrgDO;
import com.hengyunsoft.platform.exchange.repository.api.example.ShareDataApiExample;
import com.hengyunsoft.platform.exchange.repository.api.service.ShareDataApiCallService;
import com.hengyunsoft.platform.exchange.repository.api.service.ShareDataApiService;
import com.hengyunsoft.platform.exchange.repository.directory.example.ShareDataDirectoryWareExample;
import com.hengyunsoft.platform.exchange.repository.directory.service.DataDirectoryWareService;
import com.hengyunsoft.platform.exchange.repository.set.example.ShareDataSetExample;
import com.hengyunsoft.platform.exchange.repository.set.service.ShareDataSetService;
import com.hengyunsoft.platform.exchange.repository.system.example.ShareJoinOrgExample;
import com.hengyunsoft.platform.exchange.repository.system.service.ShareJoinOrgService;
import com.hengyunsoft.platform.exchange.util.ShareUtil;

import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * 数博会数据共享交换
 * @author wgj
 * @createTime 2018-01-25 10:49
 */
@RestController
@Slf4j
@RequestMapping("screen")
@Api(value = "共享交换", description = "数据共享交换页")
public class ShareDataScreenApiImpl /*implements ShareDataScreenApi*/{
    @Autowired
    ShareJoinOrgService shareJoinOrgService;
    @Autowired
    DataDirectoryWareService dataDirectoryWareService;
    @Autowired
    ShareDataSetService shareDataSetService;
    @Autowired
    ShareDataApiService shareDataApiService;
    @Autowired
    ShareDataApiCallService shareDataApiCallService;
    @Autowired
    private DozerUtils dozerUtils;
    /**
     *查询首页统计数据
     * 包含接入部门，数据目录，数据集，API,访问量，调用次数
     * @return
     * @Author wgj
     * @createtime 2018-05-01
     */
    @RequestMapping(value = "/getShareDataCount", method = RequestMethod.POST)
    
    public Result<ScreenDataCountDTO> getShareDataCount() {
            ScreenDataCountDTO countdto = new ScreenDataCountDTO();
            //接入部门
            int joinOrgCount=shareJoinOrgService.count(new ShareJoinOrgExample());
            countdto.setJoinOrgCount(joinOrgCount);
            //数据目录
            ShareDataDirectoryWareExample example=new ShareDataDirectoryWareExample();
            example.createCriteria().andIsBottomEqualTo(ExchangeConstants.IS_BOTTOM_YES).andDataStatusEqualTo(ExchangeConstants.DATA_STATUS_YES);
            int dirCount=dataDirectoryWareService.count(example);
            countdto.setDirectoryCount(dirCount);
            //数据集
            ShareDataSetExample setExample=new ShareDataSetExample();
            setExample.createCriteria().andStatusEqualTo(ExchangeConstants.DATA_SET_ON_SHELF);
            int setCount=shareDataSetService.count(setExample);
            countdto.setSetCount(setCount);
            //API数量
             ShareDataApiExample apiExample = new ShareDataApiExample();
             apiExample.createCriteria().andAuthStatusEqualTo(ExchangeConstants.API_AUTH_STATUS_PASS);
             int apiCount=shareDataApiService.count(apiExample);
             countdto.setApiCount(apiCount);
             //当日调用次数
             int callCount=shareDataApiCallService.getApiCallCount(new Date());
             countdto.setCallCount(callCount);
        return Result.success(countdto);
    }
    /**
     *按月查询平台数据情况
     * 数据目录，数据集，API
     * @return
     * @Author wgj
     * @createtime 2018-05-01
     */
    @RequestMapping(value = "/getShareDataView", method = RequestMethod.POST)
    
    public Result<ScreenDataViewDTO> getShareDataView() {
        ScreenDataViewDTO viewDTO = new ScreenDataViewDTO();
        Map<String,String> monthmap =ExchangeConstants.monthmap;
        int now =Integer.valueOf(ShareUtil.getMonth(new Date()));
        String year=ShareUtil.getYear(new Date());
        List<String> busTitle= new ArrayList<String>();
        List<Integer>   dirList = new ArrayList<Integer>();
        List<Integer>   setList = new ArrayList<Integer>();
        List<Integer>   apiList = new ArrayList<Integer>();
        for (String monthKey : monthmap.keySet() ) {
              if(now >= Integer.valueOf(monthKey)){//当前月之前的数据（包含当前月）
                  busTitle.add(monthmap.get(monthKey));
                  int dirCount=dataDirectoryWareService.getDirCount(year,monthKey);
                  int setCount=dataDirectoryWareService.getSetCount(year,monthKey);
                  int apiCount=dataDirectoryWareService.getApiCount(year,monthKey);
                  dirList.add(dirCount);
                  setList.add(setCount);
                  apiList.add(apiCount);
              }
        }
        viewDTO.setBusTitle(busTitle);
        viewDTO.setDirList(dirList);
        viewDTO.setSetList(setList);
        viewDTO.setApiList(apiList);
        return Result.success(viewDTO);
    }
    /**
     *部门共享情况
     * 目录数与Api数
     * @return
     * @Author wgj
     * @createtime 2018-05-01
     */
    @RequestMapping(value = "/getOrgUseView", method = RequestMethod.POST)
    
    public Result<OrgApiViewDTO> getOrgUseView() {
        OrgApiViewDTO viewDTO = new OrgApiViewDTO();
        List<String> busTitle= new ArrayList<String>();
        List<Integer>   apiList = new ArrayList<Integer>();
        List<Integer>   dirList = new ArrayList<Integer>();
        //查询部门的API数量
        List<OrgApiViewDO> list= dataDirectoryWareService.getOrgApiCount();
        for (OrgApiViewDO viewdo: list) {
                 busTitle.add(viewdo.getUnitName());
                 apiList.add(viewdo.getApiCount());
                 //根据单位查询目录数
                int dirCount=dataDirectoryWareService.getOrgDirCount(viewdo.getUnitId());
            dirList.add(dirCount);
        }
        viewDTO.setBusTitle(busTitle);
        viewDTO.setApiList(apiList);
        viewDTO.setDirList(dirList);
        return Result.success(viewDTO);
    }
    /**
     *API调用TOP10
     * @return
     * @Author wgj
     * @createtime 2018-05-01
     */
    @RequestMapping(value = "/getApiCallTopList", method = RequestMethod.POST)
    
    public Result<OrgApiViewDTO> getApiCallTopList() {
        OrgApiViewDTO viewDTO = new OrgApiViewDTO();
        List<String> busTitle= new ArrayList<String>();
        List<Integer>   apiList = new ArrayList<Integer>();
        List<ApiTopDO> list=dataDirectoryWareService.getApiCallTopList();
        List<Map<String,Object>> returnList= new ArrayList<Map<String,Object>>();
        for (ApiTopDO viewdo: list) {
            if(viewdo!=null){
                Map<String,Object> map=new HashMap<String,Object>();
                map.put("name",viewdo.getApiName());
                map.put("value",viewdo.getApiCallCount());
                returnList.add(map);
            }
        }
        viewDTO.setReturnList(returnList);
        return  Result.success(viewDTO);
    }
    /**
     *数据趋势
     * @Author wgj
     * @createtime 2018-05-01
     */
    @RequestMapping(value = "/getDataTrend", method = RequestMethod.POST)
    
    public Result<DataTrendDTO> getDataTrend() {
        DataTrendDTO trendDTO = new DataTrendDTO();
        Map<String,String> monthmap =ExchangeConstants.monthmap;
        List<Integer>   apiCallList = new ArrayList<Integer>();
        List<Integer>   dataList = new ArrayList<Integer>();
        List<String> busTitle= new ArrayList<String>();
        String year=ShareUtil.getYear(new Date());
        int now =Integer.valueOf(ShareUtil.getMonth(new Date()));
        for (String monthKey : monthmap.keySet() ) {
            if(now >= Integer.valueOf(monthKey)) {//当前月之前的数据（包含当前月）
                busTitle.add(monthmap.get(monthKey));
                //查询调用次数
                int apiCallCount = dataDirectoryWareService.getApiCallCount(year, monthKey);
                apiCallList.add(apiCallCount);
                //数据交换量
                int dataCount = dataDirectoryWareService.getTransDataCount(year, monthKey);
                dataList.add(dataCount);
            }
        }
        trendDTO.setApiCallList(apiCallList);
        trendDTO.setDataList(dataList);
        trendDTO.setBusTitle(busTitle);
        return Result.success(trendDTO);
    }
    /**
     *api实时调用
     * @Author wgj
     * @createtime 2018-05-01
     */
    @RequestMapping(value = "/getApiRealTimeCall", method = RequestMethod.GET)
    
    public Result<List<ScreenApiRealDTO>> getApiRealTimeCall() {
        List<ApiCallDO> list=shareDataApiCallService.getApiRealTimeCall();
        List<ScreenApiRealDTO> busView = dozerUtils.mapPage(list, ScreenApiRealDTO.class);
        return  Result.success(busView);
    }
    /**
     *共享交换调用关系
     * @Author wgj
     * @createtime 2018-05-01
     */
    @RequestMapping(value = "/getCallRelationship", method = RequestMethod.GET)
    
    public Result<List<RelationshipDTO>> getCallRelationship() {
        List<RelationshipDTO> relList=new ArrayList<RelationshipDTO>();
        //查询已接入单位拥有那些目录
        List<JoinOrgDO> unitList=shareJoinOrgService.getJoinUnitList();
        if (unitList!=null && unitList.size() > 0 ){
            for (JoinOrgDO org : unitList) {
                 RelationshipDTO ship=new RelationshipDTO();
                 ship.setCategory("dw");
                 ship.setName(org.getUnitName());
                 ship.setSortValue(0);
                 List<Map<String,Object>> target=new ArrayList<Map<String,Object>>();
                //根据单位查询目录
                 List<DirViewDO> dirList=dataDirectoryWareService.getListByUnit(org.getUnitId());
                 if (dirList!=null && dirList.size() > 0 ){
                     for (DirViewDO dir:dirList ) {
                         //单位拥有目录
                         Map<String,Object> tmp =new HashMap<>();
                         tmp.put("name",dir.getName());
                         tmp.put("type","(拥有)目录");
                         target.add(tmp);
                     }
                 }
                //查询单位申请的api
                List<ApiCallDO> sqList=shareDataApiCallService.getUnitListByUnitId(org.getUnitId());
                if(sqList!=null && sqList.size() > 0){
                    for (ApiCallDO dwsq:sqList ) {
                        Map<String,Object> dwsqtmp =new HashMap<>();
                        dwsqtmp.put("name",dwsq.getApiName());
                        dwsqtmp.put("type","申请");
                        target.add(dwsqtmp);
                    }
                }
                 ship.setTarget(target);
                 relList.add(ship);
            }
        }
        //查询目录拥有那些数据集
        ShareDataDirectoryWareExample diremp=new ShareDataDirectoryWareExample();
        diremp.createCriteria().andIsBottomEqualTo(ExchangeConstants.IS_BOTTOM_YES).andDataStatusEqualTo(ExchangeConstants.DATA_STATUS_YES);
        List<ShareDataDirectoryWare> dirList=dataDirectoryWareService.find(diremp);
        if(dirList!=null && dirList.size() > 0 ){
            for (ShareDataDirectoryWare dir :dirList ) {
                //目录拥有数据集
                RelationshipDTO mlship=new RelationshipDTO();
                List<Map<String,Object>> mltarget=new ArrayList<Map<String,Object>>();
                mlship.setCategory("ml");
                mlship.setName(dir.getDirName());
                mlship.setSortValue(1);
                //是否存在数据集
                if (dir.getSetId()!=null && dir.getSetId() > 0 ){
                    ShareDataSetExample setExample= new ShareDataSetExample();
                    setExample.createCriteria().andStatusEqualTo(ExchangeConstants.DATA_SET_ON_SHELF).andIdEqualTo(dir.getSetId());
                    ShareDataSet set=shareDataSetService.getUnique(setExample);
                    if(set!=null){
                        Map<String,Object> sjjtmp =new HashMap<>();
                        sjjtmp.put("name",set.getSetName());
                        sjjtmp.put("type","(拥有)数据集");
                        mltarget.add(sjjtmp);
                    }
                }
                mlship.setTarget(mltarget);
                relList.add(mlship);
            }
        }
        //查询数据集有哪些api
        ShareDataSetExample setExample= new ShareDataSetExample();
        setExample.createCriteria().andStatusEqualTo(ExchangeConstants.DATA_SET_ON_SHELF);
        List<ShareDataSet> setList=shareDataSetService.find(setExample);
        if (setList!=null && setList.size() > 0 ){
            for (ShareDataSet set:setList ) {
                    //数据集拥有那些api(及目录拥有那些api,因为目录与api 1对1)
                    RelationshipDTO sjjship=new RelationshipDTO();
                    List<Map<String,Object>> sjjtarget=new ArrayList<Map<String,Object>>();
                    sjjship.setCategory("sjj");
                    sjjship.setName(set.getSetName());
                    sjjship.setSortValue(2);
                    List<ShareDataApi> apiList=shareDataApiService.getApiListBySetId(set.getId());
                    if(apiList!=null && apiList.size() > 0){
                        for (ShareDataApi api:apiList) {
                            Map<String,Object> apitmp =new HashMap<>();
                            apitmp.put("name",api.getApiName());
                            apitmp.put("type","(拥有)API");
                            sjjtarget.add(apitmp);
                        }
                    }
                    sjjship.setTarget(sjjtarget);
                    relList.add(sjjship);
            }
        }

        //查询api被那些单位申请获共享

        ShareDataApiExample apiExample = new ShareDataApiExample();
        apiExample.createCriteria().andAuthStatusEqualTo(ExchangeConstants.API_AUTH_STATUS_PASS).andApiStatusEqualTo(ExchangeConstants.API_STATUS_YES);
        List<ShareDataApi> apiList=shareDataApiService.find(apiExample);
        if(apiList!=null && apiList.size() > 0){
            for (ShareDataApi api:apiList) {
                    RelationshipDTO apiship=new RelationshipDTO();
                    List<Map<String,Object>> apitarget=new ArrayList<Map<String,Object>>();
                    apiship.setCategory("api");
                    apiship.setName(api.getApiName());
                    apiship.setSortValue(3);
                    //查询api共享给那些单位了
                    List<ApiCallDO> gsList=shareDataApiCallService.getShareUnitListByApiId(api.getId());
                    if(gsList!=null && gsList.size() > 0){
                        for (ApiCallDO dwsq:gsList ) {
                            Map<String,Object> gxtmp =new HashMap<>();
                            gxtmp.put("name",dwsq.getUnitName());
                            gxtmp.put("type","共享");
                            apitarget.add(gxtmp);
                        }
                    }
                apiship.setTarget(apitarget);
                relList.add(apiship);
            }
        }
        return Result.success(relList);
    }


    /**
     *整体概览
     * @return 数据目录，数据量
     * @Author wgj
     * @createtime 2018-05-01
     */
    @RequestMapping(value = "/getDirDataCount", method = RequestMethod.GET)
    
    public Result<DirDataCount> getDirDataCount(String unitId) {
        DirDataCount data=new DirDataCount();
        //数据目录
        int dirCount=dataDirectoryWareService.getOrgDirCount(unitId);
        data.setDirCount(dirCount);
        //数据量
        int dataCount=shareDataSetService.getSetCountByUnitId(unitId);
        data.setDataCount(dataCount);
        //接入部门
        int joinOrgCount=shareJoinOrgService.count(new ShareJoinOrgExample());
        data.setOrgCount(joinOrgCount);
        /*//api数量
        ShareDataApiExample apiExample = new ShareDataApiExample();
        apiExample.createCriteria().andAuthStatusEqualTo(ExchangeConstants.API_AUTH_STATUS_PASS).andUnitIdEqualTo(unitId);
        int apiCount=shareDataApiService.count(apiExample);
        data.setApiCount(apiCount);*/
        return Result.success(data);
    }


    /**
     *整体概览(部门统计)
     * @return 数据目录，数据量，api量
     * @Author wgj
     * @createtime 2018-05-01
     */
    @RequestMapping(value = "/getOrgDataCount", method = RequestMethod.GET)
    
    public Result<OrgDataDTO> getOrgDataCount() {
        OrgDataDTO data=new OrgDataDTO();
         List<Integer> dirList=new ArrayList<Integer>();
         List<Integer> apiList=new ArrayList<Integer>();
         List<String> orgList=new ArrayList<String>();
        List<JoinOrgDO> unitList=shareJoinOrgService.getUnitDirList();
        if(unitList!=null && unitList.size() > 0 ){
            for (JoinOrgDO org:unitList ) {
                //目录数
                dirList.add(org.getDirCount());
                //api数量
                int apicount=shareDataApiService.getApiCountByUnit(org.getUnitId());
                apiList.add(apicount);
                orgList.add(org.getUnitName());
            }
        }
        data.setDirList(dirList);
        data.setApiList(apiList);
        data.setOrgList(orgList);
        return Result.success(data);
    }


    /**
     * 查询共享交换分析目录数量月度数据
     * com.hengyunsoft.platform.exchange.impl.screen
     * 版权：中科恒运软件科技股份有限公司贵阳分公司
     * 描述：角色管理Api
     * 修改人：zhaopengfei
     * 修改时间：2019/3/12
     * 修改内容：新增基础接口
     */
    @RequestMapping(value = "/getDirMonthData", method = RequestMethod.GET)
    public Result<List<ShareDataDirecoryUnitNumDO>> getDirMonthData(String year) {
        if(StringUtils.isEmpty(year)){
            SimpleDateFormat yearSdf = new SimpleDateFormat("yyyy");
            year = yearSdf.format(new Date());
        }
        List<ShareDataDirecoryUnitNumDO> data = dataDirectoryWareService.queryDirMonthData(year);
        return Result.success(data);
    }

    /**
     * 查询目录占比
     * com.hengyunsoft.platform.exchange.impl.screen
     * 版权：中科恒运软件科技股份有限公司贵阳分公司
     * 描述：角色管理Api
     * 修改人：zhaopengfei
     * 修改时间：2019/3/12
     * 修改内容：新增基础接口
     */
    @RequestMapping(value = "/getDirTypeNum", method = RequestMethod.GET)
    public Result<ShareDataDirecoryUnitNumDO> getDirTypeNum() {
        ShareDataDirecoryUnitNumDO data = dataDirectoryWareService.queryDirTypeNum();
        return Result.success(data);
    }

    /**
     * 查询目录月度调用次数（按照共享与非共享分类）
     * com.hengyunsoft.platform.exchange.impl.screen
     * 版权：中科恒运软件科技股份有限公司贵阳分公司
     * 描述：角色管理Api
     * 修改人：zhaopengfei
     * 修改时间：2019/3/12
     * 修改内容：新增基础接口
     */
    @RequestMapping(value = "/getDirMonthCallInfo", method = RequestMethod.GET)
    public Result<List<ApiDirCallDO>> getDirMonthCallInfo(String year) {
        if(StringUtils.isEmpty(year)){
            SimpleDateFormat yearSdf = new SimpleDateFormat("yyyy");
            year = yearSdf.format(new Date());
        }
        List<ApiDirCallDO> data = shareDataApiCallService.queryMonthCallInfo(year);
        return Result.success(data);
    }

    /**
     * 查询各单位开放与不开放的占比
     * com.hengyunsoft.platform.exchange.impl.screen
     * 版权：中科恒运软件科技股份有限公司贵阳分公司
     * 描述：角色管理Api
     * 修改人：zhaopengfei
     * 修改时间：2019/3/12
     * 修改内容：新增基础接口
     */
    @RequestMapping(value = "/getUnitDirTypeNum", method = RequestMethod.GET)
    public Result<List<ShareDataDirecoryUnitNumDO>> getUnitDirTypeNum() {
        List<ShareDataDirecoryUnitNumDO> data = dataDirectoryWareService.queryUnitDirTypeNum();
        return Result.success(data);
    }


    /**
     * 共享交换分析查询API调用信息
     * @param openApiReq shareWay:1:开放，2：不开放
     * com.hengyunsoft.platform.exchange.impl.screen
     * 版权：中科恒运软件科技股份有限公司贵阳分公司
     * 描述：角色管理Api
     * 修改人：zhaopengfei
     * 修改时间：2019/3/12
     * 修改内容：新增基础接口
     */
    @RequestMapping(value = "/getApiCallInfo", method = RequestMethod.POST)
    public Result<PageInfo<ApiCallDO>> getApiCallInfo(@RequestBody OpenApiReq<Integer> openApiReq) {
        Integer shareWay = openApiReq.getData();
        if(ObjectUtils.isEmpty(shareWay)){
            shareWay = 1;
        }
        PageHelper.startPage(openApiReq.getPageNo(), openApiReq.getPageSize());
        List<ApiCallDO> data = shareDataApiCallService.queryApiCallInfo(shareWay);
        return Result.success(new PageInfo<>(data));
    }


}
