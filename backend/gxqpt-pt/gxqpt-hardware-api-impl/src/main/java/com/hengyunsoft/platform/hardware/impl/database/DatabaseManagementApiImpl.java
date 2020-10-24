package com.hengyunsoft.platform.hardware.impl.database;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hengyunsoft.base.Result;
import com.hengyunsoft.commons.context.BaseContextHandler;
import com.hengyunsoft.commons.exception.core.HardWareExceptionCode;
import com.hengyunsoft.commons.utils.context.DozerUtils;
import com.hengyunsoft.page.plugins.openapi.OpenApiReq;
import com.hengyunsoft.platform.admin.api.authority.dto.role.RoleDto;
import com.hengyunsoft.platform.admin.api.core.api.GxqptOrgApi;
import com.hengyunsoft.platform.admin.api.core.dto.org.GxqptOrgByUserDTO;
import com.hengyunsoft.platform.admin.api.core.dto.org.GxqptOrgRolePageDTO;
import com.hengyunsoft.platform.admin.open.authority.api.RoleOpenApi;
import com.hengyunsoft.platform.hardware.constant.Role2ScodeEnum;
import com.hengyunsoft.platform.hardware.dto.database.*;
import com.hengyunsoft.platform.hardware.entity.database.domain.DatabaseResPanelDO;
import com.hengyunsoft.platform.hardware.entity.database.domain.DatabaseStatisticsDO;
import com.hengyunsoft.platform.hardware.entity.database.domain.DatabaseTypeRationDO;
import com.hengyunsoft.platform.hardware.entity.database.po.DatabaseManagement;
import com.hengyunsoft.platform.hardware.repository.database.example.DatabaseManagementExample;
import com.hengyunsoft.utils.BizAssert;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.hengyunsoft.platform.hardware.repository.database.service.impl.DatabaseManagementServiceImpl;

import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;

import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

/**
 * 描述：数据库管理
 * 修改人：zhangbiao
 * 修改时间：2018/9/4
 * 修改内容：
 */
@Api(value = "API - DatabaseManagementApiImpl", description = "数据库管理")
@RestController
@RequestMapping("databasemanager")
@Slf4j
public class DatabaseManagementApiImpl {
    @Autowired
    private DatabaseManagementServiceImpl databaseManagementServiceImpl;

    @Autowired
    private DozerUtils dozerUtils;

    @Autowired
    private GxqptOrgApi gxqptOrgApi;

    @Autowired
    private RoleOpenApi roleOpenApi;

    @ApiOperation(value = "查询数据库信息列表", notes = "查询数据库信息列表")
    @RequestMapping(value = "findDatabaseList", method = RequestMethod.POST)
    public Result<PageInfo<FindDatabaseListDTO>> findDatabaseList(@RequestBody OpenApiReq<DatabaseConditionDTO> openApiReq) {
        GxqptOrgRolePageDTO dto = new GxqptOrgRolePageDTO();
        dto.setAppId(BaseContextHandler.getAppId());
        dto.setUserId(BaseContextHandler.getAdminId());
        List<RoleDto> roleList = roleOpenApi.findroleList(dto);
        boolean flag = true;
        //管理员角色能看所有数据根据测试需求修改
        if (roleList != null && roleList.size()>0) {
            for(RoleDto roleD: roleList){
                if ("app_admin".equals(roleD.getCode())) {
                    flag = false;
                    break;
                }
            }
        }

        //1.获取分页模糊查询入参
        DatabaseConditionDTO databaseConditionDTO = openApiReq.getData();

        //2.设置查询条件
        PageHelper.startPage(openApiReq.getPageNo(), openApiReq.getPageSize());

        //3.结果
        DatabaseManagement databaseManagement = dozerUtils.map(databaseConditionDTO, DatabaseManagement.class);
        databaseManagement.setIsRelease(0);
        //2018-09-14不考虑存在多个单位情况，wsn
        if(flag){
            //查询当前登陆人所在单位
            List<GxqptOrgByUserDTO> orgs  =  gxqptOrgApi.findOrgByUser().getData();
            if(orgs !=null && orgs.size()>0){
                databaseManagement.setOrgid(orgs.get(0).getId());
            }
        }
        List<DatabaseManagement> list = databaseManagementServiceImpl.findByCondition(databaseManagement);
        List<FindDatabaseListDTO> result = dozerUtils.mapList(list, FindDatabaseListDTO.class);

        return Result.success(new PageInfo<>(result));
    }

    @ApiOperation(value = "新建数据库信息", notes = "新建数据库信息")
    @ApiResponses({
            @ApiResponse(code = 102000, message = "数据库实例DI不能为空"),
            @ApiResponse(code = 102001, message = "数据库管理员不能为空"),
            @ApiResponse(code = 102002, message = "数据库账户不能为空"),
            @ApiResponse(code = 102003, message = "数据库类型不能为空"),
            @ApiResponse(code = 102004, message = "主机IP地址不能为空"),
            @ApiResponse(code = 102005, message = "字符集不能为空"),
            @ApiResponse(code = 102006, message = "端口不能为空"),
            @ApiResponse(code = 102007, message = "所属网络不能为空")
    })
    @RequestMapping(value = "saveDatabase", method = RequestMethod.POST)
    public Result<Boolean> saveDatabase(@RequestBody SaveDatabaseDTO saveDatabaseDTO) {
        //校验
        BizAssert.assertNotNull(HardWareExceptionCode.DATABASE_INSTANCEDI_NULL, saveDatabaseDTO.getInstanceDi());
        BizAssert.assertNotNull(HardWareExceptionCode.DATABASE_ADMIN_NULL, saveDatabaseDTO.getAdmin());
        BizAssert.assertNotNull(HardWareExceptionCode.DATABASE_ACCOUNT_NULL, saveDatabaseDTO.getAccount());
        BizAssert.assertNotNull(HardWareExceptionCode.DATABASE_TYPE_NULL, saveDatabaseDTO.getType());
        BizAssert.assertNotNull(HardWareExceptionCode.DATABASE_HOSTIPADDRESS_NULL, saveDatabaseDTO.getHostIpAddress());
        BizAssert.assertNotNull(HardWareExceptionCode.DATABASE_CHARACTERSET_NULL, saveDatabaseDTO.getCharacterSet());
        BizAssert.assertNotNull(HardWareExceptionCode.DATABASE_PORT_NULL, saveDatabaseDTO.getPort());
        BizAssert.assertNotNull(HardWareExceptionCode.DATABASE_CODE_NULL, saveDatabaseDTO.getCode());

        //检查实例ID是否存在
        if (checkInstanceDi(saveDatabaseDTO.getInstanceDi(), null)) {
            return Result.fail("数据库实例已存在");
        }

        //保存数据
        DatabaseManagement data = dozerUtils.map(saveDatabaseDTO, DatabaseManagement.class);
        data.setIsRelease(0);
        data.setCreateTime(new Date());
        data.setCreateUser(BaseContextHandler.getAdminId().toString());
        data.setUpdateTime(new Date());
        data.setUpdateUser(BaseContextHandler.getAdminId().toString());
        //新增保存单位id,单位名称,便于新需求要求列表只查询当前登陆人所在单位的数据wsn
        List<GxqptOrgByUserDTO> orgs = gxqptOrgApi.findOrgByUser().getData();
        if(orgs!=null && orgs.size()>0){
            String orgId = orgs.get(0).getId();
            String orgName = orgs.get(0).getName();
            data.setOrgid(orgId);
            data.setOrgname(orgName);
        }
        DatabaseManagement result = databaseManagementServiceImpl.saveSelective(data);
        if (result == null || result.getId() == null) {
            return Result.fail("保存数据失败");
        }
        return Result.success(true);
    }

    @ApiOperation(value = "修改数据库信息", notes = "修改数据库信息")
    @ApiResponses({
            @ApiResponse(code = 102008, message = "数据库主键id不能为空"),
            @ApiResponse(code = 102000, message = "数据库实例DI不能为空"),
            @ApiResponse(code = 102001, message = "数据库管理员不能为空"),
            @ApiResponse(code = 102002, message = "数据库账户不能为空"),
            @ApiResponse(code = 102003, message = "数据库类型不能为空"),
            @ApiResponse(code = 102004, message = "主机IP地址不能为空"),
            @ApiResponse(code = 102005, message = "字符集不能为空"),
            @ApiResponse(code = 102006, message = "端口不能为空"),
            @ApiResponse(code = 102007, message = "所属网络不能为空")
    })
    @RequestMapping(value = "updateDatabase", method = RequestMethod.POST)
    public Result<Boolean> updateDatabase(@RequestBody UpdateDatabaseDTO updateDatabaseDTO) {
        //校验
        BizAssert.assertNotNull(HardWareExceptionCode.DATABASE_ID_NULL, updateDatabaseDTO.getId());
        BizAssert.assertNotNull(HardWareExceptionCode.DATABASE_INSTANCEDI_NULL, updateDatabaseDTO.getInstanceDi());
        BizAssert.assertNotNull(HardWareExceptionCode.DATABASE_ADMIN_NULL, updateDatabaseDTO.getAdmin());
        BizAssert.assertNotNull(HardWareExceptionCode.DATABASE_ACCOUNT_NULL, updateDatabaseDTO.getAccount());
        BizAssert.assertNotNull(HardWareExceptionCode.DATABASE_TYPE_NULL, updateDatabaseDTO.getType());
        BizAssert.assertNotNull(HardWareExceptionCode.DATABASE_HOSTIPADDRESS_NULL, updateDatabaseDTO.getHostIpAddress());
        BizAssert.assertNotNull(HardWareExceptionCode.DATABASE_CHARACTERSET_NULL, updateDatabaseDTO.getCharacterSet());
        BizAssert.assertNotNull(HardWareExceptionCode.DATABASE_PORT_NULL, updateDatabaseDTO.getPort());
        BizAssert.assertNotNull(HardWareExceptionCode.DATABASE_CODE_NULL, updateDatabaseDTO.getCode());

        //检查实例ID是否存在
        if (checkInstanceDi(updateDatabaseDTO.getInstanceDi(), updateDatabaseDTO.getId())) {
            return Result.fail("数据库实例已存在");
        }
        //修改数据
        DatabaseManagement data = dozerUtils.map(updateDatabaseDTO, DatabaseManagement.class);
        data.setUpdateTime(new Date());
        data.setUpdateUser(BaseContextHandler.getAdminId().toString());
        int record = databaseManagementServiceImpl.updateByIdSelective(data);
        if (record > 0) {
            return Result.success(true);
        } else {
            return Result.fail("修改数据失败");
        }
    }

    @ApiOperation(value = "释放数据库", notes = "释放数据库")
    @ApiResponses({
            @ApiResponse(code = 102008, message = "数据库主键id不能为空")
    })
    @RequestMapping(value = "releaseDatabase", method = RequestMethod.POST)
    public Result<Boolean> updateReleaseDatabase(@RequestParam Long id) {
        //校验
        BizAssert.assertNotNull(HardWareExceptionCode.DATABASE_ID_NULL, id);

        //获取数据
        DatabaseManagement data = new DatabaseManagement();
        data.setUpdateTime(new Date());
        data.setUpdateUser(BaseContextHandler.getAdminId().toString());
        data.setId(id);
        data.setIsRelease(1);
        int res = databaseManagementServiceImpl.updateByIdSelective(data);
        if (res > 0) {
            return Result.success(true);
        }
        return Result.fail("释放失败");
    }


    /**
     * 检查实例ID是否存在
     *
     * @param instanceDi 检查实例ID
     * @param id         数据库id
     * @return
     */
    private Boolean checkInstanceDi(String instanceDi, Long id) {

        if (instanceDi == null || "".equals(instanceDi)) {
            return true;
        }
        //
        DatabaseManagementExample example = new DatabaseManagementExample();
        example.createCriteria().andInstanceDiEqualTo(instanceDi).andIdNotEqualTo(id);

        //DatabaseManagement databaseManagement = databaseManagementServiceImpl.getUnique(example);
        List<DatabaseManagement> databaseManagementList = databaseManagementServiceImpl.find(example);
        if (databaseManagementList != null && databaseManagementList.size() > 0) {
            return true;
        } else {
            return false;
        }
    }

    @ApiOperation(value = "获取数据库资源面板数据", notes = "获取数据库资源面板数据")
    @RequestMapping(value = "databaseResPanel", method = RequestMethod.GET)
    public Result<DatabaseResPanelDTO> databaseResPanel() {
        DatabaseResPanelDO data = databaseManagementServiceImpl.findDatabaseResPanel();
        DatabaseResPanelDTO result = dozerUtils.map(data, DatabaseResPanelDTO.class);

        //新增占比
        float newProportion = (float) data.getAddNum() / data.getDatabaseNum() * 100;
        result.setNewProportion(newProportion);

        //新增环比
        float newRingRatioTemp = data.getAddNum() - data.getAddedLastMonth();
        if (newRingRatioTemp == 0) {
            result.setNewRingRatio(0);
        } else {
            float newRingRatio = data.getAddNum() / newRingRatioTemp;
            result.setNewRingRatio(newRingRatio);
        }

        //释放占比
        float releaseRatio = (float) data.getRelease() / data.getDatabaseNum() * 100;
        result.setReleaseRatio(releaseRatio);

        //释放环比
        float releaseRingRatioTemp = data.getRelease() - data.getReleaseLastMonth();
        if (releaseRingRatioTemp == 0) {
            result.setReleaseRingRatio(0);
        } else {
            float releaseRingRatio = data.getRelease() / releaseRingRatioTemp;
            result.setReleaseRingRatio(releaseRingRatio);
        }


        //净增占比
        float netIncreaseRatio = (float) data.getNetIncrease() / data.getDatabaseNum() * 100;
        result.setNetIncreaseRatio(netIncreaseRatio);

        return Result.success(result);

    }

    @ApiOperation(value = "数据库类型占比统计", notes = "数据库类型占比统计")
    @RequestMapping(value = "databaseTypeRatioStatistics", method = RequestMethod.GET)
    public Result<DatabaseTypeRatioStatisticsDTO> databaseTypeRatioStatistics() {
        DatabaseTypeRatioStatisticsDTO databaseType = new DatabaseTypeRatioStatisticsDTO();
        Map<String,Integer> map = databaseManagementServiceImpl.findDBTypeRatioStatistics()
                .parallelStream()
                .collect(Collectors.toMap(DatabaseTypeRationDO::getType,DatabaseTypeRationDO::getNum));
        //mysql
        databaseType.setMysql(map.getOrDefault("Mysql",0));
        //Oracle
        databaseType.setOracle(map.getOrDefault("Oracle",0));
        //SqlServer
        databaseType.setSqlServer(map.getOrDefault("SqlServer",0));
        //Access
        databaseType.setAccess(map.getOrDefault("Access",0));
        //Sybase
        databaseType.setSybase(map.getOrDefault("Sybase",0));

        return Result.success(databaseType);
    }

    @ApiOperation(value = "数据库数量统计", notes = "数据库数量统计")
    @RequestMapping(value = "databaseStatistics", method = RequestMethod.GET)
    public Result<Map<String, Integer>> databaseStatistics() {
        SimpleDateFormat s = new SimpleDateFormat("yyyy-MM");
        Calendar c = Calendar.getInstance();

        //map 往前推12个月，包括本月
        Map<String, Integer> map = new TreeMap<>();
        for (int i = 0; i < 12; i++){
            c.setTime(new Date());
            c.add(Calendar.MONTH, -i);
            c.set(Calendar.DAY_OF_MONTH, 1);
            map.put(s.format(c.getTime()), 0);
        }

       /* DatabaseManagementExample example = new DatabaseManagementExample();

        for (int i = 0; i < 12; i++) {
            //统计数据
            example.createCriteria().andCreateTimeBetween(getLast12Months(i, 1), getLast12Months(i, 2));
            map.put(s.format(getLast12Months(i, 1)), databaseManagementServiceImpl.count(example));
            example.clear();
        }*/
        map.putAll(databaseManagementServiceImpl.findDatabaseStatistics()
                .parallelStream()
                .collect(Collectors.toMap(DatabaseStatisticsDO::getTime,DatabaseStatisticsDO::getDatabaseNum)));


        return Result.success(map);
    }

    /**
     * 获取月的第一天或者最后一天
     *
     * @param i    月份
     * @param type 类型 1 为第一天，其他为最后一天
     * @return
     */
/*    public Date getLast12Months(int i, int type) {
        Calendar c = Calendar.getInstance();
        c.setTime(new Date());
        c.add(Calendar.MONTH, -i);
        if (type == 1) {
            c.set(Calendar.DAY_OF_MONTH, 1);
        } else {
            c.set(Calendar.DAY_OF_MONTH, c.getActualMaximum(Calendar.DAY_OF_MONTH));
        }
        Date m = c.getTime();
        return m;
    }*/


}