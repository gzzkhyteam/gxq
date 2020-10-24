package com.hengyunsoft.platform.admin.account;

import com.hengyunsoft.commons.utils.context.DozerUtils;
import com.hengyunsoft.platform.admin.api.authority.dto.resource.ResourceTreeDto;
import com.hengyunsoft.platform.admin.entity.core.domain.ResourceDO;
import com.hengyunsoft.platform.admin.entity.core.po.Resource;
import com.hengyunsoft.platform.admin.entity.org.gxqpt.po.GxqptEmp;
import com.hengyunsoft.platform.admin.entity.org.gxqpt.po.GxqptOrg;
import com.hengyunsoft.platform.admin.entity.org.sdzzww.po.SdzzwwEmp;
import com.hengyunsoft.platform.admin.repository.core.dao.ResourceMapper;
import com.hengyunsoft.platform.admin.repository.core.example.ResourceExample;
import com.hengyunsoft.platform.admin.repository.org.gxqpt.dao.GxqptEmpMapper;
import com.hengyunsoft.platform.admin.repository.org.gxqpt.dao.GxqptOrgMapper;
import com.hengyunsoft.platform.developer.repository.apply.service.ApplicationService;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author tyh
 * @createTime 2018-01-02 15:03
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@Slf4j
public class AdminServiceTest {
    @Autowired
    private ApplicationService applicationService;
    @Autowired
    private ResourceMapper resourceMapper;
    @Autowired
    private DozerUtils dozerUtils;
    @Autowired
    private GxqptOrgMapper gxqptOrgMapper;
    @Autowired
    private GxqptEmpMapper gxqptEmpMapper;

    @Test
    public void test2(){
        GxqptOrg org= new GxqptOrg();
        org.setName("张三%a");
        List<GxqptOrg> gxqptOrgs = gxqptOrgMapper.selectLikeAppByShare(org, 1L, "25kj6355");

        System.out.println("aaa" + gxqptOrgs.size());
    }

    @Test
    public void test3(){

        GxqptEmp emp = new GxqptEmp();
        emp.setName("aaa%sd");
        List<? extends SdzzwwEmp> list = gxqptEmpMapper.findIdentityEmpList(emp);

        System.out.println("size=" + list.size());

    }

    //@Test
    //public void saveTest(){
    //    Admin admin = new Admin();
    //    admin.setPassword("123456");
    //    admin.setUsername("test1");
    //    admin.setAppId("zkhyiGC1g4eZ");
    //    adminService.save(admin);
    //}
    //@Test
    //public void saveSelectiveTest(){
    //    Admin admin = new Admin();
    //    admin.setPassword("123456");
    //    admin.setUsername("test2");
    //    admin.setAppId("zkhyiGC1g4eZ");
    //    adminService.saveSelective(admin);
    //}
}
