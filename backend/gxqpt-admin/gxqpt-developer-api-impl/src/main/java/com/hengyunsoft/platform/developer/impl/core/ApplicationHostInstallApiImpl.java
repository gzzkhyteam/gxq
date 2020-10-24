package com.hengyunsoft.platform.developer.impl.core;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hengyunsoft.base.Result;
import com.hengyunsoft.commons.context.BaseContextHandler;
import com.hengyunsoft.commons.exception.core.DeveloperExceptionCode;
import com.hengyunsoft.commons.utils.context.DozerUtils;
import com.hengyunsoft.page.plugins.openapi.OpenApiReq;
import com.hengyunsoft.platform.admin.repository.core.service.UserService;
import com.hengyunsoft.platform.developer.api.core.api.ApplicationHostInstallApi;
import com.hengyunsoft.platform.developer.api.core.dto.install.HostInstallDetailsDTO;
import com.hengyunsoft.platform.developer.api.core.dto.install.HostInstallLikeReqDTO;
import com.hengyunsoft.platform.developer.api.core.dto.install.HostInstallLikeResDTO;
import com.hengyunsoft.platform.developer.api.core.dto.install.HostInstallSaveDTO;
import com.hengyunsoft.platform.developer.api.core.dto.install.HostInstallUpdateDTO;
import com.hengyunsoft.platform.developer.api.service.dto.ApplicationHostInstallDTO;
import com.hengyunsoft.platform.developer.api.service.dto.ApplicationHostInstallListDTO;
import com.hengyunsoft.platform.developer.api.service.dto.ApplicationHostNameDTO;
import com.hengyunsoft.platform.developer.api.service.dto.ApplicationNameDTO;
import com.hengyunsoft.platform.developer.entity.core.domain.ApplicationHostInstallDO;
import com.hengyunsoft.platform.developer.entity.core.po.ApplicationHostInstall;
import com.hengyunsoft.platform.developer.repository.core.service.ApplicationHostInstallService;
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

@Api(value = "API - ApplicationHostInstallApiImpl", description = "应用/服务部署管理")
@RestController
@RequestMapping("/hostInstall/")
@Slf4j
public class ApplicationHostInstallApiImpl implements ApplicationHostInstallApi {
    @Autowired
    private ApplicationHostInstallService hostInstallService;
    @Autowired
    private DozerUtils dozerUtils;
    @Autowired
    private UserService userService;

    /**
     * 分页查询部署
     *
     * @param openApiReq
     * @return
     * @auther:wz
     */
    @Override
    @ApiOperation(value = "分页查询部署", notes = "分页查询部署")
    @ApiResponses({
            @ApiResponse(code = 77001, message = "部署内容的应用id不能为空"),
    })
    @RequestMapping(value = "/page", method = RequestMethod.POST)
    public Result<PageInfo<HostInstallLikeResDTO>> page(@RequestBody OpenApiReq<HostInstallLikeReqDTO> openApiReq) {
        //1.验证
    	HostInstallLikeReqDTO dto = openApiReq.getData();
        BizAssert.assertNotNull(DeveloperExceptionCode.INSTALL_APPID_NULL, dto.getAppId());
        //2.设置分页器
        PageHelper.startPage(openApiReq.getPageNo(), openApiReq.getPageSize());

        //3.查询并转换
        List<ApplicationHostInstallDO> hostInstall = hostInstallService
                .pageHostInstall(dto.getAppId(),dto.getHostId(),dto.getHostName());
        List<HostInstallLikeResDTO> list = dozerUtils.mapPage(hostInstall, HostInstallLikeResDTO.class);
        return Result.success(new PageInfo<>(list));
    }

    /**
     * 查看部署详情
     *
     * @param id
     * @return
     * @auther:wz
     */
    @Override
    @ApiOperation(value = "查看部署详情", notes = "查看部署详情")
    @ApiResponses({
            @ApiResponse(code = 77000, message = "部署内容id不能为空"),
    })
    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public Result<HostInstallDetailsDTO> get(@RequestParam(value = "id") Long id) {
        //1.验证
        BizAssert.assertNotNull(DeveloperExceptionCode.INSTALL_ID_NULL, id);
        //2.查询并转换
        HostInstallDetailsDTO hostInstallDetails = dozerUtils.map(hostInstallService.getDetails(id), HostInstallDetailsDTO.class);
        if (hostInstallDetails != null) {
            return Result.success(hostInstallDetails);
        }
        return Result.fail("fail");
    }

    /**
     * 新增部署
     *
     * @param hostInstallSave
     * @return
     * @auther:wz
     */
    @Override
    @ApiOperation(value = "新增部署", notes = "新增部署")
    @ApiResponses({
            @ApiResponse(code = 77001, message = "部署内容的应用id不能为空"),
            @ApiResponse(code = 77002, message = "部署的路径不能为空"),
            @ApiResponse(code = 77003, message = "部署所分配内存不能为空"),
            @ApiResponse(code = 77004, message = "部署所分配硬盘容量不能为空"),
            @ApiResponse(code = 77005, message = "首页访问地址不能为空"),
            @ApiResponse(code = 77006, message = "部署主机不能为空"),
    })
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public Result<Boolean> save(@RequestBody HostInstallSaveDTO hostInstallSave) {
        //1.验证
        BizAssert.assertNotNull(DeveloperExceptionCode.INSTALL_APPID_NULL, hostInstallSave.getAppId());
        BizAssert.assertNotNull(DeveloperExceptionCode.INSTALL_HOST_NULL, hostInstallSave.getHostId());
        BizAssert.assertNotNull(DeveloperExceptionCode.INSTALL_MEM_NULL, hostInstallSave.getMem());
        BizAssert.assertNotNull(DeveloperExceptionCode.INSTALL_HARDDISK_NULL, hostInstallSave.getHarddisk());
        BizAssert.assertNotNull(DeveloperExceptionCode.INSTALL_URL_NULL, hostInstallSave.getIndexUrl());
        BizAssert.assertNotNull(DeveloperExceptionCode.INSTALL_PATH_NULL, hostInstallSave.getInstallPath());

        //2.封装PO
        ApplicationHostInstall hostInstall = dozerUtils.map(hostInstallSave, ApplicationHostInstall.class);
        hostInstall.setCreateUser(BaseContextHandler.getAdminId());
        hostInstall.setCreateTime(new Date());

        //3.执行DML
        if (hostInstallService.save(hostInstall).getId() != null) {
            return Result.success(true);
        }
        return Result.fail("fail");
    }

    /**
     * 修改部署
     *
     * @param hostInstallUpdate
     * @return
     * @auther:wz
     */
    @Override
    @ApiOperation(value = "修改部署", notes = "修改部署")
    @ApiResponses({
            @ApiResponse(code = 77000, message = "部署内容id不能为空"),
    })
    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public Result<Boolean> update(@RequestBody HostInstallUpdateDTO hostInstallUpdate) {
        //1.验证
        BizAssert.assertNotNull(DeveloperExceptionCode.INSTALL_ID_NULL, hostInstallUpdate.getId());

        //2.设置修改基本信息
        ApplicationHostInstall po = dozerUtils.map(hostInstallUpdate, ApplicationHostInstall.class);
        po.setUpdateUser(BaseContextHandler.getAdminId());
        po.setUpdateTime(new Date());

        //3.执行DML
        if (hostInstallService.updateByIdSelective(po) > 0) {
            return Result.success(true);
        }
        return Result.fail("fail");
    }

    /**
     * 删除部署
     *
     * @param id
     * @return
     * @auther:wz
     */
    @Override
    @ApiOperation(value = "删除部署", notes = "删除部署")
    @ApiResponses({
            @ApiResponse(code = 77000, message = "部署内容id不能为空"),
    })
    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public Result<Boolean> delete(@RequestParam(value = "id") Long id) {
        //1.验证
        BizAssert.assertNotNull(DeveloperExceptionCode.INSTALL_ID_NULL, id);

        //2.执行DML
        if (hostInstallService.deleteById(id) > 0) {
            return Result.success(true);
        }
        return Result.fail("fail");
    }

    /**
     * 主机应用部署列表查询
     *
     * @param openApiReq
     * @return
     */
    @Override
    @ApiOperation(value = "查询主机应用部署列表", notes = "查询主机应用部署列表")
    @ApiResponses({
            @ApiResponse(code = 0, message = ""),
    })
    @RequestMapping(value = "/pageFindList", method = RequestMethod.POST)
    public Result<PageInfo<ApplicationHostInstallListDTO>> pageFindList(@RequestBody OpenApiReq<ApplicationHostInstallListDTO> openApiReq) {
        PageHelper.startPage(openApiReq.getPageNo(), openApiReq.getPageSize());
        List<ApplicationHostInstall> list = hostInstallService.findList(openApiReq.getData().getHostName(), openApiReq.getData().getAppId(), openApiReq.getData().getHostId());
        List<ApplicationHostInstallListDTO> ahl = dozerUtils.mapPage(list, ApplicationHostInstallListDTO.class);
        PageInfo<ApplicationHostInstallListDTO> applicationHostInstallListDTOPageInfo = new PageInfo<>(ahl);
        Result<PageInfo<ApplicationHostInstallListDTO>> result = Result.success(applicationHostInstallListDTOPageInfo, "数据查询成功");
        return result;
    }

    @Override
    @ApiOperation(value = "保存主机应用部署数据", notes = "保存主机应用部署数据")
    @ApiResponses({
            @ApiResponse(code = 0, message = ""),
    })
    @RequestMapping(value = "/saveApplicationHostInstall", method = RequestMethod.POST)
    public Result<Boolean> saveApplicationHostInstall(@RequestBody ApplicationHostInstallDTO applicationHostInstallDTO) {
        Result<Boolean> result = null;
        if (applicationHostInstallDTO != null) {
            ApplicationHostInstall map = dozerUtils.map(applicationHostInstallDTO, ApplicationHostInstall.class);
            map.setCreateTime(new Date());
            map.setCreateUser(BaseContextHandler.getAdminId());
            ApplicationHostInstall save = hostInstallService.save(map);
            result = Result.success(true, "数据保存成功");
        }

        return result;
    }

    /**
     * 查询编辑主机应用部署
     *
     * @param id
     * @return
     */
    @Override
    @ApiOperation(value = "查询编辑主机应用部署", notes = "查询编辑主机应用部署")
    @ApiResponses({
            @ApiResponse(code = 0, message = ""),
    })
    @RequestMapping(value = "/findforEdit", method = RequestMethod.POST)
    public Result<ApplicationHostInstallDTO> findforEdit(@RequestParam(value = "id") Long id) {
        Result<ApplicationHostInstallDTO> result = null;
        if (id != 0) {
            ApplicationHostInstall byId = hostInstallService.getDetailById(id);
            ApplicationHostInstallDTO map = dozerUtils.map(byId, ApplicationHostInstallDTO.class);
            result = Result.success(map, "数据查询成功");
        }
        return result;
    }

    @Override
    @ApiOperation(value = "更新主机应用部署", notes = "更新主机应用部署")
    @ApiResponses({
            @ApiResponse(code = 0, message = ""),
    })
    @RequestMapping(value = "/updateApplicationHostInstall", method = RequestMethod.POST)
    public Result<Boolean> updateApplicationHostInstall(@RequestBody ApplicationHostInstallDTO applicationHostInstallDTO) {
        Result<Boolean> result = null;
        if (applicationHostInstallDTO != null) {
            ApplicationHostInstall map = dozerUtils.map(applicationHostInstallDTO, ApplicationHostInstall.class);
            hostInstallService.updateById(map);
            result = Result.success(true,"更新主机应用部署成功");
        }
        return result;
    }

    /**
     * 删除部署主机应用
     *
     * @param id
     * @return
     */
    @Override
    @ApiOperation(value = "删除部署主机应用", notes = "删除部署主机应用")
    @ApiResponses({
            @ApiResponse(code = 0, message = ""),
    })
    @RequestMapping(value = "/deleteById", method = RequestMethod.POST)
    public Result<Boolean> deleteById(@RequestParam(value = "id") Long id) {
        Result<Boolean> result = null;
        if (id != 0) {
            hostInstallService.deleteById(id);
            result = Result.success(null, "删除成功");
        }
        return result;
    }

    /**
     * 查询主机应用部署详情
     *
     * @param id
     * @return
     */
    @Override
    @ApiOperation(value = "查询主机应用部署详情", notes = "查询主机应用部署详情")
    @ApiResponses({
            @ApiResponse(code = 0, message = ""),
    })
    @RequestMapping(value = "/getDetail", method = RequestMethod.POST)
    public Result<ApplicationHostInstallDTO> getDetail(@RequestParam(value = "id") Long id) {
        Result<ApplicationHostInstallDTO> result = null;
        if (id != 0) {
            ApplicationHostInstall detail = hostInstallService.getDetail(id);
            ApplicationHostInstallDTO map = dozerUtils.map(detail, ApplicationHostInstallDTO.class);
            result = Result.success(map, "数据查询成功");
        }
        return result;
    }

    /**
     * 异步获取主机名列表
     *
     * @return
     */
    @ApiOperation(value = "异步获取主机名列表", notes = "异步获取主机名列表")
    @ApiResponses({
            @ApiResponse(code = 0, message = ""),
    })
    @RequestMapping(value = "getHostName", method = RequestMethod.POST)
    public Result<List<ApplicationHostNameDTO>> getHostName() {
        Result<List<ApplicationHostNameDTO>> result = null;
        List<ApplicationHostInstall> list = hostInstallService.getHostName();
        List<ApplicationHostNameDTO> map = dozerUtils.mapList(list, ApplicationHostNameDTO.class);
        result = Result.success(map, "主机名列表获取成功");
        return result;
    }

    /**
     * 异步获取应用名称列表
     *
     * @return
     */
    @ApiOperation(value = "异步获取应用名称列表", notes = "异步获取应用名称列表")
    @ApiResponses({
            @ApiResponse(code = 0, message = ""),
    })
    @RequestMapping(value = "getApplicationName", method = RequestMethod.POST)
    public Result<List<ApplicationNameDTO>> getApplicationName() {
        Result<List<ApplicationNameDTO>> result = null;
        List<ApplicationHostInstall> applicationName = hostInstallService.getApplicationName();
        List<ApplicationNameDTO> applicationNameDTOS = dozerUtils.mapList(applicationName, ApplicationNameDTO.class);
        result = Result.success(applicationNameDTOS, "应用名称获取成功");
        return result;

    }
    /**
     * 主机应用项目部署更新
     */
    @ApiOperation(value = "主机应用项目部署更新", notes = "主机应用项目部署更新")
    @ApiResponses({
            @ApiResponse(code = 0, message = ""),
    })
    @RequestMapping(value = "updateHostInstall", method = RequestMethod.POST)
    public Result<Boolean > updateHostInstall(@RequestBody  HostInstallDetailsDTO hostInstallDetailsDTO){
        Long id = hostInstallDetailsDTO.getId();
        Result<Boolean> success=null;
        if(id!=0) {
            ApplicationHostInstall map = dozerUtils.map(hostInstallDetailsDTO, ApplicationHostInstall.class);
            map.setCreateTime(new Date());
            map.setCreateUser(BaseContextHandler.getAdminId());
            hostInstallService.updateByIdSelective(map);
           success = Result.success(true);
        }
        return success;

    }
}
