<%--
  Created by IntelliJ IDEA.
  User: jeonghwan
  Date: 2023/03/02
  Time: 1:17 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"
         import="com.example.jeonghwanhwang.MVC.twitter.*"
%>


<html>
<head>
    <title>twitterLogin.jsp</title>
</head>
<body>
<h1>로그인</h1>
<hr/>

    <form method="POST" >

    <fieldset>
        <legend>로그인</legend>

        <label for="id">ID</label>
        <input type="text" name="id" id="id" />

        <label for="passwd">/ Passwd</label>
        <input type="password" name="passwd" id="passwd" />
        <input type="submit" value="login" />
    </fieldset>


    </form>

</body>
</html>
