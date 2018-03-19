<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div style="padding: 10px 0 10px 60px">
	<form id="searchForm" method="post">
		<table>
			<tr>
				<td>商品编号:</td>
				<td><input class="easyui-validatebox" type="text" name="items.itemId"></input></td>
			</tr>
			<tr>
				<td>商品名称:</td>
				<td><input class="easyui-validatebox" type="text" name="items.itemName"></input></td>
			</tr>
			<tr>
				<td>用户编号:</td>
				<td><input class="easyui-validatebox" type="text" name="users.userId"></input></td>
			</tr>
			<tr>
				<td>用户名:</td>
				<td><input class="easyui-validatebox" type="text" name="users.userName"></input></td>
			</tr>
		</table>
	</form>
</div>