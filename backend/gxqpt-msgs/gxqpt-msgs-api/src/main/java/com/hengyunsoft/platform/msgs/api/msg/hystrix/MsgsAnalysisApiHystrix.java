//package com.hengyunsoft.platform.msgs.api.msg.hystrix;
//
//import java.util.List;
//import java.util.Map;
//
//import org.springframework.stereotype.Component;
//
//import com.hengyunsoft.base.Result;
//import com.hengyunsoft.platform.msgs.api.msg.MsgsAnalysisApi;
//import com.hengyunsoft.platform.msgs.dto.msg.MsgActiveSendDTO;
//import com.hengyunsoft.platform.msgs.dto.msg.MsgAllChannelUsedDTO;
//import com.hengyunsoft.platform.msgs.dto.msg.MsgAnalysisChannelTypeDTO;
//import com.hengyunsoft.platform.msgs.dto.msg.MsgAnalysisChannelUsedDTO;
//import com.hengyunsoft.platform.msgs.dto.msg.MsgAnalysisHandleDTO;
//import com.hengyunsoft.platform.msgs.dto.msg.MsgAnalysisSendErrorDTO;
//import com.hengyunsoft.platform.msgs.dto.msg.MsgAnalysisSendExceptionDTO;
//@Component
//public class MsgsAnalysisApiHystrix implements MsgsAnalysisApi {
//
//	@Override
//	public Result<MsgAnalysisHandleDTO> getMsgHandleCount() {
//		return Result.timeout();
//	}
//
//	@Override
//	public Result<List<MsgAnalysisChannelUsedDTO>> getMsgChannelUsedCount() {
//		return Result.timeout();
//	}
//
//	@Override
//	public Result<MsgAnalysisChannelTypeDTO> getMsgPersonalChannelTypeCount() {
//		return Result.timeout();
//	}
//
//	@Override
//	public Result<MsgAnalysisChannelTypeDTO> getMsgAllChannelTypeCount() {
//		return Result.timeout();
//	}
//
//	@Override
//	public Result<List<MsgAnalysisSendErrorDTO>> getMsgSendErrorTop10(String type) {
//		return Result.timeout();
//	}
//
//	@Override
//	public Result<Map<String,List<MsgAnalysisSendExceptionDTO>>> getMsgSendExceptionCount() {
//		return Result.timeout();
//	}
//
//	@Override
//	public Result<Map<String,List<MsgAllChannelUsedDTO>>> getMsgAllChannelUsedCount() {
//		return Result.timeout();
//	}
//
//	@Override
//	public Result<List<MsgAnalysisSendErrorDTO>> getWechatExceptionTop10() {
//		return Result.timeout();
//	}
//
//	@Override
//	public Result<List<MsgAnalysisSendErrorDTO>> getBlogExceptionTop10() {
//		return Result.timeout();
//	}
//
//	@Override
//	public Result<List<MsgAnalysisSendErrorDTO>> getMobileExceptionTop10() {
//		return Result.timeout();
//	}
//
//	@Override
//	public Result<List<MsgAnalysisSendErrorDTO>> getPublicExceptionTop10() {
//		return Result.timeout();
//	}
//
//	@Override
//	public Result<List<MsgAnalysisSendErrorDTO>> getPublisherSendTop10() {
//		return Result.timeout();
//	}
//
//	@Override
//	public Result<List<MsgAnalysisSendErrorDTO>> getGxqptSendTop10() {
//		return Result.timeout();
//	}
//
//	@Override
//	public Result<List<MsgActiveSendDTO>> getActivePublisherSendCount(String appId) {
//		return Result.timeout();
//	}
//
//}
