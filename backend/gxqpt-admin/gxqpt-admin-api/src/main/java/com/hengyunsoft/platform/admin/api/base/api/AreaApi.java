package com.hengyunsoft.platform.admin.api.base.api;

import com.hengyunsoft.base.Result;
import com.hengyunsoft.platform.admin.api.base.api.hystrix.AreaApiHystrix;
import com.hengyunsoft.platform.admin.api.base.dto.AreaDTO;
import com.hengyunsoft.platform.admin.api.base.dto.AreaSaveDTO;
import com.hengyunsoft.platform.admin.api.base.dto.AreaTreeDTO;
import com.hengyunsoft.platform.admin.api.base.dto.AreaUpdateDTO;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @author tianai
 * @createTime 2018-01-30
 */
@FeignClient(name = "${gxqpt.gate.feign.server:gxqpt-gate-server}", path = "/api/admin", fallback = AreaApiHystrix.class)
public interface AreaApi {


    /**
     * 查询所有的区域树列表
     *
     * @param parentId
     * @return
     */
    @RequestMapping(value = "/area/findAreaTree", method = RequestMethod.GET)
    Result<List<AreaTreeDTO>> findAreaTree(@RequestParam(value = "parentId") Long parentId);

    /**
     * 根据id 查区域名称
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/area/get", method = RequestMethod.GET)
    Result<AreaDTO> get(@RequestParam(value = "id") Long id);


    /**
     * 保存地区名称信息
     *
     * @param areaSaveDto
     * @return
     */
    @RequestMapping(value = "/area/save", method = RequestMethod.POST)
    Result<AreaDTO> save(@RequestBody AreaSaveDTO areaSaveDto);


    /**
     * 修改地区名称信息
     *
     * @param areaUpdateDto
     * @return
     */
    @RequestMapping(value = "/area/update", method = RequestMethod.POST)
    Result<Boolean> update(@RequestBody AreaUpdateDTO areaUpdateDto);

    /**
     * 删除地区信息
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/area/delete", method = RequestMethod.POST)
    Result<Boolean> delete(@RequestParam(value = "id") Long id);

    /**
     * 查询所有子区域
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/area/find", method = RequestMethod.GET)
    Result<List<AreaDTO>> find(@RequestParam(value = "parentId") Long parentId);
}
