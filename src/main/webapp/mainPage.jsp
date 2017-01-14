<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% request.setCharacterEncoding("UTF-8");
    response.setCharacterEncoding("UTF-8");
%>
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Main Page</title>
</head>
<body>
<img src="images/yandextranslator.jpg" align="right"/>
<p>
<img src="images/translator.jpg" align="left"/>

<h1 align="center">Vocabulary</h1>

<form method="post" accept-charset="UTF-8" action=Vocabulary.do>
    Hello!
    <p>
    Type word to translate.
    <label><b>Text to translate</b></label>
    <input type="text" placeholder="Enter text to translate" name="text" required>
    <p>
    <label><b>Choose translation direction</b></label>
    <select name="lang" required>
        <option value="ru-en">ru-en</option>
        <option value="ru-es">ru-es</option>
        <option value="ru-fr">ru-fr</option>
        <option value="en-ru">en-ru</option>
        <option value="en-fr">en-fr</option>
        <option value="en-es">en-es</option>
        <option value="fr-en">fr-en</option>
        <option value="fr-ru">fr-ru</option>
        <option value="fr-es">fr-es</option>
    </select>
        <button type="SUBMIT">SUBMIT</button>
</form>

<p>
    <a href="http://localhost:34505/registerpage.html">Go to register page.</a>
<p>
    <a href="http://localhost:34505/loginpage.html">Go to login page.</a>
</body>
</html>
