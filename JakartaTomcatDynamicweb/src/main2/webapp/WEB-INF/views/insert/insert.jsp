<%@ page import="com.example.jeonghwanhwang.model.Student" %><%--
  Created by IntelliJ IDEA.
  User: jeonghwan
  Date: 2023/03/08
  Time: 11:46 PM
  To change this template use File | Settings | File Templates.
--%>
<%
  if(request.getMethod().equals("POST")){
    request.setCharacterEncoding("UTF-8");
  }
%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
  String result = "";

  if(request.getMethod().equals("POST")) {
    if(request.getParameter("insert") != null && request.getParameter("insert").equals("insert")) {
      Student s = (Student) session.getAttribute("insertStudent");
      if (s != null) {
        result = s.printStudent() + "등록 완료";
      }
    }
  }

%>
<html>
<head>
    <title>insert.jsp</title>
</head>
<body>
  <h2>1. 학생정보 입력</h2>
  <hr/>

  <form method="POST">
    <fieldset>
      <legend>학생정보 입력 폼</legend>
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
  <a href="">menu</a><hr/>
<%=result%>
</body>
</html>
