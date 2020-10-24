package com.hengyunsoft.platform.admin.impl.base;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hengyunsoft.base.Result;
import com.hengyunsoft.commons.constant.DeleteStatus;
import com.hengyunsoft.commons.context.BaseContextHandler;
import com.hengyunsoft.commons.exception.core.AuthorityExceptionCode;
import com.hengyunsoft.commons.utils.context.DozerUtils;
import com.hengyunsoft.page.plugins.openapi.OpenApiReq;
import com.hengyunsoft.platform.admin.api.base.api.DictionaryApi;
import com.hengyunsoft.platform.admin.api.base.dto.*;
import com.hengyunsoft.platform.admin.entity.base.po.Dictionary;
import com.hengyunsoft.platform.admin.entity.base.po.DictionaryType;
import com.hengyunsoft.platform.admin.repository.base.example.DictionaryExample;
import com.hengyunsoft.platform.admin.repository.base.example.DictionaryTypeExample;
import com.hengyunsoft.platform.admin.repository.base.service.DictionaryService;
import com.hengyunsoft.platform.admin.repository.base.service.DictionaryTypeService;
import com.hengyunsoft.platform.commons.utils.TreeUtil;
import com.hengyunsoft.security.auth.client.annotation.AppToken;
import com.hengyunsoft.utils.BizAssert;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;


/**
 * @author tianai
 * @createTime 2018-1-24
 */
@Api(value = "API - DictionaryApiImpl", description = "数据字典管理")
@RestController
@RequestMapping("dictionary")
@Slf4j
public class DictionaryApiImpl implements DictionaryApi {

    @Autowired
    private DictionaryService dictionaryService;
    @Autowired
    private DictionaryTypeService dictionaryTypeService;


    @Autowired
    private DozerUtils dozerUtils;



    @Override
    @ApiOperation(value = "根据字典编码code查询数据字典List", notes = "根据字典编码code 查询数据字典List")
    @RequestMapping(value = "/getCodeList", method = RequestMethod.GET)
    @AppToken
    public Result<List<DictionaryDTO>> getCodeList(@RequestParam(value = "code") String code) {
        if (code == null) {
            return Result.success(null);
        }
        String appId = BaseContextHandler.getAppId();
        return Result.success(dozerUtils.mapList(dictionaryService.findByCodeList(appId,code), DictionaryDTO.class));
    }


    @Override
    @ApiOperation(value = "根据id查询数据字典", notes = "根据id查询数据字典")
    @RequestMapping(value = "/get", method = RequestMethod.GET)
    @AppToken
    public Result<DictionaryDTO> get(@RequestParam(value = "id") Long id) {
        if (id == null) {
            return Result.success(null);
        }
        DictionaryExample example = new DictionaryExample();
        example.createCriteria().andIdEqualTo(id).
                andIsDeleteEqualTo(DeleteStatus.UN_DELETE.getVal());
                //.andIsEnableEqualTo(EnableStatus.ENABLE.getVal());
        Dictionary dictionary = dictionaryService.getUnique(example);
        if (dictionary == null || dictionary.getIsDelete()) {
            return Result.success(null);
        }
        DictionaryDTO dto = dozerUtils.map(dictionary, DictionaryDTO.class);
        return Result.success(dto);
    }

    @Override
    @ApiOperation(value = "根据类型id查询数据字典", notes = "根据类型id 查询数据字典List")
    @RequestMapping(value = "/getList", method = RequestMethod.GET)
    @AppToken
    public Result<List<DictionaryDTO>> getList(@RequestParam(value = "typeId") Long typeId) {
        if (typeId == null) {
            return Result.success(null);
        }
        String appId = BaseContextHandler.getAppId();
        return Result.success(dozerUtils.mapList(dictionaryService.findByTypeId(appId, typeId), DictionaryDTO.class));
    }

    @Override
    @ApiOperation(value = "查询数据字典分页信息", notes = "查询数据字典分页信息")
    @RequestMapping(value = "/page", method = RequestMethod.POST)
    @AppToken
    public Result<PageInfo<DictionaryDTO>> page(@RequestBody  OpenApiReq<DictionaryPageReqDTO> openApiReq) {
        String appId = openApiReq.getData().getAppId();
        DictionaryExample example = new DictionaryExample();
        example.createCriteria().andAppIdEqualTo(appId)
                .andIsDeleteEqualTo(DeleteStatus.UN_DELETE.getVal())
                //.andIsEnableEqualTo(EnableStatus.ENABLE.getVal())
                .andDictionaryTypeIdEqualTo(openApiReq.getData().getDictionaryTypeId());
        example.setOrderByClause("order_num asc");
        PageHelper.startPage(openApiReq.getPageNo(), openApiReq.getPageSize());
        return Result.success(new PageInfo<>(dozerUtils.mapPage(dictionaryService.find(example), DictionaryDTO.class)));
    }

    @Override
    @ApiOperation(value = "保存数据字典", notes = "保存数据字典")
    @ApiResponses({
            @ApiResponse(code = 54500, message = "数据字典不能为空"),
            @ApiResponse(code = 54001, message = "数据字典类型id不能为空"),
            @ApiResponse(code = 54502, message = "数据字典code不能为空"),
            @ApiResponse(code = 57501, message = "应用id不能为空"),
            @ApiResponse(code = 54503, message = "数据字典code不能重复"),
    })
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public Result<DictionaryDTO> save(@RequestBody DictionarySaveDTO dictionarySaveDto) {
        //验证
        BizAssert.assertNotNull(AuthorityExceptionCode.DICTIONARY_NULL, dictionarySaveDto);
        BizAssert.assertNotNull(AuthorityExceptionCode.DICTIONARY_TYPE_ID_NULL, dictionarySaveDto.getDictionaryTypeId());
        BizAssert.assertNotEmpty(AuthorityExceptionCode.DICTIONARY_CODE_EMPTY, dictionarySaveDto.getCode());
        BizAssert.assertNotEmpty(AuthorityExceptionCode.APPLICATION_ID_NULL, dictionarySaveDto.getAppId());
        String appId = dictionarySaveDto.getAppId();
        Long adminId = BaseContextHandler.getAdminId();
        DictionaryType dictionaryType = dictionaryTypeService.getByAppIdAndId(appId, dictionarySaveDto.getDictionaryTypeId());
        BizAssert.assertFalse(AuthorityExceptionCode.DICTIONARY_TYPE_CODE_EXIST, dictionaryService.check(dictionarySaveDto.getCode(),dictionaryType.getCode()));

        //BizAssert.assertNotNull(AuthorityExceptionCode.DICTIONARY_TYPE_EXIST, dictionaryType);

        //转换
        Dictionary dictionary = dozerUtils.map(dictionarySaveDto, Dictionary.class);
        //数据处理
        dictionary.setDictionaryTypeCode(dictionaryType.getCode());
        dictionary.setDictionaryTypeName(dictionaryType.getName());
        dictionary.setAppId(appId);
        dictionary.setCreateUser(Long.valueOf(adminId));
        dictionary.setUpdateUser(Long.valueOf(adminId));
        dictionary.setIsDelete(DeleteStatus.UN_DELETE.getVal());
        //保存
        dictionary = dictionaryService.saveSelective(dictionary);
        return Result.success(dozerUtils.map(dictionary, DictionaryDTO.class));
    }

    @Override
    @ApiOperation(value = "修改数据字典", notes = "修改数据字典")
    @ApiResponses({
            @ApiResponse(code = 54501, message = "数据字典id不能为空"),
            @ApiResponse(code = 54500, message = "数据字典不能为空"),
            @ApiResponse(code = 54001, message = "数据字典类型id不能为空"),
            //@ApiResponse(code = 54502, message = "数据字典code不能为空"),
            @ApiResponse(code = 57501, message = "应用id不能为空"),
            //@ApiResponse(code = 54503, message = "数据字典code不能重复"),
    })
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public Result<Boolean> update(@RequestBody DictionaryUpdateDTO dictionaryUpdateDto) {
        //验证
        BizAssert.assertNotNull(AuthorityExceptionCode.DICTIONARY_NULL, dictionaryUpdateDto);
        BizAssert.assertNotNull(AuthorityExceptionCode.DICTIONARY_ID_NULL, dictionaryUpdateDto.getId());
        BizAssert.assertNotNull(AuthorityExceptionCode.DICTIONARY_TYPE_ID_NULL, dictionaryUpdateDto.getDictionaryTypeId());
        //BizAssert.assertNotEmpty(AuthorityExceptionCode.DICTIONARY_CODE_EMPTY, dictionaryUpdateDto.getCode());
        BizAssert.assertNotEmpty(AuthorityExceptionCode.APPLICATION_ID_NULL, dictionaryUpdateDto.getAppId());
        //BizAssert.assertFalse(AuthorityExceptionCode.DICTIONARY_TYPE_CODE_EXIST, dictionaryService.check(dictionaryUpdateDto.getCode()));
        String appId = dictionaryUpdateDto.getAppId();
        Long adminId = BaseContextHandler.getAdminId();
        //转换
        Dictionary dictionary = dozerUtils.map(dictionaryUpdateDto, Dictionary.class);
        if (dictionaryUpdateDto.getDictionaryTypeId() != null && dictionaryUpdateDto.getDictionaryTypeId() > 0) {
            DictionaryType dictionaryType = dictionaryTypeService.getByAppIdAndId(appId, dictionaryUpdateDto.getDictionaryTypeId());
            //BizAssert.assertNotNull(AuthorityExceptionCode.DICTIONARY_TYPE_EXIST, dictionaryType);
            dictionary.setDictionaryTypeCode(dictionaryType.getCode());
            dictionary.setDictionaryTypeName(dictionaryType.getName());
        }

        dictionary.setAppId(appId);
        dictionary.setUpdateUser(Long.valueOf(adminId));
        //更新
        dictionaryService.updateByAppIdAndIdSelective(appId, dictionary);
        return Result.success(true);
    }


    @Override
    @ApiOperation(value = "删除数据字典", notes = "删除数据字典")
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public Result<Boolean> delete(@RequestParam(value = "id") Long id) {
        if (id == null) {
            return Result.success(null);
        }
        //String appId = BaseContextHandler.getAppId();
        //dictionaryService.removeByAppIdAndId(appId, id);
        dictionaryService.deleteById(id);
        return Result.success(true);
    }

    @Override
    @ApiOperation(value = "查询数据字典类型", notes = "查询数据字典类型")
    @RequestMapping(value = "/getType", method = RequestMethod.GET)
    @ApiResponses({
            @ApiResponse(code = 54001, message = "数据字典类型id不能为空"),
    })
    @AppToken
    public Result<DictionaryTypeDTO> getType(@RequestParam(value = "id") Long id) {
        BizAssert.assertNotNull(AuthorityExceptionCode.DICTIONARY_TYPE_ID_NULL,String.valueOf(id));
        DictionaryTypeExample example = new DictionaryTypeExample();
        example.createCriteria().andIdEqualTo(id).andIsDeleteEqualTo(DeleteStatus.UN_DELETE.getVal());
        DictionaryType dictionaryType = dictionaryTypeService.getUnique(example);
        if (dictionaryType == null || dictionaryType.getIsDelete()) {
            return Result.success(null);
        }
        DictionaryTypeDTO dto = dozerUtils.map(dictionaryType, DictionaryTypeDTO.class);
        return Result.success(dto);
    }

    @Override
    @ApiOperation(value = "查询所有数据字典类型", notes = "查询所有数据字典类型")
    @RequestMapping(value = "/listType", method = RequestMethod.GET)
    @AppToken
    public Result<List<DictionaryTypeDTO>> listType() {
        String appId = BaseContextHandler.getAppId();
        return Result.success(dozerUtils.mapList(dictionaryTypeService.find(appId), DictionaryTypeDTO.class));
    }

    @Override
    @ApiOperation(value = "查询数据字典类型分页信息", notes = "查询数据字典类型分页信息")
    @RequestMapping(value = "/pageType", method = RequestMethod.POST)
    @AppToken
    public Result<PageInfo<DictionaryTypeDTO>> pageType(@RequestBody OpenApiReq<DictionaryTypePageReqDTO> openApiReq) {
        String appId = BaseContextHandler.getAppId();

        DictionaryTypeExample example = new DictionaryTypeExample();
        example.createCriteria().andAppIdEqualTo(appId)
                .andIsDeleteEqualTo(DeleteStatus.UN_DELETE.getVal());
        return Result.success(new PageInfo<>(dozerUtils.mapPage(dictionaryTypeService.find(example), DictionaryTypeDTO.class)));
    }

    @Override
    @ApiOperation(value = "保存数据字典类型", notes = "保存数据字典类型")
    @ApiResponses({
            @ApiResponse(code = 54000, message = "数据字典类型不能为空"),
            @ApiResponse(code = 54002, message = "数据字典编码不能为空"),
            @ApiResponse(code = 57501, message = "应用id不能为空"),
            @ApiResponse(code = 54003, message = "数据字典编码不能重复"),
    })
    @RequestMapping(value = "/saveType", method = RequestMethod.POST)
    public Result<DictionaryTypeDTO> saveType(@RequestBody DictionaryTypeSaveDTO dictionaryTypeSaveDto) {
        //验证
        BizAssert.assertNotNull(AuthorityExceptionCode.DICTIONARY_TYPE_NULL, dictionaryTypeSaveDto);
        BizAssert.assertNotEmpty(AuthorityExceptionCode.DICTIONARY_TYPE_CODE_EMPTY, dictionaryTypeSaveDto.getCode());
        BizAssert.assertNotEmpty(AuthorityExceptionCode.APPLICATION_ID_NULL, dictionaryTypeSaveDto.getAppId());

        String appId = dictionaryTypeSaveDto.getAppId();
        Long adminId = BaseContextHandler.getAdminId();
        BizAssert.assertFalse(AuthorityExceptionCode.DICTIONARY_TYPE_CODE_EXIST, dictionaryTypeService.check(dictionaryTypeSaveDto.getCode()));
        //转换
        DictionaryType dictionaryType = dozerUtils.map(dictionaryTypeSaveDto, DictionaryType.class);
        dictionaryType.setAppId(appId);
        dictionaryType.setCreateUser(Long.valueOf(adminId));
        dictionaryType.setUpdateUser(Long.valueOf(adminId));
        dictionaryType.setIsDelete(DeleteStatus.UN_DELETE.getVal());
        //保存
        dictionaryType = dictionaryTypeService.saveSelective(dictionaryType);
        return Result.success(dozerUtils.map(dictionaryType, DictionaryTypeDTO.class));
    }

    @Override
    @ApiOperation(value = "修改数据字典类型", notes = "修改数据字典类型")
    @ApiResponses({
            @ApiResponse(code = 54000, message = "数据字典类型不能为空"),
            @ApiResponse(code = 54001, message = "数据字典类型id不能为空"),
            //@ApiResponse(code = 54502, message = "数据字典code不能为空"),
            //@ApiResponse(code = 54503, message = "数据字典code不能重复"),
            @ApiResponse(code = 57501, message = "应用id不能为空"),
    })
    @RequestMapping(value = "/updateType", method = RequestMethod.POST)
    public Result<Boolean> updateType(@RequestBody DictionaryTypeUpdateDTO dictionaryTypeUpdateDto) {
        //验证
        BizAssert.assertNotNull(AuthorityExceptionCode.DICTIONARY_TYPE_NULL, dictionaryTypeUpdateDto);
        BizAssert.assertNotNull(AuthorityExceptionCode.DICTIONARY_TYPE_ID_NULL, dictionaryTypeUpdateDto.getId());
        Long adminId = BaseContextHandler.getAdminId();
        //BizAssert.assertNotEmpty(AuthorityExceptionCode.DICTIONARY_TYPE_CODE_EMPTY, dictionaryTypeUpdateDto.getCode());
        BizAssert.assertNotEmpty(AuthorityExceptionCode.APPLICATION_ID_NULL, dictionaryTypeUpdateDto.getAppId());
        String appId = dictionaryTypeUpdateDto.getAppId();
        //BizAssert.assertFalse(AuthorityExceptionCode.DICTIONARY_TYPE_CODE_EXIST, dictionaryTypeService.check(dictionaryTypeUpdateDto.getCode()));

        //转换
        DictionaryType dictionaryType = dozerUtils.map(dictionaryTypeUpdateDto, DictionaryType.class);
        dictionaryType.setAppId(appId);
        //更新
        dictionaryType.setUpdateUser(Long.valueOf(adminId));
        dictionaryTypeService.updateByAppIdAndIdSelective(appId, dictionaryType);
        return Result.success(true);
    }

    @Override
    @ApiOperation(value = "删除数据字典类型", notes = "删除数据字典类型")
    @ApiResponses({
            @ApiResponse(code = 54001, message = "数据字典类型id不能为空"),
            @ApiResponse(code = 57501, message = "应用id不能为空")
    })
    @RequestMapping(value = "/deleteType", method = RequestMethod.POST)
    public Result<Boolean> deleteType(@RequestParam(value = "id") Long id,@RequestParam(value = "appId") String appId) {
        BizAssert.assertNotNull(AuthorityExceptionCode.DICTIONARY_TYPE_ID_NULL,String.valueOf(id));
        BizAssert.assertNotEmpty(AuthorityExceptionCode.APPLICATION_ID_NULL, appId);
        if (id == null) {
            return Result.success(null);
        }
        dictionaryTypeService.deleteById(id);
        //删除字典类型下对应的数据字典(加应用id-appId)
        dictionaryService.deleteByAppIdAndTypeId(appId, id);
        return Result.success(true);
    }

    /**
     * 查找字典集合
     *
     * @param typeCode
     * @return
     */
    @Override
    @ApiResponses({
            @ApiResponse(code = 54000, message = "数据字典类型不能为空")
    })
    @RequestMapping(value = "/findDictionary", method = RequestMethod.GET)
    @ApiOperation(value = "根据typeCode查找字典,node.type：节点类型;org.ascription：单位归口;" +
            "app_type：所属系统;level：所属级别;org.type：所属类型", notes = "根据typeCode查找字典")
    @AppToken
    public Result<Map<String, Map<String, String>>> findDictionary(@RequestParam(value = "typeCode[]") String[] typeCode) {
        //验证
        BizAssert.assertNotNull(AuthorityExceptionCode.DICTIONARY_TYPE_NULL, typeCode);

        //查询字典信息
        List<List<Dictionary>> list = dictionaryService.findByTypeCode(typeCode);

        //转换为map
        Map<String, Map<String, String>> map = new HashMap<>();
        for (List<Dictionary> dictionarys : list) {
            if (dictionarys.size() > 0 && !map.containsKey(dictionarys.get(0).getDictionaryTypeCode())) {
                map.put(dictionarys.get(0).getDictionaryTypeCode(), new LinkedHashMap<String, String>());
            }
            for (Dictionary dictionary : dictionarys) {
                map.get(dictionary.getDictionaryTypeCode()).put(dictionary.getCode(), dictionary.getName());
            }
        }
        return Result.success(map);
    }

    @Override
    @ApiOperation(value = "获取数据字段类型树", notes = "根据父id-parentid查询数据字段类型树List")
    @RequestMapping(value = "/dictionaryTree", method = RequestMethod.GET)
    @AppToken
    public Result<List<DictionaryTreeDTO>> dictionaryTree(@RequestParam(value = "appId") String appId, @RequestParam(value = "parentId") Long parentId) {
        if (null == parentId) {
            return Result.success(null);
        }
        List<DictionaryTreeDTO> treeList = dozerUtils.mapList(dictionaryTypeService.getSubDictionaryList(appId,parentId), DictionaryTreeDTO.class);
        return Result.success(TreeUtil.queryTree(treeList, parentId));
    }

    @Override
    @ApiOperation(value = "根据字典编码code查询数据字典List", notes = "根据字典编码code 查询数据字典List")
    @RequestMapping(value = "/getCodeListNoAppId", method = RequestMethod.GET)
    @AppToken
    public Result<List<DictionaryDTO>> getCodeListNoAppId(@RequestParam(value = "code") String code) {
        if (code == null) {
            return Result.success(null);
        }
        return Result.success(dozerUtils.mapList(dictionaryService.findByCodeList(null,code), DictionaryDTO.class));
    }
}