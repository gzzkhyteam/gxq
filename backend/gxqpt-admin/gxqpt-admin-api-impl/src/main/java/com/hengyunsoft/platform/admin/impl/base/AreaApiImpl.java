package com.hengyunsoft.platform.admin.impl.base;


import com.hengyunsoft.base.Result;
import com.hengyunsoft.commons.context.BaseContextHandler;
import com.hengyunsoft.commons.context.CommonConstants;
import com.hengyunsoft.commons.exception.core.AuthorityExceptionCode;
import com.hengyunsoft.commons.utils.context.DozerUtils;
import com.hengyunsoft.platform.admin.api.base.api.AreaApi;
import com.hengyunsoft.platform.admin.api.base.dto.AreaDTO;
import com.hengyunsoft.platform.admin.api.base.dto.AreaSaveDTO;
import com.hengyunsoft.platform.admin.api.base.dto.AreaTreeDTO;
import com.hengyunsoft.platform.admin.api.base.dto.AreaUpdateDTO;
import com.hengyunsoft.platform.admin.entity.base.po.Area;
import com.hengyunsoft.platform.admin.repository.base.example.AreaExample;
import com.hengyunsoft.platform.admin.repository.base.service.AreaService;
import com.hengyunsoft.platform.commons.utils.TreeUtil;
import com.hengyunsoft.utils.BizAssert;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


/**
 * @author tianai
 * @createTime 2018-30
 */
@Api(value = "API - AreaApiImpl", description = "地区名称信息管理")
@RestController
@RequestMapping("area")
@Slf4j
public class AreaApiImpl implements AreaApi {

    @Autowired
    private AreaService areaService;
    @Autowired
    private DozerUtils dozerUtils;

    @Override
    @ApiOperation(value = "获取区域树", notes = "根据父id-parentid查询地区名称信息List")
    @RequestMapping(value = "/findAreaTree", method = RequestMethod.GET)
    public Result<List<AreaTreeDTO>> findAreaTree(@RequestParam(value = "parentId") Long parentId) {
        if (null == parentId) {
            return Result.success(null);
        }
        List<AreaTreeDTO> treeList = dozerUtils.mapList(areaService.getSubAreaIdList(parentId), AreaTreeDTO.class);
        return Result.success(TreeUtil.queryTree(treeList, parentId));
    }

    @Override
    @ApiOperation(value = "根据id查询区域名称", notes = "根据id查询区域名称")
    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public Result<AreaDTO> get(@RequestParam(value = "id") Long id) {
        if (id == null) {
            return Result.success(null);
        }
        AreaExample example = new AreaExample();
        example.createCriteria().andIdEqualTo(id);
        Area area = areaService.getUnique(example);
        if (area == null) {
            return Result.success(null);
        }
        AreaDTO dto = dozerUtils.map(area, AreaDTO.class);
        return Result.success(dto);
    }


    @Override
    @ApiOperation(value = "保存地区信息", notes = "保存地区信息")
    @ApiResponses({
            @ApiResponse(code = 55001, message = "地区名称不能为空"),
            @ApiResponse(code = 55002, message = "地区全称不能为空"),
            @ApiResponse(code = 55005, message = "地区编码不能为空"),
            @ApiResponse(code = 55006, message = "地区编码已存在"),
            @ApiResponse(code = 55007, message = "地区名称不能以数字开头且不应包含空格"),
    })
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public Result<AreaDTO> save(@RequestBody AreaSaveDTO areaSaveDto) {
        //1.校验
        BizAssert.assertNotNull(AuthorityExceptionCode.AREA_NAME_NULL, areaSaveDto.getName());
        BizAssert.assertNotNull(AuthorityExceptionCode.AREA_FULLNAME_NULL, areaSaveDto.getFullName());
        BizAssert.assertNotNull(AuthorityExceptionCode.AREA_CODE_NULL, areaSaveDto.getCode());
        BizAssert.assertFalse(AuthorityExceptionCode.AREA_CODE_EXIST, areaService.check(areaSaveDto.getCode()));
        if (areaSaveDto.getOrderNum() == null) {
            areaSaveDto.setOrderNum(0);
        }
        String name = areaSaveDto.getName();
        if (!StringUtils.isNoneBlank(name) || name.matches("[0-9]+.*")){
            BizAssert.fail(AuthorityExceptionCode.AREA_NAME_ERROR);
        }

        //2.转换
        Area area = dozerUtils.map(areaSaveDto, Area.class);
        //3.数据处理
        if (areaSaveDto.getParentId() == null || areaSaveDto.getParentId() <= 0) {
            areaSaveDto.setParentId(CommonConstants.PARENT_ID_DEF);
            area.setTreePath(CommonConstants.ROOT_PATH_DEF);
        } else {
            AreaExample example = new AreaExample();
            example.createCriteria().andIdEqualTo(areaSaveDto.getParentId());
            Area parent = areaService.getUnique(example);
            BizAssert.assertNotNull(AuthorityExceptionCode.AREA_PARENT_NULL, parent);
            area.setTreePath(parent.getTreePath() + parent.getId() + CommonConstants.ROOT_PATH_DEF);
        }
        Long adminId = BaseContextHandler.getAdminId();
        area.setCreateUser(Long.valueOf(adminId));
        area.setUpdateUser(Long.valueOf(adminId));
        //4.保存
        area = areaService.saveSelective(area);
        return Result.success(dozerUtils.map(area, AreaDTO.class));
    }

    @Override
    @ApiOperation(value = "修改地区信息", notes = "修改地区信息")
    @ApiResponses({
            @ApiResponse(code = 55001, message = "地区名称不能为空"),
            @ApiResponse(code = 55002, message = "地区全称不能为空"),
            @ApiResponse(code = 55003, message = "地区id不能为空"),
            @ApiResponse(code = 55005, message = "地区编码不能为空"),
    })
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public Result<Boolean> update(@RequestBody AreaUpdateDTO areaUpdateDto) {
        //1.校验
        BizAssert.assertNotNull(AuthorityExceptionCode.AREA_NAME_NULL, areaUpdateDto.getName());
        BizAssert.assertNotNull(AuthorityExceptionCode.AREA_FULLNAME_NULL, areaUpdateDto);
        BizAssert.assertNotNull(AuthorityExceptionCode.AREA_ID_NULL, areaUpdateDto.getId());
        BizAssert.assertNotNull(AuthorityExceptionCode.AREA_CODE_NULL, areaUpdateDto.getCode());
        Long adminId = BaseContextHandler.getAdminId();
        //2.转换
        String name = areaUpdateDto.getName();
        if (!StringUtils.isNoneBlank(name) || name.matches("[0-9]+.*")){
            BizAssert.fail(AuthorityExceptionCode.AREA_NAME_ERROR);
        }

        Area area = dozerUtils.map(areaUpdateDto, Area.class);
        area.setUpdateUser(Long.valueOf(adminId));
        //3修改
        areaService.updateById(area);
        return Result.success(true);
    }

    @Override
    @ApiOperation(value = "删除地区以及其所有的子地区", notes = "删除地区以及其所有的子地区")
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public Result<Boolean> delete(@RequestParam(value = "id") Long id) {
        if (id == null) {
            return Result.success(null);
        }
        areaService.deleteAllById(id);
        return Result.success(true);
    }

    /**
     * 根据id查询下一级地区信息
     *
     * @param id
     * @return
     */
    @Override
    @ApiOperation(value = "根据id查询下一级地区信息", notes = "根据id查询下一级地区信息")
    @ApiResponses({
            @ApiResponse(code = 55000, message = "地区父id不能为空"),
    })
    @RequestMapping(value = "/find", method = RequestMethod.GET)
    public Result<List<AreaDTO>> find(@RequestParam(value = "parentId") Long parentId) {
        //1.校验
        BizAssert.assertNotNull(AuthorityExceptionCode.AREA_ID_NULL, parentId);

        //2.查询
        AreaExample example = new AreaExample();
        example.createCriteria().andParentIdEqualTo(parentId);
        List<Area> area = areaService.find(example);
        if (area == null) {
            return Result.success(null);
        }
        List<AreaDTO> dto = dozerUtils.mapList(area, AreaDTO.class);
        return Result.success(dto);
    }
}
