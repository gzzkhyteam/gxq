package com.hengyunsoft.platform.developer.api.core.api;

import com.github.pagehelper.PageInfo;
import com.hengyunsoft.base.Result;
import com.hengyunsoft.page.plugins.openapi.OpenApiReq;
import com.hengyunsoft.platform.developer.api.core.api.hystrix.ApplicationHostInstallApiHystrix;
import com.hengyunsoft.platform.developer.api.core.dto.install.HostInstallDetailsDTO;
import com.hengyunsoft.platform.developer.api.core.dto.install.HostInstallLikeReqDTO;
import com.hengyunsoft.platform.developer.api.core.dto.install.HostInstallLikeResDTO;
import com.hengyunsoft.platform.developer.api.core.dto.install.HostInstallSaveDTO;
import com.hengyunsoft.platform.developer.api.core.dto.install.HostInstallUpdateDTO;
import com.hengyunsoft.platform.developer.api.service.dto.ApplicationHostInstallDTO;
import com.hengyunsoft.platform.developer.api.service.dto.ApplicationHostInstallListDTO;
import com.hengyunsoft.platform.developer.api.service.dto.ApplicationHostNameDTO;
import com.hengyunsoft.platform.developer.api.service.dto.ApplicationNameDTO;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * 应用服务部署管理
 *
 * @author wz
 * @createTime 2018-04-03
 */
@FeignClient(name = "${gxqpt.gate.feign.server:gxqpt-gate-server}",
        path = "/api/developer",fallback = ApplicationHostInstallApiHystrix.class)
public interface ApplicationHostInstallApi {
    /**
     * 分页查询部署
     *
     * @param openApiReq
     * @return
     * @auther:wz
     */
    @RequestMapping(value = "/hostInstall/page", method = RequestMethod.POST)
    Result<PageInfo<HostInstallLikeResDTO>> page(@RequestBody OpenApiReq<HostInstallLikeReqDTO> openApiReq);

    /**
     * 查看部署详情
     *
     * @param id
     * @return
     * @auther:wz
     */
    @RequestMapping(value = "/hostInstall/details", method = RequestMethod.GET)
    Result<HostInstallDetailsDTO> get(@RequestParam(value = "id") Long id);

    /**
     * 新增部署
     *
     * @param hostInstallSave
     * @return
     * @auther:wz
     */
    @RequestMapping(value = "/hostInstall/save", method = RequestMethod.POST)
    Result<Boolean> save(@RequestBody HostInstallSaveDTO hostInstallSave);

    /**
     * 修改部署
     *
     * @param hostInstallUpdate
     * @return
     * @auther:wz
     */
    @RequestMapping(value = "/hostInstall/update", method = RequestMethod.PUT)
    Result<Boolean> update(@RequestBody HostInstallUpdateDTO hostInstallUpdate);

    /**
     * 删除部署
     *
     * @param id
     * @return
     * @auther:wz
     */
    @RequestMapping(value = "/hostInstall/delete", method = RequestMethod.DELETE)
    Result<Boolean> delete(@RequestParam(value = "id") Long id);

    /**
     * 主机应用部署列表查询
     *
     * @param openApiReq
     * @return
     */
    @RequestMapping(value = "/hostInstall/pageFindList", method = RequestMethod.POST)
    Result<PageInfo<ApplicationHostInstallListDTO>> pageFindList(@RequestBody OpenApiReq<ApplicationHostInstallListDTO> openApiReq);

    /**
     * 保存主机应用部署数据
     *
     * @param applicationHostInstallDTO
     * @return
     */
    @RequestMapping(value = "/hostInstall/saveApplicationHostInstall", method = RequestMethod.POST)
    Result<Boolean> saveApplicationHostInstall(@RequestBody ApplicationHostInstallDTO applicationHostInstallDTO);

    /**
     * 主机应用部署编辑查询
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/hostInstall/findforEdit", method = RequestMethod.POST)
    Result<ApplicationHostInstallDTO> findforEdit(@RequestParam(value = "id") Long id);

    /**
     * 主机应用部署更新
     *
     * @param applicationHostInstallDTO
     * @return
     */
    @RequestMapping(value = "/hostInstall/updateApplicationHostInstall", method = RequestMethod.POST)
    Result<Boolean> updateApplicationHostInstall(@RequestBody ApplicationHostInstallDTO applicationHostInstallDTO);

    /**
     * 主机应用部署删除
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/hostInstall/deleteById", method = RequestMethod.POST)
    Result<Boolean> deleteById(@RequestParam(value = "id") Long id);

    /**
     * 主机应用部署详情
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/hostInstall/getDetail", method = RequestMethod.POST)
    Result<ApplicationHostInstallDTO> getDetail(@RequestParam(value = "id") Long id);

    /**
     * 异步获取主机名列表
     *
     * @return
     */
    @RequestMapping(value = "/hostInstall/getHostName", method = RequestMethod.POST)
    Result<List<ApplicationHostNameDTO>> getHostName();


    /**
     * 异步获取应用名称列表
     *
     * @return
     */
    @RequestMapping(value = "/hostInstall/getApplicationName", method = RequestMethod.POST)
    Result<List<ApplicationNameDTO>> getApplicationName();

    /**
     * 主机应用项目部署更新
     * @return
     */
    @RequestMapping(value = "updateHostInstall", method = RequestMethod.POST)
    Result<Boolean > updateHostInstall(@RequestBody  HostInstallDetailsDTO hostInstallDetailsDTO);


}
