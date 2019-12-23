package com.book.user.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.book.base.service.impl.BaseServiceImpl;
import com.book.mapper.SysRoleMapper;
import com.book.mapper.SysUserMapper;
import com.book.pojo.SysRole;
import com.book.user.service.SysRoleService;

@Service
public class SysRoleServiceImpl extends BaseServiceImpl<SysRole> implements SysRoleService {
	
	private SysRoleMapper sysRoleMapper;
	@Resource
	public void setMapper(SysRoleMapper mapper) {
		super.setBaseMapper(mapper);
		this.sysRoleMapper = mapper;
	}
	
	@Override
	public List<SysRole> list() {
		// TODO Auto-generated method stub
		return sysRoleMapper.selectByExample(null);
	}
}
