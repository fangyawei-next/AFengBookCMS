package com.book.base.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.book.base.service.BisDictService;
import com.book.common.BookResultSortState;
import com.book.mapper.BisDictMapper;
import com.book.mapper.BisDictSortMapper;
import com.book.pojo.BisDict;
import com.book.pojo.BisDictExample;
import com.book.pojo.BisDictSort;
import com.book.pojo.BisDictSortExample;

@Service
public class BisDictServiceImpl implements BisDictService {
	
	@Resource
	private BisDictMapper bisDictMapper;
	
	@Resource
	private BisDictSortMapper bisDictSortMapper;

	@Override
	public BookResultSortState list() {
		// TODO Auto-generated method stub
		//查询图书类别的id
		BisDictSortExample bisDictSortExample = new BisDictSortExample();
		bisDictSortExample.createCriteria().andSortNameEqualTo("图书类别");
		List<BisDictSort> bisDictSortList = bisDictSortMapper.selectByExample(bisDictSortExample);
		BisDictSort bisDictSort = null;
		Long sortId = null;
		if(bisDictSortList!=null) {
			bisDictSort = bisDictSortList.get(0);
			sortId = bisDictSort.getSortId();
		}
		BisDictExample sortExample = new BisDictExample();
		sortExample.createCriteria().andBisSortEqualTo(sortId);
		List<BisDict> sortList = bisDictMapper.selectByExample(sortExample);
		for (BisDict bisDict : sortList) {
			bisDict.setBisDictSort(bisDictSort);
		}
		
		//查询图书状态的id
		BisDictSortExample bisDictStateExample = new BisDictSortExample();
		bisDictStateExample.createCriteria().andSortNameEqualTo("图书状态");
		List<BisDictSort> bisDictStateList = bisDictSortMapper.selectByExample(bisDictStateExample);
		Long stateId = null;
		if(bisDictStateList!=null) {
			bisDictSort = bisDictStateList.get(0);
			stateId = bisDictSort.getSortId();
		}
		BisDictExample stateExample = new BisDictExample();
		stateExample.createCriteria().andBisSortEqualTo(stateId);
		List<BisDict> stateList = bisDictMapper.selectByExample(stateExample);
		for (BisDict bisDict : stateList) {
			bisDict.setBisDictSort(bisDictSort);
		}
		
		//把查询出来的数据放到result里面
		BookResultSortState result = new BookResultSortState();
		result.setSortList(sortList);
		result.setStateList(stateList);
		return result;
	}
}
