<%--
  Created by IntelliJ IDEA.
  User: smd99
  Date: 24. 10. 8.
  Time: 오후 2:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Todo Modify / Remove</title>
</head>
<body>
<form action="/todo/modify" method="post">
    <div>
        <input type="text" name="tno" value="${dto.tno}" readonly>
    </div>
    <div>
        <input type="text" name="title" value="${dto.title}">
    </div>
    <div>
        <input type="date" name="dueDate" value="${dto.dueDate}">
    </div>
    <div>
        <input type="checkbox" name="finished" ${dto.finished ? "checked" : ""}>
    </div>
    <div>
        <button type="submit">Modify</button>
    </div>
</form>
<form action="/todo/remove" method="post">
    <input type="hidden" name="tno" value="${dto.tno}" readonly>
    <button type="submit">Remove</button>
</form>
<div>
    <a href="/todo/list">List</a>
</div>

</body>
</html>
