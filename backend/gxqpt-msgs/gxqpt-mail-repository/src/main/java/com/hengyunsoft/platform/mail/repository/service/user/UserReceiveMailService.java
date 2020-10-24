package com.hengyunsoft.platform.mail.repository.service.user;


import com.hengyunsoft.platform.mail.constant.MailConstant;
import com.hengyunsoft.platform.mail.entity.domain.MailBean;
import com.hengyunsoft.platform.mail.entity.domain.MoveMailListDO;
import com.hengyunsoft.platform.mail.entity.domain.PageView;
import com.hengyunsoft.platform.mail.entity.po.BWList;
import com.hengyunsoft.platform.mail.repository.dao.BWListMapper;
import com.hengyunsoft.platform.mail.repository.service.mail.receive.Flag;
import com.hengyunsoft.platform.mail.repository.service.mail.receive.MailInfo;
import com.hengyunsoft.platform.mail.repository.service.mail.receive.ReceiveMail;
import com.sun.mail.imap.IMAPFolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.mail.Folder;
import javax.mail.MessagingException;
import javax.mail.search.*;
import java.util.Date;
import java.util.List;


/**
 * 类说明：接收邮件服务层
 *
 * @author 作者: LiuJunGuang
 * @version 创建时间：2011-8-2 下午11:45:41
 */
@Service
public class UserReceiveMailService {
    @Autowired
    private BWListMapper bwListMapper;
    String mailPrefix = "";//域名前缀

    // 设置邮件信息（并将邮件信息封装到PageView中）
    public PageView<MailBean> getMailInfoPageView(String username, String password, String folderType, int pageNo, int pageSize) throws Exception {
        //folderType 1收件箱2草稿箱3已发送4已删除5垃圾邮件
//		MailConstant mailConstant = new MailConstant();
//		username = mailConstant.FightAdmin(username, folderType);
        PageView<MailBean> pageView = new PageView<>(pageSize, pageNo);
        ReceiveMail mail = new ReceiveMail(username, password);// 初始化接收邮件参数
        IMAPFolder folder = mail.openFolder(folderType, Folder.READ_WRITE);

        //查询黑名单id
        List<String> bwlist = bwListMapper.getList(BWList.BWTYPE1,BWList.LOTYPE1,username);
        SentDateTerm sentDateTerm = new SentDateTerm(ComparisonTerm.LE, new Date());
        long[] uids = null;
        if(bwlist != null && bwlist.size() > 0) {
            NotTerm[] nnotTerm = new NotTerm[bwlist.size()];
            for (int i = 0; i < bwlist.size(); i++) {
                FromStringTerm fromTerm = new FromStringTerm(bwlist.get(i));
                NotTerm notTerm = new NotTerm(fromTerm);
                nnotTerm[i] = notTerm;
            }
            AndTerm andTerm = new AndTerm(nnotTerm);
            AndTerm andTermDate = new AndTerm(sentDateTerm,andTerm);
            uids = mail.getMessageUIDs(folder, andTermDate);
        }else{

            uids = mail.getMessageUIDs(folder,sentDateTerm);
        }
        MailInfo mailinfo = mail.getMailList(pageView.getFirstResult(), pageView.getMaxresult() + pageView.getFirstResult(), uids);

        if (mailinfo != null) {
            pageView.setQueryResult(mailinfo.getMailBeanList(), mailinfo.getMessageCount());
            pageView.setNewAndUnreadMail(mailinfo.getNewMessageCount(), mailinfo.getUnreadMessageCount());
        }
        mail.close();
        return pageView;
    }


    // 根据邮件夹类型设置邮件夹的名称
//    public static String folderType(int type) {
//        switch (type) {
//            case MailConstant.INBOX:
//                return MailConstant.FOLDER_INBOX;
//            case MailConstant.DRAFT:
//                return MailConstant.FOLDER_DRAFT;
//            case MailConstant.DELETE:
//                return MailConstant.FOLDER_DELETE;
//            case MailConstant.SENDED:
//                return MailConstant.FOLDER_SENDED;
//            case MailConstant.SPAM:
//                return MailConstant.FOLDER_SPAM;
//        }
//        return MailConstant.FOLDER_INBOX;
//    }

    // 根据邮件夹名称返回邮件夹类型
//    public static int folderType(String folderName) {
//        if (folderName.equals(MailConstant.FOLDER_INBOX)) {
//            return MailConstant.INBOX;
//        } else if (folderName.equals(MailConstant.FOLDER_DRAFT)) {
//            return MailConstant.DRAFT;
//        } else if (folderName.equals(MailConstant.FOLDER_DELETE)) {
//            return MailConstant.DELETE;
//        } else if (folderName.equals(MailConstant.FOLDER_SENDED)) {
//            return MailConstant.SENDED;
//        } else if (folderName.equals(MailConstant.FOLDER_SPAM)) {
//            return MailConstant.SPAM;
//        }
//        return MailConstant.INBOX;
//    }

    // 设置邮件标记
    public boolean setMailFlags(String name, String password, String folderType,
                                String mailUid, boolean type) {
        try {
            ReceiveMail mail = new ReceiveMail(name, password);
            mail.openFolder(folderType, Folder.READ_WRITE);// 打开指定的邮件夹
            setFlag(type, mail, getLongUid(mailUid));// 设置邮件标记
            mail.close();
        } catch (MessagingException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    // 设置邮件的标记
    private void setFlag(boolean type, ReceiveMail mail, long[] longUid)
            throws MessagingException {
        if (type) {// 标志为已读邮件
            mail.setMessagesFlags(longUid, Flag.SEEN, true);
        } else {
            mail.setMessagesFlags(longUid, Flag.SEEN, false);
        }
    }

    // 移动邮件到“已删除”
    public void deleteMail(String name, String password, String folderType,
                           String mailUid) throws Exception {
        moveMail(name, password, folderType, MailConstant.FOLDER_DELETE, mailUid);// 移动邮件到"已删除"

    }

    // 彻底删除邮件
    public void deleteMailForever(String name, String password, String folderType,
                                  String mailUid) throws MessagingException {
        ReceiveMail mail = new ReceiveMail(name, password);
        mail.deleteMessage(folderType, getLongUid(mailUid));
        mail.close();// 关闭连接
    }

    // 彻底删除邮件集合
    public void deleteMailForeverList(List<MoveMailListDO> dtos,String name, String password) throws MessagingException {
        ReceiveMail mail = new ReceiveMail(name, password);
        for (MoveMailListDO mailDO : dtos){
            mail.deleteMessage(mailDO.getFolderType(), getLongUid(mailDO.getMailId()));
        }
        mail.close();// 关闭连接
    }

    // 通过字符串类型的uid返回long[]类型的uid数组
    private long[] getLongUid(String mailUid) {
        String uids[] = mailUid.split(",");// 要删除的邮件的UID
        long longUid[] = new long[uids.length];
        for (int i = 0; i < uids.length; i++) {
            longUid[i] = Long.parseLong(uids[i]);
        }
        return longUid;
    }

    // 移动邮件到指定的邮件夹中
    public void moveMail(String name, String password, String folderType, String moveType, String mailUid) throws Exception {
        ReceiveMail mail = new ReceiveMail(name, password);
        mail.moveMessage(folderType, moveType, getLongUid(mailUid));
        mail.close();// 关闭连接
    }

    //循环移动邮件到制定邮件夹中
    public void moveMailList(List<MoveMailListDO> dtos, String name, String password) throws Exception {
        ReceiveMail mail = new ReceiveMail(name, password);
        for (MoveMailListDO mailDO : dtos){
//            mail.moveMessage(mailDO.getFolderType(), MailConstant.FOLDER_DELETE, getLongUid(mailDO.getMailId()));
            mail.moveMessage(mailDO.getFolderType(), mailDO.getMoveType(), getLongUid(mailDO.getMailId()));
        }
        mail.close();// 关闭连接
    }


    // 查看指定的(已读、未读)邮件
    public PageView<MailBean> seeMail(String name, String password,
                                      String folderType, boolean type, int pageNo, int pageSize) throws Exception {
        PageView<MailBean> pageView = new PageView<>(pageSize, pageNo);
        ReceiveMail mail = new ReceiveMail(name, password);// 初始化接收邮件参数
        IMAPFolder folder = mail.openFolder(folderType, Folder.READ_WRITE);

//        getSearchTerm(type);
        //查询黑名单id
        List<String> bwlist = bwListMapper.getList(BWList.BWTYPE1,BWList.LOTYPE1,name);
        long[] uids = null;
        if(bwlist != null && bwlist.size() > 0) {
            NotTerm[] nnotTerm = new NotTerm[bwlist.size()];
            for (int i = 0; i < bwlist.size(); i++) {
                FromStringTerm fromTerm = new FromStringTerm(bwlist.get(i));
                NotTerm notTerm = new NotTerm(fromTerm);
                nnotTerm[i] = notTerm;
            }
            AndTerm andTerm = new AndTerm(nnotTerm);
            AndTerm andTerm1 = new AndTerm(andTerm, getSearchTerm(type));
            uids = mail.getMessageUIDs(folder, andTerm1);
        }else{
            uids = mail.getMessageUIDs(folder,getSearchTerm(type));
        }
        MailInfo mailinfo = mail.getMailList(pageView.getFirstResult(), pageView.getMaxresult() + pageView.getFirstResult(), uids);
        System.out.println("页面总数：" + pageView.getTotalpage());
        if (mailinfo != null) {
            pageView.setQueryResult(mailinfo.getMailBeanList(), uids.length);
            pageView.setNewAndUnreadMail(mailinfo.getNewMessageCount(),
                    mailinfo.getUnreadMessageCount());
        }
        mail.close();
        return pageView;
    }

    //清空已删除
    public void clearDelete(String name, String password,String folderType)throws Exception{
        ReceiveMail mail = new ReceiveMail(name, password);// 初始化接收邮件参数
        mail.openFolder(folderType, Folder.READ_WRITE);
        IMAPFolder folder = mail.openFolder(folderType, Folder.READ_WRITE);
        long[] uidArray = mail.getMessageUIDs(folder);
        mail.deleteMessage(folderType, uidArray);
        mail.close();
    }

    // 根据uid查看邮件
    public MailBean getMailBean(String name, String password, String folderType, long uid) throws Exception {
        //folderType 1收件箱2草稿箱3已发送4已删除5垃圾邮件
        MailConstant mailConstant = new MailConstant();
        //name = mailConstant.FightAdmin(name, folderType);
        ReceiveMail mail = new ReceiveMail(name, password);// 初始化接收邮件参数
        mail.openFolder(folderType, Folder.READ_WRITE);
        MailBean mailBean = mail.getMessageByUID(uid);
        mail.close();
        return mailBean;
    }

    // 得到邮件指定的查看方式
    private SearchTerm getSearchTerm(boolean type) {
        if (!type) {
            return new FlagTerm(Flag.SEEN.getFlag(), false);// 查看未读邮件
        } else {
            return new FlagTerm(Flag.SEEN.getFlag(), true);// 查看已读邮件
        }
    }

    // 根据前台string类型的数据返回邮件夹类型
//    private String getMailFolderName(String type) {
//        if ("moveDraft".equalsIgnoreCase(type)) {
//            return MailConstant.FOLDER_DRAFT;
//        } else if ("moveSended".equalsIgnoreCase(type)) {
//            return MailConstant.FOLDER_SENDED;
//        } else if ("moveDelete".equalsIgnoreCase(type)) {
//            return MailConstant.FOLDER_DELETE;
//        } else if ("moveInbox".equalsIgnoreCase(type)) {
//            return MailConstant.FOLDER_INBOX;
//        } else if ("moveSpam".equalsIgnoreCase(type)) {
//            return MailConstant.FOLDER_SPAM;
//        }
//        return MailConstant.FOLDER_DELETE;
//    }

    // 下载附件（将附件保存到指定的路径中）
    public void attachmentDownLoad(String name, String password,
                                   String folderType, long uid, String fileName, String path)
            throws Exception {
        ReceiveMail mail = new ReceiveMail(name, password);// 初始化接收邮件参数
        mail.openFolder(folderType, Folder.READ_WRITE);
        mail.getMessageByUID(uid, true, fileName, path);// 保存附件到指定的路径中
        mail.close();
    }
}
