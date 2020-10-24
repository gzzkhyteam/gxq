package com.hengyunsoft.platform.developer.repository.apply.service.impl;

import com.hengyunsoft.base.dao.BaseNormalDao;
import com.hengyunsoft.base.service.impl.BaseServiceImpl;
import com.hengyunsoft.platform.developer.entity.service.po.ServiceResource;
import com.hengyunsoft.platform.developer.repository.apply.service.ServiceResourceService;
import com.hengyunsoft.platform.developer.repository.service.dao.ServiceResourceMapper;
import com.hengyunsoft.platform.developer.repository.service.example.ServiceResourceExample;
import lombok.extern.slf4j.Slf4j;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
@Slf4j
public class ServiceResourceServiceImpl
        extends BaseServiceImpl<Long, ServiceResource, ServiceResourceExample>
        implements ServiceResourceService {

        @Autowired
        private ServiceResourceMapper serviceResourceMapper;

        @Override
        protected BaseNormalDao<Long, ServiceResource, ServiceResourceExample> getDao() {
            return serviceResourceMapper;
        }

        @Override
        public List<ServiceResource> getByModuleId(Long moduleId) {
                return serviceResourceMapper.getByModuleId(moduleId);
        }

		@Override
		public List<ServiceResource> getServiceAllPublicUrlsUsableByAppId(String appId) {
			return serviceResourceMapper.getServiceResourceOfAppUsable(true,appId);
		}

		@Override
		public List<ServiceResource> getServiceResourceOfAppPrivateUsable(String appId) {
			
			return serviceResourceMapper.getServiceResourceOfAppUsable(false,appId);
		}

		@Override
		public List<ServiceResource> getServiceResourceOfAppConsumer(List<String> appIds, String likeResourceName) {

			if(appIds == null || appIds.size()==0) {
				return Collections.EMPTY_LIST ;
			}
			if(StringUtils.isEmpty(likeResourceName)) {
				likeResourceName = null;
			}
			return serviceResourceMapper.getServiceResourceOfAppConsumer(appIds,likeResourceName);
		}
}
