package com.hengyunsoft.platform.exchange.impl.element;

import java.util.Date;
import java.util.List;

import com.hengyunsoft.base.Result;
import com.hengyunsoft.commons.context.BaseContextHandler;
import com.hengyunsoft.commons.exception.core.ExchangeExceptionCode;
import com.hengyunsoft.commons.utils.context.DozerUtils;
import com.hengyunsoft.platform.exchange.api.directory.dto.element.DataElementCopyDTO;
import com.hengyunsoft.platform.exchange.api.directory.dto.element.DataElementDTO;
import com.hengyunsoft.platform.exchange.api.directory.dto.element.DataElementListDTO;
import com.hengyunsoft.platform.exchange.api.directory.dto.element.DataElementSaveDTO;
import com.hengyunsoft.platform.exchange.api.directory.dto.element.DataElementUpdateDTO;
import com.hengyunsoft.platform.exchange.entity.directory.po.ShareDataChange;
import com.hengyunsoft.platform.exchange.entity.directory.po.ShareDataChangeElement;
import com.hengyunsoft.platform.exchange.entity.directory.po.ShareDataDirectory;
import com.hengyunsoft.platform.exchange.entity.directory.po.ShareDataElement;
import com.hengyunsoft.platform.exchange.entity.directory.po.ShareDataElementWare;
import com.hengyunsoft.platform.exchange.repository.directory.example.ShareDataChangeElementExample;
import com.hengyunsoft.platform.exchange.repository.directory.example.ShareDataChangeExample;
import com.hengyunsoft.platform.exchange.repository.directory.example.ShareDataElementExample;
import com.hengyunsoft.platform.exchange.repository.directory.example.ShareDataElementWareExample;
import com.hengyunsoft.platform.exchange.repository.directory.service.DataDirectoryService;
import com.hengyunsoft.platform.exchange.repository.directory.service.DataElementService;
import com.hengyunsoft.platform.exchange.repository.directory.service.DataElementWareService;
import com.hengyunsoft.platform.exchange.repository.directory.service.ShareDataChangeElementService;
import com.hengyunsoft.platform.exchange.repository.directory.service.ShareDataChangeService;
import com.hengyunsoft.platform.exchange.util.ShareUtil;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping("/element")
@Api(value = "数据目录元数据管理", description = "数据目录元数据管理")
public class ShareDataElementApiImpl /*implements ShareDataElementApi */{

    @Autowired
    private DataElementWareService dataElementChangeService;
    @Autowired
    private DataElementService dataElementService;
    @Autowired
    private DataElementWareService dataElementWareService;
    @Autowired
    private ShareDataChangeService shareDataChangeService;
    @Autowired
    private ShareDataChangeElementService shareDataChangeElementService;
    @Autowired
    private DozerUtils dozerUtils;
    @Autowired
    private DataDirectoryService dataDirectoryService;

    public ShareDataElementApiImpl() {
        super();
    }

    
    @ApiOperation(value = "根据目录id元数据List", notes = "根据字典编码code 查询数据字典List")
    @RequestMapping(value = "/getList", method = RequestMethod.GET)
    public Result<List<DataElementListDTO>> getList(@RequestParam(value = "dirId") Long dirId) {
        if (dirId == null) {
            return Result.fail("目录id不能为空");
        }
        return Result.success(dozerUtils.mapList(dataElementService.getElementWareList(dirId), DataElementListDTO.class));
    }

    
    @ApiOperation(value = "保存数据目录元数据信息", notes = "保存数据目录元数据信息")
    @ApiResponses({
            @ApiResponse(code = 85004, message = "元数据名称不能为空"),
            @ApiResponse(code = 85006, message = "元数据字段标识不能为空")
    })
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public Result<DataElementDTO> save(@RequestBody DataElementSaveDTO dto) {
        //1.校验
        BizAssert.assertNotNull(ExchangeExceptionCode.DIRECTORY_FILEID_NAME_NULL, dto.getFieldName());
        BizAssert.assertNotNull(ExchangeExceptionCode.DIRECTORY_FILEID_CODE_NULL, dto.getFieldCode());
        ShareDataElementExample elementEmp=new ShareDataElementExample();
        elementEmp.createCriteria().andFieldCodeEqualTo(dto.getFieldCode()).andDataStatusNotEqualTo(1).andDirIdEqualTo(Long.valueOf(dto.getDirId()));
        ShareDataElement shareDataElement=dataElementService.getUnique(elementEmp);
        if(shareDataElement!=null && shareDataElement.getFieldCode()!=null && shareDataElement.getFieldCode()!=""){
            return  Result.fail("字段标识已经存在！");
        }
        //2.转换
        ShareDataElement dataElement = dozerUtils.map(dto, ShareDataElement.class);
        Long adminId = BaseContextHandler.getAdminId();
        ShareUtil shareUtil = new ShareUtil();//applyCode工具类
        String applyCode = shareUtil.automaticCode("MU");
        try {
            dataElement.setStatus(1);//状态:1,未发布；2，审批中；3，驳回；4，已发布；5，已禁用',
            dataElement.setOptType(1);//操作类型(最近一次)：1,新增；2，修改；3，删除',
            dataElement.setCreateUser(Long.valueOf(adminId));
            dataElement.setUpdateUser(Long.valueOf(adminId));
            //4.保存
            dataElement = dataElementService.saveSelective(dataElement);

            ShareDataChangeExample example = new ShareDataChangeExample();
            example.createCriteria().andUnitIdEqualTo(dataElement.getUnitId()).andStatusEqualTo(1);
            ShareDataChange dataChange = shareDataChangeService.getUnique(example);
            ShareDataChange change = new ShareDataChange();
            if (dataChange == null) {
                change.setUnitId(dataElement.getUnitId());
                change.setUserId(adminId);
                change.setStatus(1);
                change.setOptTime(new Date());
                change.setApplyCode(applyCode);
                change.setCreateUser(adminId);
                change.setUpdateUser(adminId);
                //保存数据目录变动主表
                shareDataChangeService.saveSelective(change);

                ShareDataChangeElement changeElement = new ShareDataChangeElement();
                changeElement.setBusId(change.getId());
                changeElement.setBusType(2);
                changeElement.setChangeType(1);
                changeElement.setChgId(dataElement.getId());
                changeElement.setCreateUser(adminId);
                changeElement.setUpdateUser(adminId);
                shareDataChangeElementService.saveSelective(changeElement);
            } else {
                ShareDataChangeElement changeElement = new ShareDataChangeElement();
                changeElement.setBusId(dataChange.getId());
                changeElement.setBusType(2);
                changeElement.setChangeType(1);
                changeElement.setChgId(dataElement.getId());
                changeElement.setCreateUser(adminId);
                changeElement.setUpdateUser(adminId);
                shareDataChangeElementService.saveSelective(changeElement);
            }


        } catch (Exception e) {
            log.error("e",e.getMessage());
            throw e;
        }
        return Result.success(dozerUtils.map(dataElement, DataElementDTO.class));
    }

    
    @ApiOperation(value = "修改数据目录-元数据信息", notes = "保存数据目录-元数据信息")
    @ApiResponses({
            @ApiResponse(code = 85004, message = "元数据名称不能为空"),
           // @ApiResponse(code = 85005, message = "元数据字段类型不能为空"),
            @ApiResponse(code = 85006, message = "元数据字段标识不能为空")
    })
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public Result<Boolean> update(@RequestBody DataElementUpdateDTO dto) {
        //1.校验
        BizAssert.assertNotNull(ExchangeExceptionCode.DIRECTORY_FILEID_NAME_NULL, dto.getFieldName());
       // BizAssert.assertNotNull(ExchangeExceptionCode.DIRECTORY_FILEID_TYPE_NULL, dto.getFieldType());
        BizAssert.assertNotNull(ExchangeExceptionCode.DIRECTORY_FILEID_CODE_NULL, dto.getFieldCode());
        //   BizAssert.assertNotNull(ExchangeExceptionCode.DIRECTORY_SET_FILEID_NULL, dto.getSetField());
        //2.转换
        ShareDataElement dataElement = dozerUtils.map(dto, ShareDataElement.class);
        Long adminId = BaseContextHandler.getAdminId();
        try {
            Long dirId=dto.getDirId();
            if(dto.getIsPrimary()==1){
                ShareDataElement elet=dataElementService.getByDirId(dirId);
                if(elet!=null && elet.getId().longValue()!=dto.getId().longValue()){
                    return  Result.fail("主键已经存在！");
                }
            }
            ShareDataDirectory directory=dataDirectoryService.getById(dirId);
            if(directory.getOptType()==3){
                return  Result.fail("该字段目录是删除状态，字段删除状态不能修改！");
            }
            dataElement.setStatus(1);//状态:1,未发布；2，审批中；3，驳回；4，已发布；5，已禁用',
            ShareDataElementWare elementWare=dataElementWareService.getById(dto.getId());
            if(elementWare!=null){
                dataElement.setOptType(2);//操作类型(最近一次)：1,新增；2，修改；3，删除',
            }else{
                dataElement.setOptType(1);//没有发布的字段默认是新增
            }
            dataElement.setCreateUser(Long.valueOf(adminId));
            dataElement.setUpdateUser(Long.valueOf(adminId));
            //保存
            dataElementService.updateByIdSelective(dataElement);
            ShareDataElement element = dataElementService.getById(dataElement.getId());
            ShareDataChangeExample example = new ShareDataChangeExample();
            example.createCriteria().andUnitIdEqualTo(element.getUnitId()).andStatusEqualTo(1);
            ShareDataChange shareDataChange = shareDataChangeService.getUnique(example);
            ShareDataChange change = new ShareDataChange();
            if (shareDataChange == null) {
                ShareUtil shareUtil = new ShareUtil();//applyCode工具类
                String applyCode = shareUtil.automaticCode("MU");
                change.setUnitId(element.getUnitId());
                change.setUserId(adminId);
                change.setStatus(1);
                change.setOptTime(new Date());
                change.setApplyCode(applyCode);
                change.setCreateUser(adminId);
                change.setUpdateUser(adminId);
                //保存数据目录变动主表
                shareDataChangeService.saveSelective(change);

                ShareDataChangeElement changeElement = new ShareDataChangeElement();
                changeElement.setBusId(change.getId());
                changeElement.setBusType(2);
                changeElement.setChangeType(dataElement.getOptType());
                changeElement.setChgId(element.getId());
                changeElement.setCreateUser(adminId);
                changeElement.setUpdateUser(adminId);
                shareDataChangeElementService.saveSelective(changeElement);
            } else {
                ShareDataChangeElementExample elementExample = new ShareDataChangeElementExample();
                elementExample.createCriteria().andBusIdEqualTo(shareDataChange.getId()).andChgIdEqualTo(dataElement.getId()).andBusTypeEqualTo(2);
                ShareDataChangeElement changeElement = shareDataChangeElementService.getUnique(elementExample);
                if(changeElement!=null){
                    changeElement.setChangeType(2);
                    changeElement.setUpdateUser(adminId);
                    //保存目录及字段变动表
                    shareDataChangeElementService.updateByIdSelective(changeElement);
                }else{
                    ShareDataChangeElement newchangeElement =new ShareDataChangeElement();
                    newchangeElement.setBusId(shareDataChange.getId());
                    newchangeElement.setBusType(2);
                    newchangeElement.setChangeType(dataElement.getOptType());
                    newchangeElement.setChgId(element.getId());
                    newchangeElement.setCreateUser(adminId);
                    newchangeElement.setUpdateUser(adminId);
                    shareDataChangeElementService.saveSelective(newchangeElement);
                }
            }
        } catch (Exception e) {
            log.error("e",e.getMessage());
            throw e;
        }

        return Result.success(true);
    }

    
    @ApiOperation(value = "删除数据目录-元数据信息", notes = "删除数据目录-元数据信息")
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public Result<Boolean> delete(@RequestParam(value = "id") Long id) {
        if (id == null) {
            return Result.fail("元数据id不能为空");
        }
        ShareDataElementWare ware = dataElementWareService.getById(id);
        if(ware==null){
            dataElementService.deleteById(id);
            shareDataChangeElementService.deleteByElementId(id);
            return Result.success(true);
        }
        Long adminId = BaseContextHandler.getAdminId();
        ShareDataElement dataElement = dataElementService.getById(id);
        dataElement.setStatus(1);//状态:1,未发布；2，审批中；3，驳回；4，已发布；
        dataElement.setOptType(3);//操作类型(最近一次)：1,新增；2，修改；3，删除；4，禁用',5,正常，6，启用
        dataElement.setCreateUser(Long.valueOf(adminId));
        dataElement.setUpdateUser(Long.valueOf(adminId));
        //禁用更新操作
        dataElementService.updateByIdSelective(dataElement);
        ShareUtil shareUtil = new ShareUtil();//applyCode工具类
        String applyCode = shareUtil.automaticCode("MU");
        ShareDataChangeExample ChangeExample = new ShareDataChangeExample();
        ChangeExample.createCriteria().andUnitIdEqualTo(dataElement.getUnitId()).andStatusEqualTo(1);
        ShareDataChange dataChange = shareDataChangeService.getUnique(ChangeExample);
        ShareDataChange change = new ShareDataChange();
        ShareDataChangeElement changeElement = new ShareDataChangeElement();
        //如果为空需要生成变动流程
        if (dataChange != null) {
            changeElement.setBusId(dataChange.getId());
            changeElement.setBusType(2);
            changeElement.setChangeType(3);
            changeElement.setChgId(dataElement.getId());
            changeElement.setCreateUser(adminId);
            changeElement.setUpdateUser(adminId);
            shareDataChangeElementService.saveSelective(changeElement);

        } else {
            change.setUnitId(dataElement.getUnitId());
            change.setUserId(adminId);
            change.setStatus(1);
            change.setOptTime(new Date());
            change.setApplyCode(applyCode);
            change.setCreateUser(adminId);
            change.setUpdateUser(adminId);
            //保存数据目录变动主表
            shareDataChangeService.saveSelective(change);

            changeElement.setBusId(change.getId());
            changeElement.setBusType(2);
            changeElement.setChangeType(3);
            changeElement.setChgId(dataElement.getId());
            changeElement.setCreateUser(adminId);
            changeElement.setUpdateUser(adminId);
            shareDataChangeElementService.saveSelective(changeElement);
        }

        return Result.success(true);
    }

    
    @ApiOperation(value = "根据id查询数据元数据信息", notes = "根据id查询数据元数据信息")
    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public Result<DataElementDTO> get(@RequestParam(value = "id") Long id) {
        if (id == null) {
            return Result.fail("元数据id不能为空");
        }
        ShareDataElementExample example = new ShareDataElementExample();
        example.createCriteria().andIdEqualTo(id);
        ShareDataElement element = dataElementService.getUnique(example);
        DataElementDTO dto = dozerUtils.map(element, DataElementDTO.class);
        return Result.success(dto);
    }

    
    @ApiOperation(value = "根据id查询数据元数据信息", notes = "根据id查询数据元数据信息")
    @RequestMapping(value = "/getElementWare", method = RequestMethod.GET)
    public Result<DataElementDTO> getElementWare(Long id) {
        if (id == null) {
            return Result.fail("元数据id不能为空");
        }
        ShareDataElementWareExample example = new ShareDataElementWareExample();
        example.createCriteria().andIdEqualTo(id);
        ShareDataElementWare element = dataElementWareService.getUnique(example);
        DataElementDTO dto = dozerUtils.map(element, DataElementDTO.class);
        return Result.success(dto);
    }

    
    @ApiOperation(value = "查询数据元数据变动信息", notes = "查询数据元数据变动信息")
    @RequestMapping(value = "/getElementChangeList", method = RequestMethod.GET)
    public Result<List<DataElementCopyDTO>> getElementChangeList(@RequestParam(value = "applyCode") String applyCode) {
        if(applyCode==null){
            return Result.fail("申请编号不能为空");
        }
        List<DataElementCopyDTO> changeList = dozerUtils.mapList(dataElementService.getElementChangeList(applyCode), DataElementCopyDTO.class);
        return Result.success(changeList);
    }
    
    @ApiOperation(value = "查询数据元数据变动信息", notes = "查询数据元数据变动信息")
    @RequestMapping(value = "/getElementChangeListApply", method = RequestMethod.GET)
    public Result<List<DataElementCopyDTO>> getElementChangeListApply(@RequestParam(value = "unitId") String unitId
            ,@RequestParam(value = "status") Integer status) {
        if(unitId==null){
            return Result.fail("单位id不能为空");
        }
        if(status==null){
            return Result.fail("状态不能为空");
        }
        List<DataElementCopyDTO> changeList = dozerUtils.mapList(dataElementService.getElementChangeListApply(unitId,status), DataElementCopyDTO.class);
        return Result.success(changeList);
    }
}
