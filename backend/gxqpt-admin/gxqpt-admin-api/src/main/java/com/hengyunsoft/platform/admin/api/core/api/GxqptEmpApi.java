package com.hengyunsoft.platform.admin.api.core.api;

import com.github.pagehelper.PageInfo;
import com.hengyunsoft.base.Result;
import com.hengyunsoft.page.plugins.openapi.OpenApiReq;
import com.hengyunsoft.platform.admin.api.authority.dto.UserDto;
import com.hengyunsoft.platform.admin.api.core.api.hystrix.GxqptEmpApiHystrix;
import com.hengyunsoft.platform.admin.api.core.dto.emp.*;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

/**
 * 描述:高新区一体化平台人员管理
 *
 * @author chb
 * @date 2018/3/6 11:13
 * @return
 */
/*@FeignClient(name = "${gxqpt.gate.feign.server:gxqpt-gate-server}", path = "/api/admin", fallback = GxqptEmpApiHystrix.class)*/
@FeignClient(name = "${gxqpt.feign.admin-server:gxqpt-admin-server}", fallback = GxqptEmpApiHystrix.class)
public interface GxqptEmpApi {

    /**
     * 描述:新增人员
     *
     * @param gxqptEmpDTO
     * @return
     * @author chb
     * @date 2018/3/6 11:20
     */
    @RequestMapping(value = "/emp/save", method = RequestMethod.POST)
    Result<GxqptEmpDTO> save(@RequestBody GxqptEmpDTO gxqptEmpDTO);

    /**
     * 根据id获取人员信息
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/emp/getById", method = RequestMethod.GET)
    Result<GxqptEmpRetDTO> getById(@RequestParam(value = "id") String id, @RequestParam(value = "systemCode") String systemCode,
    @RequestParam(value = "identityId",required = false) String identityId);

    /**
     * 根据ids获取人员信息集合（gxqpt）
     *
     * @param ids
     * @return
     */
    @RequestMapping(value = "/emp/findByIdsGxqpt", method = RequestMethod.GET)
    Result<List<GxqptEmpRetDTO>> findByIdsGxqpt(@RequestParam(value = "ids[]") String ids[]);

    /**
     * 根据ids获取人员信息集合（gxqpt）
     *
     * @param ids
     * @return
     */
    @RequestMapping(value = "/emp/findByIdsGxqptYw", method = RequestMethod.GET)
    Result<List<GxqptEmpRetDTO>> findByIdsGxqptYw(@RequestParam(value = "ids[]") Long ids[]);
    /**
     * 根据ids获取人员信息集合（gxqpt）
     *  添加人:tianai
     * @param ids
     * @return
     */
    @RequestMapping(value = "/emp/findByIdsGxqptUserName", method = RequestMethod.GET)
    Result<List<GxqptEmpRetDTO>> findByIdsGxqptUserName(@RequestParam(value = "ids") List<Long> ids);

    /**
     * 根据id删除人员信息
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/emp/removeById", method = RequestMethod.GET)
    Result<String> removeById(@RequestParam(value = "id") String id);

    /**
     * 禁用人员
     *
     * @param ids
     * @return
     */
    @RequestMapping(value = "/emp/disable", method = RequestMethod.POST)
    Result<String> updateDisable(@RequestParam(value = "ids[]") String[] ids);

    /**
     * 启用人员
     *
     * @param ids
     * @return
     */
    @RequestMapping(value = "/emp/ennable", method = RequestMethod.POST)
    Result<String> updateEnnable(@RequestParam(value = "ids[]") String[] ids);

    /**
     * 描述：根据用户id查询用户
     * 参数：
     * 返回值：
     * 修改人：gbl
     * 修改时间：2018/6/28
     * 修改内容：
     */
    @RequestMapping(value = "getByUserId", method = RequestMethod.POST)
    Result<GxqptEmpRetDTO> getByUserId(@RequestParam(value = "id") String id, @RequestParam(value = "systemCode") String systemCode);

    /**
     * 根据id修改人员信息
     *
     * @param gxqptEmpDTO
     * @return
     */
    @RequestMapping(value = "/emp/updateById", method = RequestMethod.POST)
    Result<GxqptEmpDTO> updateById(@RequestBody GxqptEmpDTO gxqptEmpDTO);

    /**
     * 根据ID修改密码
     *
     * @param password
     * @param id
     * @return
     */
    @RequestMapping(value = "/emp/updatePasswordById", method = RequestMethod.POST)
    Result<String> updatePasswordById(@RequestParam(value = "id") String id, @RequestParam(value = "password") String password);

    /**
     * 描述：根据姓名模糊查询用户
     * 参数：
     * 返回值：
     * 修改人：gbl
     * 修改时间：2018/6/25
     * 修改内容：
     */
    @RequestMapping(value = "findEmpListByName", method = RequestMethod.POST)
    Result<List<GxqptEmpRetDTO>> findEmpListByName(@RequestParam("mainorgid") String mainorgid, @RequestParam("name") String name, @RequestParam("systemCode") String systemCode);

    /**
     * 获取分页列表
     *
     * @param openApiReq
     * @return
     */
    @RequestMapping(value = "/emp/findEmpList", method = RequestMethod.POST)
    Result<PageInfo<GxqptEmpRetDTO>> findEmpList(@RequestBody OpenApiReq<GxqptEmpDTO> openApiReq);

    /**
     * 用户信息导入
     *
     * @param request
     * @param file
     * @param orgId
     * @param deptId
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/emp/saveImportEmp", method = RequestMethod.POST)
    Result<String> saveImportEmp(HttpServletRequest request, @RequestParam(value = "file") MultipartFile file,
                                 @RequestParam(value = "orgId") String orgId, @RequestParam(value = "deptId") String deptId,
                                 @RequestParam(value = "systemCode") String systemCode) throws Exception;

    /**
     * 用户信息导入模板下载
     *
     * @param response
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/emp/downloadTemplet", method = RequestMethod.GET)
    void downloadTemplet(HttpServletResponse response) throws Exception;


//    /**
//     * 用户信息导出
//     *
//     * @param response
//     * @param userId
//     * @param orgId
//     * @param deptId
//     * @throws Exception
//     */
//    @RequestMapping(value = "/emp/downloadEmpList", method = RequestMethod.GET)
//    void downloadEmpList(HttpServletResponse response, @RequestParam(value = "userId") String userId,
//                         @RequestParam(value = "orgId") String orgId, @RequestParam(value = "deptId") String deptId) throws Exception;

    /**
     * 查找字典获取民族
     *
     * @param typeCode
     * @return
     */
    @RequestMapping(value = "/emp/findDictionary", method = RequestMethod.GET)
    Result<Map<Long, Map<String, String>>> findDictionary(@RequestParam(value = "typeCode[]") Long[] typeCode);

    /**
     * 用户绑定
     *
     * @param empBindUserDTO
     * @return
     */
    @RequestMapping(value = "/emp/saveEmpBindUser", method = RequestMethod.POST)
    Result<String> saveEmpBindUser(@RequestBody GxqptEmpBindUserDTO empBindUserDTO);


    /**
     * 查看绑定详情
     *
     * @param userId
     * @return
     */
    @RequestMapping(value = "/emp/getEmpBindUser", method = RequestMethod.POST)
    Result<UserDto> getEmpBindUser(@RequestParam(value = "userId") String userId);

    /**
     * 查找人员下拉框
     *
     * @param gxqptEmpDTO
     * @return
     */
    @RequestMapping(value = "/emp/findEmpListBySelect", method = RequestMethod.POST)
    Result<List<GxqptEmpRetDTO>> findEmpListBySelect(@RequestBody GxqptEmpDTO gxqptEmpDTO);

    /**
     * 人员身份设置
     *
     * @param identityDTO
     * @return
     */
    @RequestMapping(value = "/emp/settingIdentity", method = RequestMethod.POST)
    Result<GxqptEmpSettingIdentityDTO> saveSettingIdentity(@RequestBody GxqptEmpSettingIdentityDTO identityDTO);

    /**
     * 根据部门查询身份人员
     *
     * @param dpmId
     * @return
     */
    @RequestMapping(value = "/emp/findEmpByDpm", method = RequestMethod.GET)
    Result<List<GxqptEmpByDpmDTO>> findEmpByDpm(@RequestParam(value = "dpmId") String dpmId
            , @RequestParam(value = "systemCode") String systemCode);

    /***
     * 查询gxqpt的所有人员
     * @return
     */
    @RequestMapping(value = "/emp/getAllEmpUserGxqpt", method = RequestMethod.GET)
    Result<List<SimpEmpDTO>> getAllEmpUserGxqpt();

    /**
     * 根据部门查询运维人员
     *
     * @param openApiReq
     * @return
     */
    @RequestMapping(value = "/emp/pageEmpListFroOperation", method = RequestMethod.POST)
    Result<PageInfo<GxqptEmpRetDTO>> pageEmpListFroOperation(@RequestBody OpenApiReq<GxqptEmpDTO> openApiReq);

    /**
     * 根据部门查询身份用户
     *
     * @param dpmId
     * @return
     */
    @RequestMapping(value = "/emp/findUserByDpm", method = RequestMethod.GET)
    Result<List<GxqptUserByDpmDTO>> findUserByDpm(@RequestParam(value = "dpmId") String dpmId
            , @RequestParam(value = "systemCode") String systemCode);

    /**
     * 查询运维单位一共多少人
     *
     * @return
     */
    @RequestMapping(value = "/emp/getOperationEmpNum", method = RequestMethod.GET)
    Result<Map> getOperationEmpNum(@RequestParam(value = "orgId") String orgId);

    /**
     * 邮件系统专用人员模糊查询
     *
     * @return
     */
    @RequestMapping(value = "/emp/pageEmailEmpByDpm", method = RequestMethod.POST)
    Result<PageInfo<GxqptEmpEmailLikeResDTO>> pageEmailEmpByDpm(@RequestBody OpenApiReq<GxqptEmpEmailLikeReqDTO> openApiReq);

    /**
     * 全体系根据单位id查询人员
     *
     * @return
     */
    @RequestMapping(value = "/emp/findEmpByOrgId", method = RequestMethod.POST)
    Result<List<GxqptEmpRetDTO>> findEmpByOrgId(@RequestBody GxqptEmpfindByOrgIdDTO dto);

    /**
     * 全体系根据用户id集合模糊查询人员
     *
     * @return
     */
    @RequestMapping(value = "/emp/findEmpByUserIds", method = RequestMethod.POST)
    Result<PageInfo<GxqptEmpRetDTO>> findEmpByUserIds(@RequestBody GxqptEmpByUserNameDTO gxqptEmpByUserNameDTO);

    /**
     * 全体系根据单位id查询用户
     *
     * @return
     */
    @RequestMapping(value = "/emp/findUserByOrgId", method = RequestMethod.POST)
    Result<List<UserDto>> findUserByOrgId(@RequestBody GxqptEmpfindByOrgIdDTO dto);

    /**
     * 根据登录user查询所有单位人员二层树
     *
     * @return
     */
    @RequestMapping(value = "/emp/findUserByOrgId", method = RequestMethod.GET)
    Result<List<GxqptOrgAddEmpResDTO>> findOrgAddEmpByUser();

    /**
     * 全体系根据用户id集合模糊查询人员 不需要 token
     *
     * @return
     */
    @RequestMapping(value = "/emp/findEmpByUserIdsNoToken", method = RequestMethod.POST)
    Result<PageInfo<GxqptEmpRetDTO>> findEmpByUserIdsNoToken(@RequestBody GxqptEmpByUserNameDTO gxqptEmpByUserNameDTO);
}
