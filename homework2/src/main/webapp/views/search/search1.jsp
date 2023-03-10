<%@ page import="model.StudentDO" %><%--
  Created by IntelliJ IDEA.
  User: gimhyojun
  Date: 2023/03/09
  Time: 4:27 PM
  To change this template use File | Settings | File Templates.
--%>

<%
    if(request.getMethod().equals("POST")){
        response.setCharacterEncoding("UTF-8");
    }
%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String result = "";

    if (request.getMethod().equals("post")) {
        if (request.getParameter("select1") != null && request.getParameter("select1").equals("select1")) {
            StudentDO studentDO = (StudentDO) session.getAttribute("selectedStudent");
            if (studentDO != null) {
                result = studentDO.toString();
            } else result = "학생이 존재하지 않습니다.";
        }
    }
%>
<html>
<head>
    <title>search1.jsp</title>
</head>
<body>
<h1>개별 조회를 선택하셨습니다.</h1>
<form method="post">
    <label for="id">조회할 학생의 학번:</label>
    <input type="hidden" name="select1" value="select1">
    <input type="text" name="id" id="id">
    <input type="submit" value="조회하기">
</form>

<hr/>
<h2>결과</h2>
<%= result%>


<a href="initPage.jsp">초기 화면</a>
</body>
</html>
