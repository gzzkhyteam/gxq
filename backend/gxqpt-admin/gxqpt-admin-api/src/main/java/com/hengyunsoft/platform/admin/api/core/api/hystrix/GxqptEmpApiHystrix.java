package com.hengyunsoft.platform.admin.api.core.api.hystrix;

import com.github.pagehelper.PageInfo;
import com.hengyunsoft.base.Result;
import com.hengyunsoft.page.plugins.openapi.OpenApiReq;
import com.hengyunsoft.platform.admin.api.authority.dto.UserDto;
import com.hengyunsoft.platform.admin.api.core.api.GxqptEmpApi;
import com.hengyunsoft.platform.admin.api.core.dto.emp.GxqptEmpBindUserDTO;
import com.hengyunsoft.platform.admin.api.core.dto.emp.GxqptEmpByDpmDTO;
import com.hengyunsoft.platform.admin.api.core.dto.emp.GxqptEmpByUserNameDTO;
import com.hengyunsoft.platform.admin.api.core.dto.emp.GxqptEmpDTO;
import com.hengyunsoft.platform.admin.api.core.dto.emp.GxqptEmpEmailLikeReqDTO;
import com.hengyunsoft.platform.admin.api.core.dto.emp.GxqptEmpEmailLikeResDTO;
import com.hengyunsoft.platform.admin.api.core.dto.emp.GxqptEmpRetDTO;
import com.hengyunsoft.platform.admin.api.core.dto.emp.GxqptEmpSettingIdentityDTO;
import com.hengyunsoft.platform.admin.api.core.dto.emp.GxqptEmpfindByOrgIdDTO;
import com.hengyunsoft.platform.admin.api.core.dto.emp.GxqptOrgAddEmpResDTO;
import com.hengyunsoft.platform.admin.api.core.dto.emp.GxqptUserByDpmDTO;
import com.hengyunsoft.platform.admin.api.core.dto.emp.SimpEmpDTO;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

/**
 * 描述:熔断实现默认响应超时
 *
 * @author chb
 * @date 2018/3/6 11:15
 * @return
 */
@Component
public class GxqptEmpApiHystrix implements GxqptEmpApi {
    /**
     * 新增人员
     *
     * @param GxqptEmpDTO
     * @return
     */
    @Override
    public Result<GxqptEmpDTO> save(GxqptEmpDTO GxqptEmpDTO) {
        return Result.timeout();
    }

    /**
     * 根据id获取人员信息
     *
     * @param id
     * @return
     */
    @Override
    public Result<GxqptEmpRetDTO> getById(String id, String systemCode,String identityId) {
        return Result.timeout();
    }

    @Override
    public Result<List<GxqptEmpRetDTO>> findByIdsGxqpt(String[] ids) {
        return Result.timeout();
    }

    @Override
    public Result<List<GxqptEmpRetDTO>> findByIdsGxqptYw(Long[] ids) {
        return Result.timeout();
    }

    @Override
    public Result<List<GxqptEmpRetDTO>> findByIdsGxqptUserName(List<Long> ids) {
        return Result.timeout();
    }

    /**
     * 根据ID修改人员信息
     *
     * @param gxqptEmpDTO
     * @return
     */
    @Override
    public Result<GxqptEmpDTO> updateById(GxqptEmpDTO gxqptEmpDTO) {
        return Result.timeout();
    }

    /**
     * 修改密码
     *
     * @param id
     * @param password
     * @return
     */
    @Override
    public Result<String> updatePasswordById(String id, String password) {
        return Result.timeout();
    }

    @Override
    public Result<List<GxqptEmpRetDTO>> findEmpListByName(String mainorgid, String name, String systemCode) {
        return null;
    }

    /**
     * 获取分页列表
     *
     * @param openApiReq
     * @return
     */
    @Override
    public Result<PageInfo<GxqptEmpRetDTO>> findEmpList(OpenApiReq<GxqptEmpDTO> openApiReq) {
        return Result.timeout();
    }

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
    @Override
    public Result<String> saveImportEmp(HttpServletRequest request, MultipartFile file, String orgId, String deptId, String systemCode) throws Exception {
        return Result.timeout();
    }

    /**
     * 根据ID删除数据
     *
     * @param id
     * @return
     */
    @Override
    public Result<String> removeById(String id) {
        return Result.timeout();
    }

    /**
     * 用户信息导入模板下载
     *
     * @param response
     * @return
     * @throws Exception
     */
    @Override
    public void downloadTemplet(HttpServletResponse response) throws Exception {
    }

    /**
     * 查找字典获取民族
     *
     * @param typeCode
     * @return
     */
    @Override
    public Result<Map<Long, Map<String, String>>> findDictionary(Long[] typeCode) {
        return Result.timeout();
    }

    /**
     * 用户绑定
     *
     * @param empBindUserDTO
     * @return
     */
    @Override
    public Result<String> saveEmpBindUser(GxqptEmpBindUserDTO empBindUserDTO) {
        return Result.timeout();
    }

    /**
     * 查看用户绑定情况
     *
     * @param userId
     * @return
     */
    @Override
    public Result<UserDto> getEmpBindUser(String userId) {
        return Result.timeout();
    }

    @Override
    public Result<List<GxqptEmpRetDTO>> findEmpListBySelect(GxqptEmpDTO gxqptEmpDTO) {
        return Result.timeout();
    }

    /**
     * 人员身份设置
     *
     * @param identityDTO
     * @return
     */
    @Override
    public Result<GxqptEmpSettingIdentityDTO> saveSettingIdentity(GxqptEmpSettingIdentityDTO identityDTO) {
        return Result.timeout();
    }

//    /**
//     * 用户信息导出
//     *
//     * @param response
//     * @param userId
//     * @param orgId
//     * @param deptId
//     * @throws Exception
//     */
//    @Override
//    public void downloadEmpList(HttpServletResponse response, String userId, String orgId, String deptId) throws Exception {
//    }

    @Override
    public Result<String> updateDisable(String[] ids) {
        return Result.timeout();
    }

    @Override
    public Result<String> updateEnnable(String[] ids) {
        return Result.timeout();
    }

    @Override
    public Result<GxqptEmpRetDTO> getByUserId(String id, String systemCode) {
        return Result.timeout();
    }

    @Override
    public Result<List<GxqptEmpByDpmDTO>> findEmpByDpm(String dpmId, String systemCode) {
        return Result.timeout();
    }

    @Override
    public Result<List<SimpEmpDTO>> getAllEmpUserGxqpt() {
        return Result.timeout();
    }

    @Override
    public Result<PageInfo<GxqptEmpRetDTO>> pageEmpListFroOperation(OpenApiReq<GxqptEmpDTO> openApiReq) {
        return Result.timeout();
    }

    @Override
    public Result<List<GxqptUserByDpmDTO>> findUserByDpm(String dpmId, String systemCode) {
        return Result.timeout();
    }

    @Override
    public Result<Map> getOperationEmpNum(String orgId) {
        return Result.timeout();
    }

    @Override
    public Result<PageInfo<GxqptEmpEmailLikeResDTO>> pageEmailEmpByDpm(OpenApiReq<GxqptEmpEmailLikeReqDTO> openApiReq) {
        return Result.timeout();
    }

    @Override
    public Result<List<GxqptEmpRetDTO>> findEmpByOrgId(GxqptEmpfindByOrgIdDTO dto) {
        return Result.timeout();
    }

    @Override
    public Result<PageInfo<GxqptEmpRetDTO>> findEmpByUserIds(GxqptEmpByUserNameDTO gxqptEmpByUserNameDTO) {
        return Result.timeout();
    }

    @Override
    public Result<List<UserDto>> findUserByOrgId(GxqptEmpfindByOrgIdDTO dto) {
        return Result.timeout();
    }

    @Override
    public Result<List<GxqptOrgAddEmpResDTO>> findOrgAddEmpByUser() {
        return Result.timeout();
    }

    @Override
    public Result<PageInfo<GxqptEmpRetDTO>> findEmpByUserIdsNoToken(GxqptEmpByUserNameDTO gxqptEmpByUserNameDTO) {
        return Result.timeout();
    }
}
