package com.hengyunsoft.platform.admin.api.authority.api;

import com.github.pagehelper.PageInfo;
import com.hengyunsoft.base.Result;
import com.hengyunsoft.page.plugins.openapi.OpenApiReq;
import com.hengyunsoft.platform.admin.api.authority.api.hystrix.UserApiHystrix;
import com.hengyunsoft.platform.admin.api.authority.dto.UserDto;
import com.hengyunsoft.platform.admin.api.authority.dto.emp.GxqptEmpOrgResDTO;
import com.hengyunsoft.platform.admin.api.authority.dto.user.UserEditDTO;
import com.hengyunsoft.platform.admin.api.authority.dto.user.UserManagerReqDTO;
import com.hengyunsoft.platform.admin.api.authority.dto.user.UserResDTO;
import com.hengyunsoft.platform.admin.api.authority.dto.user.UserSaveDTO;
import com.hengyunsoft.platform.admin.api.authority.dto.user.UserSelectResDTO;
import com.hengyunsoft.platform.admin.api.core.dto.emp.GxqptEmpAndUserDTO;
import com.hengyunsoft.platform.admin.api.core.dto.emp.GxqptEmpAndUserPageDTO;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * api 中的 RequestMapping 影响消费者
 * apiImpl 中的RequestMapping 影响生产者
 * 类上面不能加  //@RequestMapping("role")
 *
 * @author tyh
 * @createTime 2017-12-08 16:07
 */
//@FeignClient(name = "${gxqpt.feign.gate-server:gxqpt-gate-server}",
//        path = "/api/admin", fallback = UserApiHystrix.class)
@FeignClient(name = "${gxqpt.feign.admin-server:gxqpt-admin-server}", fallback = UserApiHystrix.class)
public interface UserApi {

    //该方法移动到auth-server
    @RequestMapping(value = "/user/getById", method = RequestMethod.GET)
    Result<UserDto> getById(@RequestParam(value = "id") Long id);
//该方法移动到auth-server
//    @RequestMapping(value = "/user/getByAccount")
//    Result<UserDto> getByAccount(@RequestParam(value = "account") String account);

    @RequestMapping(value = "/user/isadmin", method = RequestMethod.GET)
    Result<Boolean> isAdminManager();

    /**
     * 查询所有平台用户
     *
     * @param openApiReq
     * @return
     */
    @RequestMapping(value = "/user/page", method = RequestMethod.POST)
    Result<PageInfo<UserResDTO>> page(@RequestBody OpenApiReq<UserResDTO> openApiReq);

    /**
     * 修改用户
     *
     * @param userEdit
     * @return
     */
    @RequestMapping(value = "/user/update", method = RequestMethod.POST)
    Result<Boolean> update(@RequestBody UserEditDTO userEdit);

    /**
     * 禁用用户(暂未使用)
     *
     * @param ids
     * @param tag
     * @return
     */
    @RequestMapping(value = "/user/updateBan", method = RequestMethod.POST)
    Result<Boolean> updateBan(@RequestParam(value = "ids") Long[] ids, Boolean tag);

    /**
     * 查询人员关联
     *
     * @param openApiReq
     * @return
     */
    @RequestMapping(value = "/user/pageEmpAndUser", method = RequestMethod.POST)
    Result<PageInfo<GxqptEmpAndUserDTO>> pageEmpAndUser(@RequestBody OpenApiReq<GxqptEmpAndUserPageDTO> openApiReq);

    /**
     * 根据appId查询对应应用的管理员user
     *
     * @param appId
     * @return
     */
    @RequestMapping(value = "/user/findManagerByApp", method = RequestMethod.GET)
    Result<List<UserSelectResDTO>> findManagerByApp(@RequestParam(value = "appId") String appId);

    @RequestMapping(value = "/user/save", method = RequestMethod.POST)
    Result<Boolean> save(@RequestBody UserSaveDTO userSave);

    /**
     * 单位管理员绑定查询
     *
     * @param openApiReq
     * @return
     */
    @RequestMapping(value = "/user/pageManagerByOrg", method = RequestMethod.POST)
    Result<PageInfo<UserManagerReqDTO>> pageManagerByOrg(@RequestBody OpenApiReq<String> openApiReq);

    /**
     * 查询user主单位
     *
     * @param userId
     * @return
     */
    @RequestMapping(value = "/user/getMainOrg", method = RequestMethod.GET)
    Result<GxqptEmpOrgResDTO> getMainOrg(@RequestParam(value = "userId")Long userId ) ;

    /**
     * 根据BaseHander获取人员
     * @return
     */
    @RequestMapping(value = "/user/get", method = RequestMethod.GET)
    Result<UserDto> get();

    /**
     * 根据账号集合查询对应用户id集合
     * @return
     */
    @RequestMapping(value = "/user/findIdByAccount", method = RequestMethod.POST)
    Result<List<Long>> findIdByAccount(@RequestParam(value = "accounts") List<String> accounts);

    /**
     * 获取所有用户id和名称
     * @return
     */
    @RequestMapping(value = "/user/findAllList", method = RequestMethod.GET)
    Result<List<UserSelectResDTO>> findAllList();

    /**
     * @Author wz
     * @Description 根据角色code和appId获取角色的所有用户
     * @Date 11:31 2019/2/19
     * @Param [code, appId]
     * @return com.hengyunsoft.base.Result<java.util.List<com.hengyunsoft.platform.admin.api.authority.dto.user.UserResDTO>>
     **/
    @RequestMapping(value = "/user/findUserByCodeAndAppId", method = RequestMethod.GET)
    Result<List<UserResDTO>> findUserByCodeAndAppId(@RequestParam(value = "code") String code,
                                                    @RequestParam(value = "appId") String appId);
}
