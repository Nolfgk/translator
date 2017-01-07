<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Translation Result</title>
</head>
<body>

<H1>Text translated</H1>
<%
    String text = (String) request.getAttribute("text");
    if (!text.equals("[]")){
        out.println("Your text is: " + text);} else {
        out.println("Wrong text.");
    }
%>

<H1>Meaning</H1>
<%
    String meaning = (String) request.getAttribute("meaning");
    if (!meaning.equals("[]")){
        out.println("Meaning of this text is: " + meaning);} else {
        out.println("No meaning");
    }
%>
<H1>Translate direction</H1>
<%
    String lang = (String) request.getAttribute("lang");
    if (!lang.equals("[]")){
        out.println("Your translate direction is " + lang);} else {
        out.println("wrong language");
    }
%>

<H1>Translation</H1>
<%
    String translation = (String) request.getAttribute("translation");
    if (!translation.equals("[]")){
        out.println("Translation is: " + translation);} else {
        out.println("No translation");
    }
%>

<H1>Closest synonim</H1>
<%
    String synonim = (String) request.getAttribute("synonim");
    if (!synonim.equals("[]")){
    out.println("Synonim is: " + synonim);} else {
        out.println("No synonim");
    }
%>
<p>
<a href="http://localhost:34505/mainPage.jsp">Go to main page.</a>
</body>
</html>
