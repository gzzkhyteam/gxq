package com.hengyunsoft.platform.controller;

import com.hengyunsoft.base.Result;
import com.hengyunsoft.platform.configuration.GxqptWebappConfig;
import com.hengyunsoft.platform.security.LoginInfoUtil;
import com.hengyunsoft.security.auth.api.UserApi;
import com.hengyunsoft.security.auth.dto.UserDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Slf4j
@Controller
@RequestMapping("/power")
public class PowerIndexController {
    @Autowired
    private UserApi userApi;
    @Autowired
    private GxqptWebappConfig gxqptAuthWebappConfig;

    /**
     * 所有系统的首页地址统一放在module/index
     *
     * @param model
     * @return
     */
    @RequestMapping("/main")
    public String main(ModelMap model, HttpServletRequest request) {
        UserDTO accountDTO = LoginInfoUtil.getLoginUser(request);
        model.put("user", accountDTO);
        return "module/main";
    }

    @RequestMapping("/presonList")
    public String presonList(ModelMap model) {
        return "person_manage/list";
    }

    @RequestMapping("/setUnitDep")
    public String setUnitDep(String systemCode, ModelMap model) {
        model.addAttribute("systemCode", systemCode);
        return "person_manage/setUnitDep";
    }

    @RequestMapping("/presonCreate")
    public String presonCreate(String mainorgid, String maindeptid, String systemCode, ModelMap model) {
        model.addAttribute("mainorgid", mainorgid);
        model.addAttribute("maindeptid", maindeptid);
        model.addAttribute("systemCode", systemCode);
        return "person_manage/create";
    }

    @RequestMapping("/presonEdit")
    public String presonEdit(String id, String mainorgid, String maindeptid, String systemCode, ModelMap model) {
        model.addAttribute("id", id);
        model.addAttribute("mainorgid", mainorgid);
        model.addAttribute("maindeptid", maindeptid);
        model.addAttribute("systemCode", systemCode);
        return "person_manage/edit";
    }

    @RequestMapping("/bindUser")
    public String bindUser(String id, String systemCode, ModelMap model) {
        model.addAttribute("id", id);
        model.addAttribute("systemCode", systemCode);
        return "person_manage/bindUser";
    }

    @RequestMapping("/bindUserView")
    public String bindUserView(String userId, ModelMap model) {
        model.addAttribute("userId", userId);
        return "person_manage/bindUserView";
    }

    @RequestMapping("/presonView")
    public String presonView(String id, String systemCode,String identityId, ModelMap model) {
        model.addAttribute("id", id);
        model.addAttribute("systemCode", systemCode);
        model.addAttribute("identityId", identityId);
        return "person_manage/view";
    }

    @RequestMapping("/updatePassword")
    public String updatePassword(String id, ModelMap model) {
        model.addAttribute("id", id);
        return "person_manage/updatePassword";
    }

    @RequestMapping("/resourceList")
    public String resourceList(ModelMap model) {
        return "resource_manage/list";
    }

    //体系管理页面
    @RequestMapping("/systemList")
    public String systemList(ModelMap model) {
        return "system_manage/list";
    }

    //单位管理页面
    @RequestMapping("/organList")
    public String organList(ModelMap model) {
        return "organ_manage/list";
    }

    //新增单位管理页面
    @RequestMapping("/organCreate")
    public String organCreate(ModelMap model) {
        return "organ_manage/create";
    }

    //选择单位管理员页面
    @RequestMapping("/shareIds")
    public String shareIds(String id, ModelMap model) {
        model.addAttribute("id", id);
        return "organ_manage/share_ids";
    }

    //单位管理员绑定页面
    @RequestMapping("/orgManagerIds")
    public String orgManagerIds(String orgId, ModelMap model) {
        model.addAttribute("orgId", orgId);
        return "organ_manage/bindUser";
    }

    //查看单位管理页面
    @RequestMapping("/organView")
    public String organView(String id, ModelMap model) {
        model.addAttribute("id", id);
        return "organ_manage/view";
    }

    //编辑单位管理页面
    @RequestMapping("/organEdit")
    public String organEdit(String id, ModelMap model) {
        model.addAttribute("id", id);
        return "organ_manage/edit";
    }

    //部门管理页面
    @RequestMapping("/partList")
    public String partList(ModelMap model) {
        return "part_manage/list";
    }

    //新增部门管理页面
    @RequestMapping("/partCreate")
    public String partCreate(ModelMap model) {
        return "part_manage/create";
    }

    //查看部门管理页面
    @RequestMapping("/partView")
    public String partView(String id, ModelMap model) {
        model.addAttribute("id", id);
        return "part_manage/view";
    }

    //编辑部门管理页面
    @RequestMapping("/partEdit")
    public String partEdit(String id, ModelMap model) {
        model.addAttribute("id", id);
        return "part_manage/edit";
    }

    //职务管理页面
    @RequestMapping("/dutiesList")
    public String dutiesList(ModelMap model) {
        return "duties_manage/list";
    }

    //新增职务管理页面
    @RequestMapping("/dutiesCreate")
    public String dutiesCreate(String orgid, String orgname, ModelMap model) {
        model.addAttribute("orgid", orgid);
        model.addAttribute("orgname", orgname);
        return "duties_manage/create";
    }

    //编辑职务管理页面
    @RequestMapping("/dutiesEdit")
    public String dutiesEdit(String id, String orgid, String orgname, String systemCode, ModelMap model) {
        model.addAttribute("id", id);
        model.addAttribute("orgid", orgid);
        model.addAttribute("orgname", orgname);
        model.addAttribute("systemCode", systemCode);
        return "duties_manage/edit";
    }

    //查看职务管理页面
    @RequestMapping("/dutiesView")
    public String dutiesView(String id, String systemCode, ModelMap model) {
        model.addAttribute("id", id);
        model.addAttribute("systemCode", systemCode);
        return "duties_manage/view";
    }

    //岗位管理页面
    @RequestMapping("/postList")
    public String postList(ModelMap model) {
        return "post_manage/list";
    }

    //新增岗位管理页面
    @RequestMapping("/postCreate")
    public String postCreate(String orgid, String orgname, ModelMap model) {
        model.addAttribute("orgid", orgid);
        model.addAttribute("orgname", orgname);
        return "post_manage/create";
    }

    //编辑岗位管理页面
    @RequestMapping("/postEdit")
    public String postEdit(String id, String orgid, String orgname, String systemCode, ModelMap model) {
        model.addAttribute("id", id);
        model.addAttribute("orgid", orgid);
        model.addAttribute("orgname", orgname);
        model.addAttribute("systemCode", systemCode);
        return "post_manage/edit";
    }

    //查看岗位管理页面
    @RequestMapping("/postView")
    public String postView(String id, String systemCode, ModelMap model) {
        model.addAttribute("id", id);
        model.addAttribute("systemCode", systemCode);
        return "post_manage/view";
    }

    //角色管理页面
    @RequestMapping("/roleList")
    public String roleList(ModelMap model) {
        return "role_manage/list";
    }

    //平台角色管理页面
    @RequestMapping("/ptRole")
    public String ptRole(ModelMap model) {
        model.addAttribute("appId", gxqptAuthWebappConfig.getAppId());
        return "ptRole_manage/ptRole";
    }

    //新增角色管理页面
    @RequestMapping("/roleCreate")
    public String roleCreate(String appId, ModelMap model) {
        model.addAttribute("appId", appId);
        return "role_manage/create";
    }

    @RequestMapping("/ptRoleCreate")
    public String ptRoleCreate(String appId, ModelMap model) {
        model.addAttribute("appId", appId);
        return "ptRole_manage/create";
    }

    @RequestMapping("/ptRoleEdit")
    public String ptRoleEdit(String id, ModelMap model) {
        model.addAttribute("id", id);
        return "ptRole_manage/edit";
    }

    //编辑角色管理页面
    @RequestMapping("/roleEdit")
    public String roleEdit(String appId, String id, ModelMap model) {
        model.addAttribute("appId", appId);
        model.addAttribute("id", id);
        return "role_manage/edit";
    }

    //权限配置页面
    @RequestMapping("/powerAllocation")
    public String powerAllocation(String appId, String id, ModelMap model) {
        model.addAttribute("appId", appId);
        model.addAttribute("id", id);
        return "role_manage/power_allocation";
    }
    
    //权限配置页面
    @RequestMapping("/ptPowerAllocation")
    public String ptPowerAllocation(String id, ModelMap model) {

    	model.addAttribute("id", id);
    	return "ptRole_manage/power_allocation";
    }

    //用户列表页面
    @RequestMapping("/userList")
    public String userList(String appId, String id, ModelMap model) {
        model.addAttribute("appId", appId);
        model.addAttribute("id", id);
        return "role_manage/user_list";
    }

    //分配用户页面
    @RequestMapping("/assignUser")
    public String assignUser(ModelMap model) {
        return "role_manage/assign_user";
    }

    //新增资源页面
    @RequestMapping("/resourceCreate")
    public String resourceCreate(String appId, String parentId, ModelMap model) {
        model.addAttribute("appId", appId);
        model.addAttribute("parentId", parentId);
        return "resource_manage/create";
    }

    //编辑资源页面
    @RequestMapping("/resourceEdit")
    public String resourceEdit(String appId, String id, String parentId, ModelMap model) {
        model.addAttribute("appId", appId);
        model.addAttribute("id", id);
        model.addAttribute("parentId", parentId);
        return "resource_manage/edit";
    }

    //资源详情页面
    @RequestMapping("/resourceView")
    public String resourceView(String appId, String id, String parentId, ModelMap model) {
        model.addAttribute("appId", appId);
        model.addAttribute("id", id);
        model.addAttribute("parentId", parentId);
        return "resource_manage/view";
    }

    //用户管理
    @RequestMapping("/userManage")
    public String userManage(ModelMap model) {
        return "user_manage/list";
    }

    //添加用户信息
    @RequestMapping("/userCreate")
    public String userCreate(ModelMap model) {
        return "user_manage/create";
    }

    //修改用户信息
    @RequestMapping("/userEdit")
    public String userEdit(String id, ModelMap model) {
        model.addAttribute("id", id);
        return "user_manage/edit";
    }

    //关联用户信息
    @RequestMapping("/relationUser")
    public String relationUser(String id, String systemCode, ModelMap model) {
        model.addAttribute("id", id);
        model.addAttribute("systemCode", systemCode);
        return "user_manage/relation_user";
    }

    /**
     * 用户身份设定
     *
     * @param id
     * @param systemCode
     * @param model
     * @return
     */
    @RequestMapping("/settingIdentity")
    public String settingIdentity(String id, String systemCode, ModelMap model) {
        model.addAttribute("id", id);
        model.addAttribute("systemCode", systemCode);
        return "person_manage/settingIdentity";
    }

    /**
     * 用户身份新建
     *
     * @param id
     * @param systemCode
     * @param model
     * @return
     */
    @RequestMapping("/createIdentity")
    public String createIdentity(String mainorgid, String id, String maindeptid, String systemCode, ModelMap model) {
        model.addAttribute("mainorgid", mainorgid);
        model.addAttribute("maindeptid", maindeptid);
        model.addAttribute("systemCode", systemCode);
        model.addAttribute("id", id);
        return "person_manage/createIdentity";
    }

    /**
     * 用户身份修改
     *
     * @param id
     * @param systemCode
     * @param model
     * @return
     */
    @RequestMapping("/updateIdentity")
    public String updateIdentity(String mainorgid, String id, String maindeptid, String systemCode, ModelMap model) {
        model.addAttribute("mainorgid", mainorgid);
        model.addAttribute("maindeptid", maindeptid);
        model.addAttribute("systemCode", systemCode);
        model.addAttribute("id", id);
        return "person_manage/updateIdentity";
    }

    /**
     * 用户修改重置cookie
     *
     * @param model
     * @return
     */
    @RequestMapping("/updateCookie")
    public void updateIdentity(String userId, HttpServletRequest request, HttpServletResponse response, ModelMap model) {
        Result<UserDTO> result = userApi.getById(Long.valueOf(userId));
        UserDTO user = result.getData();
        LoginInfoUtil.addLoginUser(user, request, response);
//        Cookie nameCookie = new Cookie("_user_name", user.getName());
//        Cookie photoCookie = new Cookie("_user_photo", user.getPhoto());
//
//        nameCookie.setPath("/");
//        nameCookie.setSecure(false);
//        nameCookie.setMaxAge(2 * 24 * 3600);
//        response.addCookie(nameCookie);
//
//        photoCookie.setPath("/");
//        photoCookie.setSecure(false);
//        photoCookie.setMaxAge(2 * 24 * 3600);
//        response.addCookie(photoCookie);
//
//        String userJson = JSONObject.toJSONString(user);
//        PrintWriter writer = null;
//        try {
//            writer = response.getWriter();
//            writer.print(userJson);
//            writer.flush();
//        } catch (IOException e) {
//            e.printStackTrace();
//        } finally {
//            writer.close();
//        }
    }

    //节假日元数据列表
    @RequestMapping("/hdayManageList")
    public String hdayManageList(ModelMap model) {
        return "hday_manage/list";
    }

    //节假日元数据新增
    @RequestMapping("/hdayManageCreate")
    public String hdayManageCreate(ModelMap model) {
        return "hday_manage/create";
    }

    //节假日元数据修改
    @RequestMapping("/hdayManageEdit")
    public String hdayManageEdit(String id, ModelMap model) {
        model.addAttribute("id", id);
        return "hday_manage/edit";
    }

    //节假日元数据查看
    @RequestMapping("/hdayManageView")
    public String hdayManageView(String id, ModelMap model) {
        model.addAttribute("id", id);
        return "hday_manage/view";
    }

    //节假日列表
    @RequestMapping("/hdayList")
    public String hdayList(ModelMap model) {
        return "hday/list";
    }

    //节假日新增
    @RequestMapping("/hdayCreate")
    public String hdayCreate(String date, ModelMap model) {
        model.addAttribute("date", date);
        return "hday/create";
    }

    //节假日修改
    @RequestMapping("/hdayEdit")
    public String hdayEdit(String id, String date, ModelMap model) {
        model.addAttribute("id", id);
        model.addAttribute("date", date);
        return "hday/edit";
    }

    //节假日详情
    @RequestMapping("/hdayView")
    public String hdayView(String id, ModelMap model) {
        model.addAttribute("id", id);
        return "hday/view";
    }

    //地区信息维护列表
    @RequestMapping("/regionList")
    public String regionList(ModelMap model) {
        return "regionInfo/list";
    }

    //地区信息维护新增
    @RequestMapping("/regionCreate")
    public String regionCreate(String parentId, String fullNameString, ModelMap model) {
        model.addAttribute("parentId", parentId);
        model.addAttribute("fullNameString", fullNameString);
        return "regionInfo/create";
    }

    //地区信息维护编辑
    @RequestMapping("/regionEdit")
    public String regionEdit(String id, String fullNameString, ModelMap model) {
        model.addAttribute("id", id);
        model.addAttribute("fullNameString", fullNameString);
        return "regionInfo/edit";
    }

    //地区信息维护详情
    @RequestMapping("/regionView")
    public String regionView(String id, ModelMap model) {
        model.addAttribute("id", id);
        return "regionInfo/view";
    }

    //类型信息维护列表
    @RequestMapping("/typeList")
    public String typeList(ModelMap model) {
        return "typeInfo/list";
    }

    //类型信息维护编辑
    @RequestMapping("/typeAdd")
    public String typeAdd(ModelMap model) {
        return "typeInfo/typeAdd";
    }

    //类型信息维护编辑
    @RequestMapping("/typeEdit")
    public String typeEdit(String id, ModelMap model) {
        model.addAttribute("id", id);
        return "typeInfo/typeEdit";
    }

    //类型信息维护条目列表
    @RequestMapping("/typeCatalogList")
    public String typeCatalogList(String id, ModelMap model) {
        model.addAttribute("id", id);
        return "typeInfo/typeCatalogList";
    }

    //类型信息维护条目新增
    @RequestMapping("/typeCatalogAdd")
    public String typeCatalogAdd(ModelMap model) {
        return "typeInfo/typeCatalogAdd";
    }

    //类型信息维护条目编辑
    @RequestMapping("/typeCatalogEdit")
    public String typeCatalogEdit(String id, ModelMap model) {
        model.addAttribute("id", id);
        return "typeInfo/typeCatalogEdit";
    }

    //类型信息维护条目查看
    @RequestMapping("/typeCatalogView")
    public String typeCatalogView(String id, ModelMap model) {
        model.addAttribute("id", id);
        return "typeInfo/typeCatalogView";
    }
}
