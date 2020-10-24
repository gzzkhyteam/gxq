package com.hengyunsoft.platform.admin.api.core.api;

import com.github.pagehelper.PageInfo;
import com.hengyunsoft.base.Result;
import com.hengyunsoft.page.plugins.openapi.OpenApiReq;
import com.hengyunsoft.platform.admin.api.core.api.hystrix.GxqptOrgHystrix;
import com.hengyunsoft.platform.admin.api.core.dto.org.GxqptOrgByExchangeReqDTO;
import com.hengyunsoft.platform.admin.api.core.dto.org.GxqptOrgByUserDTO;
import com.hengyunsoft.platform.admin.api.core.dto.org.GxqptOrgDetailsDTO;
import com.hengyunsoft.platform.admin.api.core.dto.org.GxqptOrgDpmIdentiDTO;
import com.hengyunsoft.platform.admin.api.core.dto.org.GxqptOrgEditDTO;
import com.hengyunsoft.platform.admin.api.core.dto.org.GxqptOrgEditRetDTO;
import com.hengyunsoft.platform.admin.api.core.dto.org.GxqptOrgResDTO;
import com.hengyunsoft.platform.admin.api.core.dto.org.GxqptOrgResPageDTO;
import com.hengyunsoft.platform.admin.api.core.dto.org.GxqptOrgSaveAndShareDTO;
import com.hengyunsoft.platform.admin.api.core.dto.org.GxqptOrgStatisticsNumDTO;
import com.hengyunsoft.platform.admin.api.core.dto.system.GxqptSystemTreeDTO;
import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 单位管理
 *
 * @author wangzhen
 * @createTime 2018-03-06
 */

@FeignClient(name = "${gxqpt.feign.admin-server:gxqpt-admin-server}" , fallback = GxqptOrgHystrix.class)
public interface GxqptOrgApi {
    /**
     * 新增单位
     *
     * @param gxqptOrgSaveAndShare
     * @return
     */
    @RequestMapping(value = "/gxqpt/org/save", method = RequestMethod.POST)
    Result<GxqptOrgResDTO> save(@RequestBody GxqptOrgSaveAndShareDTO gxqptOrgSaveAndShare);

    /**
     * 编辑单位
     *
     * @param gxqptOrgEdit
     * @return
     */
    @RequestMapping(value = "/gxqpt/org/update", method = RequestMethod.POST)
    Result<GxqptOrgEditRetDTO> update(@RequestBody GxqptOrgEditDTO gxqptOrgEdit);

    /**
     * 编辑单位分享应用
     *
     * @param gxqptOrgEdit
     * @return
     */
    @RequestMapping(value = "/gxqpt/org/updateShare", method = RequestMethod.POST)
    Result<Boolean> updateShare(@RequestBody GxqptOrgEditDTO gxqptOrgEdit);

    /**
     * 删除单位
     *
     * @param ids
     * @return
     */
    @RequestMapping(value = "/gxqpt/org/remove", method = RequestMethod.POST)
    Result<Boolean> remove(@RequestParam(value = "ids[]") String[] ids);

    /**
     * 禁用单位
     *
     * @param ids
     * @return
     */
    @RequestMapping(value = "/gxqpt/org/updateEnable", method = RequestMethod.POST)
    Result<Boolean> updateEnable(@RequestParam(value = "ids[]") String[] ids, @RequestParam(value = "isenble") String isenble);

    /**
     * 导出单位
     *
     * @param ids
     * @param response
     */
    @RequestMapping(value = "/gxqpt/org/export", method = RequestMethod.GET)
    void exportOrg(@RequestParam(value = "ids[]") String[] ids, HttpServletResponse response);

    /**
     * 查询单位列表
     *
     * @param systemCode
     * @return
     */
    @RequestMapping(value = "/gxqpt/org/find", method = RequestMethod.GET)
    Result<List<GxqptOrgResDTO>> find(@RequestParam(value = "systemCode") String systemCode,
                                      @RequestParam(value = "type",required = false) Long type);

    /**
     * 查询单位根据Id
     *
     * @param systemCode
     * @param id
     * @return
     */
    @RequestMapping(value = "/gxqpt/org/getById", method = RequestMethod.GET)
    Result<GxqptOrgResDTO> getById(@RequestParam(value = "systemCode") String systemCode, @RequestParam(value = "id") String id);

    /**
     * 查询单位根据Id
     *
     * @param systemCode
     * @param id
     * @return
     */
    @RequestMapping(value = "/gxqpt/org/getDetails", method = RequestMethod.GET)
    Result<GxqptOrgDetailsDTO> getDetails(@RequestParam(value = "systemCode") String systemCode, @RequestParam(value = "id") String id);

    /**
     * 查询分享应用
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/gxqpt/org/getShares", method = RequestMethod.GET)
    Result<List<String>> getShares(@RequestParam(value = "id") String id);

//    /**
//     * 模糊单位查询
//     *
//     * @param name
//     * @param forClass
//     * @param forType
//     * @param parentId
//     * @param systemCode
//     * @param openApiReq
//     * @return
//     */
//    @RequestMapping(value = "/gxqpt/org/findLike", method = RequestMethod.GET)
//    Result<PageInfo<GxqptOrgResDTO>> findLike(@RequestParam(value = "name") String name, @RequestParam(value = "forClass") String forClass,
//                                                   @RequestParam(value = "forType") String forType, @RequestParam(value = "parentId") String parentId,
//                                                   @RequestParam(value = "systemCode") String systemCode, OpenApiReq openApiReq);


    /**
     * 根据id[]获得集合
     *
     * @param openApiReq
     * @return
     */
    @RequestMapping(value = "/gxqpt/org/pageByIds", method = RequestMethod.POST)
    Result<PageInfo<GxqptOrgResDTO>> pageByIds(@RequestBody OpenApiReq<GxqptOrgResPageDTO> openApiReq);

    /**
     * 根据user查询所有单位
     *
     * @return
     */
    @RequestMapping(value = "/gxqpt/org/findOrgByUser", method = RequestMethod.GET)
    Result<List<GxqptOrgByUserDTO>> findOrgByUser();

    /**
     * 单位导入模板下载
     *
     * @return
     */
    @RequestMapping(value = "/gxqpt/org/downLoadTemplet", method = RequestMethod.GET)
    void downLoadTemplet(HttpServletResponse response);

    /**
     * 单位导入
     *
     * @return
     */
    @RequestMapping(value = "/gxqpt/org/saveOrgs", method = RequestMethod.POST)
    Result<List<GxqptOrgResDTO>> saveOrgs(@RequestParam(value = "file") MultipartFile file, @RequestParam(value = "orgId") String orgId);

    /**
     * 单位管理员绑定
     *
     * @param orgId
     * @param userId
     * @return
     */
    @RequestMapping(value = "/gxqpt/org/saveManagerByOrg", method = RequestMethod.POST)
    Result<Boolean> saveManagerByOrg(@RequestParam(value = "orgId") String orgId
            , @RequestParam(value = "userId") Long userId);

    /**
     * 单位管理员删除绑定
     *
     * @param orgId
     * @param userId
     * @return
     */
    @RequestMapping(value = "/gxqpt/org/deleteManagerByOrg", method = RequestMethod.POST)
    Result<Boolean> deleteManagerByOrg(@RequestParam(value = "orgId") String orgId
            , @RequestParam(value = "userId") Long userId);

    /**
     * 所在单位部门集合
     *
     * @return
     */
    @RequestMapping(value = "/gxqpt/org/findOrgDpmIdenti", method = RequestMethod.GET)
    Result<List<GxqptOrgDpmIdentiDTO>> findOrgDpmIdenti();

    /**
     * 所在单位部门集合
     *
     * @return
     */
    @RequestMapping(value = "/gxqpt/org/findOrgAndDpmOperationTree", method = RequestMethod.GET)
    Result<List<GxqptOrgResDTO>> findOrgAndDpmOperationTree();

    @ApiOperation(value = "根据用户集合查询主单位部门人员树", notes = "根据用户集合查询主单位部门人员树")
    @RequestMapping(value = "/gxqpt/org/findOrgTreeByUsersInOperation", method = RequestMethod.GET)
    Result<List<GxqptOrgResDTO>> findOrgTreeByUsersInOperation(@RequestParam(value = "ids") List<Long> ids);

    @ApiOperation(value = "根据登录用户查询主单位部门树", notes = "根据登录用户查询主单位部门树")
    @RequestMapping(value = "/gxqpt/org/findOrgTreeByLoginInOperation", method = RequestMethod.GET)
    Result<List<GxqptOrgResDTO>> findOrgTreeByLoginInOperation();

    /**
     * 根据单位id和上下文用户体系编码查询单位详情
     *
     * @return
     */
    @RequestMapping(value = "/gxqpt/org/getDetailByOrgId", method = RequestMethod.GET)
    Result<GxqptOrgDetailsDTO> getDetailByOrgId(@RequestParam(value = "orgId") String orgId);


    /**
     * 根据单位id和上下文用户体系编码查询单位详情
     *
     * @return
     */
    @RequestMapping(value = "/gxqpt/org/getAllOrgAndDpm", method = RequestMethod.GET)
    Result<List<GxqptSystemTreeDTO>> getAllOrgAndDpm();


    /**
     * 获取权限系统统计首页数据概况
     *
     * @return
     */
    @RequestMapping(value = "/gxqpt/org/getOrgStatisticsNum", method = RequestMethod.GET)
    Result<GxqptOrgStatisticsNumDTO> getOrgStatisticsNum();

    /**
     * 根据是否平台管理员查询管理单位
     *
     * @return
     */
    @RequestMapping(value = "/gxqpt/org/findOrgByPower", method = RequestMethod.GET)
    Result<List<GxqptOrgByUserDTO>> findOrgByPower();

    /**
     * 根据ids获取单位集合
     * @param ids
     * @return
     */
    @RequestMapping(value = "/gxqpt/org/findOrgNameByIds", method = RequestMethod.GET)
    Result<List<GxqptOrgResDTO>> findOrgNameByIds(@RequestParam(value = "ids") List ids);

    /**
     * 查询我所管理的单位
     * @return
     */
    @RequestMapping(value = "/gxqpt/org/findOrgByOrgRole", method = RequestMethod.GET)
    Result<List<GxqptOrgResDTO>> findOrgByOrgRole();

    /**
     * 共享交换单位查询
     * @return
     */
    @RequestMapping(value = "/gxqpt/org/findOrgByExchange", method = RequestMethod.POST)
    Result<List<GxqptOrgResDTO>> findOrgByExchange(@RequestBody GxqptOrgByExchangeReqDTO dto);

}
