<%@ page contentType="text/html;charset=UTF-8" language="java"  pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>编辑图书</title>
	<%--静态包含--%>
	<%@ include file="/pages/common/head.jsp"%>
	<script type="text/javascript">
		// $(function () {
		// 	$("#d").add(disabled="disabled");
		// });
	</script>
	<style type="text/css">
		h1 {
			text-align: center;
			margin-top: 200px;
		}

		h1 a {
			color:red;
		}

		input {
			text-align: center;
		}
	</style>
</head>
<body>
		<div id="header">
			<img class="logo_img" alt="" src="static/img/logo.gif" >
			<span class="wel_word">编辑图书</span>
			<%--静态包含manager--%>
			<%@include file="/pages/common/manager_menu.jsp"%>
		</div>

		<div id="main">
			<form action="manager/bookServlet" method="POST">
				<input type="hidden" name="pageNO" value="${param.pageNO}">
				<input type="hidden" name="action" value=${empty param.id ? "add":"update"}>
				<input type="hidden" name="id" value=${requestScope.book.id}>
				<table>
					<tr>
						<td>名称</td>
						<td>价格</td>
						<td>作者</td>
						<td>销量</td>
						<td>库存</td>
						<td colspan="2">操作</td>
					</tr>		
					<tr>
						<td><label>
							<input id="d" name="name" type="text" value="${requestScope.book.name}"/>
						</label></td>
						<td><label>
							<input name="price" type="text" value="${requestScope.book.price}"/>
						</label></td>
						<td><label>
							<input name="author" type="text" value="${requestScope.book.author}"/>
						</label></td>
						<td><label>
							<input name="sales" type="text" value="${requestScope.book.sales}"/>
						</label></td>
						<td><label>
							<input name="stock" type="text" value="${requestScope.book.stock}"/>
						</label></td>
						<td><input type="submit" value="提交"/></td>
					</tr>	
				</table>
			</form>
			
	
		</div>

		<%--页脚	--%>
		<%@include file="/pages/common/footer.jsp"%>
</body>
</html>