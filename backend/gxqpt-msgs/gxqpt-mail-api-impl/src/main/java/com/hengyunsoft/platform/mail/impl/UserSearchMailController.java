package com.hengyunsoft.platform.mail.impl;

import com.hengyunsoft.base.Result;
import com.hengyunsoft.page.plugins.openapi.OpenApiReq;
import com.hengyunsoft.platform.mail.constant.FolderType;
import com.hengyunsoft.platform.mail.constant.MailConstant;
import com.hengyunsoft.platform.mail.dto.HighSearchMailDTO;
import com.hengyunsoft.platform.mail.dto.SearchMailDTO;
import com.hengyunsoft.platform.mail.entity.core.po.CustomFile;
import com.hengyunsoft.platform.mail.entity.domain.MailBean;
import com.hengyunsoft.platform.mail.entity.domain.PageView;
import com.hengyunsoft.platform.mail.repository.core.example.CustomFileExample;
import com.hengyunsoft.platform.mail.repository.core.service.CustomFileApiService;
import com.hengyunsoft.platform.mail.repository.service.mail.receive.MailInfo;
import com.hengyunsoft.platform.mail.repository.service.mail.receive.ReceiveMail;
import com.hengyunsoft.platform.mail.repository.service.user.UserSearchMailService;
import com.hengyunsoft.platform.mail.utils.AccountUtils;
import com.hengyunsoft.utils.BizAssert;
import com.sun.mail.imap.IMAPFolder;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.mail.Folder;
import javax.mail.search.*;
import java.util.ArrayList;
import java.util.List;

import static com.hengyunsoft.commons.exception.core.MailExceptionCode.SEARCH_KEYWORD_NOT_NULL;

/**
 * This is a Description
 *
 * @auth tangyh
 * @date 2018/07/26
 */

@RestController
@Slf4j
@RequestMapping("/search")
@Api(value = "邮件搜索", description = "邮件搜索")
public class UserSearchMailController {
    @Resource
    private UserSearchMailService userSearchMailService;
    @Autowired
    private CustomFileApiService costomFileApiService;


    // 默认搜索邮件内容
    @ApiOperation(value = "搜索邮件", notes = "默认搜索邮件内容")
    @RequestMapping(value = "", method = RequestMethod.POST)
    public Result<PageView<MailBean>> getSearch(@RequestBody OpenApiReq<SearchMailDTO> openApiReq) throws Exception {
        SearchMailDTO data = openApiReq.getData();
        BizAssert.assertNotNull(SEARCH_KEYWORD_NOT_NULL, data);
        BizAssert.assertNotEmpty(SEARCH_KEYWORD_NOT_NULL, data.getKeyword());

        //默认在 收件夹 搜索
        data.setFolderType(data.getFolderType() == null ? FolderType.INBOX.toString() : data.getFolderType());
        String username = AccountUtils.getAccount();
        String password = MailConstant.DEFAULT_PASSWORD;
        PageView<MailBean> pageView = userSearchMailService.searchMailContent(username,
                password, data.getFolderType(), data.getKeyword(), openApiReq.getPageNo(), openApiReq.getPageSize());
        log.info("搜索成功");
        return Result.success(pageView);
    }

    // 高级搜索
    @ApiOperation(value = "高级搜索", notes = "高级搜索")
    @RequestMapping(value = "/high", method = RequestMethod.POST)
    public Result<PageView<MailBean>> getHighSearch(@RequestBody OpenApiReq<HighSearchMailDTO> openApiReq) throws Exception {
        SearchMailDTO data = openApiReq.getData();
        BizAssert.assertNotNull(SEARCH_KEYWORD_NOT_NULL, data);

        String username = AccountUtils.getAccount();
        String mailAccount = AccountUtils.getAccountSuffix();
        String password = MailConstant.DEFAULT_PASSWORD;

        PageView<MailBean> pageView = highSearchMail(mailAccount,username, password, openApiReq.getPageNo(), openApiReq.getPageSize(), openApiReq.getData());
        return Result.success(pageView);
    }


    // 高级搜索邮件
    private PageView<MailBean> highSearchMail(String mailAccount,String username, String password,
                                             int pageNo, int pageSize, HighSearchMailDTO searchMailFB)
            throws Exception {
        PageView<MailBean> pageView = new PageView<>(pageSize, pageNo);
        ReceiveMail mail = new ReceiveMail(username, password);// 初始化接收邮件参数
        SearchTerm term = createSearchTerm(searchMailFB);
        if (searchMailFB.getFolderType() != null) {
            String ft = searchMailFB.getFolderType();// 得到邮件夹类型
            IMAPFolder folder = mail.openFolder(ft, Folder.READ_WRITE);
            long[] uids = mail.getMessageUIDs(folder, term);
            MailInfo mailinfo = mail.getMailList(pageView.getFirstResult(), pageView.getMaxresult() + pageView.getFirstResult(), uids);
            if (mailinfo != null) {
                pageView.setQueryResult(mailinfo.getMailBeanList(), uids.length);
            }
        } else {// 在所有邮件夹中搜索
            int total = 0;
            List<String> folderTypeList = getFolderTypeList(mailAccount);
            for (String ft : folderTypeList) {
//                String ft = UserReceiveMailService.folderType(i);// 得到邮件夹类型
                //过滤回收站邮件
                if("DELETE".equals(ft)){
                    continue;
                }
                IMAPFolder folder = mail.openFolder(ft, Folder.READ_WRITE);
                long[] uids = mail.getMessageUIDs(folder, term);
                if (uids == null || uids.length == 0){
                    continue;
                }
                total += uids.length;
                MailInfo mailinfo = mail.getMailList(0, uids.length, uids);
                if (mailinfo != null) {
                    if (pageView.getRecords() != null) {
                        pageView.getRecords().addAll(mailinfo.getMailBeanList());
                    } else {
                        pageView.setRecords(mailinfo.getMailBeanList());
                    }
                }
            }
            pageView.setTotalrecord(total);// 设置总记录数
        }
        mail.close();
        return pageView;
    }

    /**
     * 获取所有邮件夹类型（含自定义）
     * @param mailAccount
     * @return
     */
    private List<String> getFolderTypeList(String mailAccount){
        List<String> result = new ArrayList<String>();
        for (FolderType ft : FolderType.values()) {
            result.add(ft.toString());
        }
        CustomFileExample example = new CustomFileExample();
        example.createCriteria().andCreateUserEqualTo(mailAccount);
        List<CustomFile> list = costomFileApiService.find(example);
        for (CustomFile customFile : list){
            result.add(customFile.getFileMark());
        }
        return result;
    }

    // 创建搜素条件
    private SearchTerm createSearchTerm(HighSearchMailDTO searchMailFB) {
        SentDateTerm sentDateTerm = new SentDateTerm(ComparisonTerm.GE, searchMailFB.getDate());// 日期搜索
        String keyword = searchMailFB.getKeyword();
//        try {
//            keyword = new String(keyword.getBytes("ISO-8859-1"), "UTF-8");
//        }catch (Exception e){
//            e.printStackTrace();
//        }
        if (keyword == null || "".equals(keyword)) {
            return sentDateTerm;
        } else {
            BodyTerm bodyTerm = new BodyTerm(keyword);// 在正文中搜索关键字
            FromStringTerm addTrem = null;
            SubjectTerm subjectTerm = null;
            OrTerm orTerm = null;
            if (searchMailFB.getInFromOrTo()) {// 在发件人中搜索
                addTrem = new FromStringTerm(keyword);
                orTerm = new OrTerm(bodyTerm, addTrem);
            }
            if (searchMailFB.getInSubject()) {// 在主题中搜索
                subjectTerm = new SubjectTerm(keyword);
                if (orTerm != null) {
                    orTerm = new OrTerm(orTerm, subjectTerm);
                } else {
                    orTerm = new OrTerm(bodyTerm, subjectTerm);
                }
            }
            if (orTerm != null) {
                return new AndTerm(sentDateTerm, orTerm);
            } else {
                return bodyTerm;
            }
        }
    }
}
