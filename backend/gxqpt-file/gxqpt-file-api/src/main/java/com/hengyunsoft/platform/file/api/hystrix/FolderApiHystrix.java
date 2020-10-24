//package com.hengyunsoft.platform.file.api.hystrix;
//
//import com.hengyunsoft.base.Result;
//import com.hengyunsoft.platform.file.api.FolderApi;
//import com.hengyunsoft.platform.file.dto.FolderDTO;
//import com.hengyunsoft.platform.file.dto.FolderSaveDTO;
//import com.hengyunsoft.platform.file.dto.FolderUpdateDTO;
//import org.springframework.stereotype.Component;
//
//import java.util.List;
//
///**
// * @author tyh
// * @createTime 2018-01-25 10:53
// */
//@Component
//public class FolderApiHystrix implements FolderApi {
//    @Override
//    public Result<FolderDTO> get(Long id) {
//        return Result.timeout();
//    }
//
//    @Override
//    public Result<List<FolderDTO>> list() {
//        return Result.timeout();
//    }
//
//    @Override
//    public Result<List<FolderDTO>> find(Long parentId) {
//        return Result.timeout();
//    }
//
//    @Override
//    public Result<List<FolderDTO>> tree() {
//        return Result.timeout();
//    }
//
//    @Override
//    public Result<FolderDTO> save(FolderSaveDTO folderSaveDto) {
//        return Result.timeout();
//    }
//
//    @Override
//    public Result<Boolean> update(FolderUpdateDTO folderUpdateDto) {
//        return Result.timeout();
//    }
//
//    @Override
//    public Result<Boolean> remove(Long id) {
//        return Result.timeout();
//    }
//}
