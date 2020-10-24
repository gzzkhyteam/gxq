package com.hengyunsoft.platform.exchange.impl.dataapi;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hengyunsoft.base.Result;
import com.hengyunsoft.base.id.IdGenerate;
import com.hengyunsoft.commons.context.BaseContextHandler;
import com.hengyunsoft.commons.exception.core.ExchangeExceptionCode;
import com.hengyunsoft.commons.utils.context.DozerUtils;
import com.hengyunsoft.page.plugins.openapi.OpenApiReq;
import com.hengyunsoft.platform.exchange.api.dataapi.dto.demand.*;
import com.hengyunsoft.platform.exchange.constant.ApplyType;
import com.hengyunsoft.platform.exchange.constant.ExchangeConstants;
import com.hengyunsoft.platform.exchange.constant.FileBusType;
import com.hengyunsoft.platform.exchange.entity.api.domain.ShareDataDemandListDO;
import com.hengyunsoft.platform.exchange.entity.api.po.ShareDataDemand;
import com.hengyunsoft.platform.exchange.entity.set.po.ShareDataFile;
import com.hengyunsoft.platform.exchange.entity.system.po.ShareFlowAudit;
import com.hengyunsoft.platform.exchange.repository.api.service.ShareDataDemandService;
import com.hengyunsoft.platform.exchange.repository.common.service.CommonService;
import com.hengyunsoft.platform.exchange.repository.set.example.ShareDataFileExample;
import com.hengyunsoft.platform.exchange.repository.set.service.ShareDataFileService;
import com.hengyunsoft.platform.exchange.repository.system.example.ShareFlowAuditExample;
import com.hengyunsoft.platform.exchange.repository.system.service.ShareFlowAuditService;
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
@Api(value = "API - ShareDataDemandApi.java", description = "需求管理")
@RestController
@RequestMapping("dataapi")
@Slf4j
public class ShareDataDemandApiImpl /*implements ShareDataDemandApi */ {
    @Autowired
    private ShareDataDemandService shareDataDemandService;
    @Autowired
    private CommonService commonService;

    @Autowired
    private DozerUtils dozerUtils;

    @Autowired
    private ShareFlowService shareFlowService;

    @Autowired
    private ShareFlowAuditService shareFlowAuditService;

    @Autowired
    private ShareDataFileService shareDataFileService;
    @Autowired
    private IdGenerate<Long> idGenerate;
    @Autowired
    private GxqPtRoleUnits gxqPtRoleUnits;

    /**
     * 描述：新增需求
     * 参数：DemandSaveDTO 需求新增dto
     * 返回值：Boolean
     * 修改人：zhaopengfei
     * 修改时间：2018/4/21
     * 修改内容：
     */

    @ApiOperation(value = "新增需求", notes = "新增需求")
    @ApiResponses({
            @ApiResponse(code = 86000, message = "需求对象不能为空"),
            @ApiResponse(code = 86001, message = "处理部门不能为空"),
            @ApiResponse(code = 86002, message = "申请内容不能为空"),
    })
    @RequestMapping(value = "/demand/save", method = RequestMethod.POST)
    public Result<Boolean> save(@RequestBody DemandSaveDTO dto) {
        //字段验证
        BizAssert.assertNotNull(ExchangeExceptionCode.DEMAND_NULL, dto);
        BizAssert.assertNotNull(ExchangeExceptionCode.HDDEPT_NULL, dto.getOrgId());
        BizAssert.assertNotNull(ExchangeExceptionCode.DEMAND_CONTENT_NULL, dto.getApplyReason());

        //基础数据获取
        Long userId = BaseContextHandler.getAdminId();
        Date date = new Date();
        //获取单位Id
        String unitId = commonService.getOrgIdByUserId(userId);
        String applyCode = ShareUtil.automaticCode(ApplyType.API_DEMAND_APPLY.getVal());

        //逻辑处理
        ShareDataDemand demand;
        demand = dozerUtils.map(dto, ShareDataDemand.class);
        demand.setApplyCode(applyCode);
        demand.setUnitId(unitId);
        demand.setStatus(1);
        demand.setCreateTime(date);
        demand.setCreateUser(userId);
        demand.setUpdateTime(date);
        demand.setUpdateUser(userId);
        shareDataDemandService.save(demand);

        //保存附件
        if (!ObjectUtils.isEmpty(dto.getFileList())) {
            List<ShareDataFile> shareDataFiles = new ArrayList<>();
            for (DemandFileDTO fileDTO : dto.getFileList()) {
                ShareDataFile file = dozerUtils.map(fileDTO, ShareDataFile.class);
                file.setBusId(demand.getId());
                file.setBusType(FileBusType.DEMAND_APPLY_ACCORD.getVal());
                file.setCreateTime(date);
                file.setCreateUser(userId);
                file.setUpdateTime(date);
                file.setUpdateUser(userId);
                file.setId(idGenerate.generate());
                shareDataFiles.add(file);
            }
            shareDataFileService.saveBatch(shareDataFiles);
        }

        //启动流程
        shareFlowService.saveStartFlow(3, applyCode, ExchangeConstants.FLOW_DEMAND_CODE, userId, unitId);

        return Result.success(true);
    }

    /**
     * 描述：查询需求列表分页数据
     * 参数：openApiReq 分页信息；appId：应用Id
     * 返回值：PageInfo<RoleDto>
     * 修改人：zhaopengfei
     * 修改时间：2018/4/21
     * 修改内容：
     */

    @ApiOperation(value = "查询需求列表分页数据", notes = "查询需求列表分页数据")
    @RequestMapping(value = "/demand/find", method = RequestMethod.POST)
    public Result<PageInfo<DemandListDTO>> page(@RequestBody OpenApiReq<DemandQueryDTO> openApiReq) {
        //基础数据获取
        Long userId = BaseContextHandler.getAdminId();

        Boolean ptAdmin = gxqPtRoleUnits.getGxqPtRole(userId, GxqPtRoleUnits.PT_ADMIN_ROLE_CODE);

        Map<String, Object> param = new HashMap<>();
        if (openApiReq.getData() != null) {
            param.put("startTime", openApiReq.getData().getStartTime());
            param.put("endTime", openApiReq.getData().getEndTime());
            param.put("orgName", openApiReq.getData().getOrgName());
            param.put("status", openApiReq.getData().getStatus());
        }
        if (!ptAdmin) {
            //获取单位Id
            String unitId = commonService.getOrgIdByUserId(userId);
            param.put("unitId", unitId);
        }
        PageHelper.startPage(openApiReq.getPageNo(), openApiReq.getPageSize());
        List<ShareDataDemandListDO> list = shareDataDemandService.findList(param);
        return Result.success(new PageInfo<>(dozerUtils.mapPage(list, DemandListDTO.class)));
    }

    /**
     * 描述：根据需求Id查询需求处理详细信息
     * 参数：id：需求Id
     * 返回值：DemandHandleDetailDTO
     * 修改人：zhaopengfei
     * 修改时间：2018/4/21
     * 修改内容：
     */

    @ApiOperation(value = "获取处理详情", notes = "获取处理详情")
    @ApiResponses({
            @ApiResponse(code = 86003, message = "需求Id不能为空"),
    })
    @RequestMapping(value = "/demand/hddetail", method = RequestMethod.POST)
    public Result<DemandHandleDetailDTO> getHandleDetail(@RequestParam("id") Long id) {
        //数据验证
        BizAssert.assertNotNull(ExchangeExceptionCode.DEMAND_ID_NULL, id);

        //业务逻辑
        ShareDataDemand demand = shareDataDemandService.getById(id);
        String orgId = demand.getOrgId();
        String orgName = "";
        DemandHandleDetailDTO detail = dozerUtils.map(demand, DemandHandleDetailDTO.class);
        if (!StringUtils.isEmpty(orgId)) {
            orgName = commonService.getOrgNameByUnitId(orgId);
        }
        detail.setOrgName(orgName);
        //查找审批数据
        ShareFlowAuditExample example = new ShareFlowAuditExample();
        example.createCriteria().andApplyCodeEqualTo(demand.getApplyCode());
        List<ShareFlowAudit> auditList = shareFlowAuditService.find(example);
        if (!ObjectUtils.isEmpty(auditList)) {
            ShareFlowAudit audit = auditList.get(0);
            detail.setHdContent(audit.getContent());
        }

        //查找附件
        ShareDataFileExample fileExample = new ShareDataFileExample();
        fileExample.createCriteria().andBusIdEqualTo(id)
                .andBusTypeEqualTo(FileBusType.DEMAND_APPLY_ACCORD.getVal());
        List<ShareDataFile> files = shareDataFileService.find(fileExample);

        detail.setFileList(dozerUtils.mapList(files, DemandFileDTO.class));
        return Result.success(detail);
    }

    /**
     * 描述：获取需求新增时公共信息
     * 参数：unitId：单位Id
     * 返回值：DemandHandleDetailDTO
     * 修改人：zhaopengfei
     * 修改时间：2018/4/21
     * 修改内容：
     */

    @ApiOperation(value = "获取需求新增时公共信息", notes = "获取需求新增时公共信息")
    @RequestMapping(value = "/demand/getaddinfo", method = RequestMethod.GET)
    public Result<DemandAddRequestDTO> getUnitName() {
        //基础数据获取
        Long userId = BaseContextHandler.getAdminId();
        //获取单位Id
        String unitId = commonService.getOrgIdByUserId(userId);
        //根据用户信息获取单位信息
        Map<String, Object> map = commonService.querDemandUnitInfoByUserId(userId);
        DemandAddRequestDTO dto = new DemandAddRequestDTO();
        dto.setOrgName(map.get("orgName").toString());
        dto.setUnitType(map.get("typeName").toString());
        dto.setLinkName(map.get("linkName").toString());
        dto.setLinkPhone(map.get("linkPhone").toString());
        return Result.success(dto);
    }
}
