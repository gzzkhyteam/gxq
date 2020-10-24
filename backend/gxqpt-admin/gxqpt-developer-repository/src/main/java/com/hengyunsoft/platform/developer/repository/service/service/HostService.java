package com.hengyunsoft.platform.developer.repository.service.service;

import com.hengyunsoft.base.service.normal.BaseService;
import com.hengyunsoft.platform.developer.entity.core.po.Host;
import com.hengyunsoft.platform.developer.repository.core.example.HostExample;

import java.util.List;


/**
 * @author luchanghong
 * @create 2018-04-02 15:44
 * @desc 主机管理业务层
 **/
public interface HostService  extends BaseService<Long, Host, HostExample> {

    /**
     * 查询主机数据列表
     * @param openApiReq
     * @return
     */
    List<Host> findHostList(Host openApiReq);

    /**
     * 保存主机数据
     * @param host
     * @return
     */

    Long saveHost(Host host);

    /**
     * 编辑主机数据
     * @param id
     * @return
     */

    Host editHost( Long id);

    /**
     * 主机数据提交更改
     * @param host
     */
    void editHostSubmit(Host host);

    /**
     * 删除主机数据
     * @param id
     * @return
     */

    void deleteHost(Long id);

    /**
     * 主机详情
     * @param id
     * @return
     */

    Host  detailHost(Long id);

    /**
     * 主机状态更改
     * @param host
     */
    void updateStatus(Host host);

}