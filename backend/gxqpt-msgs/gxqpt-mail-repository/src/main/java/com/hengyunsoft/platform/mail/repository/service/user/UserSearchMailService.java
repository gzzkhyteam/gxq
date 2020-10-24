package com.hengyunsoft.platform.mail.repository.service.user;

import com.hengyunsoft.platform.mail.entity.domain.MailBean;
import com.hengyunsoft.platform.mail.entity.domain.PageView;
import com.hengyunsoft.platform.mail.entity.po.BWList;
import com.hengyunsoft.platform.mail.repository.dao.BWListMapper;
import com.hengyunsoft.platform.mail.repository.service.mail.receive.MailInfo;
import com.hengyunsoft.platform.mail.repository.service.mail.receive.ReceiveMail;
import com.sun.mail.imap.IMAPFolder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.mail.Folder;
import javax.mail.search.AndTerm;
import javax.mail.search.BodyTerm;
import javax.mail.search.FromStringTerm;
import javax.mail.search.NotTerm;
import java.util.List;

/**
 * 类说明：用户搜索邮件服务类
 *
 * @author 作者: LiuJunGuang
 * @version 创建时间：2011-8-20 下午06:42:18
 */
@Service
@Slf4j
public class UserSearchMailService {

    @Autowired
    private BWListMapper bwListMapper;

    // 搜索邮件正文内容
    public PageView<MailBean> searchMailContent(String username, String password,
                                                String folderType, String content,
                                                int pageNo, int pageSize)
            throws Exception {
        log.info("要搜索的内容是：{}, {}", folderType, content);
        PageView<MailBean> pageView = new PageView<>(pageSize, pageNo);

        ReceiveMail mail = new ReceiveMail(username, password);// 初始化接收邮件参数
        log.info("connection success");
        IMAPFolder folder = mail.openFolder(folderType, Folder.READ_WRITE);
        log.info("openFolder success");
        BodyTerm bodyTerm = new BodyTerm(content);
        //查询黑名单id
        List<String> bwlist = bwListMapper.getList(BWList.BWTYPE1,BWList.LOTYPE1,username);
        log.info("bwlist.size={} success", bwlist.size());
        long[] uids = null;
        if(bwlist != null && bwlist.size() > 0){
            NotTerm[] nnotTerm = new NotTerm[bwlist.size()];
            for (int i=0;i<bwlist.size();i++){
                FromStringTerm fromTerm = new FromStringTerm(bwlist.get(i));
                NotTerm notTerm  = new NotTerm(fromTerm);
                nnotTerm[i] = notTerm;
            }
            AndTerm andTerm = new AndTerm(nnotTerm);
            AndTerm andTerm1 = new AndTerm(andTerm,bodyTerm);
            uids = mail.getMessageUIDs(folder, andTerm1);
        }else{
            uids = mail.getMessageUIDs(folder, bodyTerm);
        }

        MailInfo mailinfo = mail.getMailList(pageView.getFirstResult(), pageView.getMaxresult() + pageView.getFirstResult(), uids);

        if (mailinfo != null) {
            pageView.setQueryResult(mailinfo.getMailBeanList(), uids.length);
        }
        mail.close();
        return pageView;
    }


}
