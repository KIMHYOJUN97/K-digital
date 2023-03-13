<%@ page import="com.example.jeonghwanhwang.MVC.twitter.TwitterLoginDO" %>
<%
    if (request.getMethod().equals("POST")) {
        request.setCharacterEncoding("UTF-8");
    }
%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<jsp:useBean id="loginDO" class="com.example.jeonghwanhwang.MVC.twitter.TwitterLoginDO" scope="page"/>
<jsp:setProperty name="loginDO" property="*" />
<jsp:useBean id="twitterDAO" class="com.example.jeonghwanhwang.MVC.twitter.TwitterDAO" scope="session" />
<jsp:useBean id="twitterDO" class="com.example.jeonghwanhwang.MVC.twitter.TwitterDO" />
<jsp:setProperty name="twitterDO" property="message"/>

<%

    String viewPath = "/WEB-INF/views/twitter/";
    String command = request.getParameter("command");
    if(session.getAttribute("id") == null){
        if(request.getMethod().equals("GET")){
            pageContext.forward(viewPath + "twitterLogin.jsp");
        }
        else if(request.getMethod().equals("POST")){
            TwitterLoginDO result = twitterDAO.checkLogin(loginDO);
            if(result != null){
                session.setAttribute("id", result.getId());
                session.setAttribute("name", result.getName());
//                session.setAttribute("list", twitterDAO.getAllTwitter());
//                pageContext.forward(viewPath + "twitterList.jsp");
                response.sendRedirect("controller.jsp");

            }
            else{
                pageContext.forward(viewPath + "twitterLogin.jsp");
                // response.sendRedirect(viewPath + "twitterLogin.jsp"); 해도됨
            }
        }
    }
    else{
        if(command != null && command.equals("logout")){
            session.invalidate();
            response.sendRedirect("controller.jsp");
        }

        else {
            if(command != null && command.equals("twitterInsert")){
                twitterDO.setId((String)session.getAttribute("id"));
                twitterDAO.insertTwitter(twitterDO);

            }

            session.setAttribute("list", twitterDAO.getAllTwitter());
            pageContext.forward(viewPath + "twitterList.jsp");
        }
    }


%>