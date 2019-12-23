package com.book.book.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.book.book.service.FileUploadService;
import com.book.mapper.FileUploadMapper;
import com.book.pojo.FileUpload;
import com.book.pojo.FileUploadExample;

@Service
public class FileUploadServiceImpl implements FileUploadService {
	
	@Resource
	private FileUploadMapper fileUploadMapper;

	@Override
	public String findByFileName(String name) {
		// TODO Auto-generated method stub;
		FileUploadExample example = new FileUploadExample();
		example.createCriteria().andNameEqualTo(name);
		List<FileUpload> list = fileUploadMapper.selectByExample(example);
		if(list!=null||!"".equals(list)) {
			return list.get(0).getAddress();
		}else {
			return null;
		}
	}

	@Override
	public void addAll(String oriName,String extName,String imgUrl,String name) {
		// TODO Auto-generated method stub
		FileUpload fileUpload = new FileUpload();
		fileUpload.setFileName(oriName);
		fileUpload.setName(name);
		fileUpload.setSuffix(extName);
		fileUpload.setAddress(imgUrl);
		fileUpload.setStatus("已使用");
		fileUploadMapper.insert(fileUpload);
	}

}
