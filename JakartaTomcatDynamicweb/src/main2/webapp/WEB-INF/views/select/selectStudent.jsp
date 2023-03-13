<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: jeonghwan
  Date: 2023/03/08
  Time: 5:27 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>selectStudent.jsp</title>
</head>
<body>
    <h2>2. 학생 정보 조회</h2>
    <hr/>
    <form method="POST">
        <select name="selectOption">
            <option ${param.selectOption == '1. 개별조회' ? 'seleted' : '' }>1. 개별조회</option>
            <option ${param.selectOption == '2. 전체 학생 조회' ? 'seleted' : '' }>2. 전체 학생 조회</option>
            <input type="submit" value="제출"/>
        </select>
    </form>
    <hr/>
    <h3>결과</h3>
    <a href="">menu</a><hr/>
    <c:choose>
        <c:when  test="${param.selectOption == '1. 개별조회'}"> 개별조회를 선택했습니다. </c:when>

    </c:choose>
</body>
</html>
