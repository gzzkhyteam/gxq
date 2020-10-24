package com.hengyunsoft.platform.mt.repository.component.service;

import com.hengyunsoft.base.service.normal.BaseService;
import com.hengyunsoft.platform.mt.entity.component.po.AppComponent;
import com.hengyunsoft.platform.mt.repository.component.example.AppComponentExample;

import java.util.List;

public interface AppComponentService extends BaseService<Long, AppComponent, AppComponentExample> {
    /**
     * 描述：根据应用Id查找组件信息
     * 参数：id 组件Id
     * 返回值：    List<AppComponent>
     * 修改人：zhaopengfei
     * 修改时间：2018/8/28
     * 修改内容：
     */
    List<AppComponent> findByApplicationId(Long id);

    List<AppComponent> findByApplicationIdTemp(Long id);
}
