<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8" import="java.util.*" %>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>Login Result Page</title>
</head>
<body>
<h1 align="center">Login Result JSP</h1>
<p>

<H1>Login Checked</H1>
        <%
			String login = (String) request.getAttribute("login");
				out.println("Your login is " + login);
		%>
<H1>Password checked</H1>
		<%
			String password = (String) request.getAttribute("password");
				out.println("Your password is " + password);

		%>
<p>
	<a href="http://localhost:34505/mainPage.jsp">Go to main page.</a>
<p>
	<a href="http://localhost:34505/loginpage.html">Go to login page.</a>
<p>
	<a href="http://localhost:34505/registerpage.html">Go to register page.</a>
</body>
</html>
