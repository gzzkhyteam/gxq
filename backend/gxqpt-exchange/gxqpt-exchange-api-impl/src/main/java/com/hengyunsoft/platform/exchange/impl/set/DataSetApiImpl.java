package com.hengyunsoft.platform.exchange.impl.set;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.common.collect.Lists;
import com.hengyunsoft.base.Result;
import com.hengyunsoft.commons.context.BaseContextHandler;
import com.hengyunsoft.commons.exception.core.ExchangeExceptionCode;
import com.hengyunsoft.commons.utils.context.DozerUtils;
import com.hengyunsoft.page.plugins.openapi.OpenApiReq;
import com.hengyunsoft.platform.exchange.api.directory.dto.directory.DataDirectoryDTO;
import com.hengyunsoft.platform.exchange.api.set.dto.*;
import com.hengyunsoft.platform.exchange.constant.ApplyType;
import com.hengyunsoft.platform.exchange.constant.ExchangeConstants;
import com.hengyunsoft.platform.exchange.entity.directory.po.ShareDataDirectory;
import com.hengyunsoft.platform.exchange.entity.directory.po.ShareDataElement;
import com.hengyunsoft.platform.exchange.entity.directory.po.ShareDataElementWare;
import com.hengyunsoft.platform.exchange.entity.set.domain.DSFlowTaskInfoDO;
import com.hengyunsoft.platform.exchange.entity.set.domain.ShareDataSetDO;
import com.hengyunsoft.platform.exchange.entity.set.po.*;
import com.hengyunsoft.platform.exchange.impl.set.dataread.api.ApiDataDescManager;
import com.hengyunsoft.platform.exchange.impl.set.dataread.database.DataBaseDescManager;
import com.hengyunsoft.platform.exchange.impl.set.dataread.database.FieldRoule;
import com.hengyunsoft.platform.exchange.impl.set.dataread.database.QueryData;
import com.hengyunsoft.platform.exchange.repository.api.service.ShareDataApiSubscriptionService;
import com.hengyunsoft.platform.exchange.repository.common.service.CommonService;
import com.hengyunsoft.platform.exchange.repository.directory.example.ShareDataDirectoryExample;
import com.hengyunsoft.platform.exchange.repository.directory.example.ShareDataElementExample;
import com.hengyunsoft.platform.exchange.repository.directory.service.DataDirectoryService;
import com.hengyunsoft.platform.exchange.repository.directory.service.DataDirectoryWareService;
import com.hengyunsoft.platform.exchange.repository.directory.service.DataElementService;
import com.hengyunsoft.platform.exchange.repository.directory.service.DataElementWareService;
import com.hengyunsoft.platform.exchange.repository.set.example.*;
import com.hengyunsoft.platform.exchange.repository.set.service.*;
import com.hengyunsoft.platform.exchange.repository.system.service.ShareFlowService;
import com.hengyunsoft.platform.exchange.repository.system.service.ShareJoinOrgService;
import com.hengyunsoft.platform.exchange.util.ShareUtil;
import com.hengyunsoft.platform.exchange.utils.DataBaseSql;
import com.hengyunsoft.platform.exchange.utils.GxqPtRoleUnits;
import com.hengyunsoft.platform.exchange.utils.PageInfoUtil;
import com.hengyunsoft.utils.BizAssert;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.*;

@Service
@Slf4j
/**
 * com.hengyunsoft.platform.exchange.impl.set
 * 版权：中科恒运软件科技股份有限公司贵阳分公司
 * 描述：数据集
 * 修改人：gbl
 * 修改时间：2018/4/23
 * 修改内容：新增基础接口
 */
@Api(value = "API - DataSetApiImpl.java", description = "数据集API")
@RestController
@RequestMapping("set")
public class DataSetApiImpl/* implements DataSetApi */ {
    @Autowired
    private ShareDataFileService shareDataFileService;
    @Autowired
    private ShareDataSetService shareDataSetService;
    @Autowired
    private DozerUtils dozerUtils;
    @Autowired
    private GxqPtRoleUnits gxqPtRoleUnits;
    @Autowired
    private DataBaseDescManager dataBaseDescManager;
    @Autowired
    private CommonService commonService;
    @Autowired
    private ShareDataSetElementService shareDataSetElementService;
    @Autowired
    private ShareDataSetElementWareService shareDataSetElementWareService;
    @Autowired
    private ShareDataSetFilterService shareDataSetFilterService;
    @Autowired
    private ShareDataSetFilterWareService shareDataSetFilterWareService;
    @Autowired
    private DataElementService dataElementService;
    @Autowired
    private ApiDataDescManager apiDataDescManager;
    @Autowired
    private DataDirectoryService dataDirectoryService;
    @Autowired
    private DataDirectoryWareService dataDirectoryWareService;
    @Autowired
    private ShareFlowService shareFlowService;
    @Autowired
    private ShareDataSetFlowService shareDataSetFlowService;
    @Autowired
    private ShareDbSourceService shareDbSourceService;
    @Autowired
    private ShareJoinOrgService shareJoinOrgService;
    @Autowired
    private ShareDataSetDirService shareDataSetDirService;
    @Autowired
    private ShareDataSetDirElementService shareDataSetDirElementService;
    @Autowired
    private DataElementWareService dataElementWareService;
    @Autowired
    private ShareDataSetRuleService shareDataSetRuleService;
    @Autowired
    private ShareDataApiSubscriptionService shareDataApiSubscriptionService;

    //@Value("dataset.query.pageSize")根据目录id查询数据,分页大小
    private int pageSize = 10;

    private final String file_bus_type = "data_set";
    /**
     * 数据集标识生成前缀
     */
    private static final String dataSetCode = "SJJ";
    /**
     * 更新本地数据仓库时，不使用引号设置值得数据类型
     */
    private List<String> dbHasEquelType = new ArrayList<>();

    @PostConstruct
    private void initDbHasEquelType() {
        dbHasEquelType.add("bit");
    }

    public ShareDataSet saveCreateDataSet(CreateDataSetParamDTO dto) {
        BizAssert.assertNotNull(ExchangeExceptionCode.CREATEDATASET_CREATEDATASETPARAMDTO_EDITTYPE, dto.getEditType());
        BizAssert.assertNotEmpty(ExchangeExceptionCode.CREATEDATASET_CREATEDATASETPARAMDTO_SETNAME, dto.getSetName());
        BizAssert.assertNotEmpty(ExchangeExceptionCode.CREATEDATASET_CREATEDATASETPARAMDTO_SETCODE, dto.getSetCode());
        BizAssert.assertNotNull(ExchangeExceptionCode.CREATEDATASET_CREATEDATASETPARAMDTO_SETTYPE, dto.getSetType());
        BizAssert.assertNotNull(ExchangeExceptionCode.CREATEDATASET_CREATEDATASETPARAMDTO_UPDATERATE, dto.getUpdateRate());
        BizAssert.assertNotEmpty(ExchangeExceptionCode.CREATEDATASET_CREATEDATASETPARAMDTO_REASON, dto.getReason());
        if (dto.getEditType() != 1) {
            BizAssert.assertNotNull(ExchangeExceptionCode.CREATEDATASET_CREATEDATASETPARAMDTO_ID, dto.getId());
        }
        Long adminId = BaseContextHandler.getAdminId();
        String unitId = getUserUnitId();
        Boolean isPtAdmin = gxqPtRoleUnits.getGxqPtRole(adminId, GxqPtRoleUnits.PT_ADMIN_ROLE_CODE);
        Boolean isPtDataAdmin = gxqPtRoleUnits.getGxqPtRole(adminId, GxqPtRoleUnits.PT_ADMIN_DATA_ROLE_CODE);
        Boolean isUnityAdmin = gxqPtRoleUnits.getGxqPtRole(adminId, GxqPtRoleUnits.UNITY_ADMIN_DATA_ROLE_CODE);
        Boolean unity_admin_role_code = gxqPtRoleUnits.getGxqUnitRole(adminId, unitId);

        if (!isPtAdmin && !isPtDataAdmin && !isUnityAdmin && !unity_admin_role_code) {
            BizAssert.fail(ExchangeExceptionCode.CREATEDATASET_OPT_NEED_DATA_OPT);
        }


        if (dto.getSetType() < 0 || dto.getSetType() > 4) {
            BizAssert.fail(ExchangeExceptionCode.CREATEDATASET_CREATEDATASETPARAMDTO_TYPE_ERROR);
        }

//        if (dto.getEditType() == 1) {
//            ShareDataSet shareDataSetBySetCode = shareDataSetService.getShareDataSetBySetCode(dto.getSetCode());
//            BizAssert.fail(ExchangeExceptionCode.CREATEDATASET_SET_CODE_DOUBLE);
//        }

        ShareDataSet shareDataSet = dozerUtils.map(dto, ShareDataSet.class);

        if (dto.getEditType() == 1) {
            shareDataSet.setStatus(-1);//暂存状态
            shareDataSet.setCreateUser(adminId);
            shareDataSet.setUnitId(unitId);
        } else {
            ShareDataSet old = shareDataSetService.getById(dto.getId());
            shareDataSet.setId(old.getId());
            if (old.getStatus() == 1) {//处于审批中的数据集不能编辑
                BizAssert.fail(ExchangeExceptionCode.CREATEDATASET_CAN_NOT_EDIT);
            }
            if (old.getStatus() == 3) {//已经上架编号的话，变成下架状态,否则不变
                shareDataSet.setStatus(4);//编辑的话，将数据集下架
            }
            shareDataSet.setTableCode(old.getTableCode());
        }

        shareDataSet.setUpdateUser(adminId);
        //数据集自己的流程数据,在各个类型提交那一步在开启流程
        String applyCode = ShareUtil.automaticCode(ApplyType.SET_APPLY.getVal());
        ShareDataSetFlow shareDataSetFlow = new ShareDataSetFlow();
        shareDataSetFlow.setApplyCode(applyCode);
        shareDataSetFlow.setSetId(shareDataSet.getId());
        if (dto.getEditType() == 1) {
            shareDataSetFlow.setType(1);//类型(1,新增2修改)
        } else {
            shareDataSetFlow.setType(2);//类型(1,新增2修改)
        }
        shareDataSetFlow.setUnitId(unitId);
        shareDataSetFlow.setUpdateUser(adminId);
        shareDataSetFlowService.saveSelective(shareDataSetFlow);

        shareDataSet.setApplyCode(applyCode);
        shareDataSet.setAcqTime(new Date());
        shareDataSet.setUpdateUser(adminId);
        shareDataSet.setUpdateTime(new Date());

        if (dto.getEditType() == 1) {
            shareDataSetFlow.setCreateUser(adminId);
            shareDataSet.setCreateTime(new Date());
        }
        return shareDataSet;
    }

    /**
     * 描述：创建文件类型数据集第一步提交
     * 参数：数据库数据集参数
     * 返回值：成功或者失败
     * 修改人：gbl
     * 修改时间：2018/4/23
     * 修改内容：新增
     */
    @ApiOperation(value = "创建文件类型数据集第一步提交", notes = "创建文件类型数据集第一步提交")
    @ApiResponses({
            @ApiResponse(code = 85521, message = "集合编码重复"),
            @ApiResponse(code = 85522, message = "编辑类型，不能为空"),
            @ApiResponse(code = 85523, message = "主键,不能为空"),
            @ApiResponse(code = 85524, message = "数据集名称，不能为空"),
            @ApiResponse(code = 85525, message = "数据集标识，不能为空"),
            @ApiResponse(code = 85526, message = "数据集类型，不能为空"),
            @ApiResponse(code = 85527, message = "更新频率，不能为空"),
            @ApiResponse(code = 85528, message = "创建理由，不能为空"),
            @ApiResponse(code = 85533, message = "审批中的数据集不能编辑"),
            @ApiResponse(code = 85515, message = " 创建数据集类型错误,只能是1到4"),
            @ApiResponse(code = 85516, message = "只有数据操作员才能操作"),

    })
    @RequestMapping(value = "createFileDataSetFirst", method = RequestMethod.POST)
    public Result<CreateDPFileFirstResDTO> createFileDataSetFirst(@RequestBody CreateDataSetParamDTO param) {
        CreateDPFileFirstResDTO res = new CreateDPFileFirstResDTO();
        Integer editType = param.getEditType();
        ShareDataSet shareDataSet;
        if (editType == 1 || editType == 2) {
            shareDataSet = saveCreateDataSet(param);
            ShareDataSet old = shareDataSetService.getShareDataSetBySetCode(param.getSetCode());
            if (old == null) {
                shareDataSetService.saveSelective(shareDataSet);
            } else {
                shareDataSet.setId(old.getId());
                shareDataSetService.updateByIdSelective(shareDataSet);
            }

        } else {
            shareDataSet = shareDataSetService.getById(param.getId());
        }
        res.setId(shareDataSet.getId());
        return Result.success(res);

    }

    /**
     * 描述：创建文件类型数据集第二步提交
     * 参数：
     * 返回值：
     * 修改人：gbl
     * 修改时间：2018/4/24
     * 修改内容：
     */
    @ApiOperation(value = "创建文件类型数据集第二步提交", notes = "创建文件类型数据集第二步提交")
    @RequestMapping(value = "createFileDataSetSecond", method = RequestMethod.POST)
    @ApiResponses({
            @ApiResponse(code = 85504, message = "数据集不存在"),

            @ApiResponse(code = 85529, message = "编辑类型,不能为空"),
            @ApiResponse(code = 85530, message = "数据集id，不能为空"),
            @ApiResponse(code = 85531, message = "附件信息，不能为空"),
            @ApiResponse(code = 85532, message = "管理目录id，不能为空"),
    })
    public Result<Boolean> createFileDataSetSecond(@RequestBody CreateDataSetParamFileDTO param) {
        BizAssert.assertNotNull(ExchangeExceptionCode.CREATEDATASET_CREATEDATASETPARAMFILEDTO_EDITTYPE, param.getEditType());
        BizAssert.assertNotNull(ExchangeExceptionCode.CREATEDATASET_CREATEDATASETPARAMFILEDTO_ID, param.getId());
        BizAssert.assertNotEmpty(ExchangeExceptionCode.CREATEDATASET_CREATEDATASETPARAMFILEDTO_FILES, param.getFiles());
        BizAssert.assertNotEmpty(ExchangeExceptionCode.CREATEDATASET_CREATEDATASETPARAMFILEDTO_DIRECTORYID, param.getDirectoryId());

        ShareDataSet shareDataSet = shareDataSetService.getById(param.getId());
        if (shareDataSet == null) {
            return Result.fail(ExchangeExceptionCode.CREATEDATASET_CREATEDATASETPARAMFILEDTO_DATASET_NOT);
        }

        Long adminId = BaseContextHandler.getAdminId();
        //保存附件,只保存新增的附件
        List<DataSetFileDTO> files = param.getFiles();
        Map<Long, ShareDataFile> oldFileMap = shareDataFileService.getShareDataFileBySetId(shareDataSet.getId());
        List<ShareDataFile> saveAllFile = new ArrayList<>();
        List<ShareDataFile> updateAllFile = new ArrayList<>();

        boolean isFileChange = false;
        for (DataSetFileDTO fdto : files) {
            ShareDataFile old = oldFileMap.remove(fdto.getBusId());
            if (old == null) {
                ShareDataFile dataFile = dozerUtils.map(fdto, ShareDataFile.class);
                dataFile.setSetId(param.getId());
                dataFile.setCreateUser(adminId);
                dataFile.setUpdateUser(adminId);
                dataFile.setOptType(1);
                dataFile.setBusId(fdto.getBusId());//业务id(文件编号)
                dataFile.setBusType(file_bus_type);
                saveAllFile.add(dataFile);
                isFileChange = true;
            } else {
                old.setOptType(3);
                updateAllFile.add(old);
            }
        }
        for (ShareDataFile file : oldFileMap.values()) {
            file.setOptType(2);
            updateAllFile.add(file);
            isFileChange = true;
        }
        if (isFileChange) {
            shareDataApiSubscriptionService.saveUnStructNotice(param.getId());
        }

        shareDataFileService.save(saveAllFile);
        shareDataFileService.updateByIdSelective(updateAllFile);
        shareDataSet.setStatus(1);
        shareDataSet.setDataCount((float) param.getFiles().size());
        shareDataSetService.updateByIdSelective(shareDataSet);

        //处理关联目录
        List<Long> dirs = param.getDirectoryId();
        List<RelatedDirectoryDTO> redList = new ArrayList<>();
        for (long did : dirs) {
            RelatedDirectoryDTO rdd = new RelatedDirectoryDTO();
            rdd.setDirectoryId(did);
            redList.add(rdd);
        }
        saveRelatedDirectory(shareDataSet.getId(), redList);

        //正式提交流程更新流程提交时间
        ShareDataSetFlow sdsf = shareDataSetFlowService.getShareDataSetFlowByApplyCode(shareDataSet.getApplyCode());
        sdsf.setCreateTime(new Date());
        sdsf.setSetId(shareDataSet.getId());
        shareDataSetFlowService.updateByIdSelective(sdsf);

        shareFlowService.saveStartFlow(2, shareDataSet.getApplyCode(), ExchangeConstants.FLOW_SET_CODE, shareDataSet.getCreateUser(), shareDataSet.getUnitId());
        return Result.success(true);
    }

    /**
     * 描述：创建数据库类型数据集第一步提交
     * 参数：
     * 返回值：
     * 修改人：gbl
     * 修改时间：2018/4/24
     * 修改内容：
     */
    @RequestMapping(value = "createDatabaseDataSetFirst", method = RequestMethod.POST)
    @ApiOperation(value = "创建数据库类型数据集第一步提交", notes = "创建数据库类型数据集第一步提交")
    @ApiResponses({
            @ApiResponse(code = 85521, message = "集合编码重复"),
            @ApiResponse(code = 85522, message = "编辑类型，不能为空"),
            @ApiResponse(code = 85523, message = "主键,不能为空"),
            @ApiResponse(code = 85524, message = "数据集名称，不能为空"),
            @ApiResponse(code = 85525, message = "数据集标识，不能为空"),
            @ApiResponse(code = 85526, message = "数据集类型，不能为空"),
            @ApiResponse(code = 85527, message = "更新频率，不能为空"),
            @ApiResponse(code = 85528, message = "创建理由，不能为空"),
            @ApiResponse(code = 85533, message = "审批中的数据集不能编辑"),
            @ApiResponse(code = 85515, message = " 创建数据集类型错误,只能是1到4"),
            @ApiResponse(code = 85516, message = "只有数据操作员才能操作"),
            @ApiResponse(code = 85534, message = " 数据源id，不能为空"),
            @ApiResponse(code = 85535, message = "更新方式,不能为空"),
            @ApiResponse(code = 85536, message = "更新方式不能为空"),
            @ApiResponse(code = 85549, message = "数据源不可用"),

    })
    public Result<CreateDSPdbFirstResDTO> saveCreateDatabaseDataSetFirst(@RequestBody CreateDSPdbFirstReqDTO param) throws Exception {
        BizAssert.assertNotNull(ExchangeExceptionCode.CREATEDATASET_CREATEDSPDBFIRSTREQDTO_DBID, param.getDbId());
        BizAssert.assertNotNull(ExchangeExceptionCode.CREATEDATASET_CREATEDSPDBFIRSTREQDTO_UPDATETYPE, param.getUpdateType());

        ShareDataSet dataSet;
        CreateDSPdbFirstResDTO res = new CreateDSPdbFirstResDTO();

        List<DatabaseTableDTO> allTableInfo = dataBaseDescManager.getAllTableNamesInfo(param.getDbId());
        if (allTableInfo == null) {
            return Result.fail(ExchangeExceptionCode.CREATE_DATA_SET_SOURCE_NOT_USER);
        }

        if (param.getEditType() == 1 || param.getEditType() == 2) {
            ShareDbSource shareDbSource = shareDbSourceService.getById(param.getDbId());
            if (shareDbSource == null) {
                return Result.fail(ExchangeExceptionCode.CREATEDATASET_DBSOURCE_NOT_HAS);
            }
            dataSet = saveCreateDataSet(param);
            //5,添加接入部门
            shareJoinOrgService.insertJoinOrg(dataSet.getUnitId(), dataSet.getCreateUser());

            ShareDataSet old = shareDataSetService.getShareDataSetBySetCode(param.getSetCode());
            if (old == null) {
                shareDataSetService.saveSelective(dataSet);
            } else {
                dataSet.setId(old.getId());
                shareDataSetService.updateByIdSelective(dataSet);
                //上架过的,从正式表更新最近10条数据到过度表，保证后面的修改的正确
                if (old.getStatus() == 3) {
                    updateDataOverTable(old);
                }
            }
        } else {
            dataSet = shareDataSetService.getById(param.getId());
        }
        res.setTableCode(dataSet.getTableCode());
        res.setAllTable(allTableInfo);
        res.setId(dataSet.getId());
        return Result.success(res);
    }

    /**
     * 描述：创建数据库类型数据集第二步提交
     * 参数：
     * 返回值：
     * 修改人：gbl
     * 修改时间：2018/4/24
     * 修改内容：
     */
    @RequestMapping(value = "createDatabaseDataSetSecond", method = RequestMethod.POST)
    @ApiOperation(value = "创建数据库类型数据集第二步提交", notes = "创建数据库类型数据集第二步提交")
    @ApiResponses({
            @ApiResponse(code = 85537, message = "编辑类型,1新增，2编辑，3详情，不能为空"),
            @ApiResponse(code = 85538, message = "数据集id，不能为空"),
            @ApiResponse(code = 85539, message = "创建数据集方式:1,选择字段;2,sql查询，不能为空"),
            @ApiResponse(code = 85540, message = "表名标识，不能为空"),
            @ApiResponse(code = 85542, message = "返回的字段名称列表，不能为空"),
            @ApiResponse(code = 85543, message = "SQL语句，不能为空"),
            @ApiResponse(code = 85505, message = "SQL语句错误"),
    })
    public Result<CreateDSPdbSecondResDTO> createDatabaseDataSetSecond(@RequestBody CreateDSPdbSecondReqDTO param) throws Exception {
        BizAssert.assertNotNull(ExchangeExceptionCode.CREATEDATASET_CREATEDSPDBSECONDREQDTO_EDITTYPE, param.getEditType());
        BizAssert.assertNotNull(ExchangeExceptionCode.CREATEDATASET_CREATEDSPDBSECONDREQDTO_ID, param.getId());
        BizAssert.assertNotNull(ExchangeExceptionCode.CREATEDATASET_CREATEDSPDBSECONDREQDTO_SETMODE, param.getSetMode());


        ShareDataSet shareDataSet = shareDataSetService.getById(param.getId());
        if (shareDataSet == null) {
            return Result.fail(ExchangeExceptionCode.CREATEDATASET_CREATEDATASETPARAMFILEDTO_DATASET_NOT);
        }

        // 创建数据集方式:1,选择字段;2,sql查询
        int setMode = param.getSetMode();
        if (setMode < 1 || setMode > 2) {
            return Result.fail(ExchangeExceptionCode.CREATEDATASET_CREATEDATASETPARAMDTO_SQL_TYPE_ERROR);
        }
        shareDataSet.setSetMode(setMode);

        Result<CreateDSPdbSecondResDTO> res;
        if (setMode == 1) {
            res = saveFieldSelectCreateDBSetFirst(shareDataSet, param);
        } else {
            res = saveSqlSelectCreateDBSet(param, shareDataSet);
        }
        if (res.isSuccess()) {
            shareDataSetService.updateByIdSelective(shareDataSet);
            res.getData().setDbId(shareDataSet.getDbId());
            res.getData().setTableCode(shareDataSet.getSourceDbCode());//这里返回的是数据源的表名
        }
        return res;
    }

    public Result<CreateDSPdbSecondResDTO> saveSqlSelectCreateDBSet(CreateDSPdbSecondReqDTO param, ShareDataSet shareDataSet) throws Exception {
        String sqlCode;
        List<DataSetElementDTO> resultFileName;
        if (param.getSqlCode() != null) {
            sqlCode = param.getSqlCode();
        } else {
            sqlCode = shareDataSet.getSqlCode();
        }
        String[] sqlKeyWord = new String[]{"alter", "relpace", "insert", "drop", "truncate"};
        sqlCode = sqlCode.split(";")[0];
        if ((sqlCode.indexOf("SELECT") < 0 && sqlCode.indexOf("select") < 0)
                || StringUtils.containsAny(sqlCode.toLowerCase(), sqlKeyWord)) {
            return new Result(1, null, ExchangeExceptionCode.CREATEDATASET_CREATEDATASETPARAMDTO_SQL_ERROR.getMsg());
        }
        QueryData queryData = dataBaseDescManager.executeQuery(shareDataSet.getDbId(), sqlCode, 1, 2);
        if (StringUtils.isNotEmpty(queryData.getMsg())) {
            return Result.fail(queryData.getMsg());
        }

        Map<String, DataSetElementDTO> dataSetElementMp = queryData.getDataSetElementMp();
        if (param.getSqlCode() != null) {
            //验证sql语句，不能有 “删除”相关的语句(alter,relpace,inseret,inseret,update,drop,TRUNCATE)，只能是 select 开头
            //验证sql字已经的返回值是否包含以前已经有的字段
            List<ShareDataSetElement> allBySetIdCanUse = shareDataSetElementService.getAllBySetIdCanUse(shareDataSet.getId());
            if (!allBySetIdCanUse.isEmpty()) {
                for (ShareDataSetElement sdss : allBySetIdCanUse) {
                    String fCode = sdss.getFieldCode();
                    DataSetElementDTO elementDTO = dataSetElementMp.remove(fCode);
                    if (elementDTO == null) {
                        return Result.fail("返回的数据不包含设置的的字段:" + fCode);
                    }
                    if (sdss.getFieldType().indexOf(elementDTO.getFieldType()) < 0) {
                        return Result.fail("设置的字段:" + fCode + " 设置的类型:" + sdss.getFieldType() + " 和sql语句返回的类型:" + elementDTO.getFieldType() + "不一致");
                    }
                    elementDTO.setFieldName(sdss.getFieldName());
                }
            }

            if (!allBySetIdCanUse.isEmpty() && !dataSetElementMp.isEmpty()) {
                StringBuilder msg = new StringBuilder("sql语句返回的字段");
                for (DataSetElementDTO sds : dataSetElementMp.values()) {
                    msg.append(sds.getFieldCode());
                    msg.append(",");
                }
                msg.append("没有设置在字段列表中设置");
                return Result.fail(msg.toString());
            }
            shareDataSet.setSqlCode(sqlCode);
            resultFileName = queryData.getFileds();
        } else {
            resultFileName = param.getResultFileName();
        }

        CreateDSPdbSecondResDTO res = new CreateDSPdbSecondResDTO();
        //处理字段
        saveDealSelectResField(shareDataSet, resultFileName, dataSetElementMp);

        shareDataSetService.updateByIdSelective(shareDataSet);

        res.setId(shareDataSet.getId());
        return Result.success(res);
    }

    /**
     * 描述：创建数据库类型数据集第三步提交
     * 参数：
     * 返回值：
     * 修改人：gbl
     * 修改时间：2018/4/24
     * 修改内容：
     */
    @RequestMapping(value = "createDatabaseDataSetThird", method = RequestMethod.POST)
    @ApiOperation(value = "创建数据库类型数据集第三步提交", notes = "创建数据库类型数据集第三步提交")
    @ApiResponses({
            @ApiResponse(code = 85544, message = "编辑类型，不能为空"),
            @ApiResponse(code = 85545, message = "数据集id，不能为空"),
            @ApiResponse(code = 85546, message = "参数字段，不能为空"),
    })
    public Result<CreateDSPdbThirdResTDO> createDatabaseDataSetThird(@RequestBody CreateDSPdbThirdReqTDO param) throws Exception {
        BizAssert.assertNotNull(ExchangeExceptionCode.CREATEDATASET_CREATEDSPDBTHIRDREQTDO_EDITTYPE, param.getEditType());
        BizAssert.assertNotNull(ExchangeExceptionCode.CREATEDATASET_CREATEDSPDBTHIRDREQTDO_ID, param.getId());

        CreateDSPdbThirdResTDO cdres = new CreateDSPdbThirdResTDO();

        ShareDataSet shareDataSet = shareDataSetService.getById(param.getId());
        if (shareDataSet == null) {
            return Result.fail(ExchangeExceptionCode.CREATEDATASET_CREATEDATASETPARAMFILEDTO_DATASET_NOT);
        }

        List<DataSetElementDTO> fieldList = new ArrayList<>();
        //验证参数选择
        List<FieldParamDTO> paramFileds = param.getParamFileds();//参数数据
        Long adminId = BaseContextHandler.getAdminId();
        String unitId = getUserUnitId();

        DatabaseTableDTO tableInfo = dataBaseDescManager.getTableInfo(shareDataSet.getDbId(), shareDataSet.getSourceDbCode());
        Map<String, ShareDataSetFilterWare> oldMap = shareDataSetFilterWareService.getShareDataSetFilterMap(shareDataSet.getId());
        Map<String, ShareDataSetFilter> editMap = shareDataSetFilterService.getShareDataSetFilterMap(shareDataSet.getId());

        List<ShareDataSetFilter> saveList = new ArrayList<>();
        List<ShareDataSetFilter> updateList = new ArrayList<>();
        //选择参数选择
        if (paramFileds != null && paramFileds.size() > 0) {
            for (FieldParamDTO fpd : paramFileds) {
                int rule = fpd.getRule();
                FieldRoule roule = FieldRoule.getFieldRouleById(rule);
                if (roule == null) {
                    BizAssert.fail(ExchangeExceptionCode.CREATEDATASET_CREATEDATASETPARAMDTO_ROLUE_FIELD);
                }

                DataSetElementDTO df = tableInfo.isContaint(fpd.getFieldCode());

                if (df == null) {
                    BizAssert.fail(ExchangeExceptionCode.CREATEDATASET_CREATEDATASETPARAMDTO_HAS_NOT_FIELD);
                } else {
                    fieldList.add(df);

                    ShareDataSetFilterWare ele = oldMap.remove(df.getFieldCode());
                    ShareDataSetFilter editEle = editMap.remove(df.getFieldCode());

                    ShareDataSetFilter nowElel = new ShareDataSetFilter();

                    nowElel.setUpdateUser(adminId);
                    nowElel.setFieldCode(df.getFieldCode());
                    nowElel.setFieldName(df.getFieldName());
                    nowElel.setFieldType(df.getFieldType());
                    nowElel.setSetId(shareDataSet.getId());
                    nowElel.setScrRule(fpd.getRule());
                    nowElel.setScrValue(fpd.getValue());
                    nowElel.setUpdateUser(adminId);

                    if (ele != null) {
                        ShareDataSetFilter old = dozerUtils.map(ele, ShareDataSetFilter.class);
                        nowElel.setId(ele.getId());
                        if (!nowElel.equals(old)) {
                            nowElel.setOptType(2);
                        } else {
                            nowElel.setOptType(4);
                        }
                        updateList.add(nowElel);
                    } else {
                        nowElel.setOptType(1);
                        if (editEle != null) {
                            nowElel.setId(editEle.getId());
                            updateList.add(nowElel);
                        } else {
                            nowElel.setCreateUser(adminId);
                            nowElel.setUnitId(unitId);
                            saveList.add(nowElel);
                        }
                    }
                    df.setId(nowElel.getId());
                }
            }

            cdres.setId(shareDataSet.getId());
            cdres.setFieldList(fieldList);
        }

        //没有选择的都是删除
        for (ShareDataSetFilter ele : editMap.values()) {
            ele.setOptType(3);
            ele.setUpdateUser(adminId);
            updateList.add(ele);
        }

        shareDataSetFilterService.save(saveList);
        shareDataSetFilterService.updateByIdSelective(updateList);

        cdres.setId(shareDataSet.getId());
        cdres.setDbId(shareDataSet.getDbId());
        cdres.setTableCode(shareDataSet.getTableCode());
        return Result.success(cdres);
    }

    /***
     * 得到数据集目录关联字段信息
     * @param shareDataSet
     * @return
     */
    private List<RelatedDirectoryDTO> getRelatedDirectoryDTOS(ShareDataSet shareDataSet) {
        List<RelatedDirectoryDTO> relatedDirectory = new ArrayList<>();
        //关联的的目录
        Map<Long, ShareDataSetDir> shareDataSetDirMap = shareDataSetDirService.getShareDataSetDirBySetIdNotDele(shareDataSet.getId());
        ArrayList<Long> dirIds = Lists.newArrayList(shareDataSetDirMap.keySet().iterator());
        if (!dirIds.isEmpty()) {
            ShareDataDirectoryExample sdde = new ShareDataDirectoryExample();
            ShareDataDirectoryExample.Criteria sddec = sdde.createCriteria();
            sddec.andIdIn(dirIds);
            List<ShareDataDirectory> directories = dataDirectoryService.find(sdde);

            for (ShareDataDirectory sddd : directories) {
                RelatedDirectoryDTO rdd = new RelatedDirectoryDTO();
                rdd.setDirectoryId(sddd.getId());
                rdd.setName(sddd.getDirName());
                //关联的字段

                List<ShareDataElementWare> shareDataElementWares = dataElementWareService.queryByDirId(sddd.getId());
                Map<Long, ShareDataSetDirElement> shareDataSetDirElements = shareDataSetDirElementService.getShareDataSetDirElementBySetIdAndDirId(shareDataSet.getId(), sddd.getId());
                Map<Long, DirectoryField2DataFieldDTO> fileMap = new HashMap<>();

                for (ShareDataElementWare sddw : shareDataElementWares) {
                    ShareDataSetDirElement sdds = shareDataSetDirElements.remove(sddw.getId());
                    DirectoryField2DataFieldDTO dfd = new DirectoryField2DataFieldDTO();
                    dfd.setId(sddw.getId());
                    dfd.setFieldCode(sddw.getFieldCode());
                    dfd.setFieldName(sddw.getFieldName());
                    dfd.setFieldType(sddw.getFieldType());
                    if (sdds != null && sdds.getOptType() != 2) {
                        dfd.setSetField(sdds.getSetFieldCode());
                    }
                    fileMap.put(dfd.getId(), dfd);
                }
                rdd.setList(Lists.newArrayList(fileMap.values().iterator()));
                relatedDirectory.add(rdd);
            }
        }

        return relatedDirectory;
    }

    /***
     * 字段选择创建数据库数据集,返回字段
     * @param param
     * @throws Exception
     */
    private Result<CreateDSPdbSecondResDTO> saveFieldSelectCreateDBSetFirst(ShareDataSet shareDataSet, CreateDSPdbSecondReqDTO param) throws Exception {
        BizAssert.assertNotEmpty(ExchangeExceptionCode.CREATEDATASET_CREATEDSPDBSECONDREQDTO_RESULTFILENAME, param.getResultFileName());

        DatabaseTableDTO tableInfo = dataBaseDescManager.getTableInfo(shareDataSet.getDbId(), param.getTableCode());

        //处理选择字段
        saveDealSelectResField(shareDataSet, param.getResultFileName(), tableInfo.getDataSetElementMap());

        //设置数据总条数
        shareDataSet.setSourceDbCode(param.getTableCode());

        CreateDSPdbSecondResDTO res = new CreateDSPdbSecondResDTO();
        res.setId(shareDataSet.getId());
        res.setFieldList(tableInfo.getFieldList());

        return Result.success(res);
    }

    /***
     * 从正式表更新最近10条数据到过度表，保证后面的修改的正确
     * @param shareDataSet
     * @throws Exception
     */
    private void updateDataOverTable(ShareDataSet shareDataSet) throws Exception {
        String formalTableName = shareDataSet.getFormalTableCode();
        if (StringUtils.isEmpty(formalTableName)) {
            return;
        }
        Connection connection = DataBaseSql.getConnection();
        if (!DataBaseSql.exitTable(formalTableName, connection)) {
            return;
        }
        //更新表
        PreparedStatement stmt = null;
        try {
            connection.setAutoCommit(false);
            //从正式表更新最近10条数据到过度表，保证后面的修改的争取性
            String truncate = "truncate table  " + shareDataSet.getTableCode();
            stmt = connection.prepareStatement(truncate);
            stmt.execute();

            String replaceSql = getInsetOverTableStr(shareDataSet);
            stmt = connection.prepareStatement(replaceSql.toString());
            stmt.execute();
            connection.commit();
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        } finally {
            if (stmt != null) {
                stmt.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
    }

    /***
     * 得到插入数据到过度表的sql
     * @param shareDataSet
     * @return
     */
    private String getInsetOverTableStr(ShareDataSet shareDataSet) {
        String tableCode = shareDataSet.getTableCode();
        String formalTableName = DataBaseSql.getFormalTableName(tableCode);
        DatabaseTableDTO oldTable = dataBaseDescManager.getLocalTableInfo(formalTableName);
        StringBuilder replaceSql = new StringBuilder("REPLACE INTO ");
        replaceSql.append(tableCode);
        replaceSql.append(" ( ");

        StringBuilder columStr = new StringBuilder();
        for (int i = 0; i < oldTable.getFieldList().size(); i++) {
            if (i != 0) {
                columStr.append(",");
            }
            DataSetElementDTO dsed = oldTable.getFieldList().get(i);
            columStr.append("`");
            columStr.append(dsed.getFieldCode());
            columStr.append("`");
        }
        replaceSql.append(columStr);
        replaceSql.append(" ) ");

        replaceSql.append(" SELECT ");
        replaceSql.append(columStr);
        replaceSql.append(" FROM ");
        replaceSql.append(formalTableName);
        replaceSql.append(" ORDER BY  `synctime` DESC ");
        replaceSql.append(" LIMIT 10 ");
        return replaceSql.toString();
    }


    /***
     * 处理选择返回的字段
     * @param slelecResFileNames  选择返回的字段
     * @param allResFieldMap  所有可以返回的字段
     */

    private void saveDealSelectResField(ShareDataSet shareDataSet, List<DataSetElementDTO> slelecResFileNames, Map<String, DataSetElementDTO> allResFieldMap) throws Exception {
        Long userId = BaseContextHandler.getAdminId();
        String unitId = getUserUnitId();

        Map<String, ShareDataSetElementWare> oldMap = shareDataSetElementWareService.getShareDataSetElementBySetId(shareDataSet.getId());
        Map<String, ShareDataSetElement> oldEditMap = shareDataSetElementService.getShareDataSetElementBySetId(shareDataSet.getId());

        List<ShareDataSetElement> firstAddList = new ArrayList<>();
        List<ShareDataSetElement> updateList = new ArrayList<>();
        Map<Long, ShareDataSetElement> oldElseMap = new HashMap<>();
        for (DataSetElementDTO dse : slelecResFileNames) {
            String fCode = dse.getFieldCode();
            DataSetElementDTO elementDTO = allResFieldMap.get(fCode);
            if (elementDTO == null && shareDataSet.getSetMode() == 1) {
                BizAssert.fail(ExchangeExceptionCode.CREATEDATASET_CREATEDATASETPARAMDTO_HAS_NOT_FIELD);
            } else {
                ShareDataSetElementWare oldEle = oldMap.remove(fCode);
                ShareDataSetElement editEle = oldEditMap.remove(fCode);

                ShareDataSetElement nowEle = new ShareDataSetElement();
                nowEle.setUnitId(getUserUnitId());
                nowEle.setFieldCode(fCode);
                nowEle.setSetId(shareDataSet.getId());
                if (shareDataSet.getSetMode() == 1) {
                    nowEle.setFieldType(StringUtils.isEmpty(dse.getFieldType()) ? elementDTO.getHasLengthFieldType() : dse.getHasLengthFieldType());
                } else {//sql类型的全部由前端来
                    nowEle.setFieldType(dse.getHasLengthFieldType());
                }
                nowEle.setFieldName(StringUtils.isEmpty(dse.getFieldName()) ? elementDTO.getFieldName() : dse.getFieldName());

                if (oldEle != null) {
                    nowEle.setUpdateUser(userId);
                    nowEle.setId(oldEle.getId());
                    ShareDataSetElement old = dozerUtils.map(oldEle, ShareDataSetElement.class);
                    if (!nowEle.equals(old)) {
                        nowEle.setOptType(2);
                    } else {
                        nowEle.setOptType(4);
                    }
                    updateList.add(nowEle);
                    oldElseMap.put(oldEle.getId(), editEle);
                } else {
                    nowEle.setOptType(1);//1,新增；2，修改；3，删除；4，正常
                    if (editEle != null) {
                        nowEle.setId(editEle.getId());
                        nowEle.setUpdateUser(userId);
                        updateList.add(nowEle);
                        oldElseMap.put(editEle.getId(), editEle);
                    } else {
                        nowEle.setUnitId(unitId);
                        nowEle.setCreateUser(userId);
                        firstAddList.add(nowEle);
                    }
                }
            }
        }
        //剩下没有选择的，全是删除操作
        for (ShareDataSetElement ele : oldEditMap.values()) {
            ele.setOptType(3);
            ele.setUpdateUser(userId);
            updateList.add(ele);
        }

        //过度表处理
        Connection connection = DataBaseSql.getConnection();
        connection.setAutoCommit(false);

        ArrayList<ShareDataSetElement> allFileds = Lists.newArrayList(firstAddList);
        allFileds.addAll(updateList);
        try {
            updateOverTable(shareDataSet, allFileds, connection);

            shareDataSetElementService.save(firstAddList);
            shareDataSetElementService.updateByIdSelective(updateList);

            connection.commit();
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    log.error(e.getMessage(), e);
                    throw e;
                }
            }
        }

    }

    /***
     * 更新过度表操作
     * @param shareDataSet
     * @param allFileds
     * @param oldElseMap
     * @param connection
     * @throws Exception
     */
    private void updateOverTable(ShareDataSet shareDataSet, List<ShareDataSetElement> allFileds, Connection connection) throws Exception {
        try {
            String tableName;
            if (StringUtils.isEmpty(shareDataSet.getTableCode())) {
                tableName = DataBaseSql.getOverTableName();
                DataBaseSql.createTable(tableName, shareDataSet.getSetName(), connection);
            } else {
                tableName = shareDataSet.getTableCode();
            }

            DatabaseTableDTO oldTable = dataBaseDescManager.getLocalTableInfo(tableName);
            Map<String, DataSetElementDTO> oldTableFiledMap = oldTable.getDataSetElementMap();
            for (ShareDataSetElement sdse : allFileds) {
                DataSetElementDTO nowField = new DataSetElementDTO();
                nowField.setFieldCode(sdse.getFieldCode());
                nowField.setFieldType(sdse.getFieldType());
                DataSetElementDTO oldTableFiled = oldTableFiledMap.get(sdse.getFieldCode());
                boolean optIsSucceed = true;
                if (sdse.getOptType() == 1 || sdse.getOptType() == 2) { //1,新增；2，修改；3，删除；4，正常
                    if (oldTableFiled == null) { //表还没有
                        optIsSucceed = DataBaseSql.alterTableAdd(tableName, nowField, connection);
                    } else {
                        optIsSucceed = DataBaseSql.alterModify(tableName, oldTableFiled, nowField, connection);
                    }
                } else if (sdse.getOptType() == 3) {
                    if (oldTableFiled != null) {
                        optIsSucceed = DataBaseSql.dropTableElement(tableName, nowField, connection);
                    }
                }

                if (!optIsSucceed) {
                    String msg = "修改字段:" + sdse.getFieldCode() + " 失败，请确认字段类型是否可以修改";
                    BizAssert.fail(ExchangeExceptionCode.MODIFY_TABLE_FIELD_FAILE.getCode(), msg);
                }
            }
            shareDataSet.setTableCode(tableName);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    /**
     * 描述：选择关联目录
     * 参数：
     * 返回值：
     * 修改人：gbl
     * 修改时间：2018/4/23
     * 修改内容：
     */
    @RequestMapping(value = "selectDic", method = RequestMethod.POST)
    @ApiOperation(value = "选择关联目录", notes = "选择关联目录")
    @ApiResponses({
            @ApiResponse(code = 85547, message = "数据集id，不能为空"),
            @ApiResponse(code = 85548, message = "选择关联的目录，不能为空"),
            @ApiResponse(code = 85504, message = "数据集不存在"),
            @ApiResponse(code = 85522, message = "编辑类型，不能为空"),
    })
    public Result<Boolean> saveSelectDic(@RequestBody SelectDirectoryReqDTO param) {
        BizAssert.assertNotNull(ExchangeExceptionCode.CREATEDATASET_CREATEDATASETPARAMFILEDTO_EDITTYPE, param.getEditType());
        BizAssert.assertNotNull(ExchangeExceptionCode.SELECTDIC_SELECTDIRECTORYREQDTO_ID, param.getId());
        BizAssert.assertNotEmpty(ExchangeExceptionCode.SELECTDIC_SELECTDIRECTORYREQDTO_DIRECTORY, param.getDirectory());

        ShareDataSet shareDataSet = shareDataSetService.getById(param.getId());
        if (shareDataSet == null) {
            return Result.fail(ExchangeExceptionCode.CREATEDATASET_CREATEDATASETPARAMFILEDTO_DATASET_NOT);
        }
        //目录关联处理
        List<RelatedDirectoryDTO> directory = param.getDirectory();
        saveRelatedDirectory(shareDataSet.getId(), directory);

        shareDataSet.setStatus(1);
        shareDataSetService.updateByIdSelective(shareDataSet);

        ShareDataSetFlow sdsf = shareDataSetFlowService.getShareDataSetFlowByApplyCode(shareDataSet.getApplyCode());

        sdsf.setUpdateTime(new Date());
        sdsf.setSetId(shareDataSet.getId());
        shareDataSetFlowService.updateByIdSelective(sdsf);

        //开启流程
        shareFlowService.saveStartFlow(2, shareDataSet.getApplyCode(), ExchangeConstants.FLOW_SET_CODE, shareDataSet.getCreateUser(), shareDataSet.getUnitId());
        return Result.success(true);
    }

    /***
     * 目录字段关联
     * @param setId
     * @param directory
     */
    public void saveRelatedDirectory(long setId, List<RelatedDirectoryDTO> directory) {
        Map<Long, ShareDataSetDir> shareDataSetDirs = shareDataSetDirService.getShareDataSetDirBySetId(setId);
        for (RelatedDirectoryDTO rdd : directory) {
            ShareDataSetDir shareDataSetDir = shareDataSetDirs.remove(rdd.getDirectoryId());
            //处理目录数据
            int optType = 1;
            if (shareDataSetDir != null) {
                optType = 3;
            }
            saveOneRelatedDirectory(setId, rdd, shareDataSetDir, optType);
        }
        //身下的全是删除的
        for (ShareDataSetDir sd : shareDataSetDirs.values()) {
            saveOneRelatedDirectory(setId, null, sd, 2);
        }
    }

    /***
     * 参数 rdd 和shareDataSetDir 不能同时为null
     * @param setId
     * @param rdd
     * @param shareDataSetDir
     * @param optType  操作类型(:1,新增,2，删除,3，正常,
     */
    private void saveOneRelatedDirectory(long setId, RelatedDirectoryDTO rdd, ShareDataSetDir shareDataSetDir, int optType) {
        Long userId = BaseContextHandler.getAdminId();
        long dirId = rdd != null ? rdd.getDirectoryId() : shareDataSetDir.getDirId();

        //处理目录数据
        if (shareDataSetDir == null) {
            shareDataSetDir = new ShareDataSetDir();
            shareDataSetDir.setCreateTime(new Date());
            shareDataSetDir.setDirId(dirId);
            shareDataSetDir.setSetId(setId);
            shareDataSetDir.setOptType(optType);
            shareDataSetDir.setCreateUser(userId);
            shareDataSetDirService.saveSelective(shareDataSetDir);
        } else {
            shareDataSetDir.setOptType(optType);
            shareDataSetDir.setUpdateUser(userId);
            shareDataSetDirService.updateById(shareDataSetDir);
        }

        //处理字段
        Map<Long, ShareDataSetDirElement> shareDataSetDirElementMap = shareDataSetDirElementService.getShareDataSetDirElementBySdid(shareDataSetDir.getId());

        List<ShareDataSetDirElement> saveEles = new ArrayList<>();
        List<ShareDataSetDirElement> updataEles = new ArrayList<>();
        if (rdd != null && rdd.getList() != null && rdd.getList().size() > 0) {
            for (DirectoryField2DataFieldDTO ddf : rdd.getList()) {
                if (StringUtils.isBlank(ddf.getSetField())) {//选择的数据集字段为空说明没有选择
                    continue;
                }
                //弹出选择的，最后剩下的就是没有选择的，也就是删除的
                ShareDataSetDirElement ele = shareDataSetDirElementMap.remove(ddf.getId());
                if (optType == 2 && ele != null) {//如果是删除目录操作，那么所有字段都是删除操作
                    ele.setOptType(2);
                    updataEles.add(ele);
                } else {
                    ShareDataSetDirElement nowEle = new ShareDataSetDirElement();
                    nowEle.setDirId(rdd.getDirectoryId());
                    nowEle.setDirFieldId(ddf.getId());
                    nowEle.setDirFieldCode(ddf.getFieldCode());
                    nowEle.setDirFieldName(ddf.getFieldName());
                    nowEle.setSetFieldCode(ddf.getSetField());
                    nowEle.setSdId(shareDataSetDir.getId());
                    nowEle.setSetId(setId);
                    if (ele == null) {
                        nowEle.setCreateUser(userId);
                        nowEle.setOptType(1);//1,新增；2，删除；3，编辑，4,正常,
                        saveEles.add(nowEle);
                    } else {
                        nowEle.setId(ele.getId());
                        nowEle.setUpdateUser(userId);
                        nowEle.setCreateUser(ele.getCreateUser());
                        nowEle.setCreateTime(ele.getCreateTime());
                        if (nowEle.equals(ele)) {//相等是正常，不相等就编辑
                            nowEle.setOptType(4);
                        } else {
                            nowEle.setOptType(3);
                            updataEles.add(nowEle);
                        }

                    }
                }
            }
        }
        //剩下的全是删除的，审批通过时，要删除数据
        for (ShareDataSetDirElement ele : shareDataSetDirElementMap.values()) {
            ele.setUpdateUser(userId);
            ele.setOptType(2);
            updataEles.add(ele);
        }
        shareDataSetDirElementService.save(saveEles);
        shareDataSetDirElementService.updateByIdSelective(updataEles);
    }

    /**
     * 描述：创建API数据集第一步提交
     * 参数：
     * 返回值：com.hengyunsoft.base.Result<com.hengyunsoft.platform.exchange.api.set.dto.CreateDPApiFirstResDTO>
     * 修改人：gbl
     * 修改时间：2018/4/24
     * 修改内容：
     */
//    @RequestMapping(value = "createApiDataSetFirst", method = RequestMethod.POST)
//    @ApiOperation(value = "创建API数据集第一步提交", notes = "创建API数据集第一步提交")
//    @ApiResponses({
//            @ApiResponse(code = 85502, message = "API调用失败"),
//            @ApiResponse(code = 85503, message = "API返回类型错误，只能是1和2"),
//            @ApiResponse(code = 85521, message = "集合编码重复"),
//            @ApiResponse(code = 85522, message = "编辑类型，不能为空"),
//            @ApiResponse(code = 85523, message = "主键,不能为空"),
//            @ApiResponse(code = 85524, message = "数据集名称，不能为空"),
//            @ApiResponse(code = 85525, message = "数据集标识，不能为空"),
//            @ApiResponse(code = 85526, message = "数据集类型，不能为空"),
//            @ApiResponse(code = 85527, message = "更新频率，不能为空"),
//            @ApiResponse(code = 85528, message = "创建理由，不能为空"),
//            @ApiResponse(code = 85533, message = "审批中的数据集不能编辑"),
//            @ApiResponse(code = 85515, message = " 创建数据集类型错误,只能是1到4"),
//            @ApiResponse(code = 85516, message = "只有数据操作员才能操作"),
//    })
//    public Result<CreateDPApiFirstResDTO> createApiDataSetFirst(@RequestBody CreateDPApiFirstReqDTO param) {
//        int dataType = param.getApiDataType();
//        if (dataType < 1 || dataType > 2) {
//            BizAssert.fail(ExchangeExceptionCode.CREATEDATASET_CREATEDSPDBDTO_API_TYOE_ERROR);
//        }
//
//        CreateDPApiFirstResDTO rescdf = new CreateDPApiFirstResDTO();
//        if (param.getEditType() == 1 || param.getEditType() == 2) {
//            QueryData queryData = apiDataDescManager.executeQuery(dataType, param.getApiUrl());
//            if (queryData == null) {
//                BizAssert.fail(ExchangeExceptionCode.CREATEDATASET_CREATEDSPDBDTO_API_FAILED);
//            }
//
//            List<DataSetElementDTO> fileds = queryData.getFileds();
//            if (fileds == null || fileds.size() == 0) {
//                BizAssert.fail(ExchangeExceptionCode.CREATEDATASET_CREATEDSPDBDTO_API_FAILED);
//            }
//
//            ShareDataSet dataSet = createDataSet(param);
//            dataSet.setDataCount(new Float(queryData.getRecords()));
//
//            ShareDataSet old = shareDataSetService.getShareDataSetBySetCode(param.getSetCode());
//            if (old == null) {
//                shareDataSetService.saveSelective(dataSet);
//            } else {
//                dataSet.setId(old.getId());
//                shareDataSetService.updateByIdSelective(dataSet);
//            }
//            rescdf.setId(dataSet.getId());
//            rescdf.setFieldList(fileds);
//        }
//        return Result.success(rescdf);
//    }

    /**
     * 描述：创建API数据集第二步提交
     * 参数：
     * 返回值：
     * 修改人：gbl
     * 修改时间：2018/4/24
     * 修改内容：
     */
//    @RequestMapping(value = "createApiDataSetScond", method = RequestMethod.POST)
//    @ApiOperation(value = "创建API数据集第二步提交", notes = "创建API数据集第二步提交")
//    public Result<CreateDPApiSecondResDTO> createApiDataSetScond(@RequestBody CreateDPApiSecondReqDTO param) throws Exception {
//
//        ShareDataSet shareDataSet = shareDataSetService.getById(param.getId());
//        if (shareDataSet == null) {
//            return Result.fail(ExchangeExceptionCode.CREATEDATASET_CREATEDATASETPARAMFILEDTO_DATASET_NOT);
//        }
//
//
//        CreateDPApiSecondResDTO rescd = new CreateDPApiSecondResDTO();
//        if (param.getEditType() == 1 || param.getEditType() == 2) {
//
//            QueryData queryData = apiDataDescManager.executeQuery(shareDataSet.getApiDataType(), shareDataSet.getApiUrl());
//            if (queryData == null) {
//                BizAssert.fail(ExchangeExceptionCode.CREATEDATASET_CREATEDSPDBDTO_API_FAILED);
//            }
//            List<DataSetElementDTO> fileds = queryData.getFileds();
//            Map<String, DataSetElementDTO> allFiledMap = new HashMap<>();
//            for (DataSetElementDTO dse : fileds) {
//                allFiledMap.put(dse.getFieldCode(), dse);
//            }
//            dealSelectResField(shareDataSet, param.getFieldList(), allFiledMap);
//            //rescd.setFieldList(nulll);
//        }
//        rescd.setId(shareDataSet.getId());
//        return Result.success(rescd);
//    }

    /**
     * 描述：生成得到数据集标识
     * 参数：
     * 返回值：
     * 修改人：gbl
     * 修改时间：2018/4/23
     * 修改内容：
     */
    @RequestMapping(value = "dataSetCode", method = RequestMethod.GET)
    @ApiOperation(value = "生成数据集标识", notes = "生成数据集标识")
    public Result<String> dataSetCode() {
        String set = ShareUtil.automaticCode(dataSetCode);
        return Result.success(set);
    }


    /**
     * 描述： 根据url获取数据
     * 参数：resType:API数据类型:1,jason;2,xml  url: api的地址
     * 返回值：
     * 修改人：gbl
     * 修改时间：2018/4/27
     * 修改内容：
     */
    @RequestMapping(value = "queryDataByUrl", method = RequestMethod.POST)
    @ApiOperation(value = "根据url获取数据", notes = "根据url获取数据")
    @ApiResponses({
            @ApiResponse(code = 85519, message = "url不能为空"),
            @ApiResponse(code = 85520, message = "返回值类型不能空"),
    })
    public Result<QueryDataResDTO> saveQueryDataByUrl(@RequestParam Integer resType, @RequestParam String url, @RequestParam("page") Long page) {
        BizAssert.assertNotNull(ExchangeExceptionCode.API_QUERY_DATA_RES_TYPE_NULL, resType);
        BizAssert.assertNotEmpty(ExchangeExceptionCode.API_QUERY_DATA_URL_NULL, url);
        QueryData queryData = apiDataDescManager.executeQuery(resType, url);
        QueryDataResDTO resDTO = new QueryDataResDTO();
        if (queryData != null) {
            resDTO.setRecords(queryData.getRecords());
            resDTO.setRowData(queryData.getRowData());
            resDTO.setFileds(queryData.getFileds());
        }
        return Result.success(resDTO);
    }

    /**
     * 描述：查询数据集字段
     * 参数：
     * 返回值：
     * 修改人：gbl
     * 修改时间：2018/5/8
     * 修改内容：
     */
    @RequestMapping(value = "queryDataSetField", method = RequestMethod.POST)
    @ApiOperation(value = "查询数据集字段", notes = "查询数据集字段")
    @ApiResponses({
            @ApiResponse(code = 85518, message = "数据集id不能为空"),

    })
    public Result<List<DataSetElementDTO>> queryDataSetField(@RequestParam("setId") Long setId) {
        BizAssert.assertNotNull(ExchangeExceptionCode.DATA_SET_ID_NULL, setId);
        ShareDataSetElementExample adse = new ShareDataSetElementExample();
        ShareDataSetElementExample.Criteria adsec = adse.createCriteria();
        adsec.andSetIdEqualTo(setId);
        List<ShareDataSetElement> setElements = shareDataSetElementService.find(adse);//数据集字段列表
        List<DataSetElementDTO> dataSetElementDTOS = dozerUtils.mapList(setElements, DataSetElementDTO.class);
        return Result.success(dataSetElementDTOS);
    }

    /**
     * 描述：根据数据集ID查询数据
     * 参数：
     * 返回值：
     * 修改人：gbl
     * 修改时间：2018/4/27
     * 修改内容：
     */
    @RequestMapping(value = "queryDataByDataSet", method = RequestMethod.POST)
    @ApiOperation(value = "根据数据集ID查询数据", notes = "根据数据集ID查询数据")
    @ApiResponses({
            @ApiResponse(code = 85518, message = "数据集id不能为空"),
            @ApiResponse(code = 85511, message = "请求页不能为空"),
    })
    public Result<QueryDataResDTO> getQueryDataByDataSet(@RequestParam("setId") Long setId, @RequestParam("page") Long page) throws Exception {
        BizAssert.assertNotNull(ExchangeExceptionCode.DATA_SET_ID_NULL, setId);
        BizAssert.assertNotNull(ExchangeExceptionCode.CREATEDATASET_CREATEDATASETPARAMDTO_PAGE_FIELD, page);
        ShareDataSet shareDataSet = shareDataSetService.getById(setId);
        if (shareDataSet == null) {
            return Result.fail(ExchangeExceptionCode.CREATEDATASET_CREATEDATASETPARAMFILEDTO_DATASET_NOT);
        }
        //状态:1，审批中；2，驳回；3，已上架；4，已下架,只有已经上架的才能查询数据
        if (shareDataSet.getStatus() != 3) {
            return Result.fail(ExchangeExceptionCode.CREATEDATASET_CREATEDATASETPARAMDTO_FLOWS_NOT_PASS);
        }


        ShareDataSetFilterExample sdse = new ShareDataSetFilterExample();
        ShareDataSetFilterExample.Criteria sdsec = sdse.createCriteria();
        sdsec.andSetIdEqualTo(setId);

        //数据集类型:1,非结构化文件；2，结构化文件；3，API调用；4，数据库读取
        Integer setType = shareDataSet.getSetType();
        if (setType != 3 && setType != 4) {
            return Result.fail(ExchangeExceptionCode.CREATEDATASET_CREATEDATASETPARAMDTO_DATA_GET_ERROR);
        }

//        ShareDataSetElementExample adse = new ShareDataSetElementExample();
//        ShareDataSetElementExample.Criteria adsec = adse.createCriteria();
//        adsec.andSetIdEqualTo(setId);
//        List<ShareDataSetElement> setElements = shareDataSetElementService.find(adse);//数据集字段列表

        QueryData queryData = null;
        if (setType == 3) {
            int apiDataType = shareDataSet.getApiDataType();//API数据类型:1,jason;2,xml
            String apiUrl = shareDataSet.getApiUrl();
            queryData = apiDataDescManager.executeQuery(apiDataType, apiUrl);
        } else if (setType == 4) {
            String SQL = getQuerySQL(shareDataSet);
            queryData = dataBaseDescManager.executeLocalQueryResQueryData(SQL, page.intValue(), pageSize);
            //queryData = dataBaseDescManager.executeQuery(shareDataSet.getDbId(), SQL, page, pageSize);
        }

        QueryDataResDTO resDTO = new QueryDataResDTO();
        if (queryData == null) {
            resDTO.setRecords(0);
            resDTO.setRowData(null);
            resDTO.setFileds(null);
        } else {
            resDTO.setRecords(queryData.getRecords());
            resDTO.setRowData(queryData.getRowData());
            resDTO.setFileds(queryData.getFileds());
        }
        return Result.success(resDTO);
    }

    /**
     * 描述：根据目录id查询数据
     * 参数：
     * 返回值：结果数据集
     * 修改人：gbl
     * 修改时间：2018/4/24
     * 修改内容：
     */
    @RequestMapping(value = "pageShowDataByDirectoryId", method = RequestMethod.POST)
    @ApiOperation(value = "根据目录id查询数据", notes = "根据目录id查询数据")
    @ApiResponses({
            @ApiResponse(code = 85510, message = "目录id不能为空"),
            @ApiResponse(code = 85511, message = "请求页不能为空"),
            @ApiResponse(code = 85512, message = "API或者数据库类型的数据集才能调用数据"),
            @ApiResponse(code = 85513, message = "当前书记没有审批通过不能查询数据"),
    })
    public Result<QueryDataResDTO> getPageShowDataByDirectoryId(@RequestParam("did") Long
                                                                        did, @RequestParam("page") Long page) throws Exception {
        BizAssert.assertNotNull(ExchangeExceptionCode.CREATEDATASET_CREATEDATASETPARAMDTO_DIR_FIELD, did);
        BizAssert.assertNotNull(ExchangeExceptionCode.CREATEDATASET_CREATEDATASETPARAMDTO_PAGE_FIELD, page);

        ShareDataDirectory directory = dataDirectoryService.getById(did);
        Long setId = directory.getSetId();//数据集

        ShareDataSet shareDataSet = shareDataSetService.getById(setId);
        if (shareDataSet == null) {
            return Result.fail(ExchangeExceptionCode.CREATEDATASET_CREATEDATASETPARAMFILEDTO_DATASET_NOT);
        }
        //状态:1，审批中；2，驳回；3，已上架；4，已下架,只有已经上架的才能查询数据
        if (shareDataSet.getStatus() != 3) {
            return Result.fail(ExchangeExceptionCode.CREATEDATASET_CREATEDATASETPARAMDTO_FLOWS_NOT_PASS);
        }

        ShareDataElementExample ac = new ShareDataElementExample();
        ShareDataElementExample.Criteria criteria = ac.createCriteria();
        criteria.andDirIdEqualTo(did);
        List<ShareDataElement> shareDataElements = dataElementService.find(ac);//目录字段列表

//        ShareDataSetElementExample adse = new ShareDataSetElementExample();
//        ShareDataSetElementExample.Criteria adsec = adse.createCriteria();
//        adsec.andSetIdEqualTo(setId);
//        List<ShareDataSetElement> setElements = shareDataSetElementService.find(adse);//数据集字段列表
//
//
//        ShareDataSetFilterExample sdse = new ShareDataSetFilterExample();
//        ShareDataSetFilterExample.Criteria sdsec = sdse.createCriteria();
//        sdsec.andSetIdEqualTo(setId);
//        List<ShareDataSetFilter> dataSetFilterList = shareDataSetFilterService.find(sdse);

        //数据集类型:1,非结构化文件；2，结构化文件；3，API调用；4，数据库读取
        Integer setType = shareDataSet.getSetType();
        if (setType < 3 || setType > 4) {
            return Result.fail(ExchangeExceptionCode.CREATEDATASET_CREATEDATASETPARAMDTO_DATA_GET_ERROR);
        }

        QueryData queryData = null;
        if (setType == 3) {
            int apiDataType = shareDataSet.getApiDataType();//API数据类型:1,jason;2,xml
            String apiUrl = shareDataSet.getApiUrl();
            queryData = apiDataDescManager.executeQuery(apiDataType, apiUrl);
        } else if (setType == 4) {
            String SQL = getQuerySQL(shareDataSet);
            queryData = dataBaseDescManager.executeQuery(shareDataSet.getDbId(), SQL, page, pageSize);
        }

        QueryDataResDTO resDTO = new QueryDataResDTO();
        if (queryData != null) {
            apiDataDescManager.filterFields(shareDataElements, queryData);
            resDTO.setRecords(queryData.getRecords());
            resDTO.setRowData(queryData.getRowData());
            resDTO.setFileds(queryData.getFileds());
        } else {
            resDTO.setRecords(0);
            resDTO.setRowData(null);
            resDTO.setFileds(null);
        }
        return Result.success(resDTO);
    }

    /**
     * 描述：根据apiId查询api数据集类型的数据
     * 参数：
     * 返回值：结果数据集
     * 修改人：gbl
     * 修改时间：2018/4/24
     * 修改内容：
     */
    @RequestMapping(value = "queryDataByAPIId", method = RequestMethod.POST)
    @ApiOperation(value = "根据apiId查询api数据集类型的数据", notes = "根据apiId查询api数据集类型的数据")
    @ApiResponses({
            @ApiResponse(code = 85510, message = "目录id不能为空"),
            @ApiResponse(code = 85512, message = "API或者数据库类型的数据集才能调用数据"),
            @ApiResponse(code = 85513, message = "当前数据集没有审批通过不能查询数据"),
            @ApiResponse(code = 85555, message = "该数据集不是API"),
            @ApiResponse(code = 86027, message = "找不到对应的API"),
    })
    public Result<QueryDataResDTO> getQueryDataByAPIId(@RequestParam("apiId") Long apiId) {
        return apiDataDescManager.queryDataByAPIId(apiId);
    }


    private String getQuerySQL(ShareDataSet shareDataSet) {
        //SELECT * FROM users WHERE 1=1
        StringBuffer sb = new StringBuffer("SELECT *");
//        for (int i = 0; i < setElements.size(); i++) {
//            ShareDataSetElement sd = setElements.get(i);
//            String setField = sd.getFieldCode();
//            sb.append(" " + setField + " ");
//            if (i < setElements.size() - 1) {
//                sb.append(",");
//            }
//        }

        sb.append(" FROM ");
        sb.append(shareDataSet.getFormalTableCode());
        sb.append(" WHERE 1=1 ");
        sb.append(" ORDER BY key_id ");

//        for (ShareDataSetFilter ssf : dataSetFilterList) {
//            String fieldCode = ssf.getFieldCode();
//            sb.append(" AND ");
//            sb.append(fieldCode);
//            //筛选规则:1,大于；2，小于；3，等于；4，模糊
//            Integer scrRule = ssf.getScrRule();
//            FieldRoule rule = FieldRoule.getFieldRouleById(scrRule);
//            sb.append(" " + rule.operator + " ");
//            String scrValue = ssf.getScrValue();
//            if (scrRule == 4) {
//                sb.append("%" + scrValue + "%");
//            } else {
//                sb.append(scrValue);
//            }
//        }
        return sb.toString();
    }


    private String getQueryCountSQL(ShareDataSet shareDataSet) {
        //SELECT * FROM users WHERE 1=1
        StringBuffer sb = new StringBuffer("SELECT count(0) as totalNum FROM ");
        sb.append(shareDataSet.getFormalTableCode());
        sb.append(" WHERE 1=1 ");
//        for (ShareDataSetFilter ssf : dataSetFilterList) {
//            String fieldCode = ssf.getFieldCode();
//            sb.append(" AND ");
//            sb.append(fieldCode);
//            //筛选规则:1,大于；2，小于；3，等于；4，模糊
//            Integer scrRule = ssf.getScrRule();
//            FieldRoule rule = FieldRoule.getFieldRouleById(scrRule);
//            sb.append(" " + rule.operator + " ");
//            String scrValue = ssf.getScrValue();
//            if (scrRule == 4) {
//                sb.append("%" + scrValue + "%");
//            } else {
//                sb.append(scrValue);
//            }
//        }
        return sb.toString();
    }

    /***
     * 获得用户单位id
     * @return
     */
    public String getUserUnitId() {
        Long adminId = BaseContextHandler.getAdminId();
        String unitId = commonService.getOrgIdByUserId(adminId);
        if (unitId == null) {
            unitId = "-1";
        }
        return unitId;
    }

    /**
     * 描述：查询数据集列表
     * 参数：[openApiReq]
     * 返回值：com.hengyunsoft.base.Result<com.github.pagehelper.PageInfo<com.hengyunsoft.platform.exchange.api.set.dto.QueryDataSetResEleDTO>>
     * 修改人：gbl
     * 修改时间：2018/5/2
     * 修改内容：
     */
    @RequestMapping(value = "find", method = RequestMethod.POST)
    @ApiOperation(value = "查询数据集列表", notes = "查询数据集列表")
    @ApiResponses({
            @ApiResponse(code = 85514, message = "查询参数不能为空"),
            @ApiResponse(code = 85516, message = "只有数据操作员才能操作"),
    })
    public Result<PageInfo<QueryDataSetResEleDTO>> getFind(@RequestBody OpenApiReq<QueryDataSetParamReqDTO> openApiReq) {
        BizAssert.assertNotNull(ExchangeExceptionCode.CREATEDATASET_CREATEDATASETPARAMDTO_PAGE_PARAM_NULL, openApiReq);
        Long userId = BaseContextHandler.getAdminId();
        //获取单位Id
        String unitId = commonService.getOrgIdByUserId(userId);
        //只有数据操作员才能才能创建数据集
        Boolean pt_admin_data_role_code = gxqPtRoleUnits.getGxqPtRole(userId, GxqPtRoleUnits.PT_ADMIN_DATA_ROLE_CODE);
        Boolean unity_admin_data_role_code = gxqPtRoleUnits.getGxqPtRole(userId, GxqPtRoleUnits.UNITY_ADMIN_DATA_ROLE_CODE);
        Boolean unity_admin_role_code = gxqPtRoleUnits.getGxqUnitRole(userId, unitId);
        Boolean pt_admin_role_code = gxqPtRoleUnits.getGxqPtRole(userId, GxqPtRoleUnits.PT_ADMIN_ROLE_CODE);

        if (!pt_admin_data_role_code && !unity_admin_data_role_code && !unity_admin_role_code && !pt_admin_role_code) {
            return Result.fail(ExchangeExceptionCode.CREATEDATASET_OPT_NEED_DATA_OPT);
        }


        Map<String, Object> param = new HashMap<>();

        if (openApiReq.getData() != null) {
            param.put("createUserName", openApiReq.getData().getCreateUserName());
            param.put("setName", openApiReq.getData().getSetName());
            param.put("setType", openApiReq.getData().getSetType());
            param.put("status", openApiReq.getData().getStatus());
            param.put("applyType", openApiReq.getData().getStatus());//1:新增，2:修改
            param.put("startTime", openApiReq.getData().getStartTime());
            param.put("endTime", openApiReq.getData().getEndTime());
            param.put("dirName", openApiReq.getData().getDirName());
        }
        param.put("unitId", unitId);

        if (pt_admin_role_code || pt_admin_data_role_code) {//平台管理员能够看见所有,非平台管理员只能看到本单位的
            param.put("unitId", null);
        }

        PageHelper.startPage(openApiReq.getPageNo(), openApiReq.getPageSize());
        List<ShareDataSetDO> list = shareDataSetService.findAllDataSetList(param);
        //找到关联的目录
        for (ShareDataSetDO sds : list) {
            if (sds.getRelatedDicCunt() == null || sds.getRelatedDicCunt() <= 0) {
                Map<Long, ShareDataSetDir> shareDataSetDirMap = shareDataSetDirService.getShareDataSetDirBySetIdNotDele(sds.getId());
                sds.setRelatedDicCunt(shareDataSetDirMap.size());
            }
        }

        return Result.success(new PageInfo<>(dozerUtils.mapPage(list, QueryDataSetResEleDTO.class)));
    }


    /**
     * 描述： 根据数据集id删除数据集集
     * 参数：数据集id
     * 返回值：
     * 修改人：gbl
     * 修改时间：2018/4/26
     * 修改内容：
     */
    @RequestMapping(value = "deleteDataSet", method = RequestMethod.POST)
    @ApiOperation(value = "根据数据集id删除数据集集", notes = "根据数据集id删除数据集集")
    @ApiResponses({
            @ApiResponse(code = 85518, message = "数据集id不能为空"),
            @ApiResponse(code = 85504, message = "数据集不存在"),
            @ApiResponse(code = 85517, message = "该数据集不能删除"),
    })
    public Result<Boolean> deleteDataSet(Long setId) {
        BizAssert.assertNotNull(ExchangeExceptionCode.DATA_SET_ID_NULL, setId);
        //流程处于 (驳回状态并且是新增类型)或者是(暂存状态-1)的可以删除
        ShareDataSet shareDataSet = shareDataSetService.getById(setId);
        if (shareDataSet == null) {
            BizAssert.fail(ExchangeExceptionCode.CREATEDATASET_CREATEDATASETPARAMFILEDTO_DATASET_NOT);
        }
        //状态:-1:暂存;1，审批中；2，驳回；3，已上架；4，已下架
        int status = shareDataSet.getStatus();
        if (!(status == -1 || status == 2)) {
            BizAssert.fail(ExchangeExceptionCode.CREATEDATASET_OPT_CAN_NOT);
        }

        Long userId = BaseContextHandler.getAdminId();
        Boolean isPtAdmin = gxqPtRoleUnits.getGxqPtRole(userId, GxqPtRoleUnits.PT_ADMIN_ROLE_CODE);
        Boolean isPtDataAdmin = gxqPtRoleUnits.getGxqPtRole(userId, GxqPtRoleUnits.PT_ADMIN_DATA_ROLE_CODE);
        Boolean isUnityDataAdmin = gxqPtRoleUnits.getGxqPtRole(userId, GxqPtRoleUnits.UNITY_ADMIN_DATA_ROLE_CODE);
        String userUnitId = getUserUnitId();
        Boolean unity_admin_role_code = gxqPtRoleUnits.getGxqUnitRole(userId, userUnitId);

        if (!isPtAdmin && !isPtDataAdmin && !isUnityDataAdmin && !unity_admin_role_code) {
            BizAssert.fail(ExchangeExceptionCode.CREATEDATASET_OPT_NEED_DATA_OPT);
        }

        if (status == -1) {
            shareDataSetService.deleteById(setId);
        } else {
            ShareDataSetFlowExample sdsfe = new ShareDataSetFlowExample();
            ShareDataSetFlowExample.Criteria sdsfec = sdsfe.createCriteria();
            sdsfec.andSetIdEqualTo(setId);
            ShareDataSetFlow setFlow = shareDataSetFlowService.getUnique(sdsfe);
            if (setFlow.getType() == 1) {
                shareDataSetService.deleteById(setId);
                shareDataSetDirService.deleteBySetId(setId);
                shareDataSetDirElementService.deleteBySetId(setId);
//                ShareDataSetElementExample elementExample = new ShareDataSetElementExample();
//                ShareDataSetElementExample.Criteria elementExampleCriteria = elementExample.createCriteria();
//                elementExampleCriteria.andSetIdEqualTo(setId);
//
//                List<ShareDataSetElement> shareDataSetElements = shareDataSetElementService.find(elementExample);
//                List<Long> rids = new ArrayList<>();
//                for (ShareDataSetElement sdes : shareDataSetElements) {
//                    rids.add(sdes.getId());
//                }
//                shareDataSetService.deleteByIds(rids);
                //shareDataSetElementService.removeByIds(rids);
                shareDataSetDirService.getShareDataSetDirBySetId(setId);
                //删除文件数据
                ShareDataSetFilterExample filterExample = new ShareDataSetFilterExample();
                ShareDataSetFilterExample.Criteria filterExampleCriteria = filterExample.createCriteria();
                filterExampleCriteria.andSetIdEqualTo(setId);
                List<ShareDataSetFilter> shareDataSetFilters = shareDataSetFilterService.find(filterExample);
                List<Long> srids = new ArrayList<>();
                for (ShareDataSetFilter sdsf : shareDataSetFilters) {
                    srids.add(sdsf.getId());
                }
                shareDataSetFilterService.deleteByIds(srids);

            } else {
                BizAssert.fail(ExchangeExceptionCode.CREATEDATASET_OPT_CAN_NOT);
            }
        }
        return Result.success(true);
    }

    /**
     * 描述：获取数据源表信息
     * 参数：
     * 返回值：
     * 修改人：gbl
     * 修改时间：2018/5/8
     * 修改内容：
     */
    @RequestMapping(value = "getAllTableNamesInfo", method = RequestMethod.POST)
    @ApiOperation(value = "获取数据源表信息", notes = "获取数据源表信息")
    @ApiResponses({
            @ApiResponse(code = 85500, message = "数据源id,不能为空"),
    })
    public Result<List<DatabaseTableDTO>> getAllTableNamesInfo(@RequestParam("dbId") Long dbId) {
        BizAssert.assertNotNull(ExchangeExceptionCode.CREATEDATASET_CREATEDSPDBDTO_DBID, dbId);
        List<DatabaseTableDTO> allTableNamesInfo = dataBaseDescManager.getAllTableNamesInfo(dbId);
        return Result.success(allTableNamesInfo);
    }

    /**
     * 描述：查询数据集的基本信息
     * 参数：数据集id
     * 返回值：
     * 修改人：gbl
     * 修改时间：2018/4/26
     * 修改内容：
     */
    @RequestMapping(value = "getBaseInfo", method = RequestMethod.POST)
    @ApiOperation(value = "查询数据集的基本信息", notes = "查询数据集的基本信息")
    @ApiResponses({
            @ApiResponse(code = 85518, message = "数据集id不能为空"),
            @ApiResponse(code = 85504, message = "数据集不存在"),
    })
    public Result<DataSetBaseInfoDTO> getBaseInfo(@RequestParam Long setId) {
        BizAssert.assertNotNull(ExchangeExceptionCode.DATA_SET_ID_NULL, setId);
        ShareDataSet shareDataSet = shareDataSetService.getById(setId);
        if (shareDataSet == null) {
            return Result.fail(ExchangeExceptionCode.CREATEDATASET_CREATEDATASETPARAMFILEDTO_DATASET_NOT);
        }
        DataSetBaseInfoDTO res = dozerUtils.map(shareDataSet, DataSetBaseInfoDTO.class);

        //数据集类型:1,非结构化文件；2，结构化文件；3，API调用；4，数据库读取
        if (shareDataSet.getSetType() == 1 || shareDataSet.getSetType() == 2) {//关联文件
            ShareDataFileExample sdfe = new ShareDataFileExample();
            ShareDataFileExample.Criteria sdfec = sdfe.createCriteria();
            sdfec.andSetIdEqualTo(setId);
            sdfec.andOptTypeNotEqualTo(2);//不要删除操作的
            List<ShareDataFile> shareDataFiles = shareDataFileService.find(sdfe);
            res.setFiles(dozerUtils.mapList(shareDataFiles, DataSetFileDTO.class));
            //找到关联的目录
            Map<Long, ShareDataSetDir> shareDataSetDirMap = shareDataSetDirService.getShareDataSetDirBySetIdNotDele(setId);
            if (shareDataSetDirMap != null && shareDataSetDirMap.size() > 0) {
                ArrayList<Long> dirIds = Lists.newArrayList(shareDataSetDirMap.keySet().iterator());
                ShareDataDirectoryExample sdde = new ShareDataDirectoryExample();
                ShareDataDirectoryExample.Criteria sddec = sdde.createCriteria();
                sddec.andIdIn(dirIds);
                List<ShareDataDirectory> dataDirectories = dataDirectoryService.find(sdde);
                res.setDirectorys(dozerUtils.mapList(dataDirectories, DataDirectoryDTO.class));
            }
        }
        //数据类型的
        if (shareDataSet.getSetType() == 3 || shareDataSet.getSetType() == 4) {
            //表信息
            if (shareDataSet.getSetType() == 4) {
                res.setAllTable(dataBaseDescManager.getAllTableNamesInfo(shareDataSet.getDbId()));
                res.setDbName(shareDbSourceService.getById(shareDataSet.getDbId()).getSourceName());
            } else {
                //返回字段信息
                Set<String> fieldNames = apiDataDescManager.getApiFieldNames(shareDataSet.getApiDataType(), shareDataSet.getApiUrl());
                if (fieldNames == null || fieldNames.size() == 0) {
                    BizAssert.fail(ExchangeExceptionCode.CREATEDATASET_CREATEDSPDBDTO_API_FAILED);
                }
                List<DataSetElementDTO> fieldList = new ArrayList<>();
                for (String name : fieldNames) {
                    DataSetElementDTO dse = new DataSetElementDTO();
                    dse.setFieldType("String");
                    dse.setFieldName(name);
                    dse.setFieldCode(name);
                    fieldList.add(dse);
                }
                res.setFieldList(fieldList);
            }
            //已经选择返回的字段
            List<ShareDataSetElement> allBySetIdCanUse = shareDataSetElementService.getAllBySetIdCanUse(setId);
            List<DataSetElementDTO> resultFileNames = dozerUtils.mapList(allBySetIdCanUse, DataSetElementDTO.class);
//            List<DataSetElementDTO> resultFileNames = new ArrayList<>();
//            for (ShareDataSetElement sese : dataSetElementMap.values()) {
//                DataSetElementDTO dese = new DataSetElementDTO();
//                dese.setId(sese.getId());
//                dese.setFieldName(sese.getFieldName());
//                dese.setFieldCode(sese.getFieldCode());
//                dese.setFieldType(sese.getFieldType());
//                resultFileNames.add(dese);
//            }
            res.setAlFieldList(resultFileNames);

            //已经选择过滤的字段
            List<ShareDataSetFilter> allCanUseBySetId = shareDataSetFilterService.getAllCanUseBySetId(setId);
            List<FieldParamDTO> paramFileds = new ArrayList<>();
            for (ShareDataSetFilter sf : allCanUseBySetId) {
                FieldParamDTO fd = new FieldParamDTO();
                fd.setFieldCode(sf.getFieldCode());
                fd.setRule(sf.getScrRule());
                fd.setValue(sf.getScrValue());
                paramFileds.add(fd);
            }
            res.setParamFileds(paramFileds);
        }
        //关联目录信息
        List<RelatedDirectoryDTO> relatedDirectory = getRelatedDirectoryDTOS(shareDataSet);
        res.setRelatedDirectory(relatedDirectory);

        return Result.success(res);
    }


    /**
     * 描述：查询数据集流程详细信息
     * 参数：流程任务id
     * 返回值：
     * 修改人：gbl
     * 修改时间：2018/4/27
     * 修改内容：
     */
    @RequestMapping(value = "showFlowDataSetInfo", method = RequestMethod.POST)
    @ApiOperation(value = "查询数据集流程详细信息", notes = "查询数据集流程详细信息")
    @ApiResponses({
            @ApiResponse(code = 86500, message = "任务Id不能为空"),
            @ApiResponse(code = 86504, message = "任务ID不存在"),
    })
    public Result<FlowDataSetInfoTDO> getShowFlowDataSetInfo(@RequestParam Long taskId) {
        BizAssert.assertNotNull(ExchangeExceptionCode.TASK_ID_NULL, taskId);
        //正在执行的在任务表，已经完成的在历史表
        DSFlowTaskInfoDO taskInfo = shareDataSetService.getNowFlowTsakInfo(taskId);
        if (taskInfo == null) {
            taskInfo = shareDataSetService.getHiFlowTsakInfo(taskId);
        }

        if (taskInfo == null) {
            return Result.fail(ExchangeExceptionCode.TASK_ID_NOT_EXIST);
        }

        FlowDataSetInfoTDO res = dozerUtils.map(taskInfo, FlowDataSetInfoTDO.class);

        res.setApplyUserName(taskInfo.getUserName());

        ShareDataSet shareDataSet = shareDataSetService.getById(taskInfo.getDataSetId());
        List<RelatedDirectoryDTO> relatedDirectoryDTOS = getRelatedDirectoryDTOS(shareDataSet);
        for (RelatedDirectoryDTO rd : relatedDirectoryDTOS) {
            if (shareDataSet.getSetType() == 1 && shareDataSet.getSetType() == 2) {
                rd.setList(null);
            } else {
                List<DirectoryField2DataFieldDTO> removes = new ArrayList<>();
                for (DirectoryField2DataFieldDTO f : rd.getList()) {
                    if (StringUtils.isBlank(f.getSetField())) {
                        removes.add(f);
                    }
                }
                rd.getList().removeAll(removes);
            }
        }
        res.setRelatedDirectory(relatedDirectoryDTOS);

        if (shareDataSet.getSetType() == 3 || shareDataSet.getSetType() == 4) {
            ShareDataSetFilterExample sdsfe = new ShareDataSetFilterExample();
            ShareDataSetFilterExample.Criteria sdsfec = sdsfe.createCriteria();
            sdsfec.andSetIdEqualTo(shareDataSet.getId());
            List<ShareDataSetFilter> setFilters = shareDataSetFilterService.find(sdsfe);
            List<FieldParamDTO> paramFileds = new ArrayList<>();
            for (ShareDataSetFilter sf : setFilters) {
                if (sf.getSetId() == null || sf.getSetId() == -1) {
                    continue;
                }
                FieldParamDTO fd = new FieldParamDTO();
                fd.setFieldCode(sf.getFieldCode());
                fd.setFieldType(sf.getFieldType());
                fd.setFieldName(sf.getFieldName());
                fd.setRule(sf.getScrRule());
                fd.setValue(sf.getScrValue());
                paramFileds.add(fd);
            }
            res.setParamFileds(paramFileds);
        }
        if (shareDataSet.getSetType() == 1 || shareDataSet.getSetType() == 2) {//关联文件
            ShareDataFileExample sdfe = new ShareDataFileExample();
            ShareDataFileExample.Criteria sdfec = sdfe.createCriteria();
            sdfec.andSetIdEqualTo(shareDataSet.getId());
            sdfec.andOptTypeNotEqualTo(2);//不要删除操作的
            List<ShareDataFile> shareDataFiles = shareDataFileService.find(sdfe);
            res.setFiles(dozerUtils.mapList(shareDataFiles, DataSetFileDTO.class));
        }
        res.setDataCount(shareDataSet.getDataCount());
        res.setSetType(shareDataSet.getSetType());
        res.setTableCode(shareDataSet.getFormalTableCode());
        return Result.success(res);
    }

    /**
     * 描述：查询数据库数据源一张表的信息
     * 参数：[dataSourcId, tableCode]
     * 返回值：com.hengyunsoft.platform.exchange.api.set.dto.DatabaseTableDTO
     * 修改人：gbl
     * 修改时间：2018/5/5
     * 修改内容：
     */
    @RequestMapping(value = "getTableInfo", method = RequestMethod.POST)
    @ApiOperation(value = "查询数据库数据源一张表的信息", notes = "查询数据库数据源一张表的信息")
    @ApiResponses({
            @ApiResponse(code = 85500, message = "数据源id,不能为空"),
            @ApiResponse(code = 85550, message = "表名标识不能为空"),
            @ApiResponse(code = 85551, message = "表不存在"),
    })
    public Result<DatabaseTableDTO> getTableInfo(@RequestParam("dataSourcId") Long dataSourcId, @RequestParam("tableCode") String tableCode) {
        BizAssert.assertNotNull(ExchangeExceptionCode.CREATEDATASET_CREATEDSPDBDTO_DBID, dataSourcId);
        BizAssert.assertNotEmpty(ExchangeExceptionCode.CREATE_DATA_SET_TABLE_CODE_NULL, tableCode);
        DatabaseTableDTO tableInfo = dataBaseDescManager.getTableInfo(dataSourcId, tableCode);
        if (tableInfo == null) {
            return Result.fail(ExchangeExceptionCode.CREATE_DATA_SET_TABLE_NOT_HAS);
        }
        if (StringUtils.isNotEmpty(tableInfo.getMsg())) {
            return Result.fail(tableInfo.getMsg());
        }
        return Result.success(tableInfo);
    }


    /**
     * 描述：删除数据文件
     * 参数：
     * 返回值：
     * 修改人：gbl
     * 修改时间：2018/5/10
     * 修改内容：
     *
     * @param deleteFileDTO
     */
    @RequestMapping(value = "deleteFile", method = RequestMethod.POST)
    @ApiOperation(value = "删除数据文件", notes = "删除数据文件")
    @ApiResponses({
            @ApiResponse(code = 85518, message = "数据集id不能为空"),
            @ApiResponse(code = 85504, message = "数据集不存在"),
            @ApiResponse(code = 85552, message = "不是文件类数据集"),
            @ApiResponse(code = 85553, message = "不是文件类数据集"),
            @ApiResponse(code = 85554, message = "删除文件参数不能为空"),
    })
    public Result<Boolean> deleteFile(@RequestBody DeleteFileParamDTO deleteFileDTO) {
        BizAssert.assertNotNull(ExchangeExceptionCode.DELETE_DATA_FILE_PARAM_NUMM, deleteFileDTO);
        BizAssert.assertNotNull(ExchangeExceptionCode.DATA_SET_ID_NULL, deleteFileDTO.getSetId());
        BizAssert.assertNotNull(ExchangeExceptionCode.DELETE_DATA_FILE_ID_NOT_FILE_, deleteFileDTO.getFileIds());

        ShareDataSet shareDataSet = shareDataSetService.getById(deleteFileDTO.getSetId());
        if (shareDataSet == null) {
            return Result.fail(ExchangeExceptionCode.CREATEDATASET_CREATEDATASETPARAMFILEDTO_DATASET_NOT);
        }
        if (shareDataSet.getSetType() != 1 && shareDataSet.getSetType() != 2) {
            return Result.fail(ExchangeExceptionCode.CREATE_DATA_SET_NOT_FILE_SET);
        }

        ShareDataFileExample sdfe = new ShareDataFileExample();
        ShareDataFileExample.Criteria sdfec = sdfe.createCriteria();
        sdfec.andSetIdEqualTo(deleteFileDTO.getSetId());
        List<ShareDataFile> shareDataFiles = shareDataFileService.find(sdfe);
        List<Long> removes = new ArrayList<>();
        for (ShareDataFile sdf : shareDataFiles) {
            if (deleteFileDTO.getFileIds().contains(sdf.getBusId())) {
                removes.add(sdf.getId());
            }
        }
        shareDataFileService.deleteByIds(removes);
        return Result.success(true);
    }

    /**
     * 描述：得到数据集的校验规则
     * 参数：
     * 返回值：
     * 修改人：gbl
     * 修改时间：2018/9/5
     * 修改内容：
     */
    @RequestMapping(value = "getSetRule", method = RequestMethod.GET)
    @ApiOperation(value = "得到数据集的校验规则", notes = "得到数据集的校验规则")
    @ApiResponses({
            @ApiResponse(code = 85518, message = "数据集id不能为空"),
    })
    public Result<DataSetCheakRuleDTO> getSetRule(@RequestParam("setId") Long setId) {
        BizAssert.assertNotNull(ExchangeExceptionCode.DATA_SET_ID_NULL, setId);

        ShareDataSetRuleExample example = new ShareDataSetRuleExample();
        ShareDataSetRuleExample.Criteria criteria = example.createCriteria();
        criteria.andSetIdEqualTo(setId);

        List<ShareDataSetRule> shareDataSetRules = shareDataSetRuleService.find(example);
        Map<String, ShareDataSetElementWare> shareDataSetElements = shareDataSetElementWareService.getShareDataSetElementBySetId(setId);

        DataSetCheakRuleDTO dto = new DataSetCheakRuleDTO();
        dto.setSetId(setId);
        Map<Long, DateSetElementRuleDTO> eleMap = new HashMap<>();
        for (ShareDataSetElementWare shareDataSetElementWare : shareDataSetElements.values()) {
            DateSetElementRuleDTO dse = eleMap.get(shareDataSetElementWare.getId());
            if (dse == null) {
                dse = new DateSetElementRuleDTO();

                dse.setElementId(shareDataSetElementWare.getId());
                dse.setElementName(shareDataSetElementWare.getFieldCode());

                List<String> list = new ArrayList<>();
                dse.setRuleCodes(list);

                eleMap.put(dse.getElementId(), dse);
            }
            for (ShareDataSetRule sds : shareDataSetRules) {
                if (sds.getElementId().equals(shareDataSetElementWare.getId())) {
                    dse.getRuleCodes().add(sds.getRuleCode());
                }
            }

        }
        dto.setEles(Lists.newArrayList(eleMap.values()));

        return Result.success(dto);
    }

    /**
     * 描述：保存数据集字段规则
     * 参数：DataSetElementRuleDTO
     * 返回值：Boolean
     * 修改人：zhaopengfei
     * 修改时间：2018/8/30
     * 修改内容：
     */
    @RequestMapping(value = "saveSetRule", method = RequestMethod.POST)
    @ApiOperation(value = "保存数据集字段规则", notes = "保存数据集字段规则")
    @ApiResponses({
            @ApiResponse(code = 85558, message = "数据集字段规则不能为空"),
            @ApiResponse(code = 85559, message = "数据集字段规则对象不能为空"),
            @ApiResponse(code = 85560, message = "数据集字段ID不能为空"),
            @ApiResponse(code = 85518, message = "数据集id不能为空"),
    })
    public Result<Boolean> saveSetRule(@RequestBody DataSetCheakRuleDTO param) {
        BizAssert.assertNotNull(ExchangeExceptionCode.DATA_SET_ELEMENT_RULE_DTO_NOT_NULL, param);
        BizAssert.assertNotNull(ExchangeExceptionCode.DATA_SET_ELEMENT_RULE_NOT_NULL, param.getEles());
        //BizAssert.assertNotNull(ExchangeExceptionCode.DATA_SET_ELEMENT_ID_NOT_NULL, param.getElementId());
        BizAssert.assertNotNull(ExchangeExceptionCode.DATA_SET_ID_NULL, param.getSetId());

        Long userId = BaseContextHandler.getAdminId();
        //先删除以前
        shareDataSetRuleService.deleteBySetId(param.getSetId());
        //保存新的
        ShareDataSetRule dataSetRule = new ShareDataSetRule();
        dataSetRule.setCreateUser(userId);
        dataSetRule.setUpdateUser(userId);
        dataSetRule.setSetId(param.getSetId());
        for (DateSetElementRuleDTO ele : param.getEles()) {
            dataSetRule.setElementId(ele.getElementId());
            for (String ruCode : ele.getRuleCodes()) {
                dataSetRule.setId(null);
                dataSetRule.setRuleCode(ruCode);
                shareDataSetRuleService.saveSelective(dataSetRule);
            }
        }
        return Result.success(true);
    }

    /**
     * 描述：根据数据集Id查询数据集数据仓库数据
     * 参数：
     * 返回值：
     * 修改人：zhaopengfei
     * 修改时间：2018/8/30
     * 修改内容：
     */
    @RequestMapping(value = "querySetData", method = RequestMethod.POST)
    @ApiOperation(value = "根据数据集Id查询数据集数据仓库数据", notes = "根据数据集Id查询数据集数据仓库数据")
    @ApiResponses({
            @ApiResponse(code = 85518, message = "数据集id不能为空"),
    })
    public Result<DataSetDataDto> querySetData(@RequestBody OpenApiReq<Long> openApiReq) {
        DataSetDataDto setData = new DataSetDataDto();
        Long setId = openApiReq.getData();
        BizAssert.assertNotNull(ExchangeExceptionCode.DATA_SET_ID_NULL, setId);
        ShareDataSet shareDataSet = shareDataSetService.getById(setId);
        if (shareDataSet == null) {
            return Result.fail(ExchangeExceptionCode.CREATEDATASET_CREATEDATASETPARAMFILEDTO_DATASET_NOT);
        }
        //状态:1，审批中；2，驳回；3，已上架；4，已下架,只有已经上架的才能查询数据
        if (shareDataSet.getStatus() != 3) {
            return Result.fail(ExchangeExceptionCode.CREATEDATASET_CREATEDATASETPARAMDTO_FLOWS_NOT_PASS);
        }


//        ShareDataSetFilterExample sdse = new ShareDataSetFilterExample();
//        ShareDataSetFilterExample.Criteria sdsec = sdse.createCriteria();
//        sdsec.andSetIdEqualTo(setId);
//        List<ShareDataSetFilter> dataSetFilterList = shareDataSetFilterService.find(sdse);

        //数据集类型:1,非结构化文件；2，结构化文件；3，API调用；4，数据库读取
        Integer setType = shareDataSet.getSetType();
        if (setType != 3 && setType != 4) {
            return Result.fail(ExchangeExceptionCode.CREATEDATASET_CREATEDATASETPARAMDTO_DATA_GET_ERROR);
        }
        //字段规则
        Result<DataSetCheakRuleDTO> setRule = getSetRule(setId);
        setData.setEles(setRule.getData().getEles());

        ShareDataSetElementWareExample adse = new ShareDataSetElementWareExample();
        ShareDataSetElementWareExample.Criteria adsec = adse.createCriteria();
        adsec.andSetIdEqualTo(setId);
        List<ShareDataSetElementWare> setElements = shareDataSetElementWareService.find(adse);//数据集字段列表
        setData.setFieldName(dozerUtils.mapList(setElements, DataSetElementDTO.class));

        String SQL = getQuerySQL(shareDataSet);
        String countSql = getQueryCountSQL(shareDataSet);
        List<Object> jsonArray = dataBaseDescManager.executeLocalQuery(SQL, openApiReq.getPageNo(), openApiReq.getPageSize());
        int totalRow = dataBaseDescManager.executeLocalQueryCount(countSql);
        PageInfo<Object> objectPageInfo = PageInfoUtil.getPage(openApiReq.getPageNo(), openApiReq.getPageSize(), totalRow, jsonArray);
        setData.setDataList(objectPageInfo);
        return Result.success(setData);
    }

    /**
     * 描述：更新数据仓库数据
     * 参数：DataSetElementRuleDTO
     * 返回值：Boolean
     * 修改人：zhaopengfei
     * 修改时间：2018/8/31
     * 修改内容：
     */
    @RequestMapping(value = "updateWareHouseData", method = RequestMethod.POST)
    @ApiOperation(value = "数据校验修改数据", notes = "数据校验修改数据")
    @ApiResponses({
            @ApiResponse(code = 85518, message = "数据集id不能为空"),
            @ApiResponse(code = 85561, message = "修改对象不能为空"),
            @ApiResponse(code = 86028, message = "找不到对应的数据集"),
            @ApiResponse(code = 85551, message = "表不存在"),
            @ApiResponse(code = 86029, message = "找不到对应的查询字段"),
    })
    public Result<Boolean> updateWareHouseData(@RequestBody WareHouseUpdateDTO param) throws Exception {
        BizAssert.assertNotNull(ExchangeExceptionCode.WARE_HOUSE_OBJ_NOT_NULL, param);
        BizAssert.assertNotNull(ExchangeExceptionCode.DATA_SET_ID_NULL, param.getSetId());

        Long setId = param.getSetId();
        //查找数据集
        ShareDataSet dataSet = shareDataSetService.getById(setId);
        if (ObjectUtils.isEmpty(dataSet)) {
            return Result.fail(ExchangeExceptionCode.SHARE_SET_NOT_EXIST.getMsg());
        }
        if (StringUtils.isEmpty(dataSet.getTableCode())) {
            return Result.fail(ExchangeExceptionCode.CREATE_DATA_SET_TABLE_NOT_HAS.getMsg());
        }
        //查找数据集查询字段
        ShareDataSetElementExample example = new ShareDataSetElementExample();
        example.createCriteria().andSetIdEqualTo(setId);
        List<ShareDataSetElement> elementList = shareDataSetElementService.find(example);
        if (ObjectUtils.isEmpty(elementList)) {
            return Result.fail(ExchangeExceptionCode.SELECT_FILED_NOT_EXIST.getMsg());
        }
        //对对象进行修改
        Connection conn = null;
        try {
            conn = DataBaseSql.getConnection();
            conn.setAutoCommit(false);
            List<Map<String, Object>> objectList = param.getUpdateObjList();
            if (!ObjectUtils.isEmpty(objectList)) {
                for (Map<String, Object> obj : objectList) {
                    Long keyId;
                    StringBuilder updateSql = new StringBuilder("UPDATE");
                    updateSql.append(" " + dataSet.getFormalTableCode() + " SET");
                    for (ShareDataSetElement element : elementList) {
                        String value = null;
//                    if (element.getFieldType().equals())
                        Object valueObj = obj.get(element.getFieldCode());
                        if (!ObjectUtils.isEmpty(valueObj)) {
                            value = valueObj.toString();
                        }
                        if (value != null) {
                            boolean dbHasEquel = false;
                            for (String str : dbHasEquelType) {
                                if (element.getFieldType().indexOf(str) >= 0) {
                                    dbHasEquel = true;
                                    break;
                                }
                            }
                            if (!dbHasEquel) {
                                updateSql.append(" " + "`" + element.getFieldCode() + "` = '" + value + "',");
                            } else {
                                updateSql.append(" " + "`" + element.getFieldCode() + "` = " + value + ",");
                            }
                        }
                    }
                    updateSql = new StringBuilder(updateSql.substring(0, updateSql.length() - 1));
                    keyId = Long.valueOf(obj.get("key_id").toString());
                    updateSql.append(" WHERE key_id=" + keyId);
                    //执行更新语句

                    PreparedStatement ps = conn.prepareStatement(updateSql.toString());
                    ps.executeUpdate(updateSql.toString());
                    ps.close();
                }
            }
            //对仓库数据进行删除
            List<Long> deleteIdList = param.getDeleteIdList();
            if (!ObjectUtils.isEmpty(deleteIdList) && deleteIdList.size() > 0) {
                for (Long id : deleteIdList) {
                    String deleteSql = "DELETE FROM " + dataSet.getFormalTableCode() + " WHERE key_id=" + id;
                    PreparedStatement ps = conn.prepareStatement(deleteSql);
                    try {
                        ps.executeUpdate(deleteSql);
                    } finally {
                        ps.close();
                    }
                }
            }
            conn.commit();
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        } finally {
            if (conn != null) {
                conn.close();
            }
        }
        return Result.success(true);
    }

    /**
     * 描述：查询检验
     * 参数：
     * 返回值：
     * 修改人：gbl
     * 修改时间：2018/9/11
     * 修改内容：
     */
    @RequestMapping(value = "queryCheck", method = RequestMethod.GET)
    @ApiOperation(value = "查询检验接口", notes = "查询检验")
    @ApiResponses({
            @ApiResponse(code = 85543, message = "SQL语句,不能为空"),
            @ApiResponse(code = 85545, message = "数据集id,不能为空"),
    })
    public Result<List<DataSetElementDTO>> queryCheck(@RequestParam("setId") Long setId, @RequestParam("sql") String sql) {
        BizAssert.assertNotEmpty(ExchangeExceptionCode.CREATEDATASET_CREATEDSPDBSECONDREQDTO_SQLCODE, sql);
        BizAssert.assertNotNull(ExchangeExceptionCode.CREATEDATASET_CREATEDSPDBTHIRDREQTDO_ID, setId);
        ShareDataSet shareDataSet = shareDataSetService.getById(setId);
        if (shareDataSet == null) {
            return Result.fail(ExchangeExceptionCode.CREATEDATASET_CREATEDATASETPARAMFILEDTO_DATASET_NOT);
        }
        //验证sql语句，不能有 “删除”相关的语句(alter,relpace,inseret,inseret,update,drop,TRUNCATE)，只能是 select 开头
        String sqlCode = sql.split(";")[0];
        if ((sqlCode.indexOf("SELECT") < 0 && sqlCode.indexOf("select") < 0) || (sqlCode.indexOf("ALTER") > -1 || sqlCode.indexOf("alter") > -1) || sqlCode.indexOf("RELPACE") > -1 || sqlCode.indexOf("relpace") > -1 || sqlCode.indexOf("INSERET") > -1 || sqlCode.indexOf("inseret") > -1 ||
                sqlCode.indexOf("drop") > -1 || sqlCode.indexOf("DROP") > -1 || sqlCode.indexOf("TRUNCATE") > -1 || sqlCode.indexOf("truncate") > -1) {
            return new Result(1, null, ExchangeExceptionCode.CREATEDATASET_CREATEDATASETPARAMDTO_SQL_ERROR.getMsg());
        }
        QueryData queryData;
        try {
            queryData = dataBaseDescManager.executeQuery(shareDataSet.getDbId(), sqlCode, 1, 2);
        } catch (Exception e) {
            return Result.fail(e);
        }
        List<DataSetElementDTO> fileds = queryData.getFileds();
        return Result.success(fileds);
    }

    /**
     * 描述：查询数据集现在的字段列表
     * 参数：
     * 返回值：
     * 修改人：gbl
     * 修改时间：2018/9/13
     * 修改内容：
     */
    @RequestMapping(value = "querySetElementField", method = RequestMethod.GET)
    @ApiOperation(value = "查询数据集现在的字段列表", notes = "查询数据集现在的字段列表")
    @ApiResponses({
            @ApiResponse(code = 85545, message = "数据集id，不能为空"),
            @ApiResponse(code = 85504, message = "数据集不存在"),
    })
    public Result<QuerySetElementFieldRes> querySetElementField(@RequestParam("setId") Long setId) {
        BizAssert.assertNotNull(ExchangeExceptionCode.CREATEDATASET_CREATEDSPDBTHIRDREQTDO_ID, setId);

        ShareDataSet shareDataSet = shareDataSetService.getById(setId);
        if (shareDataSet == null) {
            return Result.fail(ExchangeExceptionCode.CREATEDATASET_CREATEDATASETPARAMFILEDTO_DATASET_NOT);
        }
        List<DataSetElementDTO> fileds = new ArrayList<>();

        //String formalTableName = DataBaseSql.getFormalTableName(shareDataSet.getTableCode());
        DatabaseTableDTO table = dataBaseDescManager.getLocalTableInfo(shareDataSet.getTableCode());
        Map<String, DataSetElementDTO> fieldMap = table.getDataSetElementMap();
        List<ShareDataSetElement> all = shareDataSetElementService.getAllBySetIdCanUse(setId);
        for (ShareDataSetElement sdse : all) {
            DataSetElementDTO field = fieldMap.get(sdse.getFieldCode());
            if (field != null) {
                field.setId(sdse.getId());
                field.setFieldName(sdse.getFieldName());
                fileds.add(field);
            }
        }
        QuerySetElementFieldRes res = new QuerySetElementFieldRes();
        res.setSetId(setId);
        res.setSetMode(shareDataSet.getSetMode());
        res.setTableCode(shareDataSet.getSourceDbCode());
        res.setFields(fileds);
        return Result.success(res);
    }

    /**
     * 描述：得到数据集在数据源表的信息
     * 参数：
     * 返回值：
     * 修改人：gbl
     * 修改时间：2018/9/14
     * 修改内容：
     */
    @RequestMapping(value = "getDbSourceTableInfo", method = RequestMethod.GET)
    @ApiOperation(value = "得到数据集在数据源表的信息", notes = "得到数据集在数据源表的信息")
    @ApiResponses({
            @ApiResponse(code = 85545, message = "数据集id，不能为空"),
            @ApiResponse(code = 85504, message = "数据集不存在"),
    })
    public Result<DatabaseTableDTO> getDbSourceTableInfo(@RequestParam("setId") Long setId) {
        BizAssert.assertNotNull(ExchangeExceptionCode.CREATEDATASET_CREATEDSPDBTHIRDREQTDO_ID, setId);

        ShareDataSet shareDataSet = shareDataSetService.getById(setId);
        if (shareDataSet == null) {
            return Result.fail(ExchangeExceptionCode.CREATEDATASET_CREATEDATASETPARAMFILEDTO_DATASET_NOT);
        }
        Long dataSourcId = shareDataSet.getDbId();
        String tableCode = shareDataSet.getSourceDbCode();
        if (dataSourcId == null || StringUtils.isBlank(tableCode)) {
            return Result.fail("没有选择表");
        }

        DatabaseTableDTO tableInfo = dataBaseDescManager.getTableInfo(dataSourcId, tableCode);
        if (tableInfo == null) {
            return Result.fail(ExchangeExceptionCode.CREATE_DATA_SET_TABLE_NOT_HAS);
        }
        if (StringUtils.isNotEmpty(tableInfo.getMsg())) {
            return Result.fail(tableInfo.getMsg());
        }
        return Result.success(tableInfo);
    }
}
