package com.hengyunsoft.platform.hardware.impl.manager;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hengyunsoft.base.Result;
import com.hengyunsoft.commons.context.BaseContextHandler;
import com.hengyunsoft.commons.exception.core.HardWareExceptionCode;
import com.hengyunsoft.commons.utils.DateUtils;
import com.hengyunsoft.commons.utils.context.DozerUtils;
import com.hengyunsoft.page.plugins.openapi.OpenApiReq;
import com.hengyunsoft.platform.admin.api.authority.api.RoleApi;
import com.hengyunsoft.platform.admin.api.authority.dto.role.RoleDto;
import com.hengyunsoft.platform.admin.api.core.api.GxqptOrgApi;
import com.hengyunsoft.platform.admin.api.core.dto.org.GxqptOrgByUserDTO;
import com.hengyunsoft.platform.hardware.dto.apply.ResourceCountDTO;
import com.hengyunsoft.platform.hardware.dto.manage.*;
import com.hengyunsoft.platform.hardware.dto.manage.networkBandwidthPanel.CommonDTO;
import com.hengyunsoft.platform.hardware.dto.manage.networkBandwidthPanel.EachOrgNetWorkBandwidthMonthDTO;
import com.hengyunsoft.platform.hardware.dto.manage.networkBandwidthPanel.EachOrgNetWorkBandwidthYearDTO;
import com.hengyunsoft.platform.hardware.dto.manage.networkBandwidthPanel.ThisMonthStatisticsDTO;
import com.hengyunsoft.platform.hardware.entity.apply.po.ApplyServer;
import com.hengyunsoft.platform.hardware.entity.dic.po.Dictionary;
import com.hengyunsoft.platform.hardware.entity.dic.po.DictionaryType;
import com.hengyunsoft.platform.hardware.entity.manage.domian.*;
import com.hengyunsoft.platform.hardware.entity.manage.po.DiskManage;
import com.hengyunsoft.platform.hardware.entity.manage.po.ServerManage;
import com.hengyunsoft.platform.hardware.repository.apply.example.ApplyServerExample;
import com.hengyunsoft.platform.hardware.repository.apply.service.ApplyServerService;
import com.hengyunsoft.platform.hardware.repository.dic.example.DictionaryExample;
import com.hengyunsoft.platform.hardware.repository.dic.example.DictionaryTypeExample;
import com.hengyunsoft.platform.hardware.repository.dic.service.DictionaryService;
import com.hengyunsoft.platform.hardware.repository.dic.service.DictionaryTypeService;
import com.hengyunsoft.platform.hardware.repository.manage.example.DiskManageExample;
import com.hengyunsoft.platform.hardware.repository.manage.example.MachineManageExample;
import com.hengyunsoft.platform.hardware.repository.manage.example.ServerManageExample;
import com.hengyunsoft.platform.hardware.repository.manage.service.DiskManageService;
import com.hengyunsoft.platform.hardware.repository.manage.service.MachineManageService;
import com.hengyunsoft.platform.hardware.repository.manage.service.ServerManageService;
import com.hengyunsoft.utils.BizAssert;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

/**
 * 描述：服务器分配管理
 * 修改人：wz
 * 修改时间：2018/7/16
 * 修改内容：
 */
@Api(value = "API - ServerManageApiImpl", description = "服务器分配管理")
@RestController
@RequestMapping("servermanager")
@SuppressWarnings("all")
@Slf4j
public class ServerManageApiImpl {
    @Autowired
    private MachineManageService machineManageService;
    @Autowired
    private ServerManageService serverManageService;
    @Autowired
    private ApplyServerService applyServerService;
    @Autowired
    private DictionaryService dictionaryService;
    @Autowired
    private DiskManageService diskManageService;
    @Autowired
    private DictionaryTypeService dictionaryTypeService;

    @Autowired
    private DozerUtils dozerUtils;

    @Autowired
    private RoleApi roleApi;
    @Autowired
    private GxqptOrgApi gxqptOrgApi;

    private static final String roleCode = "HARDWARE_DEPT_ROLE";

    /**
     * 查询服务分配管理分页
     *
     * @param openApiReq
     * @return
     */
    @ApiOperation(value = "查询服务分配管理分页", notes = "查询服务分配管理分页")
    @RequestMapping(value = "page", method = RequestMethod.POST)
    public Result<PageInfo<ServerManagePageResDTO>> page(@RequestBody OpenApiReq<ServerManagePageReqDTO> openApiReq) {
        //获取分页模糊查询入参
        ServerManagePageReqDTO dto = openApiReq.getData();

        //设置查询条件
        PageHelper.startPage(openApiReq.getPageNo(), openApiReq.getPageSize());

        //获得查询结果-如果是部门，只能查看自己申请的
        ServerManage serverManage = dozerUtils.map(dto, ServerManage.class);
        RoleDto roleDto = new RoleDto();
        roleDto.setCode(roleCode);
        Result<List<Long>> res = roleApi.findUsers(roleDto);
        boolean flag = false;
        if (res != null && res.getData().size() > 0) {
            for (Long id : res.getData()) {
                if ((BaseContextHandler.getAdminId()).equals(id)) {
                    flag = true;
                    break;
                }
            }
        }
        if (flag) {
            serverManage.setManageUid(BaseContextHandler.getAdminId() + "");
        }

        List<ServerManagePageResDTO> list = dozerUtils.mapPage(serverManageService.pageNewest(serverManage), ServerManagePageResDTO.class);

        //获取字典并转换
        List<Dictionary> dictionarys = findDictionarys();
        List typeCodes = dictionarys.stream().map(Dictionary::getCode).collect(Collectors.toList());

        DictionaryTypeExample typeExample = new DictionaryTypeExample();
        typeExample.createCriteria();
        List<DictionaryType> types = dictionaryTypeService.find(typeExample);
        List typeStrs = types.stream().map(DictionaryType::getCode).collect(Collectors.toList());

        list.forEach(obj -> {
            int index = typeCodes.indexOf(obj.getSystem());
            obj.setSystem(index != -1 ? dictionarys.get(index).getName() : "-");

            index = typeStrs.indexOf(obj.getNetScope());
            obj.setNetScope(index != -1 ? types.get(index).getName() : "-");
        });

        return Result.success(new PageInfo<>(list));
    }


    /**
     * 查询服务分配管理新增
     *
     * @param saveDTO
     * @return
     */
    @ApiOperation(value = "查询服务分配管理新增", notes = "查询服务分配管理新增")
    @ApiResponses({
            @ApiResponse(code = 101000, message = "服务器id不能为空"),
            @ApiResponse(code = 101001, message = "服务器iP不能为空"),
            @ApiResponse(code = 101002, message = "CPU核数不能为空"),
            @ApiResponse(code = 101003, message = "内存不能为空"),
            @ApiResponse(code = 101004, message = "操作系统不能为空"),
            @ApiResponse(code = 101005, message = "所属网络不能为空"),
            @ApiResponse(code = 101006, message = "网络带宽不能为空"),
            @ApiResponse(code = 101007, message = "管理单位id不能为空"),
            @ApiResponse(code = 101008, message = "管理单位名称不能为空"),
            @ApiResponse(code = 101011, message = "开通时间不能为空"),
    })
    @RequestMapping(value = "save", method = RequestMethod.POST)
    public Result<ServerManagePageResDTO> save(@RequestBody ServerManageSaveDTO saveDTO) {
        //获取基本头信息
        String userId = BaseContextHandler.getAdminId().toString();
        String userName = BaseContextHandler.getAppName();
        saveDTO.setManageUid(userId);
        saveDTO.setManageUname(userName);
        //验证
        BizAssert.assertNotEmpty(HardWareExceptionCode.SERVER_ID_NULL, saveDTO.getServerId());
        BizAssert.assertNotNull(HardWareExceptionCode.SERVER_CPU_NULL, saveDTO.getCpuCount());
        BizAssert.assertNotEmpty(HardWareExceptionCode.SERVER_IP_NULL, saveDTO.getIp());
        BizAssert.assertNotNull(HardWareExceptionCode.SERVER_MEMORY_NULL, saveDTO.getMemorySize());
        BizAssert.assertNotEmpty(HardWareExceptionCode.SERVER_NET_NULL, saveDTO.getNetScope());
        BizAssert.assertNotEmpty(HardWareExceptionCode.SERVER_SYSTEM_NULL, saveDTO.getSystem());
        BizAssert.assertNotEmpty(HardWareExceptionCode.SERVER_WIDE_NULL, saveDTO.getNetWide());
        BizAssert.assertNotEmpty(HardWareExceptionCode.SERVER_ORG_ID_NULL, saveDTO.getOrgid());
        BizAssert.assertNotEmpty(HardWareExceptionCode.SERVER_ORG_NAME_NULL, saveDTO.getOrgname());
        BizAssert.assertNotNull(HardWareExceptionCode.SERVER_OPENTIME_NULL, saveDTO.getOpenTime());

        //服务分配信息持久化
        ServerManage serverManage = dozerUtils.map(saveDTO, ServerManage.class);
        serverManage.setUpdateUser(userId);
        serverManage.setCreateUser(userId);
        serverManage = serverManageService.saveInit(serverManage);

        //磁盘信息持久化
        List<DiskManage> disks = dozerUtils.mapList(saveDTO.getDtos(), DiskManage.class);
        if (serverManage.getId() != null) {
            Long serverId = serverManage.getId();
            disks.forEach(obj -> {
                obj.setServerId(serverId);
                obj.setCreateUser(userId);
                obj.setUpdateUser(userId);
            });
            diskManageService.save(disks);
            return Result.success(dozerUtils.map(serverManage, ServerManagePageResDTO.class));
        }
        return Result.fail("fail");
    }

    /**
     * 服务分配详情
     *
     * @param serverId
     * @return
     */
    @ApiOperation(value = "服务分配详情", notes = "服务分配详情")
    @ApiResponses({
            @ApiResponse(code = 101012, message = "服务分配id不能为空"),
    })
    @RequestMapping(value = "getDetail", method = RequestMethod.GET)
    public Result<ServerManageDetailDTO> getDetail(@RequestParam(value = "serverId") Long serverId) {
        //验证
        BizAssert.assertNotNull(HardWareExceptionCode.SERVER_MANAGE_ID_NULL, serverId);

        //查询服务分配信息
        ServerManageExample serverManageExample = new ServerManageExample();
        serverManageExample.createCriteria().andIdEqualTo(serverId);
        ServerManage serverManage = serverManageService.getUnique(serverManageExample);
        ApplyServerExample example = new ApplyServerExample();
        example.createCriteria().andApplyKeyidEqualTo(serverManage.getApplyKeyid());
        ApplyServer unique = applyServerService.getUnique(example);
        ServerManageDetailDTO serverManageDetail = dozerUtils.map(serverManage, ServerManageDetailDTO.class);
        serverManageDetail.setGatewayDesc(unique.getGatewayDesc());
        //查询磁盘信息
        DiskManageExample diskManageExample = new DiskManageExample();
        diskManageExample.createCriteria().andServerIdEqualTo(serverManageDetail.getId());
        serverManageDetail.setDtos(dozerUtils
                .mapList(diskManageService.find(diskManageExample), ServerAddDiskDetailDTO.class));

        //转义字典信息
        List<Dictionary> dictionarys = findDictionarys();
        List typeCodes = dictionarys.stream().map(Dictionary::getCode).collect(Collectors.toList());
        List<DictionaryType> types = findDictionaryTypes();
        List typeStrs = types.stream().map(DictionaryType::getCode).collect(Collectors.toList());

        //所属网络
        int index = typeStrs.indexOf(serverManageDetail.getNetScope());
        serverManageDetail.setNetScope(index != -1 ? types.get(index).getName() : "-");

        //操作系统
        index = typeCodes.indexOf(serverManageDetail.getSystem());
        serverManageDetail.setSystem(index != -1 ? dictionarys.get(index).getName() : "-");

        return Result.success(serverManageDetail);
    }

    /**
     * 服务分配修改
     *
     * @param updateDTO
     * @return
     */
    @ApiOperation(value = "服务分配修改", notes = "服务分配修改")
    @ApiResponses({
            @ApiResponse(code = 101012, message = "服务分配id不能为空"),
    })
    @RequestMapping(value = "update", method = RequestMethod.POST)
    public Result<ServerManagePageResDTO> update(@RequestBody ServerManageUpdateDTO updateDTO) {
        //验证
        BizAssert.assertNotNull(HardWareExceptionCode.SERVER_MANAGE_ID_NULL, updateDTO.getId());
        String userId = BaseContextHandler.getAdminId().toString();

        //服务分配修改持久化处理
        ServerManage serverManage = dozerUtils.map(updateDTO, ServerManage.class);
        serverManage.setUpdateUser(userId);
        serverManageService.updateByIdSelective(serverManage);

        ServerManageExample serverManageExample = new ServerManageExample();
        serverManageExample.createCriteria().andIdEqualTo(serverManage.getId());
        serverManage = serverManageService.getUnique(serverManageExample);

        //修改磁盘信息
        if (updateDTO.getUpdates() != null && updateDTO.getUpdates().size() > 0) {
            List<DiskManage> diskUpdates = dozerUtils.mapList(updateDTO.getUpdates(), DiskManage.class);
            diskUpdates.forEach(obj -> {
                obj.setUpdateUser(userId);
            });
            diskManageService.updateByIdSelective(diskUpdates);
        }

        //删除磁盘信息
        if (updateDTO.getDeleteIds() != null && updateDTO.getDeleteIds().size() > 0) {
            diskManageService.deleteByIds(updateDTO.getDeleteIds());
        }

        //新增磁盘信息
        if (updateDTO.getSaves() != null && updateDTO.getSaves().size() > 0) {
            List<DiskManage> disks = dozerUtils.mapList(updateDTO.getSaves(), DiskManage.class);
            if (serverManage.getId() != null) {
                Long serverId = serverManage.getId();
                disks.forEach(obj -> {
                    obj.setServerId(serverId);
                    obj.setCreateUser(userId);
                    obj.setUpdateUser(userId);
                });
                diskManageService.save(disks);
            }
        }

        return Result.success(dozerUtils.map(serverManage, ServerManagePageResDTO.class));
    }

    /**
     * 服务分配删除
     *
     * @param serverIds
     * @return
     */
    @ApiOperation(value = "服务分配删除", notes = "服务分配删除")
    @ApiResponses({
            @ApiResponse(code = 101012, message = "服务分配id不能为空"),
    })
    @RequestMapping(value = "delete", method = RequestMethod.GET)
    public Result<Boolean> delete(@RequestParam(value = "serverIds[]") Long[] serverIds) {
        //验证
        BizAssert.assertNotNull(HardWareExceptionCode.SERVER_MANAGE_ID_NULL, serverIds);

        //获取服务分配下的所有磁盘
        List idList = Arrays.asList(serverIds);
        DiskManageExample example = new DiskManageExample();
        example.createCriteria().andServerIdIn(idList);
        List<DiskManage> diskManages = diskManageService.find(example);

        //删除持久化
        if (idList.size() > 0) {
            if (serverManageService.deleteByIds(idList) > 0) {
                if (diskManages.size() > 0) {
                    diskManageService
                            .deleteByIds(diskManages.stream().map(DiskManage::getId).collect(Collectors.toList()));
                }
                return Result.success(true);
            }
        }
        return Result.fail("fail");
    }

    /**
     * 服务分配变更
     *
     * @param openApiReq
     * @return
     */
    @ApiOperation(value = "服务分配变更", notes = "服务分配变更")
    @ApiResponses({
            @ApiResponse(code = 101012, message = "服务分配id不能为空"),
    })
    @RequestMapping(value = "pageChange", method = RequestMethod.POST)
    public Result<List<ServerManageChangeResDTO>> pageChange(@RequestBody ServerManageChangeReqDTO data) {
        //2019-04-24 测试提出的需求变更新增 公共接口，type空的话是原查询，1的话为新增查询
        if (data.getType() == null) {
            BizAssert.assertNotNull(HardWareExceptionCode.SERVER_MANAGE_ID_NULL, data.getOriginId());
        }

        //查找出所有变更源为serverId的历史信息
        List<ServerManageChangeDTO> list = dozerUtils
                .mapList(serverManageService.findServerManageChange(dozerUtils
                        .map(data, ServerManageChangeReqDO.class)), ServerManageChangeDTO.class);

        //转义字典信息
        List<Dictionary> dictionarys = findDictionarys();
        List typeCodes = dictionarys.stream().map(Dictionary::getCode).collect(Collectors.toList());
        List<DictionaryType> types = findDictionaryTypes();
        List typeStrs = types.stream().map(DictionaryType::getCode).collect(Collectors.toList());

        //查找所有变更历史所携带的磁盘
        if (list.size() > 0) {
            DiskManageExample diskManageExample = new DiskManageExample();
            diskManageExample.createCriteria()
                    .andServerIdIn(list.stream().map(ServerManageChangeDTO::getId).collect(Collectors.toList()));
            List<ServerAddDiskDetailDTO> disks = dozerUtils
                    .mapList(diskManageService.find(diskManageExample), ServerAddDiskDetailDTO.class);

            list.forEach(serverObj -> {
                //所属网络
                int index = typeStrs.indexOf(serverObj.getNetScope());
                serverObj.setNetScope(index != -1 ? types.get(index).getName() : "-");

                //操作系统
                index = typeCodes.indexOf(serverObj.getSystem());
                serverObj.setSystem(index != -1 ? dictionarys.get(index).getName() : "-");
                serverObj.setDtos(disks.stream()
                        .filter(diskObj -> serverObj.getId().equals(diskObj.getServerId())).collect(Collectors.toList()));
            });
        }

        //2019-04-24 测试提出的需求变更新增 公共接口，type空的话是原查询，1的话为新增查询，只可能查询出一条数据
        if (data.getType() != null && data.getType().equals(1)) {
            List<ServerManageChangeResDTO> res = new ArrayList<>();
            ServerManageChangeResDTO dto = new ServerManageChangeResDTO();
            if (list != null && list.size() > 0) {
                dto.setSource(list.get(0));
            }
            res.add(dto);
            return Result.success(res);
        }
        //获取change表格并返回
        List<ServerManageChangeResDTO> res = handleServerManageChange(list, -1L, null);
        return Result.success(res);
    }

    private List<Dictionary> findDictionarys() {
        DictionaryExample dictionaryExample = new DictionaryExample();
        dictionaryExample.createCriteria();
        List<Dictionary> dictionarys = dictionaryService.find(dictionaryExample);

        return dictionarys;
    }

    private List<DictionaryType> findDictionaryTypes() {
        DictionaryTypeExample dictionaryTypeExample = new DictionaryTypeExample();
        dictionaryTypeExample.createCriteria();
        List<DictionaryType> dictionaryTypes = dictionaryTypeService.find(dictionaryTypeExample);

        return dictionaryTypes;
    }

    private List<ServerManageChangeResDTO> handleServerManageChange(List<ServerManageChangeDTO> list, Long node, List<ServerManageChangeResDTO> res) {
        if (res == null) {
            res = new ArrayList<>();
        }
        List pids = list.stream().map(ServerManageChangeDTO::getPid).collect(Collectors.toList());
        int index = 0;
        if (pids.indexOf(node) != -1) {
            //添加源
            ServerManageChangeResDTO dto = new ServerManageChangeResDTO();
            index = pids.indexOf(node);
            ServerManageChangeDTO obj = list.get(index);
            dto.setSource(obj);
            if (pids.indexOf(obj.getId()) != -1) {
                //添加目标
                index = pids.indexOf(obj.getId());
                ServerManageChangeDTO mobj = list.get(index);
                dto.setTarget(mobj);
                dto.setApplyNo(mobj.getApplyNo());
                dto.setApplyTime(mobj.getApplyTime());
                dto.setApplyUname(mobj.getApplyUname());
                res.add(dto);

                //递归
                handleServerManageChange(list, obj.getId(), res);
            } else {
                return res;
            }
        }
        return res;
    }


    /**
     * 软硬件面板各资源数量查询
     *
     * @param manageSubmitDTO
     * @return
     */
    @ApiOperation(value = "软硬件面板各资源数量查询",
            notes = "软硬件面板各资源数量查询")
    @RequestMapping(value = "/getResourceCount", method = RequestMethod.GET)
    @ApiResponses({
    })
    public Result<ResourceCountDTO> getResourceCount() {
        MachineManageExample machine = new MachineManageExample();
        machine.createCriteria();
        int machineCount = machineManageService.count(machine);

        ServerManageExample serverManage = new ServerManageExample();
        serverManage.createCriteria().andUseStatusEqualTo(1);
        int serverCount = serverManageService.count(serverManage);

        ServerCountDO serverCountDO = serverManageService.getAllMemorySize();
        long diskSize = serverManageService.getAllDiskSize();

        ResourceCountDTO resourceCountDTO = new ResourceCountDTO();
        resourceCountDTO.setMachineCount(machineCount);
        resourceCountDTO.setServerCount(serverCount);
        resourceCountDTO.setMemorySize(serverCountDO.getMemorySize());
        resourceCountDTO.setCpuCount(serverCountDO.getCpuCount());
        resourceCountDTO.setDiskSize(diskSize);
        return Result.success(resourceCountDTO);
    }

    /**
     * 查询各单位服务器数量统计
     *
     * @param serverIds
     * @return
     */
    @ApiOperation(value = "查询各单位服务器数量统计", notes = "查询各单位服务器数量统计")
    @ApiResponses({
    })
    @RequestMapping(value = "getOrgServersCount", method = RequestMethod.GET)
    public Result<List<OrgServerCountDTO>> getOrgServersCount() {
        List<OrgServerCountDO> list = serverManageService.getOrgServersCount();
        List<OrgServerCountDTO> dto = dozerUtils.mapList(list, OrgServerCountDTO.class);
        return Result.success(dto);
    }

    /**
     * 查询当前月及前十一个月的服务器数量
     *
     * @return
     */
    @ApiOperation(value = "查询当前月及前十一个月的服务器数量", notes = "查询当前月及前十一个月的服务器数量")
    @ApiResponses({
    })
    @RequestMapping(value = "getServersCountByMonth", method = RequestMethod.GET)
    public Result<List<ServersCountByMonthDTO>> getServersCountByMonth() {
        List<ServersCountByMonthDTO> months = new ArrayList<>();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Calendar c = Calendar.getInstance();
        c.setTime(new Date());
        c.add(Calendar.MONTH, -11);
        Date m = c.getTime();
        String startMonth = sdf.format(m) + "-01";
        String endMonth = dateFormat.format(new Date());
        for (int i = 1; i <= 12; i++) {
            Calendar tmp = Calendar.getInstance();
            tmp.setTime(new Date());
            tmp.add(Calendar.MONTH, (i - 12));
            String month = sdf.format(tmp.getTime());
            ServersCountByMonthDTO dto = new ServersCountByMonthDTO();
            dto.setMon(month);
            months.add(dto);
        }
        List<ServersCountByMonthDO> list = serverManageService.getServersCountByMonth(startMonth, endMonth);
        List<ServersCountByMonthDTO> reList = dozerUtils.mapList(list, ServersCountByMonthDTO.class);
        for (ServersCountByMonthDTO dto : months) {
            for (ServersCountByMonthDTO use : reList) {
                if (dto.getMon().equals(use.getMon())) {
                    dto.setServerCount(use.getServerCount());
                }
            }
        }
        return Result.success(months);
    }

    /**
     * 查询当前月及前十一个月的服务器cpu，内存，硬盘等资源数量
     *
     * @return
     */
    @ApiOperation(value = "查询当前月及前十一个月的服务器cpu，内存，硬盘等资源数量",
            notes = "查询当前月及前十一个月的服务器cpu，内存，硬盘等资源数量")
    @ApiResponses({
    })
    @RequestMapping(value = "getServersResCountByMonth", method = RequestMethod.GET)
    public Result<List<ServersResCountByMonthDTO>> getServersResCountByMonth() {
        List<ServersResCountByMonthDTO> months = new ArrayList<>();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Calendar c = Calendar.getInstance();
        c.setTime(new Date());
        c.add(Calendar.MONTH, -11);
        Date m = c.getTime();
        String startMonth = sdf.format(m) + "-01";
        String endMonth = dateFormat.format(new Date());
        for (int i = 1; i <= 12; i++) {
            Calendar tmp = Calendar.getInstance();
            tmp.setTime(new Date());
            tmp.add(Calendar.MONTH, (i - 12));
            String month = sdf.format(tmp.getTime());
            ServersResCountByMonthDTO dto = new ServersResCountByMonthDTO();
            dto.setMon(month);
            months.add(dto);
        }
        List<ServersCountByMonthDO> list = serverManageService.getServersCountByMonth(startMonth, endMonth);
        List<ServersResCountByMonthDTO> reList = dozerUtils.mapList(list, ServersResCountByMonthDTO.class);
        for (ServersResCountByMonthDTO dto : months) {
            for (ServersResCountByMonthDTO use : reList) {
                if (dto.getMon().equals(use.getMon())) {
                    dto.setCpuCount(use.getCpuCount());
                    dto.setDiskSize(use.getDiskSize());
                    dto.setMemorySize(use.getMemorySize());
                }
            }
        }
        return Result.success(months);
    }

    /**
     * 存储管理接口
     *
     * @return
     */
    @ApiOperation(value = "存储管理", notes = "存储管理")
    @ApiResponses({
    })
    @RequestMapping(value = "getMemoryResManage", method = RequestMethod.POST)
    public Result<PageInfo<ServerMemoryResDTO>> getServersMemoryResManage(@RequestBody OpenApiReq<ServerMemoryResDTO> openApiReq) {
        //查询当前登陆人所在单位
        List<GxqptOrgByUserDTO> orgs = gxqptOrgApi.findOrgByUser().getData();
        List<String> orgids = orgs.stream().map(GxqptOrgByUserDTO::getId).collect(Collectors.toList());
        ServerMemoryResDTO dto = openApiReq.getData();
        ServerManageResDO manage = dozerUtils.map(dto, ServerManageResDO.class);
        manage.setOrgids(orgids);
        PageHelper.startPage(openApiReq.getPageNo(), openApiReq.getPageSize());
        List<ServerManageResDO> list = serverManageService.getServerManageRes(manage);
        List<ServerMemoryResDTO> listdto = dozerUtils.mapList(list, ServerMemoryResDTO.class);
        return Result.success(new PageInfo<>(listdto));
    }

    /**
     * 计算资源管理接口
     *
     * @return
     */
    @ApiOperation(value = "计算资源管理", notes = "计算资源管理")
    @ApiResponses({
    })
    @RequestMapping(value = "getCpuResManage", method = RequestMethod.POST)
    public Result<PageInfo<ServerCpuResDTO>> getCpuResManage(@RequestBody OpenApiReq<ServerCpuResDTO> openApiReq) {
        //查询当前登陆人所在单位
        List<GxqptOrgByUserDTO> orgs = gxqptOrgApi.findOrgByUser().getData();
        List<String> orgids = orgs.stream().map(GxqptOrgByUserDTO::getId).collect(Collectors.toList());
        ServerCpuResDTO dto = openApiReq.getData();
        ServerManageResDO manage = dozerUtils.map(dto, ServerManageResDO.class);
        manage.setOrgids(orgids);
        PageHelper.startPage(openApiReq.getPageNo(), openApiReq.getPageSize());
        List<ServerManageResDO> list = serverManageService.getServerManageRes(manage);
        List<ServerCpuResDTO> listdto = dozerUtils.mapList(list, ServerCpuResDTO.class);
        return Result.success(new PageInfo<>(listdto));
    }

    /**
     * 网络宽带管理
     *
     * @return
     */
    @ApiOperation(value = "网络宽带管理", notes = "网络宽带管理")
    @ApiResponses({
    })
    @RequestMapping(value = "getNetResManage", method = RequestMethod.POST)
    public Result<PageInfo<ServerNetWideResDTO>> getNetResManage(@RequestBody OpenApiReq<ServerNetWideResDTO> openApiReq) {
        //查询当前登陆人所在单位
        List<GxqptOrgByUserDTO> orgs = gxqptOrgApi.findOrgByUser().getData();
        List<String> orgids = orgs.stream().map(GxqptOrgByUserDTO::getId).collect(Collectors.toList());
        ServerNetWideResDTO dto = openApiReq.getData();
        ServerManageResDO manage = dozerUtils.map(dto, ServerManageResDO.class);
        manage.setOrgids(orgids);
        PageHelper.startPage(openApiReq.getPageNo(), openApiReq.getPageSize());
        List<ServerManageResDO> list = serverManageService.getServerManageRes(manage);
        List<ServerNetWideResDTO> listdto = dozerUtils.mapList(list, ServerNetWideResDTO.class);
        return Result.success(new PageInfo<>(listdto));
    }

    /**
     * 服务器同一服务id下不能包含一样的ip
     *
     * @param dtos
     * @return
     */
    @ApiOperation(value = "服务ip判断", notes = "服务器同一服务id下不能包含一样的ip")
    @ApiResponses({
    })
    @RequestMapping(value = "checkIp", method = RequestMethod.POST)
    public Result<List<ServerManageDetailDTO>> checkIp(@RequestBody ServerManageCheckIPDTO checkIp) {
        List<ServerManageDetailDTO> result = new ArrayList<>();
        List<ServerManageDetailDTO> dtos = checkIp.getDtos();
        int resultCount = 0;
        if (dtos != null && dtos.size() > 0) {
            for (ServerManageDetailDTO dto : dtos) {
                ServerManageExample example = new ServerManageExample();
                example.createCriteria().andServerIdEqualTo(dto.getServerId()).andIpEqualTo(dto.getIp());
                int count = serverManageService.count(example);
                if (count > 0) {
                    ServerManageDetailDTO reDto = new ServerManageDetailDTO();
                    reDto.setServerId(dto.getServerId());
                    reDto.setIp(dto.getIp());
                    result.add(reDto);
                    resultCount += count;
                }
            }
        }
        if (resultCount > 0) {
            return Result.success(result);
        }
        return Result.success(new ArrayList<>());
    }

    /**
     * 网络带宽面板
     * 网络带宽面板  本月 统计
     * thisMonth 本月（2018-01）
     *
     * @return
     */
    @ApiOperation(value = "网络带宽面板  本月统计 ", notes = "网络带宽面板  本月统计 ")
    @ApiResponses({
    })
    @RequestMapping(value = "getThisMonthStatistics", method = RequestMethod.GET)
    public Result<ThisMonthStatisticsDTO> getThisMonthStatistics(Date thisMonth) {
        int curMonAdd = 0;
        int curMonSub = 0;
        int lastMonAdd = 0;
        int lastMonSub = 0;
        int network = 0;
        List<Map> map = serverManageService.getThisMonthStatistics(new Date());
        if (map != null && map.size() > 0) {
            for (Map en : map) {
                Object object = en.get("net_wide");
                if (object == null) {
                    object = 0;
                }
                if ("curMonAdd".equals(en.get("type").toString())) {//本月新增
                    curMonAdd = Integer.parseInt(object.toString());
                } else if ("curMonSub".equals(en.get("type").toString())) {//本月回收
                    curMonSub = Integer.parseInt(object.toString());
                } else if ("lastMonAdd".equals(en.get("type").toString())) {// 上月新增
                    lastMonAdd = Integer.parseInt(object.toString());
                } else if ("lastMonSub".equals(en.get("type").toString())) {// 上月回收
                    lastMonSub = Integer.parseInt(object.toString());
                } else if ("total".equals(en.get("type").toString())) {
                    network = Integer.parseInt(object.toString());//总量
                }
            }
        }

        //新增占比
        String add_percent = proportion(curMonAdd, network);
        //回收占比
        String sub_percent = proportion(curMonSub, network);

        //新增环比
        String ciraddPercent = proportion(curMonAdd - lastMonAdd, lastMonAdd);
        //回收环比
        String cirsubPercent = proportion(curMonSub - lastMonSub, lastMonSub);

        //净增
        int add = curMonAdd - lastMonAdd;
        //净增占比
        String j_add_percent = proportion(add, network);
        // 注入返回给前端
        ThisMonthStatisticsDTO dto = new ThisMonthStatisticsDTO();
        dto.setNetwork(network);
        dto.setCurMonAdd(curMonAdd);
        dto.setCurMonSub(curMonSub);
        dto.setAddPercent(add_percent);
        dto.setSubPercent(sub_percent);
        dto.setCiraddPercent(ciraddPercent);
        dto.setRevertPercent(cirsubPercent);
        dto.setJadd(add);
        dto.setJaddPercent(j_add_percent);
        return Result.success(dto);
    }

    /**
     * 占比计算
     *
     * @return
     */
    private String proportion(int value1, int value2) {
        // 接受百分比的值
        String result = "";
        // ##.00% 百分比格式，后面不足2位的用0补齐
        DecimalFormat df1 = new DecimalFormat("0.00%");
        if (value2 == 0) {// 被除数为0的情况
            if (value1 > 0) {
                result = df1.format(1.0);
            } else {
                result = df1.format(0.0);
            }
            return result;
        }
        double x_double = value1 * 1.0;//必须要这样转化
        double tempresult = x_double / value2;
        result = df1.format(tempresult);
        return result;
    }

    /**
     * 网络带宽面板
     * 网络带宽面板  各部门网络带宽统计
     * thisMonth 本月（2018-01）
     *
     * @return
     */
    @SuppressWarnings("rawtypes")
    @ApiOperation(value = "网络带宽面板  各部门网络带宽统计（月度） ", notes = "网络带宽面板  各部门网络带宽统计（月度）")
    @ApiResponses({
    })
    @RequestMapping(value = "getEachOrgNetWorkBandwidthMonthStatistics", method = RequestMethod.GET)
    public Result<EachOrgNetWorkBandwidthMonthDTO> getEachOrgNetWorkBandwidthMonthStatistics(Date thisMonth) {
        EachOrgNetWorkBandwidthMonthDTO months = new EachOrgNetWorkBandwidthMonthDTO();
        // 获取所有的部门
        List<String> nameList = serverManageService.getOrgnamelist();
        if (nameList == null || nameList.size() == 0) {
            return Result.success(months);// 直接返回空对象
        }
        List<Integer> numList = new ArrayList<>();// 创建集合 存储于部门对应的数据
        for (int i = 0; i < nameList.size(); i++) {
            numList.add(0);// 初始化数据  默认都为0 用于后期数据替换
        }
        // 获取数据
        List<Map> map = serverManageService.getEachOrgNetWorkBandwidthMonthStatistics(new Date());
        for (int i = 0; i < numList.size(); i++) {// 遍历
            for (Map en : map) {
                // 判断部门是否相同
                if (en.get("orgname") != null && nameList.get(i).equals(en.get("orgname").toString())) {
                    Object object = en.get("net_wide");
                    if (object == null) {
                        object = 0;// 若object对象为空 注入默认值0 防止报空指针异常
                    }
                    // 数据替换
                    numList.set(i, Integer.parseInt(object.toString()));
                }
            }
        }
        months.setNameList(nameList);
        months.setNumList(numList);
        return Result.success(months);
    }

    /**
     * 网络带宽面板
     * 网络带宽面板  各部门网络带宽统计
     * thisMonth 12个月
     *
     * @return
     */
    @ApiOperation(value = "网络带宽面板  各部门网络带宽统计（年度） ", notes = "网络带宽面板  各部门网络带宽统计（年度）")
    @ApiResponses({
    })
    @RequestMapping(value = "getEachOrgNetWorkBandwidthYearStatistics", method = RequestMethod.GET)
    public Result<EachOrgNetWorkBandwidthYearDTO> getEachOrgNetWorkBandwidthYearStatistics(@RequestParam(required = false, value = "thisMonth") Date thisMonth) {

        Date date = new Date();
        EachOrgNetWorkBandwidthYearDTO dto = new EachOrgNetWorkBandwidthYearDTO();
        // 获取所有的部门
        List<String> nameList = serverManageService.getOrgnamelist();
        if (nameList == null || nameList.size() == 0) {
            return Result.success(dto);// 直接返回空对象
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");

        List<String> months = DateUtils.getSpecifiedTimesMonth(12, date);// 获取指定年月

        List<CommonDTO> numList = new ArrayList<>();// 创建一个集合 用于存储 name 和  data

        List<Map> map = serverManageService.getEachOrgNetWorkBandwidthYearStatistics(date);// 数据库查询返回数据
        for (int i = 0; i < nameList.size(); i++) {// 遍历
            List<Integer> nums = new ArrayList<>();// 创建一个集合 用于存储对应部门12个月的数据
            CommonDTO enDto = new CommonDTO();
            enDto.setName(nameList.get(i));// 部门名称存储
            int net_wide = 0;
            for (int t = 0; t < months.size(); t++) {
                for (Map en : map) {
                    if (en.get("orgname") != null && nameList.get(i).equals(en.get("orgname").toString())) {// 部门名称是否相同
                        if ((months.get(t).equals(en.get("time").toString()))) {
                            Object object = en.get("net_wide");
                            if (object == null) {
                                object = 0;// 若object对象为空 注入默认值0 防止报空指针异常
                            }
                            net_wide = Integer.parseInt(object.toString()) + net_wide;
                            break;
                        }
                    }
                }
                nums.add(net_wide);// 数据替换
            }
            enDto.setValue(nums);// 注入到 实体  直接按照前端数据格式封装
            numList.add(enDto);// 数据存储 返回值
        }
        dto.setNameList(nameList);
        dto.setNumList(numList);
        dto.setMonthsList(months);
        return Result.success(dto);
    }
}