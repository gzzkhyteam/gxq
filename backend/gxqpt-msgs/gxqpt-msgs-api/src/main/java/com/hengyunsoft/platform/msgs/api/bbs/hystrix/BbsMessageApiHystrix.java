package com.hengyunsoft.platform.msgs.api.bbs.hystrix;
import org.springframework.stereotype.Component;

import com.github.pagehelper.PageInfo;
import com.hengyunsoft.base.Result;
import com.hengyunsoft.page.plugins.openapi.OpenApiReq;
import com.hengyunsoft.platform.msgs.api.bbs.BbsMessageApi;
import com.hengyunsoft.platform.msgs.dto.bbs.BbsAllMainMsgSaveReqDTO;
import com.hengyunsoft.platform.msgs.dto.bbs.BbsAllMainMsgSaveResDTO;
import com.hengyunsoft.platform.msgs.dto.bbs.BbsAllMsgReqDTO;
import com.hengyunsoft.platform.msgs.dto.bbs.BbsAllMsgResDTO;
import com.hengyunsoft.platform.msgs.dto.bbs.BbsMsgDetailResDTO;
import com.hengyunsoft.platform.msgs.dto.bbs.BbsNotReadMsgReqDTO;
import com.hengyunsoft.platform.msgs.dto.bbs.BbsNotReadMsgResDTO;
import com.hengyunsoft.platform.msgs.dto.bbs.UpdateBacklogReqDTO;

@Component
public class BbsMessageApiHystrix implements BbsMessageApi {

    @Override
    public Result<PageInfo<BbsAllMsgResDTO>> getAllMsg(OpenApiReq<BbsAllMsgReqDTO> openApiReq) {
        return Result.timeout();
    }

    @Override
    public Result<PageInfo<BbsAllMsgResDTO>> getReadMsg(OpenApiReq<BbsAllMsgReqDTO> openApiReq) {
        return Result.timeout();
    }

    @Override
    public Result<BbsMsgDetailResDTO> getDetailById(Long msgId) {
        return Result.timeout();
    }

    @Override
    public Result<BbsMsgDetailResDTO> getRecentMsgAndNotReadNum(Long userId) {
        return Result.timeout();
    }

    @Override
    public Result<PageInfo<BbsNotReadMsgResDTO>> getNotReadMsg(OpenApiReq<BbsNotReadMsgReqDTO> openApiReq) {
        return Result.timeout();
    }

    @Override
    public Result<Boolean> updateMsgsReaded(Long[] ids) {
        return Result.timeout();
    }

    @Override
    public Result<Boolean> deleteById(Long[] ids) {
        return Result.timeout();
    }

    @Override
    public Result<Boolean> updateBacklog(UpdateBacklogReqDTO updateBacklogReqDTO) {
        return Result.timeout();
    }

    @Override
    public Result<BbsAllMainMsgSaveResDTO> saveMsg(BbsAllMainMsgSaveReqDTO bbsAllMainMsgSaveReqDTO) {
        return Result.timeout();
    }

	@Override
	public Result<String> updateToReadedAndGetUrl(Long msgId) {
		return Result.timeout();
	}

}


