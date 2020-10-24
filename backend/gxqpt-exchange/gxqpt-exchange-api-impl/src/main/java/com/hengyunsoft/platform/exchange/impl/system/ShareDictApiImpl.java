package com.hengyunsoft.platform.exchange.impl.system;

import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

import javax.validation.groups.Default;

import com.hengyunsoft.base.Result;
import com.hengyunsoft.commons.context.BaseContextHandler;
import com.hengyunsoft.commons.exception.core.ExchangeExceptionCode;
import com.hengyunsoft.commons.utils.context.DozerUtils;
import com.hengyunsoft.platform.exchange.api.system.dto.ShareRequestDictDTO;
import com.hengyunsoft.platform.exchange.api.system.dto.ShareRequestUpdateDictDTO;
import com.hengyunsoft.platform.exchange.api.system.dto.ShareResponseDictDTO;
import com.hengyunsoft.platform.exchange.entity.system.domain.DictDO;
import com.hengyunsoft.platform.exchange.entity.system.po.ShareDict;
import com.hengyunsoft.platform.exchange.repository.system.example.ShareDictExample;
import com.hengyunsoft.platform.exchange.repository.system.service.ShareDictService;
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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


/**
 * com.hengyunsoft.platform.exchange.impl.system
 * 版权：中科恒运软件科技股份有限公司贵阳分公司
 * 描述：数据字典查询
 * 修改人：wt
 * 修改时间：2018/4/23
 * 修改内容：新增基础接口
 */
@Api(value = "API - ShareDictApiImpl.java", description = "数据字典AIP管理")
@RestController
@RequestMapping("dataapi")
@Slf4j
public class ShareDictApiImpl /*implements ShareDictApi*/ {

    @Autowired
    private ShareDictService shareDictService;

    @Autowired
    private DozerUtils dozerUtils;

    private static final String[] FIXED_DICT_CODE = {"0","domain","theme","industry","service"};

    /**
     * 描述：根据dictcode详细信息
     * 参数：dictcode：APP dictcode
     * 返回值：ShareResponseDictDTO
     * 修改人：wt
     * 修改时间：2018/4/23
     * 修改内容：
     */
    @RequestMapping(value = "/api/findByDictCode", method = RequestMethod.GET)
    @ApiOperation(value = "详细信息", notes = "详细信息")
    @ApiResponses({
            @ApiResponse(code = 86021, message = "PID不能为空"),
    })
    
    public Result<List<ShareResponseDictDTO>> findByDictCode(@RequestParam("pId") String pId) {
        //数据验证
        BizAssert.assertNotNull(ExchangeExceptionCode.SHARE_DICT_ID_NULL, pId);
        List<DictDO> list = shareDictService.queryDict(pId);
        for (DictDO dictDO : list){
            List<DictDO> childrenList = shareDictService.queryDict(dictDO.getDictCode());
            if(childrenList.size() > 0){
                dictDO.setIsChildren(true);
            }else{
                dictDO.setIsChildren(false);
            }
        }
        return Result.success(dozerUtils.mapList(list, ShareResponseDictDTO.class));
    }

    /**
     * 描述：保存字典信息
     * 参数：ShareRequestDictDTO
     * 返回值：Boolean
     * 修改人：wt
     * 修改时间：2018/4/23
     * 修改内容：
     */
    @RequestMapping(value = "/api/saveDict", method = RequestMethod.POST)
    @ApiOperation(value = "保存字典信息", notes = "保存字典信息")
    @ApiResponses({
            @ApiResponse(code = 86017, message = "申请对象不能为空"),
            @ApiResponse(code = 86018, message = "目录名称不能为空"),
            @ApiResponse(code = 86019, message = "目录编码不能为空"),
            @ApiResponse(code = 86020, message = "上级目录不能为空"),
            @ApiResponse(code = 86031, message = "该编码已经存在"),
    })
    @ValidatorStandard(
            {
                @Constraint(value = ShareDict.class, groups = {Default.class,ValidatorGroups.MustNoneNull.class})
            }
    )
    
    public Result<ShareResponseDictDTO> saveDict(@RequestBody ShareRequestDictDTO dto) {
        //数据验证
        BizAssert.assertNotNull(ExchangeExceptionCode.SHARE_DICT_NULL, dto);
        BizAssert.assertNotNull(ExchangeExceptionCode.SHARE_DICT_DICTCODE_NULL, dto.getDictCode());
        BizAssert.assertNotNull(ExchangeExceptionCode.SHARE_DICT_DICTNAME_NULL, dto.getDictName());
        BizAssert.assertNotNull(ExchangeExceptionCode.SHARE_DICT_PDICTCODE_NULL, dto.getPDictCode());
        ShareResponseDictDTO result = null;
        try {
            ShareDictExample example = new ShareDictExample();
            example.createCriteria().andDictCodeEqualTo(dto.getDictCode());
            List<ShareDict> cfList=shareDictService.find(example);
            if(cfList!=null && cfList.size() > 0 ){
              return Result.fail(ExchangeExceptionCode.DICT_CODE_YEW_EXIST);
            }
            Long adminId = BaseContextHandler.getAdminId();
            ShareDict shareDict = new ShareDict();
            shareDict.setDictName(dto.getDictName());
            shareDict.setDictCode(dto.getDictCode());
            //查询新增层级
            ShareDictExample shareDictExample = new ShareDictExample();
            shareDictExample.createCriteria().andDictCodeEqualTo(dto.getPDictCode());
            ShareDict shareDict1 = shareDictService.getUnique(shareDictExample);
            shareDict.setLevel(shareDict1.getLevel());
            shareDict.setPId(dto.getPDictCode());
            List<DictDO> list = shareDictService.queryDict(shareDict1.getId().toString());
            int indexNo=list.size()+1;
            shareDict.setIndexNo(indexNo);
            shareDict.setCreateTime(Calendar.getInstance().getTime());
            shareDict.setCreateUser(adminId);
            ShareDict returnShareDict = shareDictService.saveSelective(shareDict);
            result = dozerUtils.map(shareDict,ShareResponseDictDTO.class);
            result.setPDictCode(dto.getPDictCode());
            result.setPDictName(dto.getPDictName());
        } catch (Exception e) {
            Result.fail(e);
        }
        return Result.success(result);
    }

//    public ShareResponseDictDTO saveOrUpdateReturnShareDict(ShareDict shareDict){
//        ShareResponseDictDTO shareResponseDictDTO = dozerUtils.map(shareDict,ShareResponseDictDTO.class);
//        //查询父目录名称
//        ShareDictExample shareDictExample = new ShareDictExample();
//        Long pId=Long.parseLong(shareDict.getpId());
//        shareDictExample.createCriteria().andIdEqualTo(pId);
//        ShareDict shareDict1 = shareDictService.getUnique(shareDictExample);
//        shareResponseDictDTO.setPDictCode(shareDict1.getDictCode());
//        shareResponseDictDTO.setPDictName(shareDict1.getDictName());
//        return shareResponseDictDTO;
//    }

    /**
     * 描述：删除字典信息
     * 参数：id
     * 返回值：Boolean
     * 修改人：wt
     * 修改时间：2018/4/23
     * 修改内容：
     */
    @RequestMapping(value = "/api/deleteDictById", method = RequestMethod.GET)
    @ApiOperation(value = "删除字典信息", notes = "删除字典信息")
    @ApiResponses({
            @ApiResponse(code = 86021, message = "输入API ID不能为空"),
    })
    
    public Result<Boolean> deleteDictById(@RequestParam("id") Long id) {
        //数据验证
        BizAssert.assertNotNull(ExchangeExceptionCode.SHARE_DICT_ID_NULL, id);
        try {
            //校验
            ShareDict shareDict = shareDictService.getById(id);
            Boolean isCode = Arrays.asList(FIXED_DICT_CODE).contains(shareDict.getDictCode());
            if(isCode){
                BizAssert.fail(ExchangeExceptionCode.CREATEDATASET_OPT_NEED_DATA_OPT);
            }
            shareDictService.deleteById(id);
        } catch (Exception e) {
            return Result.fail(e);
        }
        return Result.success(true);
    }


    /**
     * 描述：更新字典信息
     * 参数：ShareRequestDictDTO
     * 返回值：Boolean
     * 修改人：wt
     * 修改时间：2018/4/23
     * 修改内容：
     */
    @RequestMapping(value = "/api/updateDict", method = RequestMethod.POST)
    @ApiOperation(value = "更新字典信息", notes = "更新字典信息")
    @ApiResponses({
            @ApiResponse(code = 86017, message = "申请对象不能为空"),
            @ApiResponse(code = 86021, message = "输入API ID不能为空"),
    })
    @ValidatorStandard(
            {
                @Constraint(value = ShareDict.class)
            }
    )
    
    public Result<ShareResponseDictDTO> updateDict(@RequestBody ShareRequestUpdateDictDTO dto) {
        //数据验证
        BizAssert.assertNotNull(ExchangeExceptionCode.SHARE_DICT_NULL, dto);
        BizAssert.assertNotNull(ExchangeExceptionCode.SHARE_DICT_ID_NULL, dto.getId());
        ShareResponseDictDTO result = null;
        try {
            ShareDictExample example = new ShareDictExample();
            example.createCriteria().andDictCodeEqualTo(dto.getDictCode());
            List<ShareDict> cfList=shareDictService.find(example);
            if(cfList!=null && cfList.size() > 0 ){
                return Result.fail(ExchangeExceptionCode.DICT_CODE_YEW_EXIST);
            }
            Long adminId = BaseContextHandler.getAdminId();
            ShareDict shareDict = dozerUtils.map(dto,ShareDict.class);
            shareDict.setUpdateTime(Calendar.getInstance().getTime());
            shareDict.setUpdateUser(adminId);
            Integer val = shareDictService.updateByIdSelective(shareDict);
            if(val > 0){
                result = dozerUtils.map(dto,ShareResponseDictDTO.class);
            }
        } catch (Exception e) {

        }
        return Result.success(result);
    }

}
