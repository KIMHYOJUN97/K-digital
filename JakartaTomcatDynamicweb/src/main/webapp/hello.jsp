<%--
  Created by IntelliJ IDEA.
  User: gimhyojun
  Date: 2023/02/23
  Time: 10:54 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    int result =0;

    if(request.getMethod().equals("POST")){
        request.getParameter("num1");
    }
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>calc1.jsp</title>
</head>
<body>
<h2>JSP 프로그램 구현 유형-1</h2>
<hr/>
<form method="POST">
    <fieldset>
        <legend>간단 계산기</legend>

        <input type="number" name="num1" value="0"/>
        <select name="operator">
            <option selected>+</option>
            <option>-</option>
            <option>*</option>
            <option>/</option>
        </select>
        <input type="number" name="num2" value="0"/>
        <input type="submit" value="계산"/>
        <input type="reset" value="초기화"/>
    </fieldset>
</form>

<hr/>
<h4>계산결과: <%=result%> </h4>
</body>
</html>
