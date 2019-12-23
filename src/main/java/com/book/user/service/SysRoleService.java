package com.book.user.service;

import java.util.List;

import com.book.base.service.BaseService;
import com.book.pojo.SysRole;

public interface SysRoleService extends BaseService<SysRole> {

	//查询所有的list集合
	List<SysRole> list();
	
}
