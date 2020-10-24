package com.hengyunsoft.platform.hardware.impl.manage;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hengyunsoft.base.Result;
import com.hengyunsoft.commons.context.BaseContextHandler;
import com.hengyunsoft.commons.exception.core.HardWareExceptionCode;
import com.hengyunsoft.commons.utils.context.DozerUtils;
import com.hengyunsoft.page.plugins.openapi.OpenApiReq;
import com.hengyunsoft.platform.hardware.dto.manage.*;
import com.hengyunsoft.platform.hardware.entity.manage.po.MachineManage;
import com.hengyunsoft.platform.hardware.repository.manage.example.MachineManageExample;
import com.hengyunsoft.platform.hardware.repository.manage.service.MachineManageService;
import com.hengyunsoft.utils.BizAssert;
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

import java.util.Date;
import java.util.List;

/**
 * @author luchanghong
 * @create 2018-07-16 14:01
 * @desc 主机管理
 **/

@Api(value = "API - MachineManageApiImpl", description = "主机管理")
@RestController
@RequestMapping("machine")
@Slf4j
public class MachineManageApiImpl {
    @Autowired
    private MachineManageService machineManageService;
    @Autowired
    private DozerUtils dozerUtils;

    /**
     * 查询主机列表
     * @param openApiReq
     * @return
     */
    @ApiOperation(value = "查询主机列表", notes = "查询主机列表")
    @RequestMapping(value = "findMachineList",method = RequestMethod.POST)
    public Result<PageInfo<FindMachineListDTO>> findMachineList(@RequestBody OpenApiReq<MachineConditionDTO> openApiReq){
        MachineManage map = dozerUtils.map(openApiReq.getData(), MachineManage.class);
        MachineManageExample me=new MachineManageExample();
        me.createCriteria().andIpLike(MachineManageExample.fullLike(openApiReq.getData().getIp()))
                .andModelLike(MachineManageExample.fullLike(openApiReq.getData().getModel()))
                .andCpuCountEqualTo(openApiReq.getData().getCpuCount())
                .andMemoryEqualTo(openApiReq.getData().getMemory())
                .andNetcardCountEqualTo(openApiReq.getData().getNetcardCount());
        PageHelper.startPage(openApiReq.getPageNo(), openApiReq.getPageSize());
        return Result.success(new PageInfo<>(dozerUtils.mapPage(machineManageService.find(me), FindMachineListDTO.class)));
    }

    /**
     * 保存主机数据
     * @param saveMachineDTO
     * @return
     */
    @ApiOperation(value = "保存主机数据", notes = "保存主机数据")
    @RequestMapping(value = "saveMachine",method = RequestMethod.POST)
    @ApiResponses({
            @ApiResponse(code =101500,message = "主机ip不能为空"),
            @ApiResponse(code =101501,message = "主机集群不能为空"),
            @ApiResponse(code =101502,message = "处理器数量不能为空"),
            @ApiResponse(code =101503,message = "内存大小不能为空"),
            @ApiResponse(code = 101504,message = "网卡数量不能为空"),
            @ApiResponse(code = 101505,message = "磁盘大小不能为空")
    })
    public  Result<Boolean> saveMachine(@RequestBody SaveMachineDTO saveMachineDTO ){
        //1.校验
        BizAssert.assertNotNull(HardWareExceptionCode.MACHINE_IP_NULL, saveMachineDTO.getIp());
        BizAssert.assertNotNull(HardWareExceptionCode.MACHINE_CLUSTER_NULL, saveMachineDTO.getCluster());
        BizAssert.assertNotNull(HardWareExceptionCode.MACHINE_CPUCOUNT_NULL, saveMachineDTO.getCpuCount());
        BizAssert.assertNotNull(HardWareExceptionCode.MACHINE_DISKSIZE_NULL, saveMachineDTO.getDiskSize());
        BizAssert.assertNotNull(HardWareExceptionCode.MACHINE_MEMORY_NULL, saveMachineDTO.getMemory());
        BizAssert.assertNotNull(HardWareExceptionCode.MACHINE_NETCARDCOUNT_NULL, saveMachineDTO.getNetcardCount());
        MachineManage map = dozerUtils.map(saveMachineDTO, MachineManage.class);
       map.setCreateTime(new Date());
       map.setCreateUser(BaseContextHandler.getAdminId().toString());
       map.setUpdateUser(BaseContextHandler.getAdminId().toString());
       map.setUpdateTime(new Date());
        machineManageService.save(map);
        return Result.success(true);
    }
    /**
     * 保存主机数据(集合)
     * @param saveMachineDTO
     * @return
     */
    @ApiOperation(value = "保存主机数据集合", notes = "保存主机数据集合")
    @RequestMapping(value = "saveMachines",method = RequestMethod.POST)
    @ApiResponses({
            @ApiResponse(code =101500,message = "主机ip不能为空"),
            @ApiResponse(code =101501,message = "主机集群不能为空"),
            @ApiResponse(code =101502,message = "处理器数量不能为空"),
            @ApiResponse(code =101503,message = "内存大小不能为空"),
            @ApiResponse(code = 101504,message = "网卡数量不能为空"),
            @ApiResponse(code = 101505,message = "磁盘大小不能为空"),
            @ApiResponse(code = 100015,message = "申请单主键不能为空")
    })
    public  Result<Boolean> saveMachines(@RequestBody SaveMachinesDTO saveMachine){
       List<SaveMachineDTO> saveMachineDTO =  saveMachine.getMachines();
        //1.校验
        saveMachineDTO.forEach(obj -> {
            BizAssert.assertNotNull(HardWareExceptionCode.MACHINE_IP_NULL, obj.getIp());
            BizAssert.assertNotNull(HardWareExceptionCode.MACHINE_CLUSTER_NULL, obj.getCluster());
            BizAssert.assertNotNull(HardWareExceptionCode.MACHINE_CPUCOUNT_NULL, obj.getCpuCount());
            BizAssert.assertNotNull(HardWareExceptionCode.MACHINE_DISKSIZE_NULL, obj.getDiskSize());
            BizAssert.assertNotNull(HardWareExceptionCode.MACHINE_MEMORY_NULL, obj.getMemory());
            BizAssert.assertNotNull(HardWareExceptionCode.MACHINE_NETCARDCOUNT_NULL, obj.getNetcardCount());
            BizAssert.assertNotNull(HardWareExceptionCode.APPLY_SERVER_APPLYKEYID_NULL, obj.getApplyKeyid());
        });
        //2.删除历史纪录
        machineManageService.deleteByApplyKeyid(saveMachineDTO.get(0).getApplyKeyid());
        List<MachineManage> map = dozerUtils.mapList(saveMachineDTO, MachineManage.class);
        map.forEach(obj ->{
            obj.setCreateTime(new Date());
            obj.setCreateUser(BaseContextHandler.getAdminId().toString());
            obj.setUpdateUser(BaseContextHandler.getAdminId().toString());
            obj.setUpdateTime(new Date());
        });
        machineManageService.save(map);
        return Result.success(true);
    }
    /**
     * 修改主机数据
     * @param updateMachineDTO
     * @return
     */
    @ApiOperation(value = "修改主机数据", notes = "修改主机数据")
    @RequestMapping(value = "updateMachine",method = RequestMethod.POST)
    @ApiResponses({
            @ApiResponse(code =101500,message = "主机ip不能为空"),
            @ApiResponse(code =101501,message = "主机集群不能为空"),
            @ApiResponse(code =101502,message = "处理器数量不能为空"),
            @ApiResponse(code =101503,message = "内存大小不能为空"),
            @ApiResponse(code = 101504,message = "网卡数量不能为空"),
            @ApiResponse(code = 101505,message = "磁盘大小不能为空")
    })
    public  Result<Boolean> updateMachine(@RequestBody UpdateMachineDTO updateMachineDTO ){
        //1.校验
        BizAssert.assertNotNull(HardWareExceptionCode.MACHINE_IP_NULL, updateMachineDTO.getIp());
        BizAssert.assertNotNull(HardWareExceptionCode.MACHINE_CLUSTER_NULL, updateMachineDTO.getCluster());
        BizAssert.assertNotNull(HardWareExceptionCode.MACHINE_CPUCOUNT_NULL, updateMachineDTO.getCpuCount());
        BizAssert.assertNotNull(HardWareExceptionCode.MACHINE_DISKSIZE_NULL, updateMachineDTO.getDiskSize());
        BizAssert.assertNotNull(HardWareExceptionCode.MACHINE_MEMORY_NULL, updateMachineDTO.getMemory());
        BizAssert.assertNotNull(HardWareExceptionCode.MACHINE_NETCARDCOUNT_NULL, updateMachineDTO.getNetcardCount());
        MachineManage map = dozerUtils.map(updateMachineDTO, MachineManage.class);
        map.setUpdateUser(BaseContextHandler.getAdminId().toString());
        map.setUpdateTime(new Date());
        machineManageService.updateByIdSelective(map);
        return Result.success(true);
    }

    /**
     * 删除主机应用
     * @param id
     * @return
     */
    @ApiOperation(value = "删除主机数据", notes = "删除主机数据")
    @RequestMapping(value = "deleteMachine",method = RequestMethod.GET)
    @ApiResponses({
            @ApiResponse(code =101506,message = "主机id不能为空")
    })
    public Result<Boolean> deleteMachine(@RequestParam Long id){
        //1.校验
        BizAssert.assertNotNull(HardWareExceptionCode.MACHINE_ID_NULL, id);
        machineManageService.deleteById(id);
       return Result.success(true);
    }
    /**
     * 主机应用详情查询
     * @param id
     * @return
     */
    @ApiOperation(value = "主机应用详情查询", notes = "主机应用详情查询")
    @RequestMapping(value = "getMachineDetail",method = RequestMethod.GET)
    @ApiResponses({
            @ApiResponse(code =101506,message = "主机id不能为空")
    })
    public Result<SaveMachineDTO> getMachineDetail(@RequestParam Long id){
        //1.校验
        BizAssert.assertNotNull(HardWareExceptionCode.MACHINE_ID_NULL, id);
        MachineManage mm = machineManageService.getById(id);
        SaveMachineDTO map = dozerUtils.map(mm, SaveMachineDTO.class);
        return Result.success(map,"true");
    }

}