package com.hengyunsoft.platform.developer.api.service.api;

import com.github.pagehelper.PageInfo;
import com.hengyunsoft.base.Result;
import com.hengyunsoft.page.plugins.openapi.OpenApiReq;
import com.hengyunsoft.platform.developer.api.service.api.hystrix.HostApiHystrix;
import com.hengyunsoft.platform.developer.api.service.dto.*;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @author luchanghong
 * @create 2018-04-02 16:13
 * @desc 主机管理Api业务层
 **/
@FeignClient(name = "${gxqpt.gate.feign.server:gxqpt-gate-server}",path = "/api/developer",fallback = HostApiHystrix.class)
public interface HostApi  {
    /**
     * 查询主机数据列表
     * @param openApiReq
     * @return
     */
    @RequestMapping(value = "/host/pageFindHostList",method = RequestMethod.POST)
    Result<PageInfo<HostDTO>> pageFindHostList(@RequestBody OpenApiReq<HostListDTO> openApiReq);

    /**
     * 保存主机数据
     * @param hostDTO
     * @return
     */
    @RequestMapping(value ="/host/saveHost" ,method =RequestMethod.POST )
    Result<Boolean> saveHost(@RequestParam(value = "hostDTO")HostDTO hostDTO);

    /**
     * 编辑主机数据
     * @param id
     * @return
     */
    @RequestMapping(value = "/host/getEditHost",method = RequestMethod.POST)
    Result<HostDTO> getEditHost(@RequestParam(value = "id") Long id);

    /**
     * 主机数据提交更改
     * @param hostDTO
     * @return
     */
    @RequestMapping(value = "/host/updateEditHostSubmit",method = RequestMethod.POST)
    Result<Boolean> updateEditHostSubmit(@RequestParam(value = "hostDTO")HostDTO hostDTO);
    /**
     * 删除主机数据
     * @param id
     * @return
     */
    @RequestMapping(value = "/host/deleteHost",method = RequestMethod.POST)
    Result<Boolean> deleteHost(@RequestParam(value = "id")Long id);
    /**
     * 主机详情
     * @param id
     * @return
     */
    @RequestMapping(value = "/host/getDetailHost",method = RequestMethod.POST)
    Result<HostDTO>  getDetailHost(@RequestParam(value = "id")Long id);

    /**
     * 更改主机状态
     * @param hostStatusDTO
     * @return
     */
    @RequestMapping(value = "/host/updateStatus",method = RequestMethod.POST)
    Result<Boolean> updateStatus(@RequestParam(value = "hostStatusDTO")HostStatusDTO hostStatusDTO);

    /**
     * 查询主机管理员列表
     * @param openApiReq
     * @return
     */
    @RequestMapping(value = "/host/pageHostAdminList",method = RequestMethod.POST)
    Result<PageInfo<HostAdminListDTO>> pageHostAdminList(@RequestBody OpenApiReq<HostAdminListDTO> openApiReq);

    /**
     * 关联主机
     * @param hostId
     * @return
     */
    @RequestMapping(value = "/host/saveRelate",method = RequestMethod.POST)
    Result<Boolean> saveRelate(@RequestParam(value = "hostId")Long hostId,@RequestParam(value = "userId")Long userId);

    /**
     * 取消关联主机
     * @param assignId
     * @return
     */
    @RequestMapping(value = "/host/deleteCancleRelate",method = RequestMethod.POST)
    Result<Boolean> deleteCancleRelate(@RequestParam(value ="assignId") Long assignId);

    /**
     * 获取主机创建人
     * @return
     */
   @RequestMapping(value = "/host/findHostCreateUser",method =RequestMethod.POST )
    Result<List<HostCreateUserDTO>> findHostCreateUser();

    /**
     * 获取主机名
     * @return
     */
   @RequestMapping(value = "/host/getHostNameList",method =RequestMethod.GET )
    Result<List<HostNameList>> getHostNameList();
}