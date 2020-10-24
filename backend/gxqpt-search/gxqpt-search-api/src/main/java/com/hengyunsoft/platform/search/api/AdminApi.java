package com.hengyunsoft.platform.search.api;

import com.hengyunsoft.base.Result;
import com.hengyunsoft.platform.search.api.hystrix.AdminApiHystrix;
import com.hengyunsoft.platform.search.dto.OptCollection2AppDTO;
import com.hengyunsoft.platform.search.dto.OptCollstionListDTO;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 描述：搜索模块管理接口
 *
 * @author gbl
 * @date 2018/4/9
 */
@FeignClient(name = "${gxqpt.feign.search-server:gxqpt-search-server}", fallback = AdminApiHystrix.class)
public interface AdminApi {

    /**
     * 描述：查看登录用户的所有集合
     * 参数：集合列表
     * 返回值：
     * 修改人：gbl
     * 修改时间：2018/4/9
     * 修改内容：
     */
    @RequestMapping(value = "/adminModule/showMyCollection", method = RequestMethod.GET)
    Result<OptCollstionListDTO> showMyCollection();

    /**
     * 描述：集合指派给需要查询的app
     * 参数：optCollection2AppDTO
     * 返回值：成功或者失败
     * 修改人：gbl
     * 修改时间：2018/4/9
     * 修改内容：新增
     */
    @RequestMapping(value = "/adminModule/appointCollection2App", method = RequestMethod.POST)
    Result<Boolean> appointCollection2App(OptCollection2AppDTO optCollection2AppDTO);

    /**
     * 描述：得到collectionIdd对应appid的权限
     * 参数：collectionId:集合id  appId:appId
     * 返回值：权限值
     * 修改人：gbl
     * 修改时间：2018/4/12
     * 修改内容：
     */
    @RequestMapping(value = "/adminModule/getColleAppIpOpt", method = RequestMethod.GET)
    Result<Integer> getColleAppIpOpt(@RequestParam("collectionId") Long collectionId, @RequestParam("appId") String appId);

    /**
     * 描述：查看拥有该集合权限的所有app
     * 参数：collectionId集合id
     * 返回值：
     * 修改人：gbl
     * 修改时间：2018/4/9
     * 修改内容： 新增
     */
    @RequestMapping(value = "/adminModule/showCollectionApp", method = RequestMethod.POST)
    Result<OptCollstionListDTO> showCollectionApp(Long collectionId);
}
