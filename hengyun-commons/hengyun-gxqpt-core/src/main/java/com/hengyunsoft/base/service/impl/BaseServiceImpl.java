package com.hengyunsoft.base.service.impl;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import com.hengyunsoft.base.dao.BaseNormalDao;
import com.hengyunsoft.base.entity.BaseEntity;
import com.hengyunsoft.base.entity.CommonBaseEntity;
import com.hengyunsoft.base.id.IdGenerate;
import com.hengyunsoft.base.service.normal.BaseService;
import com.hengyunsoft.db.example.BaseExample;
import com.hengyunsoft.exception.BizException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

/**
 * @author tyh
 * @createTime 2017-12-08 17:33
 */
public abstract class BaseServiceImpl<I extends Serializable, T extends BaseEntity<I>, TE extends BaseExample>
        implements BaseService<I, T, TE> {

    protected abstract BaseNormalDao<I, T, TE> getDao();

    @Autowired
    private IdGenerate<I> idGenerator;
    @Override
    public  I genId() {
        return idGenerator.generate();
    }


    @Override
    public T save(T entity) {
        if (entity == null) {
            throw new RuntimeException("不允许保存空对象");
        }
        setSaveTimes(entity);
        entity.setId(genId());
        getDao().insert(entity);
        return entity;
    }

    @Override
    public Collection<T> save(Collection<T> list) {
        if (list == null) {
            throw new RuntimeException("list is null");
        }
        for (T t : list) {
            save(t);
        }
        return list;
    }

    @Override
    public T saveSelective(T entity) {
        if (entity == null) {
            throw new RuntimeException("不允许保存空对象");
        }
        setSaveTimes(entity);
        entity.setId(genId());
        getDao().insertSelective(entity);
        return entity;
    }

	protected void setSaveTimes(T entity) {
        if (entity instanceof CommonBaseEntity) {
            CommonBaseEntity<I> t = (CommonBaseEntity<I>) entity;
            Date nowDate = new Date();
            if(t.getCreateTime() == null){
                t.setCreateTime(nowDate);
            }
            if(t.getUpdateTime() == null){
                t.setUpdateTime(nowDate);
            }
        }
        if (entity instanceof BaseEntity) {
			BaseEntity<I> t = (BaseEntity<I>) entity;
            Date nowDate = new Date();
            if(t.getCreateTime() == null){
                t.setCreateTime(nowDate);
            }
            if(t.getUpdateTime() == null){
                t.setUpdateTime(nowDate);
            }
        }
    }

    protected void setUpdateTimes(T entity) {
        if (entity instanceof CommonBaseEntity) {
            CommonBaseEntity<I> t = (CommonBaseEntity<I>) entity;
            Date nowDate = new Date();
            if(t.getUpdateTime() == null){
                t.setUpdateTime(nowDate);
            }
        }
        if (entity instanceof BaseEntity) {
			BaseEntity<I> t = (BaseEntity<I>) entity;
            Date nowDate = new Date();
            if(t.getUpdateTime() == null){
                t.setUpdateTime(nowDate);
            }
        }
    }

    @Override
    public T getUnique(TE example) {
        if (example == null) {
            return null;
        }
        return getDao().selectEntity(example);
    }

    @Override
    public List<T> find(TE example) {
        return getDao().selectByExample(example);
    }

    @Override
    public int count(TE example) {
        return getDao().countByExample(example);
    }

	@Override
	public T getById(I id) {
		return getDao().selectByPrimaryKey(id);
	}

	@Override
	public int updateById(T entity) {
		return doUpdateById(entity,false);
	}

	private int doUpdateById(T entity,boolean isSelectiveUpdate) {
		setUpdateTimes(entity);
		if (entity instanceof CommonBaseEntity) {
			//不允许更改appid
            CommonBaseEntity<I> baseEntity = (CommonBaseEntity<I>) entity;
            String appId = baseEntity.getAppId();
            int rows = 0;
            if(isSelectiveUpdate) {
            	baseEntity.setAppId(null);
            	rows = getDao().updateByPrimaryKeySelective(entity);
            } else {
            	//String appIdDb = getBaseDao().selectAppIdById(entity.getId());
            	//baseEntity.setAppId(appIdDb);
            	rows = getDao().updateByPrimaryKey(entity);
            }
            baseEntity.setAppId(appId);
            return rows;
        } else {
        	if(isSelectiveUpdate) {
            	return getDao().updateByPrimaryKeySelective(entity);
            } else {
            	return  getDao().updateByPrimaryKey(entity);
            }
        }
	}
	
	@Override
	public int updateByIds(Collection<T> entitys) {
		
		if(CollectionUtils.isEmpty(entitys)) {
			return 0;
		}
		int rows = 0;
		for (T t : entitys) {
			rows += updateById(t);
		}
		return rows;
	}


	@Override
	public int updateByIdSelective(T entity) {
		return doUpdateById(entity, true);
	}


	@Override
	public int updateByIdSelective(Collection<T> entitys) {
		if(CollectionUtils.isEmpty(entitys)) {
			return 0;
		}
		int rows = 0;
		for (T t : entitys) {
			rows += updateByIdSelective(t);
		}
		return rows;
	}

	@Override
	public int deleteById(I id) {
		if(StringUtils.isEmpty(id)) {
			return 0;
		}

		return getDao().deleteByPrimaryKey(id);
	}

	@Override
	public int deleteByIds(Collection<I> ids) {
		
		if(CollectionUtils.isEmpty(ids)) {
			return 0;
		}
		int rows = 0;
		for (I t : ids) {
			rows += deleteById(t);
		}
		return rows;
	}

	@Override
	public int removeById(I id) throws BizException {
		if(StringUtils.isEmpty(id)) {
			return 0;
		}
		return getDao().removeByPrimaryKey(id);
	}

	@Override
	public int removeByIds(Collection<I> ids) throws BizException {
		if(CollectionUtils.isEmpty(ids)) {
			return 0;
		}
		int rows = 0;
		for (I t : ids) {
			rows += removeById(t);
		}
		return rows;
	}
}
