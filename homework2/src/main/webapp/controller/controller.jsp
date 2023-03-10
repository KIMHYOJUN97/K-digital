<%--
  Created by IntelliJ IDEA.
  User: gimhyojun
  Date: 2023/03/09
  Time: 3:40 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    if (request.getMethod().equals("post")) request.setCharacterEncoding("UTF-8");
%>

<jsp:useBean id = "stduent" class="model.StudentDO" />
<jsp:useBean id="studentDAO" class="model.StudentDAO"/>
<jsp:setProperty name="stduent" property="*"/>
<%
    String viewPATH = "/WEB-INF/views/";
    String step = request.getParameter("step");
    String selecting = request.getParameter("selecting");
    String changing = request.getParameter()
    if (request.getMethod().equals("get")) {
        pageContext.forward(viewPATH+"initPage.jsp");
    }
    else{
        if (request.getMethod().equals("post")) {
            if(step.equals("1. 학생 정보 입력")){
                pageContext.forward(viewPATH+"/input/input.jsp");
            } else if (step.equals("2. 학생 정보 조회")) {
                pageContext.forward(viewPATH + "/search/search.jsp");
            } else if (step.equals("3. 성적 변경")) {
                pageContext.forward(viewPATH + "/change/change.jsp");
            } else if (step.equals("4. 학생 정보 삭제")) {
                pageContext.forward(viewPATH + "/delete/delete.jsp");
            }

            if()
        }
    }
%>

<html>
<head>
    <title>controller.jsp</title>
</head>
<body>

</body>
</html>
