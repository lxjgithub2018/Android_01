<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div style="padding: 10px 0 10px 60px">
	<form id="editForm" method="post">
		<table>
			<tr>
				<td>编号:</td>
				<td><input class="easyui-validatebox" type="text" name="userId" readonly="readonly"></input></td>
			</tr>
			<tr>
                 <td>用户名:</td>
                 <td><input class="easyui-validatebox" type="text" name="userName" data-options="required:true"></input></td>
             </tr>
             <tr>
                 <td>密码:</td>
                 <td><input class="easyui-validatebox" type="text" name="userPass" data-options="required:true"></input></td>
             </tr>
             <tr>
                 <td>邮箱:</td>
                 <td><input class="easyui-validatebox" type="text" name="email" data-options="required:true"></input></td>
             </tr>
		</table>
	</form>
</div>
