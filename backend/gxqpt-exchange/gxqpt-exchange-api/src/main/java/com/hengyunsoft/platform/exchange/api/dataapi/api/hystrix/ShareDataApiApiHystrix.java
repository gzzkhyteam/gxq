//package com.hengyunsoft.platform.exchange.api.dataapi.api.hystrix;
//
//import com.github.pagehelper.PageInfo;
//import com.hengyunsoft.base.Result;
//import com.hengyunsoft.page.plugins.openapi.OpenApiReq;
//import com.hengyunsoft.platform.exchange.api.dataapi.api.ShareDataApiApi;
//import com.hengyunsoft.platform.exchange.api.dataapi.dto.dataapi.*;
//import com.hengyunsoft.platform.exchange.api.directory.dto.directory.VOrgDTO;
//import org.springframework.stereotype.Component;
//
//import java.util.List;
//
///**
// * com.hengyunsoft.platform.exchange.api.dataapi.api.hystrix
// * 版权：中科恒运软件科技股份有限公司贵阳分公司
// * 描述：熔断机制的实现， 默认返回超时响应
// * 修改人：zhaopengfei
// * 修改时间：2018/4/21
// * 修改内容：新增熔断机制
// */
//@Component
//public class ShareDataApiApiHystrix implements ShareDataApiApi {
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
//    @Override
//    public Result<ApiDirSaveReturnDTO> saveApiDirectoryChosen(Long dirId, Integer type,Long apiId,Long busId) {
//        return Result.timeout();
//    }
//
//    /**
//     * 描述：用于保存Api创建第二步：保存查询字段
//     * 参数：ApiElementDTO API元数据
//     * 返回值：Boolean 状态（成功、失败）
//     * 修改人：zhaopengfei
//     * 修改时间：2018/4/21
//     * 修改内容：
//     */
//    @Override
//    public Result<Boolean> saveApiElementChosen(ApiElementDTO dto) {
//        return Result.timeout();
//    }
//
//
//    /**
//     * 描述：用于保存Api创建第三步：保存过滤条件
//     * 参数：ApiElementDTO API元数据
//     * 返回值：Boolean 状态（成功、失败）
//     * 修改人：zhaopengfei
//     * 修改时间：2018/4/21
//     * 修改内容：
//     */
//    @Override
//    public Result<Boolean> saveApiFilterChosen(ApiFilterDTO dto) {
//        return Result.timeout();
//    }
//
//    /**
//     * 描述：用于保存Api创建第四步：保存api基本信息
//     * 参数：ApiElementDTO API元数据
//     * 返回值：Boolean 状态（成功、失败）
//     * 修改人：zhaopengfei
//     * 修改时间：2018/4/21
//     * 修改内容：
//     */
//    @Override
//    public Result<Boolean> saveApiInfo(ApiBaseInfoDTO dto) {
//        return Result.timeout();
//    }
//
//    /**
//     * 描述：查询api分页数据
//     * 参数：openApiReq 分页信息；appId：应用Id
//     * 返回值：PageInfo<RoleDto>
//     * 修改人：zhaopengfei
//     * 修改时间：2018/4/21
//     * 修改内容：
//     */
//    @Override
//    public Result<PageInfo<ApiReturnDataDTO>> page(OpenApiReq<ApiQueryConditionDTO> openApiReq) {
//        return Result.timeout();
//    }
//
//    /**
//     * 描述：根据api详细信息
//     * 参数：id：APP id
//     * 返回值：ResourceUpdatDto
//     * 修改人：zhaopengfei
//     * 修改时间：2018/4/21
//     * 修改内容：
//     */
//    @Override
//    public Result<ApiDetailDTO> getById(Long id) {
//        return Result.timeout();
//    }
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
//    @Override
//    public Result<Boolean> updatestatus(Long id, Integer status) {
//        return Result.timeout();
//    }
//
//    /**
//     * 描述：通过目录Id查找api分页列表
//     * 参数：openApiReq 分页信息；appId：应用Id
//     * 返回值：PageInfo<RoleDto>
//     * 修改人：zhaopengfei
//     * 修改时间：2018/4/21
//     * 修改内容：
//     */
//    @Override
//    public Result<PageInfo<ApiReturnDataDTO>> findApiByDirId(OpenApiReq<Long> openApiReq) {
//        return Result.timeout();
//    }
//
//    /**
//     * 描述：api新增授权单位
//     * 参数：dto
//     * 返回值：Boolean
//     * 修改人：zhaopengfei
//     * 修改时间：2018/4/30
//     * 修改内容：
//     */
//    @Override
//    public Result<Boolean> saveAuthUnit(ApiAuthUnitSaveDTO dto) {
//        return Result.timeout();
//    }
//
//    /**
//     * 描述：通过ApiId查找所共享单位
//     * 参数：openApiReq 分页信息；ApiAuthUnitConditionDTO
//     * 返回值：PageInfo<ApiAuthUnitListDTO>
//     * 修改人：zhaopengfei
//     * 修改时间：2018/4/30
//     * 修改内容：
//     */
//    @Override
//    public Result<PageInfo<ApiAuthUnitListDTO>> findAuthUnit(OpenApiReq<ApiAuthUnitConditionDTO> openApiReq) {
//        return Result.timeout();
//    }
//
//    /**
//     * 描述：查询api未共享的单位
//     * 参数：apiId apiId
//     * 返回值：PageInfo<ApiAuthUnitListDTO>
//     * 修改人：zhaopengfei
//     * 修改时间：2018/4/30
//     * 修改内容：
//     */
//    @Override
//    public Result<List<VOrgDTO>> findNoAuthUnit(Long apiId) {
//        return Result.timeout();
//    }
//
//    /**
//     * 描述：查询api正常使用情况
//     * 参数：ApiUseQueryDTO
//     * 返回值：PageInfo<ApiUseListDTO>
//     * 修改人：zhaopengfei
//     * 修改时间：2018/5/1
//     * 修改内容：
//     */
//    @Override
//    public Result<PageInfo<ApiUseListDTO>> findApiUse(OpenApiReq<ApiUseQueryDTO> dto) {
//        return Result.timeout();
//    }
//
//    /**
//     * 描述：查询api异常使用情况
//     * 参数：ApiUseExceptionQueryDTO
//     * 返回值：PageInfo<ApiUseExceptionListDTO>
//     * 修改人：zhaopengfei
//     * 修改时间：2018/5/1
//     * 修改内容：
//     */
//    @Override
//    public Result<PageInfo<ApiUseExceptionListDTO>> findApiUseException(OpenApiReq<ApiUseExceptionQueryDTO> openApiReq) {
//        return Result.timeout();
//    }
//
//    /**
//     * 描述：查询Api调用总次数
//     * 参数：id apiId
//     * 返回值：调用数
//     * 修改人：zhaopengfei
//     * 修改时间：2018/5/2
//     * 修改内容：
//     */
//    @Override
//    public Result<Integer> findApiUseTotalNum(Long id) {
//        return Result.timeout();
//    }
//
//    /**
//     * 描述：api异常忽略处理
//     * 参数：id 异常调用Id
//     * 返回值：Boolean 操作状态
//     * 修改人：zhaopengfei
//     * 修改时间：2018/4/22
//     * 修改内容：
//     */
//    @Override
//    public Result<Boolean> updateExcHdle(Long id) {
//        return Result.timeout();
//    }
//
//    /**
//     * 描述：保存异常处理信息
//     * 参数：dto
//     * 返回值：调用数
//     * 修改人：zhaopengfei
//     * 修改时间：2018/5/2
//     * 修改内容：
//     */
//    @Override
//    public Result<Boolean> saveExcHdle(ApiCallExceptionHdleDTO dto) {
//        return Result.timeout();
//    }
//
//    /**
//     * 描述：获取异常信息
//     * 参数：id
//     * 返回值：调用数
//     * 修改人：zhaopengfei
//     * 修改时间：2018/5/2
//     * 修改内容：
//     */
//    @Override
//    public Result<ApiUseExceptionDetailDTO> getExcInfo(Long id) {
//        return Result.timeout();
//    }
//
//    /**
//     * 描述：根据非结构化目录Id获取该目录的全量API
//     * 参数：dirId
//     * 返回值：ApiBaseInfoDTO
//     * 修改人：zhaopengfei
//     * 修改时间：2018/5/2
//     * 修改内容：
//     */
//    @Override
//    public Result<ApiBaseInfoDTO> getApiInfoByUnstrId(Long dirId) {
//        return Result.timeout();
//    }
//
//    @Override
//    public Result<ApiBaseInfoDTO> getBaseApiInfo(Long apiId) {
//        return Result.timeout();
//    }
//
//    @Override
//    public Result<List<ApiElementBaseDTO>> getElementByApiId(Long apiId) {
//        return Result.timeout();
//    }
//
//    @Override
//    public Result<List<ApiFilterBaseDTO>> getFilterByApiId(Long apiId) {
//        return Result.timeout();
//    }
//    /**
//     * 描述：共享API
//     * 参数：id apiId
//     * 返回值：Boolean
//     * 修改人：zhaopengfei
//     * 修改时间：2018/6/12
//     * 修改内容：
//     */
//    @Override
//    public Result<Boolean> delete(Long id) {
//        return Result.timeout();
//    }
//
//    @Override
//    public Result<Object> dataView(Long id, Integer type) {
//        return Result.timeout();
//    }
//
//    @Override
//    public Result<String> getLoginUnitId() {
//        return Result.timeout();
//    }
//}
