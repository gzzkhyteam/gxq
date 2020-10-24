package com.hengyunsoft.platform.developer.repository.apply.service;

import com.hengyunsoft.base.service.normal.BaseService;
import com.hengyunsoft.platform.developer.entity.service.po.ServiceResourceDoc;
import com.hengyunsoft.platform.developer.repository.service.example.ServiceResourceDocExample;

public interface ServiceResourceDocService extends BaseService<Long, ServiceResourceDoc, ServiceResourceDocExample>{

    /**
     * 描述：根据id查询服务资源文档Api
     * 参数：id
     * 返回值：ServiceResourceDocDTO
     * 修改人：sunxiaoya
     * 修改时间：2018/4/4
     * 修改内容：
     */
    ServiceResourceDoc getByModuleId(Long moduleId);
}
