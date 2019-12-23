package com.book.base.service.impl;

import java.util.List;

import com.book.base.service.BaseService;
import com.book.mapper.BaseMapper;

//这是Service层,调用dao层=>mapper层
public class BaseServiceImpl<T> implements BaseService<T> {

	private BaseMapper<T> baseMapper;
	
	public BaseMapper<T> getBaseMapper() {
		return baseMapper;
	}
	
	//使用BaseServiceImpl的子类给baseMapper注入值
	//给baseMapper注入值,传入的参数可以是baseMapper的子类
	public void setBaseMapper(BaseMapper<T> baseMapper) {
		this.baseMapper = baseMapper;
	}

	@Override
	public void saveEntity(T entity) {
		// TODO Auto-generated method stub
		baseMapper.insertSelective(entity);
	}

	@Override
	public void updateEntity(T entity) {
		// TODO Auto-generated method stub
		baseMapper.updateByPrimaryKeySelective(entity);
	}

	@Override
	public void deleteByPrimaryKey(Object id) {
		// TODO Auto-generated method stub
		baseMapper.deleteByPrimaryKey(id);
	}

	@Override
	public T findEntityById(Object id) {
		// TODO Auto-generated method stub
		return baseMapper.selectByPrimaryKey(id);
	}
}
