//package com.hengyunsoft.platform.exchange.api.directory.api.Hystrix;
//
//import com.github.pagehelper.PageInfo;
//import com.hengyunsoft.base.Result;
//import com.hengyunsoft.page.plugins.openapi.OpenApiReq;
//import com.hengyunsoft.platform.exchange.api.directory.api.DataDirectoryApi;
//import com.hengyunsoft.platform.exchange.api.directory.dto.directory.*;
//import com.hengyunsoft.platform.exchange.api.flow.dto.ShareFlowAuditDTO;
//import org.springframework.stereotype.Component;
//import org.springframework.web.bind.annotation.RequestParam;
//
//import java.util.List;
//
///**
// * feign 熔断机制的实现， 默认返回超时响应
// * @author tianai
// * @createTime 2018-04-21
// */
//@Component
//public class DataDirectoryApiHystrix implements DataDirectoryApi {
//    @Override
//    public Result<List<DataDirectoryTreeDTO>> findDataTree(String unitId) {
//        return Result.timeout();
//    }
//
//
//    @Override
//    public Result<PageInfo<DataDirectoryAuditDTO>> page(OpenApiReq<DataDirectoryPageReqAuditDTO> openApiReq) {
//        return Result.timeout();
//    }
//
//    @Override
//    public Result<DataDirectoryDTO> save(DataDirectorySaveDTO dataDirectoryUnitSave) {
//        return Result.timeout();
//    }
//
//    @Override
//    public Result<Boolean> update(DataDirectoryUpdateDTO dataDirectoryUnitUpdateDTO) {
//        return Result.timeout();
//    }
//
//
//    @Override
//    public Result<Boolean> updateUnit(DataDirectoryUpdateDTO dataDirectoryUnitUpdateDTO) {
//        return Result.timeout();
//    }
//
//    @Override
//    public Result<Boolean> delete(Long id) {
//        return Result.timeout();
//    }
//
//    @Override
//    public Result<DataDirectoryDictDTO> get(Long id) {
//        return  Result.timeout();
//    }
//
//    @Override
//    public Result<List<DataDirectoryDTO>> getDirectoryChangeList(String applyCode) {
//        return  Result.timeout();
//    }
//
//    @Override
//    public Result<List<DataDirectoryDTO>> getDirectoryChangeListApply(String unitId, Integer status) {
//        return Result.timeout();
//    }
//
//    @Override
//    public Result<Boolean> updateRasons(String unitId, String reasons) {
//       return Result.timeout();
//    }
//
//    @Override
//    public Result<Boolean> disable(Long  dirId) {
//        return Result.timeout();
//    }
//
//    @Override
//    public Result<Boolean> enable(Long dirId) {
//        return Result.timeout();
//    }
//
//    @Override
//    public Result<List<VOrgDTO>> getOrgList() {
//        return Result.timeout();
//    }
//
//    @Override
//    public Result<ShareFlowAuditDTO> findAudit(Long auditId) {
//        return Result.timeout();
//    }
//
//    @Override
//    public Result<DataDirectoryDictDTO> getDirectoryWare(Long id) {
//        return Result.timeout();
//    }
//
//    @Override
//    public Result<DataDirectoryAutomaticSaveDTO> saveAutomatic(DataDirectoryAutomaticSaveDTO AutomaticSaveDTO) {
//        return Result.timeout();
//    }
//
//    @Override
//    public Result<List<DataDirectoryTreeDTO>> findDataTypeTree(Integer dataType) {
//        return Result.timeout();
//    }
//
//    @Override
//    public Result<List<DataDirectoryTreeDTO>> findAllDataTypeTree(Integer dataType) {
//        return Result.timeout();
//    }
//
//    @Override
//    public Result<List<DataDirectoryTreeDTO>> findAllTreeUnUnit() {
//        return Result.timeout();
//    }
//
//    @Override
//    public Result<Boolean> generatingDatabaseTables(Long dirId ,String dirCode) {
//        return Result.timeout();
//    }
//
//    @Override
//    public Result<ShareUnitDTO> getUnitList(Long dirId, String unitId) {
//        return Result.timeout();
//    }
//
//    @Override
//    public Result<Boolean> getWare(Long id) {
//        return Result.timeout();
//    }
//
//    @Override
//    public Result<Boolean> getDirCode(String dirCode) {
//        return Result.timeout();
//    }
//
//    @Override
//    public Result<Boolean> getElementCode(String fieldCode, Long dirId) {
//        return Result.timeout();
//    }
//}
