<%--
  Created by IntelliJ IDEA.
  User: gimhyojun
  Date: 2023/03/07
  Time: 10:31 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<jsp:useBean id="product" class="com.example.chap10.Product" scope="session"/>

<%
    String[] productList = product.getProductList();
    String result = "";
    for (String p : productList) {
        result += "<option>" + p + "</option>";
    }
%>
<html>
<head>
    <meta charset="UTF-8">
    <title>productList.jsp</title>
</head>
<body>
<h2>EL Test</h2>
<hr />
<form method="post" action="productSel.jsp">
    <fieldset>
        <legend>상품 선택</legend>
        <select name="sel"></select>

    </fieldset>

</form>

</body>
</html>
