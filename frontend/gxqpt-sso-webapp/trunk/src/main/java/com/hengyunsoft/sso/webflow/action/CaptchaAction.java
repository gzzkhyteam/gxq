package com.hengyunsoft.sso.webflow.action;

import com.hengyunsoft.sso.util.CaptchaUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 验证码控制器
 * 使用sessionId作为key缓存
 * @author sxy
 * @date 20180626
 *
 */
@RestController
@RequestMapping("auth")
public class CaptchaAction {

    /**
     * 登录验证码缓存key
     */
    public final static String LOGIN_QRCODE_SESSION_KEY = "captcha_";

    /**
     * 获取验证码
     * @return
     */
    @RequestMapping(value = "/msg/getCaptcha", method = RequestMethod.GET)
    public String getAuthCode(HttpServletRequest request, HttpServletResponse response){
        HttpSession session = request.getSession();
        String captcha = CaptchaUtils.getInstance().generateCheckcode();
        session.setAttribute(LOGIN_QRCODE_SESSION_KEY+session.getId(),captcha);
        return captcha;
    }
}
