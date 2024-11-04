<%--
  Created by IntelliJ IDEA.
  User: smd99
  Date: 24. 10. 4.
  Time: 오전 10:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>List Page</h1>
    <ul>
        <c:forEach var="dto" items="${list}">
            <li>
                글 번호: ${dto.getTno()}
                제목: ${dto.getTitle()}
                날짜: ${dto.getDueDate()}
                완료: ${dto.isFinished()}
            </li>
        </c:forEach>
    </ul>
</body>
</html>
