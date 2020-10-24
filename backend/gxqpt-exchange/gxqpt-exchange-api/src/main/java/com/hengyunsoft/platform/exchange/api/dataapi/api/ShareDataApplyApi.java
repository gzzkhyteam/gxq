//package com.hengyunsoft.platform.exchange.api.dataapi.api;
//
//import com.github.pagehelper.PageInfo;
//import com.hengyunsoft.base.Result;
//import com.hengyunsoft.page.plugins.openapi.OpenApiReq;
//import com.hengyunsoft.platform.exchange.api.dataapi.api.hystrix.ShareDataApplyApiHystrix;
//import com.hengyunsoft.platform.exchange.api.dataapi.dto.dataapi.ApiIRenewalDTO;
//import com.hengyunsoft.platform.exchange.api.dataapi.dto.dataapi.ApiRenewalInfoDTO;
//import com.hengyunsoft.platform.exchange.api.dataapi.dto.shareapply.ShareApplyDetailDTO;
//import com.hengyunsoft.platform.exchange.api.dataapi.dto.shareapply.ShareApplyListDTO;
//import com.hengyunsoft.platform.exchange.api.dataapi.dto.shareapply.ShareApplyQueryDTO;
//import com.hengyunsoft.platform.exchange.api.dataapi.dto.shareapply.ShareApplySaveDTO;
//import org.apache.ibatis.annotations.Param;
//import org.springframework.cloud.netflix.feign.FeignClient;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;
//
///**
// * com.hengyunsoft.platform.exchange.api.dataapi.api
// * 版权：中科恒运软件科技股份有限公司贵阳分公司
// * 描述：共享申请Api
// * 修改人：zhaopengfei
// * 修改时间：2018/4/21
// * 修改内容：新增基础接口
// */
//@FeignClient(name = "${gxqpt.gate.feign.server:gxqpt-gate-server}",
//        path = "api/exchange", fallback = ShareDataApplyApiHystrix.class)
//public interface ShareDataApplyApi {
//    /**
//     * 描述：保存共享申请
//     * 参数：ShareApplySaveDTO API元数据
//     * 返回值：Boolean 状态（成功、失败）
//     * 修改人：zhaopengfei
//     * 修改时间：2018/4/21
//     * 修改内容：
//     */
//    @RequestMapping(value = "/apply/saveshareapply", method = RequestMethod.POST)
//    Result<Boolean> saveShareApply(@RequestBody ShareApplySaveDTO dto);
//
//    /**
//     * 描述：根据共享申请Id查找共享申请详细信息
//     * 参数：id 申请Id
//     * 返回值：ShareApplyDetailDTO
//     * 修改人：zhaopengfei
//     * 修改时间：2018/4/21
//     * 修改内容：
//     */
//    @RequestMapping(value = "/apply/detail", method = RequestMethod.POST)
//    Result<ShareApplyDetailDTO> getById(@RequestParam("id") Long id);
//
//    /**
//     * 描述：更新订阅状态
//     * 参数：id 申请Id
//     * 参数：isTake：是否订阅：1：订阅；2，取消订阅
//     * 返回值：Boolean 操作状态
//     * 修改人：zhaopengfei
//     * 修改时间：2018/4/22
//     * 修改内容：
//     */
//    @RequestMapping(value = "/apply/updatetake", method = RequestMethod.POST)
//    Result<Boolean> updatetake(@RequestParam(value = "id") Long id, @RequestParam(value = "isTake") Integer isTake);
//
//
//    /**
//     * 描述：查询共享申请分页数据
//     * 参数：openApiReq 分页信息；
//     * 返回值：PageInfo<ShareApplyListDTO>
//     * 修改人：zhaopengfei
//     * 修改时间：2018/4/21
//     * 修改内容：
//     */
//    @RequestMapping(value = "/apply/find", method = RequestMethod.POST)
//    Result<PageInfo<ShareApplyListDTO>> page(@RequestBody OpenApiReq<ShareApplyQueryDTO> openApiReq);
//
//    /**
//     * 描述：api延续申请
//     * 参数：ApiIRenewalDTO
//     * 返回值：Boolean 操作状态
//     * 修改人：zhaopengfei
//     * 修改时间：2018/4/22
//     * 修改内容：
//     */
//    @RequestMapping(value = "/apply/renewal", method = RequestMethod.POST)
//    Result<Boolean> updateLimitTime(@RequestBody ApiIRenewalDTO dto);
//
//    /**
//     * 描述：根据共享申请Id查询api续期基础信息
//     * 参数：id：共享申请id
//     * 返回值：ApiRenewalInfoDTO
//     * 修改人：zhaopengfei
//     * 修改时间：2018/5/1
//     * 修改内容：
//     */
//    @RequestMapping(value = "/api/apirenewalinfo", method = RequestMethod.POST)
//    public Result<ApiRenewalInfoDTO> queryBaseInfo(@RequestParam("id") Long id);
//
//    /**
//     * 描述：根据API id查询该单位是否已经申请过
//     * 参数：apiId
//     * 返回值：true:已经申请 false 未申请
//     * 修改人：zhaopengfei
//     * 修改时间：2018/5/11
//     * 修改内容：
//     */
//    @RequestMapping(value = "/apply/getapiapplystatus",method = RequestMethod.POST)
//    public Result<Boolean> getApiApplyStatus(@RequestParam("apiId") Long apiId);
//
//    /**
//     * 描述：共享单位删除
//     * 参数：id 共享申请Id
//     * 返回值：Boolean
//     * 修改人：zhaopengfei
//     * 修改时间：2018/5/12
//     * 修改内容：
//     */
//    @RequestMapping(value = "/apply/deleteshareunit", method = RequestMethod.POST)
//    public Result<Boolean> deleteShareUnit(@RequestParam("id") Long id);
//    /**
//     * 描述：共享单位删除
//     * 参数：id 共享申请Id
//     * 返回值：Boolean
//     * 修改人：zhaopengfei
//     * 修改时间：2018/5/12
//     * 修改内容：
//     */
//    @RequestMapping(value = "/apply/delete", method = RequestMethod.POST)
//    public Result<Boolean> delete(@RequestParam("id") Long id);
//
//    /**
//     * 描述：根据API id查询该单位所申请API的密钥
//     * 参数：apiId
//     * 返回值：String  密钥
//     * 修改人：zhaopengfei
//     * 修改时间：2018/7/21
//     * 修改内容：
//     */
//    @RequestMapping(value = "/apply/getApiApplyKey", method = RequestMethod.POST)
//    public Result<String> getApiApplyKey(@RequestParam("apiId") Long apiId) ;
//
//    /**
//     * 描述：根据API id查询该单位所申请API的密钥
//     * 参数：apiId
//     * 返回值：String  密钥
//     * 修改人：zhaopengfei
//     * 修改时间：2018/5/11
//     * 修改内容：
//     */
//    @RequestMapping(value = "/apply/isValid", method = RequestMethod.POST)
//    public Result<Boolean> isValid(@RequestParam("apiId") Long apiId);
//}
