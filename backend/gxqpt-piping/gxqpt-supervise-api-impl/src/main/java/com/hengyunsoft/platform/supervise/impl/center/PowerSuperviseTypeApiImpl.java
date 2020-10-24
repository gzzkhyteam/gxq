package com.hengyunsoft.platform.supervise.impl.center;

import com.hengyunsoft.base.Result;
import com.hengyunsoft.commons.context.BaseContextHandler;
import com.hengyunsoft.commons.exception.core.SuperviseExceptionCode;
import com.hengyunsoft.commons.utils.context.DozerUtils;
import com.hengyunsoft.platform.commons.utils.TreeUtil;
import com.hengyunsoft.platform.supervise.dto.center.PowerSuperviseTypeDTO;
import com.hengyunsoft.platform.supervise.dto.center.PowerTreeDTO;
import com.hengyunsoft.platform.supervise.dto.center.UpdatePowerSuperviseTypeDTO;
import com.hengyunsoft.platform.supervise.entity.po.PowerSuperviseType;
import com.hengyunsoft.platform.supervise.repository.example.PowerSuperviseTypeExample;
import com.hengyunsoft.platform.supervise.repository.service.PowerSuperviseTypeService;
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
 * @date 2018/09/12
 */
@Api(value = "API - PowerSuperviseTypeApiImpl", description = "权责类型维护")
@RestController
@RequestMapping("power")
@Slf4j
public class PowerSuperviseTypeApiImpl {

    @Autowired
    private PowerSuperviseTypeService powerSuperviseTypeService;
    @Autowired
    private DozerUtils dozerUtils;

    /**
     * 获取权责类型树
     * @param
     * @return
     */
    @ApiOperation(value = "获取权责类型树", notes = "获取权责类型树")
    @RequestMapping(value = "/findPowerSuperviseTypeTree", method = RequestMethod.GET)
    public Result<List<PowerTreeDTO>> findPowerSuperviseTypeTree(@RequestParam(value = "id") Long id){
        String rootId = null;
        PowerSuperviseTypeExample powerSuperviseTypeExample = new PowerSuperviseTypeExample();
        powerSuperviseTypeExample.createCriteria().andIsEnableEqualTo(true);
        powerSuperviseTypeExample.setOrderByClause("parent_id");
        List<PowerSuperviseType> powerSuperviseTypeList = powerSuperviseTypeService.find(powerSuperviseTypeExample);
        if (powerSuperviseTypeList != null) {
            List<PowerTreeDTO> treeList = dozerUtils.mapList(powerSuperviseTypeList, PowerTreeDTO.class);
            if (id != null) {
                for (PowerTreeDTO tree : treeList) {
                    if (tree.getId() == id) {
                        tree.setChecked(true);
                        break;
                    }
                }
            }
            //获取根Id
            for (PowerTreeDTO dto : treeList) {
                if (dto.getParentId().toString().equals("-1")) {
//                    rootId = dto.getId().toString();
                    rootId = dto.getParentId().toString();
                }
            }
            return Result.success(TreeUtil.build(treeList, rootId));
        } else {
            return Result.success(null);
        }
    }


    /**
     *
     *
     * 根据id查询权责类型信息
     * @param id
     * @return
     */
    @ApiOperation(value = "根据id查询权责类型信息", notes = "根据id查询权责类型信息")
    @RequestMapping(value = "/getById", method = RequestMethod.GET)
    @ApiResponses({
            @ApiResponse(code = 110000, message = "权责类型id为空"),
    })
    public Result<PowerSuperviseTypeDTO> getById(@RequestParam(value = "id") Long id){
        //1.校验
        BizAssert.assertNotNull(SuperviseExceptionCode.SUPERVISE_TYPE_ID_NULL,id);
        //2.查询
        PowerSuperviseType powerSuperviseType = powerSuperviseTypeService.getById(id);
        return Result.success(dozerUtils.map(powerSuperviseType, PowerSuperviseTypeDTO.class));

    }
    /**
     * 添加权责类型信息
     * @param dto
     * @return
     */
    @ApiOperation(value = "添加权责类型信息", notes = "添加权责类型信息")
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    @ApiResponses({
            @ApiResponse(code = 110000, message = "权责类型id为空"),
            @ApiResponse(code = 110003, message = "全责类型名称不能为空"),
            @ApiResponse(code = 110004, message = "全责类型编码不能为空"),
    })
    public Result<PowerSuperviseTypeDTO> save(@RequestBody PowerSuperviseTypeDTO dto){
        //1.校验
        BizAssert.assertNotNull(SuperviseExceptionCode.SUPERVISE_TYPE_ID_NULL,dto.getId());
        BizAssert.assertNotEmpty(SuperviseExceptionCode.SUPERVISE_POWER_NAME_NULL,dto.getName());
        BizAssert.assertNotEmpty(SuperviseExceptionCode.SUPERVISE_POWER_CODE_NULL,dto.getCode());
        if(dto.getIsEnable()==null){
            dto.setIsEnable(true);
        }
        PowerSuperviseTypeExample example = new PowerSuperviseTypeExample();
        example.createCriteria().andCodeEqualTo(dto.getCode());
        List<PowerSuperviseType> list = powerSuperviseTypeService.find(example);
        if(list != null && list.size() > 0){
            return Result.fail("权责类型编码已存在！");
        }

        //2.转换
        PowerSuperviseType powerSuperviseType = dozerUtils.map(dto,PowerSuperviseType.class);

        //3.数据处理
        powerSuperviseType.setCreateUser(BaseContextHandler.getAdminId());
        Date nowDate = new Date();
        powerSuperviseType.setCreateTime(nowDate);
        if (powerSuperviseType.getParentId() == null) {
            long pId=powerSuperviseTypeService.getIdByParentId(-1L);
            powerSuperviseType.setParentId(pId);
        }

        //4.保存
        PowerSuperviseType powerType =  powerSuperviseTypeService.save(powerSuperviseType);
        //自动生成资源层级
        String leave = generateCode(powerSuperviseType);
        //自动生成序号
        Integer orderNum = generateOrderNum(powerSuperviseType);
        powerSuperviseType.setOrderNum(orderNum);
        powerSuperviseType.setLevel(leave);
        powerSuperviseTypeService.updateByIdSelective(powerSuperviseType);
        //返回
        if(powerType.getId()!=null){
            return Result.success(dozerUtils.map(powerType,PowerSuperviseTypeDTO.class));
        }
        return Result.fail("保存失败！");
    }

    /**
     * 根据id编辑权责类型信息
     * @param
     * @return
     */
    @ApiOperation(value="根据id编辑权责类型信息",notes = "根据id编辑权责类型信息")
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    @ApiResponses({
            @ApiResponse(code = 110000, message = "权责类型id为空"),
    })
    public Result<UpdatePowerSuperviseTypeDTO> update(@RequestBody UpdatePowerSuperviseTypeDTO updatePowerSuperviseTypeDto){
        //1.校验
        BizAssert.assertNotNull(SuperviseExceptionCode.SUPERVISE_TYPE_ID_NULL,updatePowerSuperviseTypeDto.getId());
        //2.转换
        PowerSuperviseType powerSuperviseType=dozerUtils.map(updatePowerSuperviseTypeDto,PowerSuperviseType.class);
        //3.数据初始化
        powerSuperviseType.setUpdateUser(BaseContextHandler.getAdminId());
        Date nowDate=new Date();
        powerSuperviseType.setUpdateTime(nowDate);
        //4.数据保存
        int result = powerSuperviseTypeService.updateByIdSelective(powerSuperviseType);
        if (result>0){
            return Result.success(dozerUtils.map(powerSuperviseType,UpdatePowerSuperviseTypeDTO.class));
        }
        return Result.fail("修改失败！");
    }

    /**
     * 查询权责类型编码
     * @return
     */
    @ApiOperation(value = "查询权责类型编码", notes = "查询权责类型编码")
    @RequestMapping(value = "/getCode", method = RequestMethod.GET)
    public int getCode(String code){
        List<String> result = powerSuperviseTypeService.getCode(code);
        if(result!= null&&result.size()!=0){
            return 1;
        }
        return 0;
    }
    /**
     * 根据ID禁用权责类型信息
     * @param id
     * @return
     */
    @ApiOperation(value="根据ID禁用权责类型信息",notes = "根据ID禁用权责类型信息")
    @RequestMapping(value = "/overdueById", method = RequestMethod.GET)
    @ApiResponses({
            @ApiResponse(code = 110000, message = "权责类型id为空"),
    })
    public Result<String> overdueById(@RequestParam(value="id")Long id){
        //1.校验
        BizAssert.assertNotNull(SuperviseExceptionCode.SUPERVISE_TYPE_ID_NULL,id);
        //2.数据处理
        PowerSuperviseType powerSuperviseType=new PowerSuperviseType();
        powerSuperviseType.setId(id);
        powerSuperviseType.setIsEnable(false);
        powerSuperviseType.setUpdateUser(BaseContextHandler.getAdminId());
        Date nowDate = new Date();
        powerSuperviseType.setUpdateTime(nowDate);
        //3.数据操作
        int result=powerSuperviseTypeService.updateByIdSelective(powerSuperviseType);
        if (result>0){
            return Result.success("禁用成功！");
        }
        return Result.fail("禁用失败！");
    }
    /**
     * 拖动权责类型
     */
    @ApiOperation(value="拖动权责类型",notes = "拖动权责类型")
    @RequestMapping(value = "/updateLocation", method = RequestMethod.POST)
    @ApiResponses({
            @ApiResponse(code = 110001, message = "拖动位置不正确"),
            @ApiResponse(code = 110002, message = "获取当前拖动类型不正确"),
    })
    public Result<Boolean> updateLocation(@RequestParam("currentId") Long currentId, Long locateId, String type) {
        //1.验证
        BizAssert.assertNotNull(SuperviseExceptionCode.SUPERVISE_DRAG_EXIST, currentId);
        BizAssert.assertNotNull(SuperviseExceptionCode.SUPERVISE_DRAG_ID_EXIST, locateId);

        //2.获取当前权责类型及当前权责类型包含的子集
        //当前类型
        PowerSuperviseType currentWt = new PowerSuperviseType();
        currentWt = powerSuperviseTypeService.getById(currentId);
        //当前类型所包含子集
        List<PowerSuperviseType> currentChildList = new ArrayList<>();
        PowerSuperviseTypeExample example = new PowerSuperviseTypeExample();
        example.createCriteria().andParentIdEqualTo(currentWt.getId());
        currentChildList = powerSuperviseTypeService.find(example);

        //4.拖动位置类型
        PowerSuperviseType dragWt = new PowerSuperviseType();
        dragWt = powerSuperviseTypeService.getById(locateId);


        //如果把子类型放置于最顶层
        if (locateId == -1l) {
            currentWt.setParentId(-1l);
            currentWt.setLevel(currentWt.getId() + "");
            PowerSuperviseTypeExample parentExample = new PowerSuperviseTypeExample();
            parentExample.setOrderByClause("order_no desc");
            List<PowerSuperviseType> parentChildList = powerSuperviseTypeService.find(parentExample);
            if (parentChildList.size() > 0) {
                currentWt.setOrderNum(parentChildList.get(0).getOrderNum() + 1);
            } else {
                currentWt.setOrderNum(1);
            }
            powerSuperviseTypeService.updateByIdSelective(currentWt);
        } else {
            //5.拖动位置类型所包含子集
            List<PowerSuperviseType> dragChildList = new ArrayList<>();
            PowerSuperviseTypeExample dragExample = new PowerSuperviseTypeExample();
            dragExample.createCriteria().andParentIdEqualTo(dragWt.getId());
            dragExample.setOrderByClause("order_num desc");
            dragChildList = powerSuperviseTypeService.find(dragExample);
            //6.对拖动类型及拖动位置的类型进行修改
            //6.1如果拖动位置类型存在子类型，则把拖动类型做为拖动后类型的子集
            if (dragChildList != null && dragChildList.size() > 0) {
                switch (type) {
                    case "inner":
                        currentWt.setParentId(dragWt.getId());
                        currentWt.setLevel(dragWt.getLevel() + "-" + currentWt.getId());
                        currentWt.setOrderNum(dragChildList.get(0).getOrderNum() + 1);
                        powerSuperviseTypeService.updateByIdSelective(currentWt);
                        break;
                    case "prev":
                        currentWt.setParentId(dragWt.getParentId());
                        currentWt.setLevel(dragWt.getLevel().replace(String.valueOf(dragWt.getId()), "") + currentWt.getId());
                        currentWt.setOrderNum(dragWt.getOrderNum());
                        powerSuperviseTypeService.updateByIdSelective(currentWt);
                        updateOrderNo(currentWt, 2, currentWt.getId());
                        break;
                    case "next":
                        currentWt.setParentId(dragWt.getParentId());
                        currentWt.setLevel(dragWt.getLevel().replace(String.valueOf(dragWt.getId()), "") + currentWt.getId());
                        currentWt.setOrderNum(dragWt.getOrderNum() + 1);
                        powerSuperviseTypeService.updateByIdSelective(currentWt);
                        updateOrderNo(currentWt, 2, currentWt.getId());
                        break;
                    default:
                        break;
                }
            }else { //6.2如果拖动后权责类型不存在子类型，则把拖动权责类型放置与拖动后类型的后面

                if (type.equals("next")) {
                    currentWt.setParentId(dragWt.getParentId());
                    currentWt.setLevel(dragWt.getLevel() + "-" + currentWt.getId());
                    currentWt.setOrderNum(dragWt.getOrderNum() + 1);
                    powerSuperviseTypeService.updateByIdSelective(currentWt);
                    //更推动位置后面权责类型的排序号
                    updateOrderNo(dragWt, 2, currentWt.getId());
                } else if (type.equals("prev")) {
                    currentWt.setParentId(dragWt.getParentId());
                    currentWt.setLevel(dragWt.getLevel() + "-" + currentWt.getId());
                    currentWt.setOrderNum(dragWt.getOrderNum());
                    powerSuperviseTypeService.updateByIdSelective(currentWt);
                    updateOrderNo(currentWt, 2, currentWt.getId());

                } else if (type.equals("inner")) {
                    currentWt.setParentId(dragWt.getId());
                    currentWt.setLevel(dragWt.getLevel() + "-" + currentWt.getId());
                    currentWt.setOrderNum(1);
                    powerSuperviseTypeService.updateByIdSelective(currentWt);

                }
            }
        }
        //7.更改子集的层级
        if (currentChildList != null && currentChildList.size() > 0) {
            for (PowerSuperviseType rs : currentChildList) {
                rs.setLevel(currentWt.getLevel() + "-" + rs.getId());
                powerSuperviseTypeService.updateByIdSelective(rs);
            }
        }
        //8.返回成功结果
        return Result.success(true);
    }
    /**
     * 描述：根据传入当前预警类型，修改后面的预警类型编号
     * 参数：type 操作方式1：删除权责类型，2：新增权责类型
     * 参数：curentRsId 拖动权责类型Id
     */
    public void updateOrderNo(PowerSuperviseType powerSuperviseType, int type, Long curentRsId) {
        //根据传入权责类型查询该权责类型同级以后的权责类型
        PowerSuperviseTypeExample example = new PowerSuperviseTypeExample();
        example.createCriteria().andParentIdEqualTo(powerSuperviseType.getParentId())
                .andOrderNumGreaterThanOrEqualTo(powerSuperviseType.getOrderNum());
        List<PowerSuperviseType> typeList = powerSuperviseTypeService.find(example);

        //如果查询的同级以后的权责类型不为空，针对删除，排序号进行减1操作，针对新增，排序号进行加1操作
        if (typeList != null && typeList.size() > 0) {
            for (PowerSuperviseType temp : typeList) {
                if (powerSuperviseType.getId().equals(temp.getId())) {
                    continue;
                }
                if (curentRsId != null) {
                    if (curentRsId.equals(temp.getId())) {
                        continue;
                    }
                }
                //设置排序号
                if (type == 1) {
                    temp.setOrderNum(temp.getOrderNum() - 1);
                } else if (type == 2) {
                    temp.setOrderNum(temp.getOrderNum() + 1);
                }
                //修改排序号
                powerSuperviseTypeService.updateByIdSelective(temp);
            }
        }

    }

    /**
     * 自动生成序号
     * @param
     * @return
     */
    private Integer generateOrderNum(PowerSuperviseType powerSuperviseType) {
        Integer orderNum = 1;

        PowerSuperviseTypeExample example = new PowerSuperviseTypeExample();
        example.createCriteria().andParentIdEqualTo(powerSuperviseType.getParentId());
        example.setOrderByClause("order_num desc");
        List<PowerSuperviseType> typeList = powerSuperviseTypeService.find(example);
        if (typeList != null && typeList.size() > 0) {
            PowerSuperviseType lastResource = typeList.get(0);
            if (!lastResource.getId().equals(powerSuperviseType.getId())) {
                orderNum = typeList.get(0).getOrderNum() + 1;
            }
        }

        return orderNum;
    }

    /**
     * 自动生成层级
     * @param
     * @return
     */
    private String generateCode(PowerSuperviseType powerSuperviseType) {
        String leave = "";
        Long parentId = powerSuperviseType.getParentId();
        if (parentId.equals(-1l)) {
            leave = String.valueOf(powerSuperviseType.getId());
        } else {
            PowerSuperviseType parentRs = powerSuperviseTypeService.getById(parentId);
            leave = parentRs.getLevel() + "-" + powerSuperviseType.getId();
        }
        return leave;
    }
}
