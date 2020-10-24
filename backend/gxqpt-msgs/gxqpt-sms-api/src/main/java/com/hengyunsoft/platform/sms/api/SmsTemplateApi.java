//package com.hengyunsoft.platform.sms.api;
//
//import java.util.List;
//import java.util.Map;
//
//import org.springframework.cloud.netflix.feign.FeignClient;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;
//
//import com.github.pagehelper.PageInfo;
//import com.hengyunsoft.base.Result;
//import com.hengyunsoft.page.plugins.openapi.OpenApiReq;
//import com.hengyunsoft.platform.sms.api.hystrix.SmsTemplateApiHystrix;
//import com.hengyunsoft.platform.sms.dto.QuerySmsTemplateDTO;
//import com.hengyunsoft.platform.sms.dto.SmsTemplateDTO;
//import com.hengyunsoft.platform.sms.dto.SmsTemplateListDTO;
///**
// * 短信模板管理接口
// * @author Administrator
// */
//@FeignClient(name = "${gxqpt.gate.feign.server:gxqpt-gate-server}",path = "/api/sms",
//fallback = SmsTemplateApiHystrix.class)
//public interface SmsTemplateApi {
//	/**
//     * 新增短信模板
//     * @return
//     */
//    @RequestMapping(value = "/api/smstemplate/add", method = RequestMethod.POST)
//    Result<String> addSmsTemplate(@RequestBody SmsTemplateDTO smsTemplateDTO);
//    /**
//     * 编辑短信模板
//     * @return
//     */
//    @RequestMapping(value = "/api/smstemplate/update", method = RequestMethod.POST)
//    Result<String> updateSmsTemplate(@RequestBody SmsTemplateDTO smsTemplateDTO);
//    /**
//     * 删除短信模板
//     * @return
//     */
//    @RequestMapping(value = "/api/smstemplate/delete", method = RequestMethod.GET)
//    Result<String> deleteSmsTemplate(@RequestParam(value = "id") Long id);
//    /**
//     * 查询短信模板列表
//     * @return
//     */
//    @RequestMapping(value = "/api/smstemplate/list", method = RequestMethod.POST)
//    Result<PageInfo<SmsTemplateListDTO>> pageSmsTemplate(@RequestBody OpenApiReq<QuerySmsTemplateDTO> openApiReq);
//    /**
//     * 新建发送模板选择
//     */
//    @RequestMapping(value = "/api/smstemplate/listcreate", method = RequestMethod.POST)
//    Result<PageInfo<SmsTemplateDTO>> getSmsTemplateCreate(@RequestParam(value = "channelId") String channelId);
//    /**
//     * 查询短信模板详情
//     * @return
//     */
//    @RequestMapping(value = "/api/smstemplate/detail", method = RequestMethod.GET)
//    Result<SmsTemplateDTO> getSmsTemplateDetail(@RequestParam(value = "id") Long id);
//    /**
//     * 获取某个渠道下的模板列表
//     * @return
//     */
//    @RequestMapping(value = "/api/smstemplate/channellist", method = RequestMethod.GET)
//    Result<List<Map<String,Object>>> getSmsTemplateChannelList(@RequestParam(value = "channelid") String channelid);
//}
