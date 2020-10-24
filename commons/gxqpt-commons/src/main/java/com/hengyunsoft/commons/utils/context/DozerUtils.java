package com.hengyunsoft.commons.utils.context;

import com.github.pagehelper.Page;
import org.dozer.Mapper;
import org.dozer.MappingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * 很诡异，DozerUtils 工具类不能以 xxMapper 结尾
 *
 * @author tyh
 * @createTime 2017-12-08 14:41
 */
@Component
public class DozerUtils {
    @Autowired
    private Mapper mapper;

    /**
     * Constructs new instance of destinationClass and performs mapping between from source
     *
     * @param source
     * @param destinationClass
     * @param <T>
     * @return
     * @throws MappingException
     */
    public <T> T map(Object source, Class<T> destinationClass) {
        if (source == null) {
            return null;
        }
        return mapper.map(source, destinationClass);
    }
    public <T> T map2(Object source, Class<T> destinationClass) {
        if (source == null) {
            try {
                return destinationClass.newInstance();
            }catch (Exception e){
            }
        }
        return mapper.map(source, destinationClass);
    }

    /**
     * Performs mapping between source and destination objects
     *
     * @param source
     * @param destination
     * @throws MappingException
     */
    public void map(Object source, Object destination) {
        if (source == null) {
            return;
        }
        mapper.map(source, destination);
    }

    /**
     * Constructs new instance of destinationClass and performs mapping between from source
     *
     * @param source
     * @param destinationClass
     * @param mapId
     * @param <T>
     * @return
     * @throws MappingException
     */
    public <T> T map(Object source, Class<T> destinationClass, String mapId) {
        if (source == null) {
            return null;
        }
        return mapper.map(source, destinationClass, mapId);
    }

    /**
     * Performs mapping between source and destination objects
     *
     * @param source
     * @param destination
     * @param mapId
     * @throws MappingException
     */
    public void map(Object source, Object destination, String mapId) {
        if(source == null){
            return ;
        }
        mapper.map(source, destination, mapId);
    }

    /**
     * 将集合转成集合
     * List<A> -->  List<B>
     *
     * @param sourceList       源集合
     * @param destinationClass 待转类型
     * @param <T>
     * @return
     */
    public <E, T> List<T> mapList(Collection<E> sourceList, Class<T> destinationClass) {
//        if (sourceList == null || sourceList.isEmpty() || destinationClass == null) {
//            return Collections.emptyList();
//        }
//        return sourceList.stream().map((sourceObject) -> mapper.map(sourceObject, destinationClass)).collect(Collectors.toList());
    	return  mapPage(sourceList, destinationClass);
    }

    public <T, E> List<T> mapPage(Collection<E> sourceList, Class<T> destinationClass) {
        if (sourceList == null || sourceList.isEmpty()||  destinationClass == null) {
            return Collections.emptyList();
        }
        List<T> destinationList = sourceList.stream()
                .map((sourceObject) -> mapper.map(sourceObject, destinationClass))
                .collect(Collectors.toList());
        //List destinationList = Lists.newArrayList();
        //for (Object sourceObject : sourceList) {
        //    Object destinationObject = mapper.map(sourceObject, destinationClass);
        //    destinationList.add(destinationObject);
        //}
        if (sourceList instanceof Page) {
            Page<T> sourcePage = (Page<T>) sourceList;
            sourcePage.clear();
            sourcePage.addAll(destinationList);
            return sourcePage;
        }
        return destinationList;
    }

    public <T, E> Set<T> mapSet(Collection<E> sourceList, Class<T> destinationClass) {
        if (sourceList == null || sourceList.isEmpty() || destinationClass == null) {
            return Collections.emptySet();
        }
        return sourceList.stream().map((sourceObject) -> mapper.map(sourceObject, destinationClass)).collect(Collectors.toSet());
    }
}
