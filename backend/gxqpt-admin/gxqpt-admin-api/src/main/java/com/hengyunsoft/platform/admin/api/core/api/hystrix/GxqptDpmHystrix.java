package com.hengyunsoft.platform.admin.api.core.api.hystrix;

import com.github.pagehelper.PageInfo;
import com.hengyunsoft.base.Result;
import com.hengyunsoft.page.plugins.openapi.OpenApiReq;
import com.hengyunsoft.platform.admin.api.core.api.GxqptDpmApi;
import com.hengyunsoft.platform.admin.api.core.dto.dpm.*;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 部门管理
 *
 * @author wangzhen
 * @createTime 2018-03-07
 */

@Component
public class GxqptDpmHystrix implements GxqptDpmApi {
    @Override
    public Result<GxqptDpmResDTO> save(GxqptDpmSaveDTO dpmSave) {
        return Result.timeout();
    }

    @Override
    public Result<GxqptDpmEditRetDTO> update(GxqptDpmEditDTO dpmEdit) {
        return Result.timeout();
    }

    @Override
    public Result<List<GxqptDpmResDTO>> saveDpms(MultipartFile file, String orgId) {
        return Result.timeout();
    }

    @Override
    public Result<Boolean> remove(String[] ids) {
        return Result.timeout();
    }

    @Override
    public Result<Boolean> updateEnable(String[] ids, String isenble) {
        return Result.timeout();
    }

    @Override
    public Result<List<GxqptDpmResDTO>> find(String orgId, String systemCode) {
        return Result.timeout();
    }

    @Override
    public Result<PageInfo<GxqptDpmResDTO>> pageLike(OpenApiReq<GxqptDpmResPageDTO> openApiReq) {
        return Result.timeout();
    }

    @Override
    public Result<GxqptDpmResDTO> get(String systemCode, String id) {
        return Result.timeout();
    }

    @Override
    public Result<GxqptDpmDetailsDTO> getDetails(String systemCode, String id) {
        return Result.timeout();
    }

    @Override
    public void downloadTemplet(HttpServletResponse response) {
    }

    @Override
    public void exportOrg(String[] ids, HttpServletResponse response) {

    }

    @Override
    public Result<List<GxqptDpmByUserDTO>> findDpmByUser()  {
        return Result.timeout();
    }

    @Override
    public Result<List<GxqptDpmByUserDTO>> findDpmByOrgEnable(String orgId) {
        return Result.timeout();
    }

    @Override
    public Result<List<GxqptDpmByUserDTO>> findDpmByUserAndOrg(String orgId) {
        return Result.timeout();
    }

    @Override
    public Result<List<GxqptDpmByUserDTO>> findDpmByOrg(String systemCode, String orgId) {
        return Result.timeout();
    }

    @Override
    public Result<List<GxqptDpmResDTO>> findDpmNameByIds(List ids) {
        return Result.timeout();
    }
}
