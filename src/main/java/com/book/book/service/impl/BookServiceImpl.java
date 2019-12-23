package com.book.book.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.book.book.service.BookService;
import com.book.common.EasyUIDataGridResult;
import com.book.common.ResultUtil;
import com.book.mapper.BookMapper;
import com.book.pojo.Book;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
public class BookServiceImpl implements BookService {
	
	@Resource
	private BookMapper bookMapper;

	//图书列表
//	@Override
//	public EasyUIDataGridResult bookList(Book book, int page, int rows) {
//		// TODO Auto-generated method stub
//		//设置启始页数，每页显示的条数
//		String orderBy ="id desc";//按照（数据库）排序字段 倒序 排序
//		PageHelper.orderBy(orderBy);
//		PageHelper.startPage(page, rows);
//		List<Book> list = bookMapper.selectByExample(null);
//		PageInfo pageInfo = new PageInfo(list);
//		EasyUIDataGridResult result = new EasyUIDataGridResult();
//		result.setRows(pageInfo.getList());
//		result.setTotal(pageInfo.getTotal());
//		return result;
//	}
	
	//图书列表
	@Override
	public EasyUIDataGridResult bookList(Book book, int page, int rows) {
		// TODO Auto-generated method stub
		//设置启始页数，每页显示的条数
		String orderBy ="id desc";//按照（数据库）排序字段 倒序 排序
		PageHelper.orderBy(orderBy);
		PageHelper.startPage(page, rows);
		List<Book> list = bookMapper.selectByExampleByLike(book);
		PageInfo pageInfo = new PageInfo(list);
		EasyUIDataGridResult result = new EasyUIDataGridResult();
		result.setRows(pageInfo.getList());
		result.setTotal(pageInfo.getTotal());
		return result;
	}

	//添加图书
	@Override
	public ResultUtil add(Book book) {
		// TODO Auto-generated method stub
		try {
			//如果状态是上架则创建上架时间
			if(book.getState()==52) {
				Date date = new Date();
				book.setStartDate(date);
			}
			int num = bookMapper.insert(book);
			if(num>0) {
				return ResultUtil.ok();
			}else {
				return ResultUtil.build(404, "图书添加失败");
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			return ResultUtil.build(404, "图书添加失败");
		}
	}

	//删除图书
	@Override
	public ResultUtil delete(String id) {
		// TODO Auto-generated method stub
		try {
			if(id!=null&&id!="") {
				bookMapper.deleteByIdToString(id);
				return ResultUtil.build(200, "删除成功!");
			}else {
				return ResultUtil.build(404, "删除失败!");
			}
		} catch (Exception e) {
			e.printStackTrace();
			return ResultUtil.build(404, "删除失败!");
		}
	}

	//根据id查询图书
	@Override
	public ResultUtil findBookById(Long id) {
		// TODO Auto-generated method stub
		try {
			Book book = bookMapper.selectByPrimaryKey(id);
			return ResultUtil.ok(book);
			//return ResultUtil.build(404, "查询Id为"+userId+"的用户失败!");
		} catch (Exception e) {
			return ResultUtil.build(404, "查询Id为"+id+"的图书失败!");
		}
	}

	//更新图书
	@Override
	public ResultUtil update(Book book) {
		// TODO Auto-generated method stub
		try {
			//如果状态是上架则创建上架时间
			if(book.getState()==52) {
				Date date = new Date();
				book.setStartDate(date);
			}
			//如果状态是下架则创建上架时间
			if(book.getState()==53) {
				Date date = new Date();
				book.setEndDate(date);
			}
			int num = bookMapper.updateByPrimaryKeySelective(book);
			if(num>0) {
				return ResultUtil.ok();
			}else {
				return ResultUtil.build(404, "更新失败!");
			}
		} catch (Exception e) {
			return ResultUtil.build(404, "更新失败!");
		}
	}
	
}
