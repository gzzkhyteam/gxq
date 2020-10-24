//package com.hengyunsoft.platform.exchange.api.system.api.hystrix;
//
//import com.hengyunsoft.base.Result;
//import com.hengyunsoft.platform.exchange.api.system.api.ShareDictApi;
//import com.hengyunsoft.platform.exchange.api.system.dto.ShareRequestDictDTO;
//import com.hengyunsoft.platform.exchange.api.system.dto.ShareRequestUpdateDictDTO;
//import com.hengyunsoft.platform.exchange.api.system.dto.ShareResponseDictDTO;
//import org.springframework.stereotype.Component;
//
//import java.util.List;
//
///**
// *com.hengyunsoft.platform.exchange.api.system.api.hystrix
// * 版权：中科恒运软件科技股份有限公司贵阳分公司
// * 描述：熔断机制的实现， 默认返回超时响应
// * 修改人：wt
// * 修改时间：2018/4/23
// * 修改内容：新增熔断机制
// */
//@Component
//public class ShareDictApiHystrix implements ShareDictApi {
//
//    /**
//     * 描述：用户根据code查询数据字典
//     * 参数：dictCode 目录编码
//     * 返回值：List<ShareResponseDictDTO>
//     * 修改人：
//     * 修改时间：2018/4/23
//     * 修改内容：
//     */
//    @Override
//    public Result<List<ShareResponseDictDTO>> findByDictCode(String pId) {
//        return Result.timeout();
//    }
//
//    /**
//     * 描述：保存数据字典
//     * 参数：ShareRequestDictDTO
//     * 返回值：ShareResponseDictDTO
//     * 修改人：
//     * 修改时间：2018/4/23
//     * 修改内容：
//     */
//    @Override
//    public Result<ShareResponseDictDTO> saveDict(ShareRequestDictDTO dto) { return Result.timeout(); }
//
//    /**
//     * 描述：删除数据字典
//     * 参数：id
//     * 返回值：Boolean
//     * 修改人：
//     * 修改时间：2018/4/23
//     * 修改内容：
//     */
//    @Override
//    public Result<Boolean> deleteDictById(Long id) { return Result.timeout(); }
//
//    /**
//     * 描述：删除数据字典
//     * 参数：ShareRequestDictDTO
//     * 返回值：ShareResponseDictDTO
//     * 修改人：
//     * 修改时间：2018/4/23
//     * 修改内容：
//     */
//    @Override
//    public Result<ShareResponseDictDTO> updateDict(ShareRequestUpdateDictDTO dto) { return Result.timeout();}
//}
