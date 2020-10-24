package com.hengyunsoft.platform.mail.repository.service.user;

import com.hengyunsoft.commons.constant.EnableStatus;
import com.hengyunsoft.platform.mail.constant.MailConstant;
import com.hengyunsoft.platform.mail.entity.po.JamesUser;
import com.hengyunsoft.platform.mail.repository.dao.JamesUserMapper;
import com.hengyunsoft.platform.mail.utils.PasswordEncode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;


/**
 * This is a Description
 *
 * @auth tangyh
 * @date 2018/07/26
 */
@Service
@Slf4j
public class UserRegisterService {
    @Autowired
    JamesUserMapper jamesUserMapper;

    /**
     * 检查用户名 是否还能注册
     * @param account
     * @return
     */
    public boolean check(String account){
        if(jamesUserMapper.count(account) > 0){
            return true;
        }
        return false;
    }

    /**
     * 保存用户
     * @param account
     */
    public JamesUser saveUser(String account) {
        JamesUser user = new JamesUser();
        user.setName(account);
        //将登陆名户名追加邮箱后缀
        user.setUserName(MailConstant.fightAdmin(account));
        String password = PasswordEncode.setPassword(MailConstant.DEFAULT_PASSWORD);
        user.setPassword(password);
        user.setEnable(EnableStatus.ENABLE.getVal());
        jamesUserMapper.insert(user);
        return user;
    }

    /**
     * 同步用户表创建邮件用户
     */
    public void synUserData(){
        log.info("开始同步用户={}",new Date());
        List<String> nameList = jamesUserMapper.getCopyAccount(null,null);
        log.info("查询完成={}", new Date());
        for (String val : nameList){
            log.info("account={}",val);
            if(val != null){
                saveUser(getSubAccount(val));
            }
        }
        log.info("同步用户完成={}", new Date());
    }

    /**
     * 判断token帐号是否带有@，有则截取
     * @param val
     * @return
     */
    private static String getSubAccount(String val){
        if(val.indexOf("@") < 0){
            return val;
        }
        return val.substring(0,val.indexOf("@"));
    }
}
