<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<html>
<head>
    <title>Login</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <script defer src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
            crossorigin="anonymous"></script>
</head>
<body>
<div class="container mt-5">
    <h2>Login</h2>
    <c:if test="${success}">
        <div class="alert alert-success" role="alert">
            User successfully created!
        </div>
    </c:if>
    <form action="${pageContext.request.contextPath}/login" method="post">
        <div class="form-group">
            <label for="username">Username:</label>
            <input name="username" id="username" class="form-control" required/>
        </div>
        <div class="form-group">
            <label for="password">Password:</label>
            <input name="password" id="password" class="form-control" type="password" required/>
        </div>
        <button type="submit" class="btn btn-primary mt-3">Login</button>
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
    </form>
    <div class="mt-3">
        <a href="${pageContext.request.contextPath}/sign-up" class="btn btn-secondary">Create a New User</a>
    </div>
</div>
</body>
</html>
