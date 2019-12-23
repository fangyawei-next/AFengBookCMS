package com.book.wxuser.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.book.common.ResultUtil;
import com.book.pojo.SysUser;
import com.book.wxuser.service.WxSysUserService;

/**
 * 微信小程序的SysUserController类
 * @author Lenovo
 *
 */
@Controller
public class WxSysUserController {
	
	@Resource
	private WxSysUserService wxSysUserService;
	
	@RequestMapping("/wxLogin")
	@ResponseBody
	public ResultUtil login(SysUser sysUser) {
		System.out.println("微信小程序进来了"+sysUser);
		ResultUtil result = wxSysUserService.login(sysUser);
		return result;
	}
}
