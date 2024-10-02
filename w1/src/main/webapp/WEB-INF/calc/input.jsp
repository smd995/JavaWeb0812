<%--
  Created by IntelliJ IDEA.
  User: smd99
  Date: 24. 10. 2.
  Time: 오후 3:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<p>num1 : <%= request.getParameter("num1")%></p>
<p>num2 : <%= request.getParameter("num2")%></p>
<form action="/calc/input" method="post">
    <input type="text" name="num1">
    <input type="text" name="num2">
    <button type="submit">SEND</button>
</form>
</body>
</html>
