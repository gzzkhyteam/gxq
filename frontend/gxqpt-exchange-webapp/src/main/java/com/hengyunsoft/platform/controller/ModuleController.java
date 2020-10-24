package com.hengyunsoft.platform.controller;

import com.hengyunsoft.platform.security.LoginInfoUtil;
import com.hengyunsoft.security.auth.dto.UserDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
@RequestMapping("module")
public class ModuleController {
    /**
     * 所有系统的首页地址统一放在module/index
     *
     * @return
     */
    @RequestMapping("/index")
    public String index(ModelMap model, HttpServletRequest request) {
        UserDTO accountDTO = LoginInfoUtil.getLoginUser(request);
        model.put("user", accountDTO);
        return "module/index";
    }

    @RequestMapping("qualityControl")
    public String qualityControl() throws IOException {
        return "/module/qualityControlList";
    }

    @RequestMapping("/home")
    public String home(ModelMap model) {
        return "module/home";
    }

    /**
     * 目录管理— 数据目录管理（单位管理员）
     *
     * @return
     */
    @RequestMapping("/dataCatalogManage")
    public String dataCatalogManage(ModelMap model) {
        return "catalogManage/dataCatalogManage";
    }

    /**
     * 目录管理—新增单位信息
     *
     * @return
     */
    @RequestMapping("/createUnit")
    public String createUnit(ModelMap model) {
        return "catalogManage/createUnit";
    }

    /**
     * 目录管理—单位信息编辑
     *
     * @return
     */
    @RequestMapping("/editUnit")
    public String editUnit(String id, String dirCode, ModelMap model) {
        model.addAttribute("id", id);
        model.addAttribute("dirCode", dirCode);
        return "catalogManage/editUnit";
    }

    /**
     * 目录管理—新增目录信息
     *
     * @return
     */
    @RequestMapping("/createCatalog")
    public String createCatalog(String id, String unitId, ModelMap model) {
        model.addAttribute("id", id);
        model.addAttribute("unitId", unitId);
        return "catalogManage/createCatalog";
    }

    /**
     * 目录管理—目录信息编辑
     *
     * @return
     */
    @RequestMapping("/editCatalog")
    public String editCatalog(String id, ModelMap model) {
        model.addAttribute("id", id);
        return "catalogManage/editCatalog";
    }

    /**
     * 目录管理—目录信息变动对比
     *
     * @return
     */
    @RequestMapping("/updateCatalog")
    public String updateCatalog(String id, ModelMap model) {
        model.addAttribute("id", id);
        return "catalogManage/updateCatalog";
    }

    /**
     * 目录管理—元目录信息编辑
     *
     * @return
     */
    @RequestMapping("/editCatalogBottom")
    public String editCatalogBottom(String id, ModelMap model) {
        model.addAttribute("id", id);
        return "catalogManage/editCatalogBottom";
    }

    /**
     * 目录管理—元目录信息变动对比
     *
     * @return
     */
    @RequestMapping("/updateCatalogBottom")
    public String updateCatalogBottom(String id, ModelMap model) {
        model.addAttribute("id", id);
        return "catalogManage/updateCatalogBottom";
    }

    /**
     * 目录管理—字段信息新增
     *
     * @return
     */
    @RequestMapping("/createField")
    public String createField(String id, String unitId, ModelMap model) {
        model.addAttribute("id", id);
        model.addAttribute("unitId", unitId);
        return "catalogManage/createField";
    }

    /**
     * 目录管理—字段信息编辑
     *
     * @return
     */
    @RequestMapping("/editField")
    public String editField(String id, ModelMap model) {
        model.addAttribute("id", id);
        return "catalogManage/editField";
    }

    /**
     * 目录管理—字段信息变动对比
     *
     * @return
     */
    @RequestMapping("/updateField")
    public String updateField(String id, ModelMap model) {
        model.addAttribute("id", id);
        return "catalogManage/updateField";
    }

    /**
     * 目录管理-目录发布跟踪
     *
     * @return
     */
    @RequestMapping("/applyList")
    public String applyList(ModelMap model,String pageNo) {
        model.addAttribute("pageNo",pageNo);
        return "catalogManage/applyList";
    }

    /**
     * 目录管理-目录发布跟踪-新增
     *
     * @return
     */
    @RequestMapping("/applyCreate")
    public String applyCreate(ModelMap model) {
        return "catalogManage/applyCreate";
    }

    /**
     * 目录管理-目录发布跟踪-详情
     *
     * @return
     */
    @RequestMapping("/applyView")
    public String applyView(String id, String pageNum, ModelMap model) {
        model.addAttribute("id", id);
        model.addAttribute("pageNum", pageNum);
        return "catalogManage/applyView";
    }

    /**
     * 目录管理-目录发布跟踪-处理详情
     *
     * @return
     */
    @RequestMapping("/applyDealView")
    public String applyDealView(String id, ModelMap model) {
        model.addAttribute("id", id);
        return "catalogManage/applyDealView";
    }
    /**
     *目录管理-目录发布跟踪-处理详情
     *
     * @return
     */
    @RequestMapping("/ptAdminDealView")
    public String ptAdminDealView(String optTime, ModelMap model) {
        model.addAttribute("optTime",optTime);
        return "catalogManage/ptAdminDealView";
    }
    /**
     * 目录管理-目录发布跟踪-目录修改列表
     *
     * @return
     */
    @RequestMapping("/editList")
    public String editList(ModelMap model,String applyCode,String pageNo,String pageType) {
        model.addAttribute("applyCode",applyCode);
        model.addAttribute("pageNo",pageNo);
        model.addAttribute("pageType",pageType);
        return "catalogManage/editList";
    }

    /**
     * 目录管理—目录审核列表
     *
     * @return
     */
    @RequestMapping("/catalogAuditList")
    public String catalogAuditList( String pageNo,ModelMap model) {
        model.addAttribute("pageNo", pageNo);
        return "catalogManage/catalogAuditList";
    }

    /**
     * 目录管理—目录审核详情
     *
     * @return
     */
    @RequestMapping("/catalogAuditView")
    public String catalogAuditView(ModelMap model) {
        return "catalogManage/catalogAuditView";
    }

    /**
     * 目录管理—目录审核处理
     *
     * @return
     */
    @RequestMapping("/auditPage")
    public String auditPage(String taskId, String pageNo, String unitId, ModelMap model) {
        model.addAttribute("taskId", taskId);
        model.addAttribute("pageNo", pageNo);
        model.addAttribute("unitId", unitId);
        return "catalogManage/auditPage";
    }

    /**
     * 目录管理—申请发布
     *
     * @return
     */
    @RequestMapping("/editListApply")
    public String releaseApply(String unitId, String pageType, ModelMap model) {
        model.addAttribute("unitId", unitId);
        model.addAttribute("pageType", pageType);
        return "catalogManage/editListApply";
    }

    /**
     * 目录管理—分类选择
     *
     * @return
     */
    @RequestMapping("/openZtree")
    public String openZtree(String type, ModelMap model) {
        model.addAttribute("type", type);
        return "catalogManage/openZtree";
    }

    /**
     * 目录管理—自动生成目录
     *
     * @return
     */
    @RequestMapping("/autoCreateCatalogs")
    public String autoCreateCatalogs(String catalogPid, String autoCatalogUnitId, String catalogPname, ModelMap model) {
        model.addAttribute("catalogPid", catalogPid);
        model.addAttribute("catalogPname", catalogPname);
        model.addAttribute("autoCatalogUnitId", autoCatalogUnitId);
        return "catalogManage/autoCreate";
    }

    /**
     * 目录管理—自动生成目录-字段选择
     *
     * @return
     */
    @RequestMapping("/autoCreateFieldSet")
    public String autoCreateFieldSet(String catalogPid, String resType, String url, String autoCatalogUnitId, ModelMap model) {
        model.addAttribute("catalogPid", catalogPid);
        model.addAttribute("autoCatalogUnitId", autoCatalogUnitId);
        model.addAttribute("resType", resType);
        model.addAttribute("url", url);
        return "catalogManage/autoCreateFieldSet";
    }

    /**
     * 目录管理—自动生成目录-字段选择
     *
     * @return
     */
    @RequestMapping("/autoCreateFieldSetTwo")
    public String autoCreateFieldSetTwo(String catalogPid, String dbId, String tableName, String autoCatalogUnitId, String catalogPname, ModelMap model) {
        model.addAttribute("catalogPid", catalogPid);
        model.addAttribute("catalogPname", catalogPname);
        model.addAttribute("autoCatalogUnitId", autoCatalogUnitId);
        model.addAttribute("tableName", tableName);
        model.addAttribute("dbId", dbId);
        return "catalogManage/autoCreateFieldSetTwo";
    }

    /**
     * 目录管理—自动生成目录-字段选择
     *
     * @return
     */
    @RequestMapping("/autoCreateFieldSetThree")
    public String autoCreateFieldSetThree(String catalogPid, String setId, String autoCatalogUnitId, String dataType, String catalogPname, ModelMap model) {
        model.addAttribute("catalogPid", catalogPid);
        model.addAttribute("catalogPname", catalogPname);
        model.addAttribute("autoCatalogUnitId", autoCatalogUnitId);
        model.addAttribute("setId", setId);
        model.addAttribute("dataType", dataType);
        return "catalogManage/autoCreateFieldSetThree";
    }

    /**
     * 目录管理—自动生成目录-表选择
     *
     * @return
     */
    @RequestMapping("/autoCreateTableSet")
    public String autoCreateTableSet(String catalogPid, String dbId, String autoCatalogUnitId, String catalogPname, ModelMap model) {
        model.addAttribute("catalogPid", catalogPid);
        model.addAttribute("catalogPname", catalogPname);
        model.addAttribute("autoCatalogUnitId", autoCatalogUnitId);
        model.addAttribute("dbId", dbId);
        return "catalogManage/autoCreateTableSet";
    }

    /**
     * 目录管理—自动生成目录-数据源选择
     *
     * @return
     */
    @RequestMapping("/autoDataSourceSet")
    public String autoDataSourceSet(String pageNo, ModelMap model) {
        model.addAttribute("pageNo", pageNo);
        return "catalogManage/dataSourceSet";
    }

    /**
     * 目录管理—自动生成目录-数据源选择
     *
     * @return
     */
    @RequestMapping("/autoDataSet")
    public String autoDataSet(String pageNo, ModelMap model) {
        model.addAttribute("pageNo", pageNo);
        return "catalogManage/dataSet";
    }

    /**
     * 数据字典首页
     *
     * @return
     */
    @RequestMapping("/dataDictionary")
    public String dataDictionary(ModelMap model) {
        return "dataDictionary/list";
    }

    /**
     * 数据字典新增
     *
     * @return
     */
    @RequestMapping("/createDataDictionary")
    public String createDataDictionary(String pdictCode, String pdictName, String id, ModelMap model) {
        model.addAttribute("id", id);
        model.addAttribute("pdictCode", pdictCode);
        model.addAttribute("pdictName", pdictName);
        return "dataDictionary/create";
    }

    /**
     * 数据字典编辑
     *
     * @return
     */
    @RequestMapping("/editDataDictionary")
    public String editDataDictionary(String pdictCode, String pdictName, String dictCode, String dictName, String id, ModelMap model) {
        model.addAttribute("pdictCode", pdictCode);
        model.addAttribute("pdictName", pdictName);
        model.addAttribute("dictCode", dictCode);
        model.addAttribute("dictName", dictName);
        model.addAttribute("id", id);
        return "dataDictionary/edit";
    }

    /**
     * 数据源管理首页
     *
     * @return
     */
    @RequestMapping("/dataSourceList")
    public String dataSourceList(String pageNo, ModelMap model) {
        model.addAttribute("pageNo", pageNo);
        return "dataSourceManage/list";
    }

    /**
     * 数据源管理新增
     *
     * @return
     */
    @RequestMapping("/dataSourceCreate")
    public String dataSourceCreate(ModelMap model) {
        return "dataSourceManage/create";
    }

    /**
     * 数据源管理编辑
     *
     * @return
     */
    @RequestMapping("/dataSourceEdit")
    public String dataSourceEdit(String id, String pageNo, ModelMap model) {
        model.addAttribute("id", id);
        model.addAttribute("pageNo", pageNo);
        return "dataSourceManage/edit";
    }

    /**
     * 数据源管理详情
     *
     * @return
     */
    @RequestMapping("/dataSourceView")
    public String dataSourceView(String id, String pageNo, ModelMap model) {
        model.addAttribute("id", id);
        model.addAttribute("pageNo", pageNo);
        return "dataSourceManage/view";
    }


    /**
     * 系统列表首页
     *
     * @return
     */
    @RequestMapping("/systemList")
    public String systemList(String pageNo, ModelMap model) {
        model.addAttribute("pageNo", pageNo);
        return "system/list";
    }

    /**
     * 系统列表新增
     *
     * @return
     */
    @RequestMapping("/systemCreate")
    public String systemCreate(ModelMap model) {
        return "system/create";
    }

    /**
     * 系统列表编辑
     *
     * @return
     */
    @RequestMapping("/systemEdit")
    public String systemEdit(String id, String pageNo, ModelMap model) {
        model.addAttribute("id", id);
        model.addAttribute("pageNo", pageNo);
        return "system/edit";
    }

    /**
     * 系统列表详情
     *
     * @return
     */
    @RequestMapping("/systemView")
    public String systemView(String id, String pageNo, ModelMap model) {
        model.addAttribute("id", id);
        model.addAttribute("pageNo", pageNo);
        return "system/view";
    }

    /**
     * 数据集管理列表
     *
     * @return
     */
    @RequestMapping("/dataSetManageList")
    public String dataSetManageList(String pageNo, ModelMap model) {
        model.addAttribute("pageNo", pageNo);
        return "dataSetManage/list";
    }

    /**
     * 数据集管理新增
     *
     * @return
     */
    @RequestMapping("/dataSetCreateFirst")
    public String dataSetCreateFirst(String editType, ModelMap model) {
        model.addAttribute("editType", editType);
        return "dataSetManage/create_first";
    }

    /**
     * 数据集管理数据源选择
     *
     * @return
     */
    @RequestMapping("/dataSetSourceSet")
    public String dataSetSourceSet(String pageNo, ModelMap model) {
        model.addAttribute("pageNo", pageNo);
        return "dataSetManage/dataSourceSet";
    }

    /**
     * 数据集管理新增-关联目录
     *
     * @return
     */
    @RequestMapping("/dataSetCreateSecond")
    public String dataSetCreateSecond(String id, String type, String editType, ModelMap model) {
        model.addAttribute("id", id);
        model.addAttribute("type", type);
        model.addAttribute("editType", editType);
        return "dataSetManage/create_second";
    }

    /**
     * 数据集管理新增-关联目录选择
     *
     * @return
     */
    @RequestMapping("/dataSetCatalogZtree")
    public String dataSetCatalogZtree(String type, String catalogIds, ModelMap model) {
        model.addAttribute("type", type);
        model.addAttribute("catalogIds", catalogIds);
        return "dataSetManage/openZtree";
    }

    /**
     * 数据集管理新增-返回数据字段
     *
     * @return
     */
    @RequestMapping("/dataSetCreateApi")
    public String dataSetCreateApi(String id, ModelMap model) {
        model.addAttribute("id", id);
        return "dataSetManage/createApi";
    }

    /**
     * 数据集管理新增-选择数据集字段
     *
     * @return
     */
    @RequestMapping("/dataSetCreateDataBaseOne")
    public String dataSetCreateDataBaseOne(String id, ModelMap model) {
        model.addAttribute("id", id);
        return "dataSetManage/createDataBaseOne";
    }

    /**
     * 数据集管理新增-选择数据集字段
     *
     * @return
     */
    @RequestMapping("/dataSetCreateDataBaseTwo")
    public String dataSetCreateDataBaseTwo(String id, ModelMap model) {
        model.addAttribute("id", id);
        return "dataSetManage/createDataBaseTwo";
    }

    /**
     * 数据集管理新增-定义查询参数
     *
     * @return
     */
    @RequestMapping("/dataSetCreateDataBaseFiled")
    public String dataSetCreateDataBaseFiled(String id, String tableCode, String dataSourcId, ModelMap model) {
        model.addAttribute("id", id);
        model.addAttribute("tableCode", tableCode);
        model.addAttribute("dataSourcId", dataSourcId);
        return "dataSetManage/createDataBaseFiled";
    }

    /**
     * 数据集管理流程图
     *
     * @return
     */
    @RequestMapping("/dataSetFlow")
    public String dataSetFlow(ModelMap model) {
        return "dataSetManage/flowImg";
    }

    /**
     * 数据集管理返回数据格式查看
     *
     * @return
     */
    @RequestMapping("/dataTypeView")
    public String dataTypeView(ModelMap model) {
        return "dataSetManage/dataTypeView";
    }

    /**
     * 数据集管理新增-API类型关联目录
     *
     * @return
     */
    @RequestMapping("/dataSetCreateRelation")
    public String dataSetCreateRelation(String id, ModelMap model) {
        model.addAttribute("id", id);
        return "dataSetManage/createRelation";
    }

    /**
     * 数据集管理新增-数据库类型关联目录
     *
     * @return
     */
    @RequestMapping("/dataSetCreateDbRelation")
    public String dataSetCreateDbRelation(String id, String tableCode, String dataSourcId, ModelMap model) {
        model.addAttribute("id", id);
        model.addAttribute("tableCode", tableCode);
        model.addAttribute("dataSourcId", dataSourcId);
        return "dataSetManage/createDbRelation";
    }

    /**
     * 数据集管理编辑
     *
     * @return
     */
    @RequestMapping("/dataSetEditFirst")
    public String dataSetEditFirst(String setId, String pageNo, ModelMap model) {
        model.addAttribute("id", setId);
        model.addAttribute("pageNo", pageNo);
        return "dataSetManage/edit_first";
    }

    /**
     * 数据集管理编辑-关联目录
     *
     * @return
     */
    @RequestMapping("/dataSetEditSecond")
    public String dataSetEditSecond(String id, String type, String pageNo, ModelMap model) {
        model.addAttribute("id", id);
        model.addAttribute("type", type);
        model.addAttribute("pageNo", pageNo);
        return "dataSetManage/edit_second";
    }

    /**
     * 数据集管理编辑-返回数据字段
     *
     * @return
     */
    @RequestMapping("/dataSetEditApi")
    public String dataSetEditApi(String id, String pageNo, ModelMap model) {
        model.addAttribute("id", id);
        model.addAttribute("pageNo", pageNo);
        return "dataSetManage/editApi";
    }

    /**
     * 数据集管理编辑-选择数据集字段
     *
     * @return
     */
    @RequestMapping("/dataSetEditDataBaseOne")
    public String dataSetEditDataBaseOne(String id, String pageNo, ModelMap model) {
        model.addAttribute("id", id);
        model.addAttribute("pageNo", pageNo);
        return "dataSetManage/editDataBaseOne";
    }

    /**
     * 数据集管理编辑-选择数据集字段
     *
     * @return
     */
    @RequestMapping("/dataSetEditDataBaseTwo")
    public String dataSetEditDataBaseTwo(String id, String pageNo, ModelMap model) {
        model.addAttribute("id", id);
        model.addAttribute("pageNo", pageNo);
        return "dataSetManage/editDataBaseTwo";
    }

    /**
     * 数据集管理编辑-数据集编辑数据库读取页面
     *
     * @return
     */
    @RequestMapping("/dataSetEditDb")
    public String dataSetEditDb(String id, String pageNo, ModelMap model) {
        model.addAttribute("id", id);
        model.addAttribute("pageNo", pageNo);
        return "dataSetManage/dataSetEditDb";
    }

    /**
     * 数据集管理编辑-数据集编辑数据库读取页面新增字段
     *
     * @return
     */
    @RequestMapping("/dataSetEditDbAdd")
    public String dataSetEditDbAdd(String id,String filedStr,ModelMap model) {
        model.addAttribute("id", id);
        model.addAttribute("filedStr", filedStr);
        return "dataSetManage/dataSetEditDbAdd";
    }

    /**
     * 数据集管理编辑-数据集编辑数据库sql修改
     *
     * @return
     */
    @RequestMapping("/dataSetEditSql")
    public String dataSetEditSql(String id,String pageNo,ModelMap model) {
        model.addAttribute("id", id);
        model.addAttribute("pageNo", pageNo);
        return "dataSetManage/dataSetEditSql";
    }



    /**
     * 数据集管理编辑-定义查询参数
     *
     * @return
     */
    @RequestMapping("/dataSetEditDataBaseFiled")
    public String dataSetEditDataBaseFiled(String id, String tableCode, String dataSourcId, String pageNo, ModelMap model) {
        model.addAttribute("id", id);
        model.addAttribute("tableCode", tableCode);
        model.addAttribute("dataSourcId", dataSourcId);
        model.addAttribute("pageNo", pageNo);
        return "dataSetManage/editDataBaseFiled";
    }

    /**
     * 数据集管理编辑-数据库类型关联目录
     *
     * @return
     */
    @RequestMapping("/dataSetEditRelation")
    public String dataSetEditRelation(String id, String pageNo, ModelMap model) {
        model.addAttribute("id", id);
        model.addAttribute("pageNo", pageNo);
        return "dataSetManage/editRelation";
    }

    /**
     * 数据集管理编辑-数据库类型关联目录
     *
     * @return
     */
    @RequestMapping("/dataSetEditDbRelation")
    public String dataSetEditDbRelation(String id, String tableCode, String dataSourcId, String pageNo, ModelMap model) {
        model.addAttribute("id", id);
        model.addAttribute("tableCode", tableCode);
        model.addAttribute("dataSourcId", dataSourcId);
        model.addAttribute("pageNo", pageNo);
        return "dataSetManage/editDbRelation";
    }


    /**
     * 数据集管理详情
     *
     * @return
     */
    @RequestMapping("/dataSetViewFirst")
    public String dataSetViewFirst(String setId, String pageNo, ModelMap model) {
        model.addAttribute("id", setId);
        model.addAttribute("pageNo", pageNo);
        return "dataSetManage/view_first";
    }

    /**
     * 数据集管理详情-关联目录
     *
     * @return
     */
    @RequestMapping("/dataSetViewSecond")
    public String dataSetViewSecond(String id, String type, String pageNo, ModelMap model) {
        model.addAttribute("id", id);
        model.addAttribute("type", type);
        model.addAttribute("pageNo", pageNo);
        return "dataSetManage/view_second";
    }

    /**
     * 数据集管理详情-返回数据字段
     *
     * @return
     */
    @RequestMapping("/dataSetViewApi")
    public String dataSetViewApi(String id, String pageNo, ModelMap model) {
        model.addAttribute("id", id);
        model.addAttribute("pageNo", pageNo);
        return "dataSetManage/viewApi";
    }

    /**
     * 数据集管理详情-选择数据集字段
     *
     * @return
     */
    @RequestMapping("/dataSetViewDataBaseOne")
    public String dataSetViewDataBaseOne(String id, String pageNo, ModelMap model) {
        model.addAttribute("id", id);
        model.addAttribute("pageNo", pageNo);
        return "dataSetManage/viewDataBaseOne";
    }

    /**
     * 数据集管理详情-选择数据集字段
     *
     * @return
     */
    @RequestMapping("/dataSetViewDataBaseTwo")
    public String dataSetViewDataBaseTwo(String id, String pageNo, ModelMap model) {
        model.addAttribute("id", id);
        model.addAttribute("pageNo", pageNo);
        return "dataSetManage/viewDataBaseTwo";
    }

    /**
     * 数据集管理详情-定义查询参数
     *
     * @return
     */
    @RequestMapping("/dataSetViewDataBaseFiled")
    public String dataSetViewDataBaseFiled(String id, String tableCode, String dataSourcId, String pageNo, ModelMap model) {
        model.addAttribute("id", id);
        model.addAttribute("tableCode", tableCode);
        model.addAttribute("dataSourcId", dataSourcId);
        model.addAttribute("pageNo", pageNo);
        return "dataSetManage/viewDataBaseFiled";
    }

    /**
     * 数据集管理详情-数据库类型关联目录
     *
     * @return
     */
    @RequestMapping("/dataSetViewRelation")
    public String dataSetViewRelation(String id, String pageNo, ModelMap model) {
        model.addAttribute("id", id);
        model.addAttribute("pageNo", pageNo);
        return "dataSetManage/viewRelation";
    }

    /**
     * 数据集管理详情-数据库类型关联目录
     *
     * @return
     */
    @RequestMapping("/dataSetViewDbRelation")
    public String dataSetViewDbRelation(String id, String tableCode, String dataSourcId, String pageNo, ModelMap model) {
        model.addAttribute("id", id);
        model.addAttribute("tableCode", tableCode);
        model.addAttribute("dataSourcId", dataSourcId);
        model.addAttribute("pageNo", pageNo);
        return "dataSetManage/viewDbRelation";
    }


    /**
     * 数据集管理详情
     *
     * @return
     */
    @RequestMapping("/dataSetView")
    public String dataSetView(String taskId, String pageNo,ModelMap model) {
        model.addAttribute("taskId", taskId);
        model.addAttribute("pageNo", pageNo);
        return "dataSetManage/view";
    }
    /**
     * 数据集管理数据校验
     *
     * @return
     */
    @RequestMapping("/dataSetDataValid")
    public String dataSetDataValid(String id,  String pageNo,ModelMap model) {
        model.addAttribute("id", id);
        model.addAttribute("pageNo", pageNo);
        return "dataSetManage/dataSetDataValid";
    }
    /**
     * 数据集管理数据校验列表
     *
     * @return
     */
    @RequestMapping("/dataSetDataValidList")
    public String dataSetDataValidList(String id, String pageNo,ModelMap model) {
        model.addAttribute("id", id);
        model.addAttribute("pageNo", pageNo);
        return "dataSetManage/dataSetDataValidList";
    }

    /**
     * 数据集管理数据校验列表
     *
     * @return
     */
    @RequestMapping("/dataSetDataValidEdit")
    public String dataSetDataValidEdit(String id, String setId, String pageNo, ModelMap model) {
        model.addAttribute("id", id);
        model.addAttribute("setId", setId);
        model.addAttribute("pageNo", pageNo);
        return "dataSetManage/dataSetDataValidEdit";
    }

    /**
     * 数据集审核列表
     *
     * @return
     */
    @RequestMapping("/dataSetApplyList")
    public String dataSetApplyList(String pageNo, ModelMap model) {
        model.addAttribute("pageNo", pageNo);
        return "dataSetManage/applyList";
    }

    /**
     * 数据集审核详情
     *
     * @return
     */
    @RequestMapping("/dataSetApplyView")
    public String dataSetApplyView(ModelMap model) {
        return "dataSetManage/view";
    }

    /**
     * 共享申请列表
     *
     * @return
     */
    @RequestMapping("/shareMagApplyList")
    public String shareMagApplyList( String pageNo, ModelMap model) {
        model.addAttribute("pageNo", pageNo);
        return "shareManage/applyList";
    }

    /**
     * 共享申请详情
     *
     * @return
     */
    @RequestMapping("/shareMagView")
    public String shareMagView(ModelMap model, String pageNo, String id) {
        model.addAttribute("pageNo", pageNo);
        model.addAttribute("id", id);
        return "shareManage/view";
    }

    /**
     * 共享申请结构化目录详情
     *
     * @return
     */
    @RequestMapping("/shareApplyView")
    public String shareApplyView(ModelMap model, String id, String apiId, String pageNo) {
        model.addAttribute("id", id);
        model.addAttribute("apiId", apiId);
        model.addAttribute("pageNo", pageNo);
        return "shareManage/shareview";
    }
    /**
     * 共享申请非结构化目录详情
     *
     * @return
     */
    @RequestMapping("/shareApplyUnStructView")
    public String shareApplyUnStructView(ModelMap model, String id, String apiId,String authStatus) {
        model.addAttribute("id", id);
        model.addAttribute("apiId", apiId);
        model.addAttribute("authStatus", authStatus);
        return "shareManage/shareUnStructView";
    }

    /**
     * 共享申请新增-选择目录
     *
     * @return
     */
    @RequestMapping("/shareMagSetCatalog")
    public String shareMagSetCatalog(ModelMap model, String apiId, String type) {
        model.addAttribute("apiId", apiId);
        model.addAttribute("type", type);
        return "shareManage/setCatalog";
    }

    /**
     * 共享申请新增-返回数据字段
     *
     * @return
     */
    @RequestMapping("/shareMagApplyFirst")
    public String shareMagApplyFirst(String pageType, String dataId, String catalogId, String applyId, ModelMap model) {
        model.addAttribute("pageType", pageType);
        model.addAttribute("dataId", dataId);
        model.addAttribute("applyId", applyId);
        model.addAttribute("catalogId", catalogId);
        return "generalView/dataApply_first";
    }

    /**
     * 共享申请新增-定义查询参数
     *
     * @return
     */
    @RequestMapping("/shareMagApplySecond")
    public String shareMagApplySecond(String pageType, String dataId, String catalogId, ModelMap model) {
        model.addAttribute("pageType", pageType);
        model.addAttribute("dataId", dataId);
        model.addAttribute("catalogId", catalogId);
        return "shareManage/dataApply_second";
    }

    /**
     * 共享申请新增-基本信息录入
     *
     * @return
     */
    @RequestMapping("/shareMagApplyThree")
    public String shareMagApplyThree(ModelMap model) {
        return "shareManage/dataApply_three";
    }

    /**
     * 共享申请新增-文件申请基本信息录入
     *
     * @return
     */
    @RequestMapping("/shareMagFileApply")
    public String shareMagFileApply(ModelMap model) {
        return "shareManage/fileApply";
    }

    /**
     * 共享申请新增-续期申请
     *
     * @return
     */
    @RequestMapping("/shareMagDelayed")
    public String shareMagDelayed(ModelMap model, String id) {
        model.addAttribute("id", id);
        return "shareManage/delayed";
    }

    /**
     * 共享管理api列表
     *
     * @return
     */
    @RequestMapping("/shareMagApiList")
    public String shareMagApiList(ModelMap model) {
        return "shareManage/apiList";
    }

    /**
     * 共享管理需求申请列表
     *
     * @return
     */
    @RequestMapping("/shareMagDemandList")
    public String shareMagDemandList(ModelMap model) {
        return "shareManage/demandList";
    }

    /**
     * 共享管理api管理-使用情况
     *
     * @return
     */
    @RequestMapping("/usage")
    public String usage(ModelMap model, String id) {
        model.addAttribute("id", id);
        return "shareManage/usage";
    }

    /**
     * 共享管理api管理-异常情况
     *
     * @return
     */
    @RequestMapping("/abnormal")
    public String abnormal(ModelMap model, String id) {
        model.addAttribute("id", id);
        return "shareManage/abnormal";
    }

    /**
     * 共享管理api管理-异常情况处理
     *
     * @return
     */
    @RequestMapping("/shareMagDealPage")
    public String shareMagDealPage(ModelMap model, String id) {
        model.addAttribute("id", id);
        return "shareManage/dealPage";
    }

    /**
     * 共享管理api管理-调用详情
     *
     * @return
     */
    @RequestMapping("/invoking")
    public String invoking(ModelMap model) {
        return "shareManage/invoking";
    }

    /**
     * 共享管理api管理-新增授权单位
     *
     * @return
     */
    @RequestMapping("/unitCreate")
    public String unitCreate(String apiId, ModelMap model) {
        model.addAttribute("apiId", apiId);
        return "shareManage/unitCreate";
    }

    /**
     * 共享管理api管理-授权记录
     *
     * @return
     */
    @RequestMapping("/authorizeHistory")
    public String authorizeHistory(ModelMap model, String id) {
        model.addAttribute("id", id);
        return "shareManage/authorizeHistory";
    }

    /**
     * 共享管理api管理-基本信息录入
     *
     * @return
     */
    @RequestMapping("/shareMagApiApplyThree")
    public String shareMagApiApplyThree(String pageType, String dataId, ModelMap model) {
        model.addAttribute("pageType", pageType);
        model.addAttribute("dataId", dataId);
        return "shareManage/dataApiApply_three";
    }

    /**
     * 共享管理api管理-选择目录
     *
     * @return
     */
    @RequestMapping("/shareMagSetApiCatalog")
    public String shareMagSetApiCatalog(String pageType, String applyId, String apiId,String dirId, ModelMap model) {
        model.addAttribute("pageType", pageType);
        model.addAttribute("apiId", apiId);
        model.addAttribute("applyId", applyId);
        model.addAttribute("dirId", dirId);
        return "shareManage/setApiCatalog";
    }

    /**
     * 共享管理api管理-选择默认共享单位
     *
     * @return
     */
    @RequestMapping("/shareMagSetUnit")
    public String shareMagSetUnit(String unitIds, String apiId, ModelMap model) {
        model.addAttribute("unitIds", unitIds);
        model.addAttribute("apiId", apiId);
        return "shareManage/setUnitPage";
    }

    /**
     * 共享管理api管理-数据目录shareMagSetApiCatalog
     *
     * @return
     */
    @RequestMapping("/shareMagOpenZtree")
    public String shareMagOpenZtree(ModelMap model, String pageType) {
        model.addAttribute("pageType", pageType);
        return "shareManage/openZtree";
    }

    /**
     * 共享管理api管理-处理详情
     *
     * @return
     */
    @RequestMapping("/shareMagDealView")
    public String shareMagDealView(ModelMap model, String pageNo, String id) {
        model.addAttribute("pageNo", pageNo);
        model.addAttribute("id", id);
        return "shareManage/dealView";
    }

    /**
     * 共享管理需求申请-新增
     *
     * @return
     */
    @RequestMapping("/shareMagCreate")
    public String shareMagCreate(ModelMap model) {
        return "shareManage/create";
    }

    /**
     * 共享管理流程图
     *
     * @return
     */
    @RequestMapping("/shareManageFlow")
    public String shareManageFlow(ModelMap model) {
        return "shareManage/shareManageFlow";
    }
    /**
     * 共享申请预览数据
     * type:调用类型：1：api调用，2：目录调用，3：数据集调用
     * @return
     */
    @RequestMapping("/shareManageDataView")
    public String shareManageDataView(ModelMap model,String setId,Integer type) {
        model.addAttribute("id", setId);
        model.addAttribute("type", type);
        return "shareManage/shareManageDataView";
    }

    /**
     * 需求审核
     *
     * @return
     */
    @RequestMapping("/demandExamineList")
    public String demandExamineList(String pageNo, ModelMap model) {
        model.addAttribute("pageNo", pageNo);
        return "shareManage/demandExamineList";
    }

    /**
     * 需求审核处理
     *
     * @return
     */
    @RequestMapping("/demandDeal")
    public String demandDeal(ModelMap model, String pageNo, String id, String demandId) {
        model.addAttribute("pageNo", pageNo);
        model.addAttribute("id", id);
        model.addAttribute("demandId", demandId);
        return "shareManage/demandDeal";
    }

    /**
     * 需求审核基本信息录入
     *
     * @return
     */
    @RequestMapping("/dataDemandApplyThree")
    public String dataDemandApplyThree(String pageType, String dataId, ModelMap model) {
        model.addAttribute("pageType", pageType);
        model.addAttribute("dataId", dataId);
        return "shareManage/dataDemandApply_three";
    }

    /**
     * 共享审核
     *
     * @return
     */
    @RequestMapping("/shareExamineList")
    public String shareExamineList(String pageNo,ModelMap model) {
        model.addAttribute("pageNo", pageNo);
        return "shareManage/shareExamineList";
    }

    /**
     * 共享审核-处理详情
     *
     * @return
     */
    @RequestMapping("/shareDealView")
    public String shareDealView(ModelMap model, String applyCode) {
        model.addAttribute("applyCode", applyCode);
        return "shareManage/shareDealView";
    }

    /**
     * 共享审核-处理
     *
     * @return
     */
    @RequestMapping("/shareDeal")
    public String shareDeal(ModelMap model, String id, String applyType) {
        model.addAttribute("id", id);
        model.addAttribute("applyType", applyType);
        return "shareManage/shareDeal";
    }


    /**
     * 整体概览list列表页
     *
     * @return
     */
    @RequestMapping("/generalList")
    public String generalList(ModelMap model, String unitId) {
        model.addAttribute("unitId", unitId);
        return "generalView/list";
    }
    /**
     * 主题库、专题库、基础库详细页面
     *
     * @return
     */
    @RequestMapping("/libraryList")
    public String libraryList(ModelMap model, String busCode,String busKey) {
        model.addAttribute("busCode", busCode);
        model.addAttribute("busKey", busKey);
        return "generalView/libraryList";
    }

    /**
     * 整体概览结构化文件详情
     * pageType : 页面跳转类型 unit:单位目录跳转详情，three:三库跳转详情
     * @return
     */
    @RequestMapping("/generalView")
    public String generalView(ModelMap model, String id, String unitId,String pageType,String busCode,String busKey) {
        model.addAttribute("id", id);
        model.addAttribute("unitId", unitId);
        model.addAttribute("pageType", pageType);
        model.addAttribute("busCode", busCode);
        model.addAttribute("busKey", busKey);
        return "generalView/view";
    }

    /**
     * 整体概览结构化文件API详情
     * canApply 1:是 0：否
     *
     * @return
     */
    @RequestMapping("/generalApiView")
    public String generalApiView(String id, String catalogId, String canApply, ModelMap model) {
        model.addAttribute("id", id);
        model.addAttribute("catalogId", catalogId);
        model.addAttribute("canApply", canApply);
        return "generalView/apiView";
    }

    /*
     * *整体概览非结构化文件API详情
     * canApply 1:是 0：否
     * @return
     */
    @RequestMapping("/generalUnstructuredApiView")
    public String generalUnstructuredApiView(String id, String catalogId, String canApply, ModelMap model) {
        model.addAttribute("id", id);
        model.addAttribute("catalogId", catalogId);
        model.addAttribute("canApply", canApply);
        return "generalView/unstructuredApiView";
    }

    /**
     * 整体概览非结构化文件详情
     *
     * @return
     */
    @RequestMapping("/unstructuredView")
    public String unstructuredView(String id, String unitId, ModelMap model) {
        model.addAttribute("id", id);
        model.addAttribute("unitId", unitId);
        return "generalView/unstructuredView";
    }

    /**
     * 整体概览API申请
     *
     * @return
     */
    @RequestMapping("/generalApiApply")
    public String generalApiApply(String id, String catalogId, ModelMap model) {
        model.addAttribute("id", id);
        model.addAttribute("catalogId", catalogId);
        return "generalView/apiApply";
    }

    /**
     * 整体概览申请下载
     *
     * @return
     */
    @RequestMapping("/generalApplyDownload")
    public String generalApplyDownload(String catalogId, ModelMap model) {
        model.addAttribute("catalogId", catalogId);
        return "generalView/applyDownload";
    }

    /**
     * 整体概览数据申请返回数据字段选择
     *
     * @return
     */
    @RequestMapping("/generalFirst")
    public String generalFirst(String dataId, String catalogId, String pageType, String applyId, ModelMap model) {
        model.addAttribute("dataId", dataId);
        model.addAttribute("pageType", pageType);
        model.addAttribute("applyId", applyId);
        model.addAttribute("catalogId", catalogId);
        return "generalView/dataApply_first";
    }

    /**
     * 整体概览数据申请定义查询参数
     *
     * @return
     */
    @RequestMapping("/generalSecond")
    public String generalSecond(String dataId, String catalogId, String applyId, ModelMap model) {
        model.addAttribute("dataId", dataId);
        model.addAttribute("applyId", applyId);
        model.addAttribute("catalogId", catalogId);
        return "generalView/dataApply_second";
    }

    /**
     * 整体概览数据申请基本信息录入
     *
     * @return
     */
    @RequestMapping("/generalThree")
    public String generalThree(String dataId, String catalogId, String applyId, ModelMap model) {
        model.addAttribute("dataId", dataId);
        model.addAttribute("applyId", applyId);
        model.addAttribute("catalogId", catalogId);
        return "generalView/dataApply_three";
    }
    /**
     * 统计分析
     *
     * @return
     */
    @RequestMapping("/statAnalysis")
    public String statAnalysis(ModelMap model) {
        return "module/statAnalysis";
    }
}