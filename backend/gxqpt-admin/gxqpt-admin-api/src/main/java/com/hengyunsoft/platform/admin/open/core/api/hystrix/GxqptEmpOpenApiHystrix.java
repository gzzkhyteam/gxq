package com.hengyunsoft.platform.admin.open.core.api.hystrix;

import com.github.pagehelper.PageInfo;
import com.hengyunsoft.base.Result;
import com.hengyunsoft.page.plugins.openapi.OpenApiReq;
import com.hengyunsoft.platform.admin.api.core.dto.emp.*;
import com.hengyunsoft.platform.admin.open.core.api.GxqptEmpOpenApi;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * 权限管理用户对外接口
 */
@Component
public class GxqptEmpOpenApiHystrix implements GxqptEmpOpenApi {

    /**
     * 根据用户id+体系编码查询用户
     * @param userId
     * @return
     */
    @Override
    public Result<GxqptEmpRetDTO> getEmpByUserId(String userId, String systemCode) {
        return Result.timeout();
    }

    /**
     * 根据用户id获取用户列表（user表的id查询所有体系用户+体系编码）
     * @param userId
     * @return
     */
    @Override
    public Result<List<GxqptEmpOpenRetDTO>> getEmpListByUserId(String userId) {
        return Result.timeout();
    }


    /**
     * 根据单位+体系编码获取用户
     * @param openApiReq
     * @return
     */
    @Override
    public Result<PageInfo<GxqptEmpRetDTO>> getEmpListByOrgId(@RequestBody OpenApiReq<GxqptEmpOpenQueryDTO> req) {
        return Result.timeout();
    }

    /**
     * 根据部门+体系编码获取用户
     * @return
     */
    @Override
    public Result<PageInfo<GxqptEmpRetDTO>> getEmpListByDeptId(@RequestBody OpenApiReq<GxqptEmpOpenQueryDTO> req) {
        return Result.timeout();
    }


    @Override
    public Result<List<GxqptOrgTreeDTO>> getTreeEmpPhoneByUserId(String userId, String unitId, Boolean filterPhone) {
        return Result.timeout();
    }

    @Override
    public Result<List<GxqptLogEmpInfoDTO>> getUsersByUserId(String userId, String deptId) {
        return Result.timeout();
    }
}
