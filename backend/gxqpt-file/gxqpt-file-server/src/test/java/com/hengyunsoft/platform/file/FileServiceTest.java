package com.hengyunsoft.platform.file;

import java.util.Arrays;

import com.hengyunsoft.platform.file.entity.file.po.FileRecycle;
import com.hengyunsoft.platform.file.repository.file.dao.FileMapper;
import com.hengyunsoft.platform.file.repository.file.dao.FileRecycleMapper;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * This is a Description
 *
 * @auth tangyh
 * @date 2018/06/07
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@Slf4j
public class FileServiceTest {
    @Autowired
    private FileMapper fileMapper;

    @Test
    public void testRemoveById(){
        fileMapper.removeByPrimaryKey(3L);
    }
    @Test
    public void testselectAppIdById(){
        String appId = fileMapper.selectAppIdById(3L);
        log.info(appId);
    }
    @Test
    public void testRemoveAppidByid(){
        fileMapper.removeByAppIdAndId("45kj6352", 3L);
    }
    @Test
    public void testRemoveAppidByids(){
        fileMapper.removeByAppIdAndIds("45kj6352", Arrays.asList(3L));

    }
    @Test
    public void testDeleteById(){
        fileMapper.deleteByAppIdAndId("45kj6352", 3L);
    }
    @Test
    public void testDeleteByIds(){

        fileMapper.deleteByAppIdAndIds("45kj6352", Arrays.asList(3L));
    }

}
