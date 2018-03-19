<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<title>用户管理</title>
	<c:import url="/WEB-INF/content/header.jsp"></c:import>
	<script type="text/javascript" src="${pageContext.request.contextPath}/static/js/Users.js"></script>
</head>
  
 <body class="easyui-layout">
 	<div class="easyui-panel" style="height:754px;padding:10px;">
 		<div class="easyui-panel" style="padding:10px;">
	        <a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-add'" onclick="$('#add').dialog('open')">添加</a>
	        <a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-search'" onclick="$('#search').dialog('open')">查询</a>
			<a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-edit'" onclick="javascript:loadRemote()">修改</a>
			<a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-remove'" onclick="javascript:removeConfirm()">删除</a>
			<a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-reload'" onclick="javascript:refresh()">刷新</a>
		</div>
		<table id="dg" style="width:100%;height:400px" class="easyui-datagrid" data-options="url:'${pageContext.request.contextPath}/users_selectDatas',method:'post',rownumbers:true,pagination:true,border:true,singleSelect:true">
		</table>
	</div>
	
	<div id="add" class="easyui-dialog" title="添加用户" 
		data-options="modal:true,closed:true,iconCls:'icon-add',buttons:'#add-dlg-buttons',
		href:'${pageContext.request.contextPath}/users_add',method:'post'" 
		style="width:500px;height:200px;padding:10px;">
		<div id="add-dlg-buttons">
	     	<a id="add-save-button" href="javascript:void(0)" class="easyui-linkbutton">保存</a>
	     	<a id="add-close-button" href="javascript:void(0)" class="easyui-linkbutton" onclick="javascript:$('#add').dialog('close')">关闭</a>
		</div>
    </div>
	
	<div id="search" class="easyui-dialog" title="查询条件" 
		data-options="modal:true,closed:true,iconCls:'icon-search',buttons:'#search-dlg-buttons',
		href:'${pageContext.request.contextPath}/users_search',method:'post'"
		style="width:500px;height:200px;padding:10px;">
		
		<div id="search-dlg-buttons">
	        <a id="search-save-button" href="javascript:void(0)" class="easyui-linkbutton">查询</a>
	        <a id="search-close-button" href="javascript:void(0)" class="easyui-linkbutton" onclick="javascript:$('#search').dialog('close')">关闭</a>
	    </div>
    </div>
    
    <div id="edit" class="easyui-dialog" title="修改用户" 
    	data-options="modal:true,closed:true,iconCls:'icon-edit',buttons:'#edit-dlg-buttons',
		href:'${pageContext.request.contextPath}/users_edit',method:'post'" 
		style="width:500px;height:200px;padding:10px;">
		<div id="edit-dlg-buttons">
	        <a id="edit-save-button" href="javascript:void(0)" class="easyui-linkbutton">保存</a>
	        <a id="edit-close-button" href="javascript:void(0)" class="easyui-linkbutton" onclick="javascript:$('#edit').dialog('close')">关闭</a>
	    </div>
    </div>
    
</body>
</html>