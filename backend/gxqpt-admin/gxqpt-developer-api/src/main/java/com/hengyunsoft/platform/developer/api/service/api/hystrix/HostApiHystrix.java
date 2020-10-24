package com.hengyunsoft.platform.developer.api.service.api.hystrix;

import com.github.pagehelper.PageInfo;
import com.hengyunsoft.base.Result;
import com.hengyunsoft.page.plugins.openapi.OpenApiReq;
import com.hengyunsoft.platform.developer.api.service.api.HostApi;
import com.hengyunsoft.platform.developer.api.service.dto.*;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @author luchanghong
 * @create 2018-04-02 16:16
 * @desc 主机管理熔断层
 **/
@Component
public class HostApiHystrix implements HostApi {

    @Override
    public Result<PageInfo<HostDTO>> pageFindHostList(@RequestBody OpenApiReq<HostListDTO> openApiReq) {
        return Result.timeout();
    }

    @Override
    public Result<Boolean> saveHost(@RequestParam(value = "hostDTO") HostDTO hostDTO) {
        return Result.timeout();
    }

    @Override
    public Result<HostDTO> getEditHost(@RequestParam(value = "id") Long id) {
        return Result.timeout();
    }

    @Override
    public Result<Boolean> updateEditHostSubmit(@RequestParam(value = "hostDTO") HostDTO hostDTO) {
        return Result.timeout();
    }

    @Override
    public Result<Boolean> deleteHost(@RequestParam(value = "id") Long id) {
        return Result.timeout();
    }

    @Override
    public Result<HostDTO> getDetailHost(@RequestParam(value = "id") Long id) {
        return Result.timeout();
    }

    @Override
    public Result<Boolean> updateStatus(@RequestParam(value = "hostStatusDTO") HostStatusDTO hostStatusDTO) {
        return Result.timeout();
    }

    @Override
    public Result<PageInfo<HostAdminListDTO>> pageHostAdminList(@RequestBody OpenApiReq<HostAdminListDTO> openApiReq) {
        return Result.timeout();
    }

    @Override
    public Result<Boolean> saveRelate(@RequestParam(value = "hostId") Long hostId, @RequestParam(value = "userId") Long userId) {
        return Result.timeout();
    }

    @Override
    public Result<Boolean> deleteCancleRelate(@RequestParam(value = "assignId") Long assignId) {
        return Result.timeout();
    }

    @Override
    public Result<List<HostCreateUserDTO>> findHostCreateUser() {
        return Result.timeout();
    }

    @Override
    public Result<List<HostNameList>> getHostNameList() {
        return Result.timeout();
    }
}