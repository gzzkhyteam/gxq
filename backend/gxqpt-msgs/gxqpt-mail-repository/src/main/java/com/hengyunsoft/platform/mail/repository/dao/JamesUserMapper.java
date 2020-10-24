package com.hengyunsoft.platform.mail.repository.dao;

import com.hengyunsoft.platform.mail.entity.po.JamesUser;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

/**
 * This is a Description
 *
 * @auth tangyh
 * @date 2018/07/26
 */
@Repository
public interface JamesUserMapper {
    int insert(JamesUser jamesUser);

    int count(String name);

    int getAllCount();

    List<String> getCopyAccount(@Param("startDate") Date startDate, @Param("endDate") Date endDate);
}
