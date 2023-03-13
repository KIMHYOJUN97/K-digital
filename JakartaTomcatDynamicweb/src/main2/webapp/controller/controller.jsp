<%@ page import="com.example.jeonghwanhwang.model.Student" %><%--<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>--%>
<%--
  Created by IntelliJ IDEA.
  User: jeonghwan
  Date: 2023/03/08
  Time: 4:21 PM
  To change this template use File | Settings | File Templates.
--%>
<%
    if (request.getMethod().equals("POST")) {
        request.setCharacterEncoding("UTF-8");
    }
%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="student" class="com.example.jeonghwanhwang.model.Student" />
<jsp:useBean id="studentDAO" class="com.example.jeonghwanhwang.model.StudentDAO" />

<jsp:setProperty name="student" property="*" />
<%
    String viewPath = "/WEB-INF/views/";
    String menu = request.getParameter("menu") != null ? request.getParameter("menu") : "";
    String selectOption = request.getParameter("selectOption") != null ? request.getParameter("selectOption") : "";
    String updateOption = request.getParameter("updateOption") != null ? request.getParameter("updateOption") : "";

    if(request.getMethod().equals("GET")){
        pageContext.forward(viewPath + "menu.jsp");
    }
    else if(request.getMethod().equals("POST")){
        if(menu.equals("1. 학생정보 입력")){
            pageContext.forward(viewPath + "/insert/insert.jsp");
        }
        else if(menu.equals("2. 학생정보 조회")){
            pageContext.forward(viewPath + "select/selectStudent.jsp");
        }
        else if(menu.equals("3. 성적 변경")){
            pageContext.forward(viewPath + "update/update.jsp");
        }
        else if(menu.equals("4. 학생 정보 삭제")){
            pageContext.forward(viewPath + "delete/delete.jsp");
        }
        else if(selectOption.equals("1. 개별조회")){
            pageContext.forward(viewPath + "select/selectOne.jsp");
        }
        else if(selectOption.equals("2. 전체 학생 조회")){
            session.setAttribute("selectAll", studentDAO.selectAll());
            pageContext.forward(viewPath + "select/selectAll.jsp");
        }
        else if(updateOption.equals("1. 개별 성적 업데이트")){
            pageContext.forward(viewPath + "update/updateOne.jsp");
        }
        else if(updateOption.equals("2. 전체 성적 업데이트")){

            pageContext.forward(viewPath + "update/updateAll.jsp");
        }
        else if(request.getParameter("id") != null && request.getParameter("selectOne") != null && request.getParameter("selectOne").equals("selectOne")){
            session.setAttribute("selectedStudent", studentDAO.selectStudent(student.getId()));
            pageContext.forward(viewPath + "select/selectOne.jsp");
        }
        else if(request.getParameter("id") != null && request.getParameter("deleteOne") != null && request.getParameter("deleteOne").equals("deleteOne")){
            session.setAttribute("deletedStudent", studentDAO.selectStudent(student.getId()));
            studentDAO.deleteStudent(studentDAO.selectStudent(student.getId()));
            pageContext.forward(viewPath + "delete/delete.jsp");
        }
        else if(request.getParameter("id") != null && request.getParameter("updateOne") != null && request.getParameter("updateOne").equals("updateOne")){
            Student before = studentDAO.selectStudent(student.getId());
            if(before != null) {
                session.setAttribute("beforeUpdateOne", before);
                studentDAO.updateStudentOne(before.getId(), request.getParameter("subject"), Integer.parseInt(request.getParameter("score")));
                session.setAttribute("afterUpdateOne", studentDAO.selectStudent(student.getId()));

            }
            pageContext.forward(viewPath + "update/updateOne.jsp");
        }
        else if(request.getParameter("id") != null && request.getParameter("updateAll") != null && request.getParameter("updateAll").equals("updateAll")){
            Student before = studentDAO.selectStudent(student.getId());
            if (before != null) {


                session.setAttribute("beforeUpdateAll", before);
                Student beforeAll = studentDAO.selectStudent(Integer.parseInt(request.getParameter("id")));

                beforeAll.setKorean(Integer.parseInt(request.getParameter("korean")));
                beforeAll.setEnglish(Integer.parseInt(request.getParameter("english")));
                beforeAll.setMath(Integer.parseInt(request.getParameter("math")));
                beforeAll.setScience(Integer.parseInt(request.getParameter("science")));
                studentDAO.updateStudentAll(beforeAll);
                session.setAttribute("afterUpdateAll", studentDAO.selectStudent(student.getId()));

            }
            pageContext.forward(viewPath + "update/updateAll.jsp");
        }
        else if(request.getParameter("insert") != null){
            studentDAO.insertStudent(student);
            session.setAttribute("insertStudent",studentDAO.selectStudent(student.getId()));
            pageContext.forward(viewPath + "insert/insert.jsp");
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
