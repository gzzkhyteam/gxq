//package com.hengyunsoft.platform.file.api.hystrix;
//
//import com.hengyunsoft.base.Result;
//import com.hengyunsoft.platform.file.api.FileDataApi;
//import com.hengyunsoft.platform.file.dto.*;
//import org.springframework.stereotype.Component;
//
//import java.util.List;
//
///**
// * @author madengbo
// * @create 2018-09-06 08:27
// * @desc
// * @Version 1.0
// **/
//
//@Component
//public class FileDataApiHystrix implements FileDataApi {
//    @Override
//    public Result<FileDataViewDTO> getMyFileDataView() {
//        return  Result.timeout();
//    }
//
//    @Override
//    public Result<FileTypeViewDTO> getMyFileTypeView() {
//        return  Result.timeout();
//    }
//
//    @Override
//    public Result<FileShareViewDTO> getFileShareData() {
//        return Result.timeout();
//    }
//
//    @Override
//    public Result<List<FileDevViewDTO>> getFileDev(String startTime, String endTime) {
//        return Result.timeout();
//    }
//
//    @Override
//    public Result<List<FileDataTypeDevViewDTO>> getFileDataTypeDev(String startTime, String endTime) {
//        return Result.timeout();
//    }
//}
