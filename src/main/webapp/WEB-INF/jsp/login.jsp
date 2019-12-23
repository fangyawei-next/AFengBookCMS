<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
  <meta charset="utf-8">
  <title>登录图书管理</title>
  <meta name="description" content="particles.js is a lightweight JavaScript library for creating particles.">
  <meta name="author" content="Vincent Garreau" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no">
  <link rel="stylesheet" media="screen" href="${pageContext.request.contextPath}/css/login.css">
  <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/reset.css"/>
  <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/button.css"/>
</head>
<style>
	.login{
		background-image: url(/bookcms/img/binner.png);
		background-repeat:no-repeat;
		background-size:100% 9%;
		background-position: 150px 0px;
		opacity:0.8;
	}
	.mouse{
		color:#363636;
		float:right;
		margin-right:10px;
		text-decoration: underline;
		font-family:'微软雅黑,宋体';
		text-decoration:none;
	}
	.mouse:hover{
		color:blue;
		text-decoration:underline;
		font-weight:bold;
	}
</style>
<body>

<div id="particles-js">
		<div class="login">
			<div class="login-top" style="margin-top:75px;">
				登录
			</div>
			<div class="login-center clearfix">
				<div class="login-center-img"><img src="${pageContext.request.contextPath}/img/name.png"/></div>
				<div class="login-center-input">
					<input type="text" id="username" name="user.username" placeholder="请输入您的用户名" onfocus="this.placeholder=''" onblur="this.placeholder='请输入您的用户名'" onkeydown="on_return();"/>
					<div class="login-center-input-text">用户名</div>
				</div>
			</div>
			<div class="login-center clearfix">
				<div class="login-center-img"><img src="${pageContext.request.contextPath}/img/password.png"/></div>
				<div class="login-center-input">
					<input type="password" id="password" name="user.password" placeholder="请输入您的密码" onfocus="this.placeholder=''" onblur="this.placeholder='请输入您的密码'" onkeydown="on_return();"/>
					<div class="login-center-input-text">密码</div>
				</div>
			</div>
			<div class="login-center clearfix">
				<div class="login-center-img"><img src="${pageContext.request.contextPath}/img/password.png"/></div>
				<div class="login-center-input">
					<input type="text" id="email" name="user.password" value="" placeholder="请输入您的QQ邮箱" onfocus="this.placeholder=''" onblur="this.placeholder='请输入您的手机号'" onkeydown="on_return();"/>
					<div class="login-center-input-text">QQ邮箱</div>
				</div>
			</div>
			<div class="login-center clearfix">
				<div class="login-center-img"><img src="${pageContext.request.contextPath}/img/password.png"/></div>
				<div class="login-center-input" style="width:100px;">
					<input type="text" id="emailCode" name="user.password" value="" placeholder="" onfocus="this.placeholder=''" onblur="this.placeholder=''" onkeydown="on_return();"/>
					<div class="login-center-input-text" style="">邮箱验证码</div>
					<%--display: inline; --%>
				</div>
				<div class="centered" id="autore" style="display: inline;">
					<%-- 按钮格式https://codepen.io/ben_jammin/pen/syaCq --%>
					<input type="button" id="verificationCode" class="small blue button" style="margin-left:15px;margin-top: 2px;" value="获取验证码" onclick="settime(this)" />
				</div>
				
			</div>
			
			<div class="login-button" id="login_but" onclick="login_but();">
				登录
			</div>
			<%-- <div class="login-button" v-on:click="enrol" id="enrol_but" style="margin-top: 20px;margin-bottom: 20px;">
			注册
			</div> --%>
			<div style="margin-top: 20px;">
				<a href="javascript:void(0);" id="close_window" class="mouse" >关闭程序</a>
				<a href="javascript:void(0);" class="mouse" >一键登录</a>
				<a href="javascript:void(0);" class="mouse" >忘记密码</a>
				<a href="javascript:void(0);" class="mouse" id="enrol_but" >注册</a>
			</div>
		</div>
		<div class="sk-rotating-plane"></div>
</div>

<!-- scripts -->
<script src="${pageContext.request.contextPath}/js/particles.min.js"></script>
<script src="${pageContext.request.contextPath}/js/app.js"></script>
<script src="${pageContext.request.contextPath}/js/jquery-3.3.1.min.js"></script>
<script>
	function hasClass(elem, cls) {
	  cls = cls || '';
	  if (cls.replace(/\s/g, '').length == 0) return false; //当cls没有参数时，返回false
	  return new RegExp(' ' + cls + ' ').test(' ' + elem.className + ' ');
	}
	 
	function addClass(ele, cls) {
	  if (!hasClass(ele, cls)) {
	    ele.className = ele.className == '' ? cls : ele.className + ' ' + cls;
	  }
	}
	 
	function removeClass(ele, cls) {
	  if (hasClass(ele, cls)) {
	    var newClass = ' ' + ele.className.replace(/[\t\r\n]/g, '') + ' ';
	    while (newClass.indexOf(' ' + cls + ' ') >= 0) {
	      newClass = newClass.replace(' ' + cls + ' ', ' ');
	    }
	    ele.className = newClass.replace(/^\s+|\s+$/g, '');
	  }
	}
</script>
<script type="text/javascript">
	//验证码
	var counts = 60;
	var verificationCode ='';
	function settime(val) {
	 $("#verificationCode").attr("disabled",true);
	 if(counts == 59){
		 //验证QQ邮箱 可关闭
		 //if($('#email').val()==null||$('#email').val()==''){
				//alert('QQ邮箱不能为空!请输入QQ邮箱');
				//return false;
		// }
		 
		 $.ajax({
		 	 	type:"post", //请求方式 get，post
	 	 	 	url:"${pageContext.request.contextPath}/verificationCode",
	 	 	 	data:{"email":$('#email').val()},
	 	 	 	async:true,  //是否异步,默认true
	 		 	success:function(data){ //data 返回值
	 		 		//打印邮箱的返回值
	 		 		console.log("打印邮箱验证码："+data);
	 		 		verificationCode = data;
	 			}
		 	})
		 val.setAttribute("disabled", true);
	     val.value = "重新发送（" + counts + "）";
	     counts--;
	 }
	 
	 if(counts == 0) {
	  val.removeAttribute("disabled");
	  val.value = "获取验证码";
	  counts = 60;
	  $("#verificationCode").attr("disabled",false);
	  return false;
	 } else {
	  val.setAttribute("disabled", true);
	  val.value = "重新发送（" + counts + "）";
	  counts--;
	 }
	 setTimeout(function() {
	  settime(val);
	 }, 1000);
	}
	$(function(){
		//点击注册按钮
		$('#enrol_but').click(function(){
			location.href='${pageContext.request.contextPath}/toEnrol';
		});
	})
	//点击关闭程序按钮
	$('#close_window').click(function(){
		if(confirm('是否退出程序')){
			//关闭当前窗口
			//window.open("about:blank","_self").close() 
			window.open("","_self").close()   
		}
	});
	//登录
	function login_but(){
		//location.href='loginAction';
		//console.log("执行了")
		if($('#username').val()==null||$('#username').val()==''){
			alert('用户名不能为空!请输入用户名');
			return false;
		}else if($('#password').val()==null||$('#password').val()==''){
			alert('密码不能为空!请输入密码');
			return false;
		}
		
		//验证QQ邮箱 可关闭
		//else if($('#emailCode').val()==null||$('#emailCode').val()==''){
			//alert('验证码不能为空!请输入验证码');
			//return false;
		//}else 
		if(verificationCode!=$('#emailCode').val()){
			alert('验证失败');
			return false;
		}
		
		$.ajax({
	 	 	type:"post", //请求方式 get，post
 	 	 	url:"${pageContext.request.contextPath}/login",
 	 	 	data:{"userName":$('#username').val(),"userPassword":$('#password').val()},
 	 	 	async:true,  //是否异步,默认true
 		 	success:function(data){ //data 返回值
 		 		addClass(document.querySelector(".login"), "active")
 				setTimeout(function(){
 					addClass(document.querySelector(".sk-rotating-plane"), "active")
 					document.querySelector(".login").style.display = "none"
 				},800)
 				setTimeout(function(){
 					removeClass(document.querySelector(".login"), "active")
 					removeClass(document.querySelector(".sk-rotating-plane"), "active")
 					document.querySelector(".login").style.display = "block"
 					//alert("登录成功")
 					if(data.status=="200"){
 			 			console.log("登录成功")
 		 	 	 	 	location.href='${pageContext.request.contextPath}/tomain';
 		 	 	 	 }else{
 		 	 	 	 	alert("登录失败!请确认用户名或密码正确后重新登录");
 		 	 	 	 }
 				//},5000)
 				},3000)
 			}
	 	})
	}  //);
	//按回车键触发事件
	function on_return(){
		if(window.event.keyCode==13){
			login_but();
		}
	}
</script>
</body>
</html>