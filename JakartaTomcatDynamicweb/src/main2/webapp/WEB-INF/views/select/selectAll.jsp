<%@ page import="com.example.jeonghwanhwang.model.Student" %>
<%@ page import="java.lang.reflect.Array" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: jeonghwan
  Date: 2023/03/08
  Time: 9:14 PM
  To change this template use File | Settings | File Templates.
--%>
<%
    if(request.getMethod().equals("POST")){
        response.setCharacterEncoding("UTF-8");
    }
%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    ArrayList<Student> arr = (ArrayList<Student>)session.getAttribute("selectAll");
    String result = "";
    if(arr.isEmpty()){
        result = "존재하는 학생이 없습니다.";
    }
    else{
        for(Student s : arr){
            result += s.printStudent() + "<br/>";
        }
    }
%>
<html>
<head>
    <title>selectAll.jsp</title>
</head>
<body>
    <h2>1. 전체 학생 조회</h2>
    <hr/>
    <a href="">menu</a><hr/>
    <%=result%>
</body>
</html>
