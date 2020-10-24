package com.hengyunsoft.platform.admin.api.base.api.hystrix;

import com.hengyunsoft.base.Result;
import com.hengyunsoft.platform.admin.api.base.api.AreaApi;
import com.hengyunsoft.platform.admin.api.base.dto.AreaDTO;
import com.hengyunsoft.platform.admin.api.base.dto.AreaSaveDTO;
import com.hengyunsoft.platform.admin.api.base.dto.AreaTreeDTO;
import com.hengyunsoft.platform.admin.api.base.dto.AreaUpdateDTO;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

/**
 * feign 熔断机制的实现， 默认返回超时响应
 * @author tianai
 * @createTime 2018-01-30
 */
@Component
public class AreaApiHystrix implements AreaApi{

    /**
     * 根据主键id查询区域信息
     *  feign 熔断机制的实现， 默认返回超时响应
     */
    @Override
    public Result<AreaDTO> get(Long id) {
        return Result.timeout();
    }
    /**
     * 根据父id-parentId查询区域信息
     *  feign 熔断机制的实现， 默认返回超时响应
     */
    @Override
    public Result<List<AreaTreeDTO>> findAreaTree(Long parentId) {
        return Result.timeout();
    }
    /**
     * 保存区域信息
     *  feign 熔断机制的实现， 默认返回超时响应
     */
    @Override
    public Result<AreaDTO> save(AreaSaveDTO areaSaveDto) {
        return Result.timeout();
    }
    /**
     * 更新区域信息
     *  feign 熔断机制的实现， 默认返回超时响应
     */
    @Override
    public Result<Boolean> update(AreaUpdateDTO areaUpdateDto) {
        return Result.timeout();
    }
    /**
     * 删除区域信息
     *  feign 熔断机制的实现， 默认返回超时响应
     */
    @Override
    public Result<Boolean> delete(Long id) {
        return Result.timeout();
    }
    /**
     * 查询子区域
     *  feign 熔断机制的实现， 默认返回超时响应
     */
    @Override
    public Result<List<AreaDTO>> find(Long id) { return Result.timeout(); }

}
