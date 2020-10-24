package com.hengyunsoft.platform.mail.repository.core.service.impl;

import com.hengyunsoft.base.dao.BaseNormalDao;
import com.hengyunsoft.base.service.impl.BaseServiceImpl;
import com.hengyunsoft.platform.mail.entity.core.po.CustomFile;
import com.hengyunsoft.platform.mail.repository.core.dao.CustomFileMapper;
import com.hengyunsoft.platform.mail.repository.core.example.CustomFileExample;
import com.hengyunsoft.platform.mail.repository.core.service.CustomFileApiService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * 版权：中科恒运软件科技股份有限公司贵阳分公司
 * 描述：自定义文件夹impl
 * 修改人：wt
 * 修改时间：2018/7/30
 * 修改内容：
 */
@Service
@Slf4j
public class CustomFileApiServiceImpl extends BaseServiceImpl<Long, CustomFile, CustomFileExample> implements CustomFileApiService {

    @Autowired
    CustomFileMapper customFileMapper;


    @Override
    protected BaseNormalDao<Long,CustomFile, CustomFileExample> getDao() {
        return customFileMapper;
    }
}
