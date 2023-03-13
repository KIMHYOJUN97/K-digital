<%--
  Created by IntelliJ IDEA.
  User: gimhyojun
  Date: 2023/03/07
  Time: 10:49 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>elResult.jsp</title>
</head>
<body>
<h2>EL Result</h2>
<hr/>
${pageScope.pageElTest}<br/>
${requestScope.reqElTest}<br/>
${sessionScope.sesElTest}<br/>
${applicationScope.appElTest}<br/>
${param.userName}<br/>
${paramValues.favorite[0]} / ${paramValues.favorite[1]}<br/>
${cookie.elCookie.name} = ${cookie.elCookie.value}<br/>
adminID: ${initParam.adminID} / admin passwd: ${initParam.adminPasswd}<br/>
</body>
</html>
