package com.book.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BaseMapper<T> {
	
	int deleteByPrimaryKey(Object id);
	
	int insertSelective(T record);
	
	T selectByPrimaryKey(Object id);
	
	int updateByPrimaryKeySelective(T record);
} 
