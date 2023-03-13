<%--
  Created by IntelliJ IDEA.
  User: jeonghwan
  Date: 2023/03/02
  Time: 1:17 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"
            import="java.util.* , com.example.jeonghwanhwang.MVC.twitter.*"
%>

<%
    ArrayList<TwitterDO> list = (ArrayList<TwitterDO>) session.getAttribute("list");
    String result = "";
    for(TwitterDO tDO : list){
        result += "<li>" + tDO.getId() + ":::" + tDO.getMessage() + ":::"  + tDO.getCreateDate() + "</li>";

    }
%>
<!DOCTYPE html>
<html>
<head>
    <title>twitterList.jsp</title>
</head>
<body>
    <h2>My Simple Twitter!!</h2>
    <hr/>

    <form method="POST"> <!-- action을 지정하지 않으면 login으로 가버림 forward로 온경우! -->
        <fiedset>
        <lable ><%=session.getAttribute("id")%>@<%=session.getAttribute("name")%></lable>
        <input type="text" name="message" size="50"/>
            <input type="hidden" name="command" value="twitterInsert" />
        <input type="submit" value="등록"/>
        </fiedset>
    </form>

    <hr/>
    <form method="POST"> <!--action을 사용하지 않고 로그아웃 기능 구현-->
        <input type="submit" value="로그아웃"/>
        <input type="hidden" name="command" value="logout"/>
        <!--command라는 파라미터를 추가하고 value가 뭔지에따라 구분해서 작업을 수행할 수 있음-->

    </form>
    <hr/>

    <h3>트위터 리스트</h3>
    <ul>
        <!--등록된 모든 트위터의 내용이 보이도록 리스트 작성-->
        <%=result%>
    </ul>
</body>
</html>
