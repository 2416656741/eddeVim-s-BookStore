<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<%--静态包含--%>
	<%@ include file="/pages/common/head.jsp"%>
<title>EddieVim's BookStore会员注册页面</title>
<link type="text/css" rel="stylesheet" href="static/css/style.css" >
<style type="text/css">
	h1 {
		text-align: center;
		margin-top: 200px;
	}
	
	h1 a {
		color:red;
	}
</style>
</head>
<body>
		<div id="header">
				<img class="logo_img" alt="" src="static/img/logo.gif" >
				<span class="wel_word"></span>
			<%--静态包含欢迎界面--%>
			<%@include file="/pages/common/login_sucess_menu.jsp"%>
		</div>
		
		<div id="main">
		
			<h1>注册成功! <a href="../../../index.jsp">转到主页</a></h1>
	
		</div>

		<%--页脚	--%>
		<%@include file="/pages/common/footer.jsp"%>
</body>
</html>