package com.hengyunsoft.platform.admin.repository.authority.service.impl;

import com.hengyunsoft.base.dao.BaseNormalDao;
import com.hengyunsoft.base.service.impl.BaseServiceImpl;
import com.hengyunsoft.platform.admin.entity.core.domain.ResourceDO;
import com.hengyunsoft.platform.admin.entity.core.po.Resource;
import com.hengyunsoft.platform.admin.repository.authority.service.ResourceService;
import com.hengyunsoft.platform.admin.repository.core.dao.ResourceMapper;
import com.hengyunsoft.platform.admin.repository.core.example.ResourceExample;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * com.hengyunsoft.platform.admin.repository.authority.service.impl
 * codeBySC2
 * 版权：中科恒运软件科技股份有限公司贵阳分公司
 * 描述：资源Service实现
 * 修改人：zhaopengfei
 * 修改时间：2018/3/7
 * 修改内容：
 */
@Service
@Slf4j
public class ResourceServiceImpl extends BaseServiceImpl<Long, Resource, ResourceExample> implements ResourceService {
    @Autowired
    ResourceMapper resourceMapper;

    @Override
    protected BaseNormalDao<Long, Resource, ResourceExample> getDao() {
        return resourceMapper;
    }

    /**
     * 描述：根据用户id及应用id查找该用户在该应用用于哪些资源
     * 参数：param
     * 返回值： List<Resource>
     * 修改人：zhaopengfei
     * 修改时间：2018/4/9
     * 修改内容：
     */
    @Override
    public List<Resource> queryUserRes(Map<String, Object> param) {
        return resourceMapper.selectUserRes(param);
    }
    
    @Override
	public List<Resource> queryUserRes(String appId, Long userId) {
    	
    	
    	Map<String, Object> param = new HashMap<>(4);
    	param.put("appId", appId);
    	param.put("userId", userId);
		return queryUserRes(param );
	}


    public List<ResourceDO> findTree(Map<String, Object> param) {
        return resourceMapper.selectTree(param);
    }
    /**
     * 描述：查找可访问按钮
     * 参数：param
     * 返回值：Resource
     * 修改人：zhaopengfei
     * 修改时间：2018/4/17
     * 修改内容：
     */
    @Override
    public List<Resource> findButtonList(Map<String, Object> param) {
        return resourceMapper.selectButtonList(param);
    }

    @Override
    public List<Long> findMenuIdByUserId(List<Long> menuIdList, Long userId) {
        return resourceMapper.findMenuIdByUserId(menuIdList, userId);
    }

	@Override
	public List<ResourceDO> findUserVisibleResource(ResourceExample resourceExample, Long userId) {

		List<ResourceDO> resources = resourceMapper.findUserVisibleResource(resourceExample,userId);
		
		return resources;
	}

}