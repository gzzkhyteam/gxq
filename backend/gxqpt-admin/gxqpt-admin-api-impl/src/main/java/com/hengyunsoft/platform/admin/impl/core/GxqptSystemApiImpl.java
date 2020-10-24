package com.hengyunsoft.platform.admin.impl.core;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hengyunsoft.base.Result;
import com.hengyunsoft.commons.context.BaseContextHandler;
import com.hengyunsoft.commons.exception.core.ExceptionCode;
import com.hengyunsoft.commons.utils.context.DozerUtils;
import com.hengyunsoft.page.plugins.openapi.OpenApiReq;
import com.hengyunsoft.platform.admin.api.core.api.GxqptSystemApi;
import com.hengyunsoft.platform.admin.api.core.dto.system.GxqptSystemDTO;
import com.hengyunsoft.platform.admin.api.core.dto.system.GxqptSystemPageListDTO;
import com.hengyunsoft.platform.admin.api.core.dto.system.GxqptSystemUpdateDTO;
import com.hengyunsoft.platform.admin.entity.org.gxqpt.po.GxqptSystem;
import com.hengyunsoft.platform.admin.repository.org.gxqpt.dao.GxqptSystemMapper;
import com.hengyunsoft.platform.admin.repository.org.gxqpt.example.GxqptSystemExample;
import com.hengyunsoft.platform.admin.repository.org.gxqpt.service.GxqptSystemService;
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

import java.util.Date;
import java.util.List;


/**
 * @author zjr
 * @createTime 2018-03-07
 */
@Api(value = "API - SystemApiImpl", description = "体系管理")
@RestController
@RequestMapping("system")
@Slf4j
public class GxqptSystemApiImpl implements GxqptSystemApi {

    @Autowired
    private GxqptSystemService gxqptSystemService;
    @Autowired
    private GxqptSystemMapper gxqptSystemMapper;

    @Autowired
    private DozerUtils dozerUtils;


    /**
     * 功能描述：查询体系来源
     * @author zjr
     * @return
     */
    @Override
    @ApiOperation(value = "查询体系来源", notes = "查询体系来源")
    @RequestMapping(value = "/getBySource", method = RequestMethod.GET)
    public Result<List<String>> getBySource(){
            List<String> sources = gxqptSystemMapper.getBySource();
            return Result.success(sources);

    }


    /**
     * 功能描述：按条件分页查询体系信息
     * @author zjr
     */
    @Override
    @ApiOperation(value="分页查询体系信息",notes = "分页查询体系信息")
    @RequestMapping(value = "/findSystemList", method = RequestMethod.POST)
    public Result<PageInfo<GxqptSystemPageListDTO>> findSystemList(@RequestBody OpenApiReq<GxqptSystemDTO> openApiReq){
        //1.数据初始化
        GxqptSystemDTO gxqptSystemDto = openApiReq.getData();

        GxqptSystemExample systemExample = new GxqptSystemExample();
        systemExample.createCriteria().andNameLike(GxqptSystemExample.fullLike(openApiReq.getData().getName()))
                .andSourceEqualTo(openApiReq.getData().getSource());
        systemExample.setOrderByClause("id asc");
        PageHelper.startPage(openApiReq.getPageNo(), openApiReq.getPageSize());
        //2.查询
        List<GxqptSystem> systemList= gxqptSystemService.find(systemExample);
        //3.转换
        List<GxqptSystemPageListDTO> pageList = dozerUtils.mapPage(systemList, GxqptSystemPageListDTO.class);
        return Result.success(new PageInfo<>(pageList));

    }

    /**
     * 功能描述：编辑体系信息
     * @author zjr
     */
    @Override
    @ApiOperation(value="编辑体系信息",notes = "编辑体系信息")
    @ApiResponses({
            @ApiResponse(code = 56500, message = "体系id不能为空"),
    })
    @RequestMapping(value = "/updateById", method = RequestMethod.POST)
    public Result<GxqptSystemUpdateDTO> updateById(@RequestBody GxqptSystemUpdateDTO systemUpdateDto) {
        //1.校验
        BizAssert.assertNotNull(ExceptionCode.SYSTEM_ID_NULL, systemUpdateDto.getId());
        //2.转换
        GxqptSystem system = dozerUtils.map(systemUpdateDto, GxqptSystem.class);
        //3.数据初始化
        system.setUpdateUser(BaseContextHandler.getAdminId().toString());
        Date nowDate = new Date();
        system.setUpdateTime(nowDate);
        //4.数据保存
        int result = gxqptSystemService.updateByIdSelective(system);
        if(result>0){
            return Result.success(dozerUtils.map(system,GxqptSystemUpdateDTO.class));
        }
        return Result.fail("编辑失败！");

    }

    /**
     * 功能描述：删除体系信息
     * @author zjr
     */
    @Override
    @ApiOperation(value = "删除体系信息", notes = "删除体系信息")
    @ApiResponses({
            @ApiResponse(code = 56500, message = "体系id不能为空"),
    })
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public Result<Boolean> deleteSystem(@RequestParam(value = "id") String id) {
        if (id == null) {
            return Result.success(null);
        }
        gxqptSystemService.deleteSystem(id);
        return Result.success(true);
    }

}
