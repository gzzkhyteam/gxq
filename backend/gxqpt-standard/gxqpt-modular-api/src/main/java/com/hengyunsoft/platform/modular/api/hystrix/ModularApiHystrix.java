//package com.hengyunsoft.platform.modular.api.hystrix;
//
//import org.springframework.stereotype.Component;
//
//import com.github.pagehelper.PageInfo;
//import com.hengyunsoft.base.Result;
//import com.hengyunsoft.page.plugins.openapi.OpenApiReq;
//import com.hengyunsoft.platform.modular.api.ModularApi;
//import com.hengyunsoft.platform.modular.dto.ModularDTO;
//import com.hengyunsoft.platform.modular.dto.ModularDiscardedPageDTO;
//import com.hengyunsoft.platform.modular.dto.ModularQueryDTO;
//import com.hengyunsoft.platform.modular.dto.ModularUpdateDTO;
//
///**
// * @author zhoukx
// * @createTime 2018-4-5
// */
//@Component
//public class ModularApiHystrix implements ModularApi {
//
//
//    /**
//     * 通过id查询模块对象信息
//     *
//     * @param id 模块id
//     * @return ModularDTO
//     * @createTime 2018-4-5
//     * @author zhoukx
//     */
//    @Override
//    public Result<ModularDTO> getModularById(Long id) {
//        return Result.timeout();
//    }
//
//    /**
//     * 分页查询模块列表
//     *
//     * @param openApiReq 分页信息
//     * @return PageInfo<ModularDTO>
//     * @createTime 2018-4-5
//     * @author zhoukx
//     */
//    @Override
//    public Result<PageInfo<ModularDTO>> page(OpenApiReq<ModularQueryDTO> openApiReq) {
//        return Result.timeout();
//    }
//
//    /**
//     * 模块更新
//     *
//     * @param modularUpdateDTO 要更新的模块对象
//     * @return Boolean
//     * @createTime 2018-4-5
//     * @author zhoukx
//     */
//    @Override
//    public Result<Boolean> update(ModularUpdateDTO modularUpdateDTO) {
//        return Result.timeout();
//    }
//
//    /**
//     * 根据id删除模块
//     * 如果模块下存在jar包则不可删除。
//     *
//     * @param id 模块id
//     * @return Boolean
//     * @createTime 2018-4-5
//     * @author zhoukx
//     */
//    @Override
//    public Result<Boolean> delete(Long id) {
//        return Result.timeout();
//    }
//
//    /**
//     * 根据仓库名和groupId和artifactId查询模块对象信息
//     *
//     * @param modularDTO 仓库名和groupId和artifactId
//     * @return ModularDTO
//     * @createTime 2018-4-5
//     * @author zhoukx
//     */
//    @Override
//    public Result<ModularDTO> getModularByRepNameAndGidAndAid(ModularDTO modularDTO) {
//        return Result.timeout();
//    }
//
//	@Override
//	public Result<PageInfo<ModularDTO>> pageDiscarded(OpenApiReq<ModularDiscardedPageDTO> openApiReq) {
//		return Result.timeout();
//	}
//}
