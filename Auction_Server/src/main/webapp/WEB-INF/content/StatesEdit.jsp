<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div style="padding: 10px 0 10px 60px">
	<form id="editForm" method="post">
		<table>
			<tr>
				<td>状态编号:</td>
				<td><input class="easyui-validatebox" type="text" name="stateId" readonly="readonly"></input></td>
			</tr>
			<tr>
				<td>状态名称:</td>
				<td><input class="easyui-validatebox" type="text" name="stateName" data-options="required:true"></input></td>
			</tr>
		</table>
	</form>
</div>
