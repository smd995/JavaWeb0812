<%--
  Created by IntelliJ IDEA.
  User: smd99
  Date: 24. 10. 10.
  Time: 오전 11:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <c:if test="${param.result == 'error'}">
        <h1>로그인 에러 : 아이디 또는 비밀번호가 틀립니다.</h1>
    </c:if>
    <form action="/login" method="post">
        <input type="text" name="mid">
        <input type="password" name="mpw">
        <input type="checkbox" name="auto">
        <button type="submit">LOGIN</button>
    </form>
</body>
</html>
