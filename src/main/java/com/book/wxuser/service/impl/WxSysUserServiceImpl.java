package com.book.wxuser.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.book.base.service.impl.BaseServiceImpl;
import com.book.common.ResultUtil;
import com.book.mapper.SysUserMapper;
import com.book.pojo.SysUser;
import com.book.pojo.SysUserExample;
import com.book.pojo.SysUserExample.Criteria;
import com.book.wxuser.service.WxSysUserService;

@Service
public class WxSysUserServiceImpl extends BaseServiceImpl<SysUser> implements WxSysUserService {

	private SysUserMapper userMapper;
	@Resource
	public void setMapper(SysUserMapper mapper) {
		super.setBaseMapper(mapper);
		this.userMapper = mapper;
	}
	
	@Override
	public ResultUtil login(SysUser sysUser) {
		SysUserExample example = new SysUserExample();
		Criteria criteria = example.createCriteria();
		criteria.andUserNameEqualTo(sysUser.getUserName());
		criteria.andUserPasswordEqualTo(sysUser.getUserPassword());
		//有值返回200，没值返回404
		try {
			sysUser = userMapper.selectByExample(example).get(0);
			return ResultUtil.ok(sysUser);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			return ResultUtil.build(404, "登录失败");
		}
	}

}
