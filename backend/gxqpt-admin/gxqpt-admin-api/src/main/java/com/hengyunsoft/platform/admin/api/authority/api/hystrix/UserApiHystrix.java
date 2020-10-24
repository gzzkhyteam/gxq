package com.hengyunsoft.platform.admin.api.authority.api.hystrix;

import com.github.pagehelper.PageInfo;
import com.hengyunsoft.base.Result;
import com.hengyunsoft.page.plugins.openapi.OpenApiReq;
import com.hengyunsoft.platform.admin.api.authority.api.UserApi;
import com.hengyunsoft.platform.admin.api.authority.dto.UserDto;
import com.hengyunsoft.platform.admin.api.authority.dto.emp.GxqptEmpOrgResDTO;
import com.hengyunsoft.platform.admin.api.authority.dto.user.UserEditDTO;
import com.hengyunsoft.platform.admin.api.authority.dto.user.UserManagerReqDTO;
import com.hengyunsoft.platform.admin.api.authority.dto.user.UserResDTO;
import com.hengyunsoft.platform.admin.api.authority.dto.user.UserSaveDTO;
import com.hengyunsoft.platform.admin.api.authority.dto.user.UserSelectResDTO;
import com.hengyunsoft.platform.admin.api.core.dto.emp.GxqptEmpAndUserDTO;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 熔断器默认实现
 *
 * @author tyh
 * @createTime 2017-12-08 16:11
 */
@Component
public class UserApiHystrix implements UserApi {

    @Override
    public Result<UserDto> getById(Long id) {
        return Result.timeout();
    }

    @Override
    public Result<Boolean> isAdminManager() {
        return Result.timeout();
    }

    @Override
    public Result<PageInfo<UserResDTO>> page(OpenApiReq openApiReq) {
        return Result.timeout();
    }

    @Override
    public Result<Boolean> update(UserEditDTO userEdit) {
        return Result.timeout();
    }

    @Override
    public Result<Boolean> updateBan(Long[] ids, Boolean tag) {
        return Result.timeout();
    }

    @Override
    public Result<List<UserSelectResDTO>> findManagerByApp(String appId) { return Result.timeout(); }

    @Override
    public Result<PageInfo<UserManagerReqDTO>> pageManagerByOrg(OpenApiReq<String> openApiReq) {
        return Result.timeout();
    }

    @Override
    public Result<PageInfo<GxqptEmpAndUserDTO>> pageEmpAndUser(OpenApiReq openApiReq) {
        return Result.timeout();
    }

//    @Override
//    public Result<UserDto> getByAccount(String account) {
//        return Result.timeout();
//    }

    @Override
    public Result<Boolean> save(UserSaveDTO userSave) { return  Result.timeout(); }

    @Override
    public Result<GxqptEmpOrgResDTO> getMainOrg(Long userId) {
        return  Result.timeout();
    }

    @Override
    public Result<UserDto> get() {
        return  Result.timeout();
    }

    @Override
    public Result<List<Long>> findIdByAccount(List<String> accounts) {
        return  Result.timeout();
    }

    @Override
    public Result<List<UserSelectResDTO>> findAllList() {
        return  Result.timeout();
    }

    @Override
    public Result<List<UserResDTO>> findUserByCodeAndAppId(String code, String appId) {
        return  Result.timeout();
    }
}
