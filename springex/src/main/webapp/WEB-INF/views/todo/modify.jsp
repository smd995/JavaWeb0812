<%--
  Created by IntelliJ IDEA.
  User: smd99
  Date: 24. 10. 15.
  Time: 오후 5:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <title>Hello, world!</title>
</head>
<body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
<div class="container-fluid">
    <div class="row">
        <div class="row content">
            <div class="col">
                <nav class="navbar navbar-expand-lg navbar-light bg-light">
                    <div class="container-fluid">
                        <a class="navbar-brand" href="#">Navbar</a>
                        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                            <span class="navbar-toggler-icon"></span>
                        </button>
                        <div class="collapse navbar-collapse" id="navbarNav">
                            <ul class="navbar-nav">
                                <li class="nav-item">
                                    <a class="nav-link active" aria-current="page" href="#">Home</a>
                                </li>
                                <li class="nav-item">
                                    <a class="nav-link" href="#">Features</a>
                                </li>
                                <li class="nav-item">
                                    <a class="nav-link" href="#">Pricing</a>
                                </li>
                                <li class="nav-item">
                                    <a class="nav-link disabled">Disabled</a>
                                </li>
                            </ul>
                        </div>
                    </div>
                </nav>
                <div class="card">
                    <div class="card-header">
                        Featured
                    </div>
                    <form class="card-body">
                        <form action="/todo/modify" method="post">
                            <div class="input-group mb-3">
                                <span class="input-group-text">TNO</span>
                                <input type="text" name="tno" class="form-control"
                                        value=<c:out value="${dto.tno}"></c:out> readonly>
                            </div>

                            <div class="input-group mb-3">
                                <span class="input-group-text">Title</span>
                                <input type="text" name="title" class="form-control"
                                       value=<c:out value="${dto.title}"></c:out>>
                            </div>

                            <div class="input-group mb-3">
                                <span class="input-group-text">DueDate</span>
                                <input type="date" name="dueDate" class="form-control"
                                       value=<c:out value="${dto.dueDate}"></c:out>>
                            </div>

                            <div class="input-group mb-3">
                                <span class="input-group-text">Writer</span>
                                <input type="text" name="writer" class="form-control"
                                       value=<c:out value="${dto.writer}"></c:out> readonly>
                            </div>

                            <div class="form-check">
                                <label class="form-check-label">
                                    Finished &nbsp;
                                </label>
                                <input type="checkbox" class="form-check-input" name="finished" ${dto.finished?"checked":""}>
                            </div>
                            <div class="my-4">
                                <div class="float-end">
                                    <button type="button" class="btn btn-danger">remove</button>
                                    <button type="button" class="btn btn-primary">Modify</button>
                                    <button type="button" class="btn btn-secondary">List</button>
                                </div>
                            </div>
                        </form>
                    </form>
                </div>
                <script>
                    const serverValidResult = {}

                    <c:forEach items="${errors}" var="error">

                    serverValidResult['${error.getField()}'] = '${error.defaultMessage}'

                    </c:forEach>

                    console.log(serverValidResult)

                </script>
                <script>
                    const formObj = document.querySelector("form")

                    document.querySelector(".btn-danger").addEventListener("click", function (e){

                        e.preventDefault()
                        e.stopPropagation()

                        formObj.action = "/todo/remove?${pageRequestDTO.link}"
                        formObj.method = "post"

                        formObj.submit()
                    },false);

                    document.querySelector(".btn-primary").addEventListener("click",function(e){
                        e.preventDefault()
                        e.stopPropagation()

                        formObj.action="/todo/modify"
                        formObj.method="post"

                        formObj.submit()

                    },false)

                    document.querySelector(".btn-secondary").addEventListener("click",function(e){
                        e.preventDefault()
                        e.stopPropagation()

                        self.location = `/todo/list?${pageRequestDTO.link}`
                    },false)

                </script>

                </div>
            </div>
        </div>
    </div>
    <div class="row content">

    </div>
    <div class="row footer">
        <div class="row fixed-bottom" style="z-index: -100">
            <footer class="py-1 my-1">
                <p class="text-center text-muted">Footer</p>
            </footer>
        </div>
    </div>
</div>
</body>
</html>
