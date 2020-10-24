//package com.hengyunsoft.platform.standard.api;
//
//import java.text.ParseException;
//import java.util.List;
//
//import org.springframework.cloud.netflix.feign.FeignClient;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;
//
//import com.hengyunsoft.base.Result;
//import com.hengyunsoft.platform.standard.api.hystrix.StandardCassifyApiHystrix;
//import com.hengyunsoft.platform.standard.dto.StandardAnalysisTopFileDTO;
//import com.hengyunsoft.platform.standard.dto.StandardAnalysisTreeDTO;
//import com.hengyunsoft.platform.standard.dto.StandardDownloadDTO;
//import com.hengyunsoft.platform.standard.dto.StandardHandleAnalysisDTO;
//import com.hengyunsoft.platform.standard.dto.StandardMonthDTO;
//import com.hengyunsoft.platform.standard.dto.StandardTypeDTO;
//import com.hengyunsoft.platform.standard.dto.UploadCompanyDTO;
//
///**
// * 标准文档分析API接口
// * fallback: 实现服务降级处理逻辑。
// * 调用过程中，出现错误、超时、线程池拒绝、断路器熔断等情况时，执行fallback中的方法
// */
//@FeignClient(name = "${gxqpt.gate.feign.server:gaxq-gate-server}", path = "/api/standard", fallback = StandardCassifyApiHystrix.class)
//public interface StandardAnalysisApi {
//
//    /**
//     * 查看月下载TOP10文档列表
//     *
//     * @param yyyyMM
//     * @return
//     */
//    @RequestMapping(value = "/analysis/month/top10", method = RequestMethod.POST)
//    Result<List<StandardAnalysisTopFileDTO>> statMonthTop10(@RequestParam(value = "yyyyMM") String yyyyMM) throws ParseException;
//    /**
//     * 查看年下载TOP10文档列表
//     *
//     * @param yyyy
//     * @return
//     */
//    @RequestMapping(value = "/analysis/year/top10", method = RequestMethod.POST)
//    Result<List<StandardAnalysisTopFileDTO>> statYearTop10(@RequestParam(value = "yyyy") String yyyy) throws ParseException;
//    /**
//     * 按分类统计文档下载量
//     *
//     * @param
//     * @return
//     */
//    @RequestMapping(value = "/analysis/classify", method = RequestMethod.POST)
//    Result<List<StandardAnalysisTreeDTO>> statByClassify(@RequestParam(value = "yyyyMM") String yyyyMM,@RequestParam(value = "parentId") String parentId) throws ParseException;
//
//
//
//    /**
//     * 首页获取本月标准各操作数量
//     * @return
//     */
//    @RequestMapping(value = "/home/statHandle/nums", method = RequestMethod.GET)
//    Result<StandardHandleAnalysisDTO> statHandleNums();
//    /**
//     * 标准上传单位TOP10
//     * @return
//     */
//    @RequestMapping(value = "/home/uploadCompany/top10", method = RequestMethod.GET)
//    Result<List<UploadCompanyDTO>> uploadCompanyTop10();
//    /**
//     * 类别标准数量TOP5（按类型分类）
//     * @return
//     */
//    @RequestMapping(value = "/home/statType/top5", method = RequestMethod.GET)
//    Result<List<StandardTypeDTO>> statTypeTop5();
//    /**
//     * 标准文档下载数量TOP20
//     * @return
//     */
//    @RequestMapping(value = "/home/downLoad/top20", method = RequestMethod.GET)
//    Result<List<StandardDownloadDTO>> statDownloadTop20();
//    /**
//     * 标准分类分析
//     * @return
//     */
//    @RequestMapping(value = "/home/statType/analysis", method = RequestMethod.GET)
//    Result<List<StandardDownloadDTO>> statTypeAnalysis();
//    /**
//     * XX标准文档下载数量TOP10
//     * @return
//     */
//    @RequestMapping(value = "/chaild/download/top10", method = RequestMethod.GET)
//    Result<List<StandardDownloadDTO>> statDownloadTop10(@RequestParam(value="typeId") Long typeId);
//    /**
//     * XX标准数量分析
//     * @return
//     */
//    @RequestMapping(value = "/chaild/type/count", method = RequestMethod.GET)
//    Result<List<StandardMonthDTO>> statTypeCount(@RequestParam(value="typeId") Long typeId);
//    /**
//     * XX标准文档下载趋势
//     * @return
//     */
//    @RequestMapping(value = "/chaild/download/trend", method = RequestMethod.GET)
//    Result<List<StandardMonthDTO>> statDownloadTrend(@RequestParam(value="typeId") Long typeId);
//    /**
//     * XX标准文档上传单位top10
//     * @return
//     */
//    @RequestMapping(value = "/chaild/uploadCompany/top10", method = RequestMethod.GET)
//    Result<List<UploadCompanyDTO>> statUploadCompanyTop10(@RequestParam(value="typeId") Long typeId);
//}
