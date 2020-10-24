package com.hengyunsoft.platform.mail.impl;


import java.util.List;

import javax.annotation.Resource;

import com.hengyunsoft.base.Result;
import com.hengyunsoft.commons.utils.context.DozerUtils;
import com.hengyunsoft.page.plugins.openapi.OpenApiReq;
import com.hengyunsoft.platform.mail.constant.FolderType;
import com.hengyunsoft.platform.mail.constant.MailConstant;
import com.hengyunsoft.platform.mail.dto.DeleteMailDTO;
import com.hengyunsoft.platform.mail.dto.DeleteMailListDTO;
import com.hengyunsoft.platform.mail.dto.MarkMailDTO;
import com.hengyunsoft.platform.mail.dto.MoveMailDTO;
import com.hengyunsoft.platform.mail.dto.SeeMailDTO;
import com.hengyunsoft.platform.mail.dto.ViewMailDTO;
import com.hengyunsoft.platform.mail.entity.domain.MailBean;
import com.hengyunsoft.platform.mail.entity.domain.MoveMailListDO;
import com.hengyunsoft.platform.mail.entity.domain.PageView;
import com.hengyunsoft.platform.mail.repository.service.user.UserReceiveMailService;
import com.hengyunsoft.platform.mail.utils.AccountUtils;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * ApiParam
 * This is a Description
 *
 * @auth tangyh
 * @date 2018/07/25
 */
@RestController
@Slf4j
@RequestMapping("/receive")
@Api(value = "收件箱", description = "收件箱")
public class UserReceiveMailController {
    @Autowired
    DozerUtils dozerUtils;
    @Resource
    private UserReceiveMailService userReceiveMailService;

    @ApiOperation(value = "查询邮件", notes = "查询指定邮件夹中的邮件 不传默认查收件夹")
//    @ApiImplicitParams({
//            @ApiImplicitParam(name = "data", value = "邮件夹类型 INBOX:收件夹, SENDED:已发送, DRAFT:草稿箱, DELETE:已删除 SPAM:垃圾邮件夹 ABNORMAL: 异常邮件  VIRUSES:病毒邮件  xxxx:自定义文件夹", dataType = "string", paramType = "query"),
//    })
    @RequestMapping(value = "/page", method = RequestMethod.POST)
    public Result<PageView<MailBean>> page(
            @ApiParam(name = "openApiReq", value = "openApiReq.data: 邮件夹类型 INBOX:收件夹, SENDED:已发送, DRAFT:草稿箱, DELETE:已删除 SPAM:垃圾邮件夹 ABNORMAL: 异常邮件  VIRUSES:病毒邮件 TRASH:异常邮件  xxxx:自定义文件夹")
            @RequestBody OpenApiReq<String> openApiReq) throws Exception {
        String username = AccountUtils.getAccount();
        String password = MailConstant.DEFAULT_PASSWORD;
        String data = openApiReq.getData();
        data = data == null ? FolderType.INBOX.toString() : data;
        log.info("username={}, password={}", username, password);
        PageView<MailBean> pageView = userReceiveMailService.getMailInfoPageView(username,
                password, data, openApiReq.getPageNo(), openApiReq.getPageSize());
        return Result.success(pageView);
    }

    // 移动邮件集合
    @ApiOperation(value = "移动邮件集合", notes = "移动邮件集合")
    @RequestMapping(value = "/saveMoveMailList", method = RequestMethod.POST)
    public Result<String> removeMailList(@RequestBody DeleteMailListDTO dto) throws Exception {
        String username = AccountUtils.getAccount();
        String password = MailConstant.DEFAULT_PASSWORD;
        List<MoveMailListDO> list = dozerUtils.mapList(dto.getData(),MoveMailListDO.class);
        userReceiveMailService.moveMailList(list,username,password);
        // 将邮件移动到“已删除”收件夹下
        return Result.success("移动邮件集合成功");
    }

    // 删除邮件
    @ApiOperation(value = "删除邮件", notes = "删除邮件")
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public Result<String> deleteMail(@RequestBody DeleteMailDTO deleteMail) throws Exception {
        String username = AccountUtils.getAccount();
        String password = MailConstant.DEFAULT_PASSWORD;
        userReceiveMailService.deleteMail(username, password,
                deleteMail.getFolderType(), deleteMail.getMailId());// 将邮件移动到“已删除”收件夹下
        return Result.success("删除成功");
    }

    // 彻底删除邮件集合
    @ApiOperation(value = "彻底删除邮件集合", notes = "彻底删除邮件集合")
    @RequestMapping(value = "/deleteByForeverList", method = RequestMethod.POST)
    public Result<String> deleteMailForeverList(@RequestBody DeleteMailListDTO dto) throws Exception {
        String username = AccountUtils.getAccount();
        String password = MailConstant.DEFAULT_PASSWORD;
        List<MoveMailListDO> list = dozerUtils.mapList(dto.getData(),MoveMailListDO.class);
        userReceiveMailService.deleteMailForeverList(list,username, password);// 将邮件"彻底删除"收件夹下
        return Result.success("删除邮件集合成功");
    }

    // 彻底删除邮件
    @ApiOperation(value = "彻底删除邮件", notes = "彻底删除邮件")
    @RequestMapping(value = "/deleteByForever", method = RequestMethod.POST)
    public Result<String> deleteMailForever(@RequestBody DeleteMailDTO deleteMail) throws Exception {
        String username = AccountUtils.getAccount();
        String password = MailConstant.DEFAULT_PASSWORD;
        userReceiveMailService.deleteMailForever(username, password,
                deleteMail.getFolderType(), deleteMail.getMailId());// 将邮件"彻底删除"收件夹下
        return Result.success("删除成功");
    }

    // 清空已删除邮件
    @ApiOperation(value = "清空已删除邮件", notes = "清空已删除邮件")
    @RequestMapping(value = "/clearDelete", method = RequestMethod.POST)
    public Result<String> deleteClear() throws Exception {
        String username = AccountUtils.getAccount();
        String password = MailConstant.DEFAULT_PASSWORD;
        userReceiveMailService.clearDelete(username,password,MailConstant.FOLDER_DELETE);
        return Result.success("删除成功");
    }

    // 标记邮件是否已读
    @ApiOperation(value = "标记邮件是否已读", notes = "标记邮件是否已读")
    @RequestMapping(value = "/mark", method = RequestMethod.POST)
    public Result<String> updateMarkMail(@RequestBody MarkMailDTO markMail) throws Exception {
        String username = AccountUtils.getAccount();
        String password = MailConstant.DEFAULT_PASSWORD;
        userReceiveMailService.setMailFlags(username, password,
                markMail.getFolderType(), markMail.getMailId(), markMail.getIsRead());
        return Result.success("标记成功");
    }

    // 移动邮件到指定的邮件夹
    @RequestMapping(value = "/move", method = RequestMethod.POST)
    @ApiOperation(value = "移动邮件到指定的邮件夹", notes = "移动邮件到指定的邮件夹")
    public Result<String> removeMail(@RequestBody MoveMailDTO moveMail) throws Exception {
        String username = AccountUtils.getAccount();
        String password = MailConstant.DEFAULT_PASSWORD;
        userReceiveMailService.moveMail(username, password, moveMail.getFolderType(),
                moveMail.getMoveType(), moveMail.getMailId());// 移动邮件到指定的邮件夹中
        return Result.success("移动成功");
    }

    // 查看指定类型的邮件（已读、未读）
    @ApiOperation(value = "查看指定类型的邮件（已读、未读）", notes = "查看指定类型的邮件（已读、未读）")
    @RequestMapping(value = "/see", method = RequestMethod.POST)
    public Result<PageView<MailBean>> seeMail(@RequestBody OpenApiReq<SeeMailDTO> openApiReq) throws Exception {

        String username = AccountUtils.getAccount();
        String password = MailConstant.DEFAULT_PASSWORD;
        SeeMailDTO data = openApiReq.getData();

        PageView<MailBean> pageView = userReceiveMailService.seeMail(username, password, data.getFolderType(),
                data.getIsRead(), openApiReq.getPageNo(), openApiReq.getPageSize());
        return Result.success(pageView);
    }

    // 阅读邮件
    @ApiOperation(value = "阅读邮件", notes = "阅读邮件")
    @RequestMapping(value = "/view", method = RequestMethod.GET)
    public Result<MailBean> readMail(ViewMailDTO viewMail) throws Exception {
        String username = AccountUtils.getAccount();
        String password = MailConstant.DEFAULT_PASSWORD;
        MailBean mailBean = userReceiveMailService.getMailBean(username, password, viewMail.getFolderType(), viewMail.getMailId());
//        writeMail(mailBean.getContent());// 将邮件的正文内容写入到readMail.html文件中

        return Result.success(mailBean);
    }

//    // 将邮件正文内容写入到readMail.html文件中
//    @RequestMapping(value = "/page", method = RequestMethod.POST)
//    private void writeMail(String content) throws IOException {
//        String path = httpsession.getServletContext().getRealPath("/") + "readMail.html";
//        FileWriter fw = new FileWriter(path);
//        fw.write(content);
//        fw.close();
//    }

//    // 邮件附件的下载
//    @RequestMapping(value = "/page", method = RequestMethod.POST)
//    public String attachmentDownload() {
//        try {
//            String username = "lyr";
//            String password = "lyr";
//            path = httpsession.getServletContext().getRealPath("/")
//                    + "fileDownLoad/" + user.getName();
//            userReceiveMailService.attachmentDownLoad(username, password, // 将附件保存到指定的路径中
//                    folderType, uid, fileName, path);
//        } catch (Exception e) {
//            e.printStackTrace();
//            return "downloadFail";
//        }
//        return "download";
//    }

}
