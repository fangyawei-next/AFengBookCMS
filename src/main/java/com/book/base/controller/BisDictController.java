package com.book.base.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.book.base.service.BisDictService;
import com.book.common.BookResultSortState;
import com.book.pojo.SysRole;

@Controller
public class BisDictController {
	
	@Resource
	private BisDictService bisDictService;
	
	@RequestMapping("/book/book/list")
	@ResponseBody
	public BookResultSortState list() {
		return bisDictService.list();
	}

}
