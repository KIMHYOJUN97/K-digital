<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: jeonghwan
  Date: 2023/03/08
  Time: 10:52 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>JSTL : choose ::: /JeonghwanHwang/choose.jsp</title>
</head>
<body>
    <h2>JSTL : choose ::: /JeonghwanHwang/choose.jsp</h2>
    <hr/>

    <form>
        <select name="sel">
            <option>-</option>
            <option ${param.sel == 'a' ? 'seleted' : '' }>a</option>
            <option ${param.sel == 'b' ? 'seleted' : '' }>b</option>
            <option ${param.sel == 'c' ? 'seleted' : '' }>c</option>
            <option ${param.sel == 'd' ? 'seleted' : '' }>d</option>
        </select>
        <input type="submit" value="전송"/>
    </form>

    <hr/>

    <c:choose>
        <c:when test="${param.sel == 'a'}">a를 선택 했습니다.</c:when>
        <c:when test="${param.sel == 'b'}">b를 선택 했습니다.</c:when>
        <c:when test="${param.sel == 'c'}">c를 선택 했습니다.</c:when>
        <c:otherwise >a, b, c 이외의 값을 선택 했습니다.</c:otherwise>
    </c:choose>
</body>
</html>
