<%--
  Created by IntelliJ IDEA.
  User: gimhyojun
  Date: 2023/03/09
  Time: 1:29 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>initPage.jsp</title>
</head>
<body>
<h2>### 학생 성적 관리 프로그램 ###</h2>
<form method="post">
    <select name="step">
        <option>1. 학생 정보 입력</option>
        <option>2. 학생 정보 조회</option>
        <option>3. 성적 변경</option>
        <option>4. 학생 정보 삭제</option>

        <input type="submit" value="확인">
    </select>
</form>
</body>
</html>
