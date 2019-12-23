package com.book.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

//import com.book.common.FastDFSClient;
//import com.github.tobato.fastdfs.domain.StorePath;

/**
 * 数据库跳转页面的Controller
 * @author Lenovo
 *
 */
@Controller
public class PageController {
	
	//跳转到用户列表
	@RequestMapping("user_manager/user/list")
	public String userList() {
		return "user_manager/user/list";
	}
	
	//跳转到图书列表
	@RequestMapping("book_manager/book/list")
	public String bookList() {
		return "book_manager/book/list";
	}
}
