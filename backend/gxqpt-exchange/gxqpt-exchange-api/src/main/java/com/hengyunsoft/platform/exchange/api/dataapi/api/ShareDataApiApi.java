//package com.hengyunsoft.platform.exchange.api.dataapi.api;
//
//import com.github.pagehelper.PageInfo;
//import com.hengyunsoft.base.Result;
//import com.hengyunsoft.page.plugins.openapi.OpenApiReq;
//import com.hengyunsoft.platform.exchange.api.dataapi.api.hystrix.ShareDataApiApiHystrix;
//import com.hengyunsoft.platform.exchange.api.dataapi.dto.dataapi.*;
//import com.hengyunsoft.platform.exchange.api.directory.dto.directory.VOrgDTO;
//import org.springframework.cloud.netflix.feign.FeignClient;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
///**
// * com.hengyunsoft.platform.exchange.api.dataapi.api
// * 版权：中科恒运软件科技股份有限公司贵阳分公司
// * 描述：角色管理Api
// * 修改人：zhaopengfei
// * 修改时间：2018/4/21
// * 修改内容：新增基础接口
// */
//@FeignClient(name = "${gxqpt.gate.feign.server:gxqpt-gate-server}",
//        path = "api/exchange", fallback = ShareDataApiApiHystrix.class)
//public interface ShareDataApiApi {
//
//    /**
//     * 描述：用于保存Api创建第一步：选择目录
//     * 参数：dirId 目录id
//     * 参数：Integer type (1:单位自己创建，2：共享申请创建)
//     * 返回值： ApiDirSaveReturnDTO
//     * 修改人：zhaopengfei
//     * 修改时间：2018/4/21
//     * 修改内容：
//     */
//    @RequestMapping(value = "/api/savedirectorychosen", method = RequestMethod.POST)
//    Result<ApiDirSaveReturnDTO> saveApiDirectoryChosen(@RequestParam(value = "dirId") Long dirId, @RequestParam("type") Integer type, Long apiId,Long busId);
//
//
//    /**
//     * 描述：用于保存Api创建第二步：保存查询字段
//     * 参数：ApiElementDTO API元数据
//     * 返回值：Boolean 状态（成功、失败）
//     * 修改人：zhaopengfei
//     * 修改时间：2018/4/21
//     * 修改内容：
//     */
//    @RequestMapping(value = "/api/saveapielementchosen", method = RequestMethod.POST)
//    Result<Boolean> saveApiElementChosen(@RequestBody ApiElementDTO dto);
//
//    /**
//     * 描述：用于保存Api创建第三步：保存过滤条件
//     * 参数：ApiElementDTO API元数据
//     * 返回值：Boolean 状态（成功、失败）
//     * 修改人：zhaopengfei
//     * 修改时间：2018/4/21
//     * 修改内容：
//     */
//    @RequestMapping(value = "/api/saveapifilterchosen", method = RequestMethod.POST)
//    Result<Boolean> saveApiFilterChosen(@RequestBody ApiFilterDTO dto);
//
//    /**
//     * 描述：用于保存Api创建第四步：保存api基本信息
//     * 参数：ApiElementDTO API元数据
//     * 返回值：Boolean 状态（成功、失败）
//     * 修改人：zhaopengfei
//     * 修改时间：2018/4/21
//     * 修改内容：
//     */
//    @RequestMapping(value = "/api/saveapiinfo", method = RequestMethod.POST)
//    Result<Boolean> saveApiInfo(@RequestBody ApiBaseInfoDTO dto);
//
//    /**
//     * 描述：查询api分页数据
//     * 参数：openApiReq 分页信息；appId：应用Id
//     * 返回值：PageInfo<RoleDto>
//     * 修改人：zhaopengfei
//     * 修改时间：2018/4/21
//     * 修改内容：
//     */
//    @RequestMapping(value = "/api/find", method = RequestMethod.POST)
//    Result<PageInfo<ApiReturnDataDTO>> page(@RequestBody OpenApiReq<ApiQueryConditionDTO> openApiReq);
//
//    /**
//     * 描述：根据apiId查询api详细信息
//     * 参数：id：APP id
//     * 返回值：ResourceUpdatDto
//     * 修改人：zhaopengfei
//     * 修改时间：2018/4/21
//     * 修改内容：
//     */
//    @RequestMapping(value = "/api/detail", method = RequestMethod.POST)
//    Result<ApiDetailDTO> getById(@RequestParam("id") Long id);
//
//    /**
//     * 描述：api启用、禁用操作
//     * 参数：id：api Id
//     * 参数：status：1,启用；2，禁用'
//     * 返回值：Boolean
//     * 修改人：zhaopengfei
//     * 修改时间：2018/4/21
//     * 修改内容：
//     */
//    @RequestMapping(value = "/api/setstatus", method = RequestMethod.POST)
//    Result<Boolean> updatestatus(@RequestParam(value = "id") Long id, @RequestParam(value = "status") Integer status);
//
//    /**
//     * 描述：通过目录Id查找api分页列表
//     * 参数：openApiReq 分页信息；appId：应用Id
//     * 返回值：PageInfo<RoleDto>
//     * 修改人：zhaopengfei
//     * 修改时间：2018/4/21
//     * 修改内容：
//     */
//    @RequestMapping(value = "/api/findApiByDirId", method = RequestMethod.POST)
//    Result<PageInfo<ApiReturnDataDTO>> findApiByDirId(@RequestBody OpenApiReq<Long> openApiReq);
//
//    /**
//     * 描述：api新增授权单位
//     * 参数：dto
//     * 返回值：Boolean
//     * 修改人：zhaopengfei
//     * 修改时间：2018/4/30
//     * 修改内容：
//     */
//    @RequestMapping(value = "/api/saveauthunit", method = RequestMethod.POST)
//    Result<Boolean> saveAuthUnit(@RequestBody ApiAuthUnitSaveDTO dto);
//
//    /**
//     * 描述：通过ApiId查找所共享单位
//     * 参数：openApiReq 分页信息；ApiAuthUnitConditionDTO
//     * 返回值：PageInfo<ApiAuthUnitListDTO>
//     * 修改人：zhaopengfei
//     * 修改时间：2018/4/30
//     * 修改内容：
//     */
//    @RequestMapping(value = "/api/findauthunit", method = RequestMethod.POST)
//    Result<PageInfo<ApiAuthUnitListDTO>> findAuthUnit(@RequestBody OpenApiReq<ApiAuthUnitConditionDTO> openApiReq);
//
//    /**
//     * 描述：查询api未共享的单位
//     * 参数：apiId apiId
//     * 返回值：PageInfo<ApiAuthUnitListDTO>
//     * 修改人：zhaopengfei
//     * 修改时间：2018/4/30
//     * 修改内容：
//     */
//    @RequestMapping(value = "/api/findnoauthunit", method = RequestMethod.GET)
//    Result<List<VOrgDTO>> findNoAuthUnit(@RequestParam("apiId") Long apiId);
//
//
//    /**
//     * 描述：查询api正常使用情况
//     * 参数：ApiUseQueryDTO
//     * 返回值：PageInfo<ApiUseListDTO>
//     * 修改人：zhaopengfei
//     * 修改时间：2018/5/1
//     * 修改内容：
//     */
//    @RequestMapping(value = "/api/findapiuse", method = RequestMethod.POST)
//    Result<PageInfo<ApiUseListDTO>> findApiUse(@RequestBody OpenApiReq<ApiUseQueryDTO> dto);
//
//    /**
//     * 描述：查询api异常使用情况
//     * 参数：ApiUseExceptionQueryDTO
//     * 返回值：PageInfo<ApiUseExceptionListDTO>
//     * 修改人：zhaopengfei
//     * 修改时间：2018/5/1
//     * 修改内容：
//     */
//    @RequestMapping(value = "/api/findapiuseexception", method = RequestMethod.POST)
//    Result<PageInfo<ApiUseExceptionListDTO>> findApiUseException(@RequestBody OpenApiReq<ApiUseExceptionQueryDTO> openApiReq);
//
//    /**
//     * 描述：查询Api调用总次数
//     * 参数：id apiId
//     * 返回值：调用数
//     * 修改人：zhaopengfei
//     * 修改时间：2018/5/2
//     * 修改内容：
//     */
//    @RequestMapping(value = "/api/findapiusetotalnum", method = RequestMethod.POST)
//    Result<Integer> findApiUseTotalNum(@RequestParam Long id);
//
//    /**
//     * 描述：api异常忽略处理
//     * 参数：id 异常调用Id
//     * 返回值：Boolean 操作状态
//     * 修改人：zhaopengfei
//     * 修改时间：2018/4/22
//     * 修改内容：
//     */
//    @RequestMapping(value = "/api/updateexchdle", method = RequestMethod.POST)
//    public Result<Boolean> updateExcHdle(@RequestParam(value = "id") Long id);
//
//
//    /**
//     * 描述：保存异常处理信息
//     * 参数：dto
//     * 返回值：调用数
//     * 修改人：zhaopengfei
//     * 修改时间：2018/5/2
//     * 修改内容：
//     */
//    @RequestMapping(value = "/api/saveexchdle", method = RequestMethod.POST)
//    public Result<Boolean> saveExcHdle(@RequestBody ApiCallExceptionHdleDTO dto);
//
//    /**
//     * 描述：获取异常信息
//     * 参数：id
//     * 返回值：调用数
//     * 修改人：zhaopengfei
//     * 修改时间：2018/5/2
//     * 修改内容：
//     */
//    @RequestMapping(value = "/api/getexcinfo", method = RequestMethod.POST)
//    public Result<ApiUseExceptionDetailDTO> getExcInfo(@RequestParam Long id);
//
//    /**
//     * 描述：根据非结构化目录Id获取该目录的全量API
//     * 参数：dirId
//     * 返回值：ApiBaseInfoDTO
//     * 修改人：zhaopengfei
//     * 修改时间：2018/5/2
//     * 修改内容：
//     */
//    @RequestMapping(value = "/api/getapiinfobyunstrid", method = RequestMethod.POST)
//    public Result<ApiBaseInfoDTO> getApiInfoByUnstrId(@RequestParam Long dirId);
//
//    /**
//     * 描述：返回Api基础信息
//     * 参数：apiId
//     * 返回值：ApiBaseInfoDTO
//     * 修改人：zhaopengfei
//     * 修改时间：2018/6/8
//     * 修改内容：
//     */
//    @RequestMapping(value = "/api/getBaseApiInfo", method = RequestMethod.POST)
//    public Result<ApiBaseInfoDTO> getBaseApiInfo(@RequestParam Long apiId);
//
//    /**
//     * 描述：根据ApiId查询返回字段
//     * 参数：apiId
//     * 返回值：List<ShareDataApiElement>
//     * 修改人：zhaopengfei
//     * 修改时间：2018/6/8
//     * 修改内容：
//     */
//    @RequestMapping(value = "/api/getElementByApiId", method = RequestMethod.POST)
//    public Result<List<ApiElementBaseDTO>> getElementByApiId(@RequestParam Long apiId);
//
//    /**
//     * 描述：根据ApiId查询过滤字段
//     * 参数：apiId
//     * 返回值：List<ShareDataApiFilter>
//     * 修改人：zhaopengfei
//     * 修改时间：2018/6/8
//     * 修改内容：
//     */
//    @RequestMapping(value = "/api/getDirIdByApiId", method = RequestMethod.POST)
//    public Result<List<ApiFilterBaseDTO>> getFilterByApiId(@RequestParam Long apiId);
//
//    /**
//     * 描述：api删除
//     * 参数：id apiId
//     * 返回值：Boolean
//     * 修改人：zhaopengfei
//     * 修改时间：2018/6/12
//     * 修改内容：
//     */
//    @RequestMapping(value = "/apply/delete", method = RequestMethod.POST)
//    public Result<Boolean> delete(@RequestParam("id") Long id);
//
//    @RequestMapping(value = {"/api/dataView"}, method = RequestMethod.POST)
//    public Result<Object> dataView(@RequestParam("id") Long id, @RequestParam("type") Integer type);
//    /**
//     * 描述：获取当前登录单位Id
//     * 返回值：String
//     * 修改人：zhaopengfei
//     * 修改时间：2018/6/12
//     * 修改内容：
//     */
//    @RequestMapping(value = "/api/getLoginUnitId", method = RequestMethod.GET)
//    public Result<String> getLoginUnitId();
//}
