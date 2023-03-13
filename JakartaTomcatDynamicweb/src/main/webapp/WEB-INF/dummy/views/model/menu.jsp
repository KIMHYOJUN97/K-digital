<%--
  Created by IntelliJ IDEA.
  User: jeonghwan
  Date: 2023/03/08
  Time: 4:14 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>menu.jsp</title>
    <style>
      form{
        padding:10px;
        margin: 10px;
      }
    </style>
</head>
<body>
  <h2>Menu를 선택해 주세요</h2>
  <form method="POST">
    <select name="menu">
      <option>1. 학생정보 입력</option>
      <option>2. 학생정보 조회</option>
      <option>3. 성적 변경</option>
      <option>4. 학생 정보 삭제</option>


      <input type="submit" value="제출">
    </select>
  </form>

</body>
</html>
