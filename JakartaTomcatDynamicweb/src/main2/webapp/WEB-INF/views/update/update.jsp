<%@ page import="com.example.jeonghwanhwang.model.Student" %><%--
  Created by IntelliJ IDEA.
  User: jeonghwan
  Date: 2023/03/09
  Time: 12:07 AM
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
            Student s = (Student) session.getAttribute("beforeUpdateOne");
            if (s != null) {
                result = s.printStudent();
            } else {
                result = "존재하지 않는 학생입니다.";
            }
        }
    }

%><html>
<head>
    <title>Title</title>
</head>
<body>
    <h2>3. 학생 성적 변경</h2>
    <hr/>
    <form method="POST">
      <select name="updateOption">
        <option>1. 개별 성적 업데이트</option>
        <option>2. 전체 성적 업데이트</option>
        <input type="submit" value="제출"/>
      </select>
    </form>
    <hr/>
    <a href="">menu</a><hr/>
</body>
</html>
