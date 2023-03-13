<%@ page contentType="text/html; charset=UTF-8"
		 import="com.example.twitter.*"
%>

<jsp:useBean id="twitterDAO" class="com.example.twitter.TwitterDAO" scope="session" />
<jsp:useBean id="loginDO" class="com.example.twitter.TwitterLoginDO" />
<jsp:setProperty name="loginDO" property="*" />

<%
	if(request.getMethod().equals("POST")) {
		TwitterLoginDO result = twitterDAO.getLoginDO(loginDO);
		
		if(result != null) {
			session.setAttribute("id", result.getId());
			session.setAttribute("name", result.getName());
			response.sendRedirect("twitterList.jsp");
		}
	}
%>

<!DOCTYPE html>

<html>
<head>
	<meta charset="UTF-8">
	<title>twitterLogin.jsp</title>
</head>

<body>

	<h2>트위터 로그인</h2>
	<hr />
	
	<form method="POST">
	<fieldset>	
		<legend>로그인</legend>
		<label for="id">ID</label>
		<input type="text" name="id" id="id" /> /
		<label for="passwd">Passwd</label>
		<input type="password" name="passwd" id="passwd" />
		<input type="submit" value="login" />
	</fieldset>
	</form>
	

</body>
</html>