<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
  <head>
    
    <title>竞拍系统登录</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<c:import url="/WEB-INF/content/header.jsp"></c:import><!-- 引入头部文件 -->
  </head>
  
  <body>
  	<div style="width:320px;height: 600px;margin: 0 auto;margin-top: 250px;">
		<div class="easyui-panel" title="竞拍系统登录" style="width:300px;"> 
	        <s:form method="post" id="loginForm" action="%{#request.contextPath}/login"> 
	            <table> 
	                <tr> 
	                    <td>用户名:</td> 
	                    <td><input name="userName" type="text" value="${param.userName}"></input></td> 
	                </tr> 
	                <tr> 
	                    <td>密  码:</td> 
	                    <td><input name="userPass" type="password"  value="${param.userPass}"></input></td> 
	                </tr>
	                <tr> 
	                    <td>验证码：</td> 
	                    <td>
	                    	<input name="code" type="text" style="width:100px;"></input>
	                   	 	<img id="code" alt="" src="${pageContext.request.contextPath}/code">
	                    </td> 
	                </tr> 
	                <tr style="height: 60px;"> 
	                    <td style="text-align: left;padding-left: 55px;" colspan="2"><input type="submit" value="登    录"></input><s:fielderror></s:fielderror></td> 
	                </tr> 
	            </table> 
	        </s:form> 
	    </div> 
    </div>
    
	<script type="text/javascript">
		$(function(){//刷新验证码
			var codeSrc='${pageContext.request.contextPath}/code';
			$("#code").click(function(){
				var t=new Date().getTime();//获得当前系统毫秒数
				this.src=codeSrc+"?t="+t;//重新给验证码图片对象的src属性赋值
			});
		});
	</script>
  </body>
</html>
