package com.hengyunsoft.platform.open.impl.utils;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * @author tyh
 * @createTime 2017-11-23 14:58
 */
//@RunWith(SpringJUnit4ClassRunner.class)
//@SpringBootTest
@Slf4j
public class TestCopy {

    //@Autowired
    //RoleService roleService;

    @Test
    public void testLog() throws Exception{
        log.error("-------------------------error");
        log.warn("-------------------------warn");
        log.info("-------------------------info");
        log.debug("-------------------------debug");
        log.trace("-------------------------trace");

        //ObjectMapper mapper = new ObjectMapper();
        //Admin admin = new Admin();
        //admin.setIsEnable(true);
        //admin.setCreateTime(new Date());
        //admin.setDescription("年后斯蒂芬");
        //admin.setUsername("asdf");

        //String username = JSONObject.toJSONString(admin);
        //admin = new Admin();
        //admin.setIsEnable(true);
        //admin.setCreateTime(new Date());
        //admin.setDescription("年后斯蒂芬");
        //admin.setUsername(username);
        //System.out.println(mapper.writeValueAsString(admin));
        //System.out.println(JSONObject.toJSONString(admin));
        //
        //Result<Admin> r = Result.success(admin);
        //System.out.println(mapper.writeValueAsString(r));
        //System.out.println(JSONObject.toJSONString(r));
    }

    //@Test
    //public void testRemove() throws Exception{
    //    List<Long> list = new ArrayList<>();
    //    list.add(1L);
    //    roleService.removeByIds(list);
    //}
    //
    //@Test
    //public void testDelete(){
    //    List<Long> list = new ArrayList<>();
    //    list.add(4L);
    //    roleService.deleteByIds(list);
    //
    //
    //    RoleExample example = new RoleExample();
    //    example.createCriteria().andIdEqualTo(3L);
    //    roleService.delete(example);
    //}
    //
    //@Test
    //public void testUpdate(){
    //    Role role= new Role();
    //    role.setId(3L);
    //    role.setAppId("22");
    //    role.setCode("test update");
    //    role.setName("test update");
    //    role.setParentId(-1L);
    //    List<Role> list = new ArrayList<>();
    //    list.add(role);
    //    roleService.updateById(list);
    //
    //
    //    role= new Role();
    //    role.setId(4L);
    //    role.setAppId("3");
    //    role.setCode("test update");
    //    role.setName("test update");
    //    role.setParentId(-1L);
    //     list = new ArrayList<>();
    //    list.add(role);
    //    roleService.updateByIdSelective(list);
    //}
    //
    //@Test
    //public void testSave(){
    //    Role role= new Role();
    //    role.setAppId("1");
    //    role.setCode("test");
    //    role.setName("test");
    //    role.setParentId(-1L);
    //    List<Role> list = new ArrayList<>();
    //    list.add(role);
    //    roleService.save(list);
    //    System.out.println(JSONObject.toJSONString(list));
    //
    //    role= new Role();
    //    role.setAppId("1");
    //    role.setCode("test");
    //    role.setDescription("test");
    //    role.setParentId(-1L);
    //    roleService.saveSelective(role);
    //
    //    System.out.println(role.getId());
    //
    //}
    //
    //@Test
    //public void testGetRole() {
    //    log.error("-------------------------error");
    //    log.warn("-------------------------warn");
    //    log.info("-------------------------info");
    //    log.debug("-------------------------debug");
    //    log.trace("-------------------------trace");
    //
    //    Role role = roleService.getById(1L);
    //    System.out.println(role.getAppId());
    //
    //    Role appIdRole = roleService.getByAppIdAndId("1", 1L);
    //    System.out.println(appIdRole.getName());
    //
    //    RoleExample example = new RoleExample();
    //    example.createCriteria().andAppIdEqualTo("1").andCodeEqualTo("admin").andPathEqualTo(",");
    //    example.setOrderByClause("create_time desc");
    //    Role unique = roleService.getUnique(example);
    //    System.out.println(unique != null ? unique.getAppId() : "null");
    //
    //    //log.info("-------------------------info");
    //}

}
