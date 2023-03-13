<%@ page import="com.example.jeonghwanhwang.model.Student" %><%--
  Created by IntelliJ IDEA.
  User: jeonghwan
  Date: 2023/03/09
  Time: 12:05 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String before = "";
    String after = "";
    String none = "";
    if(request.getMethod().equals("POST")) {
        if(request.getParameter("updateOne") != null && request.getParameter("updateOne").equals("updateOne")) {
            Student bs = (Student) session.getAttribute("beforeUpdateOne");
            Student as = (Student) session.getAttribute("afterUpdateOne");
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
    <title>updateOne.jsp</title>
</head>
<body>
<h2>개별 성적 변경</h2>
<hr/>
<form method="POST">
    <fieldset>
        <legend>업데이트 폼</legend>
        <label for="id">학번:</label>
        <input type="hidden" name="updateOne" value="updateOne"/>
        <input type="text" name="id" id="id"><br/>
        과목 선택
        <select name="subject">
            <option>korean</option>
            <option>english</option>
            <option>math</option>
            <option>science</option>

        </select>
        <br/>
        <label for="score">점수</label>
        <input type="text" name="score" id="score"/>
        <input type="submit" value="제출"/>
    </fieldset>
</form>
    <a href="">menu</a><hr/>
<hr/>
<h4><%=none%></h4><hr/>
<h4>변경전 <%=before%>></h4><hr/>
<h4>변경후 <%=after%>></h4>

</body>
</html>
