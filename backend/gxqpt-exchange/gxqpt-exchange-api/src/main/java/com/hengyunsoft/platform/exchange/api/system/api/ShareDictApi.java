//package com.hengyunsoft.platform.exchange.api.system.api;
//
//import com.hengyunsoft.base.Result;
//import com.hengyunsoft.platform.exchange.api.system.api.hystrix.ShareDictApiHystrix;
//import com.hengyunsoft.platform.exchange.api.system.dto.ShareRequestDictDTO;
//import com.hengyunsoft.platform.exchange.api.system.dto.ShareRequestUpdateDictDTO;
//import com.hengyunsoft.platform.exchange.api.system.dto.ShareResponseDictDTO;
//import org.springframework.cloud.netflix.feign.FeignClient;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;
//
//import java.util.List;
//
///**
// * com.hengyunsoft.platform.exchange.api.system.api
// * 版权：中科恒运软件科技股份有限公司贵阳分公司
// * 描述：数据字典API
// * 修改人：wt
// * 修改时间：2018/4/23
// * 修改内容：新增基础接口
// */
//@FeignClient(name = "${gxqpt.gate.feign.server:gxqpt-exchange-server}",
//         path = "/api/exchange",
//        fallback = ShareDictApiHystrix.class)
//public interface ShareDictApi {
//    /**
//     * @todo 查询数据字典
//     * @param pId 父编码
//     * @return List<ShareResponseDictDTO>
//     * @Author wt
//     * @createtime 2018-4-23
//     */
//    @RequestMapping(value = "/dict/findByDictCode", method = RequestMethod.POST)
//    Result<List<ShareResponseDictDTO>> findByDictCode(@RequestParam("pId") String pId);
//
//    /**
//     * @todo 保存数据字典
//     * @param dto
//     * @return ShareResponseDictDTO
//     * @Author wt
//     * @createtime 2018-4-23
//     */
//    @RequestMapping(value = "/system/saveDict", method = RequestMethod.POST)
//    Result<ShareResponseDictDTO> saveDict(@RequestBody ShareRequestDictDTO dto);
//
//    /**
//     * @todo 删除数据字典
//     * @param id
//     * @return Boolean
//     * @Author wt
//     * @createtime 2018-4-23
//     */
//    @RequestMapping(value = "/system/deleteDictById", method = RequestMethod.GET)
//    Result<Boolean> deleteDictById(@RequestParam("id") Long id);
//
//    /**
//     * @todo 更新数据字典
//     * @param
//     * @return ShareResponseDictDTO
//     * @Author wt
//     * @createtime 2018-4-23
//     */
//    @RequestMapping(value = "/system/updateDict", method = RequestMethod.POST)
//    Result<ShareResponseDictDTO> updateDict(@RequestBody ShareRequestUpdateDictDTO dto);
//}
