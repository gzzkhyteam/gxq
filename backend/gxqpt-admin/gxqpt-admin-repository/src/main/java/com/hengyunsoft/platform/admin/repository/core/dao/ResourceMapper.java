package com.hengyunsoft.platform.admin.repository.core.dao;

import com.hengyunsoft.platform.admin.entity.core.domain.ResourceDO;
import com.hengyunsoft.platform.admin.entity.core.po.Resource;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.hengyunsoft.platform.admin.repository.core.example.ResourceExample;

import java.util.List;
import java.util.Map;
@Repository
public interface ResourceMapper extends com.hengyunsoft.base.dao.BaseAllDao<Long, com.hengyunsoft.platform.admin.entity.core.po.Resource, ResourceExample> {
    /**
     * 描述：根据用户id及应用id查找该用户在该应用用于哪些资源
     * 参数：param
     * 返回值： List<Resource>
     * 修改人：zhaopengfei
     * 修改时间：2018/4/9
     * 修改内容：
     */
    List<Resource> selectUserRes(Map<String, Object> param);


    List<ResourceDO> selectTree(Map<String, Object> param);
    /**
     * 描述：查找可访问按钮
     * 参数：param
     * 返回值：Resource
     * 修改人：zhaopengfei
     * 修改时间：2018/4/17
     * 修改内容：
     */
    List<Resource> selectButtonList(Map<String, Object> param);

    /**
     * 查询用户拥有的指定菜单id
     * @tangyh
     * @param menuIdList
     * @param userId
     * @return
     */
    List<Long> findMenuIdByUserId(@Param("menuIdList") List<Long> menuIdList, @Param("userId") Long userId);


	List<ResourceDO> findUserVisibleResource(@Param("example") ResourceExample resourceExample,@Param("userId") Long userId);
}