//package com.hengyunsoft.platform.modular.api;
//
//import java.text.ParseException;
//import java.util.List;
//
//import org.springframework.cloud.netflix.feign.FeignClient;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//
//import com.hengyunsoft.base.Result;
//import com.hengyunsoft.platform.commons.config.FeignConfiguration;
//import com.hengyunsoft.platform.modular.api.hystrix.ModularAnalysisApiHystrix;
//import com.hengyunsoft.platform.modular.dto.HotSupportDTO;
//import com.hengyunsoft.platform.modular.dto.HotSupportListDTO;
//import com.hengyunsoft.platform.modular.dto.ModularAnalysisCategoryTopDTO;
//import com.hengyunsoft.platform.modular.dto.ModularDiscardedNumDTO;
//import com.hengyunsoft.platform.modular.dto.ModularDownloadNumDTO;
//import com.hengyunsoft.platform.modular.dto.ModularDownloadTopDTO;
//import com.hengyunsoft.platform.modular.dto.ModularHandleAnalysisDTO;
//import com.hengyunsoft.platform.modular.dto.ModularNewestDTO;
//import com.hengyunsoft.platform.modular.dto.ModularNumDTO;
//import com.hengyunsoft.platform.modular.dto.ModularRepertoriesTopDTO;
//
///**
// * @author wangs
// * @createTime 2018-4-03
// */
//@FeignClient(name = "${gxqpt.gate.feign.server:gaxq-gate-server}", configuration = FeignConfiguration.class, path = "/api/modular", fallback = ModularAnalysisApiHystrix.class)
//public interface ModularAnalysisApi {
//
//    /**
//     * 下载量最多的CategoryTop10
//     *
//     * @return
//     */
//    @RequestMapping(value = "/analysis/category/down/top10", method = RequestMethod.POST)
//    Result<List<ModularAnalysisCategoryTopDTO>> findCategoryDownTop10();
//
//    /**
//     * 使用量最多的模块Top10
//     *
//     * @return
//     */
//    @RequestMapping(value = "/analysis/modular/down/top10", method = RequestMethod.POST)
//    Result<List<ModularDownloadTopDTO>> findModularDownTop10();
//
//    /**
//     * 模块数量最多的库排行
//     *
//     * @return
//     */
//    @RequestMapping(value = "/analysis/repository/top10", method = RequestMethod.POST)
//    Result<List<ModularRepertoriesTopDTO>> findRepositoryTop10();
//
//    /*  =====================================  模块使用分析 =================================*/
//
//    /**
//     * 活跃提供商榜
//     */
//    @RequestMapping(value = "/analysis/supplier/top10", method = RequestMethod.POST)
//    Result<List<HotSupportDTO>> findSupplierTop10() throws ParseException;
//
//    /**
//     * 模块活跃度榜
//     */
//    @RequestMapping(value = "/analysis/modular/updateFrequency/top10", method = RequestMethod.POST)
//    Result<List<HotSupportDTO>> findModularUpdateFrequencyTop10() throws ParseException;
//
//
//    /**
//     * 新模块榜
//     */
//    @RequestMapping(value = "/analysis/modular/lastUpload/top10", method = RequestMethod.POST)
//    Result<List<HotSupportDTO>> findModularLastUploadTop10() throws ParseException;
//
//    /*  =====================================  新增模块分析 =================================*/
//
//    /**
//     * 模块各操作统计
//     */
//    @RequestMapping(value = "/home/handle/count", method = RequestMethod.GET)
//    Result<ModularHandleAnalysisDTO> getModularHandle();
//    /**
//     * 模块数量分析
//     */
//    @RequestMapping(value = "/home/num/analysis", method = RequestMethod.GET)
//    Result<List<ModularNumDTO>> getModularNum();
//    /**
//     * 废弃模块数
//     */
//    @RequestMapping(value = "/home/discarded/num", method = RequestMethod.GET)
//    Result<List<ModularDiscardedNumDTO>> getModularDiscardedNum();
//    /**
//     * 新模块榜(最近半年)
//     */
//    @RequestMapping(value = "/home/newest/ranking", method = RequestMethod.GET)
//    Result<List<ModularNewestDTO>> getModularNewestRanking();
//    /**
//     * 模块下载top20
//     */
//    @RequestMapping(value = "/home/download/num", method = RequestMethod.GET)
//    Result<List<ModularDownloadNumDTO>> getModularDownloadTop20();
//
//    /**
//     * 活跃提供商列表
//     */
//    @RequestMapping(value = "/used/supplier/top10", method = RequestMethod.GET)
//    Result<List<HotSupportListDTO>> getSupplierListTop10();
//}
