<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: eddie
  Date: 2020/3/10
  Time: 3:07 下午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div>
    <c:if test="${not empty sessionScope.user.username}">
        <span>welcome<span class="user_span" style="color:red; font-size: 30px">${sessionScope.user.username}</span>to eddieVim's BookStore</span>
    </c:if>
    <a href="manager/bookServlet?action=page">图书管理</a>
    <a href="pages/manager/order_manager.jsp">订单管理</a>
    <a href="index.jsp">返回商城</a>
</div>
