package com.hengyunsoft.platform.developer.api.core.api.hystrix;

import com.github.pagehelper.PageInfo;
import com.hengyunsoft.base.Result;
import com.hengyunsoft.page.plugins.openapi.OpenApiReq;
import com.hengyunsoft.platform.developer.api.core.api.ApplicationHostInstallApi;
import com.hengyunsoft.platform.developer.api.core.dto.install.*;
import com.hengyunsoft.platform.developer.api.service.dto.ApplicationHostInstallDTO;
import com.hengyunsoft.platform.developer.api.service.dto.ApplicationHostInstallListDTO;
import com.hengyunsoft.platform.developer.api.service.dto.ApplicationHostNameDTO;
import com.hengyunsoft.platform.developer.api.service.dto.ApplicationNameDTO;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @author luchanghong
 * @create 2018-04-27 12:38
 * @desc 主机应用部署熔断层
 **/
@Component
public class ApplicationHostInstallApiHystrix implements ApplicationHostInstallApi {
    @Override
    public Result<PageInfo<HostInstallLikeResDTO>> page(@RequestBody OpenApiReq<HostInstallLikeReqDTO> openApiReq) {
        return Result.timeout();
    }

    @Override
    public Result<HostInstallDetailsDTO> get(@RequestParam(value = "id") Long id) {
        return Result.timeout();
    }

    @Override
    public Result<Boolean> save(@RequestBody HostInstallSaveDTO hostInstallSave) {
        return Result.timeout();
    }

    @Override
    public Result<Boolean> update(@RequestBody HostInstallUpdateDTO hostInstallUpdate) {
        return Result.timeout();
    }

    @Override
    public Result<Boolean> delete(@RequestParam(value = "id") Long id) {
        return Result.timeout();
    }

    @Override
    public Result<PageInfo<ApplicationHostInstallListDTO>> pageFindList(@RequestBody OpenApiReq<ApplicationHostInstallListDTO> openApiReq) {
        return Result.timeout();
    }

    @Override
    public Result<Boolean> saveApplicationHostInstall(@RequestBody ApplicationHostInstallDTO applicationHostInstallDTO) {
        return Result.timeout();
    }

    @Override
    public Result<ApplicationHostInstallDTO> findforEdit(@RequestParam(value = "id") Long id) {
        return Result.timeout();
    }

    @Override
    public Result<Boolean> updateApplicationHostInstall(@RequestBody ApplicationHostInstallDTO applicationHostInstallDTO) {
        return Result.timeout();
    }

    @Override
    public Result<Boolean> deleteById(@RequestParam(value = "id") Long id) {
        return Result.timeout();
    }

    @Override
    public Result<ApplicationHostInstallDTO> getDetail(@RequestParam(value = "id") Long id) {
        return Result.timeout();
    }

    @Override
    public Result<List<ApplicationHostNameDTO>> getHostName() {
        return Result.timeout();
    }

    @Override
    public Result<List<ApplicationNameDTO>> getApplicationName() {
        return Result.timeout();
    }

    @Override
    public Result<Boolean> updateHostInstall(@RequestBody HostInstallDetailsDTO hostInstallDetailsDTO) {
        return Result.timeout();
    }
}