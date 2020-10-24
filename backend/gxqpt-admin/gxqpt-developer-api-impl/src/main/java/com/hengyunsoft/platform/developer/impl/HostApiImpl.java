package com.hengyunsoft.platform.developer.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hengyunsoft.base.Result;
import com.hengyunsoft.commons.context.BaseContextHandler;
import com.hengyunsoft.commons.exception.core.DeveloperExceptionCode;
import com.hengyunsoft.commons.utils.context.DozerUtils;
import com.hengyunsoft.page.plugins.openapi.OpenApiReq;
import com.hengyunsoft.platform.admin.entity.core.po.AssignRole;
import com.hengyunsoft.platform.admin.entity.core.po.Role;
import com.hengyunsoft.platform.admin.entity.core.po.User;
import com.hengyunsoft.platform.admin.repository.authority.service.AssignRoleService;
import com.hengyunsoft.platform.admin.repository.authority.service.RoleService;
import com.hengyunsoft.platform.admin.repository.core.service.UserService;
import com.hengyunsoft.platform.developer.api.service.api.HostApi;
import com.hengyunsoft.platform.developer.api.service.dto.*;
import com.hengyunsoft.platform.developer.entity.core.po.Host;
import com.hengyunsoft.platform.developer.repository.service.service.HostService;
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
import java.util.*;

/**
 * @author luchanghong
 * @create 2018-04-03 11:37
 * @desc 主机管理Api实现层
 **/
@Api(value = "API - HostApiImpl.java", description = "主机管理Api实现层")
@RestController
@RequestMapping("/host")
@Slf4j
public class HostApiImpl implements HostApi{
    @Autowired
    private HostService hostService;
    @Autowired
    DozerUtils dozerUtils;
    @Autowired
    private UserService userService;
    @Autowired
    private RoleService roleService;
    @Autowired
    private AssignRoleService assignRoleService;

    /**
     * 查询主机数据列表
     * @param openApiReq
     * @return
     */
    @Override
    @ApiOperation(value = "查询主机数据列表", notes = "查询主机数据列表")
    @ApiResponses({
            @ApiResponse(code = 0, message = ""),
    })
    @RequestMapping(value = "/pageFindHostList", method = RequestMethod.POST)
    public Result<PageInfo<HostDTO>> pageFindHostList(@RequestBody OpenApiReq<HostListDTO> openApiReq) {
        Host map = dozerUtils.map(openApiReq.getData(), Host.class);
        PageHelper.startPage(openApiReq.getPageNo(),openApiReq.getPageSize());
        List<Host> hostList = hostService.findHostList(map);
        List<HostDTO> hostListDTOS = dozerUtils.mapPage(hostList, HostDTO.class);
        Result<PageInfo<HostDTO>> success = Result.success(new PageInfo<HostDTO>(hostListDTOS),"数据列表获取成功");
        return success;

    }

    /**
     * 保存主机数据
     * @param hostDTO
     * @return
     */
    @Override
    @ApiOperation(value = "保存主机数据", notes = "保存主机数据")
    @ApiResponses({
            @ApiResponse(code = 0, message = ""),
    })
    @ValidatorStandard(
            {
                    @Constraint(value = Host.class, groups = {Default.class,ValidatorGroups.MustNoneNull.class})
            }
    )
    @RequestMapping(value = "/saveHost", method = RequestMethod.POST)
    public Result<Boolean> saveHost(@RequestBody HostDTO hostDTO) {
        Result<Boolean> result=null;
        if (hostDTO!=null){
            Host host = dozerUtils.map(hostDTO, Host.class);
            Long aLong = hostService.saveHost(host);
            Role role = new Role();
            role.setBizFlag(aLong.toString());
            role.setName(host.getHostName()+"管理员");
            roleService.saveHostAdmin(role);
            Long roleId = roleService.findRoleIdByBizFlag(aLong);
            AssignRole ar=new AssignRole();
            ar.setRoleId(roleId);
            ar.setUserId(BaseContextHandler.getAdminId());
            ar.setCreateTime(new Date());
            ar.setCreateUser(BaseContextHandler.getAdminId());
            assignRoleService.save(ar);
            result = Result.success(true,"数据保存成功");
        }
        return result;
    }

    /**
     * 主机数据编辑查询
     * @param id
     * @return
     */
    @Override
    @ApiOperation(value = "主机数据编辑查询", notes = "主机数据编辑查询")
    @ApiResponses({
            @ApiResponse(code = 0, message = ""),
            @ApiResponse(code = 78000, message = "主机id不能为空"),
    })
    @RequestMapping(value = "/getEditHost", method = RequestMethod.POST)
    public Result<HostDTO> getEditHost(@RequestParam(value = "id") Long id) {
        //1.校验
        BizAssert.assertNotNull(DeveloperExceptionCode.HOST_ID_NULL,id);
        Result<HostDTO> result=null;
        if (id!=0){
            Host host = hostService.editHost(id);
            HostDTO hd = dozerUtils.map(host, HostDTO.class);
         result = Result.success(hd,"数据查找成功");
        }
        return result;
    }

    /**
     * 主机数据更新
     * @param hostDTO
     * @return
     */
    @Override
    @ApiOperation(value = "主机数据更新", notes = "主机数据更新")
    @ApiResponses({
            @ApiResponse(code = 0, message = ""),
            @ApiResponse(code = 78000, message = "主机id不能为空"),
    })
    @RequestMapping(value = "/updateEditHostSubmit", method = RequestMethod.POST)
    public Result<Boolean> updateEditHostSubmit(@RequestBody HostDTO hostDTO) {
        //1.校验
        BizAssert.assertNotNull(DeveloperExceptionCode.HOST_ID_NULL,hostDTO.getId());
        Result<Boolean> result=null;
        if(hostDTO!=null){
            Host host = dozerUtils.map(hostDTO, Host.class);
            hostService.editHostSubmit(host);
            result = Result.success(true, "更新数据成功");
        }
        return  result;
    }

    /**
     * 删除主机
     * @param id
     * @return
     */
    @Override
    @ApiOperation(value = "删除主机", notes = "删除主机")
    @ApiResponses({
            @ApiResponse(code = 0, message = ""),
            @ApiResponse(code = 78000, message = "主机id不能为空"),
    })
    @RequestMapping(value = "/deleteHost", method = RequestMethod.POST)
    public Result<Boolean> deleteHost(@RequestParam(value = "id") Long id) {
        //1.校验
        BizAssert.assertNotNull(DeveloperExceptionCode.HOST_ID_NULL,id);
        Result<Boolean> result=null;
        if (id!=0){
            hostService.deleteHost(id);
           result= Result.success(true,"删除成功");
        }
        return result;
    }

    /**
     * 主机详情
     * @param id
     * @return
     */
    @Override
    @ApiOperation(value = "主机详情", notes = "主机详情")
    @ApiResponses({
            @ApiResponse(code = 0, message = ""),
            @ApiResponse(code = 78000, message = "主机id不能为空"),
    })
    @RequestMapping(value = "/getDetailHost", method = RequestMethod.POST)
    public Result<HostDTO> getDetailHost(@RequestParam(value = "id") Long id) {
        //1.校验
        BizAssert.assertNotNull(DeveloperExceptionCode.HOST_ID_NULL,id);
        Result<HostDTO> result=null;
        if (id!=0){
            Host host = hostService.detailHost(id);
            HostDTO hd = dozerUtils.map(host, HostDTO.class);
            result = Result.success(hd,"数据查找成功");
        }
        return result;
    }

    /**
     * 更新主机状态
     * @param hostStatusDTO
     * @return
     */
    @Override
    @ApiOperation(value = "更新主机状态", notes = "更新主机状态")
    @ApiResponses({
            @ApiResponse(code = 0, message = ""),
            @ApiResponse(code = 78000, message = "主机id不能为空"),
            @ApiResponse(code =78001,message = "主机状态不能为空"),
    })
    @RequestMapping(value = "/updateStatus",method = RequestMethod.POST)
    public Result<Boolean> updateStatus(@RequestBody HostStatusDTO hostStatusDTO) {
        //1.校验
        BizAssert.assertNotNull(DeveloperExceptionCode.HOST_ID_NULL,hostStatusDTO.getId());
        BizAssert.assertNotNull(DeveloperExceptionCode.HOST_STATUS_NULL,hostStatusDTO.getStatus());
        Result<Boolean> result=null;
        if(hostStatusDTO!=null){
            Host host = dozerUtils.map(hostStatusDTO, Host.class);
            hostService.updateStatus(host);
            result = Result.success(true, "状态更新成功");
        }
        return result;
    }

    /**
     * 查询主机管理员列表
     * @param openApiReq
     * @return
     */
    @Override
    @ApiOperation(value = "查询主机管理员列表", notes = "查询主机管理员列表")
    @ApiResponses({
            @ApiResponse(code = 0, message = ""),
            @ApiResponse(code = 78000, message = "主机id不能为空"),
    })
    @RequestMapping(value = "/pageHostAdminList",method = RequestMethod.POST)
    public Result<PageInfo<HostAdminListDTO>> pageHostAdminList(@RequestBody OpenApiReq<HostAdminListDTO> openApiReq) {
        //1.校验
        BizAssert.assertNotNull(DeveloperExceptionCode.HOST_ID_NULL,openApiReq.getData().getHostId());
        PageHelper.startPage(openApiReq.getPageNo(),openApiReq.getPageSize());
        List<User> user = userService.hostAdminList(openApiReq.getData().getHostId(),openApiReq.getData().getName(),openApiReq.getData().getId(),openApiReq.getData().getAccount());
        List<HostAdminListDTO> hostAdminListDTOS = dozerUtils.mapPage(user, HostAdminListDTO.class);
        for (HostAdminListDTO hd:hostAdminListDTOS){
            hd.setHostId(openApiReq.getData().getHostId());
        }
        Result<PageInfo<HostAdminListDTO>> success = Result.success(new PageInfo<HostAdminListDTO>(hostAdminListDTOS),"查询主机管理员列表成功");
        return  success;
    }

    /**
     * 关联主机
     * @param hostId
     * @return
     */
    @Override
    @ApiOperation(value = "关联主机", notes = "关联主机")
    @ApiResponses({
            @ApiResponse(code = 0, message = ""),
            @ApiResponse(code = 78000,message = "主机id不能为空"),
            @ApiResponse(code = 78002,message = "用户id不能为空"),
    })
    @RequestMapping(value = "/saveRelate",method = RequestMethod.POST)
    public Result<Boolean> saveRelate(@RequestParam(value = "hostId") Long hostId,@RequestParam(value = "userId") Long userId) {
        //1.校验
        BizAssert.assertNotNull(DeveloperExceptionCode.HOST_ID_NULL,hostId);
        BizAssert.assertNotNull(DeveloperExceptionCode.HOST_ID_NULL,userId);
        Long roleId = roleService.findRoleIdByBizFlag(hostId);
        assignRoleService.saveRelate(roleId,userId);
        Result<Boolean> success = Result.success(true,"关联成功");
        return success;

    }


    /**
     * 取消主机管理员关联
     * @param assignId
     * @return
     */
    @Override
    @ApiOperation(value = "取消主机管理员关联", notes = "取消主机管理员关联")
    @ApiResponses({
            @ApiResponse(code = 0, message = ""),
            @ApiResponse(code = 78003,message = "用户角色关联id不能为空"),
    })
    @RequestMapping(value = "/deleteCancleRelate",method = RequestMethod.POST)
    public Result<Boolean> deleteCancleRelate(@RequestParam(value = "assignId") Long assignId) {
        //1.校验
        BizAssert.assertNotNull(DeveloperExceptionCode.HOST_ID_NULL,assignId);
        assignRoleService.deleteById(assignId);
        Result<Boolean> result = Result.success(true, "取消关联成功");
        return result;
    }

    /**
     * 获取主机创建人
     * @return
     */
    @Override
    @ApiOperation(value = "获取主机创建人", notes = "获取主机创建人")
    @ApiResponses({
            @ApiResponse(code = 0, message = ""),
    })
    @RequestMapping(value = "/findHostCreateUser",method =RequestMethod.GET )
    public Result<List<HostCreateUserDTO>> findHostCreateUser() {
        List<User> user= userService.findHostCreateUser();
        List<HostCreateUserDTO> hostCreateUserDTOS = dozerUtils.mapList(user, HostCreateUserDTO.class);
        HashSet<HostCreateUserDTO> userDTOS = new HashSet<>(hostCreateUserDTOS);
        List<HostCreateUserDTO> hdt = new ArrayList<>(userDTOS);
        Result<List<HostCreateUserDTO>> result = Result.success(hdt, "获取主机创建人成功");
        return  result;

    }

    /**
     * 获取主机名列表
     * @return
     */
    @Override
    @ApiOperation(value = "获取主机名列表", notes = "获取主机名列表")
    @ApiResponses({
            @ApiResponse(code = 0, message = ""),
    })
    @RequestMapping(value = "/getHostNameList",method =RequestMethod.GET )
    public Result<List<HostNameList>> getHostNameList() {
        List<Host> hostList = hostService.findHostList(new Host());
        Iterator<Host> iterator = hostList.iterator();
        while (iterator.hasNext()){
            Host next = iterator.next();
            if( next.getStatus().equals(false)) {
                iterator.remove();
            }else if( next.getVirtualHost().shortValue()==2) {
                iterator.remove();
            }
        }
        List<HostNameList> hostNameLists = dozerUtils.mapList(hostList, HostNameList.class);
        Result<List<HostNameList>> result = Result.success(hostNameLists, "获取主机名列表成功");
        return result;

    }

    }