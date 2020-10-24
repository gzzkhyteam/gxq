//package com.hengyunsoft.platform.standard.api.hystrix;
//
//import com.github.pagehelper.PageInfo;
//import com.hengyunsoft.base.Result;
//import com.hengyunsoft.page.plugins.openapi.OpenApiReq;
//import com.hengyunsoft.platform.standard.api.StandardFileApi;
//import com.hengyunsoft.platform.standard.dto.*;
//import org.springframework.stereotype.Component;
//
//import java.util.List;
//
//@Component
//public class StandardFileApiHystrix implements StandardFileApi {
//
//    /**
//     * 根据id 查看文档详情
//     *
//     * @param id
//     * @return
//     */
//    @Override
//    public Result<StandardFileDTO> get(Long id) {
//        return Result.timeout();
//    }
//
//    /**
//     * 标准文档查询
//     *
//     * @param openApiReq
//     * @return
//     */
//    public Result<PageInfo<StandardFileDTO>> pageDocument(OpenApiReq<StandardFileQueryDTO> openApiReq) {
//        return Result.timeout();
//    }
//
//    /**
//     * 标准文档管理查询列表
//     *
//     * @param openApiReq
//     * @return
//     */
//    @Override
//    public Result<PageInfo<StandardFileDTO>> pageManageDocument(OpenApiReq<StandardFileQueryDTO> openApiReq) {
//        return Result.timeout();
//    }
//
//    /**
//     * 获取登录人的单位信息
//     */
//    @Override
//    public Result<List<CompanyInfoDTO>> findPolyByUser() { return Result.timeout(); }
//
//    /**
//     * 保存标准文档
//     *
//     * @param standardFileSaveDTO
//     */
//    @Override
//    public Result<StandardFileDTO> save(StandardFileSaveDTO standardFileSaveDTO) {
//        return Result.timeout();
//    }
//
//    /**
//     * 更新标准文档
//     *
//     * @param standardFileUpdateDTO
//     */
//    @Override
//    public Result<Boolean> update(StandardFileUpdateDTO standardFileUpdateDTO) {
//        return Result.timeout();
//    }
//
//    /**
//     * 根据id 删除文档
//     *
//     * @param id
//     * @return
//     */
//    @Override
//    public Result<Boolean> delete(Long id) {
//        return Result.timeout();
//    }
//
//    /**
//     * 批量删除文档，多个id之间用“,”隔开
//     *
//     * @param ids
//     * @return
//     */
//    @Override
//    public Result<Boolean> batchDelete(String ids) {
//        return Result.timeout();
//    }
//
//    /**
//     * 设置文档为过期状态
//     *
//     * @param id
//     * @return
//     */
//    @Override
//    public Result<Boolean> updateToDisable(Long id) {
//        return Result.timeout();
//    }
//
//    /**
//     * 重新启用文档
//     *
//     * @param id
//     * @return
//     */
//    @Override
//    public Result<Boolean> updateToEnable(Long id) {
//        return Result.timeout();
//    }
//
//    /**
//     * 根据分类Id查询是否关联文档
//     *
//     * @param classifyId
//     * @return
//     */
//    @Override
//    public Result<Boolean> isRelevanceDocument(String classifyId) {
//        return Result.timeout();
//    }
//
//    /**
//     * 查询各分类下的文档数量
//     *
//     * @return
//     */
//    @Override
//    public Result<List<StandardAnalysisClassifyTreeDTO>> findAllFileCount() {
//        return Result.timeout();
//    }
//    /**
//     * 标准文档查询(某一分类及子类的文档)
//     *
//     * @param openApiReq
//     * @return
//     */
//    public Result<PageInfo<StandardFileDTO>> pageDocumentByClassifyId(OpenApiReq<StandardFileQueryDTO> openApiReq) {
//        return Result.timeout();
//    }
//    /**
//     * 标准文档管理查询列表(某一分类及子类的文档)
//     *
//     * @param openApiReq
//     * @return
//     */
//    @Override
//    public Result<PageInfo<StandardFileDTO>> pageManageDocumentByClassifyId(OpenApiReq<StandardFileQueryDTO> openApiReq) {
//        return Result.timeout();
//    }
//}
