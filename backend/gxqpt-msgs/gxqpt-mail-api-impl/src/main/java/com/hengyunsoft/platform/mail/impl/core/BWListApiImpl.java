package com.hengyunsoft.platform.mail.impl.core;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hengyunsoft.base.Result;
import com.hengyunsoft.commons.context.BaseContextHandler;
import com.hengyunsoft.commons.exception.core.MailExceptionCode;
import com.hengyunsoft.commons.utils.context.DozerUtils;
import com.hengyunsoft.page.plugins.openapi.OpenApiReq;
import com.hengyunsoft.platform.mail.dto.bwlist.BWListDTO;
import com.hengyunsoft.platform.mail.dto.bwlist.BWPagingDTO;
import com.hengyunsoft.platform.mail.dto.bwlist.QueryBWDTO;
import com.hengyunsoft.platform.mail.dto.bwlist.ValueDTO;
import com.hengyunsoft.platform.mail.entity.po.BWList;
import com.hengyunsoft.platform.mail.repository.example.BWListExample;
import com.hengyunsoft.platform.mail.repository.service.BWListService;
import com.hengyunsoft.platform.mail.utils.AccountUtils;
import com.hengyunsoft.utils.BizAssert;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * @author zjr
 * @date 2018/08/08
 */
@Api(value = "API - BWListApiImpl", description = "黑白名单")
@RestController
@RequestMapping("mail")
@Slf4j
public class BWListApiImpl /*implements BWListApi*/ {

    @Autowired
    private BWListService bwListService;
    @Autowired
    private DozerUtils dozerUtils;

    /**
     * 新增黑名单
     * @param bwListDto
     * @return
     */
    
    @ApiOperation(value = "新增黑名单", notes = "新增黑名单")
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public Result<Boolean> save(@RequestBody BWListDTO bwListDto){
        List<BWList> list = new ArrayList<>();
        List<ValueDTO> value = bwListDto.getValue();
        List<String> result = new ArrayList<String>();
        BWListExample bwListExample = new BWListExample();
        bwListExample.createCriteria().andBwTypeEqualTo(BWList.BWTYPE1).andCurrentEmailEqualTo(AccountUtils.getAccount());
        List<BWList> vlist = bwListService.find(bwListExample);
        //1.判断账号格式
        for (int i=0;i<value.size();i++){
            String reValue = getMailName(value.get(i).getValue());
            result.add(reValue);
        }
        //1.验证
        for (int i=0;i<result.size();i++){
            for (int j=0;j<vlist.size();j++){
                if (result.get(i).equals(vlist.get(j).getValue())){
                    return Result.fail("黑名单已存在,不能重复添加");
                }
            }
            if (result.get(i).equals(AccountUtils.getAccountSuffix())){
                return Result.fail("不能添加自己为黑名单");
            }
        }
        List<String> newResultList = removeDuplicate(result);
        //2.数据处理
        for (String bwList1:newResultList){
//            BWList bwList = dozerUtils.map(bwList1,BWList.class);
            BWList bwList = new BWList();
            bwList.setValue(bwList1);
            bwList.setCreateUser(BaseContextHandler.getAdminId());
            Date nowDate = new Date();
            bwList.setCreateTime(nowDate);
            bwList.setBwType(BWList.BWTYPE1);
            bwList.setLocateType(BWList.LOTYPE1);
            bwList.setCurrentEmail(AccountUtils.getAccount());
            list.add(bwList);
        }
        bwListService.save(list);
        return Result.success(true);
    }

    /**
     * 去除集合重复数据
     * @param list
     * @return
     */
    public static List removeDuplicate(List list){
        List listTemp = new ArrayList();
        for(int i=0;i<list.size();i++){
            if(!listTemp.contains(list.get(i))){
                listTemp.add(list.get(i));
            }
        }
        return listTemp;
    }


    //获取邮件地址名称
    private String getMailName(String val){
        String result = "";
        if(!"".equals(val)){
            if(val.indexOf("<") != -1&&val.indexOf(">") != -1){
                result =  val.substring(val.indexOf("<")+1,val.length()-1);
            }else if (val.indexOf("<") != -1&&val.indexOf(">") == -1){
                result =  val.substring(val.indexOf("<")+1,val.length());
            }else if (val.indexOf("<") == -1&&val.indexOf(">") != -1){
                result =  val.substring(0,val.length()-1);
            }else{
                result =  val.substring(0,val.length());
            }
        }
        return result;
    }

    /**
     * 查询黑、白名单分页列表
     * @param openApiReq
     * @return
     */
    
    @ApiOperation(value = "查询黑、白名单分页列表", notes = "查询黑、白名单分页列表")
    @RequestMapping(value = "/findBWList", method = RequestMethod.POST)
    public Result<PageInfo<BWPagingDTO>> findBWList(@RequestBody OpenApiReq<QueryBWDTO> openApiReq){
        QueryBWDTO queryBWDto = openApiReq.getData();
        //1.验证
        if (queryBWDto == null) {
            return Result.success(new PageInfo<>());
        }
        //2.设置分页器
        PageHelper.startPage(openApiReq.getPageNo(), openApiReq.getPageSize());
        //3.查询
        BWList bw = new BWList();
        bw.setCurrentEmail(AccountUtils.getAccount());
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
    @RequestMapping(value = "/deleteById", method = RequestMethod.GET)
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
    @RequestMapping(value = "/saveWhite", method = RequestMethod.POST)
    public Result<Boolean> saveWhite(@RequestBody BWListDTO bwListDto){
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
            bwList.setCurrentEmail(AccountUtils.getAccount());
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
    @RequestMapping(value = "/deleteWhiteById", method = RequestMethod.GET)
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
