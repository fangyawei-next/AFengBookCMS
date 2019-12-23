package com.book.book.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.book.book.service.BookService;
import com.book.common.EasyUIDataGridResult;
import com.book.common.ResultUtil;
import com.book.pojo.Book;

@Controller
public class BookController {
	
	@Resource
	private BookService bookService;
	
	//图书列表
	@RequestMapping("/book/list")
	@ResponseBody
	//@DateTimeFormat(pattern="yyyy-MM-dd")
	public EasyUIDataGridResult userList(Book book,int page,int rows) {
		return bookService.bookList(book,page,rows);
	}
	
	//添加图书
	@RequestMapping("/book/add")
	@ResponseBody
	public ResultUtil add(Book book) {
		return bookService.add(book);
	}
	
	//删除图书
	@RequestMapping("/book/delete")
	@ResponseBody
	public ResultUtil delete(String id) {
		return bookService.delete(id);
	}
	
	//根据id查询图书列表
	@RequestMapping("/book/findBookById")
	@ResponseBody
	public ResultUtil findUserById(Long id) {
		return bookService.findBookById(id);
	}
	
	//更新图书
	@RequestMapping("/book/update")
	@ResponseBody
	public ResultUtil update(Book book) {
		return bookService.update(book);
	}
}
