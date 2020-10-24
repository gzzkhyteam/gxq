package com.hengyunsoft.platform.exchange.impl.dataapi;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hengyunsoft.base.Result;
import com.hengyunsoft.base.id.IdGenerate;
import com.hengyunsoft.commons.constant.SearchConstants;
import com.hengyunsoft.commons.context.BaseContextHandler;
import com.hengyunsoft.commons.exception.core.ExchangeExceptionCode;
import com.hengyunsoft.commons.utils.DateUtils;
import com.hengyunsoft.commons.utils.context.DozerUtils;
import com.hengyunsoft.page.plugins.openapi.OpenApiReq;
import com.hengyunsoft.platform.exchange.api.dataapi.dto.dataapi.*;
import com.hengyunsoft.platform.exchange.api.directory.dto.directory.VOrgDTO;
import com.hengyunsoft.platform.exchange.api.set.dto.QueryDataResDTO;
import com.hengyunsoft.platform.exchange.constant.ApplyType;
import com.hengyunsoft.platform.exchange.entity.api.domain.*;
import com.hengyunsoft.platform.exchange.entity.api.po.*;
import com.hengyunsoft.platform.exchange.entity.directory.po.ShareDataDirectory;
import com.hengyunsoft.platform.exchange.entity.directory.po.ShareDataElement;
import com.hengyunsoft.platform.exchange.entity.directory.po.domain.VOrgDO;
import com.hengyunsoft.platform.exchange.entity.set.po.ShareDataSet;
import com.hengyunsoft.platform.exchange.entity.system.po.ShareFlowTask;
import com.hengyunsoft.platform.exchange.impl.set.dataread.api.ApiDataDescManager;
import com.hengyunsoft.platform.exchange.impl.set.dataread.database.DataBaseDescManager;
import com.hengyunsoft.platform.exchange.repository.api.example.*;
import com.hengyunsoft.platform.exchange.repository.api.service.*;
import com.hengyunsoft.platform.exchange.repository.common.service.CommonService;
import com.hengyunsoft.platform.exchange.repository.directory.service.DataDirectoryService;
import com.hengyunsoft.platform.exchange.repository.set.service.ShareDataSetService;
import com.hengyunsoft.platform.exchange.repository.system.service.ShareFlowTaskService;
import com.hengyunsoft.platform.exchange.util.SearchQueueUtil;
import com.hengyunsoft.platform.exchange.util.ShareUtil;
import com.hengyunsoft.platform.exchange.utils.GxqPtRoleUnits;
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

import java.util.*;


/**
 * com.hengyunsoft.platform.exchange.impl.dataapi
 * 版权：中科恒运软件科技股份有限公司贵阳分公司
 * 描述：Api管理api
 * 修改人：zhaopengfei
 * 修改时间：2018/4/21
 * 修改内容：新增基础接口
 */
@Api(value = "API - ShareDataApiApiImpl.java", description = "Api管理")
@RestController
@RequestMapping("dataapi")
@Slf4j
public class ShareDataApiApiImpl /*implements ShareDataApiApi*/ {
    @Autowired
    private ShareDataApiService shareDataApiService;

    @Autowired
    private ShareDataApiElementService shareDataApiElementService;

    @Autowired
    private ShareDataApiFilterService shareDataApiFilterService;

    @Autowired
    private DozerUtils dozerUtils;

    @Autowired
    private CommonService commonService;

    @Autowired
    private ShareFlowTaskService shareFlowTaskService;

    @Autowired
    private ShareDataDemandService shareDataDemandService;

    @Autowired
    private ShareDataApiUserService shareDataApiUserService;

    @Autowired
    private IdGenerate<Long> idGenerate;

    @Autowired
    private ShareDataApiCallService shareDataApiCallService;
    @Autowired
    private DataDirectoryService dataDirectoryService;
    @Autowired
    private GxqPtRoleUnits gxqPtRoleUnits;

    @Autowired
    private ShareDataSetService shareDataSetService;
    @Autowired
    private ApiDataDescManager apiDataDescManager;
    @Autowired
    private DataBaseDescManager dataBaseDescManager;
    @Autowired
    private SearchQueueUtil searchQueueUtil;
    @Value("http://${gxqpt.hostname.nginx:127.0.0.1}:${gxqpt.port.gate:10003}/api/exchange/p/api/sharedataapiopen")
    String url;
    @Value("http://${gxqpt.hostname.nginx:127.0.0.1}:${gxqpt.port.gate:10003}/module/generalApiView?id=")
    String apiUrl;



    /**
     * 描述：用于保存Api创建第一步：选择目录
     * 参数：dirId 目录id
     * 参数：Integer type (1:单位自己创建，2：共享申请创建,4：api封装)
     * 返回值： ApiDirSaveReturnDTO
     * 修改人：zhaopengfei
     * 修改时间：2018/4/21
     * 修改内容：
     */
    @RequestMapping(value = "/api/savedirectorychosen", method = RequestMethod.POST)
    @ApiOperation(value = "用于保存Api创建第一步：选择目录", notes = "用于保存Api创建第一步：选择目录")
    @ApiResponses({
            @ApiResponse(code = 85000, message = "数据目录ID不允许为空"),
            @ApiResponse(code = 85014, message = "没有找到对应的目录"),
            @ApiResponse(code = 86027, message = "找不到对应的API"),
    })

    public Result<ApiDirSaveReturnDTO> saveApiDirectoryChosen(@RequestParam("dirId") Long dirId, @RequestParam("type") Integer type, Long apiId, Long busId) {
        //数据验证
        BizAssert.assertNotNull(ExchangeExceptionCode.DIRECTORY_ID_NULL, dirId);

        Long userId = BaseContextHandler.getAdminId();
        //获取单位Id
        String unitId = commonService.getOrgIdByUserId(userId);

        ApiDirSaveReturnDTO dto = new ApiDirSaveReturnDTO();
        Integer apiType = 1;
        //业务逻辑书写
        if (ObjectUtils.isEmpty(apiId)) {
            //基础数据获取
            Date date = new Date();

            ShareDataApi api = new ShareDataApi();
            api.setApiStatus(1);
            api.setAuthStatus(0);
            if (type == 2) {
                api.setApiType(3);
            } else {
                api.setApiType(2);
            }
            api.setDirId(dirId);
            ShareDataDirectory directory = dataDirectoryService.getById(dirId);
            if (ObjectUtils.isEmpty(directory)) {
                return Result.fail(ExchangeExceptionCode.DIRECTORY_NOT_FIND.getMsg());
            }
            api.setUnitId(directory.getUnitId());
            api.setCreateTime(date);
            api.setCreateUser(userId);
            api.setUpdateTime(date);
            api.setUpdateUser(userId);
            shareDataApiService.save(api);
            dto.setApiId(api.getId());

            //修改关联需求申请信息
            if (type == 4) {
                ShareDataDemand demand = shareDataDemandService.getById(busId);
                demand.setApiId(api.getId());
                shareDataDemandService.updateByIdSelective(demand);
//                apiType = 1;
                unitId = demand.getUnitId();
            } else if (type == 2) {
                apiType = 2;
            }

            //保存申请信息
            ShareDataApiUser shareDataApiUser = new ShareDataApiUser();
            String applyCode = ShareUtil.automaticCode(ApplyType.API_NOT_EXIST_APPLY.getVal());
            shareDataApiUser.setUnitId(unitId);
            shareDataApiUser.setAuthStatus(0);
            shareDataApiUser.setApplyCode(applyCode);
            shareDataApiUser.setApiId(api.getId());
            shareDataApiUser.setUserId(userId);
            shareDataApiUser.setIsTake(2);
            shareDataApiUser.setApplyTime(date);
            shareDataApiUser.setApiType(apiType);
            shareDataApiUser.setCreateTime(date);
            shareDataApiUser.setCreateUser(userId);
            shareDataApiUser.setUpdateTime(date);
            shareDataApiUser.setUpdateUser(userId);
            shareDataApiUser = shareDataApiUserService.save(shareDataApiUser);
            dto.setApplyId(shareDataApiUser.getId());
        } else {
            ShareDataApi api = shareDataApiService.getById(apiId);
            if (ObjectUtils.isEmpty(api)) {
                return Result.fail(ExchangeExceptionCode.SHARE_API_NOT_EXIST.getMsg());
            }
            api.setDirId(dirId);
            shareDataApiService.updateByIdSelective(api);
            dto.setApiId(apiId);
            if (type == 2) {
                ShareDataApiUserExample example = new ShareDataApiUserExample();
                example.createCriteria().andApiIdEqualTo(apiId).andUnitIdEqualTo(unitId);
                List<ShareDataApiUser> apiUserList = shareDataApiUserService.find(example);
                if (!apiUserList.isEmpty()) {
                    dto.setApplyId(apiUserList.get(0).getId());
                }
            }
        }
        dto.setUnitId(unitId);
        return Result.success(dto);
    }

    /**
     * 描述：用于保存api创建第三步：保存过滤条件
     * 参数：apielementdto api元数据
     * 返回值：boolean 状态（成功、失败）
     * 修改人：zhaopengfei
     * 修改时间：2018/4/21
     * 修改内容：
     */
    @RequestMapping(value = "/api/saveapielementchosen", method = RequestMethod.POST)
    @ApiOperation(value = "用于保存Api创建第二步：保存查询字段", notes = "用于保存Api创建第二步：保存查询字段")
    @ApiResponses({
            @ApiResponse(code = 86004, message = "返回对象不能为空"),
            @ApiResponse(code = 86005, message = "API id不能为空"),
            @ApiResponse(code = 86006, message = "API 返回字段不能为空"),
            @ApiResponse(code = 86014, message = "错误操作，请先目录选择"),
    })

    public Result<Boolean> saveApiElementChosen(@RequestBody ApiElementDTO dto) {
        //数据验证
        BizAssert.assertNotNull(ExchangeExceptionCode.DEMAND_ELEMENT_SET_NULL, dto);
        BizAssert.assertNotNull(ExchangeExceptionCode.API_ID_NULL, dto.getApiId());
        BizAssert.assertNotNull(ExchangeExceptionCode.API_ELEMENT_ID_NULL, dto.getFieldIds());

        //基础数据获取
        Long userId = BaseContextHandler.getAdminId();
        Date date = new Date();

        //业务验证
        ShareDataApi api = shareDataApiService.getById(dto.getApiId());
        if (ObjectUtils.isEmpty(api)) {
            return new Result(1, "", ExchangeExceptionCode.SHARE_APPLY_STEP_NULL.getMsg());
        }

        //循环遍历插入
        //删除原有ApiElement
        ShareDataApiElementExample example = new ShareDataApiElementExample();
        example.createCriteria().andApiIdEqualTo(dto.getApiId());
        shareDataApiElementService.deleteByExample(example);
        //再重新添加
        List<ShareDataApiElement> elements = new ArrayList<>();
        for (Long filedId : dto.getFieldIds()) {
            ShareDataApiElement element = new ShareDataApiElement();
            element.setApiId(dto.getApiId());
            element.setFieldId(filedId);
            element.setCreateTime(date);
            element.setCreateUser(userId);
            element.setUpdateTime(date);
            element.setUpdateUser(userId);
            element.setId(idGenerate.generate());
            elements.add(element);
        }
        shareDataApiElementService.saveBatch(elements);
        return Result.success(true);
    }

    /**
     * 描述：用于保存Api创建第二步：保存查询字段
     * 参数：ApiElementDTO API元数据
     * 返回值：Boolean 状态（成功、失败）
     * 修改人：zhaopengfei
     * 修改时间：2018/4/21
     * 修改内容：
     */
    @RequestMapping(value = "/api/saveapifilterchosen", method = RequestMethod.POST)
    @ApiOperation(value = "用于保存Api创建第三步：保存查询字段", notes = "用于保存Api创建第三步：保存查询字段")
    @ApiResponses({
            @ApiResponse(code = 86015, message = "过滤对象不能为空"),
            @ApiResponse(code = 86005, message = "API id不能为空"),
            @ApiResponse(code = 86014, message = "错误操作，请先目录选择"),
    })

    public Result<Boolean> saveApiFilterChosen(@RequestBody ApiFilterDTO dto) {
        //数据验证
        BizAssert.assertNotNull(ExchangeExceptionCode.SHARE_APPLY_FITER_NULL, dto);
        BizAssert.assertNotNull(ExchangeExceptionCode.API_ID_NULL, dto.getApiId());

        //基础数据获取
        Long userId = BaseContextHandler.getAdminId();
        Date date = new Date();

        //业务验证
        ShareDataApi api = shareDataApiService.getById(dto.getApiId());
        if (ObjectUtils.isEmpty(api)) {
            return new Result(1, "", ExchangeExceptionCode.SHARE_APPLY_STEP_NULL.getMsg());
        }

        //循环遍历插入
        if (!dto.getFieldPropertys().isEmpty()) {
            ShareDataApiFilterExample example = new ShareDataApiFilterExample();
            example.createCriteria().andApiIdEqualTo(dto.getApiId());
            shareDataApiFilterService.deleteByExample(example);
            List<ShareDataApiFilter> filters = new ArrayList<>();
            for (ApiFilterPropertyDTO property : dto.getFieldPropertys()) {
                ShareDataApiFilter filter = dozerUtils.map(property, ShareDataApiFilter.class);
                filter.setApiId(dto.getApiId());
                filter.setCreateTime(date);
                filter.setCreateUser(userId);
                filter.setUpdateTime(date);
                filter.setUpdateUser(userId);
                filter.setId(idGenerate.generate());
                filters.add(filter);
            }
            if (!filters.isEmpty()) {
                shareDataApiFilterService.saveBatch(filters);

            }
        }
        return Result.success(true);

    }

    /**
     * 描述：用于保存Api创建第四步：保存api基本信息
     * 参数：ApiElementDTO API元数据
     * 返回值：Boolean 状态（成功、失败）
     * 修改人：zhaopengfei
     * 修改时间：2018/4/21
     * 修改内容：
     */
    @RequestMapping(value = "/api/saveapiinfo", method = RequestMethod.POST)
    @ApiOperation(value = "用于保存Api创建第四步：保存api基本信息", notes = "用于保存Api创建第四步：保存api基本信息")
    @ApiResponses({
            @ApiResponse(code = 86005, message = "API id不能为空"),
            @ApiResponse(code = 86007, message = "API 名称不能为空"),
            @ApiResponse(code = 86008, message = "API 支持格式不能为空"),
            @ApiResponse(code = 86014, message = "错误操作，请先目录选择"),
    })

    public Result<Boolean> saveApiInfo(@RequestBody ApiBaseInfoDTO dto) {
        //数据验证
        BizAssert.assertNotNull(ExchangeExceptionCode.API_ID_NULL, dto.getApiId());
        BizAssert.assertNotNull(ExchangeExceptionCode.API_NAME_NULL, dto.getApiName());
        BizAssert.assertNotNull(ExchangeExceptionCode.API_DATA_FORMAT_NULL, dto.getDataFmat());

        //基础数据获取
        Long userId = BaseContextHandler.getAdminId();
        Date date = new Date();

        //业务验证
        ShareDataApi api = shareDataApiService.getById(dto.getApiId());
        if (ObjectUtils.isEmpty(api)) {
            return new Result(1, "", ExchangeExceptionCode.SHARE_APPLY_STEP_NULL.getMsg());
        }
        //更新api实体
        api.setApiName(dto.getApiName());
        api.setDataFmat(dto.getDataFmat());
        api.setApiDesc(dto.getApiDesc());
        String apiCode = UUID.randomUUID().toString().replace("-", "");
        api.setApiUrl(url + "/" + apiCode);
        api.setApiCode(apiCode);
        api.setAuthStatus(3);
        api.setApiType(2);
        api.setUpdateTime(date);
        shareDataApiService.updateByIdSelective(api);


//          如果用户封装Api，则更新需求关联apiId信息
        ShareFlowTask shareFlowTask = shareFlowTaskService.getById(dto.getTaskId());
        if (!ObjectUtils.isEmpty(shareFlowTask)) {
            ShareDataDemandExample example = new ShareDataDemandExample();
            example.createCriteria().andApplyCodeEqualTo(shareFlowTask.getApplyCode());
            ShareDataDemand shareDataDemand = shareDataDemandService.getUnique(example);
            if (!ObjectUtils.isEmpty(shareDataDemand)) {
                shareDataDemand.setApiId(dto.getApiId());
                shareDataDemand.setStatus(4);
                shareDataDemandService.updateByIdSelective(shareDataDemand);
            }
            //保存用户申请信息
            ShareDataApiUserExample userExample = new ShareDataApiUserExample();
            userExample.createCriteria().andApiIdEqualTo(api.getId()).andUnitIdEqualTo(shareDataDemand.getUnitId());
            ShareDataApiUser shareDataApiUser = shareDataApiUserService.getUnique(userExample);
            Integer limitDay = DateUtils.getDistDates(date, dto.getLimitTime());
            shareDataApiUser.setDateTerm(limitDay);
            shareDataApiUser.setSecretKey(UUID.randomUUID().toString().replace("-", ""));
            shareDataApiUser.setLimitTime(dto.getLimitTime());
            shareDataApiUser.setAuthStatus(3);
            shareDataApiUser.setUpdateTime(date);
            shareDataApiUser.setUpdateUser(userId);
            shareDataApiUserService.updateByIdSelective(shareDataApiUser);
        }
        //保存共享单位
        List<String> unitIds = dto.getUnitIdList();
        if (ObjectUtils.isEmpty(unitIds)) {
            unitIds = new ArrayList<>();
        }
        //给本单位增加申请信息
        unitIds.add(api.getUnitId());
        //循环遍历插入共享信息
        if (!unitIds.isEmpty()) {
            List<ShareDataApiUser> shareDataApiUsers = new ArrayList<>();
            for (String unitId : unitIds) {
                ShareDataApiUser shareDataApiUser = dozerUtils.map(dto, ShareDataApiUser.class);
                shareDataApiUser.setUnitId(unitId);
                shareDataApiUser.setDateTerm(-1);
                shareDataApiUser.setAuthStatus(3);
                shareDataApiUser.setSecretKey(UUID.randomUUID().toString().replace("-", ""));
                shareDataApiUser.setApiId(dto.getApiId());
                shareDataApiUser.setUserId(userId);
                shareDataApiUser.setIsTake(2);
                shareDataApiUser.setApplyTime(date);
                shareDataApiUser.setApiType(4);
                shareDataApiUser.setCreateTime(date);
                shareDataApiUser.setCreateUser(userId);
                shareDataApiUser.setUpdateTime(date);
                shareDataApiUser.setUpdateUser(userId);
                shareDataApiUser.setId(idGenerate.generate());
                shareDataApiUsers.add(shareDataApiUser);
            }
            shareDataApiUserService.saveBatch(shareDataApiUsers);
        }

        //增加门户快速搜索索引
        String content = StringUtils.isEmpty(api.getApiDesc())?api.getApiName():api.getApiDesc();
        String indexUrl = "/module/index?promUrl=/gxqpt-exchange/module/generalApiView?id=";
        IndexItemDTO indexItemDTO = searchQueueUtil.covertIndexItemDto(api.getId().toString(),content,api.getApiName(), indexUrl, SearchConstants.GXQPT_PORTAL_SEARCH_TYPE_GXJH_API);
        searchQueueUtil.saveOrUpdateIndex(indexItemDTO);

        return Result.success(true);
    }

    /**
     * 描述：查询api分页数据
     * 参数：openApiReq 分页信息；
     * 返回值：PageInfo<ApiReturnDataDTO>
     * 修改人：zhaopengfei
     * 修改时间：2018/4/21
     * 修改内容：
     */
    @RequestMapping(value = "/api/find", method = RequestMethod.POST)
    @ApiOperation(value = "查询api分页数据", notes = "查询api分页数据")

    public Result<PageInfo<ApiReturnDataDTO>> page(@RequestBody OpenApiReq<ApiQueryConditionDTO> openApiReq) {
        //基础数据获取
        Long userId = BaseContextHandler.getAdminId();

        Boolean ptAdmin = gxqPtRoleUnits.getGxqPtRole(userId, GxqPtRoleUnits.PT_ADMIN_ROLE_CODE);

        Map<String, Object> param = new HashMap<>();
        if (openApiReq.getData() != null) {
            param.put("apiName", openApiReq.getData().getApiName());
            param.put("apiStatus", openApiReq.getData().getApiStatus());
            param.put("authStatus", openApiReq.getData().getAuthStatus());

        }
        if (!ptAdmin) {
            String unitId = commonService.getOrgIdByUserId(userId);
            param.put("unitId", unitId);
        }
        PageHelper.startPage(openApiReq.getPageNo(), openApiReq.getPageSize());
        List<ShareDataApiListDO> list = shareDataApiService.findList(param);
        return Result.success(new PageInfo<>(dozerUtils.mapPage(list, ApiReturnDataDTO.class)));
    }

    /**
     * 描述：根据apiId获取详细信息
     * 参数：id：APP id
     * 返回值：ResourceUpdatDto
     * 修改人：zhaopengfei
     * 修改时间：2018/4/21
     * 修改内容：
     */
    @RequestMapping(value = "/api/detail", method = RequestMethod.POST)
    @ApiOperation(value = "根据apiId查询api详细信息", notes = "根据apiId查询api详细信息")
    @ApiResponses({
            @ApiResponse(code = 86005, message = "API id不能为空"),
    })

    public Result<ApiDetailDTO> getById(@RequestParam("id") Long id) {
        //数据验证
        BizAssert.assertNotNull(ExchangeExceptionCode.API_ID_NULL, id);
        //基础数据获取
        Long userId = BaseContextHandler.getAdminId();
        //获取单位Id
        String unitId = "";
        if (userId != null) {
            unitId = commonService.getOrgIdByUserId(userId);
        }

        ApiDetailDO api = shareDataApiService.getDetailById(id);

        Integer shareUnit = 0;
        if (!ObjectUtils.isEmpty(api)&&api.getUnitId().toString().equals(unitId)) {
            shareUnit = 1;
        } else {
            ShareDataApiUserExample userExample = new ShareDataApiUserExample();
            userExample.createCriteria().andApiIdEqualTo(id).andAuthStatusEqualTo(3)
                    .andUnitIdEqualTo(unitId);
            List<ShareDataApiUser> apiUserList = shareDataApiUserService.find(userExample);
            if (!apiUserList.isEmpty()) {
                shareUnit = 1;
            }
        }


        if (ObjectUtils.isEmpty(api)) {
            return Result.fail(ExchangeExceptionCode.SHARE_APPLY_APIID_NOT_EXIST.getMsg());
        }

        //业务逻辑
        ApiDetailDTO detailDTO = dozerUtils.map(api, ApiDetailDTO.class);

        //封装查询字段列表
        List<ShareDataElement> elements = shareDataApiElementService.findElementInfoByApiId(id);
        detailDTO.setElementList(dozerUtils.mapList(elements, ApiElementBaseDTO.class));

        //封装过滤条件字段列表
        List<ShareDataApiFilterDO> filterList = shareDataApiFilterService.findFilterInfoByApiId(id);
        detailDTO.setFilterList(dozerUtils.mapList(filterList, ApiFilterBaseDTO.class));
        detailDTO.setShareUnit(shareUnit);
        detailDTO.setLoginUnitId(unitId);
        return Result.success(detailDTO);

    }

    /**
     * 描述：api启用、禁用操作
     * 参数：id：api Id
     * 参数：status：1,启用；2，禁用'
     * 返回值：Boolean
     * 修改人：zhaopengfei
     * 修改时间：2018/4/21
     * 修改内容：
     */
    @RequestMapping(value = "/api/setstatus", method = RequestMethod.POST)
    @ApiOperation(value = "api启用、禁用操作", notes = "api启用、禁用操作")
    @ApiResponses({
            @ApiResponse(code = 86005, message = "API id不能为空"),
            @ApiResponse(code = 86009, message = "状态不能为空"),
    })

    public Result<Boolean> updatestatus(@RequestParam(value = "id") Long id, @RequestParam(value = "status") Integer status) {
        //数据验证
        BizAssert.assertNotNull(ExchangeExceptionCode.API_ID_NULL, id);
        BizAssert.assertNotNull(ExchangeExceptionCode.API_STATUS_NULL, status);
        ShareDataApi example = new ShareDataApi();
        example.setId(id);
        example.setApiStatus(status);
        shareDataApiService.updateByIdSelective(example);
        //增加门户快速搜索索引
        if (status == 2) {//为禁用时，删除索引
            DeleteIndexDTO indexDTO = new DeleteIndexDTO();
            indexDTO.setId(SearchConstants.GXQPT_PORTAL_SEARCH_TYPE_GXJH_API + "_" + id.toString());
            indexDTO.setCollection(SearchConstants.GXQPT_PORTAL_SEARCH_INDEX_SET);
            searchQueueUtil.deleteIndex(indexDTO); //删除索引
        } else {
            ShareDataApi api = shareDataApiService.getById(id);
            String content = StringUtils.isEmpty(api.getApiDesc())?api.getApiName():api.getApiDesc();
            String indexUrl = "/module/index?promUrl=/gxqpt-exchange/module/generalApiView?id=";
            IndexItemDTO indexItemDTO = searchQueueUtil.covertIndexItemDto(api.getId().toString(),content,api.getApiName(), indexUrl, SearchConstants.GXQPT_PORTAL_SEARCH_TYPE_GXJH_API);
            searchQueueUtil.saveOrUpdateIndex(indexItemDTO);
        }

        return Result.success(true);
    }

    /**
     * 描述：通过目录Id查找api分页列表
     * 参数：openApiReq 分页信息；appId：应用Id
     * 返回值：PageInfo<RoleDto>
     * 修改人：zhaopengfei
     * 修改时间：2018/4/21
     * 修改内容：暂未定
     */

    @ApiOperation(value = "通过目录Id查找api分页列表", notes = "通过目录Id查找api分页列表")
    @ApiResponses({
            @ApiResponse(code = 85000, message = "数据目录ID不允许为空"),
    })
    @RequestMapping(value = "/api/findApiByDirId", method = RequestMethod.POST)
    public Result<PageInfo<ApiReturnDataDTO>> findApiByDirId(@RequestBody OpenApiReq<Long> openApiReq) {
        //数据验证
        BizAssert.assertNotNull(ExchangeExceptionCode.DIRECTORY_ID_NULL, openApiReq.getData());
        return null;
    }

    /**
     * 描述：api新增授权单位
     * 参数：dto
     * 返回值：Boolean
     * 修改人：zhaopengfei
     * 修改时间：2018/4/30
     * 修改内容：
     */

    @ApiOperation(value = "api新增授权单位", notes = "api新增授权单位")
    @ApiResponses({
            @ApiResponse(code = 86005, message = "API id不能为空"),
            @ApiResponse(code = 86022, message = "API授权对象不能为空"),
            @ApiResponse(code = 86011, message = "共享申请授权期限不能为空"),
    })
    @RequestMapping(value = "/api/saveauthunit", method = RequestMethod.POST)
    public Result<Boolean> saveAuthUnit(@RequestBody ApiAuthUnitSaveDTO dto) {
        //数据验证
        BizAssert.assertNotNull(ExchangeExceptionCode.SHARE_AUTO_UNIT_ENTITY_NULL, dto);
        BizAssert.assertNotNull(ExchangeExceptionCode.API_ID_NULL, dto.getApiId());
        BizAssert.assertNotNull(ExchangeExceptionCode.SHARE_APPLY_LIMIT_NULL, dto.getLimitTime());
        //基础数据获取
        Long userId = BaseContextHandler.getAdminId();
        Date date = new Date();

        List<String> unitIds = dto.getUnitIdList();
        //循环遍历插入共享信息
        if (!unitIds.isEmpty()) {
            List<ShareDataApiUser> shareDataApiUsers = new ArrayList<>();
            for (String unitId : unitIds) {
                ShareDataApiUser shareDataApiUser = dozerUtils.map(dto, ShareDataApiUser.class);
                shareDataApiUser.setUnitId(unitId);
                Integer day = DateUtils.getDistDates(date, dto.getLimitTime());
                shareDataApiUser.setDateTerm(day);
                shareDataApiUser.setLimitTime(dto.getLimitTime());
                shareDataApiUser.setAuthStatus(1);
                shareDataApiUser.setApiId(dto.getApiId());
                shareDataApiUser.setUserId(userId);
                shareDataApiUser.setIsTake(2);
                shareDataApiUser.setSecretKey(UUID.randomUUID().toString().replace("-", ""));
                shareDataApiUser.setApplyTime(date);
                shareDataApiUser.setApiType(4);
                shareDataApiUser.setCreateTime(date);
                shareDataApiUser.setCreateUser(userId);
                shareDataApiUser.setUpdateTime(date);
                shareDataApiUser.setUpdateUser(userId);
                shareDataApiUser.setId(idGenerate.generate());
                shareDataApiUsers.add(shareDataApiUser);
            }
            shareDataApiUserService.saveBatch(shareDataApiUsers);
        }


        return Result.success(true);

    }

    /**
     * 描述：通过ApiId查找所共享单位
     * 参数：openApiReq 分页信息；ApiAuthUnitConditionDTO
     * 返回值：PageInfo<ApiAuthUnitListDTO>
     * 修改人：zhaopengfei
     * 修改时间：2018/4/30
     * 修改内容：
     */

    @ApiOperation(value = "通过ApiId查找所共享单位", notes = "通过ApiId查找所共享单位")
    @ApiResponses({
            @ApiResponse(code = 86005, message = "API id不能为空"),
    })
    @RequestMapping(value = "/api/findauthunit", method = RequestMethod.POST)
    public Result<PageInfo<ApiAuthUnitListDTO>> findAuthUnit(@RequestBody OpenApiReq<ApiAuthUnitConditionDTO> openApiReq) {
        //数据验证
        BizAssert.assertNotNull(ExchangeExceptionCode.SHARE_APPLY_ID_NULL, openApiReq.getData().getApiId());
        Map<String, Object> param = new HashMap<>();

        if (openApiReq.getData() != null) {
            param.put("apiId", openApiReq.getData().getApiId());
            param.put("unitName", openApiReq.getData().getUnitName());
        }
        PageHelper.startPage(openApiReq.getPageNo(), openApiReq.getPageSize());
        List<ApiAuthUnitListDO> list = shareDataApiService.findAuthUnit(param);
        return Result.success(new PageInfo<>(dozerUtils.mapPage(list, ApiAuthUnitListDTO.class)));

    }

    /**
     * 描述：查询api未共享的单位
     * 参数：apiId apiId
     * 返回值：List<VOrgDTO>
     * 修改人：zhaopengfei
     * 修改时间：2018/4/30
     * 修改内容：
     */

    @ApiOperation(value = "查询api未共享的单位", notes = "查询api未共享的单位")
    @ApiResponses({
            @ApiResponse(code = 86005, message = "API id不能为空"),
    })
    @RequestMapping(value = "/api/findnoauthunit", method = RequestMethod.GET)
    public Result<List<VOrgDTO>> findNoAuthUnit(@RequestParam("apiId") Long apiId) {
        List<VOrgDO> unitList = shareDataApiService.findNoAuthUnit(apiId);
        return Result.success(dozerUtils.mapList(unitList, VOrgDTO.class));
    }

    /**
     * 描述：查询api正常使用情况
     * 参数：ApiUseQueryDTO
     * 返回值：PageInfo<ApiUseListDTO>
     * 修改人：zhaopengfei
     * 修改时间：2018/5/1
     * 修改内容：
     */

    @ApiOperation(value = "查询api正常使用情况", notes = "查询api正常使用情况")
    @ApiResponses({
            @ApiResponse(code = 86005, message = "API id不能为空"),
    })
    @RequestMapping(value = "/api/findapiuse", method = RequestMethod.POST)
    public Result<PageInfo<ApiUseListDTO>> findApiUse(@RequestBody OpenApiReq<ApiUseQueryDTO> openApiReq) {
        //数据验证
        BizAssert.assertNotNull(ExchangeExceptionCode.SHARE_APPLY_ID_NULL, openApiReq.getData().getApiId());
        Map<String, Object> param = new HashMap<>();
        param.put("apiId", openApiReq.getData().getApiId());
        if (openApiReq.getData() != null) {
            param.put("orgName", openApiReq.getData().getOrgName());
            param.put("callDate", openApiReq.getData().getCallDate());
        }
        PageHelper.startPage(openApiReq.getPageNo(), openApiReq.getPageSize());
        List<ApiUseDO> list = shareDataApiService.findApiUse(param);
        return Result.success(new PageInfo<>(dozerUtils.mapPage(list, ApiUseListDTO.class)));

    }


    @ApiOperation(value = "查询api异常使用情况", notes = "查询api异常使用情况")
    @ApiResponses({
            @ApiResponse(code = 86005, message = "API id不能为空"),
    })
    @RequestMapping(value = "/api/findapiuseexception", method = RequestMethod.POST)
    public Result<PageInfo<ApiUseExceptionListDTO>> findApiUseException(@RequestBody OpenApiReq<ApiUseExceptionQueryDTO> openApiReq) {
        //数据验证
        BizAssert.assertNotNull(ExchangeExceptionCode.SHARE_APPLY_ID_NULL, openApiReq.getData().getApiId());
        Map<String, Object> param = new HashMap<>();

        param.put("apiId", openApiReq.getData().getApiId());
        if (openApiReq.getData() != null) {
            param.put("failLog", openApiReq.getData().getFailLog());
            param.put("callDate", openApiReq.getData().getCallDate());
            param.put("hdleState", openApiReq.getData().getHdleState());
        }
        PageHelper.startPage(openApiReq.getPageNo(), openApiReq.getPageSize());
        List<ApiUseExceptionDO> list = shareDataApiService.findApiUseException(param);
        return Result.success(new PageInfo<>(dozerUtils.mapPage(list, ApiUseExceptionListDTO.class)));
    }

    /**
     * 描述：查询Api调用总次数
     * 参数：id apiId
     * 返回值：调用数
     * 修改人：zhaopengfei
     * 修改时间：2018/5/2
     * 修改内容：
     */

    @ApiOperation(value = "查询Api调用总次数", notes = "查询Api调用总次数")
    @ApiResponses({
            @ApiResponse(code = 86005, message = "API id不能为空"),
    })
    @RequestMapping(value = "/api/findapiusetotalnum", method = RequestMethod.POST)
    public Result<Integer> findApiUseTotalNum(@RequestParam Long id) {
        //数据验证
        BizAssert.assertNotNull(ExchangeExceptionCode.API_ID_NULL, id);
        ShareDataApiCallExample example = new ShareDataApiCallExample();
        example.createCriteria().andApiIdEqualTo(id);
        Integer callNum = shareDataApiCallService.count(example);
        return Result.success(callNum);
    }

    /**
     * 描述：api异常忽略处理
     * 参数：id 异常调用Id
     * 返回值：Boolean 操作状态
     * 修改人：zhaopengfei
     * 修改时间：2018/4/22
     * 修改内容：
     */

    @ApiOperation(value = "api异常忽略处理", notes = "api异常忽略处理")
    @ApiResponses({
            @ApiResponse(code = 86023, message = "API异常ID不能为空"),
    })
    @RequestMapping(value = "/api/updateexchdle", method = RequestMethod.POST)
    public Result<Boolean> updateExcHdle(@RequestParam(value = "id") Long id) {
        //数据验证
        BizAssert.assertNotNull(ExchangeExceptionCode.SHARE_API_EXCEPTION_ID_NULL, id);

        //基础数据获取
        Long userId = BaseContextHandler.getAdminId();
        Date date = new Date();

        //业务操作
        ShareDataApiCall shareDataApiCall = new ShareDataApiCall();
        shareDataApiCall.setId(id);
        shareDataApiCall.setHdleState(3);
        shareDataApiCall.setUpdateUser(userId);
        shareDataApiCall.setUpdateTime(date);
        shareDataApiCall.setHdleUser(userId);
        shareDataApiCall.setHdleTime(date);
        shareDataApiCallService.updateByIdSelective(shareDataApiCall);

        return Result.success(true);
    }

    /**
     * 描述：保存异常处理信息
     * 参数：dto
     * 返回值：调用数
     * 修改人：zhaopengfei
     * 修改时间：2018/5/2
     * 修改内容：
     */

    @ApiOperation(value = "保存异常处理信息", notes = "保存异常处理信息")
    @ApiResponses({
            @ApiResponse(code = 86023, message = "API异常ID不能为空"),
    })
    @RequestMapping(value = "/api/saveexchdle", method = RequestMethod.POST)
    public Result<Boolean> saveExcHdle(@RequestBody ApiCallExceptionHdleDTO dto) {
        //数据验证
        BizAssert.assertNotNull(ExchangeExceptionCode.SHARE_API_EXCEPTION_ID_NULL, dto.getId());
        //基础数据获取
        Long userId = BaseContextHandler.getAdminId();
        Date date = new Date();

        //业务操作
        ShareDataApiCall shareDataApiCall = new ShareDataApiCall();
        shareDataApiCall.setId(dto.getId());
        shareDataApiCall.setHdleState(1);
        shareDataApiCall.setUpdateUser(userId);
        shareDataApiCall.setUpdateTime(date);
        shareDataApiCall.setHdleTime(date);
        shareDataApiCall.setHdleUser(userId);
        shareDataApiCall.setHdleContent(dto.getHdleContent());
        shareDataApiCallService.updateByIdSelective(shareDataApiCall);

        return Result.success(true);
    }

    /**
     * 描述：获取异常信息
     * 参数：id
     * 返回值：调用数
     * 修改人：zhaopengfei
     * 修改时间：2018/5/2
     * 修改内容：
     */

    @ApiOperation(value = "api异常忽略处理", notes = "api异常忽略处理")
    @ApiResponses({
            @ApiResponse(code = 86023, message = "API异常ID不能为空"),
    })
    @RequestMapping(value = "/api/getexcinfo", method = RequestMethod.POST)
    public Result<ApiUseExceptionDetailDTO> getExcInfo(Long id) {
        //数据验证
        BizAssert.assertNotNull(ExchangeExceptionCode.SHARE_API_EXCEPTION_ID_NULL, id);

        ShareDataApiCall call = shareDataApiCallService.getById(id);

        ApiUseExceptionDetailDTO detailDTO = dozerUtils.map(call, ApiUseExceptionDetailDTO.class);
        return Result.success(detailDTO);
    }

    /**
     * 描述：根据非结构化目录Id获取该目录的全量API
     * 参数：dirId
     * 返回值：ApiBaseInfoDTO
     * 修改人：zhaopengfei
     * 修改时间：2018/5/2
     * 修改内容：
     */

    @ApiOperation(value = "根据apiId查询非结构化API信息", notes = "根据apiId查询非结构化API信息")
    @ApiResponses({
            @ApiResponse(code = 86005, message = "API id不能为空"),
    })
    @RequestMapping(value = "/api/getapiinfobyunstrid", method = RequestMethod.POST)
    public Result<ApiBaseInfoDTO> getApiInfoByUnstrId(Long apiId) {
        //数据验证
        BizAssert.assertNotNull(ExchangeExceptionCode.API_ID_NULL, apiId);
        ShareDataApi api = shareDataApiService.getById(apiId);
        if (ObjectUtils.isEmpty(api)) {
            return new Result(1, "", ExchangeExceptionCode.SHARE_API_NOT_EXIST.getMsg());
        }
        ApiBaseInfoDTO dto = dozerUtils.map(api, ApiBaseInfoDTO.class);
        dto.setApiId(api.getId());
        return Result.success(dto);
    }

    /**
     * 描述：返回Api基础信息
     * 参数：apiId
     * 返回值：ApiBaseInfoDTO
     * 修改人：zhaopengfei
     * 修改时间：2018/6/8
     * 修改内容：
     */

    @ApiOperation(value = "返回Api基础信息", notes = "返回Api基础信息")
    @ApiResponses({
            @ApiResponse(code = 86005, message = "API id不能为空"),
    })
    @RequestMapping(value = "/api/getBaseApiInfo", method = RequestMethod.POST)
    public Result<ApiBaseInfoDTO> getBaseApiInfo(@RequestParam Long apiId) {
        //数据验证
        BizAssert.assertNotNull(ExchangeExceptionCode.API_ID_NULL, apiId);
        ShareDataApi api = shareDataApiService.getById(apiId);
        ApiBaseInfoDTO dto = dozerUtils.map(api, ApiBaseInfoDTO.class);
        ShareDataDirectory directory = dataDirectoryService.getById(api.getDirId());
        dto.setApiId(api.getId());
        dto.setDirName(directory.getDirName());
        dto.setDataType(directory.getDataType());
        return Result.success(dto);
    }

    /**
     * 描述：根据ApiId查询返回字段
     * 参数：apiId
     * 返回值：List<ShareDataApiElement>
     * 修改人：zhaopengfei
     * 修改时间：2018/6/8
     * 修改内容：
     */

    @ApiOperation(value = "根据ApiId查询返回字段", notes = "根据ApiId查询返回字段")
    @ApiResponses({
            @ApiResponse(code = 86005, message = "API id不能为空"),
    })
    @RequestMapping(value = "/api/getElementByApiId", method = RequestMethod.POST)
    public Result<List<ApiElementBaseDTO>> getElementByApiId(@RequestParam Long apiId) {
        //数据验证
        BizAssert.assertNotNull(ExchangeExceptionCode.API_ID_NULL, apiId);
        List<ShareDataElement> elementList = shareDataApiElementService.findElementInfoByApiId(apiId);
        return Result.success(dozerUtils.mapList(elementList, ApiElementBaseDTO.class));
    }

    /**
     * 描述：根据ApiId查询过滤字段
     * 参数：apiId
     * 返回值：List<ShareDataApiFilter>
     * 修改人：zhaopengfei
     * 修改时间：2018/6/8
     * 修改内容：
     */

    @ApiOperation(value = "根据ApiId查询过滤字段", notes = "根据ApiId查询过滤字段")
    @ApiResponses({
            @ApiResponse(code = 86005, message = "API id不能为空"),
    })
    @RequestMapping(value = "/api/getFilterByApiId", method = RequestMethod.POST)
    public Result<List<ApiFilterBaseDTO>> getFilterByApiId(@RequestParam Long apiId) {
        //数据验证
        BizAssert.assertNotNull(ExchangeExceptionCode.API_ID_NULL, apiId);
        ShareDataApiFilterExample elementExample = new ShareDataApiFilterExample();
        elementExample.createCriteria().andApiIdEqualTo(apiId);
        List<ShareDataApiFilter> filters = shareDataApiFilterService.find(elementExample);
        return Result.success(dozerUtils.mapList(filters, ApiFilterBaseDTO.class));
    }

    /**
     * 描述：api删除
     * 参数：id apiId
     * 返回值：Boolean
     * 修改人：zhaopengfei
     * 修改时间：2018/5/12
     * 修改内容：
     */

    @ApiOperation(value = "api删除", notes = "api删除")
    @ApiResponses({
            @ApiResponse(code = 86005, message = "API id不能为空"),
    })
    @RequestMapping(value = "/api/delete", method = RequestMethod.POST)
    public Result<Boolean> delete(Long id) {
        //1.验证
        BizAssert.assertNotNull(ExchangeExceptionCode.API_ID_NULL, id);

        //2.删除与申请相关Api的查询字段
        ShareDataApiElementExample elementExa = new ShareDataApiElementExample();
        elementExa.createCriteria().andApiIdEqualTo(id);
        shareDataApiElementService.deleteByExample(elementExa);

        //3.删除与申请相关Api的过滤字段
        ShareDataApiFilterExample filterExample = new ShareDataApiFilterExample();
        filterExample.createCriteria().andApiIdEqualTo(id);
        shareDataApiFilterService.deleteByExample(filterExample);

        //4.删除共享申请创建的API
        shareDataApiService.deleteById(id);
        //5.返回
        return Result.success(true);
    }


    @ApiOperation(value = "查询目录或者Api的预览数据", notes = "查询目录或者Api的预览数据")
    @RequestMapping(value = {"/api/dataView"}, method = RequestMethod.POST)
    public Result<Object> dataView(@RequestParam("id") Long id, @RequestParam("type") Integer type) {
        String exceptionLog;
        ShareDataApi api;
        if (type == 2) {
            ShareDataApiExample example = new ShareDataApiExample();
            example.createCriteria().andDirIdEqualTo(id).andApiTypeEqualTo(1);
            api = shareDataApiService.getUnique(example);
        } else {
            api = shareDataApiService.getById(id);
        }
        ShareDataDirectory directory = dataDirectoryService.getById(api.getDirId());
        if (ObjectUtils.isEmpty(directory)) {
            return Result.fail(ExchangeExceptionCode.DIRECTORY_NOT_USE.getMsg());
        }
        Long setId = directory.getSetId();
        if (ObjectUtils.isEmpty(setId)) {
            return Result.fail(ExchangeExceptionCode.SHARE_SET_NOT_EXIST.getMsg());
        }
        ShareDataSet ds = shareDataSetService.getById(directory.getSetId());
        if (ds.getSetType() == 3) {
            return Result.success(apiDataDescManager.queryDataByAPIId(api.getId()).getData());
        }

        if (ObjectUtils.isEmpty(ds.getTableCode())) {
            exceptionLog = ExchangeExceptionCode.SELECT_TABLE_NOT_EXIST.getMsg();
            return Result.fail(exceptionLog);
        }
        //查询API查询字段
        List<FiledSelectDO> selectList = shareDataApiElementService.querySelectFiled(api.getId());
        if (ObjectUtils.isEmpty(selectList)) {
            exceptionLog = ExchangeExceptionCode.SHARE_SET_NOT_EXIST.getMsg();
            return Result.fail(exceptionLog);
        }

        //查找API过滤字段
        List<FiledFilterDO> filterList = shareDataApiFilterService.queryFilterFiled(api.getId());
        StringBuilder andSql = new StringBuilder(" AND 1=1 ");
        if (!filterList.isEmpty()) {
            for (FiledFilterDO filterFiled : filterList) {
                Integer rule = filterFiled.getScrRule();
                String value = filterFiled.getScrValue();
                if (!ObjectUtils.isEmpty(rule) && !StringUtils.isEmpty(value)) {
                    StringBuilder operator = new StringBuilder();
                    switch (rule) {
                        case 1:
                            operator.append(" > '").append(value).append("'");
                            break;
                        case 2:
                            operator.append(" < '").append(value).append("'");
                            break;
                        case 3:
                            operator.append(" = '").append(value).append("'");
                            break;
                        case 4:
                            operator.append(" LIKE '%").append(value).append("%'");
                            break;
                        default:
                            operator.append(" = '").append(value).append("'");
                    }
                    andSql.append(" AND ").append(filterFiled.getSelectName()).append(" ").append(operator);
                }
            }
        }
        QueryDataResDTO resDTO = dataBaseDescManager.queryDataByAPIId(api.getId(), andSql);
        return Result.success(resDTO);

    }

    /**
     * 描述：根据ApiId查询返回字段
     * 参数：apiId
     * 返回值：List<ShareDataApiElement>
     * 修改人：zhaopengfei
     * 修改时间：2018/6/8
     * 修改内容：
     */

    @ApiOperation(value = "获取当前登录单位Id", notes = "获取当前登录单位Id")
    @RequestMapping(value = "/api/getLoginUnitId", method = RequestMethod.GET)
    public Result<String> getLoginUnitId() {
        //基础数据获取
        Long userId = BaseContextHandler.getAdminId();
        //获取单位Id
        String unitId = commonService.getOrgIdByUserId(userId);
        return Result.success(unitId);
    }


}
