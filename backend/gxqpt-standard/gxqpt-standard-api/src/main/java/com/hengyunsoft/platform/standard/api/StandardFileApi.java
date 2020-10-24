//package com.hengyunsoft.platform.standard.api;
//
//import com.github.pagehelper.PageInfo;
//import com.hengyunsoft.base.Result;
//import com.hengyunsoft.page.plugins.openapi.OpenApiReq;
//import com.hengyunsoft.platform.commons.config.FeignConfiguration;
//import com.hengyunsoft.platform.commons.utils.TreeNode;
//import com.hengyunsoft.platform.standard.api.hystrix.StandardFileApiHystrix;
//import com.hengyunsoft.platform.standard.dto.*;
//import org.springframework.cloud.netflix.feign.FeignClient;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;
//
//import java.util.List;
//
///**
// * 标准文档API接口
// * fallback: 实现服务降级处理逻辑。
// * 调用过程中，出现错误、超时、线程池拒绝、断路器熔断等情况时，执行fallback中的方法
// */
//@FeignClient(name = "${gxqpt.gate.feign.server:gaxq-gate-server}",
//        configuration = FeignConfiguration.class,
//        path = "/api/standard", fallback = StandardFileApiHystrix.class)
//public interface StandardFileApi {
//    /**
//     * 根据id 查看文档详情
//     *
//     * @param id
//     * @return
//     */
//    @RequestMapping(value = "/file/get", method = RequestMethod.GET)
//    Result<StandardFileDTO> get(@RequestParam(value = "id") Long id);
//
//    /**
//     * 标准文档查询
//     *
//     * @param openApiReq
//     * @return
//     */
//    @RequestMapping(value = "/file/query", method = RequestMethod.POST)
//    Result<PageInfo<StandardFileDTO>> pageDocument(@RequestBody OpenApiReq<StandardFileQueryDTO> openApiReq);
//
//    /**
//     * 标准文档管理查询列表
//     *
//     * @param openApiReq
//     * @return
//     */
//    @RequestMapping(value = "/file/manageQuery", method = RequestMethod.POST)
//    Result<PageInfo<StandardFileDTO>> pageManageDocument(@RequestBody OpenApiReq<StandardFileQueryDTO> openApiReq);
//
//    /**
//     * 获取登录人的单位信息
//     *
//     * @param
//     */
//    @RequestMapping(value = "/file/findPoly", method = RequestMethod.GET)
//    Result<List<CompanyInfoDTO>> findPolyByUser();
//
//    /**
//     * 保存标准文档
//     *
//     * @param
//     */
//    @RequestMapping(value = "/file/save", method = RequestMethod.POST)
//    Result<StandardFileDTO> save(@RequestBody StandardFileSaveDTO standardFileSaveDTO);
//
//    /**
//     * 更新标准文档
//     *
//     * @param
//     */
//    @RequestMapping(value = "/file/update", method = RequestMethod.POST)
//    Result<Boolean> update(@RequestBody StandardFileUpdateDTO standardFileUpdateDTO);
//
//    /**
//     * 根据id 删除文档
//     *
//     * @param id
//     * @return
//     */
//    @RequestMapping(value = "/file/delete", method = RequestMethod.GET)
//    Result<Boolean> delete(@RequestParam(value = "id") Long id);
//
//    /**
//     * 批量删除文档，多个id之间用“,”隔开
//     *
//     * @param ids
//     * @return
//     */
//    @RequestMapping(value = "/file/batchDelete", method = RequestMethod.GET)
//    Result<Boolean> batchDelete(@RequestParam(value = "ids") String ids);
//
//    /**
//     * 设置文档为过期状态
//     *
//     * @param id
//     * @return
//     */
//    @RequestMapping(value = "/file/updateToDisable", method = RequestMethod.GET)
//    Result<Boolean> updateToDisable(@RequestParam(value = "id") Long id);
//
//    /**
//     * 重新启用文档
//     *
//     * @param id
//     * @return
//     */
//    @RequestMapping(value = "/file/updateToEnable", method = RequestMethod.GET)
//    Result<Boolean> updateToEnable(@RequestParam(value = "id") Long id);
//
//    /**
//     * 根据分类Id查询是否关联文档
//     *
//     * @param classifyId
//     * @return
//     */
//    @RequestMapping(value = "/file/isRelevanceDocument", method = RequestMethod.GET)
//    public Result<Boolean> isRelevanceDocument(@RequestParam(value = "classifyId") String classifyId);
//
//    /**
//     * 查询各分类下的文档数量
//     *
//     * @return
//     */
//    @RequestMapping(value = "/file/findAllFileCount", method = RequestMethod.POST)
//    public Result<List<StandardAnalysisClassifyTreeDTO>> findAllFileCount();
//
//    /**
//     * 标准文档查询(某一分类及子类的文档)
//     *
//     * @param openApiReq
//     * @return
//     */
//    @RequestMapping(value = "/file/queryByClassifyId", method = RequestMethod.POST)
//    Result<PageInfo<StandardFileDTO>> pageDocumentByClassifyId(@RequestBody OpenApiReq<StandardFileQueryDTO> openApiReq);
//
//    /**
//     * 标准文档管理查询列表(某一分类及子类的文档)
//     *
//     * @param openApiReq
//     * @return
//     */
//    @RequestMapping(value = "/file/manageQueryByClassifyId", method = RequestMethod.POST)
//    Result<PageInfo<StandardFileDTO>> pageManageDocumentByClassifyId(@RequestBody OpenApiReq<StandardFileQueryDTO> openApiReq);
//}
