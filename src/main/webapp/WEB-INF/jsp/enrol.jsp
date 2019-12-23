<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
  <meta charset="utf-8">
  <title>注册图书管理</title>
  <meta name="description" content="particles.js is a lightweight JavaScript library for creating particles.">
  <meta name="author" content="Vincent Garreau" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no">
  <link rel="stylesheet" media="screen" href="${pageContext.request.contextPath}/css/login.css">
  <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/reset.css"/>
  <style>
  	.login{
		background-image: url(/img/binner.png);
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
</head>
<body>

<div id="particles-js">
		<div class="login">
			<div class="login-top">
				注册
			</div>
			<div class="login-center clearfix">
				<div class="login-center-img"><img src="${pageContext.request.contextPath}/img/name.png"/></div>
				<div class="login-center-input">
					<input type="text" id="username" name="user.username" value="" placeholder="请输入您的用户名" onfocus="this.placeholder=''" onblur="this.placeholder='请输入您的用户名'"/>
					<div class="login-center-input-text">用户名</div>
				</div>
			</div>
			<div class="login-center clearfix">
				<div class="login-center-img"><img src="${pageContext.request.contextPath}/img/password.png"/></div>
				<div class="login-center-input">
					<input type="password" id="password" name="user.password" value="" placeholder="请输入您的密码" onfocus="this.placeholder=''" onblur="this.placeholder='请输入您的密码'"/>
					<div class="login-center-input-text">密码</div>
				</div>
			</div>
			<div class="login-center clearfix">
				<div class="login-center-img"><img src="${pageContext.request.contextPath}/img/password.png"/></div>
				<div class="login-center-input">
					<input type="password" id="unpassword" name="user.password" value="" placeholder="请再次输入您的密码" onfocus="this.placeholder=''" onblur="this.placeholder='请再次输入您的密码'"/>
					<div class="login-center-input-text">再次输入密码</div>
				</div>
			</div>
			<div class="login-button" id="enrol_but">
				点击注册
			</div>
			<div style="margin-top: 20px;">
				<a href="javascript:void(0);" id="close_window" class="mouse" >关闭程序</a>
				<a href="javascript:void(0);" class="mouse" id="login_but" >返回登录</a>
			</div>
		</div>
		<div class="sk-rotating-plane"></div>
</div>

<!-- scripts -->
<script src="${pageContext.request.contextPath}/js/particles.min.js"></script>
<script src="${pageContext.request.contextPath}/js/app.js"></script>
<script src="${pageContext.request.contextPath}/js/jquery-3.3.1.min.js"></script>
<script type="text/javascript">
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
	//document.querySelector(".login-button").onclick = function(){		
	//}
</script>
<script type="text/javascript">
	$(function(){
		//定义一个变量用来记录验证用户名成功或失败
		var flag = 0;
		
		//前端验证用户名是否存在
		//发送一个ajax请求，blur失去焦点时触发的事件
		$("#username").blur(function(){
			$.ajax({
		 	 	type:"post", //请求方式 get，post
	 	 	 	url:"${pageContext.request.contextPath}/user/verifyUsername",
	 	 	 	data:{"username":$('#username').val()},
	 	 	 	async:true,  //是否异步,默认true
	 		 	success:function(data){ //data 返回值
	 		 		console.log(data)
	 				if(data.status=="200"){
	 		 	 	 	 console.log("数据库中无此用户,可以添加");
	 		 	 	 	 flag = 1;
	 		 	 	}else{
	 		 	 	 	 alert("添加失败!已有该用户");
	 		 	 	}
	 	 	 	}
		 	})
		})
		//完成注册的按钮的触发事件
		$('#enrol_but').click(function(){
			//location.href='loginAction';
			console.log("执行了")
			//判断验证用户名成功或失败
			if(flag==0){
				alert("添加失败!已有该用户,请更改用户名再提交");
				return false;
			}
			if($('#username').val()==null||$('#username').val()==''){
				alert('用户名不能为空!请输入用户名');
				return false;
			}else if($('#password').val()==null||$('#password').val()==''){
				alert('密码不能为空!请输入密码');
				return false;
			}else if($('#unpassword').val()==null||$('#unpassword').val()==''){
				alert('请再次输入您的密码');
				return false;
			}else if($('#unpassword').val()!=$('#password').val()){
				alert('两次密码不一致,请检查后重新输入!');
				return false;
			}
			$.ajax({
		 	 	type:"post", //请求方式 get，post
	 	 	 	url:"${pageContext.request.contextPath}/enrol",
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
	 					console.log(data)
	 					if(data.status=="200"){
	 		 	 	 	 	alert("添加成功");
	 		 	 	 		location.href='${pageContext.request.contextPath}/fromLogin';
	 		 	 	 	}else{
	 		 	 	 		alert("添加失败!已有该用户");
	 		 	 	 		//报错的时候跳转到该页面
	 		 	 	 		location.href='${pageContext.request.contextPath}/login_error_Action';
	 		 	 	 	}
	 				},3000)
	 	 	 	}
		 	})
		});
		//点击关闭程序按钮
		$('#close_window').click(function(){
			if(confirm('是否退出程序')){
				//关闭当前窗口
				//window.open("about:blank","_self").close() 
				window.open("","_self").close()   
			}
		});
		//返回登录按钮的触发事件
		$('#login_but').click(function(){
			location.href='${pageContext.request.contextPath}/fromLogin';
		});
	})
</script>
</body>
</html>