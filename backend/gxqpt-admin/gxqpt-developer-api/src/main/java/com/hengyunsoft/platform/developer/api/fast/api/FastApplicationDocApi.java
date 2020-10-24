package com.hengyunsoft.platform.developer.api.fast.api;

import com.github.pagehelper.PageInfo;
import com.hengyunsoft.base.Result;
import com.hengyunsoft.page.plugins.openapi.OpenApiReq;
import com.hengyunsoft.platform.developer.api.fast.api.hystrix.FastApplicationDocApiHystrix;
import com.hengyunsoft.platform.developer.api.fast.dto.docment.*;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * 快速应用公文服务管理
 *
 * @author sxy
 * @createTime 2018年5月8日
 */
@FeignClient(name = "${gxqpt.feign.admin-server:gxqpt-admin-server}",
        fallback = FastApplicationDocApiHystrix.class)
public interface FastApplicationDocApi {

    /**
     * 描述：快速应用公文分页Api
     * 参数：[FastAppDocTaskPageDTO]
     * 返回值：<PageInfo<FastAppDocTaskPageRetDTO>>
     * 修改人：sxy
     * 修改时间：2018/5/8
     * 修改内容：
     */
    @RequestMapping(value = "/fastapplicationdoc/page", method = RequestMethod.POST)
    Result<PageInfo<FastAppDocTaskPageRetDTO>> page(@RequestBody OpenApiReq<FastAppDocTaskPageDTO> openApiReq);

    /**
     * 描述：快速应用公文审批Api
     * 参数：FastAppDocTaskApproveDTO
     * 返回值：Boolean
     * 修改人：sxy
     * 修改时间：2018/5/8
     * 修改内容：
     */
    @RequestMapping(value = "/fastapplicationdoc/approve", method = RequestMethod.POST)
    Result<Boolean> approve(@RequestBody FastAppDocTaskApproveDTO dto);

    /**
     * 描述：快速应用公文更新Api
     * 参数：FastAppDocTaskUpdateDTO
     * 返回值：Boolean
     * 修改人：sxy
     * 修改时间：2018/5/8
     * 修改内容：
     */
    @RequestMapping(value = "/fastapplicationdoc/update", method = RequestMethod.POST)
    Result<Boolean> update(@RequestBody FastAppDocTaskUpdateDTO dto);

    /**
     * 描述：根据id查询快速应用公文详情Api
     * 参数：id
     * 返回值：FastAppDocTaskRetDTO
     * 修改人：sxy
     * 修改时间：2018/5/8
     * 修改内容：
     */
    @RequestMapping(value = "/fastapplicationdoc/taskDetail", method = RequestMethod.GET)
    Result<FastAppDocTaskRetDTO> getById(@RequestParam("id") Long id);

    /**
     * 描述：根据id查询快速应用公文拟办详情Api
     * 参数：taskId
     * 返回值：List<FastAppDocExtraAdviceRetDTO>
     * 修改人：sxy
     * 修改时间：2018/5/8
     * 修改内容：
     */
    @RequestMapping(value = "/fastapplicationdoc/taskExtraDetail", method = RequestMethod.GET)
    Result<List<FastAppDocExtraAdviceRetDTO>> getByTaskId(@RequestParam("taskId") Long taskId);

    /**
     * 描述：新增公文
     * 参数：FastAppDocTaskSaveDTO
     * 返回值：Result<FastAppDocTaskSaveRetDTO>
     * 修改人：sxy
     * 修改时间：2018/5/8
     * 修改内容：
     */
    @RequestMapping(value = "/fastapplicationdoc/saveDoc", method = RequestMethod.POST)
    Result<FastAppDocTaskSaveRetDTO> saveDoc(@RequestBody FastAppDocTaskSaveDTO dto);

    /**
     * 描述：新增拟办
     * 参数：FastAppDocExtraAdviceSaveDTO
     * 返回值：Result<FastAppDocExtraAdviceRetDTO>
     * 修改人：sxy
     * 修改时间：2018/5/8
     * 修改内容：
     */
    @RequestMapping(value = "/fastapplicationdoc/saveExtraDoc", method = RequestMethod.POST)
    Result<FastAppDocExtraAdviceSaveRetDTO> saveExtraDoc(@RequestBody FastAppDocExtraAdviceSaveDTO dto);


}

