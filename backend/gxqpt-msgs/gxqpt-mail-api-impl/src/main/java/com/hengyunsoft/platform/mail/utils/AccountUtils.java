package com.hengyunsoft.platform.mail.utils;

import com.hengyunsoft.commons.context.BaseContextHandler;
import com.hengyunsoft.exception.BizException;
import com.hengyunsoft.platform.commons.sec.UserTokenExtInfo;

import static com.hengyunsoft.commons.exception.core.MailExceptionCode.USER_INFO_GET_ERROR;

/**
 * This is a Description
 *
 * @auth tangyh
 * @date 2018/07/26
 */
public class AccountUtils {
    /***
     * 获取登录人账号
     * @return
     */
    public static String getAccount() {
        UserTokenExtInfo user = (UserTokenExtInfo) BaseContextHandler.getUserTokenExtInfo();
        if (user != null) {
            return getSubAccount(user.getAccount());
        }
        throw new BizException(USER_INFO_GET_ERROR.getCode(), USER_INFO_GET_ERROR.getMsg());
    }

    /***
     * 获取登录人账号带邮件地址后缀
     * @return
     */
    public static String getAccountSuffix() {
        UserTokenExtInfo user = (UserTokenExtInfo) BaseContextHandler.getUserTokenExtInfo();
        if (user != null) {
            return getSubAccount(user.getAccount()) + "@gygxq.com";
        }
        throw new BizException(USER_INFO_GET_ERROR.getCode(), USER_INFO_GET_ERROR.getMsg());
    }

    /**
     * 判断token帐号是否带有@，有则截取
     *
     * @param val
     * @return
     */
    private static String getSubAccount(String val) {
        if (val.indexOf("@") < 0) {
            return val;
        }
        return val.substring(0, val.indexOf("@"));
    }
}
