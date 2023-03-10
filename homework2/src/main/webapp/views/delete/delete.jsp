<%@ page import="model.StudentDO" %><%--
  Created by IntelliJ IDEA.
  User: gimhyojun
  Date: 2023/03/09
  Time: 5:09 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    if(request.getMethod().equals("POST")){
        response.setCharacterEncoding("UTF-8");
    }
%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String result = "";

    if(request.getMethod().equals("POST")) {
        if(request.getParameter("deleting") != null && request.getParameter("deleting").equals("deleting")) {
            StudentDO s = (StudentDO) session.getAttribute("deletedStudent");
            if (s != null) {
                result = "삭제 완료되었습니다";
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
    <input type="hidden" name="deleting" value="deleting">
    <input type="text" name="id" id="id">
    <input type="submit" value="제출">
</form>

<%=result%>
<a href="">menu</a><hr/>

</body>
</html>