package com.hengyunsoft.platform.admin.repository.core.service.impl;


import com.hengyunsoft.base.dao.BaseNormalDao;
import com.hengyunsoft.base.service.impl.BaseServiceImpl;
import com.hengyunsoft.platform.admin.entity.core.po.LoginLogs;
import com.hengyunsoft.platform.admin.repository.core.dao.LoginLogsMapper;
import com.hengyunsoft.platform.admin.repository.core.example.LoginLogsExample;
import com.hengyunsoft.platform.admin.repository.core.service.LoginLogsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class LoginLogsServiceImpl extends BaseServiceImpl<Long, LoginLogs, LoginLogsExample> implements LoginLogsService {

	@Autowired
	LoginLogsMapper loginLogsMapper;
	@Override
	protected BaseNormalDao<Long, LoginLogs, LoginLogsExample> getDao() {
		return loginLogsMapper;
	}

    /**
     *  查询  访问用户数就是当天的登录次数,停留时间就是退出时间减去登录时间总和
     * @param nowDay
     * @param nextDay
     * @return
     */
    @Override
    public Map<String,String> getLoginAskCount(String nowDay, String nextDay) {
        return loginLogsMapper.getLoginAskCount(nowDay,nextDay);
    }

    /**
     * 查询 活跃用户数就是当天的登录用户数
     * @param nowDay
     * @param nextDay
     * @return
     */
    @Override
    public int getLoginCount(String nowDay, String nextDay) {
        return loginLogsMapper.getLoginCount(nowDay, nextDay);
    }

	@Override
	public int updateByMasterLoginIdSelective(LoginLogs entity) {
		
		if(entity == null || entity.getMasterLoginId() == null) {
			return 0;
		}
		
		
		LoginLogsExample example = new LoginLogsExample();
		example.createCriteria().andMasterLoginIdEqualTo(entity.getMasterLoginId());
		return loginLogsMapper.updateByExampleSelective(entity, example );
	}

	@Override
	public LoginLogs saveLogSetMasterLogId(LoginLogs loginLog) {
		
		if(loginLog.getMasterLoginIs()) {
			loginLog.setId(genId());
			loginLog.setMasterLoginId(loginLog.getId());
			getDao().insert(loginLog);
			return loginLog;
		} else {
			return save(loginLog);
		}
	}

	@Override
	public List<LoginLogs> findByAppIdAndLoginDate(String appId, String beginDate) {
		return loginLogsMapper.findByAppIdAndLoginDate(appId, beginDate);
	}
}
