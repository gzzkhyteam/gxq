package com.hengyunsoft.platform.hardware.impl.dic;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hengyunsoft.base.Result;
import com.hengyunsoft.commons.context.BaseContextHandler;
import com.hengyunsoft.commons.exception.core.HardWareExceptionCode;
import com.hengyunsoft.commons.utils.context.DozerUtils;
import com.hengyunsoft.page.plugins.openapi.OpenApiReq;
import com.hengyunsoft.platform.hardware.dto.dic.*;
import com.hengyunsoft.platform.hardware.entity.dic.po.Dictionary;
import com.hengyunsoft.platform.hardware.entity.dic.po.DictionaryType;
import com.hengyunsoft.platform.hardware.repository.dic.example.DictionaryExample;
import com.hengyunsoft.platform.hardware.repository.dic.example.DictionaryTypeExample;
import com.hengyunsoft.platform.hardware.repository.dic.service.DictionaryService;
import com.hengyunsoft.platform.hardware.repository.dic.service.DictionaryTypeService;
import com.hengyunsoft.platform.hardware.util.pinyin.Pinyin4jUtil;
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
import java.util.stream.Collectors;


@Api(value = "API - DictionaryApiImpl", description = "数据字典管理")
@RestController
@RequestMapping("dictionary")
@Slf4j
public class DictionaryApiImpl {

    @Autowired
    private DictionaryService dictionaryService;
    @Autowired
    private DictionaryTypeService dictionaryTypeService;


    @Autowired
    private DozerUtils dozerUtils;

    /**
     * 查询字典类型数据列表
     *
     * @return
     */
    @ApiOperation(value = "查询字典类型数据列表", notes = "查询字典类型数据列表")
    @RequestMapping(value = "findDictionaryTypeList", method = RequestMethod.GET)
    @ApiResponses({
            @ApiResponse(code = 100504, message = "父id不能为空"),
    })
    public Result<List<DictionaryTypeListDTO>> findDictionaryTypeList() {
        DictionaryTypeExample dictionaryTypeExample = new DictionaryTypeExample();
        dictionaryTypeExample.createCriteria().andIsDeleteEqualTo(false);
        List<DictionaryType> dictionaryTypes = dictionaryTypeService.find(dictionaryTypeExample);
        List<DictionaryTypeListDTO> dictionaryTypeListDTOs = dozerUtils.mapList(dictionaryTypes, DictionaryTypeListDTO.class);
        Result<List<DictionaryTypeListDTO>> success = Result.success(dictionaryTypeListDTOs, "success");
        return success;
    }

    /**
     * 保存字典类型数据
     *
     * @param saveDictionaryType
     * @return
     */
    @ApiOperation(value = "保存字典类型数据", notes = "保存字典类型数据")
    @RequestMapping(value = "saveDictionaryType", method = RequestMethod.POST)
    @ApiResponses({
            @ApiResponse(code = 100504, message = "父id不能为空"),
            @ApiResponse(code = 100502, message = "字典类型编码不能为空"),
            @ApiResponse(code = 100503, message = "字典类型名称不能为空"),
    })
    public Result<Boolean> saveDictionaryType(@RequestBody SaveDictionaryTypeDTO saveDictionaryType) {
        //1.校验
        BizAssert.assertNotNull(HardWareExceptionCode.PARENTID_NULL, saveDictionaryType.getParentId());
        BizAssert.assertNotNull(HardWareExceptionCode.DICTYPECODE_NULL, saveDictionaryType.getCode());
        BizAssert.assertNotNull(HardWareExceptionCode.DICTYPENAME_NULL, saveDictionaryType.getName());
        if (saveDictionaryType != null) {
            DictionaryType dt = dozerUtils.map(saveDictionaryType, DictionaryType.class);
            dt.setCreateTime(new Date());
            dt.setCreateUser(BaseContextHandler.getAdminId());
            dt.setUpdateTime(new Date());
            dt.setUpdateUser(BaseContextHandler.getAdminId());
            dt.setIsDelete(false);
            String simplePinyinHeadChar = Pinyin4jUtil.getSimplePinyinHeadChar(dt.getName());
            String code = dt.getCode() + "_" + simplePinyinHeadChar;
          /* DictionaryTypeExample de=new DictionaryTypeExample();
           de.createCriteria().andCodeEqualTo(code);
           List<DictionaryType> dictionaryTypes = dictionaryTypeService.find(de);
           if(dictionaryTypes.size()>0){
               StringBuilder sb=new StringBuilder(code);
               StringBuilder stb = sb.append("A");
               code= stb.toString();
           }*/
            dt.setCode(code);
            dictionaryTypeService.save(dt);
            return Result.success(true, "true");
        }
        return Result.fail("false");
    }

    /**
     * 修改字典类型数据
     *
     * @param updateDictionaryType
     * @return
     */
    @ApiOperation(value = "修改字典类型数据", notes = "修改字典类型数据")
    @RequestMapping(value = "updateDictionaryType", method = RequestMethod.POST)
    @ApiResponses({
            @ApiResponse(code = 100501, message = "字典类型id不能为空"),
            @ApiResponse(code = 100502, message = "字典类型编码不能为空"),
            @ApiResponse(code = 100503, message = "字典类型名称不能为空")
    })
    public Result<Boolean> updateDictionaryType(@RequestBody UpdateDictionaryTypeDTO updateDictionaryType) {
        //1.校验
        BizAssert.assertNotNull(HardWareExceptionCode.DICTYPEID_NULL, updateDictionaryType.getId());
        BizAssert.assertNotNull(HardWareExceptionCode.DICTYPECODE_NULL, updateDictionaryType.getCode());
        BizAssert.assertNotNull(HardWareExceptionCode.DICTYPENAME_NULL, updateDictionaryType.getName());
        if (updateDictionaryType.getId() != 0) {
            DictionaryType dt = dozerUtils.map(updateDictionaryType, DictionaryType.class);
            dt.setUpdateTime(new Date());
            dt.setUpdateUser(BaseContextHandler.getAdminId());
            dictionaryTypeService.updateByIdSelective(dt);
            return Result.success(true, "true");
        }
        return Result.fail("false");
    }

    /**
     * 删除字典类型数据
     *
     * @param id
     * @return
     */
    @ApiOperation(value = "删除字典类型数据", notes = "删除字典类型数据")
    @RequestMapping(value = "deleteDictionaryType", method = RequestMethod.GET)
    @ApiResponses({
            @ApiResponse(code = 100501, message = "字典类型id不能为空")
    })
    public Result<Boolean> deleteDictionaryType(@RequestParam Long id) {
        //1.校验
        BizAssert.assertNotNull(HardWareExceptionCode.DICTYPEID_NULL, id);
        if (id != 0) {
            DictionaryType dt = new DictionaryType();
            dt.setId(id);
            dt.setIsDelete(true);
            dt.setUpdateTime(new Date());
            dt.setUpdateUser(BaseContextHandler.getAdminId());
            dictionaryTypeService.updateByIdSelective(dt);
            return Result.success(true, "true");
        }
        return Result.fail("false");
    }

    /**
     * 保存字典数据
     *
     * @param addDictionary
     * @return
     */
    @ApiOperation(value = "保存字典数据", notes = "保存字典数据")
    @RequestMapping(value = "saveDictionary", method = RequestMethod.POST)
    @ApiResponses({
            @ApiResponse(code = 100501, message = "字典类型id不能为空"),
            @ApiResponse(code = 100502, message = "字典类型编码不能为空"),
            @ApiResponse(code = 100503, message = "字典类型名称不能为空"),
            @ApiResponse(code = 100505, message = "字典名称不能为空"),
    })
    public Result<Boolean> saveDictionary(@RequestBody AddDictionaryDTO addDictionary) {
        //1.校验
        BizAssert.assertNotNull(HardWareExceptionCode.DICTYPEID_NULL, addDictionary.getDictionaryTypeId());
        BizAssert.assertNotNull(HardWareExceptionCode.DICTYPECODE_NULL, addDictionary.getDictionaryTypeCode());
        BizAssert.assertNotNull(HardWareExceptionCode.DICTYPENAME_NULL, addDictionary.getDictionaryTypeName());
        BizAssert.assertNotNull(HardWareExceptionCode.DICNAME_NULL, addDictionary.getName());
        if (addDictionary != null) {
            Dictionary dictionary = dozerUtils.map(addDictionary, Dictionary.class);
            dictionaryService.saveDictionary(dictionary);
            Result<Boolean> success = Result.success(true, "success");
            return success;

        }
        Result<Boolean> fail = Result.fail("fail");
        return fail;
    }

    /**
     * 修改字典数据
     *
     * @param updateDictionaryDTO
     * @return
     */
    @ApiOperation(value = "修改字典数据", notes = "修改字典数据")
    @RequestMapping(value = "updateDictionary", method = RequestMethod.POST)
    @ApiResponses({
            @ApiResponse(code = 100500, message = "字典id不能为空"),
            @ApiResponse(code = 100505, message = "字典名称不能为空")
    })
    public Result<Boolean> updateDictionary(@RequestBody UpdateDictionaryDTO updateDictionaryDTO) {
        //1.校验
        BizAssert.assertNotNull(HardWareExceptionCode.DICID_NULL, updateDictionaryDTO.getId());
        BizAssert.assertNotNull(HardWareExceptionCode.DICNAME_NULL, updateDictionaryDTO.getName());
        if (updateDictionaryDTO.getId() != 0) {
            Dictionary dictionary = dozerUtils.map(updateDictionaryDTO, Dictionary.class);
            dictionary.setUpdateTime(new Date());
            dictionary.setUpdateUser(BaseContextHandler.getAdminId());
            dictionaryService.updateByIdSelective(dictionary);
            Result<Boolean> aTrue = Result.success(true, "true");
            return aTrue;
        }
        Result<Boolean> result = Result.fail("false");
        return result;
    }

    /**
     * 删除字典数据
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "deleteDictionary", method = RequestMethod.GET)
    @ApiOperation(value = "删除字典数据", notes = "删除字典数据")
    @ApiResponses({
            @ApiResponse(code = 100500, message = "字典id不能为空"),
    })
    public Result<Boolean> deleteDictionary(@RequestParam Long id) {
        //1.校验
        BizAssert.assertNotNull(HardWareExceptionCode.DICID_NULL, id);
        if (id != 0) {
            Dictionary de = new Dictionary();
            de.setId(id);
            de.setIsDelete(true);
            de.setUpdateUser(BaseContextHandler.getAdminId());
            de.setUpdateTime(new Date());
            dictionaryService.updateByIdSelective(de);
            Result<Boolean> aTrue = Result.success(true, "true");
            return aTrue;
        } else {
            return Result.fail("false");
        }

    }

    /**
     * 查询字典数据
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "findDictionary", method = RequestMethod.GET)
    @ApiOperation(value = "查询字典数据", notes = "查询字典数据")
    @ApiResponses({
            @ApiResponse(code = 100500, message = "字典id不能为空"),
    })
    public Result<AddDictionaryDTO> findDictionary(@RequestParam Long id) {
        //1.校验
        BizAssert.assertNotNull(HardWareExceptionCode.DICID_NULL, id);
        Dictionary dr = dictionaryService.getById(id);
        AddDictionaryDTO map = dozerUtils.map(dr, AddDictionaryDTO.class);
        Result<AddDictionaryDTO> aTrue = Result.success(map, "true");
        return aTrue;
    }

    /**
     * 查询字典类型数据
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "findDictionaryType", method = RequestMethod.GET)
    @ApiOperation(value = "查询字典类型数据", notes = "查询字典类型数据")
    @ApiResponses({
            @ApiResponse(code = 100501, message = "字典类型id不能为空"),
    })
    public Result<SaveDictionaryTypeDTO> findDictionaryType(@RequestParam Long id) {
        //校验
        BizAssert.assertNotNull(HardWareExceptionCode.DICTYPEID_NULL, id);
        DictionaryType dr = dictionaryTypeService.getById(id);
        SaveDictionaryTypeDTO map = dozerUtils.map(dr, SaveDictionaryTypeDTO.class);
        Result<SaveDictionaryTypeDTO> aTrue = Result.success(map, "true");
        return aTrue;
    }

    /**
     * 通过编码查询数据
     *
     * @param code
     * @return
     */
    @RequestMapping(value = "findByCode", method = RequestMethod.GET)
    @ApiOperation(value = "通过编码查询数据", notes = "通过编码查询数据")
    @ApiResponses({
            @ApiResponse(code = 100502, message = "字典类型编码不能为空")
    })
    public Result<List<FindByCodeDTO>> findByCode(@RequestParam String code) {
        //校验
        BizAssert.assertNotNull(HardWareExceptionCode.DICTYPECODE_NULL, code);
        DictionaryTypeExample de = new DictionaryTypeExample();
        de.createCriteria().andCodeEqualTo(code);
        DictionaryType dt = dictionaryTypeService.getUnique(de);
        DictionaryTypeExample dte = new DictionaryTypeExample();
        dte.createCriteria().andParentIdEqualTo(dt.getId())
                .andIsDeleteEqualTo(false);
        List<DictionaryType> dictionaryTypes = dictionaryTypeService.find(dte);
        List<FindByCodeDTO> findByCodeDTOs = dozerUtils.mapList(dictionaryTypes, FindByCodeDTO.class);
        Result<List<FindByCodeDTO>> success = Result.success(findByCodeDTOs);
        return success;
    }

    /**
     * 20180830新增网络宽带
     *
     * @param code
     * @return
     */
    @RequestMapping(value = "findByTypeCode", method = RequestMethod.GET)
    @ApiOperation(value = "通过编码查询子项数据", notes = "通过编码查询子项数据")
    @ApiResponses({
            @ApiResponse(code = 100502, message = "字典类型编码不能为空")
    })
    public Result<List<FindByCodeDTO>> findByTypeCode(@RequestParam String code) {
        //校验
        BizAssert.assertNotNull(HardWareExceptionCode.DICTYPECODE_NULL, code);
        DictionaryExample example = new DictionaryExample();
        example.createCriteria().andDictionaryTypeCodeEqualTo(code).andIsDeleteEqualTo(false).andIsEnableEqualTo(true);
        List<Dictionary> dictionary = dictionaryService.find(example);
        List<FindByCodeDTO> findByCodeDTOs = dozerUtils.mapList(dictionary, FindByCodeDTO.class);
        Result<List<FindByCodeDTO>> success = Result.success(findByCodeDTOs);
        return success;
    }

    /**
     * 查询数据字典分页信息
     *
     * @param openApiReq
     * @return
     */
    @ApiOperation(value = "查询数据字典分页信息", notes = "查询数据字典分页信息")
    @RequestMapping(value = "/pageDictionaryList", method = RequestMethod.POST)
    @ApiResponses({
            @ApiResponse(code = 100501, message = "字典类型id不能为空"),
    })
    public Result<PageInfo<PageDictionaryListDTO>> pageDictionaryList(@RequestBody OpenApiReq<DictionaryListDTO> openApiReq) {
        //1.校验
        BizAssert.assertNotNull(HardWareExceptionCode.DICTYPEID_NULL, openApiReq.getData().getDictionaryTypeId());
        DictionaryExample example = new DictionaryExample();
        example.createCriteria().andIsDeleteEqualTo(false)
                .andDictionaryTypeIdEqualTo(openApiReq.getData().getDictionaryTypeId());
        example.setOrderByClause("create_time desc");
        PageHelper.startPage(openApiReq.getPageNo(), openApiReq.getPageSize());
        return Result.success(new PageInfo<>(dozerUtils.mapPage(dictionaryService.find(example), PageDictionaryListDTO.class)));
    }

    /**
     * 通过编码查询字典树
     *
     * @param code
     * @return
     * @wz
     */
    @RequestMapping(value = "findDictionaryTree", method = RequestMethod.GET)
    @ApiOperation(value = "通过编码查询字典树", notes = "通过编码查询字典树")
    @ApiResponses({
            @ApiResponse(code = 100502, message = "字典类型编码不能为空")
    })
    public Result<List<FindByCodeTreeDTO>> findDictionaryTree(@RequestParam String code) {
        //校验
        BizAssert.assertNotNull(HardWareExceptionCode.DICTYPECODE_NULL, code);
        DictionaryTypeExample de = new DictionaryTypeExample();
        de.createCriteria()
                .andCodeEqualTo(code)
                .andIsDeleteEqualTo(false);
        DictionaryType dt = dictionaryTypeService.getUnique(de);

        //查询出子type的集合
        DictionaryTypeExample typeExample = new DictionaryTypeExample();
        typeExample.createCriteria()
                .andParentIdEqualTo(dt.getId())
                .andIsDeleteEqualTo(false);
        List<DictionaryType> typeList = dictionaryTypeService.find(typeExample);

        //查出dictionary的集合
        DictionaryExample dictionaryExample = new DictionaryExample();

        dictionaryExample.createCriteria().andIsDeleteEqualTo(false)
                .andDictionaryTypeCodeIn(typeList.stream().map(DictionaryType::getCode).collect(Collectors.toList()));
        List<FindByCodeDTO> dictionaryList = dozerUtils
                .mapList(dictionaryService.find(dictionaryExample), FindByCodeDTO.class);

        //整理数据
        List<FindByCodeTreeDTO> trees = typeList.size() != 0
                ? dozerUtils.mapList(typeList, FindByCodeTreeDTO.class) : new ArrayList<>();
        dictionaryList.stream().collect(Collectors.groupingBy(FindByCodeDTO::getDictionaryTypeCode))
                .forEach((dictionaryTypeCode, dtos) -> {
                    int index = trees.stream().map(FindByCodeTreeDTO::getCode)
                            .collect(Collectors.toList()).indexOf(dictionaryTypeCode);
                    if (index > -1 && index < trees.size()) {
                        trees.get(index).setDtos(dtos);
                    }
                });

        //返回
        return Result.success(trees);
    }

}