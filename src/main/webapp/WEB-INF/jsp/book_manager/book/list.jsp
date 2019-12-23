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
        <a href="">图书管理</a>
        <a>
          <cite>图书列表</cite></a>
      </span>
      <a class="layui-btn layui-btn-primary layui-btn-small" style="line-height:1.6em;margin-top:3px;float:right" href="javascript:location.replace(location.href);" title="刷新">
        <i class="layui-icon" style="line-height:38px">ဂ</i></a>
    </div>
    <div class="x-body">
      <div class="layui-row">
        <form class="layui-form layui-col-md12 x-so">
          <input class="layui-input" id="detailDate" placeholder="加入时间" name="sysUserDetail.detailDate" id="start">
          <input type="text" name="username" id="username" placeholder="请输入图书名称" autocomplete="off" class="layui-input">
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
        <button class="layui-btn" onclick="x_admin_show('添加图书','./add.html')"><i class="layui-icon"></i>添加</button>
        <%-- <button class="layui-btn" onclick="x_admin_show('添加用户','./admin-add.html')"><i class="layui-icon"></i>添加</button> --%>
        <span class="x-right" style="line-height:40px">共有数据：<span id="total"></span> 条</span>
      </xblock>
      <table class="layui-table" id="layui_table_id">
        <thead>
          <tr>
            <th>
              <div class="layui-unselect header layui-form-checkbox" lay-skin="primary"><i class="layui-icon">&#xe605;</i></div>
            </th>
            <th>图书编号</th>
            <th>图书名称</th>
            <th>价格</th>
            <th>数量</th>
            <th>界面</th>
            <th>详情</th>
            <th>作者</th>
            <th>分类</th>
            <th>状态</th>
            <th>上架时间</th>
            <th>下架时间</th>
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
      	 	 		url:"${pageContext.request.contextPath}/user/update",
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
        	 	 		url:"${pageContext.request.contextPath}/user/update",
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
          layer.confirm('确认要删除'+id+'吗？',function(index){
              //发异步删除数据
	          layui.$.ajax({
		 	 		type:"post", //请求方式 get，post
		 	 		url:"${pageContext.request.contextPath}/book/delete",
		 	 		async:true,  //是否异步,默认true
		 	 		data:{"id":id},
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
        	    dataStr+=data[i]+",";
        	}
        	//截取掉最后一位字符串
        	dataStr = dataStr.substr(0,dataStr.length-1)
            //捉到所有被选中的，发异步进行删除
            layui.$.ajax({
		 	 		type:"post", //请求方式 get，post
		 	 		url:"${pageContext.request.contextPath}/book/delete",
		 	 		async:false,  //是否异步,默认true
		 	 		data:{"id":dataStr},
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
		var status = 0;
		var name = '';
		var startDate = '';
		//模糊查询
		layui.$("#sreach").click(function(){
			username = layui.$("#username").val();
			detailDate = layui.$("#detailDate").val();
			var total = showReocrd(1,10,username,status,detailDate);
			layui.$("#total").text(total());
		})
		//状态按钮
	    function wuClick(){
	    	num++;
			if(num%3==1){
				layui.$("#wu").html('在库<input type="hidden" value="1"/>')
			}else if(num%5==2){
				layui.$("#wu").html('上架<input type="hidden" value="0"/>')
				layui.$("#back").css("background-color","red")
			}else if(num%5==3){
				layui.$("#wu").html('下架<input type="hidden" value="0"/>')
				layui.$("#back").css("background-color","red")
			}else if(num%5==4){
				layui.$("#wu").html('弃用<input type="hidden" value="0"/>')
				layui.$("#back").css("background-color","red")
			}else if(num%5==0){
				layui.$("#wu").html('&nbsp;无 &nbsp; <input type="hidden" value="2"/>')
				layui.$("#wu").css("background-color","#0dc316;")
			}
			status = layui.$("#wu input").val()
	    }
	    function showReocrd(pageNo,pageSize,name,status,startDate){
	    	var total = '';
	    	//同步请求,默认异步
	    	layui.$.ajax({
	 	 		type:"post", //请求方式 get，post
	 	 		url:"${pageContext.request.contextPath}/book/list",
	 	 		async:false,  //是否异步,默认true
	 	 		data:{"page":pageNo,"rows":pageSize,"name":name,"state":status,"startDate":startDate},
	 	 		dataType:"json", //返回值类型
	 		 	success:function(data){ //data 返回值
	 		 		total = data.total;
		        	//加载后台返回的List集合数据
		        	var str = '';
		            $.each(data.rows,function(i,type){
		            	var sort = type.sortBisDict.bisName;
		            	//var sortId = type.sort;
		            	var state = type.stateBisDict.bisName;
		            	//var stateId = type.state;
		            	//$.each(type.bisDictList,function(i,type){
		            		//if(sortId==type.bisId){
		            			//sort = type.bisName;
		            		//}
		            		//if(stateId==type.bisId){
		            			//state = type.bisName;
		            		//}
		            	//})
		            	var detail = type.detail;
		            	if(detail.length>=10){
		            		var detail2 = detail.slice(10,detail.length)
		            		detail = detail.replace(detail2,'...');
		            	}
		            	str+='<tr>'
							str+='<td>'
								str+='<div class="layui-unselect layui-form-checkbox" lay-skin="primary" data-id=\''+type.id+'\'><i class="layui-icon">&#xe605;</i></div>'
							str+='</td>'
							str+='<td>'+type.id+'</td>'
							str+='<td>'+type.name+'</td>'
							str+='<td>'+type.price+'</td>'
							str+='<td>'+type.num+'</td>'
							str+='<td>'
							//<img id="Img" src="'+type.image+'" alt="图片" width="200px" height="200px" class="layui-upload-img" οnclick="previewImg(this)">
								str+='<img class="Img" id="Img" src="'+type.image+'" alt="图片" width="200px" height="50px" class="layui-upload-img">'
							str+='</td>'
							str+='<td class="Detail" id="Detail">'+detail+'<span style="display:none;">'+type.detail+'</span></td>'
							str+='<td>'+type.author+'</td>'
							str+='<td class="td-status">'
							str+='<span id="userFlag" class="layui-btn layui-btn-normal layui-btn-mini" style="background-color: #42b8f1;">'+sort+'</span></td>'
							str+='<td class="td-status">'
							str+='<span id="userFlag" class="layui-btn layui-btn-normal layui-btn-mini" style="background-color: #42b8f1;">'+state+'</span></td>'
							str+='<td>'+type.startDate+'</td>'
							str+='<td>'+type.endDate+'</td>'
							str+='<td class="td-manage">'
								str+='<a onclick="member_stop(this,\''+type.id+'\')" href="javascript:;"  title="停用">'
								str+='<i class="layui-icon">&#xe601;</i>'
								str+='</a>'
								str+='<a title="编辑"  id="edit" onclick="x_admin_show2(\'编辑\',\'./edit.html\',\''+type.id+'\')" href="javascript:;">'
									str+='<i class="layui-icon">&#xe642;</i>'
								str+='</a>'
								str+='<a title="删除" onclick="member_del(this,\''+type.id+'\')" href="javascript:;">'
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
		var total = showReocrd(1,10,name,status,startDate);
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
                    $('tbody').empty();
                    //调用加载函数加载数据
                    showReocrd(obj.curr,obj.limit,layui.$("#username").val(),layui.$("#wu input").val(),layui.$("#detailDate").val());
                    //showReocrd(obj.curr,obj.limit,obj.where.username,obj.where.userFlag,obj.where.sysUserDetail.detailDate);
                 }
             }
		  });
		});
		layui.$(".Img").click(function(){
			previewImg(this)
		})
		layui.$(".Detail").click(function(){
			console.log("点击了")
			var detailHtml = "<p><span>&nbsp;&nbsp;&nbsp;&nbsp;</span>"+this.lastElementChild.innerHTML+"</p>";  
	        //弹出层
	        layer.open({  
	            type: 1,  
	            shade: 0.8,
	            offset: 'auto',
	            area: [500 + 'px',550+'px'],
	            shadeClose:true,
	            scrollbar: false,
	            title: "详情", //不显示标题  
	            content: detailHtml, //捕获的元素，注意：最好该指定的元素要存放在body最外层，否则可能被其它的相对元素所影响  
	            cancel: function () {  
	                //layer.msg('捕获就是从页面已经存在的元素上，包裹layer的结构', { time: 5000, icon: 6 });  
	            }  
	        }); 
		})
		//显示原始大小
		function previewImgTwo(obj) {
	        var img = new Image();  
	        img.src = obj.src;
	        var height = img.height + 50; //获取图片高度
	        var width = img.width; //获取图片宽度
	        var imgHtml = "<img src='" + obj.src + "' />";  
	        //弹出层
	        layer.open({  
	            type: 1,  
	            shade: 0.8,
	            offset: 'auto',
	            area: [width + 'px',height+'px'],
	            shadeClose:true,//点击外围关闭弹窗
	            scrollbar: false,//不现实滚动条
	            title: "图片预览", //不显示标题  
	            content: imgHtml, //捕获的元素，注意：最好该指定的元素要存放在body最外层，否则可能被其它的相对元素所影响  
	            cancel: function () {  
	                //layer.msg('捕获就是从页面已经存在的元素上，包裹layer的结构', { time: 5000, icon: 6 });  
	            }  
	        }); 
	    }
		//显示500*500
		function previewImg(obj) {
	        var img = new Image();  
	        img.src = obj.src;
	        var imgHtml = "<img src='" + obj.src + "' width='500px' height='500px'/>";  
	        //弹出层
	        layer.open({  
	            type: 1,  
	            shade: 0.8,
	            offset: 'auto',
	            area: [500 + 'px',550+'px'],
	            shadeClose:true,
	            scrollbar: false,
	            title: "图片预览", //不显示标题  
	            content: imgHtml, //捕获的元素，注意：最好该指定的元素要存放在body最外层，否则可能被其它的相对元素所影响  
	            cancel: function () {  
	                //layer.msg('捕获就是从页面已经存在的元素上，包裹layer的结构', { time: 5000, icon: 6 });  
	            }  
	        }); 
	    }
	</script>
   
  </body>

</html>