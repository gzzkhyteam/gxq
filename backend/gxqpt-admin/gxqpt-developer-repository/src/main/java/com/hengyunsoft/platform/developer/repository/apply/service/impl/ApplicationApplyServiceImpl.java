package com.hengyunsoft.platform.developer.repository.apply.service.impl;

import com.github.pagehelper.PageHelper;
import com.hengyunsoft.base.dao.BaseNormalDao;
import com.hengyunsoft.base.service.impl.BaseServiceImpl;
import com.hengyunsoft.page.PageRequest;
import com.hengyunsoft.platform.developer.entity.apply.po.Application;
import com.hengyunsoft.platform.developer.entity.apply.po.ApplicationApply;
import com.hengyunsoft.platform.developer.entity.apply.po.domain.ApplyQueryDO;
import com.hengyunsoft.platform.developer.repository.apply.dao.ApplicationApplyMapper;
import com.hengyunsoft.platform.developer.repository.apply.dao.ApplicationMapper;
import com.hengyunsoft.platform.developer.repository.apply.example.ApplicationApplyExample;
import com.hengyunsoft.platform.developer.repository.apply.example.ApplicationExample;
import com.hengyunsoft.platform.developer.repository.apply.service.ApplicationApplyService;
import com.hengyunsoft.platform.developer.utils.UUIDUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

@Service
public class ApplicationApplyServiceImpl extends BaseServiceImpl<Long, ApplicationApply, ApplicationApplyExample> implements ApplicationApplyService {
    @Autowired
    private ApplicationApplyMapper mapper;
    @Autowired
    private ApplicationMapper applicationMapper;
    @Override
    protected BaseNormalDao<Long, ApplicationApply, ApplicationApplyExample> getDao() {
        return this.mapper;
    }
    /**
     * 检测appid是否存在
     *
     * @param appId
     * @return 存在返回true 不存在返回false
     */
    public boolean check(String appId) {
        ApplicationApplyExample example = new ApplicationApplyExample();
        example.createCriteria().andAppIdEqualTo(appId);
        int count = mapper.countByExample(example);
        if (count > 0) {
            return true;
        }
        return false;
    }

    /**
     * 生成appid， 并且检测数据库中是否存在，存在则重新生成， 最多重新生成3次
     *
     * @return
     */
    private String generateAppId() {
        String appId = UUIDUtils.generateShortUuid();
        for (int i = 0; check(appId) && i < 3; i++) {
        }
        return appId;
    }

    /**
     * 保存
     * @param app
     * @return
     */
    @Override
    public ApplicationApply saveApp(ApplicationApply app) {
        app.setAppId(generateAppId());
        app.setAppSecret(UUIDUtils.generateUuid());
        return super.save(app);
    }
    @Override
    public List<ApplyQueryDO> queryMyTask(String moduleName,String appName,String moduleId, String auditStatus, List<String> appIds, String taskType, String taskRole,
                                          Boolean auditApp2ModelAdd,Long applyUser,PageRequest page) {

    	PageHelper.startPage(page.getPageNo(), page.getPageSize());
        List<ApplyQueryDO> applyQueryDOs =  mapper.queryMyTask(moduleName,appName,moduleId, auditStatus, appIds, taskType, taskRole, auditApp2ModelAdd,applyUser);
        if(!CollectionUtils.isEmpty(applyQueryDOs)) {
            putAppName(applyQueryDOs);
        }
        return applyQueryDOs;
    }
    /**
     * 注入app应用名称
     * @param applyQueryDOs
     */
    private void putAppName(List<ApplyQueryDO> applyQueryDOs) {

        List<String> appIds = new ArrayList<String>(applyQueryDOs.size());

        for (ApplyQueryDO queryDO : applyQueryDOs) {
            if(!StringUtils.isEmpty(queryDO.getAppId())) {
                appIds.add(queryDO.getAppId());
            }
        }
        if(CollectionUtils.isEmpty(appIds)) {
            return ;
        }
        ApplicationExample example = new ApplicationExample();
        example.or().andAppIdIn(appIds);
        List<Application> applications = applicationMapper.selectByExample(example );

        if(CollectionUtils.isEmpty(applications)) {
            return ;
        }

        for (ApplyQueryDO applicationDO : applyQueryDOs) {
            String appId = applicationDO.getAppId();
            for (Application application : applications) {
                if(application.getAppId().equals(appId)) {
                    applicationDO.setAppName(application.getName());
                    break;
                }
            }
        }
    }
    
    
}
