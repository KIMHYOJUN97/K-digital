<%@ page import="model.StudentDO" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: gimhyojun
  Date: 2023/03/09
  Time: 4:44 PM
  To change this template use File | Settings | File Templates.
--%>
<%
    if(request.getMethod().equals("POST")){
        response.setCharacterEncoding("UTF-8");
    }
%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    ArrayList<StudentDO> arr = (ArrayList<StudentDO>)session.getAttribute("selectAll");
    String result = "";
    if(arr.isEmpty()){
        result = "존재하는 학생이 없습니다.";
    }
    else{
        for(StudentDO s : arr){
            result += s.toString() + "<br/>";
        }
    }
%>
<html>
<head>
    <title>searchAll</title>
</head>
<body>
    <h2>1. 전체 학생 조회</h2>
<hr/>
<%=result%>
<a href="initPage.jsp">초기 화면</a>
</body>
</html>
