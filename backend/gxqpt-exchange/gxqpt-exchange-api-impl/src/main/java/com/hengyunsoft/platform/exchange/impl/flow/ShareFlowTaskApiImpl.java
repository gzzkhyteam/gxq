package com.hengyunsoft.platform.exchange.impl.flow;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hengyunsoft.base.Result;
import com.hengyunsoft.commons.constant.SearchConstants;
import com.hengyunsoft.commons.context.BaseContextHandler;
import com.hengyunsoft.commons.exception.core.ExchangeExceptionCode;
import com.hengyunsoft.commons.utils.DateUtils;
import com.hengyunsoft.commons.utils.context.DozerUtils;
import com.hengyunsoft.page.plugins.openapi.OpenApiReq;
import com.hengyunsoft.platform.admin.api.core.api.GxqptEmpApi;
import com.hengyunsoft.platform.admin.api.core.dto.emp.GxqptEmpRetDTO;
import com.hengyunsoft.platform.exchange.api.dataapi.dto.demand.DemandFileDTO;
import com.hengyunsoft.platform.exchange.api.directory.dto.directory.DataDirectoryAuditDTO;
import com.hengyunsoft.platform.exchange.api.directory.dto.directory.DataDirectoryPageReqAuditDTO;
import com.hengyunsoft.platform.exchange.api.flow.dto.*;
import com.hengyunsoft.platform.exchange.api.set.dto.DataSetElementDTO;
import com.hengyunsoft.platform.exchange.api.set.dto.DatabaseTableDTO;
import com.hengyunsoft.platform.exchange.api.set.dto.QueryDataSetParamReqDTO;
import com.hengyunsoft.platform.exchange.api.set.dto.QueryDataSetResEleDTO;
import com.hengyunsoft.platform.exchange.constant.FileBusType;
import com.hengyunsoft.platform.exchange.entity.api.po.ShareDataApi;
import com.hengyunsoft.platform.exchange.entity.api.po.ShareDataApiRenewal;
import com.hengyunsoft.platform.exchange.entity.api.po.ShareDataApiUser;
import com.hengyunsoft.platform.exchange.entity.api.po.ShareDataDemand;
import com.hengyunsoft.platform.exchange.entity.directory.po.*;
import com.hengyunsoft.platform.exchange.entity.directory.po.domain.ShareDataDirectoryAuditDO;
import com.hengyunsoft.platform.exchange.entity.set.domain.ShareDataSetDO;
import com.hengyunsoft.platform.exchange.entity.set.po.*;
import com.hengyunsoft.platform.exchange.entity.system.domain.FlowApiListDO;
import com.hengyunsoft.platform.exchange.entity.system.domain.FlowDemanListDO;
import com.hengyunsoft.platform.exchange.entity.system.po.ShareFlowTask;
import com.hengyunsoft.platform.exchange.impl.set.dataread.database.DataBaseDescManager;
import com.hengyunsoft.platform.exchange.repository.api.example.ShareDataApiExample;
import com.hengyunsoft.platform.exchange.repository.api.example.ShareDataApiRenewalExample;
import com.hengyunsoft.platform.exchange.repository.api.example.ShareDataApiUserExample;
import com.hengyunsoft.platform.exchange.repository.api.example.ShareDataDemandExample;
import com.hengyunsoft.platform.exchange.repository.api.service.ShareDataApiRenewalService;
import com.hengyunsoft.platform.exchange.repository.api.service.ShareDataApiService;
import com.hengyunsoft.platform.exchange.repository.api.service.ShareDataApiUserService;
import com.hengyunsoft.platform.exchange.repository.api.service.ShareDataDemandService;
import com.hengyunsoft.platform.exchange.repository.common.service.CommonService;
import com.hengyunsoft.platform.exchange.repository.directory.example.ShareDataDirectoryExample;
import com.hengyunsoft.platform.exchange.repository.directory.example.ShareUnitExample;
import com.hengyunsoft.platform.exchange.repository.directory.example.ShareUnitWareExample;
import com.hengyunsoft.platform.exchange.repository.directory.service.*;
import com.hengyunsoft.platform.exchange.repository.set.example.ShareDataFileExample;
import com.hengyunsoft.platform.exchange.repository.set.service.*;
import com.hengyunsoft.platform.exchange.repository.system.example.ShareFlowAuditExample;
import com.hengyunsoft.platform.exchange.repository.system.service.ShareFlowAuditService;
import com.hengyunsoft.platform.exchange.repository.system.service.ShareFlowService;
import com.hengyunsoft.platform.exchange.repository.system.service.ShareFlowTaskService;
import com.hengyunsoft.platform.exchange.util.SearchQueueUtil;
import com.hengyunsoft.platform.exchange.utils.DataBaseSql;
import com.hengyunsoft.platform.exchange.utils.GxqPtRoleUnits;
import com.hengyunsoft.platform.search.queue.SearchQueueProducer;
import com.hengyunsoft.platform.search.queue.dto.DeleteIndexDTO;
import com.hengyunsoft.platform.search.queue.dto.IndexItemDTO;
import com.hengyunsoft.utils.BizAssert;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 待办任务
 *
 * @author wgj
 * @createTime 2018-01-25 10:49
 */
@RestController
@Slf4j
@RequestMapping("task")
@Api(value = "待办任务", description = "查询我审批的各种任务")
public class ShareFlowTaskApiImpl /*implements ShareFlowTaskApi*/ {

    @Autowired
    private CommonService commonService;

    @Autowired
    private DozerUtils dozerUtils;

    @Autowired
    private ShareFlowTaskService shareFlowTaskService;

    @Autowired
    private ShareDataFileService shareDataFileService;

    @Autowired
    private ShareFlowService shareFlowService;

    @Autowired
    private ShareDataDemandService shareDataDemandService;

    @Autowired
    private ShareDataSetService shareDataSetService;
    @Autowired
    private ShareDataSetWareService shareDataSetWareService;
    @Autowired
    private DataDirectoryService dataDirectoryService;

    @Autowired
    private ShareDataApiRenewalService shareDataApiRenewalService;
    @Autowired
    private DataElementService dataElementService;
    @Autowired
    private DataElementWareService dataElementWareService;

    @Autowired
    private ShareDataApiUserService shareDataApiUserService;

    @Autowired
    private ShareDataChangeService shareDataChangeService;
    @Autowired
    private DataDirectoryWareService dataDirectoryWareService;
    @Autowired
    private ShareDataChangeElementService shareDataChangeElementService;

    @Autowired
    private ShareFlowAuditService shareFlowAuditService;
    @Autowired
    private GxqPtRoleUnits gxqPtRoleUnits;
    @Autowired
    private ShareDataApiService shareDataApiService;
    @Autowired
    private ShareUnitService shareUnitService;
    @Autowired
    private ShareUnitWareService shareUnitWareService;

    @Autowired
    private ShareDataSetFilterService shareDataSetFilterService;
    @Autowired
    private ShareDataSetFilterWareService shareDataSetFilterWareService;
    @Autowired
    private ShareDataSetElementService shareDataSetElementService;
    @Autowired
    private ShareDataSetElementWareService shareDataSetElementWareService;
    @Autowired
    private ShareDataSetDirService shareDataSetDirService;
    @Autowired
    private ShareDataSetDirElementService shareDataSetDirElementService;
    @Autowired
    private SearchQueueProducer searchQueueProducer;

    @Autowired
    private DataBaseDescManager dataBaseDescManager;
    @Autowired
    private SearchQueueUtil searchQueueUtil;

    @Value("http://${gxqpt.hostname.nginx:127.0.0.1}:${gxqpt.port.gate:10003}/api/exchange/p/api/sharedataapiopen")
    String url;
    @Autowired
    GxqptEmpApi gxqptEmpApi;


    /**
     * 描述：获取任务处理详情
     * 参数：taskId 任务Id
     * 返回值：ShareFlowAuditDTO
     * 修改人：zhaopengfei
     * 修改时间：2018/5/6
     * 修改内容：
     */

    @ApiOperation(value = "获取任务处理详情", notes = "获取任务处理详情")
    @ApiResponses({
            @ApiResponse(code = 86508, message = "申请编码不能为空"),
    })
    @RequestMapping(value = "/gettaskhddetail", method = RequestMethod.POST)
    public Result<ShareFlowAuditDTO> getTaskHdDetail(@RequestParam("applyCode") String applyCode) {
        BizAssert.assertNotNull(ExchangeExceptionCode.TASK_APPLY_CODE_NULL, applyCode);
        ShareFlowAuditExample example = new ShareFlowAuditExample();
        example.createCriteria().andApplyCodeEqualTo(applyCode);
        ShareFlowAuditDTO dto = dozerUtils.map(shareFlowAuditService.getUnique(example), ShareFlowAuditDTO.class);
        return Result.success(dto);
    }

    /**
     * @return ShareFlowTaskDTO
     * @todo 查询目录审批任务
     * @Author wgj
     * @createtime 2018-4-22
     */

    @ApiOperation(value = "查询数据目录分页信息", notes = "查询数据目录分页信息")
    @ApiResponses({
            @ApiResponse(code = 85515, message = "需要单位管理员才能操作"),
    })
    @RequestMapping(value = "/getDirectoryTask", method = RequestMethod.POST)
    public Result<PageInfo<DataDirectoryAuditDTO>> getDirectoryTask(@RequestBody OpenApiReq<DataDirectoryPageReqAuditDTO> openApiReq) {
        Boolean gxqPtAdmin;//是否是平台管理员
        Long adminId = BaseContextHandler.getAdminId();
        gxqPtAdmin = gxqPtRoleUnits.getGxqPtRole(adminId, GxqPtRoleUnits.PT_ADMIN_ROLE_CODE);
        if (!gxqPtAdmin) {
            BizAssert.fail(ExchangeExceptionCode.CREATEDATASET_OPT_NEED_UNIT_ADMIN);
        }
        //数据验证
        BizAssert.assertNotNull(ExchangeExceptionCode.CREATEDATASET_CREATEDATASETPARAMDTO_PAGE_PARAM_NULL, openApiReq.getData());
        Map<String, Object> map = new HashMap<>();
        map.put("unitId", openApiReq.getData().getUnitId());
        map.put("status", openApiReq.getData().getStatus());
        map.put("startTime", openApiReq.getData().getStartTime());
        map.put("endTime", openApiReq.getData().getEndTime());
        PageHelper.startPage(openApiReq.getPageNo(), openApiReq.getPageSize());
        List<ShareDataDirectoryAuditDO> results = dataDirectoryService.getDirectoryTask(map);
        PageInfo<DataDirectoryAuditDTO> pageDTO = new PageInfo<>(dozerUtils.mapPage(results, DataDirectoryAuditDTO.class));
        if (pageDTO != null && pageDTO.getList() != null && pageDTO.getList().size() > 0) {
            List<String> ids=new ArrayList<>();
            for (DataDirectoryAuditDTO auditDTO : pageDTO.getList()) {
                Long personId = auditDTO.getUserId();
                ids.add(personId.toString());
            }
            String[] ids1 = ids.toArray(new String[ids.size()]);
            Result<List<GxqptEmpRetDTO>> empUser = gxqptEmpApi.findByIdsGxqpt(ids1);
            for (DataDirectoryAuditDTO managementDTO : pageDTO.getList()) {
                for(GxqptEmpRetDTO empRetDTO:empUser.getData()){
                    if(empRetDTO.getGxqptEmpId().equals(managementDTO.getUserId())){
                        managementDTO.setUserName(empRetDTO.getName());
                    }
                }
            }
        }
        return Result.success(pageDTO);

    }

    /**
     * 描述：数据目录审批处理
     * 参数：handleDTO
     * 返回值：com.hengyunsoft.base.Result<java.lang.Boolean>
     * 修改人：tianai
     * 修改时间：2018/5/2
     * 修改内容：
     */

    @ApiOperation(value = "数据目录审批处理", notes = "数据目录审批处理")
    @RequestMapping(value = "/updateDirectory", method = RequestMethod.POST)
    @ApiResponses({
            @ApiResponse(code = 86500, message = "任务Id不能为空"),
            @ApiResponse(code = 86501, message = "处理状态不能为空"),
            @ApiResponse(code = 86503, message = "审批对象不能为空"),
            @ApiResponse(code = 86504, message = "任务ID不存在"),
    })
    public Result<Boolean> updateDirectory(@RequestBody HandleDirectoryDTO dto) {
        Boolean gxqPtAdmin;//是否是平台管理员
        Long adminId = BaseContextHandler.getAdminId();
        gxqPtAdmin = gxqPtRoleUnits.getGxqPtRole(adminId, GxqPtRoleUnits.PT_ADMIN_ROLE_CODE);
        if (!gxqPtAdmin) {
            BizAssert.fail(ExchangeExceptionCode.DIRECTORY_ADMIN_NULL);
        }
        //数据验证
        BizAssert.assertNotNull(ExchangeExceptionCode.TASK_HANDLE_ENTITY_NULL, dto);
        BizAssert.assertNotNull(ExchangeExceptionCode.TASK_ID_NULL, dto.getTaskId());
        BizAssert.assertNotNull(ExchangeExceptionCode.TASK_HANDLE_STATUS_NULL, dto.getStatus());

        Long userId = BaseContextHandler.getAdminId();
        //获取单位Id
        String unitId = dto.getUnitId();
        ShareFlowTask shareFlowTask = shareFlowTaskService.getById(dto.getTaskId());
        if (shareFlowTask == null) {
            BizAssert.fail(ExchangeExceptionCode.TASK_ID_NOT_EXIST);
        }
        //查询所有变动的目录
        List<ShareDataChangeElement> eltList = shareDataChangeElementService.findChangeEmtList(unitId, shareFlowTask.getApplyCode(), 2);
        List<ShareDataChangeElement> dirList = shareDataChangeElementService.findChangeEmtList(unitId, shareFlowTask.getApplyCode(), 1);
        //审批通过
        try {
            if (dto.getStatus() == 1) {
                //是字段
                if (eltList!=null && !eltList.isEmpty()) {
                    List<ShareDataElement> updateElementList = new ArrayList<>();
                    List<ShareDataElementWare> addWereElementList = new ArrayList<>();
                    List<ShareDataElementWare> updateWereElementList = new ArrayList<>();
                    for (ShareDataChangeElement element : eltList) {
                        ShareDataElement shareDataElement = dataElementService.getById(element.getChgId());
                        if (shareDataElement != null) {
                            if (element.getChangeType() == 1) {//1,新增
                                shareDataElement.setOptType(5);//操作类型(最近一次)：1,新增；2，修改；3，删除；
                            } else if (element.getChangeType() == 3) {//删除
                                shareDataElement.setOptType(3);
                                shareDataElement.setDataStatus(2);
                            } else if (element.getChangeType() == 4) {//禁用
                                shareDataElement.setOptType(4);
                                shareDataElement.setDataStatus(3);
                            } else {//修改不调用生成api
                                shareDataElement.setOptType(5);//操作类型(最近一次)：1,新增；2，修改；3，删除，4禁用（随目录变化），5正常，6启用（随目录变化）；
                            }
                            shareDataElement.setStatus(4);
                            shareDataElement.setUpdateTime(new Date());
                            shareDataElement.setUpdateUser(Long.valueOf(userId));
                            updateElementList.add(shareDataElement);
                            ShareDataElementWare elementWare = dozerUtils.map(shareDataElement, ShareDataElementWare.class);
                            ShareDataElementWare ware = dataElementWareService.getById(shareDataElement.getId());
                            if (ware == null) {
                                elementWare.setId(shareDataElement.getId());
                                addWereElementList.add(elementWare);
                            } else {
                                updateWereElementList.add(elementWare);
                            }
                        }
                    }
                    if (updateElementList!=null && !updateElementList.isEmpty()) {
                        dataElementService.batchUpdate(updateElementList);//批量更新字段信息
                    }
                    if (addWereElementList!=null && !addWereElementList.isEmpty()) {
                        dataElementWareService.batchSave(addWereElementList);//新增字段信息到字段发布表
                    }
                    if (updateWereElementList!=null && !updateWereElementList.isEmpty()) {
                        dataElementWareService.batchUpdate(updateWereElementList);//批量更新字段信息到发布表
                    }
                }
                //是目录
                if (dirList!=null && !dirList.isEmpty()) {
                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                    String appId = BaseContextHandler.getAppId();
                    List<ShareDataDirectory> updateDirectoryList = new ArrayList<>();
                    List<ShareDataDirectoryWare> addWareDirectoryList = new ArrayList<>();
                    List<ShareDataDirectoryWare> updateWareDirectoryList = new ArrayList<>();
                    for (ShareDataChangeElement element : dirList) {
                        ShareDataDirectory dataDirectory = dataDirectoryService.getById(element.getChgId());
                        if (dataDirectory != null) {
                            dataDirectory.setDataStatus(1);//数据状态；1，正常；2，已删除；3，已禁用',
                            dataDirectory.setOptType(5);//操作类型(最近一次)：1,新增；2，修改；3，删除；4，禁用',5正常，6启用
                            List<Long> filedIds = null;//非结构话没有元数据字段
                            //是元目录 是结构化
                            if (dataDirectory.getIsBottom() == 2 && dataDirectory.getDataType() == 1) {
                                //查询字段
                                filedIds = dataElementService.getEltListByDirId(element.getChgId());
                            }
                            //查询单位
                            List<String> unitIds = shareUnitService.getUnitListByDirId(element.getChgId());

                            if (element.getChangeType() == 1) {//1新增；
                                //生成全量的api
                                if (dataDirectory.getIsBottom() == 2) {
                                    //增加门户快速搜索索引
                                    String bizId = dataDirectory.getId().toString();
                                    String content=dataDirectory.getDesc();
                                    if(content==null || content==""){
                                        content = dataDirectory.getDirName();
                                    }
                                    ShareDataDirectoryExample unitExample=new ShareDataDirectoryExample();
                                    unitExample.createCriteria().andUnitIdEqualTo(dataDirectory.getUnitId()).andParentIdEqualTo("-1");
                                    ShareDataDirectory unitDir = dataDirectoryService.getUnique(unitExample);
                                    String title = unitDir.getDirName()+"-"+dataDirectory.getDirName();
                                    String url = "/module/index?promUrl=/gxqpt-exchange/module/generalView?id=";
                                    searchQueueUtil.saveOrUpdateIndex(searchQueueUtil.covertIndexItemDto(bizId,content,title,url, SearchConstants.GXQPT_PORTAL_SEARCH_TYPE_DATA_TREE));
                                    shareDataApiService.addApiByDirAdd(dataDirectory.getId(), dataDirectory.getDirName(), dataDirectory.getUnitId(), filedIds, unitIds);
                                }
                            } else if (element.getChangeType() == 2) {//2修改
                                if (dataDirectory.getIsBottom() == 2) {
                                    shareDataApiService.addApiByDirAdd(dataDirectory.getId(), dataDirectory.getDirName(), dataDirectory.getUnitId(), filedIds, unitIds);
                                }
                            } else if (element.getChangeType() == 3) {//3删除
                                dataDirectory.setOptType(3);
                                dataDirectory.setDataStatus(2);
                                if (dataDirectory.getIsBottom() == 2) {
                                    //删除门户快速搜索索引
                                    DeleteIndexDTO indexDTO = new DeleteIndexDTO();
                                    indexDTO.setId(SearchConstants.GXQPT_PORTAL_SEARCH_TYPE_DATA_TREE + "_" + dataDirectory.getId().toString());
                                    indexDTO.setCollection(SearchConstants.GXQPT_PORTAL_SEARCH_INDEX_SET);
                                    searchQueueProducer.deleteIndex(indexDTO); //删除索引
                                    //删除目录调用禁用api
                                    shareDataApiService.deleteApiByDeleteDir(dataDirectory.getId());

                                }
                            } else if (element.getChangeType() == 4) {//禁用
                                dataDirectory.setOptType(4);
                                dataDirectory.setDataStatus(3);
                                if (dataDirectory.getIsBottom() == 2) {
                                    //删除门户快速搜索索引
                                    DeleteIndexDTO indexDTO = new DeleteIndexDTO();
                                    indexDTO.setId(SearchConstants.GXQPT_PORTAL_SEARCH_TYPE_DATA_TREE + "_" + dataDirectory.getId().toString());
                                    indexDTO.setCollection(SearchConstants.GXQPT_PORTAL_SEARCH_INDEX_SET);
                                    searchQueueProducer.deleteIndex(indexDTO); //删除索引

                                    ShareDataApiExample dataApiExample = new ShareDataApiExample();
                                    dataApiExample.createCriteria().andDirIdEqualTo(dataDirectory.getId()).andApiStatusEqualTo(1);
                                    List<ShareDataApi> apiList = shareDataApiService.find(dataApiExample);
                                    List<ShareDataApi> updateApiList = new ArrayList<>();
                                    if (apiList!=null && !apiList.isEmpty()) {
                                        for (ShareDataApi dataApi : apiList) {
                                            dataApi.setApiStatus(2);
                                            dataApi.setUpdateTime(new Date());
                                            dataApi.setUpdateUser(userId);
                                            updateApiList.add(dataApi);
                                            //增加门户快速搜索索引，为禁用时，删除索引
                                            DeleteIndexDTO deleteIndexDTO = new DeleteIndexDTO();
                                            deleteIndexDTO.setCollection(SearchConstants.GXQPT_PORTAL_SEARCH_INDEX_SET);
                                            deleteIndexDTO.setId(SearchConstants.GXQPT_PORTAL_SEARCH_TYPE_GXJH_API + "_" + dataApi.getId().toString());
                                            searchQueueProducer.deleteIndex(deleteIndexDTO); //删除索引
                                        }
                                        shareDataApiService.batchUpdate(updateApiList);
                                    }
                                }
                            } else if (element.getChangeType() == 6) {//启用
                                dataDirectory.setOptType(5);
                                dataDirectory.setDataStatus(1);
                                if (dataDirectory.getIsBottom() == 2) {
                                    //增加门户快速搜索索引
                                    IndexItemDTO indexItemDTO = new IndexItemDTO();
                                    indexItemDTO.setAppId(appId);
                                    indexItemDTO.setBizId(dataDirectory.getId().toString());
                                    indexItemDTO.setCollection(SearchConstants.GXQPT_PORTAL_SEARCH_INDEX_SET);
                                    String content = dataDirectory.getDesc();
                                    if (content != null && content != "") {
                                        indexItemDTO.setContent(dataDirectory.getDesc());
                                    } else {
                                        indexItemDTO.setContent(dataDirectory.getDirName());
                                    }
                                    indexItemDTO.setExt(simpleDateFormat.format(new Date()));
                                    indexItemDTO.setId(SearchConstants.GXQPT_PORTAL_SEARCH_TYPE_DATA_TREE + "_" + dataDirectory.getId().toString());
                                    ShareDataDirectoryExample unitExample = new ShareDataDirectoryExample();
                                    unitExample.createCriteria().andUnitIdEqualTo(dataDirectory.getUnitId()).andParentIdEqualTo("-1");
                                    ShareDataDirectory unitDir = dataDirectoryService.getUnique(unitExample);
                                    indexItemDTO.setTitle(unitDir.getDirName() + "-" + dataDirectory.getDirName());
                                    indexItemDTO.setType(SearchConstants.GXQPT_PORTAL_SEARCH_TYPE_DATA_TREE);
                                    indexItemDTO.setUrl("/module/index?promUrl=/gxqpt-exchange/module/generalView?id=" + dataDirectory.getId().toString());
                                    searchQueueProducer.addOrUpdateIndex(indexItemDTO);
                                }
                            }
                            //更新目录表
                            dataDirectory.setStatus(4);
                            dataDirectory.setUpdateTime(new Date());
                            dataDirectory.setUpdateUser(Long.valueOf(userId));
                            updateDirectoryList.add(dataDirectory);
                            ShareDataDirectoryWare shareDataDirectoryWare = dozerUtils.map(dataDirectory, ShareDataDirectoryWare.class);
                            //判断目录中心表是否存在，存在更新，否则插入
                            ShareDataDirectoryWare ware = dataDirectoryWareService.getById(dataDirectory.getId());
                            if (ware == null) {
                               boolean isExist =  isExist(dataDirectory.getId(),addWareDirectoryList);
                                if (!isExist){
                                    shareDataDirectoryWare.setId(dataDirectory.getId());
                                    addWareDirectoryList.add(shareDataDirectoryWare);
                                }
                            } else {
                                updateWareDirectoryList.add(shareDataDirectoryWare);
                            }
                            //是元目录才有共享单位
                            if (dataDirectory.getIsBottom() == 2) {
                                //删除之前的共享单位
                                shareUnitWareService.deleteWareByDirId(dataDirectory.getId());
                                //添加新的共享单位
                                ShareUnitExample unitExample = new ShareUnitExample();
                                unitExample.createCriteria().andDirIdEqualTo(dataDirectory.getId());
                                List<ShareUnit> unitList = shareUnitService.find(unitExample);
                                List<ShareUnitWare> warList = dozerUtils.mapList(unitList, ShareUnitWare.class);
                                if (warList!=null && !warList.isEmpty()) {
                                    shareUnitWareService.batchSave(warList);
                                }
                            }
                        }
                    }
                    if (updateDirectoryList!=null && !updateDirectoryList.isEmpty()) {
                        dataDirectoryService.batchUpdate(updateDirectoryList);//批量更新目录信息表
                    }
                    if (addWareDirectoryList!=null && !addWareDirectoryList.isEmpty()) {
                        dataDirectoryWareService.batchSave(addWareDirectoryList);//批量保存目录信息表（发布表）
                    }
                    if (updateWareDirectoryList!=null &&  !updateWareDirectoryList.isEmpty()) {
                        dataDirectoryWareService.batchUpdate(updateWareDirectoryList);//批量更新目录信息表（发布表）
                    }
                }

                //更新api
                List<ShareDataDirectory> list = dataDirectoryService.getChangeDirListByApplyCode(unitId, shareFlowTask.getApplyCode());
                if (list != null && list.size() > 0) {
                    for (ShareDataDirectory dir : list) {
                        //根据目录id查询字段
                        List<Long> fList = dataElementService.getEltListByDirId(dir.getId());
                        //根据目录id查询共享单位
                        List<String> dList = shareUnitService.getUnitListByDirId(dir.getId());
                        shareDataApiService.addApiByDirAdd(dir.getId(), dir.getDirName(), dir.getUnitId(), fList, dList);
                    }
                }
                //更新变动表
                shareDataChangeService.updateStatusByApplyCode(shareFlowTask.getApplyCode(), 3);
                //驳回
            } else {
                List<ShareDataChangeElement> elementList = shareDataChangeElementService.findChangeEmtList(unitId, shareFlowTask.getApplyCode(), null);
                if (elementList!=null && !elementList.isEmpty()) {
                    List<ShareDataDirectory> updateDirectoryList = new ArrayList<>();
                    List<ShareDataElement> updateEleList = new ArrayList<>();
                    ShareDataDirectory dir=null;
                    ShareDataElement elt=null;
                    for (ShareDataChangeElement element : elementList) {
                        //是目录
                        if (element.getBusType() == 1) {
                            dir = dataDirectoryService.getById(element.getChgId());
                            dir.setStatus(3);
                            updateDirectoryList.add(dir);
                            //删除共享单位
                            shareUnitService.deleteByDirId(element.getChgId());
                            //将共享单位从中心表同步到基础表
                            ShareUnitWareExample wareExample = new ShareUnitWareExample();
                            wareExample.createCriteria().andDirIdEqualTo(element.getChgId());
                            List<ShareUnitWare> oldunitList = shareUnitWareService.find(wareExample);
                            if (oldunitList!=null&& !oldunitList.isEmpty()) {
                                List<ShareUnit> unitList = dozerUtils.mapList(oldunitList, ShareUnit.class);
                                shareUnitService.batchSave(unitList);
                            }
                            //是字段
                        } else {
                            elt = dataElementService.getById(element.getChgId());
                            elt.setStatus(3);
                            updateEleList.add(elt);
                        }
                    }
                    if (updateDirectoryList!=null && !updateDirectoryList.isEmpty()) {
                        dataDirectoryService.batchUpdate(updateDirectoryList);
                    }
                    if (updateEleList!=null && !updateEleList.isEmpty()) {
                        dataElementService.batchUpdate(updateEleList);
                    }
                }
                //更新变动表
                shareDataChangeService.updateStatusByApplyCode(shareFlowTask.getApplyCode(), 2);
            }
            //插入流程审批数据
            shareFlowService.updateWorkFlow(1, dto.getTaskId(), userId, dto.getStatus(), dto.getContent());
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
        return Result.success(true);
    }
    /**
     * 描述：判断是否存在目录
     * 参数：id 目录Id
     * 参数：addWareDirectoryList 当前list
     * 返回值：
     * 修改人：zhaopengfei
     * 修改时间：2019/4/23
     * 修改内容：
     */
    private boolean isExist(Long id, List<ShareDataDirectoryWare> addWareDirectoryList) {
        long count = addWareDirectoryList.stream().filter(obj -> obj.getId().equals(id)).count();
        if (count>0){
            return true;
        }else {
            return false;
        }
    }


    /**
     * @return ShareFlowTaskDTO
     * @todo 查询数据集审批任务
     * @Author wgj
     * @createtime 2018-4-22
     */
    @RequestMapping(value = "/getDataSetTask", method = RequestMethod.POST)

    @ApiOperation(value = "查询数据集审批任务", notes = "查询数据集审批任务")
    @ApiResponses({
            @ApiResponse(code = 85515, message = "需要单位管理员或者平台管理员才能操作"),
    })
    public Result<PageInfo<QueryDataSetResEleDTO>> getDataSetTask(@RequestBody OpenApiReq<QueryDataSetParamReqDTO> openApiReq) {
        //获取单位Id
        Long userId = BaseContextHandler.getAdminId();
        String unitId = commonService.getOrgIdByUserId(userId);

        Boolean unitAdmin = gxqPtRoleUnits.getGxqUnitRole(userId, unitId);//是否是单位管理员
        Boolean pt_admin_role_code = gxqPtRoleUnits.getGxqPtRole(userId, GxqPtRoleUnits.PT_ADMIN_ROLE_CODE);//是否是平台管理员
        if (!unitAdmin && !pt_admin_role_code) {
            return Result.fail(ExchangeExceptionCode.CREATEDATASET_OPT_NEED_UNIT_ADMIN);
        }

        Map<String, Object> param = new HashMap<>();

        if (openApiReq.getData() != null) {
            param.put("setName", openApiReq.getData().getSetName());
            param.put("setType", openApiReq.getData().getSetType());
            param.put("status", openApiReq.getData().getStatus());
            param.put("applyType", openApiReq.getData().getApplyType());//1:新增，2:修改
            param.put("startTime", openApiReq.getData().getStartTime());
            param.put("endTime", openApiReq.getData().getEndTime());
            param.put("dirName", openApiReq.getData().getDirName());
        }
        if (!pt_admin_role_code) {//如果不是平台管理员就只能看见本单位的
            param.put("unitId", unitId);
        }

        PageHelper.startPage(openApiReq.getPageNo(), openApiReq.getPageSize());
        List<ShareDataSetDO> list = shareDataSetService.findAuditList(param);
        return Result.success(new PageInfo<>(dozerUtils.mapPage(list, QueryDataSetResEleDTO.class)));
    }

    /**
     * @return ShareFlowTaskDTO
     * @todo 查询共享审批任务
     * @Author wgj
     * @createtime 2018-4-22
     */
    @RequestMapping(value = "/getApiTask", method = RequestMethod.POST)
    @ApiOperation(value = "查询API审批任务", notes = "查询API审批任务")

    public Result<PageInfo<ShareFLowApiListDTO>> findApiTask(@RequestBody OpenApiReq<ShareFLowApiConditionDTO> openApiReq) {
        //基础数据获取
        Long userId = BaseContextHandler.getAdminId();
        //获取单位Id
        String unitId = commonService.getOrgIdByUserId(userId);
        boolean ptAdmin = gxqPtRoleUnits.getGxqPtRole(userId, gxqPtRoleUnits.PT_ADMIN_ROLE_CODE);

        Map<String, Object> param = new HashMap<>();
        if (!ptAdmin) {
            param.put("unitId", unitId);
        }
        param.put("apiName", openApiReq.getData().getApiName());
        param.put("dirId", openApiReq.getData().getDirId());
        param.put("dirName", openApiReq.getData().getDirName());
        param.put("applyType", openApiReq.getData().getApplyType());
        param.put("authStatus", openApiReq.getData().getHandleStatus());
        param.put("startTime", openApiReq.getData().getStartTime());
        param.put("endTime", openApiReq.getData().getEndTime());

        PageHelper.startPage(openApiReq.getPageNo(), openApiReq.getPageSize());
        List<FlowApiListDO> list = shareFlowTaskService.findApiApplyList(param);
        List<ShareFLowApiListDTO> demandListDTOS = dozerUtils.mapList(list, ShareFLowApiListDTO.class);
        if (!ObjectUtils.isEmpty(demandListDTOS)) {
            for (ShareFLowApiListDTO demand : demandListDTOS) {
                ShareDataFileExample example = new ShareDataFileExample();
                example.createCriteria().andBusIdEqualTo(demand.getApplyId())
                        .andBusTypeEqualTo(FileBusType.DEMAND_APPLY_ACCORD.getVal());
                List<ShareDataFile> files = shareDataFileService.find(example);
                if (files!=null && !files.isEmpty()) {
                    demand.setFileList(dozerUtils.mapList(files, DemandFileDTO.class));
                }
            }
        }
        return Result.success(new PageInfo<>(dozerUtils.mapPage(demandListDTOS, ShareFLowApiListDTO.class)));

    }

    /**
     * 描述：查询需求审批任务
     * 参数：openApiReq
     * 返回值：PageInfo<ShareFLowDemandListDTO>
     * 修改人：zhaopengfei
     * 修改时间：2018/4/25
     * 修改内容：
     */
    @RequestMapping(value = "/finddemandtask", method = RequestMethod.POST)
    @ApiOperation(value = "查询需求审批任务", notes = "查询需求审批任务")

    public Result<PageInfo<ShareFLowDemandListDTO>> findDemandTask(@RequestBody OpenApiReq<ShareFLowDemandConditionDTO> openApiReq) {
        //基础数据获取
        Long userId = BaseContextHandler.getAdminId();
        //获取单位Id
        String unitId = commonService.getOrgIdByUserId(userId);
        Boolean ptAdmin = gxqPtRoleUnits.getGxqPtRole(userId, GxqPtRoleUnits.PT_ADMIN_ROLE_CODE);

        Map<String, Object> param = new HashMap<>();
        if (!ptAdmin) {
            param.put("orgId", unitId);
        }
        param.put("unitName", openApiReq.getData().getUnitName());
        param.put("startTime", openApiReq.getData().getStartTime());
        param.put("endTime", openApiReq.getData().getEndTime());
        param.put("authStatus", openApiReq.getData().getHandleStatus());

        PageHelper.startPage(openApiReq.getPageNo(), openApiReq.getPageSize());
        List<FlowDemanListDO> list = shareFlowTaskService.findDemandList(param);
        return Result.success(new PageInfo<>(dozerUtils.mapPage(list, ShareFLowDemandListDTO.class)));
    }

    /**
     * 描述：api需求处理
     * 参数：ShareDataHandleDemandDTO
     * 返回值：Boolean 状态（成功、失败）
     * 修改人：zhaopengfei
     * 修改时间：2018/4/21
     * 修改内容：
     */
    @RequestMapping(value = "/handledemand", method = RequestMethod.POST)
    @ApiOperation(value = "需求审核处理", notes = "需求审核处理")
    @ApiResponses({
            @ApiResponse(code = 86500, message = "任务Id不能为空"),
            @ApiResponse(code = 86501, message = "处理状态不能为空"),
            @ApiResponse(code = 86503, message = "审批对象不能为空"),
            @ApiResponse(code = 86504, message = "任务ID不存在"),
    })

    public Result<Boolean> saveHandleDemand(@RequestBody ShareDataHandleDemandDTO dto) {
        //数据验证
        BizAssert.assertNotNull(ExchangeExceptionCode.TASK_HANDLE_ENTITY_NULL, dto);
        BizAssert.assertNotNull(ExchangeExceptionCode.TASK_ID_NULL, dto.getTaskId());
        BizAssert.assertNotNull(ExchangeExceptionCode.TASK_HANDLE_STATUS_NULL, dto.getStatus());
        if (dto.getStatus() == 1) {
            BizAssert.assertNotNull(ExchangeExceptionCode.DEMAND_ESTIMATE_TIME_NULL, dto.getEstimateTime());
        }

        Long userId = BaseContextHandler.getAdminId();

        ShareFlowTask shareFlowTask = shareFlowTaskService.getById(dto.getTaskId());

        if (ObjectUtils.isEmpty(shareFlowTask)) {
            return Result.fail(ExchangeExceptionCode.TASK_HANDLE_ENTITY_NULL.getMsg());
        }

        try {
            //插入流程审批数据
            shareFlowService.updateWorkFlow(4, dto.getTaskId(), userId, dto.getStatus(), dto.getContent());

            //更新申请表信息
            ShareDataDemandExample example = new ShareDataDemandExample();
            example.createCriteria().andApplyCodeEqualTo(shareFlowTask.getApplyCode());
            ShareDataDemand shareDataDemand = shareDataDemandService.getUnique(example);
            Integer status = dto.getStatus();
            if (status == 1) {
                shareDataDemand.setStatus(3);
            } else {
                shareDataDemand.setStatus(2);
            }

            if (!ObjectUtils.isEmpty(dto.getEstimateTime())) {
                shareDataDemand.setEstimateTime(dto.getEstimateTime());
            }
            shareDataDemandService.updateByIdSelective(shareDataDemand);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }

        return Result.success(true);
    }

    /**
     * 描述：数据集审批处理
     * 参数：handleDTO
     * 返回值：com.hengyunsoft.base.Result<java.lang.Boolean>
     * 修改人：gbl
     * 修改时间：2018/4/26
     * 修改内容：
     */
    @RequestMapping(value = "/set/dateSetHandleDemand", method = RequestMethod.POST)
    @ApiOperation(value = "数据集审批处理", notes = "数据集审批处理")

    @ApiResponses({
            @ApiResponse(code = 86500, message = "任务Id不能为空"),
            @ApiResponse(code = 86501, message = "处理状态不能为空"),
            @ApiResponse(code = 86503, message = "审批对象不能为空"),
            @ApiResponse(code = 86504, message = "任务ID不存在"),
            @ApiResponse(code = 85515, message = "需要单位管理员或者平台管理员才能操作"),

    })
    public Result<Boolean> saveDateSetHandleDemand(@RequestBody HandleDTO dto) throws Exception {
        //数据验证
        BizAssert.assertNotNull(ExchangeExceptionCode.TASK_HANDLE_ENTITY_NULL, dto);
        BizAssert.assertNotNull(ExchangeExceptionCode.TASK_ID_NULL, dto.getTaskId());
        BizAssert.assertNotNull(ExchangeExceptionCode.TASK_HANDLE_STATUS_NULL, dto.getStatus());

        ShareFlowTask shareFlowTask = shareFlowTaskService.getById(dto.getTaskId());
        if (shareFlowTask == null) {
            BizAssert.fail(ExchangeExceptionCode.TASK_ID_NOT_EXIST);
        }

        Long userId = BaseContextHandler.getAdminId();

        try {

            //更新数据集相关信息
            ShareDataSet shareDataSet = shareDataSetService.getShareDataSetByApplyCod(shareFlowTask.getApplyCode());
            //1通过，2驳回
            if (dto.getStatus() == 1) {
                shareDataSet.setStatus(3);//状态:1，审批中；2，驳回；3，已上架；4，已下架
                //更新数据集到中心表
                updateDataToWare(shareDataSet);
                ShareDataSetWare dataSetWare = dozerUtils.map(shareDataSet, ShareDataSetWare.class);
                ShareDataSetWare old = shareDataSetWareService.getById(dataSetWare.getId());
                if (old != null) {
                    shareDataSetWareService.updateByIdSelective(dataSetWare);
                } else {
                    shareDataSetWareService.insert(dataSetWare);
                }
            } else if (dto.getStatus() == 2) {
                shareDataSet.setStatus(2);
            }
            shareDataSet.setUpdateUser(userId);
            shareDataSetService.updateByIdSelective(shareDataSet);

            //插入流程审批数据
            shareFlowService.updateWorkFlow(2, dto.getTaskId(), userId, dto.getStatus(), dto.getContent());
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
        return Result.success(true);
    }

    /***
     * 更新数据到中心表
     * @param shareDataSet
     */
    private void updateDataToWare(ShareDataSet shareDataSet) throws Exception {
        long setId = shareDataSet.getId();
        //更新文件,删除操作的文件把它删了
        shareDataFileService.deleteOptDeleBySetId(setId);
        //更新字段选择到中心表
        updateElement(shareDataSet);
        //更新条件过滤到中心表
        updateSetFilter(shareDataSet);
        //更新目前关联数据
        updateDirOpt(shareDataSet.getId());
        //更新表
        updateTable(shareDataSet);
    }

    /***
     * 更新本地仓库正式表结构
     * @param shareDataSet
     * @throws Exception
     */
    private void updateTable(ShareDataSet shareDataSet) throws Exception {
        if (shareDataSet.getSetType() != 3 && shareDataSet.getSetType() != 4) {
            return;
        }
        Connection connection = DataBaseSql.getConnection();
        try {
            connection.setAutoCommit(false);
            updataWareTable(shareDataSet, connection);
            connection.commit();
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        } finally {
            if (connection != null) {
                connection.close();
            }
        }
    }

    /***
     * 把目录关联数据更新到数据集,
     * 先处理删除的(为防止目录的数据已经被其他数据集关联了,目录的数据集id等于当前数据集id才更新它的数据集id为-1)
     * 在处理新增的，正常的
     *
     */
    private void updateDirOpt(long setId) {
        List<Long> removeIds = new ArrayList<>();
        //删除的
        List<ShareDataSetDir> allRemoveShareDataSetDir = shareDataSetDirService.getShareDataSetDirBySetIdAndOpt(setId, 2);
        List<Long> removeShareDataSetDirIds = new ArrayList<>();
        for (ShareDataSetDir sds : allRemoveShareDataSetDir) {
            removeShareDataSetDirIds.add(sds.getId());
            ShareDataDirectoryWare sdw = dataDirectoryWareService.getById(sds.getDirId());
            if (sdw.getSetId() != null && (sdw.getSetId().longValue() == setId)) {
                dataDirectoryWareService.updateSetIdToNull(sdw.getId(), setId);
                dataDirectoryService.updateSetIdToNull(sdw.getId(), setId);
                //更新字段为空
                dataElementWareService.updateSetFiled2Null(sdw.getId());
                dataElementService.updateSetFiled2Null(sdw.getId());

                Map<Long, ShareDataSetDirElement> shareDataSetDirElementBySdid = shareDataSetDirElementService.getShareDataSetDirElementBySdid(sds.getId());
                for (ShareDataSetDirElement ee : shareDataSetDirElementBySdid.values()) {
                    removeIds.add(ee.getId());
                }
            }
            //删除全量API索引
            ShareDataApiExample shareDataApiExample = new ShareDataApiExample();
            shareDataApiExample.createCriteria().andDirIdEqualTo(sds.getDirId())
                    .andApiTypeEqualTo(1);
            List<ShareDataApi> apiList = shareDataApiService.find(shareDataApiExample);
            if (!ObjectUtils.isEmpty(apiList) && apiList.size() > 0) {
                ShareDataApi api = apiList.get(0);
                DeleteIndexDTO indexDTO = new DeleteIndexDTO();
                indexDTO.setId(SearchConstants.GXQPT_PORTAL_SEARCH_TYPE_GXJH_API + "_" + api.getId().toString());
                indexDTO.setCollection(SearchConstants.GXQPT_PORTAL_SEARCH_INDEX_SET);
                searchQueueProducer.deleteIndex(indexDTO); //删除索引
            }
        }
        shareDataSetDirService.deleteByIds(removeShareDataSetDirIds);
        //新增的
        List<ShareDataSetDir> allAddShareDataSetDir = shareDataSetDirService.getShareDataSetDirBySetIdAndOpt(setId, 1);
        for (ShareDataSetDir sds : allAddShareDataSetDir) {
            dataDirectoryWareService.updateSetId(sds.getDirId(), setId);
            dataDirectoryService.updateSetId(sds.getDirId(), setId);

            //更新字段,这里字段只能一个一个更新了
            Map<Long, ShareDataSetDirElement> shareDataSetDirElementBySdid = shareDataSetDirElementService.getShareDataSetDirElementBySdid(sds.getId());
            for (ShareDataSetDirElement sdse : shareDataSetDirElementBySdid.values()) {
                dataElementWareService.updateSetFiled(sds.getDirId(), sdse.getDirFieldCode(), sdse.getSetFieldCode());
                dataElementService.updateSetFiled(sds.getDirId(), sdse.getDirFieldCode(), sdse.getSetFieldCode());
            }

            //增加全量API门户快速搜索索引
            ShareDataApiExample shareDataApiExample = new ShareDataApiExample();
            shareDataApiExample.createCriteria().andDirIdEqualTo(sds.getDirId())
                    .andApiTypeEqualTo(1);
            List<ShareDataApi> apiList = shareDataApiService.find(shareDataApiExample);
            if (!ObjectUtils.isEmpty(apiList) && apiList.size() > 0) {
                ShareDataApi api = apiList.get(0);
                String appId = BaseContextHandler.getAppId();
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                IndexItemDTO indexItemDTO = new IndexItemDTO();
                indexItemDTO.setAppId(appId);
                indexItemDTO.setBizId(api.getId().toString());
                indexItemDTO.setCollection(SearchConstants.GXQPT_PORTAL_SEARCH_INDEX_SET);
                String content = api.getApiDesc();
                if (StringUtils.isEmpty(content)) {
                    content = api.getApiName();
                }
                indexItemDTO.setContent(content);
                indexItemDTO.setExt(simpleDateFormat.format(new Date()));
                indexItemDTO.setId(SearchConstants.GXQPT_PORTAL_SEARCH_TYPE_GXJH_API + "_" + api.getId().toString());
                indexItemDTO.setTitle(api.getApiName());
                indexItemDTO.setType(SearchConstants.GXQPT_PORTAL_SEARCH_TYPE_GXJH_API);
                indexItemDTO.setUrl("/module/index?promUrl=/gxqpt-exchange/module/generalApiView?id=" + api.getId());
                searchQueueProducer.addOrUpdateIndex(indexItemDTO);
            }

        }
        //正常的
        List<ShareDataSetDir> allNalSds = shareDataSetDirService.getShareDataSetDirBySetIdAndOpt(setId, 3);
        for (ShareDataSetDir sds : allNalSds) {
            dataDirectoryWareService.updateSetId(sds.getDirId(), setId);
            dataDirectoryService.updateSetId(sds.getDirId(), setId);
            //更新字段为空
            //dataElementWareService.updateSetFiled2Null(sds.getDirId());
            //dataElementService.updateSetFiled2Null(sds.getDirId());
            //更新字段,这里字段只能一个一个更新了
            Map<Long, ShareDataSetDirElement> shareDataSetDirElementBySdid = shareDataSetDirElementService.getShareDataSetDirElementBySdid(sds.getId());
            for (ShareDataSetDirElement sdse : shareDataSetDirElementBySdid.values()) {
                String setFieldCode = sdse.getSetFieldCode();
                if (sdse.getOptType() == 2) {//删除的话就更新为null
                    setFieldCode = null;
                    removeIds.add(sdse.getId());
                }
                dataElementWareService.updateSetFiled(sds.getDirId(), sdse.getDirFieldCode(), setFieldCode);
                dataElementService.updateSetFiled(sds.getDirId(), sdse.getDirFieldCode(), setFieldCode);
            }

        }
        shareDataSetDirElementService.deleteByIds(removeIds);
    }

    /***
     * 更新条件过滤到中心表,先处理删除操作的（中心表删除，然后临时表删除），在处理修改操作的（更新就可以了），，最后是新增的,正常的那种不用管
     * @param shareDataSet
     */
    private void updateSetFilter(ShareDataSet shareDataSet) {
        long setId = shareDataSet.getId();
        if (shareDataSet.getSetType() != 3 && shareDataSet.getSetType() != 4) {
            return;
        }
        //删除的
        List<ShareDataSetFilter> allRemove = shareDataSetFilterService.getAllBySetIdAndOpt(setId, 3);
        List<Long> rvIds = new ArrayList<>();
        for (ShareDataSetFilter sd : allRemove) {
            rvIds.add(sd.getId());
        }
        shareDataSetFilterWareService.deleteByIds(rvIds);
        shareDataSetFilterService.deleteByIds(rvIds);
        //修改的
        List<ShareDataSetFilter> allBySetAndOpt = shareDataSetFilterService.getAllBySetIdAndOpt(setId, 2);
        List<ShareDataSetFilterWare> updates = dozerUtils.mapList(allBySetAndOpt, ShareDataSetFilterWare.class);
        shareDataSetFilterWareService.updateByIdSelective(updates);
        //新增的
        List<ShareDataSetFilter> allAddFilter = shareDataSetFilterService.getAllBySetIdAndOpt(setId, 1);
        List<ShareDataSetFilterWare> allAddFilterWares = dozerUtils.mapList(allAddFilter, ShareDataSetFilterWare.class);
        shareDataSetFilterWareService.batchInsert(allAddFilterWares);
    }

    /***
     * 更新字段选择到中心表，先处理删除操作的（中心表删除，然后临时表删除），在处理修改操作的（更新就可以了），最后是新增的,正常的那种不用管
     * @param shareDataSet
     */
    private void updateElement(ShareDataSet shareDataSet) {
        long setId = shareDataSet.getId();
        if (shareDataSet.getSetType() != 3 && shareDataSet.getSetType() != 4) {
            return;
        }
        //删除的
        List<ShareDataSetElement> allRemoveEles = shareDataSetElementService.getAllBySetIdAndOpt(setId, 3);
        List<Long> allRemoveElesIds = new ArrayList<>();
        for (ShareDataSetElement sds : allRemoveEles) {
            allRemoveElesIds.add(sds.getId());
        }
        shareDataSetElementWareService.deleteByIds(allRemoveElesIds);
        shareDataSetElementService.deleteByIds(allRemoveElesIds);
        //更新的
        List<ShareDataSetElement> allUpdateEles = shareDataSetElementService.getAllBySetIdAndOpt(setId, 2);
        List<ShareDataSetElementWare> allUpdateElesWare = dozerUtils.mapList(allUpdateEles, ShareDataSetElementWare.class);
        shareDataSetElementWareService.updateByIdSelective(allUpdateElesWare);
        //新增的
        List<ShareDataSetElement> allAddEles = shareDataSetElementService.getAllBySetIdAndOpt(setId, 1);
        List<ShareDataSetElementWare> allAddElesWare = dozerUtils.mapList(allAddEles, ShareDataSetElementWare.class);
        shareDataSetElementWareService.batchInsert(allAddElesWare);
    }

    /***
     * 更新正式表结构
     * @param shareDataSet
     * @param connection
     * @throws Exception
     */
    private void updataWareTable(ShareDataSet shareDataSet, Connection connection) throws Exception {
        String formalTableName = DataBaseSql.getFormalTableName(shareDataSet.getTableCode());
        if (!DataBaseSql.exitTable(formalTableName, connection)) {
            DataBaseSql.createTable(formalTableName, shareDataSet.getSetName(), connection);
        }

        //Map<String, ShareDataSetElement> allFiledsMap = shareDataSetElementService.getShareDataSetElementBySetId(setId);
        DatabaseTableDTO localTableInfo = dataBaseDescManager.getLocalTableInfo(shareDataSet.getTableCode());
        Map<String, DataSetElementDTO> allFiledsMap = localTableInfo.getDataSetElementMap();
        //Map<String, ShareDataSetElementWare> oldWareEle = shareDataSetElementWareService.getShareDataSetElementBySetId(setId);

        DatabaseTableDTO oldFromalTable = dataBaseDescManager.getLocalTableInfo(formalTableName);
        Map<String, DataSetElementDTO> oldFromalTableFiledMap = oldFromalTable.getDataSetElementMap();
        for (DataSetElementDTO sdse : allFiledsMap.values()) {
            DataSetElementDTO oldTableFiled = oldFromalTableFiledMap.remove(sdse.getFieldCode());
            //ShareDataSetElementWare oldSetElement = oldWareEle.remove(sdse.getFieldCode());
            boolean optIsSucceed = false;
            if (oldTableFiled == null) {
                optIsSucceed = DataBaseSql.alterTableAdd(formalTableName, sdse, connection);
            } else {
                //ShareDataSetElement oldEle = dozerUtils.map(oldSetElement, ShareDataSetElement.class);
                optIsSucceed = DataBaseSql.alterModify(formalTableName, oldTableFiled, sdse, connection);
            }
            if (!optIsSucceed) {
                String msg = "更新字段:" + sdse.getFieldCode() + " 失败，请联系管理员";
                BizAssert.fail(ExchangeExceptionCode.MODIFY_TABLE_FIELD_FAILE.getCode(), msg);
            }
        }
        //剩下的就是删除的
        for (DataSetElementDTO re : oldFromalTableFiledMap.values()) {
            DataBaseSql.dropTableElement(formalTableName, re, connection);
        }
        shareDataSet.setFormalTableCode(formalTableName);

    }

    /**
     * 描述：共享审核审批
     * 参数：
     * 返回值：
     * 修改人：zhaopengfei
     * 修改时间：2018/4/27
     * 修改内容：
     */

    @RequestMapping(value = "/handleapi", method = RequestMethod.POST)
    @ApiOperation(value = "共享审核处理", notes = "共享审核处理")
    @ApiResponses({
            @ApiResponse(code = 86500, message = "任务Id不能为空"),
            @ApiResponse(code = 86501, message = "处理状态不能为空"),
            @ApiResponse(code = 86505, message = "任务类型不能为空"),
            @ApiResponse(code = 86503, message = "审批对象不能为空"),
            @ApiResponse(code = 86504, message = "任务ID不存在"),
            @ApiResponse(code = 86011, message = "共享申请授权期限不能为空"),
            @ApiResponse(code = 86507, message = "没有找到相关联的API申请信息"),
    })
    public Result<Boolean> saveHandleApi(@RequestBody ShareDataHandleApiDTO dto) {
        //数据验证
        BizAssert.assertNotNull(ExchangeExceptionCode.TASK_HANDLE_ENTITY_NULL, dto);
        BizAssert.assertNotNull(ExchangeExceptionCode.TASK_ID_NULL, dto.getTaskId());
        BizAssert.assertNotNull(ExchangeExceptionCode.TASK_HANDLE_STATUS_NULL, dto.getStatus());
        BizAssert.assertNotNull(ExchangeExceptionCode.TASK_HANDLE_TYPE_NULL, dto.getApplyType());

        Long userId = BaseContextHandler.getAdminId();
        Date date = new Date();

        ShareFlowTask shareFlowTask = shareFlowTaskService.getById(dto.getTaskId());

        if (ObjectUtils.isEmpty(shareFlowTask)) {
            return Result.fail(ExchangeExceptionCode.TASK_HANDLE_ENTITY_NULL.getMsg());
        }
        try {
            //防止流程审批数据重新插入,对审批信息进行验证

            //插入流程审批数据
            shareFlowService.updateWorkFlow(3, dto.getTaskId(), userId, dto.getStatus(), dto.getContent());
            ShareDataApiUser apiUser;
            //根据不同义务类型进行相关更新
            if (dto.getApplyType() == 1) {//续期申请
                ShareDataApiRenewalExample example = new ShareDataApiRenewalExample();
                example.createCriteria().andApplyCodeEqualTo(shareFlowTask.getApplyCode());
                ShareDataApiRenewal renewal = shareDataApiRenewalService.getUnique(example);
                if (ObjectUtils.isEmpty(renewal)) {
                    return Result.fail(ExchangeExceptionCode.TASK_APPLY_NULL.getMsg());
                }
                Integer dateTerm = renewal.getDateTerm();
                if (ObjectUtils.isEmpty(dateTerm)) {
                    return Result.fail(ExchangeExceptionCode.SHARE_APPLY_LIMIT_NULL.getMsg());
                }

                //修改api延续申请信息
                if (dto.getStatus() == 1) {
                    renewal.setAuthStatus(3);
                } else {
                    renewal.setAuthStatus(2);
                }
                renewal.setUpdateTime(date);
                shareDataApiRenewalService.updateByIdSelective(renewal);

                ShareDataApiUserExample shareDataApiUserExample = new ShareDataApiUserExample();
                shareDataApiUserExample.createCriteria().andApiIdEqualTo(renewal.getApiId())
                        .andUnitIdEqualTo(renewal.getUnitId());
                List<ShareDataApiUser> apiUserList = shareDataApiUserService.find(shareDataApiUserExample);
                if (ObjectUtils.isEmpty(apiUserList)) {
                    return Result.fail(ExchangeExceptionCode.TASK_API_USER_NULL.getMsg());
                }
                apiUser = apiUserList.get(0);
                apiUser.setDateTerm(dateTerm);
                //判断该单位申请的API是否已经过期，
                Date invalidDate = apiUser.getLimitTime();
                if (invalidDate.getTime() > date.getTime()) {//如果未过期，则在上一次的截止时间+期限时间
                    apiUser.setLimitTime(DateUtils.addDays(invalidDate, dateTerm));
                } else {//如果已经过期，用当前审批通过时间+期限时间
                    apiUser.setLimitTime(DateUtils.addDays(date, dateTerm));
                }
            } else {
                ShareDataApiUserExample userExample = new ShareDataApiUserExample();
                userExample.createCriteria().andApplyCodeEqualTo(shareFlowTask.getApplyCode());
                apiUser = shareDataApiUserService.getUnique(userExample);
                if (ObjectUtils.isEmpty(apiUser)) {
                    return Result.fail(ExchangeExceptionCode.TASK_API_USER_NULL.getMsg());
                }
                if (dto.getStatus() == 1) {
                    apiUser.setAuthStatus(3);
                    apiUser.setSecretKey(UUID.randomUUID().toString().replace("-", ""));
                } else {
                    apiUser.setAuthStatus(2);
                }
                //修改api信息
                if (dto.getApplyType() == 2) {//目录新增API
                    ShareDataApi shareDataApi = shareDataApiService.getById(apiUser.getApiId());
                    if (dto.getStatus() == 1) {
                        shareDataApi.setAuthStatus(3);
                        shareDataApi.setApiUrl(url + "/" + shareDataApi.getApiCode());
                    } else {
                        shareDataApi.setAuthStatus(2);
                    }
                    shareDataApiService.updateByIdSelective(shareDataApi);
                }
            }

            apiUser.setUpdateTime(date);
            apiUser.setUpdateUser(userId);
            shareDataApiUserService.updateByIdSelective(apiUser);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
        return Result.success(true);
    }
}
