package com.book.controller;


import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.book.common.EmailCode;
import com.book.common.VerificationCode;

@Controller
public class TestController {
	
	//private final static Map<String, TestCodeInforVo> testCodeInforMap = new HashMap<String,TestCodeInforVo>();
	
	@RequestMapping("/index")
	public String index(){
		return "index";
	}
	
	@RequestMapping("/hello")
	@ResponseBody
	public String hello(){
		return "helloworld";
	}
	
	@RequestMapping("/hello2")
	public String hello2(){
		return "index2";
	}
	@RequestMapping("/ceshi")
	public String ceshi(){
		return "user_manager/user/list";
	}
	
	
}
