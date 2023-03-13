<%@ page import="com.example.jeonghwanhwang.model.Student" %><%--
  Created by IntelliJ IDEA.
  User: jeonghwan
  Date: 2023/03/09
  Time: 12:05 AM
  To change this template use File | Settings | File Templates.
--%>

<%
    if(request.getMethod().equals("POST")){
        response.setCharacterEncoding("UTF-8");
    }
%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String before = "";
    String after = "";
    String none = "";
    if(request.getMethod().equals("POST")) {
        if(request.getParameter("updateAll") != null && request.getParameter("updateAll").equals("updateAll")) {
            Student bs = (Student) session.getAttribute("beforeUpdateAll");
            Student as = (Student) session.getAttribute("afterUpdateAll");
            if (bs != null) {
                before = bs.printStudent();
            }
            else if(bs == null){
                none = "존재하지 않는 학생입니다.";
            }
            if(as != null){
                after = as.printStudent();
            }
        }
    }

%>

<html>
<head>
    <title>updateAll.jsp</title>
</head>
<body>
<h2>전체 성적 변경</h2>
<hr/>

<form method="POST">
    <fieldset>
        <legend>성적변경 입력 폼</legend>
        <input type="hidden" name="updateAll" value="updateAll"/>
        <label for="id">학번: </label>
        <input type="text" name="id" id="id"/> <br/>
        <label for="korean">국어: </label>
        <input type="text" name="korean" id="korean"/><br/>
        <label for="english">영어: </label>
        <input type="text" name="english" id="english"/><br/>
        <label for="id">수학: </label>
        <input type="text" name="math" id="math"/><br/>
        <label for="science">과학: </label>
        <input type="text" name="science" id="science"/><br/>
        <input type="submit" value="등록"/>
    </fieldset>

</form>
<a href="">menu</a> <hr/>
<h4><%=none%></h4><hr/>
<h4>변경전 <%=before%>></h4><hr/>
<h4>변경후 <%=after%>></h4>
</body>
</html>
