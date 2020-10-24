package com.hengyunsoft.platform.mail.repository.dao;

import com.hengyunsoft.platform.mail.entity.core.po.FilterKeyword;
import com.hengyunsoft.platform.mail.entity.po.BWList;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author zjr
 * @date 2018/08/08
 */
@Repository
public interface BWListMapper extends com.hengyunsoft.base.dao.BaseNormalDao<Long, com.hengyunsoft.platform.mail.entity.po.BWList, com.hengyunsoft.platform.mail.repository.example.BWListExample> {
    /**
     * 查询黑名单分页列表
     * @param queryBWDto
     * @return
     */
    List<BWList> findBWList(@Param(value = "bw") BWList bw);

    /**
     * 查询当前用户的黑名单列表
     * @param bwType
     * @param localType
     * @param currentEmail
     * @return
     */
    List<String> getList(@Param("bwType") String bwType,@Param("localType") String localType,@Param("currentEmail") String currentEmail);

    int insertFilterKeyWord(@Param(value = "fk") FilterKeyword fk);

    int deleteFilterKeyWord(@Param("id") Long id);

    List<FilterKeyword> getFilterKeywordAll(@Param("filterWord")String filterWord);

}