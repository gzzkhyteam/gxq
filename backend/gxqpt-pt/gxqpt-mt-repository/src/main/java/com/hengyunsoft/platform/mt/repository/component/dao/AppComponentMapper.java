package com.hengyunsoft.platform.mt.repository.component.dao;

import com.hengyunsoft.platform.mt.entity.component.po.AppComponent;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface AppComponentMapper extends com.hengyunsoft.base.dao.BaseNormalDao<Long, com.hengyunsoft.platform.mt.entity.component.po.AppComponent, com.hengyunsoft.platform.mt.repository.component.example.AppComponentExample> {
    /**
     * 描述：根据应用Id查找组件信息
     * 参数：id 组件Id
     * 返回值：    List<AppComponent>
     * 修改人：zhaopengfei
     * 修改时间：2018/8/28
     * 修改内容：
     */
    List<AppComponent> selectByApplicationId(@Param("applicationId") Long applicationId);

    List<AppComponent> selectByApplicationIdTemp(@Param("applicationId") Long applicationId);
}