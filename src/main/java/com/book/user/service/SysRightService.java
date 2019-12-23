package com.book.user.service;

import java.util.List;

import com.book.base.service.BaseService;
import com.book.common.EasyUITreeNode;
import com.book.pojo.SysRight;

public interface SysRightService extends BaseService<SysRight> {

	//查询所有的,树状图列表
	List<EasyUITreeNode> selectTreeToAll();
	
	////查询所有的,树状图列表 根据权限查
	List<EasyUITreeNode> selectTreeToAll(Object userId);

}
