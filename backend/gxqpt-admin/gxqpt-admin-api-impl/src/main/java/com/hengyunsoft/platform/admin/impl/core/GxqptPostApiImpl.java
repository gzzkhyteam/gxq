package com.hengyunsoft.platform.admin.impl.core;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hengyunsoft.base.Result;
import com.hengyunsoft.commons.context.BaseContextHandler;
import com.hengyunsoft.commons.context.CommonConstants;
import com.hengyunsoft.commons.exception.core.AuthorityExceptionCode;
import com.hengyunsoft.commons.utils.context.DozerUtils;
import com.hengyunsoft.page.plugins.openapi.OpenApiReq;
import com.hengyunsoft.platform.admin.api.core.api.GxqptPostApi;
import com.hengyunsoft.platform.admin.api.core.dto.post.GxqptPostQueryDTO;
import com.hengyunsoft.platform.admin.api.core.dto.post.GxqptPostRetDTO;
import com.hengyunsoft.platform.admin.api.core.dto.post.GxqptPostSaveDTO;
import com.hengyunsoft.platform.admin.api.core.dto.post.GxqptPostUpdateDTO;
import com.hengyunsoft.platform.admin.entity.org.gxqpt.po.GxqptPost;
import com.hengyunsoft.platform.admin.entity.org.sdzzww.po.SdzzwwPost;
import com.hengyunsoft.platform.admin.repository.org.gxqpt.example.GxqptEmpExample;
import com.hengyunsoft.platform.admin.repository.org.gxqpt.example.GxqptPostExample;
import com.hengyunsoft.platform.admin.repository.org.gxqpt.service.GxqptPostService;
import com.hengyunsoft.platform.admin.repository.org.sdzzww.example.SdzzwwPostExample;
import com.hengyunsoft.platform.admin.repository.org.sdzzww.service.SdzzwwPostService;
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
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 描述:岗位管理
 *
 * @author chb
 * @date 2018/3/7 13:50
 * @return
 */
@Api(value = "API - GxqptPostApiImpl", description = "岗位管理")
@RestController
@RequestMapping("post")
@Slf4j
public class GxqptPostApiImpl implements GxqptPostApi {


    /**
     * 已删除
     */
    private static final String DELETE = "1";
    /**
     * 未删除
     */
    private static final String UNDELETE = "0";

    @Autowired
    private GxqptPostService gxqptPostService;
    @Autowired
    private DozerUtils dozerUtils;
    @Autowired
    private SdzzwwPostService sdzzwwPostService;

    /**
     * 新增岗位
     *
     * @param gxqptPostSaveDTO
     * @return
     */
    @Override
    @ApiOperation(value = "新建岗位信息", notes = "新建岗位信息")
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    @ApiResponses({
            @ApiResponse(code = 56005, message = "岗位信息为空")
    })
    @ValidatorStandard(
            {
                    @Constraint(value = SdzzwwPost.class, groups = {Default.class, ValidatorGroups.MustNoneNull.class})
            }
    )
    public Result<GxqptPostRetDTO> save(@RequestBody GxqptPostSaveDTO gxqptPostSaveDTO) {
        //1.验证
        BizAssert.assertNotNull(AuthorityExceptionCode.GXQPT_POST_NULL, gxqptPostSaveDTO);
        //2.转换
        GxqptPost post = dozerUtils.map(gxqptPostSaveDTO, GxqptPost.class);
        //3.数据初始化
        post.setIsdelete(UNDELETE);
        post.setCreateUser(BaseContextHandler.getAdminId().toString());
        post.setUpdateUser(post.getCreateUser());
        Date nowDate = new Date();
        post.setCreateTime(nowDate);
        post.setUpdateTime(nowDate);
        //4.数据保存
        GxqptPost post1 = gxqptPostService.save(post);
        if (post1.getId() != null) {
            return Result.success(dozerUtils.map(post1, GxqptPostRetDTO.class));
        }
        return Result.fail("保存失败！");
    }

    /**
     * 描述:根据ID修改数据信息
     *
     * @return
     * @author chb
     * @date 2018/3/7 14:14
     */
    @Override
    @ApiOperation(value = "根据ID修改岗位信息", notes = "根据ID修改岗位信息")
    @RequestMapping(value = "/updateById", method = RequestMethod.POST)
    @ApiResponses({
            @ApiResponse(code = 56005, message = "岗位信息为空"),
            @ApiResponse(code = 56006, message = "岗位ID为空")
    })
    @ValidatorStandard(
            {
                    @Constraint(value = SdzzwwPost.class)
            }
    )
    public Result<GxqptPostUpdateDTO> updateById(@RequestBody GxqptPostUpdateDTO gxqptPostUpdateDTO) {
        //1.验证
        BizAssert.assertNotNull(AuthorityExceptionCode.GXQPT_POST_NULL, gxqptPostUpdateDTO);
        BizAssert.assertNotEmpty(AuthorityExceptionCode.GXQPT_POST_ID_EMPTY, gxqptPostUpdateDTO.getId());
        //2.转换
        GxqptPost post = dozerUtils.map(gxqptPostUpdateDTO, GxqptPost.class);
        //3.数据初始化
        post.setUpdateUser(BaseContextHandler.getAdminId().toString());
        Date nowDate = new Date();
        post.setUpdateTime(nowDate);
        //4.数据保存
        int result = gxqptPostService.updateByIdSelective(post);
        if (result > 0) {
            return Result.success(dozerUtils.map(post, GxqptPostUpdateDTO.class));
        }
        return Result.fail("保存失败！");
    }

    /**
     * 根据ID获取岗位信息
     *
     * @param id
     * @return
     */
    @Override
    @ApiOperation(value = "根据ID获取岗位信息", notes = "根据ID获取岗位信息")
    @RequestMapping(value = "/getPostById", method = RequestMethod.GET)
    @ApiResponses({
            @ApiResponse(code = 56014, message = "体系结构代码为空"),
            @ApiResponse(code = 56006, message = "岗位ID为空")
    })
    public Result<GxqptPostRetDTO> getPostById(@RequestParam(value = "id") String id, @RequestParam(value = "systemCode") String systemCode) {
        //1.验证
        BizAssert.assertNotEmpty(AuthorityExceptionCode.GXQPT_POST_ID_EMPTY, id);
        BizAssert.assertNotEmpty(AuthorityExceptionCode.SYSTEMCODE, systemCode);
        //2.查询
        if (CommonConstants.SYS_GXQPT_CODE.equals(systemCode)) {
            GxqptPost post = gxqptPostService.getById(id);
            return Result.success(dozerUtils.map(post, GxqptPostRetDTO.class));
        } else if (CommonConstants.SYS_SDZZWW_CODE.equals(systemCode)) {
            SdzzwwPost sdzzwwPost = sdzzwwPostService.getById(id);
            return Result.success(dozerUtils.map(sdzzwwPost, GxqptPostRetDTO.class));
        } else {
            return null;
        }
    }

    /**
     * 根据ID删除数据
     *
     * @param id
     * @return
     */
    @Override
    @ApiOperation(value = "根据ID删除岗位信息", notes = "根据ID删除岗位信息")
    @RequestMapping(value = "/removeById", method = RequestMethod.GET)
    @ApiResponses({
            @ApiResponse(code = 56006, message = "岗位ID为空"),
    })
    public Result<String> removeById(@RequestParam(value = "id") String id) {
        //1.验证
        BizAssert.assertNotEmpty(AuthorityExceptionCode.GXQPT_POST_ID_EMPTY, id);
        //2.数据初始化
        GxqptPost post = new GxqptPost();
        post.setId(id);
        post.setIsdelete(DELETE);
        post.setUpdateUser(BaseContextHandler.getAdminId().toString());
        Date nowDate = new Date();
        post.setUpdateTime(nowDate);
        //3.操作数据
        int result = gxqptPostService.updateByIdSelective(post);

        if (result > 0) {
            return Result.success("删除成功！");
        }
        return Result.fail("删除失败！");
    }

    /**
     * 获取岗位列表分页数据
     *
     * @param openApiReq
     * @return
     */
    @Override
    @ApiOperation(value = "获取岗位信息分页数据", notes = "获取岗位信息分页数据")
    @RequestMapping(value = "/findPostList", method = RequestMethod.POST)
    public Result<PageInfo<GxqptPostRetDTO>> findPostList(@RequestBody OpenApiReq<GxqptPostQueryDTO> openApiReq) {
        GxqptPostQueryDTO gxqptPostQueryDTO = openApiReq.getData();

        if (gxqptPostQueryDTO.getOrgid() == null || "".equals(gxqptPostQueryDTO.getOrgid())) {
            return Result.success(new PageInfo<>(new ArrayList<>()));
        }
        //1.数据初始化
        GxqptPostExample example = new GxqptPostExample();
        String isenable = "";
        if (gxqptPostQueryDTO.getIsenable() != null && !"".equals(gxqptPostQueryDTO.getIsenable())) {
            isenable = gxqptPostQueryDTO.getIsenable();
        }
        example.createCriteria()
                .andCodeEqualTo(gxqptPostQueryDTO.getCode()).andOrgidEqualTo(gxqptPostQueryDTO.getOrgid())
                .andIsdeleteEqualTo(UNDELETE).andIsenableEqualTo(isenable)
                .andNameLike(GxqptEmpExample.fullLike(gxqptPostQueryDTO.getName()));
        example.setOrderByClause("sortvalue asc");

        PageHelper.startPage(openApiReq.getPageNo(), openApiReq.getPageSize());

        List<? extends SdzzwwPost> list;
        //2.查询
        if (CommonConstants.SYS_GXQPT_CODE.equals(gxqptPostQueryDTO.getSystemCode())) {
            list = gxqptPostService.find(example);
        } else if (CommonConstants.SYS_SDZZWW_CODE.equals(gxqptPostQueryDTO.getSystemCode())) {
            SdzzwwPostExample sdzzwwPostExample = new SdzzwwPostExample();
            sdzzwwPostExample.createCriteria().andNameLike(GxqptEmpExample.fullLike(gxqptPostQueryDTO.getName()))
                    .andCodeEqualTo(gxqptPostQueryDTO.getCode()).andOrgidEqualTo(gxqptPostQueryDTO.getOrgid())
                    .andIsdeleteEqualTo(UNDELETE)
                    .andOrgnameLike(GxqptEmpExample.fullLike(gxqptPostQueryDTO.getOrgname()));
            sdzzwwPostExample.setOrderByClause("sortvalue asc");
            list = sdzzwwPostService.find(sdzzwwPostExample);
        } else {
            list = new ArrayList<>();
        }
        //3.转换
        List<GxqptPostRetDTO> pageList = dozerUtils.mapPage(list, GxqptPostRetDTO.class);
        return Result.success(new PageInfo<>(pageList));
    }
}
