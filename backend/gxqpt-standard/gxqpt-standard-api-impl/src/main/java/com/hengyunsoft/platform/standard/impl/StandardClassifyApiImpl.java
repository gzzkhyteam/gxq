package com.hengyunsoft.platform.standard.impl;

import com.hengyunsoft.base.Result;
import com.hengyunsoft.commons.context.BaseContextHandler;
import com.hengyunsoft.commons.context.CommonConstants;
import com.hengyunsoft.commons.exception.core.StandardExceptionCode;
import com.hengyunsoft.commons.utils.context.DozerUtils;
import com.hengyunsoft.platform.commons.utils.TreeUtil;
import com.hengyunsoft.platform.standard.dto.StandardClassifyDTO;
import com.hengyunsoft.platform.standard.dto.StandardClassifySaveDTO;
import com.hengyunsoft.platform.standard.dto.StandardClassifyTreeDTO;
import com.hengyunsoft.platform.standard.dto.StandardClassifyUpdateDTO;
import com.hengyunsoft.platform.standard.entity.standard.po.StandardClassify;
import com.hengyunsoft.platform.standard.repository.standard.example.StandardClassifyExample;
import com.hengyunsoft.platform.standard.repository.standard.service.StandardClassifyService;
import com.hengyunsoft.platform.standard.utils.ReturnTreeUtills;
import com.hengyunsoft.utils.BizAssert;
import com.hengyunsoft.validator.annotation.Constraint;
import com.hengyunsoft.validator.annotation.ValidatorStandard;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

@RestController
@Slf4j
@Api(value = "标准分类管理", description = "标准分类管理")
public class StandardClassifyApiImpl /*implements StandardClassifyApi */{

    @Autowired
    private DozerUtils dozerUtils;

    @Autowired
    private StandardClassifyService standardClassifyService;

    /**
     * 根据id 查看分类详情
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/classify/get", method = RequestMethod.GET)
    public Result<StandardClassifyDTO> get(@RequestParam(value = "id") Long id) {
        //1，验证
        BizAssert.assertNotNull(StandardExceptionCode.ID_NULL, id);

        StandardClassify classify = standardClassifyService.getById(id);

        return Result.success(dozerUtils.map(classify, StandardClassifyDTO.class));
    }

    /**
     * 保存标准分类
     *
     * @param standardClassifySaveDTO
     */
    @ValidatorStandard(
            {
                    @Constraint(value = StandardClassify.class)
            }
    )
    @RequestMapping(value = "/classify/save", method = RequestMethod.POST)
    public Result<StandardClassifyDTO> save(@RequestBody StandardClassifySaveDTO standardClassifySaveDTO) {
        //1，验证
        BizAssert.assertNotNull(StandardExceptionCode.CLASSIFY_NULL, standardClassifySaveDTO);
        BizAssert.assertNotEmpty(StandardExceptionCode.CLASSIFY_NAME_EMPTY, standardClassifySaveDTO.getName());

        //2，获取身份
        Long adminId = BaseContextHandler.getAdminId();
        String userName = BaseContextHandler.getName();

        //3,转换po，并保存
        StandardClassify standardClassify = dozerUtils.map(standardClassifySaveDTO, StandardClassify.class);
        standardClassify.setIsEnable(true);
        standardClassify.setCreateTime(Calendar.getInstance().getTime());
        standardClassify.setCreateUser(BaseContextHandler.getAdminId());
        standardClassify.setCreateUserName(userName);
        if (standardClassify.getParentId() == null) {
            standardClassify.setParentId(CommonConstants.PARENT_ID_DEF);
        }
        standardClassify.setUpdateUser(adminId);
        standardClassify.setUpdateTime(Calendar.getInstance().getTime());
        standardClassify.setUpdateUserName(userName);
        standardClassify = standardClassifyService.save(standardClassify);

        //4,返回
        return Result.success(dozerUtils.map(standardClassify, StandardClassifyDTO.class));
    }

    /**
     * 更新标准分类
     *
     * @param standardClassifyUpdateDTO
     */
    @ValidatorStandard(
            {
                    @Constraint(value = StandardClassify.class)
            }
    )
    @RequestMapping(value = "/classify/update", method = RequestMethod.POST)
    public Result<Boolean> update(@RequestBody StandardClassifyUpdateDTO standardClassifyUpdateDTO) {
        //1，验证
        BizAssert.assertNotNull(StandardExceptionCode.CLASSIFY_NULL, standardClassifyUpdateDTO);
        BizAssert.assertNotNull(StandardExceptionCode.ID_NULL, standardClassifyUpdateDTO.getId());
        BizAssert.assertNotEmpty(StandardExceptionCode.CLASSIFY_NAME_EMPTY, standardClassifyUpdateDTO.getName());

        //2，获取身份
        Long adminId = BaseContextHandler.getAdminId();
        String userName = BaseContextHandler.getName();

        //3,转换po，并保存
        StandardClassify standardClassify = dozerUtils.map(standardClassifyUpdateDTO, StandardClassify.class);
        standardClassify.setUpdateUser(adminId);
        standardClassify.setUpdateTime(Calendar.getInstance().getTime());
        standardClassify.setUpdateUserName(userName);
        int i = standardClassifyService.updateByIdSelective(standardClassify);

        //4,返回
        if (i > 0) {
            return Result.success(true);
        } else {
            return Result.fail("未找到要更新的数据，id：" + standardClassifyUpdateDTO.getId());
        }
    }

    /**
     * 根据id 删除
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/classify/delete", method = RequestMethod.GET)
    public Result<Boolean> delete(@RequestParam(value = "id") Long id) {
        //1，验证
        BizAssert.assertNotNull(StandardExceptionCode.ID_NULL, id);

        int i = standardClassifyService.deleteById(id);
        if (i == 0) {
            return Result.fail("未找到要删除的数据，id：" + id);
        } else {
            return Result.success(true);
        }
    }

    /**
     * 描述：获取标准分类树
     * 返回值：标准分类树形结构
     */
    @RequestMapping(value = "/classify/getTree", method = RequestMethod.GET)
    public Result<List<StandardClassifyTreeDTO>> getTree(@RequestParam(value = "id") Long id) {
        String rootId = null;
        StandardClassifyExample standardClassifyExample = new StandardClassifyExample();
        standardClassifyExample.createCriteria().andIsEnableEqualTo(true);
        standardClassifyExample.setOrderByClause("parent_id,sort_no");
        List<StandardClassify> standardClassifyList = standardClassifyService.find(standardClassifyExample);
        if (standardClassifyList != null) {
            List<StandardClassifyTreeDTO> treeList = dozerUtils.mapList(standardClassifyList,
                    StandardClassifyTreeDTO.class);

            if (id != null) {
                for (StandardClassifyTreeDTO tree : treeList) {
                    if (tree.getId() == id) {
                        tree.setChecked(true);
                    }
                }
            }
            //获取根Id
            for (StandardClassifyTreeDTO dto : treeList) {
                if (dto.getParentId().toString().equals("-1")) {
                    rootId = dto.getParentId().toString();
                    break;
                }
            }
            return Result.success(TreeUtil.build(treeList, rootId));
        } else {
            return Result.success(null);
        }
    }

    /**
     * 描述：获取运维文档的分类树
     * 返回值：运维文档树形结构
     */
    @RequestMapping(value = "/classify/getAllTreeById", method = RequestMethod.GET)
    public Result<List<StandardClassifyTreeDTO>> getAllTreeById(String treeId,String name) {
        StandardClassifyExample standardClassifyExample = new StandardClassifyExample();
        standardClassifyExample.createCriteria().andIsEnableEqualTo(true);
        standardClassifyExample.setOrderByClause("parent_id,sort_no");
        List<StandardClassify> standardClassifyList = new ArrayList<>();
        if(name ==null || name== "") {
        	standardClassifyList = standardClassifyService.find(standardClassifyExample);
        }else {
        	standardClassifyList = standardClassifyService.findDevOpsDocTree(treeId,name);
        }
       
        List<StandardClassifyTreeDTO> result = null;
        if (standardClassifyList != null) {
            List<StandardClassifyTreeDTO> treeList = dozerUtils.mapList(standardClassifyList,
                    StandardClassifyTreeDTO.class);
            result = ReturnTreeUtills.useListRecordToTree(treeList,treeId);
        }
        return Result.success(result);
    }
}
