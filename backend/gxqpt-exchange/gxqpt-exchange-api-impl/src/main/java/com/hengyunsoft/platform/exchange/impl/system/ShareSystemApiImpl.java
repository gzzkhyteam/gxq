package com.hengyunsoft.platform.exchange.impl.system;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hengyunsoft.base.Result;
import com.hengyunsoft.base.id.IdGenerate;
import com.hengyunsoft.commons.context.BaseContextHandler;
import com.hengyunsoft.commons.exception.core.ExchangeExceptionCode;
import com.hengyunsoft.commons.utils.context.DozerUtils;
import com.hengyunsoft.page.plugins.openapi.OpenApiReq;
import com.hengyunsoft.platform.exchange.api.system.dto.ShareRequestSaveSystemDTO;
import com.hengyunsoft.platform.exchange.api.system.dto.ShareRequestSystemDTO;
import com.hengyunsoft.platform.exchange.api.system.dto.ShareResponseSelectSystemDTO;
import com.hengyunsoft.platform.exchange.api.system.dto.ShareResponseSystemDTO;
import com.hengyunsoft.platform.exchange.entity.system.po.ShareSystem;
import com.hengyunsoft.platform.exchange.repository.common.service.CommonService;
import com.hengyunsoft.platform.exchange.repository.system.example.ShareSystemExample;
import com.hengyunsoft.platform.exchange.repository.system.service.ShareSystemService;
import com.hengyunsoft.platform.exchange.utils.GxqPtRoleUnits;
import com.hengyunsoft.utils.BizAssert;
import com.hengyunsoft.validator.ValidatorGroups;
import com.hengyunsoft.validator.annotation.Constraint;
import com.hengyunsoft.validator.annotation.ValidatorStandard;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.groups.Default;
import java.util.Calendar;
import java.util.List;


/**
 * com.hengyunsoft.platform.exchange.impl.system
 * 版权：中科恒运软件科技股份有限公司贵阳分公司
 * 描述：业务系统 AIP管理
 * 修改人：wt
 * 修改时间：2018/4/23
 * 修改内容：新增基础接口
 */
@Api(value = "API - ShareDictApiImpl.java", description = "业务系统 AIP管理")
@RestController
@RequestMapping("dataapi")
@Slf4j
public class ShareSystemApiImpl /*implements ShareSystemApi */ {
    @Autowired
    private ShareSystemService shareSystemService;

    @Autowired
    private DozerUtils dozerUtils;

    @Autowired
    IdGenerate<Long> idGenerate;

    @Autowired
    private CommonService commonService;

    @Autowired
    private GxqPtRoleUnits gxqPtRoleUnits;

    /**
     * 描述：根据参数查询业务系统
     * 参数：ShareRequestSystemDTO
     * 返回值：List<ShareResponseSystemDTO>
     * 修改人：wt
     * 修改时间：2018/4/24
     * 修改内容：创建日期倒序查询 2018/7/13
     */
    @RequestMapping(value = "/system/findSys", method = RequestMethod.POST)
    @ApiOperation(value = "根据参数查询业务系统", notes = "根据参数查询业务系统")
    @ApiResponses({
            @ApiResponse(code = 86017, message = "申请对象不能为空"),
    })

    public Result<PageInfo<ShareResponseSystemDTO>> findSys(@RequestBody OpenApiReq<ShareRequestSystemDTO> openApiReq) {
        //数据验证
        BizAssert.assertNotNull(ExchangeExceptionCode.SHARE_DICT_NULL, openApiReq);

        //基本数据的获取
        Long adminId = BaseContextHandler.getAdminId();
        String orgId = commonService.getOrgIdByUserId(adminId);
        log.info("ShareDbSourceApiImpl-find:adminId={},orgId={}", adminId, orgId);
        String contractor = null;
        Integer status = null;
        Integer sysArch = null;
        String majorData = null;
        String sysName = null;
        if (openApiReq.getData() != null) {
            contractor = openApiReq.getData().getContractor();
            status = openApiReq.getData().getStatus();
            sysArch = openApiReq.getData().getSysArch();
            majorData = openApiReq.getData().getMajorData();
            sysName = openApiReq.getData().getSysName();
        }

        Boolean isPtAdmin = gxqPtRoleUnits.getGxqPtRole(adminId, GxqPtRoleUnits.PT_ADMIN_ROLE_CODE);
        Boolean isPtAdminData = gxqPtRoleUnits.getGxqPtRole(adminId, GxqPtRoleUnits.PT_ADMIN_DATA_ROLE_CODE);
        if (isPtAdmin || isPtAdminData) {
            orgId = null;
        }

        //数据获取
        PageHelper.startPage(openApiReq.getPageNo(), openApiReq.getPageSize());
        List<ShareSystem> list = shareSystemService.findSystemList(contractor, status, sysArch, majorData, sysName, orgId);
        return Result.success(new PageInfo<>(dozerUtils.mapPage(list, ShareResponseSystemDTO.class)));
    }

    /**
     * 描述：查询系统列表对象
     * 参数：id
     * 返回值：ShareResponseSystemDTO
     * 修改人：wt
     * 修改时间：2018/4/24
     * 修改内容：
     */
    @RequestMapping(value = "/system/getById", method = RequestMethod.POST)
    @ApiOperation(value = "查询系统列表对象", notes = "查询系统列表对象")
    @ApiResponses({
            @ApiResponse(code = 86021, message = "输入API ID不能为空"),
    })

    public Result<ShareResponseSystemDTO> getById(@RequestParam("id") Long id) {
        //数据验证
        BizAssert.assertNotNull(ExchangeExceptionCode.SHARE_DICT_ID_NULL, id);
        ShareSystem shareSystem = shareSystemService.getById(id);
        if (shareSystem.getDataCount() != null) {
            shareSystem.setDataCount(shareSystem.getDataCount() == 0 ? null : shareSystem.getDataCount());
        }
        return Result.success(dozerUtils.map(shareSystem, ShareResponseSystemDTO.class));
    }

    /**
     * 描述：根据参数保存业务系统
     * 参数：ShareRequestSaveSystemDTO
     * 返回值：Boolean
     * 修改人：wt
     * 修改时间：2018/4/24
     * 修改内容：
     */
    @RequestMapping(value = "/system/saveSys", method = RequestMethod.POST)
    @ApiOperation(value = "根据参数保存业务系统", notes = "根据参数保存业务系统")
    @ApiResponses({
            @ApiResponse(code = 86017, message = "申请对象不能为空"),
    })
    @ValidatorStandard(
            {
                    @Constraint(value = ShareSystem.class, groups = {Default.class, ValidatorGroups.MustNoneNull.class})
            }
    )

    public Result<Boolean> saveSys(@RequestBody ShareRequestSaveSystemDTO dto) {
        //数据验证
        BizAssert.assertNotNull(ExchangeExceptionCode.SHARE_DICT_NULL, dto);
        Long adminId = BaseContextHandler.getAdminId();
        String orgId = commonService.getOrgIdByUserId(adminId);
        log.info("ShareDbSourceApiImpl-find:adminId={},orgId={}", adminId, orgId);
        ShareSystem shareSystem = new ShareSystem();
        shareSystem.setUnitId(orgId);
        shareSystem.setOrgId(orgId);
        shareSystem.setSysName(dto.getSysName());
        shareSystem.setContractor(dto.getContractor());
        shareSystem.setContName(dto.getContName());
        shareSystem.setContTel(dto.getContTel());
        shareSystem.setStatus(dto.getStatus());
        shareSystem.setUrl(dto.getUrl());
        shareSystem.setUserReft(dto.getUserReft());
        shareSystem.setNetwork(dto.getNetwork());
        shareSystem.setHasKey(dto.getHasKey());
        shareSystem.setHasVpn(dto.getHasVpn());
        shareSystem.setSysArch(dto.getSysArch());
        shareSystem.setAccount(dto.getAccount());
        shareSystem.setPassword(dto.getPassword());
        shareSystem.setLangeFrwork(dto.getLangeFrwork());
        shareSystem.setHasInstruction(dto.getHasInstruction());
        shareSystem.setSysRunEnvent(dto.getSysRunEnvent());
        shareSystem.setDataAddress(dto.getDataAddress());
        shareSystem.setDbType(dto.getDbType());
        shareSystem.setDataCount(dto.getDataCount());
        shareSystem.setHasDict(dto.getHasDict());
        shareSystem.setShareChain(dto.getShareChain());
        shareSystem.setDataDemand(dto.getDataDemand());
        shareSystem.setMajorData(dto.getMajorData());
        shareSystem.setSysPurpose(dto.getSysPurpose());
        shareSystem.setCreateTime(Calendar.getInstance().getTime());
        shareSystem.setCreateUser(adminId);
        shareSystemService.saveSelective(shareSystem);
        return Result.success(true);
    }

    /**
     * 描述：根据参数删除业务系统
     * 参数：ShareRequestSaveSystemDTO
     * 返回值：Boolean
     * 修改人：wt
     * 修改时间：2018/4/24
     * 修改内容：
     */
    @RequestMapping(value = "/system/deleteById", method = RequestMethod.GET)
    @ApiOperation(value = "根据参数删除业务系统", notes = "根据参数删除业务系统")
    @ApiResponses({
            @ApiResponse(code = 86021, message = "输入API ID不能为空"),
    })

    public Result<Boolean> deleteById(@RequestParam("id") Long id) {
        //数据验证
        BizAssert.assertNotNull(ExchangeExceptionCode.SHARE_DICT_ID_NULL, id);
        try {
            shareSystemService.deleteById(id);
        } catch (Exception e) {
            return Result.fail(e);
        }
        return Result.success(true);
    }

    /**
     * 描述：根据参数更新业务系统
     * 参数：ShareResponseSystemDTO
     * 返回值：Boolean
     * 修改人：wt
     * 修改时间：2018/4/24
     * 修改内容：
     */
    @RequestMapping(value = "/system/updateSys", method = RequestMethod.POST)
    @ApiOperation(value = "根据参数更新业务系统", notes = "根据参数更新业务系统")
    @ApiResponses({
            @ApiResponse(code = 86017, message = "申请对象不能为空"),
            @ApiResponse(code = 86021, message = "输入API ID不能为空"),
    })
    @ValidatorStandard(
            {
                    @Constraint(value = ShareSystem.class)
            }
    )

    public Result<Boolean> updateSys(@RequestBody ShareResponseSystemDTO dto) {
        //数据验证
        BizAssert.assertNotNull(ExchangeExceptionCode.SHARE_APPLY_NULL, dto);
        BizAssert.assertNotNull(ExchangeExceptionCode.SHARE_DICT_ID_NULL, dto.getId());
        Long adminId = BaseContextHandler.getAdminId();
        String unitId = commonService.getOrgIdByUserId(adminId);
        ShareSystem shareSystem = dozerUtils.map(dto, ShareSystem.class);
        if (dto.getDataCount() == null) {
            shareSystem.setDataCount(0);
        }
        shareSystem.setUnitId(dto.getUnitId());
        shareSystem.setOrgId(unitId);
        shareSystem.setUpdateTime(Calendar.getInstance().getTime());
        shareSystem.setUpdateUser(adminId);
        shareSystemService.updateByIdSelective(shareSystem);
        return Result.success(true);
    }

    /**
     * 描述：查询系统列表下拉框信息
     * 参数：
     * 返回值：List<ShareResponseSelectSystemDTO>
     * 修改人：wt
     * 修改时间：2018/4/25
     * 修改内容：
     */
    @RequestMapping(value = "/system/findSelectInfo", method = RequestMethod.POST)
    @ApiOperation(value = "查询系统列表下拉框信息", notes = "查询系统列表下拉框信息")

    public Result<List<ShareResponseSelectSystemDTO>> findSelectInfo() {
        Long adminId = BaseContextHandler.getAdminId();
        ShareSystemExample example = new ShareSystemExample();
        example.createCriteria().andCreateUserEqualTo(adminId).andUnitIdIsNotNull();
        List<ShareSystem> list = shareSystemService.find(example);
        return Result.success(dozerUtils.mapList(list, ShareResponseSelectSystemDTO.class));
    }
}
