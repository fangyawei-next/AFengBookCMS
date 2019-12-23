package com.book.wxuser.service;

import com.book.base.service.BaseService;
import com.book.common.ResultUtil;
import com.book.pojo.SysUser;

public interface WxSysUserService extends BaseService<SysUser>{

	ResultUtil login(SysUser sysUser);

}
