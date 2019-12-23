<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8">
    <title>用户列表</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width,user-scalable=yes, minimum-scale=0.4, initial-scale=0.8,target-densitydpi=low-dpi" />
    <link rel="shortcut icon" href="/favicon.ico" type="image/x-icon" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/ladmin/css/font.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/ladmin/css/xadmin.css">
    <script src="${pageContext.request.contextPath}/ladmin/js/jquery.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/ladmin/lib/layui/layui.js" charset="utf-8"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/ladmin/js/xadmin.js"></script>
    <style>
    	.layui-card-body {
		    display: inline-block;
		    text-align: center;
		}
		.layui-card-body {
		    padding: 0;
		}
		.layui-col-space10>* {
    		padding: 0px;
    	} 
    </style>
    <!-- 让IE8/9支持媒体查询，从而兼容栅格 -->
    <!--[if lt IE 9]>
      <script src="https://cdn.staticfile.org/html5shiv/r29/html5.min.js"></script>
      <script src="https://cdn.staticfile.org/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
  </head>
  
  <body>
    <div class="x-nav">
      <span class="layui-breadcrumb">
        <a href="">系统管理</a>
        <a href="">用户管理</a>
        <a>
          <cite>用户列表</cite></a>
      </span>
      <a class="layui-btn layui-btn-primary layui-btn-small" style="line-height:1.6em;margin-top:3px;float:right" href="javascript:location.replace(location.href);" title="刷新">
        <i class="layui-icon" style="line-height:38px">ဂ</i></a>
    </div>
    <div class="x-body">
      <div class="layui-row">
        <form class="layui-form layui-col-md12 x-so">
          <input class="layui-input" id="detailDate" placeholder="加入时间" name="sysUserDetail.detailDate" id="start">
          <input type="text" name="username" id="username" placeholder="请输入用户名" autocomplete="off" class="layui-input">
          <span style="margin-left:5px;" lay-filter="latui-span">
          	<div class="layui-btn-container" style="display:inline;margin-right:10px;">
              <div class="layui-btn-group">
                <button class="layui-btn status" type="button" id="wu" onclick="wuClick();">&nbsp;无 &nbsp;</button>
              </div>
            </div>
          </span>
          <button type="button" class="layui-btn" id="sreach"  lay-filter="sreach"><i class="layui-icon">&#xe615;</i></button>
        </form>
      </div>
      <xblock>
        <button class="layui-btn layui-btn-danger" onclick="delAll()"><i class="layui-icon"></i>批量删除</button>
        <button class="layui-btn" onclick="x_admin_show('添加用户','./add.html')"><i class="layui-icon"></i>添加</button>
        <%-- <button class="layui-btn" onclick="x_admin_show('添加用户','./admin-add.html')"><i class="layui-icon"></i>添加</button> --%>
        <span class="x-right" style="line-height:40px">共有数据：<span id="total"></span> 条</span>
      </xblock>
      <table class="layui-table" id="layui_table_id">
        <thead>
          <tr>
            <th>
              <div class="layui-unselect header layui-form-checkbox" lay-skin="primary"><i class="layui-icon">&#xe605;</i></div>
            </th>
            <th>ID</th>
            <th>登录名</th>
            <th>手机</th>
            <th>邮箱</th>
            <th>角色</th>
            <th>加入时间</th>
            <th>状态</th>
            <th>操作</th>
           </tr>
        </thead>
        <!-- 内容容器 -->
        <tbody id="typeList"></tbody>
      </table>
      <!-- 分页容器 -->
      <div style="text-align:center;" id="demo8"></div>
    </div>
    <script>
      layui.use('laydate', function(){
        var laydate = layui.laydate;
        
        //执行一个laydate实例
        laydate.render({
          elem: '#start' //指定元素
        });

        //执行一个laydate实例
        laydate.render({
          elem: '#end' //指定元素
        });
      });

       /*用户-停用*/
      function member_stop(obj,id){
          layer.confirm('确认要'+$(obj).attr('title')+'吗？',function(index){
        	  console.log(obj)
        	  if($(obj).attr('title')=='启用'){
        		  layui.$.ajax({
      	 	 		type:"post", //请求方式 get，post
      	 	 		url:"${pageContext.request.contextPath}/user/updateToFlag",
      	 	 		async:true,  //是否异步,默认true
      	 	 		data:{"userId":id,"userFlag":"1"},
      	 	 		dataType:"json", //返回值类型
      	 		 	success:function(data){ //data 返回值
      	 		 		console.log(data)
	      	 		 	if(data.status=="200"){
	 			 			console.log("修改状态成功")
	 			 			 //发异步把用户状态进行更改
	  	 			 		$(obj).attr('title','启用')
	  	 	                $(obj).find('i').html('&#xe601;');
	
	  	 	                $(obj).parents("tr").find(".td-status").find('span').removeClass('layui-btn-disabled').html('已启用');
	  	 	                layer.msg('已启用!',{icon: 5,time:1000});
	 		 	 	 	 }else{
	 		 	 	 	 	alert("修改状态失败!");
	 		 	 	 	 }
      	 		 	}
      			})
              }else{
            	  layui.$.ajax({
        	 	 		type:"post", //请求方式 get，post
        	 	 		url:"${pageContext.request.contextPath}/user/updateToFlag",
        	 	 		async:true,  //是否异步,默认true
        	 	 		data:{"userId":id,"userFlag":"0"},
        	 	 		dataType:"json", //返回值类型
        	 		 	success:function(data){ //data 返回值
        	 		 		console.log(data)
  	      	 		 	if(data.status=="200"){
  	 			 			console.log("修改状态成功")
  	 			 			 //发异步把用户状态进行更改
  	 		                $(obj).attr('title','停用')
  	 		                $(obj).find('i').html('&#xe62f;');

  	 		                $(obj).parents("tr").find(".td-status").find('span').addClass('layui-btn-disabled').html('已停用');
  	 		                layer.msg('已停用!',{icon: 5,time:1000});
  	 		 	 	 	 }else{
  	 		 	 	 	 	alert("修改状态失败!");
  	 		 	 	 	 }
        	 		 	}
        			})
              }
              
          });
      }

      /*用户-删除*/
      function member_del(obj,id){
          layer.confirm('确认要'+id+'删除吗？',function(index){
              //发异步删除数据
	          layui.$.ajax({
		 	 		type:"post", //请求方式 get，post
		 	 		url:"${pageContext.request.contextPath}/user/delete",
		 	 		async:true,  //是否异步,默认true
		 	 		data:{"userId":id},
		 	 		dataType:"json", //返回值类型
		 		 	success:function(data){ //data 返回值
		 		 		if(data.status=="200"){
		 		 			$(obj).parents("tr").remove();
			 	            layer.msg('已删除!',{icon:1,time:1000});
		 		 		}else{
		 		 			console.log(data.msg);
		 		 		}
		 		 		
		 	 		}
			  });
          });
      }



      function delAll (argument) {

        var data = tableCheck.getData();
        layer.confirm('确认要删除'+data+'吗？',function(index){
        	var dataStr = ''
        	for(i = 0,len = data.length; i < len; i++) {
        	    console.log(data[i])
        	    dataStr+=data[i]+",";
        	}
        	//截取掉最后一位字符串
        	dataStr = dataStr.substr(0,dataStr.length-1)
            //捉到所有被选中的，发异步进行删除
            layui.$.ajax({
		 	 		type:"post", //请求方式 get，post
		 	 		url:"${pageContext.request.contextPath}/user/delete",
		 	 		async:false,  //是否异步,默认true
		 	 		data:{"userId":dataStr},
		 	 		dataType:"json", //返回值类型
		 		 	success:function(data){ //data 返回值
		 		 		if(data.status=="200"){
		 		 			 layer.msg('删除成功', {icon: 1});
		 		             $(".layui-form-checked").not('.header').parents('tr').remove();
		 		 		}else{
		 		 			console.log(data.msg);
		 		 		}
		 		 		
		 	 		}
			  });
        });
      }
    </script>
    <script type="text/javascript">
    	//var wheredata=null;
		var num = 0;
		var status = 2;
		var username = '';
		var detailDate = '';
		layui.$("#sreach").click(function(){
			username = layui.$("#username").val();
			detailDate = layui.$("#detailDate").val();
			var total = showReocrd(1,10,username,status,detailDate);
			layui.$("#total").text(total());
		})
	    function wuClick(){
	    	num++;
			if(num%3==1){
				layui.$("#wu").html('启用<input type="hidden" value="1"/>')
			}else if(num%3==2){
				layui.$("#wu").html('停用<input type="hidden" value="0"/>')
				layui.$("#back").css("background-color","red")
			}else if(num%3==0){
				layui.$("#wu").html('&nbsp;无 &nbsp; <input type="hidden" value="2"/>')
				layui.$("#wu").css("background-color","#0dc316;")
			}
			status = layui.$("#wu input").val()
	    }
	    function showReocrd(pageNo,pageSize,username,status,detailDate){
	    	var total = '';
	    	//同步请求,默认异步
	    	layui.$.ajax({
	 	 		type:"post", //请求方式 get，post
	 	 		url:"${pageContext.request.contextPath}/user/list",
	 	 		async:false,  //是否异步,默认true
	 	 		data:{"page":pageNo,"rows":pageSize,"userName":username,"userFlag":status,"sysUserDetail.detailDate":detailDate},
	 	 		dataType:"json", //返回值类型
	 		 	success:function(data){ //data 返回值
	 		 		var detailDate=''
	 		 		total = data.total;
		        	//加载后台返回的List集合数据
		        	var str = '';
		            $.each(data.rows,function(i,type){
		            	if(type.sysUserDetail.detailDate!=null&&type.sysUserDetail.detailDate!=''){
		 		 			detailDate = formatDate(new Date(type.sysUserDetail.detailDate));
		 		 		}
		            	str+='<tr>'
							str+='<td>'
								str+='<div class="layui-unselect layui-form-checkbox" lay-skin="primary" data-id=\''+type.userId+'\'><i class="layui-icon">&#xe605;</i></div>'
							str+='</td>'
							str+='<td>'+type.userId+'</td>'
							str+='<td>'+type.userName+'</td>'
							str+='<td>'+type.sysUserDetail.detailPhone+'</td>'
							str+='<td>'+type.sysUserDetail.detailEmail+'</td>'
							str+='<td>'+type.sysRoleList[0].roleName+'</td>'
							str+='<td>'+detailDate+'</td>'
							str+='<td class="td-status">'
							if(type.userFlag == 1){
								str+='<span id="userFlag" class="layui-btn layui-btn-normal layui-btn-mini" style="background-color: #42b8f1;">已启用</span></td>'
						    }else if(type.userFlag == 0){
								str+='<span id="userFlag" class="layui-btn layui-btn-normal layui-btn-mini" style="background-color: red;">已停用</span></td>'
							}
							
							str+='<td class="td-manage">'
							if(type.userFlag == 1){
								str+='<a onclick="member_stop(this,\''+type.userId+'\')" href="javascript:;"  title="停用">'
								str+='<i class="layui-icon">&#xe601;</i>'
								str+='</a>'
							}else if(type.userFlag == 0){
								str+='<a onclick="member_stop(this,\''+type.userId+'\')" href="javascript:;"  title="启用">'
								str+='<i class="layui-icon">&#xe62f;</i>'
								str+='</a>'
							}
							str+='<a title="编辑"  id="edit" onclick="x_admin_show2(\'编辑\',\'./edit.html\',\''+type.userId+'\')" href="javascript:;">'
								str+='<i class="layui-icon">&#xe642;</i>'
							str+='</a>'
							str+='<a title="删除" onclick="member_del(this,\''+type.userId+'\')" href="javascript:;">'
								str+='<i class="layui-icon">&#xe640;</i>'
							str+='</a>'
							str+='</td>'
						str+='</tr>'
					})
		            layui.$('#typeList').html(str);
		            //wheredata={"username":layui.$("#username").val(),"userFlag":status,"sysUserDetail":{"detailDate":layui.$("#detailDate").val()}}
	 	 		}
		 	});
		    return function () {
                return total;
            }
		}
		//先初始化加载首页，十条数据
		var total = showReocrd(1,10,username,status,detailDate);
		layui.$("#total").text(total());
		layui.use(['laypage', 'layer'], function(){
		  var laypage = layui.laypage
		  ,layer = layui.layer
		  wheredata=null;
		  
		  //自定义排版
		  laypage.render({
		    elem: 'demo8'
		    ,count: total()
		    ,where: wheredata
		    ,layout: ['limit', 'prev', 'page', 'next','where']
		    //跳转页码时调用
            , jump: function (obj, first) { //obj为当前页的属性和方法，第一次加载first为true
                //非首次加载 do something
                if (!first) {
              	    //清空以前加载的数据
              	    console.log()
                    $('tbody').empty();
                    //调用加载函数加载数据
                    showReocrd(obj.curr,obj.limit,layui.$("#username").val(),layui.$("#wu input").val(),layui.$("#detailDate").val());
                    //showReocrd(obj.curr,obj.limit,obj.where.username,obj.where.userFlag,obj.where.sysUserDetail.detailDate);
                 }
             }
		  });
		});
		function formatDate(date){ //设置时间转换格式
			var y = date.getFullYear();  //获取年
			var m = date.getMonth() + 1;  //获取月
		    m = m < 10 ? '0' + m : m;  //判断月是否大于10
			var d = date.getDate();  //获取日
			d = d < 10 ? ('0' + d) : d;  //判断日期是否大10
			return y + '-' + m + '-' + d;  //返回时间格式
		}
	</script>
   
  </body>

</html>