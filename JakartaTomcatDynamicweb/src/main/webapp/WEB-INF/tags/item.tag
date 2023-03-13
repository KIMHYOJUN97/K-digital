<%@ tag body-content="scriptless" pageEncoding="UTF-8" %>
<%@ attribute name="title" %>
<%@ attribute name="colName" %>

<jsp:useBean id="product" class="com.example.chap10.Product"/>

<h2><jsp:doBody/></h2>

<h4>${title}</h4>

<table>
    <tr><th></th></tr>

    <%
        for (String prod : product.getProductList()) {
            out.println("<tr><td>"+prod+"</td></tr>");
        }
    %>
</table>

<myTag:item title="테이블 제목" colName="컬럼 제목">상품 재고 현황</myTag:item>