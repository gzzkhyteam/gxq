package com.hengyunsoft.platform.admin.impl.base;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hengyunsoft.base.Result;
import com.hengyunsoft.commons.context.BaseContextHandler;
import com.hengyunsoft.commons.exception.core.AuthorityExceptionCode;
import com.hengyunsoft.commons.utils.context.DozerUtils;
import com.hengyunsoft.page.plugins.openapi.OpenApiReq;
import com.hengyunsoft.platform.admin.api.base.api.ModuleTypeMaintenanceApi;
import com.hengyunsoft.platform.admin.api.base.dto.*;
import com.hengyunsoft.platform.admin.entity.base.domain.DictionaryMaintainDO;
import com.hengyunsoft.platform.admin.entity.base.po.Dictionary;
import com.hengyunsoft.platform.admin.entity.base.po.DictionaryType;
import com.hengyunsoft.platform.admin.entity.core.po.User;
import com.hengyunsoft.platform.admin.repository.base.example.DictionaryExample;
import com.hengyunsoft.platform.admin.repository.base.example.DictionaryTypeExample;
import com.hengyunsoft.platform.admin.repository.base.service.DictionaryService;
import com.hengyunsoft.platform.admin.repository.base.service.DictionaryTypeService;
import com.hengyunsoft.platform.admin.repository.core.service.UserService;
import com.hengyunsoft.platform.developer.entity.apply.po.ApplicationApply;
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
 * @author madb
 * @createTime 2018/4/10
 */
@Api(value = "API - ModuleDictionaryApiImpl", description = "功能类型维护管理")
@RestController
@RequestMapping("dictionary")
@Slf4j
public class ModuleTypeMaintenanceApiImpl implements ModuleTypeMaintenanceApi {

    @Autowired
    private DictionaryTypeService dictionaryTypeService;

    @Autowired
    private DictionaryService dictionaryService;

    @Autowired
    private UserService userService;

    @Autowired
    private DozerUtils dozerUtils;

    @Override
    @ApiOperation(value = "获取功能类型", notes = "获取功能类型")
    @RequestMapping(value = "/pageModuleType", method = RequestMethod.POST)
    public Result<PageInfo<ModuleDictionaryDTO>> pageModuleType(@RequestBody  OpenApiReq openApiReq) {
        //数据获取
        PageHelper.startPage(openApiReq.getPageNo(), openApiReq.getPageSize());
        //Long typeId = 8L; //类型id = 8L 为功能类型
        String typeCode = "module.type";
        String appId = BaseContextHandler.getAppId();
//        DictionaryExample example = new DictionaryExample();
//        example.createCriteria()
//                .andDictionaryTypeCodeEqualTo(typeCode)
//                .andIsDeleteEqualTo(false)
//                .andNameLike(DictionaryExample.fullLike(name));

        List<DictionaryMaintainDO> functionList = dictionaryService.findModMaintainPage(typeCode, appId);
        //数据转换
        return Result.success(new PageInfo<>(dozerUtils.mapPage(functionList, ModuleDictionaryDTO.class)));
    }

    @Override
    @ApiOperation(value = "新增功能类型", notes = "新增功能类型")
    @ApiResponses({
            @ApiResponse(code = 58001, message = "功能名称不能为空"),
            @ApiResponse(code = 58002, message = "功能类型编码不能为空"),
            @ApiResponse(code = 58003, message = "功能描述不能为空"),
    })
    @ValidatorStandard(
            {
                    @Constraint(value = Dictionary.class, groups = {Default.class,ValidatorGroups.MustNoneNull.class})
            }
    )
    @RequestMapping(value = "/addModuleType", method = RequestMethod.POST)
    public Result<String> addModuleType(@RequestBody ModuleTypeAddDTO moduleTypeAddDTO) {
        //1.验证
        BizAssert.assertNotNull(AuthorityExceptionCode.MODULE_NAME_NULL, moduleTypeAddDTO.getName());
        BizAssert.assertNotNull(AuthorityExceptionCode.MODULE_CODE_NULL, moduleTypeAddDTO.getCode());
        BizAssert.assertNotNull(AuthorityExceptionCode.MODULE_DESCRIPTION_NULL, moduleTypeAddDTO.getDescription());

        //获取功能类型详情信息
        String code = "module.type";
        DictionaryTypeExample dictionaryTypeExample = new DictionaryTypeExample();
        dictionaryTypeExample.createCriteria().andCodeEqualTo(code);
        DictionaryType dictionaryType = dictionaryTypeService.getUnique(dictionaryTypeExample);
        if(dictionaryType == null){
            return Result.fail("无对应类型名称，请先添加功能类型");
        }

        //判断是否已存在该功能名
        DictionaryExample example1 = new DictionaryExample();
        example1.createCriteria()
                .andDictionaryTypeCodeEqualTo(dictionaryType.getCode())
                .andNameEqualTo(moduleTypeAddDTO.getName());
        List<Dictionary> functionList = dictionaryService.find(example1);
        if(functionList.size()>0) {
            return Result.fail("已存在功能类型名称");
        }

        //判断是否存在code 若存在肯定不为null
        DictionaryExample example2 = new DictionaryExample();
        example2.createCriteria()
                .andDictionaryTypeCodeEqualTo(dictionaryType.getCode())
                .andCodeEqualTo(moduleTypeAddDTO.getCode());
        List<Dictionary> functionList1 = dictionaryService.find(example2);
        if(functionList1 .size()>0){
            return Result.fail("已存在功能类型编码");
        }
            //基本数据处理
            Dictionary dictionary = new Dictionary();
            dictionary.setAppId(BaseContextHandler.getAppId());
            dictionary.setDictionaryTypeId(dictionaryType.getId());//数据库功能类内定编码 8L
            dictionary.setDictionaryTypeCode(dictionaryType.getCode());
            dictionary.setDictionaryTypeName(dictionaryType.getName());
            dictionary.setName(moduleTypeAddDTO.getName());
            dictionary.setCode(moduleTypeAddDTO.getCode());
            dictionary.setCreateTime(new Date());
            dictionary.setIsDelete(false);
            dictionary.setIsEnable(true);
            dictionary.setCreateUser(Long.valueOf(BaseContextHandler.getAdminId()));
            dictionary.setDescription(moduleTypeAddDTO.getDescription());
            Dictionary save = dictionaryService.save(dictionary);
            DictionaryExample example3 = new DictionaryExample();
            example3.createCriteria()
                                    .andDictionaryTypeCodeEqualTo(dictionaryType.getCode())
                                    .andNameEqualTo(moduleTypeAddDTO.getName())
                                    .andCodeEqualTo(moduleTypeAddDTO.getCode());
             List<Dictionary> functionList3= dictionaryService.find(example3);
        if ( functionList3.size() > 0) {
            return Result.success("新增功能类型成功");
            }
        return Result.fail("新增功能类型失败");
    }

    @Override
    @ApiOperation(value = "根据ID删除功能类型", notes = "删除功能类型")
    @ApiResponses({
            @ApiResponse(code = 58003, message = "功能类型ID不能为空"),
    })
    @RequestMapping(value = "/deleteModuleType", method = RequestMethod.GET)
    public Result<String> deleteModuleType(@RequestParam(value = "id") Long id) {
        //1.验证
        BizAssert.assertNotNull(AuthorityExceptionCode.MODULE_ID_NULL, id);

        //数据操作 逻辑删除：既是 不删除数据库内容 将应用状态置为 is_delete =1；
        Dictionary dictionary = new Dictionary();
        dictionary.setId(id);
        dictionary.setIsDelete(true);

        int ret = dictionaryService.delById(dictionary);
        if(ret>0){
            return Result.success("删除成功");
        }
        return Result.fail("删除失败");
    }

    @Override
    @ApiOperation(value = "修改功能类型", notes = "修改功能类型")
    @ApiResponses({
            @ApiResponse(code = 58003, message = "功能类型ID不能为空"),
    })
    @RequestMapping(value = "/updateModuleType", method = RequestMethod.POST)
    @ValidatorStandard(
            {
                    @Constraint(value = Dictionary.class)
            }
    )
    public Result<String> updateModuleType(@RequestBody ModuleDictionaryModifyDTO moduleDictionaryModifyDTO) {
        //1.验证
        BizAssert.assertNotNull(AuthorityExceptionCode.MODULE_ID_NULL, moduleDictionaryModifyDTO.getId());

        //判断是否已存在该功能名
        Dictionary dic = dictionaryService.findByName(moduleDictionaryModifyDTO.getName());

        if((dic != null) && !String.valueOf(dic.getId()).equals( String.valueOf(moduleDictionaryModifyDTO.getId()))) {
            return Result.fail("已存在功能类型名称");
        }

        //判断是否存在code 若存在肯定不为null
        //业务变化：madb 2018/06/06 维护时类型编码不变
       /* Dictionary byCode = dictionaryService.findByCode(moduleDictionaryModifyDTO.getCode());
        if(byCode != null && !String.valueOf(byCode.getId()).equals( String.valueOf(moduleDictionaryModifyDTO.getId()))){
            return Result.fail("已存在功能类型编码");
        }*/
        //基本数据处理
        Dictionary dictionary = new Dictionary();
        dictionary.setId(moduleDictionaryModifyDTO.getId());
        dictionary.setCode(moduleDictionaryModifyDTO.getCode());
        dictionary.setName(moduleDictionaryModifyDTO.getName());
        dictionary.setUpdateTime(new Date());
        dictionary.setUpdateUser(Long.valueOf(BaseContextHandler.getAdminId()));
        dictionary.setDescription(moduleDictionaryModifyDTO.getDescription());

        int ret = dictionaryService.updateDictionaryById(dictionary);

        if(ret>0){
            return Result.success("修改成功");
        }
        return Result.fail("修改失败");
    }

    @Override
    @ApiOperation(value = "查看功能类型详情", notes = "查看功能类型详情")
    @ApiResponses({
            @ApiResponse(code = 58003, message = "功能类型ID不能为空"),
    })
    @RequestMapping(value = "/getDetailModuleTypeById", method = RequestMethod.GET)
    public Result<ModuleDictionaryDTO> getDetailModuleTypeById(@RequestParam(value = "id") Long id) {
        //1.验证
        BizAssert.assertNotNull(AuthorityExceptionCode.MODULE_ID_NULL, id);

        //查询
        //2.数据查询
        Dictionary dictionary = dictionaryService.getById(id);

        //3.数据转换并且返回
        ModuleDictionaryDTO moduleDictionaryDTO = dozerUtils.map(dictionary, ModuleDictionaryDTO.class);

        //4.确定对应的创建人
        if(dictionary.getCreateUser() != null ){
            User byId = userService.getById(dictionary.getCreateUser());
            if (byId !=null) {
                moduleDictionaryDTO.setCreateUser(byId.getName());
            }
        }
        return Result.success(moduleDictionaryDTO);
    }

    @Override
    @ApiOperation(value = "根据dictionaryTypeCode获取对应的类型", notes = "根据dictionaryTypeCode获取对应的类型")
    @ApiResponses({
            @ApiResponse(code = 58004, message = "类型编码不能为空"),
    })
    @RequestMapping(value = "/getListByTypeCode", method = RequestMethod.GET)
    public Result<List<AppAndModuleDTO>> getListByTypeCode(@RequestParam(value = "typeCode") String typeCode) {
        //1.验证
        BizAssert.assertNotNull(AuthorityExceptionCode.MODULE_TYPECODE_NULL, typeCode);
        //数据获取
        DictionaryExample dictionaryExample = new DictionaryExample();
        dictionaryExample.createCriteria().andDictionaryTypeCodeEqualTo(typeCode)
                                            .andIsDeleteEqualTo(false);
        List<Dictionary> dictionaries = dictionaryService.find(dictionaryExample);
        return Result.success(dozerUtils.mapList(dictionaries, AppAndModuleDTO.class));
    }
}
