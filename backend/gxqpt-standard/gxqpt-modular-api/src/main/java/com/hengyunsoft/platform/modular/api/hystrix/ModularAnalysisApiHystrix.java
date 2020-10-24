//package com.hengyunsoft.platform.modular.api.hystrix;
//
//import java.text.ParseException;
//import java.util.List;
//
//import org.springframework.stereotype.Component;
//
//import com.hengyunsoft.base.Result;
//import com.hengyunsoft.platform.modular.api.ModularAnalysisApi;
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
//@Component
//public class ModularAnalysisApiHystrix implements ModularAnalysisApi {
//
//
//    /**
//     * 下载量最多的CategoryTop10
//     *
//     * @return
//     */
//    @Override
//    public Result<List<ModularAnalysisCategoryTopDTO>> findCategoryDownTop10() {
//        return Result.timeout();
//    }
//
//    /**
//     * 使用量最多的模块Top10
//     *
//     * @return
//     */
//    @Override
//    public Result<List<ModularDownloadTopDTO>> findModularDownTop10() {
//        return Result.timeout();
//    }
//
//    /**
//     * 模块数量最多的库排行
//     *
//     * @return
//     */
//    @Override
//    public Result<List<ModularRepertoriesTopDTO>> findRepositoryTop10() {
//        return Result.timeout();
//    }
//
//    /**
//     * 活跃提供商榜
//     */
//    @Override
//    public Result<List<HotSupportDTO>> findSupplierTop10() throws ParseException {
//        return Result.timeout();
//    }
//
//    /**
//     * 模块活跃度榜
//     */
//    @Override
//    public Result<List<HotSupportDTO>> findModularUpdateFrequencyTop10() throws ParseException {
//        return Result.timeout();
//    }
//
//    /**
//     * 新模块榜
//     */
//    @Override
//    public Result<List<HotSupportDTO>> findModularLastUploadTop10() throws ParseException {
//        return Result.timeout();
//    }
//
//	@Override
//	public Result<ModularHandleAnalysisDTO> getModularHandle() {
//		return Result.timeout();
//	}
//
//	@Override
//	public Result<List<ModularNumDTO>> getModularNum() {
//		return Result.timeout();
//	}
//
//	@Override
//	public Result<List<ModularDiscardedNumDTO>> getModularDiscardedNum() {
//		return Result.timeout();
//	}
//
//	@Override
//	public Result<List<ModularNewestDTO>> getModularNewestRanking() {
//		return Result.timeout();
//	}
//
//	@Override
//	public Result<List<ModularDownloadNumDTO>> getModularDownloadTop20() {
//		return Result.timeout();
//	}
//
//	@Override
//	public Result<List<HotSupportListDTO>> getSupplierListTop10() {
//		return Result.timeout();
//	}
//}
