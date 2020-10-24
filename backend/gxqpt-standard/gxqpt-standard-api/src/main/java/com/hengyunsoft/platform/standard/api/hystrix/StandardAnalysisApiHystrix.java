//package com.hengyunsoft.platform.standard.api.hystrix;
//
//import com.hengyunsoft.base.Result;
//import com.hengyunsoft.platform.standard.api.StandardAnalysisApi;
//import com.hengyunsoft.platform.standard.dto.*;
//import org.springframework.stereotype.Component;
//
//import java.text.ParseException;
//import java.util.List;
//
//@Component
//public class StandardAnalysisApiHystrix implements StandardAnalysisApi {
//
//
//    /**
//     * 查看月下载TOP10文档列表
//     *
//     * @param yyyyMM
//     * @return
//     */
//    @Override
//    public Result<List<StandardAnalysisTopFileDTO>> statMonthTop10(String yyyyMM) throws ParseException {
//        return Result.timeout();
//    }
//
//    /**
//     * 查看年下载TOP10文档列表
//     *
//     * @param yyyy
//     * @return
//     */
//    @Override
//    public Result<List<StandardAnalysisTopFileDTO>> statYearTop10(String yyyy) throws ParseException {
//        return Result.timeout();
//    }
//
//    /**
//     * 按分类统计文档下载量
//     *
//     * @param yyyyMM@return
//     */
//    @Override
//    public Result<List<StandardAnalysisTreeDTO>> statByClassify(String yyyyMM,String parentId) throws ParseException {
//        return Result.timeout();
//    }
//
//	@Override
//	public Result<StandardHandleAnalysisDTO> statHandleNums() {
//		return Result.timeout();
//	}
//
//	@Override
//	public Result<List<UploadCompanyDTO>> uploadCompanyTop10() {
//		return Result.timeout();
//	}
//
//	@Override
//	public Result<List<StandardTypeDTO>> statTypeTop5() {
//		return Result.timeout();
//	}
//
//	@Override
//	public Result<List<StandardDownloadDTO>> statDownloadTop20() {
//		return Result.timeout();
//	}
//
//	@Override
//	public Result<List<StandardDownloadDTO>> statTypeAnalysis() {
//		return Result.timeout();
//	}
//
//	@Override
//	public Result<List<StandardDownloadDTO>> statDownloadTop10(Long typeId) {
//		return Result.timeout();
//	}
//
//	@Override
//	public Result<List<StandardMonthDTO>> statTypeCount(Long typeId) {
//		return Result.timeout();
//	}
//
//	@Override
//	public Result<List<StandardMonthDTO>> statDownloadTrend(Long typeId) {
//		return Result.timeout();
//	}
//
//	@Override
//	public Result<List<UploadCompanyDTO>> statUploadCompanyTop10(Long typeId) {
//		return Result.timeout();
//	}
//}
