<%--
  Created by IntelliJ IDEA.
  User: eddie
  Date: 2020/3/10
  Time: 3:07 下午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div>
    <span>welcome<span class="user_span">${sessionScope.user.username}</span>to eddieVim's BookStore</span>
    <a href="manager/bookServlet?action=page">图书管理</a>
    <a href="pages/manager/order_manager.jsp">订单管理</a>
    <a href="index.jsp">返回商城</a>
</div>
