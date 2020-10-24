package com.hengyunsoft.platform.search.api.hystrix;

import com.hengyunsoft.base.Result;
import com.hengyunsoft.platform.search.api.SearchApi;
import com.hengyunsoft.platform.search.dto.*;
import org.springframework.stereotype.Component;

@Component
public class SearchApiHystrix implements SearchApi {

    @Override
    public Result<CollectionDTO> createCollection(CollectionDTO collectionDTO) {
        return Result.timeout();
    }

    @Override
    public Result<Boolean> addOrUpdateIndex(IndexItemDTO indexItemDTO) {
        return Result.timeout();
    }

    @Override
    public Result<SearchResDTO> search(SeacherParamDTO param) {
        return Result.timeout();
    }

    @Override
    public Result<SearchResDTO> searchNoVerify(SeacherParamDTO seacherParamDTO) {
        return Result.timeout();
    }

    @Override
    public Result<AnalysisResDTO> analysisField(String keyWord, String queryWord, String collection, String field) {
        return Result.timeout();
    }

    @Override
    public Result<Boolean> remove(String collection, String id) {
        return Result.timeout();
    }


}
