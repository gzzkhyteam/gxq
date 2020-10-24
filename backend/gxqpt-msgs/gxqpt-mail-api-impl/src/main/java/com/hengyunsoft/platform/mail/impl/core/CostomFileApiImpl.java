package com.hengyunsoft.platform.mail.impl.core;

import com.hengyunsoft.base.Result;
import com.hengyunsoft.commons.exception.core.MailExceptionCode;
import com.hengyunsoft.commons.utils.context.DozerUtils;
import com.hengyunsoft.platform.mail.constant.FolderType;
import com.hengyunsoft.platform.mail.constant.MailConstant;
import com.hengyunsoft.platform.mail.dto.core.ResponseCostomFileAllDTO;
import com.hengyunsoft.platform.mail.dto.core.ResponseCostomFileDTO;
import com.hengyunsoft.platform.mail.entity.core.po.CustomFile;
import com.hengyunsoft.platform.mail.entity.domain.MailBean;
import com.hengyunsoft.platform.mail.entity.domain.PageView;
import com.hengyunsoft.platform.mail.entity.po.BWList;
import com.hengyunsoft.platform.mail.repository.core.example.CustomFileExample;
import com.hengyunsoft.platform.mail.repository.core.service.CustomFileApiService;
import com.hengyunsoft.platform.mail.repository.dao.BWListMapper;
import com.hengyunsoft.platform.mail.repository.service.mail.receive.MailInfo;
import com.hengyunsoft.platform.mail.repository.service.mail.receive.ReceiveMail;
import com.hengyunsoft.platform.mail.repository.service.user.UserReceiveMailService;
import com.hengyunsoft.platform.mail.utils.AccountUtils;
import com.hengyunsoft.utils.BizAssert;
import com.sun.mail.imap.IMAPFolder;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.mail.Folder;
import javax.mail.search.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * 版权：中科恒运软件科技股份有限公司贵阳分公司
 * 描述：自定义文件夹API
 * 修改人：wt
 * 修改时间：2018/7/30
 * 修改内容：
 */
@Api(value = "API - CostomFileApiImpl.java", description = "自定义文件夹API")
@RestController
@RequestMapping("dataapi/sostomfile/")
@Slf4j
public class CostomFileApiImpl {
    @Autowired
    private DozerUtils dozerUtils;
    @Autowired
    private CustomFileApiService costomFileApiService;
    @Resource
    private UserReceiveMailService userReceiveMailService;
    @Autowired
    private BWListMapper bwListMapper;

    /**
     * 描述：查询自定义文件夹
     * 参数：
     * 返回值：List<ResponseCostomFileDTO>
     * 修改人：wt
     * 修改时间：2018/8/8
     * 修改内容：
     */
    @RequestMapping(value = "/findAll", method = RequestMethod.GET)
    @ApiOperation(value = "查询用户文件夹", notes = "查询用户文件夹")
    public Result<List<ResponseCostomFileAllDTO>> findAllFile() throws Exception {
        //基本数据的获取
        String mailAccount = AccountUtils.getAccountSuffix();
        String account = AccountUtils.getAccount();
        String password = MailConstant.DEFAULT_PASSWORD;
        log.info("mailAccount={}, account={}, password={}", mailAccount, account, password);
        long start = System.currentTimeMillis();
        //自定义文件夹
        CustomFileExample example = new CustomFileExample();
        example.createCriteria().andCreateUserEqualTo(mailAccount);
        List<CustomFile> list = costomFileApiService.find(example);

        log.info("list.size={}", list.size());
        List<ResponseCostomFileAllDTO> result = new ArrayList<ResponseCostomFileAllDTO>();

        ReceiveMail mail = new ReceiveMail(account, password);// 初始化接收邮件参数
        List<String> bwlist = bwListMapper.getList(BWList.BWTYPE1, BWList.LOTYPE1,account);
        log.info("bwlist.size={}", bwlist.size());

        Integer inboxTotal = getFileTotle(mail, bwlist, FolderType.INBOX.toString(), 1);
        result.add(new ResponseCostomFileAllDTO(FolderType.INBOX.getDescribe(), FolderType.INBOX.toString(), inboxTotal));
        log.info("inboxTotal={}", inboxTotal);

//        Integer abnormalTotal = getFileTotle(mail, bwlist, FolderType.ABNORMAL.toString(), 1);
        result.add(new ResponseCostomFileAllDTO(FolderType.ABNORMAL.getDescribe(),FolderType.ABNORMAL.toString(), 0));
        log.info("abnormalTotal={}", 0);

        Integer virusesTotal = getFileTotle(mail, bwlist, FolderType.VIRUSES.toString(), 1);
        result.add(new ResponseCostomFileAllDTO(FolderType.VIRUSES.getDescribe(), FolderType.VIRUSES.toString(), virusesTotal));
        log.info("virusesTotal={}", virusesTotal);

        Integer trashTotal = getFileTotle(mail, bwlist, FolderType.TRASH.toString(),  0);
        result.add(new ResponseCostomFileAllDTO(FolderType.TRASH.getDescribe(), FolderType.TRASH.toString(), trashTotal));
        log.info("trashTotal={}", trashTotal);

        Integer draftTotal = getFileTotle(mail, bwlist, FolderType.DRAFT.toString(),  0);
        result.add(new ResponseCostomFileAllDTO(FolderType.DRAFT.getDescribe(), FolderType.DRAFT.toString(), draftTotal));
        log.info("draftTotal={}", draftTotal);
        mail.close();

        result.add(new ResponseCostomFileAllDTO(FolderType.SENDED.getDescribe(), FolderType.SENDED.toString(), 0));
        result.add(new ResponseCostomFileAllDTO(FolderType.DELETE.getDescribe(),FolderType.DELETE.toString(),  0));
        ResponseCostomFileAllDTO dto = new ResponseCostomFileAllDTO("自定义文件夹", "",  0);
        if (!list.isEmpty()) {
            dto.setCostomFIle(dozerUtils.mapList(list, ResponseCostomFileAllDTO.class));
        }
        result.add(dto);
        log.info("result={}, times={} ", result, System.currentTimeMillis() - start);
        return Result.success(result);
    }

    /**
     * 获取邮件数量
     *
     * @param mail       邮件对象
     * @param folderType 邮件类型
     * @param type       1 未读邮件数 0 所有邮件数
     * @return
     * @throws Exception
     */
    private Integer getFileTotle(ReceiveMail mail, List<String> bwlist, String folderType, Integer type) throws Exception {
        Integer result = 0;
        PageView<MailBean> pageView = new PageView<>(10, 1);
        IMAPFolder folder = mail.openFolder(folderType, Folder.READ_WRITE);
        SentDateTerm sentDateTerm = new SentDateTerm(ComparisonTerm.LE, new Date());
        //查询黑名单id
        long[] uids = null;
        if (bwlist != null && bwlist.size() > 0) {
            NotTerm[] nnotTerm = new NotTerm[bwlist.size()];
            for (int i = 0; i < bwlist.size(); i++) {
                FromStringTerm fromTerm = new FromStringTerm(bwlist.get(i));
                NotTerm notTerm = new NotTerm(fromTerm);
                nnotTerm[i] = notTerm;
            }
            AndTerm andTerm = new AndTerm(nnotTerm);
            AndTerm andTermDate = new AndTerm(sentDateTerm,andTerm);
            uids = mail.getMessageUIDs(folder, andTermDate);
        } else {
            uids = mail.getMessageUIDs(folder,sentDateTerm);
        }
        log.info("uids={}", uids != null ? uids.length : uids);

//        if (type == 1) {
//            result = folder.getUnreadMessageCount(); //未读
//        } else {
//            result = folder.getMessageCount();//邮件总数
//        }

        MailInfo mailinfo = mail.getMailList(pageView.getFirstResult(), pageView.getMaxresult() + pageView.getFirstResult(), uids);
        log.info("mailinfo={}", mailinfo == null);
        if (mailinfo != null) {
            if (type == 1) {
                result = unreadMessageCount(mailinfo.getMailBeanList());
            } else {
                result = mailinfo.getMessageCount();
            }
        }
        log.info("result={}", result);

        return result;
    }

    private Integer unreadMessageCount(List<MailBean> mailBeanList){
        Integer result = 0;
        for (MailBean mailBean : mailBeanList){
            if(!mailBean.getRead()){
                ++result;
            }
        }
        return result;
    }


    /**
     * 描述：查询自定义文件夹
     * 参数：
     * 返回值：List<ResponseCostomFileDTO>
     * 修改人：wt
     * 修改时间：2018/7/30
     * 修改内容：
     */
    @RequestMapping(value = "/find", method = RequestMethod.GET)
    @ApiOperation(value = "查询自定义文件夹", notes = "查询自定义文件夹")
    public Result<List<ResponseCostomFileDTO>> find() {
        //基本数据的获取
        String mailAccount = AccountUtils.getAccountSuffix();

        CustomFileExample example = new CustomFileExample();
        example.createCriteria().andCreateUserEqualTo(mailAccount);
        List<CustomFile> list = costomFileApiService.find(example);
        return Result.success(dozerUtils.mapList(list, ResponseCostomFileDTO.class));
    }

    /**
     * 描述：保存自定义文件夹
     * 参数：fileName
     * 返回值：ResponseCostomFileDTO
     * 修改人：wt
     * 修改时间：2018/7/30
     * 修改内容：
     */
    @RequestMapping(value = "/save", method = RequestMethod.GET)
    @ApiOperation(value = "保存自定义文件夹", notes = "保存自定义文件夹")
    @ApiResponses({
            @ApiResponse(code = 42000, message = "参数不能为空"),
    })
    public Result<ResponseCostomFileDTO> saveCostomFile(@RequestParam("fileName") String fileName) {
        //数据验证
        BizAssert.assertNotNull(MailExceptionCode.PARAM_NOT_NULL, fileName);

        //基本数据的获取
        String mailAccount = AccountUtils.getAccountSuffix();

        CustomFileExample example = new CustomFileExample();
        example.createCriteria().andCreateUserEqualTo(mailAccount);
        Integer count = costomFileApiService.count(example);
        if (count >= 10) {
            return Result.success(null, "用户文件夹数量超出范围");
        }
        CustomFile customFile = new CustomFile();
        customFile.setFileName(fileName);
        customFile.setFileMark(valimathVal());
        customFile.setCreateTime(Calendar.getInstance().getTime());
        customFile.setCreateUser(mailAccount);
        CustomFile result = costomFileApiService.saveSelective(customFile);
        return Result.success(dozerUtils.map(result, ResponseCostomFileDTO.class));
    }

    //校验数据库中是否存在生产编号，如果存在继续重新生成
    private String valimathVal() {
        String result = "";
        while (true) {
            String val = getMathVal();
            CustomFileExample example = new CustomFileExample();
            example.createCriteria().andFileMarkEqualTo(val);
            Integer count = costomFileApiService.count(example);
            if (count < 1) {
                result = val;
                break;
            }
        }
        return result;
    }

    //生产随机两位大写字母
    private String getMathVal() {
        String str = "ZDY";
        for (int i = 0; i < 2; i++) {//你想生成几个字符的，就修改循环次数
            str = str + (char) (Math.random() * 26 + 'A');
        }
        return str;
    }


    /**
     * 描述：更新自定义文件夹
     * 参数：ResponseCostomFileDTO
     * 返回值：Integer
     * 修改人：wt
     * 修改时间：2018/7/30
     * 修改内容：
     */
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    @ApiOperation(value = "更新自定义文件夹", notes = "更新自定义文件夹")
    @ApiResponses({
            @ApiResponse(code = 42000, message = "参数不能为空"),
    })
    public Result<Integer> updateCostomFile(@RequestBody ResponseCostomFileDTO dto) {
        //数据验证
        BizAssert.assertNotNull(MailExceptionCode.PARAM_NOT_NULL, dto);
        BizAssert.assertNotNull(MailExceptionCode.PARAM_NOT_NULL, dto.getFileName());

        //基本数据的获取
        String mailAccount = AccountUtils.getAccountSuffix();

        CustomFile customFile = dozerUtils.map(dto, CustomFile.class);
        customFile.setUpdateTime(Calendar.getInstance().getTime());
        customFile.setUpdateUser(mailAccount);
        Integer result = costomFileApiService.updateByIdSelective(customFile);
        return Result.success(result);
    }

    /**
     * 描述：删除自定义文件夹
     * 参数：id
     * 返回值：Integer
     * 修改人：wt
     * 修改时间：2018/7/30
     * 修改内容：
     */
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    @ApiOperation(value = "删除自定义文件夹", notes = "删除自定义文件夹")
    @ApiResponses({
            @ApiResponse(code = 42000, message = "参数不能为空"),
    })
    public Result<Integer> deleteCostomFile(@RequestParam("id") Long id) {
        //数据验证
        BizAssert.assertNotNull(MailExceptionCode.PARAM_NOT_NULL, id);

        Integer result = costomFileApiService.deleteById(id);
        return Result.success(result);
    }

}
