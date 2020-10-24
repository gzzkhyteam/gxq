package com.hengyunsoft.platform.hardware.impl.apply;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hengyunsoft.base.Result;
import com.hengyunsoft.base.id.IdGenerate;
import com.hengyunsoft.commons.context.BaseContextHandler;
import com.hengyunsoft.commons.exception.core.HardWareExceptionCode;
import com.hengyunsoft.commons.utils.context.DozerUtils;
import com.hengyunsoft.page.plugins.openapi.OpenApiReq;
import com.hengyunsoft.platform.admin.api.authority.dto.role.RoleDto;
import com.hengyunsoft.platform.admin.api.core.dto.org.GxqptOrgRolePageDTO;
import com.hengyunsoft.platform.admin.open.authority.api.RoleOpenApi;
import com.hengyunsoft.platform.hardware.constant.CommonConstant;
import com.hengyunsoft.platform.hardware.constant.ProcessData;
import com.hengyunsoft.platform.hardware.constant.Role2ScodeEnum;
import com.hengyunsoft.platform.hardware.constant.StepConstant;
import com.hengyunsoft.platform.hardware.dto.apply.*;
import com.hengyunsoft.platform.hardware.entity.apply.domain.ApplyManageDO;
import com.hengyunsoft.platform.hardware.entity.apply.domain.ApplyServerDO;
import com.hengyunsoft.platform.hardware.entity.apply.po.*;
import com.hengyunsoft.platform.hardware.entity.manage.po.DiskManage;
import com.hengyunsoft.platform.hardware.entity.manage.po.MachineManage;
import com.hengyunsoft.platform.hardware.entity.manage.po.ServerManage;
import com.hengyunsoft.platform.hardware.repository.apply.example.*;
import com.hengyunsoft.platform.hardware.repository.apply.service.*;
import com.hengyunsoft.platform.hardware.repository.manage.example.MachineManageExample;
import com.hengyunsoft.platform.hardware.repository.manage.service.DiskManageService;
import com.hengyunsoft.platform.hardware.repository.manage.service.MachineManageService;
import com.hengyunsoft.platform.hardware.repository.manage.service.ServerManageService;
import com.hengyunsoft.platform.msgs.dto.bbs.BbsAllMainMsgDTO;
import com.hengyunsoft.platform.msgs.dto.bbs.UpdateBacklogReqDTO;
import com.hengyunsoft.platform.msgs.queue.BbbMsgQueueProducer;
import com.hengyunsoft.platform.supervise.dto.center.PowerSuperviseTempSaveDTO;
import com.hengyunsoft.platform.supervise.dto.supervise.PowerSuperviseTempApi;
import com.hengyunsoft.utils.BizAssert;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

@Api(value = "API - ApplyManageImpl", description = "申请管理")
@RestController
@RequestMapping("applymanage")
@Slf4j
public class ApplyManageImpl {

    @Autowired
    private ApplyManageService applyManageService;

    @Autowired
    private ApplyServerService applyServerService;

    @Autowired
    private ApplyDiskService applyDiskService;

    @Autowired
    private AttachmentService attachmentService;

    @Autowired
    private ApplyResourceService resourceService;

    @Autowired
    private MachineManageService machineManageService;

    @Autowired
    private ApplyRecordService applyRecordService;

    @Autowired
    private ServerManageService serverManageService;

    @Autowired
    private DiskManageService diskManageService;

    @Autowired
    private DozerUtils dozerUtils;

    @Autowired
    private ProcessData processData;

    @Autowired
    private IdGenerate<Long> idGenerator;

    @Autowired
    private BbbMsgQueueProducer bbMsgQueueProducer;

    @Autowired
    private RoleOpenApi roleOpenApi;

    @Autowired
    private PowerSuperviseTempApi powerSuperviseTempApi;

    /**
     * 部门角色编码
     */
    private static final String deptRoleCode = "HARDWARE_DEPT_ROLE";

    /**
     * 管理员角色编码
     */
    private static final String manageRoleCode = "HARDWARE_MANAGE";


    /**
     * 国信优易角色编码
     */
    private static final String uyiRoleCode = "HARDWARE_GXUY";


    /**
     * 高新翼云角色编码
     */
    private static final String yyRoleCode = "HARDWARE_GXYY";

    private static final String BriefTpye = "work_audit";
    private static final String ClientFlag = "gxqpt_hardware_msg";
    private static final String DetailedType = "gxqpt_hardware_server_apply";
    private static final String DetailedTypeDesc = "软硬件平台服务器申请";
    private static final String SenderName = "系统自动通知";

    /**
     * 新建申请管理
     *
     * @param applyManageDTO
     * @return
     */
    @ApiOperation(value = "新建申请管理", notes = "新建申请管理")
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    @ApiResponses({
            @ApiResponse(code = 100000, message = "单位ID不允许为空"),
            @ApiResponse(code = 100001, message = "单位名称不允许为空"),
            @ApiResponse(code = 100004, message = "申请人邮箱不能为空"),
            @ApiResponse(code = 100005, message = "申请原因不能为空"),
            @ApiResponse(code = 100007, message = "申请服务器数据不能为空"),
    })
    public Result<ApplyManageDTO> saveApplyManage(@RequestBody ApplyManageDTO applyManageDTO) {
        //1.校验
        BizAssert.assertNotNull(HardWareExceptionCode.ORGID_NULL, applyManageDTO.getApplyOrgid());
        BizAssert.assertNotNull(HardWareExceptionCode.ORGNAME_NULL, applyManageDTO.getApplyOrgname());
        BizAssert.assertNotNull(HardWareExceptionCode.APPLY_USEREMAIL_NULL, applyManageDTO.getApplyEmail());
        BizAssert.assertNotNull(HardWareExceptionCode.APPLY_REASON_NULL, applyManageDTO.getApplyReason());
        BizAssert.assertNotNull(HardWareExceptionCode.APPLY_SERVER_NULL, applyManageDTO.getApplyServer());

        //2.数据处理
        ApplyManage applyManage = dozerUtils.map(applyManageDTO, ApplyManage.class);
        applyManage.setApplyUid(BaseContextHandler.getAdminId() + "");
        applyManage.setApplyUname(BaseContextHandler.getName());
        applyManage.setCreateUser(BaseContextHandler.getAdminId() + "");
        applyManage.setUpdateUser(BaseContextHandler.getAdminId() + "");
        applyManage.setResflag(CommonConstant.FALSE);
        applyManage.setEndflag(CommonConstant.ONE);
        applyManage.setApplyTime(new Date());
        //提交处理
        if (CommonConstant.ADD.equals(applyManageDTO.getApplyType())) {
            applyManage.setApplyNo(getApplyNo("XZ"));
        }
        if (CommonConstant.UPDATE.equals(applyManageDTO.getApplyType())) {
            applyManage.setApplyNo(getApplyNo("BG"));
        }
        delManage(applyManage, applyManageDTO.getType());
        ApplyManage rapplymanage = applyManageService.save(applyManage);
        //服务器
        List<ApplyServer> applyServer = dozerUtils.mapList(applyManageDTO.getApplyServer(), ApplyServer.class);
        if (null != applyServer) {
            for (ApplyServer server : applyServer) {
                if (server.getApplyCount() == null || server.getApplyCount() == 0) {
                    server.setApplyCount(1);
                }
                server.setApplyKeyid(rapplymanage.getId());
                server.setCreateUser(BaseContextHandler.getAdminId() + "");
                server.setUpdateUser(BaseContextHandler.getAdminId() + "");
                ApplyServer rserver = applyServerService.save(server);
                //磁盘
                List<ApplyDisk> disks = dozerUtils.mapList(server.getDisks(), ApplyDisk.class);
                if (null != disks) {
                    for (ApplyDisk disk : disks) {
                        disk.setApplyServerid(rserver.getId());
                        disk.setCreateUser(BaseContextHandler.getAdminId() + "");
                        disk.setUpdateUser(BaseContextHandler.getAdminId() + "");
                    }
                    applyDiskService.save(disks);
                }
            }
        }

        //附件
        List<Attachment> attachment = dozerUtils.mapList(applyManageDTO.getAttachment(), Attachment.class);
        dealAttach(attachment, applyManage.getId(), BaseContextHandler.getAdminId() + "");

        //消息推送-统一监管推送
        if (CommonConstant.SUBMIT.equals(applyManageDTO.getType())) {
            applySendMsg(applyManage, "/index.html#/adminApply", manageRoleCode, StepConstant.MANAGE_AUTH_DRAFT.getStepCode(), "1", null);
            pushSupervise(applyManage.getId(), new Date(), null, StepConstant.MANAGE_AUTH_DRAFT.getStepCode(), "审批", "软硬件管理资源申请");
        }
        return Result.success(applyManageDTO);
    }

    /**
     * 修改申请管理
     *
     * @param applyUpdateManageDTO
     * @return
     */
    @ApiOperation(value = "修改申请管理", notes = "修改申请管理")
    @RequestMapping(value = "/updateApplyManage", method = RequestMethod.POST)
    @ApiResponses({
            @ApiResponse(code = 100009, message = "记录id不能为空"),
            @ApiResponse(code = 100000, message = "单位ID不允许为空"),
            @ApiResponse(code = 100001, message = "单位名称不允许为空"),
            @ApiResponse(code = 100004, message = "申请人邮箱不能为空"),
            @ApiResponse(code = 100005, message = "申请原因不能为空"),
            @ApiResponse(code = 100007, message = "申请服务器数据不能为空"),
    })
    public Result<ApplyUpdateManageDTO> updateApplyManage(@RequestBody ApplyUpdateManageDTO applyUpdateManageDTO) {
        //1.校验
        BizAssert.assertNotNull(HardWareExceptionCode.APPLY_MANAGE_ID_NULL, applyUpdateManageDTO.getId());
        BizAssert.assertNotNull(HardWareExceptionCode.ORGID_NULL, applyUpdateManageDTO.getApplyOrgid());
        BizAssert.assertNotNull(HardWareExceptionCode.ORGNAME_NULL, applyUpdateManageDTO.getApplyOrgname());
        BizAssert.assertNotNull(HardWareExceptionCode.APPLY_USEREMAIL_NULL, applyUpdateManageDTO.getApplyEmail());
        BizAssert.assertNotNull(HardWareExceptionCode.APPLY_REASON_NULL, applyUpdateManageDTO.getApplyReason());
        BizAssert.assertNotNull(HardWareExceptionCode.APPLY_SERVER_NULL, applyUpdateManageDTO.getApplyServer());
        //2.删除历史数据
        ApplyServerExample applyServerExample = new ApplyServerExample();
        applyServerExample.createCriteria().andApplyKeyidEqualTo(applyUpdateManageDTO.getId());
        List<ApplyServer> list = applyServerService.find(applyServerExample);
        list.stream().forEach(server -> applyDiskService.deleteByServerKeyId(server.getId()));
        applyServerService.deleteByApplyKeyId(applyUpdateManageDTO.getId());
        attachmentService.deleteByBusId(applyUpdateManageDTO.getId());
        resourceService.deleteByApplyKeyId(applyUpdateManageDTO.getId());

        //3.修改数据
        ApplyManage applyManage = dozerUtils.map(applyUpdateManageDTO, ApplyManage.class);
        applyManage.setUpdateUser(BaseContextHandler.getAdminId() + "");
        applyManage.setResflag(CommonConstant.FALSE);
        applyManage.setEndflag(CommonConstant.ONE);
        applyManage.setApplyTime(new Date());
        delManage(applyManage, applyUpdateManageDTO.getType());
        applyManageService.updateByIdSelective(applyManage);
        //4.新建保存服务器
        List<ApplyServer> applyServer = dozerUtils.mapList(applyUpdateManageDTO.getApplyServer(), ApplyServer.class);
        if (null != applyServer) {
            for (ApplyServer server : applyServer) {
                server.setApplyKeyid(applyUpdateManageDTO.getId());
                server.setCreateUser(BaseContextHandler.getAdminId() + "");
                server.setUpdateUser(BaseContextHandler.getAdminId() + "");
                ApplyServer rserver = applyServerService.save(server);
                //磁盘
                List<ApplyDisk> disks = dozerUtils.mapList(server.getDisks(), ApplyDisk.class);
                if (null != disks) {
                    for (ApplyDisk disk : disks) {
                        disk.setApplyServerid(rserver.getId());
                        disk.setCreateUser(BaseContextHandler.getAdminId() + "");
                        disk.setUpdateUser(BaseContextHandler.getAdminId() + "");
                    }
                    applyDiskService.save(disks);
                }
            }
        }
        //保存附件
        List<Attachment> attachment = dozerUtils.mapList(applyUpdateManageDTO.getAttachment(), Attachment.class);
        dealAttach(attachment, applyManage.getId(), BaseContextHandler.getAdminId() + "");
        //消息推送-统一监管推送
        if (CommonConstant.SUBMIT.equals(applyUpdateManageDTO.getType())) {
            applySendMsg(applyManage, "/index.html#/adminApply", manageRoleCode, StepConstant.MANAGE_AUTH_DRAFT.getStepCode(), "1", null);
            pushSupervise(applyManage.getId(), new Date(), null, StepConstant.MANAGE_AUTH_DRAFT.getStepCode(), "审批", "软硬件管理资源申请");
        }
        return Result.success(applyUpdateManageDTO);
    }

    /**
     * 消息发送,type=1需要处理，2查看
     */
    private void applySendMsg(ApplyManage applyManage, String url, String roleCode, String bizType, String type, String msg) {
        //消息发送
        try {
            BbsAllMainMsgDTO bbsAllMainMsgDTO = new BbsAllMainMsgDTO();
            bbsAllMainMsgDTO.setAppId(BaseContextHandler.getAppId());
            bbsAllMainMsgDTO.setAppName(BaseContextHandler.getAppName());
            bbsAllMainMsgDTO.setBizId(applyManage.getId() + "");
            bbsAllMainMsgDTO.setBizType(bizType);
            bbsAllMainMsgDTO.setBriefTpye(BriefTpye);
            bbsAllMainMsgDTO.setClientFlag(ClientFlag);
            bbsAllMainMsgDTO.setSingleHandleIs(false);
            bbsAllMainMsgDTO.setTitle("软硬件管理申请审批");
            if (msg != null && !"".equals(msg)) {
                bbsAllMainMsgDTO.setTitle("您的服务器资源申请已审批通过");
                bbsAllMainMsgDTO.setContent(msg);
            } else {
                bbsAllMainMsgDTO.setContent("您有一条来自于" + applyManage.getApplyOrgname() + "单位的服务器资源申请待审批。");
            }
            bbsAllMainMsgDTO.setDetailedType(DetailedType);
            bbsAllMainMsgDTO.setDetailedTypeDesc(DetailedTypeDesc);
            bbsAllMainMsgDTO.setHandlerNeedIs(true);
            bbsAllMainMsgDTO.setHandlerUrl(url);
            //bbsAllMainMsgDTO.setHandlerParams();
            bbsAllMainMsgDTO.setSenderName(SenderName);
            if ("1".equals(type)) {
                bbMsgQueueProducer.saveHandlerMsgToRole(bbsAllMainMsgDTO, roleCode, BaseContextHandler.getAppId());
            } else {
                bbMsgQueueProducer.saveLookMsgToRole(bbsAllMainMsgDTO, roleCode, BaseContextHandler.getAppId());
            }
        } catch (Exception e) {
            log.error("消息推送失败" + e);
        }
    }

    /**
     * 2019-04-24 统一监管推送
     *
     * @param bizId
     * @param startTime
     * @param endTime
     * @param code
     * @param desc
     * @param stepName
     */
    private void pushSupervise(Long bizId, Date startTime, Date endTime, String code, String desc, String stepName) {
        /*
         * MANAGE_AUTH_DRAFT("MANAGE_AUTH_DRAFT","管理员","GL","流程中"),
         * YOUYI_HANDLER("YOUYI_HANDLER","国信优易","UY","流程中"),
         * MANAGE_AUTH_EXT("MANAGE_AUTH_EXT","管理员","GL","流程中"),
         * YIYUN_HANDLER("YIYUN_HANDLER","高新翼云","YY","流程中"),
         * YIYUN_ADD_HOST("YIYUN_ADD_HOST","高新翼云","YY","流程中"),
         * YOUYI_FINAL("YOUYI_FINAL","国信优易","UY","流程中"),
         * */
        Result<PowerSuperviseTempSaveDTO> save = null;
        try {
            PowerSuperviseTempSaveDTO sts = new PowerSuperviseTempSaveDTO();
            sts.setBizId(bizId);
            sts.setStartTime(startTime);
            if (endTime != null) {
                sts.setEndTime(endTime);
            }
            sts.setCode(code);
            sts.setDesc(desc);
            sts.setName(stepName);
            sts.setAppId(BaseContextHandler.getAppId());
            sts.setAppName(BaseContextHandler.getAppName());
            save = powerSuperviseTempApi.save(sts);
        } catch (Exception e) {
            log.error("推送到统一监管，{},{}", save.getErrcode(), save.getErrmsg());
        }
    }

    /**
     * 保存附件
     *
     * @param attachment
     * @param busId
     * @param userId
     */
    private void dealAttach(List<Attachment> attachment, Long busId, String userId) {
        if (null != attachment) {
            attachment.stream().forEach(att -> {
                att.setBusId(busId);
                att.setCreateUser(userId);
                att.setUpdateUser(userId);
            });
            attachmentService.save(attachment);
        }
    }

    /**
     * 删除草稿箱数据
     *
     * @param id
     * @return
     */
    @ApiOperation(value = "删除草稿箱数据", notes = "删除草稿箱数据")
    @RequestMapping(value = "/deleteDraft", method = RequestMethod.GET)
    @ApiResponses({
            @ApiResponse(code = 100009, message = "记录id不能为空"),
    })
    public Result<String> deleteDraft(@RequestParam(value = "id") Long id) {
        //1.校验
        BizAssert.assertNotNull(HardWareExceptionCode.APPLY_MANAGE_ID_NULL, id);
        ApplyManage applyManage = applyManageService.getById(id);
        BizAssert.assertNotNull(HardWareExceptionCode.APPLY_APPR_MANAGE_NULL, applyManage);
        if (!applyManage.getStepCode().equals(StepConstant.DRAFT.getStepCode()) && !applyManage.getStepCode().equals(StepConstant.ROBACK.getStepCode())) {
            BizAssert.assertNotNull(HardWareExceptionCode.APPLY_STEPCODE_MATCH_NULL, null);
        }
        ApplyServerExample applyServerExample = new ApplyServerExample();
        applyServerExample.createCriteria().andApplyKeyidEqualTo(id);
        List<ApplyServer> list = applyServerService.find(applyServerExample);
        //删除磁盘
        list.stream().forEach(server -> applyDiskService.deleteByServerKeyId(server.getId()));
        //删除服务器
        applyServerService.deleteByApplyKeyId(id);
        //删除附件
        attachmentService.deleteByBusId(id);
        //删除审批提交数据
        int result = applyManageService.deleteById(id);
        if (result > 0) {
            return Result.success("SUCCESS");
        }
        return Result.fail("FAIL");
    }


    /**
     * 新增申请服务器数据
     *
     * @param applyServerAddDTO
     * @return
     */
    @Deprecated
    @ApiOperation(value = "新增申请服务器数据", notes = "新增申请服务器数据")
    @RequestMapping(value = "/addApplyServer", method = RequestMethod.POST)
    @ApiResponses({
            @ApiResponse(code = 100007, message = "申请服务器数据不能为空"),
            @ApiResponse(code = 100015, message = "申请主键不能为空"),
    })
    public Result<ApplyServerAddDTO> addApplyServer(@RequestBody ApplyServerAddDTO applyServerAddDTO) {
        //1.校验
        BizAssert.assertNotNull(HardWareExceptionCode.APPLY_SERVER_NULL, applyServerAddDTO);
        BizAssert.assertNotNull(HardWareExceptionCode.APPLY_SERVER_APPLYKEYID_NULL, applyServerAddDTO.getApplyKeyid());
        //申请服务器
        ApplyServer applyServer = dozerUtils.map(applyServerAddDTO, ApplyServer.class);
        applyServer.setApplyKeyid(applyServerAddDTO.getApplyKeyid());
        applyServer.setCreateUser(BaseContextHandler.getAdminId() + "");
        applyServer.setUpdateUser(BaseContextHandler.getAdminId() + "");
        ApplyServer rserver = applyServerService.save(applyServer);
        //磁盘
        List<ApplyDisk> disks = dozerUtils.mapList(applyServer.getDisks(), ApplyDisk.class);
        if (null != disks) {
            for (ApplyDisk disk : disks) {
                disk.setApplyServerid(rserver.getId());
                disk.setCreateUser(applyServer.getCreateUser());
                disk.setUpdateUser(applyServer.getCreateUser());
            }
            applyDiskService.save(disks);
        }
        return Result.success(applyServerAddDTO);
    }

    /**
     * 删除申请服务器数据
     *
     * @param id
     * @return
     */
    @Deprecated
    @ApiOperation(value = "删除申请服务器数据", notes = "删除申请服务器数据")
    @RequestMapping(value = "/deleteApplyServer", method = RequestMethod.POST)
    @ApiResponses({
            @ApiResponse(code = 100014, message = "服务器id不能为空"),
    })
    public Result<String> deleteApplyServer(@RequestParam(value = "id") Long id) {
        //1.校验
        BizAssert.assertNotNull(HardWareExceptionCode.APPLY_SERVER_ID_NULL, id);
        //删除磁盘
        applyDiskService.deleteByServerKeyId(id);
        //删除服务器
        int result = applyServerService.deleteById(id);
        if (result > 0) {
            return Result.success("SUCCESS");
        }
        return Result.fail("FAIL");
    }

    /**
     * 修改申请服务器数据
     *
     * @param applyServerDTO
     * @return
     */
    @Deprecated
    @ApiOperation(value = "修改申请服务器数据", notes = "修改申请服务器数据")
    @RequestMapping(value = "/updateApplyServer", method = RequestMethod.POST)
    @ApiResponses({
            @ApiResponse(code = 100007, message = "申请服务器数据不能为空"),
            @ApiResponse(code = 100014, message = "服务器id不能为空"),
            @ApiResponse(code = 100015, message = "申请主键不能为空"),
    })
    public Result<ApplyServerUpdateDTO> updateApplyServer(@RequestBody ApplyServerUpdateDTO applyServerDTO) {
        //1.校验
        BizAssert.assertNotNull(HardWareExceptionCode.APPLY_SERVER_NULL, applyServerDTO);
        BizAssert.assertNotNull(HardWareExceptionCode.APPLY_SERVER_ID_NULL, applyServerDTO.getId());
        BizAssert.assertNotNull(HardWareExceptionCode.APPLY_SERVER_APPLYKEYID_NULL, applyServerDTO.getApplyKeyid());

        ApplyServer applyServer = dozerUtils.map(applyServerDTO, ApplyServer.class);
        applyServer.setUpdateUser(BaseContextHandler.getAdminId() + "");
        //删除磁盘
        applyDiskService.deleteByServerKeyId(applyServer.getId());
        //保存服务器
        applyServerService.updateByIdSelective(applyServer);
        //保存磁盘
        List<ApplyDisk> disks = dozerUtils.mapList(applyServer.getDisks(), ApplyDisk.class);
        if (null != disks) {
            for (ApplyDisk disk : disks) {
                disk.setApplyServerid(applyServer.getId());
                disk.setCreateUser(applyServer.getUpdateUser());
                disk.setUpdateUser(applyServer.getUpdateUser());
            }
            applyDiskService.save(disks);
        }
        return Result.success(applyServerDTO);
    }


    /**
     * 修改草稿箱数据
     *
     * @param applyManageUpdateDTO
     * @return
     */
    @Deprecated
    @ApiOperation(value = "修改草稿箱数据", notes = "修改草稿箱数据")
    @RequestMapping(value = "/updateDraft", method = RequestMethod.POST)
    @ApiResponses({
            @ApiResponse(code = 100009, message = "记录id不能为空"),
            @ApiResponse(code = 100000, message = "单位ID不允许为空"),
            @ApiResponse(code = 100001, message = "单位名称不允许为空"),
            @ApiResponse(code = 100004, message = "申请人邮箱不能为空"),
            @ApiResponse(code = 100005, message = "申请原因不能为空"),
    })
    public Result<ApplyManageUpdateDTO> updateDraft(@RequestBody ApplyManageUpdateDTO applyManageUpdateDTO) {
        //1.校验
        BizAssert.assertNotNull(HardWareExceptionCode.APPLY_MANAGE_ID_NULL, applyManageUpdateDTO.getId());
        BizAssert.assertNotNull(HardWareExceptionCode.ORGID_NULL, applyManageUpdateDTO.getApplyOrgid());
        BizAssert.assertNotNull(HardWareExceptionCode.ORGNAME_NULL, applyManageUpdateDTO.getApplyOrgname());
        BizAssert.assertNotNull(HardWareExceptionCode.APPLY_USEREMAIL_NULL, applyManageUpdateDTO.getApplyEmail());
        BizAssert.assertNotNull(HardWareExceptionCode.APPLY_REASON_NULL, applyManageUpdateDTO.getApplyReason());

        //2.数据处理
        ApplyManage applyManage = dozerUtils.map(applyManageUpdateDTO, ApplyManage.class);
        applyManage.setApplyUid(BaseContextHandler.getAdminId() + "");
        applyManage.setApplyUname(BaseContextHandler.getName());
        //处理附件
        List<Long> delAtts = applyManageUpdateDTO.getDelattachment();
        attachmentService.deleteByIds(delAtts);
        List<Attachment> atts = dozerUtils.mapList(applyManageUpdateDTO.getAttachment(), Attachment.class);

        dealAttach(atts, applyManage.getId(), applyManage.getApplyUid());
        //处理申请单
        delManage(applyManage, applyManageUpdateDTO.getType());
        applyManageService.updateByIdSelective(applyManage);
        //消息推送-统一监管推送
        if (CommonConstant.SUBMIT.equals(applyManageUpdateDTO.getType())) {
            applySendMsg(applyManage, "/index.html#/adminApply", manageRoleCode, StepConstant.MANAGE_AUTH_DRAFT.getStepCode(), "1", null);
            pushSupervise(applyManage.getId(), new Date(), null, StepConstant.MANAGE_AUTH_DRAFT.getStepCode(), "审批", "软硬件管理资源申请");
        }
        return Result.success(applyManageUpdateDTO);
    }

    /**
     * 处理提交
     *
     * @param applyManage
     * @param type
     */
    private void delManage(ApplyManage applyManage, String type) {
        if (CommonConstant.SUBMIT.equals(type)) {
            applyManage.setStepCode(StepConstant.MANAGE_AUTH_DRAFT.getStepCode());
            applyManage.setStepName(StepConstant.MANAGE_AUTH_DRAFT.getStepName());
            applyManage.setScode(StepConstant.MANAGE_AUTH_DRAFT.getsCode());
            applyManage.setSname(StepConstant.MANAGE_AUTH_DRAFT.getsName());
        } else {
            applyManage.setStepCode(StepConstant.DRAFT.getStepCode());
            applyManage.setStepName(StepConstant.DRAFT.getStepName());
            applyManage.setScode(StepConstant.DRAFT.getsCode());
            applyManage.setSname(StepConstant.DRAFT.getsName());
        }
    }

    /**
     * 申请列表数据查询
     *
     * @param openApiReq
     * @return
     */
    @ApiOperation(value = "申请列表数据查询", notes = "申请列表数据查询")
    @RequestMapping(value = "/getMyApplyList", method = RequestMethod.POST)
    @ApiResponses({
    })
    public Result<PageInfo<ApplyQueryRetListDTO>> getMyApplyList(@RequestBody OpenApiReq<ApplyQueryDTO> openApiReq) {
        ApplyQueryDTO applyQueryDTO = openApiReq.getData();
        PageHelper.startPage(openApiReq.getPageNo(), openApiReq.getPageSize());
        Long userId = BaseContextHandler.getAdminId();
        ApplyManageExample example = new ApplyManageExample();
        ApplyManageExample.Criteria c = example.createCriteria()
                .andApplyNoLike(ApplyManageExample.fullLike(applyQueryDTO.getApplyNo()))
                .andApplyUidEqualTo(String.valueOf(userId));
        if (applyQueryDTO.getApplyStartTime() != null) {
            c.andApplyTimeGreaterThanOrEqualTo(applyQueryDTO.getApplyStartTime());
        }
        if (applyQueryDTO.getApplyEneTime() != null) {
            if (applyQueryDTO.getApplyEneTime().getTime() == applyQueryDTO.getApplyStartTime().getTime()) {
                Calendar calendar = Calendar.getInstance();
                calendar.setTime(applyQueryDTO.getApplyEneTime());
                calendar.add(Calendar.DAY_OF_MONTH, 1); //利用Calendar 实现 Date日期+1天  
                applyQueryDTO.setApplyEneTime(calendar.getTime());
            }
            c.andApplyTimeLessThanOrEqualTo(applyQueryDTO.getApplyEneTime());
        }
        example.setOrderByClause(" create_time desc ");
        List<ApplyManage> list = applyManageService.find(example);
        List<ApplyQueryRetListDTO> relist = dozerUtils.mapList(list, ApplyQueryRetListDTO.class);
        return Result.success(new PageInfo<>(relist));
    }

    /**
     * 审批列表数据查询
     *
     * @param openApiReq
     * @return
     */
    @ApiOperation(value = "审批列表数据查询", notes = "审批列表数据查询")
    @RequestMapping(value = "/getApprApplyList", method = RequestMethod.POST)
    @ApiResponses({
            // @ApiResponse(code = 100008, message = "环节编码不能为空"),
    })
    public Result<PageInfo<ApplyQueryRetListDTO>> getApprApplyList(@RequestBody OpenApiReq<ApplyApprQueryDTO> openApiReq) {
        //1.校验
        //2.查询角色编码
        GxqptOrgRolePageDTO dto = new GxqptOrgRolePageDTO();
        dto.setAppId(BaseContextHandler.getAppId());
        dto.setUserId(BaseContextHandler.getAdminId());
        List<RoleDto> roleList = roleOpenApi.findroleList(dto);
        Set<String> set = new HashSet<>();
        if (roleList != null) {
            roleList.forEach(roleD -> {
                String sCode = Role2ScodeEnum.getScodeByRoleCode(roleD.getCode());
                set.add(sCode);
                //应用管理员只能看管理员的数据
                if ("app_admin".equals(roleD.getCode())) {
                    set.add("GL");
                }
            });
        }
        //3.查询数据
        ApplyManageDO applyManageDO = dozerUtils.map(openApiReq.getData(), ApplyManageDO.class);
        applyManageDO.setScodes(set);
        PageHelper.startPage(openApiReq.getPageNo(), openApiReq.getPageSize());
        List<ApplyManageDO> list = applyManageService.getApprApplyList(applyManageDO);
        List<ApplyQueryRetListDTO> relist = dozerUtils.mapList(list, ApplyQueryRetListDTO.class);
        return Result.success(new PageInfo<>(relist));
    }

    /**
     * 根据id查询审批详情
     *
     * @param id
     * @return
     */
    @ApiOperation(value = "根据id查询审批详情", notes = "根据id查询审批详情")
    @RequestMapping(value = "/getApplyManageById", method = RequestMethod.GET)
    @ApiResponses({
            @ApiResponse(code = 100009, message = "记录id不能为空"),
    })
    public Result<ApplyManageApprDTO> getApplyManageById(@RequestParam(value = "id") Long id) {
        //1.校验
        BizAssert.assertNotNull(HardWareExceptionCode.APPLY_MANAGE_ID_NULL, id);
        //2.查询
        ApplyManage applyManage = applyManageService.getById(id);
        ApplyManageApprDTO apprDTO = dozerUtils.map(applyManage, ApplyManageApprDTO.class);

        //3.附件
        AttachmentExample example = new AttachmentExample();
        example.createCriteria().andBusIdEqualTo(id);
        List<Attachment> attachments = attachmentService.find(example);
        List<AttachmentDTO> attach = dozerUtils.mapList(attachments, AttachmentDTO.class);
        apprDTO.setAttachment(attach);

        //4.服务器、磁盘
        List<ApplyServerDO> applyServers = applyServerService.getApplyServerByApplyKeyId(id);
        if (applyServers != null) {
            for (ApplyServerDO server : applyServers) {
                ApplyDiskExample diskExample = new ApplyDiskExample();
                diskExample.createCriteria().andApplyServeridEqualTo(server.getId());
                diskExample.setOrderByClause(" disk_type desc ");
                List<ApplyDisk> disk = applyDiskService.find(diskExample);
                server.setDisks(disk);
            }
        }
        List<ApplyServerDTO> applyServerDTOS = dozerUtils.mapList(applyServers, ApplyServerDTO.class);
        apprDTO.setApplyServer(applyServerDTOS);

        return Result.success(apprDTO);
    }

    /**
     * 根据id查询申请服务器资源
     *
     * @param id
     * @return
     */
    @Deprecated
    @ApiOperation(value = "根据id查询申请服务器资源", notes = "根据id查询申请服务器资源")
    @RequestMapping(value = "/getApplyServerById", method = RequestMethod.GET)
    @ApiResponses({
            @ApiResponse(code = 100009, message = "记录id不能为空"),
    })
    public Result<ApplyServerDTO> getApplyServerById(@RequestParam(value = "id") Long id) {
        //1.校验
        BizAssert.assertNotNull(HardWareExceptionCode.APPLY_SERVER_ID_NULL, id);
        //服务器、磁盘
        ApplyServerDO applyServer = applyServerService.getApplyServerById(id);
        if (applyServer != null) {
            ApplyDiskExample diskExample = new ApplyDiskExample();
            diskExample.createCriteria().andApplyServeridEqualTo(applyServer.getId());
            List<ApplyDisk> disk = applyDiskService.find(diskExample);
            applyServer.setDisks(disk);
        }
        ApplyServerDTO applyServerDTOS = dozerUtils.map(applyServer, ApplyServerDTO.class);
        return Result.success(applyServerDTOS);
    }

    /**
     * 根据ApplyId查询申请新增所需资源
     *
     * @param keyid
     * @return
     */
    @ApiOperation(value = "根据ApplyId查询申请新增所需资源", notes = "根据ApplyId查询申请新增所需资源")
    @RequestMapping(value = "/getApplyResByApplyId", method = RequestMethod.GET)
    @ApiResponses({
            @ApiResponse(code = 100009, message = "记录id不能为空"),
    })
    public Result<ApplyResourceDTO> getApplyResByApplyId(@RequestParam(value = "keyid") Long keyid) {
        BizAssert.assertNotNull(HardWareExceptionCode.APPLY_MANAGE_ID_NULL, keyid);
        ApplyResourceExample resourceExample = new ApplyResourceExample();
        resourceExample.createCriteria().andApplyKeyidEqualTo(keyid);
        ApplyResource res = resourceService.getUnique(resourceExample);
        ApplyResourceDTO dto = dozerUtils.map(res, ApplyResourceDTO.class);
        return Result.success(dto);
    }


    /**
     * 根据ApplyId查询新增主机
     *
     * @param keyid
     * @return
     */
    @ApiOperation(value = "根据ApplyId查询新增主机", notes = "根据ApplyId查询新增主机")
    @RequestMapping(value = "/getAddHostByApplyId", method = RequestMethod.GET)
    @ApiResponses({
            @ApiResponse(code = 100009, message = "记录id不能为空"),
    })
    public Result<List<AddHostResourceDTO>> getAddHostByApplyId(@RequestParam(value = "keyid") Long keyid) {
        BizAssert.assertNotNull(HardWareExceptionCode.APPLY_MANAGE_ID_NULL, keyid);
        MachineManageExample machineManageExample = new MachineManageExample();
        machineManageExample.createCriteria().andApplyKeyidEqualTo(keyid);
        List<MachineManage> res = machineManageService.find(machineManageExample);
        List<AddHostResourceDTO> dto = dozerUtils.mapList(res, AddHostResourceDTO.class);
        return Result.success(dto);
    }

    /**
     * 根据ApplyId查询审批记录
     *
     * @param keyid
     * @return
     */
    @ApiOperation(value = "根据ApplyId查询审批记录", notes = "根据ApplyId查询审批记录")
    @RequestMapping(value = "/getApplyRecordsByApplyId", method = RequestMethod.GET)
    @ApiResponses({
            @ApiResponse(code = 100009, message = "记录id不能为空"),
    })
    public Result<List<ApplyRecordRetDTO>> getApplyRecordsByApplyId(@RequestParam(value = "keyid") Long keyid) {
        BizAssert.assertNotNull(HardWareExceptionCode.APPLY_MANAGE_ID_NULL, keyid);
        ApplyRecordExample applyRecordExample = new ApplyRecordExample();
        applyRecordExample.createCriteria().andApplyKeyidEqualTo(keyid);
        applyRecordExample.setOrderByClause(" create_time asc ");
        List<ApplyRecord> res = applyRecordService.find(applyRecordExample);
        List<ApplyRecordRetDTO> dto = dozerUtils.mapList(res, ApplyRecordRetDTO.class);
        return Result.success(dto);
    }


    /**
     * 根据id对申请进行审批
     *
     * @param commonApproveDTO
     * @return
     */
    @ApiOperation(value = "根据id对申请进行审批", notes = "根据id对申请进行审批")
    @RequestMapping(value = "/commApproveSubmit", method = RequestMethod.POST)
    @ApiResponses({
            @ApiResponse(code = 100013, message = "提交数据不能为空"),
            @ApiResponse(code = 100009, message = "记录id不能为空"),
            @ApiResponse(code = 100010, message = "该条审批数据不存在"),
    })
    public Result<CommonApproveDTO> saveCommApproveSubmit(@RequestBody CommonApproveDTO commonApproveDTO) {
        BizAssert.assertNotNull(HardWareExceptionCode.APPLY_DATA_NULL, commonApproveDTO);
        BizAssert.assertNotNull(HardWareExceptionCode.APPLY_MANAGE_ID_NULL, commonApproveDTO.getApplyKeyid());
        ApplyManage applyManage = applyManageService.getById(commonApproveDTO.getApplyKeyid());
        BizAssert.assertNotNull(HardWareExceptionCode.APPLY_APPR_MANAGE_NULL, applyManage);

        String currentStepCode = applyManage.getStepCode();
        String currentStepName = StepConstant.getprocessName(currentStepCode);
        String currentScode = StepConstant.getCode(currentStepCode);
        String currentSname = StepConstant.getName(currentStepCode);

        ApplyRecord record = dozerUtils.map(commonApproveDTO, ApplyRecord.class);
        record.setCreateUser(BaseContextHandler.getAdminId() + "");
        record.setUpdateUser(BaseContextHandler.getAdminId() + "");
        record.setApplyUid(BaseContextHandler.getAdminId().toString());
        record.setApplyUname(BaseContextHandler.getName());
        ApplyManage apply = new ApplyManage();
        apply.setId(commonApproveDTO.getApplyKeyid());
        apply.setUpdateUser(BaseContextHandler.getAdminId() + "");

        record.setStepCode(currentStepCode);
        record.setStepName(currentStepName);
        record.setScode(currentScode);
        record.setSname(currentSname);
        //审批通过
        if (CommonConstant.YES.equals(commonApproveDTO.getPassFlag())) {
            //获取流程下一节点code
            String nextStepCode = processData.getProcess().get(currentStepCode).getNextStep(true);
            String nextStepName = StepConstant.getprocessName(nextStepCode);
            //获取流程下一节点大步骤Code 和 Name
            String nextSCode = StepConstant.getCode(nextStepCode);
            String nextName = StepConstant.getName(nextStepCode);

            apply.setStepCode(nextStepCode);
            apply.setStepName(nextStepName);
            apply.setScode(nextSCode);
            apply.setSname(nextName);
            //处理消息
            commonSendMessage(applyManage, nextStepCode);
            //统一监管推送，结束上个审批，开始新的审批
            pushSupervise(applyManage.getId(), new Date(), new Date(), currentStepCode, "审批", "软硬件管理资源申请审批通过");
            pushSupervise(applyManage.getId(), new Date(), null, nextStepCode, "审批", "软硬件管理资源申请审批通过");
        } else {
            String nextStepCode = processData.getProcess().get(currentStepCode).getNextStep(false);
            String nextStepName = StepConstant.getprocessName(nextStepCode);
            String nextSCode = StepConstant.getCode(nextStepCode);
            String nextName = StepConstant.getName(nextStepCode);

            apply.setStepCode(nextStepCode);
            apply.setStepName(nextStepName);
            apply.setScode(nextSCode);
            apply.setSname(nextName);
            //处理消息
            commonSendMessage(applyManage, nextStepCode);
            //统一监管推送，结束上个审批，开始新的审批
            pushSupervise(applyManage.getId(), new Date(), new Date(), currentStepCode, "审批", "软硬件管理资源申请审批不通过");
            pushSupervise(applyManage.getId(), new Date(), null, nextStepCode, "审批", "软硬件管理资源申请审批不通过");
        }
        applyManageService.updateByIdSelective(apply);
        applyRecordService.saveSelective(record);
        //处理消息
        dealMessage(applyManage.getId().toString(), applyManage.getStepCode());
        return Result.success(commonApproveDTO);
    }

    /**
     * 通用审批，处理消息
     */
    private void commonSendMessage(ApplyManage applyManage, String nextStepCode) {
        //使用普通审批的节点只有：管理员审批->YOUYI_HANDLER、ROBACK，管理员扩展审批->YIYUN_HANDLER、ROBACK，高新翼云—>YIYUN_ADD_HOST、ROBACK
        switch (nextStepCode) {
            case "YOUYI_HANDLER":
                applySendMsg(applyManage, "/index.html#/applyMgr", uyiRoleCode, applyManage.getStepCode(), "1", null);
                break;
            case "ROBACK":
                applySendMsg(applyManage, "/index.html#/departmentApply", deptRoleCode, applyManage.getStepCode(), "1", null);
                break;
            case "YIYUN_HANDLER":
                applySendMsg(applyManage, "/index.html#/gxyyApply", yyRoleCode, applyManage.getStepCode(), "1", null);
                break;
            case "YIYUN_ADD_HOST":
                applySendMsg(applyManage, "/index.html#/gxyyApply", yyRoleCode, applyManage.getStepCode(), "1", null);
                break;
            default:
                break;
        }
    }


    /**
     * 消息处理
     *
     * @param bizId
     * @param bizType
     */
    private void dealMessage(String bizId, String bizType) {
        try {
            UpdateBacklogReqDTO updateMssage = new UpdateBacklogReqDTO();
            updateMssage.setAppId(BaseContextHandler.getAppId());
            updateMssage.setBizId(bizId);
            updateMssage.setBizType(bizType);
            bbMsgQueueProducer.updateBbsToHandleed(updateMssage);
        } catch (Exception e) {
            log.error("消息处理" + e);
        }
    }

    /**
     * 优易资源不足提交审批处理
     *
     * @param applyResSubmitDTO
     * @return
     */
    @ApiOperation(value = "优易资源不足提交审批处理，根据id对申请进行审批",
            notes = "优易资源不足提交审批处理，根据id对申请进行审批")
    @RequestMapping(value = "/uYApplyReseSubmit", method = RequestMethod.POST)
    @ApiResponses({
            @ApiResponse(code = 100013, message = "提交数据不能为空"),
            @ApiResponse(code = 100009, message = "记录id不能为空"),
            @ApiResponse(code = 100010, message = "该条审批数据不存在"),
    })
    public Result<ApplyResSubmitDTO> saveuYApplyReseSubmit(@RequestBody ApplyResSubmitDTO applyResSubmitDTO) {
        //1.校验
        BizAssert.assertNotNull(HardWareExceptionCode.APPLY_DATA_NULL, applyResSubmitDTO);
        BizAssert.assertNotNull(HardWareExceptionCode.APPLY_MANAGE_ID_NULL, applyResSubmitDTO.getApplyKeyid());
        BizAssert.assertNotNull(HardWareExceptionCode.APPLY_APPR_STEPCODE_NULL, applyResSubmitDTO.getStepCode());
        BizAssert.assertFalse(HardWareExceptionCode.APPLY_STEPCODE_MATCH_NULL, !(StepConstant.YOUYI_HANDLER.getStepCode()).equals(applyResSubmitDTO.getStepCode()));
        ApplyManage applyManage = applyManageService.getById(applyResSubmitDTO.getApplyKeyid());
        BizAssert.assertNotNull(HardWareExceptionCode.APPLY_APPR_MANAGE_NULL, applyManage);
        String currentStepCode = StepConstant.YOUYI_HANDLER.getStepCode();
        String currentStepName = StepConstant.getprocessName(currentStepCode);
        String currentScode = StepConstant.getCode(currentStepCode);
        String currentSname = StepConstant.getName(currentStepCode);

        //2.保存申请资源
        ApplyResource resource = dozerUtils.map(applyResSubmitDTO, ApplyResource.class);
        resource.setCreateUser(BaseContextHandler.getAdminId() + "");
        resource.setUpdateUser(BaseContextHandler.getAdminId() + "");
        resourceService.saveSelective(resource);

        //3.处理审批记录
        String nextStepCode = processData.getProcess().get(currentStepCode).getNextStep(false);
        String nextStepName = StepConstant.getprocessName(nextStepCode);
        String nextSCode = StepConstant.getCode(nextStepCode);
        String nextName = StepConstant.getName(nextStepCode);

        ApplyRecord record = new ApplyRecord();
        record.setApplyKeyid(applyResSubmitDTO.getApplyKeyid());
        record.setApplyUid(BaseContextHandler.getAdminId() + "");
        record.setApplyUname(BaseContextHandler.getName());
        record.setPassFlag(CommonConstant.NO);
        record.setApprOpinion("资源不足");
        record.setStepName(currentStepName);
        record.setStepCode(currentStepCode);
        record.setScode(currentScode);
        record.setSname(currentSname);
        record.setCreateUser(BaseContextHandler.getAdminId() + "");
        record.setUpdateUser(BaseContextHandler.getAdminId() + "");
        applyRecordService.saveSelective(record);

        //4.处理申请单节点数据
        ApplyManage apply = new ApplyManage();
        apply.setId(applyResSubmitDTO.getApplyKeyid());
        apply.setUpdateUser(BaseContextHandler.getAdminId() + "");
        apply.setStepName(nextStepName);
        apply.setStepCode(nextStepCode);
        apply.setScode(nextSCode);
        apply.setSname(nextName);
        applyManageService.updateByIdSelective(apply);
        //消息推送
        applySendMsg(applyManage, "/index.html#/adminApply", manageRoleCode, currentStepCode, "1", null);
        //处理消息
        dealMessage(applyManage.getId().toString(), applyManage.getStepCode());
        //统一监管推送，第一个为结束上个环节的推送，第二个为开始这次提交的推送
        pushSupervise(applyManage.getId(), new Date(), new Date(), currentStepCode, "审批", "软硬件管理-资源不足提交审批处理");
        pushSupervise(applyManage.getId(), new Date(), null, nextStepCode, "审批", "软硬件管理-资源不足提交审批处理");
        return Result.success(applyResSubmitDTO);
    }

    /**
     * 优易分配虚拟机
     *
     * @param dealToServerDTO
     * @return
     */
    @ApiOperation(value = "优易分配虚拟机",
            notes = "优易分配虚拟机")
    @RequestMapping(value = "/uYApproveSubmit", method = RequestMethod.POST)
    @ApiResponses({
            @ApiResponse(code = 100013, message = "提交数据不能为空"),
            @ApiResponse(code = 100009, message = "记录id不能为空"),
            @ApiResponse(code = 100010, message = "该条审批数据不存在"),
    })
    public Result<DealToServerDTO> saveuYApproveSubmit(@RequestBody DealToServerDTO dealToServerDTO) {
        //1.校验
        BizAssert.assertNotNull(HardWareExceptionCode.APPLY_DATA_NULL, dealToServerDTO);
        BizAssert.assertNotNull(HardWareExceptionCode.APPLY_MANAGE_ID_NULL, dealToServerDTO.getApplyKeyid());
        BizAssert.assertNotNull(HardWareExceptionCode.APPLY_APPR_STEPCODE_NULL, dealToServerDTO.getStepCode());
        BizAssert.assertFalse(HardWareExceptionCode.APPLY_STEPCODE_MATCH_NULL, !(StepConstant.YOUYI_HANDLER.getStepCode()).equals(dealToServerDTO.getStepCode()));
        ApplyManage applyManage = applyManageService.getById(dealToServerDTO.getApplyKeyid());
        BizAssert.assertNotNull(HardWareExceptionCode.APPLY_APPR_MANAGE_NULL, applyManage);

        //2.保存分配的主机
        if (dealToServerDTO.getDealServer() != null) {
            List<ServerManage> serverList = dozerUtils.mapList(dealToServerDTO.getDealServer(), ServerManage.class);
            for (ServerManage server : serverList) {
                Long id = idGenerator.generate();
                server.setUpdateUser(BaseContextHandler.getAdminId() + "");
                server.setManageUid(applyManage.getApplyUid());
                server.setManageUname(applyManage.getApplyUname());
                server.setOrgid(applyManage.getApplyOrgid());
                server.setOrgname(applyManage.getApplyOrgname());
                //开通时间
                server.setOpenTime(new Date());
                //使用中
                server.setUseStatus(CommonConstant.USING);
                //选择之前已存在的
                if (server.getId() != null) {
                    //处理变更信息
                    if (applyManage.getServerKeyid() != null) {
                        dealChange(applyManage, server);
                    }
                    serverManageService.updateByIdSelective(server);
                } else {//新增的
                    server.setId(id);
                    server.setPid(-1L);
                    server.setCreateUser(BaseContextHandler.getAdminId() + "");
                    //处理变更信息
                    if (applyManage.getServerKeyid() != null) {
                        dealChange(applyManage, server);
                    } else {
                        server.setOriginId(id);
                        server.setChangeCount(0);
                        server.setChangeFlag(CommonConstant.FALSE);
                    }
                    serverManageService.saveServer(server);
                }
                //处理磁盘
                List<DiskManage> disks = server.getDisks();
                if (disks != null) {
                    for (DiskManage disk : disks) {
                        disk.setServerId(server.getId());
                        disk.setCreateUser(BaseContextHandler.getAdminId() + "");
                        disk.setUpdateUser(BaseContextHandler.getAdminId() + "");
                    }
                    diskManageService.save(disks);
                }
            }
        }

        //3.处理审批记录-后一节点一定是结束节点
        ApplyRecord record = new ApplyRecord();
        record.setApplyKeyid(dealToServerDTO.getApplyKeyid());
        record.setApplyUid(BaseContextHandler.getAdminId() + "");
        record.setApplyUname(BaseContextHandler.getName());
        record.setPassFlag(CommonConstant.YES);
        record.setApprOpinion("虚拟机已分配");
        record.setStepName(StepConstant.END.getStepName());
        record.setStepCode(StepConstant.END.getStepCode());
        record.setScode(StepConstant.END.getsCode());
        record.setSname(StepConstant.END.getsName());
        record.setCreateUser(BaseContextHandler.getAdminId() + "");
        record.setUpdateUser(BaseContextHandler.getAdminId() + "");
        applyRecordService.saveSelective(record);

        //4.处理申请单节点数据
        ApplyManage apply = new ApplyManage();
        apply.setId(dealToServerDTO.getApplyKeyid());
        apply.setStepName(StepConstant.END.getStepName());
        apply.setStepCode(StepConstant.END.getStepCode());
        apply.setScode(StepConstant.END.getsCode());
        apply.setSname(StepConstant.END.getsName());
        //是否分配到资源
        apply.setResflag(true);
        //是否正常结束
        apply.setEndflag(CommonConstant.THREE);
        apply.setUpdateUser(BaseContextHandler.getAdminId() + "");
        applyManageService.updateByIdSelective(apply);
        //消息推送
        applySendMsg(applyManage, "/index.html#/departmentServer", deptRoleCode, applyManage.getStepCode(), "2", "您的服务器资源申请已审批通过。");
        //统一监管推送-结束流程
        pushSupervise(applyManage.getId(), new Date(), new Date(), applyManage.getStepCode(), "审批", "软硬件管理-分配虚拟机");
        //处理消息
        dealMessage(applyManage.getId().toString(), applyManage.getStepCode());
        return Result.success(dealToServerDTO);
    }

    private void dealChange(ApplyManage applyManage, ServerManage server) {
        //查询变更的服务器源数据
        ServerManage se = serverManageService.getById(applyManage.getServerKeyid());
        if (se != null) {
            server.setPid(se.getId());
            server.setOriginId(se.getOriginId());
            if (se.getChangeCount() != null) {
                server.setChangeCount(se.getChangeCount() + 1);
            }
            server.setChangeFlag(CommonConstant.TRUE);
            //审批通过后，获得新分配的服务器，释放之前的服务器，将被变更服务器修改为已释放
            ServerManage serverManage = new ServerManage();
            serverManage.setId(server.getPid());
            serverManage.setRevertTime(new Date());
            serverManage.setUseStatus(CommonConstant.NOT_USE);
            serverManageService.updateByIdSelective(serverManage);
        }
    }

    /**
     * 高新翼云新增主机提交审批处理
     *
     * @param manageSubmitDTO
     * @return
     */
    @ApiOperation(value = "硬件供应商新增主机提交处理",
            notes = "硬件供应商新增主机提交处理")
    @RequestMapping(value = "/yiYunApproveSubmit", method = RequestMethod.POST)
    @ApiResponses({
            @ApiResponse(code = 100013, message = "提交数据不能为空"),
            @ApiResponse(code = 100009, message = "记录id不能为空"),
            @ApiResponse(code = 100010, message = "该条审批数据不存在"),
    })
    public Result<MachineManageSDTO> saveyiYunApproveSubmit(@RequestBody MachineManageSDTO manageSubmitDTO) {
        //1.校验
        BizAssert.assertNotNull(HardWareExceptionCode.APPLY_DATA_NULL, manageSubmitDTO);
        BizAssert.assertNotNull(HardWareExceptionCode.APPLY_MANAGE_ID_NULL, manageSubmitDTO.getApplyKeyid());
        BizAssert.assertNotNull(HardWareExceptionCode.APPLY_APPR_STEPCODE_NULL, manageSubmitDTO.getStepCode());
        BizAssert.assertFalse(HardWareExceptionCode.APPLY_STEPCODE_MATCH_NULL, !(StepConstant.YIYUN_ADD_HOST.getStepCode()).equals(manageSubmitDTO.getStepCode()));
        ApplyManage applyManage = applyManageService.getById(manageSubmitDTO.getApplyKeyid());
        BizAssert.assertNotNull(HardWareExceptionCode.APPLY_APPR_MANAGE_NULL, applyManage);
        String currentStepCode = StepConstant.YIYUN_ADD_HOST.getStepCode();
        String currentStepName = StepConstant.getprocessName(currentStepCode);
        String currentScode = StepConstant.getCode(currentStepCode);
        String currentSname = StepConstant.getName(currentStepCode);

        //2.保存主机
        List<MachineManage> machine = dozerUtils.mapList(manageSubmitDTO.getMachineManage(), MachineManage.class);
        machine.stream().forEach(mach -> {
            BizAssert.assertNotNull(HardWareExceptionCode.MACHINE_IP_NULL, mach.getIp());
            BizAssert.assertNotNull(HardWareExceptionCode.MACHINE_CLUSTER_NULL, mach.getCluster());
            BizAssert.assertNotNull(HardWareExceptionCode.MACHINE_CPUCOUNT_NULL, mach.getCpuCount());
            BizAssert.assertNotNull(HardWareExceptionCode.MACHINE_DISKSIZE_NULL, mach.getDiskSize());
            BizAssert.assertNotNull(HardWareExceptionCode.MACHINE_MEMORY_NULL, mach.getMemory());
            BizAssert.assertNotNull(HardWareExceptionCode.MACHINE_NETCARDCOUNT_NULL, mach.getNetcardCount());
            BizAssert.assertNotNull(HardWareExceptionCode.APPLY_SERVER_APPLYKEYID_NULL, mach.getApplyKeyid());
        });
        //删除历史纪录
        machineManageService.deleteByApplyKeyid(manageSubmitDTO.getApplyKeyid());
        machine.stream().forEach(mach -> {
            mach.setApplyKeyid(manageSubmitDTO.getApplyKeyid());
            mach.setUpdateUser(BaseContextHandler.getAdminId() + "");
            mach.setCreateUser(BaseContextHandler.getAdminId() + "");
            machineManageService.saveSelective(mach);
        });

        //3.处理审批记录
        String nextStepCode = processData.getProcess().get(currentStepCode).getNextStep(true);
        String nextStepName = StepConstant.getprocessName(nextStepCode);
        String nextSCode = StepConstant.getCode(nextStepCode);
        String nextName = StepConstant.getName(nextStepCode);
        ApplyRecord record = new ApplyRecord();
        record.setApplyKeyid(manageSubmitDTO.getApplyKeyid());
        record.setApplyUid(BaseContextHandler.getAdminId() + "");
        record.setApplyUname(BaseContextHandler.getName());
        record.setPassFlag(CommonConstant.YES);
        record.setApprOpinion("新增主机");
        record.setStepName(currentStepName);
        record.setStepCode(currentStepCode);
        record.setScode(currentScode);
        record.setSname(currentSname);

        record.setCreateUser(BaseContextHandler.getAdminId() + "");
        record.setUpdateUser(BaseContextHandler.getAdminId() + "");
        applyRecordService.saveSelective(record);

        //4.处理申请单节点数据
        ApplyManage apply = new ApplyManage();
        apply.setId(manageSubmitDTO.getApplyKeyid());
        apply.setUpdateUser(BaseContextHandler.getAdminId() + "");
        apply.setStepName(nextStepName);
        apply.setStepCode(nextStepCode);
        apply.setScode(nextSCode);
        apply.setSname(nextName);
        applyManageService.updateByIdSelective(apply);
        //消息推送
        applySendMsg(applyManage, "/index.html#/applyMgr", uyiRoleCode, currentStepCode, "1", null);
        //统一监管推送-结束上个节点审批，发起新审批
        pushSupervise(applyManage.getId(), new Date(), new Date(), currentStepCode, "审批", "软硬件管理-新增主机提交审批处理");
        pushSupervise(applyManage.getId(), new Date(), null, nextStepCode, "审批", "软硬件管理-新增主机提交审批处理");
        //处理消息
        dealMessage(applyManage.getId().toString(), applyManage.getStepCode());
        return Result.success(manageSubmitDTO);
    }

    /**
     * 释放服务器数据
     *
     * @param id
     * @return
     */
    @ApiOperation(value = "释放服务器数据", notes = "释放服务器数据")
    @RequestMapping(value = "/releaseServer", method = RequestMethod.POST)
    @ApiResponses({
            @ApiResponse(code = 100014, message = "服务器id不能为空"),
    })
    public Result<String> updateReleaseServer(@RequestParam(value = "id") Long id) {
        //1.校验
        BizAssert.assertNotNull(HardWareExceptionCode.APPLY_SERVER_ID_NULL, id);
        ServerManage serverManage = new ServerManage();
        serverManage.setId(id);
        serverManage.setRevertTime(new Date());
        serverManage.setUseStatus(CommonConstant.NOT_USE);
        int result = serverManageService.updateByIdSelective(serverManage);
        if (result > 0) {
            return Result.success("SUCCESS");
        }
        return Result.fail("FAIL");
    }

    /**
     * 重新使用服务器数据
     *
     * @param id
     * @return
     */
    @ApiOperation(value = "重新使用服务器数据", notes = "重新使用服务器数据")
    @RequestMapping(value = "/reusingServer", method = RequestMethod.POST)
    @ApiResponses({
            @ApiResponse(code = 100014, message = "服务器id不能为空"),
    })
    public Result<String> saveReusingServer(@RequestParam(value = "id") Long id) {
        //1.校验
        BizAssert.assertNotNull(HardWareExceptionCode.APPLY_SERVER_ID_NULL, id);
        ServerManage serverManage = new ServerManage();
        serverManage.setId(id);
        serverManage.setUseStatus(CommonConstant.USING);
        int result = serverManageService.updateById(serverManage);
        if (result > 0) {
            return Result.success("SUCCESS");
        }
        return Result.fail("FAIL");
    }

    /**
     * 管理员销毁服务器数据
     *
     * @param id
     * @return
     */
    @ApiOperation(value = "管理员销毁服务器数据", notes = "管理员销毁服务器数据")
    @RequestMapping(value = "/delServer", method = RequestMethod.POST)
    @ApiResponses({
            @ApiResponse(code = 100014, message = "服务器id不能为空"),
    })
    public Result<String> deleteServer(@RequestParam(value = "id") Long id) {
        //1.校验
        BizAssert.assertNotNull(HardWareExceptionCode.APPLY_SERVER_ID_NULL, id);
        ServerManage serverManage = new ServerManage();
        serverManage.setId(id);
        serverManage.setUseStatus(CommonConstant.REVERT);
        int result = serverManageService.updateById(serverManage);
        if (result > 0) {
            return Result.success("SUCCESS");
        }
        return Result.fail("FAIL");
    }


    //=========================================以下为编号处理=========================================================
    private static ConcurrentHashMap<String, String> applyNomap = new ConcurrentHashMap<>();
    private static Lock lock = new ReentrantLock();

    /**
     * 编号处理
     */
    @PostConstruct
    public void init() {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String date = format.format(new Date()).replaceAll("-", "");
        ApplyManageExample example = new ApplyManageExample();
        example.createCriteria().andApplyTypeEqualTo(CommonConstant.ADD);
        example.setOrderByClause(" apply_no desc ");
        ApplyManage addNo = applyManageService.getUnique(example);
        //防止启动因数据造成服务器无法启动
        if (addNo == null || addNo.getApplyNo() == null || "".equals(addNo.getApplyNo())) {
            applyNomap.put("XZ", "XZ" + date + "0000");
        } else {
            applyNomap.put("XZ", addNo.getApplyNo());
        }
        ApplyManageExample change = new ApplyManageExample();
        change.createCriteria().andApplyTypeEqualTo(CommonConstant.UPDATE);
        change.setOrderByClause(" apply_no desc ");
        ApplyManage changeNo = applyManageService.getUnique(change);
        if (changeNo == null) {
            applyNomap.put("BG", "BG" + date + "0000");
        } else {
            applyNomap.put("BG", changeNo.getApplyNo());
        }
    }

    /**
     * 根据类型获取自增编号
     *
     * @param type
     * @return
     */
    private String getApplyNo(String type) {
        lock.lock();
        String applyNO = "";
        String xzType = "XZ";
        String bgType = "BG";
        try {
            String no;
            String typ;
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            if (xzType.equals(type)) {
                no = applyNomap.get(xzType);
                typ = xzType;
            } else {
                no = applyNomap.get(bgType);
                typ = bgType;
            }
            String endNO = no.substring(10, no.length());
            String date = format.format(new Date()).replaceAll("-", "");
            Integer integer = Integer.parseInt(endNO);
            ++integer;
            if (integer <= 9) {
                applyNO = typ + date + "000" + integer;
            } else if (integer > 9 && integer <= 99) {
                applyNO = typ + date + "00" + integer;
            } else if (integer > 99 && integer <= 999) {
                applyNO = typ + date + "0" + integer;
            } else {
                applyNO = typ + date + integer;
            }
            applyNomap.put(typ, applyNO);
        } finally {
            lock.unlock();
        }
        return applyNO;
    }
}
