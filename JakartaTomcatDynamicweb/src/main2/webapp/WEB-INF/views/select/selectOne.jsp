<%@ page import="com.example.jeonghwanhwang.model.Student" %><%--
  Created by IntelliJ IDEA.
  User: jeonghwan
  Date: 2023/03/08
  Time: 9:14 PM
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

    if(request.getMethod().equals("POST")) {
        if(request.getParameter("selectOne") != null && request.getParameter("selectOne").equals("selectOne")) {
            Student s = (Student) session.getAttribute("selectedStudent");
            if (s != null) {
                result = s.printStudent();
            } else {
                result = "존재하지 않는 학생입니다.";
            }
        }
    }

%>
<html>
<head>
    <title>selectOne.jsp</title>
</head>
<body>
<h2>1. 개별조회</h2>
<hr/>

<form method="POST">
    <label for="id">조회할 학생의 학번:</label>
    <input type="hidden" name="selectOne" value="selectOne">
    <input type="text" name="id" id="id">
    <input type="submit" value="제출">
</form>
<a href="">menu</a><hr/>

<%=result%>
</body>
</html>
