package com.hengyunsoft.platform.mail.repository.service.mail.receive;

import com.hengyunsoft.exception.BizException;
import com.hengyunsoft.platform.mail.constant.MailConstant;
import com.hengyunsoft.platform.mail.entity.domain.Attachment;
import com.hengyunsoft.platform.mail.entity.domain.MailBean;
import com.hengyunsoft.platform.mail.entity.domain.MailSession;
import com.sun.mail.imap.IMAPFolder;
import com.sun.mail.imap.IMAPMessage;
import com.sun.mail.imap.IMAPStore;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeUtility;
import javax.mail.search.SearchTerm;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import static com.hengyunsoft.commons.exception.core.MailExceptionCode.MAIL_NOT_EXIST;

/**
 * 类说明：接收电子邮件
 *
 * @author 作者: LiuJunGuang
 * @version 创建时间：2011-7-23 下午04:45:34
 */
public class ReceiveMail {
    private String host = "localhost";
    private String username = null;
    private String password = null;
    private IMAPStore store = null;
    private MailInfo mailInfo = null;
    private IMAPFolder folder = null;
    private boolean saveAttachments = false;// 是否保存附件
    private String attachmentName = null;// 附件的名称
    private String folderName = null;// 邮件夹名称
    private String path = null;// 附件保存的位置
    private StringBuffer content = new StringBuffer();
    //    private StringBuffer filename = new StringBuffer();
    private List<Attachment> attachmentList = new ArrayList<>();

    /**
     * 初始化接收邮件的构造方法
     *
     * @param username 用户名
     * @param password 密码
     * @throws MessagingException
     */
    public ReceiveMail(String username, String password)
            throws MessagingException {
        this.username = username;
        this.password = password;
        mailInfo = new MailInfo();
        connection();// 连接到邮件服务器
    }

    // 创建与服务器的连接
    private void connection() throws MessagingException {
        Session session = MailSession.getInstance(MailConstant.EMAIL_CONFIG_PATH);
        store = (IMAPStore) session.getStore();
        // 连接到邮件服务器
        //folderType 1收件箱2草稿箱3已发送4已删除5垃圾邮件
//        MailConstant mailConstant = new MailConstant();
        username = MailConstant.fightAdmin(username);
        store.connect(host, username, password);
    }

    // 打开指定的收件夹folderName,model文件夹打开模式
    public IMAPFolder openFolder(String folderName, int model)
            throws MessagingException {
        this.folderName = folderName;
        folder = (IMAPFolder) store.getFolder(folderName);
        if (folder.exists())
            folder.open(model);
        else {
            folder.create(Folder.HOLDS_MESSAGES);
            folder.open(model);
        }
        return folder;
    }

    // 保存邮件到指定的收件夹中
    public boolean copyMessage(Message[] message, String folderName)
            throws MessagingException {
        openFolder(folderName, Folder.READ_WRITE);// 打开指定的邮件夹
        folder.appendMessages(message);// 将邮件追加到指定的邮件夹中
        return false;
    }

    // 移动邮件到指定的邮件夹下
    public void moveMessage(String srcFolder, String destFolder, long[] uid)
            throws MessagingException {
        IMAPFolder src = openFolder(srcFolder, Folder.READ_WRITE);
        IMAPFolder dest = openFolder(destFolder, Folder.READ_WRITE);
        Message[] messages = src.getMessagesByUID(uid);
        if (messages == null || messages[0] == null) {
            throw new BizException(MAIL_NOT_EXIST.getCode(), MAIL_NOT_EXIST.getMsg());
        }
        src.copyMessages(messages, dest);// 复制邮件到指定的邮件夹中
        src.setFlags(messages, Flag.DELETED.getFlag(), true);// 将源邮件夹中的邮件设置为删除
        if (dest.isOpen()) {// 关闭目标邮件夹
            dest.close(true);
        }
        if (src.isOpen()) {// 关闭目标邮件夹
            src.close(true);
        }
    }

    // 彻底删除邮件
    public void deleteMessage(String folderType, long[] uid)
            throws MessagingException {
        IMAPFolder folder = openFolder(folderType, Folder.READ_WRITE);
        Message[] messages = folder.getMessagesByUID(uid);
        folder.setFlags(messages, Flag.DELETED.getFlag(), true);// 将源邮件夹中的邮件设置为删除
        if (folder.isOpen()) {// 关闭目标邮件夹
            folder.close(true);
        }
    }

    /**
     * 接收收件夹中的全部邮件,返回封装了邮件总数、新邮件数、未读邮件数、邮件列表的MailInfo
     *
     * @throws Exception
     */
    public MailInfo getMailList() throws Exception {
        Message[] messages = folder.getMessages();
        setMailInfo();// 设置邮件的基本信息
        getMessageList(messages);// 将邮件封装成邮件列表
        return mailInfo;
    }

    // 得到符合条件的邮件
    public MailInfo getMailList(SearchTerm term) throws Exception {
        Message[] messages = folder.search(term);
        setMailInfo();// 设置邮件的基本信息
        getMessageList(messages);// 设置邮件消息内容
        return mailInfo;
    }

    /**
     * 得到某个邮件夹下的所有邮件的UID （返回long[]）
     *
     * @throws MessagingException
     */
    public long[] getMessageUIDs(IMAPFolder folder) throws MessagingException {
        long[] uids = new long[folder.getMessageCount()];
        Message[] messages = folder.getMessages();
        int length = messages.length;
        if (length > 0) {
            for (int i = 0; i < length; i++) {//
                uids[length - 1 - i] = folder.getUID(messages[i]);
            }
            return uids;
        }
        return null;
    }

    // 得到符合条件的邮件Uid
    public long[] getMessageUIDs(IMAPFolder folder, SearchTerm term)
            throws MessagingException {
        Message[] messages = folder.search(term);
        long[] uids = new long[messages.length];
        int length = messages.length;
        if (length > 0) {
            for (int i = 0; i < length; i++) {//
                uids[length - 1 - i] = folder.getUID(messages[i]);
            }
            return uids;
        }
        return null;
    }

    /**
     * 得到从from开始到to之间的邮件，不包括to邮件
     *
     * @throws Exception
     */
    public MailInfo getMailList(int from, int to, long[] uids) throws Exception {
        if (uids != null && uids.length > 0) {
            if (to > uids.length)
                to = uids.length;
            long[] subUids = Arrays.copyOfRange(uids, from, to);
            Message[] messages = folder.getMessagesByUID(subUids);
            setMailInfo();// 设置邮件的基本信息
            getMessageList(messages);// 设置邮件消息内容
            return mailInfo;
        }
        return null;
    }

    // 关闭各种资源
    public void close() {
        try {
            if (folder != null && folder.isOpen())
                folder.close(true);
            if (store != null && store.isConnected())
                store.close();
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

    /**
     * 将邮件封装成一个邮件列表
     *
     * @throws Exception
     */
    private List<MailBean> getMessageList(Message[] messages) throws Exception {
        List<MailBean> list = new LinkedList<>();
        for (Message message : messages) {
            IMAPMessage m = (IMAPMessage) message;
            list.add(setMailBean(m));// 将每个邮件体封装成一个MailBean，并将MailBean添加到list中
        }
        mailInfo.setMailBeanList(list);
        return list;
    }

    /**
     * 设置邮件基本信息(发送人、接收人、抄送、主题、大小、发送日期、标记、邮件id、邮件UID)
     *
     * @throws Exception
     */
    private MailBean setMailBean(IMAPMessage m) throws Exception {
        MailBean mail = new MailBean();
        mail.setSubject(m.getSubject());
        mail.setDate(m.getSentDate());
        mail.setFrom(decode(InternetAddress.toString(m.getFrom())));// 设置发件人
        mail.setCc(decode(InternetAddress.toString(m.getRecipients(Message.RecipientType.CC))));
        mail.setTo(decode(InternetAddress.toString(m.getRecipients(Message.RecipientType.TO))));
        mail.setMessageID(m.getMessageID());
        mail.setSize(m.getSize());
        mail.setMessageUID(folder.getUID(m));
        mail.setFlags(setFlags(m));
        mail.setFolderType(folderName);
        mail.setIsReplySign(isReplySign(m));
        return mail;
    }

    /**
     * 判断是否存在回执参数
     * @param msg
     * @return
     * @throws MessagingException
     */
    public static boolean isReplySign(IMAPMessage msg) throws MessagingException {
        boolean replySign = false;
        String[] headers = msg.getHeader("Disposition-Notification-To");
        if (headers != null)
            replySign = true;
        return replySign;
    }

    // 封装邮件的标记
    private String setFlags(IMAPMessage m) throws MessagingException {
        Flags flags = m.getFlags();
        StringBuffer sb = new StringBuffer();
        Flags.Flag[] sf = flags.getSystemFlags(); // get the system flags
        for (int i = 0; i < sf.length; i++) {
            String s;
            Flags.Flag f = sf[i];
            if (f == Flags.Flag.ANSWERED)
                s = "Answered";
            else if (f == Flags.Flag.DELETED)
                s = "Deleted";
            else if (f == Flags.Flag.DRAFT)
                s = "Draft";
            else if (f == Flags.Flag.FLAGGED)
                s = "Flagged";
            else if (f == Flags.Flag.RECENT)
                s = "Recent";
            else if (f == Flags.Flag.SEEN)
                s = "Seen";
            else
                continue; // skip it
            sb.append(s);
            sb.append(',');
        }
        if (sb.length() > 0)
            sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

    /**
     * 设置邮件的公共信息(新邮件个数、邮件总数、未读邮件个数)
     */
    private void setMailInfo() throws MessagingException {
        mailInfo.setNewMessageCount(folder.getNewMessageCount());
        mailInfo.setMessageCount(folder.getMessageCount());
        mailInfo.setUnreadMessageCount(folder.getUnreadMessageCount());
    }

    // 根据指定的uid找到邮件具体内容(不保存附件)
    public MailBean getMessageByUID(long uid) throws Exception {
        return getMessageByUID(uid, false, null, null);
    }

    // 根据指定的uid找到邮件具体内容
    public MailBean getMessageByUID(long uid, boolean saveAttachments,
                                    String attachmentName, String path) throws Exception {
        this.saveAttachments = saveAttachments;
        this.attachmentName = attachmentName;
        this.path = path;
        IMAPMessage m = (IMAPMessage) folder.getMessageByUID(uid);
        if (m == null) {
            return null;
        }
        m.setFlag(Flags.Flag.SEEN, true);// 设置邮件为已读
        MailBean mailbean = setMailBean(m);
        clear();// 清空缓存附件名与正文信息信息
        dumpPart(m);
        setContent(mailbean);// 设置邮件正文和附件信息
        return mailbean;
    }

    // 清空附件信息和正文信息
    private void clear() {
        content.delete(0, content.length());
//        filename.delete(0, filename.length());
        attachmentList = new ArrayList<>();
    }

    // 设置邮件正文和附件信息
    private void setContent(MailBean mailbean) {
        mailbean.setContent(content.toString());
        mailbean.setFile(attachmentList);
    }

    // 设置邮件的标记
    public void setMessagesFlags(long[] uids, Flag flag, boolean value)
            throws MessagingException {
        Message[] messages = folder.getMessagesByUID(uids);
        if (messages == null || messages[0] == null) {
            throw new BizException(MAIL_NOT_EXIST.getCode(), MAIL_NOT_EXIST.getMsg());
        }
        folder.setFlags(messages, flag.getFlag(), value);
    }

    // 解码
    private String decode(String mailadd) throws UnsupportedEncodingException {
        if (mailadd != null && !"".equals(mailadd)) {
            return MimeUtility.decodeText(mailadd);
        } else
            return null;
    }

    // 遍历正文内容
    private void dumpPart(Part p) throws Exception {
        String fn = decode(p.getFileName());
        String[] fileSize = p.getHeader("HEADER_FILE_SIZE");
        if(fileSize != null){
            Integer length = Integer.parseInt(fileSize[0].toString());
            for(int i = 0;i < length; i++){
                String[] fileName = p.getHeader(MailConstant.HEADER_FILE_NAME+"_"+i);
                String[] fileUrl = p.getHeader(MailConstant.HEADER_FILE_URL+"_"+i);
                if(fileName != null && fileUrl != null){
                    attachmentList.add(new Attachment(fileUrl[0],decode(fileName[0])));
                }
            }
        }
//        if (fn != null && fn.length() > 0) {
//            String[] header = p.getHeader(MailConstant.HEADER_FILE_URL);
//            attachmentList.add(new Attachment(header != null && header.length > 0 ? header[0] : null, fn));
//        }
        if (p.isMimeType("text/plain")) {
            if (!saveAttachments)
                content.append((String) p.getContent());// 添加邮件内容
        } else if (p.isMimeType("multipart/*")) {
            Multipart mp = (Multipart) p.getContent();
            int count = mp.getCount();
            for (int i = 0; i < count; i++)
                dumpPart(mp.getBodyPart(i));// 循环遍历每个邮件体
        } else if (p.isMimeType("message/rfc822")) {
            dumpPart((Part) p.getContent());
        } else {
            if (!saveAttachments) {
                Object o = p.getContent();
                if (o instanceof String) {
                    content.append((String) o);
                }
            }
        }
        //下载附件接口才会调用这个
        if (saveAttachments && !p.isMimeType("multipart/*")) {
            String disp = p.getDisposition();
            if (disp == null || disp.equalsIgnoreCase(Part.ATTACHMENT)) {
                if (fn != null && fn.equals(attachmentName)) {
                    try {// 保存附件
                        File saveFile = new File(path + "/" + fn);
                        if (!saveFile.getParentFile().exists())
                            saveFile.getParentFile().mkdirs();
                        ((MimeBodyPart) p).saveFile(saveFile);// 保存附件到指定的路径中
                        return;
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                }
            }
        }
    }
}
