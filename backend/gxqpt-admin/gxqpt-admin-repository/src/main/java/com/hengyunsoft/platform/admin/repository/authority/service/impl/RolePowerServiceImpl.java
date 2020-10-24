package com.hengyunsoft.platform.admin.repository.authority.service.impl;

import com.hengyunsoft.base.dao.BaseNormalDao;
import com.hengyunsoft.base.service.impl.BaseServiceImpl;
import com.hengyunsoft.platform.admin.entity.core.po.RolePower;
import com.hengyunsoft.platform.admin.repository.authority.service.RolePowerService;
import com.hengyunsoft.platform.admin.repository.core.dao.RolePowerMapper;
import com.hengyunsoft.platform.admin.repository.core.example.RolePowerExample;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * com.hengyunsoft.platform.admin.repository.authority.service.impl
 * codeBySC2
 * 版权：中科恒运软件科技股份有限公司贵阳分公司
 * 描述：角色资源关联Service实现
 * 修改人：zhaopengfei
 * 修改时间：2018/3/7
 * 修改内容：
 */
@Service
@Slf4j
public class RolePowerServiceImpl extends BaseServiceImpl<Long, RolePower, RolePowerExample> implements RolePowerService {
    @Autowired
    RolePowerMapper rolePowerMapper;

    @Override
    protected BaseNormalDao<Long, RolePower, RolePowerExample> getDao() {
        return rolePowerMapper;
    }

    /**
     * 描述：根据属性匹配删除
     * 参数：RolePowerExample 角色资源Example
     * 修改人：zhaopengfei
     * 修改时间：2018/3/14
     * 修改内容：
     */
    @Override
    public void deleteByEntity(RolePowerExample example) {
        rolePowerMapper.deleteByExample(example);
    }
}
