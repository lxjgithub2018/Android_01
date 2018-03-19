<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div style="padding: 10px 0 10px 60px">
	<form id="searchForm" method="post">
		<table>
			<tr>
				<td>商品编号:</td>
				<td><input class="easyui-validatebox" type="text" name="itemId"></input></td>
			</tr>
			<tr>
                 <td>商品名称:</td>
                 <td><input class="easyui-validatebox" type="text" name="itemName" data-options="required:true"></input></td>
             </tr>
             <tr>
                 <td>添加时间:</td>
                 <td><input class="easyui-datebox" type="text" name="addTime" data-options="required:true"></input></td>
             </tr>
              <tr>
                 <td>结束竞拍时间:</td>
                 <td><input class="easyui-datebox" type="text" name="endTime" data-options="required:true"></input></td>
             </tr>
             <tr>
                 <td>所属类别:</td>
                 <td>
                 	<input class="easyui-combobox" type="text" name="kinds.kindId" 
                 			data-options="required:true,
		                    url:'${pageContext.request.contextPath}/items_kindsDatas',
		                    valueField:'kindId',
		                    textField:'kindName',
		                    panelHeight:'200px'
		            		"></input>
		         </td>
             </tr>
             <tr>
                 <td>状态:</td>
                 <td>
                 	<input class="easyui-combobox" type="text" name="states.stateId" 
                 	data-options="required:true,
		                    url:'${pageContext.request.contextPath}/items_statesDatas',
		                    valueField:'stateId',
		                    textField:'stateName',
		                    panelHeight:'200px'
		            		"></input>
                 
                 </td>
             </tr>
		</table>
	</form>
</div>