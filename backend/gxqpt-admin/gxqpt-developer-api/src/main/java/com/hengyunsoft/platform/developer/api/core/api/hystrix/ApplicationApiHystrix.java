package com.hengyunsoft.platform.developer.api.core.api.hystrix;

import com.github.pagehelper.PageInfo;
import com.hengyunsoft.base.Result;
import com.hengyunsoft.page.plugins.openapi.OpenApiReq;
import com.hengyunsoft.platform.developer.api.core.api.ApplicationApi;
import com.hengyunsoft.platform.developer.api.core.dto.application.*;
import com.hengyunsoft.platform.developer.api.core.dto.apply.ApplicationApplyAuditDTO;
import com.hengyunsoft.platform.developer.api.core.dto.apply.ApplicationApplySaveDTO;
import com.hengyunsoft.platform.developer.api.core.dto.user.UserManagerReqDTO;
import com.hengyunsoft.platform.developer.api.core.dto.user.UserResDTO;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public class ApplicationApiHystrix implements ApplicationApi {
    @Override
    public Result<List<AppQueryDTO>> findAppListByName(String name) {
        return Result.timeout();
    }

    @Override
    public Result<List<AppShowDto>> findAppIdList(Long type) {
        return Result.timeout();
    }

    @Override
    public Result<List<ApplicationResDTO>> find() {
        return Result.timeout();
    }

    @Override
    public Result<String> getAppFullRootUrl(String appId) {
        return Result.timeout();
    }

    @Override
    public Result<PageInfo<UserResDTO>> pageAppManager(OpenApiReq<UserManagerReqDTO> openApiReq) {
        return Result.timeout();
    }

    @Override
    public Result<Boolean> deleteAppManager(Long userId, String appId) {
        return Result.timeout();
    }

    @Override
    public Result<Boolean> saveAppManager(Long userId, String appId) {
        return Result.timeout();
    }

    @Override
    public Result<ApplicationDetailsDTO> getDetails(Long id) {
        return Result.timeout();
    }

    @Override
    public Result<Boolean> updateApp(ApplicationUpdateDTO applicationUpdate) {
        return Result.timeout();
    }

    @Override
    public Result<Boolean> saveApply(ApplicationApplySaveDTO applicationApplySave) {
        return Result.timeout();
    }

    @Override
    public Result<Boolean> saveApp(ApplicationApplyAuditDTO applicationApplyAudit) {
        return Result.timeout();
    }

    @Override
    public Result<PageInfo<ApplicationAllDTO>> findAll(OpenApiReq<ApplicationAllReqDTO> openApiReq) {
        return Result.timeout();
    }

    @Override
    public Result<List<ApplicationAllDTO>> findAllList() {
        return Result.timeout();
    }

    @Override
    public Result<List<ApplicationSelectDTO>> findByType(Short type) {
        return Result.timeout();
    }

    @Override
    public Result<List<ApplicationSelectDTO>> findAppTypeAll(String type) {
        return Result.timeout();
    }

    @Override
    public Result<PageInfo<AppRelationRetDTO>> getApplicationRelation(OpenApiReq<AppQueryDTO> openApiReq) {
        return Result.timeout();
    }

    @Override
    public Result<String> saveApplicationRelation(AppRelationDTO appRelationDTO) {
        return Result.timeout();
    }

    @Override
    public Result<String> deleteAppRelation(Long id) {
        return Result.timeout();
    }

    @Override
    public Result<PageInfo<ApplicationResDTO>> findLike(OpenApiReq<ApplicationLikeDTO> openApiReq) {
        return Result.timeout();
    }

	@Override
	public Result<List<ApplicationResDTO>> findAppVisibleForSelf(Integer type) {
		 return Result.timeout();
	}

    @Override
    public Result<PageInfo<ApplicationResDTO>> pageAppVisibleForSelf(OpenApiReq<Integer> openApiReq) {
        return Result.timeout();
    }

    @Override
    public Result<PageInfo<ApplicationResDTO>> pageAppVisibleForSelfName(OpenApiReq<RequestAppNameDTO> openApiReq) {
        return Result.timeout();
    }

    @Override
	public Result<List<CountOrgApplicationDTO>> countOrgApplication(Boolean status) {
		return Result.timeout();
	}

	@Override
	public Result<List<String>> getAllUseableJryy() {
		return Result.timeout();
	}

    @Override
    public Result<PageInfo<ResponseApplicationDTO>> findByAppIdList(OpenApiReq<RequestApplicationDTO> openApiReq) {
        return Result.timeout();
    }

    @Override
    public Result<Map<String, List<ApplicationFiveSupportResDTO>>> findFiveSupport() {
        return Result.timeout();
    }

	@Override
	public Result<String> getAppSecret(String appId) {
		return Result.timeout();
	}

	@Override
	public Result<ApplicationAllDTO> getAppInforByAppId(String appId) {
		return Result.timeout();
	}

    @Override
    public Result<List<AppShowDto>> findAppByAdminWithEnable(Long type) {
        return Result.timeout();
    }

    @Override
    public Result<List<ApplicationResDTO>> findAppByPower(Long type) {
        return Result.timeout();
    }

    @Override
    public Result<List<ApplicationAllDTO>> findAllLike(ApplicationAllReqDTO dto) {
        return Result.timeout();
    }

	@Override
	public Result<PageInfo<ApplicationAllDTO>> PageAllLike(ApplicationAllReqDTO dto) {
		return Result.timeout();
	}

    @Override
    public Result<List<AppShowDto>> findAppIdListByPt(Long type) {
        return Result.timeout();
    }
}
