//package com.hengyunsoft.platform.warn.api.warntype.api;
//
//import com.hengyunsoft.base.Result;
//
//import com.hengyunsoft.platform.warn.api.warntype.api.hystrix.GxqptWarnTypeApiHystrix;
//import com.hengyunsoft.platform.warn.api.warntype.dto.GxqptWarnTypeDTO;
//import com.hengyunsoft.platform.warn.api.warntype.dto.UpdateGxqptWarnTypeDTO;
//import com.hengyunsoft.platform.warn.api.warntype.dto.WarnTreeDTO;
//import org.springframework.cloud.netflix.feign.FeignClient;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;
//
//import java.util.List;
//import java.util.Map;
//
///**
// *@author zjr
// * @date 2018/03/28
// */
//@FeignClient(name = "${gxqpt.gate.feign.server:gxqpt-gate-server}", fallback = GxqptWarnTypeApiHystrix.class,
//path = "/api/warn")
//public interface GxqptWarnTypeApi {
//
//    /**
//     * 获取预警类型分类树
//     * @param parentId
//     * @return
//     */
//    @RequestMapping(value = "/warntype/findWarnTypeTree", method = RequestMethod.GET)
//    Result<List<WarnTreeDTO>> findWarnTypeTree(@RequestParam(value = "id") Long id);
//    /**
//     * 查询预警类型
//     * @return
//     */
//    @RequestMapping(value = "/warntype/getWarnType", method = RequestMethod.GET)
//    Result<List<Map<String,Object>>> getWarnType();
//    /**
//     * 根据id查询预警类型信息
//     * @param id
//     * @return
//     */
//    @RequestMapping(value = "/warntype/getWarnTypeById", method = RequestMethod.GET)
//    Result<GxqptWarnTypeDTO> getById(@RequestParam(value = "id") Long id);
//    /**
//     * 添加预警类型信息
//     * @param gxqptWarnTypeDto
//     * @return
//     */
//    @RequestMapping(value = "/warntype/save", method = RequestMethod.GET)
//    Result<GxqptWarnTypeDTO> save(@RequestBody GxqptWarnTypeDTO gxqptWarnTypeDto);
//
//    /**
//     * 根据id编辑预警类型信息
//     * @param updateGxqptWarnTypeDto
//     * @return
//     */
//    @RequestMapping(value = "/warntype/updateById", method = RequestMethod.POST)
//    Result<UpdateGxqptWarnTypeDTO> update(@RequestBody UpdateGxqptWarnTypeDTO updateGxqptWarnTypeDto);
//
//    /**
//     * 查询预警类型编码
//     * @return
//     */
//    @RequestMapping(value = "/warntype/getCode", method = RequestMethod.GET)
//    int getCode(String code);
//
//    /**
//     * 根据ID禁用预警类型信息
//     * @param id
//     * @return
//     */
//    @RequestMapping(value = "/warntype/overdueById", method = RequestMethod.GET)
//    Result<String> overdueById(@RequestParam(value="id")Long id);
//    /**
//     * 描述：拖动预警类型
//     * 参数：currentId:拖动当前资源Id，
//     * 参数：locateId：1、如果拖动到非叶子节点下，则是非叶子节点Id，2、如果是拖动到叶子节点下，则是拖动到该位置的前一叶子节点Id
//     * 参数：type 拖动类型，用于拖动到文件夹下面最后位置或者拖动到文件夹下面的第一位置
//     * 返回值：Boolean
//     */
//    @RequestMapping(value = "/warntype/updateLocation", method = RequestMethod.POST)
//    //Result<String> updateById(@RequestParam(value="id")Long id,@RequestParam(value="parentId")Long parentId);
//    Result<Boolean> updateLocation(@RequestParam("currentId") Long currentId,Long locateId,String type);
//}
