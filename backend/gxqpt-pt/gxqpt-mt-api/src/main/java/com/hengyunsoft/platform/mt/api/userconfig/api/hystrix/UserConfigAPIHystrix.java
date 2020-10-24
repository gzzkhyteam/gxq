//package com.hengyunsoft.platform.mt.api.userconfig.api.hystrix;
//
//import com.hengyunsoft.base.Result;
//import com.hengyunsoft.platform.mt.api.userconfig.api.UserConfigAPI;
//import com.hengyunsoft.platform.mt.api.userconfig.dto.LoginResDTO;
//import com.hengyunsoft.platform.mt.api.userconfig.dto.RedMsgDTO;
//import com.hengyunsoft.platform.mt.api.userconfig.dto.UserOrgInfoDTO;
//
//import java.util.List;
//
//public class UserConfigAPIHystrix implements UserConfigAPI {
//
//    @Override
//    public Result<UserOrgInfoDTO> getMyOrgList() {
//        return Result.timeout();
//    }
//
//    @Override
//    public Result<Boolean> setNowUnitId(String unityId) {
//        return Result.timeout();
//    }
//
//    @Override
//    public Result<List<RedMsgDTO>> getRedMsg() {
//        return  Result.timeout();
//    }
//
//    @Override
//    public Result<LoginResDTO> mtMoveLogin(String account, String password) {
//        return  Result.timeout();
//    }
//
//    @Override
//    public Result<String> refreshToken() {
//        return  Result.timeout();
//    }
//}
