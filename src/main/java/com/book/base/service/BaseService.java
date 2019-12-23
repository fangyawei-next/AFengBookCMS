package com.book.base.service;

public interface BaseService<T> {
	//新增
	void saveEntity(T entity);
	
	//更新 需要传入Id
	void updateEntity(T entity);
	
	//删除 按照Id删除 id可能为 int(Integer)、String、Long类型
	void deleteByPrimaryKey(Object id);
	
	//根据Id查询(使用最多)
	T findEntityById(Object id);
}
