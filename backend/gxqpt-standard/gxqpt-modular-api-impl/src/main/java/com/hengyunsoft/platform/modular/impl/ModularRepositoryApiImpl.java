package com.hengyunsoft.platform.modular.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONArray;
import com.hengyunsoft.base.Result;
import com.hengyunsoft.commons.utils.context.DozerUtils;
import com.hengyunsoft.platform.modular.config.NexusConfig;
import com.hengyunsoft.platform.modular.dto.ModularRepositoryDTO;
import com.hengyunsoft.platform.modular.entity.modular.domain.ModularRepositoryDO;
import com.hengyunsoft.platform.modular.utils.HttpUtil;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * @author zhoukx
 * @createTime 2018-3-28
 */
@RestController
@Api(value = "模块仓库管理", description = "模块仓库管理")
public class ModularRepositoryApiImpl /*implements ModularRepositoryApi*/ {

    @Autowired
    private DozerUtils dozerUtils;

    @Autowired
    private NexusConfig nexusConfig;

    /**
     * 仓库列表查询
     *
     * @createTime 2018-4-5
     * @author wangs
     */
    @RequestMapping(value = "/repository/find", method = RequestMethod.POST)
    @ApiOperation(value = "仓库列表查询", notes = "调用nexus接口查询仓库列表信息")
    public Result<List<ModularRepositoryDTO>> findAll() {
        //调用nexus接口查询仓库列表信息
        String getUrl = nexusConfig.getServerUrl() + "/service/rest/beta/repositories";

        String resultJson = HttpUtil.getResultByGet(getUrl, "");
        List<ModularRepositoryDO> lists = (List<ModularRepositoryDO>) JSONArray.parseArray(resultJson, ModularRepositoryDO.class);

        return Result.success(dozerUtils.mapPage(lists, ModularRepositoryDTO.class));
    }
}
