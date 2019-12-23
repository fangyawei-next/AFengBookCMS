package com.book.user.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.book.pojo.SysRole;
import com.book.user.service.SysRoleService;

@Controller
public class SysRoleController {
	
	@Resource
	private SysRoleService sysRoleService;
	
	@RequestMapping("/user/role/list")
	@ResponseBody
	public List<SysRole> list() {
		return sysRoleService.list();
	}
}
