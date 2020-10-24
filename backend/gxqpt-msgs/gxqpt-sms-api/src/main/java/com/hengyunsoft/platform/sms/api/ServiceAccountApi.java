//package com.hengyunsoft.platform.sms.api;
//
//import java.util.List;
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
//import com.hengyunsoft.platform.sms.api.hystrix.ServiceAccountApiHystrix;
//import com.hengyunsoft.platform.sms.dto.AppointAppDTO;
//import com.hengyunsoft.platform.sms.dto.ServiceAccountDTO;
//import com.hengyunsoft.platform.sms.dto.ServiceAccountMsgDTO;
//import com.hengyunsoft.platform.sms.dto.ServiceAccountPageDTO;
///**
// * 短信第三方申请账号管理服务
// * @author dxz
// */
//@FeignClient(name = "${gxqpt.gate.feign.server:gxqpt-gate-server}",path = "/api/sms",
//fallback = ServiceAccountApiHystrix.class)
//public interface ServiceAccountApi {
//	/**
//     * 新增账号
//     * @return
//     */
//    @RequestMapping(value = "/api/smsacount/add", method = RequestMethod.POST)
//    Result<String> addAcount(@RequestBody ServiceAccountDTO serviceAccountDTO);
//    /**
//     * 编辑账号
//     * @return
//     */
//    @RequestMapping(value = "/api/smsacount/update", method = RequestMethod.POST)
//    Result<String> updateAcount(@RequestBody ServiceAccountDTO serviceAccountDTO);
//    /**
//     * 删除账号
//     * @return
//     */
//    @RequestMapping(value = "/api/smsacount/delete", method = RequestMethod.GET)
//    Result<String> deleteAcount(@RequestParam(value = "id") Long id);
//    /**
//     * 获取账号列表
//     * @return
//     */
//    @RequestMapping(value = "/api/smsacount/list", method = RequestMethod.POST)
//    Result<PageInfo<ServiceAccountDTO>> pageAcountList(@RequestBody OpenApiReq<ServiceAccountPageDTO> openApiReq);
//    /**
//     * 获取账号详情
//     * @return
//     */
//    @RequestMapping(value = "/api/smsacount/detail", method = RequestMethod.GET)
//    Result<ServiceAccountDTO> getAcountDetali(@RequestParam(value = "id") Long id); 
//    /**
//     * 指定应用
//     * @return
//     */
//    @RequestMapping(value = "/api/smsacount/appoint", method = RequestMethod.POST)
//    Result<String> saveAppoint(@RequestBody AppointAppDTO appointAppDTO); 
//    /**
//     * 根据服务商英文名查询短信服务账号
//     * @return
//     */
//    @RequestMapping(value = "/api/smsacount/names", method = RequestMethod.GET)
//    Result<List<ServiceAccountMsgDTO>> getAccountByServer(@RequestParam(value = "server") String server); 
//}
