package com.hengyunsoft.platform.admin.api.authority.api.hystrix;

import com.hengyunsoft.base.Result;
import com.hengyunsoft.platform.admin.api.authority.api.FastEntryApi;
import com.hengyunsoft.platform.admin.api.authority.dto.resource.FastEntryDTO;
import com.hengyunsoft.platform.admin.api.authority.dto.resource.FastEntryRankDTO;
import com.hengyunsoft.platform.admin.api.authority.dto.resource.FastEntrySaveDTO;
import com.hengyunsoft.platform.admin.api.authority.dto.resource.FastEntryUpdateDTO;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * com.hengyunsoft.platform.admin.api.authority.api.hystrix
 * 版权：中科恒运软件科技股份有限公司贵阳分公司
 * 描述：熔断机制的实现， 默认返回超时响应
 * 修改人：sunxiaoya
 * 修改时间：2018/3/28
 * 修改内容：新增熔断机制
 */
@Component
public class FastEntryApiHystrix implements FastEntryApi {


    /**
     * 描述：新增快捷入口Api
     * 参数：[FastEntrySaveDTO：快捷入口新增实体]
     * 返回值：FastEntrySaveDTO
     * 修改人：sunxiaoya
     * 修改时间：2018/3/28
     * 修改内容：
     */
    @Override
    public Result<FastEntrySaveDTO> save(FastEntrySaveDTO fastEntryDto) {
        return Result.timeout();
    }

    /**
     * 描述：修改快捷入口Api
     * 参数：FastEntryUpdateDTO
     * 返回值：Boolean
     * 修改人：sunxiaoya
     * 修改时间：2018/3/28
     * 修改内容：
     */
    @Override
    public Result<Boolean> update(FastEntryUpdateDTO fastEntryUpdateDTO) {
        return Result.timeout();
    }


    /**
     * 描述：删除快捷入口Api
     * 参数：快速入口id
     * 返回值：Boolean
     * 修改人：sunxiaoya
     * 修改时间：2018/3/28
     * 修改内容：
     */
    @Override
    public Result<Boolean> delete(Long id) {
        return Result.timeout();
    }


    /**
     * 描述：根据userId查询快捷入口Api
     * 参数：userId
     * 返回值：FastEntryDTO
     * 修改人：sunxiaoya
     * 修改时间：2018/3/28
     * 修改内容：
     */
    @Override
    public Result<FastEntryDTO> getById(Long userId) {
        return Result.timeout();
    }

    /**
     * 描述：查询快捷入口Api
     * 参数：
     * 返回值：FastEntryDTO
     * 修改人：sunxiaoya
     * 修改时间：2018/3/28
     * 修改内容：
     */
    @Override
    public Result<List<FastEntryDTO>> findList() {
        return Result.timeout();
    }

    /**
     * 获取快捷入口排行榜
     * @param resultNum
     * @return
     */
    @Override
    public Result<List<FastEntryRankDTO>> getFastEntryRank(Long resultNum) {
        return Result.timeout();
    }
}
