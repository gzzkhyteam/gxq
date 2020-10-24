package com.hengyunsoft.platform.sms.api;

import com.github.pagehelper.PageInfo;
import com.hengyunsoft.base.Result;
import com.hengyunsoft.page.plugins.openapi.OpenApiReq;
import com.hengyunsoft.platform.msgs.dto.msg.MessageDTO;
import com.hengyunsoft.platform.msgs.dto.msg.MsgsContactOftenDTO;
import com.hengyunsoft.platform.sms.api.hystrix.SmsRecordApiHystrix;
import com.hengyunsoft.platform.sms.dto.QuerySmsExtRecordDTO;
import com.hengyunsoft.platform.sms.dto.QuerySmsRecordDTO;
import com.hengyunsoft.platform.sms.dto.SmsChannelDTO;
import com.hengyunsoft.platform.sms.dto.SmsRecordDTO;
import com.hengyunsoft.platform.sms.dto.SmsRecordDetailDTO;
import com.hengyunsoft.platform.sms.dto.SmsRecordPageResDTO;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * 短信记录服务
 *
 * @author dxz
 */
@FeignClient(name = "${gxqpt.feign.msgs-server:gxqpt-gate-server}", fallback = SmsRecordApiHystrix.class)
public interface SmsRecordApi {
    /**
     * 查询短信记录列表、草稿箱列表
     *
     * @return
     */
    @RequestMapping(value = "/api/smsrecord/list", method = RequestMethod.POST)
    Result<PageInfo<SmsRecordDTO>> pageSmsRecordList(@RequestBody OpenApiReq<QuerySmsRecordDTO> querySmsRecordDTO);

    /**
     * 删除短信记录
     */
    @RequestMapping(value = "/api/smsrecord/deleteById", method = RequestMethod.POST)
    Result<String> deleteById(@RequestParam(value = "id") Long id);

    /**
     * 获取短信记录分页列表
     *
     * @return
     */
    @RequestMapping(value = "/api/smsrecord/ext/list", method = RequestMethod.POST)
    Result<PageInfo<SmsRecordPageResDTO>> pageSmsRecordExtList(@RequestBody OpenApiReq<QuerySmsExtRecordDTO> openApiReq);

    /**
     * 查询短信记录详情、草稿详情
     *
     * @return
     */
    @RequestMapping(value = "/api/smsrecord/detail", method = RequestMethod.GET)
    Result<SmsRecordDetailDTO> getSmsRecordDetail(@RequestParam(value = "msgId") String msgId);

    /**
     * 新建发送、保存草稿、定时发送
     */
    @RequestMapping(value = "/api/smsrecord/add", method = RequestMethod.POST)
    Result<String> addSmsRecord(@RequestBody MessageDTO messageDTO);

    /**
     * 编辑草稿
     */
    @RequestMapping(value = "/api/smsrecord/update", method = RequestMethod.POST)
    Result<String> updateSmsRecord(@RequestParam(value = "id") Long id, @RequestBody MessageDTO messageDTO);

    /**
     * 查询短信渠道
     */
    @RequestMapping(value = "/api/smschannel/list", method = RequestMethod.GET)
    Result<List<SmsChannelDTO>> getSmsChannelList(@RequestParam(value = "appId") String appId);
    /**
     * 查询组织架构：调用其他服务，不在本服务写
     */

    /**
     * 查询常用联系人：调用其他服务，不在本服务写
     */

    /**
     * 批量删除草稿
     */
    @RequestMapping(value = "/api/smsdrafts/delete", method = RequestMethod.GET)
    Result<String> deleteSmsDraft(@RequestParam(value = "recordIds") String recordIds);

    /**
     * 删除草稿
     */
    @RequestMapping(value = "/api/smsdraft/delete", method = RequestMethod.GET)
    Result<String> deleteSmsDraftById(@RequestParam(value = "recordId") Long recordId);

    /**
     * 常用联系人初次查询以及输入框查询
     */
    @RequestMapping(value = "/api/message/getIdPhonenum", method = RequestMethod.POST)
    Result<PageInfo<MsgsContactOftenDTO>> getIdPhonenum(@RequestParam(value = "contact") String contact);

    /**
     * 发送时常用联系人表的save/update
     */
    @RequestMapping(value = "/api/message/getSendPhonenum", method = RequestMethod.POST)
    Result<Boolean> getSendPhonenum(@RequestParam(value = "contact_send") String contact_send);

    /**
     * 根据联系人id删除联系人
     *
     * @param ids 联系人id
     * @return 删除结果
     */
    @RequestMapping(value = "/api/message/deleteContactByIds", method = RequestMethod.POST)
    Result<Boolean> deleteContactByIds(@RequestParam(value = "ids") String ids);
}
