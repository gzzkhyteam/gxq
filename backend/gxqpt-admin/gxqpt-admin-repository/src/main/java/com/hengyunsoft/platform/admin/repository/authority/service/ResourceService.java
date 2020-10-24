package com.hengyunsoft.platform.admin.repository.authority.service;

import com.hengyunsoft.base.service.normal.BaseService;
import com.hengyunsoft.platform.admin.entity.core.domain.ResourceDO;
import com.hengyunsoft.platform.admin.entity.core.po.Resource;
import com.hengyunsoft.platform.admin.repository.core.example.ResourceExample;

import java.util.List;
import java.util.Map;

/**
 * com.hengyunsoft.platform.admin.repository.authority.service
 * codeBySC2
 * 版权：中科恒运软件科技股份有限公司贵阳分公司
 * 描述：资源Service
 * 修改人：zhaopengfei
 * 修改时间：2018/3/7
 * 修改内容：
 */

public interface ResourceService extends BaseService<Long, Resource, ResourceExample> {
    /**
     * 描述：根据用户id及应用id查找该用户在该应用用于哪些资源
     * 参数：param
     * 返回值： List<Resource>
     * 修改人：zhaopengfei
     * 修改时间：2018/4/9
     * 修改内容：
     */
    List<Resource> queryUserRes(Map<String, Object> param); 
    /**
     * 描述：根据用户id及应用id查找该用户在该应用用于哪些资源
     * 参数：param
     * 返回值： List<Resource>
     * 修改人：zhaopengfei
     * 修改时间：2018/4/9
     * 修改内容：
     */
    List<Resource> queryUserRes(String appId,Long userId); 
    
    List<ResourceDO> findTree(Map<String, Object> param);
    /**
     * 描述：查找可访问按钮
     * 参数：param
     * 返回值：Resource
     * 修改人：zhaopengfei
     * 修改时间：2018/4/17
     * 修改内容：
     */
    List<Resource> findButtonList(Map<String, Object> param);

    List<Long> findMenuIdByUserId(List<Long> menuIdList, Long userId);
    /**
     * 组织成树，   获取指定用户的资源信息
     * @param resourceExample  过滤条件
     * @param userId           指定的用户
     * @return
     */
	List<ResourceDO> findUserVisibleResource(ResourceExample resourceExample, Long userId);
}
