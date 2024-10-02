<%--
  Created by IntelliJ IDEA.
  User: smd99
  Date: 24. 10. 2.
  Time: 오후 4:00
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
<p>result : <%= Integer.parseInt(request.getParameter("num1")) + Integer.parseInt(request.getParameter("num2"))%></p>
</body>
</html>
