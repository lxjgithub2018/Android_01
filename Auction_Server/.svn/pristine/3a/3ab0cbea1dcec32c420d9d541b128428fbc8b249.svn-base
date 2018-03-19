<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<title>竞拍系统</title>
	<c:import url="/WEB-INF/content/header.jsp"></c:import><!-- 引入头部文件 -->
</head>
<body class="easyui-layout layout panel-noscroll">
	<div class="easyui-layout" style="width:100%;height:768px;">
		<div data-options="region:'north'" style="background-color: rgb(224, 236, 255);height:100px">欢迎使用竞拍系统</div>
		<div data-options="region:'south',split:true" style="height:150px;"></div>
		<!-- <div data-options="region:'east',split:true" title="East" style="width:100px;"></div> -->
		<div data-options="region:'west',split:true" title="功能导航" style="width:200px;">
			<ul id="tree" class="easyui-tree" data-options="animate:true,lines:true">
				<li id=11 data-options="attributes:{'url':'kinds_select'}">商品类别管理</li>
				<li id=13 data-options="attributes:{'url':'states_select'}">状态管理</li>
				<li id=12 data-options="attributes:{'url':'users_select'}">用户管理</li>
				<li id=14 data-options="attributes:{'url':'items_select'}">商品管理</li>
				<li id=15 data-options="attributes:{'url':'bids_select'}">竞拍记录管理</li>
			</ul>
		</div>
		<div data-options="region:'center'"><!-- 中间部分 -->
			<div id="tabs" class="easyui-tabs" style="width:100%;height:100%">
				
			</div>
		</div>
	</div>
	<script type="text/javascript">
	$(function(){//文档加载完之后执行这个匿名函数

		//实例化树菜单
		$("#tree").tree({
			lines:true,
			onClick:function(node){
				if(node.attributes){
					openTab(node.text,node.attributes.url);//把树的文本及树的链接传openTab方法
				}
			}
		});
		
		// 新增Tab
		function openTab(text,url){
			if($("#tabs").tabs('exists',text)){//判断选项卡是否已经存在
				$("#tabs").tabs('select',text);//如果已经打开那就让它被选中
			}else{//判断选项卡是不存在
				var content="<iframe frameborder='0' scrolling='auto' style='width:100%;height:100%' src="+url+"></iframe>";
				$("#tabs").tabs('add',{//往选项卡上添加一项
					title:text,
					closable:true,//带有关闭按钮
					content:content//内容
				});
			}
		}

		//默认加载一个页面到选项卡面板
		openTab("商品类别管理","kinds_select");
		$("#cl-dashboard").html('');
	});
		
		
	</script>
</body>
</html>