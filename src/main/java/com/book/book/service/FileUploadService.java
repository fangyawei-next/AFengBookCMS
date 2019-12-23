package com.book.book.service;

public interface FileUploadService {

	//查询数据库是否有该文件的名字
	String findByFileName(String name);
	
	//添加文件表数据
	void addAll(String oriName,String extName,String imgUrl,String name);

}
