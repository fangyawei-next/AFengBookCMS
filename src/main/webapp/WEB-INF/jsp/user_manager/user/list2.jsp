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
    <script src="${pageContext.request.contextPath}/ladmin/js/jquery.min.js"></script>
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
          <input class="layui-input" placeholder="加入时间" name="start" id="start">
          <input type="text" name="username"  placeholder="请输入用户名" autocomplete="off" class="layui-input">
          <span style="margin-left:5px;">
          	<div class="layui-card-body layui-row layui-col-space10">
            	<div class="layui-col-md12" style="display:inline;"><input type="checkbox" value="0" name="" title="启用"></div>
         	</div> 
          </span>
          <button class="layui-btn"  lay-submit="" lay-filter="sreach"><i class="layui-icon">&#xe615;</i></button>
        </form>
      </div>
      <xblock>
        <button class="layui-btn layui-btn-danger" onclick="delAll()"><i class="layui-icon"></i>批量删除</button>
        <button class="layui-btn" onclick="x_admin_show('添加用户','./admin-add.html')"><i class="layui-icon"></i>添加</button>
        <span class="x-right" style="line-height:40px">共有数据：88 条</span>
      </xblock>
      <table class="layui-table">
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
        </thead>
        <tbody id="typeList">
          
        </tbody>
      </table>
      <div id="demo8" style="text-align:center;"></div>
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
          layer.confirm('确认要停用吗？',function(index){

              if($(obj).attr('title')=='启用'){

                //发异步把用户状态进行更改
                $(obj).attr('title','停用')
                $(obj).find('i').html('&#xe62f;');

                $(obj).parents("tr").find(".td-status").find('span').addClass('layui-btn-disabled').html('已停用');
                layer.msg('已停用!',{icon: 5,time:1000});

              }else{
                $(obj).attr('title','启用')
                $(obj).find('i').html('&#xe601;');

                $(obj).parents("tr").find(".td-status").find('span').removeClass('layui-btn-disabled').html('已启用');
                layer.msg('已启用!',{icon: 5,time:1000});
              }
              
          });
      }

      /*用户-删除*/
      function member_del(obj,id){
          layer.confirm('确认要删除吗？',function(index){
              //发异步删除数据
              $(obj).parents("tr").remove();
              layer.msg('已删除!',{icon:1,time:1000});
          });
      }



      function delAll (argument) {

        var data = tableCheck.getData();
  
        layer.confirm('确认要删除吗？'+data,function(index){
            //捉到所有被选中的，发异步进行删除
            layer.msg('删除成功', {icon: 1});
            $(".layui-form-checked").not('.header').parents('tr').remove();
        });
      }
    </script>
    <script>
		layui.use(['laypage', 'layer'], function(){
		  var laypage = layui.laypage
		  ,layer = layui.layer;
		  
		  //自定义排版
		  laypage.render({
		    elem: 'demo8'
		    ,count: 1000
		    ,layout: ['limit', 'prev', 'page', 'next']
		  });
		  
		});
	</script>
    <script id="titleTpl">
	    $(function(){
			selectTypes();
		})
		
		//发送ajax请求
		function selectTypes(){
			$.ajax({
				url:"${pageContext.request.contextPath}/user/list",
				type:"post",
				data:{type:$("#dictType").val()},
				dataType:"json",
				success:function(data){
					console.log(data);
					convertToString(data);
				}
			})
		}
		function convertToString(data){
			$('#typeList').html()
			var str="";
			$.each(data,function(i,type){
				console.log(type.sysUserDetail.detailDate);
				console.log("2019-12-02T16:00:00.000+0000")
				str+='<tr>'
					str+='<td>'
						str+='<div class="layui-unselect layui-form-checkbox" lay-skin="primary" data-id=\'2\'><i class="layui-icon">&#xe605;</i></div>'
					str+='</td>'
					str+='<td>'+type.userId+'</td>'
					str+='<td>'+type.userName+'</td>'
					str+='<td>'+type.sysUserDetail.detailPhone+'</td>'
					str+='<td>'+type.sysUserDetail.detailEmail+'</td>'
					str+='<td>'+type.sysRoleList[0].roleName+'</td>'
					str+='<td>'+type.sysUserDetail.detailDate+'</td>'
					str+='<td class="td-status">'
					if(type.userFlag == 1){
						str+='<span id="userFlag" class="layui-btn layui-btn-normal layui-btn-mini" style="background-color: #42b8f1;">已启用</span></td>'
				    }else if(type.userFlag == 0){
						str+='<span id="userFlag" class="layui-btn layui-btn-normal layui-btn-mini" style="background-color: red;">已禁用</span></td>'
					}
					
					str+='<td class="td-manage">'
					str+='<a onclick="member_stop(this,\'10001\')" href="javascript:;"  title="启用">'
					str+='<i class="layui-icon">&#xe601;</i>'
					str+='</a>'
					str+='<a title="编辑"  onclick="x_admin_show(\'编辑\',\'admin-edit.html\')" href="javascript:;">'
						str+='<i class="layui-icon">&#xe642;</i>'
					str+='</a>'
					str+='<a title="删除" onclick="member_del(this,\'要删除的id\')" href="javascript:;">'
						str+='<i class="layui-icon">&#xe640;</i>'
					str+='</a>'
					str+='</td>'
					str+='</tr>'
			})
			$('#typeList').html(str)
		}
    </script>
  </body>

</html>