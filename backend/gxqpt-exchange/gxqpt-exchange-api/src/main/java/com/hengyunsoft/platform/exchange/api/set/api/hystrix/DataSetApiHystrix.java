//package com.hengyunsoft.platform.exchange.api.set.api.hystrix;
//
//import com.github.pagehelper.PageInfo;
//import com.hengyunsoft.base.Result;
//import com.hengyunsoft.page.plugins.openapi.OpenApiReq;
//import com.hengyunsoft.platform.exchange.api.set.api.DataSetApi;
//import com.hengyunsoft.platform.exchange.api.set.dto.*;
//import org.springframework.stereotype.Component;
//
//import java.util.List;
//
//@Component
//public class DataSetApiHystrix implements DataSetApi {
//    @Override
//    public Result<String> dataSetCode() {
//        return Result.timeout();
//    }
//
//    @Override
//    public Result<CreateDPFileFirstResDTO> createFileDataSetFirst(CreateDataSetParamDTO param) {
//        return Result.timeout();
//    }
//
//    @Override
//    public Result<Boolean> createFileDataSetSecond(CreateDataSetParamFileDTO param) throws Exception {
//        return Result.timeout();
//    }
//
//    @Override
//    public Result<CreateDSPdbFirstResDTO> createDatabaseDataSetFirst(CreateDSPdbFirstReqDTO param) throws Exception {
//        return Result.timeout();
//    }
//
//    @Override
//    public Result<CreateDSPdbSecondResDTO> createDatabaseDataSetSecond(CreateDSPdbSecondReqDTO param) {
//        return Result.timeout();
//    }
//
//    @Override
//    public Result<List<DataSetElementDTO>> queryCheck(Long setId, String sql) {
//        return Result.timeout();
//    }
//
//    @Override
//    public Result<CreateDSPdbThirdResTDO> createDatabaseDataSetThird(CreateDSPdbThirdReqTDO param) {
//        return Result.timeout();
//    }
//
//
//    @Override
//    public Result<Boolean> selectDic(SelectDirectoryReqDTO param) {
//        return Result.timeout();
//    }
//
//
//    @Override
//    public Result<QueryDataResDTO> pageShowDataByDirectoryId(Long did, Long page) {
//        return Result.timeout();
//    }
//
//    @Override
//    public Result<PageInfo<QueryDataSetResEleDTO>> find(OpenApiReq<QueryDataSetParamReqDTO> openApiReq) {
//        return Result.timeout();
//    }
//
//    @Override
//    public Result<Boolean> deleteDataSet(Long setId) {
//        return Result.timeout();
//    }
//
//    @Override
//    public Result<DataSetBaseInfoDTO> getBaseInfo(Long setId) {
//        return Result.timeout();
//    }
//
//    @Override
//    public Result<QueryDataResDTO> queryDataByUrl(Integer resType, String url, Long page) {
//        return Result.timeout();
//    }
//
//    @Override
//    public Result<QueryDataResDTO> queryDataByDataSet(Long did, Long page) {
//        return Result.timeout();
//    }
//
//    @Override
//    public Result<FlowDataSetInfoTDO> showFlowDataSetInfo(Long taskId) {
//        return Result.timeout();
//    }
//
//    @Override
//    public Result<DatabaseTableDTO> getTableInfo(Long dataSourcId, String tableCode) {
//        return Result.timeout();
//    }
//
//    @Override
//    public Result<List<DatabaseTableDTO>> getAllTableNamesInfo(Long dbId) {
//        return Result.timeout();
//    }
//
//    @Override
//    public Result<List<DataSetElementDTO>> queryDataSetField(Long setId) {
//        return Result.timeout();
//    }
//
//    @Override
//    public Result<Boolean> deleteFile(DeleteFileParamDTO deleteFileDTO) {
//        return Result.timeout();
//    }
//
//    @Override
//    public Result<DataSetCheakRuleDTO> getSetRule(Long setId) {
//        return Result.timeout();
//    }
//
//    @Override
//    public Result<Boolean> saveSetRule(DataSetCheakRuleDTO param) {
//        return Result.timeout();
//    }
//
//    @Override
//    public Result<DataSetDataDto> querySetData(OpenApiReq<Long> openApiReq) {
//        return Result.timeout();
//    }
//
//    @Override
//    public Result<Boolean> updateWareHouseData(WareHouseUpdateDTO param) {
//        return Result.timeout();
//    }
//
//    @Override
//    public Result<QuerySetElementFieldRes> querySetElementField(Long setId) {
//        return Result.timeout();
//    }
//
//
//    @Override
//    public Result<DatabaseTableDTO> getDbSourceTableInfo(Long setId) {
//        return Result.timeout();
//    }
//
//    @Override
//    public Result<QueryDataResDTO> queryDataByAPIId(Long apiId) {
//        return Result.timeout();
//    }
//}
//
