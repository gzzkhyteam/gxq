package com.hengyunsoft.platform.modular.sdk;


import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.util.StringUtil;
import com.hengyunsoft.platform.modular.sdk.dto.*;
import com.hengyunsoft.platform.modular.sdk.utils.HttpUtil;
import com.hengyunsoft.platform.modular.sdk.utils.PropertiesUtil;
import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

/**
 * 模块管理工具接口类
 *
 * @author zhoukx
 * @createTime 2018-4-16
 */
@Slf4j
public class MavenUtil {

    //获取服务请求的地址
    private static String serverUrl = PropertiesUtil.getValue("serverUrl");

    /**
     * 获取token认证信息
     *
     * @param appId     应用id
     * @param appSecret 应用密码
     * @return TokenDTO token对象
     */
    public static TokenDTO getToken(String appId, String appSecret) {

        if (StringUtil.isEmpty(appId)) {
            log.error("应用id不能为空");
            return null;
        }
        if (StringUtil.isEmpty(appSecret)) {
            log.error("应用密码不能为空");
            return null;
        }
        TokenDTO token = new TokenDTO();
        String resultJson = HttpUtil.getTokenByPost(serverUrl + "/api/auth/app/token", appId, appSecret);
        JSONObject object = JSONObject.parseObject(resultJson);
        JSONObject jsonObject = object.getJSONObject("data");

        if (jsonObject == null) {
            log.error("未查到数据");
            return null;
        }
        token.setToken(jsonObject.getString("token"));//token
        token.setExpire(jsonObject.getInteger("expire"));//有效时间：单位：秒

        return token;
    }

    /**
     * jar包分页查询
     *
     * @param modularVersionQueryDTO 查询jar包使用的实体类
     * @param pageSize               页容量
     * @param pageNo                 页码号
     * @param token                  请求需要的凭证信息
     * @return List<ModularVersion> jar包的list列表
     */
    public static List<ModularVersion> queryVersion(ModularVersionQueryDTO modularVersionQueryDTO, Integer pageSize, Integer pageNo, String token) throws IOException {

        //对分页信息的参数进行验证
        if (pageSize == null || pageSize <= 0 || pageSize >= 500) {
            pageSize = 10;
        }
        if (pageNo == null || pageNo <= 0) {
            pageNo = 1;
        }
        //构建请求需要的参数
        JSONObject param = new JSONObject();
        JSONObject innerParams = new JSONObject();
        //判断是否有查询条件
        if (modularVersionQueryDTO != null) {
            if (StringUtil.isNotEmpty(modularVersionQueryDTO.getRepName())) {
                innerParams.put("repName", modularVersionQueryDTO.getRepName());
            }
            if (StringUtil.isNotEmpty(modularVersionQueryDTO.getModularName())) {
                innerParams.put("modularName", modularVersionQueryDTO.getModularName());
            }
            if (StringUtil.isNotEmpty(modularVersionQueryDTO.getGroupId())) {
                innerParams.put("groupId", modularVersionQueryDTO.getGroupId());
            }
            if (StringUtil.isNotEmpty(modularVersionQueryDTO.getArtifactId())) {
                innerParams.put("artifactId", modularVersionQueryDTO.getArtifactId());
            }
            if (StringUtil.isNotEmpty(modularVersionQueryDTO.getVersion())) {
                innerParams.put("version", modularVersionQueryDTO.getVersion());
            }
            if (StringUtil.isNotEmpty(modularVersionQueryDTO.getDescription())) {
                innerParams.put("description", modularVersionQueryDTO.getDescription());
            }
        }

        param.put("data", innerParams);

        param.put("pageSize", pageSize);
        param.put("pageNo", pageNo);
        String mdjson = param.toString();
        String mdresultJson = HttpUtil.getResultByPost(serverUrl + "/api/modular/version/pageJar", mdjson, token);
        JSONObject object = JSONObject.parseObject(mdresultJson);

        JSONObject o = object.getJSONObject("data");
        JSONArray array = o.getJSONArray("list");
        List<ModularVersion> mdVersionList = array.toJavaList(ModularVersion.class);

        return mdVersionList;
    }

    /**
     * 发布jar包
     *
     * @param modularVersionUploadDTO 发布jar包使用的实体类
     * @param file                    发布的jar包文件
     * @param token                   请求需要的凭证信息
     * @return boolean true：成功，false：失败
     */
    public static boolean uploadVersion(ModularVersionUploadDTO modularVersionUploadDTO, File file, String token) throws IOException {

        if (modularVersionUploadDTO == null) {
            log.error("参数对象不能为空");
            return false;
        }
        if (StringUtil.isEmpty(modularVersionUploadDTO.getRepName())) {
            log.error("仓库名称不能为空");
            return false;
        }
        if (StringUtil.isEmpty(modularVersionUploadDTO.getModularName())) {
            log.error("模块名称不能为空");
            return false;
        }
        if (StringUtil.isEmpty(modularVersionUploadDTO.getGroupId())) {
            log.error("groupId不能为空");
            return false;
        }
        if (StringUtil.isEmpty(modularVersionUploadDTO.getArtifactId())) {
            log.error("artifactId不能为空");
            return false;
        }
        if (StringUtil.isEmpty(modularVersionUploadDTO.getVersion())) {
            log.error("版本不能为空");
            return false;
        }
        if (StringUtil.isEmpty(modularVersionUploadDTO.getClassifier())) {
            log.error("jar包的类型不能为空");
            return false;
        }
        if (!(modularVersionUploadDTO.getClassifier().equals("jar") || modularVersionUploadDTO.getClassifier().equals("source")
                || modularVersionUploadDTO.getClassifier().equals("doc") || modularVersionUploadDTO.getClassifier().equals("help"))) {
            log.error("jar包的类型填写不正确，格式为：jar、source、doc、help");
            return false;
        }
        if (modularVersionUploadDTO.getCreateCompanyId() == null) {
            log.error("单位Id不能为空");
            return false;
        }
        if (StringUtil.isEmpty(modularVersionUploadDTO.getCreateCompanyName())) {
            log.error("单位名称不能为空");
            return false;
        }
        //验证上传的文件名称是否包含中文、后缀是否是jar，通过则继续，否则返回失败。
        if (file == null) {
            log.error("文件不能为空");
            return false;
        }
        String fileName = file.getName();
        Boolean isChinese = false;
        if (StringUtil.isEmpty(fileName)) {
            log.error("文件名称不能为空");
            return false;
        }
        Pattern pattern = Pattern.compile("[\\u4E00-\\u9FBF]+");
        isChinese = pattern.matcher(fileName.trim()).find();
        if (isChinese) {
            log.error("文件名称不能包含中文");
            return false;
        }
        if (fileName.contains(".")) {
            String suffix = fileName.substring(fileName.lastIndexOf(".") + 1);
            if (!suffix.equals("jar")) {
                log.error("文件应该为.jar格式");
                return false;
            }
        }

        if (StringUtil.isEmpty(modularVersionUploadDTO.getDescription())) {
            log.error("模块描述不能为空");
            return false;
        }
        //错误提示信息
        String errmsg = "";

        String resultJson = HttpUtil.uploadPost(serverUrl + "/api/modular/version/upload", modularVersionUploadDTO, file, token);
        JSONObject object = JSONObject.parseObject(resultJson);
        JSONObject o = object.getJSONObject("data");

        if (StringUtil.isNotEmpty(object.getString("errmsg"))) {
            errmsg = object.getString("errmsg");
        }
        if (o == null) {
            log.error("发布jar包失败：" + errmsg);
            return false;
        }
        return true;
    }

    /**
     * 更新jar包
     *
     * @param updateVersionDTO 更新jar包使用的实体类
     * @param file             发布的jar包文件
     * @param token            请求需要的凭证信息
     * @return boolean true：成功，false：失败
     */
    public static boolean updateVersion(UpdateVersionDTO updateVersionDTO, File file, String token) throws IOException {
        if (updateVersionDTO == null) {

            log.error("参数对象不能为空");
            return false;
        }
        if (StringUtil.isEmpty(updateVersionDTO.getRepName())) {
            log.error("仓库名称不能为空");
            return false;
        }
        if (StringUtil.isEmpty(updateVersionDTO.getGroupId())) {
            log.error("groupId不能为空");
            return false;
        }
        if (StringUtil.isEmpty(updateVersionDTO.getArtifactId())) {
            log.error("artifactId不能为空");
            return false;
        }
        if (StringUtil.isEmpty(updateVersionDTO.getVersion())) {
            log.error("版本不能为空");
            return false;
        }
        if (StringUtil.isEmpty(updateVersionDTO.getClassifier())) {
            log.error("jar包的类型不能为空");
            return false;
        }
        if (!(updateVersionDTO.getClassifier().equals("jar") || updateVersionDTO.getClassifier().equals("source")
                || updateVersionDTO.getClassifier().equals("doc") || updateVersionDTO.getClassifier().equals("help"))) {
            log.error("jar包的类型填写不正确，格式为：jar、source、doc、help");
            return false;
        }
        if (updateVersionDTO.getCreateCompanyId() == null) {
            log.error("单位Id不能为空");
            return false;
        }
        if (StringUtil.isEmpty(updateVersionDTO.getCreateCompanyName())) {
            log.error("单位名称不能为空");
            return false;
        }
        if (file == null) {
            log.error("文件不能为空");
            return false;
        }
        //错误提示信息
        String errmsg = "";

        JSONObject param = new JSONObject();
        param.put("repName", updateVersionDTO.getRepName());
        param.put("groupId", updateVersionDTO.getGroupId());
        param.put("artifactId", updateVersionDTO.getArtifactId());

        String json = param.toString();
        //先判断模块是否存在，如果存在继续执行，否则 return false
        String resultJson = HttpUtil.getResultByPost(serverUrl + "/api/modular/modular/getModularByRepNameAndGidAndAid", json, token);
        JSONObject object = JSONObject.parseObject(resultJson);
        JSONObject o = object.getJSONObject("data");

        if (StringUtil.isNotEmpty(object.getString("errmsg"))) {
            errmsg = object.getString("errmsg");
        }
        if (o == null) {
            log.error("jar包更新失败：" + errmsg);
            return false;
        }

        //上传jar包
        String uploadResultJson = HttpUtil.updateVersionPost(serverUrl + "/api/modular/version/updateVersion", updateVersionDTO, file, token);
        JSONObject obj = JSONObject.parseObject(uploadResultJson);
        JSONObject jsonObject = obj.getJSONObject("data");

        if (StringUtil.isNotEmpty(obj.getString("errmsg"))) {
            errmsg = obj.getString("errmsg");
        }
        if (jsonObject == null) {
            log.error("jar包更新失败：" + errmsg);
            return false;
        }
        return true;
    }

    /**
     * 查询jar包详情
     *
     * @param id    jar包的id
     * @param token 请求需要的凭证信息
     * @return ModularVersion jar包的实体信息
     */
    public static ModularVersion detailVersion(Long id, String token) throws IOException {
        if (id == null) {
            log.error("id不能为空");
            return null;
        }
        ModularVersion ModularVersion = new ModularVersion();

        String resultJson = HttpUtil.getResultByGet(serverUrl + "/api/modular/version/get?id=" + id, "", token);
        JSONObject object = JSONObject.parseObject(resultJson);
        JSONObject jsonObject = object.getJSONObject("data");

        if (jsonObject == null) {
            log.error("未查到数据");
            return null;
        }
        ModularVersion.setId(jsonObject.getLong("id"));//id
        ModularVersion.setRepName(jsonObject.getString("repName"));//仓库名
        ModularVersion.setGroupId(jsonObject.getString("groupId"));//groupId
        ModularVersion.setArtifactId(jsonObject.getString("artifactId"));//artifactId
        ModularVersion.setVersion(jsonObject.getString("version"));//jar包版本
        ModularVersion.setClassifier(jsonObject.getString("classifier"));//jar包分类（class类型的为null source doc help）
        ModularVersion.setCreateTime(jsonObject.getDate("createTime"));//发布时间
        ModularVersion.setDownloadCount(jsonObject.getInteger("downloadCount"));//下载次数
        ModularVersion.setDownloadUrl(jsonObject.getString("downloadUrl"));//下载地址

        return ModularVersion;
    }

    /**
     * 查询仓库列表
     *
     * @param token 请求需要的凭证信息
     * @return List<ModularRepositoryDTO> 仓库的列表信息
     */
    public static List<ModularRepositoryDTO> findRepertories(String token) throws IOException {
        List<ModularRepositoryDTO> newRepositoryLists = new ArrayList<ModularRepositoryDTO>();
        String resultJson = HttpUtil.getResultByPost(serverUrl + "/api/modular/repository/find", "", token);

        JSONObject object = JSONObject.parseObject(resultJson);
        JSONArray jsonArray = object.getJSONArray("data");

        if (jsonArray == null) {
            log.error("未查到数据");
            return null;
        }

        //jsonArray转为javaList
        List<ModularRepositoryDTO> repositoryLists = jsonArray.toJavaList(ModularRepositoryDTO.class);

        for (int i = 0; i < repositoryLists.size(); i++) {
            if (!(repositoryLists.get(i).getName().equals("maven-central")
                    || repositoryLists.get(i).getName().equals("maven-public")
                    || repositoryLists.get(i).getName().equals("maven-snapshots")
                    || repositoryLists.get(i).getName().equals("nuget-group")
                    || repositoryLists.get(i).getName().equals("nuget-hosted")
                    || repositoryLists.get(i).getName().equals("nuget.org-proxy"))) {

                newRepositoryLists.add(repositoryLists.get(i));
            }
        }
        return newRepositoryLists;
    }

    /**
     * 分类查询
     *
     * @param token 请求需要的凭证信息
     * @return List<MdCategoryDefDTO> 分类的列表信息
     */
    public static List<MdCategoryDefDTO> findCategoryDefs(String token) throws IOException {
        List<MdCategoryDefDTO> list = new ArrayList<MdCategoryDefDTO>();

        String resultJson = HttpUtil.getResultByPost(serverUrl + "/api/modular/category/findCategoryDef", "", token);
        JSONObject object = JSONObject.parseObject(resultJson);
        JSONArray jsonArray = object.getJSONArray("data");

        if (jsonArray == null) {
            log.error("未查到数据");
            return null;
        }
        //jsonArray转为javaList
        list = jsonArray.toJavaList(MdCategoryDefDTO.class);

        return list;
    }

    /**
     * 标签查询
     *
     * @param token 请求需要的凭证信息
     * @return List<MdTagDefDTO> 标签的列表信息
     */
    public static List<MdTagDefDTO> findTagDefs(String token) throws IOException {
        List<MdTagDefDTO> list = new ArrayList<MdTagDefDTO>();

        String resultJson = HttpUtil.getResultByPost(serverUrl + "/api/modular/tag/findTagDef", "", token);
        JSONObject object = JSONObject.parseObject(resultJson);
        JSONArray jsonArray = object.getJSONArray("data");
        //jsonArray转为javaList
        list = jsonArray.toJavaList(MdTagDefDTO.class);

        return list;
    }
}
