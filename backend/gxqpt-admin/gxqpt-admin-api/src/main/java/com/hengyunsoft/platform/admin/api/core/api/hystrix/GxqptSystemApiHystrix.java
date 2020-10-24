package com.hengyunsoft.platform.admin.api.core.api.hystrix;

import com.github.pagehelper.PageInfo;
import com.hengyunsoft.base.Result;
import com.hengyunsoft.page.plugins.openapi.OpenApiReq;
import com.hengyunsoft.platform.admin.api.core.api.GxqptSystemApi;
import com.hengyunsoft.platform.admin.api.core.dto.system.GxqptSystemDTO;
import com.hengyunsoft.platform.admin.api.core.dto.system.GxqptSystemPageListDTO;
import com.hengyunsoft.platform.admin.api.core.dto.system.GxqptSystemUpdateDTO;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;


/**
 * feign 熔断机制的实现， 默认返回超时响应
 * @author zjr
 * @createTime 2018-03-07
 * @return
 */
@Component
public class GxqptSystemApiHystrix implements GxqptSystemApi {

    /**
     * 查询体系来源
     * feign 熔断机制的实现， 默认返回超时响应
     */
    @Override
    public Result<List<String>> getBySource() {
        return Result.timeout();
    }

    /**
     * 查询体系分页信息
     * feign 熔断机制的实现， 默认返回超时响应
     */
    @Override
    public Result<PageInfo<GxqptSystemPageListDTO>> findSystemList(OpenApiReq<GxqptSystemDTO> openApiReq) {
        return Result.timeout();
    }
    /**
     * 编辑体系信息
     * feign 熔断机制的实现， 默认返回超时响应
     */
    @Override
    public Result<GxqptSystemUpdateDTO> updateById(GxqptSystemUpdateDTO systemUpdateDto) {
        return Result.timeout();
    }
    /**
     * 删除体系信息
     * feign 熔断机制的实现， 默认返回超时响应
     */
    @Override
    public Result<Boolean> deleteSystem(String id) {
        return Result.timeout();
    }

}
