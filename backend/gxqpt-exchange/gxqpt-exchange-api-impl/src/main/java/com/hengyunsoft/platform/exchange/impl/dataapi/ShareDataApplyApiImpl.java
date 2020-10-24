package com.hengyunsoft.platform.exchange.impl.dataapi;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hengyunsoft.base.Result;
import com.hengyunsoft.base.id.IdGenerate;
import com.hengyunsoft.commons.context.BaseContextHandler;
import com.hengyunsoft.commons.exception.core.ExchangeExceptionCode;
import com.hengyunsoft.commons.utils.DateUtils;
import com.hengyunsoft.commons.utils.context.DozerUtils;
import com.hengyunsoft.page.plugins.openapi.OpenApiReq;
import com.hengyunsoft.platform.exchange.api.dataapi.dto.dataapi.ApiElementBaseDTO;
import com.hengyunsoft.platform.exchange.api.dataapi.dto.dataapi.ApiFilterBaseDTO;
import com.hengyunsoft.platform.exchange.api.dataapi.dto.dataapi.ApiIRenewalDTO;
import com.hengyunsoft.platform.exchange.api.dataapi.dto.dataapi.ApiRenewalInfoDTO;
import com.hengyunsoft.platform.exchange.api.dataapi.dto.demand.DemandFileDTO;
import com.hengyunsoft.platform.exchange.api.dataapi.dto.shareapply.ShareApplyDetailDTO;
import com.hengyunsoft.platform.exchange.api.dataapi.dto.shareapply.ShareApplyListDTO;
import com.hengyunsoft.platform.exchange.api.dataapi.dto.shareapply.ShareApplyQueryDTO;
import com.hengyunsoft.platform.exchange.api.dataapi.dto.shareapply.ShareApplySaveDTO;
import com.hengyunsoft.platform.exchange.constant.ApplyType;
import com.hengyunsoft.platform.exchange.constant.ExchangeConstants;
import com.hengyunsoft.platform.exchange.constant.FileBusType;
import com.hengyunsoft.platform.exchange.entity.api.domain.ShareDataApiFilterDO;
import com.hengyunsoft.platform.exchange.entity.api.domain.ShareDataApiRenewalDO;
import com.hengyunsoft.platform.exchange.entity.api.domain.ShareDataApiUserListDO;
import com.hengyunsoft.platform.exchange.entity.api.po.ShareDataApi;
import com.hengyunsoft.platform.exchange.entity.api.po.ShareDataApiRenewal;
import com.hengyunsoft.platform.exchange.entity.api.po.ShareDataApiUser;
import com.hengyunsoft.platform.exchange.entity.directory.po.ShareDataDirectory;
import com.hengyunsoft.platform.exchange.entity.directory.po.ShareDataElement;
import com.hengyunsoft.platform.exchange.entity.set.po.ShareDataFile;
import com.hengyunsoft.platform.exchange.repository.api.example.ShareDataApiElementExample;
import com.hengyunsoft.platform.exchange.repository.api.example.ShareDataApiFilterExample;
import com.hengyunsoft.platform.exchange.repository.api.example.ShareDataApiUserExample;
import com.hengyunsoft.platform.exchange.repository.api.service.*;
import com.hengyunsoft.platform.exchange.repository.common.service.CommonService;
import com.hengyunsoft.platform.exchange.repository.directory.service.DataDirectoryService;
import com.hengyunsoft.platform.exchange.repository.set.example.ShareDataFileExample;
import com.hengyunsoft.platform.exchange.repository.set.service.ShareDataFileService;
import com.hengyunsoft.platform.exchange.repository.system.service.ShareFlowService;
import com.hengyunsoft.platform.exchange.util.ShareUtil;
import com.hengyunsoft.platform.exchange.utils.GxqPtRoleUnits;
import com.hengyunsoft.utils.BizAssert;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

import java.util.*;

/**
 * com.hengyunsoft.platform.exchange.impl.dataapi
 * 版权：中科恒运软件科技股份有限公司贵阳分公司
 * 描述：共享申请管理
 * 修改人：zhaopengfei
 * 修改时间：2018/4/22
 * 修改内容：新增基础接口
 */
@Api(value = "API - ShareDataApplyApiImpl.java", description = "共享申请管理")
@RestController
@Slf4j
public class ShareDataApplyApiImpl /*implements ShareDataApplyApi */ {
    @Autowired
    private ShareDataApiUserService shareDataApiUserService;

    @Autowired
    private DozerUtils dozerUtils;

    @Autowired
    private CommonService commonService;

    @Autowired
    private ShareFlowService shareFlowService;

    @Autowired
    private ShareDataApiElementService shareDataApiElementService;

    @Autowired
    private ShareDataApiService shareDataApiService;

    @Autowired
    private ShareDataApiFilterService shareDataApiFilterService;

    @Autowired
    private ShareDataApiRenewalService shareDataApiRenewalService;

    @Autowired
    private DataDirectoryService dataDirectoryService;

    @Autowired
    private ShareDataFileService shareDataFileService;
    @Autowired
    private GxqPtRoleUnits gxqPtRoleUnits;

    @Autowired
    private IdGenerate<Long> idGenerate;

    /**
     * 描述：保存共享申请
     * 参数：ShareApplySaveDTO API元数据
     * 返回值：Boolean 状态（成功、失败）
     * 修改人：zhaopengfei
     * 修改时间：2018/4/21
     * 修改内容：
     */

    @ApiOperation(value = "保存共享申请", notes = "保存共享申请")
    @ApiResponses({
            @ApiResponse(code = 86010, message = "共享申请对象不能为空"),
            @ApiResponse(code = 85000, message = "数据目录ID不允许为空"),
            @ApiResponse(code = 86011, message = "共享申请授权期限不能为空"),
            @ApiResponse(code = 885009, message = "数据目录对象不能为空"),
    })
    @RequestMapping(value = "/apply/saveshareapply", method = RequestMethod.POST)
    public Result<Boolean> saveShareApply(@RequestBody ShareApplySaveDTO dto) {
        //数据验证
        BizAssert.assertNotNull(ExchangeExceptionCode.SHARE_APPLY_NULL, dto);
        BizAssert.assertNotNull(ExchangeExceptionCode.DIRECTORY_ID_NULL, dto.getDirId());
        BizAssert.assertNotNull(ExchangeExceptionCode.SHARE_APPLY_LIMIT_NULL, dto.getLimtTime());

        //基础数据获取
        Long userId = BaseContextHandler.getAdminId();
        Date date = new Date();
        //获取单位Id
        String unitId = commonService.getOrgIdByUserId(userId);
        try {
            Integer applyType = dto.getApplyType();
            String applyCode = "";
            if (applyType == 1 || applyType == 3) {
                applyCode = ShareUtil.automaticCode(ApplyType.API_APPLY.getVal());
            } else if (applyType == 2) {
                applyCode = ShareUtil.automaticCode(ApplyType.API_NOT_EXIST_APPLY.getVal());
                //保存API基础信息
                ShareDataApi api = shareDataApiService.getById(dto.getApiId());
                if (ObjectUtils.isEmpty(api)) {
                    return new Result(1, "", ExchangeExceptionCode.SHARE_APPLY_STEP_NULL.getMsg());
                }
                api.setApiName(dto.getApiName());
                String apiCode = UUID.randomUUID().toString().replace("-", "");
                ;
                api.setApiCode(apiCode);
                api.setAuthStatus(1);
                api.setApiType(3);
                api.setDataFmat(dto.getDataFmat());
                shareDataApiService.updateByIdSelective(api);
            }
            Integer day = DateUtils.getDistDates(date, dto.getLimtTime());
            ShareDataApiUser shareDataApiUser = shareDataApiUserService.getById(dto.getId());
            if (ObjectUtils.isEmpty(shareDataApiUser)) {
                shareDataApiUser = new ShareDataApiUser();
                shareDataApiUser.setApiType(3);
                shareDataApiUser.setApplyCode(applyCode);
                shareDataApiUser.setUnitId(unitId);
                shareDataApiUser.setApiId(dto.getApiId());
                shareDataApiUser.setDateTerm(day);
                shareDataApiUser.setAuthStatus(1);
                shareDataApiUser.setLimitTime(dto.getLimtTime());
                shareDataApiUser.setReason(dto.getReason());
                shareDataApiUser.setIsTake(2);
                shareDataApiUser.setUserId(userId);
                shareDataApiUser.setApplyTime(date);
                shareDataApiUser.setCreateUser(userId);
                shareDataApiUser.setCreateTime(date);
                shareDataApiUser.setUpdateTime(date);
                shareDataApiUser.setUpdateUser(userId);
                shareDataApiUserService.save(shareDataApiUser);
            } else {
                applyCode = shareDataApiUser.getApplyCode();
                shareDataApiUser.setDateTerm(day);
                shareDataApiUser.setAuthStatus(1);
                shareDataApiUser.setLimitTime(dto.getLimtTime());
                shareDataApiUser.setReason(dto.getReason());
                shareDataApiUser.setApiType(2);
                shareDataApiUser.setUpdateTime(date);
                shareDataApiUser.setUpdateUser(userId);
                shareDataApiUserService.updateByIdSelective(shareDataApiUser);
            }


            //保存附件
            if (!ObjectUtils.isEmpty(dto.getFileList())) {
                List<ShareDataFile> shareDataFiles = new ArrayList<>();
                for (DemandFileDTO fileDTO : dto.getFileList()) {
                    ShareDataFile file = dozerUtils.map(fileDTO, ShareDataFile.class);
                    file.setBusId(shareDataApiUser.getId());
                    file.setBusType(FileBusType.API_APPLY_ACCORD.getVal());
                    file.setCreateTime(date);
                    file.setCreateUser(userId);
                    file.setUpdateTime(date);
                    file.setUpdateUser(userId);
                    file.setId(idGenerate.generate());
                    shareDataFiles.add(file);
                }
                shareDataFileService.saveBatch(shareDataFiles);
            }

            // 启动流程
            shareFlowService.saveStartFlow(4, applyCode, ExchangeConstants.FLOW_API_CODE, userId, unitId);
            //发送消息
        } catch (Exception e) {
            return Result.fail(e);
        }
        return Result.success(true);

    }

    /**
     * 描述：根据共享申请Id查找共享申请详细信息
     * 参数：id 申请Id
     * 返回值：ShareApplyDetailDTO
     * 修改人：zhaopengfei
     * 修改时间：2018/4/21
     * 修改内容：
     */

    @ApiOperation(value = "根据共享申请Id查找共享申请详细信息", notes = "根据共享申请Id查找共享申请详细信息")
    @ApiResponses({
            @ApiResponse(code = 86012, message = "共享申请Id不能为空"),
    })
    @RequestMapping(value = "/apply/detail", method = RequestMethod.POST)
    public Result<ShareApplyDetailDTO> getById(@RequestParam("id") Long id) {
        //数据验证
        BizAssert.assertNotNull(ExchangeExceptionCode.SHARE_APPLY_ID_NULL, id);
        ShareDataApiUser shareDataApiUser = shareDataApiUserService.getById(id);
        ShareApplyDetailDTO detailDTO = new ShareApplyDetailDTO();
        detailDTO.setLimitTime(shareDataApiUser.getLimitTime());
        detailDTO.setReason(shareDataApiUser.getReason());
        detailDTO.setApplyTime(shareDataApiUser.getApplyTime());
        detailDTO.setSecretKey(shareDataApiUser.getSecretKey());

        ShareDataApi api = shareDataApiService.getById(shareDataApiUser.getApiId());
        if (ObjectUtils.isEmpty(api)) {
            return Result.fail(ExchangeExceptionCode.SHARE_APPLY_APIID_NOT_EXIST);
        }
        ShareDataDirectory directory = dataDirectoryService.getById(api.getDirId());
        detailDTO.setSetId(directory.getSetId());
        //业务逻辑
        detailDTO.setApiName(api.getApiName());
        detailDTO.setApiUrl(api.getApiUrl() + "/" + shareDataApiUser.getSecretKey());
        detailDTO.setApiCode(api.getApiCode());
        detailDTO.setCreateTime(api.getCreateTime());
        detailDTO.setCreateUserName("");
        String dataFmat = "json";
        if (api.getDataFmat().equals(2)) {
            dataFmat = "xml";
        }
        detailDTO.setDataFmat(dataFmat);

        //封装查询字段列表
        List<ShareDataElement> elements = shareDataApiElementService.findElementInfoByApiId(api.getId());
        detailDTO.setElementList(dozerUtils.mapList(elements, ApiElementBaseDTO.class));

        //封装过滤条件字段列表
        List<ShareDataApiFilterDO> filterList = shareDataApiFilterService.findFilterInfoByApiId(api.getId());
        detailDTO.setFilterList(dozerUtils.mapList(filterList, ApiFilterBaseDTO.class));

        //封装附件信息
        ShareDataFileExample fileExample = new ShareDataFileExample();
        fileExample.createCriteria().andBusIdEqualTo(id)
                .andBusTypeEqualTo(FileBusType.DEMAND_APPLY_ACCORD.getVal());
        List<ShareDataFile> files = shareDataFileService.find(fileExample);
        detailDTO.setFileList(dozerUtils.mapList(files, DemandFileDTO.class));
        return Result.success(detailDTO);
    }

    /**
     * 描述：更新订阅状态
     * 参数：id 申请Id
     * 参数：isTake：是否订阅：1：订阅；2，取消订阅
     * 返回值：Boolean 操作状态
     * 修改人：zhaopengfei
     * 修改时间：2018/4/22
     * 修改内容：
     */

    @ApiOperation(value = "更新订阅状态", notes = "更新订阅状态")
    @ApiResponses({
            @ApiResponse(code = 86012, message = "共享申请Id不能为空"),
            @ApiResponse(code = 86013, message = "订阅状态不能为空"),
    })
    @RequestMapping(value = "/apply/updatetake", method = RequestMethod.POST)
    public Result<Boolean> updatetake(@RequestParam(value = "id") Long id, @RequestParam(value = "isTake") Integer isTake) {
        //数据验证
        BizAssert.assertNotNull(ExchangeExceptionCode.SHARE_APPLY_ID_NULL, id);
        BizAssert.assertNotNull(ExchangeExceptionCode.SHARE_APPLY_TAKE_NULL, isTake);

        //基础数据获取
        Long userId = BaseContextHandler.getAdminId();
        Date date = new Date();

        //业务操作
        ShareDataApiUser shareDataApiUser = new ShareDataApiUser();
        shareDataApiUser.setId(id);
        shareDataApiUser.setIsTake(isTake);
        shareDataApiUser.setUpdateTime(date);
        shareDataApiUser.setUpdateUser(userId);
        shareDataApiUserService.updateByIdSelective(shareDataApiUser);

        return Result.success(true);
    }


    /**
     * 描述：api延续申请
     * 参数：ApiIRenewalDTO
     * 返回值：Boolean 操作状态
     * 修改人：zhaopengfei
     * 修改时间：2018/4/22
     * 修改内容：
     */

    @ApiOperation(value = "api延续申请", notes = "api延续申请")
    @ApiResponses({
            @ApiResponse(code = 86012, message = "共享申请Id不能为空"),
            @ApiResponse(code = 86005, message = "API id不能为空"),
            @ApiResponse(code = 86011, message = "共享申请授权期限不能为空"),
    })
    @RequestMapping(value = "/apply/renewal", method = RequestMethod.POST)
    public Result<Boolean> updateLimitTime(@RequestBody ApiIRenewalDTO dto) {
        //数据验证
        BizAssert.assertNotNull(ExchangeExceptionCode.API_ID_NULL, dto.getApiId());
        BizAssert.assertNotNull(ExchangeExceptionCode.SHARE_APPLY_ID_NULL, dto.getId());
        BizAssert.assertNotNull(ExchangeExceptionCode.SHARE_APPLY_LIMIT_NULL, dto.getDateTerm());

        //基础数据获取
        Long userId = BaseContextHandler.getAdminId();
        Date date = new Date();
        //获取单位Id
        String unitId = commonService.getOrgIdByUserId(userId);
        String applyCode = ShareUtil.automaticCode(ApplyType.API_RENEVAL_APPLY.getVal());

        //业务处理
        ShareDataApiRenewal shareDataApiRenewal = dozerUtils.map(dto, ShareDataApiRenewal.class);

        shareDataApiRenewal.setApplyCode(applyCode);
        shareDataApiRenewal.setDateTerm(dto.getDateTerm());
        shareDataApiRenewal.setApplyTime(date);
        shareDataApiRenewal.setUserId(userId);
        shareDataApiRenewal.setCreateTime(date);
        shareDataApiRenewal.setCreateUser(userId);
        shareDataApiRenewal.setUnitId(unitId);
        shareDataApiRenewal.setUpdateTime(date);
        shareDataApiRenewal.setUpdateUser(userId);
        shareDataApiRenewal.setAuthStatus(1);
        shareDataApiRenewalService.save(shareDataApiRenewal);

        //启动流程
        shareFlowService.saveStartFlow(5, applyCode, ExchangeConstants.FLOW_API_RENEWAL_CODE, userId, unitId);
        return Result.success(true);
    }

    /**
     * 描述：查询api分页数据
     * 参数：openApiReq 分页信息；
     * 返回值：PageInfo<ShareApplyListDTO>
     * 修改人：zhaopengfei
     * 修改时间：2018/4/21
     * 修改内容：
     */

    @ApiOperation(value = "查询共享申请分页数据", notes = "查询共享申请分页数据")
    @RequestMapping(value = "/apply/find", method = RequestMethod.POST)
    public Result<PageInfo<ShareApplyListDTO>> page(@RequestBody OpenApiReq<ShareApplyQueryDTO> openApiReq) {
        //基础数据获取
        Long userId = BaseContextHandler.getAdminId();
        //获取单位Id
        Boolean ptAdmin = gxqPtRoleUnits.getGxqPtRole(userId, GxqPtRoleUnits.PT_ADMIN_ROLE_CODE);

        Map<String, Object> param = new HashMap<>();
        if (openApiReq.getData() != null) {
            param.put("apiName", openApiReq.getData().getApiName());
            param.put("dirId", openApiReq.getData().getDirId());
            param.put("apiStatus", openApiReq.getData().getApiStatus());
            param.put("authStatus", openApiReq.getData().getStatus());
        }
        if (!ptAdmin) {
            String unitId = commonService.getOrgIdByUserId(userId);
            param.put("unitId", unitId);
        }
        PageHelper.startPage(openApiReq.getPageNo(), openApiReq.getPageSize());
        List<ShareDataApiUserListDO> list = shareDataApiUserService.findList(param);
        return Result.success(new PageInfo<>(dozerUtils.mapPage(list, ShareApplyListDTO.class)));
    }


    /**
     * 描述：根据共享申请Id查询api续期基础信息
     * 参数：id：共享申请id
     * 返回值：ApiRenewalInfoDTO
     * 修改人：zhaopengfei
     * 修改时间：2018/5/1
     * 修改内容：
     */
    @RequestMapping(value = "/api/apirenewalinfo", method = RequestMethod.POST)
    @ApiOperation(value = "根据共享申请Id查询api续期基础信息", notes = "根据共享申请Id查询api续期基础信息")
    @ApiResponses({
            @ApiResponse(code = 86012, message = "共享申请Id不能为空"),
    })

    public Result<ApiRenewalInfoDTO> queryBaseInfo(@RequestParam("id") Long id) {
        //数据验证
        BizAssert.assertNotNull(ExchangeExceptionCode.SHARE_APPLY_ID_NULL, id);

        ShareDataApiRenewalDO api = shareDataApiUserService.queryApiBaseInfo(id);

        return Result.success(dozerUtils.map(api, ApiRenewalInfoDTO.class));
    }

    /**
     * 描述：根据API id查询该单位是否已经申请过
     * 参数：apiId
     * 返回值：true:已经申请 false 未申请
     * 修改人：zhaopengfei
     * 修改时间：2018/5/11
     * 修改内容：
     */
    @RequestMapping(value = "/apply/getapiapplystatus", method = RequestMethod.POST)
    @ApiOperation(value = "id查询该单位是否已经申请过", notes = "id查询该单位是否已经申请过")
    @ApiResponses({
            @ApiResponse(code = 86005, message = "API id不能为空"),
    })

    public Result<Boolean> getApiApplyStatus(@RequestParam("apiId") Long apiId) {
        boolean haveApply = false;
        //数据验证
        BizAssert.assertNotNull(ExchangeExceptionCode.API_ID_NULL, apiId);

        Long userId = BaseContextHandler.getAdminId();
        //获取单位Id
        String unitId = commonService.getOrgIdByUserId(userId);
        List<Integer> authStatus = Arrays.asList(1, 3);
        ShareDataApiUserExample example = new ShareDataApiUserExample();
        example.createCriteria().andUnitIdEqualTo(unitId)
                .andApiIdEqualTo(apiId)
                .andAuthStatusIn(authStatus);
        List<ShareDataApiUser> list = shareDataApiUserService.find(example);
        if (!list.isEmpty()) {
            haveApply = true;
        }
        return Result.success(haveApply);
    }

    /**
     * 描述：共享单位删除
     * 参数：id 共享申请Id
     * 返回值：Boolean
     * 修改人：zhaopengfei
     * 修改时间：2018/5/12
     * 修改内容：
     */
    @ApiOperation(value = "共享单位删除", notes = "共享单位删除")
    @ApiResponses({
            @ApiResponse(code = 86012, message = "共享申请Id不能为空"),
    })

    @RequestMapping(value = "/apply/deleteshareunit", method = RequestMethod.POST)
    public Result<Boolean> deleteShareUnit(@RequestParam("id") Long id) {
        //数据验证
        BizAssert.assertNotNull(ExchangeExceptionCode.SHARE_APPLY_ID_NULL, id);
        shareDataApiUserService.deleteById(id);

        return Result.success(true);
    }

    /**
     * 描述：删除共享申请
     * 参数：id 共享申请Id
     * 返回值：Boolean
     * 修改人：zhaopengfei
     * 修改时间：2018/6/8
     * 修改内容：
     */

    @ApiOperation(value = "删除共享申请", notes = "删除共享申请")
    @ApiResponses({
            @ApiResponse(code = 86012, message = "共享申请Id不能为空"),
    })
    @RequestMapping(value = "/apply/delete", method = RequestMethod.POST)
    public Result<Boolean> delete(@RequestParam("id") Long id) {
        //1.验证
        BizAssert.assertNotNull(ExchangeExceptionCode.SHARE_APPLY_ID_NULL, id);
        ShareDataApiUser shareDataApiUser = shareDataApiUserService.getById(id);
        if (ObjectUtils.isEmpty(shareDataApiUser)) {
            return Result.fail(ExchangeExceptionCode.TASK_API_USER_NULL.getCode(), ExchangeExceptionCode.TASK_API_USER_NULL.getMsg());
        }
        //2.删除与申请相关Api的查询字段
        ShareDataApiElementExample elementExa = new ShareDataApiElementExample();
        elementExa.createCriteria().andApiIdEqualTo(shareDataApiUser.getApiId());
        shareDataApiElementService.deleteByExample(elementExa);
        //3.删除与申请相关Api的过滤字段
        ShareDataApiFilterExample filterExample = new ShareDataApiFilterExample();
        filterExample.createCriteria().andApiIdEqualTo(shareDataApiUser.getApiId());
        shareDataApiFilterService.deleteByExample(filterExample);
        //4.删除共享申请创建的API
        shareDataApiService.deleteById(shareDataApiUser.getApiId());
        //5.删除共享申请信息
        shareDataApiUserService.deleteById(id);
        //4.返回
        return Result.success(true);
    }


    /**
     * 描述：根据API id查询该单位所申请API的密钥
     * 参数：apiId
     * 返回值：String  密钥
     * 修改人：zhaopengfei
     * 修改时间：2018/5/11
     * 修改内容：
     */
    @RequestMapping(value = "/apply/getApiApplyKey", method = RequestMethod.POST)
    @ApiOperation(value = "id查询该单位所申请API的密钥", notes = "id查询该单位所申请API的密钥")
    @ApiResponses({
            @ApiResponse(code = 86005, message = "API id不能为空"),
    })

    public Result<String> getApiApplyKey(@RequestParam("apiId") Long apiId) {
        //数据验证
        BizAssert.assertNotNull(ExchangeExceptionCode.API_ID_NULL, apiId);

        Long userId = BaseContextHandler.getAdminId();
        //获取单位Id
        String unitId = commonService.getOrgIdByUserId(userId);
        String secretKey = "";
        ShareDataApiUserExample example = new ShareDataApiUserExample();
        example.createCriteria().andUnitIdEqualTo(unitId)
                .andApiIdEqualTo(apiId)
                .andAuthStatusEqualTo(3);
        List<ShareDataApiUser> list = shareDataApiUserService.find(example);
        if (!list.isEmpty()) {
            secretKey = list.get(0).getSecretKey();
        }
        return Result.success(secretKey);
    }

    /**
     * 描述：根据API id查询该单位申请的API是否过期
     * 参数：apiId
     * 返回值：Boolean  true 有效，false：无效
     * 修改人：zhaopengfei
     * 修改时间：2018/5/11
     * 修改内容：
     */
    @RequestMapping(value = "/apply/isValid", method = RequestMethod.POST)
    @ApiOperation(value = "id查询该单位申请的API是否过期", notes = "id查询该单位申请的API是否过期")
    @ApiResponses({
            @ApiResponse(code = 86005, message = "API id不能为空"),
    })

    public Result<Boolean> isValid(@RequestParam("apiId") Long apiId) {
        //数据验证
        BizAssert.assertNotNull(ExchangeExceptionCode.API_ID_NULL, apiId);
        Long userId = BaseContextHandler.getAdminId();
        //获取单位Id
        String unitId = commonService.getOrgIdByUserId(userId);
        Boolean valid = true; //有效
        ShareDataApiUserExample example = new ShareDataApiUserExample();
        example.createCriteria().andUnitIdEqualTo(unitId)
                .andApiIdEqualTo(apiId).andDateTermNotEqualTo(-1).andSecretKeyIsNotNull();
        List<ShareDataApiUser> list = shareDataApiUserService.find(example);
        if (!list.isEmpty()) {
            Date validDate = list.get(0).getLimitTime();
            if (validDate.getTime() < new Date().getTime()) {
                valid = false;
            }
        }
        return Result.success(valid);
    }


}
