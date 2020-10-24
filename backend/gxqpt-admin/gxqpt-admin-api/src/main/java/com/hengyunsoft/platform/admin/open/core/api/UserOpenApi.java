package com.hengyunsoft.platform.admin.open.core.api;

import com.github.pagehelper.PageInfo;
import com.hengyunsoft.base.Result;
import com.hengyunsoft.page.plugins.openapi.OpenApiReq;
import com.hengyunsoft.platform.admin.api.authority.dto.UserDto;
import com.hengyunsoft.platform.admin.api.authority.dto.user.UserResDTO;
import com.hengyunsoft.platform.admin.api.authority.dto.user.UserUpdatePswDTO;
import com.hengyunsoft.platform.admin.api.core.dto.org.GxqptOrgUserPageDTO;
import com.hengyunsoft.platform.admin.open.core.api.hystrix.UserOpenHystrix;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.*;

/**
 * 账号管理-open
 *
 * @author wangzhen
 * @createTime 2018-03-26
 */
@FeignClient(name = "${gxqpt.gate.feign.server:gxqpt-gate-server}",
        path = "/api/admin", fallback = UserOpenHystrix.class)
public interface UserOpenApi {
    /**
     * 根据ids查询账号列表
     *
     *  ids
     *
     */
    @RequestMapping(value = "/p/user/findUserByIds", method = RequestMethod.GET)
    Result<List<UserResDTO>> findUserByIds(@RequestParam(value = "ids[]") Long[] ids);

    /***
     *根据ids查询账号列表
     * @param ids  用户id列表
     * @return  key:用户id  value:UserRes  的map
     */
    @RequestMapping(value = "/p/user/findUserByIdList", method = RequestMethod.POST)
    Result<Map<Long,UserResDTO>> findUserByIdList(@RequestBody  ArrayList<Long> ids);
    /**
     * 描述：通過应用Id和角色编码获取绑定的用户账号列表
     * 参数：openApiReq
     * 返回值：List<UserDto>  用户集合
     * 修改人：zhangbiao
     * 修改时间：2018/3/26
     * 修改内容：新增基础接口
     */
    @RequestMapping(value = "/p/user/finduser" , method = RequestMethod.POST)
    Result<PageInfo<UserDto>> findUserByAppIdAndCode(@RequestBody OpenApiReq<GxqptOrgUserPageDTO> openApiReq);


    @RequestMapping(value = "/p/user/updatePsw" , method = RequestMethod.POST)
    Result<Boolean> updatePsw(@RequestBody UserUpdatePswDTO userUpdatePswDTO);
}
