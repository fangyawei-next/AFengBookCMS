package com.book.user.controller;

import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.apache.commons.mail.EmailException;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.book.common.EasyUIDataGridResult;
import com.book.common.EmailCode;
import com.book.common.ResultUtil;
import com.book.common.VerificationCode;
import com.book.pojo.SysUser;
import com.book.pojo.SysUserDetail;
import com.book.user.service.SysUserService;
import com.zhenzi.sms.ZhenziSmsClient;

@Controller
public class SysUserController {
	
	@Resource
	private SysUserService sysUserService;
	
	//点击登录的逻辑
	@RequestMapping("/login")
	@ResponseBody
	public ResultUtil login(SysUser sysUser,HttpSession session) {
		ResultUtil result = null;
		try {
			result = sysUserService.login(sysUser);
			sysUser = (SysUser) result.getData();
			session.setAttribute("sysUser",sysUser);
			return ResultUtil.ok();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			return result;
		}
	}
	
	//登录成功的逻辑
	@RequestMapping("/index2")
	public String index2() {
		return "index2";
	}
	
	//登录成功的逻辑
	@RequestMapping("/toLogin")
	public String toLogin() {
		return "redirect:/index2";
	}
	
	//邮箱验证码
	@RequestMapping("/verificationCode")
	@ResponseBody
	public String verificationCode(String email) throws EmailException{
		String code = VerificationCode.verificationCode(new EmailCode(email,"你本次获取的验证码为:","。有效时间为5分钟!"));
		if("获取验证码失败!".equals(code)) {
			return "获取验证码失败!";
		}
		return code;
	}
	
//	@RequestMapping("/verificationCode")
//	@ResponseBody
//	public String verificationCode(String phone) throws Exception {
//		String num = VerificationCode.getCodeSix();
//		System.out.println(num);
//		ZhenziSmsClient client = new ZhenziSmsClient("https://sms_developer.zhenzikj.com","103538","0afc7029-7a7e-47a9-b620-873835cea020");
//		String result = client.send(phone, "您的验证码为"+num+"，有效时间为5分钟。---来自方亚伟开发的软件");
//		//String result = client.balance();
//		System.out.println(result);
//		return result;
//	}
	
	//@RequestMapping("/ceshi")
	public String ceshi() throws Exception {
//		SMSSDK.getVerificationCode("86","15638623278");
//		String params= "appkey=2d41a7b985c46&phone=15638623278&zone=86&code=2589";
//		String result=testSDK.requestData("https://webapi.sms.mob.com/sms/verify", params);
//		System.out.println(result);
		ZhenziSmsClient client = new ZhenziSmsClient("https://sms_developer.zhenzikj.com","103538","0afc7029-7a7e-47a9-b620-873835cea020");
		//成功code是0
		//String result = client.send("15638623278", "您的验证码为4534，有效时间为5分钟");
		String result = client.balance();
		System.out.println(result);
		return null;
	}
	
	//跳转到注册页面
	@RequestMapping("/toEnrol")
	public String toEnrol() {
		return "enrol";
	}
	
	//注册
	@RequestMapping("/enrol")
	@ResponseBody
	public ResultUtil enrol(SysUser sysUser) {
		return sysUserService.enrol(sysUser);
	}
	
	//跳转到登录页面
	@RequestMapping("/fromLogin")
	public String fromLogin() {
		return "login";
	}
	
	//================ 用户相关的操作 =========================
	
	//根据用户名查询用户
	@RequestMapping("/user/verifyUsername")
	@ResponseBody
	public ResultUtil verifyUsername(String username) {
		ResultUtil result = sysUserService.verifyUsername(username);
		return result;
	}
	
	//用户列表
//	@RequestMapping("/user/list")
//	@ResponseBody
//	public EasyUIDataGridResult userList(SysUser user,Model model) {
//		UserListResult result = sysUserService.userList(user);
//		return result;
//	}
	
	//用户列表
	@RequestMapping("/user/list")
	@ResponseBody
	//@DateTimeFormat(pattern="yyyy-MM-dd")
	public EasyUIDataGridResult userList(SysUser user,int page,int rows) {
		return sysUserService.userList(user,page,rows);
	}
	
	//根据id查询用户
	@RequestMapping("/user/findUserById")
	@ResponseBody
	//@DateTimeFormat(pattern="yyyy-MM-dd")
	public ResultUtil findUserById(Long userId) {
		return sysUserService.findUserById(userId);
	}
	
//	//修改用户权限
	@RequestMapping("/user/updateToFlag")
	@ResponseBody
	//@DateTimeFormat(pattern="yyyy-MM-dd")
	public ResultUtil updateToFlag(SysUser user) {
		try {
			sysUserService.updateEntity(user);
			return ResultUtil.build(200, "修改成功!");
		} catch (Exception e) {
			return ResultUtil.build(404, "修改失败!");
		}
	}
	
	//删除用户
	@RequestMapping("/user/delete")
	@ResponseBody
	//@DateTimeFormat(pattern="yyyy-MM-dd")
	public ResultUtil delete(String userId) {
		return sysUserService.delete(userId);
	}
	
	//跳转到添加用户的页面
//	@RequestMapping("/toAdd")
//	public String toAdd() {
//		System.out.println("点击了添加");
//		return "user_manager/user/add";
//	}
	
	//添加用户
	@RequestMapping("/user/add")
	public ResultUtil add(SysUser sysUser) {
		return sysUserService.addAndDetail(sysUser);
	}
	
	//更新用户
	@RequestMapping("/user/update")
	@ResponseBody
	public ResultUtil update(SysUser sysUser) {
		ResultUtil result = sysUserService.update(sysUser);
		return result;
	}
}
