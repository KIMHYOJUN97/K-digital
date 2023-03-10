<%@ page import="model.StudentDO" %><%--
  Created by IntelliJ IDEA.
  User: gimhyojun
  Date: 2023/03/09
  Time: 5:00 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%--<%--%>
<%--    String before = "";--%>
<%--    String after = "";--%>
<%--    String none = "";--%>
<%--    if(request.getMethod().equals("POST")) {--%>
<%--        if(request.getParameter("change1") != null && request.getParameter("change1").equals("change1")) {--%>
<%--            StudentDO bs = (StudentDO) session.getAttribute("beforeUpdateOne");--%>
<%--            StudentDO as = (StudentDO) session.getAttribute("afterUpdateOne");--%>
<%--            if (bs != null) {--%>
<%--                before = bs.toString();--%>
<%--            }--%>
<%--            else if(bs == null){--%>
<%--                none = "존재하지 않는 학생입니다.";--%>
<%--            }--%>
<%--            if(as != null){--%>
<%--                after = as.toString();--%>
<%--            }--%>
<%--        }--%>
<%--    }--%>
<%--%>--%>
<html>
<head>
    <title>change1.jsp</title>
</head>
<body>
<h2>개별 성적 변경</h2>
<hr/>
<form method="POST">
    <fieldset>
        <legend>업데이트 폼</legend>
        <label for="id">학번:</label>
        <input type="hidden" name="change1" value="change1"/>
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
        <input type="submit" value="변경 완료"/>
    </fieldset>
</form>

</body>
</html>
