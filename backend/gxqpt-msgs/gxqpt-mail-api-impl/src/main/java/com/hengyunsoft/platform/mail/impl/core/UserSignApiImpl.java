package com.hengyunsoft.platform.mail.impl.core;

import com.hengyunsoft.base.Result;
import com.hengyunsoft.commons.exception.core.MailExceptionCode;
import com.hengyunsoft.commons.utils.context.DozerUtils;
import com.hengyunsoft.platform.mail.dto.core.RequestUserSignDTO;
import com.hengyunsoft.platform.mail.dto.core.ResponseUserSignDTO;
import com.hengyunsoft.platform.mail.entity.core.po.UserSign;
import com.hengyunsoft.platform.mail.repository.core.example.UserSignExample;
import com.hengyunsoft.platform.mail.repository.core.service.UserSignApiService;
import com.hengyunsoft.platform.mail.utils.AccountUtils;
import com.hengyunsoft.utils.BizAssert;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Calendar;
import java.util.List;

/**
 * 版权：中科恒运软件科技股份有限公司贵阳分公司
 * 描述：用户签名API
 * 修改人：wt
 * 修改时间：2018/7/30
 * 修改内容：
 */
@Api(value = "API - UserSignApiImpl.java", description = "用户签名API")
@RestController
@RequestMapping("dataapi/usersign/")
@Slf4j
public class UserSignApiImpl {
    @Autowired
    private DozerUtils dozerUtils;
    @Autowired
    private UserSignApiService userSignApiService;

    /**
     * 描述：查询用户签名
     * 参数：
     * 返回值：List<ResponseUserSignDTO>
     * 修改人：wt
     * 修改时间：2018/7/30
     * 修改内容：
     */
    @RequestMapping(value = "/find", method = RequestMethod.GET)
    @ApiOperation(value = "查询用户签名", notes = "查询用户签名")
    public Result<List<ResponseUserSignDTO>> findUserSign(){
        //基本数据的获取
        String mailAccount = AccountUtils.getAccountSuffix();

        UserSignExample example = new UserSignExample();
        example.createCriteria().andCreateUserEqualTo(mailAccount);
        List<UserSign> list = userSignApiService.find(example);
        return Result.success(dozerUtils.mapList(list,ResponseUserSignDTO.class));
    }

    /**
     * 描述：保存用户签名
     * 参数：RequestUserSignDTO
     * 返回值：ResponseUserSignDTO
     * 修改人：wt
     * 修改时间：2018/7/30
     * 修改内容：
     */
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    @ApiOperation(value = "保存用户签名", notes = "保存用户签名")
    @ApiResponses({
            @ApiResponse(code = 42000, message = "参数不能为空"),
    })
    public Result<ResponseUserSignDTO> saveUserSign(@RequestBody RequestUserSignDTO dto){
        //数据验证
        BizAssert.assertNotNull(MailExceptionCode.PARAM_NOT_NULL, dto);

        //基本数据的获取
        String mailAccount = AccountUtils.getAccountSuffix();

        UserSignExample example = new UserSignExample();
        example.createCriteria().andCreateUserEqualTo(mailAccount);
        Integer count = userSignApiService.count(example);
        if(count >= 3){
            return Result.success(null,"用户签名数量超出范围");
        }
        UserSign userSign = dozerUtils.map(dto,UserSign.class);
        userSign.setCreateTime(Calendar.getInstance().getTime());
        userSign.setCreateUser(mailAccount);
        UserSign result = userSignApiService.saveSelective(userSign);
        return Result.success(dozerUtils.map(result,ResponseUserSignDTO.class));
    }

    /**
     * 描述：更新用户签名
     * 参数：RequestUserSignDTO
     * 返回值：Integer
     * 修改人：wt
     * 修改时间：2018/7/30
     * 修改内容：
     */
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    @ApiOperation(value = "更新用户签名", notes = "更新用户签名")
    @ApiResponses({
            @ApiResponse(code = 42000, message = "参数不能为空"),
    })
    public Result<Integer> updateUserSign(@RequestBody ResponseUserSignDTO dto){
        //数据验证
        BizAssert.assertNotNull(MailExceptionCode.PARAM_NOT_NULL, dto);

        //基本数据的获取
        String mailAccount = AccountUtils.getAccountSuffix();

        UserSign userSign = dozerUtils.map(dto,UserSign.class);
        userSign.setUpdateTime(Calendar.getInstance().getTime());
        userSign.setCreateUser(mailAccount);
        Integer result = userSignApiService.updateByIdSelective(userSign);
        return Result.success(result);
    }

    /**
     * 描述：删除用户签名
     * 参数：id
     * 返回值：Integer
     * 修改人：wt
     * 修改时间：2018/7/30
     * 修改内容：
     */
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    @ApiOperation(value = "删除用户签名", notes = "删除用户签名")
    @ApiResponses({
            @ApiResponse(code = 42000, message = "参数不能为空"),
    })
    public Result<Integer> deleteUserSign(@RequestParam("id") Long id){
        //数据验证
        BizAssert.assertNotNull(MailExceptionCode.PARAM_NOT_NULL, id);

        Integer result = userSignApiService.deleteById(id);
        return Result.success(result);
    }

}
