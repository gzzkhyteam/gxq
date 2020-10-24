package com.hengyunsoft.commons.exception.core;

import com.hengyunsoft.exception.code.BaseExceptionCode;

/**
 * 权限服务（gxqpt-admin项目）相关的异常代码
 * 50000-59999
 */
public enum  AuthorityExceptionCode implements BaseExceptionCode {
    //权限相关 start
    CLIENT_FORBIDDEN(50001, "客户端被禁止!"),
    USER_NAME_PWD_ERROR(50002, "帐号或者密码错误"),
    USER_NAME_EXIST(50003, "帐号已存在"),
    USER_NOT_EXIST(50004, "帐号不存在"),
    USER_UNLOGIN(50005, "用户未登录"),
    USER_LOGIN_DISABLE(50006, "账号已禁用"),
    //权限相关 end

    //资源管理相关 start
    MENU_GROUP_NULL(51000, "菜单组不能为空"),
    MENU_GROUP_CODE_EMPTY(51001, "菜单组编码不能为空"),
    MENU_GROUP_EXIST(51002, "菜单组CODE已存在"),
    MENU_GROUP_TOO_MUCH(51003, "菜单组最多只能创建20个"),
    MENU_GROUP_ID_NULL(51004, "菜单组id不能为空"),
    MENU_GROUP_EXIST_CHILD(51005, "该菜单组存在子菜，无法删除"),

    MENU_NULL(51100, "菜单不能为空"),
    MENU_CODE_EMPTY(51101, "菜单编码[code]不能为空"),
    MENU_TYPE_EMPTY(51102, "菜单类型[type]不能为空"),
    MENU_GROUP_NOT_EXIST(51103, "菜单组编码[code]不存在"),
    MENU_TOO_MUCH(51104, "每组菜单最多只能创建500个"),
    MENU_ID_NULL(51105, "菜单[id]不能为空"),
    MENU_EXIST_CHILD(51106, "该菜单存在子菜单或子资源，无法删除"),

    RESOURCES_NULL(51200, "资源信息不能为空"),
    RESOURCES_CODE_EMPTY(51201, "资源编码[code]不能为空"),
    RESOURCES_MENU_ID_NULL(51202, "资源菜单id[menuId]不能为空"),
    RESOURCES_TYPE_NULL(51203, "资源类型[type]不能为空"),
    RESOURCES_EXIST(51204, "菜单/资源编码[code]已存在"),
    RESOURCES_ID_NULL(51205, "资源id[id]不能为空"),
    MENU_NOT_EXIST(51206, "资源所属菜单不存在"),
    RESOURCES_NAME_NULL(51207, "资源菜单名称[name]不能为空"),
    RESOURCES_NAME_EXIST(51208, "资源菜单名称已经存在"),
    RESOURCES_APP_ID_NULL(51209, "资源应用Id不能为空"),
    RESOURCES_DRAG_EXIST(51210, "拖动位置不正确"),
    RESOURCES_DRAG_ID_EXIST(51211, "获取当前拖动资源不正确"),

    //资源管理相关 end

    //角色管理相关 start
    ROLE_NULL(52000, "角色信息不能为空"),
    ROLE_CODE_EMPTY(52001, "角色编码不能为空"),
    ROLE_CODE_EXIST(52002, "角色编码已存在"),
    ROLE_ID_NULL(52003, "角色id不能为空"),
    ROLE_NAME_NULL(52004,"角色名称不能为空"),
    ROLE_RESOURCE_ID_NULL(52005,"关联资源不能为空"),
    ROLE_USER_ID_NULL(52006,"关联用户ID不能为空"),
    ROLE_APP_ID_NULL(52007,"角色应用ID不能为空"),
    ROLE_READONLY(52008,"角色为只读，不可以编辑"),
    DEPART_USER_NOT_EXIST(53509, "该角色对应的用户找不到"),
    ROLE_NAME_EXIST(52010,"角色名称已经存在"),
    ROLE_NOT_UNIQUE(52011,"角色code在该App下不唯一"),
    ROLE_NOT_EXIST(52012,"角色不存在"),

    //角色管理相关 end

    //帐号管理相关 start
    USER_EXIST(53000, "登录名username已存在"),
    USER_ID_NULL(53001, "用户id不能为空"),
    USER_NAME_EMPTY(53002, "登录名username不能为空"),
    USER_PWD_EMPTY(53003, "密码不能为空"),
    USER_PWD_NOT_EQUALS(53004, "密码与确认密码不一致"),
    USER_NULL(53005, "用户信息不能为空"),
    USER_NAME_NULL(53006, "用户姓名不能为空"),
    USER_PHONE_NULL(53007, "手机不能为空"),
    USER_LOGINABLE_NULL(53008, "登录状态不能为空"),
    USER_WORK_DESC_NULL(53009, "工作描述不能为空"),
    USER_OLDPSW_NULL(53010, "原始密码不能为空"),
    USER_NEWPSW_NULL(53011, "新密码不能为空"),
    USER_TRUEPSW_NULL(53012, "确认密码不能为空"),
    USER_ACCOUNT_NULL(53013, "账号不能为空"),

    DEPART_EXIST(53501, "部门code已存在"),
    DEPART_NULL(53502, "部门信息不能为空"),
    DEPART_ID_NULL(53503, "部门id不能为空"),
    DEPART_CODE_EMPTY(53504, "部门code不能为空"),
    DEPART_CODE_EXIST(53505, "部门code已经存在"),
    DEPART_PARENT_NOT_EXIST(53506, "父部门不存在"),
    //帐号管理相关 end


    //base 包 start
    //数据字典相关 start
    DICTIONARY_TYPE_NULL(54000, "数据字典类型不能为空"),
    DICTIONARY_TYPE_ID_NULL(54001, "数据字典类型id不能为空"),
    DICTIONARY_TYPE_CODE_EMPTY(54002, "数据字典编码不能为空"),
    DICTIONARY_TYPE_CODE_EXIST(54003, "数据字典编码不能重复"),
    DICTIONARY_TYPE_EXIST(54004, "数据字典类型不存在"),

    DICTIONARY_NULL(54500, "数据字典不能为空"),
    DICTIONARY_ID_NULL(54501, "数据字典id不能为空"),
    DICTIONARY_CODE_EMPTY(54502, "数据字典code不能为空"),
    DICTIONARY_CODE_EXIST(54503, "数据字典code不能重复"),
    //数据字典相关 end

    //地区名称信息相关 start
    AREA_ID_NULL(55000, "地区id不能为空"),
    AREA_NAME_NULL(55001, "地区名称不能为空"),
    AREA_FULLNAME_NULL(55002, "地区全称不能为空"),
    AREA_PARENTID_NULL(55003, "地区父id不能为空"),
    AREA_PARENT_NULL(55004, "父地区不能为空"),
    AREA_CODE_NULL(55005, "地区编码不能为空"),
    AREA_CODE_EXIST(55006, "地区编码已存在"),
    AREA_NAME_ERROR(55007, "地区名称不能以数字开头且不应包含空格"),
    //地区名称信息相关 end

    //节假日元数据信息相关 start
    HOLIDAY_ID_NULL(55500, "节假日id不能为空"),
    HOLIDAY_NAME_NULL(55501, "节假日名称不能为空"),
    HOLIDAY_NUMBER_NULL(55502, "节假日编码不能为空"),
    HOLIDAY_NUMBER_EXSIST(55503, "节假日编码不能重复"),
    HOLIDAY_NULL(55504, "节假日信息不能为空"),
    HOLIDAY_STARTTIME_NULL(55505, "节假日开始日期不能为空"),
    HOLIDAY_ENDTIME_NULL(55506, "节假日结束日期不能为空"),
    HOLIDAY_YEAR_NULL(55507, "节假日年不能为空"),
    HOLIDAY_STARTDATE_NULL(55508, "节假日开始月日不能为空"),
    HOLIDAY_DAYS_NULL(55509, "节假日天数不能为空"),
    //节假日元数据信息相关 end
    //base 包 end

    //人员,职位,单位,部门信息  start
    GXQPT_EMP_NULL(56000,"人员不能为空"),
    GXQPT_EMP_ID(56001,"人员ID不能为空"),
    GXQPT_EMP_PASSWORD(56002,"人员密码不能为空"),
    GXQPT_DUTIES_NULL(56003,"职务信息不能为空"),
    GXQPT_DUTIES_ID_EMPTY(56004,"职务ID不能为空"),
    GXQPT_POST_NULL(56005,"岗位信息不能为空"),
    GXQPT_POST_ID_EMPTY(56006,"岗位ID不能为空"),
    GXQPT_ORG_NULL(56007,"单位不能为空"),
    GXQPT_ORG_ID(56008,"单位id不能为空"),
    GXQPT_ORG_NAME(56009,"单位名称不能为空"),
    GXQPT_DPM_NULL(56010,"部门不能为空"),
    GXQPT_DPM_ID(56011,"部门id不能为空"),
    GXQPT_DPM_NAME(56012,"部门名称不能为空"),
    GXQPT_DPM_PARENT(56013,"上级部门不能为空"),
    SYSTEMCODE(56014,"体系结构代码不能为空"),
    GXQPT_ORG_PARENT(56015,"上级单位不能为空"),
    GXQPT_ORG_ORGADMIN(56016,"单位管理员不能为空"),
    GXQPT_ORG_FORTYPE(56017,"所属类型不能为空"),
    GXQPT_ORG_FORCLASS(56018,"所属级别不能为空"),
    GXQPT_ORG_FORINDUSTRY(56019,"所属系统不能为空"),
    GXQPT_ORG_FORGK(56020,"单位归口不能为空"),
    GXQPT_ORG_STATUS(56021,"状态不能为空"),
    GXQPT_ORG_FORNODETYPE(56022,"节点不能为空"),
    GXQPT_ORG_ISENABLE(56023,"启用标记不能为空"),
    GXQPT_DPM_ORGADMIN(56024,"部门管理员不能为空"),
    GXQPT_DPM_EMPBINDUSER(56025,"用户id不能为空"),
    GXQPT_APP_NULL(56034,"应用不能为空"),
    GXQPT_APP_ID(56035,"应用id不能为空"),
    GXQPT_APP_NAME(56036,"应用名称不能为空"),
    GXQPT_EMP_NAME(56045,"人员姓名不能为空"),
    GXQPT_EMP_NIKENAME(56046,"人员登陆名不能为空"),
    GXQPT_EMP_MAINMOBILE(56047,"手机1不能为空"),
    GXQPT_EMP_EMPNO_REPEAT(56048,"统一人员编码不能重复"),


    //人员身份 start
    GXQPT_EMP_IDENTITY_NULL(56026,"人员身份不能为空"),
    GXQPT_EMP_IDENTITY_ID(56027,"人员身份ID不能为空"),
    GXQPT_EMP_IDENTITY_ISENABLE(56028,"人员身份是否启用不能为空"),
    GXQPT_POST_EMPTY_NAME(56029,"岗位名称不能为空"),
    GXQPT_DUTIES_NAME_EMPTY(56030,"职务名称不能为空"),
    GXQPT_EMP_ACCOUNT(56031,"登陆账号不能为空"),
    GXQPT_XLS_ERROR(56032,"这个东西在导入EXCEL的时候会重置内容"),
    GXQPT_EMPXLS_ERROR(56033,"导入格式不正确，请按正确格式进行导入！"),
    //人员身份 end

    //人员,职位,单位,部门信息 end


    // 快捷入口  start
    FSAT_ENTRY_NULL(57000, "快捷入口信息不能为空"),
    FSAT_ENTRY_ID_NULL(57001, "快捷入口ID不能为空"),
    RESOURCES_FSAT_ENTRY_EXIST(57002, "当前用户快捷入口已经存在"),
    FSAT_ENTRY_URL_NULL(57003, "快捷入口地址不能为空"),
    FSAT_ENTRY_ICON_NULL(57004, "快捷入口图标不能为空"),
    FSAT_ENTRY_APP_ID_NULL(57005, "快捷入口应用ID不能为空"),
    FSAT_ENTRY_RESOURCE_ID_NULL(57006, "快捷入口资源ID不能为空"),
    // 快捷入口  end

    //应用 start
    APPLICATION_NAME_NULL(57500,"应用名称不能为空"),
    APPLICATION_ID_NULL(57501,"应用id不能为空"),
    //应用 end

    //功能类型维护 start
    MODULE_NAME_NULL(58000,"功能名称不能为空"),
    MODULE_CODE_NULL(58001,"功能类型编码不能为空"),
    MODULE_DESCRIPTION_NULL(58002,"功能描述不能为空"),
    MODULE_ID_NULL(58003,"功能类型ID不能为空"),
    MODULE_TYPECODE_NULL(58004,"类型编码不能为空"),
    //功能类型维护 end

    //我的任务列表维护 start
    APPLYMANAGER_ID_NULL(58501, "类型的ID不能为空"),
    APPLYMANAGER_TASKTYPE_NULL(58502,"任务类型不能为空"),
    APPLYMANAGER_AUDITDESC_NULL(58503,"批注不能为空"),
    //我的任务列表维护 end

    ;

    private int code;
    private String msg;

    AuthorityExceptionCode(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    @Override
    public int getCode() {
        return code;
    }

    @Override
    public String getMsg() {
        return msg;
    }
}
