package com.hengyunsoft.platform.developer.repository.fast.service;

import com.hengyunsoft.base.service.BaseAllService;
import com.hengyunsoft.platform.developer.entity.fast.po.FastMenu;
import com.hengyunsoft.platform.developer.repository.fast.example.FastMenuExample;

import java.util.List;

public interface FastMenuService extends BaseAllService<Long, FastMenu, FastMenuExample> {

    /**
     * 描述：根据id查询快速应用菜单Api
     * 参数：id
     * 返回值：FastMenuDTO
     * 修改人：sunxiaoya
     * 修改时间：2018/5/3
     * 修改内容：
     */
    List<FastMenu> getMenu(Long parentId, String appId);


    void deleteByAppId(String appId);
}
