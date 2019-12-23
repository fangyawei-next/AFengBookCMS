package com.book.common;

import java.io.Serializable;
import java.util.List;

/**
 * 分页查询
 * @author Lenovo
 *
 */
//可以结合@ResponseBody
//返回{total:"2",rows:[{"id":"1","name":"张三"},{"id":"2","name":"李四"}]}
public class EasyUIDataGridResult implements Serializable {
	
	//有几条数据
	private Long total;
	//将要显示的数据
	private List<?> rows;
	
	//对应的get,set方法
	public Long getTotal() {
		return total;
	}
	public void setTotal(Long total) {
		this.total = total;
	}
	public List<?> getRows() {
		return rows;
	}
	public void setRows(List<?> rows) {
		this.rows = rows;
	}
	
}
