package com.hengyunsoft.platform.warn.impl;

import com.hengyunsoft.base.Result;
import com.hengyunsoft.commons.context.BaseContextHandler;
import com.hengyunsoft.commons.exception.core.WarnExceptionCode;
import com.hengyunsoft.commons.servicemodule.annotation.WarnSendModule;
import com.hengyunsoft.commons.utils.context.DozerUtils;
import com.hengyunsoft.platform.commons.utils.TreeUtil;
import com.hengyunsoft.platform.warn.api.warntype.dto.GxqptWarnTypeDTO;
import com.hengyunsoft.platform.warn.api.warntype.dto.UpdateGxqptWarnTypeDTO;
import com.hengyunsoft.platform.warn.api.warntype.dto.WarnTreeDTO;
import com.hengyunsoft.platform.warn.entity.po.GxqptWarnType;
import com.hengyunsoft.platform.warn.repository.dao.GxqptWarnTypeMapper;
import com.hengyunsoft.platform.warn.repository.example.GxqptWarnTypeExample;
import com.hengyunsoft.platform.warn.repository.service.GxqptWarnTypeService;
import com.hengyunsoft.utils.BizAssert;

import com.hengyunsoft.validator.annotation.Constraint;
import com.hengyunsoft.validator.annotation.ValidatorStandard;
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
import java.util.Map;


/**
 * @author zjr
 * @date 2018/03/27
 */
@Api(value = "API - GxqptWarnTypeApiImpl", description = "预警类型管理")
@RestController
@RequestMapping("warntype")
@Slf4j
@WarnSendModule
public class GxqptWarnTypeApiImpl {

    @Autowired
    private GxqptWarnTypeService gxqptWarnTypeService;
    @Autowired
    private DozerUtils dozerUtils;
    @Autowired
    private GxqptWarnTypeMapper gxqptWarnTypeMapper;

    /**
     * 获取预警类型分类树
     * @param id
     * @return
     */
    @ApiOperation(value = "获取预警类型分类树", notes = "获取预警类型分类树")
    @RequestMapping(value = "/findWarnTypeTree", method = RequestMethod.GET)
    public Result<List<WarnTreeDTO>> findWarnTypeTree(@RequestParam(value = "id") Long id){
        String rootId = null;
        GxqptWarnTypeExample gxqptWarnTypeExample = new GxqptWarnTypeExample();
        gxqptWarnTypeExample.createCriteria();
        gxqptWarnTypeExample.setOrderByClause("parent_id");
        List<GxqptWarnType> gxqptWarnTypeList = gxqptWarnTypeService.find(gxqptWarnTypeExample);
        if (gxqptWarnTypeList != null) {
            List<WarnTreeDTO> treeList = dozerUtils.mapList(gxqptWarnTypeList, WarnTreeDTO.class);
//            //返回当前位置的层级位置  根节点为第一层 eg:  1-2-3   2属于根2层
//            if(treeList.size()>0){
//                for(WarnTreeDTO warnTreeDTO: treeList){
//                    if(!warnTreeDTO.getLeve().isEmpty()){
//                        String[] levelNum = warnTreeDTO.getLeve().split("-");
//                        warnTreeDTO.setLeve(String.valueOf(levelNum.length));
//                    }
//                }
//            }
            if (id != null) {
                for (WarnTreeDTO tree : treeList) {
                    if (tree.getId() == id) {
                        tree.setChecked(true);
                        break;
                    }
                }
            }
            //获取根Id
            for (WarnTreeDTO dto : treeList) {
                if (dto.getParentId().toString().equals("-1")) {
                    rootId = dto.getId().toString();
                }
            }
            return Result.success(TreeUtil.build(treeList, rootId));
        } else {
            return Result.success(null);
        }
    }

    @ApiOperation(value = "查询预警类型", notes = "查询预警类型")
    @RequestMapping(value = "/getWarnType", method = RequestMethod.GET)
    public Result<List<Map<String,Object>>> getWarnType(){
        List<Map<String,Object>> handler = gxqptWarnTypeMapper.getWarnType();
        return Result.success(handler);
    }

    /**
     * 根据id查询预警类型信息
     * @param id
     * @return
     */
    @ApiOperation(value = "根据id查询预警类型信息", notes = "根据id查询预警类型信息")
    @RequestMapping(value = "/getById", method = RequestMethod.GET)
    @ApiResponses({
            @ApiResponse(code = 31000, message = "预警信息id为空"),
    })
    public Result<GxqptWarnTypeDTO> getById(@RequestParam(value = "id") Long id){
        //1.校验
        BizAssert.assertNotNull(WarnExceptionCode.WARN_TYPE_ID_NULL,id);
        //2.查询
        GxqptWarnType warnType = gxqptWarnTypeService.getById(id);
        return Result.success(dozerUtils.map(warnType, GxqptWarnTypeDTO.class));

    }
    /**
     * 添加预警类型信息
     * @param gxqptWarnTypeDto
     * @return
     */
    @ApiOperation(value = "添加预警类型信息", notes = "添加预警类型信息")
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    @ApiResponses({
            @ApiResponse(code = 31000, message = "预警信息id为空"),
            @ApiResponse(code = 31003, message = "预警类型名称不能为空"),
            @ApiResponse(code = 31004, message = "预警类型编码不能为空"),
    })
    @ValidatorStandard(
            {
                    @Constraint(value = GxqptWarnType.class)
            }
    )
    public Result<GxqptWarnTypeDTO> save(@RequestBody GxqptWarnTypeDTO gxqptWarnTypeDto){
        //1.校验
        BizAssert.assertNotNull(WarnExceptionCode.WARN_TYPE_ID_NULL,gxqptWarnTypeDto);
        BizAssert.assertNotEmpty(WarnExceptionCode.WARN_TYPE_NAME_EMPTY,gxqptWarnTypeDto.getTypeName());
        BizAssert.assertNotEmpty(WarnExceptionCode.WARN_TYPE_CODE_EMPTY,gxqptWarnTypeDto.getCode());
        if(gxqptWarnTypeDto.getIsEnable()==null){
            gxqptWarnTypeDto.setIsEnable(1);
        }
        //确保 业务类型名称和编码的唯一性
        GxqptWarnTypeExample gxqptWarnTypeExample = new GxqptWarnTypeExample();
        if(!gxqptWarnTypeDto.getTypeName().isEmpty()){
            gxqptWarnTypeExample.createCriteria().andTypeNameEqualTo(gxqptWarnTypeDto.getTypeName());
            List<GxqptWarnType> gxqptWarnTypes = gxqptWarnTypeService.find(gxqptWarnTypeExample);
            if(gxqptWarnTypes.size()>0){
                return Result.fail("分类名称已存在！！");
            }
        }
        if(!gxqptWarnTypeDto.getCode().isEmpty()){
            gxqptWarnTypeExample.clear();
            gxqptWarnTypeExample.createCriteria().andCodeEqualTo(gxqptWarnTypeDto.getCode());
            List<GxqptWarnType> gxqptWarnTypes = gxqptWarnTypeService.find(gxqptWarnTypeExample);
            if(gxqptWarnTypes.size()>0){
                return Result.fail("预警编码已存在！！");
            }
        }

        //2.转换
        GxqptWarnType gxqptWarnType = dozerUtils.map(gxqptWarnTypeDto,GxqptWarnType.class);
        //3.数据处理
        gxqptWarnType.setCreateUser(BaseContextHandler.getAdminId().toString());
        gxqptWarnType.setUpdateUser(BaseContextHandler.getAdminId().toString());
        Date nowDate = new Date();
        gxqptWarnType.setCreateTime(nowDate);
        if (gxqptWarnType.getParentId() == null) {
            long pId=gxqptWarnTypeMapper.getIdByParentId(-1L);
            gxqptWarnType.setParentId(pId);
        }
        //4.保存
        GxqptWarnType warnType =  gxqptWarnTypeService.save(gxqptWarnType);
        //自动生成资源层级
        String leave = generateCode(gxqptWarnType);
        //自动生成序号
        Integer orderNo = generateOrderNo(gxqptWarnType);
        gxqptWarnType.setOrderNo(orderNo);
        gxqptWarnType.setLeve(leave);
        gxqptWarnTypeService.updateByIdSelective(gxqptWarnType);
        //返回
        if(warnType.getId()!=null){
            return Result.success(dozerUtils.map(warnType,GxqptWarnTypeDTO.class));
        }
        return Result.fail("保存失败！");
    }

    /**
     * 根据id编辑预警类型信息
     * @param updateGxqptWarnTypeDto
     * @return
     */
    @ApiOperation(value="根据id编辑预警类型信息",notes = "根据id编辑预警类型信息")
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    @ApiResponses({
            @ApiResponse(code = 31000, message = "预警信息id为空"),
    })
    @ValidatorStandard(
            {
                    @Constraint(value = GxqptWarnType.class)
            }
    )
    public Result<UpdateGxqptWarnTypeDTO> update(@RequestBody UpdateGxqptWarnTypeDTO updateGxqptWarnTypeDto){
        //1.校验
        BizAssert.assertNotNull(WarnExceptionCode.WARN_TYPE_ID_NULL,updateGxqptWarnTypeDto.getId());
        //确保 业务类型名称和编码的唯一性
        GxqptWarnTypeExample gxqptWarnTypeExample = new GxqptWarnTypeExample();
        if(!updateGxqptWarnTypeDto.getTypeName().isEmpty()){
            gxqptWarnTypeExample.createCriteria().andTypeNameEqualTo(updateGxqptWarnTypeDto.getTypeName()).andIdNotEqualTo(updateGxqptWarnTypeDto.getId());
            List<GxqptWarnType> gxqptWarnTypes = gxqptWarnTypeService.find(gxqptWarnTypeExample);
            if(gxqptWarnTypes.size()>0){
                return Result.fail("分类名称已存在！！");
            }
        }
        if(!updateGxqptWarnTypeDto.getCode().isEmpty()){
            gxqptWarnTypeExample.clear();
            gxqptWarnTypeExample.createCriteria().andCodeEqualTo(updateGxqptWarnTypeDto.getCode()).andIdNotEqualTo(updateGxqptWarnTypeDto.getId());
            List<GxqptWarnType> gxqptWarnTypes = gxqptWarnTypeService.find(gxqptWarnTypeExample);
            if(gxqptWarnTypes.size()>0){
                return Result.fail("预警编码已存在！！");
            }
        }
        //2.转换
        GxqptWarnType gxqptWarnType=dozerUtils.map(updateGxqptWarnTypeDto,GxqptWarnType.class);
        //3.数据初始化
        gxqptWarnType.setUpdateUser(BaseContextHandler.getAdminId().toString());
        Date nowDate=new Date();
        gxqptWarnType.setUpdateTime(nowDate);
        //4.数据保存
        int result = gxqptWarnTypeService.updateByIdSelective(gxqptWarnType);
        if (result>0){
            return Result.success(dozerUtils.map(gxqptWarnType,UpdateGxqptWarnTypeDTO.class));
        }
        return Result.fail("处理操作失败！");
    }

    /**
     * 查询预警类型编码
     * @return
     */
    @ApiOperation(value = "查询预警类型编码", notes = "查询预警类型编码")
    @RequestMapping(value = "/getCode", method = RequestMethod.GET)
    public int getCode(String code){
        List<String> result = gxqptWarnTypeMapper.getCode(code);
        if(result!= null&&result.size()!=0){
            return 0;
        }
        return 1;
    }
    /**
     * 根据ID禁用预警类型信息
     * @param id
     * @return
     */
    @ApiOperation(value="根据ID禁用预警类型信息",notes = "根据ID禁用预警类型信息")
    @RequestMapping(value = "/deleteById", method = RequestMethod.GET)
    @ApiResponses({
            @ApiResponse(code = 31000, message = "预警类型信息id为空"),
    })
    public Result<String> deleteById(@RequestParam(value="id")Long id, @RequestParam(value="isEnable")Boolean isEnable){
        //1.校验
        BizAssert.assertNotNull(WarnExceptionCode.WARN_TYPE_ID_NULL,id);
        //2.数据处理
        GxqptWarnType gxqptWarnType=new GxqptWarnType();
        gxqptWarnType.setId(id);
        gxqptWarnType.setIsEnable(isEnable);
        gxqptWarnType.setUpdateUser(BaseContextHandler.getAdminId().toString());
        Date nowDate = new Date();
        gxqptWarnType.setUpdateTime(nowDate);
        //3.数据操作
        int result=gxqptWarnTypeService.updateByIdSelective(gxqptWarnType);
        if (result>0){
            return Result.success("设置成功！");
        }
        return Result.fail("设置失败！");
    }
    /**
     * 拖动预警类型
     */
    @ApiOperation(value="拖动预警类型",notes = "拖动预警类型")
    @RequestMapping(value = "/updateLocation", method = RequestMethod.POST)
    @ApiResponses({
            @ApiResponse(code = 31001, message = "拖动位置不正确"),
            @ApiResponse(code = 31002, message = "获取当前拖动类型不正确"),
    })
    public Result<Boolean> updateLocation(@RequestParam("currentId") Long currentId, Long locateId, String type) {
        //1.验证
        BizAssert.assertNotNull(WarnExceptionCode.WARN_TYPE_DRAG_EXIST, currentId);
        BizAssert.assertNotNull(WarnExceptionCode.WARN_TYPE_DRAG_ID_EXIST, locateId);

        //2.获取当前预警类型及当前预警类型包含的子集
        //当前类型
        GxqptWarnType currentWt = new GxqptWarnType();
        currentWt = gxqptWarnTypeService.getById(currentId);
        //当前类型所包含子集
        List<GxqptWarnType> currentChildList = new ArrayList<>();
        GxqptWarnTypeExample example = new GxqptWarnTypeExample();
        example.createCriteria().andParentIdEqualTo(currentWt.getId());
        currentChildList = gxqptWarnTypeService.find(example);

        //4.拖动位置类型
        GxqptWarnType dragWt = new GxqptWarnType();
        dragWt = gxqptWarnTypeService.getById(locateId);


        //如果把子类型放置于最顶层
        if (locateId == -1l) {
            currentWt.setParentId(-1l);
            currentWt.setLeve(currentWt.getId() + "");
            GxqptWarnTypeExample parentExample = new GxqptWarnTypeExample();
            parentExample.setOrderByClause("order_no desc");
            List<GxqptWarnType> parentChildList = gxqptWarnTypeService.find(parentExample);
            if (parentChildList.size() > 0) {
                currentWt.setOrderNo(parentChildList.get(0).getOrderNo() + 1);
            } else {
                currentWt.setOrderNo(1);
            }
            gxqptWarnTypeService.updateByIdSelective(currentWt);
        } else {
            //5.拖动位置类型所包含子集
            List<GxqptWarnType> dragChildList = new ArrayList<>();
            GxqptWarnTypeExample dragExample = new GxqptWarnTypeExample();
            dragExample.createCriteria().andParentIdEqualTo(dragWt.getId());
            dragExample.setOrderByClause("order_no desc");
            dragChildList = gxqptWarnTypeService.find(dragExample);
            //6.对拖动类型及拖动位置的类型进行修改
            //6.1如果拖动位置类型存在子类型，则把拖动类型做为拖动后类型的子集
            if (dragChildList != null && dragChildList.size() > 0) {
                switch (type) {
                    case "inner":
                        currentWt.setParentId(dragWt.getId());
                        currentWt.setLeve(dragWt.getLeve() + "-" + currentWt.getId());
                        currentWt.setOrderNo(dragChildList.get(0).getOrderNo() + 1);
                        gxqptWarnTypeService.updateByIdSelective(currentWt);
                        break;
                    case "prev":
                        currentWt.setParentId(dragWt.getParentId());
                        currentWt.setLeve(dragWt.getLeve().replace(String.valueOf(dragWt.getId()), "") + currentWt.getId());
                        currentWt.setOrderNo(dragWt.getOrderNo());
                        gxqptWarnTypeService.updateByIdSelective(currentWt);
                        updateOrderNo(currentWt, 2, currentWt.getId());
                        break;
                    case "next":
                        currentWt.setParentId(dragWt.getParentId());
                        currentWt.setLeve(dragWt.getLeve().replace(String.valueOf(dragWt.getId()), "") + currentWt.getId());
                        currentWt.setOrderNo(dragWt.getOrderNo() + 1);
                        gxqptWarnTypeService.updateByIdSelective(currentWt);
                        updateOrderNo(currentWt, 2, currentWt.getId());
                        break;
                    default:
                        break;
                }
            }else { //6.2如果拖动后预警类型不存在子类型，则把拖动预警类型放置与拖动后类型的后面

                if (type.equals("next")) {
                    currentWt.setParentId(dragWt.getParentId());
                    currentWt.setLeve(dragWt.getLeve() + "-" + currentWt.getId());
                    currentWt.setOrderNo(dragWt.getOrderNo() + 1);
                    gxqptWarnTypeService.updateByIdSelective(currentWt);
                    //更推动位置后面预警类型的排序号
                    updateOrderNo(dragWt, 2, currentWt.getId());
                } else if (type.equals("prev")) {
                    currentWt.setParentId(dragWt.getParentId());
                    currentWt.setLeve(dragWt.getLeve() + "-" + currentWt.getId());
                    currentWt.setOrderNo(dragWt.getOrderNo());
                    gxqptWarnTypeService.updateByIdSelective(currentWt);
                    updateOrderNo(currentWt, 2, currentWt.getId());

                } else if (type.equals("inner")) {
                    currentWt.setParentId(dragWt.getId());
                    currentWt.setLeve(dragWt.getLeve() + "-" + currentWt.getId());
                    currentWt.setOrderNo(1);
                    gxqptWarnTypeService.updateByIdSelective(currentWt);

                }
            }
        }
        //7.更改子集的层级
        if (currentChildList != null && currentChildList.size() > 0) {
            for (GxqptWarnType rs : currentChildList) {
                rs.setLeve(currentWt.getLeve() + "-" + rs.getId());
                gxqptWarnTypeService.updateByIdSelective(rs);
            }
        }
        //8.返回成功结果
        return Result.success(true);
    }
    /**
     * 描述：根据传入当前预警类型，修改后面的预警类型编号
     * 参数：type 操作方式1：删除预警类型，2：新增预警
     * 参数：curentRsId 拖动预警类型Id
     */
    public void updateOrderNo(GxqptWarnType gxqptWarnType, int type, Long curentRsId) {
        //根据传入预警类型查询该预警类型同级以后的预警类型
        GxqptWarnTypeExample example = new GxqptWarnTypeExample();
        example.createCriteria().andParentIdEqualTo(gxqptWarnType.getParentId())
                .andOrderNoGreaterThanOrEqualTo(gxqptWarnType.getOrderNo());
        List<GxqptWarnType> typeList = gxqptWarnTypeService.find(example);

        //如果查询的同级以后的预警类型不为空，针对删除，排序号进行减1操作，针对新增，排序号进行加1操作
        if (typeList != null && typeList.size() > 0) {
            for (GxqptWarnType temp : typeList) {
                if (gxqptWarnType.getId().equals(temp.getId())) {
                    continue;
                }
                if (curentRsId != null) {
                    if (curentRsId.equals(temp.getId())) {
                        continue;
                    }
                }
                //设置排序号
                if (type == 1) {
                    temp.setOrderNo(temp.getOrderNo() - 1);
                } else if (type == 2) {
                    temp.setOrderNo(temp.getOrderNo() + 1);
                }
                //修改排序号
                gxqptWarnTypeService.updateByIdSelective(temp);
            }
        }

    }

    /**
     * 自动生成序号
     * @param gxqptWarnType
     * @return
     */
    private Integer generateOrderNo(GxqptWarnType gxqptWarnType) {
        Integer orderNo = 1;

        GxqptWarnTypeExample example = new GxqptWarnTypeExample();
        example.createCriteria().andParentIdEqualTo(gxqptWarnType.getParentId());
        example.setOrderByClause("order_no desc");
        List<GxqptWarnType> typeList = gxqptWarnTypeService.find(example);
        if (typeList != null && typeList.size() > 0) {
            GxqptWarnType lastResource = typeList.get(0);
            if (!lastResource.getId().equals(gxqptWarnType.getId())) {
                orderNo = typeList.get(0).getOrderNo() + 1;
            }
        }

        return orderNo;
    }

    /**
     * 自动生成层级
     * @param gxqptWarnType
     * @return
     */
    private String generateCode(GxqptWarnType gxqptWarnType) {
        String leave = "";
        Long parentId = gxqptWarnType.getParentId();
        if (parentId.equals(-1l)) {
            leave = String.valueOf(gxqptWarnType.getId());
        } else {
            GxqptWarnType parentRs = gxqptWarnTypeService.getById(parentId);
            leave = parentRs.getLeve() + "-" + gxqptWarnType.getId();
        }
        return leave;
    }
}
