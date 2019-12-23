package com.book.common;

import java.util.List;

/**
 * 封装图书返回的状态和类别
 * @author Lenovo
 *
 */
public class BookResultSortState {
	
	private List<?> sortList;
	
	private List<?> stateList;

	public List<?> getSortList() {
		return sortList;
	}

	public void setSortList(List<?> sortList) {
		this.sortList = sortList;
	}

	public List<?> getStateList() {
		return stateList;
	}

	public void setStateList(List<?> stateList) {
		this.stateList = stateList;
	}
	

}
