package com.hengyunsoft.platform.mail.open;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hengyunsoft.base.Result;
import com.hengyunsoft.commons.context.BaseContextHandler;
import com.hengyunsoft.commons.exception.core.MailExceptionCode;
import com.hengyunsoft.commons.utils.context.DozerUtils;
import com.hengyunsoft.page.plugins.openapi.OpenApiReq;
import com.hengyunsoft.platform.mail.dto.bwlist.BWPagingDTO;
import com.hengyunsoft.platform.mail.dto.bwlist.ValueDTO;
import com.hengyunsoft.platform.mail.dto.open.BWListOpenDTO;
import com.hengyunsoft.platform.mail.dto.open.QueryBWOpenDTO;
import com.hengyunsoft.platform.mail.entity.po.BWList;
import com.hengyunsoft.platform.mail.repository.service.BWListService;
import com.hengyunsoft.utils.BizAssert;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


/**
 * @author zjr
 * @date 2018/08/08
 */
@Api(value = "API - BWListApiImpl", description = "黑白名单")
@RestController
@RequestMapping("mail")
@Slf4j
public class BWListOpenApiImpl{

    @Autowired
    private BWListService bwListService;
    @Autowired
    private DozerUtils dozerUtils;

    public static final String MAIL_ACCOUNTSUFFIX = "@gygxq.com";

    /**
     * 新增黑名单
     * @param bwListDto
     * @return
     */
    @ApiOperation(value = "新增黑名单", notes = "新增黑名单")
    @RequestMapping(value = "/open/save", method = RequestMethod.POST)
    public Result<Boolean> save(@RequestBody BWListOpenDTO bwListDto){
        String userName = bwListDto.getUserName();
        if (userName == null || "".equals(userName)){
            return Result.success(null,"邮件用户为空！");
        }
        List<BWList> list = new ArrayList<>();
        List<ValueDTO> value = bwListDto.getValue();
        //1.转换
//        BWList bwList1 = dozerUtils.map(bwListDto,BWList.class);
        //2.数据处理
        for (ValueDTO bwList1:value){
            BWList bwList = dozerUtils.map(bwList1,BWList.class);
            bwList.setCreateUser(BaseContextHandler.getAdminId());
            Date nowDate = new Date();
            bwList.setCreateTime(nowDate);
            bwList.setBwType(BWList.BWTYPE1);
            bwList.setLocateType(BWList.LOTYPE1);
            bwList.setCurrentEmail(userName + MAIL_ACCOUNTSUFFIX);
            list.add(bwList);
        }
        bwListService.save(list);
//        if(bw.getId()!=null){
//            return Result.success(dozerUtils.map(bw,BWListDTO.class));
//        }
        return Result.success(true);
    }
    /**
     * 查询黑、白名单分页列表
     * @param openApiReq
     * @return
     */
    @ApiOperation(value = "查询黑、白名单分页列表", notes = "查询黑、白名单分页列表")
    @RequestMapping(value = "/open/findBWList", method = RequestMethod.POST)
    public Result<PageInfo<BWPagingDTO>> findBWList(@RequestBody OpenApiReq<QueryBWOpenDTO> openApiReq){
        QueryBWOpenDTO queryBWDto = openApiReq.getData();
        //1.验证
        if (queryBWDto == null) {
            return Result.success(new PageInfo<>());
        }
        String userName = queryBWDto.getUserName();
        if (userName == null || "".equals(userName)){
            return Result.success(null,"邮件用户为空！");
        }
        //2.设置分页器
        PageHelper.startPage(openApiReq.getPageNo(), openApiReq.getPageSize());
        //3.查询
        BWList bw = new BWList();
        bw.setCurrentEmail(userName + MAIL_ACCOUNTSUFFIX);
        bw.setLocateType(queryBWDto.getLocateType());
        bw.setBwType(queryBWDto.getBwType());
//        queryBWDto.setCurrentEmail(AccountUtils.getAccountSuffix());
//        queryBWDto.setBwType(BWList.BWTYPE1);
//        queryBWDto.setLocateType(BWList.LOTYPE1);
        List<BWList> bwList = bwListService.findBWList(bw);
        //4.转换
        List<BWPagingDTO> paging = dozerUtils.mapPage(bwList, BWPagingDTO.class);
        return Result.success(new PageInfo<>(paging));
    }

    /**
     * 根据id删除黑名单
     * @param id
     * @return
     */
    @ApiOperation(value = "根据id删除黑名单", notes = "根据id删除黑名单")
    @ApiResponses({
            @ApiResponse(code = 43000, message = "黑白名单id不能为空")
    })
    @RequestMapping(value = "/open/deleteById", method = RequestMethod.GET)
    public Result<String> deleteById(@RequestParam(value = "id") Long id){
        //1.验证
        BizAssert.assertNotNull(MailExceptionCode.BWID_NOT_NULL, id);
        //2.删除
        if (id == null){
            return Result.fail("该邮箱地址不存在");
        }
        bwListService.deleteById(id);
        return Result.success("删除成功");
    }

    /**
     * 新增白名单
     * @param bwListDto
     * @return
     */
    @ApiOperation(value = "新增白名单", notes = "新增白名单")
    @RequestMapping(value = "/open/saveWhite", method = RequestMethod.POST)
    public Result<Boolean> saveWhite(@RequestBody BWListOpenDTO bwListDto){
        String userName = bwListDto.getUserName();
        if (userName == null || "".equals(userName)){
            return Result.success(null,"邮件用户为空！");
        }
        List<BWList> list = new ArrayList<>();
        List<ValueDTO> value = bwListDto.getValue();
        //数据处理
        for (ValueDTO whiteList:value){
            BWList bwList = dozerUtils.map(whiteList,BWList.class);
            bwList.setCreateUser(BaseContextHandler.getAdminId());
            Date nowDate = new Date();
            bwList.setCreateTime(nowDate);
            bwList.setBwType(BWList.BWTYPE2);
            bwList.setLocateType(BWList.LOTYPE1);
            bwList.setCurrentEmail(userName + MAIL_ACCOUNTSUFFIX);
            list.add(bwList);
        }
        bwListService.save(list);
        return Result.success(true);
    }

    /**
     * 根据id删除白名单
     * @param id
     * @return
     */
    @ApiOperation(value = "根据id删除白名单", notes = "根据id删除白名单")
    @ApiResponses({
            @ApiResponse(code = 43000, message = "黑白名单id不能为空")
    })
    @RequestMapping(value = "/open/deleteWhiteById", method = RequestMethod.GET)
    public Result<String> deleteWhiteById(@RequestParam(value = "id") Long id){
        //1.验证
        BizAssert.assertNotNull(MailExceptionCode.BWID_NOT_NULL, id);
        //2.删除
        if (id == null){
            return Result.fail("该邮箱地址不存在");
        }
        bwListService.deleteById(id);
        return Result.success("删除成功");
    }
}
