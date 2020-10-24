package com.hengyunsoft.platform.admin.api.core.api.hystrix;

import com.github.pagehelper.PageInfo;
import com.hengyunsoft.base.Result;
import com.hengyunsoft.page.plugins.openapi.OpenApiReq;
import com.hengyunsoft.platform.admin.api.core.api.GxqptDutiesApi;
import com.hengyunsoft.platform.admin.api.core.dto.duties.GxqptDutiesDTO;
import com.hengyunsoft.platform.admin.api.core.dto.duties.SimpDutiesDTO;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * 描述:职务管理熔断
 * @author chb
 * @date 2018/3/7 13:46
 * @return
 */
@Component
public class GxqptDutiesHystrix implements GxqptDutiesApi {

    /**
     * 新增职务
     * @param gxqptEmpDTO
     * @return
     */
    @Override
    public Result<GxqptDutiesDTO> save(GxqptDutiesDTO gxqptDutiesDTO) {
        return Result.timeout();
    }

    /**
     * 根据ID修改数据
     * @param gxqptDutiesDTO
     * @return
     */
    @Override
    public Result<GxqptDutiesDTO> updateById(GxqptDutiesDTO gxqptDutiesDTO) {
        return Result.timeout();
    }

    /**
     * 根据ID获取数据
     * @param id
     * @return
     */
    @Override
    public Result<GxqptDutiesDTO> getDutiesById(String id,String systemCode) {
        return Result.timeout();
    }

    /**
     * 获取分页数据
     * @param openApiReq
     * @param gxqptEmpDTO
     * @return
     */
    @Override
    public Result<PageInfo<GxqptDutiesDTO>>  findDutiesList(OpenApiReq<GxqptDutiesDTO> openApiReq) {
        return Result.timeout();
    }

    @Override
    public Result<List<SimpDutiesDTO>> findSimpDutiesGxqpt(String orgid) {
        return Result.timeout();
    }

    /**
     * 根据ID删除数据
     * @param id
     * @return
     */
    @Override
    public Result<String> removeById(String id) {
        return Result.timeout();
    }
}
