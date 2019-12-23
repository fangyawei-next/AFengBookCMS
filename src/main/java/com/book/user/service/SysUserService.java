package com.book.user.service;

import java.util.List;

import com.book.base.service.BaseService;
import com.book.common.EasyUIDataGridResult;
import com.book.common.ResultListUtil;
import com.book.common.ResultUtil;
import com.book.pojo.SysUser;
import com.book.pojo.SysUserDetail;

public interface SysUserService extends BaseService<SysUser> {

	//登录
	ResultUtil login(SysUser sysUser);
	
	//根据用户名查询用户
	ResultUtil verifyUsername(String username);

	//注册
	ResultUtil enrol(SysUser sysUser);

	//用户列表
//	EasyUIDataGridResult userList(SysUser user);
	EasyUIDataGridResult userList(SysUser user,int page,int rows);

	//删除
	ResultUtil delete(String userId);

	//添加用户及其详情
	ResultUtil addAndDetail(SysUser sysUser);

	//根据id查询用户及详情
	ResultUtil findUserById(Long userId);

	//更新用户
	ResultUtil update(SysUser sysUser);
	
}
