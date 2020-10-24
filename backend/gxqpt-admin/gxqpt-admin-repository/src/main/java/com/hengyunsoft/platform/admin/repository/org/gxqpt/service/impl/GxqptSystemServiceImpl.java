package com.hengyunsoft.platform.admin.repository.org.gxqpt.service.impl;

import com.hengyunsoft.base.dao.BaseNormalDao;
import com.hengyunsoft.base.service.impl.BaseServiceImpl;
import com.hengyunsoft.commons.constant.EnableStatus;
import com.hengyunsoft.platform.admin.entity.org.gxqpt.po.GxqptSystem;
import com.hengyunsoft.platform.admin.repository.org.gxqpt.dao.GxqptSystemMapper;
import com.hengyunsoft.platform.admin.repository.org.gxqpt.example.GxqptSystemExample;
import com.hengyunsoft.platform.admin.repository.org.gxqpt.service.GxqptSystemService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class GxqptSystemServiceImpl extends BaseServiceImpl<String, GxqptSystem, GxqptSystemExample> implements GxqptSystemService {

    @Autowired
    private GxqptSystemMapper gxqptSystemMapper;


    /**
     * 根据id删除体系信息
     * @param id
     * @return
     */
    @Override
    public int deleteSystem(String id){
        return gxqptSystemMapper.deleteSystem(id);
    }

    @Override
    protected BaseNormalDao<String, GxqptSystem, GxqptSystemExample> getDao() {
        return gxqptSystemMapper;
    }

    /**
     * 判断体系是否存在，防止注入
     * @param system
     * @return
     */
    @Override
    public boolean isExistSystem(String system){
        GxqptSystemExample example = new GxqptSystemExample();
        example.createCriteria().andCodeEqualTo(system);

        if (gxqptSystemMapper.selectByExample(example).size() > 0) {
            return true;
        }
        return false;
    }
    /**
     * 获得体系编码list
     *
     * @return
     */
    @Override
    public List<String> getSystemCode() {
        //设置查询条件
        GxqptSystemExample systemExample = new GxqptSystemExample();
        systemExample.createCriteria().andStatusEqualTo(String.valueOf(EnableStatus.ENABLE.getStatus()));
        List<GxqptSystem> systems = gxqptSystemMapper.selectByExample(systemExample);
        //过滤空处理
        List systemCodes = systems.stream().filter(system -> !StringUtils.isEmpty(system.getCode()))
                .map(GxqptSystem::getCode).collect(Collectors.toList());

        return systemCodes;
    }
}
