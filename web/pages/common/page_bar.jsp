<%--
  Created by IntelliJ IDEA.
  User: eddie
  Date: 2020/3/13
  Time: 10:33 上午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%--页码分页条的开始--%>
<div id="page_nav">
    <c:if test="${requestScope.page.pageNO > 1}">
        <a href="${requestScope.page.url}&pageNO=1">首页</a>
        <a href="${requestScope.page.url}&pageNO=${requestScope.page.pageNO-1}">上一页</a>
    </c:if>
    <%--页码输出的开始--%>
    <%--情况1：如果总页码小于等于5的情况，页码的范围是：1-总页码--%>
    <c:choose>
        <c:when test="${requestScope.page.pageTotal <= 5}">
            <c:set var="begin" value="1"/>
            <c:set var="end" value="${requestScope.page.pageTotal}"/>
        </c:when>
        <c:otherwise>
            <c:choose>
                <c:when test="${requestScope.page.pageNO <= 3}">
                    <c:set var="begin" value="1"/>
                    <c:set var="end" value="5"/>
                </c:when>

                <c:when test="${requestScope.page.pageNO >= requestScope.page.pageTotal - 3}">
                    <c:set var="begin" value="${requestScope.page.pageTotal - 5}"/>
                    <c:set var="end" value="${requestScope.page.pageTotal}"/>
                </c:when>

                <c:otherwise>
                    <c:set var="begin" value="${requestScope.page.pageNO - 2}"/>
                    <c:set var="end" value="${requestScope.page.pageNO + 2}"/>
                </c:otherwise>
            </c:choose>
        </c:otherwise>
    </c:choose>

    <c:forEach begin="${begin}" end="${end}" var="i">
        <c:if test="${i == requestScope.page.pageNO}">
            「${i}」
        </c:if>
        <c:if test="${i != requestScope.page.pageNO}">
            <a href="${requestScope.page.url}&pageNO=${i}">${i}</a>
        </c:if>
    </c:forEach>

    <c:if test="${requestScope.page.pageNO < requestScope.page.pageTotal}">
        <a href="${requestScope.page.url}&pageNO=${requestScope.page.pageNO+1}">下一页</a>
        <a href="${requestScope.page.url}&pageNO=${requestScope.page.pageTotal}">末页</a>
    </c:if>

    共${requestScope.page.pageTotal}页，${requestScope.page.pageTotalCount}条记录
    到第<input value="${requestScope.page.pageNO}" name="pn" id="pn_input"/>页
    <input id="searchPageBtn" type="button" value="确定">
    <script type="text/javascript">
        $(function(){

            $("#searchPageBtn").click(function () {
                var pageNO = $("#pn_input").val();

                location.href = "${pageScope.basePath}${requestScope.page.url}&pageNO="+pageNO;
            });
        });
    </script>
</div>
<%--页码分页条的结束--%>