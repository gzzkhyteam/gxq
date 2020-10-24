package com.hengyunsoft.platform.exchange.impl.directory;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hengyunsoft.base.Result;
import com.hengyunsoft.base.id.IdGenerate;
import com.hengyunsoft.commons.constant.SearchConstants;
import com.hengyunsoft.commons.context.BaseContextHandler;
import com.hengyunsoft.commons.context.CommonConstants;
import com.hengyunsoft.commons.exception.core.ExchangeExceptionCode;
import com.hengyunsoft.commons.utils.context.DozerUtils;
import com.hengyunsoft.page.plugins.openapi.OpenApiReq;
import com.hengyunsoft.platform.admin.api.core.api.GxqptEmpApi;
import com.hengyunsoft.platform.admin.api.core.api.GxqptOrgApi;
import com.hengyunsoft.platform.admin.api.core.dto.emp.GxqptEmpRetDTO;
import com.hengyunsoft.platform.admin.api.core.dto.org.GxqptOrgByExchangeReqDTO;
import com.hengyunsoft.platform.admin.api.core.dto.org.GxqptOrgResDTO;
import com.hengyunsoft.platform.commons.utils.TreeUtil;
import com.hengyunsoft.platform.exchange.api.directory.dto.directory.DataDirectoryAuditDTO;
import com.hengyunsoft.platform.exchange.api.directory.dto.directory.DataDirectoryAutomaticSaveDTO;
import com.hengyunsoft.platform.exchange.api.directory.dto.directory.DataDirectoryDTO;
import com.hengyunsoft.platform.exchange.api.directory.dto.directory.DataDirectoryDictDTO;
import com.hengyunsoft.platform.exchange.api.directory.dto.directory.DataDirectoryPageReqAuditDTO;
import com.hengyunsoft.platform.exchange.api.directory.dto.directory.DataDirectorySaveDTO;
import com.hengyunsoft.platform.exchange.api.directory.dto.directory.DataDirectoryTreeDTO;
import com.hengyunsoft.platform.exchange.api.directory.dto.directory.DataDirectoryUpdateDTO;
import com.hengyunsoft.platform.exchange.api.directory.dto.directory.ShareUnitDTO;
import com.hengyunsoft.platform.exchange.api.directory.dto.directory.VOrgDTO;
import com.hengyunsoft.platform.exchange.api.directory.dto.element.DataElementAutomaticSaveDTO;
import com.hengyunsoft.platform.exchange.api.flow.dto.ShareFlowAuditDTO;
import com.hengyunsoft.platform.exchange.constant.ExchangeConstants;
import com.hengyunsoft.platform.exchange.entity.api.po.ShareDataApi;
import com.hengyunsoft.platform.exchange.entity.directory.po.ShareDataChange;
import com.hengyunsoft.platform.exchange.entity.directory.po.ShareDataChangeElement;
import com.hengyunsoft.platform.exchange.entity.directory.po.ShareDataDirectory;
import com.hengyunsoft.platform.exchange.entity.directory.po.ShareDataDirectoryWare;
import com.hengyunsoft.platform.exchange.entity.directory.po.ShareDataElement;
import com.hengyunsoft.platform.exchange.entity.directory.po.ShareDataElementWare;
import com.hengyunsoft.platform.exchange.entity.directory.po.ShareUnit;
import com.hengyunsoft.platform.exchange.entity.directory.po.ShareUnitWare;
import com.hengyunsoft.platform.exchange.entity.directory.po.domain.ShareDataDirectoryAuditDO;
import com.hengyunsoft.platform.exchange.entity.directory.po.domain.ShareDataDirectoryDictDO;
import com.hengyunsoft.platform.exchange.repository.api.example.ShareDataApiExample;
import com.hengyunsoft.platform.exchange.repository.api.service.ShareDataApiService;
import com.hengyunsoft.platform.exchange.repository.common.service.CommonService;
import com.hengyunsoft.platform.exchange.repository.directory.example.ShareDataChangeElementExample;
import com.hengyunsoft.platform.exchange.repository.directory.example.ShareDataChangeExample;
import com.hengyunsoft.platform.exchange.repository.directory.example.ShareDataDirectoryExample;
import com.hengyunsoft.platform.exchange.repository.directory.example.ShareDataElementExample;
import com.hengyunsoft.platform.exchange.repository.directory.example.ShareUnitExample;
import com.hengyunsoft.platform.exchange.repository.directory.example.ShareUnitWareExample;
import com.hengyunsoft.platform.exchange.repository.directory.service.DataDirectoryService;
import com.hengyunsoft.platform.exchange.repository.directory.service.DataDirectoryWareService;
import com.hengyunsoft.platform.exchange.repository.directory.service.DataElementService;
import com.hengyunsoft.platform.exchange.repository.directory.service.DataElementWareService;
import com.hengyunsoft.platform.exchange.repository.directory.service.ShareDataChangeElementService;
import com.hengyunsoft.platform.exchange.repository.directory.service.ShareDataChangeService;
import com.hengyunsoft.platform.exchange.repository.directory.service.ShareUnitService;
import com.hengyunsoft.platform.exchange.repository.directory.service.ShareUnitWareService;
import com.hengyunsoft.platform.exchange.repository.system.dao.ShareFlowAuditMapper;
import com.hengyunsoft.platform.exchange.repository.system.dao.ShareFlowHiTaskMapper;
import com.hengyunsoft.platform.exchange.repository.system.example.ShareFlowAuditExample;
import com.hengyunsoft.platform.exchange.repository.system.service.ShareFlowAuditService;
import com.hengyunsoft.platform.exchange.repository.system.service.ShareFlowService;
import com.hengyunsoft.platform.exchange.repository.system.service.ShareJoinOrgService;
import com.hengyunsoft.platform.exchange.util.SearchQueueUtil;
import com.hengyunsoft.platform.exchange.util.ShareUtil;
import com.hengyunsoft.platform.exchange.utils.GxqPtRoleUnits;
import com.hengyunsoft.platform.exchange.utils.pinyin.Pinyin4jUtil;
import com.hengyunsoft.platform.search.queue.dto.DeleteIndexDTO;
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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.groups.Default;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@Slf4j
@RequestMapping("/directory")
@Api(value = "数据目录管理", description = "数据目录管理")
public class ShareDataDirectoryApiImpl /*implements DataDirectoryApi*/ {
    @Autowired
    IdGenerate<Long> idGenerate;
    @Autowired
    private DataDirectoryService dataDirectoryService;
    @Autowired
    private DataDirectoryWareService dataDirectoryWareService;
    @Autowired
    private ShareUnitService shareUnitService;
    @Autowired
    private DataElementService dataElementService;
    @Autowired
    private ShareDataChangeService shareDataChangeService;
    @Autowired
    private DozerUtils dozerUtils;
    @Autowired
    private ShareDataChangeElementService shareDataChangeElementService;
    @Autowired
    private CommonService commonService;
    @Autowired
    private ShareFlowAuditService shareFlowAuditService;
    @Autowired
    ShareJoinOrgService shareJoinOrgService;
    @Autowired
    private GxqPtRoleUnits gxqPtRoleUnits;

    @Autowired
    private ShareDataApiService shareDataApiService;
    @Autowired
    private ShareFlowService shareFlowService;
    @Autowired
    ShareFlowHiTaskMapper shareFlowHiTaskMapper;
    @Autowired
    ShareFlowAuditMapper shareFlowAuditMapper;
    @Autowired
    private ShareUnitWareService shareUnitWareService;
    @Autowired
    private DataElementWareService dataElementWareService;
    @Autowired
    private SearchQueueUtil searchQueueUtil;
    @Autowired
    GxqptOrgApi gxqptOrgApi;
    @Autowired
    GxqptEmpApi gxqptEmpApi;

    ShareUtil shareUtil;//applyCode工具类


    @ApiOperation(value = "查询目录审核结果", notes = "查询目录审核结果")
    @RequestMapping(value = "/findAudit", method = RequestMethod.GET)
    public Result<ShareFlowAuditDTO> findAudit(@RequestParam(value = "auditId") Long auditId) {
        if (null == auditId) {
            return Result.fail("审核id不能为空");
        }
        ShareFlowAuditExample example = new ShareFlowAuditExample();
        example.createCriteria().andIdEqualTo(auditId);
        ShareFlowAuditDTO dto = dozerUtils.map(shareFlowAuditService.getUnique(example), ShareFlowAuditDTO.class);
        return Result.success(dto);
    }


    @ApiOperation(value = "获取本单位外所有数据目录数", notes = "获取本单位外所有数据目录数")
    @RequestMapping(value = "/findAllDataTypeTree", method = RequestMethod.GET)
    public Result<List<DataDirectoryTreeDTO>> findAllDataTypeTree(@RequestParam(value = "dataType") Integer dataType) {
        Long adminId = BaseContextHandler.getAdminId();
        String unitId = commonService.getOrgIdByUserId(adminId);
        List<DataDirectoryTreeDTO> treeList = dozerUtils.mapList(dataDirectoryService.getDataTypeList(dataType, unitId), DataDirectoryTreeDTO.class);
        return Result.success(TreeUtil.queryTree(treeList, -1));
    }

    @ApiOperation(value = "获取非本单位外所有数据目录数,用于API申请功能", notes = "获取非本单位外所有数据目录数")
    @RequestMapping(value = "/findAllTreeUnUnit", method = RequestMethod.GET)
    public Result<List<DataDirectoryTreeDTO>> findAllTreeUnUnit() {
        Long adminId = BaseContextHandler.getAdminId();
        String unitId = commonService.getOrgIdByUserId(adminId);
        List<DataDirectoryTreeDTO> treeList = dozerUtils.mapList(dataDirectoryService.getAllTreeUnUnit(unitId), DataDirectoryTreeDTO.class);
        return Result.success(TreeUtil.queryTree(treeList, -1));
    }


    @ApiOperation(value = "判断是否单位管理员获取数据目录树", notes = "判断是否单位管理员获取数据目录树")
    @RequestMapping(value = "/findDataTree", method = RequestMethod.GET)
    public Result<List<DataDirectoryTreeDTO>> saveFindDataTree(@RequestParam(value = "unitId") String unitId) {
        if (null == unitId) {
            return Result.fail("单位id不能为空");
        }
        Boolean gxqPtAdmin;//是否是平台管理员
        Boolean unitAdmin;//是否是单位管理员
        Long adminId = BaseContextHandler.getAdminId();
        gxqPtAdmin = gxqPtRoleUnits.getGxqPtRole(adminId, GxqPtRoleUnits.PT_ADMIN_ROLE_CODE);
        Long pId = Long.valueOf(-1);
        if (gxqPtAdmin) {
            List<DataDirectoryTreeDTO> treeList = dozerUtils.mapList(dataDirectoryService.getAllList(), DataDirectoryTreeDTO.class);
            return Result.success(TreeUtil.queryTree(treeList, pId));
        } else {
            String strUnitId = commonService.getOrgIdByUserId(adminId);
            if (strUnitId == null) {
                return Result.fail("用户单位id不能为空");
            }
            unitAdmin = gxqPtRoleUnits.getGxqUnitRole(adminId, strUnitId);
            if (!unitAdmin) {
                return Result.fail("非单位管理员");
            }
            ShareDataDirectoryExample directoryExample = new ShareDataDirectoryExample();
            directoryExample.createCriteria().andParentIdEqualTo("-1").andUnitIdEqualTo(strUnitId);
            ShareDataDirectory directoryList = dataDirectoryService.getUnique(directoryExample);
            if (directoryList == null) {
                GxqptOrgByExchangeReqDTO orgByExchangeReqDTO = new GxqptOrgByExchangeReqDTO();
                orgByExchangeReqDTO.setId(strUnitId);
                Result<List<GxqptOrgResDTO>> orgList = gxqptOrgApi.findOrgByExchange(orgByExchangeReqDTO);
                ShareDataDirectory directory = new ShareDataDirectory();
                directory.setDirName(orgList.getData().get(0).getName());
                directory.setParentId("-1");
                directory.setDesc(orgList.getData().get(0).getName());
                directory.setUnitAbbr(orgList.getData().get(0).getName());
                directory.setDataStatus(1);
                directory.setUnitId(orgList.getData().get(0).getId());
                directory.setDirType(1);//目录标识:1,单位；2，数据目录',
                directory.setOptType(5);//操作类型(最近一次)：1,新增；2，修改；3，删除',
                directory.setStatus(4);//状态:1,未发布
                directory.setIsBottom(1);
                directory.setCreateUser(adminId);
                directory.setUpdateUser(adminId);
                dataDirectoryService.saveSelective(directory);
                ShareDataDirectoryWare shareDataDirectoryWare = dozerUtils.map(directory, ShareDataDirectoryWare.class);
                dataDirectoryWareService.saveWare(shareDataDirectoryWare);
            }
            List<DataDirectoryTreeDTO> treeList = dozerUtils.mapList(dataDirectoryService.getUnitDirectoryList(Long.valueOf(strUnitId)), DataDirectoryTreeDTO.class);
            return Result.success(TreeUtil.queryTree(treeList, pId));
        }
    }

    @ApiOperation(value = "根据数据类型dataType,并判断是否单位管理员获取数据目录树", notes = "根据数据类型dataType,并判断是否单位管理员获取数据目录树")
    @RequestMapping(value = "/findDataTypeTree", method = RequestMethod.GET)
    public Result<List<DataDirectoryTreeDTO>> findDataTypeTree(@RequestParam(value = "dataType") Integer dataType) {
        Long adminId = BaseContextHandler.getAdminId();
        Boolean isPtAdmin = gxqPtRoleUnits.getGxqPtRole(adminId, GxqPtRoleUnits.PT_ADMIN_ROLE_CODE);
        String unitId = commonService.getOrgIdByUserId(adminId);

        Long pId = Long.valueOf(-1);
        if (isPtAdmin) {
            List<DataDirectoryTreeDTO> treeList = dozerUtils.mapList(dataDirectoryService.getDataTypeList(dataType, null), DataDirectoryTreeDTO.class);
            return Result.success(TreeUtil.queryTree(treeList, pId));
        } else {
            if (unitId == null) {
                return Result.fail("用户单位id为空");
            }
            List<DataDirectoryTreeDTO> treeList = dozerUtils.mapList(dataDirectoryService.getUnitDataTypeList(Long.valueOf(unitId), dataType), DataDirectoryTreeDTO.class);
            return Result.success(TreeUtil.queryTree(treeList, pId));

        }
    }


    @ApiOperation(value = "查询数据目录分页信息", notes = "查询数据目录分页信息")
    @RequestMapping(value = "/page", method = RequestMethod.POST)
    public Result<PageInfo<DataDirectoryAuditDTO>> page(@RequestBody OpenApiReq<DataDirectoryPageReqAuditDTO> openApiReq) {
        Boolean gxqPtAdmin;//是否是平台管理员
        Boolean unitAdmin;//是否是单位管理员
        Long adminId = BaseContextHandler.getAdminId();
        gxqPtAdmin = gxqPtRoleUnits.getGxqPtRole(adminId, GxqPtRoleUnits.PT_ADMIN_ROLE_CODE);
        String unitId = commonService.getOrgIdByUserId(adminId);
        if (gxqPtAdmin) {
            unitId = null;
        } else {
            if (unitId == null) {
                return Result.fail("用户单位id为空");
            }
            unitAdmin = gxqPtRoleUnits.getGxqUnitRole(adminId, unitId);
            if (!unitAdmin) {
                return Result.fail("非单位管理员");
            }
        }
        Map map = new HashMap<>();
        map.put("unitId", unitId);
        map.put("status", openApiReq.getData().getStatus());
        map.put("startTime", openApiReq.getData().getStartTime());
        map.put("endTime", openApiReq.getData().getEndTime());
        PageHelper.startPage(openApiReq.getPageNo(), openApiReq.getPageSize());
        List<ShareDataDirectoryAuditDO> results = dataDirectoryService.getDirectoryTask(map);
        // List<DataDirectoryAuditDTO> ts = dozerUtils.mapList(results, DataDirectoryAuditDTO.class);
        PageInfo<DataDirectoryAuditDTO> pageDTO = new PageInfo<>(dozerUtils.mapPage(results, DataDirectoryAuditDTO.class));
        if (pageDTO != null && pageDTO.getList() != null && pageDTO.getList().size() > 0) {
            List<Long> ids = new ArrayList<>();
            for (DataDirectoryAuditDTO auditDTO : pageDTO.getList()) {
                Long personId = auditDTO.getUserId();
                ids.add(personId);
            }
            Result<List<GxqptEmpRetDTO>> empUser = gxqptEmpApi.findByIdsGxqptUserName(ids);
            for (DataDirectoryAuditDTO managementDTO : pageDTO.getList()) {
                for (GxqptEmpRetDTO empRetDTO : empUser.getData()) {
                    if (empRetDTO.getGxqptEmpId().equals(managementDTO.getUserId())) {
                        managementDTO.setUserName(empRetDTO.getName());
                        managementDTO.setDeptName(empRetDTO.getMaindeptname());
                    }
                }
            }
        }

        return Result.success(pageDTO);
    }


    @ApiOperation(value = "修改数据目录单位信息", notes = "修改数据目录单位信息")
    @ApiResponses({
            @ApiResponse(code = 85001, message = "单位名称不允许为空"),
            @ApiResponse(code = 85002, message = "单位简称不允许为空"),
            @ApiResponse(code = 85003, message = "单位标识不允许为空"),
    })
    @RequestMapping(value = "/updateUnit", method = RequestMethod.POST)
    public Result<Boolean> updateUnit(@RequestBody DataDirectoryUpdateDTO dto) {
        //1.校验
        BizAssert.assertNotNull(ExchangeExceptionCode.DIRECTORY_NAME_NULL, dto.getDirName());
        BizAssert.assertNotNull(ExchangeExceptionCode.DIRECTORY_CODE_NULL, dto.getDirCode());
        BizAssert.assertNotNull(ExchangeExceptionCode.DIRECTORY_TYPE_NULL, dto.getDirType());
        //2.转换
        ShareDataDirectory dataDirectory = dozerUtils.map(dto, ShareDataDirectory.class);
        Long adminId = BaseContextHandler.getAdminId();
        dataDirectory.setOptType(2);//操作类型(最近一次)：1,新增；2，修改；3，删除；4，禁用',
        dataDirectory.setStatus(1);//状态:1,未发布
        dataDirectory.setUpdateUser(Long.valueOf(adminId));
        //4.保存
        dataDirectoryService.updateByIdSelective(dataDirectory);
        return Result.success(true);

    }

    @ApiOperation(value = "保存数据目录信息", notes = "保存数据目录信息")
    @ApiResponses({
            @ApiResponse(code = 85001, message = "数据目录不允许为空"),
            @ApiResponse(code = 85002, message = "数据目录简称不允许为空"),
            @ApiResponse(code = 85011, message = "数据目录父id不允许为空"),
    })
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    @ValidatorStandard(
            {
                    @Constraint(value = ShareDataDirectory.class, groups = {Default.class, ValidatorGroups.MustNoneNull.class})
            }
    )
    public Result<DataDirectoryDTO> save(@RequestBody DataDirectorySaveDTO dto) {
        //1.校验
        BizAssert.assertNotNull(ExchangeExceptionCode.DIRECTORY_NAME_NULL, dto.getDirName());
        BizAssert.assertNotNull(ExchangeExceptionCode.DIRECTORY_TYPE_NULL, dto.getDirType());
        //2.转换
        ShareDataDirectory dataDirectory = dozerUtils.map(dto, ShareDataDirectory.class);

        //3.数据处理
        if (dto.getParentId() == null || dto.getParentId() <= 0) {
            dto.setParentId(CommonConstants.PARENT_ID_DEF);
        } else {
            ShareDataDirectoryExample example = new ShareDataDirectoryExample();
            example.createCriteria().andIdEqualTo(dto.getParentId());
            ShareDataDirectory parent = dataDirectoryService.getUnique(example);
            BizAssert.assertNotNull(ExchangeExceptionCode.DIRECTORY_PARENTID_NULL, parent);
        }
        Long adminId = BaseContextHandler.getAdminId();
        List<String> unitIds = dto.getUnitIds();
        String applyCode = shareUtil.automaticCode("MU");
        try {
            dataDirectory.setApplyCode(applyCode);
            dataDirectory.setDirType(2);//目录标识:1,单位；2，数据目录',
            dataDirectory.setOptType(1);//操作类型(最近一次)：1,新增；2，修改；3，删除',
            dataDirectory.setDataStatus(1);
            dataDirectory.setStatus(1);//状态:1,未发布
            // 目录编码(单位的首字母缩写)
            dataDirectory.setDirCode(Pinyin4jUtil.getPinYinHeadChar(dto.getDirName()).toUpperCase());
            dataDirectory.setCreateUser(Long.valueOf(adminId));
            dataDirectory.setUpdateUser(Long.valueOf(adminId));
            //4.保存数据目录表
            dataDirectory = dataDirectoryService.saveSelective(dataDirectory);

            //5,添加接入部门
            shareJoinOrgService.insertJoinOrg(dataDirectory.getUnitId(), adminId);

            ShareDataChangeExample ChangeExample = new ShareDataChangeExample();
            ChangeExample.createCriteria().andUnitIdEqualTo(dataDirectory.getUnitId()).andStatusEqualTo(1);
            ShareDataChange dataChange = shareDataChangeService.getUnique(ChangeExample);
            ShareDataChange change = new ShareDataChange();
            ShareDataChangeElement changeElement = new ShareDataChangeElement();
            if (dataChange == null) {
                change.setUnitId(dataDirectory.getUnitId());
                change.setUserId(adminId);
                change.setStatus(1);
                change.setOptTime(new Date());
                change.setApplyCode(applyCode);
                change.setCreateUser(adminId);
                change.setUpdateUser(adminId);
                //保存数据目录变动主表
                shareDataChangeService.saveSelective(change);
                changeElement.setBusId(change.getId());
            } else {
                changeElement.setBusId(dataChange.getId());
            }
            changeElement.setBusType(1);
            changeElement.setChangeType(1);
            changeElement.setChgId(dataDirectory.getId());
            changeElement.setCreateUser(adminId);
            changeElement.setUpdateUser(adminId);
            shareDataChangeElementService.saveSelective(changeElement);

            List<ShareUnit> shareUnitList = new ArrayList<>();
            if (dto.getIsBottom() == 2 && unitIds != null && !unitIds.isEmpty()) {
                for (String id : dto.getUnitIds()) {
                    ShareUnit shareUnit = new ShareUnit();
                    shareUnit.setId(idGenerate.generate());
                    shareUnit.setUnitId(id);
                    shareUnit.setOptType(1);
                    shareUnit.setDirId(dataDirectory.getId());
                    shareUnit.setCreateUser(Long.valueOf(adminId));
                    shareUnit.setCreateTime(new Date());
                    shareUnit.setUpdateTime(new Date());
                    shareUnit.setUpdateUser(Long.valueOf(adminId));
                    shareUnitList.add(shareUnit);
                }
                shareUnitService.batchSave(shareUnitList);
            }
        } catch (Exception e) {
            log.error("异常", e);
            throw e;
        }
        return Result.success(dozerUtils.map(dataDirectory, DataDirectoryDTO.class));
    }


    @ApiOperation(value = "修改数据目录信息", notes = "修改数据目录信息")
    @ApiResponses({
            @ApiResponse(code = 85001, message = "数据目录不允许为空"),
            @ApiResponse(code = 85003, message = "数据目录标识不允许为空")
    })
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    @ValidatorStandard(
            {
                    @Constraint(value = ShareDataDirectory.class)
            }
    )
    public Result<Boolean> update(@RequestBody DataDirectoryUpdateDTO dto) {
        //1.校验
        BizAssert.assertNotNull(ExchangeExceptionCode.DIRECTORY_NAME_NULL, dto.getDirName());
        BizAssert.assertNotNull(ExchangeExceptionCode.DIRECTORY_TYPE_NULL, dto.getDirType());
        //2.转换
        ShareDataDirectory dataDirectory = dozerUtils.map(dto, ShareDataDirectory.class);
        ShareDataElementExample eleExample = new ShareDataElementExample();
        eleExample.createCriteria().andDirIdEqualTo(dataDirectory.getId());
        List<ShareDataElement> dataElement = dataElementService.find(eleExample);
        if (dataDirectory.getIsBottom() == 2) {
            if (dataDirectory.getDataType() == 2 && dataElement != null && !dataElement.isEmpty()) {
                return Result.fail("已存在元数据字段，数据类型不能修改成非结构化");
            }
        }
        Long adminId = BaseContextHandler.getAdminId();
        try {
            ShareDataDirectoryWare ware = dataDirectoryWareService.getById(dataDirectory.getId());
            if (ware != null) {//已发布过的目录
                List<String> unitIds = dto.getUnitIds();
                List<ShareUnit> insertUnitList = new ArrayList<>();
                if (unitIds != null && !unitIds.isEmpty()) {//前端选择单位
                    for (int i = 0; i < unitIds.size(); i++) {
                        ShareUnitExample unitExample = new ShareUnitExample();
                        unitExample.createCriteria().andDirIdEqualTo(dto.getId()).andUnitIdEqualTo(unitIds.get(i));
                        List<ShareUnit> unit = shareUnitService.find(unitExample);
                        if (unit.size() == 0) {
                            ShareUnit insertUnit = new ShareUnit();
                            insertUnit.setUnitId(unitIds.get(i));
                            insertUnit.setOptType(1);//新增
                            insertUnit.setDirId(dataDirectory.getId());
                            insertUnit.setCreateUser(Long.valueOf(adminId));
                            insertUnit.setId(idGenerate.generate());
                            insertUnit.setCreateTime(new Date());
                            insertUnit.setUpdateTime(new Date());
                            insertUnit.setUpdateUser(Long.valueOf(adminId));
                            insertUnitList.add(insertUnit);
                        }
                    }
                    if (insertUnitList != null && !insertUnitList.isEmpty()) {
                        shareUnitService.batchSave(insertUnitList);//批量新增
                    }
                    ShareUnitExample dwExample = new ShareUnitExample();
                    dwExample.createCriteria().andDirIdEqualTo(dto.getId());
                    List<ShareUnit> shareUnitList = shareUnitService.find(dwExample);
                    List<String> oldUnitListId = new ArrayList<>(); //已发布目录共享单位列表
                    if (shareUnitList != null && shareUnitList.size() != 0) {
                        for (int j = 0; j < shareUnitList.size(); j++) {
                            oldUnitListId.add(shareUnitList.get(j).getUnitId());
                        }
                    }
                    List<ShareUnit> deleteUnitList = new ArrayList<>();
                    ShareUnit delUnit;
                    List<ShareUnit> deleteList;
                    for (String strUnitIds : oldUnitListId) {
                        if (!unitIds.contains(strUnitIds)) {//修改时unitIds中没有的单位id，执行删除操作（OptType=3）
                            ShareUnitExample e = new ShareUnitExample();
                            e.createCriteria().andDirIdEqualTo(dto.getId()).andUnitIdEqualTo(strUnitIds);
                            deleteList = shareUnitService.find(e);
                            delUnit = shareUnitService.getById(deleteList.get(0).getId());
                            delUnit.setOptType(3);//删除
                            delUnit.setUpdateTime(new Date());
                            delUnit.setUpdateUser(Long.valueOf(adminId));
                            deleteUnitList.add(delUnit);
                        }
                    }
                    if (deleteUnitList != null && !deleteUnitList.isEmpty()) {
                        shareUnitService.batchUpdate(deleteUnitList);
                    }

                } else {//前端选择的单位为空
                    ShareUnitExample unitExample = new ShareUnitExample();
                    unitExample.createCriteria().andDirIdEqualTo(dto.getId());
                    List<ShareUnit> shareUnitList = shareUnitService.find(unitExample);
                    List<ShareUnit> deleteShareUnitList = new ArrayList<>();
                    ShareUnit deleteUnit;
                    if (shareUnitList != null && shareUnitList.size() != 0) {
                        for (int i = 0; i < shareUnitList.size(); i++) {
                            deleteUnit = shareUnitService.getById(shareUnitList.get(i).getId());
                            deleteUnit.setOptType(3);//删除
                            deleteUnit.setUpdateTime(new Date());
                            deleteUnit.setUpdateUser(Long.valueOf(adminId));
                            deleteShareUnitList.add(deleteUnit);
                        }
                        shareUnitService.batchUpdate(deleteShareUnitList);
                    }
                }

                //未发布过的目录
            } else {
                ShareUnitExample unitExample = new ShareUnitExample();
                unitExample.createCriteria().andDirIdEqualTo(dto.getId());
                List<ShareUnit> shareUnitList = shareUnitService.find(unitExample);
                if (shareUnitList != null && !shareUnitList.isEmpty()) {
                    for (int i = 0; i < shareUnitList.size(); i++) {
                        shareUnitService.deleteById(shareUnitList.get(i).getId());
                    }
                }
                List<ShareUnit> insertUnitList = new ArrayList<>();
                List<String> unitIds = dto.getUnitIds();
                if (unitIds != null && !unitIds.isEmpty()) {
                    for (String unit_Id : dto.getUnitIds()) {
                        ShareUnit shareUnit = new ShareUnit();
                        shareUnit.setId(idGenerate.generate());
                        shareUnit.setCreateTime(new Date());
                        shareUnit.setUpdateTime(new Date());
                        shareUnit.setOptType(1);
                        shareUnit.setUnitId(unit_Id);
                        shareUnit.setDirId(dataDirectory.getId());
                        shareUnit.setCreateUser(Long.valueOf(adminId));
                        shareUnit.setUpdateUser(Long.valueOf(adminId));
                        insertUnitList.add(shareUnit);
                    }
                    shareUnitService.batchSave(insertUnitList);
                }
            }

            dataDirectory.setDirType(2);//目录标识:1,单位；2，数据目录',
            if (ware != null) {
                dataDirectory.setOptType(2);//操作类型(最近一次)：1,新增；2，修改；3，删除；4，禁用',
            } else {
                dataDirectory.setOptType(1);//操作类型(最近一次)：1,新增；2，修改；3，删除；4，禁用',
            }
            dataDirectory.setStatus(1);//状态:1,未发布
            dataDirectory.setCreateUser(Long.valueOf(adminId));
            dataDirectory.setUpdateUser(Long.valueOf(adminId));
            //4.保存
            dataDirectoryService.updateByIdSelective(dataDirectory);
            ShareDataChangeExample example = new ShareDataChangeExample();
            example.createCriteria().andUnitIdEqualTo(dataDirectory.getUnitId()).andStatusEqualTo(1);
            ShareDataChange dataChange = shareDataChangeService.getUnique(example);
            ShareDataChange change = new ShareDataChange();
            ShareDataChangeElement changeElement = new ShareDataChangeElement();
            if (dataChange == null) {
                change.setUnitId(dataDirectory.getUnitId());
                change.setUserId(adminId);
                change.setStatus(1);
                change.setOptTime(new Date());
                change.setApplyCode(dataDirectory.getApplyCode());
                change.setCreateUser(adminId);
                change.setUpdateUser(adminId);
                //保存数据目录变动主表
                shareDataChangeService.saveSelective(change);
                changeElement.setBusId(change.getId());
                changeElement.setBusType(1);
                changeElement.setChangeType(2);
                changeElement.setChgId(dataDirectory.getId());
                changeElement.setCreateUser(adminId);
                changeElement.setUpdateUser(adminId);
                shareDataChangeElementService.saveSelective(changeElement);
            } else {
                ShareDataChangeElementExample elementExample = new ShareDataChangeElementExample();
                elementExample.createCriteria().andChgIdEqualTo(dataDirectory.getId()).andBusIdEqualTo(dataChange.getId()).andBusTypeEqualTo(1);
                ShareDataChangeElement dataChangeElement = shareDataChangeElementService.getUnique(elementExample);
                if (dataChangeElement == null) {
                    ShareDataChangeElement shareDataChangeElement = new ShareDataChangeElement();
                    shareDataChangeElement.setBusId(dataChange.getId());
                    shareDataChangeElement.setBusType(1);
                    shareDataChangeElement.setChangeType(2);
                    shareDataChangeElement.setChgId(dataDirectory.getId());
                    shareDataChangeElement.setCreateUser(adminId);
                    shareDataChangeElement.setUpdateUser(adminId);
                    shareDataChangeElementService.saveSelective(shareDataChangeElement);
                } else {
                    dataChangeElement.setChangeType(2);
                    dataChangeElement.setUpdateUser(adminId);
                    //保存目录及字段变动表
                    shareDataChangeElementService.updateByIdSelective(dataChangeElement);
                }
            }
        } catch (Exception ex) {
            log.error("e", ex);
            throw ex;
        }
        return Result.success(true);
    }


    @ApiOperation(value = "目录发布申请(平台管理员直接发布)", notes = "目录发布申请(平台管理员直接发布)")
    @RequestMapping(value = "/updateRasons", method = RequestMethod.POST)
    public Result<Boolean> updateRasons(@RequestParam(value = "unitId") String unitId, @RequestParam(value = "reasons") String reasons) {
        Boolean gxqPtAdmin;//平台管理员直接发布
        Long userId = BaseContextHandler.getAdminId();
        gxqPtAdmin = gxqPtRoleUnits.getGxqPtRole(userId, GxqPtRoleUnits.PT_ADMIN_ROLE_CODE);
        ShareDataChangeExample example = new ShareDataChangeExample();
        example.createCriteria().andUnitIdEqualTo(unitId).andStatusEqualTo(1);
        ShareDataChange dataChange = shareDataChangeService.getUnique(example);
        try {
            if (dataChange != null) {
                dataChange.setApplicationReasons(reasons);
                dataChange.setUpdateUser(userId);
                dataChange.setOptTime(new Date());
                dataChange.setIsPtadmin(2);
                //如果是平台管理员直接发布,无需走审批流程
                if (gxqPtAdmin) {
                    //查询所有变动的目录
                    List<ShareDataChangeElement> eltList = shareDataChangeElementService.findChangeEmtList(unitId, dataChange.getApplyCode(), 2);
                    List<ShareDataChangeElement> dirList = shareDataChangeElementService.findChangeEmtList(unitId, dataChange.getApplyCode(), 1);
                    //是字段
                    if (eltList != null && !eltList.isEmpty()) {
                        List<ShareDataElement> updateElementList = new ArrayList<>();
                        List<ShareDataElementWare> addWereElementList = new ArrayList<>();
                        List<ShareDataElementWare> updateWereElementList = new ArrayList<>();
                        for (ShareDataChangeElement element : eltList) {
                            ShareDataElement shareDataElement = dataElementService.getById(element.getChgId());
                            if (shareDataElement != null) {
                                if (element.getChangeType() == 1) {//1,新增
                                    shareDataElement.setOptType(5);//操作类型(最近一次)：1,新增；2，修改；3，删除；
                                } else if (element.getChangeType() == 3) {//删除
                                    shareDataElement.setDataStatus(2);
                                    shareDataElement.setOptType(3);
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
                        if (updateElementList != null && !updateElementList.isEmpty()) {
                            dataElementService.batchUpdate(updateElementList);//批量更新字段信息
                        }
                        if (addWereElementList != null && !addWereElementList.isEmpty()) {
                            dataElementWareService.batchSave(addWereElementList);//新增字段信息到字段发布表
                        }
                        if (updateWereElementList != null && !updateWereElementList.isEmpty()) {
                            dataElementWareService.batchUpdate(updateWereElementList);//批量更新字段信息到发布表
                        }
                    }
                    //是目录
                    if (dirList != null && !dirList.isEmpty()) {
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
                                        String content = dataDirectory.getDesc();
                                        if (content == null || content == "") {
                                            content = dataDirectory.getDirName();
                                        }
                                        String url = "/module/index?promUrl=/gxqpt-exchange/module/generalView?id=";
                                        ShareDataDirectoryExample unitExample = new ShareDataDirectoryExample();
                                        unitExample.createCriteria().andUnitIdEqualTo(dataDirectory.getUnitId()).andParentIdEqualTo("-1");
                                        ShareDataDirectory unitDir = dataDirectoryService.getUnique(unitExample);
                                        String title = unitDir.getDirName() + "-" + dataDirectory.getDirName();
                                        searchQueueUtil.saveOrUpdateIndex(searchQueueUtil.covertIndexItemDto(bizId, content, title, url, SearchConstants.GXQPT_PORTAL_SEARCH_TYPE_DATA_TREE));

                                        shareDataApiService.addApiByDirAdd(dataDirectory.getId(), dataDirectory.getDirName(), dataDirectory.getUnitId(), filedIds, unitIds);
                                    }
                                } else if (element.getChangeType() == 2) {//2修改
                                    if (dataDirectory.getIsBottom() == 2) {
                                        shareDataApiService.addApiByDirAdd(dataDirectory.getId(), dataDirectory.getDirName(), dataDirectory.getUnitId(), filedIds, unitIds);
                                    }
                                } else if (element.getChangeType() == 3) {//3删除
                                    dataDirectory.setDataStatus(2);
                                    dataDirectory.setOptType(3);
                                    if (dataDirectory.getIsBottom() == 2) {
                                        //删除目录调用禁用api
                                        shareDataApiService.deleteApiByDeleteDir(dataDirectory.getId());
                                        //删除门户快速搜索索引
                                        DeleteIndexDTO indexDTO = new DeleteIndexDTO();
                                        indexDTO.setCollection(SearchConstants.GXQPT_PORTAL_SEARCH_INDEX_SET);
                                        indexDTO.setId(SearchConstants.GXQPT_PORTAL_SEARCH_TYPE_DATA_TREE + "_" + dataDirectory.getId().toString());
                                        searchQueueUtil.deleteIndex(indexDTO); //删除索引
                                    }
                                } else if (element.getChangeType() == 4) {//禁用
                                    dataDirectory.setOptType(4);
                                    dataDirectory.setDataStatus(3);
                                    if (dataDirectory.getIsBottom() == 2) {
                                        //删除门户快速搜索索引
                                        DeleteIndexDTO indexDTO = new DeleteIndexDTO();
                                        indexDTO.setCollection(SearchConstants.GXQPT_PORTAL_SEARCH_INDEX_SET);
                                        indexDTO.setId(SearchConstants.GXQPT_PORTAL_SEARCH_TYPE_DATA_TREE + "_" + dataDirectory.getId().toString());
                                        searchQueueUtil.deleteIndex(indexDTO); //删除索引
                                        ShareDataApiExample dataApiExample = new ShareDataApiExample();
                                        dataApiExample.createCriteria().andDirIdEqualTo(dataDirectory.getId()).andApiStatusEqualTo(1);
                                        List<ShareDataApi> apiList = shareDataApiService.find(dataApiExample);
                                        List<ShareDataApi> updateApiList = new ArrayList<>();
                                        if (apiList != null && apiList.size() > 0) {
                                            for (ShareDataApi dataApi : apiList) {
                                                dataApi.setApiStatus(2);
                                                dataApi.setUpdateTime(new Date());
                                                dataApi.setUpdateUser(userId);
                                                updateApiList.add(dataApi);

                                                //增加门户快速搜索索引，为禁用时，删除索引
                                                DeleteIndexDTO deleteIndexDTO = new DeleteIndexDTO();
                                                deleteIndexDTO.setId(SearchConstants.GXQPT_PORTAL_SEARCH_TYPE_GXJH_API + "_" + dataApi.getId().toString());
                                                deleteIndexDTO.setCollection(SearchConstants.GXQPT_PORTAL_SEARCH_INDEX_SET);
                                                searchQueueUtil.deleteIndex(deleteIndexDTO); //删除索引
                                            }
                                            shareDataApiService.batchUpdate(updateApiList);
                                        }
                                    }
                                } else if (element.getChangeType() == 6) {//启用
                                    dataDirectory.setOptType(5);
                                    dataDirectory.setDataStatus(1);
                                    if (dataDirectory.getIsBottom() == 2) {
                                        //增加门户快速搜索索引
                                        String bizId = dataDirectory.getId().toString();
                                        String content = dataDirectory.getDesc();
                                        if (content == null || content == "") {
                                            content = dataDirectory.getDirName();
                                        }
                                        ShareDataDirectoryExample unitExample = new ShareDataDirectoryExample();
                                        unitExample.createCriteria().andUnitIdEqualTo(dataDirectory.getUnitId()).andParentIdEqualTo("-1");
                                        ShareDataDirectory unitDir = dataDirectoryService.getUnique(unitExample);
                                        String title = unitDir.getDirName() + "-" + dataDirectory.getDirName();
                                        String type = SearchConstants.GXQPT_PORTAL_SEARCH_TYPE_DATA_TREE;
                                        String url = "/module/index?promUrl=/gxqpt-exchange/module/generalView?id=";
                                        searchQueueUtil.saveOrUpdateIndex(searchQueueUtil.covertIndexItemDto(bizId, content, title, url, type));
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
                                    shareDataDirectoryWare.setId(dataDirectory.getId());
                                    addWareDirectoryList.add(shareDataDirectoryWare);
                                } else {
                                    updateWareDirectoryList.add(shareDataDirectoryWare);
                                }
                                //是元目录才有共享单位
                                if (dataDirectory.getIsBottom() == 2) {
                                    //删除之前的共享单位
                                    ShareUnitExample unitExample = new ShareUnitExample();
                                    shareUnitWareService.deleteWareByDirId(dataDirectory.getId());
                                    unitExample.createCriteria().andDirIdEqualTo(dataDirectory.getId());
                                    List<ShareUnit> unitList = shareUnitService.find(unitExample);
                                    List<ShareUnitWare> warList = dozerUtils.mapList(unitList, ShareUnitWare.class);
                                    //添加新的共享单位
                                    if (warList != null && warList.size() > 0) {
                                        shareUnitWareService.batchSave(warList);//批量保存
                                    }
                                }
                            }
                        }
                        if (updateDirectoryList != null && !updateDirectoryList.isEmpty()) {
                            dataDirectoryService.batchUpdate(updateDirectoryList);//批量更新目录信息表
                        }
                        if (addWareDirectoryList != null && !addWareDirectoryList.isEmpty()) {
                            dataDirectoryWareService.batchSave(addWareDirectoryList);//批量保存目录信息表（发布表）
                        }
                        if (updateWareDirectoryList != null && !updateWareDirectoryList.isEmpty()) {
                            dataDirectoryWareService.batchUpdate(updateWareDirectoryList);//批量更新目录信息表（发布表）
                        }
                    }
                    //更新api
                    List<ShareDataDirectory> list = dataDirectoryService.getChangeDirListByApplyCode(unitId, dataChange.getApplyCode());
                    if (list != null && list.size() > 0) {
                        for (ShareDataDirectory dir : list) {
                            //根据目录id查询共享单位
                            List<String> dList = shareUnitService.getUnitListByDirId(dir.getId());
                            //根据目录id查询字段
                            List<Long> fList = dataElementService.getEltListByDirId(dir.getId());
                            shareDataApiService.addApiByDirAdd(dir.getId(), dir.getDirName(), dir.getUnitId(), fList, dList);
                        }
                    }
                    //更新变动表
                    dataChange.setStatus(3);
                    dataChange.setIsPtadmin(1);
                    shareDataChangeService.updateByIdSelective(dataChange);
                    Result.success(true);
                } else {//不是平台管理员则需要走审批流程
                    dataChange.setStatus(4);
                    shareDataChangeService.updateByIdSelective(dataChange);
                    shareFlowService.saveStartFlow(1, dataChange.getApplyCode(), ExchangeConstants.FLOW_DIR_CODE, userId, unitId);
                }
            } else {
                return Result.fail("暂无需要发布的目录");
            }
        } catch (Exception e) {
            log.error("e", e);
            throw e;
        }
        return Result.success(true);
    }


    @ApiOperation(value = "目录禁用", notes = "目录禁用")
    @RequestMapping(value = "/disable", method = RequestMethod.POST)
    public Result<Boolean> disable(@RequestParam(value = "dirId") Long dirId) {
        //2.转换
        Long adminId = BaseContextHandler.getAdminId();
        try {
            ShareDataDirectory dataDirectory = dataDirectoryService.getById(dirId);
            ShareDataDirectoryWare ware = dataDirectoryWareService.getById(dirId);
            if (dataDirectory.getOptType() == 4 && ware.getOptType() == 5) {
                return Result.fail("目录发布后再启用");
            }
            dataDirectory.setOptType(4);//操作类型(最近一次)：1,新增；2，修改；3，删除；4，禁用',5，正常,6,启用',
            dataDirectory.setStatus(1);
            dataDirectory.setUpdateUser(Long.valueOf(adminId));
            dataDirectoryService.updateByIdSelective(dataDirectory);

            String applyCode = shareUtil.automaticCode("MU");
            ShareDataChangeExample ChangeExample = new ShareDataChangeExample();
            ChangeExample.createCriteria().andUnitIdEqualTo(dataDirectory.getUnitId()).andStatusEqualTo(1);
            ShareDataChange dataChange = shareDataChangeService.getUnique(ChangeExample);
            ShareDataChange change = new ShareDataChange();
            ShareDataChangeElement changeElement = new ShareDataChangeElement();
            Long changeId;
            //如果为空需要生成变动流程
            if (dataChange != null) {
                changeId = dataChange.getId();
                changeElement.setBusId(changeId);
                changeElement.setBusType(1);
                changeElement.setChangeType(4);
                changeElement.setChgId(dataDirectory.getId());
                changeElement.setCreateUser(adminId);
                changeElement.setUpdateUser(adminId);
                shareDataChangeElementService.saveSelective(changeElement);
            } else {
                change.setUnitId(dataDirectory.getUnitId());
                change.setUserId(adminId);
                change.setStatus(1);
                change.setOptTime(new Date());
                change.setApplyCode(applyCode);
                change.setCreateUser(adminId);
                change.setUpdateUser(adminId);
                //保存数据目录变动主表
                shareDataChangeService.saveSelective(change);
                changeId = change.getId();
                changeElement.setBusId(changeId);
                changeElement.setBusType(1);
                changeElement.setChangeType(4);
                changeElement.setChgId(dataDirectory.getId());
                changeElement.setCreateUser(adminId);
                changeElement.setUpdateUser(adminId);
                shareDataChangeElementService.saveSelective(changeElement);
            }

            //更新子目录及元数据为状态禁用
            List<ShareDataDirectory> treeList = dozerUtils.mapList(dataDirectoryService.getDirectoryList(dirId), ShareDataDirectory.class);
            if (treeList != null && treeList.size() > 0) {
                List<ShareDataChangeElement> changeEleList = new ArrayList<>();
                List<ShareDataDirectory> updateDirectoryList = new ArrayList<>();
                for (ShareDataDirectory directory : treeList) {
                    directory.setOptType(4);//操作类型(最近一次)：1,新增；2，修改；3，删除；4，禁用',5，正常,6,启用',
                    directory.setStatus(1);
                    directory.setUpdateTime(new Date());
                    directory.setUpdateUser(Long.valueOf(adminId));
                    updateDirectoryList.add(directory);

                    ShareDataChangeElement chElement = new ShareDataChangeElement();
                    chElement.setBusId(changeId);
                    chElement.setBusType(1);
                    chElement.setChangeType(4);
                    chElement.setChgId(directory.getId());
                    chElement.setId(idGenerate.generate());
                    chElement.setCreateTime(new Date());
                    chElement.setUpdateTime(new Date());
                    chElement.setCreateUser(adminId);
                    chElement.setUpdateUser(adminId);
                    changeEleList.add(chElement);

                    ShareDataElementExample e = new ShareDataElementExample();
                    e.createCriteria().andDirIdEqualTo(directory.getId());
                    List<ShareDataElement> dataElement = dataElementService.find(e);
                    List<ShareDataChangeElement> changeElementList = new ArrayList<>();
                    List<ShareDataElement> updateElementList = new ArrayList<>();
                    if (dataElement != null && !dataElement.isEmpty()) {
                        for (int i = 0; i < dataElement.size(); i++) {
                            dataElement.get(i).setStatus(1);
                            dataElement.get(i).setOptType(4);
                            dataElement.get(i).setUpdateUser(adminId);
                            updateElementList.add(dataElement.get(i));

                            ShareDataChangeElement zdElement = new ShareDataChangeElement();
                            Long chgId = dataElement.get(i).getId();
                            zdElement.setBusId(changeId);
                            zdElement.setBusType(2);
                            zdElement.setChangeType(4);
                            zdElement.setChgId(chgId);
                            zdElement.setId(idGenerate.generate());
                            zdElement.setCreateTime(new Date());
                            zdElement.setUpdateTime(new Date());
                            zdElement.setCreateUser(adminId);
                            zdElement.setUpdateUser(adminId);
                            changeElementList.add(zdElement);
                        }
                        dataElementService.batchUpdate(updateElementList);
                        shareDataChangeElementService.batchSave(changeElementList);
                    }
                }
                //4.保存
                dataDirectoryService.batchUpdate(updateDirectoryList);
                shareDataChangeElementService.batchSave(changeEleList);
            } else {
                ShareDataElementExample ex = new ShareDataElementExample();
                ex.createCriteria().andDirIdEqualTo(dataDirectory.getId());
                List<ShareDataElement> entityElement = dataElementService.find(ex);
                List<ShareDataChangeElement> dataChangeElementList = new ArrayList<>();
                List<ShareDataElement> updateEleList = new ArrayList<>();
                if (entityElement != null && !entityElement.isEmpty()) {
                    for (int i = 0; i < entityElement.size(); i++) {
                        entityElement.get(i).setStatus(1);
                        entityElement.get(i).setOptType(4);
                        entityElement.get(i).setUpdateTime(new Date());
                        entityElement.get(i).setUpdateUser(adminId);
                        updateEleList.add(entityElement.get(i));

                        ShareDataChangeElement zd = new ShareDataChangeElement();
                        Long chgId = entityElement.get(i).getId();
                        zd.setBusType(2);
                        zd.setBusId(changeId);
                        zd.setChangeType(4);
                        zd.setChgId(chgId);
                        zd.setId(idGenerate.generate());
                        zd.setCreateTime(new Date());
                        zd.setUpdateTime(new Date());
                        zd.setCreateUser(adminId);
                        zd.setUpdateUser(adminId);
                        dataChangeElementList.add(zd);
                    }
                    dataElementService.batchUpdate(updateEleList);
                    shareDataChangeElementService.batchSave(dataChangeElementList);
                }
            }
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
        return Result.success(true);

    }


    @ApiOperation(value = "目录启用", notes = "目录启用")
    @RequestMapping(value = "/enable", method = RequestMethod.POST)
    public Result<Boolean> enable(@RequestParam(value = "dirId") Long dirId) {
        //2.转换
        Long adminId = BaseContextHandler.getAdminId();
        ShareDataDirectory dataDirectory = dataDirectoryService.getById(dirId);
        if (dataDirectory.getStatus() == 1) {
            return Result.fail("当前数据需要申请发布审核后，再发起启用流程");
        }
        ShareDataDirectoryWare ware = dataDirectoryWareService.getById(dirId);
        if (dataDirectory.getOptType() == 6 && ware.getOptType() == 4) {
            return Result.fail("目录发布后再禁用");
        }
        try {

            dataDirectory.setOptType(6);//操作类型(最近一次)：1,新增；2，修改；3，删除；4，禁用',5，正常,6,启用',
            dataDirectory.setStatus(1);
            dataDirectory.setUpdateUser(Long.valueOf(adminId));
            dataDirectoryService.updateByIdSelective(dataDirectory);

            String applyCode = shareUtil.automaticCode("MU");
            ShareDataChangeExample ChangeExample = new ShareDataChangeExample();
            ChangeExample.createCriteria().andUnitIdEqualTo(dataDirectory.getUnitId()).andStatusEqualTo(1);
            ShareDataChange dataChange = shareDataChangeService.getUnique(ChangeExample);
            ShareDataChange change = new ShareDataChange();
            ShareDataChangeElement changeElement = new ShareDataChangeElement();
            Long changeId;
            //如果为空需要生成变动流程
            if (dataChange != null) {
                changeId = dataChange.getId();
                changeElement.setBusId(changeId);
                changeElement.setBusType(1);
                changeElement.setChangeType(6);
                changeElement.setChgId(dataDirectory.getId());
                changeElement.setCreateUser(adminId);
                changeElement.setUpdateUser(adminId);
                shareDataChangeElementService.saveSelective(changeElement);
            } else {
                change.setUnitId(dataDirectory.getUnitId());
                change.setUserId(adminId);
                change.setStatus(1);
                change.setOptTime(new Date());
                change.setApplyCode(applyCode);
                change.setCreateUser(adminId);
                change.setUpdateUser(adminId);
                //保存数据目录变动主表
                shareDataChangeService.saveSelective(change);
                changeId = change.getId();
                changeElement.setBusId(changeId);
                changeElement.setBusType(1);
                changeElement.setChangeType(6);
                changeElement.setChgId(dataDirectory.getId());
                changeElement.setCreateUser(adminId);
                changeElement.setUpdateUser(adminId);
                shareDataChangeElementService.saveSelective(changeElement);
            }

            //更新子目录及元数据为状态禁用
            List<ShareDataDirectory> treeList = dozerUtils.mapList(dataDirectoryService.getDirectoryList(dirId), ShareDataDirectory.class);
            if (treeList != null && !treeList.isEmpty()) {
                List<ShareDataChangeElement> changeEleList = new ArrayList<>();
                List<ShareDataDirectory> updateDirectoryList = new ArrayList<>();
                for (ShareDataDirectory directory : treeList) {
                    directory.setOptType(6);//操作类型(最近一次)：1,新增；2，修改；3，删除；4，禁用',5，正常,6,启用',
                    directory.setStatus(1);
                    directory.setUpdateTime(new Date());
                    directory.setUpdateUser(Long.valueOf(adminId));
                    updateDirectoryList.add(directory);

                    ShareDataChangeElement chElement = new ShareDataChangeElement();
                    chElement.setBusId(changeId);
                    chElement.setBusType(1);
                    chElement.setChangeType(6);
                    chElement.setChgId(directory.getId());
                    chElement.setId(idGenerate.generate());
                    chElement.setCreateTime(new Date());
                    chElement.setUpdateTime(new Date());
                    chElement.setCreateUser(adminId);
                    chElement.setUpdateUser(adminId);
                    changeEleList.add(chElement);
                    ShareDataElementExample e = new ShareDataElementExample();
                    e.createCriteria().andDirIdEqualTo(directory.getId());
                    List<ShareDataElement> dataElement = dataElementService.find(e);
                    List<ShareDataChangeElement> changeElementList = new ArrayList<>();
                    List<ShareDataElement> updateElementList = new ArrayList<>();
                    if (dataElement != null && !dataElement.isEmpty()) {
                        for (int i = 0; i < dataElement.size(); i++) {
                            dataElement.get(i).setStatus(1);
                            dataElement.get(i).setOptType(6);
                            dataElement.get(i).setUpdateTime(new Date());
                            dataElement.get(i).setUpdateUser(adminId);
                            updateElementList.add(dataElement.get(i));

                            ShareDataChangeElement zdsElement = new ShareDataChangeElement();
                            Long chgId = dataElement.get(i).getId();
                            zdsElement.setBusId(changeId);
                            zdsElement.setBusType(2);
                            zdsElement.setChangeType(6);
                            zdsElement.setChgId(chgId);
                            zdsElement.setId(idGenerate.generate());
                            zdsElement.setCreateTime(new Date());
                            zdsElement.setUpdateTime(new Date());
                            zdsElement.setCreateUser(adminId);
                            zdsElement.setUpdateUser(adminId);
                            changeElementList.add(zdsElement);
                        }
                        dataElementService.batchUpdate(updateElementList);
                        shareDataChangeElementService.batchSave(changeElementList);
                    }
                }
                //4.保存
                dataDirectoryService.batchUpdate(updateDirectoryList);
                shareDataChangeElementService.batchSave(changeEleList);
            } else {
                ShareDataElementExample ex = new ShareDataElementExample();
                ex.createCriteria().andDirIdEqualTo(dataDirectory.getId());
                List<ShareDataElement> entityElement = dataElementService.find(ex);
                List<ShareDataChangeElement> dataChangeElementList = new ArrayList<>();
                List<ShareDataElement> updateEleList = new ArrayList<>();
                if (entityElement != null && !entityElement.isEmpty()) {
                    for (int i = 0; i < entityElement.size(); i++) {
                        entityElement.get(i).setStatus(1);
                        entityElement.get(i).setOptType(6);
                        entityElement.get(i).setUpdateUser(adminId);
                        updateEleList.add(entityElement.get(i));

                        ShareDataChangeElement zd = new ShareDataChangeElement();
                        Long chgId = entityElement.get(i).getId();
                        zd.setBusId(changeId);
                        zd.setChangeType(6);
                        zd.setBusType(2);
                        zd.setChgId(chgId);
                        zd.setId(idGenerate.generate());
                        zd.setCreateTime(new Date());
                        zd.setUpdateTime(new Date());
                        zd.setCreateUser(adminId);
                        zd.setUpdateUser(adminId);
                        dataChangeElementList.add(zd);
                    }
                    dataElementService.batchUpdate(updateEleList);
                    shareDataChangeElementService.batchSave(dataChangeElementList);
                }
            }
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
        return Result.success(true);
    }


    @ApiOperation(value = "删除数据目录信息", notes = "删除数据目录信息")
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public Result<Boolean> delete(@RequestParam(value = "id") Long id) {
        if (id == null) {
            return Result.fail("目录id不能为空");
        }
        Long adminId = BaseContextHandler.getAdminId();
        try {
            ShareDataDirectoryWare ware = dataDirectoryWareService.getById(id);
            List<ShareDataDirectory> treeList = dozerUtils.mapList(dataDirectoryService.getDirectoryList(id), ShareDataDirectory.class);
            if (ware == null) {//目录没有发布过，直接接连删除
                dataDirectoryService.deleteById(id);
                shareDataChangeElementService.deleteByDirId(id);
                if (treeList != null && !treeList.isEmpty()) {
                    for (ShareDataDirectory directory : treeList) {
                        dataDirectoryService.deleteById(directory.getId());
                        shareDataChangeElementService.deleteByDirId(directory.getId());//删除目录变动记录
                    }
                }
                ShareDataElementExample elementExample = new ShareDataElementExample();
                elementExample.createCriteria().andDirIdEqualTo(id);
                List<ShareDataElement> elementList = dataElementService.find(elementExample);
                if (elementList != null && elementList.size() > 0) {
                    dataElementService.deleteByDirId(id);
                    for (ShareDataElement element : elementList) {
                        shareDataChangeElementService.deleteByElementId(element.getId());//删除目录变动记录
                    }
                }
                return Result.success(true);
            }
            ShareDataDirectory dataDirectory = dataDirectoryService.getById(id);
            dataDirectory.setOptType(3);//操作类型(最近一次)：1,新增；2，修改；3，删除；4，禁用',5，正常,6,启用',
            dataDirectory.setStatus(1);
            dataDirectory.setUpdateUser(Long.valueOf(adminId));
            dataDirectoryService.updateByIdSelective(dataDirectory);

            ShareUtil shareUtil = new ShareUtil();//applyCode工具类
            String applyCode = shareUtil.automaticCode("MU");
            ShareDataChangeExample ChangeExample = new ShareDataChangeExample();
            ChangeExample.createCriteria().andUnitIdEqualTo(dataDirectory.getUnitId()).andStatusEqualTo(1);
            ShareDataChange dataChange = shareDataChangeService.getUnique(ChangeExample);
            ShareDataChange change = new ShareDataChange();
            ShareDataChangeElement changeElement = new ShareDataChangeElement();
            Long changeId = null;
            //如果为空需要生成变动流程
            if (dataChange != null) {
                changeId = dataChange.getId();
                changeElement.setBusId(changeId);
                changeElement.setBusType(1);
                changeElement.setChangeType(3);
                changeElement.setChgId(dataDirectory.getId());
                changeElement.setCreateUser(adminId);
                changeElement.setUpdateUser(adminId);
                shareDataChangeElementService.saveSelective(changeElement);
            } else {
                change.setUnitId(dataDirectory.getUnitId());
                change.setUserId(adminId);
                change.setStatus(1);
                change.setOptTime(new Date());
                change.setApplyCode(applyCode);
                change.setCreateUser(adminId);
                change.setUpdateUser(adminId);
                //保存数据目录变动主表
                shareDataChangeService.saveSelective(change);
                changeId = change.getId();
                changeElement.setBusId(changeId);
                changeElement.setBusType(1);
                changeElement.setChangeType(3);
                changeElement.setChgId(dataDirectory.getId());
                changeElement.setCreateUser(adminId);
                changeElement.setUpdateUser(adminId);
                shareDataChangeElementService.saveSelective(changeElement);
            }

            //更新子目录及元数据状态
            List<ShareDataElement> updateElementList = new ArrayList<>();
            List<ShareDataChangeElement> addElementList = new ArrayList<>();
            if (treeList != null && !treeList.isEmpty()) {
                for (ShareDataDirectory directory : treeList) {
                    ShareDataDirectoryWare wareDelete = dataDirectoryWareService.getById(directory.getId());
                    ShareDataElementExample e = new ShareDataElementExample();
                    e.createCriteria().andDirIdEqualTo(directory.getId());
                    List<ShareDataElement> dataElementList = dataElementService.find(e);
                    if (wareDelete == null) {//子目录没有发布过直接删除、删除字段、记录表
                        dataDirectoryService.deleteById(directory.getId());
                        dataElementService.deleteByDirId(directory.getId());
                        shareDataChangeElementService.deleteByDirId(directory.getId());//删除目录变动记录
                        if (dataElementList != null && !dataElementList.isEmpty()) {
                            for (ShareDataElement dataElement : dataElementList) {
                                shareDataChangeElementService.deleteByElementId(dataElement.getId());//删除字段变动记录
                            }
                        }
                    } else {
                        directory.setOptType(3);//操作类型(最近一次)：1,新增；2，修改；3，删除；4，禁用',5，正常,6,启用',
                        directory.setStatus(1);
                        directory.setUpdateUser(Long.valueOf(adminId));
                        //4.保存
                        dataDirectoryService.updateByIdSelective(directory);
                        ShareDataChangeElement chElement = new ShareDataChangeElement();
                        chElement.setBusId(changeId);
                        chElement.setBusType(1);
                        chElement.setChangeType(3);
                        chElement.setChgId(directory.getId());
                        chElement.setCreateUser(adminId);
                        chElement.setUpdateUser(adminId);
                        shareDataChangeElementService.saveSelective(chElement);
                        if (dataElementList != null && !dataElementList.isEmpty()) {
                            for (ShareDataElement shareDataElement : dataElementList) {
                                if (shareDataElement.getOptType().equals(1)) {
                                    dataElementService.deleteById(shareDataElement.getId());
                                    shareDataChangeElementService.deleteByElementId(shareDataElement.getId());
                                } else {
                                    shareDataElement.setStatus(1);
                                    shareDataElement.setOptType(3);
                                    shareDataElement.setUpdateUser(adminId);
                                    updateElementList.add(shareDataElement);

                                    ShareDataChangeElement zdElement = new ShareDataChangeElement();
                                    zdElement.setId(idGenerate.generate());
                                    zdElement.setBusType(2);
                                    zdElement.setBusId(changeId);
                                    zdElement.setChangeType(3);
                                    zdElement.setChgId(shareDataElement.getId());
                                    zdElement.setCreateUser(adminId);
                                    zdElement.setUpdateUser(adminId);
                                    addElementList.add(zdElement);
                                }
                            }
                        }
                    }
                }
            } else {
                ShareDataElementExample ex = new ShareDataElementExample();
                ex.createCriteria().andDirIdEqualTo(dataDirectory.getId());
                List<ShareDataElement> entityElementList = dataElementService.find(ex);
                if (entityElementList != null && !entityElementList.isEmpty()) {
                    for (ShareDataElement shareDataElement : entityElementList) {
                        if (shareDataElement.getOptType().equals(1)) {
                            dataElementService.deleteById(shareDataElement.getId());
                            shareDataChangeElementService.deleteByElementId(shareDataElement.getId());
                        } else {
                            shareDataElement.setStatus(1);
                            shareDataElement.setOptType(3);
                            shareDataElement.setUpdateUser(adminId);
                            updateElementList.add(shareDataElement);
                            ShareDataChangeElement zd = new ShareDataChangeElement();
                            zd.setId(idGenerate.generate());
                            zd.setBusId(changeId);
                            zd.setBusType(2);
                            zd.setChangeType(3);
                            zd.setChgId(shareDataElement.getId());
                            zd.setCreateUser(adminId);
                            zd.setUpdateUser(adminId);
                            addElementList.add(zd);
                        }
                    }
                }
            }
            if (updateElementList != null && !updateElementList.isEmpty()) {
                dataElementService.batchUpdate(updateElementList);
            }
            if (addElementList != null && !addElementList.isEmpty()) {
                shareDataChangeElementService.batchSave(addElementList);
            }
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
        return Result.success(true);
    }


    @ApiOperation(value = "根据id查询数据目录信息", notes = "根据id查询数据目录信息")
    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public Result<DataDirectoryDictDTO> get(@RequestParam(value = "id") Long id) {
        if (id == null) {
            return Result.fail("目录id不能为空");
        }
        ShareDataDirectoryDictDO dictionary = dataDirectoryService.getDictCodeList(id);
        ShareUnitExample example = new ShareUnitExample();
        example.createCriteria().andDirIdEqualTo(id).andOptTypeNotEqualTo(3);
        List<ShareUnit> List = dozerUtils.mapList(shareUnitService.find(example), ShareUnit.class);
        List<String> unitIds = new ArrayList();
        if (List != null && !List.isEmpty()) {
            for (int i = 0; i < List.size(); i++) {
                String unitId = List.get(i).getUnitId();
                unitIds.add(unitId);
            }
        }
        dictionary.setUnitIds(unitIds);
        DataDirectoryDictDTO dto = dozerUtils.map(dictionary, DataDirectoryDictDTO.class);

        /*用于判断是否可以申请 start edit by zhaopengfei */
        //基础数据获取
        Long userId = BaseContextHandler.getAdminId();
        //获取单位Id
        String unitId = commonService.getOrgIdByUserId(userId);
        boolean isOwner = shareDataApiService.queryOwner(unitId, id);
        if (isOwner) {
            dto.setIsOwner(1);
        } else {
            dto.setIsOwner(2);
        }

        //edit by zhaopengfei 判断登录单位是否为共享单位
        Integer shareUnit = 0;
        if (dictionary.getUnitId().equals(unitId)) {
            shareUnit = 1;
        } else {
            ShareUnitWareExample shareUnitExample = new ShareUnitWareExample();
            shareUnitExample.createCriteria().andDirIdEqualTo(Long.valueOf(id)).andUnitIdEqualTo(unitId);
            List<ShareUnitWare> unitWares = shareUnitWareService.find(shareUnitExample);
            if (unitWares != null && !unitWares.isEmpty()) {
                shareUnit = 1;
            }
        }
        dto.setShareUnit(shareUnit);
        dto.setLoginUnitId(unitId);
        /*用于判断是否可以申请 end edit by zhaopengfei */

        return Result.success(dto);
    }

    @ApiOperation(value = "查询目录编码是否存在", notes = "查询目录编码是否存在")
    @RequestMapping(value = "/getDirCode", method = RequestMethod.GET)
    public Result<Boolean> getDirCode(@RequestParam(value = "dirCode") String dirCode) {
        if (dirCode == null) {
            return Result.fail("目录编码不能为空");
        }

        ShareDataDirectoryExample example = new ShareDataDirectoryExample();
        example.createCriteria().andDirCodeEqualTo(dirCode);
        List<ShareDataDirectory> directory = dataDirectoryService.find(example);
        if (directory != null && !directory.isEmpty()) {
            return Result.success(false);
        } else {
            return Result.success(true);
        }
    }

    @ApiOperation(value = "查询字段编码是否存在", notes = "查询字段编码是否存在")
    @RequestMapping(value = "/getElementCode", method = RequestMethod.GET)
    public Result<Boolean> getElementCode(@RequestParam(value = "fieldCode") String fieldCode, @RequestParam(value = "dirId") Long dirId) {
        if (fieldCode == null) {
            return Result.fail("字段编码不能为空");
        }
        if (dirId == null) {
            return Result.fail("目录id不能为空");
        }
        ShareDataElementExample example = new ShareDataElementExample();
        example.createCriteria().andDirIdEqualTo(dirId).andFieldCodeEqualTo(fieldCode).andDataStatusNotEqualTo(2);
        List<ShareDataElement> elements = dataElementService.find(example);
        if (elements != null && !elements.isEmpty()) {
            return Result.success(false);
        } else {
            return Result.success(true);
        }
    }

    @ApiOperation(value = "根据id查询数据目录信息", notes = "根据id查询数据目录信息")
    @RequestMapping(value = "/getDirectoryWare", method = RequestMethod.GET)
    public Result<DataDirectoryDictDTO> getDirectoryWare(@RequestParam(value = "id") Long id) {
        if (id == null) {
            return Result.fail("目录id不能为空");
        }
        ShareDataDirectoryDictDO dictionary = dataDirectoryService.getDictCodeWareList(id);
        ShareUnitExample example = new ShareUnitExample();
        example.createCriteria().andDirIdEqualTo(id);
        List<ShareUnit> List = dozerUtils.mapList(shareUnitService.find(example), ShareUnit.class);
        List<String> unitIds = new ArrayList();
        if (List != null && !List.isEmpty()) {
            for (int i = 0; i < List.size(); i++) {
                String unitId = List.get(i).getUnitId();
                unitIds.add(unitId);
            }
        }
        dictionary.setUnitIds(unitIds);
        DataDirectoryDictDTO dto = dozerUtils.map(dictionary, DataDirectoryDictDTO.class);
        return Result.success(dto);
    }


    @ApiOperation(value = "查询数据目录变动信息", notes = "查询数据目录变动信息")
    @RequestMapping(value = "/getDirectoryChangeList", method = RequestMethod.GET)
    public Result<List<DataDirectoryDTO>> getDirectoryChangeList(@RequestParam(value = "applyCode") String applyCode) {
        if (applyCode == null) {
            return Result.fail("申请编号不能为空");
        }
        List<DataDirectoryDTO> changeList = dozerUtils.mapList(dataDirectoryService.getDirectoryChangeList(applyCode), DataDirectoryDTO.class);
        return Result.success(changeList);
    }

    @ApiOperation(value = "查询申请发布目录变动信息", notes = "查询申请发布目录变动信息")
    @RequestMapping(value = "/getDirectoryChangeListApply", method = RequestMethod.GET)
    public Result<List<DataDirectoryDTO>> getDirectoryChangeListApply(@RequestParam(value = "unitId") String unitId, @RequestParam(value = "status") Integer status) {
        if (unitId == null) {
            return Result.fail("申请编号不能为空");
        }
        if (status == null) {
            return Result.fail("状态不能为空");
        }
        List<DataDirectoryDTO> changeList = dozerUtils.mapList(dataDirectoryService.getDirectoryChangeListApply(unitId, status), DataDirectoryDTO.class);
        return Result.success(changeList);
    }


    @ApiOperation(value = "查询默认共享单位信息", notes = "查询默认共享单位信息")
    @RequestMapping(value = "/getOrgList", method = RequestMethod.GET)
    public Result<List<VOrgDTO>> getOrgList() {
        List<VOrgDTO> List = dozerUtils.mapList(dataDirectoryService.getOrgList(), VOrgDTO.class);
        return Result.success(List);
    }


    @ApiOperation(value = "自动创建目录的元数据信息", notes = "自动创建目录的元数据信息")
    @ApiResponses({
            @ApiResponse(code = 85001, message = "数据目录不允许为空"),
            @ApiResponse(code = 85012, message = "单位id不允许为空"),
            @ApiResponse(code = 85013, message = "数据类型不能为空"),
    })
    @RequestMapping(value = "/saveAutomatic", method = RequestMethod.POST)
    public Result<DataDirectoryAutomaticSaveDTO> saveAutomatic(@RequestBody DataDirectoryAutomaticSaveDTO dto) {
        //1.校验
        BizAssert.assertNotNull(ExchangeExceptionCode.DIRECTORY_NAME_NULL, dto.getDirName());
        BizAssert.assertNotNull(ExchangeExceptionCode.DIRECTORY_UNITID_NULL, dto.getUnitId());
        BizAssert.assertNotNull(ExchangeExceptionCode.DIRECTORY_DATA_TYPE_NULL, dto.getDataType());//数据类型:1,结构化数据；2，非结构化数据',
        //2.转换
        ShareDataDirectory dataDirectory = dozerUtils.map(dto, ShareDataDirectory.class);

        Long adminId = BaseContextHandler.getAdminId();
        String applyCode = shareUtil.automaticCode("MU");
        try {
            List<DataElementAutomaticSaveDTO> elementList = dto.getAutomaticSaveDTO();//元数据列表信息
            ShareDataChangeExample ChangeExample = new ShareDataChangeExample();
            ChangeExample.createCriteria().andUnitIdEqualTo(dataDirectory.getUnitId()).andStatusEqualTo(1);
            ShareDataChange dataChange = shareDataChangeService.getUnique(ChangeExample);//查询chang主表
            ShareDataChange change = new ShareDataChange();
            Long changeId;
            if (dataChange != null) {
                changeId = dataChange.getId();
            } else {
                change.setUnitId(dataDirectory.getUnitId());
                change.setUserId(adminId);
                change.setStatus(1);
                change.setOptTime(new Date());
                change.setApplyCode(applyCode);
                change.setCreateUser(adminId);
                change.setUpdateUser(adminId);
                //保存数据目录变动主表
                shareDataChangeService.saveSelective(change);
                changeId = change.getId();

            }
            List<ShareDataElement> dataElementList = new ArrayList<>();
            List<ShareDataChangeElement> dataChangeElementList = new ArrayList<>();
            for (DataElementAutomaticSaveDTO el : elementList) {
                ShareDataElement dataElement = new ShareDataElement();
                dataElement.setId(idGenerate.generate());
                dataElement.setUnitId(dataDirectory.getUnitId());
                dataElement.setDirId(dataDirectory.getId());
                if (el.getFieldName() != null && el.getFieldName() != "") {
                    dataElement.setDesc(el.getFieldName());
                    dataElement.setFieldName(el.getFieldName());
                } else {
                    dataElement.setDesc(el.getFieldCode());
                    dataElement.setFieldName(el.getFieldCode());
                }
                dataElement.setFieldCode(el.getFieldCode());
                dataElement.setFieldType(el.getFieldType());
                dataElement.setStatus(1);//状态:1,未发布；2，审批中；3，驳回；4，已发布；5，已禁用',
                dataElement.setOptType(1);//操作类型(最近一次)：1,新增；2，修改；3，删除',
                dataElement.setDataStatus(1);
                dataElement.setIsPrimary(2);
                dataElement.setCreateTime(new Date());
                dataElement.setUpdateTime(new Date());
                dataElement.setCreateUser(Long.valueOf(adminId));
                dataElement.setUpdateUser(Long.valueOf(adminId));
                dataElementList.add(dataElement);

                ShareDataChangeElement chgElement = new ShareDataChangeElement();
                chgElement.setId(idGenerate.generate());
                chgElement.setBusId(changeId);
                chgElement.setBusType(2);//2，字段
                chgElement.setChangeType(1);
                chgElement.setChgId(dataElement.getId());
                chgElement.setCreateTime(new Date());
                chgElement.setUpdateTime(new Date());
                chgElement.setCreateUser(adminId);
                chgElement.setUpdateUser(adminId);
                dataChangeElementList.add(chgElement);
            }
            //4.保存
            dataElementService.batchSave(dataElementList);
            shareDataChangeElementService.batchSave(dataChangeElementList);

        } catch (Exception e) {
            log.error("转换错误", e.getMessage());
            throw e;
        }
        return Result.success(dozerUtils.map(dataDirectory, DataDirectoryAutomaticSaveDTO.class));
    }


    @ApiOperation(value = "查询数据目录共享单位", notes = "查询数据目录共享单位")
    @RequestMapping(value = "/getUnitList", method = RequestMethod.GET)
    public Result<ShareUnitDTO> getUnitList(@RequestParam(value = "dirId") Long dirId, @RequestParam(value = "unitId") String unitId) {
        if (dirId == null) {
            return Result.fail("目录id不能为空");
        }
        if (unitId == null) {
            return Result.fail("单位d不能为空");
        }
        ShareUnitExample unitExample = new ShareUnitExample();
        unitExample.createCriteria().andUnitIdEqualTo(unitId).andDirIdEqualTo(dirId).andOptTypeNotEqualTo(3);
        ShareUnitDTO shareUnit = dozerUtils.map(shareUnitService.getUnique(unitExample), ShareUnitDTO.class);
        return Result.success(shareUnit);
    }


    @ApiOperation(value = "查询数据目录是否发布", notes = "查询数据目录是否发布")
    @RequestMapping(value = "/getWare", method = RequestMethod.GET)
    public Result<Boolean> getWare(@RequestParam(value = "id") Long id) {
        Boolean bool = false;
        if (id == null) {
            return Result.fail("目录id不能为空！");
        }
        ShareDataDirectoryWare ware = dataDirectoryWareService.getById(id);
        if (ware != null) {
            bool = true;
        }
        return Result.success(bool);
    }

    @ApiOperation(value = "查询数据目录或字段是否发布中", notes = "查询数据目录或字段是否发布中")
    @RequestMapping(value = "/getDirOrElement", method = RequestMethod.GET)
    public Result<Boolean> getDirOrElement(@RequestParam(value = "id") Long id) {
        Boolean bool = false;
        if (id == null) {
            return Result.fail("目录id不能为空！");
        }
        List<ShareDataChange> change = shareDataChangeService.getDirOrElement(id);
        if (change != null && !change.isEmpty()) {
            for (ShareDataChange dataChange : change) {
                if (dataChange.getStatus() == 4) {
                    bool = true;
                    break;
                }
            }
        }
        return Result.success(bool);
    }

    @ApiOperation(value = "查询驳回的数据目录树", notes = "查询驳回的数据目录树")
    @RequestMapping(value = "/findRejectDataTree", method = RequestMethod.GET)
    public Result<List<DataDirectoryTreeDTO>> findRejectDataTree(@RequestParam(value = "applyCode") String applyCode) {
        if (null == applyCode) {
            return Result.fail("申请编号不能为空！");
        }
        Boolean unitAdmin;//是否是单位管理员
        Long adminId = BaseContextHandler.getAdminId();
        Long pId = Long.valueOf(-1);
        String strUnitId = commonService.getOrgIdByUserId(adminId);
        if (strUnitId == null) {
            return Result.fail("用户单位id不能为空");
        }
        unitAdmin = gxqPtRoleUnits.getGxqUnitRole(adminId, strUnitId);
        if (!unitAdmin) {
            return Result.fail("非单位管理员");
        }
        List<DataDirectoryTreeDTO> treeList = dozerUtils.mapList(dataDirectoryService.getUnitDirectoryList(Long.valueOf(strUnitId)), DataDirectoryTreeDTO.class);
        return Result.success(TreeUtil.queryTree(treeList, pId));
    }

}