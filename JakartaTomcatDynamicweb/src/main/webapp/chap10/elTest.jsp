<%--
  Created by IntelliJ IDEA.
  User: gimhyojun
  Date: 2023/03/07
  Time: 10:49 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    pageContext.setAttribute("pageElTest", "pageContext storage value!");
    request.setAttribute("reqElTest", "request storage value!");
    session.setAttribute("sesElTest", "session storage value!");
    application.setAttribute("appElTest", "application storage value!");
%>
<html>
<head>
    <title>elTest.jsp</title>
    <script>
        document.cookie = "elCookie=EL_CookieTest";
    </script>
</head>
<body>
<h2>EL Test</h2>
<hr/>
<form method="post" action="elResult.jsp">
    <label for="userName">이름</label>
    <input type="text" name="userName" id="userName"/>
    [관심분야]

    <input type="submit" value="전송"/>
</form>
</body>
</html>
