package com.hengyunsoft.platform.admin.repository.base.service;

import com.hengyunsoft.base.service.normal.BaseService;
import com.hengyunsoft.platform.admin.entity.base.po.Area;
import com.hengyunsoft.platform.admin.repository.base.example.AreaExample;

import java.util.List;

/**
 * @author tianai
 * @createTime 2018-01-30
 */
public interface AreaService extends BaseService<Long, Area, AreaExample> {
    /**
     * 查询区域及子区域ID列表
     * @param parentId  上级区域ID
     */
    List<Area> findByParentId(Long parentId);


    /**
     * 查询区域及子区域
     * @param id 主键id
     */
    List<Area> getSubAreaIdList(Long id);

    /**
     * 更新
     *
     * @param entity 区域实体
     * @return 影响行数
     */
    int updateById(Area entity);


    /**
     * 根据ID物理删除记录
     *
     * @param id 主键id
     */
    int deleteAllById(Long id);

    /**
     * 根据id查询某个地区
     *
     * @param id 主键id
     */
    Area findById(Long id);

    /**
     * 查询所有地区(带键值)
     * @return
     */
    List findAreaForExcel();

    /**
     * 编码是否存在判断
     * @param code
     * @return
     */
    boolean check(String code);
}
