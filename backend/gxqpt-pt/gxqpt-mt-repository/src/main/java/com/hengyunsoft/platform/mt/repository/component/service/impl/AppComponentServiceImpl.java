package com.hengyunsoft.platform.mt.repository.component.service.impl;

import com.hengyunsoft.base.dao.BaseNormalDao;
import com.hengyunsoft.base.service.impl.BaseServiceImpl;
import com.hengyunsoft.platform.mt.entity.component.po.AppCallInterface;
import com.hengyunsoft.platform.mt.entity.component.po.AppComponent;
import com.hengyunsoft.platform.mt.repository.component.dao.AppCallInterfaceMapper;
import com.hengyunsoft.platform.mt.repository.component.dao.AppComponentMapper;
import com.hengyunsoft.platform.mt.repository.component.example.AppCallInterfaceExample;
import com.hengyunsoft.platform.mt.repository.component.example.AppComponentExample;
import com.hengyunsoft.platform.mt.repository.component.service.AppCallInterfaceService;
import com.hengyunsoft.platform.mt.repository.component.service.AppComponentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class AppComponentServiceImpl extends BaseServiceImpl<Long, AppComponent, AppComponentExample> implements AppComponentService {
    @Autowired
    private AppComponentMapper appComponentMapper;

    @Override
    protected BaseNormalDao<Long, AppComponent, AppComponentExample> getDao() {
        return appComponentMapper;
    }
    /**
     * 描述：根据应用Id查找组件信息
     * 参数：id 组件Id
     * 返回值：    List<AppComponent>
     * 修改人：zhaopengfei
     * 修改时间：2018/8/28
     * 修改内容：
     */
    @Override
    public List<AppComponent> findByApplicationId(Long id) {
        return appComponentMapper.selectByApplicationId(id);
    }

    @Override
    public List<AppComponent> findByApplicationIdTemp(Long id) {
        return appComponentMapper.selectByApplicationIdTemp(id);
    }
}
