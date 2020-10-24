//package com.hengyunsoft.platform.exchange.api.overview.api;
//
//import com.github.pagehelper.PageInfo;
//import com.hengyunsoft.base.Result;
//import com.hengyunsoft.page.plugins.openapi.OpenApiReq;
//import com.hengyunsoft.platform.exchange.api.dataapi.dto.dataapi.ApiReturnDataDTO;
//import com.hengyunsoft.platform.exchange.api.overview.api.hystrix.DataOverviewApiHystrix;
//import com.hengyunsoft.platform.exchange.api.overview.dto.*;
//import com.hengyunsoft.platform.exchange.api.screen.dto.ScreenDataCountDTO;
//import org.springframework.cloud.netflix.feign.FeignClient;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//
//import java.util.List;
//import java.util.Map;
//
///**
// * @TODO: 数据概览接口
// * fallback: 实现服务降级处理逻辑。
// * 调用过程中，出现错误、超时、线程池拒绝、断路器熔断等情况时，执行fallback中的方法
// * @author wgj
// * @createTime 2018-04-21 14:42
// */
//@FeignClient(name = "${gxqpt.gate.feign.server:gxqpt-gate-server}",
//        path = "/api/exchange",
//        fallback = DataOverviewApiHystrix.class)
//public interface DataOverviewApi {
//    /**
//     *查询首页统计数据
//     * 包含接入部门，数据目录，数据集，API,访问量，调用次数
//     * @return
//     * @Author wgj
//     * @createtime 2018-05-01
//     */
//    @RequestMapping(value = "/overview/getShareDataCount", method = RequestMethod.POST)
//    public Result<ScreenDataCountDTO>  getShareDataCount();
//    /**
//     * @todo 根据业务类型查询数据量
//     * @param  openApiReq 业务编码
//     * @return boolean
//     * @Author wgj
//     * @createtime 2018-4-22
//     */
//    @RequestMapping(value = "/overview/getBusDataList", method = RequestMethod.POST)
//    Result<PageInfo<DirOrgDTO>> getBusDataList(@RequestBody OpenApiReq<DirOrgDTO> openApiReq);
//
//
//    /**
//     * @todo 根据业务类型查询元目录
//     * @param  业务编码
//     * @param 分页参数
//     * @return boolean
//     * @Author wgj
//     * @createtime 2018-4-22
//     */
//    @RequestMapping(value = "/overview/getBottomDirList", method = RequestMethod.POST)
//    Result<PageInfo<DirViewDTO>> getBottomDirList(@RequestBody OpenApiReq<DirOrgDTO> openApiReq);
//
//    /**
//     * @todo 根据元目录id查询详情
//     * @param  id 元目录id
//     * @return boolean
//     * @Author wgj
//     * @createtime 2018-4-22
//     */
//    @RequestMapping(value = "/overview/getDirView", method = RequestMethod.GET)
//    Result<DirViewDTO> getDirView(String id);
//
//    /**
//     * @todo 根据元目录id查询Api
//     * @param  openApiReq 元目录id
//     * @return boolean
//     * @Author wgj
//     * @createtime 2018-4-22
//     */
//    @RequestMapping(value = "/overview/getApiList", method = RequestMethod.POST)
//    Result<PageInfo<ApiViewDTO>> getApiList(@RequestBody OpenApiReq<DirViewDTO> openApiReq);
//
//    /**
//     * @todo 热门TOP10API
//     * @Author wgj
//     * @createtime 2018-4-22
//     */
//    @RequestMapping(value = "/overview/getHostApi", method = RequestMethod.POST)
//    Result<List<ApiReturnDataDTO>> getHostApi();
//    /**
//     * @todo 查询部门
//     * @Author wgj
//     * @createtime 2018-4-22
//     */
//    @RequestMapping(value = "/overview/getOrgList", method = RequestMethod.POST)
//    Result<List<OrgDTO>> getOrgList();
//    /**
//     * @todo 更新元目录的查看次数
//     * @param  id 元目录id
//     * @return boolean
//     * @Author wgj
//     * @createtime 2018-4-22
//     */
//    @RequestMapping(value = "/overview/updateSeeCount", method = RequestMethod.GET)
//    public Result<Boolean> updateSeeCount(String id);
//
//    /**
//     * @todo根据类型查询api量及数据集量
//     * @param busCode 业务编码
//     * @param unitId  单位id
//     * @return boolean
//     * @Author wgj
//     * @createtime 2018-4-22
//     */
//    @RequestMapping(value = "/overview/getApiSetCount", method = RequestMethod.GET)
//    public Result<Map<String,Integer>> getApiSetCount(String busCode, String unitId);
//
//
//    /**
//     * 描述：根据概览中基础库、主题库、专题库进行分类查询元目录
//     * 参数：
//     * 返回值：
//     * 修改人：zhaopengfei
//     * 修改时间：2018/8/23
//     * 修改内容：
//     */
//    @RequestMapping(value = "/overview/getBottomDirListByType", method = RequestMethod.POST)
//    Result<PageInfo<DirViewDTO>> getBottomDirListByType(@RequestBody OpenApiReq<DirOrgDTO> openApiReq);
//
//   /**
//    * 描述：根据业务类型查询api总量
//    * 参数：busCode 类型编码
//    * 返回值：Map<String,Integer>
//    * 修改人：zhaopengfei
//    * 修改时间：2018/8/24
//    * 修改内容：
//    */
//    @RequestMapping(value = "/overview/getApiCountByType", method = RequestMethod.GET)
//    public Result<Map<String,Integer>> getApiCountByType(String busCode,String busKey);
//}
