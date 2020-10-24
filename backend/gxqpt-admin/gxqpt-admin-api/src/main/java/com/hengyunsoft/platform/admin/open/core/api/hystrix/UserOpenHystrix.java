package com.hengyunsoft.platform.admin.open.core.api.hystrix;

import com.github.pagehelper.PageInfo;
import com.hengyunsoft.base.Result;
import com.hengyunsoft.page.plugins.openapi.OpenApiReq;
import com.hengyunsoft.platform.admin.api.authority.dto.UserDto;
import com.hengyunsoft.platform.admin.api.authority.dto.user.UserResDTO;
import com.hengyunsoft.platform.admin.api.authority.dto.user.UserUpdatePswDTO;
import com.hengyunsoft.platform.admin.api.core.dto.org.GxqptOrgUserPageDTO;
import com.hengyunsoft.platform.admin.open.core.api.UserOpenApi;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Component
public class UserOpenHystrix implements UserOpenApi {
    @Override
    public Result<List<UserResDTO>> findUserByIds(Long[] ids) {
        return Result.timeout();
    }

    @Override
    public Result<Map<Long, UserResDTO>> findUserByIdList(ArrayList<Long> ids) {
        return Result.timeout();
    }

    @Override
    public Result<PageInfo<UserDto>> findUserByAppIdAndCode(OpenApiReq<GxqptOrgUserPageDTO> openApiReq) {
        return Result.timeout();
    }

    @Override
    public Result<Boolean> updatePsw(UserUpdatePswDTO userUpdatePswDTO) {
        return Result.timeout();
    }
}
