package com.hengyunsoft.platform.mt.impl.userconfig;

import com.hengyunsoft.base.Result;
import com.hengyunsoft.commons.context.BaseContextHandler;
import com.hengyunsoft.commons.exception.core.AuthorityExceptionCode;
import com.hengyunsoft.commons.exception.core.MtExceptionCode;
import com.hengyunsoft.platform.admin.api.authority.api.UserApi;
import com.hengyunsoft.platform.admin.api.authority.dto.emp.GxqptEmpOrgResDTO;
import com.hengyunsoft.platform.admin.open.core.api.GxqptOrgOpenApi;
import com.hengyunsoft.platform.commons.sec.IUserToken;
import com.hengyunsoft.platform.commons.sec.UserTokenExtInfo;
import com.hengyunsoft.platform.msgs.api.bbs.BbsMessageApi;
import com.hengyunsoft.platform.msgs.api.msg.MsgsMessageApi;
import com.hengyunsoft.platform.msgs.dto.bbs.BbsMsgDetailResDTO;
import com.hengyunsoft.platform.msgs.dto.msg.MobileNewReadDTO;
import com.hengyunsoft.platform.mt.api.userconfig.dto.LoginResDTO;
import com.hengyunsoft.platform.mt.api.userconfig.dto.OrgInfoDTO;
import com.hengyunsoft.platform.mt.api.userconfig.dto.RedMsgDTO;
import com.hengyunsoft.platform.mt.api.userconfig.dto.UserOrgInfoDTO;
import com.hengyunsoft.platform.mt.entity.userconfig.po.UserConfig;
import com.hengyunsoft.platform.mt.repository.feedback.service.FeedBackService;
import com.hengyunsoft.platform.mt.repository.userconfig.example.UserConfigExample;
import com.hengyunsoft.platform.mt.repository.userconfig.service.UserConfigService;
import com.hengyunsoft.platform.mt.utils.UnityUtil;
import com.hengyunsoft.security.auth.cache.TokenCache;
import com.hengyunsoft.security.auth.client.annotation.IgnoreToken;
import com.hengyunsoft.security.auth.dto.UserDTO;
import com.hengyunsoft.utils.BizAssert;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * com.hengyunsoft.platform.mt.impl.userconfig
 * 版权：中科恒运软件科技股份有限公司贵阳分公司
 * 描述：用户配置
 * 修改人：gbl
 * 修改时间：2018/6/25
 * 修改内容：新增基础接口
 */
@Api(value = "API - UserConfiApiImpl.java", description = "用户配置")
@RestController
@RequestMapping("userConfi")
@Slf4j
public class UserConfiApiImpl /*implements UserConfigAPI */ {
    @Autowired
    private GxqptOrgOpenApi gxqptOrgOpenApi;
    @Autowired
    private UserConfigService userConfigService;
    @Autowired
    private UserApi userApi;
    @Autowired
    private FeedBackService feedBackService;
    @Autowired
    private BbsMessageApi bbsMessageApi;
    @Autowired
    private MsgsMessageApi msgsMessageApi;

    private RestTemplate restTemplate = new RestTemplate();
    @Value("${gxqpt.mt-webapp.app-id}")
    private String appId;
    @Value("${gxqpt.mt-webapp.app-secret}")
    private String appSecret;
    @Value("${loginUrl}")
    private String loginUrl;
    @Autowired
    private IUserToken userToken;


    /**
     * 描述：获取我的所有单位
     * 参数：
     * 返回值：
     * 修改人：gbl
     * 修改时间：2018/6/25
     * 修改内容：
     */

    @RequestMapping(value = "getMyOrgList", method = RequestMethod.GET)
    @ApiOperation(value = "获取我的所有单位", notes = "获取我的所有单位")
    public Result<UserOrgInfoDTO> saveGetMyOrgList() {
        Long userId = BaseContextHandler.getAdminId();
        GxqptEmpOrgResDTO mainOrg = UnityUtil.getEmp(userId);
        if (mainOrg == null) {
            return Result.fail("您的账号没有设置主单位");
        }
        List<OrgInfoDTO> rList = new ArrayList<>();

        OrgInfoDTO info = new OrgInfoDTO();
        info.setId(mainOrg.getMainorgid());
        info.setName(mainOrg.getMainorgname());
//        info.setDeptName(mainOrg.getDeptName());
//        info.setPostName(mainOrg.getPostName());
        rList.add(info);

        UserOrgInfoDTO res = new UserOrgInfoDTO();
        res.setOrgList(rList);
        res.setId(mainOrg.getMainorgid());
        res.setName(mainOrg.getMainorgname());
//        res.setPostName(nowpostName);
//        res.setDutyName(nowdutyName);
//        res.setDeptName(nowdeptName);
        return Result.success(res);
    }


    /**
     * 描述：切换单位
     * 参数：
     * 返回值：
     * 修改人：gbl
     * 修改时间：2018/6/25
     * 修改内容：
     */

    @RequestMapping(value = "setNowUnityId", method = RequestMethod.POST)
    @ApiOperation(value = "切换单位", notes = "切换单位")
    @ApiResponses({
            @ApiResponse(code = 92500, message = "单位id，不能为空"),
    })
    public Result<Boolean> saveSetNowUnitId(@RequestParam("unitId") String unitId) {
        BizAssert.assertNotEmpty(MtExceptionCode.UNITY_ID_IS_NULL, unitId);
        Long userId = BaseContextHandler.getAdminId();
        //查询设置的单位id
        UserConfigExample example = new UserConfigExample();
        UserConfigExample.Criteria criteria = example.createCriteria();
        criteria.andUserIdEqualTo(userId);
        criteria.andJobIdEqualTo(UserConfigJobType.now_unity_id.jobId);
        UserConfig uConfig = userConfigService.getUnique(example);
        if (uConfig == null) {
            uConfig = new UserConfig();
            uConfig.setJobId(UserConfigJobType.now_unity_id.jobId);
            uConfig.setUserId(userId);
            uConfig.setCreateUser(userId);

        }
        uConfig.setJobValue(unitId);
        uConfig.setUpdateUser(userId);

        userConfigService.updateByIdSelective(uConfig);
        return Result.success(true);
    }

    /**
     * 描述：查询红点提醒消息
     * 参数：
     * 返回值：
     * 修改人：gbl
     * 修改时间：2018/8/20
     * 修改内容：
     */

    @RequestMapping(value = "getRedMsg", method = RequestMethod.GET)
    @ApiOperation(value = "查询红点提醒消息", notes = "查询红点提醒消息")
    public Result<List<RedMsgDTO>> getRedMsg() {
        List<RedMsgDTO> list = new ArrayList<>();
        Long adminId = BaseContextHandler.getAdminId();

        //已经反馈
        RedMsgDTO feedBackMsg = new RedMsgDTO();
        Integer notReadCount = feedBackService.getNotReadCount(adminId);
        feedBackMsg.setMsgType("feedBack");
        feedBackMsg.setNotReadCount(notReadCount);
        list.add(feedBackMsg);

        //系统消息
        RedMsgDTO sysMsg = new RedMsgDTO();
        Result<BbsMsgDetailResDTO> recentMsgAndNotReadNum = bbsMessageApi.getRecentMsgAndNotReadNum(adminId);
        sysMsg.setMsgType("sysMsg");
        if (recentMsgAndNotReadNum.isSuccess() && recentMsgAndNotReadNum.getData() != null) {
            sysMsg.setContent(recentMsgAndNotReadNum.getData().getTitle());
            sysMsg.setNotReadCount(recentMsgAndNotReadNum.getData().getNotReadNum());
        } else {
            sysMsg.setContent("");
            sysMsg.setNotReadCount(0);
            log.error("调用消息接口 bbsMessageApi的getRecentMsgAndNotReadNum失败,错误码:{},错误消息:{}", recentMsgAndNotReadNum.getErrcode(), recentMsgAndNotReadNum.getErrmsg());
        }
        list.add(sysMsg);

        //系统公告
        RedMsgDTO sysNotice = new RedMsgDTO();
        Result<MobileNewReadDTO> sysNoticeResult = msgsMessageApi.queryMobileIsRead(adminId);
        if (sysNoticeResult.isSuccess() && sysNoticeResult.getData() != null) {
            sysNotice.setContent(sysNoticeResult.getData().getTopic());
            sysNotice.setNotReadCount(sysNoticeResult.getData().getReadNum());
        } else {
            sysNotice.setContent("");
            sysNotice.setNotReadCount(0);
            log.error("调用通知接口msgsMessageApi的queryMobileIsRead失败,错误码:{},错误消息:{}", sysNoticeResult.getErrcode(), sysNoticeResult.getErrmsg());
        }
        sysNotice.setMsgType("sysNotice");
        list.add(sysNotice);

        return Result.success(list);
    }

    /**
     * 描述：移动端登录
     * 参数：
     * 返回值：
     * 修改人：gbl
     * 修改时间：2018/6/26
     * 修改内容：
     */

    @RequestMapping(value = "mtMoveLogin", method = RequestMethod.POST)
    @ApiOperation(value = "移动端登录", notes = "移动端登录")
    @ApiResponses({
            @ApiResponse(code = 50002, message = "帐号或者密码错误"),
    })
    @IgnoreToken
    public Result<LoginResDTO> mtMoveLogin(@RequestParam("account") String account, @RequestParam("password") String password) throws Exception {
        log.info("请求登录 account:{},password:{}", account, password);
        BizAssert.assertNotEmpty(AuthorityExceptionCode.USER_NAME_PWD_ERROR, account);
        BizAssert.assertNotEmpty(AuthorityExceptionCode.USER_NAME_PWD_ERROR, password);
        String loaduserapi = loginUrl + "?account={account}&password={password}";
        Map<String, String> urlVariables = new HashMap<>();
        urlVariables.put("account", account);
        urlVariables.put("password", password);
        LoginResult re = restTemplate.postForEntity(loaduserapi, null, LoginResult.class, urlVariables).getBody();
//        HttpHeaders headers = new HttpHeaders();
//        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
//        MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
//        map.add("account", account);
//        map.add("password", password);
//
//        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(map, headers);
//        ResponseEntity<Result> res = restTemplate.postForEntity(loginUrl, request, Result.class);
        if (!re.isSuccess()) {
            log.error("模拟http请求登录接口失败:{},{}", re.getErrcode(), re.getErrmsg());
            return Result.fail(re.getErrcode(), re.getErrmsg());
        }
        UserDTO user = re.getData();
//        String s = JSON.toJSONString(data);
//        UserDTO user = JSON.parseObject(s, UserDTO.class);
        //String token = TokenCache.of(appId, appSecret).get().get();

        String token = getToken(user.getId(), account, user.getName());

        LoginResDTO res1 = new LoginResDTO();
        res1.setUser(user);
        res1.setToken(token);
        return Result.success(res1);
    }

    /**
     * 描述：移动端刷新token(已经不可用)
     * 参数：
     * 返回值：
     * 修改人：gbl
     * 修改时间：2018/8/10
     * 修改内容：
     */

    @RequestMapping(value = "refreshToken", method = RequestMethod.GET)
    @ApiOperation(value = "刷新token", notes = "刷新token")
    @IgnoreToken
    @Deprecated
    public Result<String> refreshToken() {
        try {
            //String token = getToken(BaseContextHandler.getAdminId(), BaseContextHandler.getName());
            //Result.success(token);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
        return Result.fail("获取token失败");
    }

    private String getToken(Long userId, String account, String userName) throws Exception {
        String token = TokenCache.of(appId, appSecret).get().get();
        log.info("appId={}", appId);
        log.info("appSecret={}", appSecret);
        log.info("token={}", token);
        // HashOperations<String, String, String> hashOperations = redisTemplate.opsForHash();
        // String token = hashOperations.get(getToeknPre + appId, appId);
        UserTokenExtInfo ext = new UserTokenExtInfo();
        ext.setAccount(account);
        token = userToken.encoder(token, String.valueOf(userId), userName, ext);
        token = URLEncoder.encode(token, "utf-8");
        return token;
    }

    public static class LoginResult {


        /**
         * 调用是否成功标识，0：成功，-1:系统繁忙，此时请开发者稍候再试 详情见[ExceptionCode]
         */
        private int errcode;

        /**
         * 调用结果
         */
        private UserDTO data;

        /**
         * 结果消息，如果调用成功，消息通常为空T
         */
        private String errmsg = "ok";


        public int getErrcode() {
            return errcode;
        }

        public void setErrcode(int errcode) {
            this.errcode = errcode;
        }

        public UserDTO getData() {
            return data;
        }

        public void setData(UserDTO data) {
            this.data = data;
        }

        public String getErrmsg() {
            return errmsg;
        }

        public void setErrmsg(String errmsg) {
            this.errmsg = errmsg;
        }

        /**
         * 逻辑处理是否成功
         *
         * @return 是否成功
         */

        public boolean isSuccess() {
            return this.errcode == Result.SUCCESS;
        }


        public String toString() {
            return "LoginResult [errcode=" + errcode + ", data=" + data + ", errmsg=" + errmsg + "]";
        }
    }
}
