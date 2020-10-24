//package com.hengyunsoft.platform.exchange.api.set.api;
//
//import com.github.pagehelper.PageInfo;
//import com.hengyunsoft.base.Result;
//import com.hengyunsoft.page.plugins.openapi.OpenApiReq;
//import com.hengyunsoft.platform.exchange.api.set.api.hystrix.DataSetApiHystrix;
//import com.hengyunsoft.platform.exchange.api.set.dto.*;
//import io.swagger.annotations.ApiOperation;
//import org.springframework.cloud.netflix.feign.FeignClient;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;
//
//import java.util.List;
//
///**
// * 描述：
// *
// * @author gbl
// * @date 2018/4/21
// */
//@FeignClient(name = "${gxqpt.gate.feign.server:gxqpt-gate-server}", path = "/api/set", fallback = DataSetApiHystrix.class)
//public interface DataSetApi {
//    /**
//     * 描述：生成得到数据集标识
//     * 参数：
//     * 返回值：
//     * 修改人：gbl
//     * 修改时间：2018/4/23
//     * 修改内容：
//     */
//    @RequestMapping(value = "dataSetCode", method = RequestMethod.GET)
//    Result<String> dataSetCode();
//
//    /**
//     * 描述：创建文件类型数据集第一步提交
//     * 参数：数据库数据集参数
//     * 返回值：当前数据集的主键
//     * 修改人：gbl
//     * 修改时间：2018/4/23
//     * 修改内容：新增
//     */
//    @RequestMapping(value = "createFileDataSetFirst", method = RequestMethod.POST)
//    Result<CreateDPFileFirstResDTO> createFileDataSetFirst(@RequestBody CreateDataSetParamDTO param);
//
//    /**
//     * 描述：创建文件类型数据集第二步提交
//     * 参数：提交参数
//     * 返回值：
//     * 修改人：gbl
//     * 修改时间：2018/4/24
//     * 修改内容：
//     */
//    @RequestMapping(value = "createFileDataSetSecond", method = RequestMethod.POST)
//    Result<Boolean> createFileDataSetSecond(@RequestBody CreateDataSetParamFileDTO param) throws Exception;
//
//
//    /**
//     * 描述：创建数据库类型数据集第一步提交
//     * 参数：数据库相关参数
//     * 返回值：
//     * 修改人：gbl
//     * 修改时间：2018/4/24
//     * 修改内容：
//     */
//    @RequestMapping(value = "createDatabaseDataSetFirst", method = RequestMethod.POST)
//    Result<CreateDSPdbFirstResDTO> createDatabaseDataSetFirst(@RequestBody CreateDSPdbFirstReqDTO param) throws Exception;
//
//    /**
//     * 描述：创建数据库类型数据集第二步提交
//     * 参数：
//     * 返回值：
//     * 修改人：gbl
//     * 修改时间：2018/4/24
//     * 修改内容：
//     */
//    @RequestMapping(value = "createDatabaseDataSetSecond", method = RequestMethod.POST)
//    Result<CreateDSPdbSecondResDTO> createDatabaseDataSetSecond(@RequestBody CreateDSPdbSecondReqDTO param) throws Exception;
//
//    /**
//     * 描述：查询检验
//     * 参数：
//     * 返回值：
//     * 修改人：gbl
//     * 修改时间：2018/9/11
//     * 修改内容：
//     */
//    @RequestMapping(value = "queryCheck", method = RequestMethod.GET)
//    Result<List<DataSetElementDTO>> queryCheck(@RequestParam("setId") Long setId, @RequestParam("sql") String sql);
//
//    /**
//     * 描述：创建数据库类型数据集第三步提交
//     * 参数：
//     * 返回值：
//     * 修改人：gbl
//     * 修改时间：2018/4/24
//     * 修改内容：
//     */
//    @RequestMapping(value = "createDatabaseDataSetThird", method = RequestMethod.POST)
//    Result<CreateDSPdbThirdResTDO> createDatabaseDataSetThird(@RequestBody CreateDSPdbThirdReqTDO param) throws Exception;
//
//
//    /**
//     * 描述：选择关联目录
//     * 参数：
//     * 返回值：
//     * 修改人：gbl
//     * 修改时间：2018/4/23
//     * 修改内容：
//     */
//    @RequestMapping(value = "selectDic", method = RequestMethod.POST)
//    Result<Boolean> selectDic(@RequestBody SelectDirectoryReqDTO param);
//
//
//    /**
//     * 描述：创建API数据集第一步提交
//     * 参数：
//     * 返回值：
//     * 修改人：gbl
//     * 修改时间：2018/4/24
//     * 修改内容：
//     */
//    // @RequestMapping(value = "createApiDataSetFirst", method = RequestMethod.POST)
//    // Result<CreateDPApiFirstResDTO> createApiDataSetFirst(@RequestBody CreateDPApiFirstReqDTO param);
//
//    /**
//     * 描述：创建API数据集第二步提交
//     * 参数：
//     * 返回值：
//     * 修改人：gbl
//     * 修改时间：2018/4/24
//     * 修改内容：
//     */
//    //@RequestMapping(value = "createApiDataSetScond", method = RequestMethod.POST)
//    // Result<CreateDPApiSecondResDTO> createApiDataSetScond(@RequestBody CreateDPApiSecondReqDTO param) throws Exception;
//
//
//    /**
//     * 描述：根据目录id查询数据
//     * 参数：
//     * 返回值：结果数据集
//     * 修改人：gbl
//     * 修改时间：2018/4/24
//     * 修改内容：
//     */
//    @RequestMapping(value = "pageShowDataByDirectoryId", method = RequestMethod.POST)
//    Result<QueryDataResDTO> pageShowDataByDirectoryId(@RequestParam Long did, @RequestParam Long page) throws Exception;
//
//    /**
//     * 描述：根据apiId查询api数据集类型的数据
//     * 参数：
//     * 返回值：结果数据集
//     * 修改人：gbl
//     * 修改时间：2018/4/24
//     * 修改内容：
//     */
//    @RequestMapping(value = "queryDataByAPIId", method = RequestMethod.POST)
//    @ApiOperation(value = "根据apiId查询api数据集类型的数据", notes = "根据apiId查询api数据集类型的数据")
//    Result<QueryDataResDTO> queryDataByAPIId(@RequestParam("apiId") Long apiId);
//
//    /**
//     * 描述： 根据url获取数据
//     * 参数：resType:API数据类型:1,jason;2,xml  url: api的地址
//     * 返回值：
//     * 修改人：gbl
//     * 修改时间：2018/4/27
//     * 修改内容：
//     */
//    @RequestMapping(value = "queryDataByUrl", method = RequestMethod.POST)
//    Result<QueryDataResDTO> queryDataByUrl(@RequestParam("resType") Integer resType, @RequestParam("url") String url, @RequestParam("page") Long page);
//
//
//    /**
//     * 描述：根据数据集ID查询数据
//     * 参数：
//     * 返回值：
//     * 修改人：gbl
//     * 修改时间：2018/4/27
//     * 修改内容：
//     */
//    @RequestMapping(value = "queryDataByDataSet", method = RequestMethod.POST)
//    Result<QueryDataResDTO> queryDataByDataSet(@RequestParam("did") Long did, @RequestParam("page") Long page) throws Exception;
//
//    /**
//     * 描述：查询数据列表
//     * 参数：
//     * 返回值：
//     * 修改人：gbl
//     * 修改时间：2018/4/25
//     * 修改内容：
//     */
//    @RequestMapping(value = "find", method = RequestMethod.POST)
//    Result<PageInfo<QueryDataSetResEleDTO>> find(@RequestBody OpenApiReq<QueryDataSetParamReqDTO> openApiReq);
//
//
//    /**
//     * 描述： 根据数据集id删除数据集集
//     * 参数：数据集id
//     * 返回值：
//     * 修改人：gbl
//     * 修改时间：2018/4/26
//     * 修改内容：
//     */
//    @RequestMapping(value = "deleteDataSet", method = RequestMethod.POST)
//    Result<Boolean> deleteDataSet(@RequestParam Long setId);
//
//
//    /**
//     * 描述：查询数据集的基本信息
//     * 参数：数据集id
//     * 返回值：
//     * 修改人：gbl
//     * 修改时间：2018/4/26
//     * 修改内容：
//     */
//    @RequestMapping(value = "getBaseInfo", method = RequestMethod.GET)
//    Result<DataSetBaseInfoDTO> getBaseInfo(@RequestParam Long setId) throws Exception;
//
//
//    /**
//     * 描述：查询数据集流程详细信息
//     * 参数：流程任务id
//     * 返回值：
//     * 修改人：gbl
//     * 修改时间：2018/4/27
//     * 修改内容：
//     */
//    @RequestMapping(value = "showFlowDataSetInfo", method = RequestMethod.POST)
//    Result<FlowDataSetInfoTDO> showFlowDataSetInfo(@RequestParam Long taskId);
//
//
//    /**
//     * 描述：查询数据库数据源一张表的信息
//     * 参数：
//     * 返回值：
//     * 修改人：gbl
//     * 修改时间：2018/5/5
//     * 修改内容：
//     */
//    @RequestMapping(value = "getTableInfo", method = RequestMethod.POST)
//    Result<DatabaseTableDTO> getTableInfo(@RequestParam("dataSourcId") Long dataSourcId, @RequestParam("tableCode") String tableCode);
//
//    /**
//     * 描述：获取数据源表信息
//     * 参数：
//     * 返回值：
//     * 修改人：gbl
//     * 修改时间：2018/5/8
//     * 修改内容：
//     */
//    @ApiOperation(value = "获取数据源表信息", notes = "获取数据源表信息")
//    @RequestMapping(value = "getAllTableNamesInfo", method = RequestMethod.POST)
//    Result<List<DatabaseTableDTO>> getAllTableNamesInfo(@RequestParam("dbId") Long dbId);
//
//    /**
//     * 描述：查询数据集字段
//     * 参数：
//     * 返回值：
//     * 修改人：gbl
//     * 修改时间：2018/5/8
//     * 修改内容：
//     */
//    @RequestMapping(value = "queryDataSetField", method = RequestMethod.POST)
//    @ApiOperation(value = "查询数据集字段", notes = "查询数据集字段")
//    Result<List<DataSetElementDTO>> queryDataSetField(@RequestParam("setId") Long setId);
//
//
//    /**
//     * 描述：删除数据文件
//     * 参数：
//     * 返回值：
//     * 修改人：gbl
//     * 修改时间：2018/5/10
//     * 修改内容：
//     *
//     * @param deleteFileDTO
//     */
//    @RequestMapping(value = "deleteFile", method = RequestMethod.POST)
//    @ApiOperation(value = "删除数据文件", notes = "删除数据文件")
//    Result<Boolean> deleteFile(@RequestBody DeleteFileParamDTO deleteFileDTO);
//
//    /***
//     * 得到数据集的校验规则
//     * @param setId
//     * @return
//     */
//    @RequestMapping(value = "getSetRule", method = RequestMethod.GET)
//    Result<DataSetCheakRuleDTO> getSetRule(@RequestParam("setId") Long setId);
//
//    /**
//     * 描述：保存数据集字段规则
//     * 参数：DataSetElementRuleDTO
//     * 返回值：Boolean
//     * 修改人：zhaopengfei
//     * 修改时间：2018/8/29
//     * 修改内容：
//     */
//    @RequestMapping(value = "saveSetRule", method = RequestMethod.POST)
//    Result<Boolean> saveSetRule(@RequestBody DataSetCheakRuleDTO param);
//
//
//    /**
//     * 描述：根据数据集Id查询数据集数据仓库数据
//     * 参数：
//     * 返回值：
//     * 修改人：zhaopengfei
//     * 修改时间：2018/8/30
//     * 修改内容：
//     */
//    @RequestMapping(value = "querySetData", method = RequestMethod.POST)
//    Result<DataSetDataDto> querySetData(@RequestBody OpenApiReq<Long> openApiReq);
//
//    /**
//     * 描述：更新数据仓库数据
//     * 参数：DataSetElementRuleDTO
//     * 返回值：Boolean
//     * 修改人：zhaopengfei
//     * 修改时间：2018/8/31
//     * 修改内容：
//     */
//    @RequestMapping(value = "updateWareHouseData", method = RequestMethod.POST)
//    Result<Boolean> updateWareHouseData(@RequestBody WareHouseUpdateDTO param) throws Exception;
//
//    /**
//     * 描述：查询数据集现在的字段列表
//     * 参数：
//     * 返回值：
//     * 修改人：gbl
//     * 修改时间：2018/9/13
//     * 修改内容：
//     */
//    @RequestMapping(value = "querySetElementField", method = RequestMethod.GET)
//    Result<QuerySetElementFieldRes> querySetElementField(@RequestParam("setId") Long setId);
//
//    /**
//     * 描述：得到数据集在数据源表的信息
//     * 参数：
//     * 返回值：
//     * 修改人：gbl
//     * 修改时间：2018/9/14
//     * 修改内容：
//     */
//    @RequestMapping(value = "getDbSourceTableInfo", method = RequestMethod.GET)
//    Result<DatabaseTableDTO> getDbSourceTableInfo(@RequestParam("setId") Long setId);
//}
