package com.book.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.book.book.service.FileUploadService;
import com.book.common.FastDFSClientWrapper;
import com.book.pojo.FileUpload;

/**
 * @ClassName FastDFSController
 * @Description FastDFS 文件上传下载删除
 * @Author coco
 * @Data 2018/11/16 10:25
 * @Version 1.0
 **/
 
@RestController
@RequestMapping("/fdfs")
public class FastDFSController {
	
	@Autowired
    private FastDFSClientWrapper dfsClient;
	
	@Resource
	private FileUploadService fileUploadService;

    @PostMapping("/files-anon/fdfsupload")
    public String fdfsupload(@RequestParam("file") MultipartFile file) throws Exception {
    	//可以判断传递过来的参数
        String imgUrl = dfsClient.uploadFile(file);
        System.out.println(imgUrl);
        return imgUrl;
    }
   
	@PostMapping("/upload")
    public Map<String,Object> upload(@RequestParam("file") MultipartFile file) throws Exception {
		//可以判断传递过来的参数,如果数据库有值则不会上传,直接从数据库获取
		//获取文件名
		String oriName = file.getOriginalFilename();
		// 获取图片后缀
		String extName = oriName.substring(oriName.lastIndexOf(".")+1);
		//获取图片文件名
		String name = oriName.substring(0,oriName.lastIndexOf("."));
		String imgUrl = fileUploadService.findByFileName(name);
		Map<String,Object> map = new HashMap<>();
    	if(imgUrl!=null) {
    		map.put("url", imgUrl);
    		return map;
    	}else {
    		imgUrl = dfsClient.uploadFile(file);
    		fileUploadService.addAll(oriName,extName,imgUrl,name);
    		map.put("url", imgUrl);
    		return map;
    	}
        
    }
   
//    @RequestMapping("/substring")
//    public String upload(){
//        String imgUrl = "http://192.168.25.133:22122/group1/M00/00/01/wKgZhV36M3GAKfvIAABBXjFOxTk947.jpg";
//        int num =  imgUrl.indexOf(":",6);
//        String str = imgUrl.substring(0,num);
//        String str2 = imgUrl.substring(num+6,imgUrl.length());
//        imgUrl = str+str2;
//        System.out.println(str+"\t"+str2);
//        return imgUrl;
//    }
}