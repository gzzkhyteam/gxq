package com.hengyunsoft.mybatis.typehandler;


import org.apache.ibatis.type.Alias;

/**
 * 仅仅用于like查询
 * @author Administrator
 *
 */
@Alias("rigthLike")
public class RigthLikeTypeHandler extends BaseLikeTypeHandler {

    public RigthLikeTypeHandler() {
    	super(false, true);
    }
}

