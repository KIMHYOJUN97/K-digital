<%@ page import="com.example.jeonghwanhwang.model.Student" %><%--
  Created by IntelliJ IDEA.
  User: jeonghwan
  Date: 2023/03/09
  Time: 12:06 AM
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
        if(request.getParameter("deleteOne") != null && request.getParameter("deleteOne").equals("deleteOne")) {
            Student s = (Student) session.getAttribute("deletedStudent");
            if (s != null) {
                result = s.printStudent() + " 삭제";
            } else {
                result = "존재하지 않는 학생입니다.";
            }
        }
    }
%>
<html>
<head>
    <title>delete.jsp</title>
</head>
<body>
<h2>4. 학생정보 삭제</h2>
<hr/>

<form method="POST">
    <label for="id">삭제할 학생의 학번:</label>
    <input type="hidden" name="deleteOne" value="deleteOne">
    <input type="text" name="id" id="id">
    <input type="submit" value="제출">
</form>
<a href="">menu</a><hr/>
<%=result%>
</body>
</html>
