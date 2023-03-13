<%@ page import="com.example.homework2.model.StudentDO" %><%--
  Created by IntelliJ IDEA.
  User: gimhyojun
  Date: 2023/03/09
  Time: 3:52 PM
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    if(request.getMethod().equals("POST")){
        request.setCharacterEncoding("UTF-8");
    }
%>

<%
    String result = "";

    if (request.getMethod().equals("post")) {
        if (request.getParameter("input") != null && request.getParameter("input").equals("input")) {
            StudentDO studentDO = (StudentDO) session.getAttribute("insertStudent");
            if(studentDO!=null) result = studentDO.toString() + "등록이 완료되었습니다";
        }
    }
%>
<html>
<head>
    <title>input.jsp</title>
</head>
<body>
<h2>1. 학생 정보 입력</h2>
<hr/>

<form method = "post">
    <fieldset>
        <legend>학생정보를 입력하시오</legend>
        <input type="hidden" name="insert" value="insert"/>
        <label for="id">학번: </label>
        <input type="text" name="id" id="id"/> <br/>
        <label for="name">이름: </label>
        <input type="text" name="name" id="name"/><br/>
        <label for="gender">성별: </label>
        <input type="text" name="gender" id="gender"/><br/>
        <label for="korean">국어: </label>
        <input type="text" name="korean" id="korean"/><br/>
        <label for="english">영어: </label>
        <input type="text" name="english" id="english"/><br/>
        <label for="id">수학: </label>
        <input type="text" name="math" id="math"/><br/>
        <label for="science">과학: </label>
        <input type="text" name="science" id="science"/><br/>
        <input type="submit" value="등록"/>
    </fieldset>
</form>

<hr/>
<a href="">초기 화면</a>
<hr/>
</body>
</html>
