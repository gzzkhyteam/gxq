package com.hengyunsoft.platform.admin.impl.application;

import com.hengyunsoft.base.Result;
import com.hengyunsoft.commons.constant.biz.AdminSearchType;
import com.hengyunsoft.commons.context.AdminSearchCollections;
import com.hengyunsoft.commons.context.BaseContextHandler;
import com.hengyunsoft.commons.utils.WrapsClassUtils;
import com.hengyunsoft.platform.admin.repository.authority.service.ResourceService;
import com.hengyunsoft.platform.developer.repository.apply.service.ApplicationService;
import com.hengyunsoft.platform.search.api.SearchApi;
import com.hengyunsoft.platform.search.dto.IndexItemResDTO;
import com.hengyunsoft.platform.search.dto.SeacherParamDTO;
import com.hengyunsoft.platform.search.dto.SearchResDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Api(value = "SearchApiImpl", description = "后台搜索")
@RestController
@RequestMapping("search")
@Slf4j
public class AdminSearchApiImpl {

    @Autowired
    private SearchApi searchApi;
    @Autowired
    private ApplicationService applicationService;
    @Autowired
    private ResourceService resourceService;


    @ApiOperation(value = "后台首页搜索", notes = "后台首页搜索")
    @RequestMapping(value = "", method = RequestMethod.POST)
    public Result<SearchResDTO> search(@RequestParam(value = "keyword") String keyword) {
        Long userId = BaseContextHandler.getAdminId();

        SeacherParamDTO param = new SeacherParamDTO();
        //关键词 和 菜单+应用 + 代办消息
        //() AND ( (type:MENU) OR (type:APPLICATION) OR (type:MSG AND bizId:{USERID}) )
        param.setCollections(AdminSearchCollections.ADMIN_SEARCH);

        param.setAppendCondition(String.format(" AND ( (type:%s) OR (type:%s) OR (type:%s AND retainField1:%s)) "
                , AdminSearchType.MENU.toString(), AdminSearchType.APPLICATION.toString(),
                AdminSearchType.MSG.toString(), userId));
        param.setKeyWords(keyword);
        param.setPageNo(1);
        param.setPageSize(100);
        param.setHighlighter(true);
        Result<SearchResDTO> result = searchApi.search(param);

        if (!(result.isSuccess() && result.getData() != null
                && result.getData().getDatas() != null
                && !result.getData().getDatas().isEmpty())) {
            return Result.success(null, "没有查到数据");
        }

        SearchResDTO searchRes = result.getData();
        List<IndexItemResDTO> list = searchRes.getDatas();

        //待验证 权限的 菜单和应用数据
        List<IndexItemResDTO> toBeVerifiedList = list.stream()
                .filter((item) -> "MENU".equalsIgnoreCase(item.getType()) || "APPLICATION".equalsIgnoreCase(item.getType())) //过滤掉消息
                .collect(Collectors.toList());

        if (!toBeVerifiedList.isEmpty()) {
            //待验证 权限的 菜单id
            List<Long> toBeVerifiedMenuList = toBeVerifiedList.stream()
                    .filter((item) -> "MENU".equalsIgnoreCase(item.getType()))
                    .map((item) -> WrapsClassUtils.longValueOf(item.getBizId())).collect(Collectors.toList());
            //待验证 权限的 应用id
            List<Long> toBeVerifiedApplicationList = toBeVerifiedList.stream()
                    .filter((item) -> "APPLICATION".equalsIgnoreCase(item.getType()))
                    .map((item) -> WrapsClassUtils.longValueOf(item.getBizId())).collect(Collectors.toList());


            //根据当前用户权限查具体拥有的菜单和应用
            List<Long> hasMenuList = new ArrayList<>();
            List<Long> hasApplicationList = new ArrayList<>();
            if (!toBeVerifiedMenuList.isEmpty()) {
                List<Long> tempList = resourceService.findMenuIdByUserId(toBeVerifiedMenuList, userId);
                hasMenuList.addAll(tempList);
            }
            if (!toBeVerifiedApplicationList.isEmpty()) {
                List<Long> tempList = applicationService.findAppIdByUserId(toBeVerifiedApplicationList, userId);
                hasApplicationList.addAll(tempList);
            }

            //将原始数据 过滤掉 没有权限的
            List<IndexItemResDTO> newList = list.stream().filter((item) ->
                    hasMenuList.contains(WrapsClassUtils.longValueOf(item.getBizId()))
                            || hasApplicationList.contains(WrapsClassUtils.longValueOf(item.getBizId()))
                            || "MSG".equalsIgnoreCase(item.getType()))
                    .collect(Collectors.toList());

            result.getData().setTotal(newList.size());
            result.getData().setDatas(newList);
        }

        return result;
    }

    //public static void main(String[] args) {
    //    List<IndexItemResDTO> list = new ArrayList<>();
    //    IndexItemResDTO it = new IndexItemResDTO();
    //    it.setType("APPLICATION");
    //    it.setBizId("2");
    //    it.setTitle("aaa");
    //    list.add(it);
    //    it = new IndexItemResDTO();
    //    it.setType("MENU");
    //    it.setBizId("3");
    //    it.setTitle("bbb");
    //    list.add(it);
    //    it = new IndexItemResDTO();
    //    it.setType("MSG");
    //    it.setBizId("1");
    //    it.setRetainField1("1");
    //    it.setTitle("bbb");
    //    list.add(it);
    //
    //
    //    //待验证 权限的 菜单和应用数据
    //    List<IndexItemResDTO> toBeVerifiedList = list.stream()
    //            .filter((item) -> "MENU".equalsIgnoreCase(item.getType()) || "APPLICATION".equalsIgnoreCase(item.getType())) //过滤掉消息
    //            .collect(Collectors.toList());
    //
    //    if(!toBeVerifiedList.isEmpty()){
    //        //待验证 权限的 菜单id
    //        List<Long> toBeVerifiedMenuList = toBeVerifiedList.stream()
    //                .filter((item) -> "MENU".equalsIgnoreCase(item.getType()))
    //                .map((item) -> WrapsClassUtils.longValueOf(item.getBizId())).collect(Collectors.toList());
    //        //待验证 权限的 应用id
    //        List<Long> toBeVerifiedApplicationList = toBeVerifiedList.stream()
    //                .filter((item) -> "APPLICATION".equalsIgnoreCase(item.getType()))
    //                .map((item) -> WrapsClassUtils.longValueOf(item.getBizId())).collect(Collectors.toList());
    //
    //
    //        List<Long> hasMenuList = new ArrayList<>();
    //        List<Long> hasApplicationList = new ArrayList<>();
    //        //查权限
    //        if(!toBeVerifiedMenuList.isEmpty()){
    //            List<Long> tempList = new ArrayList<>();//模拟一个都查不到
    //            hasMenuList.addAll(tempList);
    //        }
    //        if(!toBeVerifiedApplicationList.isEmpty()){
    //            List<Long> tempList = new ArrayList<>();
    //            tempList.add(3L);
    //            hasApplicationList.addAll(tempList);
    //        }
    //
    //        //将原始数据 过滤掉 没有权限的
    //        List<IndexItemResDTO> newList = list.stream().filter((item) ->
    //                hasMenuList.contains(WrapsClassUtils.longValueOf(item.getBizId()))
    //                        || hasApplicationList.contains(WrapsClassUtils.longValueOf(item.getBizId()))
    //                        || "MSG".equalsIgnoreCase(item.getType()))
    //                .collect(Collectors.toList());
    //
    //
    //        System.out.println(newList.size());
    //
    //
    //    }
    //    System.out.println("---");
    //
    //}
}
