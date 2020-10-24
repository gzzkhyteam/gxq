//package com.hengyunsoft.platform.warn.api.warntype.api.hystrix;
//
//import com.hengyunsoft.base.Result;
//import com.hengyunsoft.platform.warn.api.warntype.dto.GxqptWarnTypeDTO;
//import com.hengyunsoft.platform.warn.api.warntype.dto.UpdateGxqptWarnTypeDTO;
//import com.hengyunsoft.platform.warn.api.warntype.dto.WarnTreeDTO;
//import com.hengyunsoft.platform.warn.api.warntype.api.GxqptWarnTypeApi;
//
//import org.springframework.stereotype.Component;
//import org.springframework.web.bind.annotation.RequestParam;
//
//import java.util.List;
//import java.util.Map;
//
//
///**
// * 描述:熔断实现默认响应超时
// * @author zjr
// * @date 2018/03/28
// * @return
// */
//@Component
//public class GxqptWarnTypeApiHystrix implements GxqptWarnTypeApi {
//
//    /**
//     * 获取预警类型分类树
//     * @param parentId
//     * @return
//     */
//    @Override
//    public Result<List<WarnTreeDTO>> findWarnTypeTree (Long id){return Result.timeout();}
//
//    /**
//     * 查询预警类型
//     * @return
//     */
//    @Override
//    public Result<List<Map<String,Object>>> getWarnType(){return Result.timeout();}
//    /**
//     * 根据id查询预警类型信息
//     * @param id
//     * @return
//     */
//    @Override
//    public Result<GxqptWarnTypeDTO> getById(Long id){return Result.timeout();}
//    /**
//     * 添加预警类型信息
//     * @param gxqptWarnTypeDto
//     * @return
//     */
//    @Override
//    public Result<GxqptWarnTypeDTO> save(GxqptWarnTypeDTO gxqptWarnTypeDto){ return Result.timeout(); }
//
//    /**
//     * 根据id编辑预警类型信息
//     * @param updateGxqptWarnTypeDto
//     * @return
//     */
//    @Override
//    public Result<UpdateGxqptWarnTypeDTO> update(UpdateGxqptWarnTypeDTO updateGxqptWarnTypeDto){ return Result.timeout(); }
//
//    public int getCode(String code){return -1;}
//    /**
//     * 根据ID过期预警类型信息
//     * @param id
//     * @return
//     */
//    @Override
//    public Result<String> overdueById(Long id){return Result.timeout();}
//    /**
//     * 拖动预警类型
//     * @param id
//     * @return
//     */
//    @Override
//	public Result<Boolean> updateLocation(Long currentId,Long locateId,String type) {
//		return Result.timeout();
//	}
//}
