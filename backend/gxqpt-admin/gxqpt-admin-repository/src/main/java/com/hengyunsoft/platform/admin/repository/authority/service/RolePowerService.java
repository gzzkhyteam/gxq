package com.hengyunsoft.platform.admin.repository.authority.service;

import com.hengyunsoft.base.service.normal.BaseService;
import com.hengyunsoft.platform.admin.entity.core.po.RolePower;
import com.hengyunsoft.platform.admin.repository.core.example.RolePowerExample;

/**
 * com.hengyunsoft.platform.admin.repository.authority.service
 * codeBySC2
 * 版权：中科恒运软件科技股份有限公司贵阳分公司
 * 描述：角色资源关联Service
 * 修改人：zhaopengfei
 * 修改时间：2018/3/7
 * 修改内容：
 */
public interface RolePowerService extends BaseService<Long, RolePower, RolePowerExample> {
    /**
     * 描述：根据属性匹配删除
     * 参数：RolePowerExample 角色资源Example
     * 修改人：zhaopengfei
     * 修改时间：2018/3/14
     * 修改内容：
     */
    void deleteByEntity(RolePowerExample example);
}
