//package com.hengyunsoft.platform.mt.api.userconfig.api;
//
//import com.hengyunsoft.base.Result;
//import com.hengyunsoft.platform.mt.api.userconfig.api.hystrix.UserConfigAPIHystrix;
//import com.hengyunsoft.platform.mt.api.userconfig.dto.LoginResDTO;
//import com.hengyunsoft.platform.mt.api.userconfig.dto.RedMsgDTO;
//import com.hengyunsoft.platform.mt.api.userconfig.dto.UserOrgInfoDTO;
//import io.swagger.annotations.ApiOperation;
//import org.springframework.cloud.netflix.feign.FeignClient;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;
//
//import java.util.List;
//
///**
// * 描述：
// *
// * @author gbl
// * @date 2018/6/25
// */
//@FeignClient(name = "${gxqpt.gate.feign.server:gxqpt-gate-server}", path = "/api/UserConfig", fallback = UserConfigAPIHystrix.class)
//public interface UserConfigAPI {
//    /**
//     * 描述：获取我的所有单位
//     * 参数：
//     * 返回值：
//     * 修改人：gbl
//     * 修改时间：2018/6/25
//     * 修改内容：
//     */
//    @RequestMapping(value = "getMyOrgList", method = RequestMethod.GET)
//    Result<UserOrgInfoDTO> getMyOrgList();
//
//    /**
//     * 描述：切换单位
//     * 参数：
//     * 返回值：
//     * 修改人：gbl
//     * 修改时间：2018/6/25
//     * 修改内容：
//     */
//    @RequestMapping(value = "setNowUnitId", method = RequestMethod.POST)
//    Result<Boolean> setNowUnitId(@RequestParam("unitId") String unitId);
//
//    /**
//     * 描述：查询红点提醒消息
//     * 参数：
//     * 返回值：
//     * 修改人：gbl
//     * 修改时间：2018/8/20
//     * 修改内容：
//     */
//    @RequestMapping(value = "getRedMsg", method = RequestMethod.GET)
//    Result<List<RedMsgDTO>> getRedMsg();
//
//    /**
//     * 描述：登录
//     * 参数：
//     * 返回值：
//     * 修改人：gbl
//     * 修改时间：2018/6/26
//     * 修改内容：
//     */
//    @RequestMapping(value = "mtMoveLogin", method = RequestMethod.POST)
//    Result<LoginResDTO> mtMoveLogin(String account, String password) throws Exception;
//
//    /**
//     * 描述：移动端刷新token
//     * 参数：
//     * 返回值：
//     * 修改人：gbl
//     * 修改时间：2018/8/10
//     * 修改内容：
//     */
//    @RequestMapping(value = "refreshToken", method = RequestMethod.GET)
//    @Deprecated
//    Result<String> refreshToken();
//
//
//}
