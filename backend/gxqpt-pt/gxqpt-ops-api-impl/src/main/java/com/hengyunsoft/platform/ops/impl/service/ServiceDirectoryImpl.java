package com.hengyunsoft.platform.ops.impl.service;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hengyunsoft.base.Result;
import com.hengyunsoft.commons.context.BaseContextHandler;
import com.hengyunsoft.commons.exception.core.OperationExceptionCode;
import com.hengyunsoft.commons.utils.context.DozerUtils;
import com.hengyunsoft.db.example.BaseExample;
import com.hengyunsoft.page.plugins.openapi.OpenApiReq;
import com.hengyunsoft.platform.admin.api.core.api.GxqptEmpApi;
import com.hengyunsoft.platform.admin.api.core.api.GxqptOrgApi;
import com.hengyunsoft.platform.admin.api.core.dto.emp.GxqptEmpRetDTO;
import com.hengyunsoft.platform.admin.api.core.dto.org.GxqptOrgResDTO;
import com.hengyunsoft.platform.admin.api.core.dto.org.OrgDeptDutyInfoDTO;
import com.hengyunsoft.platform.admin.open.core.api.GxqptOrgOpenApi;
import com.hengyunsoft.platform.commons.sec.UserTokenExtInfo;
import com.hengyunsoft.platform.commons.utils.TreeUtil;
import com.hengyunsoft.platform.msgs.dto.bbs.BbsAllMainMsgDTO;
import com.hengyunsoft.platform.msgs.dto.bbs.UpdateBacklogReqDTO;
import com.hengyunsoft.platform.msgs.queue.BbbMsgQueueProducer;
import com.hengyunsoft.platform.ops.consultdto.DealUserDTO;
import com.hengyunsoft.platform.ops.entity.alarm.po.AlarmInformation;
import com.hengyunsoft.platform.ops.entity.file.po.OperationFile;
import com.hengyunsoft.platform.ops.entity.person.po.ChargeSystem;
import com.hengyunsoft.platform.ops.entity.person.po.DealUser;
import com.hengyunsoft.platform.ops.entity.person.po.PersonManage;
import com.hengyunsoft.platform.ops.entity.service.po.ServiceDirectory;
import com.hengyunsoft.platform.ops.entity.service.po.ServiceManage;
import com.hengyunsoft.platform.ops.entity.service.po.ServiceSystem;
import com.hengyunsoft.platform.ops.impl.utils.OpsCode;
import com.hengyunsoft.platform.ops.impl.utils.OpsCodeUtil;
import com.hengyunsoft.platform.ops.impl.utils.PushSuperviseTemp;
import com.hengyunsoft.platform.ops.operationfiledto.OperationFileDTO;
import com.hengyunsoft.platform.ops.repository.alarm.example.AlarmInformationExample;
import com.hengyunsoft.platform.ops.repository.alarm.service.AlarmInformationService;
import com.hengyunsoft.platform.ops.repository.file.example.OperationFileExample;
import com.hengyunsoft.platform.ops.repository.file.service.OperationFileService;
import com.hengyunsoft.platform.ops.repository.person.example.ChargeSystemExample;
import com.hengyunsoft.platform.ops.repository.person.example.DealUserExample;
import com.hengyunsoft.platform.ops.repository.person.service.ChargeSystemService;
import com.hengyunsoft.platform.ops.repository.person.service.DealUserService;
import com.hengyunsoft.platform.ops.repository.person.service.PersonService;
import com.hengyunsoft.platform.ops.repository.service.example.ServiceDirectoryExample;
import com.hengyunsoft.platform.ops.repository.service.example.ServiceManageExample;
import com.hengyunsoft.platform.ops.repository.service.example.ServiceSystemExample;
import com.hengyunsoft.platform.ops.repository.service.service.ServiceDirectoryService;
import com.hengyunsoft.platform.ops.repository.service.service.ServiceManageService;
import com.hengyunsoft.platform.ops.repository.service.service.ServiceSystemService;
import com.hengyunsoft.platform.ops.servicedto.*;
import com.hengyunsoft.utils.BizAssert;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.stream.Collectors;

@RestController
@Slf4j
@RequestMapping("service")
@Api(value = "API - ServiceDirectoryImpl", description = "服务目录管理")
public class ServiceDirectoryImpl {

    @Autowired
    private ServiceDirectoryService serviceDirectoryService;
    @Autowired
    private DozerUtils dozerUtils;
    @Autowired
    private ServiceManageService serviceManageService;
    @Autowired
    private ServiceSystemService serviceSystemService;
    @Autowired
    private ChargeSystemService chargeSystemService;
    @Autowired
    private DealUserService dealUserService;
    @Autowired
    private GxqptEmpApi gxqptEmpApi;
    @Autowired
    private OperationFileService operationFileService;
    @Autowired
    private BbbMsgQueueProducer msgQueueProducer;
    @Autowired
    GxqptOrgOpenApi gxqptOrgOpenApi;
    @Autowired
    GxqptOrgApi gxqptOrgApi;
    @Autowired
    private PersonService personService;
    @Autowired
    private AlarmInformationService alarmInformationService;
    @Autowired
    PushSuperviseTemp pushSuperviseTemp;
    /**
     * 驳回状态值
     */
    private Integer two = 2;
    private Integer three = 3;

    @ApiOperation(value = "查询服务目录树", notes = "查询服务目录树")
    @RequestMapping(value = "/getTree", method = RequestMethod.GET)
    public Result<List<ServiceDirectoryTreeDTO>> getTree(@RequestParam(value = "serviceName") String serviceName) {
        List<ServiceDirectory> list;
        ServiceDirectoryExample example = new ServiceDirectoryExample();
        if (StringUtils.isNoneBlank(serviceName)) {
            list = serviceDirectoryService.getPageList(serviceName);
            if (list != null && !list.isEmpty()) {
                // id集合
                Set<Long> ids = new HashSet<>();
                List<ServiceDirectory> treeList = new ArrayList<>(list);
                list.forEach(l -> {
                    // 排除父节点查询
                    if (!ids.contains(l.getId())) {
                        treeList.addAll(serviceDirectoryService.selectParentsById(l.getId()));
                        ids.add(l.getId());
                        ids.add(l.getParentId());
                    }
                });

                // 数据去重
                list = treeList.stream().collect(
                        Collectors.collectingAndThen(Collectors.toCollection(() -> new TreeSet<>(Comparator.comparing(ServiceDirectory::getId))), ArrayList::new));
            }
        } else {
            list = serviceDirectoryService.find(example);
        }
        List<ServiceDirectoryTreeDTO> resultList = dozerUtils.mapList(list, ServiceDirectoryTreeDTO.class);

        // 构建树并返回
        return Result.success(TreeUtil.builderTreeOrdered(resultList));
    }

    @ApiOperation(value = "保存服务目录信息", notes = "保存服务目录信息")
    @ApiResponses({
            @ApiResponse(code = 105030, message = "父id不能为空"),
            @ApiResponse(code = 105031, message = "排序不能为空"),
            @ApiResponse(code = 105032, message = "层级不能为空"),
            @ApiResponse(code = 105033, message = "类型不能为空"),
            @ApiResponse(code = 105034, message = "服务名称不能为空")
    })
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public Result<ServiceDirectorySaveDTO> save(@RequestBody ServiceDirectorySaveDTO saveDTO) {
        //1.校验
        BizAssert.assertNotNull(OperationExceptionCode.PID_ID_NULL, saveDTO.getParentId());
        BizAssert.assertNotNull(OperationExceptionCode.SORT_NULL, saveDTO.getSort());
        BizAssert.assertNotNull(OperationExceptionCode.LEVEL_NULL, saveDTO.getLevel());
        BizAssert.assertNotNull(OperationExceptionCode.TYPE_NULL, saveDTO.getType());
        if (saveDTO.getLevel() == 4) {
            BizAssert.assertNotNull(OperationExceptionCode.LSERVICE_NAME_NULL, saveDTO.getServiceName());
        }
        //转换，保存与运维人员表数据
        Long userId = BaseContextHandler.getAdminId();
        ServiceDirectory serviceDirectory = dozerUtils.map(saveDTO, ServiceDirectory.class);
        serviceDirectory.setCreateUser(userId);
        serviceDirectory.setUpdateUser(userId);
        serviceDirectoryService.saveSelective(serviceDirectory);

        return Result.success(dozerUtils.map(serviceDirectory, ServiceDirectorySaveDTO.class));
    }

    @ApiOperation(value = "删除服务目录信息", notes = "删除服务目录信息")
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public Result<Boolean> delete(@RequestParam(value = "id") Long id) {
        if (id == null) {
            return Result.fail("服务目录id不能为空");
        }
        serviceDirectoryService.deleteById(id);
        return Result.success(true);
    }

    @ApiOperation(value = "保存服务目录信息", notes = "保存服务目录信息")
    @ApiResponses({
            @ApiResponse(code = 105030, message = "父id不能为空"),
            @ApiResponse(code = 105031, message = "排序不能为空"),
            @ApiResponse(code = 105032, message = "层级不能为空"),
            @ApiResponse(code = 105033, message = "类型不能为空"),
            @ApiResponse(code = 105034, message = "服务名称不能为空")
    })
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public Result<ServiceDirectorySaveDTO> update(@RequestBody ServiceDirectorySaveDTO saveDTO) {
        //1.校验
        BizAssert.assertNotNull(OperationExceptionCode.SORT_NULL, saveDTO.getSort());
        BizAssert.assertNotNull(OperationExceptionCode.PID_ID_NULL, saveDTO.getParentId());
        BizAssert.assertNotNull(OperationExceptionCode.LEVEL_NULL, saveDTO.getLevel());
        BizAssert.assertNotNull(OperationExceptionCode.TYPE_NULL, saveDTO.getType());
        if (saveDTO.getLevel() == 4) {
            BizAssert.assertNotNull(OperationExceptionCode.LSERVICE_NAME_NULL, saveDTO.getServiceName());
        }
        //转换，保存服务目录表数据
        Long userId = BaseContextHandler.getAdminId();
        ServiceDirectory serviceDirectory = dozerUtils.map(saveDTO, ServiceDirectory.class);
        serviceDirectory.setUpdateUser(userId);
        serviceDirectoryService.updateByIdSelective(serviceDirectory);
        return Result.success(dozerUtils.map(serviceDirectory, ServiceDirectorySaveDTO.class));
    }

    @ApiOperation(value = "查询服务申请分页信息", notes = "查询服务申请分页信息")
    @RequestMapping(value = "/page", method = RequestMethod.POST)
    public Result<PageInfo<ServiceMangeDTO>> page(@RequestBody OpenApiReq<ServiceManagePageReqDTO> openApiReq) {

        String userId = BaseContextHandler.getAdminId().toString();

        Map<String, Object> map = new HashMap();
        map.put("startTime", openApiReq.getData().getStartTime());
        map.put("endTime", openApiReq.getData().getEndTime());
        map.put("startScore", openApiReq.getData().getStartScore());
        map.put("endScore", openApiReq.getData().getEndScore());
        map.put("serviceType", openApiReq.getData().getServiceType());
        map.put("status", openApiReq.getData().getStatus());
        map.put("applyUser", userId);
        map.put("applyCode", BaseExample.fullLike(openApiReq.getData().getApplyCode()));

        PageHelper.startPage(openApiReq.getPageNo(), openApiReq.getPageSize());
        List<ServiceManage> list = serviceManageService.getPageList(map);
        PageInfo<ServiceMangeDTO> mangeDTOList = new PageInfo<>(dozerUtils.mapPage(list, ServiceMangeDTO.class));
        List<ServiceSystemDTO> systemDTOList = null;
        if (mangeDTOList.getList() != null && mangeDTOList.getList().size() > 0) {
            for (ServiceMangeDTO dto : mangeDTOList.getList()) {
                ServiceSystemExample systemExample = new ServiceSystemExample();
                systemExample.createCriteria().andPIdEqualTo(dto.getId());
                systemDTOList = dozerUtils.mapList(serviceSystemService.find(systemExample), ServiceSystemDTO.class);
                dto.setSystemName(systemDTOList);
            }
        }
        return Result.success(mangeDTOList);
    }

    @ApiOperation(value = "查询服务审核分页信息", notes = "查询服务审核分页信息")
    @RequestMapping(value = "/pageAuditList", method = RequestMethod.POST)
    public Result<PageInfo<ServiceMangeDTO>> pageAuditList(@RequestBody OpenApiReq<ServiceManagePageReqDTO> openApiReq) {


        Map<String, Object> map = new HashMap();
        map.put("startTime", openApiReq.getData().getStartTime());
        map.put("endTime", openApiReq.getData().getEndTime());
        map.put("startScore", openApiReq.getData().getStartScore());
        map.put("endScore", openApiReq.getData().getEndScore());
        map.put("serviceType", openApiReq.getData().getServiceType());
        map.put("status", openApiReq.getData().getStatus());
        map.put("applyCode", BaseExample.fullLike(openApiReq.getData().getApplyCode()));

        PageHelper.startPage(openApiReq.getPageNo(), openApiReq.getPageSize());
        List<ServiceManage> list = serviceManageService.getAuditList(map);
        if (list != null && list.size() > 0) {
            PageInfo<ServiceMangeDTO> mangeDTOList = new PageInfo<>(dozerUtils.mapPage(list, ServiceMangeDTO.class));
            List<ServiceSystemDTO> systemDTOList = null;
            if (mangeDTOList.getList() != null && mangeDTOList.getList().size() > 0) {
                for (ServiceMangeDTO dto : mangeDTOList.getList()) {
                    ServiceSystemExample systemExample = new ServiceSystemExample();
                    systemExample.createCriteria().andPIdEqualTo(dto.getId());
                    systemDTOList = dozerUtils.mapList(serviceSystemService.find(systemExample), ServiceSystemDTO.class);
                    dto.setSystemName(systemDTOList);

                    Result<OrgDeptDutyInfoDTO> orgDeptDutyInfo = gxqptOrgOpenApi.getOrgDeptDutyByUserId(Long.valueOf(dto.getApplyUser()));
                    if (orgDeptDutyInfo.getData() != null && orgDeptDutyInfo.getData().getUserName() != null) {
                        dto.setApplyUser(orgDeptDutyInfo.getData().getUserName());
                        dto.setApplyOrg(orgDeptDutyInfo.getData().getOrgName());
                    } else {
                        dto.setApplyUser("用户名为空");
                    }
                }
            }
            return Result.success(mangeDTOList);
        } else {
            PageInfo<ServiceMangeDTO> mangeDTOList = new PageInfo<>();
            return Result.success(mangeDTOList);
        }

    }

    @ApiOperation(value = "查询服务处理分页信息", notes = "查询服务处理分页信息")
    @RequestMapping(value = "/pageDealList", method = RequestMethod.POST)
    public Result<PageInfo<ServiceMangeDTO>> pageDealList(@RequestBody OpenApiReq<ServiceManagePageReqDTO> openApiReq) {
        UserTokenExtInfo userTokenExtInfo = (UserTokenExtInfo) BaseContextHandler.getUserTokenExtInfo();
        String appId = BaseContextHandler.getAppId();
        boolean isAdmin = userTokenExtInfo.isAppAdmin(appId);
        Long userId = BaseContextHandler.getAdminId();

        Map<String, Object> map = new HashMap();
        map.put("startTime", openApiReq.getData().getStartTime());
        map.put("endTime", openApiReq.getData().getEndTime());
        map.put("startScore", openApiReq.getData().getStartScore());
        map.put("endScore", openApiReq.getData().getEndScore());
        map.put("serviceType", openApiReq.getData().getServiceType());
        map.put("status", openApiReq.getData().getStatus());
        map.put("applyCode", BaseExample.fullLike(openApiReq.getData().getApplyCode()));

        List<ServiceManage> list = null;
        if (isAdmin) {
            PageHelper.startPage(openApiReq.getPageNo(), openApiReq.getPageSize());
            list = serviceManageService.getDealList(map);
        } else {
            map.put("userId", userId);
            list = serviceManageService.getByDealUserList(map);
        }
        if (list == null || list.size() == 0) {
            PageInfo<ServiceMangeDTO> mangeDTOList = new PageInfo<>();
            return Result.success(mangeDTOList);
        }
        PageInfo<ServiceMangeDTO> mangeDTOList = new PageInfo<>(dozerUtils.mapPage(list, ServiceMangeDTO.class));
        if (mangeDTOList != null && mangeDTOList.getList() != null && mangeDTOList.getList().size() > 0) {
            List<ServiceSystemDTO> systemDTOList = null;
            for (ServiceMangeDTO dto : mangeDTOList.getList()) {
                ServiceSystemExample systemExample = new ServiceSystemExample();
                systemExample.createCriteria().andPIdEqualTo(dto.getId());
                systemDTOList = dozerUtils.mapList(serviceSystemService.find(systemExample), ServiceSystemDTO.class);
                dto.setSystemName(systemDTOList);

                Result<OrgDeptDutyInfoDTO> orgDeptDutyInfo = gxqptOrgOpenApi.getOrgDeptDutyByUserId(Long.valueOf(dto.getApplyUser()));
                if (orgDeptDutyInfo.getData() != null && orgDeptDutyInfo.getData().getUserName() != null) {
                    dto.setApplyUser(orgDeptDutyInfo.getData().getUserName());
                    dto.setApplyOrg(orgDeptDutyInfo.getData().getOrgName());
                } else {
                    dto.setApplyUser("用户名为空");
                }
                //获取处理人信息
                List<DealUser> dealList = dealUserService.getByBussId(dto.getId());
                if (dealList != null && dealList.size() > 0) {
                    for (DealUser dealUser : dealList) {
                        String type = dealUser.getType();
                        //处理人只有一个
                        if ("clr".equals(type)) {
                            dto.setDealUser(dealUser.getPersonId());
                        }
                    }
                }
            }
        }
        return Result.success(mangeDTOList);
    }

    @ApiOperation(value = "查询服务分类", notes = "查询服务分类")
    @RequestMapping(value = "/getType", method = RequestMethod.GET)
    public Result<List<ServiceDirectoryDTO>> getType(@RequestParam(value = "level") Integer level, @RequestParam(value = "parentId") Long parentId) {
        if (level == null) {
            return Result.fail("服务分类level不能为空！");
        }
        if (parentId == null) {
            return Result.fail("服务分类父id不能为空！");
        }
        ServiceDirectoryExample example = new ServiceDirectoryExample();
        example.createCriteria().andLevelEqualTo(level).andParentIdEqualTo(parentId);
        List<ServiceDirectoryDTO> list = dozerUtils.mapList(serviceDirectoryService.find(example), ServiceDirectoryDTO.class);
        return Result.success(list);
    }

    @ApiOperation(value = "保存服务申请信息", notes = "保存服务申请信息")
    @ApiResponses({
            @ApiResponse(code = 105034, message = "服务类别"),
            @ApiResponse(code = 105035, message = "服务对象"),
            @ApiResponse(code = 105036, message = "服务分类"),
            @ApiResponse(code = 105037, message = "服务名称"),
    })
    @RequestMapping(value = "/saveMange", method = RequestMethod.POST)
    public Result<ServiceMangeSaveDTO> saveMange(@RequestBody ServiceMangeSaveDTO saveDTO) {
        //1.校验
        BizAssert.assertNotNull(OperationExceptionCode.SERVICE_TYPE_NULL, saveDTO.getServiceType());
        BizAssert.assertNotNull(OperationExceptionCode.SERVICE_OBJ_NULL, saveDTO.getServiceObj());
        BizAssert.assertNotNull(OperationExceptionCode.SERVICE_CLASS_NULL, saveDTO.getServiceClass());
        BizAssert.assertNotNull(OperationExceptionCode.SERVICE_NAME_NULL, saveDTO.getServiceName());
        //转换，保存服务申请信息
        Long userId = BaseContextHandler.getAdminId();
        ServiceManage serviceManage = dozerUtils.map(saveDTO, ServiceManage.class);
        String applyCode = OpsCodeUtil.automaticCode("FW");
        serviceManage.setApplyCode(applyCode);
        serviceManage.setStatus(1);
        serviceManage.setApplyUser(userId.toString());
        serviceManage.setCreateUser(userId);
        serviceManage.setUpdateUser(userId);
        serviceManageService.saveSelective(serviceManage);

        //保存负责系统表数据
        List<ServiceSystemDTO> systemList = saveDTO.getSystemName();
        List<ServiceSystem> arrList = new ArrayList<>();
        if (systemList != null && systemList.size() > 0) {
            for (ServiceSystemDTO syetemDTO : systemList) {
                ServiceSystem system = dozerUtils.map(syetemDTO, ServiceSystem.class);
                system.setpId(serviceManage.getId());
                system.setCreateUser(userId);
                system.setUpdateUser(userId);
                arrList.add(system);
            }
        }
        serviceSystemService.save(arrList);
        BbsAllMainMsgDTO bbsAllMainMsgDTO = null;
        String appId = BaseContextHandler.getAppId();
        String userName = BaseContextHandler.getName();
        String bizType = "yw_service_apply";
        ServiceDirectory serviceDirectory = serviceDirectoryService.getById(Long.valueOf(saveDTO.getServiceName()));
        bbsAllMainMsgDTO = builderBbsAllMainMsgDTO(serviceManage.getId(), bizType, "您有一条" +
                serviceDirectory.getServiceName() + "申请待审核", userName);
        msgQueueProducer.saveLookMsgToRole(bbsAllMainMsgDTO, "app_approval", appId);
        pushSuperviseTemp.pushSupervise(serviceManage.getId(), new Date(), null, OpsCode.SERVER_CODE.getCode(),
                OpsCode.SERVER_CODE.getName(), OpsCode.SERVER_CODE.getDescribe());
        return Result.success(dozerUtils.map(serviceManage, ServiceMangeSaveDTO.class));
    }

    private BbsAllMainMsgDTO builderBbsAllMainMsgDTO(Long id, String bizType, String moduleName, String userName) {
        BbsAllMainMsgDTO bbsAllMainMsgDTO = new BbsAllMainMsgDTO();
        bbsAllMainMsgDTO.setAppId(BaseContextHandler.getAppId());
        bbsAllMainMsgDTO.setAppName(BaseContextHandler.getAppName());
        bbsAllMainMsgDTO.setBizId(id.toString());
        bbsAllMainMsgDTO.setBizType(bizType);
        bbsAllMainMsgDTO.setBriefTpye("work_auth");
        bbsAllMainMsgDTO.setContent(moduleName);
        bbsAllMainMsgDTO.setTitle(moduleName);
        bbsAllMainMsgDTO.setClientFlag("gxqpt");
        bbsAllMainMsgDTO.setSingleHandleIs(false);

        bbsAllMainMsgDTO.setDetailedType(bizType);
        bbsAllMainMsgDTO.setDetailedTypeDesc("服务审核");
        bbsAllMainMsgDTO.setHandlerNeedIs(false);
        bbsAllMainMsgDTO.setHandlerUrl("/index.html#/serviceAudit");
        bbsAllMainMsgDTO.setSenderName("系统自动通知");
        return bbsAllMainMsgDTO;
    }

    @ApiOperation(value = "修改服务申请信息", notes = "修改服务申请信息")
    @ApiResponses({
            @ApiResponse(code = 105034, message = "服务类别"),
            @ApiResponse(code = 105035, message = "服务对象"),
            @ApiResponse(code = 105036, message = "服务分类"),
            @ApiResponse(code = 105037, message = "服务名称"),
    })
    @RequestMapping(value = "/updateMange", method = RequestMethod.POST)
    public Result<ServiceMangeUpdateDTO> updateMange(@RequestBody ServiceMangeUpdateDTO updateDTO) {
        //1.校验
        BizAssert.assertNotNull(OperationExceptionCode.SERVICE_TYPE_NULL, updateDTO.getServiceType());
        BizAssert.assertNotNull(OperationExceptionCode.SERVICE_OBJ_NULL, updateDTO.getServiceObj());
        BizAssert.assertNotNull(OperationExceptionCode.SERVICE_NAME_NULL, updateDTO.getServiceName());
        BizAssert.assertNotNull(OperationExceptionCode.SERVICE_CLASS_NULL, updateDTO.getServiceClass());

        //转换，保存服务申请信息
        Long userId = BaseContextHandler.getAdminId();
        ServiceManage serviceManage = dozerUtils.map(updateDTO, ServiceManage.class);
        serviceManage.setUpdateUser(userId);
        serviceManage.setStatus(1);
        serviceManageService.updateByIdSelective(serviceManage);

        //删除负责系统表数据
        ServiceSystemExample systemExample = new ServiceSystemExample();
        systemExample.createCriteria().andPIdEqualTo(updateDTO.getId());
        List<ServiceSystem> chargeSystem = serviceSystemService.find(systemExample);
        List<Long> userIds = new ArrayList<>();
        if (chargeSystem != null && chargeSystem.size() > 0) {
            for (ServiceSystem system : chargeSystem) {
                Long useId = system.getId();
                userIds.add(useId);
            }
            serviceSystemService.deleteByIds(userIds);
        }
        //保存负责系统表数据
        List<ServiceSystemDTO> systemList = updateDTO.getSystemName();
        List<ServiceSystem> arrList = new ArrayList<>();
        if (systemList != null && systemList.size() > 0) {
            for (ServiceSystemDTO syetemDTO : systemList) {
                ServiceSystem system = new ServiceSystem();
                system.setSystemId(syetemDTO.getSystemId());
                system.setSystemName(syetemDTO.getSystemName());
                system.setpId(serviceManage.getId());
                system.setUpdateUser(userId);
                system.setCreateUser(userId);
                arrList.add(system);
            }
        }
        serviceSystemService.save(arrList);
        pushSuperviseTemp.pushSupervise(serviceManage.getId(), new Date(), null, OpsCode.SERVER_CODE.getCode(),
                OpsCode.SERVER_CODE.getName(), OpsCode.SERVER_CODE.getDescribe());
        return Result.success(dozerUtils.map(serviceManage, ServiceMangeUpdateDTO.class));
    }


    @ApiResponses({
            @ApiResponse(code = 105039, message = "服务申请id不能为空"),
            @ApiResponse(code = 105041, message = "审批意见不能为空"),
            @ApiResponse(code = 105043, message = "处理人不能为空")
    })
    @ApiOperation(value = "审核服务申请信息", notes = "审核服务申请信息")
    @RequestMapping(value = "/updateAudit", method = RequestMethod.POST)
    public Result<ServiceMangeAuditDTO> updateAudit(@RequestBody ServiceMangeAuditDTO auditDTO) {
        //1.校验
        BizAssert.assertNotNull(OperationExceptionCode.SERVICE_ID_NULL, auditDTO.getId());
        if (auditDTO.getStatus().equals(three)) {
            BizAssert.assertNotNull(OperationExceptionCode.DEAL_USER_NULL, auditDTO.getDealUserDTO());
        }
        if (auditDTO.getStatus().equals(two)) {
            BizAssert.assertNotNull(OperationExceptionCode.AUDIT_OPINION_NULL, auditDTO.getAuditOpinion());
        }
        //转换，保存服务申请信息
        Long userId = BaseContextHandler.getAdminId();
        ServiceManage serviceManage = serviceManageService.getById(auditDTO.getId());
        serviceManage.setAuditOpinion(auditDTO.getAuditOpinion());
        serviceManage.setResult(auditDTO.getResult());
        serviceManage.setStatus(auditDTO.getStatus());
        serviceManage.setUpdateUser(userId);
        serviceManageService.updateByIdSelective(serviceManage);

        List<DealUserDTO> dealUserDTOS = auditDTO.getUserNames();
        List<DealUser> userList = new ArrayList<>();
        DealUserDTO userDTO = auditDTO.getDealUserDTO();
        DealUser user = new DealUser();
        if (userDTO != null) {
            user = dozerUtils.map(userDTO, DealUser.class);
            user.setBussId(serviceManage.getId());
            user.setUpdateUser(userId);
            user.setCreateUser(userId);
            userList.add(user);
        }
        if (dealUserDTOS != null && dealUserDTOS.size() > 0) {
            for (DealUserDTO dto : dealUserDTOS) {
                DealUser dealUser = dozerUtils.map(dto, DealUser.class);
                dealUser.setBussId(serviceManage.getId());
                //dealUser.setType("xzr");//人员类型（处理人clr，协助人xzr，咨询人zxr）'前端已传
                dealUser.setCreateUser(userId);
                dealUser.setUpdateUser(userId);
                userList.add(dealUser);
            }
        }
        if (userList != null && userList.size() > 0) {
            dealUserService.save(userList);
        }
        ServiceDirectory serviceDirectory = serviceDirectoryService.getById(Long.valueOf(serviceManage.getServiceName()));
        if (auditDTO.getStatus().equals(three)) {
            BbsAllMainMsgDTO bbsAllMainMsgDTO = null;
            List<Long> lookUserIds = new ArrayList<>(1);
            lookUserIds.add(user.getPersonId());//发送审核人
            String bizType = "yw_service_audit";
            bbsAllMainMsgDTO = builderBbsAllMainMsgDTO(serviceManage.getId(), bizType, "您有一条" +
                    serviceDirectory.getServiceName() + "申请待处理", true);
            msgQueueProducer.saveMsgToUser(bbsAllMainMsgDTO, lookUserIds, null);

        }
        BbsAllMainMsgDTO bbsAllMainMsgDTO = null;
        List<Long> applyUser = new ArrayList<>(1);
        applyUser.add(Long.valueOf(serviceManage.getApplyUser()));//发送给申请人
        String bizType = "yw_service_deal_apply";
        if (auditDTO.getStatus().equals(two)) {
            bbsAllMainMsgDTO = builderBbsAllMainMsgDTO(serviceManage.getId(), bizType, "您有一条" +
                    serviceDirectory.getServiceName() + "申请已被驳回", true);
            msgQueueProducer.saveMsgToUser(bbsAllMainMsgDTO, applyUser, null);
        } else {
            bbsAllMainMsgDTO = builderBbsAllMainMsgDTO(serviceManage.getId(), bizType, "您有一条" +
                    serviceDirectory.getServiceName() + "申请已审批通过", true);
            msgQueueProducer.saveMsgToUser(bbsAllMainMsgDTO, applyUser, null);
        }
        if (serviceManage.getApplyCode() != null) {
            AlarmInformationExample informationExample = new AlarmInformationExample();
            informationExample.createCriteria().andApplyCodeEqualTo(serviceManage.getApplyCode()).andApplyTypeEqualTo("service_audit");
            List<AlarmInformation> informationList = alarmInformationService.find(informationExample);
            if (informationList != null && informationList.size() > 0) {
                for (AlarmInformation information : informationList) {
                    information.setStatus(2);
                    information.setUpdateUser(userId);
                    alarmInformationService.updateByIdSelective(information);
                }
            }
        }
        //推送到统一监管-结束审批
        pushSuperviseTemp.pushSupervise(serviceManage.getId(), new Date(), new Date(), OpsCode.SERVER_CODE.getCode(),
                OpsCode.SERVER_CODE.getName(), OpsCode.SERVER_CODE.getDescribe());
        //推送到统一监管-处理申请
        if (!auditDTO.getStatus().equals(two)) {
            pushSuperviseTemp.pushSupervise(serviceManage.getId(), new Date(),
                    null, OpsCode.SERVER_DEAL_APPLY_CODE.getCode(),
                    OpsCode.SERVER_DEAL_APPLY_CODE.getName(), OpsCode.SERVER_DEAL_APPLY_CODE.getDescribe());
        }

        return Result.success(dozerUtils.map(serviceManage, ServiceMangeAuditDTO.class));
    }

    private BbsAllMainMsgDTO builderBbsAllMainMsgDTO(Long id, String bizType, String moduleName, boolean pass) {
        BbsAllMainMsgDTO bbsAllMainMsgDTO = new BbsAllMainMsgDTO();
        bbsAllMainMsgDTO.setAppId(BaseContextHandler.getAppId());
        bbsAllMainMsgDTO.setAppName(BaseContextHandler.getAppName());
        bbsAllMainMsgDTO.setBizId(id.toString());
        bbsAllMainMsgDTO.setBizType(bizType);
        bbsAllMainMsgDTO.setClientFlag("gxqpt");
        bbsAllMainMsgDTO.setSingleHandleIs(false);
        bbsAllMainMsgDTO.setBriefTpye("audit_result");
        bbsAllMainMsgDTO.setContent(moduleName);
        bbsAllMainMsgDTO.setTitle(moduleName);
        bbsAllMainMsgDTO.setDetailedType(bizType);
        if (bizType.equals("yw_service_audit")) {
            bbsAllMainMsgDTO.setDetailedTypeDesc("服务处理");
            bbsAllMainMsgDTO.setHandlerUrl("/index.html#/serviceDeal");
        } else if (bizType.equals("yw_service_deal_apply")) {
            bbsAllMainMsgDTO.setDetailedTypeDesc("服务申请");
            bbsAllMainMsgDTO.setHandlerUrl("/index.html#/serviceApply");
        } else if (bizType.equals("yw_service_deal")) {
            bbsAllMainMsgDTO.setDetailedTypeDesc("服务评价");
            bbsAllMainMsgDTO.setHandlerUrl("/index.html#/serviceApply");
        } else if (bizType.equals("yw_service_evaluation")) {
            bbsAllMainMsgDTO.setDetailedTypeDesc("服务评价");
            bbsAllMainMsgDTO.setHandlerUrl("/index.html#/serviceDeal");
        }

        bbsAllMainMsgDTO.setHandlerNeedIs(false);
        bbsAllMainMsgDTO.setSenderName("系统自动通知");
        return bbsAllMainMsgDTO;
    }

    @ApiOperation(value = "根据服务申请id查询服务申请信息", notes = "根据服务申请id查询服务申请信息")
    @RequestMapping(value = "/getById", method = RequestMethod.GET)
    public Result<ServiceMangeDetailDTO> getById(@RequestParam(value = "id") Long id) {
        if (id == null) {
            return Result.fail("服务申请id不能为空");
        }
        ServiceManageExample manageExample = new ServiceManageExample();
        manageExample.createCriteria().andIdEqualTo(id);
        ServiceMangeDetailDTO mangeDto = dozerUtils.map(serviceManageService.getById(id), ServiceMangeDetailDTO.class);
        ServiceSystemExample systemExample = new ServiceSystemExample();
        systemExample.createCriteria().andPIdEqualTo(mangeDto.getId());
        ServiceDirectory serviceType = serviceDirectoryService.getById(Long.valueOf(mangeDto.getServiceType()));
        if (serviceType != null) {
            mangeDto.setServiceTypeMc(serviceType.getType());
        }
        ServiceDirectory serviceClass = serviceDirectoryService.getById(Long.valueOf(mangeDto.getServiceClass()));
        if (serviceClass != null) {
            mangeDto.setServiceClassMc(serviceClass.getType());
        }
        ServiceDirectory serviceObj = serviceDirectoryService.getById(Long.valueOf(mangeDto.getServiceObj()));
        if (serviceObj != null) {
            mangeDto.setServiceObjMc(serviceObj.getType());
        }
        ServiceDirectory serviceName = serviceDirectoryService.getById(Long.valueOf(mangeDto.getServiceName()));
        if (serviceName != null) {
            mangeDto.setServiceNameMc(serviceName.getServiceName());
            mangeDto.setServiceResult(serviceName.getServiceResult());
            mangeDto.setServiceInfo(serviceName.getServiceInfo());
        }
        OperationFileExample fileExample = new OperationFileExample();
        fileExample.createCriteria().andBussIdEqualTo(id);
        List<OperationFileDTO> fileList = dozerUtils.mapList(operationFileService.find(fileExample), OperationFileDTO.class);
        mangeDto.setFileDTOS(fileList);
        List<ServiceSystemDTO> systemDTO = dozerUtils.mapList(serviceSystemService.find(systemExample), ServiceSystemDTO.class);
        mangeDto.setSystemName(systemDTO);
        //获取处理人、协助人信息
        List<DealUser> dealList = dealUserService.getByBussId(id);
        if (dealList != null && dealList.size() > 0) {
            String assistant = "";
            for (DealUser dealUser : dealList) {
                String type = dealUser.getType();
                //处理人只有一个
                if ("clr".equals(type)) {
                    mangeDto.setDealUser(dealUser.getPersonName());
                    Long personId = dealUser.getPersonId();
                    Long[] ids = {Long.valueOf(personId)};
                    Result<List<GxqptEmpRetDTO>> empUser = gxqptEmpApi.findByIdsGxqptYw(ids);
                    List<GxqptEmpRetDTO> emps = empUser.getData();
                    if (emps != null && emps.size() > 0) {
                        GxqptEmpRetDTO empRetDTO = emps.get(0);
                        mangeDto.setMaindutyname(empRetDTO.getMaindutyname());
                    }
                    PersonManage personManage = personService.getById(personId);
                    if (personManage != null) {
                        mangeDto.setContent(personManage.getContent());
                        mangeDto.setMainmobile(personManage.getMainmobile());
                    }

                }
                //协助人
                if ("xzr".equals(type)) {
                    assistant += dealUser.getPersonName() + ",";
                }
            }
            mangeDto.setAssistant(assistant);
        }
        return Result.success(mangeDto);
    }

    @ApiOperation(value = "保存服务-报告信息", notes = "保存服务-报告信息")
    @ApiResponses({
            @ApiResponse(code = 105044, message = "服务过程"),
            @ApiResponse(code = 105045, message = "处理结果"),
    })
    @RequestMapping(value = "/updateServiceReport", method = RequestMethod.POST)
    public Result<ServiceMangeUpdateDTO> updateServiceReport(@RequestBody ServiceMangeUpdateDTO updateDTO) {
        //1.校验
        BizAssert.assertNotNull(OperationExceptionCode.SERVICE_PROCESS_NULL, updateDTO.getServiceProcess());
        BizAssert.assertNotNull(OperationExceptionCode.DEAL_RESULT_NULL, updateDTO.getResult());


        //转换，保存服务-报告信息
        Long userId = BaseContextHandler.getAdminId();
        ServiceManage serviceManage = dozerUtils.map(updateDTO, ServiceManage.class);
        serviceManage.setReportTime(updateDTO.getReportTime());
        serviceManage.setUpdateUser(userId);
        serviceManageService.updateByIdSelective(serviceManage);
        List<OperationFileDTO> fileList = updateDTO.getFileDTOS();
        List<OperationFile> files = new ArrayList<>();
        if (fileList != null && fileList.size() > 0) {
            for (OperationFileDTO dto : fileList) {
                OperationFile file = dozerUtils.map(dto, OperationFile.class);
                file.setBussId(serviceManage.getId());
                file.setUserId(userId);
                files.add(file);
            }
        }
        operationFileService.save(files);
        if (serviceManage.getStatus() == 4) {
            BbsAllMainMsgDTO bbsAllMainMsgDTO = null;
            List<Long> lookUserIds = new ArrayList<>(1);
            ServiceManage manage = serviceManageService.getById(serviceManage.getId());
            lookUserIds.add(Long.valueOf(manage.getApplyUser()));
            String bizType = "yw_service_deal";
            ServiceDirectory serviceDirectory = serviceDirectoryService.getById(Long.valueOf(manage.getServiceName()));
            bbsAllMainMsgDTO = builderBbsAllMainMsgDTO(serviceManage.getId(), bizType, " 您有一条" + serviceDirectory.getServiceName() + "申请已处理，请尽快评价", true);
            msgQueueProducer.saveMsgToUser(bbsAllMainMsgDTO, lookUserIds, null);
            //更新自己受到的审批消息未已经出了
            UpdateBacklogReqDTO updateBacklogReqDTO = createUpdateBacklogReqDTO("yw_service_apply", serviceManage.getId(), userId);
            msgQueueProducer.updateBbsToHandleed(updateBacklogReqDTO);
            if (serviceManage.getApplyCode() != null) {
                AlarmInformationExample informationExample = new AlarmInformationExample();
                informationExample.createCriteria().andApplyCodeEqualTo(serviceManage.getApplyCode()).andApplyTypeEqualTo("service_deal");
                List<AlarmInformation> informationList = alarmInformationService.find(informationExample);
                if (informationList != null && informationList.size() > 0) {
                    for (AlarmInformation information : informationList) {
                        information.setStatus(2);
                        information.setUpdateUser(userId);
                        alarmInformationService.updateByIdSelective(information);
                    }
                }
            }
        }
        //推送到统一监管
        pushSuperviseTemp.pushSupervise(serviceManage.getId(), new Date(), new Date(), OpsCode.SERVER_DEAL_APPLY_CODE.getCode(),
                OpsCode.SERVER_DEAL_APPLY_CODE.getName(), OpsCode.SERVER_DEAL_APPLY_CODE.getDescribe());
        return Result.success(dozerUtils.map(serviceManage, ServiceMangeUpdateDTO.class));
    }

    /***
     * 创建更新消息实体
     * @param bizId
     * @return
     */
    public static UpdateBacklogReqDTO createUpdateBacklogReqDTO(String type, Long bizId, Long receiveId) {
        String appId = BaseContextHandler.getAppId();
        //String appName = BaseContextHandler.getAppName();
        UpdateBacklogReqDTO update = new UpdateBacklogReqDTO();
        update.setAppId(appId);
        update.setBizId(String.valueOf(bizId));
        update.setClientFlag("gxqpt");
        update.setBizType(type);
        update.setReceiveId(receiveId);
        return update;
    }

    @ApiOperation(value = "保存服务-评价信息", notes = "保存服务-评价信息")
    @ApiResponses({
            @ApiResponse(code = 105046, message = "服务态度"),
            @ApiResponse(code = 105047, message = "服务效率"),
            @ApiResponse(code = 105048, message = "服务质量"),
    })
    @RequestMapping(value = "/updateServiceEvaluation", method = RequestMethod.POST)
    public Result<ServiceMangeUpdateDTO> updateServiceEvaluation(@RequestBody ServiceEvaluateUpdateReqDTO updateDTO) {
        //1.校验
        BizAssert.assertNotNull(OperationExceptionCode.SERVICE_ATTITUDE_NULL, updateDTO.getServiceAttitude());
        BizAssert.assertNotNull(OperationExceptionCode.SERVICE_EFFICIENCY_NULL, updateDTO.getServiceEfficiency());
        BizAssert.assertNotNull(OperationExceptionCode.SERVICE_EVALUATION_NULL, updateDTO.getServiceEvaluation());

        //转换，保存服务-评价信息
        Long userId = BaseContextHandler.getAdminId();
        ServiceManage serviceManage = dozerUtils.map(updateDTO, ServiceManage.class);
        Long score = (updateDTO.getServiceAttitude() +
                updateDTO.getServiceEfficiency() +
                updateDTO.getServiceEvaluation()) / 3;
        serviceManage.setScore(score);
        serviceManage.setScoreTime(new Date());
        serviceManage.setUpdateUser(userId);
        serviceManageService.updateByIdSelective(serviceManage);
        BbsAllMainMsgDTO bbsAllMainMsgDTO = null;
        List<Long> lookUserIds = new ArrayList<>(1);
        DealUserExample dealUserExample = new DealUserExample();
        dealUserExample.createCriteria().andBussIdEqualTo(serviceManage.getId()).andTypeEqualTo("clr");
        DealUserDTO dealUserDTO = dozerUtils.map(dealUserService.getUnique(dealUserExample), DealUserDTO.class);
        lookUserIds.add(dealUserDTO.getPersonId());
        String bizType = "yw_service_evaluation";
        ServiceManage service = serviceManageService.getById(Long.valueOf(serviceManage.getId()));
        ServiceDirectory serviceDirectory = serviceDirectoryService.getById(Long.valueOf(service.getServiceName()));
        bbsAllMainMsgDTO = builderBbsAllMainMsgDTO(service.getId(), bizType, "您处理的" + serviceDirectory.getServiceName() + "已评价", true);
        msgQueueProducer.saveMsgToUser(bbsAllMainMsgDTO, lookUserIds, null);
        //更新自己受到的审批消息未已经出了
        UpdateBacklogReqDTO updateBacklogReqDTO = createUpdateBacklogReqDTO("yw_service_deal", service.getId(), userId);
        msgQueueProducer.updateBbsToHandleed(updateBacklogReqDTO);

        return Result.success(dozerUtils.map(serviceManage, ServiceMangeUpdateDTO.class));
    }

    @ApiOperation(value = "查询运维单位树", notes = "查询运维单位树")
    @RequestMapping(value = "/findOrgTreeByUsersInOperation", method = RequestMethod.GET)
    public Result<List<GxqptOrgResDTO>> findOrgTreeByUsersInOperation(@RequestParam(value = "id") Long id) {

        ServiceSystemExample serviceSystemExample = new ServiceSystemExample();
        serviceSystemExample.createCriteria().andPIdEqualTo(id);
        List<ServiceSystem> arrList = serviceSystemService.find(serviceSystemExample);
        String systemId = null;
        if (!arrList.isEmpty()) {
            systemId = arrList.get(0).getSystemId();
        }
        ChargeSystemExample chargeSystemExample = new ChargeSystemExample();
        chargeSystemExample.createCriteria().andSystemIdEqualTo(systemId);
        List<ChargeSystem> chargeSystemList = chargeSystemService.find(chargeSystemExample);
        List<Long> ids = new ArrayList<>();
        if (!chargeSystemList.isEmpty()) {
            for (ChargeSystem system : chargeSystemList) {
                ids.add(system.getpId());
            }
        }
        Result<List<GxqptOrgResDTO>> list = gxqptOrgApi.findOrgTreeByUsersInOperation(ids);
        if (list.getData() != null && !list.getData().isEmpty()) {
            return Result.success(list.getData());
        } else {
            List<GxqptOrgResDTO> list1 = new ArrayList<>();
            return Result.success(list1);
        }

    }

    @ApiOperation(value = "查询负责此系统的人员list", notes = "查询负责此系统的人员list")
    @RequestMapping(value = "/findOperationPerson", method = RequestMethod.GET)
    public Result<List<Long>> findOperationPerson(@RequestParam(value = "id") Long id) {

        ServiceSystemExample serviceSystemExample = new ServiceSystemExample();
        serviceSystemExample.createCriteria().andPIdEqualTo(id);
        List<ServiceSystem> arrList = serviceSystemService.find(serviceSystemExample);
        String systemId = null;
        if (!arrList.isEmpty()) {
            systemId = arrList.get(0).getSystemId();
        }
        ChargeSystemExample chargeSystemExample = new ChargeSystemExample();
        chargeSystemExample.createCriteria().andSystemIdEqualTo(systemId);
        List<ChargeSystem> chargeSystemList = chargeSystemService.find(chargeSystemExample);
        List<Long> ids = new ArrayList<>();
        if (!chargeSystemList.isEmpty()) {
            for (ChargeSystem system : chargeSystemList) {
                ids.add(system.getpId());
            }
        }
        return Result.success(ids);
    }
}
