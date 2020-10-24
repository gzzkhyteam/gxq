package com.hengyunsoft.platform.mail.open;

import java.util.ArrayList;
import java.util.List;

import javax.mail.Folder;
import javax.mail.search.AndTerm;
import javax.mail.search.BodyTerm;
import javax.mail.search.ComparisonTerm;
import javax.mail.search.FromStringTerm;
import javax.mail.search.OrTerm;
import javax.mail.search.SearchTerm;
import javax.mail.search.SentDateTerm;
import javax.mail.search.SubjectTerm;

import com.hengyunsoft.base.Result;
import com.hengyunsoft.page.plugins.openapi.OpenApiReq;
import com.hengyunsoft.platform.mail.constant.FolderType;
import com.hengyunsoft.platform.mail.constant.MailConstant;
import com.hengyunsoft.platform.mail.dto.open.HighSearchMailOpenDTO;
import com.hengyunsoft.platform.mail.entity.core.po.CustomFile;
import com.hengyunsoft.platform.mail.entity.domain.MailBean;
import com.hengyunsoft.platform.mail.entity.domain.PageView;
import com.hengyunsoft.platform.mail.repository.core.example.CustomFileExample;
import com.hengyunsoft.platform.mail.repository.core.service.CustomFileApiService;
import com.hengyunsoft.platform.mail.repository.service.mail.receive.MailInfo;
import com.hengyunsoft.platform.mail.repository.service.mail.receive.ReceiveMail;
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

import static com.hengyunsoft.commons.exception.core.MailExceptionCode.SEARCH_KEYWORD_NOT_NULL;

/**
 * This is a Description
 *
 * @auth wt
 * @date 2018/08/28
 */

@RestController
@Slf4j
@RequestMapping("/search")
@Api(value = "邮件搜索", description = "邮件搜索")
public class SearchMailOpenApiImpl {
    @Autowired
    private CustomFileApiService costomFileApiService;
    public static final String MAIL_ACCOUNTSUFFIX = "@gygxq.com";

    // 高级搜索
    @ApiOperation(value = "高级搜索", notes = "高级搜索")
    @RequestMapping(value = "/open/high", method = RequestMethod.POST)
    public Result<PageView<MailBean>> queryHighSearch(@RequestBody OpenApiReq<HighSearchMailOpenDTO> openApiReq) throws Exception {
        HighSearchMailOpenDTO data = openApiReq.getData();
        BizAssert.assertNotNull(SEARCH_KEYWORD_NOT_NULL, data);
        String userName = data.getUserName();
        if (userName == null || "".equals(userName)){
            return Result.success(null,"邮件用户为空！");
        }

        String mailAccount = userName + MAIL_ACCOUNTSUFFIX;
        String password = MailConstant.DEFAULT_PASSWORD;

        PageView<MailBean> pageView = highSearchMail(mailAccount,userName, password, openApiReq.getPageNo(), openApiReq.getPageSize(), openApiReq.getData());
        return Result.success(pageView);
    }


    // 高级搜索邮件
    private PageView<MailBean> highSearchMail(String mailAccount,String username, String password,
                                             int pageNo, int pageSize, HighSearchMailOpenDTO searchMailFB)
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
                IMAPFolder folder = mail.openFolder(ft, Folder.READ_WRITE);
                long[] uids = mail.getMessageUIDs(folder, term);
                if (uids == null || uids.length == 0)
                    continue;
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
    private SearchTerm createSearchTerm(HighSearchMailOpenDTO searchMailFB) {
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
