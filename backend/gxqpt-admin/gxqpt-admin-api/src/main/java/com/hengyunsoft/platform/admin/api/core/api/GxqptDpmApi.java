package com.hengyunsoft.platform.admin.api.core.api;

import com.github.pagehelper.PageInfo;
import com.hengyunsoft.base.Result;
import com.hengyunsoft.page.plugins.openapi.OpenApiReq;
import com.hengyunsoft.platform.admin.api.core.dto.dpm.GxqptDpmByUserDTO;
import com.hengyunsoft.platform.admin.api.core.dto.dpm.GxqptDpmDetailsDTO;
import com.hengyunsoft.platform.admin.api.core.dto.dpm.GxqptDpmEditDTO;
import com.hengyunsoft.platform.admin.api.core.dto.dpm.GxqptDpmEditRetDTO;
import com.hengyunsoft.platform.admin.api.core.dto.dpm.GxqptDpmResDTO;
import com.hengyunsoft.platform.admin.api.core.dto.dpm.GxqptDpmResPageDTO;
import com.hengyunsoft.platform.admin.api.core.dto.dpm.GxqptDpmSaveDTO;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 部门管理
 *
 * @author wangzhen
 * @createTime 2018-03-07
 */

@FeignClient(name = "${gxqpt.feign.admin-server:gxqpt-admin-server}")
public interface GxqptDpmApi {
    /**
     * 新增部门
     *
     * @param dpmSave
     * @return
     */
    @RequestMapping(value = "/gxqpt/dpm/save", method = RequestMethod.POST)
    Result<GxqptDpmResDTO> save(@RequestBody GxqptDpmSaveDTO dpmSave);

    /**
     * 编辑部门
     *
     * @param dpmEdit
     * @return
     */
    @RequestMapping(value = "/gxqpt/dpm/update", method = RequestMethod.POST)
    Result<GxqptDpmEditRetDTO> update(@RequestBody GxqptDpmEditDTO dpmEdit);

    /**
     * 导入部门
     *
     * @param file
     * @param orgId
     * @return
     */
    @RequestMapping(value = "/gxqpt/dpm/saveDpms", method = RequestMethod.POST)
    Result<List<GxqptDpmResDTO>> saveDpms(@RequestParam(value = "file") MultipartFile file, @RequestParam(value = "orgId") String orgId);

    /**
     * 导出部门
     *
     * @param ids
     * @param response
     */
    @RequestMapping(value = "/gxqpt/dpm/export", method = RequestMethod.GET)
    void exportOrg(@RequestParam(value = "ids[]") String[] ids, HttpServletResponse response);

    /**
     * 删除部门
     *
     * @param ids
     * @return
     */
    @RequestMapping(value = "/gxqpt/dpm/remove", method = RequestMethod.POST)
    Result<Boolean> remove(@RequestParam(value = "ids[]") String[] ids);

    /**
     * 禁用单位
     *
     * @param ids
     * @return
     */
    @RequestMapping(value = "/gxqpt/dpm/updateEnable", method = RequestMethod.POST)
    Result<Boolean> updateEnable(@RequestParam(value = "ids[]") String[] ids, @RequestParam(value = "isenble") String isenble);

    /**
     * 查询部门列表
     *
     * @param orgId
     * @param systemCode
     * @return
     */
    @RequestMapping(value = "/gxqpt/dpm/find", method = RequestMethod.GET)
    Result<List<GxqptDpmResDTO>> find(@RequestParam(value = "orgId") String orgId, @RequestParam(value = "systemCode") String systemCode);

    /**
     * 模糊查询部门列表
     *
     * @param openApiReq
     * @return
     */
    @RequestMapping(value = "/gxqpt/dpm/pageLike", method = RequestMethod.POST)
    Result<PageInfo<GxqptDpmResDTO>> pageLike(@RequestBody OpenApiReq<GxqptDpmResPageDTO> openApiReq);

    /**
     * 查询部门根据id
     *
     * @param systemCode
     * @param id
     * @return
     */
    @RequestMapping(value = "/gxqpt/dpm/get", method = RequestMethod.GET)
    Result<GxqptDpmResDTO> get(@RequestParam(value = "systemCode") String systemCode, @RequestParam(value = "id") String id);

    /**
     * 查询部门根据id(详情)
     *
     * @param systemCode
     * @param id
     * @return
     */
    @RequestMapping(value = "/gxqpt/dpm/getDetails", method = RequestMethod.GET)
    Result<GxqptDpmDetailsDTO> getDetails(@RequestParam(value = "systemCode") String systemCode, @RequestParam(value = "id") String id);

    /**
     * 下载导入模板
     *
     * @param response
     * @return
     */
    @RequestMapping(value = "/gxqpt/dpm/downloadTemplet", method = RequestMethod.GET)
    void downloadTemplet(HttpServletResponse response);

    /**
     * 根据user查询所有部门
     *
     * @return
     */
    @RequestMapping(value = "/gxqpt/dpm/findDpmByUser", method = RequestMethod.GET)
    Result<List<GxqptDpmByUserDTO>> findDpmByUser();

    /**
     * 根据user和Org查询所有部门
     *
     * @return
     */
    @RequestMapping(value = "/gxqpt/dpm/findDpmByUserAndOrg", method = RequestMethod.GET)
    Result<List<GxqptDpmByUserDTO>> findDpmByUserAndOrg(@RequestParam(value = "orgId") String orgId);

    /**
     * 根据user查询所有单位
     *
     * @return
     */
    @RequestMapping(value = "/gxqpt/dpm/findDpmByOrgEnable", method = RequestMethod.GET)
    Result<List<GxqptDpmByUserDTO>> findDpmByOrgEnable(@RequestParam(value = "orgId") String orgId);

    /**
     * 根据user查询所有单位
     *
     * @return
     */
    @RequestMapping(value = "/gxqpt/dpm/findDpmByOrg", method = RequestMethod.GET)
    Result<List<GxqptDpmByUserDTO>> findDpmByOrg(@RequestParam(value = "systemCode") String systemCode, @RequestParam(value = "orgId") String orgId);

    /**
     * 根据部门ids查询部门名称id信息
     *
     * @param ids
     * @return
     */
    @RequestMapping(value = "/gxqpt/dpm/findDpmNameByIds", method = RequestMethod.GET)
    Result<List<GxqptDpmResDTO>> findDpmNameByIds(@RequestParam(value = "ids") List ids);


//    /**
//     * 根据id[]获得集合
//     *
//     * @param ids
//     * @param systemCode
//     * @param openApiReq
//     * @return
//     */
//    @RequestMapping(value = "/gxqpt/dpm/findByIds", method = RequestMethod.GET)
//    Result<PageInfo<GxqptDpmResDTO>> findByIds(@RequestParam(value = "ids[]") String[] ids, @RequestParam(value = "systemCode") String systemCode, OpenApiReq openApiReq);
}
