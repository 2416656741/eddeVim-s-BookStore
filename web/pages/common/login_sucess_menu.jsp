<%--
  Created by IntelliJ IDEA.
  User: eddie
  Date: 2020/3/10
  Time: 2:12 下午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div>
    <span>Welcome<span class="um_span">${sessionScope.user.username}</span>to EddieVim's BookStore</span>
    <a href="pages/order/order.jsp">我的订单</a>
    <a href="userServlet?action=logout">注销</a>&nbsp;&nbsp;
    <a href="index.jsp">返回</a>
</div>
