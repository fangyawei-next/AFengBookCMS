package com.book.user.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.book.common.EasyUITreeNode;
import com.book.pojo.SysUser;
import com.book.user.service.SysRightService;

@Controller
public class SysRightController {
	
	@Resource
	private SysRightService sysRightService;
	
	//跳转到main页面
	@RequestMapping("/tomain")
	public String toMain(){
		return "main";
	}
	
	//树状图列表
	@RequestMapping("/tree")
	@ResponseBody
	public List<EasyUITreeNode> tree(HttpSession session) {
		SysUser sysUser = (SysUser) session.getAttribute("sysUser");
		return sysRightService.selectTreeToAll(sysUser.getUserId());
	}
	
}
