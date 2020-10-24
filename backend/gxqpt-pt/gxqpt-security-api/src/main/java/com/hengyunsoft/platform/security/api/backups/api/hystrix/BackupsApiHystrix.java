//package com.hengyunsoft.platform.security.api.backups.api.hystrix;
//
//import com.github.pagehelper.PageInfo;
//import com.hengyunsoft.base.Result;
//import com.hengyunsoft.page.plugins.openapi.OpenApiReq;
//import com.hengyunsoft.platform.security.api.backups.api.BackupsApi;
//import com.hengyunsoft.platform.security.api.backups.dto.*;
//
//public class BackupsApiHystrix implements BackupsApi {
//
//    @Override
//    public Result<PageInfo<ShareResponseBackupsFindListDTO>> backupsFind(OpenApiReq<ShareRequestBackupsFindListDTO> openApiReq) {
//        return Result.timeout();
//    }
//
//    @Override
//    public Result<ShareResponseBackupsSaveDTO> backupsSave(ShareRequestBackupsSaveDTO dto) {
//        return Result.timeout();
//    }
//
//    @Override
//    public Result<Integer> backupsUpdate(ShareRequestBackupsUpdateDTO dto) {
//        return Result.timeout();
//    }
//}
