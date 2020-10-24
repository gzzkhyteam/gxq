package com.hengyunsoft.platform.developer.repository.service.service.impl;

import com.hengyunsoft.base.dao.BaseNormalDao;
import com.hengyunsoft.base.service.impl.BaseServiceImpl;
import com.hengyunsoft.commons.context.BaseContextHandler;
import com.hengyunsoft.platform.developer.entity.core.po.Host;
import com.hengyunsoft.platform.developer.repository.core.dao.HostMapper;
import com.hengyunsoft.platform.developer.repository.core.example.HostExample;
import com.hengyunsoft.platform.developer.repository.service.service.HostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;


/**
 * @author luchanghong
 * @create 2018-04-02 15:49
 * @desc 主机管理业务实现层
 **/
@Service
public class HostServiceImpl extends BaseServiceImpl<Long, Host, HostExample> implements HostService {

    @Autowired
    private HostMapper hostMapper;


    @Override
    protected BaseNormalDao getDao() {
        return hostMapper;
    }

    /**
     * 查询主机列表数据
     * @param host
     * @return
     */
    @Override
    public List<Host> findHostList(Host host) {
    	Long adminId = BaseContextHandler.getAdminId();
    	if(host==null){
    	    host = new Host();
        }
        return hostMapper.findHostList(host,adminId);
    }

    /**
     * 保存主机数据
     * @param host
     */
    @Override
    public Long saveHost(Host host) {
        Long id =null;
        if(host!=null){
        host.setId(genId());
        host.setCreateTime(new Date());
        host.setCreateUser(BaseContextHandler.getAdminId());
        hostMapper.insertSelective(host);
        id= host.getId();

        }
        return id;
    }

    /**
     * 查询主机数据（用于编辑）
     * @param id
     * @return
     */
    @Override
    public Host editHost(Long id) {
        Host host=null;
        if (id!=0){
            host = hostMapper.selectByPrimaryKey(id);
        }
        return host;
    }

    /**
     * 主机数据编辑提交
     * @param host
     */
    @Override
    public void editHostSubmit(Host host) {
        if (host!=null){
            host.setUpdateTime(new Date());
            host.setUpdateUser(BaseContextHandler.getAdminId());
            hostMapper.updateByPrimaryKeySelective(host);
       }
    }

    /**
     * 主机数据删除
     * @param id
     */
    @Override
    public void deleteHost(Long id) {
        if (id!=0){
            hostMapper.deleteByPrimaryKey(id);
         }
    }

    /**
     * 主机详情
     * @param id
     * @return
     */
    @Override
    public Host detailHost(Long id) {
        Host host=null;
        if(id!=0){
            host = hostMapper.selectByPrimaryKey(id);
        }
        return host;
    }

    /**
     * 主机状态更改
     * @param host
     */
    @Override
    public void updateStatus(Host host) {
        if (host!=null){
            hostMapper.updateByPrimaryKeySelective(host);
        }else {
            throw new RuntimeException("状态不能为空");
        }
    }
}