package com.hengyunsoft.platform.admin.api.core.api.hystrix;

import com.github.pagehelper.PageInfo;
import com.hengyunsoft.base.Result;
import com.hengyunsoft.page.plugins.openapi.OpenApiReq;
import com.hengyunsoft.platform.admin.api.core.api.GxqptPostApi;
import com.hengyunsoft.platform.admin.api.core.dto.post.GxqptPostQueryDTO;
import com.hengyunsoft.platform.admin.api.core.dto.post.GxqptPostRetDTO;
import com.hengyunsoft.platform.admin.api.core.dto.post.GxqptPostSaveDTO;
import com.hengyunsoft.platform.admin.api.core.dto.post.GxqptPostUpdateDTO;
import org.springframework.stereotype.Component;

/**
 *
 * 描述:岗位管理熔断
 * @author chb
 * @date 2018/3/7 13:46
 * @return
 */
@Component
public class GxqptPostHystrix implements GxqptPostApi {
    @Override
    public Result<GxqptPostRetDTO> save(GxqptPostSaveDTO gxqptPostSaveDTO) {
        return Result.timeout();
    }

    @Override
    public Result<GxqptPostUpdateDTO> updateById(GxqptPostUpdateDTO gxqptPostUpdateDTO) {
        return Result.timeout();
    }

    @Override
    public Result<GxqptPostRetDTO> getPostById(String id,String systemCode) {
        return Result.timeout();
    }

    @Override
    public Result<String> removeById(String id) {
        return Result.timeout();
    }

    @Override
    public Result<PageInfo<GxqptPostRetDTO>> findPostList(OpenApiReq<GxqptPostQueryDTO> openApiReq) {
        return null;
    }
}
