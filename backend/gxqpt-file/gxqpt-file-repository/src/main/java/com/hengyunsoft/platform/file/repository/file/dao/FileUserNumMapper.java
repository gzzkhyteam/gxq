package com.hengyunsoft.platform.file.repository.file.dao;

import com.hengyunsoft.platform.file.entity.file.domain.FileDataTypeDevViewDO;
import com.hengyunsoft.platform.file.entity.file.domain.FileDevViewDO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FileUserNumMapper extends com.hengyunsoft.base.dao.BaseAllDao<Long, com.hengyunsoft.platform.file.entity.file.po.FileUserNum, com.hengyunsoft.platform.file.repository.file.example.FileUserNumExample> {

    FileDevViewDO getYearMonthNum(@Param("userId") Long userId, @Param("yearMonth") String yearMonth,@Param("appId") String appId);

    List<FileDataTypeDevViewDO> getFileDataType(@Param("userId") Long userId, @Param("yearMonth") String yearMonth, @Param("appId")String appId);
}
