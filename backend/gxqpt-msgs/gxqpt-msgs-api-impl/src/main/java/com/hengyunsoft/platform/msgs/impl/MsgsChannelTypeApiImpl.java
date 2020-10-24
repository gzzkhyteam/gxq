package com.hengyunsoft.platform.msgs.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hengyunsoft.base.Result;
import com.hengyunsoft.commons.utils.context.DozerUtils;
import com.hengyunsoft.platform.msgs.dto.msg.MsgsChannelTypeDTO;
import com.hengyunsoft.platform.msgs.dto.msg.MsgsChannelTypeSelectDTO;
import com.hengyunsoft.platform.msgs.entity.channeltype.po.MsgsChannelType;
import com.hengyunsoft.platform.msgs.repository.channeltype.example.MsgsChannelTypeExample;
import com.hengyunsoft.platform.msgs.repository.channeltype.service.MsgsChannelTypeService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@Api(value = "渠道类别管理", description = "渠道类别管理")
public class MsgsChannelTypeApiImpl {
    @Autowired
    private MsgsChannelTypeService msgsChannelTypeService;

    @Autowired
    private DozerUtils dozerUtils;

    /**
     * 查询渠道类别
     * @param
     * @return
     */
    @RequestMapping(value = "/channeltype/query", method = RequestMethod.GET)
	@ApiOperation(value="查询渠道类别",notes = "查询渠道类别")
    public Result<List<MsgsChannelTypeDTO>> query() {
        try{
            MsgsChannelTypeExample msgsChannelTypeExample = new MsgsChannelTypeExample();
            msgsChannelTypeExample.createCriteria();
            msgsChannelTypeExample.setOrderByClause(" create_time desc ");
            List<MsgsChannelType> list = msgsChannelTypeService.find(msgsChannelTypeExample);
            List<MsgsChannelTypeDTO> result = dozerUtils.mapPage(list, MsgsChannelTypeDTO.class);
            return Result.success(result);
        }catch (Exception e){
            log.error("查询渠道类别异常:"+e);
            return Result.fail("查询渠道类别出错");
        }
    }
    //下拉查询
    @RequestMapping(value = "/channeltype/querySelect", method = RequestMethod.POST)
    @ApiOperation(value="下拉列表查询",notes = "下拉列表查询")
    public Result<PageInfo<MsgsChannelTypeSelectDTO>> querySelect() {
        try{
            MsgsChannelTypeExample msgsChannelTypeExample = new MsgsChannelTypeExample();
            msgsChannelTypeExample.createCriteria();
            msgsChannelTypeExample.setOrderByClause(" create_time desc ");
            PageHelper.startPage(1, 20);
            List<MsgsChannelType> list = msgsChannelTypeService.find(msgsChannelTypeExample);
            List<MsgsChannelTypeSelectDTO> pageList = dozerUtils.mapPage(list, MsgsChannelTypeSelectDTO.class);
            return Result.success(new PageInfo<>(pageList));
        }catch (Exception e){
            log.error("渠道类型查询功能异常:"+e);
            return Result.fail("查询失败，请稍后重试！");
        }
    }
}
