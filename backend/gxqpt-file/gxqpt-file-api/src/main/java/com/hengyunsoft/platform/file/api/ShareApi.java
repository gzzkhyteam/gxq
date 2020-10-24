//package com.hengyunsoft.platform.file.api;
//
//import com.github.pagehelper.PageInfo;
//import com.hengyunsoft.base.Result;
//import com.hengyunsoft.page.plugins.openapi.OpenApiReq;
//import com.hengyunsoft.platform.file.api.hystrix.ShareApiHystrix;
//import com.hengyunsoft.platform.file.dto.*;
//import org.springframework.cloud.netflix.feign.FeignClient;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;
//
//
//@FeignClient(name = "${gxqpt.feign.admin-server:gxqpt-file-server}", fallback = ShareApiHystrix.class)
//public interface ShareApi {
//
//    /**
//     * 根据id + token 查文件夹详情
//     *
//     * @param id
//     * @return
//     */
//    @RequestMapping(value = "/share/page", method = RequestMethod.POST)
//    Result<PageInfo<ShareFileDTO>> pageShareFileList(@RequestBody OpenApiReq<ShareFileLikeDTO> openApiReq);
//
//    /**
//     * 根据人员id查询列表
//     *
//     * @param
//     */
//    @RequestMapping(value = "/share/my/page", method = RequestMethod.POST)
//    Result<PageInfo<ShareDTO>> pageShareList(@RequestBody  OpenApiReq<Long> openApiReq);
//
////    /**
////     * 根据id + appid 删除条目
////     *
////     * @param id
////     */
////    @RequestMapping(value = "/share/delete",method = RequestMethod.GET)
////    Result<Boolean> delete(@RequestParam("id") Long id);
//
//    /**
//     * 根据ids + appid 删除条目
//     *
//     * @param
//     */
//    @RequestMapping(value = "/share/delete", method = RequestMethod.POST)
//    Result<Boolean> deleteList(@RequestParam(value = "ids[]") Long[] ids);
//
//    /**
//     * 根据文件实体添加条目
//     *
//     * @param
//     */
//    @RequestMapping(value = "/share/save", method = RequestMethod.POST)
//    Result<SaveShareRetDTO> save(@RequestBody SaveShareDTO saveShareDTO);
//
////    /**
////     * 根据shareId 查询列表
////     *
////     * @param
////     */
////    @RequestMapping(value = "/share/url/list", method = RequestMethod.GET)
////    Result<PageInfo<ShareFileDTO>> shareUrlList(OpenApiReq openApiReq,@RequestParam("id") String id);
//
//    /**
//     * 根据shareId 查询是否有密码
//     *
//     * @param
//     */
//    @RequestMapping(value = "/share/url/ispassword", method = RequestMethod.GET)
//    Result<ShareUrlDTO> shareUrlPasswordIsNotNull(@RequestParam(value = "id") Long id);
//
//    /**
//     * 根据password 查询密码是否正确
//     *
//     * @param
//     */
//    @RequestMapping(value = "/share/url/verify", method = RequestMethod.GET)
//    Result<Boolean> shareUrlVerify(@RequestParam(value = "id") Long id, @RequestParam(value = "sharePassword") String sharePassword);
//
//    /**
//     * 根据父文件id 查询子文件
//     *
//     * @param
//     */
//    @RequestMapping(value = "/share/findTree", method = RequestMethod.POST)
//    Result<PageInfo<ShareFileDTO>> findTree(@RequestBody OpenApiReq<ShareFileLikeDTO> openApiReq);
//
//}
