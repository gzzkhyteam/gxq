package com.hengyunsoft.platform.mail.open;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hengyunsoft.base.Result;
import com.hengyunsoft.commons.utils.context.DozerUtils;
import com.hengyunsoft.page.plugins.openapi.OpenApiReq;
import com.hengyunsoft.platform.mail.dto.open.RequestDeliveryDTO;
import com.hengyunsoft.platform.mail.entity.core.po.DeliveryService;
import com.hengyunsoft.platform.mail.repository.core.example.DeliveryServiceExample;
import com.hengyunsoft.platform.mail.repository.core.service.DeliveryServiceApiService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Calendar;
import java.util.List;

/**
 * 版权：中科恒运软件科技股份有限公司贵阳分公司
 * 描述：投递服务API
 * 修改人：wt
 * 修改时间：2018/8/27
 * 修改内容：
 */
@Api(value = "API - DeliveryServiceApiImpl.java", description = "投递服务API")
@RestController
@RequestMapping("dataapi/open/delivery/")
@Slf4j
public class DeliveryServiceApiImpl {
    @Autowired
    private DozerUtils dozerUtils;
    @Autowired
    private DeliveryServiceApiService deliveryServiceApiService;

    /**
     * 描述：查询列表
     * 参数：
     * 返回值：PageInfo<RequestDeliveryDTO>
     * 修改人：wt
     * 修改时间：2018/8/27
     * 修改内容：
     */
    @RequestMapping(value = "/find", method = RequestMethod.POST)
    @ApiOperation(value = "查询列表", notes = "查询列表")
    @ApiResponses({
    })
    public Result<PageInfo<RequestDeliveryDTO>> findDelivery(@RequestBody OpenApiReq<String> openApiReq) {

        DeliveryServiceExample example = new DeliveryServiceExample();
        example.createCriteria().andCreateTimeIsNotNull();
        PageHelper.startPage(openApiReq.getPageNo(), openApiReq.getPageSize());
        List<DeliveryService> list = deliveryServiceApiService.find(example);
        return Result.success(new PageInfo<>(dozerUtils.mapPage(list, RequestDeliveryDTO.class)));
    }

    /**
     * 描述：根据ID查询
     * 参数：id
     * 返回值：RequestDeliveryDTO
     * 修改人：wt
     * 修改时间：2018/8/27
     * 修改内容：
     */
    @RequestMapping(value = "/get", method = RequestMethod.GET)
    @ApiOperation(value = "根据ID查询", notes = "根据ID查询")
    @ApiResponses({
    })
    public Result<RequestDeliveryDTO> getDelivery(@RequestParam("id") Long id) {

        DeliveryServiceExample example = new DeliveryServiceExample();
        example.createCriteria().andIdEqualTo(id);
        DeliveryService deliveryService = deliveryServiceApiService.getUnique(example);
        return Result.success(dozerUtils.map(deliveryService,RequestDeliveryDTO.class));
    }

    /**
     * 描述：保存
     * 参数：RequestDeliveryDTO
     * 返回值：RequestDeliveryDTO
     * 修改人：wt
     * 修改时间：2018/8/27
     * 修改内容：
     */
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    @ApiOperation(value = "保存", notes = "保存")
    @ApiResponses({
    })
    public Result<RequestDeliveryDTO> saveDelivery(@RequestBody RequestDeliveryDTO dto) {

        DeliveryService deliveryService = dozerUtils.map(dto,DeliveryService.class);
        deliveryService.setCreateTime(Calendar.getInstance().getTime());
        deliveryService.setCreateUser(dto.getUserName());
        DeliveryService result = deliveryServiceApiService.saveSelective(deliveryService);
        return Result.success(dozerUtils.map(result,RequestDeliveryDTO.class));
    }

    /**
     * 描述：更新
     * 参数：RequestDeliveryDTO
     * 返回值：Integer
     * 修改人：wt
     * 修改时间：2018/8/27
     * 修改内容：
     */
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    @ApiOperation(value = "更新", notes = "更新")
    @ApiResponses({
    })
    public Result<Integer> updateDelivery(@RequestBody RequestDeliveryDTO dto) {

        DeliveryService deliveryService = dozerUtils.map(dto,DeliveryService.class);
        deliveryService.setUpdateTime(Calendar.getInstance().getTime());
        deliveryService.setUpdateUser(dto.getUserName());
        Integer result = deliveryServiceApiService.updateByIdSelective(deliveryService);
        return Result.success(result);
    }

    /**
     * 描述：删除
     * 参数：id
     * 返回值：Integer
     * 修改人：wt
     * 修改时间：2018/8/27
     * 修改内容：
     */
    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    @ApiOperation(value = "删除", notes = "删除")
    @ApiResponses({
    })
    public Result<Integer> deleteDelivery(@RequestParam("id") Long id) {
        Integer result = deliveryServiceApiService.deleteById(id);
        return Result.success(result);
    }
}
