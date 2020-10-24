//package com.hengyunsoft.platform.standard.api;
//
//import com.hengyunsoft.base.Result;
//import com.hengyunsoft.platform.standard.api.hystrix.StandardCassifyApiHystrix;
//import com.hengyunsoft.platform.standard.dto.StandardClassifyDTO;
//import com.hengyunsoft.platform.standard.dto.StandardClassifySaveDTO;
//import com.hengyunsoft.platform.standard.dto.StandardClassifyTreeDTO;
//import com.hengyunsoft.platform.standard.dto.StandardClassifyUpdateDTO;
//import org.springframework.cloud.netflix.feign.FeignClient;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;
//
//import java.util.List;
//
///**
// * 标准分类API接口
// * fallback: 实现服务降级处理逻辑。
// * 调用过程中，出现错误、超时、线程池拒绝、断路器熔断等情况时，执行fallback中的方法
// */
//@FeignClient(name = "${gxqpt.gate.feign.server:gaxq-gate-server}", path = "/api/standard", fallback = StandardCassifyApiHystrix.class)
//public interface StandardClassifyApi {
//    /**
//     * 根据id 查看分类详情
//     *
//     * @param id
//     * @return
//     */
//    @RequestMapping(value = "/classify/get", method = RequestMethod.GET)
//    Result<StandardClassifyDTO> get(@RequestParam(value = "id") Long id);
//
//    /**
//     * 保存标准分类
//     *
//     * @param
//     */
//    @RequestMapping(value = "/classify/save", method = RequestMethod.POST)
//    Result<StandardClassifyDTO> save(@RequestBody StandardClassifySaveDTO standardClassifySaveDTO);
//
//    /**
//     * 更新标准分类
//     *
//     * @param
//     */
//    @RequestMapping(value = "/classify/update", method = RequestMethod.POST)
//    Result<Boolean> update(@RequestBody StandardClassifyUpdateDTO standardClassifyUpdateDTO);
//
//    /**
//     * 根据id 删除
//     *
//     * @param id
//     * @return
//     */
//    @RequestMapping(value = "/classify/delete", method = RequestMethod.GET)
//    Result<Boolean> delete(@RequestParam(value = "id") Long id);
//
//
//    /**
//     * 描述：获取标准分类树
//     * 返回值：标准分类树形结构
//     */
//    @RequestMapping(value = "/classify/getTree", method = RequestMethod.GET)
//    Result<List<StandardClassifyTreeDTO>> getTree(@RequestParam(value = "id") Long id);
//
//    /**
//     * 描述：获取运维文档的分类树
//     * 返回值：运维文档树形结构
//     */
//    @RequestMapping(value = "/classify/getYunWeiTree", method = RequestMethod.GET)
//    Result<List<StandardClassifyTreeDTO>> getYunWeiTree();
//
//}
