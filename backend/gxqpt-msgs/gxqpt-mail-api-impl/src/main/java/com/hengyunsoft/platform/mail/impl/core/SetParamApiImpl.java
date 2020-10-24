package com.hengyunsoft.platform.mail.impl.core;

import com.hengyunsoft.base.Result;
import com.hengyunsoft.commons.exception.core.MailExceptionCode;
import com.hengyunsoft.commons.utils.context.DozerUtils;
import com.hengyunsoft.platform.mail.dto.core.RequestSetParamDTO;
import com.hengyunsoft.platform.mail.dto.core.ResponseSetParamDTO;
import com.hengyunsoft.platform.mail.entity.core.po.SetParam;
import com.hengyunsoft.platform.mail.repository.core.example.SetParamExample;
import com.hengyunsoft.platform.mail.repository.core.service.SetParamApiService;
import com.hengyunsoft.platform.mail.utils.AccountUtils;
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
import org.springframework.web.bind.annotation.RestController;

import java.util.Calendar;

/**
 * 版权：中科恒运软件科技股份有限公司贵阳分公司
 * 描述：设置参数API
 * 修改人：wt
 * 修改时间：2018/7/30
 * 修改内容：
 */
@Api(value = "API - SetParamApiImpl.java", description = "设置参数API")
@RestController
@RequestMapping("dataapi/setparam/")
@Slf4j
public class SetParamApiImpl {
    @Autowired
    private DozerUtils dozerUtils;
    @Autowired
    private SetParamApiService setParamApiService;

    /**
     * 描述：查询用户设置参数
     * 参数：id
     * 返回值：ResponseSetParamDTO
     * 修改人：wt
     * 修改时间：2018/7/30
     * 修改内容：
     */
    @RequestMapping(value = "/findById", method = RequestMethod.GET)
    @ApiOperation(value = "查询用户设置参数", notes = "查询用户设置参数")
    public Result<ResponseSetParamDTO> findCurUser(){
        //基本数据的获取
        String mailAccount = AccountUtils.getAccountSuffix();

        SetParamExample example = new SetParamExample();
        example.createCriteria().andCreateUserEqualTo(mailAccount);
        SetParam result = setParamApiService.getUnique(example);
        return Result.success(dozerUtils.map(result,ResponseSetParamDTO.class));
    }

    /**
     * 描述：保存设置参数
     * 参数：ResponseSetParamDTO
     * 返回值：Integer
     * 修改人：wt
     * 修改时间：2018/7/30
     * 修改内容：
     */
    @RequestMapping(value = "/saveandupdate", method = RequestMethod.POST)
    @ApiOperation(value = "保存设置参数", notes = "保存设置参数")
    @ApiResponses({
            @ApiResponse(code = 42000, message = "参数不能为空"),
    })
    public Result<Integer> saveAndUpdate(@RequestBody RequestSetParamDTO dto){
        //数据验证
        BizAssert.assertNotNull(MailExceptionCode.PARAM_NOT_NULL, dto);

        //基本数据的获取
        String mailAccount = AccountUtils.getAccountSuffix();

        SetParamExample example = new SetParamExample();
        example.createCriteria().andCreateUserEqualTo(mailAccount);
        SetParam currSetparam = setParamApiService.getUnique(example);

        SetParam setParam = dozerUtils.map(dto,SetParam.class);
        Integer result = 0;
        if(currSetparam != null){
            setParam.setId(currSetparam.getId());
            setParam.setUpdateTime(Calendar.getInstance().getTime());
            setParam.setUpdateUser(mailAccount);
            result = setParamApiService.updateByIdSelective(setParam);
        }else{
            setParam.setCreateTime(Calendar.getInstance().getTime());
            setParam.setCreateUser(mailAccount);
            SetParam resultSetParam = setParamApiService.saveSelective(setParam);
            if(resultSetParam != null){
                result = 1;
            }
        }
        return Result.success(result);
    }

}
