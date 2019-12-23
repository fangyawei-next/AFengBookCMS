package com.book.book.service;

import com.book.common.EasyUIDataGridResult;
import com.book.common.ResultUtil;
import com.book.pojo.Book;

public interface BookService {

	//图书列表
	EasyUIDataGridResult bookList(Book book, int page, int rows);

	//添加图书
	ResultUtil add(Book book);

	//删除图书
	ResultUtil delete(String id);

	//根据id查询图书
	ResultUtil findBookById(Long id);

	//更新图书
	ResultUtil update(Book book);

}
