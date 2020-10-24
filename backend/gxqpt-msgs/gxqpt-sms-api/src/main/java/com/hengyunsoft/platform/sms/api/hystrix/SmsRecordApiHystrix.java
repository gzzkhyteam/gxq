package com.hengyunsoft.platform.sms.api.hystrix;

import com.github.pagehelper.PageInfo;
import com.hengyunsoft.base.Result;
import com.hengyunsoft.page.plugins.openapi.OpenApiReq;
import com.hengyunsoft.platform.msgs.dto.msg.MessageDTO;
import com.hengyunsoft.platform.msgs.dto.msg.MsgsContactOftenDTO;
import com.hengyunsoft.platform.sms.api.SmsRecordApi;
import com.hengyunsoft.platform.sms.dto.QuerySmsExtRecordDTO;
import com.hengyunsoft.platform.sms.dto.QuerySmsRecordDTO;
import com.hengyunsoft.platform.sms.dto.SmsChannelDTO;
import com.hengyunsoft.platform.sms.dto.SmsRecordDTO;
import com.hengyunsoft.platform.sms.dto.SmsRecordDetailDTO;
import com.hengyunsoft.platform.sms.dto.SmsRecordPageResDTO;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SmsRecordApiHystrix implements SmsRecordApi {

    public Result<SmsRecordDetailDTO> getSmsRecordDetail(String msgId) {
        return Result.timeout();
    }

    public Result<String> addSmsRecord(MessageDTO messageDTO) {
        return Result.timeout();
    }

    public Result<List<SmsChannelDTO>> getSmsChannelList(String appId) {
        return Result.timeout();
    }

    public Result<String> deleteSmsDraft(String recordIds) {
        return Result.timeout();
    }

    public Result<String> deleteSmsDraftById(Long recordId) {
        return Result.timeout();
    }

    public Result<String> updateSmsRecord(Long id, MessageDTO messageDTO) {
        return Result.timeout();
    }

    public Result<PageInfo<SmsRecordDTO>> pageSmsRecordList(
            OpenApiReq<QuerySmsRecordDTO> querySmsRecordDTO) {
        return Result.timeout();
    }

    @Override
    public Result<String> deleteById(Long id) {
        return Result.timeout();
    }

    public Result<PageInfo<SmsRecordPageResDTO>> pageSmsRecordExtList(OpenApiReq<QuerySmsExtRecordDTO> openApiReq) {
        return Result.timeout();
    }

    @Override
    public Result<PageInfo<MsgsContactOftenDTO>> getIdPhonenum(String contact) {
        return Result.timeout();
    }

    @Override
    public Result<Boolean> getSendPhonenum(String contact) {
        return Result.timeout();
    }

    @Override
    public Result<Boolean> deleteContactByIds(String contactIds) {
        return Result.timeout();
    }
}
