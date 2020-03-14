<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>EddieVim's BookStore会员注册页面</title>
	<%--静态包含--%>
	<%@ include file="/pages/common/head.jsp"%>
</head>
<body>
		<div id="header">
				<img class="logo_img" alt="" src="static/img/logo.gif" >
				<%--静态包含欢迎界面--%>
				<%@include file="/pages/common/login_sucess_menu.jsp"%>
		</div>
		
		<div id="main">
		
			<h1>欢迎回来 <a href="index.jsp">转到主页</a></h1>
	
		</div>

		<%--页脚	--%>
		<%@include file="/pages/common/footer.jsp"%>
</body>
</html>