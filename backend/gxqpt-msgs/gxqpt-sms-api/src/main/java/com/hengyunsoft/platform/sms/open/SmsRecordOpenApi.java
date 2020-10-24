package com.hengyunsoft.platform.sms.open;

import java.util.List;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.pagehelper.PageInfo;
import com.hengyunsoft.base.Result;
import com.hengyunsoft.page.plugins.openapi.OpenApiReq;
import com.hengyunsoft.platform.sms.dto.QuerySmsRecordDTO;
import com.hengyunsoft.platform.sms.dto.SmsChannelDTO;
import com.hengyunsoft.platform.sms.dto.SmsRecordDTO;
import com.hengyunsoft.platform.sms.dto.SmsRecordDetailDTO;
import com.hengyunsoft.platform.sms.open.hystrix.SmsRecordOpenApiHystrix;

/**
 * 短信记录服务
 * @author dxz
 */
@FeignClient(name = "${gxqpt.feign.msgs-server:gxqpt-gate-server}",path = "/api/sms",
fallback = SmsRecordOpenApiHystrix.class)
public interface SmsRecordOpenApi {
    /**
     * 查询短信记录列表、草稿箱列表
     * @return
     */
    @RequestMapping(value = "/p/smsrecord/list", method = RequestMethod.POST)
    Result<PageInfo<SmsRecordDTO>> pageSmsRecordList(@RequestBody OpenApiReq<QuerySmsRecordDTO> querySmsRecordDTO);
    /**
     * 查询短信记录详情、草稿详情
     * @return
     */
    @RequestMapping(value = "/p/smsrecord/detail", method = RequestMethod.GET)
    Result<SmsRecordDetailDTO> getSmsRecordDetail(@RequestParam(value = "msgId") String msgId);   
    /**
     * 查询短信渠道
     */
    @RequestMapping(value = "/p/smschannel/list", method = RequestMethod.GET)
    Result<List<SmsChannelDTO>> getSmsChannelList(@RequestParam(value = "appId") String appId);   
    /**
     * 删除草稿
     */
    @RequestMapping(value = "/p/smsdraft/delete", method = RequestMethod.GET)
    Result<String> deleteSmsDraftById(@RequestParam(value = "recordId") Long recordId);
}
