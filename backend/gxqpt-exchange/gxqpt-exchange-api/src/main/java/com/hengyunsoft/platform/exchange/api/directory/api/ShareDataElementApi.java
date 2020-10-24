//package com.hengyunsoft.platform.exchange.api.directory.api;
//
//
//import com.hengyunsoft.base.Result;
//import com.hengyunsoft.platform.exchange.api.directory.api.Hystrix.ShareDataElementApiHystrix;
//import com.hengyunsoft.platform.exchange.api.directory.dto.directory.DataDirectoryDTO;
//import com.hengyunsoft.platform.exchange.api.directory.dto.element.*;
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
//@FeignClient(name = "${gxqpt.gate.feign.server:gxqpt-gate-server}", path = "/api/exchange", fallback = ShareDataElementApiHystrix.class)
//public interface ShareDataElementApi {
//    /**
//     * 根据目录id查询数据目录元数据表信息
//     * @param dirId
//     * @return
//     */
//    @RequestMapping(value = "/element/getList", method = RequestMethod.GET)
//    Result<List<DataElementListDTO>> getList(@RequestParam(value = "dirId") Long dirId);
//
//
//    /**
//     * 保存数据目录元数据信息
//     *
//     * @param dataElementSaveDTO
//     * @return
//     */
//    @RequestMapping(value = "/directory/save", method = RequestMethod.POST)
//    Result<DataElementDTO> save(@RequestBody DataElementSaveDTO dataElementSaveDTO);
//    /**
//     * 修改数据目录元数据表信息
//     *
//     * @param dataElementUpdateDTO
//     * @return
//     */
//    @RequestMapping(value = "/element/update", method = RequestMethod.POST)
//    Result<Boolean> update(@RequestBody DataElementUpdateDTO dataElementUpdateDTO);
//
//    /**
//     * 删除数据目录元数据信息
//     *
//     * @param id
//     * @return
//     */
//    @RequestMapping(value = "/element/delete", method = RequestMethod.POST)
//    Result<Boolean> delete(@RequestParam(value = "id") Long id);
//    /**
//     * 根据目录id查询目录信息
//     * @param
//     * @return
//     */
//    @RequestMapping(value = "/element/get", method = RequestMethod.GET)
//    Result<DataElementDTO> get(@RequestParam(value = "id") Long id);
//
//    /**
//     * 根据目录id查询元数据发布表信息(变动)
//     * @param
//     * @return
//     */
//    @RequestMapping(value = "/element/getElementWare", method = RequestMethod.GET)
//    Result<DataElementDTO> getElementWare(@RequestParam(value = "id") Long id);
//
//    /**
//     * 根据元数据表变动信息
//     * @param
//     * @return
//     */
//    @RequestMapping(value = "/element/getElementChangeList", method = RequestMethod.GET)
//    Result<List<DataElementCopyDTO>> getElementChangeList(@RequestParam(value = "applyCode") String applyCode);
//
//    /**
//     * 根据申请发布元数据表变动信息
//     * @param
//     * @return
//     */
//    @RequestMapping(value = "/element/getElementChangeList", method = RequestMethod.GET)
//    Result<List<DataElementCopyDTO>> getElementChangeListApply(@RequestParam(value = "unitId") String unitId,@RequestParam(value = "status") Integer status);
//
//    /**
//     * 禁用数据目录元数据表信息
//     *
//     * @param id
//     * @return
//     */
//    @RequestMapping(value = "/element/disable", method = RequestMethod.POST)
//    Result<Boolean> disable(@RequestParam(value = "id") Long id);
//
//    /**
//     * 启用数据目录元数据表信息
//     *
//     * @param id
//     * @return
//     */
//    @RequestMapping(value = "/element/enable", method = RequestMethod.POST)
//    Result<Boolean> enable(@RequestParam(value = "id") Long id);
//
//}
