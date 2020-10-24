//package com.hengyunsoft.platform.security.api.backups.api;
//
//import com.github.pagehelper.PageInfo;
//import com.hengyunsoft.base.Result;
//import com.hengyunsoft.page.plugins.openapi.OpenApiReq;
//import com.hengyunsoft.platform.security.api.backups.dto.*;
//import org.springframework.cloud.netflix.feign.FeignClient;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//
//import java.util.List;
//
///**
// * 描述：安全保障平台-备份管理
// *
// * @author wt
// * @date 2018/6/29
// */
//@FeignClient(name = "${gxqpt.gate.feign.server:gxqpt-pt-server}", path = "/api/security", fallback = BackupsApi.class)
//public interface BackupsApi {
//
//    /**
//     * @todo 查询备份数据列表
//     * @param OpenApiReq<ShareRequestProgramFindDTO>
//     * @return PageInfo<ShareResponseProgramFindDTO>
//     * @Author wt
//     * @createtime 2018-6-29
//     */
//    @RequestMapping(value = "/backups/findList", method = RequestMethod.POST)
//    Result<PageInfo<ShareResponseBackupsFindListDTO>> backupsFind(@RequestBody OpenApiReq<ShareRequestBackupsFindListDTO> openApiReq);
//
//    /**
//     * @todo 保存备份数据
//     * @param ShareRequestBackupsSaveDTO
//     * @return Boolean
//     * @Author wt
//     * @createtime 2018-6-29
//     */
//    @RequestMapping(value = "/backups/save", method = RequestMethod.POST)
//    Result<ShareResponseBackupsSaveDTO> backupsSave(@RequestBody ShareRequestBackupsSaveDTO dto);
//
//    /**
//     * @todo 更新备份数据
//     * @param ShareRequestBackupsUpdateDTO 系统表
//     * @return Boolean
//     * @Author wt
//     * @createtime 2018-6-29
//     */
//    @RequestMapping(value = "/backups/update", method = RequestMethod.POST)
//    Result<Integer> backupsUpdate(@RequestBody ShareRequestBackupsUpdateDTO dto);
//}
