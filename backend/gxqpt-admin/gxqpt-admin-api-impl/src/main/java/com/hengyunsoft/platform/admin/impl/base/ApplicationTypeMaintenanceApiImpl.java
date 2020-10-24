package com.hengyunsoft.platform.admin.impl.base;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hengyunsoft.base.Result;
import com.hengyunsoft.commons.context.BaseContextHandler;
import com.hengyunsoft.commons.exception.core.AuthorityExceptionCode;
import com.hengyunsoft.commons.utils.context.DozerUtils;
import com.hengyunsoft.page.plugins.openapi.OpenApiReq;
import com.hengyunsoft.platform.admin.api.base.api.ApplicationTypeMaintenanceApi;
import com.hengyunsoft.platform.admin.api.base.dto.DictionaryMaintainDetailsDTO;
import com.hengyunsoft.platform.admin.api.base.dto.DictionaryMaintainPageDTO;
import com.hengyunsoft.platform.admin.api.base.dto.DictionaryMaintainSaveDTO;
import com.hengyunsoft.platform.admin.api.base.dto.DictionaryMaintainUpdateDTO;
import com.hengyunsoft.platform.admin.entity.base.domain.DictionaryMaintainDO;
import com.hengyunsoft.platform.admin.entity.base.po.Dictionary;
import com.hengyunsoft.platform.admin.entity.base.po.DictionaryType;
import com.hengyunsoft.platform.admin.repository.base.example.DictionaryExample;
import com.hengyunsoft.platform.admin.repository.base.example.DictionaryTypeExample;
import com.hengyunsoft.platform.admin.repository.base.service.DictionaryService;
import com.hengyunsoft.platform.admin.repository.base.service.DictionaryTypeService;
import com.hengyunsoft.platform.admin.repository.core.service.UserService;
import com.hengyunsoft.utils.BizAssert;
import com.hengyunsoft.validator.ValidatorGroups;
import com.hengyunsoft.validator.annotation.Constraint;
import com.hengyunsoft.validator.annotation.ValidatorStandard;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.groups.Default;
import java.util.Date;
import java.util.List;

/**
 * @author zhangbiao
 * @createTime 2018-04-10
 */
@Api(value = "API - ApplicationTypeMaintenanceApiImpl", description = "应用类型维护")
@RestController
@RequestMapping("/maintenance")
@Slf4j
public class ApplicationTypeMaintenanceApiImpl implements ApplicationTypeMaintenanceApi {

    @Autowired
    private DictionaryTypeService dictionaryTypeService;

    @Autowired
    private DictionaryService dictionaryService;

    @Autowired
    private UserService userService;

    @Autowired
    private DozerUtils dozerUtils;

    @ApiOperation(value = "应用类型维护" , notes = "应用类型维护 查询列表")
    @RequestMapping(value = "/findList" , method = RequestMethod.POST)
    @Override
    public Result<PageInfo<DictionaryMaintainPageDTO>> findList(@RequestBody OpenApiReq openApiReq) {
        //1.数据处理
        String typeCode = "application.type";
        PageHelper.startPage(openApiReq.getPageNo(),openApiReq.getPageSize());
        String appId = BaseContextHandler.getAppId();
        //2.数据查询
        List<DictionaryMaintainDO> list = dictionaryService.findAppMaintainPage(typeCode, appId);

        //3.数据转换并且返回

        return Result.success(new PageInfo<DictionaryMaintainPageDTO>(dozerUtils.mapPage(list,DictionaryMaintainPageDTO.class)));
    }

    @ApiOperation(value = "应用类型维护" , notes = "应用类型维护 查询详情")
    @ApiResponses({
            @ApiResponse(code = 54501 , message = "数据字典id不能为空")
    })
    @RequestMapping(value = "/get" , method = RequestMethod.GET)
    @Override
    public Result<DictionaryMaintainDetailsDTO> get(@RequestParam(value = "id") Long id) {
        //1.验证
        BizAssert.assertNotNull(AuthorityExceptionCode.DICTIONARY_ID_NULL,id);

        //2.数据查询
        Dictionary dictionary = dictionaryService.getById(id);

        //3.数据转换并且返回

        //4.确定对应的创建人
        //@Author:madb
        //@Time:2018/4/19
        DictionaryMaintainDetailsDTO dictionaryMaintainDetailsDTO = dozerUtils.map(dictionary, DictionaryMaintainDetailsDTO.class);
        if(dictionary.getCreateUser() != null ){
            dictionaryMaintainDetailsDTO.setCreateUser(userService.getById(dictionary.getCreateUser()).getName());
        }
        return Result.success(dictionaryMaintainDetailsDTO);
    }


    @ApiOperation(value = "应用类型维护" , notes = "应用类型维护 修改")
    @ApiResponses({
            @ApiResponse(code = 54501 , message = "数据字典id不能为空"),
            @ApiResponse(code = 54502 , message = "数据字典code不能为空")
    })
    @RequestMapping(value = "/update" , method = RequestMethod.POST)
    @ValidatorStandard(
            {
                    @Constraint(value = Dictionary.class)
            }
    )
    @Override
    public Result<String> update(@RequestBody DictionaryMaintainUpdateDTO maintainUpdateDTO) {
        //1.数据验证
        BizAssert.assertNotNull(AuthorityExceptionCode.DICTIONARY_ID_NULL,maintainUpdateDTO.getId());
        BizAssert.assertNotNull(AuthorityExceptionCode.DICTIONARY_CODE_EMPTY,maintainUpdateDTO.getCode());

        if ("".equals(maintainUpdateDTO.getName()) || maintainUpdateDTO.getName() == null){
            return Result.fail("应用类型名称不能为空");
        }

        //code ,name 不重复验证
        Dictionary temp = new Dictionary();
        DictionaryExample dictionaryExample = new DictionaryExample();
        dictionaryExample.createCriteria()
                .andNameEqualTo(maintainUpdateDTO.getName())
                .andDictionaryTypeCodeEqualTo("application.type");
        temp = dictionaryService.getUnique(dictionaryExample);

        if (temp != null && !String.valueOf(maintainUpdateDTO.getId()).equals(String.valueOf(temp.getId()))){
                return Result.fail("应用类型名称不能重复");
        }

        /**
         * 更新时：编码不变：madb2018/06/06
         * */

        /*temp = new Dictionary();
        dictionaryExample = new DictionaryExample();
        dictionaryExample.createCriteria()
                .andCodeEqualTo(maintainUpdateDTO.getCode())
                .andDictionaryTypeCodeEqualTo("application.type");
        temp = dictionaryService.getById(maintainUpdateDTO.getId());

        if (temp != null){
            if(!temp.getCode().equals(maintainUpdateDTO.getCode())){
                return Result.fail("应用类型编码不能重复");
            }
        }*/


        //2.数据处理
        Long updateUser = BaseContextHandler.getAdminId();

        Dictionary dictionary = dozerUtils.map(maintainUpdateDTO , Dictionary.class);
        dictionary.setUpdateUser(Long.valueOf(updateUser));
        dictionary.setUpdateTime(new Date());

        //3.保存
        if (dictionaryService.updateDictionaryById(dictionary) > 0){
            return Result.success("ok");
        }

        return Result.success("保存失败");
    }

    @ApiOperation(value = "应用类型维护" , notes = "应用类型维护 删除(逻辑删除)")
    @ApiResponses({
            @ApiResponse(code = 54501 , message = "数据字典id不能为空")
    })
    @RequestMapping(value = "/delete" , method = RequestMethod.POST)
    @Override
    public Result<Boolean> delete(@RequestParam(value = "id") Long id) {
        //1.验证
        BizAssert.assertNotNull(AuthorityExceptionCode.DICTIONARY_ID_NULL,id);

        //2.删除
        /*if (dictionaryService.deleteById(id) > 0){
            return Result.success(true);
        }*/
        //2.数据处理
        Long updateUser = BaseContextHandler.getAdminId();

        Dictionary dictionary = new Dictionary();
        dictionary.setUpdateUser(Long.valueOf(updateUser));
        dictionary.setUpdateTime(new Date());
        dictionary.setId(id);
        dictionary.setIsDelete(true);
        //3.更新数据(逻辑删除)
        if (dictionaryService.delById(dictionary) > 0){
            return Result.success(true);
        }

        return Result.success(false);
    }

    @ApiOperation(value = "应用类型维护" , notes = "应用类型维护 保存")
    @ApiResponses({
            @ApiResponse(code = 54502 , message = "数据字典code不能为空"),
            @ApiResponse(code = 54500 , message = "数据字典不能为空"),
            @ApiResponse(code = 54503 , message = "数据字典code不能重复")
    })
    @RequestMapping(value = "/save" , method = RequestMethod.POST)
    @ValidatorStandard(
            {
                    @Constraint(value = Dictionary.class, groups = {Default.class,ValidatorGroups.MustNoneNull.class})
            }
    )
    @Override
    public Result<String> save(@RequestBody DictionaryMaintainSaveDTO maintainSaveDTO) {
        //1.验证
        BizAssert.assertNotNull(AuthorityExceptionCode.DICTIONARY_NULL, maintainSaveDTO);
        BizAssert.assertNotNull(AuthorityExceptionCode.DICTIONARY_CODE_EMPTY, maintainSaveDTO.getCode());
        BizAssert.assertNotNull(AuthorityExceptionCode.DICTIONARY_CODE_EXIST, maintainSaveDTO.getCode());

        //获取功能类型详情信息
        //@Author:madb  2018/4/23
        String code = "application.type";
        DictionaryTypeExample dictionaryTypeExample = new DictionaryTypeExample();
        dictionaryTypeExample.createCriteria().andCodeEqualTo(code);
        DictionaryType dictionaryType = dictionaryTypeService.getUnique(dictionaryTypeExample);
        if(dictionaryType == null){
            return Result.fail("无对应类型名称，请先添加应用类型");
        }

        if (maintainSaveDTO.getName() == null || "".equals(maintainSaveDTO.getName())) {
            return Result.fail("应用类型名称不能为空");
        }

        //code ,name 不重复验证
        DictionaryExample dictionaryExample = new DictionaryExample();
       /* dictionaryExample.createCriteria()
                .andDictionaryTypeCodeEqualTo("application.type");*/
        dictionaryExample.createCriteria()
                .andNameEqualTo(maintainSaveDTO.getName())
                .andDictionaryTypeCodeEqualTo(dictionaryType.getCode());
        if (dictionaryService.find(dictionaryExample).size() > 0){
            return Result.fail("应用类型名称不能重复");
        }

        dictionaryExample = new DictionaryExample();
        dictionaryExample.createCriteria()
                .andCodeEqualTo(maintainSaveDTO.getCode())
                .andDictionaryTypeCodeEqualTo(dictionaryType.getCode());
        if (dictionaryService.find(dictionaryExample).size() > 0){
            return Result.fail("应用类型编码不能重复");
        }

        //2.数据转换
        Dictionary dictionary = dozerUtils.map(maintainSaveDTO, Dictionary.class);

        //3.数据处理
        Long user = BaseContextHandler.getAdminId();

        dictionary.setIsDelete(false);
        dictionary.setIsEnable(true);
        dictionary.setCreateUser(Long.valueOf(user));
        dictionary.setUpdateUser(Long.valueOf(user));
        dictionary.setCreateTime(new Date());
        dictionary.setUpdateTime(new Date());
        dictionary.setId(dictionaryService.genId());
        dictionary.setAppId(BaseContextHandler.getAppId());
        dictionary.setDictionaryTypeId(dictionaryType.getId());
        dictionary.setDictionaryTypeCode(dictionaryType.getCode());
        dictionary.setDictionaryTypeName(dictionaryType.getName());


       /* DictionaryExample example = new DictionaryExample();
        example.createCriteria()
                .andNameLike(maintainSaveDTO.getName())
                .andCodeEqualTo(maintainSaveDTO.getCode())
                .andDescriptionEqualTo(maintainSaveDTO.getDescription());*/
        //3.保存数据
       /* dictionaryService.save(dictionary);*/



        if (dictionaryService.saveDictionaryById(dictionary) > 0){
            return Result.fail("ok");
        };

        return Result.fail("保存失败");
    }
}
