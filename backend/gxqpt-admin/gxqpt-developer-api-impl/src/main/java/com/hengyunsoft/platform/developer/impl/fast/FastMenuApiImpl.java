package com.hengyunsoft.platform.developer.impl.fast;

import com.hengyunsoft.base.Result;
import com.hengyunsoft.commons.context.BaseContextHandler;
import com.hengyunsoft.commons.exception.core.DeveloperExceptionCode;
import com.hengyunsoft.commons.utils.context.DozerUtils;
import com.hengyunsoft.platform.developer.api.fast.api.FastMenuApi;
import com.hengyunsoft.platform.developer.api.fast.dto.FastBizConfigDTO;
import com.hengyunsoft.platform.developer.api.fast.dto.FastMenuReqDTO;
import com.hengyunsoft.platform.developer.api.fast.dto.FastMenuUpdateDTO;
import com.hengyunsoft.platform.developer.entity.fast.po.FastBizConfig;
import com.hengyunsoft.platform.developer.entity.fast.po.FastMenu;
import com.hengyunsoft.platform.developer.repository.fast.service.FastBizConfigService;
import com.hengyunsoft.platform.developer.repository.fast.service.FastMenuService;
import com.hengyunsoft.utils.BizAssert;
import com.hengyunsoft.utils.JSONUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@Api(value = "API - FastMenuApiImpl", description = "快速菜单服务管理")
@RestController
@RequestMapping("/fastmenu")
@Slf4j
public class FastMenuApiImpl implements FastMenuApi {

    @Autowired
    private FastBizConfigService fastBizConfigService;
    @Autowired
    private FastMenuService fastMenuService;
    @Autowired
    private DozerUtils dozerUtils;

    /**
     * 描述：根据id查询快速应用业务场景配置Api
     * 参数：parentId
     * 返回值：FastMenuDTO
     * 修改人：sunxiaoya
     * 修改时间：2018/5/3
     * 修改内容：
     */
    @Override
    @ApiOperation(value = "根据parentId查询快速应用业务场景配置", notes = "根据parentId查询快速应用业务场景配置")
    @ApiResponses({
            @ApiResponse(code = 78505, message = "我的快速应用菜单父ID不能为空")
    })
    @RequestMapping(value = "/getBizConfig", method = RequestMethod.GET)
    public Result<List<FastBizConfigDTO>> getBizConfig(@RequestParam("parentId") Long parentId) {

        //1、验证
        BizAssert.assertNotNull(DeveloperExceptionCode.FAST_MENU_PARENT_ID_NULL, parentId);

        //2、根据appId查询我的功能列表
        List<FastBizConfigDTO> dto = dozerUtils.mapList(fastBizConfigService.getBizConfig(parentId), FastBizConfigDTO.class);

        //3、返回
        return Result.success(dto);
    }

    /**
     * 描述：根据id查询快速应用菜单Api
     * 参数：id
     * 返回值：FastMenuDTO
     * 修改人：sunxiaoya
     * 修改时间：2018/5/3
     * 修改内容：
     */
    @Override
    @ApiOperation(value = "根据id查询快速应用菜单", notes = "根据id查询快速应用菜单")
    @ApiResponses({
            @ApiResponse(code = 78505, message = "我的快速应用菜单父ID不能为空"),
            @ApiResponse(code = 78504, message = "我的快速应用菜单appID不能为空")
    })
    @RequestMapping(value = "/getMenu", method = RequestMethod.POST)
    public Result<String> getMenu(@RequestBody FastMenuReqDTO dto) {
        Long parentId = dto.getParentId();
        String appId = dto.getAppId();

        //1、验证
        BizAssert.assertNotNull(DeveloperExceptionCode.FAST_MENU_APP_ID_NULL, appId);
        BizAssert.assertNotNull(DeveloperExceptionCode.FAST_MENU_PARENT_ID_NULL, parentId);

        //2、根据appId查询我的功能列表
        List<FastMenu> list = fastMenuService.getMenu(parentId,appId);
        if(list.size()==0){
            return Result.fail("菜单不存在!!");
        }
        List<Object> relationList = new ArrayList<Object>();
        List<Object> sceneList = new ArrayList<Object>();

        for(FastMenu menu:list){
            Map<String,Object> relationMap = new HashMap<String,Object>();
            relationMap.put("name",menu.getName());
            relationMap.put("url",menu.getUrl());
            relationList.add(relationMap);
        }
        FastBizConfig config = fastBizConfigService.getById(list.get(0).getbFastBizConfig());
        List<FastBizConfig> configList = fastBizConfigService.getBizConfig(list.get(0).getbFastBizConfig());
        for(FastBizConfig fc:configList){
            Map<String,Object> sceneMap = new HashMap<String,Object>();
            sceneMap.put("name",fc.getName());
            sceneMap.put("url",fc.getUrl());
            sceneList.add(sceneMap);
        }
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("关联应用",relationList);
        map.put(config.getName(),sceneList);
        String menuJsonStr = JSONUtils.toJsonString(map);
        System.out.println("-------------------------"+menuJsonStr);

        //3、返回
        return Result.success(menuJsonStr);
    }

    /**
     * 描述：快速应用菜单更新Api
     * 参数：FastMenuUpdateDTO
     * 返回值：Boolean
     * 修改人：sunxiaoya
     * 修改时间：2018/5/3
     * 修改内容：
     */
    @ApiOperation(value = "快速应用菜单更新", notes = "快速应用菜单更新")
    @ApiResponses({
            @ApiResponse(code = 78503, message = "我的快速应用菜单ID不能为空")
    })
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public Result<Boolean> update(@RequestBody FastMenuUpdateDTO dto) {

        //1.验证
        BizAssert.assertNotNull(DeveloperExceptionCode.FAST_MENU_ID_NULL, dto.getId());

        //2、基础数据获取
        Long userId = BaseContextHandler.getAdminId();
        Date date = new Date();

        //3、转换并赋初值
        FastMenu fastMenu = dozerUtils.map(dto, FastMenu.class);
        fastMenu.setUpdateUser(userId);
        fastMenu.setUpdateTime(date);

        //4、修改
        fastMenuService.updateByIdSelective(fastMenu);
        return Result.success(true);
    }
}
