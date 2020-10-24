//package com.hengyunsoft.platform.exchange.api.directory.api;
//
//import com.github.pagehelper.PageInfo;
//import com.hengyunsoft.base.Result;
//import com.hengyunsoft.page.plugins.openapi.OpenApiReq;
//import com.hengyunsoft.platform.exchange.api.directory.api.Hystrix.DataDirectoryApiHystrix;
//import com.hengyunsoft.platform.exchange.api.directory.dto.directory.*;
//import com.hengyunsoft.platform.exchange.api.flow.dto.ShareFlowAuditDTO;
//import org.springframework.cloud.netflix.feign.FeignClient;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;
//
//import java.util.List;
//
///**
// * @author tianai
// * @createTime 2018-04-21
// */
//@FeignClient(name = "${gxqpt.gate.feign.server:gxqpt-gate-server}", path = "/api/exchange", fallback = DataDirectoryApiHystrix.class)
//public interface DataDirectoryApi {
//    /**
//     * 查询查询目录列表
//     *
//     * @param unitId
//     * @return
//     */
//    @RequestMapping(value = "/directory/findDataTree", method = RequestMethod.GET)
//    Result<List<DataDirectoryTreeDTO>> findDataTree(@RequestParam(value = "unitId") String unitId);
//
//
//    /**
//     * 查询数据目录分页信息
//     *
//     * @param openApiReq
//     * @return
//     */
//    @RequestMapping(value = "/directory/page", method = RequestMethod.POST)
//    Result<PageInfo<DataDirectoryAuditDTO>> page(@RequestBody OpenApiReq<DataDirectoryPageReqAuditDTO> openApiReq);
//
//    /**
//     * 保存数据目录信息
//     *
//     * @param dataDirectoryUnitSave
//     * @return
//     */
//    @RequestMapping(value = "/directory/save", method = RequestMethod.POST)
//    Result<DataDirectoryDTO> save(@RequestBody DataDirectorySaveDTO dataDirectoryUnitSave);
//
//    /**
//     * 修改数据目录信息
//     *
//     * @param dataDirectoryUnitUpdateDTO
//     * @return
//     */
//    @RequestMapping(value = "/directory/update", method = RequestMethod.POST)
//    Result<Boolean> update(@RequestBody DataDirectoryUpdateDTO dataDirectoryUnitUpdateDTO);
//
//
//    /**
//     * 修改数据目录单位信息
//     *
//     * @param dataDirectoryUnitUpdateDTO
//     * @return
//     */
//    @RequestMapping(value = "/directory/updateUnit", method = RequestMethod.POST)
//    Result<Boolean> updateUnit(@RequestBody DataDirectoryUpdateDTO dataDirectoryUnitUpdateDTO);
//
//    /**
//     * 删除数据目录信息
//     *
//     * @param id
//     * @return
//     */
//    @RequestMapping(value = "/directory/delete", method = RequestMethod.POST)
//    Result<Boolean> delete(@RequestParam(value = "id") Long id);
//
//
//    /**
//     * 根据目录id查询目录信息
//     *
//     * @param
//     * @return
//     */
//    @RequestMapping(value = "/directory/get", method = RequestMethod.GET)
//    Result<DataDirectoryDictDTO> get(@RequestParam(value = "id") Long id);
//
//    /**
//     * 查询目录新增、修改、删除的目录信息
//     *
//     * @param
//     * @return
//     */
//    @RequestMapping(value = "/directory/getDirectoryChangeList", method = RequestMethod.GET)
//    Result<List<DataDirectoryDTO>> getDirectoryChangeList(@RequestParam(value = "applyCode") String applyCode);
//
//    /**
//     * 查询目录新增、修改、删除的目录信息
//     *
//     * @param
//     * @return
//     */
//    @RequestMapping(value = "/directory/getDirectoryChangeListApply", method = RequestMethod.GET)
//    Result<List<DataDirectoryDTO>> getDirectoryChangeListApply(@RequestParam(value = "unitId") String unitId,@RequestParam(value = "status") Integer status);
//
//
//    /**
//     * 目录发布更新申请原因/理由
//     *
//     * @param unitId,applicationReasons
//     * @return
//     */
//    @RequestMapping(value = "/directory/updateRasons", method = RequestMethod.POST)
//    Result<Boolean> updateRasons(@RequestParam(value = "unitId") String unitId, @RequestParam(value = "reasons") String reasons);
//
//    /**
//     * 禁用此目录及子目录
//     *
//     * @param dirId
//     * @return
//     */
//    @RequestMapping(value = "/directory/disable", method = RequestMethod.POST)
//    Result<Boolean> disable(@RequestParam(value = "dirId") Long dirId);
//
//    /**
//     * 启用用此目录及子目录
//     *
//     * @param dirId
//     * @return
//     */
//    @RequestMapping(value = "/directory/enable", method = RequestMethod.POST)
//    Result<Boolean> enable(@RequestParam(value = "dirId") Long dirId);
//
//    /**
//     * 查询共享单位
//     *
//     * @param
//     */
//    @RequestMapping(value = "/directory/getOrgList", method = RequestMethod.GET)
//    Result<List<VOrgDTO>> getOrgList();
//
//    /**
//     * 根据AuditId查询目录审核结果
//     *
//     * @param auditId
//     * @return
//     */
//    @RequestMapping(value = "/directory/findAudit", method = RequestMethod.GET)
//    Result<ShareFlowAuditDTO> findAudit(@RequestParam(value = "auditId") Long auditId);
//
//
//    /**
//     * 根据目录id查询目录信息发布表信息(变动)
//     *
//     * @param
//     * @return
//     */
//    @RequestMapping(value = "/directory/getDirectoryWare", method = RequestMethod.GET)
//    Result<DataDirectoryDictDTO> getDirectoryWare(@RequestParam(value = "id") Long id);
//
//    /**
//     * 自动创建数据目录及字段信息
//     *
//     * @param AutomaticSaveDTO
//     * @return
//     */
//    @RequestMapping(value = "/directory/saveUnit", method = RequestMethod.POST)
//    Result<DataDirectoryAutomaticSaveDTO> saveAutomatic(@RequestBody DataDirectoryAutomaticSaveDTO AutomaticSaveDTO);
//
//
//    /**
//     * 根据数据类型查询目录列表
//     *
//     * @param dataType
//     * @return
//     */
//    @RequestMapping(value = "/directory/findDataTypeTree", method = RequestMethod.GET)
//    Result<List<DataDirectoryTreeDTO>> findDataTypeTree(@RequestParam(value = "dataType") Integer dataType);
//
//    @RequestMapping(value = "/findAllDataTypeTree", method = RequestMethod.GET)
//    Result<List<DataDirectoryTreeDTO>> findAllDataTypeTree(@RequestParam(value = "dataType") Integer dataType);
//
//    @RequestMapping(value = "/findAllTreeUnUnit", method = RequestMethod.GET)
//    Result<List<DataDirectoryTreeDTO>> findAllTreeUnUnit();
//
//    /**
//     * 目录生成数据库表及字段信息
//     *
//     * @param dirCode
//     * @return
//     */
//    @RequestMapping(value = "/directory/generatingDatabaseTables", method = RequestMethod.POST)
//    Result<Boolean> generatingDatabaseTables(@RequestParam(value = "dirId") Long dirId,@RequestParam(value = "dirCode") String dirCode);
//
//    /**
//     * 查询共享单位
//     *
//     * @param
//     */
//    @RequestMapping(value = "/directory/getUnitList", method = RequestMethod.GET)
//    Result<ShareUnitDTO> getUnitList(@RequestParam(value = "dirId") Long dirId,@RequestParam(value = "unitId") String unitId);
//
//    /**
//     * 根据目录id查询目录是否已发布
//     *
//     * @param
//     * @return
//     */
//    @RequestMapping(value = "/directory/getWare", method = RequestMethod.GET)
//    Result<Boolean> getWare(@RequestParam(value = "id") Long id);
//
//    /**
//     * 查询字段编码是否存在
//     *
//     * @param dirCode
//     * @return
//     */
//    @RequestMapping(value = "/directory/getDirCode", method = RequestMethod.GET)
//    Result<Boolean> getDirCode(@RequestParam(value = "dirCode") String dirCode);
//
//    /**
//     * 查询字段编码是否存在
//     *
//     * @param dirId,fieldCode
//     * @return
//     */
//    @RequestMapping(value = "/directory/getElementCode", method = RequestMethod.GET)
//    Result<Boolean> getElementCode(@RequestParam(value = "fieldCode") String fieldCode,@RequestParam(value = "dirId") Long dirId);
//}
